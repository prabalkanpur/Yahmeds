package com.yahmeds.healthcare.dataclass

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("sucess")
    val sucess: String,
    @SerializedName("data")
    val data: DataClass
)

data class DataClass(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("pwd")
    val pwd: String,
    @SerializedName("facebookid")
    val facebookid: String,
    @SerializedName("googleid")
    val googleid: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("usertype")
    val usertype: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("deviceId")
    val deviceId: String,
    @SerializedName("lastlogin")
    val lastlogin: String,
    @SerializedName("userRoll")
    val userRoll: String,
    @SerializedName("entryDate")
    val entryDate: String

)