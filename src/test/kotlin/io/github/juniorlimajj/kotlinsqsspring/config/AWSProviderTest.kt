package io.github.juniorlimajj.kotlinsqsspring.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class AWSProviderTest {

    private val accessKey = "test-access-key"
    private val secretKey = "test-secret-key"

    @Test
    fun `test aws credentials provider`() {
        // mock credentials object
        val credentials: AWSCredentials = mock(AWSCredentials::class.java)
        val awsCredentialsProvider: AWSCredentialsProvider = AWSStaticCredentialsProvider(credentials)

        // create aws provider object with mocked credentials provider
        val awsProvider = AWSProvider(accessKey, secretKey)

        // call awsCredentialsProvider() method to get credentials provider
        val actualProvider = awsProvider.awsCredentialsProvider()

        // assert that the returned credentials provider is equal to the mocked one
        assertEquals(awsCredentialsProvider.javaClass, actualProvider.javaClass)
    }
}
