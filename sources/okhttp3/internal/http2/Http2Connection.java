package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    static final int n3 = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService o3 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.H("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean p3 = false;
    final Listener X;
    int X2;
    final Map<Integer, Http2Stream> Y = new LinkedHashMap();
    int Y2;
    final String Z;
    boolean Z2;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService a3;
    private final ExecutorService b3;
    final PushObserver c3;
    /* access modifiers changed from: private */
    public boolean d3;
    long e3 = 0;
    long f3;
    Settings g3 = new Settings();
    final Settings h3;
    boolean i3;
    final Socket j3;
    final Http2Writer k3;
    final ReaderRunnable l3;
    final Set<Integer> m3;
    final boolean s;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Socket f31183a;

        /* renamed from: b  reason: collision with root package name */
        String f31184b;

        /* renamed from: c  reason: collision with root package name */
        BufferedSource f31185c;

        /* renamed from: d  reason: collision with root package name */
        BufferedSink f31186d;

        /* renamed from: e  reason: collision with root package name */
        Listener f31187e = Listener.f31191a;

        /* renamed from: f  reason: collision with root package name */
        PushObserver f31188f = PushObserver.f31213a;

        /* renamed from: g  reason: collision with root package name */
        boolean f31189g;

        /* renamed from: h  reason: collision with root package name */
        int f31190h;

        public Builder(boolean z) {
            this.f31189g = z;
        }

        public Http2Connection a() {
            return new Http2Connection(this);
        }

        public Builder b(Listener listener) {
            this.f31187e = listener;
            return this;
        }

        public Builder c(int i2) {
            this.f31190h = i2;
            return this;
        }

        public Builder d(PushObserver pushObserver) {
            this.f31188f = pushObserver;
            return this;
        }

        public Builder e(Socket socket) throws IOException {
            return f(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.e(Okio.v(socket)), Okio.d(Okio.q(socket)));
        }

        public Builder f(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f31183a = socket;
            this.f31184b = str;
            this.f31185c = bufferedSource;
            this.f31186d = bufferedSink;
            return this;
        }
    }

    public static abstract class Listener {

        /* renamed from: a  reason: collision with root package name */
        public static final Listener f31191a = new Listener() {
            public void f(Http2Stream http2Stream) throws IOException {
                http2Stream.f(ErrorCode.REFUSED_STREAM);
            }
        };

        public void e(Http2Connection http2Connection) {
        }

        public abstract void f(Http2Stream http2Stream) throws IOException;
    }

    final class PingRunnable extends NamedRunnable {
        final boolean X;
        final int Y;
        final int Z;

        PingRunnable(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.Z, Integer.valueOf(i2), Integer.valueOf(i3));
            this.X = z;
            this.Y = i2;
            this.Z = i3;
        }

        public void l() {
            Http2Connection.this.O(this.X, this.Y, this.Z);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader X;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.Z);
            this.X = http2Reader;
        }

        private void m(final Settings settings) {
            try {
                Http2Connection.this.a3.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.Z}) {
                    public void l() {
                        try {
                            Http2Connection.this.k3.b(settings);
                        } catch (IOException unused) {
                            Http2Connection.this.i();
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public void a() {
        }

        /* JADX WARNING: type inference failed for: r3v11, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(boolean r12, okhttp3.internal.http2.Settings r13) {
            /*
                r11 = this;
                r0 = 0
                r1 = 1
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r2)
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Settings r3 = r3.h3     // Catch:{ all -> 0x0017 }
                int r3 = r3.e()     // Catch:{ all -> 0x0017 }
                if (r12 == 0) goto L_0x001a
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Settings r12 = r12.h3     // Catch:{ all -> 0x0017 }
                r12.a()     // Catch:{ all -> 0x0017 }
                goto L_0x001a
            L_0x0017:
                r12 = move-exception
                goto L_0x008e
            L_0x001a:
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Settings r12 = r12.h3     // Catch:{ all -> 0x0017 }
                r12.j(r13)     // Catch:{ all -> 0x0017 }
                r11.m(r13)     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Http2Connection r12 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Settings r12 = r12.h3     // Catch:{ all -> 0x0017 }
                int r12 = r12.e()     // Catch:{ all -> 0x0017 }
                r13 = -1
                r4 = 0
                r6 = 0
                if (r12 == r13) goto L_0x0060
                if (r12 == r3) goto L_0x0060
                int r12 = r12 - r3
                long r12 = (long) r12     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                boolean r7 = r3.i3     // Catch:{ all -> 0x0017 }
                if (r7 != 0) goto L_0x003e
                r3.i3 = r1     // Catch:{ all -> 0x0017 }
            L_0x003e:
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r3.Y     // Catch:{ all -> 0x0017 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0017 }
                if (r3 != 0) goto L_0x0061
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r3.Y     // Catch:{ all -> 0x0017 }
                java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Http2Connection r6 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r6 = r6.Y     // Catch:{ all -> 0x0017 }
                int r6 = r6.size()     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Http2Stream[] r6 = new okhttp3.internal.http2.Http2Stream[r6]     // Catch:{ all -> 0x0017 }
                java.lang.Object[] r3 = r3.toArray(r6)     // Catch:{ all -> 0x0017 }
                r6 = r3
                okhttp3.internal.http2.Http2Stream[] r6 = (okhttp3.internal.http2.Http2Stream[]) r6     // Catch:{ all -> 0x0017 }
                goto L_0x0061
            L_0x0060:
                r12 = r4
            L_0x0061:
                java.util.concurrent.ExecutorService r3 = okhttp3.internal.http2.Http2Connection.o3     // Catch:{ all -> 0x0017 }
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$2 r7 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$2     // Catch:{ all -> 0x0017 }
                java.lang.String r8 = "OkHttp %s settings"
                okhttp3.internal.http2.Http2Connection r9 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0017 }
                java.lang.String r9 = r9.Z     // Catch:{ all -> 0x0017 }
                java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ all -> 0x0017 }
                r10[r0] = r9     // Catch:{ all -> 0x0017 }
                r7.<init>(r8, r10)     // Catch:{ all -> 0x0017 }
                r3.execute(r7)     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                if (r6 == 0) goto L_0x008d
                int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r2 == 0) goto L_0x008d
                int r2 = r6.length
            L_0x007f:
                if (r0 >= r2) goto L_0x008d
                r3 = r6[r0]
                monitor-enter(r3)
                r3.c(r12)     // Catch:{ all -> 0x008a }
                monitor-exit(r3)     // Catch:{ all -> 0x008a }
                int r0 = r0 + r1
                goto L_0x007f
            L_0x008a:
                r12 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x008a }
                throw r12
            L_0x008d:
                return
            L_0x008e:
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.b(boolean, okhttp3.internal.http2.Settings):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
            r1.s(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
            if (r8 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
            r1.r();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(boolean r8, int r9, int r10, java.util.List<okhttp3.internal.http2.Header> r11) {
            /*
                r7 = this;
                r10 = 2
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
                boolean r0 = r0.C(r9)
                if (r0 == 0) goto L_0x000f
                okhttp3.internal.http2.Http2Connection r10 = okhttp3.internal.http2.Http2Connection.this
                r10.w(r9, r11, r8)
                return
            L_0x000f:
                okhttp3.internal.http2.Http2Connection r0 = okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0022 }
                okhttp3.internal.http2.Http2Stream r1 = r1.n(r9)     // Catch:{ all -> 0x0022 }
                if (r1 != 0) goto L_0x006f
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0022 }
                boolean r2 = r1.Z2     // Catch:{ all -> 0x0022 }
                if (r2 == 0) goto L_0x0024
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x0022:
                r8 = move-exception
                goto L_0x0079
            L_0x0024:
                int r2 = r1.X2     // Catch:{ all -> 0x0022 }
                if (r9 > r2) goto L_0x002a
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x002a:
                int r2 = r9 % 2
                int r1 = r1.Y2     // Catch:{ all -> 0x0022 }
                int r1 = r1 % r10
                if (r2 != r1) goto L_0x0033
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x0033:
                okhttp3.Headers r6 = okhttp3.internal.Util.I(r11)     // Catch:{ all -> 0x0022 }
                okhttp3.internal.http2.Http2Stream r11 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0022 }
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0022 }
                r4 = 0
                r1 = r11
                r2 = r9
                r5 = r8
                r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
                okhttp3.internal.http2.Http2Connection r8 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0022 }
                r8.X2 = r9     // Catch:{ all -> 0x0022 }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r8 = r8.Y     // Catch:{ all -> 0x0022 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0022 }
                r8.put(r1, r11)     // Catch:{ all -> 0x0022 }
                java.util.concurrent.ExecutorService r8 = okhttp3.internal.http2.Http2Connection.o3     // Catch:{ all -> 0x0022 }
                okhttp3.internal.http2.Http2Connection$ReaderRunnable$1 r1 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x0022 }
                java.lang.String r2 = "OkHttp %s stream %d"
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = r3.Z     // Catch:{ all -> 0x0022 }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0022 }
                java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x0022 }
                r4 = 0
                r10[r4] = r3     // Catch:{ all -> 0x0022 }
                r3 = 1
                r10[r3] = r9     // Catch:{ all -> 0x0022 }
                r1.<init>(r2, r10, r11)     // Catch:{ all -> 0x0022 }
                r8.execute(r1)     // Catch:{ all -> 0x0022 }
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x006f:
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                r1.s(r11)
                if (r8 == 0) goto L_0x0078
                r1.r()
            L_0x0078:
                return
            L_0x0079:
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.c(boolean, int, int, java.util.List):void");
        }

        public void d(int i2, long j2) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i2 == 0) {
                synchronized (http2Connection) {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.f3 += j2;
                    http2Connection2.notifyAll();
                }
                return;
            }
            Http2Stream n2 = http2Connection.n(i2);
            if (n2 != null) {
                synchronized (n2) {
                    n2.c(j2);
                }
            }
        }

        public void e(int i2, String str, ByteString byteString, String str2, int i3, long j2) {
        }

        public void f(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            if (Http2Connection.this.C(i2)) {
                Http2Connection.this.u(i2, bufferedSource, i3, z);
                return;
            }
            Http2Stream n2 = Http2Connection.this.n(i2);
            if (n2 == null) {
                Http2Connection.this.S(i2, ErrorCode.PROTOCOL_ERROR);
                long j2 = (long) i3;
                Http2Connection.this.L(j2);
                bufferedSource.skip(j2);
                return;
            }
            n2.q(bufferedSource, i3);
            if (z) {
                n2.r();
            }
        }

        public void g(boolean z, int i2, int i3) {
            if (z) {
                synchronized (Http2Connection.this) {
                    boolean unused = Http2Connection.this.d3 = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.a3.execute(new PingRunnable(true, i2, i3));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public void h(int i2, int i3, int i4, boolean z) {
        }

        public void i(int i2, ErrorCode errorCode) {
            if (Http2Connection.this.C(i2)) {
                Http2Connection.this.y(i2, errorCode);
                return;
            }
            Http2Stream F = Http2Connection.this.F(i2);
            if (F != null) {
                F.t(errorCode);
            }
        }

        public void j(int i2, int i3, List<Header> list) {
            Http2Connection.this.x(i3, list);
        }

        public void k(int i2, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.m0();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.Y.values().toArray(new Http2Stream[Http2Connection.this.Y.size()]);
                Http2Connection.this.Z2 = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.k() > i2 && http2Stream.n()) {
                    http2Stream.t(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.F(http2Stream.k());
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4.Y.h(r0, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l() {
            /*
                r4 = this;
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                okhttp3.internal.http2.Http2Reader r1 = r4.X     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r1.d(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            L_0x0007:
                okhttp3.internal.http2.Http2Reader r1 = r4.X     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r2 = 0
                boolean r1 = r1.c(r2, r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0026 }
                okhttp3.internal.http2.Http2Connection r2 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r2.h(r1, r0)     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                okhttp3.internal.http2.Http2Reader r0 = r4.X
                okhttp3.internal.Util.g(r0)
                goto L_0x002e
            L_0x0020:
                r2 = move-exception
                goto L_0x002f
            L_0x0022:
                r2 = move-exception
                r1 = r0
                goto L_0x002f
            L_0x0025:
                r1 = r0
            L_0x0026:
                okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0020 }
                okhttp3.internal.http2.Http2Connection r1 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r1.h(r0, r0)     // Catch:{ IOException -> 0x001a }
                goto L_0x001a
            L_0x002e:
                return
            L_0x002f:
                okhttp3.internal.http2.Http2Connection r3 = okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0034 }
                r3.h(r1, r0)     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                okhttp3.internal.http2.Http2Reader r0 = r4.X
                okhttp3.internal.Util.g(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.l():void");
        }
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.h3 = settings;
        this.i3 = false;
        this.m3 = new LinkedHashSet();
        this.c3 = builder2.f31188f;
        boolean z = builder2.f31189g;
        this.s = z;
        this.X = builder2.f31187e;
        int i2 = z ? 1 : 2;
        this.Y2 = i2;
        if (z) {
            this.Y2 = i2 + 2;
        }
        if (z) {
            this.g3.k(7, 16777216);
        }
        String str = builder2.f31184b;
        this.Z = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.H(Util.s("OkHttp %s Writer", str), false));
        this.a3 = scheduledThreadPoolExecutor;
        if (builder2.f31190h != 0) {
            PingRunnable pingRunnable = new PingRunnable(false, 0, 0);
            int i4 = builder2.f31190h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, (long) i4, (long) i4, TimeUnit.MILLISECONDS);
        }
        this.b3 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.H(Util.s("OkHttp %s Push Observer", str), true));
        settings.k(7, 65535);
        settings.k(5, 16384);
        this.f3 = (long) settings.e();
        this.j3 = builder2.f31183a;
        this.k3 = new Http2Writer(builder2.f31186d, z);
        this.l3 = new ReaderRunnable(new Http2Reader(builder2.f31185c, z));
    }

    /* access modifiers changed from: private */
    public void i() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            h(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x0013, all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.Http2Stream r(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            okhttp3.internal.http2.Http2Writer r7 = r10.k3
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0056 }
            int r0 = r10.Y2     // Catch:{ all -> 0x0013 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0015
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0013 }
            r10.H(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            r11 = move-exception
            goto L_0x0078
        L_0x0015:
            boolean r0 = r10.Z2     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0072
            int r8 = r10.Y2     // Catch:{ all -> 0x0013 }
            int r0 = r8 + 2
            r10.Y2 = r0     // Catch:{ all -> 0x0013 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0013 }
            r5 = 0
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0013 }
            if (r13 == 0) goto L_0x003d
            long r0 = r10.f3     // Catch:{ all -> 0x0013 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003d
            long r0 = r9.f31194b     // Catch:{ all -> 0x0013 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r13 = 0
            goto L_0x003e
        L_0x003d:
            r13 = 1
        L_0x003e:
            boolean r0 = r9.o()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x004d
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r10.Y     // Catch:{ all -> 0x0013 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0013 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0013 }
        L_0x004d:
            monitor-exit(r10)     // Catch:{ all -> 0x0013 }
            if (r11 != 0) goto L_0x0058
            okhttp3.internal.http2.Http2Writer r0 = r10.k3     // Catch:{ all -> 0x0056 }
            r0.u(r6, r8, r11, r12)     // Catch:{ all -> 0x0056 }
            goto L_0x0061
        L_0x0056:
            r11 = move-exception
            goto L_0x007a
        L_0x0058:
            boolean r0 = r10.s     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x006a
            okhttp3.internal.http2.Http2Writer r0 = r10.k3     // Catch:{ all -> 0x0056 }
            r0.q(r11, r8, r12)     // Catch:{ all -> 0x0056 }
        L_0x0061:
            monitor-exit(r7)     // Catch:{ all -> 0x0056 }
            if (r13 == 0) goto L_0x0069
            okhttp3.internal.http2.Http2Writer r11 = r10.k3
            r11.flush()
        L_0x0069:
            return r9
        L_0x006a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0056 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0056 }
            throw r11     // Catch:{ all -> 0x0056 }
        L_0x0072:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0013 }
            r11.<init>()     // Catch:{ all -> 0x0013 }
            throw r11     // Catch:{ all -> 0x0013 }
        L_0x0078:
            monitor-exit(r10)     // Catch:{ all -> 0x0013 }
            throw r11     // Catch:{ all -> 0x0056 }
        L_0x007a:
            monitor-exit(r7)     // Catch:{ all -> 0x0056 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.r(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    private synchronized void v(NamedRunnable namedRunnable) {
        if (!p()) {
            this.b3.execute(namedRunnable);
        }
    }

    public Http2Stream A(int i2, List<Header> list, boolean z) throws IOException {
        if (!this.s) {
            return r(i2, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: package-private */
    public boolean C(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream F(int i2) {
        Http2Stream remove;
        remove = this.Y.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public void G(Settings settings) throws IOException {
        synchronized (this.k3) {
            synchronized (this) {
                if (!this.Z2) {
                    this.g3.j(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.k3.s(settings);
        }
    }

    public void H(ErrorCode errorCode) throws IOException {
        synchronized (this.k3) {
            synchronized (this) {
                if (!this.Z2) {
                    this.Z2 = true;
                    int i2 = this.X2;
                    this.k3.h(i2, errorCode, Util.f30970a);
                }
            }
        }
    }

    public void I() throws IOException {
        J(true);
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z) throws IOException {
        if (z) {
            this.k3.c();
            this.k3.s(this.g3);
            int e2 = this.g3.e();
            if (e2 != 65535) {
                this.k3.v(0, (long) (e2 - 65535));
            }
        }
        new Thread(this.l3).start();
    }

    /* access modifiers changed from: package-private */
    public synchronized void L(long j2) {
        long j4 = this.e3 + j2;
        this.e3 = j4;
        if (j4 >= ((long) (this.g3.e() / 2))) {
            T(0, this.e3);
            this.e3 = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.k3.n());
        r6 = (long) r3;
        r8.f3 -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.Http2Writer r12 = r8.k3
            r12.d(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f3     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0032
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r8.Y     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            r9 = move-exception
            goto L_0x0065
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0032:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0028 }
            int r4 = (int) r3     // Catch:{ all -> 0x0028 }
            okhttp3.internal.http2.Http2Writer r3 = r8.k3     // Catch:{ all -> 0x0028 }
            int r3 = r3.n()     // Catch:{ all -> 0x0028 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0028 }
            long r4 = r8.f3     // Catch:{ all -> 0x0028 }
            long r6 = (long) r3     // Catch:{ all -> 0x0028 }
            long r4 = r4 - r6
            r8.f3 = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.k3
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.d(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0028 }
            r9.interrupt()     // Catch:{ all -> 0x0028 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            throw r9     // Catch:{ all -> 0x0028 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.N(int, boolean, okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z, int i2, int i4) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.d3;
                this.d3 = true;
            }
            if (z2) {
                i();
                return;
            }
        }
        try {
            this.k3.p(z, i2, i4);
        } catch (IOException unused) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void P() throws InterruptedException {
        O(false, 1330343787, -257978967);
        f();
    }

    /* access modifiers changed from: package-private */
    public void Q(int i2, boolean z, List<Header> list) throws IOException {
        this.k3.t(z, i2, list);
    }

    /* access modifiers changed from: package-private */
    public void R(int i2, ErrorCode errorCode) throws IOException {
        this.k3.r(i2, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void S(int i2, ErrorCode errorCode) {
        try {
            final int i4 = i2;
            final ErrorCode errorCode2 = errorCode;
            this.a3.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.Z, Integer.valueOf(i2)}) {
                public void l() {
                    try {
                        Http2Connection.this.R(i4, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.i();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int i2, long j2) {
        try {
            final int i4 = i2;
            final long j4 = j2;
            this.a3.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.Z, Integer.valueOf(i2)}) {
                public void l() {
                    try {
                        Http2Connection.this.k3.v(i4, j4);
                    } catch (IOException unused) {
                        Http2Connection.this.i();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void close() throws IOException {
        h(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    public synchronized void f() throws InterruptedException {
        while (this.d3) {
            wait();
        }
    }

    public void flush() throws IOException {
        this.k3.flush();
    }

    /* access modifiers changed from: package-private */
    public void h(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            H(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            try {
                if (!this.Y.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.Y.values().toArray(new Http2Stream[this.Y.size()]);
                    this.Y.clear();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream f2 : http2StreamArr) {
                try {
                    f2.f(errorCode2);
                } catch (IOException e4) {
                    if (e != null) {
                        e = e4;
                    }
                }
            }
        }
        try {
            this.k3.close();
        } catch (IOException e5) {
            if (e == null) {
                e = e5;
            }
        }
        try {
            this.j3.close();
        } catch (IOException e6) {
            e = e6;
        }
        this.a3.shutdown();
        this.b3.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public Protocol k() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream n(int i2) {
        return this.Y.get(Integer.valueOf(i2));
    }

    public synchronized boolean p() {
        return this.Z2;
    }

    public synchronized int q() {
        return this.h3.f(Integer.MAX_VALUE);
    }

    public Http2Stream s(List<Header> list, boolean z) throws IOException {
        return r(0, list, z);
    }

    public synchronized int t() {
        return this.Y.size();
    }

    /* access modifiers changed from: package-private */
    public void u(int i2, BufferedSource bufferedSource, int i4, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j2 = (long) i4;
        bufferedSource.I2(j2);
        bufferedSource.n2(buffer, j2);
        if (buffer.L0() == j2) {
            final int i5 = i2;
            final int i6 = i4;
            final boolean z2 = z;
            v(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.Z, Integer.valueOf(i2)}) {
                public void l() {
                    try {
                        boolean d2 = Http2Connection.this.c3.d(i5, buffer, i6, z2);
                        if (d2) {
                            Http2Connection.this.k3.r(i5, ErrorCode.CANCEL);
                        }
                        if (d2 || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.m3.remove(Integer.valueOf(i5));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.L0() + " != " + i4);
    }

    /* access modifiers changed from: package-private */
    public void w(int i2, List<Header> list, boolean z) {
        try {
            final int i4 = i2;
            final List<Header> list2 = list;
            final boolean z2 = z;
            v(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.Z, Integer.valueOf(i2)}) {
                public void l() {
                    boolean b2 = Http2Connection.this.c3.b(i4, list2, z2);
                    if (b2) {
                        try {
                            Http2Connection.this.k3.r(i4, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (b2 || z2) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.m3.remove(Integer.valueOf(i4));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void x(int i2, List<Header> list) {
        synchronized (this) {
            try {
                if (this.m3.contains(Integer.valueOf(i2))) {
                    S(i2, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                this.m3.add(Integer.valueOf(i2));
                try {
                    final int i4 = i2;
                    final List<Header> list2 = list;
                    v(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.Z, Integer.valueOf(i2)}) {
                        public void l() {
                            if (Http2Connection.this.c3.a(i4, list2)) {
                                try {
                                    Http2Connection.this.k3.r(i4, ErrorCode.CANCEL);
                                    synchronized (Http2Connection.this) {
                                        Http2Connection.this.m3.remove(Integer.valueOf(i4));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y(int i2, ErrorCode errorCode) {
        final int i4 = i2;
        final ErrorCode errorCode2 = errorCode;
        v(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.Z, Integer.valueOf(i2)}) {
            public void l() {
                Http2Connection.this.c3.c(i4, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.m3.remove(Integer.valueOf(i4));
                }
            }
        });
    }
}
