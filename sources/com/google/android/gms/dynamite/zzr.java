package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzr extends zza implements IInterface {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper e(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, iObjectWrapper2);
        Parcel zzB = zzB(2, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }

    public final IObjectWrapper f(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, iObjectWrapper2);
        Parcel zzB = zzB(3, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }
}
