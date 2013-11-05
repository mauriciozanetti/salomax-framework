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
 * Some bean have generic types and must a specified handling.
 * 
 * @author marcos.salomao
 */
public class GenericBeanContextMapping<T> extends BeanContextMapping<T> {
	
	/**
	 * Generic type.
	 */
	private GenericType<T> type;
	
	/**
	 * Generic reference or generic type implementation..
	 */
	private GenericType<? extends T> reference;
	
	/**
	 * Easy constructor, setting type and reference at once.
	 * 
	 * @param type Generic type
	 * @param reference Generic reference or generic type implementation
	 */
	public GenericBeanContextMapping(GenericType<T> type, GenericType<? extends T> reference) {
		setGenericType(type);
		setGenericReference(reference);
	}

	/**
	 * @return the type
	 */
	public GenericType<T> getGenericType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setGenericType(GenericType<T> type) {
		this.type = type;
	}


	/**
	 * @return the reference
	 */
	public GenericType<? extends T> getGenericReference() {
		return reference;
	}


	/**
	 * @param reference the reference to set
	 */
	public void setGenericReference(GenericType<? extends T> reference) {
		this.reference = reference;
	}

}
