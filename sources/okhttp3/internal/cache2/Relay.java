package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {

    /* renamed from: k  reason: collision with root package name */
    private static final int f31012k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f31013l = 2;

    /* renamed from: m  reason: collision with root package name */
    static final ByteString f31014m = ByteString.n("OkHttp cache v1\n");

    /* renamed from: n  reason: collision with root package name */
    static final ByteString f31015n = ByteString.n("OkHttp DIRTY :(\n");
    private static final long o = 32;

    /* renamed from: a  reason: collision with root package name */
    RandomAccessFile f31016a;

    /* renamed from: b  reason: collision with root package name */
    Thread f31017b;

    /* renamed from: c  reason: collision with root package name */
    Source f31018c;

    /* renamed from: d  reason: collision with root package name */
    final Buffer f31019d = new Buffer();

    /* renamed from: e  reason: collision with root package name */
    long f31020e;

    /* renamed from: f  reason: collision with root package name */
    boolean f31021f;

    /* renamed from: g  reason: collision with root package name */
    private final ByteString f31022g;

    /* renamed from: h  reason: collision with root package name */
    final Buffer f31023h = new Buffer();

    /* renamed from: i  reason: collision with root package name */
    final long f31024i;

    /* renamed from: j  reason: collision with root package name */
    int f31025j;

    class RelaySource implements Source {
        private FileOperator X;
        private long Y;
        private final Timeout s = new Timeout();

        RelaySource() {
            this.X = new FileOperator(Relay.this.f31016a.getChannel());
        }

        public void close() throws IOException {
            if (this.X != null) {
                RandomAccessFile randomAccessFile = null;
                this.X = null;
                synchronized (Relay.this) {
                    try {
                        Relay relay = Relay.this;
                        int i2 = relay.f31025j - 1;
                        relay.f31025j = i2;
                        if (i2 == 0) {
                            RandomAccessFile randomAccessFile2 = relay.f31016a;
                            relay.f31016a = null;
                            randomAccessFile = randomAccessFile2;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (randomAccessFile != null) {
                    Util.g(randomAccessFile);
                }
            }
        }

        public Timeout j() {
            return this.s;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r0 = r1.Z;
            r5 = r0.f31018c.n2(r0.f31019d, r0.f31024i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            if (r5 != -1) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
            r1.Z.a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
            r2 = r1.Z;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            r0 = r1.Z;
            r0.f31017b = null;
            r0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0058, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r2 = java.lang.Math.min(r5, r2);
            r1.Z.f31019d.r(r22, 0, r2);
            r1.Y += r2;
            r1.X.b(r7 + 32, r1.Z.f31019d.clone(), r5);
            r7 = r1.Z;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0082, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r0 = r1.Z;
            r0.f31023h.u1(r0.f31019d, r5);
            r8 = r1.Z.f31023h.L0();
            r0 = r1.Z;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
            if (r8 <= r0.f31024i) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
            r0 = r0.f31023h;
            r0.skip(r0.L0() - r1.Z.f31024i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ad, code lost:
            r8 = r1.Z;
            r8.f31020e += r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b5, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r0 = r1.Z;
            r0.f31017b = null;
            r0.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bd, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00be, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c6, code lost:
            monitor-enter(r1.Z);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            r3 = r1.Z;
            r3.f31017b = null;
            r3.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cf, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r5 = r7 - r0.f31023h.L0();
            r11 = r1.Y;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00df, code lost:
            if (r11 >= r5) goto L_0x00f9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e2, code lost:
            r2 = java.lang.Math.min(r2, r7 - r11);
            r1.X.a(r1.Y + 32, r22, r2);
            r1.Y += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f8, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r11);
            r1.Z.f31023h.r(r22, r1.Y - r5, r2);
            r1.Y += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0112, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long n2(okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                okhttp3.internal.cache2.FileOperator r0 = r1.X
                if (r0 == 0) goto L_0x0115
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.Y     // Catch:{ all -> 0x001f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x001f }
                long r7 = r0.f31020e     // Catch:{ all -> 0x001f }
                r9 = 32
                int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r11 != 0) goto L_0x00d3
                boolean r5 = r0.f31021f     // Catch:{ all -> 0x001f }
                r11 = -1
                if (r5 == 0) goto L_0x0022
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                return r11
            L_0x001f:
                r0 = move-exception
                goto L_0x0113
            L_0x0022:
                java.lang.Thread r5 = r0.f31017b     // Catch:{ all -> 0x001f }
                if (r5 == 0) goto L_0x002c
                okio.Timeout r5 = r1.s     // Catch:{ all -> 0x001f }
                r5.k(r0)     // Catch:{ all -> 0x001f }
                goto L_0x000b
            L_0x002c:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001f }
                r0.f31017b = r5     // Catch:{ all -> 0x001f }
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                r4 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                okio.Source r5 = r0.f31018c     // Catch:{ all -> 0x0058 }
                okio.Buffer r6 = r0.f31019d     // Catch:{ all -> 0x0058 }
                long r13 = r0.f31024i     // Catch:{ all -> 0x0058 }
                long r5 = r5.n2(r6, r13)     // Catch:{ all -> 0x0058 }
                int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x005a
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                r0.a(r7)     // Catch:{ all -> 0x0058 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0055 }
                r0.f31017b = r4     // Catch:{ all -> 0x0055 }
                r0.notifyAll()     // Catch:{ all -> 0x0055 }
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                return r11
            L_0x0055:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                throw r0
            L_0x0058:
                r0 = move-exception
                goto L_0x00c4
            L_0x005a:
                long r2 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x0058 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                okio.Buffer r11 = r0.f31019d     // Catch:{ all -> 0x0058 }
                r13 = 0
                r12 = r22
                r15 = r2
                r11.r(r12, r13, r15)     // Catch:{ all -> 0x0058 }
                long r11 = r1.Y     // Catch:{ all -> 0x0058 }
                long r11 = r11 + r2
                r1.Y = r11     // Catch:{ all -> 0x0058 }
                okhttp3.internal.cache2.FileOperator r15 = r1.X     // Catch:{ all -> 0x0058 }
                long r16 = r7 + r9
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                okio.Buffer r0 = r0.f31019d     // Catch:{ all -> 0x0058 }
                okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x0058 }
                r19 = r5
                r15.b(r16, r18, r19)     // Catch:{ all -> 0x0058 }
                okhttp3.internal.cache2.Relay r7 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)     // Catch:{ all -> 0x0058 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ab }
                okio.Buffer r8 = r0.f31023h     // Catch:{ all -> 0x00ab }
                okio.Buffer r0 = r0.f31019d     // Catch:{ all -> 0x00ab }
                r8.u1(r0, r5)     // Catch:{ all -> 0x00ab }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ab }
                okio.Buffer r0 = r0.f31023h     // Catch:{ all -> 0x00ab }
                long r8 = r0.L0()     // Catch:{ all -> 0x00ab }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ab }
                long r10 = r0.f31024i     // Catch:{ all -> 0x00ab }
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x00ad
                okio.Buffer r0 = r0.f31023h     // Catch:{ all -> 0x00ab }
                long r8 = r0.L0()     // Catch:{ all -> 0x00ab }
                okhttp3.internal.cache2.Relay r10 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ab }
                long r10 = r10.f31024i     // Catch:{ all -> 0x00ab }
                long r8 = r8 - r10
                r0.skip(r8)     // Catch:{ all -> 0x00ab }
                goto L_0x00ad
            L_0x00ab:
                r0 = move-exception
                goto L_0x00c2
            L_0x00ad:
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ab }
                long r9 = r8.f31020e     // Catch:{ all -> 0x00ab }
                long r9 = r9 + r5
                r8.f31020e = r9     // Catch:{ all -> 0x00ab }
                monitor-exit(r7)     // Catch:{ all -> 0x00ab }
                monitor-enter(r8)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00bf }
                r0.f31017b = r4     // Catch:{ all -> 0x00bf }
                r0.notifyAll()     // Catch:{ all -> 0x00bf }
                monitor-exit(r8)     // Catch:{ all -> 0x00bf }
                return r2
            L_0x00bf:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x00bf }
                throw r0
            L_0x00c2:
                monitor-exit(r7)     // Catch:{ all -> 0x00ab }
                throw r0     // Catch:{ all -> 0x0058 }
            L_0x00c4:
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r3 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d0 }
                r3.f31017b = r4     // Catch:{ all -> 0x00d0 }
                r3.notifyAll()     // Catch:{ all -> 0x00d0 }
                monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
                throw r0
            L_0x00d0:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
                throw r0
            L_0x00d3:
                okio.Buffer r0 = r0.f31023h     // Catch:{ all -> 0x001f }
                long r5 = r0.L0()     // Catch:{ all -> 0x001f }
                long r5 = r7 - r5
                long r11 = r1.Y     // Catch:{ all -> 0x001f }
                int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00f9
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)
                okhttp3.internal.cache2.FileOperator r11 = r1.X
                long r4 = r1.Y
                long r12 = r4 + r9
                r14 = r22
                r15 = r2
                r11.a(r12, r14, r15)
                long r4 = r1.Y
                long r4 = r4 + r2
                r1.Y = r4
                return r2
            L_0x00f9:
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x001f }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x001f }
                okio.Buffer r9 = r0.f31023h     // Catch:{ all -> 0x001f }
                long r7 = r1.Y     // Catch:{ all -> 0x001f }
                long r11 = r7 - r5
                r10 = r22
                r13 = r2
                r9.r(r10, r11, r13)     // Catch:{ all -> 0x001f }
                long r5 = r1.Y     // Catch:{ all -> 0x001f }
                long r5 = r5 + r2
                r1.Y = r5     // Catch:{ all -> 0x001f }
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                return r2
            L_0x0113:
                monitor-exit(r4)     // Catch:{ all -> 0x001f }
                throw r0
            L_0x0115:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.n2(okio.Buffer, long):long");
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j2, ByteString byteString, long j3) {
        this.f31016a = randomAccessFile;
        this.f31018c = source;
        this.f31021f = source == null;
        this.f31020e = j2;
        this.f31022g = byteString;
        this.f31024i = j3;
    }

    public static Relay b(File file, Source source, ByteString byteString, long j2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j2);
        randomAccessFile.setLength(0);
        relay.g(f31015n, -1, -1);
        return relay;
    }

    public static Relay f(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.a(0, buffer, 32);
        ByteString byteString = f31014m;
        if (buffer.K((long) byteString.m0()).equals(byteString)) {
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            fileOperator.a(readLong + 32, buffer2, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer2.A1(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void g(ByteString byteString, long j2, long j3) throws IOException {
        Buffer buffer = new Buffer();
        buffer.g2(byteString);
        buffer.writeLong(j2);
        buffer.writeLong(j3);
        if (buffer.L0() == 32) {
            new FileOperator(this.f31016a.getChannel()).b(0, buffer, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void h(long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.g2(this.f31022g);
        new FileOperator(this.f31016a.getChannel()).b(32 + j2, buffer, (long) this.f31022g.m0());
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) throws IOException {
        h(j2);
        this.f31016a.getChannel().force(false);
        g(f31014m, j2, (long) this.f31022g.m0());
        this.f31016a.getChannel().force(false);
        synchronized (this) {
            this.f31021f = true;
        }
        Util.g(this.f31018c);
        this.f31018c = null;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f31016a == null;
    }

    public ByteString d() {
        return this.f31022g;
    }

    public Source e() {
        synchronized (this) {
            try {
                if (this.f31016a == null) {
                    return null;
                }
                this.f31025j++;
                return new RelaySource();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
