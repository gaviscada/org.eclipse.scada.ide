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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Archive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueArchive#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueArchive#getArchiveconfiguration <em>Archiveconfiguration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchive()
 * @model
 * @generated
 */
public interface ValueArchive extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Items</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Item}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchive_Items()
     * @model
     * @generated
     */
    EList<Item> getItems ();

    /**
     * Returns the value of the '<em><b>Archiveconfiguration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archiveconfiguration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Archiveconfiguration</em>' reference.
     * @see #setArchiveconfiguration(ArchiveConfiguration)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchive_Archiveconfiguration()
     * @model
     * @generated
     */
    ArchiveConfiguration getArchiveconfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ValueArchive#getArchiveconfiguration <em>Archiveconfiguration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Archiveconfiguration</em>' reference.
     * @see #getArchiveconfiguration()
     * @generated
     */
    void setArchiveconfiguration ( ArchiveConfiguration value );

} // ValueArchive
