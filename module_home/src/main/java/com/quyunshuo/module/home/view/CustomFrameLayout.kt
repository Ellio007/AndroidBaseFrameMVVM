package com.quyunshuo.module.home.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class CustomFrameLayout : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var mInitialTouchY: Float = 0.0f
    private var mInitialTouchX: Float = 0.0f
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("asdfg", "dispatchTouchEvent ${ev?.action}")
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                mInitialTouchX = ev.x
                mInitialTouchY = ev.y
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = ev.x - mInitialTouchX
                val dy = ev.y - mInitialTouchY
                var hasScrollView = false
                for (i in 0 until childCount) {
                    val child = getChildAt(i)
                    if (child.canScrollHorizontally(-1) && dx > 0) {
                        hasScrollView = true
                    }
                    if (child.canScrollHorizontally(1) && dx < 0) {
                        hasScrollView = true
                    }
                }
                val r = kotlin.math.abs(dy) / kotlin.math.abs(dx)
                if (r < 0.6f && hasScrollView) { // 比例可调整
                    requestDisallowInterceptTouchEvent(true)
                }
            }
            MotionEvent.ACTION_UP -> {
                requestDisallowInterceptTouchEvent(false)
            }
            MotionEvent.ACTION_CANCEL -> {
                requestDisallowInterceptTouchEvent(false)
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}