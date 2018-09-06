package com.gjj.latte_core.net;

import android.content.Context;

import com.gjj.latte_core.net.callback.IError;
import com.gjj.latte_core.net.callback.IFailure;
import com.gjj.latte_core.net.callback.IRequest;
import com.gjj.latte_core.net.callback.ISuccess;
import com.gjj.latte_core.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by GJJ on 2018/9/5.
 */
public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mSuccess = null;
    private IFailure mFailure = null;
    private IError mError = null;
    private RequestBody mBody = null;
    private Context context = null;
    private LoaderStyle loaderStyle = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> mParams) {
        PARAMS.putAll(mParams);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.context = context;
        this.loaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest, mSuccess, mFailure, mError, mBody, context, loaderStyle);
    }
}
