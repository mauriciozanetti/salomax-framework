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
package com.sx.framework.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sx.framework.dao.EntityDAO;
import com.sx.framework.dao.utils.Filter;
import com.sx.framework.entity.Entity;
import com.sx.framework.service.EntityService;
import com.sx.framework.transaction.Transaction;
import com.sx.framework.transaction.TransactionType;

/**
 * Generic entity service.
 * 
 * @author marcos.salomao
 */
@Component
public class GenericEntityService<T extends Entity<?>> implements EntityService<T> {

	/**
	 * Generic entity DAO pattern.
	 */
	@Autowired
	private EntityDAO<T> entityDAO;
	
	/**
	 * Save a entity.
	 * @param entity entity
	 * @return returns a entity saved
	 */
	@Transaction(type=TransactionType.REQUIRED)
	public T save(T entity) {
		return entityDAO.save(entity);
	}

	/**
	 * Load a entity from your id.
	 * @param entity entity
	 * @return returns a entity
	 */
	public T load(T entity) {
		return entityDAO.load(entity);
	}

	/**
	 * Delete a entity from your id.
	 * @param entity entity
	 */
	@Transaction(type=TransactionType.REQUIRED)
	public void delete(T entity) {
		entityDAO.delete(entity);
	}

	/**
	 * Filter list entities <T>.
	 * @return list of entities <T> filtered
	 */
	public List<T> list(T entity) {
		return entityDAO.list(entity);
	}

	/**
	 * Filter list entities <T>.
	 * @return list of entities <T> filtered
	 */
	public List<T> filter(T entity, Filter... filters) {
		return entityDAO.filter(entity, filters);
	}

}
