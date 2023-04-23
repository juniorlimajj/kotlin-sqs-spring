package io.github.juniorlimajj.kotlinsqsspring.listner

import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class QueueListener {

    var logger = LoggerFactory.getLogger(javaClass)

    @SqsListener(value = ["test-queue"])
    fun listener(message: String) {
        logger.info("\nReceived message <> SqsListener: $message")
    }
}