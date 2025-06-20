package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class PendingResultUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final zas f20255a = new zao();

    @KeepForSdk
    public interface ResultConverter<R extends Result, T> {
        @KeepForSdk
        @Nullable
        T a(@NonNull R r);
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result, T extends Response<R>> Task<T> a(@NonNull PendingResult<R> pendingResult, @NonNull T t) {
        return b(pendingResult, new zaq(t));
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result, T> Task<T> b(@NonNull PendingResult<R> pendingResult, @NonNull ResultConverter<R, T> resultConverter) {
        zas zas = f20255a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.c(new zap(pendingResult, taskCompletionSource, resultConverter, zas));
        return taskCompletionSource.a();
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> Task<Void> c(@NonNull PendingResult<R> pendingResult) {
        return b(pendingResult, new zar());
    }
}
