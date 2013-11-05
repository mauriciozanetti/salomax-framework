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
package com.sx.framework.beancontext.imp;

import com.google.inject.AbstractModule;
import com.sx.framework.dao.EntityDAO;
import com.sx.framework.dao.imp.GenericOfyEntityDAO;
import com.sx.framework.serialization.VOSerializer;
import com.sx.framework.serialization.imp.JSONVOSerializerImp;

/**
 * Standard bean configuration.
 * 
 * @author salomax
 */
public class StandardModule extends AbstractModule {

	/**
	 * Configure beans.
	 */
	@Override
	protected void configure() {
		
		bind(VOSerializer.class).to(JSONVOSerializerImp.class);
		
		bind(EntityDAO.class).to(GenericOfyEntityDAO.class);
	
	}

}
