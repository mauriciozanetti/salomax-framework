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
package com.sx.framework.transaction;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.sx.framework.beancontext.BeanContext;
import com.sx.framework.beancontext.BeanContextConfiguration;
import com.sx.framework.beancontext.BeanContextFactory;
import com.sx.framework.beancontext.BeanContextMapping;
import com.sx.framework.commons.Str;
import com.sx.framework.dao.imp.OfyHelper;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.transaction.service.OtherThingService;
import com.sx.framework.transaction.service.ThingService;
import com.sx.framework.transaction.service.imp.OtherThingServiceImp;
import com.sx.framework.transaction.service.imp.ThingServiceImp;

/**
 * Service transaction context unit test.
 * 
 * @author salomax
 */
public class ServiceTransactionUnitTest {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(ServiceTransactionUnitTest.class);
	
	/**
	 * LocalServiceTestHelper.
	 */
	private final static LocalServiceTestHelper helper =
		    new LocalServiceTestHelper(
		    		new LocalDatastoreServiceTestConfig()
		    		.setApplyAllHighRepJobPolicy());
	

	/**
	 * Thing entity test.
	 */
	private static Thing thing;
	
	/**
	 * Bean context.
	 */
	private static BeanContext beanContext;
	
	/**
	 * Static block to register.
	 */
	static {
		OfyHelper.register(Thing.class);
	}
	
	/**
	 * Before test.
	 */
	@BeforeClass
	public static void beforeTest() {
	
		LOGGER.info("Testing generic ofy entity dao");
		
		helper.setUp();
		
		if (thing == null) {
			LOGGER.info("Creating a new Thing");
			thing = new Thing();

			Integer value = new Random().nextInt(1000);
			thing.setValue(value);
		}
		
		if (beanContext == null) {
			
			beanContext = BeanContextFactory.getInstance();
			
			beanContext.addContext(new BeanContextConfiguration() {
				
				@SuppressWarnings("unchecked")
				@Override
				public BeanContextMapping<ThingService> configureMapping() {
					return new BeanContextMapping<ThingService>(ThingService.class, ThingServiceImp.class);
				}
			});
			
			beanContext.addContext(new BeanContextConfiguration() {
				
				@SuppressWarnings("unchecked")
				@Override
				public BeanContextMapping<OtherThingService> configureMapping() {
					return new BeanContextMapping<OtherThingService>(OtherThingService.class, OtherThingServiceImp.class);
				}
			});
			
		}
	
	}
	
	/**
	 * After test.
	 */
	@AfterClass
	public static void afterTest() {
		helper.tearDown();
	}
	
	/**
	 * Test save thing.
	 */
	@Test
	public void testSaveThing() {
		
		ThingService service = beanContext.getBean(ThingService.class);
		
		try {
			service.testTransaction(thing);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		
		List<Thing> list = service.list(thing);
		
		assertTrue(list != null);
		
		LOGGER.info(Str.format("list size: %d", list.size()));
		
		assertTrue(list.size() == 0);
		
	}

}
