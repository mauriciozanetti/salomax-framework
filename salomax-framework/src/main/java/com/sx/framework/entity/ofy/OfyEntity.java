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
package com.sx.framework.entity.ofy;

import com.googlecode.objectify.annotation.Id;
import com.sx.framework.entity.Entity;
import com.sx.framework.vo.ValueObject;

/**
 * Defautl ofy entity mapping.
 * 
 * @author marcos.salomao
 */
public abstract class OfyEntity extends ValueObject implements Entity<Long> {

	/**
	 * Id.
	 */
	@Id
	private Long id;
	
	/**
	 * Returns entity id.
	 * @return Id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Set entity id.
	 * @param id entity id
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
