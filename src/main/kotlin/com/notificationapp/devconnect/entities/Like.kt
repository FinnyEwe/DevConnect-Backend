package com.notificationapp.devconnect.entities;

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "likes")
data class Like (
    @Id
        @Column(name="like_id")
        val id: String,

    @Column(name="user_id")
        val userId: String,

    @Column(name="post_id")
        val post_id: String,

    @Column(name="created_at")
    val createdAt: LocalDateTime,
    )
