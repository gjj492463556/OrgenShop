package com.gjj.latte_core.net.callback;

import android.os.Handler;

import com.gjj.latte_core.ui.LatteLoader;
import com.gjj.latte_core.ui.LoaderStyle;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by GJJ on 2018/9/5.
 */
public class RequsetCallBacks implements Callback<String> {

    private final IRequest IREQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;

    static final Handler HANDLER = new Handler();


    public RequsetCallBacks(IRequest IREQUEST, ISuccess SUCCESS, IFailure FAILURE, IError ERROR, LoaderStyle loaderStyle) {
        this.IREQUEST = IREQUEST;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        stopLoading();

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
        stopLoading();
    }

    private void stopLoading() {
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 3000);
        }
    }
}
