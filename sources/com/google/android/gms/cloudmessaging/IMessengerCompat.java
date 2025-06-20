package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

interface IMessengerCompat extends IInterface {

    /* renamed from: h  reason: collision with root package name */
    public static final String f19806h = "com.google.android.gms.iid.IMessengerCompat";

    /* renamed from: i  reason: collision with root package name */
    public static final int f19807i = 1;

    public static class Impl extends Binder implements IMessengerCompat {
        public void T(@NonNull Message message) throws RemoteException {
            throw null;
        }

        @NonNull
        public IBinder asBinder() {
            throw null;
        }

        public boolean onTransact(int i2, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i3) throws RemoteException {
            throw null;
        }
    }

    public static class Proxy implements IMessengerCompat {

        /* renamed from: l  reason: collision with root package name */
        private final IBinder f19808l;

        Proxy(@NonNull IBinder iBinder) {
            this.f19808l = iBinder;
        }

        public void T(@NonNull Message message) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(IMessengerCompat.f19806h);
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.f19808l.transact(1, obtain, (Parcel) null, 1);
            } finally {
                obtain.recycle();
            }
        }

        @NonNull
        public IBinder asBinder() {
            return this.f19808l;
        }
    }

    void T(@NonNull Message message) throws RemoteException;
}
