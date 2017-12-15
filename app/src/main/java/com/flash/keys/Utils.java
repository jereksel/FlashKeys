package com.flash.keys;

import android.graphics.Color;

class Utils {

    static int tint(int color) {
        int a = Color.alpha(color);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);

        return Color.argb(a, Math.max((int) (r * 0.9), 0), Math.max((int) (g * 0.9), 0), Math.max((int) (b * 0.9), 0));
    }
}
