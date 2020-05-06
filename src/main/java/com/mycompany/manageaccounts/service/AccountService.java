/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.service;
import java.util.List;
import com.mycompany.manageaccounts.model.User;
/**
 *
 * @author rayhan & andika
 */
public interface AccountService {
    public void createAccount(User user);
    public void updateAccount(User user);
    public void deleteAccount(User user);
    public void deleteAllAccount();
    public User findAccount(String id);
    public List<User> findByFullName(String fullName);
    public List<User> findByUserName(String userName);
    public User findByEmail(String email);
    public List<User> findAllAccount();
    public boolean checkAccountAvailability(User user);
}
