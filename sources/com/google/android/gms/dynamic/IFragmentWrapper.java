package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.common.zzb;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @NonNull
        public static IFragmentWrapper e(@NonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0079, code lost:
            r3.writeNoException();
            r2 = com.google.android.gms.internal.common.zzc.zza;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
            r3.writeInt(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
            r3.writeNoException();
            com.google.android.gms.internal.common.zzc.zze(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
            r3.writeNoException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
            r3.writeNoException();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean zza(int r1, @androidx.annotation.NonNull android.os.Parcel r2, @androidx.annotation.NonNull android.os.Parcel r3, int r4) throws android.os.RemoteException {
            /*
                r0 = this;
                switch(r1) {
                    case 2: goto L_0x00e8;
                    case 3: goto L_0x00dd;
                    case 4: goto L_0x00d8;
                    case 5: goto L_0x00d3;
                    case 6: goto L_0x00ce;
                    case 7: goto L_0x00c9;
                    case 8: goto L_0x00be;
                    case 9: goto L_0x00b9;
                    case 10: goto L_0x00b1;
                    case 11: goto L_0x00ac;
                    case 12: goto L_0x00a1;
                    case 13: goto L_0x009c;
                    case 14: goto L_0x0097;
                    case 15: goto L_0x0092;
                    case 16: goto L_0x008d;
                    case 17: goto L_0x0088;
                    case 18: goto L_0x0083;
                    case 19: goto L_0x0075;
                    case 20: goto L_0x0066;
                    case 21: goto L_0x005b;
                    case 22: goto L_0x0050;
                    case 23: goto L_0x0045;
                    case 24: goto L_0x003a;
                    case 25: goto L_0x002b;
                    case 26: goto L_0x0018;
                    case 27: goto L_0x0005;
                    default: goto L_0x0003;
                }
            L_0x0003:
                r1 = 0
                return r1
            L_0x0005:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.e(r1)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.J0(r1)
            L_0x0013:
                r3.writeNoException()
                goto L_0x00ed
            L_0x0018:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzc.zza(r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                int r4 = r2.readInt()
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.l0(r1, r4)
                goto L_0x0013
            L_0x002b:
                android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
                android.os.Parcelable r1 = com.google.android.gms.internal.common.zzc.zza(r2, r1)
                android.content.Intent r1 = (android.content.Intent) r1
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.h0(r1)
                goto L_0x0013
            L_0x003a:
                boolean r1 = com.google.android.gms.internal.common.zzc.zzf(r2)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.W0(r1)
                goto L_0x0013
            L_0x0045:
                boolean r1 = com.google.android.gms.internal.common.zzc.zzf(r2)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.b0(r1)
                goto L_0x0013
            L_0x0050:
                boolean r1 = com.google.android.gms.internal.common.zzc.zzf(r2)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.E(r1)
                goto L_0x0013
            L_0x005b:
                boolean r1 = com.google.android.gms.internal.common.zzc.zzf(r2)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.B(r1)
                goto L_0x0013
            L_0x0066:
                android.os.IBinder r1 = r2.readStrongBinder()
                com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.e(r1)
                com.google.android.gms.internal.common.zzc.zzb(r2)
                r0.H0(r1)
                goto L_0x0013
            L_0x0075:
                boolean r1 = r0.a1()
            L_0x0079:
                r3.writeNoException()
                int r2 = com.google.android.gms.internal.common.zzc.zza
            L_0x007e:
                r3.writeInt(r1)
                goto L_0x00ed
            L_0x0083:
                boolean r1 = r0.V()
                goto L_0x0079
            L_0x0088:
                boolean r1 = r0.C()
                goto L_0x0079
            L_0x008d:
                boolean r1 = r0.v0()
                goto L_0x0079
            L_0x0092:
                boolean r1 = r0.k0()
                goto L_0x0079
            L_0x0097:
                boolean r1 = r0.L0()
                goto L_0x0079
            L_0x009c:
                boolean r1 = r0.I0()
                goto L_0x0079
            L_0x00a1:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.a()
            L_0x00a5:
                r3.writeNoException()
                com.google.android.gms.internal.common.zzc.zze(r3, r1)
                goto L_0x00ed
            L_0x00ac:
                boolean r1 = r0.c1()
                goto L_0x0079
            L_0x00b1:
                int r1 = r0.b()
            L_0x00b5:
                r3.writeNoException()
                goto L_0x007e
            L_0x00b9:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.n0()
                goto L_0x00a5
            L_0x00be:
                java.lang.String r1 = r0.Q0()
                r3.writeNoException()
                r3.writeString(r1)
                goto L_0x00ed
            L_0x00c9:
                boolean r1 = r0.U0()
                goto L_0x0079
            L_0x00ce:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.D()
                goto L_0x00a5
            L_0x00d3:
                com.google.android.gms.dynamic.IFragmentWrapper r1 = r0.O0()
                goto L_0x00a5
            L_0x00d8:
                int r1 = r0.g()
                goto L_0x00b5
            L_0x00dd:
                android.os.Bundle r1 = r0.d()
                r3.writeNoException()
                com.google.android.gms.internal.common.zzc.zzd(r3, r1)
                goto L_0x00ed
            L_0x00e8:
                com.google.android.gms.dynamic.IObjectWrapper r1 = r0.c()
                goto L_0x00a5
            L_0x00ed:
                r1 = 1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.IFragmentWrapper.Stub.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void B(boolean z) throws RemoteException;

    boolean C() throws RemoteException;

    @NonNull
    IObjectWrapper D() throws RemoteException;

    void E(boolean z) throws RemoteException;

    void H0(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean I0() throws RemoteException;

    void J0(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean L0() throws RemoteException;

    @Nullable
    IFragmentWrapper O0() throws RemoteException;

    @Nullable
    String Q0() throws RemoteException;

    boolean U0() throws RemoteException;

    boolean V() throws RemoteException;

    void W0(boolean z) throws RemoteException;

    @NonNull
    IObjectWrapper a() throws RemoteException;

    boolean a1() throws RemoteException;

    int b() throws RemoteException;

    void b0(boolean z) throws RemoteException;

    @NonNull
    IObjectWrapper c() throws RemoteException;

    boolean c1() throws RemoteException;

    @Nullable
    Bundle d() throws RemoteException;

    int g() throws RemoteException;

    void h0(@NonNull Intent intent) throws RemoteException;

    boolean k0() throws RemoteException;

    void l0(@NonNull Intent intent, int i2) throws RemoteException;

    @Nullable
    IFragmentWrapper n0() throws RemoteException;

    boolean v0() throws RemoteException;
}
