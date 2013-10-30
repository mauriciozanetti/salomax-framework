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
package com.sx.framework.dao.ofy;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.sx.framework.dao.EntityDAO;
import com.sx.framework.dao.utils.Filter;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.logging.LoggerFactory;

/**
 * Generic Ofy Entity DAO unit test.
 * 
 * @author salomax
 */
public class GenericOfyEntityDAOUnitTest {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericOfyEntityDAOUnitTest.class);
	
	/**
	 * LocalServiceTestHelper.
	 */
	private final LocalServiceTestHelper helper =
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
	@Before
	public void beforeTest() {
	
		LOGGER.info("Testing generic ofy entity dao");
		
		helper.setUp();

		
		if (thing == null) {
			thing = new Thing();

			Integer value = new Random().nextInt(1000);
			thing.setValue(value);
		}
	
	}
	
	/**
	 * Test save thing.
	 */
	@Test
	public void testSaveThing() {
		
		LOGGER.info("Saving Thing entity");
		
		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>(Thing.class);

		thing = dao.save(thing);
		
		assert(thing != null);
		
		assert(thing.getId() != null && thing.getId() > 0);
		
		LOGGER.info(thing.toString());
		
	}
	

	/**
	 * Test load thing.
	 */
	@Test
	public void testLoadThing() {

		assert(thing != null);

		LOGGER.info("Loading Thing entity");

		Integer compareValue = thing.getValue();

		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>(Thing.class);
		
		thing = dao.load(thing);
		
		assert(thing != null);
		
		assert(thing.getValue().equals(compareValue));

	}
	
	/**
	 * Test list things.
	 */
	@Test
	public void testListThing() {
		
		LOGGER.info("Listing Thing entity");
		
		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>(Thing.class);

		List<Thing> list = dao.list();
		
		assert(list != null);
		
		assert(list.size() == 1);
		
	}
	
	/**
	 * Test list things.
	 */
	@Test
	public void testFilterThing() {
		
		LOGGER.info("Filtering Thing entity");
		
		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>(Thing.class);

		Integer compareValue = thing.getValue();
		
		Filter filter = new Filter();
		filter.setLeft("value");
		filter.setRight(compareValue);
		
		List<Thing> list = dao.filter(filter, filter);
		
		assert(list.size() == 1);
		
	}
	
	/**
	 * Test delete things.
	 */
	@Test
	public void testDeleteThing() {
		
		LOGGER.info("Delete Thing entity");
		
		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>(Thing.class);
		
		dao.delete(thing);
		
		List<Thing> list = dao.list();
		
		list = dao.list();
		
		assert(list.size() == 0);
		
		LOGGER.info("Generic ofy entity dao successful");
		
	}
	
	/**
	 * After test.
	 */
	@After
	public void afterTest() {
		helper.tearDown();
	}

}
