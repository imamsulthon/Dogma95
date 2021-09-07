package com.mamski.dogma95.data.model.media

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoCollection(
    @SerializedName("id") val aspectRatio: Int?,
    @SerializedName("results") val backdrops: List<Video>?
): Parcelable

@Parcelize
data class Video(
    @SerializedName("id") val id: String,
    @SerializedName("key") val key: String,
    @SerializedName("name") val name: String?,
    @SerializedName("iso_639_1") val iso_639_1: String?,
    @SerializedName("iso_3166_1") val iso_3166_1: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("site") val site: String?,
    @SerializedName("published_at") val publishedAt: String?,
    @SerializedName("size") val size: Int?,
    @SerializedName("official") val official: Boolean
): Parcelable

@Parcelize
data class ImageCollection(
    @SerializedName("id") val id: Int?,
    @SerializedName("backdrops") val backdrops: List<Image>?,
    @SerializedName("posters") val posters: List<Image>?
): Parcelable

@Parcelize
data class Image(
    @SerializedName("aspect_ratio") val aspectRatio: Float?,
    @SerializedName("iso_639_1") val iso_639_1: String?,
    @SerializedName("file_path") val filePath: String?,
    @SerializedName("file_type") val fileType: String?,
    @SerializedName("vote_average") val vote_average: Int?,
    @SerializedName("vote_count") val vote_count: Int?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?
): Parcelable