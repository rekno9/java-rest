package com.tser.service;

import com.tser.dao.entities.User;
import com.tser.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    UserRepository userRepository;

    public String addNewUser(String userName, String password){
        User newUser = new User(userName, password, true, "USER");
        userRepository.save(newUser);
        return "Saved";
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByName(String userName){
        List<User> tempUsers = userRepository.findByUserName(userName);
        User tempUser = new User();
        if(tempUsers.size() > 0){
            tempUser = tempUsers.get(0);
        }
        return tempUser;
    }

    public List<User> getUserByNameContains(String userName){
        return userRepository.findByUserNameContaining(userName);
    }
}
