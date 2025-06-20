package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class TaskUtil {
    @KeepForSdk
    public static void a(@NonNull Status status, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        b(status, (Object) null, taskCompletionSource);
    }

    @KeepForSdk
    public static <TResult> void b(@NonNull Status status, @Nullable TResult tresult, @NonNull TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.R()) {
            taskCompletionSource.c(tresult);
        } else {
            taskCompletionSource.b(new ApiException(status));
        }
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static Task<Void> c(@NonNull Task<Boolean> task) {
        return task.m(new zacx());
    }

    @KeepForSdk
    public static <ResultT> boolean d(@NonNull Status status, @Nullable ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        return status.R() ? taskCompletionSource.e(resultt) : taskCompletionSource.d(new ApiException(status));
    }
}
