/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.config;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
/**
 *
 * @author rayhan-andhika
 */
@Aspect
public class AccountServiceaspect {
    private Logger log = Logger.getLogger(this.getClass().getName());
    Handler handlerobj = new ConsoleHandler();
    
    public AccountServiceaspect(){
        handlerobj.setLevel(Level.ALL);
        log.addHandler(handlerobj);
        log.setLevel(Level.ALL);
        log.setUseParentHandlers(false);
    }
    
 
    @Before("execution(* *.*(..))")
    public void runBefore(JoinPoint joinPoint) {
        log.info("Method " + joinPoint.getSignature().getName() + " () telah dijalankan");
        System.out.println("Project run");
    }
 
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void runAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Method " + joinPoint.getSignature().getName() + " () telah dijalankan dengan hasil : " + result);
        System.out.println("Project result");
    }
 
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
    public void runAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("Terjadi error " + e + " didalam method " + joinPoint.getSignature().getName());
        System.out.println("Project error");
    }
}
