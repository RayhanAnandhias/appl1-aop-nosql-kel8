/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.manageaccounts.model.User;
import com.mycompany.manageaccounts.repositories.AccountRepository;

/**
 *
 * @author rayhan-andika
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accRepo;
    
    @Override
    public void createAccount(User user) {
        User usr = accRepo.insert(user);
        System.out.println("Created:- " + usr);
    }

    @Override
    public void updateAccount(User user) {
        User usr = accRepo.save(user);
        System.out.println("Updated:- " + usr);
    }

    @Override
    public void deleteAccount(User user) {
        accRepo.delete(user);
        System.out.println("Deleted:- " + user.getId());
    }

    @Override
    public void deleteAllAccount() {
        accRepo.deleteAll();
    }

    @Override
    public List<User> findAllAccount() {
        return accRepo.findAll();
    }

    @Override
    public List<User> findByFullName(String fullName) {
        return accRepo.findByFullName(fullName);
    }

    @Override
    public List<User> findByUserName(String userName) {
        return accRepo.findByUserName(userName);
    }

    @Override
    public User findAccount(String id) {
        return accRepo.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return accRepo.findByEmail(email);
    }
    
    @Override
    public boolean checkAccountAvailability(User user) {
        return (findByEmail(user.getEmail()) != null);
    }
}
