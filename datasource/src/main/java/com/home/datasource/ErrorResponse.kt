package com.home.datasource

import com.google.gson.annotations.SerializedName

/**
 * Data class used as DTO for request errors
 * @author Yago H Pereira <yago.henriquep@gmail.com>
 * @since 20/01/2024
 * @version 1.0.0
 */
data class ErrorResponse(
    @SerializedName("statusCode")
    var statusCode: Int?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("error")
    var error: String?
);