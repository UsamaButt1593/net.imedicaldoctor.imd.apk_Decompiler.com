package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f18465a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f18466b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f18467c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f18468d;
    @GuardedBy("requestLock")

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f18469e;
    @GuardedBy("requestLock")

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f18470f;
    @GuardedBy("requestLock")

    /* renamed from: g  reason: collision with root package name */
    private boolean f18471g;

    public ThumbnailRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f18469e = requestState;
        this.f18470f = requestState;
        this.f18466b = obj;
        this.f18465a = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f18465a;
        return requestCoordinator == null || requestCoordinator.k(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.f18465a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean n() {
        RequestCoordinator requestCoordinator = this.f18465a;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f18466b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f18467c     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.f18470f = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r3 = move-exception
            goto L_0x0020
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0011 }
            r2.f18469e = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f18465a     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.a(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.a(com.bumptech.glide.request.Request):void");
    }

    public boolean b() {
        boolean z;
        synchronized (this.f18466b) {
            try {
                if (!this.f18468d.b()) {
                    if (!this.f18467c.b()) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean c(Request request) {
        boolean z;
        synchronized (this.f18466b) {
            try {
                z = m() && request.equals(this.f18467c) && !b();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void clear() {
        synchronized (this.f18466b) {
            this.f18471g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f18469e = requestState;
            this.f18470f = requestState;
            this.f18468d.clear();
            this.f18467c.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(com.bumptech.glide.request.Request r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.bumptech.glide.request.ThumbnailRequestCoordinator
            r1 = 0
            if (r0 == 0) goto L_0x002e
            com.bumptech.glide.request.ThumbnailRequestCoordinator r4 = (com.bumptech.glide.request.ThumbnailRequestCoordinator) r4
            com.bumptech.glide.request.Request r0 = r3.f18467c
            if (r0 != 0) goto L_0x0010
            com.bumptech.glide.request.Request r0 = r4.f18467c
            if (r0 != 0) goto L_0x002e
            goto L_0x001a
        L_0x0010:
            com.bumptech.glide.request.Request r0 = r3.f18467c
            com.bumptech.glide.request.Request r2 = r4.f18467c
            boolean r0 = r0.d(r2)
            if (r0 == 0) goto L_0x002e
        L_0x001a:
            com.bumptech.glide.request.Request r0 = r3.f18468d
            if (r0 != 0) goto L_0x0023
            com.bumptech.glide.request.Request r4 = r4.f18468d
            if (r4 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0023:
            com.bumptech.glide.request.Request r0 = r3.f18468d
            com.bumptech.glide.request.Request r4 = r4.f18468d
            boolean r4 = r0.d(r4)
            if (r4 == 0) goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.d(com.bumptech.glide.request.Request):boolean");
    }

    public boolean e(Request request) {
        boolean z;
        synchronized (this.f18466b) {
            try {
                if (n()) {
                    if (!request.equals(this.f18467c)) {
                        if (this.f18469e != RequestCoordinator.RequestState.SUCCESS) {
                        }
                    }
                    z = true;
                }
                z = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean f() {
        boolean z;
        synchronized (this.f18466b) {
            z = this.f18469e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f18466b
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f18468d     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0013
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.f18470f = r3     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r3 = move-exception
            goto L_0x002d
        L_0x0013:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0011 }
            r2.f18469e = r3     // Catch:{ all -> 0x0011 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f18465a     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x001e
            r3.g(r2)     // Catch:{ all -> 0x0011 }
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f18470f     // Catch:{ all -> 0x0011 }
            boolean r3 = r3.a()     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x002b
            com.bumptech.glide.request.Request r3 = r2.f18468d     // Catch:{ all -> 0x0011 }
            r3.clear()     // Catch:{ all -> 0x0011 }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.g(com.bumptech.glide.request.Request):void");
    }

    public void h() {
        synchronized (this.f18466b) {
            try {
                if (!this.f18470f.a()) {
                    this.f18470f = RequestCoordinator.RequestState.PAUSED;
                    this.f18468d.h();
                }
                if (!this.f18469e.a()) {
                    this.f18469e = RequestCoordinator.RequestState.PAUSED;
                    this.f18467c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RequestCoordinator i() {
        RequestCoordinator i2;
        synchronized (this.f18466b) {
            try {
                RequestCoordinator requestCoordinator = this.f18465a;
                i2 = requestCoordinator != null ? requestCoordinator.i() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f18466b) {
            z = this.f18469e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.f18466b) {
            z = this.f18469e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    public void j() {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2;
        synchronized (this.f18466b) {
            try {
                this.f18471g = true;
                if (!(this.f18469e == RequestCoordinator.RequestState.SUCCESS || this.f18470f == (requestState2 = RequestCoordinator.RequestState.RUNNING))) {
                    this.f18470f = requestState2;
                    this.f18468d.j();
                }
                if (this.f18471g && this.f18469e != (requestState = RequestCoordinator.RequestState.RUNNING)) {
                    this.f18469e = requestState;
                    this.f18467c.j();
                }
                this.f18471g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean k(Request request) {
        boolean z;
        synchronized (this.f18466b) {
            try {
                z = l() && request.equals(this.f18467c) && this.f18469e != RequestCoordinator.RequestState.PAUSED;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void o(Request request, Request request2) {
        this.f18467c = request;
        this.f18468d = request2;
    }
}
