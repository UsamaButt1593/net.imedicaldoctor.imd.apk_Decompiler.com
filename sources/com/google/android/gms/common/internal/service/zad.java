package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class zad extends zaa {

    /* renamed from: l  reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f20276l;

    public zad(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f20276l = resultHolder;
    }

    public final void q0(int i2) throws RemoteException {
        this.f20276l.b(new Status(i2));
    }
}
