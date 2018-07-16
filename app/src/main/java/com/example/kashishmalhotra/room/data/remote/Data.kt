package com.example.kashishmalhotra.room.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("_id")
        @Expose
        var id : String? = null,

        @SerializedName("name")
        @Expose
        var name : String? = null,

        @SerializedName("address")
        @Expose
        var address :String? = null,

        @SerializedName("city")
        @Expose
        var city : String ?  = null
)