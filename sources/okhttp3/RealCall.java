package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall implements Call {
    final RetryAndFollowUpInterceptor X;
    final Request X2;
    final AsyncTimeout Y;
    final boolean Y2;
    /* access modifiers changed from: private */
    @Nullable
    public EventListener Z;
    private boolean Z2;
    final OkHttpClient s;

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean Z = false;
        private final Callback X;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.f());
            this.X = callback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x004a A[Catch:{ all -> 0x0028 }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x006a A[Catch:{ all -> 0x0028 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okio.AsyncTimeout r0 = r0.Y
                r0.w()
                r0 = 0
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.Response r1 = r1.d()     // Catch:{ IOException -> 0x003f }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x003f }
                okhttp3.internal.http.RetryAndFollowUpInterceptor r2 = r2.X     // Catch:{ IOException -> 0x003f }
                boolean r0 = r2.e()     // Catch:{ IOException -> 0x003f }
                r2 = 1
                if (r0 == 0) goto L_0x002c
                okhttp3.Callback r0 = r5.X     // Catch:{ IOException -> 0x002a }
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x002a }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x002a }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x002a }
                r0.b(r1, r3)     // Catch:{ IOException -> 0x002a }
                goto L_0x0033
            L_0x0028:
                r0 = move-exception
                goto L_0x007e
            L_0x002a:
                r0 = move-exception
                goto L_0x0042
            L_0x002c:
                okhttp3.Callback r0 = r5.X     // Catch:{ IOException -> 0x002a }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x002a }
                r0.a(r3, r1)     // Catch:{ IOException -> 0x002a }
            L_0x0033:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.s
                okhttp3.Dispatcher r0 = r0.m()
                r0.f(r5)
                goto L_0x007d
            L_0x003f:
                r1 = move-exception
                r0 = r1
                r2 = 0
            L_0x0042:
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ all -> 0x0028 }
                java.io.IOException r0 = r1.h(r0)     // Catch:{ all -> 0x0028 }
                if (r2 == 0) goto L_0x006a
                okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.k()     // Catch:{ all -> 0x0028 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
                r2.<init>()     // Catch:{ all -> 0x0028 }
                java.lang.String r3 = "Callback failure for "
                r2.append(r3)     // Catch:{ all -> 0x0028 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ all -> 0x0028 }
                java.lang.String r3 = r3.i()     // Catch:{ all -> 0x0028 }
                r2.append(r3)     // Catch:{ all -> 0x0028 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0028 }
                r3 = 4
                r1.r(r3, r2, r0)     // Catch:{ all -> 0x0028 }
                goto L_0x0033
            L_0x006a:
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ all -> 0x0028 }
                okhttp3.EventListener r1 = r1.Z     // Catch:{ all -> 0x0028 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0028 }
                r1.b(r2, r0)     // Catch:{ all -> 0x0028 }
                okhttp3.Callback r1 = r5.X     // Catch:{ all -> 0x0028 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0028 }
                r1.b(r2, r0)     // Catch:{ all -> 0x0028 }
                goto L_0x0033
            L_0x007d:
                return
            L_0x007e:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.s
                okhttp3.Dispatcher r1 = r1.m()
                r1.f(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.l():void");
        }

        /* access modifiers changed from: package-private */
        public void m(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                RealCall.this.Z.b(RealCall.this, interruptedIOException);
                this.X.b(RealCall.this, interruptedIOException);
                RealCall.this.s.m().f(this);
            } catch (Throwable th) {
                RealCall.this.s.m().f(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public RealCall n() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return RealCall.this.X2.k().p();
        }

        /* access modifiers changed from: package-private */
        public Request p() {
            return RealCall.this.X2;
        }
    }

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.s = okHttpClient;
        this.X2 = request;
        this.Y2 = z;
        this.X = new RetryAndFollowUpInterceptor(okHttpClient, z);
        AnonymousClass1 r4 = new AsyncTimeout() {
            /* access modifiers changed from: protected */
            public void C() {
                RealCall.this.cancel();
            }
        };
        this.Y = r4;
        r4.i((long) okHttpClient.e(), TimeUnit.MILLISECONDS);
    }

    private void b() {
        this.X.j(Platform.k().o("response.body().close()"));
    }

    static RealCall e(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.Z = okHttpClient.o().a(realCall);
        return realCall;
    }

    public synchronized boolean T0() {
        return this.Z2;
    }

    /* renamed from: c */
    public RealCall clone() {
        return e(this.s, this.X2, this.Y2);
    }

    public void cancel() {
        this.X.b();
    }

    /* access modifiers changed from: package-private */
    public Response d() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.s.s());
        arrayList.add(this.X);
        arrayList.add(new BridgeInterceptor(this.s.l()));
        arrayList.add(new CacheInterceptor(this.s.t()));
        arrayList.add(new ConnectInterceptor(this.s));
        if (!this.Y2) {
            arrayList.addAll(this.s.u());
        }
        arrayList.add(new CallServerInterceptor(this.Y2));
        return new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.X2, this, this.Z, this.s.g(), this.s.D(), this.s.J()).e(this.X2);
    }

    public void e0(Callback callback) {
        synchronized (this) {
            if (!this.Z2) {
                this.Z2 = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.Z.c(this);
        this.s.m().b(new AsyncCall(callback));
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.Z2) {
                this.Z2 = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.Y.w();
        this.Z.c(this);
        try {
            this.s.m().c(this);
            Response d2 = d();
            if (d2 != null) {
                this.s.m().g(this);
                return d2;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException h2 = h(e2);
            this.Z.b(this, h2);
            throw h2;
        } catch (Throwable th) {
            this.s.m().g(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.X2.k().N();
    }

    /* access modifiers changed from: package-private */
    public StreamAllocation g() {
        return this.X.k();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException h(@Nullable IOException iOException) {
        if (!this.Y.x()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(i1() ? "canceled " : "");
        sb.append(this.Y2 ? "web socket" : NotificationCompat.E0);
        sb.append(" to ");
        sb.append(f());
        return sb.toString();
    }

    public boolean i1() {
        return this.X.e();
    }

    public Timeout j() {
        return this.Y;
    }

    public Request k() {
        return this.X2;
    }
}
