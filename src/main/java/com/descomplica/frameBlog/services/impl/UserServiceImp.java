package com.descomplica.frameBlog.services.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.descomplica.frameBlog.models.User;
import com.descomplica.frameBlog.repositories.UserRepository;
import com.descomplica.frameBlog.services.UserService;

import jakarta.persistence.EntityNotFoundException;


@Service

public class UserServiceImp  implements UserService{

    @Autowired

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override

    public User save(final User user){

        User existingUser = userRepository.findByUsername(user.getName());

        if(Objects.nonNull(existingUser)){

            throw new RuntimeException("existing user");
        }

        String passwordHash = passwordEncoder.encode(user.getPassword());
        
        User entity = new User(user.getUserId(), user.getName(),user.getEmail(),passwordHash
        ,user.getRole(),user.getUsername());

        User newUser = userRepository.save(entity);

        return new User(newUser.getUserId(), newUser.getName(),newUser.getEmail(),passwordHash
        ,newUser.getRole(),user.getUsername());

    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    
    @Override
    public User get(final Long id){

        return userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("user not found")
        );
        
    }


    @Override
    public User update(final Long id, final User user){
        User userUpdate = userRepository.findById(id).orElse(null);
        if(Objects.nonNull(userUpdate)){

            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setName(user.getName());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setRole(user.getRole());
            userUpdate.setPassword(passwordHash);
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(final Long id){
        userRepository.deleteById(id);
    }



}
