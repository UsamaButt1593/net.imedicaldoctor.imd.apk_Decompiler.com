package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderResult implements Result, Releasable {
    @NonNull
    @KeepForSdk
    protected final DataHolder X;
    @NonNull
    @KeepForSdk
    protected final Status s;

    @KeepForSdk
    protected DataHolderResult(@NonNull DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.Q()));
    }

    @KeepForSdk
    public void a() {
        DataHolder dataHolder = this.X;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @NonNull
    @KeepForSdk
    public Status d() {
        return this.s;
    }

    @KeepForSdk
    protected DataHolderResult(@NonNull DataHolder dataHolder, @NonNull Status status) {
        this.s = status;
        this.X = dataHolder;
    }
}
