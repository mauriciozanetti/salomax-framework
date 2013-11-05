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
package com.sx.framework.transaction.service.imp;

import javax.inject.Inject;

import com.sx.framework.entity.ofy.Thing;
import com.sx.framework.service.imp.GenericEntityService;
import com.sx.framework.transaction.Transaction;
import com.sx.framework.transaction.TransactionType;
import com.sx.framework.transaction.service.OtherThingService;
import com.sx.framework.transaction.service.ThingService;

/**
 * @author marcos.salomao
 */
public class ThingServiceImp extends GenericEntityService<Thing> implements ThingService {
	
	/**
	 * 
	 */
	@Inject
	private OtherThingService otherThingService;

	/**
	 * Transactional method.
	 */
	@Transaction(type=TransactionType.REQUIRED)
	public void testTransaction(Thing thing) {
		
		save(thing);
		
		list(thing).size();
		
		otherThingService.testInnerTransaction(new Thing());

	}

}
