package com.mamski.dogma95.badminton

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "player")
data class Player(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("homepage")
    val homepage: String?
): Parcelable

@Parcelize
data class Set(
    var game: Game?
): Parcelable


@Parcelize
data class Game(
    var interval: Int?
): Parcelable

@Parcelize
data class Score (
    var point: Int,
    var isServeTurn: Boolean = false
): Parcelable