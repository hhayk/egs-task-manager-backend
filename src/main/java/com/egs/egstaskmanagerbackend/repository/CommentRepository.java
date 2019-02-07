package com.egs.egstaskmanagerbackend.repository;

import com.egs.egstaskmanagerbackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
