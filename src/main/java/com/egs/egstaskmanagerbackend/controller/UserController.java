package com.egs.egstaskmanagerbackend.controller;

import com.egs.egstaskmanagerbackend.entity.User;
import com.egs.egstaskmanagerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public List<User> all() {
        return userService.findAll();
    }
}
