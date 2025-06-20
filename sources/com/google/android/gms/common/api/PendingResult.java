package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void a(@NonNull Status status);
    }

    @KeepForSdk
    public void c(@NonNull StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract R d();

    @NonNull
    public abstract R e(long j2, @NonNull TimeUnit timeUnit);

    public abstract void f();

    public abstract boolean g();

    public abstract void h(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void i(@NonNull ResultCallback<? super R> resultCallback, long j2, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends Result> TransformedResult<S> j(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }
}
