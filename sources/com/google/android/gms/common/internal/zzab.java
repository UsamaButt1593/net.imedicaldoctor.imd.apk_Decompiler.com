package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzab extends zza implements IGmsCallbacks {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void X0(int i2, IBinder iBinder, zzk zzk) throws RemoteException {
        throw null;
    }

    public final void g0(int i2, Bundle bundle) throws RemoteException {
        throw null;
    }

    public final void w0(int i2, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzC(1, zza);
    }
}
