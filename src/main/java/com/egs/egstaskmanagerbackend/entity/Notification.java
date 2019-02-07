package com.egs.egstaskmanagerbackend.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "text", nullable = false)
    @Lob
    private String text;

    @Column(name = "unread", nullable = false)
    private Boolean unread;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    public Notification() {
    }

    public Notification(Long userId, Long taskId, String text) {
        this.userId = userId;
        this.taskId = taskId;
        this.text = text;
        this.unread = true;
        this.createdDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getText() {
        return text;
    }

    public Boolean getUnread() {
        return unread;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
