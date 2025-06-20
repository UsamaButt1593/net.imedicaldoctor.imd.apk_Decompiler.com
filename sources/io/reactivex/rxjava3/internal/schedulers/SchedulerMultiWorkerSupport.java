package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerMultiWorkerSupport {

    public interface WorkerCallback {
        void a(int i2, @NonNull Scheduler.Worker worker);
    }

    void a(int i2, @NonNull WorkerCallback workerCallback);
}
