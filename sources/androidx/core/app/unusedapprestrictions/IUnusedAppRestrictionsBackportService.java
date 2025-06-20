package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import org.apache.commons.lang3.ClassUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IUnusedAppRestrictionsBackportService extends IInterface {

    /* renamed from: g  reason: collision with root package name */
    public static final String f5629g = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IUnusedAppRestrictionsBackportService {
        public IBinder asBinder() {
            return null;
        }

        public void e0(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {

        /* renamed from: l  reason: collision with root package name */
        static final int f5630l = 1;

        private static class Proxy implements IUnusedAppRestrictionsBackportService {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f5631l;

            Proxy(IBinder iBinder) {
                this.f5631l = iBinder;
            }

            public IBinder asBinder() {
                return this.f5631l;
            }

            public String e() {
                return IUnusedAppRestrictionsBackportService.f5629g;
            }

            public void e0(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IUnusedAppRestrictionsBackportService.f5629g);
                    obtain.writeStrongInterface(iUnusedAppRestrictionsBackportCallback);
                    this.f5631l.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.f5629g);
        }

        public static IUnusedAppRestrictionsBackportService e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportService.f5629g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUnusedAppRestrictionsBackportService)) ? new Proxy(iBinder) : (IUnusedAppRestrictionsBackportService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            String str = IUnusedAppRestrictionsBackportService.f5629g;
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                e0(IUnusedAppRestrictionsBackportCallback.Stub.e(parcel.readStrongBinder()));
                return true;
            }
        }
    }

    void e0(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException;
}
