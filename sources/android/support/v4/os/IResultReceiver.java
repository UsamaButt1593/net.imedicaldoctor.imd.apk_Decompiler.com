package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo({RestrictTo.Scope.s})
public interface IResultReceiver extends IInterface {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2405e = "android$support$v4$os$IResultReceiver".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IResultReceiver {
        public void A(int i2, Bundle bundle) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IResultReceiver {

        /* renamed from: l  reason: collision with root package name */
        static final int f2406l = 1;

        private static class Proxy implements IResultReceiver {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f2407l;

            Proxy(IBinder iBinder) {
                this.f2407l = iBinder;
            }

            public void A(int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IResultReceiver.f2405e);
                    obtain.writeInt(i2);
                    _Parcel.d(obtain, bundle, 0);
                    this.f2407l.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2407l;
            }

            public String e() {
                return IResultReceiver.f2405e;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.f2405e);
        }

        public static IResultReceiver e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IResultReceiver.f2405e);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IResultReceiver)) ? new Proxy(iBinder) : (IResultReceiver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = IResultReceiver.f2405e;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                A(parcel.readInt(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void d(Parcel parcel, T t, int i2) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i2);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void A(int i2, Bundle bundle) throws RemoteException;
}
