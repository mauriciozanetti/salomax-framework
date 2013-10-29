/*
 *  Copyright 2013.
 *  
 *  Este arquivo � parte do programa SALOMAX FRAMEWORK.
 *  N�O REMOVA OU MODIFIQUE o cabe�alho deste arquivo contendo sua licen�a de uso.
 *  
 * SALOMAX FRAMEWORK � um software livre; voc� pode redistribu�-lo e/ou 
 * modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como 
 * publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da 
 * Licen�a, ou (na sua opini�o) qualquer vers�o.

 * Este programa � distribu�do na esperan�a de que possa ser  �til, 
 * mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 * MERCADO ou APLICA��O EM PARTICULAR. Veja a
 * Licen�a P�blica Geral GNU para maiores detalhes.
 * 
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
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
