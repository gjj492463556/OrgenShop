package com.gjj.orgenshop;

import android.app.Application;

import com.gjj.latte_core.app.Latte;
import com.gjj.latte_ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by GJJ on 2018/8/29.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .configire();
    }
}
