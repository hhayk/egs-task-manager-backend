package com.egs.egstaskmanagerbackend.repository;

import com.egs.egstaskmanagerbackend.entity.Notification;
import com.egs.egstaskmanagerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update Notification n set n.unread=:unread where n.userId=:userId")
    void readByUserId(@Param("userId") Long userId, @Param("unread") Boolean unread);
}
