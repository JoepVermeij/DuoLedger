package com.yooply

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class YooplyApplication

fun main(args: Array<String>) {
    runApplication<YooplyApplication>(*args)
}
