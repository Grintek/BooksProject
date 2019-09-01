package com.library.service;

import com.library.domain.Role;
import com.library.domain.User;
import com.library.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findByUsername(username);
    }

    @Autowired
    private UserRepo userRepo;

    public boolean addUser(User user){
        User userFormDB = userRepo.findByUsername(user.getUsername());

        if(userFormDB != null){
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(user.getPassword());

        userRepo.save(user);
        return true;
    }

}
