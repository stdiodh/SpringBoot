package com.example.firstSpringBoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class FirstSpringBootApplication

fun main(args: Array<String>) {
	runApplication<FirstSpringBootApplication>(*args)
}

@RestController
class HelloWorldController{
	@RequestMapping("/hello-world", method = [RequestMethod.GET])
	fun HelloWorld() : String {
		return "HelloWorld"
	}
}