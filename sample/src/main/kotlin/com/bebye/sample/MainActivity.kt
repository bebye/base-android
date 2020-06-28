package com.bebye.sample

import android.os.Bundle
import com.bebye.base.ui.BaseDataBindingActivity
import com.bebye.sample.databinding.ActivityMainBinding
import com.bebye.sample.ui.main.MainFragment

class MainActivity : BaseDataBindingActivity<ActivityMainBinding>() {

    override val layoutResourceId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
