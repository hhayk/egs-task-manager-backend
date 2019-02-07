package com.egs.egstaskmanagerbackend.repository;

import com.egs.egstaskmanagerbackend.entity.Task;
import com.egs.egstaskmanagerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
