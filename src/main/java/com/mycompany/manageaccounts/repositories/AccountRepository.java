/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.repositories;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.mycompany.manageaccounts.model.User;
/**
 *
 * @author rayhan-andika
 */
@Repository
public interface AccountRepository extends MongoRepository<User, String> {
    @Query("{ 'fullName' : ?0 }")
    List<User> findByFullName(String fullName);
    
    @Query("{ 'username' : ?0 }")
    List<User> findByUserName(String userName);
    
    @Query("{ 'email' : ?0 }")
    User findByEmail(String id);
}
