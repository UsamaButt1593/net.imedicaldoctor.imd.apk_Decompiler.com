package androidx.media3.datasource.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@UnstableApi
public final class SimpleCache implements Cache {

    /* renamed from: m  reason: collision with root package name */
    private static final String f10035m = "SimpleCache";

    /* renamed from: n  reason: collision with root package name */
    private static final int f10036n = 10;
    private static final String o = ".uid";
    private static final HashSet<File> p = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private final File f10037b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CacheEvictor f10038c;

    /* renamed from: d  reason: collision with root package name */
    private final CachedContentIndex f10039d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final CacheFileMetadataIndex f10040e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ArrayList<Cache.Listener>> f10041f;

    /* renamed from: g  reason: collision with root package name */
    private final Random f10042g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f10043h;

    /* renamed from: i  reason: collision with root package name */
    private long f10044i;

    /* renamed from: j  reason: collision with root package name */
    private long f10045j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10046k;

    /* renamed from: l  reason: collision with root package name */
    private Cache.CacheException f10047l;

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (DatabaseProvider) null, (byte[]) null, false, true);
    }

    private SimpleCacheSpan A(String str, long j2, long j3) {
        SimpleCacheSpan e2;
        CachedContent h2 = this.f10039d.h(str);
        if (h2 == null) {
            return SimpleCacheSpan.h(str, j2, j3);
        }
        while (true) {
            e2 = h2.e(j2, j3);
            if (!e2.Z || ((File) Assertions.g(e2.X2)).length() == e2.Y) {
                return e2;
            }
            L();
        }
        return e2;
    }

    /* access modifiers changed from: private */
    public void B() {
        Cache.CacheException cacheException;
        if (!this.f10037b.exists()) {
            try {
                x(this.f10037b);
            } catch (Cache.CacheException e2) {
                this.f10047l = e2;
                return;
            }
        }
        File[] listFiles = this.f10037b.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f10037b;
            Log.d(f10035m, str);
            cacheException = new Cache.CacheException(str);
        } else {
            long E = E(listFiles);
            this.f10044i = E;
            if (E == -1) {
                try {
                    this.f10044i = y(this.f10037b);
                } catch (IOException e3) {
                    String str2 = "Failed to create cache UID: " + this.f10037b;
                    Log.e(f10035m, str2, e3);
                    cacheException = new Cache.CacheException(str2, e3);
                }
            }
            try {
                this.f10039d.p(this.f10044i);
                CacheFileMetadataIndex cacheFileMetadataIndex = this.f10040e;
                if (cacheFileMetadataIndex != null) {
                    cacheFileMetadataIndex.f(this.f10044i);
                    Map<String, CacheFileMetadata> c2 = this.f10040e.c();
                    D(this.f10037b, true, listFiles, c2);
                    this.f10040e.h(c2.keySet());
                } else {
                    D(this.f10037b, true, listFiles, (Map<String, CacheFileMetadata>) null);
                }
                this.f10039d.t();
                try {
                    this.f10039d.u();
                    return;
                } catch (IOException e4) {
                    Log.e(f10035m, "Storing index file failed", e4);
                    return;
                }
            } catch (IOException e5) {
                String str3 = "Failed to initialize cache indices: " + this.f10037b;
                Log.e(f10035m, str3, e5);
                cacheException = new Cache.CacheException(str3, e5);
            }
        }
        this.f10047l = cacheException;
    }

    public static synchronized boolean C(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = p.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    private void D(File file, boolean z, @Nullable File[] fileArr, @Nullable Map<String, CacheFileMetadata> map) {
        long j2;
        long j3;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z && name.indexOf(46) == -1) {
                    D(file2, false, file2.listFiles(), map);
                } else if (!z || (!CachedContentIndex.q(name) && !name.endsWith(o))) {
                    CacheFileMetadata remove = map != null ? map.remove(name) : null;
                    if (remove != null) {
                        j3 = remove.f9957a;
                        j2 = remove.f9958b;
                    } else {
                        j2 = -9223372036854775807L;
                        j3 = -1;
                    }
                    SimpleCacheSpan f2 = SimpleCacheSpan.f(file2, j3, j2, this.f10039d);
                    if (f2 != null) {
                        v(f2);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z) {
            file.delete();
        }
    }

    private static long E(File[] fileArr) {
        int length = fileArr.length;
        int i2 = 0;
        while (i2 < length) {
            File file = fileArr[i2];
            String name = file.getName();
            if (name.endsWith(o)) {
                try {
                    return J(name);
                } catch (NumberFormatException unused) {
                    Log.d(f10035m, "Malformed UID file: " + file);
                    file.delete();
                }
            } else {
                i2++;
            }
        }
        return -1;
    }

    private static synchronized boolean F(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = p.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void G(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.f10041f.get(simpleCacheSpan.s);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).c(this, simpleCacheSpan);
            }
        }
        this.f10038c.c(this, simpleCacheSpan);
    }

    private void H(CacheSpan cacheSpan) {
        ArrayList arrayList = this.f10041f.get(cacheSpan.s);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).d(this, cacheSpan);
            }
        }
        this.f10038c.d(this, cacheSpan);
    }

    private void I(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.f10041f.get(simpleCacheSpan.s);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).a(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.f10038c.a(this, simpleCacheSpan, cacheSpan);
    }

    private static long J(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void K(CacheSpan cacheSpan) {
        CachedContent h2 = this.f10039d.h(cacheSpan.s);
        if (h2 != null && h2.k(cacheSpan)) {
            this.f10045j -= cacheSpan.Y;
            if (this.f10040e != null) {
                String name = ((File) Assertions.g(cacheSpan.X2)).getName();
                try {
                    this.f10040e.g(name);
                } catch (IOException unused) {
                    Log.n(f10035m, "Failed to remove file index entry for: " + name);
                }
            }
            this.f10039d.r(h2.f9986b);
            H(cacheSpan);
        }
    }

    private void L() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent f2 : this.f10039d.i()) {
            Iterator<SimpleCacheSpan> it2 = f2.f().iterator();
            while (it2.hasNext()) {
                CacheSpan next = it2.next();
                if (((File) Assertions.g(next.X2)).length() != next.Y) {
                    arrayList.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            K((CacheSpan) arrayList.get(i2));
        }
    }

    private SimpleCacheSpan M(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z;
        if (!this.f10043h) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.g(simpleCacheSpan.X2)).getName();
        long j2 = simpleCacheSpan.Y;
        long currentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f10040e;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.i(name, j2, currentTimeMillis);
            } catch (IOException unused) {
                Log.n(f10035m, "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        SimpleCacheSpan l2 = ((CachedContent) Assertions.g(this.f10039d.h(str))).l(simpleCacheSpan, currentTimeMillis, z);
        I(simpleCacheSpan, l2);
        return l2;
    }

    private static synchronized void N(File file) {
        synchronized (SimpleCache.class) {
            p.remove(file.getAbsoluteFile());
        }
    }

    private void v(SimpleCacheSpan simpleCacheSpan) {
        this.f10039d.o(simpleCacheSpan.s).a(simpleCacheSpan);
        this.f10045j += simpleCacheSpan.Y;
        G(simpleCacheSpan);
    }

    private static void x(File file) throws Cache.CacheException {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            Log.d(f10035m, str);
            throw new Cache.CacheException(str);
        }
    }

    private static long y(File file) throws IOException {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0 : Math.abs(nextLong);
        String l2 = Long.toString(abs, 16);
        File file2 = new File(file, l2 + o);
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    @WorkerThread
    public static void z(File file, @Nullable DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long E = E(listFiles);
                if (E != -1) {
                    try {
                        CacheFileMetadataIndex.a(databaseProvider, E);
                    } catch (DatabaseIOException unused) {
                        Log.n(f10035m, "Failed to delete file metadata: " + E);
                    }
                    try {
                        CachedContentIndex.g(databaseProvider, E);
                    } catch (DatabaseIOException unused2) {
                        Log.n(f10035m, "Failed to delete file metadata: " + E);
                    }
                }
            }
            Util.W1(file);
        }
    }

    public synchronized void a() {
        if (!this.f10046k) {
            this.f10041f.clear();
            L();
            try {
                this.f10039d.u();
                N(this.f10037b);
            } catch (IOException e2) {
                try {
                    Log.e(f10035m, "Storing index file failed", e2);
                    N(this.f10037b);
                } catch (Throwable th) {
                    N(this.f10037b);
                    this.f10046k = true;
                    throw th;
                }
            }
            this.f10046k = true;
            return;
        }
        return;
    }

    public synchronized long b() {
        return this.f10044i;
    }

    public synchronized File c(String str, long j2, long j3) throws Cache.CacheException {
        CachedContent h2;
        File file;
        try {
            Assertions.i(!this.f10046k);
            w();
            h2 = this.f10039d.h(str);
            Assertions.g(h2);
            Assertions.i(h2.h(j2, j3));
            if (!this.f10037b.exists()) {
                x(this.f10037b);
                L();
            }
            this.f10038c.b(this, str, j2, j3);
            file = new File(this.f10037b, Integer.toString(this.f10042g.nextInt(10)));
            if (!file.exists()) {
                x(file);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return SimpleCacheSpan.j(file, h2.f9985a, j2, System.currentTimeMillis());
    }

    public synchronized void d(CacheSpan cacheSpan) {
        Assertions.i(!this.f10046k);
        CachedContent cachedContent = (CachedContent) Assertions.g(this.f10039d.h(cacheSpan.s));
        cachedContent.m(cacheSpan.X);
        this.f10039d.r(cachedContent.f9986b);
        notifyAll();
    }

    public synchronized ContentMetadata e(String str) {
        Assertions.i(!this.f10046k);
        return this.f10039d.k(str);
    }

    public synchronized long f(String str, long j2, long j3) {
        long j4;
        long j5 = Long.MAX_VALUE;
        long j6 = j3 == -1 ? Long.MAX_VALUE : j3 + j2;
        if (j6 >= 0) {
            j5 = j6;
        }
        j4 = 0;
        while (j2 < j5) {
            long k2 = k(str, j2, j5 - j2);
            if (k2 > 0) {
                j4 += k2;
            } else {
                k2 = -k2;
            }
            j2 += k2;
        }
        return j4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void g(java.lang.String r2, androidx.media3.datasource.cache.Cache.Listener r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f10046k     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.media3.datasource.cache.Cache$Listener>> r0 = r1.f10041f     // Catch:{ all -> 0x0020 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0020 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0022
            r0.remove(r3)     // Catch:{ all -> 0x0020 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x0022
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.media3.datasource.cache.Cache$Listener>> r3 = r1.f10041f     // Catch:{ all -> 0x0020 }
            r3.remove(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x0022
        L_0x0020:
            r2 = move-exception
            goto L_0x0024
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.SimpleCache.g(java.lang.String, androidx.media3.datasource.cache.Cache$Listener):void");
    }

    public synchronized void h(CacheSpan cacheSpan) {
        Assertions.i(!this.f10046k);
        K(cacheSpan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r2.f10039d.o(r3).j(r4, r6.Y) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized androidx.media3.datasource.cache.CacheSpan i(java.lang.String r3, long r4, long r6) throws androidx.media3.datasource.cache.Cache.CacheException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f10046k     // Catch:{ all -> 0x0019 }
            r0 = r0 ^ 1
            androidx.media3.common.util.Assertions.i(r0)     // Catch:{ all -> 0x0019 }
            r2.w()     // Catch:{ all -> 0x0019 }
            androidx.media3.datasource.cache.SimpleCacheSpan r6 = r2.A(r3, r4, r6)     // Catch:{ all -> 0x0019 }
            boolean r7 = r6.Z     // Catch:{ all -> 0x0019 }
            if (r7 == 0) goto L_0x001b
            androidx.media3.datasource.cache.SimpleCacheSpan r3 = r2.M(r3, r6)     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            return r3
        L_0x0019:
            r3 = move-exception
            goto L_0x002d
        L_0x001b:
            androidx.media3.datasource.cache.CachedContentIndex r7 = r2.f10039d     // Catch:{ all -> 0x0019 }
            androidx.media3.datasource.cache.CachedContent r3 = r7.o(r3)     // Catch:{ all -> 0x0019 }
            long r0 = r6.Y     // Catch:{ all -> 0x0019 }
            boolean r3 = r3.j(r4, r0)     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)
            if (r3 == 0) goto L_0x002b
            return r6
        L_0x002b:
            r3 = 0
            return r3
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.SimpleCache.i(java.lang.String, long, long):androidx.media3.datasource.cache.CacheSpan");
    }

    public synchronized NavigableSet<CacheSpan> j(String str, Cache.Listener listener) {
        try {
            Assertions.i(!this.f10046k);
            Assertions.g(str);
            Assertions.g(listener);
            ArrayList arrayList = this.f10041f.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f10041f.put(str, arrayList);
            }
            arrayList.add(listener);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return s(str);
    }

    public synchronized long k(String str, long j2, long j3) {
        CachedContent h2;
        Assertions.i(!this.f10046k);
        if (j3 == -1) {
            j3 = Long.MAX_VALUE;
        }
        h2 = this.f10039d.h(str);
        return h2 != null ? h2.c(j2, j3) : -j3;
    }

    public synchronized CacheSpan l(String str, long j2, long j3) throws InterruptedException, Cache.CacheException {
        CacheSpan i2;
        Assertions.i(!this.f10046k);
        w();
        while (true) {
            i2 = i(str, j2, j3);
            if (i2 == null) {
                wait();
            }
        }
        return i2;
    }

    public synchronized Set<String> m() {
        Assertions.i(!this.f10046k);
        return new HashSet(this.f10039d.m());
    }

    public synchronized void n(File file, long j2) throws Cache.CacheException {
        boolean z = false;
        Assertions.i(!this.f10046k);
        if (file.exists()) {
            if (j2 == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.g(SimpleCacheSpan.g(file, j2, this.f10039d));
            CachedContent cachedContent = (CachedContent) Assertions.g(this.f10039d.h(simpleCacheSpan.s));
            Assertions.i(cachedContent.h(simpleCacheSpan.X, simpleCacheSpan.Y));
            long a2 = c.a(cachedContent.d());
            if (a2 != -1) {
                if (simpleCacheSpan.X + simpleCacheSpan.Y <= a2) {
                    z = true;
                }
                Assertions.i(z);
            }
            if (this.f10040e != null) {
                try {
                    this.f10040e.i(file.getName(), simpleCacheSpan.Y, simpleCacheSpan.Y2);
                } catch (IOException e2) {
                    throw new Cache.CacheException((Throwable) e2);
                } catch (IOException e3) {
                    throw new Cache.CacheException((Throwable) e3);
                }
            }
            v(simpleCacheSpan);
            this.f10039d.u();
            notifyAll();
        }
    }

    public synchronized void o(String str) {
        Assertions.i(!this.f10046k);
        for (CacheSpan K : s(str)) {
            K(K);
        }
    }

    public synchronized void p(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        Assertions.i(!this.f10046k);
        w();
        this.f10039d.e(str, contentMetadataMutations);
        try {
            this.f10039d.u();
        } catch (IOException e2) {
            throw new Cache.CacheException((Throwable) e2);
        }
    }

    public synchronized long q() {
        Assertions.i(!this.f10046k);
        return this.f10045j;
    }

    public synchronized boolean r(String str, long j2, long j3) {
        boolean z;
        z = false;
        Assertions.i(!this.f10046k);
        CachedContent h2 = this.f10039d.h(str);
        if (h2 != null && h2.c(j2, j3) >= j3) {
            z = true;
        }
        return z;
    }

    public synchronized NavigableSet<CacheSpan> s(String str) {
        TreeSet treeSet;
        try {
            Assertions.i(!this.f10046k);
            CachedContent h2 = this.f10039d.h(str);
            if (h2 != null) {
                if (!h2.g()) {
                    treeSet = new TreeSet(h2.f());
                }
            }
            treeSet = new TreeSet();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return treeSet;
    }

    public synchronized void w() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f10047l;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, (byte[]) null, false, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, @Nullable DatabaseProvider databaseProvider, @Nullable byte[] bArr, boolean z, boolean z2) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z, z2), (databaseProvider == null || z2) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, @Nullable CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (F(file)) {
            this.f10037b = file;
            this.f10038c = cacheEvictor;
            this.f10039d = cachedContentIndex;
            this.f10040e = cacheFileMetadataIndex;
            this.f10041f = new HashMap<>();
            this.f10042g = new Random();
            this.f10043h = cacheEvictor.f();
            this.f10044i = -1;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("ExoPlayer:SimpleCacheInit") {
                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.B();
                        SimpleCache.this.f10038c.e();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
