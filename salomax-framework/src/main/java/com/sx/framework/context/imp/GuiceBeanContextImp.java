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
package com.sx.framework.context.imp;

import java.util.logging.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sx.framework.commons.Str;
import com.sx.framework.context.BeanContext;
import com.sx.framework.context.BeanContextConfiguration;
import com.sx.framework.context.BeanContextMapping;
import com.sx.framework.logging.LoggerFactory;

/**
 * TODO Comments.
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
	 * TODO comments.
	 */
	@Override
	public void addContext(BeanContextConfiguration beanContextConfiguration) {
		
		final BeanContextMapping mapping = beanContextConfiguration.configureMapping();
		
		if (!getInjector().getAllBindings().containsKey(mapping.getType())) {
			getInjector().createChildInjector(new AbstractModule() {

				/**
				 * TODO Comments.
				 */
				@Override
				protected void configure() {
					LOGGER.info(Str.format("Binding type %s to %s", 
							mapping.getType().getCanonicalName(),
							mapping.getReference().getCanonicalName()));
					bind(mapping.getType()).to(mapping.getReference());
				}
			});
		}

	}

	/**
	 * TODO Comments.
	 * 
	 * @return the injector
	 */
	protected static Injector getInjector() {
		if (injector == null) {
			injector = Guice.createInjector(new StandardModule());
		}
		return injector;
	}

}
