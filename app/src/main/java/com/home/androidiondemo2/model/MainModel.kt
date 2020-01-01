package com.home.androidiondemo2.model

import com.home.androidiondemo2.common.utils.IonUtils

class MainModel {

    companion object {
        const val MAIN_TAIPEI_EXPRESS_INFORMATION_URL =
            "https://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=35aa3c53-28fb-423c-91b6-2c22432d0d70"
    }

    fun getMainTaipeiExpressInformation(callBack: IonUtils.CallBack) {
        IonUtils.getInstance().getRequestServer(
            MAIN_TAIPEI_EXPRESS_INFORMATION_URL,
            object : IonUtils.CallBack {
                override fun onResponse(any: Any?) {
                    callBack.onResponse(any)
                }

                override fun onFailure(e: Exception?) {
                    callBack.onFailure(e)
                }
            }, MainTaipeiExpressInformationPojo::class.java
        )
    }
}