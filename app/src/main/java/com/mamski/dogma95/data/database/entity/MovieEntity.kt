package com.mamski.dogma95.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mamski.dogma95.Config
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = Config.Entity.Movie)
data class MovieEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdb_id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Long?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("vote_average")
    val voteAverage: String?,
    @SerializedName("vote_count")
    val voteCount: Long?
): Parcelable
