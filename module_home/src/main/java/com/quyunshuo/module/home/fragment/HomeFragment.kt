package com.quyunshuo.module.home.fragment

import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.androidbaseframemvvm.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.androidbaseframemvvm.common.constant.RouteUrl
import com.quyunshuo.androidbaseframemvvm.common.ui.BaseFragment
import com.quyunshuo.module.home.adapter.HorizontalVpAdapter
import com.quyunshuo.module.home.databinding.HomeFragmenLayoutBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 首页Fragment
 *
 * @author Qu Yunshuo
 * @since 2021/8/1 11:46 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Home.HomeFragment)
class HomeFragment : BaseFragment<HomeFragmenLayoutBinding, EmptyViewModel>() {

    @Inject
    lateinit var horizontalVpAdapter: HorizontalVpAdapter

    override val mViewModel: EmptyViewModel by viewModels()

    override fun HomeFragmenLayoutBinding.initView() {
        mBinding.vp2.adapter = horizontalVpAdapter
    }

    override fun initObserve() {
    }

    override fun initRequestData() {
    }
}