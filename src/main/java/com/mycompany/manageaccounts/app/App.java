/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.app;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.mycompany.manageaccounts.config.MongoConfig;
import com.mycompany.manageaccounts.service.AccountService;
/**
 *
 * @author rayhan-andika
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        AccountService accService = (AccountService) context.getBean("accountService");
        
        Menu menu = new Menu(accService);
        menu.select();
        
        context.close();
    }
}
