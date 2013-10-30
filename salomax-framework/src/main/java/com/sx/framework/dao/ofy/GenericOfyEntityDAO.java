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

import java.util.List;
import java.util.logging.Logger;

import com.sx.framework.dao.EntityDAO;
import com.sx.framework.entity.Entity;
import com.sx.framework.logging.LoggerFactory;

/**
 * Objectify implementation for generic entity DAO pattern.
 * 
 * @author marcos.salomao
 */
public abstract class GenericOfyEntityDAO<T extends Entity<?>> implements EntityDAO<T> {

	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(GenericOfyEntityDAO.class);
	
	/**
	 * Save a entity.
	 * @param entity entity
	 * @return returns a entity saved
	 */
	public T save(T entity) {
		//TODO implements method
		return null;
	}

	/**
	 * Load a entity from your id.
	 * @param entity entity
	 * @return returns a entity
	 */
	public T load(T entity) {
		//TODO implements method
		return null;
	}
	
	/**
	 * Delete a entity from your id.
	 * @param entity entity
	 */
	public void delete(T entity) {
		//TODO implements method
	}

	/**
	 * List entities saved.
	 * @return list of entities
	 */
	public List<T> list() {
		//TODO implements method
		return null;
	}
	
}
