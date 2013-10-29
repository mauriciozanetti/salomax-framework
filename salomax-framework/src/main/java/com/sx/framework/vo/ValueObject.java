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
package com.sx.framework.vo;

import com.sx.framework.serialization.VOSerializer;
import com.sx.framework.serialization.VOSerializerFactory;

/**
 * Value object pattern.
 * 
 * @author marcos.salomao
 */
public class ValueObject {

	/**
	 * Value object to String.
	 * @return Value object to String
	 */
	@Override
	public String toString() {
		return serialize();
	}

	/**
	 * Serializes value object into String.
	 * @return Value object serialized
	 */
	public String serialize() {
		VOSerializer serializer = VOSerializerFactory.getInstance();
		return serializer.serialize(this);
	}
	
}
