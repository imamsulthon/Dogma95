package com.mamski.dogma95.data.model.person

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: Int,
    @SerializedName("gender") val gender: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("place_of_birth") val placeOfBirth: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("deathday") val deathDay: String?,
    @SerializedName("biography") val biography: String?,
    @SerializedName("also_known_as") val alsoKnownAs: List<String>?,
    @SerializedName("known_for_department") val knownForDepartment: String?,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("order") val order: Int,
    @SerializedName("adult") val adult: Boolean
): Parcelable
