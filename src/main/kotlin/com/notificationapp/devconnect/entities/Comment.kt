package com.notificationapp.devconnect.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "comment")
data class Comment(
    @Id
    @Column(name = "comment_id")
    val commentId: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val post: Post = Post(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    val author: User = User(),

    val text: String = "",

    @Column(name="created_at")
    val createdAt: String = "",
)