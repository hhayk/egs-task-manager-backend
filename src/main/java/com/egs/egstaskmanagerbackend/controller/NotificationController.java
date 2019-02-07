package com.egs.egstaskmanagerbackend.controller;

import com.egs.egstaskmanagerbackend.entity.Notification;
import com.egs.egstaskmanagerbackend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping(value = "/")
    public List<Notification> all() {
        return notificationService.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<Notification> findByUserId(@PathVariable Long userId) {
        return notificationService.findByUserId(userId);
    }

    @GetMapping(value = "/read/user/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void readByUserId(@PathVariable Long userId) {
        notificationService.readByUserId(userId);
    }
}
