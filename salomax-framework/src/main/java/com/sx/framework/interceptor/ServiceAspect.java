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
package com.sx.framework.interceptor;

import static com.sx.framework.dao.ofy.OfyHelper.ofy;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.googlecode.objectify.TxnType;
import com.googlecode.objectify.Work;
import com.sx.framework.commons.Str;
import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.transaction.Transaction;
import com.sx.framework.transaction.TransactionType;

/**
 * Services aspects.
 * 
 * @author salomax
 */
@Aspect
public class ServiceAspect {
	
	/**
	 * Intercepted transaction service method 
	 * for all <code>com.sx.framework.service.Service</code>s implementations.
	 * 	
	 * @param joinPoint joinPoint
	 * @throws Throwable throwable
	 */
	@Around("execution(* com.sx.framework.service.Service+.*(..))")
	public Object applyTransaction(final ProceedingJoinPoint  joinPoint) throws Throwable {
 
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		Method method = signature.getMethod();
		
		method = joinPoint.getTarget().getClass()
				.getMethod(method.getName(), method.getParameterTypes());
		
		Transaction transaction = method.getAnnotation(Transaction.class);
		
		TransactionType transactionType = TransactionType.SUPPORTS;
		
		if (transaction != null) {
			
			transactionType = transaction.type();
			
			LOGGER.fine(Str.format("%s service transaction type applied for %s method", 
					transactionType, method.getName()));
			
		}
		
		//TODO encapsulate ofy
		return ofy().execute(TxnType.valueOf(transactionType.name()), new Work<Object>() {
            public Object run() {
            	
                try {
                	
                    return joinPoint.proceed(joinPoint.getArgs());
                    
                } catch (Throwable e) {
                	// TODO logger this
					e.printStackTrace();
					
				}
             // TODO better this
				throw new RuntimeException();
            }
        });

	}

}
