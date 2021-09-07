package com.mamski.dogma95.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    private var _binding: ViewBinding? = null
    protected val binding: VB get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = createBindingInflater(inflater, container).also { _binding = it }.root

    protected open fun createBindingInflater(inflater: LayoutInflater, container: ViewGroup?): VB {
        val vbType = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        val vbClass = vbType as Class<*>
        val method = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return method.invoke(null, inflater, container, false) as VB
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeViewModel()
        fetchViewModel()
    }

    abstract fun setupView()
    abstract fun fetchViewModel()
    abstract fun observeViewModel()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun printLog(msg: Any) {
        println("${javaClass.simpleName}: $msg")
    }

}