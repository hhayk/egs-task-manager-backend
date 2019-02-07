package com.egs.egstaskmanagerbackend.service;

import com.egs.egstaskmanagerbackend.entity.Comment;
import com.egs.egstaskmanagerbackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
