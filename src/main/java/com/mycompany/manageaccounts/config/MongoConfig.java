/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/**
 * 
 * @author rayhan-andika
 */
@Configuration
@ComponentScan(basePackages = "com.mycompany.manageaccounts")
@EnableMongoRepositories("com.mycompany.manageaccounts.repositories")
@EnableAspectJAutoProxy
public class MongoConfig extends AbstractMongoConfiguration {
    @Bean
    public AccountServiceaspect accountServiceaspect(){
        return new AccountServiceaspect();
        
    }
    @Override
    protected String getDatabaseName() {
        return "appl";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}
