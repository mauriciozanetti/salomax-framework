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
package com.sx.framework.beancontext;

import com.sx.framework.beancontext.imp.GuiceBeanContextImp;

/**
 * Factory class for bean context.
 * 
 * @author salomax
 */
public class BeanContextFactory {

	/**
	 * Bean context singleton pattern.
	 */
	private static BeanContext beanContext;
	
	/**
	 * Returns bean context implementation.
	 * 
	 * @return bean context implementation
	 */
	public static BeanContext getInstance() {
		
		if (beanContext == null) {
			// TODO better this. 
			// Instantiate the class through 
			// a configuration XML file, for example
			beanContext = new GuiceBeanContextImp();
		}
		
		return beanContext;
	}

}
