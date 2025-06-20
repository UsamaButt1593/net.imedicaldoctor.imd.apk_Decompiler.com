package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    private final Object f18445a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f18446b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f18447c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f18448d;
    @GuardedBy("requestLock")

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f18449e;
    @GuardedBy("requestLock")

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f18450f;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f18449e = requestState;
        this.f18450f = requestState;
        this.f18445a = obj;
        this.f18446b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean l(Request request) {
        return request.equals(this.f18447c) || (this.f18449e == RequestCoordinator.RequestState.FAILED && request.equals(this.f18448d));
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.f18446b;
        return requestCoordinator == null || requestCoordinator.k(this);
    }

    @GuardedBy("requestLock")
    private boolean n() {
        RequestCoordinator requestCoordinator = this.f18446b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean o() {
        RequestCoordinator requestCoordinator = this.f18446b;
        return requestCoordinator == null || requestCoordinator.e(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f18445a
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.f18448d     // Catch:{ all -> 0x001d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x001d }
            if (r3 != 0) goto L_0x0021
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.f18449e = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.f18450f     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x001d }
            if (r3 == r1) goto L_0x001f
            r2.f18450f = r1     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.Request r3 = r2.f18448d     // Catch:{ all -> 0x001d }
            r3.j()     // Catch:{ all -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r3 = move-exception
            goto L_0x002e
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x0021:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x001d }
            r2.f18450f = r3     // Catch:{ all -> 0x001d }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.f18446b     // Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x002c
            r3.a(r2)     // Catch:{ all -> 0x001d }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.a(com.bumptech.glide.request.Request):void");
    }

    public boolean b() {
        boolean z;
        synchronized (this.f18445a) {
            try {
                if (!this.f18447c.b()) {
                    if (!this.f18448d.b()) {
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
        synchronized (this.f18445a) {
            try {
                z = n() && l(request);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void clear() {
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.f18449e = requestState;
                this.f18447c.clear();
                if (this.f18450f != requestState) {
                    this.f18450f = requestState;
                    this.f18448d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        return this.f18447c.d(errorRequestCoordinator.f18447c) && this.f18448d.d(errorRequestCoordinator.f18448d);
    }

    public boolean e(Request request) {
        boolean z;
        synchronized (this.f18445a) {
            try {
                z = o() && l(request);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean f() {
        boolean z;
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = this.f18449e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                z = requestState == requestState2 && this.f18450f == requestState2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void g(Request request) {
        synchronized (this.f18445a) {
            try {
                if (request.equals(this.f18447c)) {
                    this.f18449e = RequestCoordinator.RequestState.SUCCESS;
                } else if (request.equals(this.f18448d)) {
                    this.f18450f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.f18446b;
                if (requestCoordinator != null) {
                    requestCoordinator.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h() {
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = this.f18449e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.f18449e = RequestCoordinator.RequestState.PAUSED;
                    this.f18447c.h();
                }
                if (this.f18450f == requestState2) {
                    this.f18450f = RequestCoordinator.RequestState.PAUSED;
                    this.f18448d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RequestCoordinator i() {
        RequestCoordinator i2;
        synchronized (this.f18445a) {
            try {
                RequestCoordinator requestCoordinator = this.f18446b;
                i2 = requestCoordinator != null ? requestCoordinator.i() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = this.f18449e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                if (requestState != requestState2) {
                    if (this.f18450f != requestState2) {
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

    public boolean isRunning() {
        boolean z;
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = this.f18449e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    if (this.f18450f != requestState2) {
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

    public void j() {
        synchronized (this.f18445a) {
            try {
                RequestCoordinator.RequestState requestState = this.f18449e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f18449e = requestState2;
                    this.f18447c.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean k(Request request) {
        boolean z;
        synchronized (this.f18445a) {
            try {
                z = m() && l(request);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void p(Request request, Request request2) {
        this.f18447c = request;
        this.f18448d = request2;
    }
}
