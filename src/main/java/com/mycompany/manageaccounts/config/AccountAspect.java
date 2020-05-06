/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.config;
import java.util.logging.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
/**
 *
 * @author rayhan-andika
 */
@Aspect
public class AccountAspect {
    private Logger log = Logger.getLogger(this.getClass().getName());
    Handler handlerObj = new ConsoleHandler();

    public AccountAspect() {
        handlerObj.setLevel(Level.ALL);
        log.addHandler(handlerObj);
        log.setLevel(Level.ALL);
        log.setUseParentHandlers(false);
    }
    
    @Before("execution(* com.mycompany.manageaccounts.service.AccountService.*(..))")
    public void runBefore(JoinPoint joinPoint) {
        System.out.println("Sebelum Method " + joinPoint.getSignature().getName() + "()" +  " dijalankan...");
        log.info("Method " + joinPoint.getSignature().getName() + " () akan segera dijalankan");
    }
 
    @AfterReturning(pointcut = "execution(* com.mycompany.manageaccounts.service.AccountService.*(..))", returning = "result")
    public void runAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Setelah  Method " + joinPoint.getSignature().getName() + "()" + " dijalankan...");
        log.info("Method " + joinPoint.getSignature().getName() + " () telah dijalankan dengan hasil : " + result);
    }
}
