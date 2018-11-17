package com.eyos.ofir.guessinggame.Utiliteis;

import android.app.Application;
import android.util.Log;

import com.eyos.ofir.guessinggame.BuildConfig;

import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class TimerUtilites  {

    public static final int MAX_LOG_LENGHT = 4000;

    public static void initTimer() {
        if (BuildConfig.DEBUG) {//DEBUG TREE
            Timber.plant(new MyDebugTree());
            //add the line number to the lag

        } else {//RELEASE TREE
            Timber.plant(new ReleaseTree());
        }
    }

    private static class ReleaseTree extends Timber.Tree {

        @Override
        protected boolean isLoggable(@Nullable String tag, int priority) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO)
                return false;

            return true;
        }

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (isLoggable(tag, priority)) {
                if (message.length() < MAX_LOG_LENGHT)
                    if (priority == Log.ASSERT) {
                        Timber.wtf(tag, message);
                    } else {
                        Log.println(priority, tag, message);
                    }

                for (int i = 0 , length = message.length(); i < length ; i++){
                    int newLine = message.indexOf('\n', i);
                    do{
                        int end = Math.min(newLine, i + MAX_LOG_LENGHT);
                        String part = message.substring(i , end);
                        if(priority == Log.ASSERT){
                            Timber.wtf(tag, part);
                        }else{
                            Log.println(priority, tag, part);
                        }
                        i = end;
                    }while (i < newLine);

                }
            }


        }
    }

    private static class MyDebugTree extends Timber.DebugTree {
        @Override
        protected String createStackElementTag(StackTraceElement element) {
            return String.format("(%s:%s)#%s",
                    element.getFileName(),
                    element.getLineNumber(),
                    element.getMethodName());
        }
    }
}


