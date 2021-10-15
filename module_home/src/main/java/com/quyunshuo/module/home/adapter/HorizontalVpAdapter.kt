package com.quyunshuo.module.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.quyunshuo.module.home.R
import com.quyunshuo.module.home.adapter.HorizontalVpAdapter.HorizontalVpViewHolder
import dagger.hilt.android.qualifiers.ActivityContext
import java.util.*
import javax.inject.Inject

/**
 */
class HorizontalVpAdapter @Inject constructor(@ActivityContext private val mContext: Context) :
    RecyclerView.Adapter<HorizontalVpViewHolder>() {
    private var backgrounds: MutableList<Int>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalVpViewHolder {
        return HorizontalVpViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.home_item_h_v, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HorizontalVpViewHolder, position: Int) {
        holder.mTextView.text = "第  ${(position + 1)} 界面"
        holder.mLinearLayout.setBackgroundResource(backgrounds!![position])
    }

    override fun getItemCount(): Int {
        return if (backgrounds == null) {
            0
        } else backgrounds!!.size
    }

    inner class HorizontalVpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mLinearLayout: LinearLayout = itemView.findViewById(R.id.ll_h_v)
        var mTextView: TextView = itemView.findViewById(R.id.tv_hv)

    }

    init {
        if (backgrounds == null) {
            backgrounds = ArrayList()
            backgrounds!!.add(android.R.color.holo_blue_bright)
            backgrounds!!.add(android.R.color.holo_red_dark)
            backgrounds!!.add(android.R.color.holo_green_dark)
            backgrounds!!.add(android.R.color.holo_orange_light)
            backgrounds!!.add(android.R.color.holo_purple)
        }
    }
}