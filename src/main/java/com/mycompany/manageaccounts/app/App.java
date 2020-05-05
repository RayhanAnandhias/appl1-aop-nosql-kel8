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
/**
 *
 * @author rayhan-andika
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        AccountService accService = (AccountService) context.getBean("accountService");
        
        accService.deleteAllAccount();
        
        User one = new User("rayhanazka@gmail.com", "rayhananandhias", "abc123", "rayhan azka", new Date());
        User two = new User("abc@gmail.com", "abcd", "jtk123", "decepticon", new Date());
        User three = new User("def@gmail.com", "defg", "bdg123", "darth vader", new Date());
        accService.createAccount(one);
        accService.createAccount(two);
        accService.createAccount(three);
//        List<User> users = accService.findByUserName("rayhananandhias");
//        for (User user : users) {
//            System.out.println(user);
//        }
        context.close();
    }
}
