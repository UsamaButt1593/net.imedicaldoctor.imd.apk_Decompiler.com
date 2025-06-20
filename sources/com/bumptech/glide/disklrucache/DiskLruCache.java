package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

public final class DiskLruCache implements Closeable {
    static final String h3 = "journal";
    static final String i3 = "journal.tmp";
    static final String j3 = "journal.bkp";
    static final String k3 = "libcore.io.DiskLruCache";
    static final String l3 = "1";
    static final long m3 = -1;
    private static final String n3 = "CLEAN";
    private static final String o3 = "DIRTY";
    private static final String p3 = "REMOVE";
    private static final String q3 = "READ";
    private final File X;
    private final int X2;
    private final File Y;
    private long Y2;
    private final File Z;
    /* access modifiers changed from: private */
    public final int Z2;
    private long a3 = 0;
    /* access modifiers changed from: private */
    public Writer b3;
    private final LinkedHashMap<String, Entry> c3 = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int d3;
    private long e3 = 0;
    final ThreadPoolExecutor f3 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory());
    private final Callable<Void> g3 = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.bumptech.glide.disklrucache.DiskLruCache r0 = com.bumptech.glide.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                java.io.Writer r1 = r1.b3     // Catch:{ all -> 0x000e }
                r2 = 0
                if (r1 != 0) goto L_0x0010
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x000e:
                r1 = move-exception
                goto L_0x002a
            L_0x0010:
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.S()     // Catch:{ all -> 0x000e }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                boolean r1 = r1.G()     // Catch:{ all -> 0x000e }
                if (r1 == 0) goto L_0x0028
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r1.N()     // Catch:{ all -> 0x000e }
                com.bumptech.glide.disklrucache.DiskLruCache r1 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x000e }
                r3 = 0
                int unused = r1.d3 = r3     // Catch:{ all -> 0x000e }
            L_0x0028:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                return r2
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x000e }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.AnonymousClass1.call():java.lang.Void");
        }
    };
    /* access modifiers changed from: private */
    public final File s;

    private static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Entry f17744a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f17745b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17746c;

        private Editor(Entry entry) {
            this.f17744a = entry;
            this.f17745b = entry.f17752e ? null : new boolean[DiskLruCache.this.Z2];
        }

        private InputStream h(int i2) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f17744a.f17753f != this) {
                    throw new IllegalStateException();
                } else if (!this.f17744a.f17752e) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.f17744a.j(i2));
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        public void a() throws IOException {
            DiskLruCache.this.s(this, false);
        }

        public void b() {
            if (!this.f17746c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            DiskLruCache.this.s(this, true);
            this.f17746c = true;
        }

        public File f(int i2) throws IOException {
            File k2;
            synchronized (DiskLruCache.this) {
                try {
                    if (this.f17744a.f17753f == this) {
                        if (!this.f17744a.f17752e) {
                            this.f17745b[i2] = true;
                        }
                        k2 = this.f17744a.k(i2);
                        if (!DiskLruCache.this.s.exists()) {
                            DiskLruCache.this.s.mkdirs();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return k2;
        }

        public String g(int i2) throws IOException {
            InputStream h2 = h(i2);
            if (h2 != null) {
                return DiskLruCache.F(h2);
            }
            return null;
        }

        public void i(int i2, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(f(i2)), Util.f17762b);
                try {
                    outputStreamWriter2.write(str);
                    Util.a(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Util.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.a(outputStreamWriter);
                throw th;
            }
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f17748a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f17749b;

        /* renamed from: c  reason: collision with root package name */
        File[] f17750c;

        /* renamed from: d  reason: collision with root package name */
        File[] f17751d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f17752e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Editor f17753f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f17754g;

        private Entry(String str) {
            this.f17748a = str;
            this.f17749b = new long[DiskLruCache.this.Z2];
            this.f17750c = new File[DiskLruCache.this.Z2];
            this.f17751d = new File[DiskLruCache.this.Z2];
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.Z2; i2++) {
                sb.append(i2);
                this.f17750c[i2] = new File(DiskLruCache.this.s, sb.toString());
                sb.append(".tmp");
                this.f17751d[i2] = new File(DiskLruCache.this.s, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.Z2) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f17749b[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i2) {
            return this.f17750c[i2];
        }

        public File k(int i2) {
            return this.f17751d[i2];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f17749b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }
    }

    public final class Value {

        /* renamed from: a  reason: collision with root package name */
        private final String f17756a;

        /* renamed from: b  reason: collision with root package name */
        private final long f17757b;

        /* renamed from: c  reason: collision with root package name */
        private final long[] f17758c;

        /* renamed from: d  reason: collision with root package name */
        private final File[] f17759d;

        private Value(String str, long j2, File[] fileArr, long[] jArr) {
            this.f17756a = str;
            this.f17757b = j2;
            this.f17759d = fileArr;
            this.f17758c = jArr;
        }

        public Editor a() throws IOException {
            return DiskLruCache.this.w(this.f17756a, this.f17757b);
        }

        public File b(int i2) {
            return this.f17759d[i2];
        }

        public long c(int i2) {
            return this.f17758c[i2];
        }

        public String d(int i2) throws IOException {
            return DiskLruCache.F(new FileInputStream(this.f17759d[i2]));
        }
    }

    private DiskLruCache(File file, int i2, int i4, long j2) {
        File file2 = file;
        this.s = file2;
        this.X2 = i2;
        this.X = new File(file2, h3);
        this.Y = new File(file2, i3);
        this.Z = new File(file2, j3);
        this.Z2 = i4;
        this.Y2 = j2;
    }

    /* access modifiers changed from: private */
    public static String F(InputStream inputStream) throws IOException {
        return Util.c(new InputStreamReader(inputStream, Util.f17762b));
    }

    /* access modifiers changed from: private */
    public boolean G() {
        int i2 = this.d3;
        return i2 >= 2000 && i2 >= this.c3.size();
    }

    public static DiskLruCache H(File file, int i2, int i4, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i4 > 0) {
            File file2 = new File(file, j3);
            if (file2.exists()) {
                File file3 = new File(file, h3);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    P(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i4, j2);
            if (diskLruCache.X.exists()) {
                try {
                    diskLruCache.J();
                    diskLruCache.I();
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.t();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i4, j2);
            diskLruCache2.N();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private void I() throws IOException {
        u(this.Y);
        Iterator<Entry> it2 = this.c3.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i2 = 0;
            if (next.f17753f == null) {
                while (i2 < this.Z2) {
                    this.a3 += next.f17749b[i2];
                    i2++;
                }
            } else {
                Editor unused = next.f17753f = null;
                while (i2 < this.Z2) {
                    u(next.j(i2));
                    u(next.k(i2));
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.d3 = r0 - r9.c3.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        if (r1.d() != false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        N();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        r9.b3 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.X, true), com.bumptech.glide.disklrucache.Util.f17761a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0061 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0061=Splitter:B:17:0x0061, B:24:0x008e=Splitter:B:24:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void J() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.disklrucache.StrictLineReader r1 = new com.bumptech.glide.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.X
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.disklrucache.Util.f17761a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.e()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r1.e()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r1.e()     // Catch:{ all -> 0x005f }
            java.lang.String r5 = r1.e()     // Catch:{ all -> 0x005f }
            java.lang.String r6 = r1.e()     // Catch:{ all -> 0x005f }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x008e
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x008e
            int r7 = r9.X2     // Catch:{ all -> 0x005f }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005f }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            int r4 = r9.Z2     // Catch:{ all -> 0x005f }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005f }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x008e
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.e()     // Catch:{ EOFException -> 0x0061 }
            r9.L(r2)     // Catch:{ EOFException -> 0x0061 }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            r0 = move-exception
            goto L_0x00bc
        L_0x0061:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r2 = r9.c3     // Catch:{ all -> 0x005f }
            int r2 = r2.size()     // Catch:{ all -> 0x005f }
            int r0 = r0 - r2
            r9.d3 = r0     // Catch:{ all -> 0x005f }
            boolean r0 = r1.d()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0074
            r9.N()     // Catch:{ all -> 0x005f }
            goto L_0x008a
        L_0x0074:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x005f }
            java.io.File r4 = r9.X     // Catch:{ all -> 0x005f }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x005f }
            java.nio.charset.Charset r4 = com.bumptech.glide.disklrucache.Util.f17761a     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x005f }
            r0.<init>(r2)     // Catch:{ all -> 0x005f }
            r9.b3 = r0     // Catch:{ all -> 0x005f }
        L_0x008a:
            com.bumptech.glide.disklrucache.Util.a(r1)
            return
        L_0x008e:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r7.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005f }
            r7.append(r2)     // Catch:{ all -> 0x005f }
            r7.append(r0)     // Catch:{ all -> 0x005f }
            r7.append(r3)     // Catch:{ all -> 0x005f }
            r7.append(r0)     // Catch:{ all -> 0x005f }
            r7.append(r5)     // Catch:{ all -> 0x005f }
            r7.append(r0)     // Catch:{ all -> 0x005f }
            r7.append(r6)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005f }
            r4.<init>(r0)     // Catch:{ all -> 0x005f }
            throw r4     // Catch:{ all -> 0x005f }
        L_0x00bc:
            com.bumptech.glide.disklrucache.Util.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.J():void");
    }

    private void L(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(p3)) {
                    this.c3.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = this.c3.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.c3.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(n3)) {
                String[] split = str.substring(indexOf2 + 1).split(StringUtils.SPACE);
                boolean unused = entry.f17752e = true;
                Editor unused2 = entry.f17753f = null;
                entry.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(o3)) {
                Editor unused3 = entry.f17753f = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(q3)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void N() throws IOException {
        BufferedWriter bufferedWriter;
        String str;
        try {
            Writer writer = this.b3;
            if (writer != null) {
                r(writer);
            }
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.Y), Util.f17761a));
            bufferedWriter.write(k3);
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.X2));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.Z2));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (Entry next : this.c3.values()) {
                if (next.f17753f != null) {
                    str = "DIRTY " + next.f17748a + 10;
                } else {
                    str = "CLEAN " + next.f17748a + next.l() + 10;
                }
                bufferedWriter.write(str);
            }
            r(bufferedWriter);
            if (this.X.exists()) {
                P(this.X, this.Z, true);
            }
            P(this.Y, this.X, false);
            this.Z.delete();
            this.b3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.X, true), Util.f17761a));
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void P(File file, File file2, boolean z) throws IOException {
        if (z) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void S() throws IOException {
        while (this.a3 > this.Y2) {
            O((String) this.c3.entrySet().iterator().next().getKey());
        }
    }

    private void q() {
        if (this.b3 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void r(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void s(com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = r10.f17744a     // Catch:{ all -> 0x0030 }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r0.f17753f     // Catch:{ all -> 0x0030 }
            if (r1 != r10) goto L_0x010b
            r1 = 0
            if (r11 == 0) goto L_0x0050
            boolean r2 = r0.f17752e     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0050
            r2 = 0
        L_0x0015:
            int r3 = r9.Z2     // Catch:{ all -> 0x0030 }
            if (r2 >= r3) goto L_0x0050
            boolean[] r3 = r10.f17745b     // Catch:{ all -> 0x0030 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0036
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x0030 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0030 }
            if (r3 != 0) goto L_0x0033
            r10.a()     // Catch:{ all -> 0x0030 }
            monitor-exit(r9)
            return
        L_0x0030:
            r10 = move-exception
            goto L_0x0111
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0036:
            r10.a()     // Catch:{ all -> 0x0030 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r11.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0030 }
            r11.append(r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0030 }
            r10.<init>(r11)     // Catch:{ all -> 0x0030 }
            throw r10     // Catch:{ all -> 0x0030 }
        L_0x0050:
            int r10 = r9.Z2     // Catch:{ all -> 0x0030 }
            if (r1 >= r10) goto L_0x0084
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x0030 }
            if (r11 == 0) goto L_0x007e
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0081
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0030 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0030 }
            long[] r10 = r0.f17749b     // Catch:{ all -> 0x0030 }
            r3 = r10[r1]     // Catch:{ all -> 0x0030 }
            long r5 = r2.length()     // Catch:{ all -> 0x0030 }
            long[] r10 = r0.f17749b     // Catch:{ all -> 0x0030 }
            r10[r1] = r5     // Catch:{ all -> 0x0030 }
            long r7 = r9.a3     // Catch:{ all -> 0x0030 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.a3 = r7     // Catch:{ all -> 0x0030 }
            goto L_0x0081
        L_0x007e:
            u(r10)     // Catch:{ all -> 0x0030 }
        L_0x0081:
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0084:
            int r10 = r9.d3     // Catch:{ all -> 0x0030 }
            r1 = 1
            int r10 = r10 + r1
            r9.d3 = r10     // Catch:{ all -> 0x0030 }
            r10 = 0
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f17753f = r10     // Catch:{ all -> 0x0030 }
            boolean r10 = r0.f17752e     // Catch:{ all -> 0x0030 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00cc
            boolean unused = r0.f17752e = r1     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            r10.append(r3)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r0.f17748a     // Catch:{ all -> 0x0030 }
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x0030 }
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            r10.append(r2)     // Catch:{ all -> 0x0030 }
            if (r11 == 0) goto L_0x00ef
            long r10 = r9.e3     // Catch:{ all -> 0x0030 }
            r1 = 1
            long r1 = r1 + r10
            r9.e3 = r1     // Catch:{ all -> 0x0030 }
            long unused = r0.f17754g = r10     // Catch:{ all -> 0x0030 }
            goto L_0x00ef
        L_0x00cc:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r10 = r9.c3     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r0.f17748a     // Catch:{ all -> 0x0030 }
            r10.remove(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            r10.append(r3)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            java.lang.String r11 = r0.f17748a     // Catch:{ all -> 0x0030 }
            r10.append(r11)     // Catch:{ all -> 0x0030 }
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            r10.append(r2)     // Catch:{ all -> 0x0030 }
        L_0x00ef:
            java.io.Writer r10 = r9.b3     // Catch:{ all -> 0x0030 }
            x(r10)     // Catch:{ all -> 0x0030 }
            long r10 = r9.a3     // Catch:{ all -> 0x0030 }
            long r0 = r9.Y2     // Catch:{ all -> 0x0030 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0102
            boolean r10 = r9.G()     // Catch:{ all -> 0x0030 }
            if (r10 == 0) goto L_0x0109
        L_0x0102:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f3     // Catch:{ all -> 0x0030 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.g3     // Catch:{ all -> 0x0030 }
            r10.submit(r11)     // Catch:{ all -> 0x0030 }
        L_0x0109:
            monitor-exit(r9)
            return
        L_0x010b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0030 }
            r10.<init>()     // Catch:{ all -> 0x0030 }
            throw r10     // Catch:{ all -> 0x0030 }
        L_0x0111:
            monitor-exit(r9)     // Catch:{ all -> 0x0030 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.s(com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    private static void u(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.disklrucache.DiskLruCache.Editor w(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.q()     // Catch:{ all -> 0x001e }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r5.c3     // Catch:{ all -> 0x001e }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x001e }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x001e }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.f17754g     // Catch:{ all -> 0x001e }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            goto L_0x0020
        L_0x001e:
            r6 = move-exception
            goto L_0x0060
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = new com.bumptech.glide.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x001e }
            r0.<init>(r6)     // Catch:{ all -> 0x001e }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r7 = r5.c3     // Catch:{ all -> 0x001e }
            r7.put(r6, r0)     // Catch:{ all -> 0x001e }
            goto L_0x0037
        L_0x002f:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = r0.f17753f     // Catch:{ all -> 0x001e }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r7 = new com.bumptech.glide.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x001e }
            r7.<init>(r0)     // Catch:{ all -> 0x001e }
            com.bumptech.glide.disklrucache.DiskLruCache.Editor unused = r0.f17753f = r7     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.b3     // Catch:{ all -> 0x001e }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.b3     // Catch:{ all -> 0x001e }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x001e }
            java.io.Writer r8 = r5.b3     // Catch:{ all -> 0x001e }
            r8.append(r6)     // Catch:{ all -> 0x001e }
            java.io.Writer r6 = r5.b3     // Catch:{ all -> 0x001e }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x001e }
            java.io.Writer r6 = r5.b3     // Catch:{ all -> 0x001e }
            x(r6)     // Catch:{ all -> 0x001e }
            monitor-exit(r5)
            return r7
        L_0x0060:
            monitor-exit(r5)     // Catch:{ all -> 0x001e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.w(java.lang.String, long):com.bumptech.glide.disklrucache.DiskLruCache$Editor");
    }

    @TargetApi(26)
    private static void x(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public File A() {
        return this.s;
    }

    public synchronized long C() {
        return this.Y2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean O(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.q()     // Catch:{ all -> 0x0043 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r7.c3     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0043 }
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = (com.bumptech.glide.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0043 }
            r1 = 0
            if (r0 == 0) goto L_0x008f
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r2 = r0.f17753f     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0017
            goto L_0x008f
        L_0x0017:
            int r2 = r7.Z2     // Catch:{ all -> 0x0043 }
            if (r1 >= r2) goto L_0x005b
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0043 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x0045
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x002c
            goto L_0x0045
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            r8.<init>(r0)     // Catch:{ all -> 0x0043 }
            throw r8     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r8 = move-exception
            goto L_0x0091
        L_0x0045:
            long r2 = r7.a3     // Catch:{ all -> 0x0043 }
            long[] r4 = r0.f17749b     // Catch:{ all -> 0x0043 }
            r5 = r4[r1]     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r5
            r7.a3 = r2     // Catch:{ all -> 0x0043 }
            long[] r2 = r0.f17749b     // Catch:{ all -> 0x0043 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0043 }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x005b:
            int r0 = r7.d3     // Catch:{ all -> 0x0043 }
            r1 = 1
            int r0 = r0 + r1
            r7.d3 = r0     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r7.b3     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r7.b3     // Catch:{ all -> 0x0043 }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r7.b3     // Catch:{ all -> 0x0043 }
            r0.append(r8)     // Catch:{ all -> 0x0043 }
            java.io.Writer r0 = r7.b3     // Catch:{ all -> 0x0043 }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x0043 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r0 = r7.c3     // Catch:{ all -> 0x0043 }
            r0.remove(r8)     // Catch:{ all -> 0x0043 }
            boolean r8 = r7.G()     // Catch:{ all -> 0x0043 }
            if (r8 == 0) goto L_0x008d
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f3     // Catch:{ all -> 0x0043 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.g3     // Catch:{ all -> 0x0043 }
            r8.submit(r0)     // Catch:{ all -> 0x0043 }
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            monitor-exit(r7)
            return r1
        L_0x0091:
            monitor-exit(r7)     // Catch:{ all -> 0x0043 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.O(java.lang.String):boolean");
    }

    public synchronized void Q(long j2) {
        this.Y2 = j2;
        this.f3.submit(this.g3);
    }

    public synchronized long R() {
        return this.a3;
    }

    public synchronized void close() throws IOException {
        try {
            if (this.b3 != null) {
                Iterator it2 = new ArrayList(this.c3.values()).iterator();
                while (it2.hasNext()) {
                    Entry entry = (Entry) it2.next();
                    if (entry.f17753f != null) {
                        entry.f17753f.a();
                    }
                }
                S();
                r(this.b3);
                this.b3 = null;
            }
        } finally {
            while (true) {
            }
        }
    }

    public synchronized void flush() throws IOException {
        q();
        S();
        x(this.b3);
    }

    public synchronized boolean isClosed() {
        return this.b3 == null;
    }

    public void t() throws IOException {
        close();
        Util.b(this.s);
    }

    public Editor v(String str) throws IOException {
        return w(str, -1);
    }

    public synchronized Value y(String str) throws IOException {
        q();
        Entry entry = this.c3.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.f17752e) {
            return null;
        }
        for (File exists : entry.f17750c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.d3++;
        this.b3.append(q3);
        this.b3.append(' ');
        this.b3.append(str);
        this.b3.append(10);
        if (G()) {
            this.f3.submit(this.g3);
        }
        return new Value(str, entry.f17754g, entry.f17750c, entry.f17749b);
    }
}
