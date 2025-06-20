package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    @KeepForSdk
    @Nullable
    protected final DataHolder s;

    @KeepForSdk
    protected AbstractDataBuffer(@Nullable DataHolder dataHolder) {
        this.s = dataHolder;
    }

    public void a() {
        DataHolder dataHolder = this.s;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public final void close() {
        a();
    }

    public abstract T get(int i2);

    public int getCount() {
        DataHolder dataHolder = this.s;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.s;
        return dataHolder == null || dataHolder.isClosed();
    }

    @NonNull
    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    @Nullable
    public final Bundle l() {
        DataHolder dataHolder = this.s;
        if (dataHolder == null) {
            return null;
        }
        return dataHolder.l();
    }

    @NonNull
    public Iterator<T> v0() {
        return new SingleRefDataBufferIterator(this);
    }
}
