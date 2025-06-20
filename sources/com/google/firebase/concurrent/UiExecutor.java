package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public enum UiExecutor implements Executor {
    INSTANCE;
    
    @SuppressLint({"ThreadPoolCreation"})
    private static final Handler X = null;

    static {
        X = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        X.post(runnable);
    }
}
