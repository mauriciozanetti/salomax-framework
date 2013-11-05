/*
 *  Copyright 2013.
 *  
 *  Este arquivo é parte do programa SALOMAX FRAMEWORK.
 *  NÃO REMOVA OU MODIFIQUE o cabeçalho deste arquivo contendo sua licença de uso.
 *  
 * SALOMAX FRAMEWORK é um software livre; você pode redistribuí-lo e/ou 
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como 
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da 
 * Licença.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.sx.framework.beancontext.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.sx.framework.beancontext.BeanContext;
import com.sx.framework.beancontext.BeanContextConfiguration;
import com.sx.framework.beancontext.BeanContextMapping;
import com.sx.framework.beancontext.GenericBeanContextMapping;
import com.sx.framework.beancontext.GenericKey;
import com.sx.framework.commons.Str;
import com.sx.framework.logging.LoggerFactory;

/**
 * Guice implementation to bean context.
 * 
 * @author marcos.salomao
 */
public class GuiceBeanContextImp implements BeanContext {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GuiceBeanContextImp.class);

	/**
	 * Guice injector singleton.
	 */
	private static Injector injector;
	
	/**
	 * Dirty injector instance.
	 */
	private static boolean isDirty;
	
	/**
	 * Guice modules.
	 */
	private static List<Module> modules = new ArrayList<Module>();
	
	/**
	 * Default constructor.
	 */
	public GuiceBeanContextImp() {
		modules.add(new StandardModule());
		modules.add(new TransactionalServiceModule());
		modules.add(new EntityDAOModule());
	}
	
	/**
	 * Returns bean implementation or reference by class.
	 * 
	 * @param class1 class type reference
	 * @return Bean implementation
	 */
	@Override
	public <T> T getBean(Class<T> class1) {
		return getInjector().getInstance(class1);
	}
	
	/**
	 * Returns bean implementation or reference by class.
	 * 
	 * @param genericType generic type reference
	 * @return Bean implementation
	 */
	@Override
	public <T> T getBean(GenericKey<T> genericType) {
		return getInjector().getInstance(genericType);
	}

	/**
	 * Add a new context configuration to bean context.
	 * 
	 * Even a bean context has been created, the next time 
	 * getBean() is called, the context will be reloaded.
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public void addContext(BeanContextConfiguration beanContextConfiguration) {
		
		final BeanContextMapping mapping = beanContextConfiguration.configureMapping();
		
		modules.add(new AbstractModule() {

				/**
				 * Configure a bean lately.
				 */
				@SuppressWarnings("unchecked")
				@Override
				protected void configure() {
					
					if (mapping instanceof GenericBeanContextMapping) {

						GenericBeanContextMapping genericMapping = (GenericBeanContextMapping) mapping;

						LOGGER.info(Str.format("Binding generic type %s to %s",
								genericMapping.getGenericType().getType(),
								genericMapping.getGenericReference().getType()));
						
						bind(genericMapping.getGenericType()).to(genericMapping.getGenericReference());
						
					} else {

						LOGGER.info(Str.format("Binding type %s to %s", 
								mapping.getType().getName(),
								mapping.getReference().getName()));
						
						bind(mapping.getType()).to(mapping.getReference());

					}
					
				}
			});

		// force reload injector.
		setDirty(true);

	}

	/**
	 * Create a Guice injector if there is no one,
	 * or returns the existent.
	 * 
	 * @return the injector
	 */
	protected static Injector getInjector() {
		
		LOGGER.info("Creating Guice injector");
		
		if (injector == null || isDirty) {
			injector = Guice.createInjector(modules);
			
			for (Binding<?> binding : injector.getBindings().values()) {
				LOGGER.info(Str.format("Binding type %s to %s", 
						binding.getKey().getTypeLiteral(),
						binding.getProvider().get()));
			}
			
		}
		
		// actual injector instance is valid
		setDirty(false);
		
		return injector;
	}

	/**
	 * @return the isDirty
	 */
	public static boolean isDirty() {
		return isDirty;
	}

	/**
	 * @param isDirty the isDirty to set
	 */
	public static void setDirty(boolean isDirty) {
		GuiceBeanContextImp.isDirty = isDirty;
	}

}
