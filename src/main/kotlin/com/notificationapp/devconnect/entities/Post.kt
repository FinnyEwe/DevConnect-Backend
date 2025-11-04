package com.notificationapp.devconnect.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@Table(name = "post")
data class Post (
    @Id
    @Column(name = "post_id")
    val postId: String = "",

    val content: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: User = User(),

    @Column(name = "created_at")
    val createdAt: String = "",


    )

