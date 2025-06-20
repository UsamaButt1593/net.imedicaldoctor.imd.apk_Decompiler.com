package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zam extends zaa implements IInterface {
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper e(IObjectWrapper iObjectWrapper, zax zax) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, iObjectWrapper);
        zac.zac(zaa, zax);
        Parcel zab = zab(2, zaa);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zab.readStrongBinder());
        zab.recycle();
        return e2;
    }
}
