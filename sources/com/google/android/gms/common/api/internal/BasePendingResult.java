package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zaq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> p = new zaq();
    public static final /* synthetic */ int q = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object f19984a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected final CallbackHandler<R> f19985b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    protected final WeakReference<GoogleApiClient> f19986c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f19987d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<PendingResult.StatusListener> f19988e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ResultCallback<? super R> f19989f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<zadb> f19990g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public R f19991h;

    /* renamed from: i  reason: collision with root package name */
    private Status f19992i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f19993j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19994k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19995l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ICancelToken f19996m;
    @KeepName
    private zas mResultGuardian;

    /* renamed from: n  reason: collision with root package name */
    private volatile zada<R> f19997n;
    private boolean o;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zaq {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }

        public final void a(@NonNull ResultCallback<? super R> resultCallback, @NonNull R r) {
            int i2 = BasePendingResult.q;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.r(resultCallback), r)));
        }

        public final void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.a(result);
                } catch (RuntimeException e2) {
                    BasePendingResult.t(result);
                    throw e2;
                }
            } else if (i2 != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).l(Status.b3);
            }
        }

        public CallbackHandler(@NonNull Looper looper) {
            super(looper);
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f19984a = new Object();
        this.f19987d = new CountDownLatch(1);
        this.f19988e = new ArrayList<>();
        this.f19990g = new AtomicReference<>();
        this.o = false;
        this.f19985b = new CallbackHandler<>(Looper.getMainLooper());
        this.f19986c = new WeakReference<>((Object) null);
    }

    private final R p() {
        R r;
        synchronized (this.f19984a) {
            Preconditions.y(!this.f19993j, "Result has already been consumed.");
            Preconditions.y(m(), "Result is not ready.");
            r = this.f19991h;
            this.f19991h = null;
            this.f19989f = null;
            this.f19993j = true;
        }
        zadb andSet = this.f19990g.getAndSet((Object) null);
        if (andSet != null) {
            andSet.f20155a.f20157a.remove(this);
        }
        return (Result) Preconditions.r(r);
    }

    private final void q(R r) {
        this.f19991h = r;
        this.f19992i = r.d();
        this.f19996m = null;
        this.f19987d.countDown();
        if (this.f19994k) {
            this.f19989f = null;
        } else {
            ResultCallback<? super R> resultCallback = this.f19989f;
            if (resultCallback != null) {
                this.f19985b.removeMessages(2);
                this.f19985b.a(resultCallback, p());
            } else if (this.f19991h instanceof Releasable) {
                this.mResultGuardian = new zas(this, (zar) null);
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f19988e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).a(this.f19992i);
        }
        this.f19988e.clear();
    }

    public static void t(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).a();
            } catch (RuntimeException e2) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e2);
            }
        }
    }

    public final void c(@NonNull PendingResult.StatusListener statusListener) {
        Preconditions.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.f19984a) {
            try {
                if (m()) {
                    statusListener.a(this.f19992i);
                } else {
                    this.f19988e.add(statusListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public final R d() {
        Preconditions.q("await must not be called on the UI thread");
        boolean z = true;
        Preconditions.y(!this.f19993j, "Result has already been consumed");
        if (this.f19997n != null) {
            z = false;
        }
        Preconditions.y(z, "Cannot await if then() has been called.");
        try {
            this.f19987d.await();
        } catch (InterruptedException unused) {
            l(Status.Z2);
        }
        Preconditions.y(m(), "Result is not ready.");
        return p();
    }

    @NonNull
    public final R e(long j2, @NonNull TimeUnit timeUnit) {
        if (j2 > 0) {
            Preconditions.q("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.y(!this.f19993j, "Result has already been consumed.");
        if (this.f19997n != null) {
            z = false;
        }
        Preconditions.y(z, "Cannot await if then() has been called.");
        try {
            if (!this.f19987d.await(j2, timeUnit)) {
                l(Status.b3);
            }
        } catch (InterruptedException unused) {
            l(Status.Z2);
        }
        Preconditions.y(m(), "Result is not ready.");
        return p();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|(2:10|11)|13|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0016 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f19984a
            monitor-enter(r0)
            boolean r1 = r2.f19994k     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0029
            boolean r1 = r2.f19993j     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0029
        L_0x000c:
            com.google.android.gms.common.internal.ICancelToken r1 = r2.f19996m     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0016
            r1.cancel()     // Catch:{ RemoteException -> 0x0016 }
            goto L_0x0016
        L_0x0014:
            r1 = move-exception
            goto L_0x002b
        L_0x0016:
            R r1 = r2.f19991h     // Catch:{ all -> 0x0014 }
            t(r1)     // Catch:{ all -> 0x0014 }
            r1 = 1
            r2.f19994k = r1     // Catch:{ all -> 0x0014 }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.c3     // Catch:{ all -> 0x0014 }
            com.google.android.gms.common.api.Result r1 = r2.k(r1)     // Catch:{ all -> 0x0014 }
            r2.q(r1)     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.f():void");
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f19984a) {
            z = this.f19994k;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(@androidx.annotation.Nullable com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f19984a
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000c
            r5 = 0
            r4.f19989f = r5     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r5 = move-exception
            goto L_0x003c
        L_0x000c:
            boolean r1 = r4.f19993j     // Catch:{ all -> 0x000a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.y(r1, r3)     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.zada<R> r1 = r4.f19997n     // Catch:{ all -> 0x000a }
            if (r1 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.y(r2, r1)     // Catch:{ all -> 0x000a }
            boolean r1 = r4.g()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0028
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x0028:
            boolean r1 = r4.m()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r1 = r4.f19985b     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.Result r2 = r4.p()     // Catch:{ all -> 0x000a }
            r1.a(r5, r2)     // Catch:{ all -> 0x000a }
            goto L_0x003a
        L_0x0038:
            r4.f19989f = r5     // Catch:{ all -> 0x000a }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.h(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(@androidx.annotation.NonNull com.google.android.gms.common.api.ResultCallback<? super R> r5, long r6, @androidx.annotation.NonNull java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f19984a
            monitor-enter(r0)
            if (r5 != 0) goto L_0x000c
            r5 = 0
            r4.f19989f = r5     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x000a:
            r5 = move-exception
            goto L_0x004a
        L_0x000c:
            boolean r1 = r4.f19993j     // Catch:{ all -> 0x000a }
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.y(r1, r3)     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.zada<R> r1 = r4.f19997n     // Catch:{ all -> 0x000a }
            if (r1 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.y(r2, r1)     // Catch:{ all -> 0x000a }
            boolean r1 = r4.g()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0028
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x0028:
            boolean r1 = r4.m()     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r6 = r4.f19985b     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.Result r7 = r4.p()     // Catch:{ all -> 0x000a }
            r6.a(r5, r7)     // Catch:{ all -> 0x000a }
            goto L_0x0048
        L_0x0038:
            r4.f19989f = r5     // Catch:{ all -> 0x000a }
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r5 = r4.f19985b     // Catch:{ all -> 0x000a }
            long r6 = r8.toMillis(r6)     // Catch:{ all -> 0x000a }
            r8 = 2
            android.os.Message r8 = r5.obtainMessage(r8, r4)     // Catch:{ all -> 0x000a }
            r5.sendMessageDelayed(r8, r6)     // Catch:{ all -> 0x000a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.i(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    @NonNull
    public final <S extends Result> TransformedResult<S> j(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> c2;
        Preconditions.y(!this.f19993j, "Result has already been consumed.");
        synchronized (this.f19984a) {
            try {
                boolean z = false;
                Preconditions.y(this.f19997n == null, "Cannot call then() twice.");
                if (this.f19989f == null) {
                    z = true;
                }
                Preconditions.y(z, "Cannot call then() if callbacks are set.");
                Preconditions.y(!this.f19994k, "Cannot call then() if result was canceled.");
                this.o = true;
                this.f19997n = new zada<>(this.f19986c);
                c2 = this.f19997n.c(resultTransform);
                if (m()) {
                    this.f19985b.a(this.f19997n, p());
                } else {
                    this.f19989f = this.f19997n;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract R k(@NonNull Status status);

    @KeepForSdk
    @Deprecated
    public final void l(@NonNull Status status) {
        synchronized (this.f19984a) {
            try {
                if (!m()) {
                    o(k(status));
                    this.f19995l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public final boolean m() {
        return this.f19987d.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void n(@NonNull ICancelToken iCancelToken) {
        synchronized (this.f19984a) {
            this.f19996m = iCancelToken;
        }
    }

    @KeepForSdk
    public final void o(@NonNull R r) {
        synchronized (this.f19984a) {
            try {
                if (this.f19995l || this.f19994k) {
                    t(r);
                    return;
                }
                m();
                Preconditions.y(!m(), "Results have already been set");
                Preconditions.y(!this.f19993j, "Result has already been consumed");
                q(r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s() {
        boolean z = true;
        if (!this.o && !p.get().booleanValue()) {
            z = false;
        }
        this.o = z;
    }

    public final boolean u() {
        boolean g2;
        synchronized (this.f19984a) {
            try {
                if (this.f19986c.get() != null) {
                    if (!this.o) {
                    }
                    g2 = g();
                }
                f();
                g2 = g();
            } catch (Throwable th) {
                throw th;
            }
        }
        return g2;
    }

    public final void v(@Nullable zadb zadb) {
        this.f19990g.set(zadb);
    }

    @KeepForSdk
    @Deprecated
    protected BasePendingResult(@NonNull Looper looper) {
        this.f19984a = new Object();
        this.f19987d = new CountDownLatch(1);
        this.f19988e = new ArrayList<>();
        this.f19990g = new AtomicReference<>();
        this.o = false;
        this.f19985b = new CallbackHandler<>(looper);
        this.f19986c = new WeakReference<>((Object) null);
    }

    @KeepForSdk
    protected BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.f19984a = new Object();
        this.f19987d = new CountDownLatch(1);
        this.f19988e = new ArrayList<>();
        this.f19990g = new AtomicReference<>();
        this.o = false;
        this.f19985b = new CallbackHandler<>(googleApiClient != null ? googleApiClient.r() : Looper.getMainLooper());
        this.f19986c = new WeakReference<>(googleApiClient);
    }

    @KeepForSdk
    @VisibleForTesting
    protected BasePendingResult(@NonNull CallbackHandler<R> callbackHandler) {
        this.f19984a = new Object();
        this.f19987d = new CountDownLatch(1);
        this.f19988e = new ArrayList<>();
        this.f19990g = new AtomicReference<>();
        this.o = false;
        this.f19985b = (CallbackHandler) Preconditions.s(callbackHandler, "CallbackHandler must not be null");
        this.f19986c = new WeakReference<>((Object) null);
    }
}
