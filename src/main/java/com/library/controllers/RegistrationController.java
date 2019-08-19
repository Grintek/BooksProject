package com.library.controllers;

import com.library.domain.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registr")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity addUser(@Valid User user){
        if(!userService.addUser(user)){
            return new ResponseEntity("Такой User уже есть", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity("User создан", HttpStatus.OK);
    }
}
