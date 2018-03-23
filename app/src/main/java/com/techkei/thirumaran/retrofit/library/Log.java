package com.techkei.thirumaran.retrofit.library;


public class Log {


    private static boolean SHOW_LOG = true;

    public static void d(String name, String value) {
        if (SHOW_LOG) {
            android.util.Log.d(name, value);
        }

    }

    public static void i(String name, String value) {
        if (SHOW_LOG) {
            android.util.Log.i(name, value);
        }
    }

    public static void e(String name, String value) {
        if (SHOW_LOG) {
            android.util.Log.e(name, value);
        }
    }

    public static void w(String name, String value) {
        if (SHOW_LOG) {
            android.util.Log.e(name, value);
        }
    }
}
