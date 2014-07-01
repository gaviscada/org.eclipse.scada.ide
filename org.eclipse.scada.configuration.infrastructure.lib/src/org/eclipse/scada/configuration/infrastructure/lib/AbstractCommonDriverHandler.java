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
package org.eclipse.scada.configuration.infrastructure.lib;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;

public abstract class AbstractCommonDriverHandler<T extends AbstractCommonDriver, S extends CommonDriver> implements DriverHandler
{
    protected abstract S createDriver ( T driver );

    @SuppressWarnings ( "unchecked" )
    @Override
    public Driver process ( final org.eclipse.scada.configuration.infrastructure.Driver infraDriver )
    {
        final T driver = (T)infraDriver;
        final S result = createDriver ( driver );

        result.setName ( driver.getName () );

        result.setPassword ( EcoreUtil.copy ( Worlds.findCommonDriverPassword ( driver ) ) );

        final Endpoint ep = Endpoints.createEndpoint ( driver.getPortNumber (), String.format ( "Driver Endpoint: %s", driver.getName () ) );
        result.getEndpoints ().add ( ep );
        // no need to register the endpoint, this will be done by the world generator

        return result;
    }

}