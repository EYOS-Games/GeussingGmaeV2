package com.eyos.ofir.guessinggame.Utiliteis;

import android.util.Log;

import com.eyos.ofir.guessinggame.BuildConfig;

import timber.log.Timber;

public class TimerUtilites {

    public static void initTimer() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }

    private static class ReleaseTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }


        }
    }
}
