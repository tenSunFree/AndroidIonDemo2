package com.home.androidiondemo2.view

import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemSwipeListener
import com.home.androidiondemo2.R
import com.home.androidiondemo2.common.utils.IonUtils
import com.home.androidiondemo2.model.MainTaipeiExpressInformationPojo
import com.home.androidiondemo2.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeData()
    }

    private fun initializeData() {
        progress_bar.visibility = View.VISIBLE
        val presenter = MainPresenter()
        presenter.getMainTaipeiExpressInformation(object : IonUtils.CallBack {
            override fun onResponse(any: Any?) {
                progress_bar.visibility = View.GONE
                val mainTaipeiExpressInformationPojo =
                    any as MainTaipeiExpressInformationPojo
                val results =
                    mainTaipeiExpressInformationPojo.result.results
                initializeRecyclerView(results)
            }

            override fun onFailure(e: Exception?) {
                progress_bar.visibility = View.GONE
                toast(e.toString())
            }
        })
    }

    private fun initializeRecyclerView(
        results: MutableList<MainTaipeiExpressInformationPojo.Result.Result>
    ) {
        // 側滑監聽
        val onItemSwipeListener = object : OnItemSwipeListener {
            override fun onItemSwipeStart(viewHolder: RecyclerView.ViewHolder, pos: Int) {}
            override fun clearView(viewHolder: RecyclerView.ViewHolder, pos: Int) {}
            override fun onItemSwiped(viewHolder: RecyclerView.ViewHolder, pos: Int) {}
            override fun onItemSwipeMoving(
                canvas: Canvas, viewHolder: RecyclerView.ViewHolder,
                dX: Float, dY: Float, isCurrentlyActive: Boolean
            ) {
                canvas.drawColor(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
            }
        }
        val adapter = MainRecyclerViewAdapter(results)
        adapter.let {
            it.draggableModule!!.isSwipeEnabled = true
            it.draggableModule!!.setOnItemSwipeListener(onItemSwipeListener)
            it.draggableModule!!.itemTouchHelperCallback.setSwipeMoveFlags(ItemTouchHelper.END)
            it.isAnimationFirstOnly = true
            it.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft)
            recycler_view.adapter = adapter
        }
    }
}