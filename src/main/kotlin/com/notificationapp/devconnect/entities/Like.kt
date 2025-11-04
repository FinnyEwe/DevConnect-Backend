package com.notificationapp.devconnect.entities;

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "likes")
data class Like (
    @Id
    @Column(name="like_id")
    val likeId: String = "",


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
        val author: User = User(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
        val post: Post = Post(),

    @Column(name="created_at")
    val createdAt: String = "",
    )
