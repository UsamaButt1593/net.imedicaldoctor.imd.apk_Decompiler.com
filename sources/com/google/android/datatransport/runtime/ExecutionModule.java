package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module
abstract class ExecutionModule {
    ExecutionModule() {
    }

    @Singleton
    @Provides
    @SuppressLint({"ThreadPoolCreation"})
    static Executor a() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
