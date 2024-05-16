package com.mechta.network.utils.base_api

import android.net.Uri
import com.mechta.network.utils.result.NetworkResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.onUpload
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.plugins.resources.put
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.setBody
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.resources.href
import io.ktor.resources.serialization.ResourcesFormat
import java.io.File

open class BaseApi: BaseApiHelper() {
    inline fun <reified T> getUrl(
        resource: T
    ): String {
        return href(ResourcesFormat(), resource)
    }

    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.getData(
        resource: T,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<ResponseT> {
        return safeRequest {
            get(
                resource = resource,
                builder = httpRequestBuilder,
            ).body()
        }
    }

    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.getListData(
        resource: T,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<List<ResponseT>> {
        return safeRequest {
            get(
                resource = resource,
                builder = httpRequestBuilder,
            ).body()
        }
    }

    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.getMatrixData(
        resource: T,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<List<List<ResponseT>>> {
        return safeRequest {
            get(
                resource = resource,
                builder = httpRequestBuilder,
            ).body()
        }
    }

    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.postData(
        resource: T,
        data: Any,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<ResponseT> {
        return safeRequest {
            post(resource = resource) {
                httpRequestBuilder()
                setBody(data)
            }.body()
        }
    }

    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.putData(
        resource: T,
        data: Any,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<ResponseT> {
        return safeRequest {
            put(resource = resource) {
                httpRequestBuilder()
                setBody(data)
            }.body()
        }
    }


    suspend inline fun <reified T : Any, reified ResponseT : Any> HttpClient.postFiles(
        resource: T,
        files: List<Uri>,
        httpRequestBuilder: HttpRequestBuilder.() -> Unit = {},
    ): NetworkResult<ResponseT> {
        return safeRequest {
            post(resource = resource) {
                httpRequestBuilder()
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append("file", File(files[0].path!!).readBytes(), Headers.build {
                                append(HttpHeaders.ContentDisposition, "filename=\"event_image.png\"")
                            })
                        },
                    )
                )
                onUpload { bytesSentTotal, contentLength ->
                    println("Sent $bytesSentTotal bytes from $contentLength")
                }
            }.body()
        }
    }
}