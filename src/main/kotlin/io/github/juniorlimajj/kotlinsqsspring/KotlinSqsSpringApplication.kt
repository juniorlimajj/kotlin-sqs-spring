package io.github.juniorlimajj.kotlinsqsspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSqsSpringApplication

fun main(args: Array<String>) {
	runApplication<KotlinSqsSpringApplication>(*args)
}
