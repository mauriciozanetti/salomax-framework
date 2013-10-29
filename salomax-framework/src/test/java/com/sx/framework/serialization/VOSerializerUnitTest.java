/**
 * 
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
