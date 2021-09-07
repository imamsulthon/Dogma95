package com.mamski.dogma95.data.model.media

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Network(
    @SerializedName("id") val id: Int?,
    @SerializedName("headquarters") val headquarters: String,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("name") val name: String?,
    @SerializedName("origin_country") val originCountry: String?,
    @SerializedName("logo_path") val logoPath: String?
): Parcelable