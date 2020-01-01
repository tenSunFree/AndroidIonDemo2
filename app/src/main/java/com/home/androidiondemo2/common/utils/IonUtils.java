package com.home.androidiondemo2.common.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.home.androidiondemo2.common.AIDApplication;
import com.koushikdutta.ion.Ion;

public class IonUtils {

    private static final String LOGGING_TAG = "IonUtils";

    public interface CallBack {
        void onResponse(Object any);

        void onFailure(Exception e);
    }

    /**
     * Get網路請求
     *
     * @param url    api網址
     * @param entity json內容對應的javaObject
     */
    @SuppressWarnings("unchecked")
    public void getRequestServer(final String url, final CallBack callBack, final Class entity) {
        Ion.with(AIDApplication.appContext)
                .load(url)
                .setLogging(LOGGING_TAG, Log.DEBUG)
                .asString()
                .setCallback((e, result) -> {
                    if (e != null) {
                        callBack.onFailure(e);
                        return;
                    }
                    String json = guaranteeJsonObject(result);
                    Gson gson = new Gson();
                    Object object = gson.fromJson(json, entity);
                    callBack.onResponse(object);
                });
    }

    /**
     * 確保Json永遠是一個Object
     * 如果是Array, 也會強制轉成Object
     */
    private String guaranteeJsonObject(String json) {
        if (String.valueOf(json.charAt(0)).equals("[")) {
            return "{\"array\":" + json + "}";
        } else {
            return json;
        }
    }

    /**
     * 內部類實現單例模式, 延遲加載, 減少內存開銷
     */
    private static class IonUtilsHolder {
        private static IonUtils instance = new IonUtils();
    }

    public static IonUtils getInstance() {
        return IonUtilsHolder.instance;
    }
}
