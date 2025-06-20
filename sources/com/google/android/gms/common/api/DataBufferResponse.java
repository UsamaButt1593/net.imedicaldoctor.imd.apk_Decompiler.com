package com.google.android.gms.common.api;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @KeepForSdk
    public DataBufferResponse() {
    }

    public final void a() {
        ((AbstractDataBuffer) b()).a();
    }

    public final void close() {
        ((AbstractDataBuffer) b()).close();
    }

    @NonNull
    public final T get(int i2) {
        return ((AbstractDataBuffer) b()).get(i2);
    }

    public final int getCount() {
        return ((AbstractDataBuffer) b()).getCount();
    }

    public final boolean isClosed() {
        return ((AbstractDataBuffer) b()).isClosed();
    }

    @NonNull
    public final Iterator<T> iterator() {
        return ((AbstractDataBuffer) b()).iterator();
    }

    @Nullable
    public final Bundle l() {
        return ((AbstractDataBuffer) b()).l();
    }

    @NonNull
    public final Iterator<T> v0() {
        return ((AbstractDataBuffer) b()).v0();
    }

    @KeepForSdk
    public DataBufferResponse(@NonNull R r) {
        super(r);
    }
}
