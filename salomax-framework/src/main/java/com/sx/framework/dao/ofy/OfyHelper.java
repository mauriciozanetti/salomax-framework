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

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Objectify helper.
 * 
 * @author salomax
 */
public class OfyHelper {
	
	/**
	 * Static block to register basic ofy entities.
	 */
	static {
        //factory().register(Thing.class);
    }

	/**
	 * Return Objectify instance.
	 * 
	 * @return Objectify instance
	 */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

	/**
	 * Return Objectify factory instance.
	 * 
	 * @return Objectify factory instance
	 */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}
