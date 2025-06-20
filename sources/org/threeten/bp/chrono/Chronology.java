package org.threeten.bp.chrono;

import androidx.core.text.util.LocalePreferences;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class Chronology implements Comparable<Chronology> {
    private static final ConcurrentHashMap<String, Chronology> X = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Chronology> Y = new ConcurrentHashMap<>();
    private static final Method Z;
    public static final TemporalQuery<Chronology> s = new TemporalQuery<Chronology>() {
        /* renamed from: b */
        public Chronology a(TemporalAccessor temporalAccessor) {
            return Chronology.q(temporalAccessor);
        }
    };

    static {
        Method method;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});
        } catch (Throwable unused) {
            method = null;
        }
        Z = method;
    }

    protected Chronology() {
    }

    public static Chronology A(Locale locale) {
        String str;
        w();
        Jdk8Methods.j(locale, "locale");
        Method method = Z;
        if (method != null) {
            try {
                str = (String) method.invoke(locale, new Object[]{"ca"});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        } else {
            if (locale.equals(JapaneseChronology.X2)) {
                str = "japanese";
            }
            str = "iso";
        }
        if (str == null || "iso".equals(str) || "iso8601".equals(str)) {
            return IsoChronology.X2;
        }
        Chronology chronology = Y.get(str);
        if (chronology != null) {
            return chronology;
        }
        throw new DateTimeException("Unknown calendar system: " + str);
    }

    static Chronology F(DataInput dataInput) throws IOException {
        return z(dataInput.readUTF());
    }

    private Object H() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static void I(Chronology chronology) {
        X.putIfAbsent(chronology.v(), chronology);
        String s2 = chronology.s();
        if (s2 != null) {
            Y.putIfAbsent(s2, chronology);
        }
    }

    private Object N() {
        return new Ser((byte) 11, this);
    }

    public static Chronology q(TemporalAccessor temporalAccessor) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.i(TemporalQueries.a());
        return chronology != null ? chronology : IsoChronology.X2;
    }

    public static Set<Chronology> r() {
        w();
        return new HashSet(X.values());
    }

    private static void w() {
        ConcurrentHashMap<String, Chronology> concurrentHashMap = X;
        if (concurrentHashMap.isEmpty()) {
            I(IsoChronology.X2);
            I(ThaiBuddhistChronology.X2);
            I(MinguoChronology.X2);
            I(JapaneseChronology.Y2);
            HijrahChronology hijrahChronology = HijrahChronology.X2;
            I(hijrahChronology);
            concurrentHashMap.putIfAbsent("Hijrah", hijrahChronology);
            Y.putIfAbsent(LocalePreferences.CalendarType.f6252g, hijrahChronology);
            Class<Chronology> cls = Chronology.class;
            Iterator<S> it2 = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
            while (it2.hasNext()) {
                Chronology chronology = (Chronology) it2.next();
                X.putIfAbsent(chronology.v(), chronology);
                String s2 = chronology.s();
                if (s2 != null) {
                    Y.putIfAbsent(s2, chronology);
                }
            }
        }
    }

    public static Chronology z(String str) {
        w();
        Chronology chronology = X.get(str);
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = Y.get(str);
        if (chronology2 != null) {
            return chronology2;
        }
        throw new DateTimeException("Unknown chronology: " + str);
    }

    public ChronoPeriod C(int i2, int i3, int i4) {
        return new ChronoPeriodImpl(this, i2, i3, i4);
    }

    public abstract int D(Era era, int i2);

    public abstract ValueRange E(ChronoField chronoField);

    public abstract ChronoLocalDate J(Map<TemporalField, Long> map, ResolverStyle resolverStyle);

    /* access modifiers changed from: package-private */
    public void K(Map<TemporalField, Long> map, ChronoField chronoField, long j2) {
        Long l2 = map.get(chronoField);
        if (l2 == null || l2.longValue() == j2) {
            map.put(chronoField, Long.valueOf(j2));
            return;
        }
        throw new DateTimeException("Invalid state, field: " + chronoField + StringUtils.SPACE + l2 + " conflicts with " + chronoField + StringUtils.SPACE + j2);
    }

    /* access modifiers changed from: package-private */
    public void L(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(v());
    }

    public ChronoZonedDateTime<?> O(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.L0(this, instant, zoneId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        return org.threeten.bp.chrono.ChronoZonedDateTimeImpl.K0(m(y(r5)), r0, (org.threeten.bp.ZoneOffset) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.chrono.ChronoZonedDateTime<?> P(org.threeten.bp.temporal.TemporalAccessor r5) {
        /*
            r4 = this;
            org.threeten.bp.ZoneId r0 = org.threeten.bp.ZoneId.j(r5)     // Catch:{ DateTimeException -> 0x001b }
            org.threeten.bp.Instant r1 = org.threeten.bp.Instant.x(r5)     // Catch:{ DateTimeException -> 0x000d }
            org.threeten.bp.chrono.ChronoZonedDateTime r5 = r4.O(r1, r0)     // Catch:{ DateTimeException -> 0x000d }
            return r5
        L_0x000d:
            org.threeten.bp.chrono.ChronoLocalDateTime r1 = r4.y(r5)     // Catch:{ DateTimeException -> 0x001b }
            org.threeten.bp.chrono.ChronoLocalDateTimeImpl r1 = r4.m(r1)     // Catch:{ DateTimeException -> 0x001b }
            r2 = 0
            org.threeten.bp.chrono.ChronoZonedDateTime r5 = org.threeten.bp.chrono.ChronoZonedDateTimeImpl.K0(r1, r0, r2)     // Catch:{ DateTimeException -> 0x001b }
            return r5
        L_0x001b:
            r0 = move-exception
            org.threeten.bp.DateTimeException r1 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to obtain ChronoZonedDateTime from TemporalAccessor: "
            r2.append(r3)
            java.lang.Class r5 = r5.getClass()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.Chronology.P(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.chrono.ChronoZonedDateTime");
    }

    /* renamed from: a */
    public int compareTo(Chronology chronology) {
        return v().compareTo(chronology.v());
    }

    public abstract ChronoLocalDate b(int i2, int i3, int i4);

    public ChronoLocalDate c(Era era, int i2, int i3, int i4) {
        return b(D(era, i2), i3, i4);
    }

    public abstract ChronoLocalDate e(TemporalAccessor temporalAccessor);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Chronology) && compareTo((Chronology) obj) == 0;
    }

    public abstract ChronoLocalDate f(long j2);

    public ChronoLocalDate g() {
        return h(Clock.g());
    }

    public ChronoLocalDate h(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return e(LocalDate.p2(clock));
    }

    public int hashCode() {
        return getClass().hashCode() ^ v().hashCode();
    }

    public ChronoLocalDate i(ZoneId zoneId) {
        return h(Clock.f(zoneId));
    }

    public abstract ChronoLocalDate j(int i2, int i3);

    public ChronoLocalDate k(Era era, int i2, int i3) {
        return j(D(era, i2), i3);
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> D l(Temporal temporal) {
        D d2 = (ChronoLocalDate) temporal;
        if (equals(d2.x())) {
            return d2;
        }
        throw new ClassCastException("Chrono mismatch, expected: " + v() + ", actual: " + d2.x().v());
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> ChronoLocalDateTimeImpl<D> m(Temporal temporal) {
        ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (equals(chronoLocalDateTimeImpl.S().x())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + v() + ", supplied: " + chronoLocalDateTimeImpl.S().x().v());
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoLocalDate> ChronoZonedDateTimeImpl<D> n(Temporal temporal) {
        ChronoZonedDateTimeImpl<D> chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (equals(chronoZonedDateTimeImpl.U().x())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + v() + ", supplied: " + chronoZonedDateTimeImpl.U().x().v());
    }

    public abstract Era o(int i2);

    public abstract List<Era> p();

    public abstract String s();

    public String toString() {
        return v();
    }

    public String u(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().c(textStyle).Q(locale).d(new DefaultInterfaceTemporalAccessor() {
            public <R> R i(TemporalQuery<R> temporalQuery) {
                return temporalQuery == TemporalQueries.a() ? Chronology.this : super.i(temporalQuery);
            }

            public boolean m(TemporalField temporalField) {
                return false;
            }

            public long p(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        });
    }

    public abstract String v();

    public abstract boolean x(long j2);

    public ChronoLocalDateTime<?> y(TemporalAccessor temporalAccessor) {
        try {
            return e(temporalAccessor).s(LocalTime.y(temporalAccessor));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + temporalAccessor.getClass(), e2);
        }
    }
}
