package com.commonlib;

import android.app.Application;

public class CommonLib {
    private static Application sApplication;

    public static void install(Application app) {
        if (sApplication == null) {
            sApplication = app;
        } else {
            throw new IllegalArgumentException("Context is already init ");
        }
    }

    public static Application getApplication() {
        return sApplication;
    }
}
