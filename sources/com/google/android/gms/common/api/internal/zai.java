package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public abstract class zai {

    /* renamed from: a  reason: collision with root package name */
    public final int f20165a;

    public zai(int i2) {
        this.f20165a = i2;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(@NonNull Status status);

    public abstract void b(@NonNull Exception exc);

    public abstract void c(zabq<?> zabq) throws DeadObjectException;

    public abstract void d(@NonNull zaad zaad, boolean z);
}
