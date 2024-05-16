package com.mechta.network.utils.base_api

import android.util.Log
import com.korem.network.utils.result.HttpExceptions
import com.mechta.network.utils.result.NetworkResult
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.SerializationException

open class BaseApiHelper {
    suspend inline fun <reified T> safeRequest(
        apiCall: () -> T
    ): NetworkResult<T> {
        return try {
            NetworkResult.Success(apiCall())
        } catch (clientRequestException: ClientRequestException) {
            val message = "Status Code: ${clientRequestException.response.status.value} - API Key Missing"
            Log.d("BaseApiHelper", message, clientRequestException)

            NetworkResult.Error.HttpError(
                code = clientRequestException.response.status.value,
                errorBody = clientRequestException.response.body(),
                errorMessage = "Status Code: ${clientRequestException.response.status.value} - API Key Missing",
            )
        } catch (httpExceptions: HttpExceptions) {
            val message = "Status Code: ${httpExceptions.response.status.value} - HttpExceptions"
            Log.d("BaseApiHelper", message, httpExceptions)

            NetworkResult.Error.HttpError(
                code = httpExceptions.response.status.value,
                errorBody = httpExceptions.response.body(),
                errorMessage = httpExceptions.message,
            )
        } catch (serializationException: SerializationException) {
            val message = "Serialization error: ${serializationException.message}"
            Log.d("BaseApiHelper", message, serializationException)

            NetworkResult.Error.SerializationError(
                message = serializationException.message,
                errorMessage = "Something went wrong",
            )
        } catch (noTransformationFoundException: NoTransformationFoundException) {
            val message = "noTransformationFoundException: ${noTransformationFoundException.message}"
            Log.d("BaseApiHelper", message, noTransformationFoundException)
            NetworkResult.Success(noTransformationFoundException.message as T)
        } catch (exception: Exception) {
            val message = "Unknown error: ${exception.message}"
            Log.d("BaseApiHelper", message, exception)

            NetworkResult.Error.GenericError(
                message = exception.message,
                errorMessage = "Something went wrong",
            )
        }
    }
}