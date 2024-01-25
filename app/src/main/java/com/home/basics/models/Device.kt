package com.home.basics.models;

import com.google.gson.annotations.SerializedName

data class Device(
    @SerializedName("dev")
    val deviceId: String?,
    @SerializedName("vCode")
    val versionCode: String?,
    @SerializedName("vRel")
    val releaseVersion: String?,
    @SerializedName("sdk")
    val sdkVersion: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("model")
    val model: String?,
    @SerializedName("fp")
    val fingerprint: String?
)
