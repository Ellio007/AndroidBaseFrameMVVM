package com.quyunshuo.module.home.activity

import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.androidbaseframemvvm.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.androidbaseframemvvm.common.constant.RouteUrl
import com.quyunshuo.androidbaseframemvvm.common.ui.BaseActivity
import com.quyunshuo.module.home.databinding.HomeActivitySecondeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = RouteUrl.Home.Second)
class SecondActivity : BaseActivity<HomeActivitySecondeBinding, EmptyViewModel>() {
    override val mViewModel by viewModels<EmptyViewModel>()

    override fun HomeActivitySecondeBinding.initView() {
    }


    override fun initRequestData() {
    }

    override fun initObserve() {
    }
}