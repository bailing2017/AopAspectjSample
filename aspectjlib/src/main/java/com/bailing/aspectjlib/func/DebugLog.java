package com.bailing.aspectjlib.func;

import android.util.Log;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/27 0027 11:06
 */

public class DebugLog {
    private DebugLog(){}

    public static void log(String tag, String message) {
        Log.e(tag, message);
    }
}
