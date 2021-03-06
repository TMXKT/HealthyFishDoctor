package com.healthyfish.healthyfishdoctor.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.healthyfish.healthyfishdoctor.POJO.BeanBaseReq;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.internal.platform.Platform;

/**
 * 描述：OkHttpUtils初始化工具
 * 作者：Wayne on 2017/6/27 14:49
 * 邮箱：liwei_happyman@qq.com
 * 编辑：
 */

public class OkHttpUtils {
    public static final long DEFAULT_MILLISECONDS = 10_000L;
    private volatile static OkHttpUtils mInstance;
    private static OkHttpClient mOkHttpClient;
    private Platform mPlatform;

    public OkHttpUtils(OkHttpClient okHttpClient)
    {
        if (okHttpClient == null)
        {
            mOkHttpClient = new OkHttpClient();
        } else
        {
            mOkHttpClient = okHttpClient;
        }

        mPlatform = Platform.get();
    }


    public static OkHttpUtils initClient(OkHttpClient okHttpClient)
    {
        if (mInstance == null)
        {
            synchronized (OkHttpUtils.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OkHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OkHttpUtils getInstance()
    {
        return initClient(null);
    }

    public static OkHttpClient getOkHttpClient()
    {
        return mOkHttpClient;
    }

    public static class METHOD
    {
        public static final String HEAD = "HEAD";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
        public static final String PATCH = "PATCH";
    }


    @NonNull
    public static RequestBody getRequestBody(BeanBaseReq beanBaseReq) {
        String jsonStr = JSON.toJSONString(beanBaseReq);

        Log.i("请求信息"," "+jsonStr);

        MediaType MJSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(MJSON,jsonStr);
    }
}
