package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzz extends zzb implements zzaa {
    public zzz() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzaa e(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzaa ? (zzaa) queryLocalInterface : new zzy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            IObjectWrapper d2 = d();
            parcel2.writeNoException();
            zzc.zze(parcel2, d2);
        } else if (i2 != 2) {
            return false;
        } else {
            int b2 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b2);
        }
        return true;
    }
}
