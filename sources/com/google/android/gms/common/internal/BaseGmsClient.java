package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {
    @NonNull
    @KeepForSdk
    public static final String A3 = "<<default account>>";
    @NonNull
    @KeepForSdk
    public static final String[] B3 = {"service_esmobile", "service_googleme"};
    private static final Feature[] C3 = new Feature[0];
    @KeepForSdk
    public static final int w3 = 1;
    @KeepForSdk
    public static final int x3 = 4;
    @KeepForSdk
    public static final int y3 = 5;
    @NonNull
    @KeepForSdk
    public static final String z3 = "pendingIntent";
    private long X;
    private long X2;
    private long Y;
    @Nullable
    private volatile String Y2;
    private int Z;
    @VisibleForTesting
    zzv Z2;
    private final Context a3;
    private final Looper b3;
    private final GmsClientSupervisor c3;
    private final GoogleApiAvailabilityLight d3;
    final Handler e3;
    private final Object f3;
    /* access modifiers changed from: private */
    public final Object g3;
    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("serviceBrokerLock")
    public IGmsServiceBroker h3;
    @VisibleForTesting
    @NonNull
    protected ConnectionProgressReportCallbacks i3;
    @Nullable
    @GuardedBy("lock")
    private IInterface j3;
    /* access modifiers changed from: private */
    public final ArrayList k3;
    @Nullable
    @GuardedBy("lock")
    private zze l3;
    @GuardedBy("lock")
    private int m3;
    /* access modifiers changed from: private */
    @Nullable
    public final BaseConnectionCallbacks n3;
    /* access modifiers changed from: private */
    @Nullable
    public final BaseOnConnectionFailedListener o3;
    private final int p3;
    @Nullable
    private final String q3;
    @Nullable
    private volatile String r3;
    private int s;
    /* access modifiers changed from: private */
    @Nullable
    public ConnectionResult s3;
    /* access modifiers changed from: private */
    public boolean t3;
    @Nullable
    private volatile zzk u3;
    @VisibleForTesting
    @NonNull
    protected AtomicInteger v3;

    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final int f20217a = 1;
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public static final int f20218b = 3;

        @KeepForSdk
        void e(int i2);

        @KeepForSdk
        void z(@Nullable Bundle bundle);
    }

    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void f(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void a(@NonNull ConnectionResult connectionResult);
    }

    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        public final void a(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.O()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.f((IAccountAccessor) null, baseGmsClient.L());
            } else if (BaseGmsClient.this.o3 != null) {
                BaseGmsClient.this.o3.f(connectionResult);
            }
        }
    }

    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void a();
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(@NonNull Context context, @NonNull Handler handler, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.Y2 = null;
        this.f3 = new Object();
        this.g3 = new Object();
        this.k3 = new ArrayList();
        this.m3 = 1;
        this.s3 = null;
        this.t3 = false;
        this.u3 = null;
        this.v3 = new AtomicInteger(0);
        Preconditions.s(context, "Context must not be null");
        this.a3 = context;
        Preconditions.s(handler, "Handler must not be null");
        this.e3 = handler;
        this.b3 = handler.getLooper();
        Preconditions.s(gmsClientSupervisor, "Supervisor must not be null");
        this.c3 = gmsClientSupervisor;
        Preconditions.s(googleApiAvailabilityLight, "API availability must not be null");
        this.d3 = googleApiAvailabilityLight;
        this.p3 = i2;
        this.n3 = baseConnectionCallbacks;
        this.o3 = baseOnConnectionFailedListener;
        this.q3 = null;
    }

    static /* bridge */ /* synthetic */ void k0(BaseGmsClient baseGmsClient, zzk zzk) {
        baseGmsClient.u3 = zzk;
        if (baseGmsClient.a0()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzk.Z;
            RootTelemetryConfigManager.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.P());
        }
    }

    static /* bridge */ /* synthetic */ void l0(BaseGmsClient baseGmsClient, int i2) {
        int i4;
        int i5;
        synchronized (baseGmsClient.f3) {
            i4 = baseGmsClient.m3;
        }
        if (i4 == 3) {
            baseGmsClient.t3 = true;
            i5 = 5;
        } else {
            i5 = 4;
        }
        Handler handler = baseGmsClient.e3;
        handler.sendMessage(handler.obtainMessage(i5, baseGmsClient.v3.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean o0(BaseGmsClient baseGmsClient, int i2, int i4, IInterface iInterface) {
        synchronized (baseGmsClient.f3) {
            try {
                if (baseGmsClient.m3 != i2) {
                    return false;
                }
                baseGmsClient.q0(i4, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean p0(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.t3 || TextUtils.isEmpty(baseGmsClient.N()) || TextUtils.isEmpty(baseGmsClient.J())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.N());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void q0(int i2, @Nullable IInterface iInterface) {
        zzv zzv;
        boolean z = false;
        if ((i2 == 4) == (iInterface != null)) {
            z = true;
        }
        Preconditions.a(z);
        synchronized (this.f3) {
            try {
                this.m3 = i2;
                this.j3 = iInterface;
                if (i2 == 1) {
                    zze zze = this.l3;
                    if (zze != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.c3;
                        String b2 = this.Z2.b();
                        Preconditions.r(b2);
                        gmsClientSupervisor.m(b2, this.Z2.a(), 4225, zze, f0(), this.Z2.c());
                        this.l3 = null;
                    }
                } else if (i2 == 2 || i2 == 3) {
                    zze zze2 = this.l3;
                    if (!(zze2 == null || (zzv = this.Z2) == null)) {
                        String b4 = zzv.b();
                        String a2 = zzv.a();
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + b4 + " on " + a2);
                        GmsClientSupervisor gmsClientSupervisor2 = this.c3;
                        String b5 = this.Z2.b();
                        Preconditions.r(b5);
                        gmsClientSupervisor2.m(b5, this.Z2.a(), 4225, zze2, f0(), this.Z2.c());
                        this.v3.incrementAndGet();
                    }
                    zze zze3 = new zze(this, this.v3.get());
                    this.l3 = zze3;
                    zzv zzv2 = (this.m3 != 3 || J() == null) ? new zzv(P(), O(), false, 4225, R()) : new zzv(G().getPackageName(), J(), true, 4225, false);
                    this.Z2 = zzv2;
                    if (zzv2.c()) {
                        if (r() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.Z2.b())));
                        }
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.c3;
                    String b6 = this.Z2.b();
                    Preconditions.r(b6);
                    if (!gmsClientSupervisor3.n(new zzo(b6, this.Z2.a(), 4225, this.Z2.c()), zze3, f0(), E())) {
                        String b7 = this.Z2.b();
                        String a4 = this.Z2.a();
                        Log.w("GmsClient", "unable to connect to service: " + b7 + " on " + a4);
                        m0(16, (Bundle) null, this.v3.get());
                    }
                } else if (i2 == 4) {
                    Preconditions.r(iInterface);
                    T(iInterface);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public abstract T A(@NonNull IBinder iBinder);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean B() {
        return false;
    }

    @KeepForSdk
    @Nullable
    public Account C() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public Feature[] D() {
        return C3;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public Executor E() {
        return null;
    }

    @KeepForSdk
    @Nullable
    public Bundle F() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final Context G() {
        return this.a3;
    }

    @KeepForSdk
    public int H() {
        return this.p3;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public Bundle I() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public String J() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final Looper K() {
        return this.b3;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public Set<Scope> L() {
        return Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public final T M() throws DeadObjectException {
        T t;
        synchronized (this.f3) {
            try {
                if (this.m3 != 5) {
                    z();
                    t = this.j3;
                    Preconditions.s(t, "Client is connected but service is null");
                } else {
                    throw new DeadObjectException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String N();

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String O();

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String P() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    @Nullable
    public ConnectionTelemetryConfiguration Q() {
        zzk zzk = this.u3;
        if (zzk == null) {
            return null;
        }
        return zzk.Z;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean R() {
        return r() >= 211700000;
    }

    @KeepForSdk
    public boolean S() {
        return this.u3 != null;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void T(@NonNull T t) {
        this.Y = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void U(@NonNull ConnectionResult connectionResult) {
        this.Z = connectionResult.C();
        this.X2 = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void V(int i2) {
        this.s = i2;
        this.X = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void W(int i2, @Nullable IBinder iBinder, @Nullable Bundle bundle, int i4) {
        this.e3.sendMessage(this.e3.obtainMessage(1, i4, -1, new zzf(this, i2, iBinder, bundle)));
    }

    @KeepForSdk
    public void X(@NonNull String str) {
        this.r3 = str;
    }

    @KeepForSdk
    public void Y(int i2) {
        this.e3.sendMessage(this.e3.obtainMessage(6, this.v3.get(), i2));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    @KeepForSdk
    public void Z(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i2, @Nullable PendingIntent pendingIntent) {
        Preconditions.s(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.i3 = connectionProgressReportCallbacks;
        this.e3.sendMessage(this.e3.obtainMessage(3, this.v3.get(), i2, pendingIntent));
    }

    @KeepForSdk
    public boolean a() {
        return false;
    }

    @KeepForSdk
    public boolean a0() {
        return false;
    }

    @KeepForSdk
    public boolean d() {
        return false;
    }

    @WorkerThread
    @KeepForSdk
    public void f(@Nullable IAccountAccessor iAccountAccessor, @NonNull Set<Scope> set) {
        Set<Scope> set2 = set;
        Bundle I = I();
        String str = this.r3;
        int i2 = GoogleApiAvailabilityLight.f19873a;
        Scope[] scopeArr = GetServiceRequest.h3;
        Bundle bundle = new Bundle();
        int i4 = this.p3;
        Feature[] featureArr = GetServiceRequest.i3;
        GetServiceRequest getServiceRequest = r3;
        GetServiceRequest getServiceRequest2 = new GetServiceRequest(6, i4, i2, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, featureArr, featureArr, true, 0, false, str);
        GetServiceRequest getServiceRequest3 = getServiceRequest;
        getServiceRequest3.Z = this.a3.getPackageName();
        getServiceRequest3.Z2 = I;
        if (set2 != null) {
            getServiceRequest3.Y2 = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (w()) {
            Account C = C();
            if (C == null) {
                C = new Account("<<default account>>", AccountType.f20215a);
            }
            getServiceRequest3.a3 = C;
            if (iAccountAccessor != null) {
                getServiceRequest3.X2 = iAccountAccessor.asBinder();
            }
        } else if (a()) {
            getServiceRequest3.a3 = C();
        }
        getServiceRequest3.b3 = C3;
        getServiceRequest3.c3 = D();
        if (a0()) {
            getServiceRequest3.f3 = true;
        }
        try {
            synchronized (this.g3) {
                IGmsServiceBroker iGmsServiceBroker = this.h3;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.X(new zzd(this, this.v3.get()), getServiceRequest3);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Y(3);
        } catch (SecurityException e4) {
            throw e4;
        } catch (RemoteException | RuntimeException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            W(8, (IBinder) null, (Bundle) null, this.v3.get());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String f0() {
        String str = this.q3;
        return str == null ? this.a3.getClass().getName() : str;
    }

    @KeepForSdk
    public void g(@NonNull String str) {
        this.Y2 = str;
        l();
    }

    @KeepForSdk
    public boolean h() {
        boolean z;
        synchronized (this.f3) {
            int i2 = this.m3;
            z = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    z = false;
                }
            }
        }
        return z;
    }

    @NonNull
    @KeepForSdk
    public String i() {
        zzv zzv;
        if (j() && (zzv = this.Z2) != null) {
            return zzv.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public boolean j() {
        boolean z;
        synchronized (this.f3) {
            z = this.m3 == 4;
        }
        return z;
    }

    @KeepForSdk
    public void k(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.s(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.i3 = connectionProgressReportCallbacks;
        q0(2, (IInterface) null);
    }

    @KeepForSdk
    public void l() {
        this.v3.incrementAndGet();
        synchronized (this.k3) {
            try {
                int size = this.k3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((zzc) this.k3.get(i2)).d();
                }
                this.k3.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        synchronized (this.g3) {
            this.h3 = null;
        }
        q0(1, (IInterface) null);
    }

    @KeepForSdk
    public void m(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.a();
    }

    /* access modifiers changed from: protected */
    public final void m0(int i2, @Nullable Bundle bundle, int i4) {
        this.e3.sendMessage(this.e3.obtainMessage(7, i4, -1, new zzg(this, i2, (Bundle) null)));
    }

    @KeepForSdk
    public void o(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        int i2;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.f3) {
            i2 = this.m3;
            iInterface = this.j3;
        }
        synchronized (this.g3) {
            iGmsServiceBroker = this.h3;
        }
        printWriter.append(str).append("mConnectState=");
        printWriter.print(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append(N()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.Y > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j2 = this.Y;
            String format = simpleDateFormat.format(new Date(j2));
            append.println(j2 + StringUtils.SPACE + format);
        }
        if (this.X > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i4 = this.s;
            printWriter.append(i4 != 1 ? i4 != 2 ? i4 != 3 ? String.valueOf(i4) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED");
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j4 = this.X;
            String format2 = simpleDateFormat.format(new Date(j4));
            append2.println(j4 + StringUtils.SPACE + format2);
        }
        if (this.X2 > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.a(this.Z));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j5 = this.X2;
            String format3 = simpleDateFormat.format(new Date(j5));
            append3.println(j5 + StringUtils.SPACE + format3);
        }
    }

    @KeepForSdk
    public boolean p() {
        return true;
    }

    @KeepForSdk
    public int r() {
        return GoogleApiAvailabilityLight.f19873a;
    }

    @KeepForSdk
    @Nullable
    public final Feature[] s() {
        zzk zzk = this.u3;
        if (zzk == null) {
            return null;
        }
        return zzk.X;
    }

    @KeepForSdk
    @Nullable
    public String u() {
        return this.Y2;
    }

    @NonNull
    @KeepForSdk
    public Intent v() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    public boolean w() {
        return false;
    }

    @KeepForSdk
    @Nullable
    public IBinder x() {
        synchronized (this.g3) {
            try {
                IGmsServiceBroker iGmsServiceBroker = this.h3;
                if (iGmsServiceBroker == null) {
                    return null;
                }
                IBinder asBinder = iGmsServiceBroker.asBinder();
                return asBinder;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public void y() {
        int k2 = this.d3.k(this.a3, r());
        if (k2 != 0) {
            q0(1, (IInterface) null);
            Z(new LegacyClientCallbackAdapter(), k2, (PendingIntent) null);
            return;
        }
        k(new LegacyClientCallbackAdapter());
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void z() {
        if (!j()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected BaseGmsClient(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull android.os.Looper r11, int r12, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks r13, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener r14, @androidx.annotation.Nullable java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.GmsClientSupervisor r3 = com.google.android.gms.common.internal.GmsClientSupervisor.e(r10)
            com.google.android.gms.common.GoogleApiAvailabilityLight r4 = com.google.android.gms.common.GoogleApiAvailabilityLight.i()
            com.google.android.gms.common.internal.Preconditions.r(r13)
            com.google.android.gms.common.internal.Preconditions.r(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks, com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener, java.lang.String):void");
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.Y2 = null;
        this.f3 = new Object();
        this.g3 = new Object();
        this.k3 = new ArrayList();
        this.m3 = 1;
        this.s3 = null;
        this.t3 = false;
        this.u3 = null;
        this.v3 = new AtomicInteger(0);
        Preconditions.s(context, "Context must not be null");
        this.a3 = context;
        Preconditions.s(looper, "Looper must not be null");
        this.b3 = looper;
        Preconditions.s(gmsClientSupervisor, "Supervisor must not be null");
        this.c3 = gmsClientSupervisor;
        Preconditions.s(googleApiAvailabilityLight, "API availability must not be null");
        this.d3 = googleApiAvailabilityLight;
        this.e3 = new zzb(this, looper);
        this.p3 = i2;
        this.n3 = baseConnectionCallbacks;
        this.o3 = baseOnConnectionFailedListener;
        this.q3 = str;
    }
}
