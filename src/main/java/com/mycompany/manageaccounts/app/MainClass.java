/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.app;

import com.mycompany.manageaccounts.service.AccountService;
import org.springframework.context.ApplicationContext;
import com.mycompany.manageaccounts.model.User;
import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Asus
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext aspect = new ClassPathXmlApplicationContext("com.mycompany.manageaccounts.app/container.xml");
        AccountService accountservice = (AccountService) aspect.getBean("accountservice");
        accountservice.deleteAllAccount();
        User one = new User("andhikazulfikor@gmail.com", "andhika", "inipwdnya", "andhika zulfikor", new Date());
        User two = new User("subarunatsuki@gmail.com", "subaru", "subarashi", "subaru natsuki", new Date());
        User three = new User("kazuma@gmail.com", "kazuma", "lolicon", "Kazuma", new Date());
        User four = new User("megumin@gmail.com","megumin","explosion","Megumin", new Date());
        accountservice.createAccount(one);
        accountservice.createAccount(two);
        accountservice.createAccount(three);
        accountservice.createAccount(four);
    }
}
