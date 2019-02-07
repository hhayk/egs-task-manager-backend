package com.egs.egstaskmanagerbackend.repository;

import com.egs.egstaskmanagerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
