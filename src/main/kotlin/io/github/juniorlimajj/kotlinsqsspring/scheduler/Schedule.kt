package io.github.juniorlimajj.kotlinsqsspring.scheduler

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
@EnableScheduling
class Schedule {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedDelay = 1000)
    fun receiveMessageSync() {
        logger.info("\nScheduled: ${LocalDateTime.now()}")
    }
}