package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {
    private static final int q = 16;
    private static final int r = 4;
    private static final int s = 0;
    private static final int t = 0;
    static final Supplier<? extends AbstractCache.StatsCounter> u = Suppliers.d(new AbstractCache.StatsCounter() {
        public void a() {
        }

        public void b(int i2) {
        }

        public void c(int i2) {
        }

        public void d(long j2) {
        }

        public void e(long j2) {
        }

        public CacheStats f() {
            return CacheBuilder.v;
        }
    });
    static final CacheStats v = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> w = new Supplier<AbstractCache.StatsCounter>() {
        /* renamed from: a */
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    static final Ticker x = new Ticker() {
        public long a() {
            return 0;
        }
    };
    static final int y = -1;

    /* renamed from: a  reason: collision with root package name */
    boolean f22309a = true;

    /* renamed from: b  reason: collision with root package name */
    int f22310b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f22311c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f22312d = -1;

    /* renamed from: e  reason: collision with root package name */
    long f22313e = -1;
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    Weigher<? super K, ? super V> f22314f;
    @CheckForNull

    /* renamed from: g  reason: collision with root package name */
    LocalCache.Strength f22315g;
    @CheckForNull

    /* renamed from: h  reason: collision with root package name */
    LocalCache.Strength f22316h;

    /* renamed from: i  reason: collision with root package name */
    long f22317i = -1;

    /* renamed from: j  reason: collision with root package name */
    long f22318j = -1;

    /* renamed from: k  reason: collision with root package name */
    long f22319k = -1;
    @CheckForNull

    /* renamed from: l  reason: collision with root package name */
    Equivalence<Object> f22320l;
    @CheckForNull

    /* renamed from: m  reason: collision with root package name */
    Equivalence<Object> f22321m;
    @CheckForNull

    /* renamed from: n  reason: collision with root package name */
    RemovalListener<? super K, ? super V> f22322n;
    @CheckForNull
    Ticker o;
    Supplier<? extends AbstractCache.StatsCounter> p = u;

    private static final class LoggerHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Logger f22323a = Logger.getLogger(CacheBuilder.class.getName());

        private LoggerHolder() {
        }
    }

    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void a(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int a(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> D() {
        return new CacheBuilder<>();
    }

    private void c() {
        Preconditions.h0(this.f22319k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void d() {
        String str;
        boolean z = false;
        if (this.f22314f == null) {
            if (this.f22313e == -1) {
                z = true;
            }
            str = "maximumWeight requires weigher";
        } else if (this.f22309a) {
            if (this.f22313e != -1) {
                z = true;
            }
            str = "weigher requires maximumWeight";
        } else if (this.f22313e == -1) {
            LoggerHolder.f22323a.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
            return;
        } else {
            return;
        }
        Preconditions.h0(z, str);
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> h(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.f().A();
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> i(String str) {
        return h(CacheBuilderSpec.e(str));
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> A() {
        this.f22309a = false;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> B(long j2) {
        long j3 = this.f22312d;
        boolean z = false;
        Preconditions.s0(j3 == -1, "maximum size was already set to %s", j3);
        long j4 = this.f22313e;
        Preconditions.s0(j4 == -1, "maximum weight was already set to %s", j4);
        Preconditions.h0(this.f22314f == null, "maximum size can not be combined with weigher");
        if (j2 >= 0) {
            z = true;
        }
        Preconditions.e(z, "maximum size must not be negative");
        this.f22312d = j2;
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> C(long j2) {
        long j3 = this.f22313e;
        boolean z = false;
        Preconditions.s0(j3 == -1, "maximum weight was already set to %s", j3);
        long j4 = this.f22312d;
        Preconditions.s0(j4 == -1, "maximum size was already set to %s", j4);
        if (j2 >= 0) {
            z = true;
        }
        Preconditions.e(z, "maximum weight must not be negative");
        this.f22313e = j2;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> E() {
        this.p = w;
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> F(long j2, TimeUnit timeUnit) {
        Preconditions.E(timeUnit);
        long j3 = this.f22319k;
        boolean z = false;
        Preconditions.s0(j3 == -1, "refresh was already set to %s ns", j3);
        if (j2 > 0) {
            z = true;
        }
        Preconditions.t(z, "duration must be positive: %s %s", j2, timeUnit);
        this.f22319k = timeUnit.toNanos(j2);
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> G(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.g0(this.f22322n == null);
        this.f22322n = (RemovalListener) Preconditions.E(removalListener);
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> H(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f22315g;
        Preconditions.x0(strength2 == null, "Key strength was already set to %s", strength2);
        this.f22315g = (LocalCache.Strength) Preconditions.E(strength);
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> I(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f22316h;
        Preconditions.x0(strength2 == null, "Value strength was already set to %s", strength2);
        this.f22316h = (LocalCache.Strength) Preconditions.E(strength);
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> J() {
        return I(LocalCache.Strength.SOFT);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> K(Ticker ticker) {
        Preconditions.g0(this.o == null);
        this.o = (Ticker) Preconditions.E(ticker);
        return this;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> L(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f22321m;
        Preconditions.x0(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f22321m = (Equivalence) Preconditions.E(equivalence);
        return this;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> M() {
        return H(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> N() {
        return I(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> O(Weigher<? super K1, ? super V1> weigher) {
        boolean z = false;
        Preconditions.g0(this.f22314f == null);
        if (this.f22309a) {
            long j2 = this.f22312d;
            if (j2 == -1) {
                z = true;
            }
            Preconditions.s0(z, "weigher can not be combined with maximum size (%s provided)", j2);
        }
        this.f22314f = (Weigher) Preconditions.E(weigher);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> e(int i2) {
        int i3 = this.f22311c;
        boolean z = false;
        Preconditions.n0(i3 == -1, "concurrency level was already set to %s", i3);
        if (i2 > 0) {
            z = true;
        }
        Preconditions.d(z);
        this.f22311c = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> f(long j2, TimeUnit timeUnit) {
        long j3 = this.f22318j;
        boolean z = false;
        Preconditions.s0(j3 == -1, "expireAfterAccess was already set to %s ns", j3);
        if (j2 >= 0) {
            z = true;
        }
        Preconditions.t(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.f22318j = timeUnit.toNanos(j2);
        return this;
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> g(long j2, TimeUnit timeUnit) {
        long j3 = this.f22317i;
        boolean z = false;
        Preconditions.s0(j3 == -1, "expireAfterWrite was already set to %s ns", j3);
        if (j2 >= 0) {
            z = true;
        }
        Preconditions.t(z, "duration cannot be negative: %s %s", j2, timeUnit);
        this.f22317i = timeUnit.toNanos(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        int i2 = this.f22311c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public long k() {
        long j2 = this.f22318j;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public long l() {
        long j2 = this.f22317i;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        int i2 = this.f22310b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> n() {
        return (Equivalence) MoreObjects.a(this.f22320l, o().b());
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength o() {
        return (LocalCache.Strength) MoreObjects.a(this.f22315g, LocalCache.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public long p() {
        if (this.f22317i == 0 || this.f22318j == 0) {
            return 0;
        }
        return this.f22314f == null ? this.f22312d : this.f22313e;
    }

    /* access modifiers changed from: package-private */
    public long q() {
        long j2 = this.f22319k;
        if (j2 == -1) {
            return 0;
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> r() {
        return (RemovalListener) MoreObjects.a(this.f22322n, NullListener.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> s() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public Ticker t(boolean z) {
        Ticker ticker = this.o;
        if (ticker != null) {
            return ticker;
        }
        return z ? Ticker.b() : x;
    }

    public String toString() {
        MoreObjects.ToStringHelper c2 = MoreObjects.c(this);
        int i2 = this.f22310b;
        if (i2 != -1) {
            c2.d("initialCapacity", i2);
        }
        int i3 = this.f22311c;
        if (i3 != -1) {
            c2.d("concurrencyLevel", i3);
        }
        long j2 = this.f22312d;
        if (j2 != -1) {
            c2.e("maximumSize", j2);
        }
        long j3 = this.f22313e;
        if (j3 != -1) {
            c2.e("maximumWeight", j3);
        }
        if (this.f22317i != -1) {
            c2.f("expireAfterWrite", this.f22317i + "ns");
        }
        if (this.f22318j != -1) {
            c2.f("expireAfterAccess", this.f22318j + "ns");
        }
        LocalCache.Strength strength = this.f22315g;
        if (strength != null) {
            c2.f("keyStrength", Ascii.g(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f22316h;
        if (strength2 != null) {
            c2.f("valueStrength", Ascii.g(strength2.toString()));
        }
        if (this.f22320l != null) {
            c2.s("keyEquivalence");
        }
        if (this.f22321m != null) {
            c2.s("valueEquivalence");
        }
        if (this.f22322n != null) {
            c2.s("removalListener");
        }
        return c2.toString();
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> u() {
        return (Equivalence) MoreObjects.a(this.f22321m, v().b());
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength v() {
        return (LocalCache.Strength) MoreObjects.a(this.f22316h, LocalCache.Strength.STRONG);
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> w() {
        return (Weigher) MoreObjects.a(this.f22314f, OneWeigher.INSTANCE);
    }

    @CanIgnoreReturnValue
    public CacheBuilder<K, V> x(int i2) {
        int i3 = this.f22310b;
        boolean z = false;
        Preconditions.n0(i3 == -1, "initial capacity was already set to %s", i3);
        if (i2 >= 0) {
            z = true;
        }
        Preconditions.d(z);
        this.f22310b = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.p == w;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @CanIgnoreReturnValue
    public CacheBuilder<K, V> z(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f22320l;
        Preconditions.x0(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f22320l = (Equivalence) Preconditions.E(equivalence);
        return this;
    }
}
