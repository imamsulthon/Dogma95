package com.mamski.dogma95.data.model.movie

import com.mamski.dogma95.data.model.person.Crew

class MovieUtils(movie: Movie) {

    fun getDirector(list: List<Crew>): Crew{
        return list.single { it.job == "director" }
    }

    fun getDirectors(list: List<Crew>): List<Crew> {
        return list.filter { it.job == "director" }.sortedBy { it.name }
    }

}