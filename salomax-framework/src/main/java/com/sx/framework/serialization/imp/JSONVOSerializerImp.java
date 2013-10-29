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
package com.sx.framework.serialization.imp;

import com.sx.framework.serialization.VOSerializer;
import com.sx.framework.vo.ValueObject;

import flexjson.JSONSerializer;

/**
 * JSON pattern implementation to VO Serialization.
 * 
 * @author marcos.salomao
 */
public class JSONVOSerializerImp implements VOSerializer {

	/**
	 * JSON Serializer implementation.
	 */
	private JSONSerializer jsonSerializer;
	
	/**
	 * Default constructor.
	 */
	public JSONVOSerializerImp() {
		jsonSerializer = new JSONSerializer();
		jsonSerializer.prettyPrint(true);
	}
	
	/**
	 * Serializes a value object.
	 * @param target value object to serializes
	 * @return value object serialized
	 */
	public String serialize(ValueObject target) {
		return jsonSerializer.serialize(target);
	}

}
