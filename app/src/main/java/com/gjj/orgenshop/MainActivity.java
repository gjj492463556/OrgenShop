package com.gjj.orgenshop;


import com.gjj.latte_core.activitys.ProxyActivity;
import com.gjj.latte_core.fragments.LatteFragment;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteFragment setRootDelegate() {
        return new ExampleDelegate();
    }

    @Override
    public void post(Runnable runnable) {

    }
}
