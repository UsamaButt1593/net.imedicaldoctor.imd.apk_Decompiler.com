package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.s})
public interface IMediaSession extends IInterface {

    /* renamed from: c  reason: collision with root package name */
    public static final String f2263c = "android.support.v4.media.session.IMediaSession";

    public static class Default implements IMediaSession {
        public void A0(int i2, int i3, String str) throws RemoteException {
        }

        public void C0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        }

        public void E0(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException {
        }

        public void G(long j2) throws RemoteException {
        }

        public void H(boolean z) throws RemoteException {
        }

        public int I() throws RemoteException {
            return 0;
        }

        public boolean J() throws RemoteException {
            return false;
        }

        public List<MediaSessionCompat.QueueItem> K() throws RemoteException {
            return null;
        }

        public void K0(int i2) throws RemoteException {
        }

        public void L(int i2) throws RemoteException {
        }

        public void M(String str, Bundle bundle) throws RemoteException {
        }

        public void N(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
        }

        public void N0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
        }

        public boolean O() throws RemoteException {
            return false;
        }

        public void P(RatingCompat ratingCompat) throws RemoteException {
        }

        public void P0() throws RemoteException {
        }

        public void Q(int i2, int i3, String str) throws RemoteException {
        }

        public void R(Uri uri, Bundle bundle) throws RemoteException {
        }

        public boolean S() throws RemoteException {
            return false;
        }

        public void S0(long j2) throws RemoteException {
        }

        public void T0(boolean z) throws RemoteException {
        }

        public PendingIntent U() throws RemoteException {
            return null;
        }

        public ParcelableVolumeInfo V0() throws RemoteException {
            return null;
        }

        public void W(String str, Bundle bundle) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }

        public Bundle getExtras() throws RemoteException {
            return null;
        }

        public void h() throws RemoteException {
        }

        public PlaybackStateCompat i() throws RemoteException {
            return null;
        }

        public void i0(String str, Bundle bundle) throws RemoteException {
        }

        public long j() throws RemoteException {
            return 0;
        }

        public void j0(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
        }

        public void k() throws RemoteException {
        }

        public MediaMetadataCompat l() throws RemoteException {
            return null;
        }

        public void m(float f2) throws RemoteException {
        }

        public void m0(String str, Bundle bundle) throws RemoteException {
        }

        public String n() throws RemoteException {
            return null;
        }

        public void next() throws RemoteException {
        }

        public void o() throws RemoteException {
        }

        public void o0(String str, Bundle bundle) throws RemoteException {
        }

        public void p(int i2) throws RemoteException {
        }

        public void p0() throws RemoteException {
        }

        public void previous() throws RemoteException {
        }

        public int q() throws RemoteException {
            return 0;
        }

        public String r() throws RemoteException {
            return null;
        }

        public void r0(Uri uri, Bundle bundle) throws RemoteException {
        }

        public void s(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }

        public void stop() throws RemoteException {
        }

        public void t(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }

        public int u() throws RemoteException {
            return 0;
        }

        public CharSequence v() throws RemoteException {
            return null;
        }

        public Bundle w() throws RemoteException {
            return null;
        }

        public boolean x0(KeyEvent keyEvent) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IMediaSession {
        static final int A = 30;
        static final int B = 31;
        static final int C = 32;
        static final int D = 45;
        static final int E = 37;
        static final int F = 38;
        static final int G = 47;
        static final int H = 41;
        static final int I = 42;
        static final int J = 43;
        static final int K = 44;
        static final int L = 50;
        static final int M = 33;
        static final int N = 34;
        static final int O = 35;
        static final int P = 36;
        static final int Q = 13;
        static final int R = 14;
        static final int S = 15;
        static final int T = 16;
        static final int U = 17;
        static final int V = 18;
        static final int W = 19;
        static final int X = 20;
        static final int Y = 21;
        static final int Z = 22;
        static final int a0 = 23;
        static final int b0 = 24;
        static final int c0 = 25;
        static final int d0 = 51;
        static final int e0 = 49;
        static final int f0 = 46;
        static final int g0 = 39;
        static final int h0 = 40;
        static final int i0 = 48;
        static final int j0 = 26;

        /* renamed from: l  reason: collision with root package name */
        static final int f2264l = 1;

        /* renamed from: m  reason: collision with root package name */
        static final int f2265m = 2;

        /* renamed from: n  reason: collision with root package name */
        static final int f2266n = 3;
        static final int o = 4;
        static final int p = 5;
        static final int q = 6;
        static final int r = 7;
        static final int s = 8;
        static final int t = 9;
        static final int u = 10;
        static final int v = 11;
        static final int w = 12;
        static final int x = 27;
        static final int y = 28;
        static final int z = 29;

        private static class Proxy implements IMediaSession {

            /* renamed from: l  reason: collision with root package name */
            private IBinder f2267l;

            Proxy(IBinder iBinder) {
                this.f2267l = iBinder;
            }

            public void A0(int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.f2267l.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void C0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, ratingCompat, 0);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void E0(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, mediaDescriptionCompat, 0);
                    obtain.writeInt(i2);
                    this.f2267l.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void G(long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeLong(j2);
                    this.f2267l.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void H(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2267l.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int I() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean J() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    boolean z = false;
                    this.f2267l.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<MediaSessionCompat.QueueItem> K() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void K0(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(i2);
                    this.f2267l.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void L(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(i2);
                    this.f2267l.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void M(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void N(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeStrongInterface(iMediaControllerCallback);
                    this.f2267l.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void N0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    _Parcel.f(obtain, resultReceiverWrapper, 0);
                    this.f2267l.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean O() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    boolean z = false;
                    this.f2267l.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void P(RatingCompat ratingCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, ratingCompat, 0);
                    this.f2267l.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void P0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void Q(int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.f2267l.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void R(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, uri, 0);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean S() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    boolean z = false;
                    this.f2267l.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void S0(long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeLong(j2);
                    this.f2267l.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void T0(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2267l.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PendingIntent U() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return (PendingIntent) _Parcel.d(obtain2, PendingIntent.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelableVolumeInfo V0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ParcelableVolumeInfo) _Parcel.d(obtain2, ParcelableVolumeInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void W(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2267l;
            }

            public String e() {
                return IMediaSession.f2263c;
            }

            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.d(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PlaybackStateCompat i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return (PlaybackStateCompat) _Parcel.d(obtain2, PlaybackStateCompat.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void i0(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void j0(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeStrongInterface(iMediaControllerCallback);
                    this.f2267l.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public MediaMetadataCompat l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return (MediaMetadataCompat) _Parcel.d(obtain2, MediaMetadataCompat.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m(float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeFloat(f2);
                    this.f2267l.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m0(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void next() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void o0(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeString(str);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void p(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    obtain.writeInt(i2);
                    this.f2267l.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void p0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void previous() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void r0(Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, uri, 0);
                    _Parcel.f(obtain, bundle, 0);
                    this.f2267l.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void s(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, mediaDescriptionCompat, 0);
                    this.f2267l.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void t(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    _Parcel.f(obtain, mediaDescriptionCompat, 0);
                    this.f2267l.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int u() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CharSequence v() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return (CharSequence) _Parcel.d(obtain2, TextUtils.CHAR_SEQUENCE_CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    this.f2267l.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.d(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean x0(KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMediaSession.f2263c);
                    boolean z = false;
                    _Parcel.f(obtain, keyEvent, 0);
                    this.f2267l.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMediaSession.f2263c);
        }

        public static IMediaSession e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMediaSession.f2263c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaSession)) ? new Proxy(iBinder) : (IMediaSession) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            r6.writeNoException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
            r6.writeNoException();
            android.support.v4.media.session.IMediaSession._Parcel.b(r6, r4, 1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
            r6.writeNoException();
            r6.writeInt(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f9, code lost:
            r6.writeNoException();
            r6.writeString(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x024c, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                java.lang.String r0 = "android.support.v4.media.session.IMediaSession"
                r1 = 1
                if (r4 < r1) goto L_0x000d
                r2 = 16777215(0xffffff, float:2.3509886E-38)
                if (r4 > r2) goto L_0x000d
                r5.enforceInterface(r0)
            L_0x000d:
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r4 != r2) goto L_0x0016
                r6.writeString(r0)
                return r1
            L_0x0016:
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x0233;
                    case 2: goto L_0x0225;
                    case 3: goto L_0x0218;
                    case 4: goto L_0x020b;
                    case 5: goto L_0x0205;
                    case 6: goto L_0x0200;
                    case 7: goto L_0x01f5;
                    case 8: goto L_0x01ef;
                    case 9: goto L_0x01e4;
                    case 10: goto L_0x01de;
                    case 11: goto L_0x01cd;
                    case 12: goto L_0x01bc;
                    case 13: goto L_0x01b7;
                    case 14: goto L_0x01a6;
                    case 15: goto L_0x0195;
                    case 16: goto L_0x0180;
                    case 17: goto L_0x0177;
                    case 18: goto L_0x0172;
                    case 19: goto L_0x016d;
                    case 20: goto L_0x0168;
                    case 21: goto L_0x0163;
                    case 22: goto L_0x015e;
                    case 23: goto L_0x0159;
                    case 24: goto L_0x0150;
                    case 25: goto L_0x0143;
                    case 26: goto L_0x0132;
                    case 27: goto L_0x012c;
                    case 28: goto L_0x0126;
                    case 29: goto L_0x011a;
                    case 30: goto L_0x0104;
                    case 31: goto L_0x00fe;
                    case 32: goto L_0x00f8;
                    case 33: goto L_0x00f3;
                    case 34: goto L_0x00e2;
                    case 35: goto L_0x00d1;
                    case 36: goto L_0x00bc;
                    case 37: goto L_0x00b7;
                    case 38: goto L_0x00b2;
                    case 39: goto L_0x00aa;
                    case 40: goto L_0x009f;
                    case 41: goto L_0x0093;
                    case 42: goto L_0x0083;
                    case 43: goto L_0x0077;
                    case 44: goto L_0x006f;
                    case 45: goto L_0x006a;
                    case 46: goto L_0x005f;
                    case 47: goto L_0x0053;
                    case 48: goto L_0x004b;
                    case 49: goto L_0x0043;
                    case 50: goto L_0x0037;
                    case 51: goto L_0x001f;
                    default: goto L_0x001a;
                }
            L_0x001a:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x001f:
                android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r4 = android.support.v4.media.RatingCompat.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.support.v4.media.RatingCompat r4 = (android.support.v4.media.RatingCompat) r4
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.C0(r4, r5)
            L_0x0032:
                r6.writeNoException()
                goto L_0x024c
            L_0x0037:
                android.os.Bundle r4 = r3.w()
            L_0x003b:
                r6.writeNoException()
                android.support.v4.media.session.IMediaSession._Parcel.f(r6, r4, r1)
                goto L_0x024c
            L_0x0043:
                float r4 = r5.readFloat()
                r3.m(r4)
                goto L_0x0032
            L_0x004b:
                int r4 = r5.readInt()
                r3.L(r4)
                goto L_0x0032
            L_0x0053:
                int r4 = r3.I()
            L_0x0057:
                r6.writeNoException()
                r6.writeInt(r4)
                goto L_0x024c
            L_0x005f:
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0066
                r0 = 1
            L_0x0066:
                r3.H(r0)
                goto L_0x0032
            L_0x006a:
                boolean r4 = r3.J()
                goto L_0x0057
            L_0x006f:
                int r4 = r5.readInt()
                r3.K0(r4)
                goto L_0x0032
            L_0x0077:
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.support.v4.media.MediaDescriptionCompat r4 = (android.support.v4.media.MediaDescriptionCompat) r4
                r3.s(r4)
                goto L_0x0032
            L_0x0083:
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.support.v4.media.MediaDescriptionCompat r4 = (android.support.v4.media.MediaDescriptionCompat) r4
                int r5 = r5.readInt()
                r3.E0(r4, r5)
                goto L_0x0032
            L_0x0093:
                android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r4 = android.support.v4.media.MediaDescriptionCompat.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.support.v4.media.MediaDescriptionCompat r4 = (android.support.v4.media.MediaDescriptionCompat) r4
                r3.t(r4)
                goto L_0x0032
            L_0x009f:
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00a6
                r0 = 1
            L_0x00a6:
                r3.T0(r0)
                goto L_0x0032
            L_0x00aa:
                int r4 = r5.readInt()
                r3.p(r4)
                goto L_0x0032
            L_0x00b2:
                boolean r4 = r3.O()
                goto L_0x0057
            L_0x00b7:
                int r4 = r3.q()
                goto L_0x0057
            L_0x00bc:
                android.os.Parcelable$Creator r4 = android.net.Uri.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.net.Uri r4 = (android.net.Uri) r4
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.R(r4, r5)
                goto L_0x0032
            L_0x00d1:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.W(r4, r5)
                goto L_0x0032
            L_0x00e2:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.i0(r4, r5)
                goto L_0x0032
            L_0x00f3:
                r3.k()
                goto L_0x0032
            L_0x00f8:
                int r4 = r3.u()
                goto L_0x0057
            L_0x00fe:
                android.os.Bundle r4 = r3.getExtras()
                goto L_0x003b
            L_0x0104:
                java.lang.CharSequence r4 = r3.v()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0115
                r6.writeInt(r1)
                android.text.TextUtils.writeToParcel(r4, r6, r1)
                goto L_0x024c
            L_0x0115:
                r6.writeInt(r0)
                goto L_0x024c
            L_0x011a:
                java.util.List r4 = r3.K()
                r6.writeNoException()
                android.support.v4.media.session.IMediaSession._Parcel.e(r6, r4, r1)
                goto L_0x024c
            L_0x0126:
                android.support.v4.media.session.PlaybackStateCompat r4 = r3.i()
                goto L_0x003b
            L_0x012c:
                android.support.v4.media.MediaMetadataCompat r4 = r3.l()
                goto L_0x003b
            L_0x0132:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.M(r4, r5)
                goto L_0x0032
            L_0x0143:
                android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r4 = android.support.v4.media.RatingCompat.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.support.v4.media.RatingCompat r4 = (android.support.v4.media.RatingCompat) r4
                r3.P(r4)
                goto L_0x0032
            L_0x0150:
                long r4 = r5.readLong()
                r3.G(r4)
                goto L_0x0032
            L_0x0159:
                r3.P0()
                goto L_0x0032
            L_0x015e:
                r3.p0()
                goto L_0x0032
            L_0x0163:
                r3.previous()
                goto L_0x0032
            L_0x0168:
                r3.next()
                goto L_0x0032
            L_0x016d:
                r3.stop()
                goto L_0x0032
            L_0x0172:
                r3.h()
                goto L_0x0032
            L_0x0177:
                long r4 = r5.readLong()
                r3.S0(r4)
                goto L_0x0032
            L_0x0180:
                android.os.Parcelable$Creator r4 = android.net.Uri.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.net.Uri r4 = (android.net.Uri) r4
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.r0(r4, r5)
                goto L_0x0032
            L_0x0195:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.o0(r4, r5)
                goto L_0x0032
            L_0x01a6:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r5 = (android.os.Bundle) r5
                r3.m0(r4, r5)
                goto L_0x0032
            L_0x01b7:
                r3.o()
                goto L_0x0032
            L_0x01bc:
                int r4 = r5.readInt()
                int r7 = r5.readInt()
                java.lang.String r5 = r5.readString()
                r3.Q(r4, r7, r5)
                goto L_0x0032
            L_0x01cd:
                int r4 = r5.readInt()
                int r7 = r5.readInt()
                java.lang.String r5 = r5.readString()
                r3.A0(r4, r7, r5)
                goto L_0x0032
            L_0x01de:
                android.support.v4.media.session.ParcelableVolumeInfo r4 = r3.V0()
                goto L_0x003b
            L_0x01e4:
                long r4 = r3.j()
                r6.writeNoException()
                r6.writeLong(r4)
                goto L_0x024c
            L_0x01ef:
                android.app.PendingIntent r4 = r3.U()
                goto L_0x003b
            L_0x01f5:
                java.lang.String r4 = r3.n()
            L_0x01f9:
                r6.writeNoException()
                r6.writeString(r4)
                goto L_0x024c
            L_0x0200:
                java.lang.String r4 = r3.r()
                goto L_0x01f9
            L_0x0205:
                boolean r4 = r3.S()
                goto L_0x0057
            L_0x020b:
                android.os.IBinder r4 = r5.readStrongBinder()
                android.support.v4.media.session.IMediaControllerCallback r4 = android.support.v4.media.session.IMediaControllerCallback.Stub.e(r4)
                r3.j0(r4)
                goto L_0x0032
            L_0x0218:
                android.os.IBinder r4 = r5.readStrongBinder()
                android.support.v4.media.session.IMediaControllerCallback r4 = android.support.v4.media.session.IMediaControllerCallback.Stub.e(r4)
                r3.N(r4)
                goto L_0x0032
            L_0x0225:
                android.os.Parcelable$Creator r4 = android.view.KeyEvent.CREATOR
                java.lang.Object r4 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r4)
                android.view.KeyEvent r4 = (android.view.KeyEvent) r4
                boolean r4 = r3.x0(r4)
                goto L_0x0057
            L_0x0233:
                java.lang.String r4 = r5.readString()
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r7 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r7)
                android.os.Bundle r7 = (android.os.Bundle) r7
                android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper> r0 = android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.CREATOR
                java.lang.Object r5 = android.support.v4.media.session.IMediaSession._Parcel.d(r5, r0)
                android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper r5 = (android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper) r5
                r3.N0(r4, r7, r5)
                goto L_0x0032
            L_0x024c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.IMediaSession.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
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

    void A0(int i2, int i3, String str) throws RemoteException;

    void C0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void E0(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException;

    void G(long j2) throws RemoteException;

    void H(boolean z) throws RemoteException;

    int I() throws RemoteException;

    boolean J() throws RemoteException;

    List<MediaSessionCompat.QueueItem> K() throws RemoteException;

    void K0(int i2) throws RemoteException;

    void L(int i2) throws RemoteException;

    void M(String str, Bundle bundle) throws RemoteException;

    void N(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void N0(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    boolean O() throws RemoteException;

    void P(RatingCompat ratingCompat) throws RemoteException;

    void P0() throws RemoteException;

    void Q(int i2, int i3, String str) throws RemoteException;

    void R(Uri uri, Bundle bundle) throws RemoteException;

    boolean S() throws RemoteException;

    void S0(long j2) throws RemoteException;

    void T0(boolean z) throws RemoteException;

    PendingIntent U() throws RemoteException;

    ParcelableVolumeInfo V0() throws RemoteException;

    void W(String str, Bundle bundle) throws RemoteException;

    Bundle getExtras() throws RemoteException;

    void h() throws RemoteException;

    PlaybackStateCompat i() throws RemoteException;

    void i0(String str, Bundle bundle) throws RemoteException;

    long j() throws RemoteException;

    void j0(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void k() throws RemoteException;

    MediaMetadataCompat l() throws RemoteException;

    void m(float f2) throws RemoteException;

    void m0(String str, Bundle bundle) throws RemoteException;

    String n() throws RemoteException;

    void next() throws RemoteException;

    void o() throws RemoteException;

    void o0(String str, Bundle bundle) throws RemoteException;

    void p(int i2) throws RemoteException;

    void p0() throws RemoteException;

    void previous() throws RemoteException;

    int q() throws RemoteException;

    String r() throws RemoteException;

    void r0(Uri uri, Bundle bundle) throws RemoteException;

    void s(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void stop() throws RemoteException;

    void t(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    int u() throws RemoteException;

    CharSequence v() throws RemoteException;

    Bundle w() throws RemoteException;

    boolean x0(KeyEvent keyEvent) throws RemoteException;
}
