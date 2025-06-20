package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String D = "Request";
    private static final String E = "Glide";
    private static final boolean F = Log.isLoggable(D, 2);
    @GuardedBy("requestLock")
    private int A;
    @GuardedBy("requestLock")
    private boolean B;
    @Nullable
    private RuntimeException C;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f18451a;

    /* renamed from: b  reason: collision with root package name */
    private final StateVerifier f18452b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f18453c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final RequestListener<R> f18454d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f18455e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f18456f;

    /* renamed from: g  reason: collision with root package name */
    private final GlideContext f18457g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Object f18458h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f18459i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseRequestOptions<?> f18460j;

    /* renamed from: k  reason: collision with root package name */
    private final int f18461k;

    /* renamed from: l  reason: collision with root package name */
    private final int f18462l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f18463m;

    /* renamed from: n  reason: collision with root package name */
    private final Target<R> f18464n;
    @Nullable
    private final List<RequestListener<R>> o;
    private final TransitionFactory<? super R> p;
    private final Executor q;
    @GuardedBy("requestLock")
    private Resource<R> r;
    @GuardedBy("requestLock")
    private Engine.LoadStatus s;
    @GuardedBy("requestLock")
    private long t;
    private volatile Engine u;
    @GuardedBy("requestLock")
    private Status v;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable w;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable x;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable y;
    @GuardedBy("requestLock")
    private int z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.f18451a = F ? String.valueOf(super.hashCode()) : null;
        this.f18452b = StateVerifier.a();
        this.f18453c = obj;
        this.f18456f = context;
        this.f18457g = glideContext;
        this.f18458h = obj2;
        this.f18459i = cls;
        this.f18460j = baseRequestOptions;
        this.f18461k = i2;
        this.f18462l = i3;
        this.f18463m = priority;
        this.f18464n = target;
        this.f18454d = requestListener;
        this.o = list;
        this.f18455e = requestCoordinator;
        this.u = engine;
        this.p = transitionFactory;
        this.q = executor;
        this.v = Status.PENDING;
        if (this.C == null && glideContext.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void A() {
        if (l()) {
            Drawable p2 = this.f18458h == null ? p() : null;
            if (p2 == null) {
                p2 = o();
            }
            if (p2 == null) {
                p2 = q();
            }
            this.f18464n.k(p2);
        }
    }

    @GuardedBy("requestLock")
    private void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.f18455e;
        return requestCoordinator == null || requestCoordinator.k(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f18455e;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.f18455e;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    @GuardedBy("requestLock")
    private void n() {
        i();
        this.f18452b.c();
        this.f18464n.c(this);
        Engine.LoadStatus loadStatus = this.s;
        if (loadStatus != null) {
            loadStatus.a();
            this.s = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable o() {
        if (this.w == null) {
            Drawable L = this.f18460j.L();
            this.w = L;
            if (L == null && this.f18460j.K() > 0) {
                this.w = s(this.f18460j.K());
            }
        }
        return this.w;
    }

    @GuardedBy("requestLock")
    private Drawable p() {
        if (this.y == null) {
            Drawable M = this.f18460j.M();
            this.y = M;
            if (M == null && this.f18460j.Q() > 0) {
                this.y = s(this.f18460j.Q());
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    private Drawable q() {
        if (this.x == null) {
            Drawable Y = this.f18460j.Y();
            this.x = Y;
            if (Y == null && this.f18460j.b0() > 0) {
                this.x = s(this.f18460j.b0());
            }
        }
        return this.x;
    }

    @GuardedBy("requestLock")
    private boolean r() {
        RequestCoordinator requestCoordinator = this.f18455e;
        return requestCoordinator == null || !requestCoordinator.i().b();
    }

    @GuardedBy("requestLock")
    private Drawable s(@DrawableRes int i2) {
        return DrawableDecoderCompat.a(this.f18457g, i2, this.f18460j.k0() != null ? this.f18460j.k0() : this.f18456f.getTheme());
    }

    private void t(String str) {
        Log.v(D, str + " this: " + this.f18451a);
    }

    private static int u(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    @GuardedBy("requestLock")
    private void v() {
        RequestCoordinator requestCoordinator = this.f18455e;
        if (requestCoordinator != null) {
            requestCoordinator.a(this);
        }
    }

    @GuardedBy("requestLock")
    private void w() {
        RequestCoordinator requestCoordinator = this.f18455e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public static <R> SingleRequest<R> x(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i2, int i3, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i2, i3, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void y(GlideException glideException, int i2) {
        boolean z2;
        this.f18452b.c();
        synchronized (this.f18453c) {
            try {
                glideException.l(this.C);
                int g2 = this.f18457g.g();
                if (g2 <= i2) {
                    Log.w(E, "Load failed for " + this.f18458h + " with size [" + this.z + "x" + this.A + "]", glideException);
                    if (g2 <= 4) {
                        glideException.h(E);
                    }
                }
                this.s = null;
                this.v = Status.FAILED;
                boolean z3 = true;
                this.B = true;
                List<RequestListener<R>> list = this.o;
                if (list != null) {
                    z2 = false;
                    for (RequestListener<R> f2 : list) {
                        z2 |= f2.f(glideException, this.f18458h, this.f18464n, r());
                    }
                } else {
                    z2 = false;
                }
                RequestListener<R> requestListener = this.f18454d;
                if (requestListener == null || !requestListener.f(glideException, this.f18458h, this.f18464n, r())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    A();
                }
                this.B = false;
                v();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9 A[Catch:{ all -> 0x0090 }] */
    @androidx.annotation.GuardedBy("requestLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.r()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.v = r0
            r10.r = r11
            com.bumptech.glide.GlideContext r11 = r10.f18457g
            int r11 = r11.g()
            r0 = 3
            if (r11 > r0) goto L_0x006a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Finished loading "
            r11.append(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f18458h
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.z
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.t
            double r0 = com.bumptech.glide.util.LogTime.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r11)
        L_0x006a:
            r11 = 1
            r10.B = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.o     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0092
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x0090 }
            r9 = 0
        L_0x0077:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0093
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x0090 }
            java.lang.Object r2 = r10.f18458h     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f18464n     // Catch:{ all -> 0x0090 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.g(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0090 }
            r9 = r9 | r0
            goto L_0x0077
        L_0x0090:
            r11 = move-exception
            goto L_0x00ba
        L_0x0092:
            r9 = 0
        L_0x0093:
            com.bumptech.glide.request.RequestListener<R> r0 = r10.f18454d     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x00a5
            java.lang.Object r2 = r10.f18458h     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.f18464n     // Catch:{ all -> 0x0090 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.g(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r11 = 0
        L_0x00a6:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b4
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r11 = r10.p     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.request.transition.Transition r11 = r11.a(r13, r6)     // Catch:{ all -> 0x0090 }
            com.bumptech.glide.request.target.Target<R> r13 = r10.f18464n     // Catch:{ all -> 0x0090 }
            r13.e(r12, r11)     // Catch:{ all -> 0x0090 }
        L_0x00b4:
            r10.B = r7
            r10.w()
            return
        L_0x00ba:
            r10.B = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.z(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }

    public void a(GlideException glideException) {
        y(glideException, 5);
    }

    public boolean b() {
        boolean z2;
        synchronized (this.f18453c) {
            z2 = this.v == Status.COMPLETE;
        }
        return z2;
    }

    public void c(Resource<?> resource, DataSource dataSource) {
        this.f18452b.c();
        Resource<?> resource2 = null;
        try {
            synchronized (this.f18453c) {
                try {
                    this.s = null;
                    if (resource == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f18459i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    if (obj != null) {
                        if (this.f18459i.isAssignableFrom(obj.getClass())) {
                            if (!m()) {
                                try {
                                    this.r = null;
                                    this.v = Status.COMPLETE;
                                    this.u.l(resource);
                                    return;
                                } catch (Throwable th) {
                                    resource2 = resource;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                z(resource, obj, dataSource);
                                return;
                            }
                        }
                    }
                    this.r = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.f18459i);
                    sb.append(" but instead got ");
                    sb.append(obj != null ? obj.getClass() : "");
                    sb.append("{");
                    sb.append(obj);
                    sb.append("} inside Resource{");
                    sb.append(resource);
                    sb.append("}.");
                    sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    a(new GlideException(sb.toString()));
                    this.u.l(resource);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.u.l(resource2);
            }
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        r5.u.l(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f18453c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f18452b     // Catch:{ all -> 0x0013 }
            r1.c()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.v     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0013 }
            if (r1 != r2) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x003b
        L_0x0015:
            r5.n()     // Catch:{ all -> 0x0013 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.r     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r1 == 0) goto L_0x0020
            r5.r = r3     // Catch:{ all -> 0x0013 }
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            boolean r3 = r5.k()     // Catch:{ all -> 0x0013 }
            if (r3 == 0) goto L_0x0030
            com.bumptech.glide.request.target.Target<R> r3 = r5.f18464n     // Catch:{ all -> 0x0013 }
            android.graphics.drawable.Drawable r4 = r5.q()     // Catch:{ all -> 0x0013 }
            r3.r(r4)     // Catch:{ all -> 0x0013 }
        L_0x0030:
            r5.v = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            if (r1 == 0) goto L_0x003a
            com.bumptech.glide.load.engine.Engine r0 = r5.u
            r0.l(r1)
        L_0x003a:
            return
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public boolean d(Request request) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f18453c) {
            try {
                i2 = this.f18461k;
                i3 = this.f18462l;
                obj = this.f18458h;
                cls = this.f18459i;
                baseRequestOptions = this.f18460j;
                priority = this.f18463m;
                List<RequestListener<R>> list = this.o;
                size = list != null ? list.size() : 0;
            } finally {
                while (true) {
                }
            }
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.f18453c) {
            try {
                i4 = singleRequest.f18461k;
                i5 = singleRequest.f18462l;
                obj2 = singleRequest.f18458h;
                cls2 = singleRequest.f18459i;
                baseRequestOptions2 = singleRequest.f18460j;
                priority2 = singleRequest.f18463m;
                List<RequestListener<R>> list2 = singleRequest.o;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return i2 == i4 && i3 == i5 && Util.c(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    public void e(int i2, int i3) {
        Object obj;
        this.f18452b.c();
        Object obj2 = this.f18453c;
        synchronized (obj2) {
            try {
                boolean z2 = F;
                if (z2) {
                    t("Got onSizeReady in " + LogTime.a(this.t));
                }
                if (this.v == Status.WAITING_FOR_SIZE) {
                    Status status = Status.RUNNING;
                    this.v = status;
                    float h0 = this.f18460j.h0();
                    this.z = u(i2, h0);
                    this.A = u(i3, h0);
                    if (z2) {
                        t("finished setup for calling load in " + LogTime.a(this.t));
                    }
                    Status status2 = status;
                    boolean z3 = z2;
                    Status status3 = status2;
                    obj = obj2;
                    try {
                        this.s = this.u.g(this.f18457g, this.f18458h, this.f18460j.g0(), this.z, this.A, this.f18460j.f0(), this.f18459i, this.f18463m, this.f18460j.J(), this.f18460j.l0(), this.f18460j.D0(), this.f18460j.v0(), this.f18460j.U(), this.f18460j.t0(), this.f18460j.o0(), this.f18460j.n0(), this.f18460j.S(), this, this.q);
                        if (this.v != status3) {
                            this.s = null;
                        }
                        if (z3) {
                            t("finished onSizeReady in " + LogTime.a(this.t));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public boolean f() {
        boolean z2;
        synchronized (this.f18453c) {
            z2 = this.v == Status.CLEARED;
        }
        return z2;
    }

    public Object g() {
        this.f18452b.c();
        return this.f18453c;
    }

    public void h() {
        synchronized (this.f18453c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isComplete() {
        boolean z2;
        synchronized (this.f18453c) {
            z2 = this.v == Status.COMPLETE;
        }
        return z2;
    }

    public boolean isRunning() {
        boolean z2;
        synchronized (this.f18453c) {
            try {
                Status status = this.v;
                if (status != Status.RUNNING) {
                    if (status != Status.WAITING_FOR_SIZE) {
                        z2 = false;
                    }
                }
                z2 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f18453c
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.f18452b     // Catch:{ all -> 0x0028 }
            r1.c()     // Catch:{ all -> 0x0028 }
            long r1 = com.bumptech.glide.util.LogTime.b()     // Catch:{ all -> 0x0028 }
            r5.t = r1     // Catch:{ all -> 0x0028 }
            java.lang.Object r1 = r5.f18458h     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0040
            int r1 = r5.f18461k     // Catch:{ all -> 0x0028 }
            int r2 = r5.f18462l     // Catch:{ all -> 0x0028 }
            boolean r1 = com.bumptech.glide.util.Util.v(r1, r2)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x002b
            int r1 = r5.f18461k     // Catch:{ all -> 0x0028 }
            r5.z = r1     // Catch:{ all -> 0x0028 }
            int r1 = r5.f18462l     // Catch:{ all -> 0x0028 }
            r5.A = r1     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r1 = move-exception
            goto L_0x00ab
        L_0x002b:
            android.graphics.drawable.Drawable r1 = r5.p()     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0033
            r1 = 5
            goto L_0x0034
        L_0x0033:
            r1 = 3
        L_0x0034:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x0028 }
            r5.y(r2, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0040:
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.v     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x0028 }
            if (r1 == r2) goto L_0x00a3
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x0028 }
            if (r1 != r3) goto L_0x0053
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.r     // Catch:{ all -> 0x0028 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x0028 }
            r5.c(r1, r2)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0053:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x0028 }
            r5.v = r1     // Catch:{ all -> 0x0028 }
            int r3 = r5.f18461k     // Catch:{ all -> 0x0028 }
            int r4 = r5.f18462l     // Catch:{ all -> 0x0028 }
            boolean r3 = com.bumptech.glide.util.Util.v(r3, r4)     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x0069
            int r3 = r5.f18461k     // Catch:{ all -> 0x0028 }
            int r4 = r5.f18462l     // Catch:{ all -> 0x0028 }
            r5.e(r3, r4)     // Catch:{ all -> 0x0028 }
            goto L_0x006e
        L_0x0069:
            com.bumptech.glide.request.target.Target<R> r3 = r5.f18464n     // Catch:{ all -> 0x0028 }
            r3.s(r5)     // Catch:{ all -> 0x0028 }
        L_0x006e:
            com.bumptech.glide.request.SingleRequest$Status r3 = r5.v     // Catch:{ all -> 0x0028 }
            if (r3 == r2) goto L_0x0074
            if (r3 != r1) goto L_0x0083
        L_0x0074:
            boolean r1 = r5.l()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0083
            com.bumptech.glide.request.target.Target<R> r1 = r5.f18464n     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r2 = r5.q()     // Catch:{ all -> 0x0028 }
            r1.p(r2)     // Catch:{ all -> 0x0028 }
        L_0x0083:
            boolean r1 = F     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x00a1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r1.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            long r2 = r5.t     // Catch:{ all -> 0x0028 }
            double r2 = com.bumptech.glide.util.LogTime.a(r2)     // Catch:{ all -> 0x0028 }
            r1.append(r2)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0028 }
            r5.t(r1)     // Catch:{ all -> 0x0028 }
        L_0x00a1:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x00a3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x0028 }
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x00ab:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.j():void");
    }
}
