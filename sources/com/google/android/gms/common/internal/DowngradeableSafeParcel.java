package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object X = new Object();
    private boolean s = false;

    @KeepForSdk
    protected static boolean C(@NonNull String str) {
        synchronized (X) {
        }
        return true;
    }

    @KeepForSdk
    @Nullable
    protected static Integer H() {
        synchronized (X) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract boolean I(int i2);

    @KeepForSdk
    public void N(boolean z) {
        this.s = z;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean O() {
        return this.s;
    }
}
