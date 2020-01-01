package com.home.androidiondemo2.view

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.home.androidiondemo2.R
import com.home.androidiondemo2.model.MainTaipeiExpressInformationPojo

class MainRecyclerViewAdapter(results: MutableList<MainTaipeiExpressInformationPojo.Result.Result>) :
    BaseQuickAdapter<MainTaipeiExpressInformationPojo.Result.Result, BaseViewHolder>(
        R.layout.activity_main_recycler_view_item, results
    ), DraggableModule {

    override fun convert(
        helper: BaseViewHolder,
        item: MainTaipeiExpressInformationPojo.Result.Result?
    ) {
        helper.setText(R.id.text_view_brief_introduction, item?.briefIntroduction)
        helper.setText(R.id.text_view_insert_time, item?.insertTime)
    }
}