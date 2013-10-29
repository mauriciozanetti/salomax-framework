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
package com.sx.framework.dao;

import java.util.List;
import java.util.logging.Logger;

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
