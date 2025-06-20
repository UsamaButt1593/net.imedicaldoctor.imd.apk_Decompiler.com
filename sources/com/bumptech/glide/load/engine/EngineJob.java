package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory r3 = new EngineResourceFactory();
    private final StateVerifier X;
    private final EngineResourceFactory X2;
    private final EngineResource.ResourceListener Y;
    private final EngineJobListener Y2;
    private final Pools.Pool<EngineJob<?>> Z;
    private final GlideExecutor Z2;
    private final GlideExecutor a3;
    private final GlideExecutor b3;
    private final GlideExecutor c3;
    private final AtomicInteger d3;
    private Key e3;
    private boolean f3;
    private boolean g3;
    private boolean h3;
    private boolean i3;
    private Resource<?> j3;
    DataSource k3;
    private boolean l3;
    GlideException m3;
    private boolean n3;
    EngineResource<?> o3;
    private DecodeJob<R> p3;
    private volatile boolean q3;
    final ResourceCallbacksAndExecutors s;

    private class CallLoadFailed implements Runnable {
        private final ResourceCallback s;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.s = resourceCallback;
        }

        public void run() {
            synchronized (this.s.g()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.s.c(this.s)) {
                            EngineJob.this.f(this.s);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    private class CallResourceReady implements Runnable {
        private final ResourceCallback s;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.s = resourceCallback;
        }

        public void run() {
            synchronized (this.s.g()) {
                synchronized (EngineJob.this) {
                    try {
                        if (EngineJob.this.s.c(this.s)) {
                            EngineJob.this.o3.b();
                            EngineJob.this.g(this.s);
                            EngineJob.this.s(this.s);
                        }
                        EngineJob.this.i();
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    @VisibleForTesting
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> a(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource(resource, z, true, key, resourceListener);
        }
    }

    static final class ResourceCallbackAndExecutor {

        /* renamed from: a  reason: collision with root package name */
        final ResourceCallback f17940a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f17941b;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.f17940a = resourceCallback;
            this.f17941b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.f17940a.equals(((ResourceCallbackAndExecutor) obj).f17940a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17940a.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> s;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        private static ResourceCallbackAndExecutor g(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.a());
        }

        /* access modifiers changed from: package-private */
        public void b(ResourceCallback resourceCallback, Executor executor) {
            this.s.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        /* access modifiers changed from: package-private */
        public boolean c(ResourceCallback resourceCallback) {
            return this.s.contains(g(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.s.clear();
        }

        /* access modifiers changed from: package-private */
        public ResourceCallbacksAndExecutors d() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.s));
        }

        /* access modifiers changed from: package-private */
        public void h(ResourceCallback resourceCallback) {
            this.s.remove(g(resourceCallback));
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.s.iterator();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.s.size();
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.s = list;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, r3);
    }

    private GlideExecutor j() {
        if (this.g3) {
            return this.b3;
        }
        return this.h3 ? this.c3 : this.a3;
    }

    private boolean n() {
        return this.n3 || this.l3 || this.q3;
    }

    private synchronized void r() {
        if (this.e3 != null) {
            this.s.clear();
            this.e3 = null;
            this.o3 = null;
            this.j3 = null;
            this.n3 = false;
            this.q3 = false;
            this.l3 = false;
            this.p3.y(false);
            this.p3 = null;
            this.m3 = null;
            this.k3 = null;
            this.Z.c(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(GlideException glideException) {
        synchronized (this) {
            this.m3 = glideException;
        }
        o();
    }

    @NonNull
    public StateVerifier b() {
        return this.X;
    }

    public void c(Resource<R> resource, DataSource dataSource) {
        synchronized (this) {
            this.j3 = resource;
            this.k3 = dataSource;
        }
        p();
    }

    public void d(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    /* access modifiers changed from: package-private */
    public synchronized void e(ResourceCallback resourceCallback, Executor executor) {
        Runnable callLoadFailed;
        try {
            this.X.c();
            this.s.b(resourceCallback, executor);
            if (this.l3) {
                k(1);
                callLoadFailed = new CallResourceReady(resourceCallback);
            } else if (this.n3) {
                k(1);
                callLoadFailed = new CallLoadFailed(resourceCallback);
            } else {
                Preconditions.a(!this.q3, "Cannot add callbacks to a cancelled EngineJob");
            }
            executor.execute(callLoadFailed);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    public void f(ResourceCallback resourceCallback) {
        try {
            resourceCallback.a(this.m3);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("this")
    public void g(ResourceCallback resourceCallback) {
        try {
            resourceCallback.c(this.o3, this.k3);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (!n()) {
            this.q3 = true;
            this.p3.f();
            this.Y2.c(this, this.e3);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        EngineResource<?> engineResource;
        synchronized (this) {
            try {
                this.X.c();
                Preconditions.a(n(), "Not yet complete!");
                int decrementAndGet = this.d3.decrementAndGet();
                Preconditions.a(decrementAndGet >= 0, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    engineResource = this.o3;
                    r();
                } else {
                    engineResource = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (engineResource != null) {
            engineResource.f();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(int i2) {
        EngineResource<?> engineResource;
        Preconditions.a(n(), "Not yet complete!");
        if (this.d3.getAndAdd(i2) == 0 && (engineResource = this.o3) != null) {
            engineResource.b();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized EngineJob<R> l(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e3 = key;
        this.f3 = z;
        this.g3 = z2;
        this.h3 = z3;
        this.i3 = z4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean m() {
        return this.q3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r4.Y2.b(r4, r1, (com.bumptech.glide.load.engine.EngineResource<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0.hasNext() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r1 = r0.next();
        r1.f17941b.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(r4, r1.f17940a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.X     // Catch:{ all -> 0x000f }
            r0.c()     // Catch:{ all -> 0x000f }
            boolean r0 = r4.q3     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x0011
            r4.r()     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r0 = move-exception
            goto L_0x0068
        L_0x0011:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.s     // Catch:{ all -> 0x000f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0060
            boolean r0 = r4.n3     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0058
            r0 = 1
            r4.n3 = r0     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.Key r1 = r4.e3     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r4.s     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r2.d()     // Catch:{ all -> 0x000f }
            int r3 = r2.size()     // Catch:{ all -> 0x000f }
            int r3 = r3 + r0
            r4.k(r3)     // Catch:{ all -> 0x000f }
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            com.bumptech.glide.load.engine.EngineJobListener r0 = r4.Y2
            r3 = 0
            r0.b(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.f17941b
            com.bumptech.glide.load.engine.EngineJob$CallLoadFailed r3 = new com.bumptech.glide.load.engine.EngineJob$CallLoadFailed
            com.bumptech.glide.request.ResourceCallback r1 = r1.f17940a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x003b
        L_0x0054:
            r4.i()
            return
        L_0x0058:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0060:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x0068:
            monitor-exit(r4)     // Catch:{ all -> 0x000f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.o():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r5.Y2.b(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r0.hasNext() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r1 = r0.next();
        r1.f17941b.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(r5, r1.f17940a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bumptech.glide.util.pool.StateVerifier r0 = r5.X     // Catch:{ all -> 0x0014 }
            r0.c()     // Catch:{ all -> 0x0014 }
            boolean r0 = r5.q3     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0016
            com.bumptech.glide.load.engine.Resource<?> r0 = r5.j3     // Catch:{ all -> 0x0014 }
            r0.recycle()     // Catch:{ all -> 0x0014 }
            r5.r()     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r0 = move-exception
            goto L_0x007e
        L_0x0016:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r5.s     // Catch:{ all -> 0x0014 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0076
            boolean r0 = r5.l3     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x006e
            com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory r0 = r5.X2     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.Resource<?> r1 = r5.j3     // Catch:{ all -> 0x0014 }
            boolean r2 = r5.f3     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r3 = r5.e3     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource$ResourceListener r4 = r5.Y     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x0014 }
            r5.o3 = r0     // Catch:{ all -> 0x0014 }
            r0 = 1
            r5.l3 = r0     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r5.s     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r1.d()     // Catch:{ all -> 0x0014 }
            int r2 = r1.size()     // Catch:{ all -> 0x0014 }
            int r2 = r2 + r0
            r5.k(r2)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.Key r0 = r5.e3     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineResource<?> r2 = r5.o3     // Catch:{ all -> 0x0014 }
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            com.bumptech.glide.load.engine.EngineJobListener r3 = r5.Y2
            r3.b(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x0051:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x006a
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.f17941b
            com.bumptech.glide.load.engine.EngineJob$CallResourceReady r3 = new com.bumptech.glide.load.engine.EngineJob$CallResourceReady
            com.bumptech.glide.request.ResourceCallback r1 = r1.f17940a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0051
        L_0x006a:
            r5.i()
            return
        L_0x006e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0076:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x007e:
            monitor-exit(r5)     // Catch:{ all -> 0x0014 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.p():void");
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public synchronized void s(ResourceCallback resourceCallback) {
        try {
            this.X.c();
            this.s.h(resourceCallback);
            if (this.s.isEmpty()) {
                h();
                if (!this.l3) {
                    if (this.n3) {
                    }
                }
                if (this.d3.get() == 0) {
                    r();
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void t(DecodeJob<R> decodeJob) {
        try {
            this.p3 = decodeJob;
            (decodeJob.F() ? this.Z2 : j()).execute(decodeJob);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.s = new ResourceCallbacksAndExecutors();
        this.X = StateVerifier.a();
        this.d3 = new AtomicInteger();
        this.Z2 = glideExecutor;
        this.a3 = glideExecutor2;
        this.b3 = glideExecutor3;
        this.c3 = glideExecutor4;
        this.Y2 = engineJobListener;
        this.Y = resourceListener;
        this.Z = pool;
        this.X2 = engineResourceFactory;
    }
}
