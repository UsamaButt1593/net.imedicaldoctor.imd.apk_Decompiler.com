package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zaf extends zaa implements IInterface {
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void e(int i2) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i2);
        zac(7, zaa);
    }

    public final void f(IAccountAccessor iAccountAccessor, int i2, boolean z) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, iAccountAccessor);
        zaa.writeInt(i2);
        zac.zab(zaa, z);
        zac(9, zaa);
    }

    public final void z(zai zai, zae zae) throws RemoteException {
        Parcel zaa = zaa();
        zac.zac(zaa, zai);
        zac.zad(zaa, zae);
        zac(12, zaa);
    }
}
