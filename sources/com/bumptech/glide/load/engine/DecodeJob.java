package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String y3 = "DecodeJob";
    private final List<Throwable> X = new ArrayList();
    private final Pools.Pool<DecodeJob<?>> X2;
    private final StateVerifier Y = StateVerifier.a();
    private final DeferredEncodeManager<?> Y2 = new DeferredEncodeManager<>();
    private final DiskCacheProvider Z;
    private final ReleaseManager Z2 = new ReleaseManager();
    private GlideContext a3;
    private Key b3;
    private Priority c3;
    private EngineKey d3;
    private int e3;
    private int f3;
    private DiskCacheStrategy g3;
    private Options h3;
    private Callback<R> i3;
    private int j3;
    private Stage k3;
    private RunReason l3;
    private long m3;
    private boolean n3;
    private Object o3;
    private Thread p3;
    private Key q3;
    private Key r3;
    private final DecodeHelper<R> s = new DecodeHelper<>();
    private Object s3;
    private DataSource t3;
    private DataFetcher<?> u3;
    private volatile DataFetcherGenerator v3;
    private volatile boolean w3;
    private volatile boolean x3;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17890a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17891b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f17892c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17892c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f17892c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f17891b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f17891b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f17891b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f17891b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f17891b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f17890a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f17890a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f17890a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.<clinit>():void");
        }
    }

    interface Callback<R> {
        void a(GlideException glideException);

        void c(Resource<R> resource, DataSource dataSource);

        void d(DecodeJob<?> decodeJob);
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f17893a;

        DecodeCallback(DataSource dataSource) {
            this.f17893a = dataSource;
        }

        @NonNull
        public Resource<Z> a(@NonNull Resource<Z> resource) {
            return DecodeJob.this.x(this.f17893a, resource);
        }
    }

    private static class DeferredEncodeManager<Z> {

        /* renamed from: a  reason: collision with root package name */
        private Key f17895a;

        /* renamed from: b  reason: collision with root package name */
        private ResourceEncoder<Z> f17896b;

        /* renamed from: c  reason: collision with root package name */
        private LockedResource<Z> f17897c;

        DeferredEncodeManager() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f17895a = null;
            this.f17896b = null;
            this.f17897c = null;
        }

        /* access modifiers changed from: package-private */
        public void b(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f17895a, new DataCacheWriter(this.f17896b, this.f17897c, options));
            } finally {
                this.f17897c.g();
                GlideTrace.e();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f17897c != null;
        }

        /* access modifiers changed from: package-private */
        public <X> void d(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f17895a = key;
            this.f17896b = resourceEncoder;
            this.f17897c = lockedResource;
        }
    }

    interface DiskCacheProvider {
        DiskCache a();
    }

    private static class ReleaseManager {

        /* renamed from: a  reason: collision with root package name */
        private boolean f17898a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17899b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f17900c;

        ReleaseManager() {
        }

        private boolean a(boolean z) {
            return (this.f17900c || z || this.f17899b) && this.f17898a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f17899b = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            this.f17900c = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean d(boolean z) {
            this.f17898a = true;
            return a(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            this.f17899b = false;
            this.f17898a = false;
            this.f17900c = false;
        }
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        this.Z = diskCacheProvider;
        this.X2 = pool;
    }

    private void A() {
        this.p3 = Thread.currentThread();
        this.m3 = LogTime.b();
        boolean z = false;
        while (!this.x3 && this.v3 != null && !(z = this.v3.b())) {
            this.k3 = l(this.k3);
            this.v3 = k();
            if (this.k3 == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.k3 == Stage.FINISHED || this.x3) && !z) {
            u();
        }
    }

    private <Data, ResourceType> Resource<R> C(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options m2 = m(dataSource);
        DataRewinder l2 = this.a3.h().l(data);
        try {
            return loadPath.b(l2, m2, this.e3, this.f3, new DecodeCallback(dataSource));
        } finally {
            l2.b();
        }
    }

    private void D() {
        int i2 = AnonymousClass1.f17890a[this.l3.ordinal()];
        if (i2 == 1) {
            this.k3 = l(Stage.INITIALIZE);
            this.v3 = k();
        } else if (i2 != 2) {
            if (i2 == 3) {
                j();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.l3);
        }
        A();
    }

    private void E() {
        Throwable th;
        this.Y.c();
        if (this.w3) {
            if (this.X.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.X;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.w3 = true;
    }

    private <Data> Resource<R> h(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.b();
            return null;
        }
        try {
            long b2 = LogTime.b();
            Resource<R> i2 = i(data, dataSource);
            if (Log.isLoggable(y3, 2)) {
                p("Decoded result " + i2, b2);
            }
            return i2;
        } finally {
            dataFetcher.b();
        }
    }

    private <Data> Resource<R> i(Data data, DataSource dataSource) throws GlideException {
        return C(data, dataSource, this.s.h(data.getClass()));
    }

    private void j() {
        Resource<R> resource;
        if (Log.isLoggable(y3, 2)) {
            long j2 = this.m3;
            q("Retrieved data", j2, "data: " + this.s3 + ", cache key: " + this.q3 + ", fetcher: " + this.u3);
        }
        try {
            resource = h(this.u3, this.s3, this.t3);
        } catch (GlideException e2) {
            e2.j(this.r3, this.t3);
            this.X.add(e2);
            resource = null;
        }
        if (resource != null) {
            s(resource, this.t3);
        } else {
            A();
        }
    }

    private DataFetcherGenerator k() {
        int i2 = AnonymousClass1.f17891b[this.k3.ordinal()];
        if (i2 == 1) {
            return new ResourceCacheGenerator(this.s, this);
        }
        if (i2 == 2) {
            return new DataCacheGenerator(this.s, this);
        }
        if (i2 == 3) {
            return new SourceGenerator(this.s, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.k3);
    }

    private Stage l(Stage stage) {
        int i2 = AnonymousClass1.f17891b[stage.ordinal()];
        if (i2 == 1) {
            return this.g3.a() ? Stage.DATA_CACHE : l(Stage.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.n3 ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return Stage.FINISHED;
        }
        if (i2 == 5) {
            return this.g3.b() ? Stage.RESOURCE_CACHE : l(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @NonNull
    private Options m(DataSource dataSource) {
        Options options = this.h3;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.s.w();
        Option option = Downsampler.f18280k;
        Boolean bool = (Boolean) options.c(option);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        Options options2 = new Options();
        options2.d(this.h3);
        options2.e(option, Boolean.valueOf(z));
        return options2;
    }

    private int n() {
        return this.c3.ordinal();
    }

    private void p(String str, long j2) {
        q(str, j2, (String) null);
    }

    private void q(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j2));
        sb.append(", load key: ");
        sb.append(this.d3);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(y3, sb.toString());
    }

    private void r(Resource<R> resource, DataSource dataSource) {
        E();
        this.i3.c(resource, dataSource);
    }

    private void s(Resource<R> resource, DataSource dataSource) {
        LockedResource<R> lockedResource;
        LockedResource<R> lockedResource2;
        if (resource instanceof Initializable) {
            ((Initializable) resource).b();
        }
        if (this.Y2.c()) {
            LockedResource<R> e2 = LockedResource.e(resource);
            lockedResource2 = e2;
            lockedResource = e2;
        } else {
            lockedResource2 = null;
            lockedResource = resource;
        }
        r(lockedResource, dataSource);
        this.k3 = Stage.ENCODE;
        try {
            if (this.Y2.c()) {
                this.Y2.b(this.Z, this.h3);
            }
            v();
        } finally {
            if (lockedResource2 != null) {
                lockedResource2.g();
            }
        }
    }

    private void u() {
        E();
        this.i3.a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.X)));
        w();
    }

    private void v() {
        if (this.Z2.b()) {
            z();
        }
    }

    private void w() {
        if (this.Z2.c()) {
            z();
        }
    }

    private void z() {
        this.Z2.e();
        this.Y2.a();
        this.s.a();
        this.w3 = false;
        this.a3 = null;
        this.b3 = null;
        this.h3 = null;
        this.c3 = null;
        this.d3 = null;
        this.i3 = null;
        this.k3 = null;
        this.v3 = null;
        this.p3 = null;
        this.q3 = null;
        this.s3 = null;
        this.t3 = null;
        this.u3 = null;
        this.m3 = 0;
        this.x3 = false;
        this.o3 = null;
        this.X.clear();
        this.X2.c(this);
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        Stage l2 = l(Stage.INITIALIZE);
        return l2 == Stage.RESOURCE_CACHE || l2 == Stage.DATA_CACHE;
    }

    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.k(key, dataSource, dataFetcher.a());
        this.X.add(glideException);
        if (Thread.currentThread() != this.p3) {
            this.l3 = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.i3.d(this);
            return;
        }
        A();
    }

    @NonNull
    public StateVerifier b() {
        return this.Y;
    }

    public void c() {
        this.l3 = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.i3.d(this);
    }

    public void e(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.q3 = key;
        this.s3 = obj;
        this.u3 = dataFetcher;
        this.t3 = dataSource;
        this.r3 = key2;
        if (Thread.currentThread() != this.p3) {
            this.l3 = RunReason.DECODE_DATA;
            this.i3.d(this);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            j();
        } finally {
            GlideTrace.e();
        }
    }

    public void f() {
        this.x3 = true;
        DataFetcherGenerator dataFetcherGenerator = this.v3;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* renamed from: g */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int n2 = n() - decodeJob.n();
        return n2 == 0 ? this.j3 - decodeJob.j3 : n2;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> o(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i4, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, Callback<R> callback, int i5) {
        this.s.u(glideContext, obj, key, i2, i4, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.Z);
        this.a3 = glideContext;
        this.b3 = key;
        this.c3 = priority;
        this.d3 = engineKey;
        this.e3 = i2;
        this.f3 = i4;
        this.g3 = diskCacheStrategy;
        this.n3 = z3;
        this.h3 = options;
        this.i3 = callback;
        this.j3 = i5;
        this.l3 = RunReason.INITIALIZE;
        this.o3 = obj;
        return this;
    }

    public void run() {
        GlideTrace.b("DecodeJob#run(model=%s)", this.o3);
        DataFetcher<?> dataFetcher = this.u3;
        try {
            if (this.x3) {
                u();
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.e();
                return;
            }
            D();
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.e();
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.e();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.DataCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.Resource<Z> x(com.bumptech.glide.load.DataSource r12, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r11.s
            com.bumptech.glide.load.Transformation r0 = r0.r(r8)
            com.bumptech.glide.GlideContext r2 = r11.a3
            int r3 = r11.e3
            int r4 = r11.f3
            com.bumptech.glide.load.engine.Resource r2 = r0.b(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.s
            boolean r13 = r13.v(r0)
            if (r13 == 0) goto L_0x0041
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.s
            com.bumptech.glide.load.ResourceEncoder r1 = r13.n(r0)
            com.bumptech.glide.load.Options r13 = r11.h3
            com.bumptech.glide.load.EncodeStrategy r13 = r1.b(r13)
        L_0x003f:
            r10 = r1
            goto L_0x0044
        L_0x0041:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
            goto L_0x003f
        L_0x0044:
            com.bumptech.glide.load.engine.DecodeHelper<R> r1 = r11.s
            com.bumptech.glide.load.Key r2 = r11.q3
            boolean r1 = r1.x(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.g3
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b4
            if (r10 == 0) goto L_0x00a6
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.f17892c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0093
            r1 = 2
            if (r12 != r1) goto L_0x007c
            com.bumptech.glide.load.engine.ResourceCacheKey r12 = new com.bumptech.glide.load.engine.ResourceCacheKey
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.s
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.b()
            com.bumptech.glide.load.Key r3 = r11.q3
            com.bumptech.glide.load.Key r4 = r11.b3
            int r5 = r11.e3
            int r6 = r11.f3
            com.bumptech.glide.load.Options r9 = r11.h3
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009c
        L_0x007c:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0093:
            com.bumptech.glide.load.engine.DataCacheKey r12 = new com.bumptech.glide.load.engine.DataCacheKey
            com.bumptech.glide.load.Key r13 = r11.q3
            com.bumptech.glide.load.Key r1 = r11.b3
            r12.<init>(r13, r1)
        L_0x009c:
            com.bumptech.glide.load.engine.LockedResource r0 = com.bumptech.glide.load.engine.LockedResource.e(r0)
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r13 = r11.Y2
            r13.d(r12, r10, r0)
            goto L_0x00b4
        L_0x00a6:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.x(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
    }

    /* access modifiers changed from: package-private */
    public void y(boolean z) {
        if (this.Z2.d(z)) {
            z();
        }
    }
}
