package com.egs.egstaskmanagerbackend.service;

import com.egs.egstaskmanagerbackend.entity.User;
import com.egs.egstaskmanagerbackend.exception.UserNotFoundException;
import com.egs.egstaskmanagerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> findAll() {
        return this.userRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
}
