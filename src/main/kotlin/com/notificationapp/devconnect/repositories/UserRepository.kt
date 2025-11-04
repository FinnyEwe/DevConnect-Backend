package com.notificationapp.devconnect.repositories

import com.notificationapp.devconnect.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, String> {
    fun findUserByUserId(userId: String): User
}