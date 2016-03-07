/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.InputReference#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.InputReference#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.recipe.RecipePackage#getInputReference()
 * @model
 * @generated
 */
public interface InputReference extends EObject
{
    /**
     * Returns the value of the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' attribute.
     * @see #setExpression(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getInputReference_Expression()
     * @model required="true"
     * @generated
     */
    String getExpression ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.InputReference#getExpression <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' attribute.
     * @see #getExpression()
     * @generated
     */
    void setExpression ( String value );

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getInputReference_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.InputReference#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

} // InputReference
