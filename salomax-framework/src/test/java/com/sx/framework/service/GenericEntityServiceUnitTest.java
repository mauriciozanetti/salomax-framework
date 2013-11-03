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
package com.sx.framework.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.sx.framework.dao.EntityDAO;
import com.sx.framework.dao.imp.GenericOfyEntityDAO;
import com.sx.framework.dao.imp.OfyHelper;
import com.sx.framework.dao.utils.Filter;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.service.imp.GenericEntityService;

/**
 * Generic Entity DAO unit test.
 * 
 * @author marcos.salomao
 */

public class GenericEntityServiceUnitTest {

	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericEntityServiceUnitTest.class);
	
	/**
	 * LocalServiceTestHelper.
	 */
	private final static LocalServiceTestHelper helper =
		    new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	/**
	 * Thing entity test.
	 */
	private static Thing thing;
	/**
	 * Static block to register.
	 */
	static {
		OfyHelper.register(Thing.class);
	}
	
	/**
	 * Inject.
	 */
	private static Injector injector;
	
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
		
		if (injector == null) {
			injector = Guice.createInjector(new AbstractModule() {
				
				@Override
				protected void configure() {
					bind(new TypeLiteral<EntityService<Thing>>(){}).to(new TypeLiteral<GenericEntityService<Thing>>(){});	
					bind(new TypeLiteral<EntityDAO<Thing>>(){}).to(new TypeLiteral<GenericOfyEntityDAO<Thing>>() {});	
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
		
		LOGGER.info("Saving Thing entity");
		
		EntityService<Thing> service = injector.getInstance(new Key<EntityService<Thing>>(){});

		thing = service.save(thing);
		
		assertTrue(thing != null);
		
		assertTrue(thing.getId() != null && thing.getId() > 0);
		
		LOGGER.info(thing.toString());
		
	}
	

	/**
	 * Test load thing.
	 */
	@Test
	public void testLoadThing() {

		LOGGER.info("Loading Thing entity");

		Integer compareValue = thing.getValue();

		EntityService<Thing> service = injector.getInstance(new Key<EntityService<Thing>>(){});
		
		thing = service.load(thing);
		
		assertTrue(thing != null);
		
		assertTrue(thing.getId() != null && thing.getId() > 0);
		
		assertTrue(thing.getValue().equals(compareValue));
		
		LOGGER.info(thing.toString());

	}
	
	/**
	 * Test list things.
	 */
	@Test
	public void testListThing() {
		
		LOGGER.info("Listing Thing entity");
		
		EntityService<Thing> service = injector.getInstance(new Key<EntityService<Thing>>(){});
		
		List<Thing> list = service.list(thing);
		
		assertTrue(list != null);
		
		assertTrue(list.size() == 1);
		
	}
	
	/**
	 * Test list things.
	 */
	@Test
	public void testFilterThing() {
		
		LOGGER.info("Filtering Thing entity");
		
		EntityService<Thing> service = injector.getInstance(new Key<EntityService<Thing>>(){});

		Integer compareValue = thing.getValue();
		
		Filter filter = new Filter();
		filter.setLeft("value");
		filter.setRight(compareValue);
		
		List<Thing> list = service.filter(thing, filter, filter);
		
		assertTrue(list != null);
		
		assertTrue(list.size() == 1);
		
	}
	
	/**
	 * Test delete things.
	 */
	@Test
	public void testDeleteThing() {
		
		LOGGER.info("Delete Thing entity");
		
		EntityService<Thing> service = injector.getInstance(new Key<EntityService<Thing>>(){});
		
		service.delete(thing);
		
		List<Thing> list = service.list(thing);
		
		assertTrue(list.size() == 0);
		
		LOGGER.info("Generic ofy entity dao successful");
		
	}
	
}
