package com.egs.egstaskmanagerbackend.service;

import com.egs.egstaskmanagerbackend.entity.Comment;
import com.egs.egstaskmanagerbackend.entity.Task;
import com.egs.egstaskmanagerbackend.entity.User;
import com.egs.egstaskmanagerbackend.exception.TaskNotFoundException;
import com.egs.egstaskmanagerbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NotificationService notificationService;

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task saveTask(Long userId, Task newTask) {
        Long taskId = newTask.getId();
        User user = userService.findById(userId);

        if (taskId == null) {
            newTask.setCreatedDate(new Date());
            newTask.setUser(user);
            return taskRepository.save(newTask);
        } else {
            return taskRepository.findById(taskId)
                    .map(task -> {
                        notificationService.registerChanges(userId, task, newTask);

                        task.setName(newTask.getName());
                        task.setSeverity(newTask.getSeverity());
                        task.setStatus(newTask.getStatus());
                        task.setUser(user);

                        return taskRepository.save(task);
                    })
                    .orElseThrow(() -> new TaskNotFoundException(taskId));
        }
    }

    public Comment addComment(Long userId, Long taskId, Comment newComment) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    notificationService.registerCommentChanges(userId, task);

                    Comment comment = new Comment();
                    comment.setText(newComment.getText());
                    comment.setTask(task);
                    comment.setCreatedDate(new Date());
                    Comment savedComment = commentService.saveComment(comment);

                    task.getComments().add(savedComment);
                    taskRepository.save(task);

                    return savedComment;
                })
                .orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    public List<Task> findAll() {
        return taskRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
}

