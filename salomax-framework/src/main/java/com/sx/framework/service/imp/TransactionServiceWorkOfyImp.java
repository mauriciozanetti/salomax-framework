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

import static com.sx.framework.dao.imp.OfyHelper.ofy;

import java.util.logging.Logger;

import com.googlecode.objectify.TxnType;
import com.googlecode.objectify.Work;
import com.sx.framework.commons.Str;
import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.transaction.TransactionServiceWork;
import com.sx.framework.transaction.TransactionType;
import com.sx.framework.transaction.TransactionWork;

/**
 * TODO comments.
 * 
 * @author salomax
 */
public class TransactionServiceWorkOfyImp implements TransactionServiceWork {

	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(TransactionServiceWorkOfyImp.class);
	
	/**
	 * TODO comments.
	 */
	public Object execute(final TransactionType transactionType, 
			final TransactionWork<Object> transactionWork) {
		
		LOGGER.fine(Str.format("Execute objectify transaction work with type %s", transactionType.name()));
		
		return ofy().execute(
				TxnType.valueOf(transactionType.name()), 
				new Work<Object>() {
		            public Object run() {
		            	try {
		            		Object r = transactionWork.run();
			                return r;
		            	} catch(Throwable e) {
		            		ofy().getTransaction().rollback();
		            		throw new RuntimeException(e);
		            	}
		            }
				});
		
	}

}
