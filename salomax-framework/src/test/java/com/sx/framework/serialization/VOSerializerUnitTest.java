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
package com.sx.framework.serialization;

import java.util.logging.Logger;

import org.junit.Test;

import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.vo.ValueObject;

/**
 * Logger Factory Unit Test
 * 
 * @author marcos.salomao
 */
public class VOSerializerUnitTest {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(VOSerializerUnitTest.class);
	
	/**
	 * Test name.
	 */
	protected static final String TEST_NAME = "Test serialization!";
	
	/**
	 * Value object inner class to use in test.
	 * 
	 * @author marcos.salomao
	 */
	private class ValueObjectTest extends ValueObject {
		@SuppressWarnings("unused")
		public String getName() {
			return TEST_NAME;
		}
	};

	/**
	 * Test Logger Factory
	 */
	@Test
	public void testVOSerializer() {

		LOGGER.info("Starting value object serializer unit test.");
		
		ValueObject valueObject = new ValueObjectTest();
		
		String valueObjectSerialized = valueObject.serialize();

		assert(valueObjectSerialized != null);

		assert(valueObjectSerialized.contains(TEST_NAME));

		LOGGER.info(valueObjectSerialized);
		
		LOGGER.info("Value object serializer unit test ended.");

	}

}
