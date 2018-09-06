package com.gjj.latte_core.net;

import android.content.Context;

import com.gjj.latte_core.net.callback.IError;
import com.gjj.latte_core.net.callback.IFailure;
import com.gjj.latte_core.net.callback.IRequest;
import com.gjj.latte_core.net.callback.ISuccess;
import com.gjj.latte_core.net.callback.RequsetCallBacks;
import com.gjj.latte_core.ui.LatteLoader;
import com.gjj.latte_core.ui.LoaderStyle;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by GJJ on 2018/9/3.
 */
public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARMS = RestCreator.getParams();

    private final IRequest IREQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      Context context,
                      LoaderStyle loaderStyle) {
        this.URL = url;
        PARMS.putAll(params);
        this.IREQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getReservice();
        Call<String> call = null;
        if (IREQUEST != null) {
            IREQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARMS);
                break;
            case POST:
                call = service.post(URL, PARMS);
                break;
            case PUT:
                call = service.put(URL, PARMS);
                break;
            case DELETE:
                call = service.delete(URL, PARMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequsetCallback());
        }
    }

    private Callback<String> getRequsetCallback() {
        return new RequsetCallBacks(IREQUEST, SUCCESS, FAILURE, ERROR, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
