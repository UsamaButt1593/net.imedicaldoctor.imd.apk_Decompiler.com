package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.PriorityDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class CacheDataSource implements DataSource {
    public static final int A = 0;
    public static final int B = 1;
    private static final long C = 102400;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 4;
    private static final int z = -1;

    /* renamed from: b  reason: collision with root package name */
    private final Cache f9934b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f9935c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f9936d;

    /* renamed from: e  reason: collision with root package name */
    private final DataSource f9937e;

    /* renamed from: f  reason: collision with root package name */
    private final CacheKeyFactory f9938f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final EventListener f9939g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f9940h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f9941i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f9942j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Uri f9943k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private DataSpec f9944l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private DataSpec f9945m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private DataSource f9946n;
    private long o;
    private long p;
    private long q;
    @Nullable
    private CacheSpan r;
    private boolean s;
    private boolean t;
    private long u;
    private long v;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void a(int i2);

        void b(long j2, long j3);
    }

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f9947a;

        /* renamed from: b  reason: collision with root package name */
        private DataSource.Factory f9948b = new FileDataSource.Factory();
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private DataSink.Factory f9949c;

        /* renamed from: d  reason: collision with root package name */
        private CacheKeyFactory f9950d = CacheKeyFactory.f9972a;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9951e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private DataSource.Factory f9952f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private PriorityTaskManager f9953g;

        /* renamed from: h  reason: collision with root package name */
        private int f9954h;

        /* renamed from: i  reason: collision with root package name */
        private int f9955i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private EventListener f9956j;

        private CacheDataSource f(@Nullable DataSource dataSource, int i2, int i3) {
            DataSink dataSink;
            Cache cache = (Cache) Assertions.g(this.f9947a);
            if (this.f9951e || dataSource == null) {
                dataSink = null;
            } else {
                DataSink.Factory factory = this.f9949c;
                dataSink = factory != null ? factory.a() : new CacheDataSink.Factory().c(cache).a();
            }
            return new CacheDataSource(cache, dataSource, this.f9948b.a(), dataSink, this.f9950d, i2, this.f9953g, i3, this.f9956j);
        }

        /* renamed from: c */
        public CacheDataSource a() {
            DataSource.Factory factory = this.f9952f;
            return f(factory != null ? factory.a() : null, this.f9955i, this.f9954h);
        }

        public CacheDataSource d() {
            DataSource.Factory factory = this.f9952f;
            return f(factory != null ? factory.a() : null, this.f9955i | 1, -1000);
        }

        public CacheDataSource e() {
            return f((DataSource) null, this.f9955i | 1, -1000);
        }

        @Nullable
        public Cache g() {
            return this.f9947a;
        }

        public CacheKeyFactory h() {
            return this.f9950d;
        }

        @Nullable
        public PriorityTaskManager i() {
            return this.f9953g;
        }

        @CanIgnoreReturnValue
        public Factory j(Cache cache) {
            this.f9947a = cache;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory k(CacheKeyFactory cacheKeyFactory) {
            this.f9950d = cacheKeyFactory;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory l(DataSource.Factory factory) {
            this.f9948b = factory;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory m(@Nullable DataSink.Factory factory) {
            this.f9949c = factory;
            this.f9951e = factory == null;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory n(@Nullable EventListener eventListener) {
            this.f9956j = eventListener;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory o(int i2) {
            this.f9955i = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory p(@Nullable DataSource.Factory factory) {
            this.f9952f = factory;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory q(int i2) {
            this.f9954h = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory r(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f9953g = priorityTaskManager;
            return this;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    private boolean A() {
        return !z();
    }

    private boolean B() {
        return this.f9946n == this.f9936d;
    }

    private void C() {
        EventListener eventListener = this.f9939g;
        if (eventListener != null && this.u > 0) {
            eventListener.b(this.f9934b.q(), this.u);
            this.u = 0;
        }
    }

    private void D(int i2) {
        EventListener eventListener = this.f9939g;
        if (eventListener != null) {
            eventListener.a(i2);
        }
    }

    private void E(DataSpec dataSpec, boolean z2) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec2;
        DataSource dataSource;
        long j2;
        DataSpec dataSpec3 = dataSpec;
        String str = (String) Util.o(dataSpec3.f9787i);
        Uri uri = null;
        if (this.t) {
            cacheSpan = null;
        } else if (this.f9940h) {
            try {
                cacheSpan = this.f9934b.l(str, this.p, this.q);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.f9934b.i(str, this.p, this.q);
        }
        if (cacheSpan == null) {
            dataSource = this.f9937e;
            dataSpec2 = dataSpec.a().i(this.p).h(this.q).a();
        } else if (cacheSpan.Z) {
            Uri fromFile = Uri.fromFile((File) Util.o(cacheSpan.X2));
            long j3 = cacheSpan.X;
            long j4 = this.p - j3;
            long j5 = cacheSpan.Y - j4;
            long j6 = this.q;
            if (j6 != -1) {
                j5 = Math.min(j5, j6);
            }
            dataSpec2 = dataSpec.a().j(fromFile).l(j3).i(j4).h(j5).a();
            dataSource = this.f9935c;
        } else {
            if (cacheSpan.c()) {
                j2 = this.q;
            } else {
                j2 = cacheSpan.Y;
                long j7 = this.q;
                if (j7 != -1) {
                    j2 = Math.min(j2, j7);
                }
            }
            dataSpec2 = dataSpec.a().i(this.p).h(j2).a();
            dataSource = this.f9936d;
            if (dataSource == null) {
                dataSource = this.f9937e;
                this.f9934b.d(cacheSpan);
                cacheSpan = null;
            }
        }
        this.v = (this.t || dataSource != this.f9937e) ? Long.MAX_VALUE : this.p + C;
        if (z2) {
            Assertions.i(y());
            if (dataSource != this.f9937e) {
                try {
                    t();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (((CacheSpan) Util.o(cacheSpan)).b()) {
                        this.f9934b.d(cacheSpan);
                    }
                    throw th2;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.b()) {
            this.r = cacheSpan;
        }
        this.f9946n = dataSource;
        this.f9945m = dataSpec2;
        this.o = 0;
        long a2 = dataSource.a(dataSpec2);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpec2.f9786h == -1 && a2 != -1) {
            this.q = a2;
            ContentMetadataMutations.h(contentMetadataMutations, this.p + a2);
        }
        if (A()) {
            Uri c2 = dataSource.c();
            this.f9943k = c2;
            if (!dataSpec3.f9779a.equals(c2)) {
                uri = this.f9943k;
            }
            ContentMetadataMutations.i(contentMetadataMutations, uri);
        }
        if (B()) {
            this.f9934b.p(str, contentMetadataMutations);
        }
    }

    private void F(String str) throws IOException {
        this.q = 0;
        if (B()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.h(contentMetadataMutations, this.p);
            this.f9934b.p(str, contentMetadataMutations);
        }
    }

    private int G(DataSpec dataSpec) {
        if (!this.f9941i || !this.s) {
            return (!this.f9942j || dataSpec.f9786h != -1) ? -1 : 1;
        }
        return 0;
    }

    private void t() throws IOException {
        DataSource dataSource = this.f9946n;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f9945m = null;
                this.f9946n = null;
                CacheSpan cacheSpan = this.r;
                if (cacheSpan != null) {
                    this.f9934b.d(cacheSpan);
                    this.r = null;
                }
            }
        }
    }

    private static Uri w(Cache cache, String str, Uri uri) {
        Uri b2 = c.b(cache.e(str));
        return b2 != null ? b2 : uri;
    }

    private void x(Throwable th) {
        if (z() || (th instanceof Cache.CacheException)) {
            this.s = true;
        }
    }

    private boolean y() {
        return this.f9946n == this.f9937e;
    }

    private boolean z() {
        return this.f9946n == this.f9935c;
    }

    public long a(DataSpec dataSpec) throws IOException {
        try {
            String a2 = this.f9938f.a(dataSpec);
            DataSpec a3 = dataSpec.a().g(a2).a();
            this.f9944l = a3;
            this.f9943k = w(this.f9934b, a2, a3.f9779a);
            this.p = dataSpec.f9785g;
            int G = G(dataSpec);
            boolean z2 = G != -1;
            this.t = z2;
            if (z2) {
                D(G);
            }
            if (this.t) {
                this.q = -1;
            } else {
                long a4 = c.a(this.f9934b.e(a2));
                this.q = a4;
                if (a4 != -1) {
                    long j2 = a4 - dataSpec.f9785g;
                    this.q = j2;
                    if (j2 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j3 = dataSpec.f9786h;
            if (j3 != -1) {
                long j4 = this.q;
                if (j4 != -1) {
                    j3 = Math.min(j4, j3);
                }
                this.q = j3;
            }
            long j5 = this.q;
            if (j5 > 0 || j5 == -1) {
                E(a3, false);
            }
            long j6 = dataSpec.f9786h;
            return j6 != -1 ? j6 : this.q;
        } catch (Throwable th) {
            x(th);
            throw th;
        }
    }

    @Nullable
    public Uri c() {
        return this.f9943k;
    }

    public void close() throws IOException {
        this.f9944l = null;
        this.f9943k = null;
        this.p = 0;
        C();
        try {
            t();
        } catch (Throwable th) {
            x(th);
            throw th;
        }
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9935c.e(transferListener);
        this.f9937e.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return A() ? this.f9937e.getResponseHeaders() : Collections.emptyMap();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.q == 0) {
            return -1;
        }
        DataSpec dataSpec = (DataSpec) Assertions.g(this.f9944l);
        DataSpec dataSpec2 = (DataSpec) Assertions.g(this.f9945m);
        try {
            if (this.p >= this.v) {
                E(dataSpec, true);
            }
            int read = ((DataSource) Assertions.g(this.f9946n)).read(bArr, i2, i3);
            if (read != -1) {
                if (z()) {
                    this.u += (long) read;
                }
                long j2 = (long) read;
                this.p += j2;
                this.o += j2;
                long j3 = this.q;
                if (j3 != -1) {
                    this.q = j3 - j2;
                }
            } else {
                if (A()) {
                    long j4 = dataSpec2.f9786h;
                    if (j4 == -1 || this.o < j4) {
                        F((String) Util.o(dataSpec.f9787i));
                    }
                }
                long j5 = this.q;
                if (j5 <= 0) {
                    if (j5 == -1) {
                    }
                }
                t();
                E(dataSpec, false);
                return read(bArr, i2, i3);
            }
            return read;
        } catch (Throwable th) {
            x(th);
            throw th;
        }
    }

    public Cache u() {
        return this.f9934b;
    }

    public CacheKeyFactory v() {
        return this.f9938f;
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, int i2) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, CacheDataSink.f9917k), i2, (EventListener) null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i2, @Nullable EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i2, eventListener, (CacheKeyFactory) null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i2, @Nullable EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i2, (PriorityTaskManager) null, 0, eventListener);
    }

    private CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, @Nullable CacheKeyFactory cacheKeyFactory, int i2, @Nullable PriorityTaskManager priorityTaskManager, int i3, @Nullable EventListener eventListener) {
        this.f9934b = cache;
        this.f9935c = dataSource2;
        this.f9938f = cacheKeyFactory == null ? CacheKeyFactory.f9972a : cacheKeyFactory;
        boolean z2 = false;
        this.f9940h = (i2 & 1) != 0;
        this.f9941i = (i2 & 2) != 0;
        this.f9942j = (i2 & 4) != 0 ? true : z2;
        TeeDataSource teeDataSource = null;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i3) : dataSource;
            this.f9937e = dataSource;
            if (dataSink != null) {
                teeDataSource = new TeeDataSource(dataSource, dataSink);
            }
        } else {
            this.f9937e = PlaceholderDataSource.f9876b;
        }
        this.f9936d = teeDataSource;
        this.f9939g = eventListener;
    }
}
