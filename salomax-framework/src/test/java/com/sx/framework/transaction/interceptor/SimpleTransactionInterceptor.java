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
package com.sx.framework.transaction.interceptor;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.sx.framework.commons.Str;
import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.transaction.Transaction;
import com.sx.framework.transaction.TransactionServiceWork;
import com.sx.framework.transaction.TransactionType;
import com.sx.framework.transaction.TransactionWork;

/**
 * @author salomax
 *
 */
public class SimpleTransactionInterceptor implements MethodInterceptor {

	/**
	 * Logger.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(SimpleTransactionInterceptor.class);
	
	/**
	 * Transaction service.
	 */
	@Inject
	private TransactionServiceWork transactionServiceWork;

	/**
	 * 
	 */
	@Override
	public Object invoke(final MethodInvocation invocation) throws Throwable {
		
		Transaction transaction = invocation.getMethod().getAnnotation(Transaction.class);
		
		//Default transaction type
		TransactionType transactionType = TransactionType.SUPPORTS;
		
		if (transaction != null) {
			
			transactionType = transaction.type();
			
			LOGGER.info(Str.format("%s service transaction type applied for %s method", 
					transactionType, invocation.getMethod().getName()));
			
		}
		
		return transactionServiceWork.execute(
				transactionType, 
				new TransactionWork<Object>() {
					public Object run() {
		                try {
							return invocation.proceed();
						} catch (Throwable e) {
							throw new RuntimeException(e);
						}
			        }

				});
		
	}

}
