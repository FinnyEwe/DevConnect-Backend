package com.notificationapp.devconnect.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.NoArgsConstructor

@Entity
@Table(name = "appusers")
@NoArgsConstructor
data class User (
    @Id
    @Column(name = "user_id")
    val userId: String = "",

    val username: String = "",

    val bio: String = "",



)