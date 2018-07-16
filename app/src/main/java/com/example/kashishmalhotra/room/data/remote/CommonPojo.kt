package com.example.kashishmalhotra.room.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommonPojo(

        @SerializedName("statusCode")
        @Expose
        var statusCode : Int? = null,

        @SerializedName("message")
        @Expose
        var message : String? = null,

        @SerializedName("data")
        @Expose
        var list : List<Data>? = null
)