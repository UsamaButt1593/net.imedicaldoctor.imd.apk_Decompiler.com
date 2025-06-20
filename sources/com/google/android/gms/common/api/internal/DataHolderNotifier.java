package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {

    /* renamed from: a  reason: collision with root package name */
    private final DataHolder f19998a;

    @KeepForSdk
    protected DataHolderNotifier(@NonNull DataHolder dataHolder) {
        this.f19998a = dataHolder;
    }

    @KeepForSdk
    public final void a(@NonNull L l2) {
        c(l2, this.f19998a);
    }

    @KeepForSdk
    public void b() {
        DataHolder dataHolder = this.f19998a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void c(@NonNull L l2, @NonNull DataHolder dataHolder);
}
