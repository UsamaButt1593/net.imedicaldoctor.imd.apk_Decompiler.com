package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable {
    void a();

    void close();

    T get(int i2);

    int getCount();

    @Deprecated
    boolean isClosed();

    @NonNull
    Iterator<T> iterator();

    @KeepForSdk
    @Nullable
    Bundle l();

    @NonNull
    Iterator<T> v0();
}
