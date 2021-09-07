package com.mamski.dogma95.data.model.genre

import com.google.gson.annotations.SerializedName

data class GenreCollection(
    @SerializedName("genres") val list: List<Genre>
)
