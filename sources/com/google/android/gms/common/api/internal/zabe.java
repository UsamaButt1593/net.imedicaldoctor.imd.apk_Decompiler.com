package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zabe extends GoogleApiClient implements zabz {
    final zadc A;
    private final zaj B;

    /* renamed from: e  reason: collision with root package name */
    private final Lock f20088e;

    /* renamed from: f  reason: collision with root package name */
    private final zak f20089f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private zaca f20090g = null;

    /* renamed from: h  reason: collision with root package name */
    private final int f20091h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Context f20092i;

    /* renamed from: j  reason: collision with root package name */
    private final Looper f20093j;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> f20094k = new LinkedList();

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f20095l;

    /* renamed from: m  reason: collision with root package name */
    private long f20096m;

    /* renamed from: n  reason: collision with root package name */
    private long f20097n;
    private final zabc o;
    private final GoogleApiAvailability p;
    @Nullable
    @VisibleForTesting
    zabx q;
    final Map<Api.AnyClientKey<?>, Api.Client> r;
    Set<Scope> s;
    final ClientSettings t;
    final Map<Api<?>, Boolean> u;
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> v;
    private final ListenerHolders w;
    private final ArrayList<zat> x;
    private Integer y;
    @Nullable
    Set<zada> z;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i2, int i3, ArrayList<zat> arrayList) {
        Looper looper2 = looper;
        int i4 = i2;
        this.f20096m = true != ClientLibraryUtils.c() ? 120000 : 10000;
        this.f20097n = 5000;
        this.s = new HashSet();
        this.w = new ListenerHolders();
        this.y = null;
        this.z = null;
        zaay zaay = new zaay(this);
        this.B = zaay;
        this.f20092i = context;
        this.f20088e = lock;
        this.f20089f = new zak(looper, zaay);
        this.f20093j = looper2;
        this.o = new zabc(this, looper);
        this.p = googleApiAvailability;
        this.f20091h = i4;
        if (i4 >= 0) {
            this.y = Integer.valueOf(i3);
        }
        this.u = map;
        this.r = map2;
        this.x = arrayList;
        this.A = new zadc();
        for (GoogleApiClient.ConnectionCallbacks f2 : list) {
            this.f20089f.f(f2);
        }
        for (GoogleApiClient.OnConnectionFailedListener g2 : list2) {
            this.f20089f.g(g2);
        }
        this.t = clientSettings;
        this.v = abstractClientBuilder;
    }

    public static int K(Iterable<Api.Client> iterable, boolean z2) {
        boolean z3 = false;
        boolean z4 = false;
        for (Api.Client next : iterable) {
            z3 |= next.w();
            z4 |= next.d();
        }
        if (z3) {
            return (!z4 || !z2) ? 1 : 2;
        }
        return 3;
    }

    static String N(int i2) {
        if (i2 == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i2 != 2) {
            return i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    static /* bridge */ /* synthetic */ void P(zabe zabe) {
        zabe.f20088e.lock();
        try {
            if (zabe.f20095l) {
                zabe.U();
            }
        } finally {
            zabe.f20088e.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void Q(zabe zabe) {
        zabe.f20088e.lock();
        try {
            if (zabe.R()) {
                zabe.U();
            }
        } finally {
            zabe.f20088e.unlock();
        }
    }

    /* JADX WARNING: type inference failed for: r13v11, types: [com.google.android.gms.common.api.internal.zaaa] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void S(int r13) {
        /*
            r12 = this;
            java.lang.Integer r0 = r12.y
            if (r0 != 0) goto L_0x000b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.y = r13
            goto L_0x0011
        L_0x000b:
            int r0 = r0.intValue()
            if (r0 != r13) goto L_0x0091
        L_0x0011:
            com.google.android.gms.common.api.internal.zaca r13 = r12.f20090g
            if (r13 == 0) goto L_0x0016
            return
        L_0x0016:
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r13 = r12.r
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
            r0 = 0
            r1 = 0
        L_0x0022:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r13.next()
            com.google.android.gms.common.api.Api$Client r2 = (com.google.android.gms.common.api.Api.Client) r2
            boolean r3 = r2.w()
            r0 = r0 | r3
            boolean r2 = r2.d()
            r1 = r1 | r2
            goto L_0x0022
        L_0x0039:
            java.lang.Integer r13 = r12.y
            int r13 = r13.intValue()
            r2 = 1
            if (r13 == r2) goto L_0x0062
            r1 = 2
            if (r13 == r1) goto L_0x0046
            goto L_0x0066
        L_0x0046:
            if (r0 == 0) goto L_0x0066
            android.content.Context r2 = r12.f20092i
            java.util.concurrent.locks.Lock r4 = r12.f20088e
            android.os.Looper r5 = r12.f20093j
            com.google.android.gms.common.GoogleApiAvailability r6 = r12.p
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r7 = r12.r
            com.google.android.gms.common.internal.ClientSettings r8 = r12.t
            java.util.Map<com.google.android.gms.common.api.Api<?>, java.lang.Boolean> r9 = r12.u
            com.google.android.gms.common.api.Api$AbstractClientBuilder<? extends com.google.android.gms.signin.zae, com.google.android.gms.signin.SignInOptions> r10 = r12.v
            java.util.ArrayList<com.google.android.gms.common.api.internal.zat> r11 = r12.x
            r3 = r12
            com.google.android.gms.common.api.internal.zaaa r13 = com.google.android.gms.common.api.internal.zaaa.t(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x005f:
            r12.f20090g = r13
            return
        L_0x0062:
            if (r0 == 0) goto L_0x0089
            if (r1 != 0) goto L_0x0081
        L_0x0066:
            com.google.android.gms.common.api.internal.zabi r13 = new com.google.android.gms.common.api.internal.zabi
            android.content.Context r1 = r12.f20092i
            java.util.concurrent.locks.Lock r3 = r12.f20088e
            android.os.Looper r4 = r12.f20093j
            com.google.android.gms.common.GoogleApiAvailability r5 = r12.p
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r6 = r12.r
            com.google.android.gms.common.internal.ClientSettings r7 = r12.t
            java.util.Map<com.google.android.gms.common.api.Api<?>, java.lang.Boolean> r8 = r12.u
            com.google.android.gms.common.api.Api$AbstractClientBuilder<? extends com.google.android.gms.signin.zae, com.google.android.gms.signin.SignInOptions> r9 = r12.v
            java.util.ArrayList<com.google.android.gms.common.api.internal.zat> r10 = r12.x
            r0 = r13
            r2 = r12
            r11 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x005f
        L_0x0081:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead."
            r13.<init>(r0)
            throw r13
        L_0x0089:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead."
            r13.<init>(r0)
            throw r13
        L_0x0091:
            java.lang.String r13 = N(r13)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.Integer r1 = r12.y
            int r1 = r1.intValue()
            java.lang.String r1 = N(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r3 = r13.length()
            int r3 = r3 + 51
            int r4 = r1.length()
            int r3 = r3 + r4
            r2.<init>(r3)
            java.lang.String r3 = "Cannot use sign-in mode: "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r13 = ". Mode was already set to "
            r2.append(r13)
            r2.append(r1)
            java.lang.String r13 = r2.toString()
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.S(int):void");
    }

    /* access modifiers changed from: private */
    public final void T(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z2) {
        Common.f20275d.a(googleApiClient).h(new zabb(this, statusPendingResult, z2, googleApiClient));
    }

    @GuardedBy("mLock")
    private final void U() {
        this.f20089f.b();
        ((zaca) Preconditions.r(this.f20090g)).g();
    }

    public final void A() {
        i();
        g();
    }

    public final void B(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f20089f.f(connectionCallbacks);
    }

    public final void C(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f20089f.g(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> D(@NonNull L l2) {
        this.f20088e.lock();
        try {
            return this.w.d(l2, this.f20093j, "NO_TYPE");
        } finally {
            this.f20088e.unlock();
        }
    }

    public final void E(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.f20091h >= 0) {
            zak.u(lifecycleActivity).w(this.f20091h);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void F(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f20089f.h(connectionCallbacks);
    }

    public final void G(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f20089f.i(onConnectionFailedListener);
    }

    public final void H(zada zada) {
        this.f20088e.lock();
        try {
            if (this.z == null) {
                this.z = new HashSet();
            }
            this.z.add(zada);
            this.f20088e.unlock();
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        if (r3 == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f20088e
            r0.lock()
            java.util.Set<com.google.android.gms.common.api.internal.zada> r0 = r2.z     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0018
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0016 }
            r3.<init>()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
        L_0x0012:
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x0049
        L_0x0016:
            r3 = move-exception
            goto L_0x0056
        L_0x0018:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0016 }
            if (r3 != 0) goto L_0x0026
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0016 }
            r3.<init>()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            goto L_0x0012
        L_0x0026:
            java.util.concurrent.locks.Lock r3 = r2.f20088e     // Catch:{ all -> 0x0016 }
            r3.lock()     // Catch:{ all -> 0x0016 }
            java.util.Set<com.google.android.gms.common.api.internal.zada> r3 = r2.z     // Catch:{ all -> 0x004f }
            if (r3 != 0) goto L_0x0035
            java.util.concurrent.locks.Lock r3 = r2.f20088e     // Catch:{ all -> 0x0016 }
            r3.unlock()     // Catch:{ all -> 0x0016 }
            goto L_0x0042
        L_0x0035:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x004f }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.f20088e     // Catch:{ all -> 0x0016 }
            r0.unlock()     // Catch:{ all -> 0x0016 }
            if (r3 != 0) goto L_0x0049
        L_0x0042:
            com.google.android.gms.common.api.internal.zaca r3 = r2.f20090g     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x0049
            r3.k()     // Catch:{ all -> 0x0016 }
        L_0x0049:
            java.util.concurrent.locks.Lock r3 = r2.f20088e
            r3.unlock()
            return
        L_0x004f:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.f20088e     // Catch:{ all -> 0x0016 }
            r0.unlock()     // Catch:{ all -> 0x0016 }
            throw r3     // Catch:{ all -> 0x0016 }
        L_0x0056:
            java.util.concurrent.locks.Lock r0 = r2.f20088e
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.I(com.google.android.gms.common.api.internal.zada):void");
    }

    /* access modifiers changed from: package-private */
    public final String M() {
        StringWriter stringWriter = new StringWriter();
        j("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("mLock")
    public final boolean R() {
        if (!this.f20095l) {
            return false;
        }
        this.f20095l = false;
        this.o.removeMessages(2);
        this.o.removeMessages(1);
        zabx zabx = this.q;
        if (zabx != null) {
            zabx.b();
            this.q = null;
        }
        return true;
    }

    @GuardedBy("mLock")
    public final void a(@Nullable Bundle bundle) {
        while (!this.f20094k.isEmpty()) {
            m(this.f20094k.remove());
        }
        this.f20089f.d(bundle);
    }

    @GuardedBy("mLock")
    public final void b(int i2, boolean z2) {
        if (i2 == 1) {
            if (!z2 && !this.f20095l) {
                this.f20095l = true;
                if (this.q == null && !ClientLibraryUtils.c()) {
                    try {
                        this.q = this.p.G(this.f20092i.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabc = this.o;
                zabc.sendMessageDelayed(zabc.obtainMessage(1), this.f20096m);
                zabc zabc2 = this.o;
                zabc2.sendMessageDelayed(zabc2.obtainMessage(2), this.f20097n);
            }
            i2 = 1;
        }
        for (BasePendingResult l2 : (BasePendingResult[]) this.A.f20157a.toArray(new BasePendingResult[0])) {
            l2.l(zadc.f20156c);
        }
        this.f20089f.e(i2);
        this.f20089f.a();
        if (i2 == 2) {
            U();
        }
    }

    @GuardedBy("mLock")
    public final void c(ConnectionResult connectionResult) {
        if (!this.p.l(this.f20092i, connectionResult.C())) {
            R();
        }
        if (!this.f20095l) {
            this.f20089f.c(connectionResult);
            this.f20089f.a();
        }
    }

    public final ConnectionResult d() {
        boolean z2 = true;
        Preconditions.y(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f20088e.lock();
        try {
            if (this.f20091h >= 0) {
                if (this.y == null) {
                    z2 = false;
                }
                Preconditions.y(z2, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.y;
                if (num == null) {
                    this.y = Integer.valueOf(K(this.r.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            S(((Integer) Preconditions.r(this.y)).intValue());
            this.f20089f.b();
            ConnectionResult c2 = ((zaca) Preconditions.r(this.f20090g)).c();
            this.f20088e.unlock();
            return c2;
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    public final ConnectionResult e(long j2, @NonNull TimeUnit timeUnit) {
        Preconditions.y(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.s(timeUnit, "TimeUnit must not be null");
        this.f20088e.lock();
        try {
            Integer num = this.y;
            if (num == null) {
                this.y = Integer.valueOf(K(this.r.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            S(((Integer) Preconditions.r(this.y)).intValue());
            this.f20089f.b();
            ConnectionResult f2 = ((zaca) Preconditions.r(this.f20090g)).f(j2, timeUnit);
            this.f20088e.unlock();
            return f2;
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    public final PendingResult<Status> f() {
        Preconditions.y(u(), "GoogleApiClient is not connected yet.");
        Integer num = this.y;
        boolean z2 = true;
        if (num != null && num.intValue() == 2) {
            z2 = false;
        }
        Preconditions.y(z2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.r.containsKey(Common.f20272a)) {
            T(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaaz = new zaaz(this, atomicReference, statusPendingResult);
            zaba zaba = new zaba(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.f20092i);
            builder.a(Common.f20273b);
            builder.e(zaaz);
            builder.f(zaba);
            builder.m(this.o);
            GoogleApiClient h2 = builder.h();
            atomicReference.set(h2);
            h2.g();
        }
        return statusPendingResult;
    }

    public final void g() {
        this.f20088e.lock();
        try {
            int i2 = 2;
            boolean z2 = false;
            if (this.f20091h >= 0) {
                Preconditions.y(this.y != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.y;
                if (num == null) {
                    this.y = Integer.valueOf(K(this.r.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.r(this.y)).intValue();
            this.f20088e.lock();
            if (intValue == 3 || intValue == 1) {
                i2 = intValue;
            } else if (intValue != 2) {
                i2 = intValue;
                StringBuilder sb = new StringBuilder(33);
                sb.append("Illegal sign-in mode: ");
                sb.append(i2);
                Preconditions.b(z2, sb.toString());
                S(i2);
                U();
                this.f20088e.unlock();
                this.f20088e.unlock();
            }
            z2 = true;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i2);
            Preconditions.b(z2, sb2.toString());
            S(i2);
            U();
            this.f20088e.unlock();
            this.f20088e.unlock();
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    public final void h(int i2) {
        this.f20088e.lock();
        boolean z2 = true;
        if (!(i2 == 3 || i2 == 1)) {
            if (i2 == 2) {
                i2 = 2;
            } else {
                z2 = false;
            }
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            Preconditions.b(z2, sb.toString());
            S(i2);
            U();
        } finally {
            this.f20088e.unlock();
        }
    }

    public final void i() {
        this.f20088e.lock();
        try {
            this.A.b();
            zaca zaca = this.f20090g;
            if (zaca != null) {
                zaca.m();
            }
            this.w.e();
            for (BaseImplementation.ApiMethodImpl next : this.f20094k) {
                next.v((zadb) null);
                next.f();
            }
            this.f20094k.clear();
            if (this.f20090g != null) {
                R();
                this.f20089f.a();
            }
            this.f20088e.unlock();
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    public final void j(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f20092i);
        printWriter.append(str).append("mResuming=").print(this.f20095l);
        printWriter.append(" mWorkQueue.size()=").print(this.f20094k.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.A.f20157a.size());
        zaca zaca = this.f20090g;
        if (zaca != null) {
            zaca.o(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t2) {
        Api<?> x2 = t2.x();
        boolean containsKey = this.r.containsKey(t2.y());
        String d2 = x2 != null ? x2.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d2);
        sb.append(" required for this call.");
        Preconditions.b(containsKey, sb.toString());
        this.f20088e.lock();
        try {
            zaca zaca = this.f20090g;
            if (zaca == null) {
                this.f20094k.add(t2);
            } else {
                t2 = zaca.h(t2);
            }
            return t2;
        } finally {
            this.f20088e.unlock();
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t2) {
        Api<?> x2 = t2.x();
        boolean containsKey = this.r.containsKey(t2.y());
        String d2 = x2 != null ? x2.d() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(d2);
        sb.append(" required for this call.");
        Preconditions.b(containsKey, sb.toString());
        this.f20088e.lock();
        try {
            zaca zaca = this.f20090g;
            if (zaca != null) {
                if (this.f20095l) {
                    this.f20094k.add(t2);
                    while (!this.f20094k.isEmpty()) {
                        BaseImplementation.ApiMethodImpl remove = this.f20094k.remove();
                        this.A.a(remove);
                        remove.a(Status.a3);
                    }
                } else {
                    t2 = zaca.j(t2);
                }
                return t2;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f20088e.unlock();
        }
    }

    @NonNull
    public final <C extends Api.Client> C o(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c2 = (Api.Client) this.r.get(anyClientKey);
        Preconditions.s(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @NonNull
    public final ConnectionResult p(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        this.f20088e.lock();
        try {
            if (!u()) {
                if (!this.f20095l) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.r.containsKey(api.b())) {
                ConnectionResult p2 = ((zaca) Preconditions.r(this.f20090g)).p(api);
                if (p2 == null) {
                    if (this.f20095l) {
                        connectionResult = ConnectionResult.w3;
                    } else {
                        Log.w("GoogleApiClientImpl", M());
                        Log.wtf("GoogleApiClientImpl", String.valueOf(api.d()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                        connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    }
                    this.f20088e.unlock();
                    return connectionResult;
                }
                this.f20088e.unlock();
                return p2;
            }
            throw new IllegalArgumentException(String.valueOf(api.d()).concat(" was never registered with GoogleApiClient"));
        } catch (Throwable th) {
            this.f20088e.unlock();
            throw th;
        }
    }

    public final Context q() {
        return this.f20092i;
    }

    public final Looper r() {
        return this.f20093j;
    }

    public final boolean s(@NonNull Api<?> api) {
        return this.r.containsKey(api.b());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r3 = r2.r.get(r3.b());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(@androidx.annotation.NonNull com.google.android.gms.common.api.Api<?> r3) {
        /*
            r2 = this;
            boolean r0 = r2.u()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r0 = r2.r
            com.google.android.gms.common.api.Api$AnyClientKey r3 = r3.b()
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.common.api.Api$Client r3 = (com.google.android.gms.common.api.Api.Client) r3
            if (r3 == 0) goto L_0x001e
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x001e
            r3 = 1
            return r3
        L_0x001e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.t(com.google.android.gms.common.api.Api):boolean");
    }

    public final boolean u() {
        zaca zaca = this.f20090g;
        return zaca != null && zaca.i();
    }

    public final boolean v() {
        zaca zaca = this.f20090g;
        return zaca != null && zaca.d();
    }

    public final boolean w(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f20089f.j(connectionCallbacks);
    }

    public final boolean x(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f20089f.k(onConnectionFailedListener);
    }

    public final boolean y(SignInConnectionListener signInConnectionListener) {
        zaca zaca = this.f20090g;
        return zaca != null && zaca.n(signInConnectionListener);
    }

    public final void z() {
        zaca zaca = this.f20090g;
        if (zaca != null) {
            zaca.l();
        }
    }
}
