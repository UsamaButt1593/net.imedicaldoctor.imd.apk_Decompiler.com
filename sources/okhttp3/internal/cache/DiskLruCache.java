package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

public final class DiskLruCache implements Closeable, Flushable {
    static final String n3 = "journal";
    static final String o3 = "journal.tmp";
    static final String p3 = "journal.bkp";
    static final String q3 = "libcore.io.DiskLruCache";
    static final String r3 = "1";
    static final long s3 = -1;
    static final Pattern t3 = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final String u3 = "CLEAN";
    private static final String v3 = "DIRTY";
    private static final String w3 = "REMOVE";
    private static final String x3 = "READ";
    static final /* synthetic */ boolean y3 = false;
    final File X;
    private final File X2;
    private final File Y;
    private final int Y2;
    private final File Z;
    private long Z2;
    final int a3;
    private long b3 = 0;
    BufferedSink c3;
    final LinkedHashMap<String, Entry> d3 = new LinkedHashMap<>(0, 0.75f, true);
    int e3;
    boolean f3;
    boolean g3;
    boolean h3;
    boolean i3;
    boolean j3;
    private long k3 = 0;
    private final Executor l3;
    private final Runnable m3 = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r6.s;
            r1.j3 = true;
            r1.c3 = okio.Okio.d(okio.Okio.c());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                boolean r2 = r1.g3     // Catch:{ all -> 0x0011 }
                r3 = 0
                r4 = 1
                r2 = r2 ^ r4
                boolean r5 = r1.h3     // Catch:{ all -> 0x0011 }
                r2 = r2 | r5
                if (r2 == 0) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x0011:
                r1 = move-exception
                goto L_0x003d
            L_0x0013:
                r1.G()     // Catch:{ IOException -> 0x0017 }
                goto L_0x001b
            L_0x0017:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                r1.i3 = r4     // Catch:{ all -> 0x0011 }
            L_0x001b:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                boolean r1 = r1.r()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x003b
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r1.w()     // Catch:{ IOException -> 0x002d }
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r1.e3 = r3     // Catch:{ IOException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                r1.j3 = r4     // Catch:{ all -> 0x0011 }
                okio.Sink r2 = okio.Okio.c()     // Catch:{ all -> 0x0011 }
                okio.BufferedSink r2 = okio.Okio.d(r2)     // Catch:{ all -> 0x0011 }
                r1.c3 = r2     // Catch:{ all -> 0x0011 }
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.AnonymousClass1.run():void");
        }
    };
    final FileSystem s;

    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        final Entry f30999a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f31000b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31001c;

        Editor(Entry entry) {
            this.f30999a = entry;
            this.f31000b = entry.f31007e ? null : new boolean[DiskLruCache.this.a3];
        }

        public void a() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.f31001c) {
                        if (this.f30999a.f31008f == this) {
                            DiskLruCache.this.c(this, false);
                        }
                        this.f31001c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r3 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.f31001c     // Catch:{ all -> 0x0014 }
                if (r1 != 0) goto L_0x0016
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r3.f30999a     // Catch:{ all -> 0x0014 }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.f31008f     // Catch:{ all -> 0x0014 }
                if (r1 != r3) goto L_0x0016
                okhttp3.internal.cache.DiskLruCache r1 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0016 }
                r2 = 0
                r1.c(r3, r2)     // Catch:{ IOException -> 0x0016 }
                goto L_0x0016
            L_0x0014:
                r1 = move-exception
                goto L_0x0018
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                return
            L_0x0018:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.b():void");
        }

        public void c() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.f31001c) {
                        if (this.f30999a.f31008f == this) {
                            DiskLruCache.this.c(this, true);
                        }
                        this.f31001c = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f30999a.f31008f == this) {
                int i2 = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i2 < diskLruCache.a3) {
                        try {
                            diskLruCache.s.f(this.f30999a.f31006d[i2]);
                        } catch (IOException unused) {
                        }
                        i2++;
                    } else {
                        this.f30999a.f31008f = null;
                        return;
                    }
                }
            }
        }

        public Sink e(int i2) {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.f31001c) {
                        Entry entry = this.f30999a;
                        if (entry.f31008f != this) {
                            Sink c2 = Okio.c();
                            return c2;
                        }
                        if (!entry.f31007e) {
                            this.f31000b[i2] = true;
                        }
                        AnonymousClass1 r1 = new FaultHidingSink(DiskLruCache.this.s.b(entry.f31006d[i2])) {
                            /* access modifiers changed from: protected */
                            public void d(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.d();
                                }
                            }
                        };
                        return r1;
                    }
                    throw new IllegalStateException();
                } catch (FileNotFoundException unused) {
                    return Okio.c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okio.Source f(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.f31001c     // Catch:{ all -> 0x0021 }
                if (r1 != 0) goto L_0x0027
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.f30999a     // Catch:{ all -> 0x0021 }
                boolean r2 = r1.f31007e     // Catch:{ all -> 0x0021 }
                r3 = 0
                if (r2 == 0) goto L_0x0025
                okhttp3.internal.cache.DiskLruCache$Editor r2 = r1.f31008f     // Catch:{ all -> 0x0021 }
                if (r2 == r4) goto L_0x0013
                goto L_0x0025
            L_0x0013:
                okhttp3.internal.cache.DiskLruCache r2 = okhttp3.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0023 }
                okhttp3.internal.io.FileSystem r2 = r2.s     // Catch:{ FileNotFoundException -> 0x0023 }
                java.io.File[] r1 = r1.f31005c     // Catch:{ FileNotFoundException -> 0x0023 }
                r5 = r1[r5]     // Catch:{ FileNotFoundException -> 0x0023 }
                okio.Source r5 = r2.a(r5)     // Catch:{ FileNotFoundException -> 0x0023 }
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r5
            L_0x0021:
                r5 = move-exception
                goto L_0x002d
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0027:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0021 }
                r5.<init>()     // Catch:{ all -> 0x0021 }
                throw r5     // Catch:{ all -> 0x0021 }
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.f(int):okio.Source");
        }
    }

    private final class Entry {

        /* renamed from: a  reason: collision with root package name */
        final String f31003a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f31004b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f31005c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f31006d;

        /* renamed from: e  reason: collision with root package name */
        boolean f31007e;

        /* renamed from: f  reason: collision with root package name */
        Editor f31008f;

        /* renamed from: g  reason: collision with root package name */
        long f31009g;

        Entry(String str) {
            this.f31003a = str;
            int i2 = DiskLruCache.this.a3;
            this.f31004b = new long[i2];
            this.f31005c = new File[i2];
            this.f31006d = new File[i2];
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i3 = 0; i3 < DiskLruCache.this.a3; i3++) {
                sb.append(i3);
                this.f31005c[i3] = new File(DiskLruCache.this.X, sb.toString());
                sb.append(".tmp");
                this.f31006d[i3] = new File(DiskLruCache.this.X, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.a3) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f31004b[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        /* access modifiers changed from: package-private */
        public Snapshot c() {
            Source source;
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.a3];
                long[] jArr = (long[]) this.f31004b.clone();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i3 >= diskLruCache.a3) {
                            return new Snapshot(this.f31003a, this.f31009g, sourceArr, jArr);
                        }
                        sourceArr[i3] = diskLruCache.s.a(this.f31005c[i3]);
                        i3++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i2 >= diskLruCache2.a3 || (source = sourceArr[i2]) == null) {
                                try {
                                    diskLruCache2.y(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                Util.g(source);
                                i2++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(BufferedSink bufferedSink) throws IOException {
            for (long L2 : this.f31004b) {
                bufferedSink.writeByte(32).L2(L2);
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final long X;
        private final Source[] Y;
        private final long[] Z;
        /* access modifiers changed from: private */
        public final String s;

        Snapshot(String str, long j2, Source[] sourceArr, long[] jArr) {
            this.s = str;
            this.X = j2;
            this.Y = sourceArr;
            this.Z = jArr;
        }

        @Nullable
        public Editor c() throws IOException {
            return DiskLruCache.this.h(this.s, this.X);
        }

        public void close() {
            for (Source g2 : this.Y) {
                Util.g(g2);
            }
        }

        public long d(int i2) {
            return this.Z[i2];
        }

        public Source e(int i2) {
            return this.Y[i2];
        }

        public String f() {
            return this.s;
        }
    }

    DiskLruCache(FileSystem fileSystem, File file, int i2, int i4, long j2, Executor executor) {
        this.s = fileSystem;
        this.X = file;
        this.Y2 = i2;
        this.Y = new File(file, n3);
        this.Z = new File(file, o3);
        this.X2 = new File(file, p3);
        this.a3 = i4;
        this.Z2 = j2;
        this.l3 = executor;
    }

    private void H(String str) {
        if (!t3.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    private synchronized void b() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache d(FileSystem fileSystem, File file, int i2, int i4, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i4 > 0) {
            return new DiskLruCache(fileSystem, file, i2, i4, j2, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.H("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private BufferedSink s() throws FileNotFoundException {
        return Okio.d(new FaultHidingSink(this.s.g(this.Y)) {
            static final /* synthetic */ boolean Z = false;

            /* access modifiers changed from: protected */
            public void d(IOException iOException) {
                DiskLruCache.this.f3 = true;
            }
        });
    }

    private void t() throws IOException {
        this.s.f(this.Z);
        Iterator<Entry> it2 = this.d3.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i2 = 0;
            if (next.f31008f == null) {
                while (i2 < this.a3) {
                    this.b3 += next.f31004b[i2];
                    i2++;
                }
            } else {
                next.f31008f = null;
                while (i2 < this.a3) {
                    this.s.f(next.f31005c[i2]);
                    this.s.f(next.f31006d[i2]);
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.e3 = r0 - r9.d3.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r1.o0() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        w();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r9.c3 = s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x007c=Splitter:B:24:0x007c, B:17:0x005f=Splitter:B:17:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.s
            java.io.File r2 = r9.Y
            okio.Source r1 = r1.a(r2)
            okio.BufferedSource r1 = okio.Okio.e(r1)
            java.lang.String r2 = r1.O1()     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r1.O1()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r1.O1()     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.O1()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = r1.O1()     // Catch:{ all -> 0x005d }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            int r7 = r9.Y2     // Catch:{ all -> 0x005d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            int r4 = r9.a3     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.O1()     // Catch:{ EOFException -> 0x005f }
            r9.v(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            r0 = move-exception
            goto L_0x00aa
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r2 = r9.d3     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            int r0 = r0 - r2
            r9.e3 = r0     // Catch:{ all -> 0x005d }
            boolean r0 = r1.o0()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0072
            r9.w()     // Catch:{ all -> 0x005d }
            goto L_0x0078
        L_0x0072:
            okio.BufferedSink r0 = r9.s()     // Catch:{ all -> 0x005d }
            r9.c3 = r0     // Catch:{ all -> 0x005d }
        L_0x0078:
            okhttp3.internal.Util.g(r1)
            return
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005d }
            r7.append(r2)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r3)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r5)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x00aa:
            okhttp3.internal.Util.g(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.u():void");
    }

    private void v(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(w3)) {
                    this.d3.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = this.d3.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.d3.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(u3)) {
                String[] split = str.substring(indexOf2 + 1).split(StringUtils.SPACE);
                entry.f31007e = true;
                entry.f31008f = null;
                entry.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(v3)) {
                entry.f31008f = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(x3)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public synchronized void A(long j2) {
        this.Z2 = j2;
        if (this.g3) {
            this.l3.execute(this.m3);
        }
    }

    public synchronized long C() throws IOException {
        q();
        return this.b3;
    }

    public synchronized Iterator<Snapshot> F() throws IOException {
        q();
        return new Iterator<Snapshot>() {
            Snapshot X;
            Snapshot Y;
            final Iterator<Entry> s;

            {
                this.s = new ArrayList(DiskLruCache.this.d3.values()).iterator();
            }

            /* renamed from: a */
            public Snapshot next() {
                if (hasNext()) {
                    Snapshot snapshot = this.X;
                    this.Y = snapshot;
                    this.X = null;
                    return snapshot;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.X != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    try {
                        if (DiskLruCache.this.h3) {
                            return false;
                        }
                        while (this.s.hasNext()) {
                            Snapshot c2 = this.s.next().c();
                            if (c2 != null) {
                                this.X = c2;
                                return true;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public void remove() {
                Snapshot snapshot = this.Y;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.x(snapshot.s);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        this.Y = null;
                        throw th;
                    }
                    this.Y = null;
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void G() throws IOException {
        while (this.b3 > this.Z2) {
            y(this.d3.values().iterator().next());
        }
        this.i3 = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            okhttp3.internal.cache.DiskLruCache$Entry r0 = r10.f30999a     // Catch:{ all -> 0x002a }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.f31008f     // Catch:{ all -> 0x002a }
            if (r1 != r10) goto L_0x00f8
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.f31007e     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x000f:
            int r3 = r9.a3     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.f31000b     // Catch:{ all -> 0x002a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0030
            okhttp3.internal.io.FileSystem r3 = r9.s     // Catch:{ all -> 0x002a }
            java.io.File[] r4 = r0.f31006d     // Catch:{ all -> 0x002a }
            r4 = r4[r2]     // Catch:{ all -> 0x002a }
            boolean r3 = r3.d(r4)     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002d
            r10.a()     // Catch:{ all -> 0x002a }
            monitor-exit(r9)
            return
        L_0x002a:
            r10 = move-exception
            goto L_0x00fe
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0030:
            r10.a()     // Catch:{ all -> 0x002a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r11.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x002a }
            r11.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002a }
            r10.<init>(r11)     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x004a:
            int r10 = r9.a3     // Catch:{ all -> 0x002a }
            if (r1 >= r10) goto L_0x0082
            java.io.File[] r10 = r0.f31006d     // Catch:{ all -> 0x002a }
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x007a
            okhttp3.internal.io.FileSystem r2 = r9.s     // Catch:{ all -> 0x002a }
            boolean r2 = r2.d(r10)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x007f
            java.io.File[] r2 = r0.f31005c     // Catch:{ all -> 0x002a }
            r2 = r2[r1]     // Catch:{ all -> 0x002a }
            okhttp3.internal.io.FileSystem r3 = r9.s     // Catch:{ all -> 0x002a }
            r3.e(r10, r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f31004b     // Catch:{ all -> 0x002a }
            r3 = r10[r1]     // Catch:{ all -> 0x002a }
            okhttp3.internal.io.FileSystem r10 = r9.s     // Catch:{ all -> 0x002a }
            long r5 = r10.h(r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f31004b     // Catch:{ all -> 0x002a }
            r10[r1] = r5     // Catch:{ all -> 0x002a }
            long r7 = r9.b3     // Catch:{ all -> 0x002a }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.b3 = r7     // Catch:{ all -> 0x002a }
            goto L_0x007f
        L_0x007a:
            okhttp3.internal.io.FileSystem r2 = r9.s     // Catch:{ all -> 0x002a }
            r2.f(r10)     // Catch:{ all -> 0x002a }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0082:
            int r10 = r9.e3     // Catch:{ all -> 0x002a }
            r1 = 1
            int r10 = r10 + r1
            r9.e3 = r10     // Catch:{ all -> 0x002a }
            r10 = 0
            r0.f31008f = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r0.f31007e     // Catch:{ all -> 0x002a }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00be
            r0.f31007e = r1     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "CLEAN"
            okio.BufferedSink r10 = r10.W0(r1)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.f31003a     // Catch:{ all -> 0x002a }
            r10.W0(r1)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            r0.d(r10)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x00dc
            long r10 = r9.k3     // Catch:{ all -> 0x002a }
            r1 = 1
            long r1 = r1 + r10
            r9.k3 = r1     // Catch:{ all -> 0x002a }
            r0.f31009g = r10     // Catch:{ all -> 0x002a }
            goto L_0x00dc
        L_0x00be:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r10 = r9.d3     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f31003a     // Catch:{ all -> 0x002a }
            r10.remove(r11)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "REMOVE"
            okio.BufferedSink r10 = r10.W0(r11)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f31003a     // Catch:{ all -> 0x002a }
            r10.W0(r11)     // Catch:{ all -> 0x002a }
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
        L_0x00dc:
            okio.BufferedSink r10 = r9.c3     // Catch:{ all -> 0x002a }
            r10.flush()     // Catch:{ all -> 0x002a }
            long r10 = r9.b3     // Catch:{ all -> 0x002a }
            long r0 = r9.Z2     // Catch:{ all -> 0x002a }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ef
            boolean r10 = r9.r()     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.Executor r10 = r9.l3     // Catch:{ all -> 0x002a }
            java.lang.Runnable r11 = r9.m3     // Catch:{ all -> 0x002a }
            r10.execute(r11)     // Catch:{ all -> 0x002a }
        L_0x00f6:
            monitor-exit(r9)
            return
        L_0x00f8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            r10.<init>()     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x00fe:
            monitor-exit(r9)     // Catch:{ all -> 0x002a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.c(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public synchronized void close() throws IOException {
        try {
            if (this.g3) {
                if (!this.h3) {
                    for (Entry entry : (Entry[]) this.d3.values().toArray(new Entry[this.d3.size()])) {
                        Editor editor = entry.f31008f;
                        if (editor != null) {
                            editor.a();
                        }
                    }
                    G();
                    this.c3.close();
                    this.c3 = null;
                    this.h3 = true;
                    return;
                }
            }
            this.h3 = true;
        } finally {
            while (true) {
            }
        }
    }

    public void e() throws IOException {
        close();
        this.s.c(this.X);
    }

    @Nullable
    public Editor f(String str) throws IOException {
        return h(str, -1);
    }

    public synchronized void flush() throws IOException {
        if (this.g3) {
            b();
            G();
            this.c3.flush();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.internal.cache.DiskLruCache.Editor h(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.q()     // Catch:{ all -> 0x0022 }
            r5.b()     // Catch:{ all -> 0x0022 }
            r5.H(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r5.d3     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0022 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0022 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0024
            long r1 = r0.f31009g     // Catch:{ all -> 0x0022 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0026
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x0077
        L_0x0024:
            monitor-exit(r5)
            return r3
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            okhttp3.internal.cache.DiskLruCache$Editor r7 = r0.f31008f     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x002e
            monitor-exit(r5)
            return r3
        L_0x002e:
            boolean r7 = r5.i3     // Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x006e
            boolean r7 = r5.j3     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            okio.BufferedSink r7 = r5.c3     // Catch:{ all -> 0x0022 }
            java.lang.String r8 = "DIRTY"
            okio.BufferedSink r7 = r7.W0(r8)     // Catch:{ all -> 0x0022 }
            r8 = 32
            okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            okio.BufferedSink r7 = r7.W0(r6)     // Catch:{ all -> 0x0022 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            okio.BufferedSink r7 = r5.c3     // Catch:{ all -> 0x0022 }
            r7.flush()     // Catch:{ all -> 0x0022 }
            boolean r7 = r5.f3     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0059
            monitor-exit(r5)
            return r3
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            okhttp3.internal.cache.DiskLruCache$Entry r0 = new okhttp3.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x0022 }
            r0.<init>(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r7 = r5.d3     // Catch:{ all -> 0x0022 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0022 }
        L_0x0065:
            okhttp3.internal.cache.DiskLruCache$Editor r6 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0022 }
            r6.<init>(r0)     // Catch:{ all -> 0x0022 }
            r0.f31008f = r6     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r6
        L_0x006e:
            java.util.concurrent.Executor r6 = r5.l3     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r7 = r5.m3     // Catch:{ all -> 0x0022 }
            r6.execute(r7)     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r3
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x0022 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.h(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public synchronized void i() throws IOException {
        try {
            q();
            for (Entry y : (Entry[]) this.d3.values().toArray(new Entry[this.d3.size()])) {
                y(y);
            }
            this.i3 = false;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.h3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.internal.cache.DiskLruCache.Snapshot k(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.q()     // Catch:{ all -> 0x004d }
            r3.b()     // Catch:{ all -> 0x004d }
            r3.H(r4)     // Catch:{ all -> 0x004d }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r3.d3     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004d }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            boolean r2 = r0.f31007e     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x001a
            goto L_0x0051
        L_0x001a:
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.c()     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.e3     // Catch:{ all -> 0x004d }
            int r1 = r1 + 1
            r3.e3 = r1     // Catch:{ all -> 0x004d }
            okio.BufferedSink r1 = r3.c3     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "READ"
            okio.BufferedSink r1 = r1.W0(r2)     // Catch:{ all -> 0x004d }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004d }
            okio.BufferedSink r4 = r1.W0(r4)     // Catch:{ all -> 0x004d }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x004d }
            boolean r4 = r3.r()     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x004f
            java.util.concurrent.Executor r4 = r3.l3     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r3.m3     // Catch:{ all -> 0x004d }
            r4.execute(r1)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r4 = move-exception
            goto L_0x0053
        L_0x004f:
            monitor-exit(r3)
            return r0
        L_0x0051:
            monitor-exit(r3)
            return r1
        L_0x0053:
            monitor-exit(r3)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.k(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public File n() {
        return this.X;
    }

    public synchronized long p() {
        return this.Z2;
    }

    public synchronized void q() throws IOException {
        try {
            if (!this.g3) {
                if (this.s.d(this.X2)) {
                    if (this.s.d(this.Y)) {
                        this.s.f(this.X2);
                    } else {
                        this.s.e(this.X2, this.Y);
                    }
                }
                if (this.s.d(this.Y)) {
                    u();
                    t();
                    this.g3 = true;
                    return;
                }
                w();
                this.g3 = true;
            }
        } catch (IOException e2) {
            Platform k2 = Platform.k();
            k2.r(5, "DiskLruCache " + this.X + " is corrupt: " + e2.getMessage() + ", removing", e2);
            e();
            this.h3 = false;
        } catch (Throwable th) {
            this.h3 = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        int i2 = this.e3;
        return i2 >= 2000 && i2 >= this.d3.size();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public synchronized void w() throws IOException {
        BufferedSink d2;
        try {
            BufferedSink bufferedSink = this.c3;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            d2 = Okio.d(this.s.b(this.Z));
            d2.W0(q3).writeByte(10);
            d2.W0("1").writeByte(10);
            d2.L2((long) this.Y2).writeByte(10);
            d2.L2((long) this.a3).writeByte(10);
            d2.writeByte(10);
            for (Entry next : this.d3.values()) {
                if (next.f31008f != null) {
                    d2.W0(v3).writeByte(32);
                    d2.W0(next.f31003a);
                } else {
                    d2.W0(u3).writeByte(32);
                    d2.W0(next.f31003a);
                    next.d(d2);
                }
                d2.writeByte(10);
            }
            d2.close();
            if (this.s.d(this.Y)) {
                this.s.e(this.Y, this.X2);
            }
            this.s.e(this.Z, this.Y);
            this.s.f(this.X2);
            this.c3 = s();
            this.f3 = false;
            this.j3 = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean x(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.q()     // Catch:{ all -> 0x0028 }
            r6.b()     // Catch:{ all -> 0x0028 }
            r6.H(r7)     // Catch:{ all -> 0x0028 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r6.d3     // Catch:{ all -> 0x0028 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0028 }
            okhttp3.internal.cache.DiskLruCache$Entry r7 = (okhttp3.internal.cache.DiskLruCache.Entry) r7     // Catch:{ all -> 0x0028 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.y(r7)     // Catch:{ all -> 0x0028 }
            if (r7 == 0) goto L_0x002a
            long r1 = r6.b3     // Catch:{ all -> 0x0028 }
            long r3 = r6.Z2     // Catch:{ all -> 0x0028 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002a
            r6.i3 = r0     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r7 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r6)
            return r7
        L_0x002c:
            monitor-exit(r6)     // Catch:{ all -> 0x0028 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.x(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean y(Entry entry) throws IOException {
        Editor editor = entry.f31008f;
        if (editor != null) {
            editor.d();
        }
        for (int i2 = 0; i2 < this.a3; i2++) {
            this.s.f(entry.f31005c[i2]);
            long j2 = this.b3;
            long[] jArr = entry.f31004b;
            this.b3 = j2 - jArr[i2];
            jArr[i2] = 0;
        }
        this.e3++;
        this.c3.W0(w3).writeByte(32).W0(entry.f31003a).writeByte(10);
        this.d3.remove(entry.f31003a);
        if (r()) {
            this.l3.execute(this.m3);
        }
        return true;
    }
}
