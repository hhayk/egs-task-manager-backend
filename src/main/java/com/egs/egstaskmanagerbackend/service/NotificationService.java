package com.egs.egstaskmanagerbackend.service;

import com.egs.egstaskmanagerbackend.entity.Notification;
import com.egs.egstaskmanagerbackend.entity.Task;
import com.egs.egstaskmanagerbackend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;


    public void registerChanges(Long userId, Task task, Task newTask) {
        if (!task.getName().equals(newTask.getName())) {
            notificationRepository.save(new Notification(userId, task.getId(), "Task Name Has Changed"));
        }
        if (!task.getSeverity().equals(newTask.getSeverity())) {
            notificationRepository.save(new Notification(userId, task.getId(), "Task Severity Has Changed"));
        }
        if (!task.getStatus().equals(newTask.getStatus())) {
            notificationRepository.save(new Notification(userId, task.getId(), "Task Status Has Changed"));
        }
//        if (!userId.equals(task.getId())) {
//            notificationRepository.save(new Notification(userId, task.getId(), "Task Assignee Has Changed"));
//        }
    }

    public void registerCommentChanges(Long userId, Task task) {
        notificationRepository.save(new Notification(userId, task.getId(), "Comment Added To Task"));
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public List<Notification> findByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public void readByUserId(Long userId) {
        notificationRepository.readByUserId(userId, false);
    }
}
