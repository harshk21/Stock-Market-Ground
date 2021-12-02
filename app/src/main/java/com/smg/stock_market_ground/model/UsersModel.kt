package com.smg.stock_market_ground.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersModel(
    @SerializedName("accountType")
    var accountType: String,
    @SerializedName("blUserLocale")
    var blUserLocale: String,
    @SerializedName("___class")
    var classX: String,
    @SerializedName("created")
    var created: Long,
    @SerializedName("email")
    var email: String,
    @SerializedName("lastLogin")
    var lastLogin: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("oAuthIdentities")
    var oAuthIdentities: String,
    @SerializedName("objectId")
    var objectId: String,
    @SerializedName("ownerId")
    var ownerId: String,
    @SerializedName("socialAccount")
    var socialAccount: String,
    @SerializedName("updated")
    var updated: String,
    @SerializedName("userStatus")
    var userStatus: String,
    @SerializedName("user-token")
    var userToken: String
) : Parcelable