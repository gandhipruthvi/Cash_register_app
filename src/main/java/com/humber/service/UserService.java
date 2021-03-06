package com.humber.service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.model.User;
import com.humber.repository.UserRepository;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
     
    public List<User> listAll() {
        return repo.findAll();
    }
     
    public void save(User user) {
        repo.save(user);
    }
    
    public User login(User user) {
        List<User> users = repo.findAll();
         for (User u : users) {
            if(user.getEmail().equalsIgnoreCase(u.getEmail())) {
                if (user.getPassword().equalsIgnoreCase(u.getPassword())) {
                    return u;
                }
            }
        }
        return null;
    }
     
    public User get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
