package com.commonlib.utils;

import android.text.TextUtils;
import android.util.Log;

public class LogUtils {

    private static boolean isDebug = true;

    static String TAG = "LogUtils";

    //for error log
    public static void error(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    //for warming log
    public static void warn(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }

    //for info log
    public static void info(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    //for debug log
    public static void debug(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    //for verbose log
    public static void verbose(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    //for error log
    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    //for warming log
    public static void w(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }

    //for info log
    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    //for debug log
    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    //for verbose log
    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }


    //for warming log
    public static void w(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = TAG;
            }
            Log.w(tag, msg);
        }
    }

    //for info log
    public static void i(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = TAG;
            }
            Log.i(tag, msg);
        }
    }

    //for debug log
    public static void d(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = TAG;
            }
            Log.d(tag, msg);
        }
    }

    //for verbose log
    public static void v(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = TAG;
            }
            Log.v(tag, msg);
        }
    }

    //for verbose log
    public static void e(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = TAG;
            }
            Log.e(tag, msg);
        }
    }

    public static void setDebug(boolean isDebug) {
        LogUtils.isDebug = isDebug;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    /**
     * 点击Log跳转到指定源码位置
     *
     * @param tag Log tag
     * @param msg Log content
     */
    public static void showLog(String tag, String msg) {
        if (isDebug && !TextUtils.isEmpty(msg)) {
            if (TextUtils.isEmpty(tag)) tag = TAG;
            StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
            int currentIndex = -1;
            for (int i = 0; i < stackTraceElement.length; i++) {
                if (stackTraceElement[i].getMethodName().compareTo("showLog") == 0) {
                    currentIndex = i + 1;
                    break;
                }
            }
            if (currentIndex >= 0) {
                String fullClassName = stackTraceElement[currentIndex].getClassName();
                String className = fullClassName.substring(fullClassName
                        .lastIndexOf(".") + 1);
                String methodName = stackTraceElement[currentIndex].getMethodName();
                String lineNumber = String
                        .valueOf(stackTraceElement[currentIndex].getLineNumber());

                Log.i(tag, msg + "\n  ---->at " + className + "." + methodName + "("
                        + className + ".java:" + lineNumber + ")");
            } else {
                Log.i(tag, msg);
            }
        }
    }
}