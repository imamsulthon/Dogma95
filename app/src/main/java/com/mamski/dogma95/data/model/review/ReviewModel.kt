package com.mamski.dogma95.data.model.review

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mamski.dogma95.data.model.person.Author
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review(
    @SerializedName("id") val id: String,
    @SerializedName("author") val name: String?,
    @SerializedName("author_details") val authorDetails: Author?,
    @SerializedName("content") val content: String?,
    @SerializedName("created_at") val created_at: String?,
    @SerializedName("updated_at") val updated_at: String?,
    @SerializedName("url") val url: String
): Parcelable
