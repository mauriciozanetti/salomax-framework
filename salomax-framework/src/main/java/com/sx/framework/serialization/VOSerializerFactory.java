/*
 *  Copyright 2013.
 *  
 *  Este arquivo é parte do programa SALOMAX FRAMEWORK.
 *  NÃO REMOVA OU MODIFIQUE o cabeçalho deste arquivo contendo sua licença de uso.
 *  
 * SALOMAX FRAMEWORK é um software livre; você pode redistribuí-lo e/ou 
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como 
 * publicada pela Fundação do Software Livre (FSF); na versão 2 da 
 * Licença, ou (na sua opinião) qualquer versão.

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

import com.sx.framework.serialization.imp.JSONVOSerializerImp;

/**
 * Factory pattern to Value Object Serialization.
 * 
 * @author marcos.salomao
 */
public class VOSerializerFactory {
	
	/**
	 * Singleton pattern.
	 */
	private static VOSerializer voSerializer;

	/**
	 * Create a new instance of Value Object serializer.
	 * @return instance of Value Object serializer
	 */
	public static VOSerializer getInstance() {
		if (voSerializer == null) {
			voSerializer = new JSONVOSerializerImp();
		}
		return voSerializer;
	}

}
