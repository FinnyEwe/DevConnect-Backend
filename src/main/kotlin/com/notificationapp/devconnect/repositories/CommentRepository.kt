package com.notificationapp.devconnect.repositories

import com.notificationapp.devconnect.entities.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, String>  {
    fun findByPostPostId (postId: String): List<Comment>
    fun findByPostPostIdIn(postIds: List<String>): List<Comment>
}