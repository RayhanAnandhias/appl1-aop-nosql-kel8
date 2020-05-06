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
        
        accService.deleteAllAccount();
        
        User one = new User("rayhanazka@gmail.com", "rayhananandhias", "abc123", "rayhan azka", new Date());
        User two = new User("abc@gmail.com", "abcd", "jtk123", "decepticon", new Date());
        User three = new User("def@gmail.com", "defg", "bdg123", "darth vader", new Date());
        User four = new User("kiritod@gmail.com","kirito","iwantobeafakboy","Kagaya Kirito", new Date());
        accService.createAccount(one);
        accService.createAccount(two);
        accService.createAccount(three);
        accService.createAccount(four);
//        List<User> users = accService.findByUserName("rayhananandhias");
//        for (User user : users) {
//            System.out.println(user);
//        }
        context.close();
    }
}
