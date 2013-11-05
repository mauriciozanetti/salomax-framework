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
package com.sx.framework.beancontext;

/**
 * Each bean on context can be mapped through this class.
 * 
 * @author marcos.salomao
 */
public class BeanContextMapping<T> {
	
	/**
	 * Type.
	 */
	private Class<T> type;
	
	/**
	 * Reference or type implementation.
	 */
	private Class<? extends T> reference;
	
	/**
	 *Default constructor.
	 */
	public BeanContextMapping() {
		// No implementation
	}
	
	/**
	 * Easy constructor, setting type and reference at once.
	 * 
	 * @param type Type
	 * @param reference Reference or type implementation
	 */
	public BeanContextMapping(Class<T> type, Class<? extends T> reference) {
		setType(type);
		setReference(reference);
	}
	
	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}

	/**
	 * @return the reference
	 */
	public Class<?> getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(Class<? extends T> reference) {
		this.reference = reference;
	}
	
}
