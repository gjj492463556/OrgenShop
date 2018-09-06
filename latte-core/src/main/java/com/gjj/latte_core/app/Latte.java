package com.gjj.latte_core.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by GJJ on 2018/8/29.
 */
public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLOCATION_CONTEXT.name(),
                context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLOCATION_CONTEXT.name());
    }
}
