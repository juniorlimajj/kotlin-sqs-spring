package io.github.juniorlimajj.kotlinsqsspring.listner

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
class QueueListenerTest {

    @Mock
    private lateinit var logger: org.slf4j.Logger

    private lateinit var listener: QueueListener

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        listener = QueueListener()
    }

    @Test
    fun testListener() {
        val message = "test message"
        listener.logger = logger
        listener.listener(message)

        org.mockito.Mockito.verify(logger).info("\nReceived message <> SqsListener: $message")
    }
}
