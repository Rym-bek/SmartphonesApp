package com.mechta.network.utils.client

import android.util.Log
import com.mechta.network.resources.constants.CommonApiConstants
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json


object KtorHttpClientHelper {
    private const val TIMEOUT_DURATION: Long = 60_000

    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
        allowSpecialFloatingPointValues = true
        explicitNulls = false
        coerceInputValues = true
    }

    fun HttpClientConfig<*>.installHttpTimeout() {
        install(HttpTimeout) {
            requestTimeoutMillis = TIMEOUT_DURATION
            connectTimeoutMillis = TIMEOUT_DURATION
            socketTimeoutMillis = TIMEOUT_DURATION
        }
    }

    fun HttpClientConfig<*>.installHttpRequestRetry() {
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 5)
            exponentialDelay()
        }
    }

    fun HttpClientConfig<*>.installResources() {
        install(Resources)
    }

    fun HttpClientConfig<*>.installContentNegotiation() {
        install(ContentNegotiation) {
            json(
                json = json,
                contentType = ContentType.Application.Json,
            )
        }
    }

    fun HttpClientConfig<*>.installLogging() {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("HTTP =>", message)
                }
            }
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }

    fun HttpClientConfig<*>.installResponseObserver() {
        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }
    }

    fun HttpClientConfig<*>.installDefaultRequest() {
        install(DefaultRequest) {
            url(CommonApiConstants.BASE_URL)
            contentType(ContentType.Application.Json)
        }
    }
}