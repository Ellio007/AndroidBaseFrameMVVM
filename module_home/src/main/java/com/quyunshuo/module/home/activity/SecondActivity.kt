package com.quyunshuo.module.home.activity

import androidx.activity.viewModels
import com.quyunshuo.androidbaseframemvvm.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.androidbaseframemvvm.common.ui.BaseActivity
import com.quyunshuo.module.home.databinding.HomeActivitySecondeBinding

class SecondActivity : BaseActivity<HomeActivitySecondeBinding, EmptyViewModel>() {
    override val mViewModel: EmptyViewModel by viewModels()

    override fun HomeActivitySecondeBinding.initView() {
    }


    override fun initRequestData() {
    }

    override fun initObserve() {
    }
}