/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.arduino;

import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.arduino.ArduinoConnection#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoConnection()
 * @model
 * @generated
 */
public interface ArduinoConnection extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference.
     * @see #setEndpoint(Endpoint)
     * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoConnection_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.arduino.ArduinoConnection#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

} // ArduinoConnection
