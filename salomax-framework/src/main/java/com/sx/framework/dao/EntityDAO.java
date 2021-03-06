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
package com.sx.framework.dao;

import java.util.List;

import com.sx.framework.dao.utils.Filter;
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
	List<T> list(T entity);
	
	/**
	 * Filter list.
	 * @param classType Return class type list
	 * @param filters Filters
	 * @return filtered list of entities <T>
	 */
	List<T> filter(T entity, Filter... filters);

}
