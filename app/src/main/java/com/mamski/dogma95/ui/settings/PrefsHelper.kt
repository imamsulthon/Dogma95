package com.mamski.dogma95.ui.settings

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.mamski.dogma95.Config
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefsHelper constructor(context: Context) {

    private var sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun generateRandomCategories() {
        val list = mutableListOf(
            Config.Category.Upcoming,
            Config.Category.NowPlaying,
            Config.Category.TopRated,
            Config.Category.Popular,
            Config.Category.Latest
        )
        val randoms = list.shuffled().take(3).toSet()
        sharedPreferences.edit().putStringSet("category", randoms).apply()
    }

    fun setRandomCategories() {
        val list = mutableListOf(
            Config.Category.Upcoming,
            Config.Category.NowPlaying,
            Config.Category.TopRated,
            Config.Category.Popular,
            Config.Category.Latest
        )
        val randoms = list.shuffled().take(3).toSet()
        sharedPreferences.edit().putStringSet("category", randoms).apply()
    }

    fun setCategories(list: List<String>) {
        sharedPreferences.edit().putStringSet("category", list.toSet()).apply()
    }

    fun updateCategories(list: List<String>) {
        var currentList = getCategories();
        if (currentList.size < 3) {
        }
    }

    fun getCategories(): List<String> {
        return sharedPreferences.getStringSet("category", null)!!.toList()
    }

}