package io.github.juniorlimajj.kotlinsqsspring.controller

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/send-message")
class QueueController(
    @Value("\${cloud.aws.credentials.access-key}") private val accessKey: String,
    @Value("\${cloud.aws.credentials.secret-key}") private val secretKey: String,
    @Value("\${cloud.aws.region.static}") private val awsRegion: String,
    @Value("\${aws.queue.endpoint}") private val queueEndpoint: String,
    @Value("\${aws.queue.queue-test-sqs}") private val queueName: String
) {

    @PostMapping
    fun sendMessage(@RequestBody message: String): ResponseEntity<String> {

        val credentials = BasicAWSCredentials(accessKey, secretKey)

        val sqs = AmazonSQSClientBuilder.standard()
            .withRegion(awsRegion)
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build()

        val sendMessageStandardQueue = SendMessageRequest()
            .withMessageBody(message)
            .withQueueUrl("$queueEndpoint$queueName")

        val result = sqs.sendMessage(sendMessageStandardQueue)

        return ResponseEntity.ok().body(result.messageId)
    }
}