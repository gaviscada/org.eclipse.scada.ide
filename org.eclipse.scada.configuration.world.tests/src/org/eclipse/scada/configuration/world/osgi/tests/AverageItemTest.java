/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.osgi.AverageItem;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Average Item</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AverageItemTest extends ItemTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( AverageItemTest.class );
    }

    /**
     * Constructs a new Average Item test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AverageItemTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Average Item test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AverageItem getFixture ()
    {
        return (AverageItem)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( OsgiFactory.eINSTANCE.createAverageItem () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //AverageItemTest
