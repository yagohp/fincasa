package com.home.basics.models

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("name")
    override var name: String?,
    @SerializedName("birthdate")
    override var birthdate: String?,
    @SerializedName("email")
    override var email: String?,
    @SerializedName("role")
    override var role: Int?
) : User
