package com.home.androidiondemo2.presenter

import com.home.androidiondemo2.common.utils.IonUtils
import com.home.androidiondemo2.model.MainModel

class MainPresenter {

    private val mainModel = MainModel()

    fun getMainTaipeiExpressInformation(callBack: IonUtils.CallBack) {
        mainModel.getMainTaipeiExpressInformation(object : IonUtils.CallBack {
            override fun onResponse(any: Any?) {
                callBack.onResponse(any)
            }

            override fun onFailure(e: Exception?) {
                callBack.onFailure(e)
            }
        })
    }
}