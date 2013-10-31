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
package com.sx.framework.serialization.imp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sx.framework.serialization.VOSerializer;
import com.sx.framework.vo.ValueObject;

import flexjson.JSONSerializer;

/**
 * JSON pattern implementation to VO Serialization.
 * 
 * @author marcos.salomao
 */
@Component
@Scope(value = "singleton")
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
