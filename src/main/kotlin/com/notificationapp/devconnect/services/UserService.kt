package com.notificationapp.devconnect.services

import com.notificationapp.devconnect.entities.User
import com.notificationapp.devconnect.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository
) {
    fun addUser(user: User): User {
        return userRepository.save(user)
    }

    fun findUser(userId: String): User {
        println("userId: $userId")
        println("result: " + userRepository.findUserByUserId(userId))
        return userRepository.findUserByUserId(userId)
    }
}