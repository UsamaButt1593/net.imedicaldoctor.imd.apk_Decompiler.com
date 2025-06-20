package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Temporal, Comparable<ChronoZonedDateTime<?>> {
    private static Comparator<ChronoZonedDateTime<?>> s = new Comparator<ChronoZonedDateTime<?>>() {
        /* renamed from: a */
        public int compare(ChronoZonedDateTime<?> chronoZonedDateTime, ChronoZonedDateTime<?> chronoZonedDateTime2) {
            int b2 = Jdk8Methods.b(chronoZonedDateTime.Q(), chronoZonedDateTime2.Q());
            return b2 == 0 ? Jdk8Methods.b(chronoZonedDateTime.h0().j1(), chronoZonedDateTime2.h0().j1()) : b2;
        }
    };

    /* renamed from: org.threeten.bp.chrono.ChronoZonedDateTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31789a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31789a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31789a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    public static Comparator<ChronoZonedDateTime<?>> L() {
        return s;
    }

    public static ChronoZonedDateTime<?> v(TemporalAccessor temporalAccessor) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoZonedDateTime) {
            return (ChronoZonedDateTime) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.i(TemporalQueries.a());
        if (chronology != null) {
            return chronology.P(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + temporalAccessor.getClass());
    }

    public boolean A(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int i2 = (Q() > chronoZonedDateTime.Q() ? 1 : (Q() == chronoZonedDateTime.Q() ? 0 : -1));
        return i2 < 0 || (i2 == 0 && h0().A() < chronoZonedDateTime.h0().A());
    }

    public abstract ChronoZonedDateTime<D> C0(ZoneId zoneId);

    public boolean D(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return Q() == chronoZonedDateTime.Q() && h0().A() == chronoZonedDateTime.h0().A();
    }

    public abstract ChronoZonedDateTime<D> D0(ZoneId zoneId);

    /* renamed from: E */
    public ChronoZonedDateTime<D> o(long j2, TemporalUnit temporalUnit) {
        return U().x().n(super.o(j2, temporalUnit));
    }

    /* renamed from: F */
    public ChronoZonedDateTime<D> g(TemporalAmount temporalAmount) {
        return U().x().n(super.g(temporalAmount));
    }

    /* renamed from: J */
    public abstract ChronoZonedDateTime<D> q(long j2, TemporalUnit temporalUnit);

    /* renamed from: K */
    public ChronoZonedDateTime<D> h(TemporalAmount temporalAmount) {
        return U().x().n(super.h(temporalAmount));
    }

    public long Q() {
        return ((U().c0() * 86400) + ((long) h0().k1())) - ((long) x().F());
    }

    public Instant S() {
        return Instant.k0(Q(), (long) h0().A());
    }

    public D U() {
        return c0().S();
    }

    public int b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.b(temporalField);
        }
        int i2 = AnonymousClass2.f31789a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? c0().b(temporalField) : x().F();
        }
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + temporalField);
    }

    public abstract ChronoLocalDateTime<D> c0();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.h() : c0().f(temporalField);
        }
        return temporalField.f(this);
    }

    public LocalTime h0() {
        return c0().U();
    }

    public int hashCode() {
        return (c0().hashCode() ^ x().hashCode()) ^ Integer.rotateLeft(y().hashCode(), 3);
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f()) {
            return y();
        }
        if (temporalQuery == TemporalQueries.a()) {
            return U().x();
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.d()) {
            return x();
        }
        if (temporalQuery == TemporalQueries.b()) {
            return LocalDate.w2(U().c0());
        }
        return temporalQuery == TemporalQueries.c() ? h0() : super.i(temporalQuery);
    }

    /* renamed from: k0 */
    public ChronoZonedDateTime<D> l(TemporalAdjuster temporalAdjuster) {
        return U().x().n(super.l(temporalAdjuster));
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i2 = AnonymousClass2.f31789a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? c0().p(temporalField) : (long) x().F();
        }
        return Q();
    }

    /* renamed from: q0 */
    public abstract ChronoZonedDateTime<D> a(TemporalField temporalField, long j2);

    public abstract ChronoZonedDateTime<D> r0();

    /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(org.threeten.bp.chrono.ChronoZonedDateTime<?> r5) {
        /*
            r4 = this;
            long r0 = r4.Q()
            long r2 = r5.Q()
            int r0 = org.threeten.bp.jdk8.Jdk8Methods.b(r0, r2)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.LocalTime r0 = r4.h0()
            int r0 = r0.A()
            org.threeten.bp.LocalTime r1 = r5.h0()
            int r1 = r1.A()
            int r0 = r0 - r1
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.chrono.ChronoLocalDateTime r0 = r4.c0()
            org.threeten.bp.chrono.ChronoLocalDateTime r1 = r5.c0()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.ZoneId r0 = r4.y()
            java.lang.String r0 = r0.s()
            org.threeten.bp.ZoneId r1 = r5.y()
            java.lang.String r1 = r1.s()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.chrono.ChronoLocalDate r0 = r4.U()
            org.threeten.bp.chrono.Chronology r0 = r0.x()
            org.threeten.bp.chrono.ChronoLocalDate r5 = r5.U()
            org.threeten.bp.chrono.Chronology r5 = r5.x()
            int r0 = r0.compareTo(r5)
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTime.compareTo(org.threeten.bp.chrono.ChronoZonedDateTime):int");
    }

    public String toString() {
        String str = c0().toString() + x().toString();
        if (x() == y()) {
            return str;
        }
        return str + '[' + y().toString() + ']';
    }

    public String u(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public abstract ChronoZonedDateTime<D> v0();

    public Chronology w() {
        return U().x();
    }

    public abstract ZoneOffset x();

    public abstract ZoneId y();

    public boolean z(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int i2 = (Q() > chronoZonedDateTime.Q() ? 1 : (Q() == chronoZonedDateTime.Q() ? 0 : -1));
        return i2 > 0 || (i2 == 0 && h0().A() > chronoZonedDateTime.h0().A());
    }
}
