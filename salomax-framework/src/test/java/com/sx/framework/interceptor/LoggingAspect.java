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

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.sx.framework.commons.Str;
import com.sx.framework.logging.LoggerFactory;

/**
 * TODO comments
 * 
 * @author marcos.salomao
 */
@Aspect
public class LoggingAspect {

	/**
	 * TODO comments.
	 * 	
	 * @param joinPoint
	 */
	@Before("execution(* com.sx.framework.interceptor.UnitTest.testing())")
	public void logBefore(JoinPoint joinPoint) {
 
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

		LOGGER.info("Before AOP testing");
	}
	
	/**
	 * TODO comments.
	 * 	
	 * @param joinPoint
	 */
	@After("execution(* com.sx.framework.interceptor.UnitTest.testing())")
	public void logAfter(JoinPoint joinPoint) {
 
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

		LOGGER.info("After AOP testing");
	}
	
	/**
	 * TODO comments.
	 * 	
	 * @param joinPoint
	 * @throws Throwable 
	 */
	@Around("execution(* com.sx.framework.interceptor.UnitTest.testing())")
	public void logAround(ProceedingJoinPoint  joinPoint) throws Throwable {
 
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		
		Long time = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		LOGGER.info(Str.format("Around AOP testing in %d ms", (System.currentTimeMillis() - time)));
	}
	
}
