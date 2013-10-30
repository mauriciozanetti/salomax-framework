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

import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.sx.framework.dao.EntityDAO;
import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.logging.LoggerFactory;

/**
 * Generic Ofy Entity DAO unit test.
 * 
 * @author salomax
 */
public class GenericOfyEntityDAOUnitTest {
	
	/**
	 * LocalServiceTestHelper.
	 */
	private final LocalServiceTestHelper helper =
		    new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericOfyEntityDAOUnitTest.class);

	/**
	 * Test Logger Factory
	 */
	@Test
	public void testGenericOfyEntiyDAO() {
		
		LOGGER.info("Testing generic ofy entity dao");
		
		helper.setUp();
		
		EntityDAO<Thing> dao = new GenericOfyEntityDAO<Thing>();
		
		Integer value = new Random().nextInt(1000);
		
		Thing thing = new Thing();
		thing.setValue(value);
		
		thing = dao.save(thing);
		
		assert(thing != null);
		
		LOGGER.info(thing.toString());
		
		helper.tearDown();
		
		LOGGER.info("Generic ofy entity dao successful");
		
	}

}
