package com.mamski.dogma95.ui

import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import com.mamski.dogma95.databinding.ActivitySplashScreenBinding
import com.mamski.dogma95.ui.main.BaseActivity
import com.mamski.dogma95.ui.settings.PrefsHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    @Inject
    lateinit var prefsHelper: PrefsHelper

    lateinit var handler: Handler

    override fun inflateLayout(layoutInflater: LayoutInflater): ActivitySplashScreenBinding {
        return ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateHandle() {
        defineRandomCategories()
        handler = Handler()
        handler.postDelayed({
            goToMain()
        }, 5000)
    }

    private fun goToMain() {
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun defineRandomCategories() {
        prefsHelper.generateRandomCategories()
    }

}