/**
 * 
 */
package com.sx.framework.logging;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Logger Factory Unit Test
 * 
 * @author marcos.salomao
 */
public class LoggerFactoryUnitTest {
	
	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(LoggerFactoryUnitTest.class);

	/**
	 * Test Logger Factory
	 */
	@Test
	public void testLoggerFactory() {
		
		assert(LOGGER != null);

		LOGGER.info("Info message");
		
		LOGGER.warning("Warning message");
		
		LOGGER.severe("Severe message");

	}

}
