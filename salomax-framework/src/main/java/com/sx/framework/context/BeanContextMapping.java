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
package com.sx.framework.context;


/**
 * TODO comments.
 * 
 * @author salomax
 *
 */
public class BeanContextMapping {
	
	/**
	 * TODO comments.
	 */
	private Class<?> type;
	
	/**
	 * TODO comments.
	 */
	private Class<?> reference;

	/**
	 * TODO comments.
	 * 
	 * @param class1
	 * @param class2
	 */
	public BeanContextMapping(Class<?> type, Class<?> reference) {
		setType(type);
		setReference(reference);
	}

	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Class<?> type) {
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
	public void setReference(Class<?> reference) {
		this.reference = reference;
	}

}
