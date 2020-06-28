package com.bebye.sample.ui.main

import android.os.Bundle
import android.view.View
import com.bebye.base.ui.BaseFragment
import com.bebye.sample.R
import com.bebye.sample.databinding.FragmentMainBinding
import com.bebye.sample.extension.getViewModel
import com.bebye.sample.viewmodel.MainViewModel

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val layoutResourceId = R.layout.fragment_main

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun refresh() {
    }

    private val mainViewModel by getViewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
