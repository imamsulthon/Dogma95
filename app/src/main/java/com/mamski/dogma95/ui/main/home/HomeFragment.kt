package com.mamski.dogma95.ui.main.home

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamski.dogma95.data.model.movie.Movie
import com.mamski.dogma95.data.model.state.MovieDataState
import com.mamski.dogma95.databinding.FragmentHomeBinding
import com.mamski.dogma95.ui.MainActivity
import com.mamski.dogma95.ui.adapter.ShowCaseAdapter
import com.mamski.dogma95.ui.main.BaseFragment
import com.mamski.dogma95.ui.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private val adapter: ShowCaseAdapter by lazy {
        ShowCaseAdapter{ item -> showDetail(item) }
    }

    private val adapter2: ShowCaseAdapter by lazy {
        ShowCaseAdapter{ item -> showDetail(item) }
    }

    private val adapter3: ShowCaseAdapter by lazy {
        ShowCaseAdapter{ item -> showDetail(item) }
    }

    override fun setupView() {
        with(binding) {
            recyclerview.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(
                    requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
            }

            recyclerview2.also {
                it.adapter = adapter2
                it.layoutManager = LinearLayoutManager(
                    requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
            }

            recyclerview3.also {
                it.adapter = adapter3
                it.layoutManager = LinearLayoutManager(
                    requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
            }
        }
    }

    override fun fetchViewModel() {
        viewModel.fetchData()
    }

    override fun observeViewModel() {
        viewModel.data.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            printLog("viewModel.data")
        })

        viewModel.dataState1.observe(viewLifecycleOwner, Observer {
            printLog("viewModel.state")
            when (it){
                is MovieDataState.Loading   -> showLoading()
                is MovieDataState.Result    -> updateRecyclerview(it.data.result, it.data.category)
                is MovieDataState.Error     -> showError(it.error.message!!)
            }
        })

        viewModel.dataState2.observe(viewLifecycleOwner, Observer {
            printLog("viewModel.state2")
            when (it){
                is MovieDataState.Loading   -> printLog("Loading2")
                is MovieDataState.Result    -> updateRecyclerview2(it.data.result, it.data.category)
                is MovieDataState.Error     -> printLog("Error2")
            }
        })

        viewModel.dataState3.observe(viewLifecycleOwner, Observer {
            when (it) {
                is MovieDataState.Loading   -> printLog("Loading3")
                is MovieDataState.Result    -> updateRecyclerview3(it.data.result, it.data.category)
                is MovieDataState.Error     -> printLog("Error3")
            }
        })
    }

    private fun showDetail(item: Movie) {
        val intent = Intent(context, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun updateRecyclerview(list: List<Movie>?, cat: String) {
        printLog("updateRecyclerview ${list?.size} $cat")
        label.text = cat
        list.let { adapter.setData(it) }
    }

    private fun updateRecyclerview2(list: List<Movie>?, cat: String) {
        printLog("updateRecyclerview2 ${list?.size} $cat")
        label2.text = cat
        list.let { adapter2.setData(it) }
    }

    private fun updateRecyclerview3(list: List<Movie>?, cat: String) {
        printLog("updateRecyclerview3 ${list?.size} $cat")
        label3.text = cat
        list.let { adapter3.setData(it) }
    }

    private fun showLoading() {
        printLog("showLoading")
    }

    private fun showError(msg: String) {
        printLog("populateData $msg")
    }

}