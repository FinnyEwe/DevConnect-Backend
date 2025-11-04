package com.notificationapp.devconnect.repositories

import com.notificationapp.devconnect.entities.Post
import com.notificationapp.devconnect.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post, String> {
    fun findByAuthorUserId(userId: String): List<Post>
    fun findByPostId(postId: String): Post
}