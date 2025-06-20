package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo({RestrictTo.Scope.s})
public interface INotificationSideChannel extends IInterface {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2195a = "android$support$v4$app$INotificationSideChannel".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements INotificationSideChannel {
        public void G0(String str, int i2, String str2) throws RemoteException {
        }

        public void Y0(String str, int i2, String str2, Notification notification) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void c0(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INotificationSideChannel {

        /* renamed from: l  reason: collision with root package name */
        static final int f2196l = 1;

        /* renamed from: m  reason: collision with root package name */
        static final int f2197m = 2;

        /* renamed from: n  reason: collision with root package name */
        static final int f2198n = 3;

        private static class Proxy implements INotificationSideChannel {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f2199l;

            Proxy(IBinder iBinder) {
                this.f2199l = iBinder;
            }

            public void G0(String str, int i2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f2195a);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    this.f2199l.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Y0(String str, int i2, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f2195a);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    _Parcel.d(obtain, notification, 0);
                    this.f2199l.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2199l;
            }

            public void c0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INotificationSideChannel.f2195a);
                    obtain.writeString(str);
                    this.f2199l.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String e() {
                return INotificationSideChannel.f2195a;
            }
        }

        public Stub() {
            attachInterface(this, INotificationSideChannel.f2195a);
        }

        public static INotificationSideChannel e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INotificationSideChannel.f2195a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationSideChannel)) ? new Proxy(iBinder) : (INotificationSideChannel) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = INotificationSideChannel.f2195a;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i2 == 1) {
                Y0(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) _Parcel.c(parcel, Notification.CREATOR));
            } else if (i2 == 2) {
                G0(parcel.readString(), parcel.readInt(), parcel.readString());
            } else if (i2 != 3) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                c0(parcel.readString());
            }
            return true;
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

    void G0(String str, int i2, String str2) throws RemoteException;

    void Y0(String str, int i2, String str2, Notification notification) throws RemoteException;

    void c0(String str) throws RemoteException;
}
