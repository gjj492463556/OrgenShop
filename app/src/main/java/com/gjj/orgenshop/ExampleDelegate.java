package com.gjj.orgenshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gjj.latte_core.fragments.LatteFragment;
import com.gjj.latte_core.net.RestClient;
import com.gjj.latte_core.net.callback.IError;
import com.gjj.latte_core.net.callback.IFailure;
import com.gjj.latte_core.net.callback.ISuccess;
import com.gjj.latte_core.ui.LatteLoader;
import com.gjj.latte_core.ui.LoaderStyle;

/**
 * Created by GJJ on 2018/9/3.
 */
public class ExampleDelegate extends LatteFragment {
    @Override
    public Object setLayout() {
        return R.layout.delagate_manin;
    }

    @Override
    public void onBindView(Bundle saveInstanceState, View rootview) {

        testRequestClient();
    }

    private void testRequestClient() {
        RestClient.builder()
                .url("https://www.baidu.com/s?ie=UTF-8&wd=%E5%9B%BE%E7%89%87")
                .loader(getContext(), LoaderStyle.BallClipRotatePulseIndicator)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(), "请求成功啦" + response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}