package com.notificationapp.devconnect

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DevConnectApplication

fun main(args: Array<String>) {
    runApplication<DevConnectApplication>(*args)
}
