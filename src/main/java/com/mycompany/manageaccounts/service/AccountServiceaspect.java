/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 *
 * @author rayhan-andhika
 */
public class AccountServiceaspect {
    private Log log = LogFactory.getLog(this.getClass());
 
    @Before("execution(* *.*(..))")
    public void runBefore(JoinPoint joinPoint) {
        log.info("Method " + joinPoint.getSignature().getName() + " () telah dijalankan");
    }
 
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void runAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Method " + joinPoint.getSignature().getName() + " () telah dijalankan dengan hasil : " + result);
    }
 
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
    public void runAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("Terjadi error " + e + " didalam method " + joinPoint.getSignature().getName());
    }
}
