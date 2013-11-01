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
package com.sx.framework.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.sx.framework.context.BeanContext;
import com.sx.framework.dao.imp.OfyHelper;
import com.sx.framework.dao.utils.Filter;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.logging.LoggerFactory;

/**
 * Generic Entity DAO unit test.
 * 
 * @author marcos.salomao
 */
public class GenericEntityDAOUnitTest {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericEntityDAOUnitTest.class);
	
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
		
		@SuppressWarnings("unchecked")
		EntityDAO<Thing> dao = BeanContext.getBean(EntityDAO.class);

		thing = dao.save(thing);
		
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

		@SuppressWarnings("unchecked")
		EntityDAO<Thing> dao = BeanContext.getBean(EntityDAO.class);
		
		thing = dao.load(thing);
		
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
		
		@SuppressWarnings("unchecked")
		EntityDAO<Thing> dao = BeanContext.getBean(EntityDAO.class);

		List<Thing> list = dao.list(thing);
		
		assertTrue(list != null);
		
		assertTrue(list.size() == 1);
		
	}
	
	/**
	 * Test list things.
	 */
	@Test
	public void testFilterThing() {
		
		LOGGER.info("Filtering Thing entity");
		
		@SuppressWarnings("unchecked")
		EntityDAO<Thing> dao = BeanContext.getBean(EntityDAO.class);

		Integer compareValue = thing.getValue();
		
		Filter filter = new Filter();
		filter.setLeft("value");
		filter.setRight(compareValue);
		
		List<Thing> list = dao.filter(thing, filter, filter);
		
		assertTrue(list != null);
		
		assertTrue(list.size() == 1);
		
	}
	
	/**
	 * Test delete things.
	 */
	@Test
	public void testDeleteThing() {
		
		LOGGER.info("Delete Thing entity");
		
		@SuppressWarnings("unchecked")
		EntityDAO<Thing> dao = BeanContext.getBean(EntityDAO.class);
		
		dao.delete(thing);
		
		List<Thing> list = dao.list(thing);
		
		assertTrue(list.size() == 0);
		
		LOGGER.info("Generic ofy entity dao successful");
		
	}
	
}
