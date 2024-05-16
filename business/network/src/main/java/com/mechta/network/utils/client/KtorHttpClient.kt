package com.mechta.network.utils.client

import com.mechta.network.utils.client.KtorHttpClientHelper.installContentNegotiation
import com.mechta.network.utils.client.KtorHttpClientHelper.installDefaultRequest
import com.mechta.network.utils.client.KtorHttpClientHelper.installHttpRequestRetry
import com.mechta.network.utils.client.KtorHttpClientHelper.installHttpTimeout
import com.mechta.network.utils.client.KtorHttpClientHelper.installLogging
import com.mechta.network.utils.client.KtorHttpClientHelper.installResources
import com.mechta.network.utils.client.KtorHttpClientHelper.installResponseObserver
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

fun ktorHttpClient(): HttpClient {
    return HttpClient(OkHttp) {
        expectSuccess = true

        installResources()

        installContentNegotiation()

        installLogging()

        installResponseObserver()

        installDefaultRequest()

        installHttpTimeout()

        installHttpRequestRetry()
    }
}