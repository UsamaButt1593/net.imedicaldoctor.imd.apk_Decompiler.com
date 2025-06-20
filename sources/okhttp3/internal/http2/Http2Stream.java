package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ boolean f31192m = false;

    /* renamed from: a  reason: collision with root package name */
    long f31193a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f31194b;

    /* renamed from: c  reason: collision with root package name */
    final int f31195c;

    /* renamed from: d  reason: collision with root package name */
    final Http2Connection f31196d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Deque<Headers> f31197e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Header.Listener f31198f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31199g;

    /* renamed from: h  reason: collision with root package name */
    private final FramingSource f31200h;

    /* renamed from: i  reason: collision with root package name */
    final FramingSink f31201i;

    /* renamed from: j  reason: collision with root package name */
    final StreamTimeout f31202j;

    /* renamed from: k  reason: collision with root package name */
    final StreamTimeout f31203k;

    /* renamed from: l  reason: collision with root package name */
    ErrorCode f31204l;

    final class FramingSink implements Sink {
        private static final long X2 = 16384;
        static final /* synthetic */ boolean Y2 = false;
        boolean X;
        boolean Y;
        private final Buffer s = new Buffer();

        FramingSink() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.f31203k.E();
            r11.Z.e();
            r9 = java.lang.Math.min(r11.Z.f31194b, r11.s.L0());
            r1 = r11.Z;
            r1.f31194b -= r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.f31203k     // Catch:{ all -> 0x0079 }
                r1.w()     // Catch:{ all -> 0x0079 }
            L_0x000a:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0024 }
                long r2 = r1.f31194b     // Catch:{ all -> 0x0024 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0026
                boolean r2 = r11.Y     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                boolean r2 = r11.X     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                okhttp3.internal.http2.ErrorCode r2 = r1.f31204l     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0026
                r1.w()     // Catch:{ all -> 0x0024 }
                goto L_0x000a
            L_0x0024:
                r12 = move-exception
                goto L_0x007b
            L_0x0026:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.f31203k     // Catch:{ all -> 0x0079 }
                r1.E()     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                r1.e()     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                long r1 = r1.f31194b     // Catch:{ all -> 0x0079 }
                okio.Buffer r3 = r11.s     // Catch:{ all -> 0x0079 }
                long r3 = r3.L0()     // Catch:{ all -> 0x0079 }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                long r2 = r1.f31194b     // Catch:{ all -> 0x0079 }
                long r2 = r2 - r9
                r1.f31194b = r2     // Catch:{ all -> 0x0079 }
                monitor-exit(r0)     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r1.f31203k
                r0.w()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0060 }
                okhttp3.internal.http2.Http2Connection r5 = r0.f31196d     // Catch:{ all -> 0x0060 }
                int r6 = r0.f31195c     // Catch:{ all -> 0x0060 }
                if (r12 == 0) goto L_0x0062
                okio.Buffer r12 = r11.s     // Catch:{ all -> 0x0060 }
                long r0 = r12.L0()     // Catch:{ all -> 0x0060 }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x0062
                r12 = 1
                r7 = 1
                goto L_0x0064
            L_0x0060:
                r12 = move-exception
                goto L_0x0071
            L_0x0062:
                r12 = 0
                r7 = 0
            L_0x0064:
                okio.Buffer r8 = r11.s     // Catch:{ all -> 0x0060 }
                r5.N(r6, r7, r8, r9)     // Catch:{ all -> 0x0060 }
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r12 = r12.f31203k
                r12.E()
                return
            L_0x0071:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.f31203k
                r0.E()
                throw r12
            L_0x0079:
                r12 = move-exception
                goto L_0x0083
            L_0x007b:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0079 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.f31203k     // Catch:{ all -> 0x0079 }
                r1.E()     // Catch:{ all -> 0x0079 }
                throw r12     // Catch:{ all -> 0x0079 }
            L_0x0083:
                monitor-exit(r0)     // Catch:{ all -> 0x0079 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.b(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r8.Z.f31201i.Y != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r8.s.L0() <= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r8.s.L0() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            b(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            r0 = r8.Z;
            r0.f31196d.N(r0.f31195c, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r2 = r8.Z;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r8.X = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r8.Z.f31196d.flush();
            r8.Z.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.X     // Catch:{ all -> 0x0009 }
                if (r1 == 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x0052
            L_0x000b:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r0 = r0.f31201i
                boolean r0 = r0.Y
                r1 = 1
                if (r0 != 0) goto L_0x003c
                okio.Buffer r0 = r8.s
                long r2 = r0.L0()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002f
            L_0x0021:
                okio.Buffer r0 = r8.s
                long r2 = r0.L0()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.b(r1)
                goto L_0x0021
            L_0x002f:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r2 = r0.f31196d
                int r3 = r0.f31195c
                r5 = 0
                r6 = 0
                r4 = 1
                r2.N(r3, r4, r5, r6)
            L_0x003c:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.X = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.f31196d
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.d()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }

        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.e();
            }
            while (this.s.L0() > 0) {
                b(false);
                Http2Stream.this.f31196d.flush();
            }
        }

        public Timeout j() {
            return Http2Stream.this.f31203k;
        }

        public void u1(Buffer buffer, long j2) throws IOException {
            this.s.u1(buffer, j2);
            while (this.s.L0() >= 16384) {
                b(false);
            }
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean Z2 = false;
        private final Buffer X = new Buffer();
        boolean X2;
        private final long Y;
        boolean Z;
        private final Buffer s = new Buffer();

        FramingSource(long j2) {
            this.Y = j2;
        }

        private void c(long j2) {
            Http2Stream.this.f31196d.L(j2);
        }

        /* access modifiers changed from: package-private */
        public void b(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j2 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.X2;
                    z2 = false;
                    z3 = this.X.L0() + j2 > this.Y;
                }
                if (z3) {
                    bufferedSource.skip(j2);
                    Http2Stream.this.h(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j2);
                    return;
                } else {
                    long n2 = bufferedSource.n2(this.s, j2);
                    if (n2 != -1) {
                        j2 -= n2;
                        synchronized (Http2Stream.this) {
                            try {
                                if (this.X.L0() == 0) {
                                    z2 = true;
                                }
                                this.X.y1(this.s);
                                if (z2) {
                                    Http2Stream.this.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public void close() throws IOException {
            long L0;
            Header.Listener listener;
            ArrayList<Headers> arrayList;
            synchronized (Http2Stream.this) {
                try {
                    this.Z = true;
                    L0 = this.X.L0();
                    this.X.d();
                    if (Http2Stream.this.f31197e.isEmpty() || Http2Stream.this.f31198f == null) {
                        arrayList = null;
                        listener = null;
                    } else {
                        arrayList = new ArrayList<>(Http2Stream.this.f31197e);
                        Http2Stream.this.f31197e.clear();
                        listener = Http2Stream.this.f31198f;
                    }
                    Http2Stream.this.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (L0 > 0) {
                c(L0);
            }
            Http2Stream.this.d();
            if (listener != null) {
                for (Headers a2 : arrayList) {
                    listener.a(a2);
                }
            }
        }

        public Timeout j() {
            return Http2Stream.this.f31202j;
        }

        /* JADX INFO: finally extract failed */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: okhttp3.Headers} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long n2(okio.Buffer r17, long r18) throws java.io.IOException {
            /*
                r16 = this;
                r1 = r16
                r2 = r18
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x00e4
            L_0x000a:
                okhttp3.internal.http2.Http2Stream r6 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r6)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00a9 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.f31202j     // Catch:{ all -> 0x00a9 }
                r0.w()     // Catch:{ all -> 0x00a9 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.ErrorCode r7 = r0.f31204l     // Catch:{ all -> 0x004b }
                if (r7 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r7 = 0
            L_0x001c:
                boolean r9 = r1.Z     // Catch:{ all -> 0x004b }
                if (r9 != 0) goto L_0x00d2
                java.util.Deque r0 = r0.f31197e     // Catch:{ all -> 0x004b }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004b }
                if (r0 != 0) goto L_0x004e
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Header$Listener r0 = r0.f31198f     // Catch:{ all -> 0x004b }
                if (r0 == 0) goto L_0x004e
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                java.util.Deque r0 = r0.f31197e     // Catch:{ all -> 0x004b }
                java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x004b }
                r8 = r0
                okhttp3.Headers r8 = (okhttp3.Headers) r8     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Header$Listener r0 = r0.f31198f     // Catch:{ all -> 0x004b }
                r13 = r17
                r10 = r0
            L_0x0048:
                r11 = -1
                goto L_0x00ae
            L_0x004b:
                r0 = move-exception
                goto L_0x00da
            L_0x004e:
                okio.Buffer r0 = r1.X     // Catch:{ all -> 0x004b }
                long r11 = r0.L0()     // Catch:{ all -> 0x004b }
                int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0092
                okio.Buffer r0 = r1.X     // Catch:{ all -> 0x004b }
                long r11 = r0.L0()     // Catch:{ all -> 0x004b }
                long r11 = java.lang.Math.min(r2, r11)     // Catch:{ all -> 0x004b }
                r13 = r17
                long r11 = r0.n2(r13, r11)     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                long r14 = r0.f31193a     // Catch:{ all -> 0x004b }
                long r14 = r14 + r11
                r0.f31193a = r14     // Catch:{ all -> 0x004b }
                if (r7 != 0) goto L_0x008f
                okhttp3.internal.http2.Http2Connection r0 = r0.f31196d     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Settings r0 = r0.g3     // Catch:{ all -> 0x004b }
                int r0 = r0.e()     // Catch:{ all -> 0x004b }
                int r0 = r0 / 2
                long r8 = (long) r0     // Catch:{ all -> 0x004b }
                int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r0 < 0) goto L_0x008f
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Http2Connection r8 = r0.f31196d     // Catch:{ all -> 0x004b }
                int r9 = r0.f31195c     // Catch:{ all -> 0x004b }
                long r14 = r0.f31193a     // Catch:{ all -> 0x004b }
                r8.T(r9, r14)     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                r0.f31193a = r4     // Catch:{ all -> 0x004b }
            L_0x008f:
                r8 = 0
                r10 = 0
                goto L_0x00ae
            L_0x0092:
                r13 = r17
                boolean r0 = r1.X2     // Catch:{ all -> 0x004b }
                if (r0 != 0) goto L_0x00ab
                if (r7 != 0) goto L_0x00ab
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x004b }
                r0.w()     // Catch:{ all -> 0x004b }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00a9 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.f31202j     // Catch:{ all -> 0x00a9 }
                r0.E()     // Catch:{ all -> 0x00a9 }
                monitor-exit(r6)     // Catch:{ all -> 0x00a9 }
                goto L_0x000a
            L_0x00a9:
                r0 = move-exception
                goto L_0x00e2
            L_0x00ab:
                r8 = 0
                r10 = 0
                goto L_0x0048
            L_0x00ae:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00a9 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.f31202j     // Catch:{ all -> 0x00a9 }
                r0.E()     // Catch:{ all -> 0x00a9 }
                monitor-exit(r6)     // Catch:{ all -> 0x00a9 }
                if (r8 == 0) goto L_0x00bf
                if (r10 == 0) goto L_0x00bf
                r10.a(r8)
                goto L_0x000a
            L_0x00bf:
                r2 = -1
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x00c9
                r1.c(r11)
                return r11
            L_0x00c9:
                if (r7 != 0) goto L_0x00cc
                return r2
            L_0x00cc:
                okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException
                r0.<init>(r7)
                throw r0
            L_0x00d2:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x004b }
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch:{ all -> 0x004b }
                throw r0     // Catch:{ all -> 0x004b }
            L_0x00da:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00a9 }
                okhttp3.internal.http2.Http2Stream$StreamTimeout r2 = r2.f31202j     // Catch:{ all -> 0x00a9 }
                r2.E()     // Catch:{ all -> 0x00a9 }
                throw r0     // Catch:{ all -> 0x00a9 }
            L_0x00e2:
                monitor-exit(r6)     // Catch:{ all -> 0x00a9 }
                throw r0
            L_0x00e4:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "byteCount < 0: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.n2(okio.Buffer, long):long");
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        /* access modifiers changed from: protected */
        public void C() {
            Http2Stream.this.h(ErrorCode.CANCEL);
        }

        public void E() throws IOException {
            if (x()) {
                throw y((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException y(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f31197e = arrayDeque;
        this.f31202j = new StreamTimeout();
        this.f31203k = new StreamTimeout();
        this.f31204l = null;
        if (http2Connection != null) {
            this.f31195c = i2;
            this.f31196d = http2Connection;
            this.f31194b = (long) http2Connection.h3.e();
            FramingSource framingSource = new FramingSource((long) http2Connection.g3.e());
            this.f31200h = framingSource;
            FramingSink framingSink = new FramingSink();
            this.f31201i = framingSink;
            framingSource.X2 = z2;
            framingSink.Y = z;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (n() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!n() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    private boolean g(ErrorCode errorCode) {
        synchronized (this) {
            try {
                if (this.f31204l != null) {
                    return false;
                }
                if (this.f31200h.X2 && this.f31201i.Y) {
                    return false;
                }
                this.f31204l = errorCode;
                notifyAll();
                this.f31196d.F(this.f31195c);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j2) {
        this.f31194b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() throws IOException {
        boolean z;
        boolean o;
        synchronized (this) {
            try {
                FramingSource framingSource = this.f31200h;
                if (!framingSource.X2 && framingSource.Z) {
                    FramingSink framingSink = this.f31201i;
                    if (!framingSink.Y) {
                        if (framingSink.X) {
                        }
                    }
                    z = true;
                    o = o();
                }
                z = false;
                o = o();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z) {
            f(ErrorCode.CANCEL);
        } else if (!o) {
            this.f31196d.F(this.f31195c);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() throws IOException {
        FramingSink framingSink = this.f31201i;
        if (framingSink.X) {
            throw new IOException("stream closed");
        } else if (framingSink.Y) {
            throw new IOException("stream finished");
        } else if (this.f31204l != null) {
            throw new StreamResetException(this.f31204l);
        }
    }

    public void f(ErrorCode errorCode) throws IOException {
        if (g(errorCode)) {
            this.f31196d.R(this.f31195c, errorCode);
        }
    }

    public void h(ErrorCode errorCode) {
        if (g(errorCode)) {
            this.f31196d.S(this.f31195c, errorCode);
        }
    }

    public Http2Connection i() {
        return this.f31196d;
    }

    public synchronized ErrorCode j() {
        return this.f31204l;
    }

    public int k() {
        return this.f31195c;
    }

    public Sink l() {
        synchronized (this) {
            try {
                if (!this.f31199g) {
                    if (!n()) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.f31201i;
    }

    public Source m() {
        return this.f31200h;
    }

    public boolean n() {
        return this.f31196d.s == ((this.f31195c & 1) == 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean o() {
        /*
            r3 = this;
            monitor-enter(r3)
            okhttp3.internal.http2.ErrorCode r0 = r3.f31204l     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r3.f31200h     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.X2     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r0 = r0.Z     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0028
        L_0x0015:
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r3.f31201i     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.Y     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x001f
            boolean r0 = r0.X     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
        L_0x001f:
            boolean r0 = r3.f31199g     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            return r1
        L_0x0025:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0013 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.o():boolean");
    }

    public Timeout p() {
        return this.f31202j;
    }

    /* access modifiers changed from: package-private */
    public void q(BufferedSource bufferedSource, int i2) throws IOException {
        this.f31200h.b(bufferedSource, (long) i2);
    }

    /* access modifiers changed from: package-private */
    public void r() {
        boolean o;
        synchronized (this) {
            this.f31200h.X2 = true;
            o = o();
            notifyAll();
        }
        if (!o) {
            this.f31196d.F(this.f31195c);
        }
    }

    /* access modifiers changed from: package-private */
    public void s(List<Header> list) {
        boolean o;
        synchronized (this) {
            this.f31199g = true;
            this.f31197e.add(Util.I(list));
            o = o();
            notifyAll();
        }
        if (!o) {
            this.f31196d.F(this.f31195c);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void t(ErrorCode errorCode) {
        if (this.f31204l == null) {
            this.f31204l = errorCode;
            notifyAll();
        }
    }

    public synchronized void u(Header.Listener listener) {
        this.f31198f = listener;
        if (!this.f31197e.isEmpty() && listener != null) {
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized Headers v() throws IOException {
        this.f31202j.w();
        while (this.f31197e.isEmpty() && this.f31204l == null) {
            try {
                w();
            } catch (Throwable th) {
                this.f31202j.E();
                throw th;
            }
        }
        this.f31202j.E();
        if (!this.f31197e.isEmpty()) {
        } else {
            throw new StreamResetException(this.f31204l);
        }
        return this.f31197e.removeFirst();
    }

    /* access modifiers changed from: package-private */
    public void w() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void x(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (list != null) {
            synchronized (this) {
                z2 = true;
                try {
                    this.f31199g = true;
                    if (!z) {
                        this.f31201i.Y = true;
                        z3 = true;
                        z4 = true;
                    } else {
                        z3 = false;
                        z4 = false;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (!z3) {
                synchronized (this.f31196d) {
                    if (this.f31196d.f3 != 0) {
                        z2 = false;
                    }
                }
                z3 = z2;
            }
            this.f31196d.Q(this.f31195c, z4, list);
            if (z3) {
                this.f31196d.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout y() {
        return this.f31203k;
    }
}
