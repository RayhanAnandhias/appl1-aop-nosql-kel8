/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.app;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.mycompany.manageaccounts.model.User;
import com.mycompany.manageaccounts.config.MongoConfig;
import com.mycompany.manageaccounts.service.AccountService;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author rayhan-andika
 */
public class App {
    public static void main(String[] args) {
       // ApplicationContext aspect= new ClassPathXmlApplicationContext("com.mycompany.manageaccounts.app/container.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        AccountService accService = (AccountService) context.getBean("accountService");
        
        Menu menu = new Menu(accService);
        menu.select();
//        List<User> users = accService.findByUserName("rayhananandhias");
//        for (User user : users) {
//            System.out.println(user);
//        }
        context.close();
    }
}
