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
package com.sx.framework.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean factory by Spring context.
 * 
 * @author marcos.salomao
 */
public class BeanContext {
	
	/**
	 * Central interface to provide configuration for an application.
	 */
	private static ApplicationContext context;
	
	/**
	 * Returns bean implementation ou reference by class.
	 * 
	 * @param class1 class type reference
	 * @return Bean implementation
	 */
	public static <T> T getBean(Class<T> class1) {
		return getApplicationContext().getBean(class1);
	}
	
	/**
	 * Returns Spring application context using XML configuration.
	 * 
	 * @return Spring application context
	 */
	public static ApplicationContext getApplicationContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext(new String[] {"bean-definitions.xml"}); 
		}
		return context;
	}

}
