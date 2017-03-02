package com.majin.mappoi.Utilities;

import android.content.Context;
import android.util.Log;

/**
 * Created by davidericci on 02/03/17.
 */

public class Logger {

    private final static String TAG = Logger.class.getSimpleName();
    private static Context context_;

    private static Logger instance = null;

    protected Logger() {
        // Exists only to defeat instantiation.
    }

    public static Logger getInstance(Context context) {
        if(instance == null) {
            instance = new Logger();
            context_ = context;
        }
        return instance;
    }

    /**
     *
     * @param tag
     * @param message
     */
    public static void debug(String tag, String message) {
        if (tag != null && message != null /*&& Config.getInstance(context_).isLogEnabled()*/) {
            Log.d(tag, message);
        }
    }

    /**
     *
     * @param tag
     * @param message
     */
    public static void error(String tag, String message) {
        if (tag != null && message != null /*&& Config.getInstance(context_).isLogEnabled()*/) {
            Log.d(tag, message);
        }
    }

    /**
     * @param message
     */
    public static void debug(String message) {
        debug(TAG, message);
    }

    /**
     *
     * @param throwable
     */
    public static void printStackTrace(Throwable throwable) {
//        if (Config.getInstance(context_).isLogEnabled()) {
            throwable.printStackTrace();
//        }
    }

}
