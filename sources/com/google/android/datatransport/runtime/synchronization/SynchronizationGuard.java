package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

@WorkerThread
public interface SynchronizationGuard {

    public interface CriticalSection<T> {
        T execute();
    }

    <T> T c(CriticalSection<T> criticalSection);
}
