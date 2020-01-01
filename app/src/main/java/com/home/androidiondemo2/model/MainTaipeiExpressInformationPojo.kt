package com.home.androidiondemo2.model

import com.google.gson.annotations.SerializedName

/**
 * 臺北市文化快遞資訊
 */
data class MainTaipeiExpressInformationPojo(
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("count")
        val count: Int,
        @SerializedName("sort")
        val sort: String,
        @SerializedName("results")
        val results: MutableList<Result>
    ) {
        data class Result(
            @SerializedName("vContent")
            val vContent: String,
            @SerializedName("Fee")
            val fee: String,
            @SerializedName("Location")
            val location: String,
            @SerializedName("DurationEnd")
            val durationEnd: String,
            @SerializedName("ShowGroupName")
            val showGroupName: String,
            @SerializedName("EventUrl")
            val eventUrl: String,
            @SerializedName("Address")
            val address: String,
            @SerializedName("dtStart")
            val dtStart: String,
            @SerializedName("AreaID")
            val areaID: String,
            @SerializedName("EventName")
            val eventName: String,
            @SerializedName("InsertTime")
            val insertTime: String,
            @SerializedName("ID")
            val iD: String,
            @SerializedName("CityID")
            val cityID: String,
            @SerializedName("IsCharge")
            val isCharge: String,
            @SerializedName("DurationStart")
            val durationStart: String,
            @SerializedName("ImageFile")
            val imageFile: String,
            @SerializedName("ContactTel")
            val contactTel: String,
            @SerializedName("EventTypeID")
            val eventTypeID: String,
            @SerializedName("dtEnd")
            val dtEnd: String,
            @SerializedName("_id")
            val id: Int,
            @SerializedName("BriefIntroduction")
            val briefIntroduction: String,
            @SerializedName("timeStart")
            val timeStart: String,
            @SerializedName("latitude")
            val latitude: String,
            @SerializedName("longitude")
            val longitude: String,
            @SerializedName("ContactName")
            val contactName: String,
            @SerializedName("ShoppingUrl")
            val shoppingUrl: String,
            @SerializedName("ContactFax")
            val contactFax: String,
            @SerializedName("YouTubeUrl")
            val youTubeUrl: String,
            @SerializedName("LogoImageFile")
            val logoImageFile: Any
        )
    }
}