package com.quyunshuo.module.home.activity

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.quyunshuo.androidbaseframemvvm.base.ktx.observe
import com.quyunshuo.androidbaseframemvvm.common.ui.BaseActivity
import com.quyunshuo.module.home.databinding.HomeActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 5/22/21 2:26 PM
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<HomeActivityMainBinding, HomeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // 初始化闪屏页面，splashScreen对象可以设置一些属性
        val splashScreen: SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
    }
    /**
     * 通过 viewModels() + Hilt 获取 ViewModel 实例
     */
    override val mViewModel by viewModels<HomeViewModel>()

    override fun HomeActivityMainBinding.initView() {
        goToNextBtn.setOnClickListener {
            mViewModel.requestUserList()
//            startActivity(Intent(this@MainActivity, InternalPagerActivity::class.java))
        }
    }

    override fun initObserve() {
        // 订阅数据库数据，单一数据来源
        observe(mViewModel.getUserList()) {
            mBinding.vTvHello.text = it.toString()
            mBinding.vTvHello.setTextColor(Color.BLUE)
        }
    }

    override fun initRequestData() {
        // 模拟获取网络数据
        mViewModel.requestUserList()
    }
}