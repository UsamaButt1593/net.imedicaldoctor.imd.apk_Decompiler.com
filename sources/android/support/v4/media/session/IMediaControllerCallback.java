package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.s})
public interface IMediaControllerCallback extends IInterface {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2258b = "android.support.v4.media.session.IMediaControllerCallback";

    public static class Default implements IMediaControllerCallback {
        public void D0() throws RemoteException {
        }

        public void F0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        }

        public void M0(int i2) throws RemoteException {
        }

        public void Z() throws RemoteException {
        }

        public void Z0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
        }

        public void a0(Bundle bundle) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public void b1(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        }

        public void d0(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        }

        public void s0(boolean z) throws RemoteException {
        }

        public void x(int i2) throws RemoteException {
        }

        public void y(String str, Bundle bundle) throws RemoteException {
        }

        public void y0(boolean z) throws RemoteException {
        }

        public void z0(CharSequence charSequence) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        /* renamed from: l  reason: collision with root package name */
        static final int f2259l = 1;

        /* renamed from: m  reason: collision with root package name */
        static final int f2260m = 2;

        /* renamed from: n  reason: collision with root package name */
        static final int f2261n = 3;
        static final int o = 4;
        static final int p = 5;
        static final int q = 6;
        static final int r = 7;
        static final int s = 8;
        static final int t = 9;
        static final int u = 10;
        static final int v = 11;
        static final int w = 12;
        static final int x = 13;

        private static class Proxy implements IMediaControllerCallback {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f2262l;

            Proxy(IBinder iBinder) {
                this.f2262l = iBinder;
            }

            public void D0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    this.f2262l.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void F0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    _Parcel.f(obtain, mediaMetadataCompat, 0);
                    this.f2262l.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void M0(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    obtain.writeInt(i2);
                    this.f2262l.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Z() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    this.f2262l.transact(13, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void Z0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    _Parcel.f(obtain, playbackStateCompat, 0);
                    this.f2262l.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a0(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2262l.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2262l;
            }

            public void b1(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    _Parcel.f(obtain, parcelableVolumeInfo, 0);
                    this.f2262l.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void d0(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    _Parcel.e(obtain, list, 0);
                    this.f2262l.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String e() {
                return IMediaControllerCallback.f2258b;
            }

            public void s0(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2262l.transact(11, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void x(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    obtain.writeInt(i2);
                    this.f2262l.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void y(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2262l.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void y0(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2262l.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void z0(CharSequence charSequence) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaControllerCallback.f2258b);
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2262l.transact(6, obtain, (Parcel) null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, IMediaControllerCallback.f2258b);
        }

        public static IMediaControllerCallback e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMediaControllerCallback.f2258b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaControllerCallback)) ? new Proxy(iBinder) : (IMediaControllerCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface(IMediaControllerCallback.f2258b);
            }
            if (i2 == 1598968902) {
                parcel2.writeString(IMediaControllerCallback.f2258b);
                return true;
            }
            boolean z = false;
            switch (i2) {
                case 1:
                    y(parcel.readString(), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    D0();
                    break;
                case 3:
                    Z0((PlaybackStateCompat) _Parcel.d(parcel, PlaybackStateCompat.CREATOR));
                    break;
                case 4:
                    F0((MediaMetadataCompat) _Parcel.d(parcel, MediaMetadataCompat.CREATOR));
                    break;
                case 5:
                    d0(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    break;
                case 6:
                    z0((CharSequence) _Parcel.d(parcel, TextUtils.CHAR_SEQUENCE_CREATOR));
                    break;
                case 7:
                    a0((Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    break;
                case 8:
                    b1((ParcelableVolumeInfo) _Parcel.d(parcel, ParcelableVolumeInfo.CREATOR));
                    break;
                case 9:
                    x(parcel.readInt());
                    break;
                case 10:
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    y0(z);
                    break;
                case 11:
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    s0(z);
                    break;
                case 12:
                    M0(parcel.readInt());
                    break;
                case 13:
                    Z();
                    break;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i2) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                f(parcel, (Parcelable) list.get(i3), i2);
            }
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void f(Parcel parcel, T t, int i2) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i2);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void D0() throws RemoteException;

    void F0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void M0(int i2) throws RemoteException;

    void Z() throws RemoteException;

    void Z0(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void a0(Bundle bundle) throws RemoteException;

    void b1(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void d0(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void s0(boolean z) throws RemoteException;

    void x(int i2) throws RemoteException;

    void y(String str, Bundle bundle) throws RemoteException;

    void y0(boolean z) throws RemoteException;

    void z0(CharSequence charSequence) throws RemoteException;
}
