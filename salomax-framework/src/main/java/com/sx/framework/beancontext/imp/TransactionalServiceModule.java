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

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.sx.framework.dao.EntityDAO;
import com.sx.framework.dao.imp.GenericOfyEntityDAO;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.service.Service;
import com.sx.framework.service.imp.TransactionalServiceWorkOfyImp;
import com.sx.framework.transaction.TransactionalServiceWork;
import com.sx.framework.transaction.interceptor.TransactionalMethodInterceptor;
import com.sx.framework.transaction.interceptor.imp.TransactionalMethodInterceptorImp;
import com.sx.framework.transaction.service.OtherThingService;
import com.sx.framework.transaction.service.ThingService;
import com.sx.framework.transaction.service.imp.OtherThingServiceImp;
import com.sx.framework.transaction.service.imp.ThingServiceImp;

/**
 * Configuration module to transactional service methods.
 * 
 * @author marcos.salomao
 */
public class TransactionalServiceModule extends AbstractModule {

	/**
	 * Configure service methods to be able 
	 * to execute in a transaction context.
	 */
	@Override
	protected void configure() {

		bind(TransactionalServiceWork.class).to(TransactionalServiceWorkOfyImp.class);		
		bind(ThingService.class).to(ThingServiceImp.class);
		bind(OtherThingService.class).to(OtherThingServiceImp.class);
		bind(new TypeLiteral<EntityDAO<Thing>>(){}).to(new TypeLiteral<GenericOfyEntityDAO<Thing>>(){});
		
		Injector injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				bind(TransactionalMethodInterceptor.class).to(TransactionalMethodInterceptorImp.class);
				bind(TransactionalServiceWork.class).to(TransactionalServiceWorkOfyImp.class);
			}
			
		});
		
		TransactionalMethodInterceptor interceptor = injector.getInstance(TransactionalMethodInterceptor.class);
		bindInterceptor(Matchers.subclassesOf(Service.class), Matchers.any(), interceptor);
	}

}
