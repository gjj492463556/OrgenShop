package com.gjj.latte_core.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.gjj.latte_core.app.Latte;

/**
 * Created by GJJ on 2018/9/6.
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
