package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {

    /* renamed from: f  reason: collision with root package name */
    public static final String f5626f = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public void R0(boolean z, boolean z2) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {

        /* renamed from: l  reason: collision with root package name */
        static final int f5627l = 1;

        private static class Proxy implements IUnusedAppRestrictionsBackportCallback {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f5628l;

            Proxy(IBinder iBinder) {
                this.f5628l = iBinder;
            }

            public void R0(boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportCallback.f5626f);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f5628l.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f5628l;
            }

            public String e() {
                return IUnusedAppRestrictionsBackportCallback.f5626f;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.f5626f);
        }

        public static IUnusedAppRestrictionsBackportCallback e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.f5626f);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) ? new Proxy(iBinder) : (IUnusedAppRestrictionsBackportCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = IUnusedAppRestrictionsBackportCallback.f5626f;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                boolean z = false;
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                R0(z2, z);
                return true;
            }
        }
    }

    void R0(boolean z, boolean z2) throws RemoteException;
}
