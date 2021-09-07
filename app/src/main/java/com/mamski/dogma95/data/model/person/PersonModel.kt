package com.mamski.dogma95.data.model.person

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Credit(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val casts: List<Cast>,
    @SerializedName("crew") val crews: List<Crew>
): Parcelable


@Parcelize
data class Cast(
    @SerializedName("id") val id: Int,
    @SerializedName("cast_id") val castId: Int,
    @SerializedName("credit_id") val creditId: Int,
    @SerializedName("gender") val gender: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("known_for_department") val knownForDepartment: String?,
    @SerializedName("character") val character: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("order") val order: Int,
    @SerializedName("adult") val adult: Boolean
): Parcelable


@Parcelize
data class Crew(
    @SerializedName("id") val id: Int,
    @SerializedName("credit_id") val creditId: Int,
    @SerializedName("gender") val gender: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("known_for_department") val knownForDepartment: String?,
    @SerializedName("job") val job: String,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("order") val order: Int,
    @SerializedName("adult") val adult: Boolean
): Parcelable


@Parcelize
data class Author(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("avatar_path") val avatarPath: String?,
    @SerializedName("rating") val rating: Int
): Parcelable


data class Director (
    private var id: Int? = null,
    private var name: String? = null
)