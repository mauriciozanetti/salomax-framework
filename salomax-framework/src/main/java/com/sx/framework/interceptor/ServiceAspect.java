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

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.sx.framework.logging.LoggerFactory;
import com.sx.framework.transaction.Transaction;
import com.sx.framework.transaction.TransactionServiceWork;

/**
 * Services aspects.
 * 
 * @author salomax
 */
@Aspect
public class ServiceAspect {
	
	/**
	 * Logging.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);
	
	/**
	 * Transaction service.
	 */
	@Autowired
	private TransactionServiceWork transactionServiceWork;
	
	@Pointcut("call(* *(..)) && !within(ServiceAspect)")
	private void applyTransaction() {
		// com.sx.framework.transaction.ThingService.test
		// execution(public * *(..))
		//com.sx.framework.service.Service+.
	}

	@Around("applyTransaction()")
	public Object applyTransaction(final ProceedingJoinPoint  proceedingJoinPoint) throws Throwable {
		LOGGER.info(">>>>>>>" + proceedingJoinPoint.toString());
		return proceedingJoinPoint.proceed();
	}
	
	/**
	 * Intercepted transaction service method 
	 * for all <code>com.sx.framework.service.Service</code>s implementations.
	 * 	
	 * @param joinPoint joinPoint
	 * @throws Throwable throwable
	 */
	/*
	@Around("execution(* com.sx.framework.service.Service+.*(..))")
	public Object applyTransaction(final ProceedingJoinPoint  joinPoint) throws Throwable {
 
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		Method method = signature.getMethod();
		
		method = joinPoint.getTarget().getClass()
				.getMethod(method.getName(), method.getParameterTypes());
		
		Transaction transaction = method.getAnnotation(Transaction.class);
		
		//Default transaction type
		TransactionType transactionType = TransactionType.NOT_SUPPORTED;
		
		if (transaction != null) {
			
			transactionType = transaction.type();
			
			LOGGER.info(Str.format("%s service transaction type applied for %s method", 
					transactionType, method.getName()));
			
		}

		return transactionServiceWork.execute(
				transactionType, 
				new TransactionWork<Object>() {
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
	*/

}
