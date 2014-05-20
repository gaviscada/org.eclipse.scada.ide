/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.dave.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.dave.DaveBlockDefinition;
import org.eclipse.scada.configuration.dave.DaveCommunicationProcessor;
import org.eclipse.scada.configuration.dave.DaveDevice;
import org.eclipse.scada.configuration.dave.DaveDriver;
import org.eclipse.scada.configuration.dave.DaveFactory;
import org.eclipse.scada.configuration.dave.DaveHelper;
import org.eclipse.scada.configuration.dave.DaveRequestBlock;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DeviceTypeValidator;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.memory.TypeHelper;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerFactory;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.world.Endpoint;

public class DriverFactoryImpl extends AbstractEquinoxDriverFactory<DaveDriver>
{
    private static final int MAX_REQUEST_SIZE = 220;

    private static final int MAX_AREA = 0xFF;

    private static final int MAX_BLOCK = 0xFFFF;

    private static final int MAX_OFFSET = 0xFFFF;

    public DriverFactoryImpl ()
    {
        addValidator ( new DeviceTypeValidator<EquinoxDriver> ( DaveDevice.class ) );
    }

    @Override
    protected DaveDriver createDriver ()
    {
        return DaveFactory.eINSTANCE.createDaveDriver ();
    }

    @Override
    protected void configureDriver ( final AbstractFactoryDriver driver, final DaveDriver result, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final MemoryManagerModule manager = MemoryManagerFactory.eINSTANCE.createMemoryManagerModule ();
        result.getModules ().add ( manager );

        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof DaveDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }

            if ( manager.getTypeSystem () == null )
            {
                manager.setTypeSystem ( ( (DaveDevice)device ).getTypeSystem () );
            }
            else if ( ( (DaveDevice)device ).getTypeSystem () != null )
            {
                if ( manager.getTypeSystem ().getName ().equals ( ( (DaveDevice)device ).getTypeSystem ().getName () ) )
                {
                    throw new IllegalStateException ( "All S7 devices must share the same type system" );
                }
            }

            createDevice ( driver, result, (DaveDevice)device, nodes );
        }
    }

    protected void createDevice ( final AbstractFactoryDriver driver, final DaveDriver result, final DaveDevice device, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final DaveCommunicationProcessor cp = DaveFactory.eINSTANCE.createDaveCommunicationProcessor ();

        cp.setId ( device.getName () );
        cp.setRack ( device.getRack () );
        cp.setSlot ( device.getSlot () );
        cp.setReadTimeout ( device.getReadTimeout () );

        result.getDevices ().add ( cp );

        final Endpoint ep = Endpoints.createEndpoint ( device.getPort (), "S7 Device Endpoint" );
        cp.setEndpoint ( ep );

        // lookup node
        final org.eclipse.scada.configuration.world.Node node = nodes.get ( device.getNode () );
        if ( node == null )
        {
            throw new IllegalStateException ( String.format ( "Node %s was not found in target model", device.getNode () ) );
        }
        node.getEndpoints ().add ( ep );

        final Map<String, Integer> blockCounters = new HashMap<> ();

        for ( final DaveBlockDefinition blockDef : device.getBlocks () )
        {
            final DaveRequestBlock blockReq = DaveFactory.eINSTANCE.createDaveRequestBlock ();

            // set name
            // set id
            final String name = DaveHelper.makeBlockName ( blockDef );

            Integer num = blockCounters.get ( name );
            num = num == null ? 1 : num + 1;
            blockCounters.put ( name, num );

            blockReq.setName ( name );
            blockReq.setId ( String.format ( "%s_%s.%s", device.getName (), name, num ) );

            blockReq.setArea ( blockDef.getArea () );
            blockReq.setBlock ( blockDef.getBlock () );
            blockReq.setEnableStatistics ( blockDef.isEnableStatistics () );
            blockReq.setOffset ( blockDef.getOffset () );
            blockReq.setLength ( TypeHelper.calculateByteSize ( blockDef.getType () ) );
            blockReq.setPeriod ( blockDef.getPeriod () );
            blockReq.setType ( blockDef.getType () );

            blockReq.setDevice ( cp );
            cp.getBlocks ().add ( blockReq );
        }
    }

    @Override
    protected void performValidation ( final IValidationContext ctx, final EquinoxDriver driver, final Collection<IStatus> result )
    {
        super.performValidation ( ctx, driver, result );

        final Set<TypeSystem> typeSystems = new HashSet<> ();

        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof DaveDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }

            typeSystems.add ( ( (DaveDevice)device ).getTypeSystem () );

            validateDevice ( ctx, driver, (DaveDevice)device, result );
        }

        if ( typeSystems.size () > 1 )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, driver, null, "All S7 devices of one driver instance must share the same type system ({0})", typeSystems ) );
        }
    }

    private void validateDevice ( final IValidationContext ctx, final EquinoxDriver driver, final DaveDevice device, final Collection<IStatus> result )
    {
        for ( final DaveBlockDefinition block : device.getBlocks () )
        {
            if ( block.getArea () < 0 || block.getArea () > MAX_AREA )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Area must be between [0..{0}]", MAX_AREA ) );
            }
            if ( block.getBlock () < 0 || block.getBlock () > MAX_BLOCK )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block must be between [0..{0}]", MAX_BLOCK ) );
            }
            if ( block.getOffset () < 0 || block.getOffset () > MAX_OFFSET )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Offset must be between [0..{0}]", MAX_OFFSET ) );
            }
            if ( block.getPeriod () < 0 )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Period must be positive" ) );
            }
            final int len = TypeHelper.calculateByteSize ( block.getType () );
            if ( len > MAX_REQUEST_SIZE )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block size ({0}) is greater then the maxmimum request size ({1}). You will need to split up your type definition to reduce block size.", len, MAX_REQUEST_SIZE ) );
            }
        }
    }
}