package com.notificationapp.devconnect.repositories

import com.notificationapp.devconnect.entities.Like
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository: JpaRepository<Like, String> {
    fun findByPostPostIdIn(postId: List<String>): List<Like>
}