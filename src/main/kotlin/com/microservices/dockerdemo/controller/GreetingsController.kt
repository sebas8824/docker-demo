package com.microservices.dockerdemo.controller

import com.microservices.dockerdemo.service.GreetingsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

    @Autowired
    lateinit var greetingsService: GreetingsService

    @GetMapping("/hello")
    fun message() = greetingsService.getGreeting()
}