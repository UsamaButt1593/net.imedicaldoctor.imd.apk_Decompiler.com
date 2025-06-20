package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class ActiveResources {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17861a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f17862b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<Key, ResourceWeakReference> f17863c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<EngineResource<?>> f17864d;

    /* renamed from: e  reason: collision with root package name */
    private EngineResource.ResourceListener f17865e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f17866f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private volatile DequeuedResourceCallback f17867g;

    @VisibleForTesting
    interface DequeuedResourceCallback {
        void a();
    }

    @VisibleForTesting
    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {

        /* renamed from: a  reason: collision with root package name */
        final Key f17868a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f17869b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        Resource<?> f17870c;

        ResourceWeakReference(@NonNull Key key, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f17868a = (Key) Preconditions.d(key);
            this.f17870c = (!engineResource.e() || !z) ? null : (Resource) Preconditions.d(engineResource.d());
            this.f17869b = engineResource.e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f17870c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(@NonNull final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference put = this.f17863c.put(key, new ResourceWeakReference(key, engineResource, this.f17864d, this.f17861a));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        while (!this.f17866f) {
            try {
                c((ResourceWeakReference) this.f17864d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.f17867g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.f17863c.remove(resourceWeakReference.f17868a);
            if (resourceWeakReference.f17869b) {
                Resource<?> resource = resourceWeakReference.f17870c;
                if (resource != null) {
                    this.f17865e.d(resourceWeakReference.f17868a, new EngineResource(resource, true, false, resourceWeakReference.f17868a, this.f17865e));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(Key key) {
        ResourceWeakReference remove = this.f17863c.remove(key);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.EngineResource<?> e(com.bumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference> r0 = r1.f17863c     // Catch:{ all -> 0x001a }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001a }
            com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference r2 = (com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) r2     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x000e
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001a }
            com.bumptech.glide.load.engine.EngineResource r0 = (com.bumptech.glide.load.engine.EngineResource) r0     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x001c
            r1.c(r2)     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r2 = move-exception
            goto L_0x001e
        L_0x001c:
            monitor-exit(r1)
            return r0
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.e(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.EngineResource");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void f(DequeuedResourceCallback dequeuedResourceCallback) {
        this.f17867g = dequeuedResourceCallback;
    }

    /* access modifiers changed from: package-private */
    public void g(EngineResource.ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.f17865e = resourceListener;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void h() {
        this.f17866f = true;
        Executor executor = this.f17862b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.c((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    ActiveResources(boolean z, Executor executor) {
        this.f17863c = new HashMap();
        this.f17864d = new ReferenceQueue<>();
        this.f17861a = z;
        this.f17862b = executor;
        executor.execute(new Runnable() {
            public void run() {
                ActiveResources.this.b();
            }
        });
    }
}
