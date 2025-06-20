package com.google.common.cache;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class CacheBuilderSpec {
    private static final Splitter o = Splitter.h(ASCIIPropertyListParser.f18651i).q();
    private static final Splitter p = Splitter.h(ASCIIPropertyListParser.f18654l).q();
    private static final ImmutableMap<String, ValueParser> q;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    Integer f22324a;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    Long f22325b;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    Long f22326c;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    Integer f22327d;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    LocalCache.Strength f22328e;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    LocalCache.Strength f22329f;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    Boolean f22330g;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    long f22331h;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    TimeUnit f22332i;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    long f22333j;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    TimeUnit f22334k;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    long f22335l;
    @CheckForNull
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    TimeUnit f22336m;

    /* renamed from: n  reason: collision with root package name */
    private final String f22337n;

    /* renamed from: com.google.common.cache.CacheBuilderSpec$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22338a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.cache.LocalCache$Strength[] r0 = com.google.common.cache.LocalCache.Strength.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22338a = r0
                com.google.common.cache.LocalCache$Strength r1 = com.google.common.cache.LocalCache.Strength.WEAK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22338a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.cache.LocalCache$Strength r1 = com.google.common.cache.LocalCache.Strength.SOFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.CacheBuilderSpec.AnonymousClass1.<clinit>():void");
        }
    }

    static class AccessDurationParser extends DurationParser {
        AccessDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, long j2, TimeUnit timeUnit) {
            Preconditions.e(cacheBuilderSpec.f22334k == null, "expireAfterAccess already set");
            cacheBuilderSpec.f22333j = j2;
            cacheBuilderSpec.f22334k = timeUnit;
        }
    }

    static class ConcurrencyLevelParser extends IntegerParser {
        ConcurrencyLevelParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, int i2) {
            Integer num = cacheBuilderSpec.f22327d;
            Preconditions.u(num == null, "concurrency level was already set to %s", num);
            cacheBuilderSpec.f22327d = Integer.valueOf(i2);
        }
    }

    static abstract class DurationParser implements ValueParser {
        DurationParser() {
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            TimeUnit timeUnit;
            if (!Strings.d(str2)) {
                try {
                    char charAt = str2.charAt(str2.length() - 1);
                    if (charAt == 'd') {
                        timeUnit = TimeUnit.DAYS;
                    } else if (charAt == 'h') {
                        timeUnit = TimeUnit.HOURS;
                    } else if (charAt == 'm') {
                        timeUnit = TimeUnit.MINUTES;
                    } else if (charAt == 's') {
                        timeUnit = TimeUnit.SECONDS;
                    } else {
                        throw new IllegalArgumentException(CacheBuilderSpec.d("key %s invalid unit: was %s, must end with one of [dhms]", str, str2));
                    }
                    b(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2));
                }
            } else {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
        }

        /* access modifiers changed from: protected */
        public abstract void b(CacheBuilderSpec cacheBuilderSpec, long j2, TimeUnit timeUnit);
    }

    static class InitialCapacityParser extends IntegerParser {
        InitialCapacityParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, int i2) {
            Integer num = cacheBuilderSpec.f22324a;
            Preconditions.u(num == null, "initial capacity was already set to %s", num);
            cacheBuilderSpec.f22324a = Integer.valueOf(i2);
        }
    }

    static abstract class IntegerParser implements ValueParser {
        IntegerParser() {
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.d(str2)) {
                try {
                    b(cacheBuilderSpec, Integer.parseInt(str2));
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2), e2);
                }
            } else {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
        }

        /* access modifiers changed from: protected */
        public abstract void b(CacheBuilderSpec cacheBuilderSpec, int i2);
    }

    static class KeyStrengthParser implements ValueParser {

        /* renamed from: a  reason: collision with root package name */
        private final LocalCache.Strength f22339a;

        public KeyStrengthParser(LocalCache.Strength strength) {
            this.f22339a = strength;
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z = false;
            Preconditions.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f22328e;
            if (strength == null) {
                z = true;
            }
            Preconditions.y(z, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f22328e = this.f22339a;
        }
    }

    static abstract class LongParser implements ValueParser {
        LongParser() {
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            if (!Strings.d(str2)) {
                try {
                    b(cacheBuilderSpec, Long.parseLong(str2));
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException(CacheBuilderSpec.d("key %s value set to %s, must be integer", str, str2), e2);
                }
            } else {
                throw new IllegalArgumentException("value of key " + str + " omitted");
            }
        }

        /* access modifiers changed from: protected */
        public abstract void b(CacheBuilderSpec cacheBuilderSpec, long j2);
    }

    static class MaximumSizeParser extends LongParser {
        MaximumSizeParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, long j2) {
            Long l2 = cacheBuilderSpec.f22325b;
            boolean z = false;
            Preconditions.u(l2 == null, "maximum size was already set to %s", l2);
            Long l3 = cacheBuilderSpec.f22326c;
            if (l3 == null) {
                z = true;
            }
            Preconditions.u(z, "maximum weight was already set to %s", l3);
            cacheBuilderSpec.f22325b = Long.valueOf(j2);
        }
    }

    static class MaximumWeightParser extends LongParser {
        MaximumWeightParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, long j2) {
            Long l2 = cacheBuilderSpec.f22326c;
            boolean z = false;
            Preconditions.u(l2 == null, "maximum weight was already set to %s", l2);
            Long l3 = cacheBuilderSpec.f22325b;
            if (l3 == null) {
                z = true;
            }
            Preconditions.u(z, "maximum size was already set to %s", l3);
            cacheBuilderSpec.f22326c = Long.valueOf(j2);
        }
    }

    static class RecordStatsParser implements ValueParser {
        RecordStatsParser() {
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z = false;
            Preconditions.e(str2 == null, "recordStats does not take values");
            if (cacheBuilderSpec.f22330g == null) {
                z = true;
            }
            Preconditions.e(z, "recordStats already set");
            cacheBuilderSpec.f22330g = Boolean.TRUE;
        }
    }

    static class RefreshDurationParser extends DurationParser {
        RefreshDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, long j2, TimeUnit timeUnit) {
            Preconditions.e(cacheBuilderSpec.f22336m == null, "refreshAfterWrite already set");
            cacheBuilderSpec.f22335l = j2;
            cacheBuilderSpec.f22336m = timeUnit;
        }
    }

    private interface ValueParser {
        void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2);
    }

    static class ValueStrengthParser implements ValueParser {

        /* renamed from: a  reason: collision with root package name */
        private final LocalCache.Strength f22340a;

        public ValueStrengthParser(LocalCache.Strength strength) {
            this.f22340a = strength;
        }

        public void a(CacheBuilderSpec cacheBuilderSpec, String str, @CheckForNull String str2) {
            boolean z = false;
            Preconditions.u(str2 == null, "key %s does not take values", str);
            LocalCache.Strength strength = cacheBuilderSpec.f22329f;
            if (strength == null) {
                z = true;
            }
            Preconditions.y(z, "%s was already set to %s", str, strength);
            cacheBuilderSpec.f22329f = this.f22340a;
        }
    }

    static class WriteDurationParser extends DurationParser {
        WriteDurationParser() {
        }

        /* access modifiers changed from: protected */
        public void b(CacheBuilderSpec cacheBuilderSpec, long j2, TimeUnit timeUnit) {
            Preconditions.e(cacheBuilderSpec.f22332i == null, "expireAfterWrite already set");
            cacheBuilderSpec.f22331h = j2;
            cacheBuilderSpec.f22332i = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder i2 = ImmutableMap.b().i("initialCapacity", new InitialCapacityParser()).i("maximumSize", new MaximumSizeParser()).i("maximumWeight", new MaximumWeightParser()).i("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        q = i2.i("weakKeys", new KeyStrengthParser(strength)).i("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).i("weakValues", new ValueStrengthParser(strength)).i("recordStats", new RecordStatsParser()).i("expireAfterAccess", new AccessDurationParser()).i("expireAfterWrite", new WriteDurationParser()).i("refreshAfterWrite", new RefreshDurationParser()).i("refreshInterval", new RefreshDurationParser()).d();
    }

    private CacheBuilderSpec(String str) {
        this.f22337n = str;
    }

    public static CacheBuilderSpec b() {
        return e("maximumSize=0");
    }

    @CheckForNull
    private static Long c(long j2, @CheckForNull TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j2));
    }

    /* access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public static CacheBuilderSpec e(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String next : o.n(str)) {
                ImmutableList<E> z = ImmutableList.z(p.n(next));
                Preconditions.e(!z.isEmpty(), "blank key-value pair");
                boolean z2 = false;
                Preconditions.u(z.size() <= 2, "key-value pair %s with more than one equals sign", next);
                String str2 = (String) z.get(0);
                ValueParser valueParser = q.get(str2);
                if (valueParser != null) {
                    z2 = true;
                }
                Preconditions.u(z2, "unknown key %s", str2);
                valueParser.a(cacheBuilderSpec, str2, z.size() == 1 ? null : (String) z.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.a(this.f22324a, cacheBuilderSpec.f22324a) && Objects.a(this.f22325b, cacheBuilderSpec.f22325b) && Objects.a(this.f22326c, cacheBuilderSpec.f22326c) && Objects.a(this.f22327d, cacheBuilderSpec.f22327d) && Objects.a(this.f22328e, cacheBuilderSpec.f22328e) && Objects.a(this.f22329f, cacheBuilderSpec.f22329f) && Objects.a(this.f22330g, cacheBuilderSpec.f22330g) && Objects.a(c(this.f22331h, this.f22332i), c(cacheBuilderSpec.f22331h, cacheBuilderSpec.f22332i)) && Objects.a(c(this.f22333j, this.f22334k), c(cacheBuilderSpec.f22333j, cacheBuilderSpec.f22334k)) && Objects.a(c(this.f22335l, this.f22336m), c(cacheBuilderSpec.f22335l, cacheBuilderSpec.f22336m));
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<Object, Object> f() {
        CacheBuilder<Object, Object> D = CacheBuilder.D();
        Integer num = this.f22324a;
        if (num != null) {
            D.x(num.intValue());
        }
        Long l2 = this.f22325b;
        if (l2 != null) {
            D.B(l2.longValue());
        }
        Long l3 = this.f22326c;
        if (l3 != null) {
            D.C(l3.longValue());
        }
        Integer num2 = this.f22327d;
        if (num2 != null) {
            D.e(num2.intValue());
        }
        LocalCache.Strength strength = this.f22328e;
        if (strength != null) {
            if (AnonymousClass1.f22338a[strength.ordinal()] == 1) {
                D.M();
            } else {
                throw new AssertionError();
            }
        }
        LocalCache.Strength strength2 = this.f22329f;
        if (strength2 != null) {
            int i2 = AnonymousClass1.f22338a[strength2.ordinal()];
            if (i2 == 1) {
                D.N();
            } else if (i2 == 2) {
                D.J();
            } else {
                throw new AssertionError();
            }
        }
        Boolean bool = this.f22330g;
        if (bool != null && bool.booleanValue()) {
            D.E();
        }
        TimeUnit timeUnit = this.f22332i;
        if (timeUnit != null) {
            D.g(this.f22331h, timeUnit);
        }
        TimeUnit timeUnit2 = this.f22334k;
        if (timeUnit2 != null) {
            D.f(this.f22333j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f22336m;
        if (timeUnit3 != null) {
            D.F(this.f22335l, timeUnit3);
        }
        return D;
    }

    public String g() {
        return this.f22337n;
    }

    public int hashCode() {
        return Objects.b(this.f22324a, this.f22325b, this.f22326c, this.f22327d, this.f22328e, this.f22329f, this.f22330g, c(this.f22331h, this.f22332i), c(this.f22333j, this.f22334k), c(this.f22335l, this.f22336m));
    }

    public String toString() {
        return MoreObjects.c(this).s(g()).toString();
    }
}
