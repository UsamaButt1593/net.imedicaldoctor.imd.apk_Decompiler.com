package okhttp3.internal.ws;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean A = false;
    private static final List<Protocol> x = Collections.singletonList(Protocol.HTTP_1_1);
    private static final long y = 16777216;
    private static final long z = 60000;

    /* renamed from: a  reason: collision with root package name */
    private final Request f31279a;

    /* renamed from: b  reason: collision with root package name */
    final WebSocketListener f31280b;

    /* renamed from: c  reason: collision with root package name */
    private final Random f31281c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31282d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31283e;

    /* renamed from: f  reason: collision with root package name */
    private Call f31284f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f31285g;

    /* renamed from: h  reason: collision with root package name */
    private WebSocketReader f31286h;

    /* renamed from: i  reason: collision with root package name */
    private WebSocketWriter f31287i;

    /* renamed from: j  reason: collision with root package name */
    private ScheduledExecutorService f31288j;

    /* renamed from: k  reason: collision with root package name */
    private Streams f31289k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayDeque<ByteString> f31290l = new ArrayDeque<>();

    /* renamed from: m  reason: collision with root package name */
    private final ArrayDeque<Object> f31291m = new ArrayDeque<>();

    /* renamed from: n  reason: collision with root package name */
    private long f31292n;
    private boolean o;
    private ScheduledFuture<?> p;
    private int q = -1;
    private String r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;

    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    static final class Close {

        /* renamed from: a  reason: collision with root package name */
        final int f31295a;

        /* renamed from: b  reason: collision with root package name */
        final ByteString f31296b;

        /* renamed from: c  reason: collision with root package name */
        final long f31297c;

        Close(int i2, ByteString byteString, long j2) {
            this.f31295a = i2;
            this.f31296b = byteString;
            this.f31297c = j2;
        }
    }

    static final class Message {

        /* renamed from: a  reason: collision with root package name */
        final int f31298a;

        /* renamed from: b  reason: collision with root package name */
        final ByteString f31299b;

        Message(int i2, ByteString byteString) {
            this.f31298a = i2;
            this.f31299b = byteString;
        }
    }

    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.A();
        }
    }

    public static abstract class Streams implements Closeable {
        public final BufferedSource X;
        public final BufferedSink Y;
        public final boolean s;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.s = z;
            this.X = bufferedSource;
            this.Y = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j2) {
        if ("GET".equals(request.g())) {
            this.f31279a = request;
            this.f31280b = webSocketListener;
            this.f31281c = random;
            this.f31282d = j2;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f31283e = ByteString.U(bArr).e();
            this.f31285g = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e2) {
                            RealWebSocket.this.o(e2, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.z());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.g());
    }

    private void v() {
        ScheduledExecutorService scheduledExecutorService = this.f31288j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f31285g);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean w(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.s     // Catch:{ all -> 0x0022 }
            r1 = 0
            if (r0 != 0) goto L_0x003e
            boolean r0 = r6.o     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x000b
            goto L_0x003e
        L_0x000b:
            long r2 = r6.f31292n     // Catch:{ all -> 0x0022 }
            int r0 = r7.m0()     // Catch:{ all -> 0x0022 }
            long r4 = (long) r0     // Catch:{ all -> 0x0022 }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0024
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.f(r7, r8)     // Catch:{ all -> 0x0022 }
            monitor-exit(r6)
            return r1
        L_0x0022:
            r7 = move-exception
            goto L_0x0040
        L_0x0024:
            long r0 = r6.f31292n     // Catch:{ all -> 0x0022 }
            int r2 = r7.m0()     // Catch:{ all -> 0x0022 }
            long r2 = (long) r2     // Catch:{ all -> 0x0022 }
            long r0 = r0 + r2
            r6.f31292n = r0     // Catch:{ all -> 0x0022 }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.f31291m     // Catch:{ all -> 0x0022 }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x0022 }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x0022 }
            r0.add(r1)     // Catch:{ all -> 0x0022 }
            r6.v()     // Catch:{ all -> 0x0022 }
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x003e:
            monitor-exit(r6)
            return r1
        L_0x0040:
            monitor-exit(r6)     // Catch:{ all -> 0x0022 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.w(okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (r1 == -1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        o(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.f31282d + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.e(okio.ByteString.Y2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        o(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.s     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r0 = move-exception
            goto L_0x0055
        L_0x0009:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.f31287i     // Catch:{ all -> 0x0007 }
            boolean r1 = r7.w     // Catch:{ all -> 0x0007 }
            r2 = -1
            if (r1 == 0) goto L_0x0013
            int r1 = r7.t     // Catch:{ all -> 0x0007 }
            goto L_0x0014
        L_0x0013:
            r1 = -1
        L_0x0014:
            int r3 = r7.t     // Catch:{ all -> 0x0007 }
            r4 = 1
            int r3 = r3 + r4
            r7.t = r3     // Catch:{ all -> 0x0007 }
            r7.w = r4     // Catch:{ all -> 0x0007 }
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            r3 = 0
            if (r1 == r2) goto L_0x004a
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.f31282d
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.o(r0, r3)
            return
        L_0x004a:
            okio.ByteString r1 = okio.ByteString.Y2     // Catch:{ IOException -> 0x0050 }
            r0.e(r1)     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r0 = move-exception
            r7.o(r0, r3)
        L_0x0054:
            return
        L_0x0055:
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.A():void");
    }

    public boolean a(ByteString byteString) {
        if (byteString != null) {
            return w(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    public boolean b(String str) {
        if (str != null) {
            return w(ByteString.n(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public void c(ByteString byteString) throws IOException {
        this.f31280b.e(this, byteString);
    }

    public void cancel() {
        this.f31284f.cancel();
    }

    public void d(String str) throws IOException {
        this.f31280b.d(this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.s     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0024
            boolean r0 = r1.o     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f31291m     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0024
        L_0x0012:
            r2 = move-exception
            goto L_0x0026
        L_0x0014:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f31290l     // Catch:{ all -> 0x0012 }
            r0.add(r2)     // Catch:{ all -> 0x0012 }
            r1.v()     // Catch:{ all -> 0x0012 }
            int r2 = r1.u     // Catch:{ all -> 0x0012 }
            int r2 = r2 + 1
            r1.u = r2     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.e(okio.ByteString):void");
    }

    public boolean f(int i2, String str) {
        return m(i2, str, 60000);
    }

    public synchronized long g() {
        return this.f31292n;
    }

    public synchronized void h(ByteString byteString) {
        this.v++;
        this.w = false;
    }

    public void i(int i2, String str) {
        Streams streams;
        if (i2 != -1) {
            synchronized (this) {
                try {
                    if (this.q == -1) {
                        this.q = i2;
                        this.r = str;
                        streams = null;
                        if (this.o && this.f31291m.isEmpty()) {
                            Streams streams2 = this.f31289k;
                            this.f31289k = streams;
                            ScheduledFuture<?> scheduledFuture = this.p;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(false);
                            }
                            this.f31288j.shutdown();
                            streams = streams2;
                        }
                    } else {
                        throw new IllegalStateException("already closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                this.f31280b.b(this, i2, str);
                if (streams != null) {
                    this.f31280b.a(this, i2, str);
                }
            } finally {
                Util.g(streams);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(int i2, TimeUnit timeUnit) throws InterruptedException {
        this.f31288j.awaitTermination((long) i2, timeUnit);
    }

    public Request k() {
        return this.f31279a;
    }

    /* access modifiers changed from: package-private */
    public void l(Response response) throws ProtocolException {
        if (response.f() == 101) {
            String i2 = response.i(HttpHeaders.o);
            if (HttpHeaders.N.equalsIgnoreCase(i2)) {
                String i3 = response.i(HttpHeaders.N);
                if ("websocket".equalsIgnoreCase(i3)) {
                    String i4 = response.i(HttpHeaders.W1);
                    String e2 = ByteString.n(this.f31283e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").i0().e();
                    if (!e2.equals(i4)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + e2 + "' but was '" + i4 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + i3 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + i2 + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.f() + StringUtils.SPACE + response.s() + "'");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m(int r7, java.lang.String r8, long r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            okhttp3.internal.ws.WebSocketProtocol.d(r7)     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x002f
            okio.ByteString r0 = okio.ByteString.n(r8)     // Catch:{ all -> 0x002d }
            int r1 = r0.m0()     // Catch:{ all -> 0x002d }
            long r1 = (long) r1     // Catch:{ all -> 0x002d }
            r3 = 123(0x7b, double:6.1E-322)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0016
            goto L_0x0030
        L_0x0016:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r9.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r10 = "reason.size() > 123: "
            r9.append(r10)     // Catch:{ all -> 0x002d }
            r9.append(r8)     // Catch:{ all -> 0x002d }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x002d }
            r7.<init>(r8)     // Catch:{ all -> 0x002d }
            throw r7     // Catch:{ all -> 0x002d }
        L_0x002d:
            r7 = move-exception
            goto L_0x004e
        L_0x002f:
            r0 = 0
        L_0x0030:
            boolean r8 = r6.s     // Catch:{ all -> 0x002d }
            if (r8 != 0) goto L_0x004b
            boolean r8 = r6.o     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            r8 = 1
            r6.o = r8     // Catch:{ all -> 0x002d }
            java.util.ArrayDeque<java.lang.Object> r1 = r6.f31291m     // Catch:{ all -> 0x002d }
            okhttp3.internal.ws.RealWebSocket$Close r2 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x002d }
            r2.<init>(r7, r0, r9)     // Catch:{ all -> 0x002d }
            r1.add(r2)     // Catch:{ all -> 0x002d }
            r6.v()     // Catch:{ all -> 0x002d }
            monitor-exit(r6)
            return r8
        L_0x004b:
            monitor-exit(r6)
            r7 = 0
            return r7
        L_0x004e:
            monitor-exit(r6)     // Catch:{ all -> 0x002d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.m(int, java.lang.String, long):boolean");
    }

    public void n(OkHttpClient okHttpClient) {
        OkHttpClient d2 = okHttpClient.v().p(EventListener.f30857a).y(x).d();
        final Request b2 = this.f31279a.h().h(HttpHeaders.N, "websocket").h(HttpHeaders.o, HttpHeaders.N).h(HttpHeaders.Y1, this.f31283e).h(HttpHeaders.a2, "13").b();
        Call k2 = Internal.f30969a.k(d2, b2);
        this.f31284f = k2;
        k2.j().b();
        this.f31284f.e0(new Callback() {
            public void a(Call call, Response response) {
                try {
                    RealWebSocket.this.l(response);
                    StreamAllocation o = Internal.f30969a.o(call);
                    o.j();
                    Streams s = o.d().s(o);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.f31280b.f(realWebSocket, response);
                        RealWebSocket.this.p("OkHttp WebSocket " + b2.k().N(), s);
                        o.d().d().setSoTimeout(0);
                        RealWebSocket.this.q();
                    } catch (Exception e2) {
                        RealWebSocket.this.o(e2, (Response) null);
                    }
                } catch (ProtocolException e3) {
                    RealWebSocket.this.o(e3, response);
                    Util.g(response);
                }
            }

            public void b(Call call, IOException iOException) {
                RealWebSocket.this.o(iOException, (Response) null);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.f31280b.c(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        okhttp3.internal.Util.g(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(java.lang.Exception r4, @javax.annotation.Nullable okhttp3.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.s     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r4 = move-exception
            goto L_0x002f
        L_0x0009:
            r0 = 1
            r3.s = r0     // Catch:{ all -> 0x0007 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r3.f31289k     // Catch:{ all -> 0x0007 }
            r1 = 0
            r3.f31289k = r1     // Catch:{ all -> 0x0007 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.p     // Catch:{ all -> 0x0007 }
            if (r1 == 0) goto L_0x0019
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0007 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.f31288j     // Catch:{ all -> 0x0007 }
            if (r1 == 0) goto L_0x0020
            r1.shutdown()     // Catch:{ all -> 0x0007 }
        L_0x0020:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            okhttp3.WebSocketListener r1 = r3.f31280b     // Catch:{ all -> 0x002a }
            r1.c(r3, r4, r5)     // Catch:{ all -> 0x002a }
            okhttp3.internal.Util.g(r0)
            return
        L_0x002a:
            r4 = move-exception
            okhttp3.internal.Util.g(r0)
            throw r4
        L_0x002f:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.o(java.lang.Exception, okhttp3.Response):void");
    }

    public void p(String str, Streams streams) throws IOException {
        synchronized (this) {
            try {
                this.f31289k = streams;
                this.f31287i = new WebSocketWriter(streams.s, streams.Y, this.f31281c);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.H(str, false));
                this.f31288j = scheduledThreadPoolExecutor;
                if (this.f31282d != 0) {
                    PingRunnable pingRunnable = new PingRunnable();
                    long j2 = this.f31282d;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j2, j2, TimeUnit.MILLISECONDS);
                }
                if (!this.f31291m.isEmpty()) {
                    v();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f31286h = new WebSocketReader(streams.s, streams.X, this);
    }

    public void q() throws IOException {
        while (this.q == -1) {
            this.f31286h.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean r(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.s     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x001f
            boolean r0 = r1.o     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f31291m     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            goto L_0x001f
        L_0x0012:
            r2 = move-exception
            goto L_0x0022
        L_0x0014:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f31290l     // Catch:{ all -> 0x0012 }
            r0.add(r2)     // Catch:{ all -> 0x0012 }
            r1.v()     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x001f:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0022:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.r(okio.ByteString):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean s() throws IOException {
        try {
            this.f31286h.a();
            return this.q == -1;
        } catch (Exception e2) {
            o(e2, (Response) null);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized int t() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public synchronized int u() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public synchronized int x() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void y() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f31288j.shutdown();
        this.f31288j.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r2 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        if ((r3 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r1 = ((okhttp3.internal.ws.RealWebSocket.Message) r3).f31299b;
        r0 = okio.Okio.d(r0.a(((okhttp3.internal.ws.RealWebSocket.Message) r3).f31298a, (long) r1.m0()));
        r0.g2(r1);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r11.f31292n -= (long) r1.m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0091, code lost:
        if ((r3 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0093, code lost:
        r3 = (okhttp3.internal.ws.RealWebSocket.Close) r3;
        r0.b(r3.f31295a, r3.f31296b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r4 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
        r11.f31280b.a(r11, r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a3, code lost:
        okhttp3.internal.Util.g(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        okhttp3.internal.Util.g(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean z() throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.s     // Catch:{ all -> 0x0008 }
            r1 = 0
            if (r0 == 0) goto L_0x000b
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x0008:
            r0 = move-exception
            goto L_0x00b2
        L_0x000b:
            okhttp3.internal.ws.WebSocketWriter r0 = r11.f31287i     // Catch:{ all -> 0x0008 }
            java.util.ArrayDeque<okio.ByteString> r2 = r11.f31290l     // Catch:{ all -> 0x0008 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0008 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x0008 }
            r3 = 0
            r4 = -1
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r11.f31291m     // Catch:{ all -> 0x0008 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x0008 }
            boolean r6 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x0008 }
            if (r6 == 0) goto L_0x004a
            int r1 = r11.q     // Catch:{ all -> 0x0008 }
            java.lang.String r6 = r11.r     // Catch:{ all -> 0x0008 }
            if (r1 == r4) goto L_0x0034
            okhttp3.internal.ws.RealWebSocket$Streams r4 = r11.f31289k     // Catch:{ all -> 0x0008 }
            r11.f31289k = r3     // Catch:{ all -> 0x0008 }
            java.util.concurrent.ScheduledExecutorService r3 = r11.f31288j     // Catch:{ all -> 0x0008 }
            r3.shutdown()     // Catch:{ all -> 0x0008 }
        L_0x0032:
            r3 = r5
            goto L_0x0056
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r4 = r11.f31288j     // Catch:{ all -> 0x0008 }
            okhttp3.internal.ws.RealWebSocket$CancelRunnable r7 = new okhttp3.internal.ws.RealWebSocket$CancelRunnable     // Catch:{ all -> 0x0008 }
            r7.<init>()     // Catch:{ all -> 0x0008 }
            r8 = r5
            okhttp3.internal.ws.RealWebSocket$Close r8 = (okhttp3.internal.ws.RealWebSocket.Close) r8     // Catch:{ all -> 0x0008 }
            long r8 = r8.f31297c     // Catch:{ all -> 0x0008 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0008 }
            java.util.concurrent.ScheduledFuture r4 = r4.schedule(r7, r8, r10)     // Catch:{ all -> 0x0008 }
            r11.p = r4     // Catch:{ all -> 0x0008 }
            r4 = r3
            goto L_0x0032
        L_0x004a:
            if (r5 != 0) goto L_0x004e
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x004e:
            r4 = r3
            r6 = r4
            r3 = r5
        L_0x0051:
            r1 = -1
            goto L_0x0056
        L_0x0053:
            r4 = r3
            r6 = r4
            goto L_0x0051
        L_0x0056:
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            if (r2 == 0) goto L_0x005f
            r0.f(r2)     // Catch:{ all -> 0x005d }
            goto L_0x00a3
        L_0x005d:
            r0 = move-exception
            goto L_0x00ae
        L_0x005f:
            boolean r2 = r3 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x008f
            r1 = r3
            okhttp3.internal.ws.RealWebSocket$Message r1 = (okhttp3.internal.ws.RealWebSocket.Message) r1     // Catch:{ all -> 0x005d }
            okio.ByteString r1 = r1.f31299b     // Catch:{ all -> 0x005d }
            okhttp3.internal.ws.RealWebSocket$Message r3 = (okhttp3.internal.ws.RealWebSocket.Message) r3     // Catch:{ all -> 0x005d }
            int r2 = r3.f31298a     // Catch:{ all -> 0x005d }
            int r3 = r1.m0()     // Catch:{ all -> 0x005d }
            long r5 = (long) r3     // Catch:{ all -> 0x005d }
            okio.Sink r0 = r0.a(r2, r5)     // Catch:{ all -> 0x005d }
            okio.BufferedSink r0 = okio.Okio.d(r0)     // Catch:{ all -> 0x005d }
            r0.g2(r1)     // Catch:{ all -> 0x005d }
            r0.close()     // Catch:{ all -> 0x005d }
            monitor-enter(r11)     // Catch:{ all -> 0x005d }
            long r2 = r11.f31292n     // Catch:{ all -> 0x008c }
            int r0 = r1.m0()     // Catch:{ all -> 0x008c }
            long r0 = (long) r0     // Catch:{ all -> 0x008c }
            long r2 = r2 - r0
            r11.f31292n = r2     // Catch:{ all -> 0x008c }
            monitor-exit(r11)     // Catch:{ all -> 0x008c }
            goto L_0x00a3
        L_0x008c:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x008c }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x008f:
            boolean r2 = r3 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x00a8
            okhttp3.internal.ws.RealWebSocket$Close r3 = (okhttp3.internal.ws.RealWebSocket.Close) r3     // Catch:{ all -> 0x005d }
            int r2 = r3.f31295a     // Catch:{ all -> 0x005d }
            okio.ByteString r3 = r3.f31296b     // Catch:{ all -> 0x005d }
            r0.b(r2, r3)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x00a3
            okhttp3.WebSocketListener r0 = r11.f31280b     // Catch:{ all -> 0x005d }
            r0.a(r11, r1, r6)     // Catch:{ all -> 0x005d }
        L_0x00a3:
            okhttp3.internal.Util.g(r4)
            r0 = 1
            return r0
        L_0x00a8:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x00ae:
            okhttp3.internal.Util.g(r4)
            throw r0
        L_0x00b2:
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.z():boolean");
    }
}
