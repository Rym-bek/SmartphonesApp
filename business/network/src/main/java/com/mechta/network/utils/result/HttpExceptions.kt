package com.korem.network.utils.result

import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.HttpResponse

class HttpExceptions(
  response: HttpResponse,
  failureReason: String?,
  cachedResponseText: String,
) : ResponseException(response, cachedResponseText) {
  override val message: String = "Status: ${response.status}" + " Failure: $failureReason"
}