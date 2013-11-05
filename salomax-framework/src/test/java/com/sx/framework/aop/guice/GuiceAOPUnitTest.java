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
package com.sx.framework.aop.guice;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sx.framework.context.BeanContext;

/**
 *Guice AOP unit test.
 */
public class GuiceAOPUnitTest {
	
	/**
	 * test simple aspect.
	 */
	@Test
	public void testAspect() {
		
		System.out.println("Running AopUnitTest.testAspect()");
		
		Injector injector = Guice.createInjector(new SimpleAOPModule());
				 
		A a = injector.getInstance(A.class);
		
		a.executeA();
		
	}

}
