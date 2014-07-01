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
package org.eclipse.scada.configuration.infrastructure.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.util.InfrastructureAdapterFactory;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.util.WorldSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructureItemProviderAdapterFactory extends InfrastructureAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender
{
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier ();

    /**
     * This keeps track of all the item providers created, so that they can be {@link #dispose disposed}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Disposable disposable = new Disposable ();

    /**
     * This helps manage the child creation extenders.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager ( InfrastructureEditPlugin.INSTANCE, InfrastructurePackage.eNS_URI );

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object> ();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureItemProviderAdapterFactory ()
    {
        supportedTypes.add ( IEditingDomainItemProvider.class );
        supportedTypes.add ( IStructuredItemContentProvider.class );
        supportedTypes.add ( ITreeItemContentProvider.class );
        supportedTypes.add ( IItemLabelProvider.class );
        supportedTypes.add ( IItemPropertySource.class );
    }

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.World}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createWorldAdapter ()
    {
        return new WorldItemProvider ( this );
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.MasterServer} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MasterServerItemProvider masterServerItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.MasterServer}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createMasterServerAdapter ()
    {
        if ( masterServerItemProvider == null )
        {
            masterServerItemProvider = new MasterServerItemProvider ( this );
        }

        return masterServerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.MasterImport} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MasterImportItemProvider masterImportItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.MasterImport}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createMasterImportAdapter ()
    {
        if ( masterImportItemProvider == null )
        {
            masterImportItemProvider = new MasterImportItemProvider ( this );
        }

        return masterImportItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.Options} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OptionsItemProvider optionsItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.Options}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createOptionsAdapter ()
    {
        if ( optionsItemProvider == null )
        {
            optionsItemProvider = new OptionsItemProvider ( this );
        }

        return optionsItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.CommonDriver} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CommonDriverItemProvider commonDriverItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.CommonDriver}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCommonDriverAdapter ()
    {
        if ( commonDriverItemProvider == null )
        {
            commonDriverItemProvider = new CommonDriverItemProvider ( this );
        }

        return commonDriverItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ExternalNode} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExternalNodeItemProvider externalNodeItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ExternalNode}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createExternalNodeAdapter ()
    {
        if ( externalNodeItemProvider == null )
        {
            externalNodeItemProvider = new ExternalNodeItemProvider ( this );
        }

        return externalNodeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.SystemNode} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemNodeItemProvider systemNodeItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.SystemNode}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSystemNodeAdapter ()
    {
        if ( systemNodeItemProvider == null )
        {
            systemNodeItemProvider = new SystemNodeItemProvider ( this );
        }

        return systemNodeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemPropertyUserServiceItemProvider systemPropertyUserServiceItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSystemPropertyUserServiceAdapter ()
    {
        if ( systemPropertyUserServiceItemProvider == null )
        {
            systemPropertyUserServiceItemProvider = new SystemPropertyUserServiceItemProvider ( this );
        }

        return systemPropertyUserServiceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.UserEntry} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserEntryItemProvider userEntryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.UserEntry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createUserEntryAdapter ()
    {
        if ( userEntryItemProvider == null )
        {
            userEntryItemProvider = new UserEntryItemProvider ( this );
        }

        return userEntryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.JdbcUserService} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcUserServiceItemProvider jdbcUserServiceItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.JdbcUserService}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createJdbcUserServiceAdapter ()
    {
        if ( jdbcUserServiceItemProvider == null )
        {
            jdbcUserServiceItemProvider = new JdbcUserServiceItemProvider ( this );
        }

        return jdbcUserServiceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveServer} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueArchiveServerItemProvider valueArchiveServerItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveServer}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createValueArchiveServerAdapter ()
    {
        if ( valueArchiveServerItemProvider == null )
        {
            valueArchiveServerItemProvider = new ValueArchiveServerItemProvider ( this );
        }

        return valueArchiveServerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EquinoxDriverItemProvider equinoxDriverItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEquinoxDriverAdapter ()
    {
        if ( equinoxDriverItemProvider == null )
        {
            equinoxDriverItemProvider = new EquinoxDriverItemProvider ( this );
        }

        return equinoxDriverItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ExternalDriver} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExternalDriverItemProvider externalDriverItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ExternalDriver}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createExternalDriverAdapter ()
    {
        if ( externalDriverItemProvider == null )
        {
            externalDriverItemProvider = new ExternalDriverItemProvider ( this );
        }

        return externalDriverItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExternalDriverPlaceholderItemProvider externalDriverPlaceholderItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createExternalDriverPlaceholderAdapter ()
    {
        if ( externalDriverPlaceholderItemProvider == null )
        {
            externalDriverPlaceholderItemProvider = new ExternalDriverPlaceholderItemProvider ( this );
        }

        return externalDriverPlaceholderItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ApplicationConfigurationItemProvider applicationConfigurationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createApplicationConfigurationAdapter ()
    {
        if ( applicationConfigurationItemProvider == null )
        {
            applicationConfigurationItemProvider = new ApplicationConfigurationItemProvider ( this );
        }

        return applicationConfigurationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.Configurations} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationsItemProvider configurationsItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.Configurations}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createConfigurationsAdapter ()
    {
        if ( configurationsItemProvider == null )
        {
            configurationsItemProvider = new ConfigurationsItemProvider ( this );
        }

        return configurationsItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.HttpServiceModule} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HttpServiceModuleItemProvider httpServiceModuleItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.HttpServiceModule}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createHttpServiceModuleAdapter ()
    {
        if ( httpServiceModuleItemProvider == null )
        {
            httpServiceModuleItemProvider = new HttpServiceModuleItemProvider ( this );
        }

        return httpServiceModuleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.RestExporterModule} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RestExporterModuleItemProvider restExporterModuleItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.RestExporterModule}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRestExporterModuleAdapter ()
    {
        if ( restExporterModuleItemProvider == null )
        {
            restExporterModuleItemProvider = new RestExporterModuleItemProvider ( this );
        }

        return restExporterModuleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueArchiveSlaveItemProvider valueArchiveSlaveItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createValueArchiveSlaveAdapter ()
    {
        if ( valueArchiveSlaveItemProvider == null )
        {
            valueArchiveSlaveItemProvider = new ValueArchiveSlaveItemProvider ( this );
        }

        return valueArchiveSlaveItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WebAdminConsoleItemProvider webAdminConsoleItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createWebAdminConsoleAdapter ()
    {
        if ( webAdminConsoleItemProvider == null )
        {
            webAdminConsoleItemProvider = new WebAdminConsoleItemProvider ( this );
        }

        return webAdminConsoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OracleVMSettingsItemProvider oracleVMSettingsItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createOracleVMSettingsAdapter ()
    {
        if ( oracleVMSettingsItemProvider == null )
        {
            oracleVMSettingsItemProvider = new OracleVMSettingsItemProvider ( this );
        }

        return oracleVMSettingsItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.GenericVMSettings} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenericVMSettingsItemProvider genericVMSettingsItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.GenericVMSettings}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGenericVMSettingsAdapter ()
    {
        if ( genericVMSettingsItemProvider == null )
        {
            genericVMSettingsItemProvider = new GenericVMSettingsItemProvider ( this );
        }

        return genericVMSettingsItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.scada.configuration.infrastructure.DatabaseSettings} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatabaseSettingsItemProvider databaseSettingsItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.scada.configuration.infrastructure.DatabaseSettings}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDatabaseSettingsAdapter ()
    {
        if ( databaseSettingsItemProvider == null )
        {
            databaseSettingsItemProvider = new DatabaseSettingsItemProvider ( this );
        }

        return databaseSettingsItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory ()
    {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory ();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory ( ComposedAdapterFactory parentAdapterFactory )
    {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object type )
    {
        return supportedTypes.contains ( type ) || super.isFactoryForType ( type );
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt ( Notifier notifier, Object type )
    {
        return super.adapt ( notifier, this );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt ( Object object, Object type )
    {
        if ( isFactoryForType ( type ) )
        {
            Object adapter = super.adapt ( object, type );
            if ( ! ( type instanceof Class<?> ) || ( ( (Class<?>)type ).isInstance ( adapter ) ) )
            {
                return adapter;
            }
        }

        return null;
    }

    /**
     * Associates an adapter with a notifier via the base implementation, then records it to ensure it will be disposed.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void associate ( Adapter adapter, Notifier target )
    {
        super.associate ( adapter, target );
        if ( adapter != null )
        {
            disposable.add ( adapter );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders ()
    {
        return childCreationExtenderManager.getChildCreationExtenders ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection<?> getNewChildDescriptors ( Object object, EditingDomain editingDomain )
    {
        return childCreationExtenderManager.getNewChildDescriptors ( object, editingDomain );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator ()
    {
        return childCreationExtenderManager;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener ( INotifyChangedListener notifyChangedListener )
    {
        changeNotifier.addListener ( notifyChangedListener );
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener ( INotifyChangedListener notifyChangedListener )
    {
        changeNotifier.removeListener ( notifyChangedListener );
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged ( Notification notification )
    {
        changeNotifier.fireNotifyChanged ( notification );

        if ( parentAdapterFactory != null )
        {
            parentAdapterFactory.fireNotifyChanged ( notification );
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose ()
    {
        disposable.dispose ();
    }

    /**
     * A child creation extender for the {@link WorldPackage}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class WorldChildCreationExtender implements IChildCreationExtender
    {
        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static class CreationSwitch extends WorldSwitch<Object>
        {
            /**
             * The child descriptors being populated.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            CreationSwitch ( List<Object> newChildDescriptors, EditingDomain editingDomain )
            {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            @Override
            public Object caseApplicationNode ( ApplicationNode object )
            {
                newChildDescriptors.add
                        ( createChildParameter
                        ( WorldPackage.Literals.APPLICATION_NODE__APPLICATIONS,
                                InfrastructureFactory.eINSTANCE.createExternalDriverPlaceholder () ) );

                return null;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected CommandParameter createChildParameter ( Object feature, Object child )
            {
                return new CommandParameter ( null, feature, child );
            }

        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Collection<Object> getNewChildDescriptors ( Object object, EditingDomain editingDomain )
        {
            ArrayList<Object> result = new ArrayList<Object> ();
            new CreationSwitch ( result, editingDomain ).doSwitch ( (EObject)object );
            return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ResourceLocator getResourceLocator ()
        {
            return InfrastructureEditPlugin.INSTANCE;
        }
    }

}
