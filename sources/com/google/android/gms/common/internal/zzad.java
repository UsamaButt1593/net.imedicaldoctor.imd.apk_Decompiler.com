package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;

final class zzad implements IGmsServiceBroker {

    /* renamed from: l  reason: collision with root package name */
    private final IBinder f20298l;

    zzad(IBinder iBinder) {
        this.f20298l = iBinder;
    }

    public final void X(IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzn.a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f20298l.transact(46, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public final IBinder asBinder() {
        return this.f20298l;
    }
}
