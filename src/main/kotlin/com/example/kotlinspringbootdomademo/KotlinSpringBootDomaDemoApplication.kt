package com.example.kotlinspringbootdomademo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringBootDomaDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringBootDomaDemoApplication::class.java, *args)
}
