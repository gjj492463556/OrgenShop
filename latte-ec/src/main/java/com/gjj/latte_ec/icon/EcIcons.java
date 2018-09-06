package com.gjj.latte_ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by GJJ on 2018/8/30.
 */
public enum EcIcons implements Icon {
    icon_scan('\ue783');

    private char character;

    EcIcons(char character){
        this.character = character;
    }
    @Override
    public String key() {
        return name().replace('_','_');
    }

    @Override
    public char character() {
        return character;
    }
}
