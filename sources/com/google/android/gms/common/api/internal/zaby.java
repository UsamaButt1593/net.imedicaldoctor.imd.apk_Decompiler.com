package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zaa;

public final class zaby extends zaa implements IStatusCallback {
    zaby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public final void f0(Status status) throws RemoteException {
        throw null;
    }
}
