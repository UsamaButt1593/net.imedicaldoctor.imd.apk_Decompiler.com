package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f30803g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.H("OkHttp ConnectionPool", true));

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f30804h = false;

    /* renamed from: a  reason: collision with root package name */
    private final int f30805a;

    /* renamed from: b  reason: collision with root package name */
    private final long f30806b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f30807c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque<RealConnection> f30808d;

    /* renamed from: e  reason: collision with root package name */
    final RouteDatabase f30809e;

    /* renamed from: f  reason: collision with root package name */
    boolean f30810f;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int h(RealConnection realConnection, long j2) {
        List<Reference<StreamAllocation>> list = realConnection.f31043n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                Platform.k().s("A connection to " + realConnection.b().a().l() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).f31069a);
                list.remove(i2);
                realConnection.f31040k = true;
                if (list.isEmpty()) {
                    realConnection.o = j2 - this.f30806b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long a(long j2) {
        synchronized (this) {
            try {
                RealConnection realConnection = null;
                long j3 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (RealConnection next : this.f30808d) {
                    if (h(next, j2) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j4 = j2 - next.o;
                        if (j4 > j3) {
                            realConnection = next;
                            j3 = j4;
                        }
                    }
                }
                long j5 = this.f30806b;
                if (j3 < j5) {
                    if (i2 <= this.f30805a) {
                        if (i2 > 0) {
                            long j6 = j5 - j3;
                            return j6;
                        } else if (i3 > 0) {
                            return j5;
                        } else {
                            this.f30810f = false;
                            return -1;
                        }
                    }
                }
                this.f30808d.remove(realConnection);
                Util.i(realConnection.d());
                return 0;
            } finally {
                while (true) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(RealConnection realConnection) {
        if (realConnection.f31040k || this.f30805a == 0) {
            this.f30808d.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    public synchronized int c() {
        return this.f30808d.size();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Socket d(Address address, StreamAllocation streamAllocation) {
        for (RealConnection next : this.f30808d) {
            if (next.o(address, (Route) null) && next.q() && next != streamAllocation.d()) {
                return streamAllocation.m(next);
            }
        }
        return null;
    }

    public void e() {
        ArrayList<RealConnection> arrayList = new ArrayList<>();
        synchronized (this) {
            try {
                Iterator<RealConnection> it2 = this.f30808d.iterator();
                while (it2.hasNext()) {
                    RealConnection next = it2.next();
                    if (next.f31043n.isEmpty()) {
                        next.f31040k = true;
                        arrayList.add(next);
                        it2.remove();
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        for (RealConnection d2 : arrayList) {
            Util.i(d2.d());
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public RealConnection f(Address address, StreamAllocation streamAllocation, Route route) {
        for (RealConnection next : this.f30808d) {
            if (next.o(address, route)) {
                streamAllocation.a(next, true);
                return next;
            }
        }
        return null;
    }

    public synchronized int g() {
        int i2;
        i2 = 0;
        for (RealConnection realConnection : this.f30808d) {
            if (realConnection.f31043n.isEmpty()) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void i(RealConnection realConnection) {
        if (!this.f30810f) {
            this.f30810f = true;
            f30803g.execute(this.f30807c);
        }
        this.f30808d.add(realConnection);
    }

    public ConnectionPool(int i2, long j2, TimeUnit timeUnit) {
        this.f30807c = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                L_0x0000:
                    okhttp3.ConnectionPool r0 = okhttp3.ConnectionPool.this
                    long r1 = java.lang.System.nanoTime()
                    long r0 = r0.a(r1)
                    r2 = -1
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 != 0) goto L_0x0011
                    return
                L_0x0011:
                    r2 = 0
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0000
                    r2 = 1000000(0xf4240, double:4.940656E-318)
                    long r4 = r0 / r2
                    long r2 = r2 * r4
                    long r0 = r0 - r2
                    okhttp3.ConnectionPool r2 = okhttp3.ConnectionPool.this
                    monitor-enter(r2)
                    okhttp3.ConnectionPool r3 = okhttp3.ConnectionPool.this     // Catch:{ InterruptedException -> 0x002b }
                    int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                    r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                    goto L_0x002b
                L_0x0029:
                    r0 = move-exception
                    goto L_0x002d
                L_0x002b:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    goto L_0x0000
                L_0x002d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ConnectionPool.AnonymousClass1.run():void");
            }
        };
        this.f30808d = new ArrayDeque();
        this.f30809e = new RouteDatabase();
        this.f30805a = i2;
        this.f30806b = timeUnit.toNanos(j2);
        if (j2 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
        }
    }
}
