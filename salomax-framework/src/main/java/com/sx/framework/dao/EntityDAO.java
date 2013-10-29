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

import com.sx.framework.entity.Entity;

/**
 * Data access object pattern for entities.
 * 
 * @author marcos.salomao
 */
public interface EntityDAO<T extends Entity<?>> extends DAO {

	/**
	 * Save a entity.
	 * @param entity entity
	 * @return returns a entity saved
	 */
	T save(T entity);

	/**
	 * Load a entity from your id.
	 * @param entity entity
	 * @return returns a entity
	 */
	T load(T entity);
	
	/**
	 * Delete a entity from your id.
	 * @param entity entity
	 */
	void delete(T entity);

	/**
	 * List entities saved.
	 * @return list of entities
	 */
	List<T> list();

}