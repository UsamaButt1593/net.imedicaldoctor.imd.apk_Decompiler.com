package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzq extends zza implements IInterface {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final IObjectWrapper d1(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i2);
        zzc.zze(zza, iObjectWrapper2);
        Parcel zzB = zzB(8, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }

    public final int e() throws RemoteException {
        Parcel zzB = zzB(6, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final IObjectWrapper e1(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel zzB = zzB(4, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }

    public final int f(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        Parcel zzB = zzB(3, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final IObjectWrapper f1(IObjectWrapper iObjectWrapper, String str, boolean z, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j2);
        Parcel zzB = zzB(7, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }

    public final IObjectWrapper u0(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i2);
        Parcel zzB = zzB(2, zza);
        IObjectWrapper e2 = IObjectWrapper.Stub.e(zzB.readStrongBinder());
        zzB.recycle();
        return e2;
    }

    public final int z(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        Parcel zzB = zzB(5, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }
}
