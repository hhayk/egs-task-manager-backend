package com.egs.egstaskmanagerbackend.controller;

import com.egs.egstaskmanagerbackend.entity.Comment;
import com.egs.egstaskmanagerbackend.entity.Task;
import com.egs.egstaskmanagerbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/{id}")
    public Task one(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping(value = "/{userId}")
    public Task saveTask(@PathVariable Long userId, @RequestBody Task task) {
        return this.taskService.saveTask(userId, task);
    }

    @PutMapping(value = "user/{userId}/task/{taskId}/comments")
    public Comment addComment(@PathVariable Long userId, @PathVariable Long taskId, @RequestBody Comment comment) {
        return this.taskService.addComment(userId, taskId, comment);
    }


    @GetMapping(value = "/")
    public List<Task> all() {
        return taskService.findAll();
    }
}
