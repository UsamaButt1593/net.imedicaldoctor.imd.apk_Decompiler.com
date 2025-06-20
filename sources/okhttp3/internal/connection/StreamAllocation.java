package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;

public final class StreamAllocation {
    static final /* synthetic */ boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    public final Address f31055a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSelector.Selection f31056b;

    /* renamed from: c  reason: collision with root package name */
    private Route f31057c;

    /* renamed from: d  reason: collision with root package name */
    private final ConnectionPool f31058d;

    /* renamed from: e  reason: collision with root package name */
    public final Call f31059e;

    /* renamed from: f  reason: collision with root package name */
    public final EventListener f31060f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f31061g;

    /* renamed from: h  reason: collision with root package name */
    private final RouteSelector f31062h;

    /* renamed from: i  reason: collision with root package name */
    private int f31063i;

    /* renamed from: j  reason: collision with root package name */
    private RealConnection f31064j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31065k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f31066l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f31067m;

    /* renamed from: n  reason: collision with root package name */
    private HttpCodec f31068n;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f31069a;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.f31069a = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.f31058d = connectionPool;
        this.f31055a = address;
        this.f31059e = call;
        this.f31060f = eventListener;
        this.f31062h = new RouteSelector(address, p(), call, eventListener);
        this.f31061g = obj;
    }

    private Socket e(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f31068n = null;
        }
        if (z2) {
            this.f31066l = true;
        }
        RealConnection realConnection = this.f31064j;
        if (realConnection == null) {
            return null;
        }
        if (z) {
            realConnection.f31040k = true;
        }
        if (this.f31068n != null) {
            return null;
        }
        if (!this.f31066l && !realConnection.f31040k) {
            return null;
        }
        l(realConnection);
        if (this.f31064j.f31043n.isEmpty()) {
            this.f31064j.o = System.nanoTime();
            if (Internal.f30969a.e(this.f31058d, this.f31064j)) {
                socket = this.f31064j.d();
                this.f31064j = null;
                return socket;
            }
        }
        socket = null;
        this.f31064j = null;
        return socket;
    }

    private RealConnection f(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        RealConnection realConnection;
        Socket n2;
        RealConnection realConnection2;
        Socket socket;
        boolean z2;
        Route route;
        boolean z3;
        RouteSelector.Selection selection;
        synchronized (this.f31058d) {
            try {
                if (this.f31066l) {
                    throw new IllegalStateException("released");
                } else if (this.f31068n != null) {
                    throw new IllegalStateException("codec != null");
                } else if (!this.f31067m) {
                    realConnection = this.f31064j;
                    n2 = n();
                    realConnection2 = this.f31064j;
                    socket = null;
                    if (realConnection2 != null) {
                        realConnection = null;
                    } else {
                        realConnection2 = null;
                    }
                    if (!this.f31065k) {
                        realConnection = null;
                    }
                    if (realConnection2 == null) {
                        Internal.f30969a.h(this.f31058d, this.f31055a, this, (Route) null);
                        RealConnection realConnection3 = this.f31064j;
                        if (realConnection3 != null) {
                            realConnection2 = realConnection3;
                            z2 = true;
                            route = null;
                        } else {
                            route = this.f31057c;
                        }
                    } else {
                        route = null;
                    }
                    z2 = false;
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
            }
        }
        Util.i(n2);
        if (realConnection != null) {
            this.f31060f.h(this.f31059e, realConnection);
        }
        if (z2) {
            this.f31060f.g(this.f31059e, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f31056b) != null && selection.b())) {
            z3 = false;
        } else {
            this.f31056b = this.f31062h.e();
            z3 = true;
        }
        synchronized (this.f31058d) {
            try {
                if (!this.f31067m) {
                    if (z3) {
                        List<Route> a2 = this.f31056b.a();
                        int size = a2.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size) {
                                break;
                            }
                            Route route2 = a2.get(i6);
                            Internal.f30969a.h(this.f31058d, this.f31055a, this, route2);
                            RealConnection realConnection4 = this.f31064j;
                            if (realConnection4 != null) {
                                this.f31057c = route2;
                                realConnection2 = realConnection4;
                                z2 = true;
                                break;
                            }
                            i6++;
                        }
                    }
                    if (!z2) {
                        if (route == null) {
                            route = this.f31056b.c();
                        }
                        this.f31057c = route;
                        this.f31063i = 0;
                        realConnection2 = new RealConnection(this.f31058d, route);
                        a(realConnection2, false);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
            }
        }
        if (!z2) {
            realConnection2.h(i2, i3, i4, i5, z, this.f31059e, this.f31060f);
            p().a(realConnection2.b());
            synchronized (this.f31058d) {
                try {
                    this.f31065k = true;
                    Internal.f30969a.l(this.f31058d, realConnection2);
                    if (realConnection2.q()) {
                        socket = Internal.f30969a.f(this.f31058d, this.f31055a, this);
                        realConnection2 = this.f31064j;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            Util.i(socket);
        }
        this.f31060f.g(this.f31059e, realConnection2);
        return realConnection2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        if (r0.p(r9) != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection g(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.f(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.f31058d
            monitor-enter(r1)
            int r2 = r0.f31041l     // Catch:{ all -> 0x000d }
            if (r2 != 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            return r0
        L_0x000d:
            r4 = move-exception
            goto L_0x001b
        L_0x000f:
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            boolean r1 = r0.p(r9)
            if (r1 != 0) goto L_0x001a
            r3.j()
            goto L_0x0000
        L_0x001a:
            return r0
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x000d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.g(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    private void l(RealConnection realConnection) {
        int size = realConnection.f31043n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (realConnection.f31043n.get(i2).get() == this) {
                realConnection.f31043n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket n() {
        RealConnection realConnection = this.f31064j;
        if (realConnection == null || !realConnection.f31040k) {
            return null;
        }
        return e(false, false, true);
    }

    private RouteDatabase p() {
        return Internal.f30969a.m(this.f31058d);
    }

    public void a(RealConnection realConnection, boolean z) {
        if (this.f31064j == null) {
            this.f31064j = realConnection;
            this.f31065k = z;
            realConnection.f31043n.add(new StreamAllocationReference(this, this.f31061g));
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.f31058d) {
            this.f31067m = true;
            httpCodec = this.f31068n;
            realConnection = this.f31064j;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.g();
        }
    }

    public HttpCodec c() {
        HttpCodec httpCodec;
        synchronized (this.f31058d) {
            httpCodec = this.f31068n;
        }
        return httpCodec;
    }

    public synchronized RealConnection d() {
        return this.f31064j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f31056b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            okhttp3.Route r0 = r1.f31057c
            if (r0 != 0) goto L_0x0019
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.f31056b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            okhttp3.internal.connection.RouteSelector r0 = r1.f31062h
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.h():boolean");
    }

    public HttpCodec i(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec r = g(chain.h(), chain.b(), chain.c(), okHttpClient.x(), okHttpClient.E(), z).r(okHttpClient, chain, this);
            synchronized (this.f31058d) {
                this.f31068n = r;
            }
            return r;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    public void j() {
        RealConnection realConnection;
        Socket e2;
        synchronized (this.f31058d) {
            realConnection = this.f31064j;
            e2 = e(true, false, false);
            if (this.f31064j != null) {
                realConnection = null;
            }
        }
        Util.i(e2);
        if (realConnection != null) {
            this.f31060f.h(this.f31059e, realConnection);
        }
    }

    public void k() {
        RealConnection realConnection;
        Socket e2;
        synchronized (this.f31058d) {
            realConnection = this.f31064j;
            e2 = e(false, true, false);
            if (this.f31064j != null) {
                realConnection = null;
            }
        }
        Util.i(e2);
        if (realConnection != null) {
            Internal.f30969a.p(this.f31059e, (IOException) null);
            this.f31060f.h(this.f31059e, realConnection);
            this.f31060f.a(this.f31059e);
        }
    }

    public Socket m(RealConnection realConnection) {
        if (this.f31068n == null && this.f31064j.f31043n.size() == 1) {
            Socket e2 = e(true, false, false);
            this.f31064j = realConnection;
            realConnection.f31043n.add(this.f31064j.f31043n.get(0));
            return e2;
        }
        throw new IllegalStateException();
    }

    public Route o() {
        return this.f31057c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r7 > 1) goto L_0x0019;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A[Catch:{ all -> 0x001c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(java.io.IOException r7) {
        /*
            r6 = this;
            okhttp3.ConnectionPool r0 = r6.f31058d
            monitor-enter(r0)
            boolean r1 = r7 instanceof okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x001c }
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0023
            okhttp3.internal.http2.StreamResetException r7 = (okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x001c }
            okhttp3.internal.http2.ErrorCode r7 = r7.s     // Catch:{ all -> 0x001c }
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x001c }
            if (r7 != r1) goto L_0x001e
            int r7 = r6.f31063i     // Catch:{ all -> 0x001c }
            int r7 = r7 + r3
            r6.f31063i = r7     // Catch:{ all -> 0x001c }
            if (r7 <= r3) goto L_0x0045
        L_0x0019:
            r6.f31057c = r2     // Catch:{ all -> 0x001c }
            goto L_0x0043
        L_0x001c:
            r7 = move-exception
            goto L_0x0064
        L_0x001e:
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x001c }
            if (r7 == r1) goto L_0x0045
            goto L_0x0019
        L_0x0023:
            okhttp3.internal.connection.RealConnection r1 = r6.f31064j     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0045
            boolean r1 = r1.q()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0045
        L_0x0031:
            okhttp3.internal.connection.RealConnection r1 = r6.f31064j     // Catch:{ all -> 0x001c }
            int r1 = r1.f31041l     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0043
            okhttp3.Route r1 = r6.f31057c     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0019
            if (r7 == 0) goto L_0x0019
            okhttp3.internal.connection.RouteSelector r5 = r6.f31062h     // Catch:{ all -> 0x001c }
            r5.a(r1, r7)     // Catch:{ all -> 0x001c }
            goto L_0x0019
        L_0x0043:
            r7 = 1
            goto L_0x0046
        L_0x0045:
            r7 = 0
        L_0x0046:
            okhttp3.internal.connection.RealConnection r1 = r6.f31064j     // Catch:{ all -> 0x001c }
            java.net.Socket r7 = r6.e(r7, r4, r3)     // Catch:{ all -> 0x001c }
            okhttp3.internal.connection.RealConnection r3 = r6.f31064j     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0056
            boolean r3 = r6.f31065k     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r2 = r1
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            okhttp3.internal.Util.i(r7)
            if (r2 == 0) goto L_0x0063
            okhttp3.EventListener r7 = r6.f31060f
            okhttp3.Call r0 = r6.f31059e
            r7.h(r0, r2)
        L_0x0063:
            return
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.q(java.io.IOException):void");
    }

    public void r(boolean z, HttpCodec httpCodec, long j2, IOException iOException) {
        RealConnection realConnection;
        Socket e2;
        boolean z2;
        this.f31060f.p(this.f31059e, j2);
        synchronized (this.f31058d) {
            if (httpCodec != null) {
                try {
                    if (httpCodec == this.f31068n) {
                        if (!z) {
                            this.f31064j.f31041l++;
                        }
                        realConnection = this.f31064j;
                        e2 = e(z, false, true);
                        if (this.f31064j != null) {
                            realConnection = null;
                        }
                        z2 = this.f31066l;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.f31068n + " but was " + httpCodec);
        }
        Util.i(e2);
        if (realConnection != null) {
            this.f31060f.h(this.f31059e, realConnection);
        }
        if (iOException != null) {
            this.f31060f.b(this.f31059e, Internal.f30969a.p(this.f31059e, iOException));
        } else if (z2) {
            Internal.f30969a.p(this.f31059e, (IOException) null);
            this.f31060f.a(this.f31059e);
        }
    }

    public String toString() {
        RealConnection d2 = d();
        return d2 != null ? d2.toString() : this.f31055a.toString();
    }
}
