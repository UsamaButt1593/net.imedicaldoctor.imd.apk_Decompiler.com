package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
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
import org.threeten.bp.temporal.ValueRange;

public final class OffsetDateTime extends DefaultInterfaceTemporal implements Temporal, TemporalAdjuster, Comparable<OffsetDateTime>, Serializable {
    public static final TemporalQuery<OffsetDateTime> X2 = new TemporalQuery<OffsetDateTime>() {
        /* renamed from: b */
        public OffsetDateTime a(TemporalAccessor temporalAccessor) {
            return OffsetDateTime.x(temporalAccessor);
        }
    };
    public static final OffsetDateTime Y = LocalDateTime.Z.k0(ZoneOffset.i3);
    private static final Comparator<OffsetDateTime> Y2 = new Comparator<OffsetDateTime>() {
        /* renamed from: a */
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int b2 = Jdk8Methods.b(offsetDateTime.n2(), offsetDateTime2.n2());
            return b2 == 0 ? Jdk8Methods.b((long) offsetDateTime.F(), (long) offsetDateTime2.F()) : b2;
        }
    };
    public static final OffsetDateTime Z = LocalDateTime.X2.k0(ZoneOffset.h3);
    private static final long Z2 = 2287754244819255394L;
    private final ZoneOffset X;
    private final LocalDateTime s;

    /* renamed from: org.threeten.bp.OffsetDateTime$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31780a;

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
                f31780a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31780a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetDateTime.AnonymousClass3.<clinit>():void");
        }
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.s = (LocalDateTime) Jdk8Methods.j(localDateTime, "dateTime");
        this.X = (ZoneOffset) Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
    }

    private OffsetDateTime E2(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.s != localDateTime || !this.X.equals(zoneOffset)) ? new OffsetDateTime(localDateTime, zoneOffset) : this;
    }

    public static OffsetDateTime G0() {
        return K0(Clock.g());
    }

    public static OffsetDateTime K0(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        Instant c2 = clock.c();
        return c1(c2, clock.b().u().b(c2));
    }

    public static OffsetDateTime L0(ZoneId zoneId) {
        return K0(Clock.f(zoneId));
    }

    public static OffsetDateTime R0(int i2, int i3, int i4, int i5, int i6, int i7, int i8, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.i2(i2, i3, i4, i5, i6, i7, i8), zoneOffset);
    }

    public static OffsetDateTime S0(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.p2(localDate, localTime), zoneOffset);
    }

    private Object X2() {
        return new Ser((byte) 69, this);
    }

    public static OffsetDateTime Y0(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime c1(Instant instant, ZoneId zoneId) {
        Jdk8Methods.j(instant, "instant");
        Jdk8Methods.j(zoneId, "zone");
        ZoneOffset b2 = zoneId.u().b(instant);
        return new OffsetDateTime(LocalDateTime.q2(instant.y(), instant.z(), b2), b2);
    }

    public static OffsetDateTime d1(CharSequence charSequence) {
        return e1(charSequence, DateTimeFormatter.o);
    }

    public static OffsetDateTime e1(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.r(charSequence, X2);
    }

    static OffsetDateTime i2(DataInput dataInput) throws IOException {
        return Y0(LocalDateTime.S2(dataInput), ZoneOffset.O(dataInput));
    }

    private Object j2() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> m2() {
        return Y2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return c1(org.threeten.bp.Instant.x(r3), r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.OffsetDateTime x(org.threeten.bp.temporal.TemporalAccessor r3) {
        /*
            boolean r0 = r3 instanceof org.threeten.bp.OffsetDateTime
            if (r0 == 0) goto L_0x0007
            org.threeten.bp.OffsetDateTime r3 = (org.threeten.bp.OffsetDateTime) r3
            return r3
        L_0x0007:
            org.threeten.bp.ZoneOffset r0 = org.threeten.bp.ZoneOffset.E(r3)     // Catch:{ DateTimeException -> 0x001d }
            org.threeten.bp.LocalDateTime r1 = org.threeten.bp.LocalDateTime.v0(r3)     // Catch:{ DateTimeException -> 0x0014 }
            org.threeten.bp.OffsetDateTime r3 = Y0(r1, r0)     // Catch:{ DateTimeException -> 0x0014 }
            return r3
        L_0x0014:
            org.threeten.bp.Instant r1 = org.threeten.bp.Instant.x(r3)     // Catch:{ DateTimeException -> 0x001d }
            org.threeten.bp.OffsetDateTime r3 = c1(r1, r0)     // Catch:{ DateTimeException -> 0x001d }
            return r3
        L_0x001d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to obtain OffsetDateTime from TemporalAccessor: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", type "
            r1.append(r2)
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetDateTime.x(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.OffsetDateTime");
    }

    public int A() {
        return this.s.G0();
    }

    public int A1() {
        return this.s.A1();
    }

    public ZonedDateTime B2() {
        return ZonedDateTime.p2(this.s, this.X);
    }

    public OffsetDateTime C0(long j2) {
        return j2 == Long.MIN_VALUE ? e2(Long.MAX_VALUE).e2(1) : e2(-j2);
    }

    public OffsetDateTime C2(TemporalUnit temporalUnit) {
        return E2(this.s.V2(temporalUnit), this.X);
    }

    public Month D() {
        return this.s.K0();
    }

    public OffsetDateTime D0(long j2) {
        return j2 == Long.MIN_VALUE ? f2(Long.MAX_VALUE).f2(1) : f2(-j2);
    }

    public OffsetDateTime D1(long j2) {
        return E2(this.s.J2(j2), this.X);
    }

    public int E() {
        return this.s.L0();
    }

    public int F() {
        return this.s.R0();
    }

    public OffsetDateTime F1(long j2) {
        return E2(this.s.L2(j2), this.X);
    }

    /* renamed from: G2 */
    public OffsetDateTime l(TemporalAdjuster temporalAdjuster) {
        if ((temporalAdjuster instanceof LocalDate) || (temporalAdjuster instanceof LocalTime) || (temporalAdjuster instanceof LocalDateTime)) {
            return E2(this.s.l(temporalAdjuster), this.X);
        }
        if (temporalAdjuster instanceof Instant) {
            return c1((Instant) temporalAdjuster, this.X);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return E2(this.s, (ZoneOffset) temporalAdjuster);
        }
        return temporalAdjuster instanceof OffsetDateTime ? (OffsetDateTime) temporalAdjuster : (OffsetDateTime) temporalAdjuster.e(this);
    }

    /* renamed from: I2 */
    public OffsetDateTime a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (OffsetDateTime) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass3.f31780a[chronoField.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? E2(this.s.h0(temporalField, j2), this.X) : E2(this.s, ZoneOffset.L(chronoField.m(j2)));
        }
        return c1(Instant.k0(j2, (long) F()), this.X);
    }

    public ZoneOffset J() {
        return this.X;
    }

    public OffsetDateTime J2(int i2) {
        return E2(this.s.Z2(i2), this.X);
    }

    public boolean K(OffsetDateTime offsetDateTime) {
        int i2 = (n2() > offsetDateTime.n2() ? 1 : (n2() == offsetDateTime.n2() ? 0 : -1));
        return i2 > 0 || (i2 == 0 && u2().A() > offsetDateTime.u2().A());
    }

    public boolean L(OffsetDateTime offsetDateTime) {
        int i2 = (n2() > offsetDateTime.n2() ? 1 : (n2() == offsetDateTime.n2() ? 0 : -1));
        return i2 < 0 || (i2 == 0 && u2().A() < offsetDateTime.u2().A());
    }

    public OffsetDateTime L2(int i2) {
        return E2(this.s.a3(i2), this.X);
    }

    public int M0() {
        return this.s.M0();
    }

    public OffsetDateTime M2(int i2) {
        return E2(this.s.b3(i2), this.X);
    }

    public OffsetDateTime N2(int i2) {
        return E2(this.s.c3(i2), this.X);
    }

    public OffsetDateTime P2(int i2) {
        return E2(this.s.d3(i2), this.X);
    }

    public boolean Q(OffsetDateTime offsetDateTime) {
        return n2() == offsetDateTime.n2() && u2().A() == offsetDateTime.u2().A();
    }

    public OffsetDateTime Q2(int i2) {
        return E2(this.s.e3(i2), this.X);
    }

    /* renamed from: S */
    public OffsetDateTime o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public int S1() {
        return this.s.S1();
    }

    public OffsetDateTime S2(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.X)) {
            return this;
        }
        return new OffsetDateTime(this.s.M2((long) (zoneOffset.F() - this.X.F())), zoneOffset);
    }

    public OffsetDateTime T1(long j2) {
        return E2(this.s.M2(j2), this.X);
    }

    public OffsetDateTime T2(ZoneOffset zoneOffset) {
        return E2(this.s, zoneOffset);
    }

    /* renamed from: U */
    public OffsetDateTime g(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.a(this);
    }

    public OffsetDateTime U2(int i2) {
        return E2(this.s.f3(i2), this.X);
    }

    public OffsetDateTime V2(int i2) {
        return E2(this.s.g3(i2), this.X);
    }

    /* access modifiers changed from: package-private */
    public void W2(DataOutput dataOutput) throws IOException {
        this.s.h3(dataOutput);
        this.X.S(dataOutput);
    }

    public int b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.b(temporalField);
        }
        int i2 = AnonymousClass3.f31780a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? this.s.b(temporalField) : J().F();
        }
        throw new DateTimeException("Field too large for an int: " + temporalField);
    }

    public OffsetDateTime c0(long j2) {
        return j2 == Long.MIN_VALUE ? k1(Long.MAX_VALUE).k1(1) : k1(-j2);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.EPOCH_DAY, q2().c0()).a(ChronoField.NANO_OF_DAY, u2().j1()).a(ChronoField.OFFSET_SECONDS, (long) J().F());
    }

    public OffsetDateTime e2(long j2) {
        return E2(this.s.N2(j2), this.X);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.s.equals(offsetDateTime.s) && this.X.equals(offsetDateTime.X);
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.h() : this.s.f(temporalField);
        }
        return temporalField.f(this);
    }

    public OffsetDateTime f2(long j2) {
        return E2(this.s.Q2(j2), this.X);
    }

    public OffsetDateTime h0(long j2) {
        return j2 == Long.MIN_VALUE ? l1(Long.MAX_VALUE).l1(1) : l1(-j2);
    }

    /* renamed from: h1 */
    public OffsetDateTime q(long j2, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? E2(this.s.q(j2, temporalUnit), this.X) : (OffsetDateTime) temporalUnit.g(this, j2);
    }

    public int hashCode() {
        return this.s.hashCode() ^ this.X.hashCode();
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.a()) {
            return IsoChronology.X2;
        }
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return J();
        }
        if (temporalQuery == TemporalQueries.b()) {
            return q2();
        }
        if (temporalQuery == TemporalQueries.c()) {
            return u2();
        }
        if (temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return super.i(temporalQuery);
    }

    /* renamed from: j1 */
    public OffsetDateTime h(TemporalAmount temporalAmount) {
        return (OffsetDateTime) temporalAmount.b(this);
    }

    public OffsetDateTime k0(long j2) {
        return j2 == Long.MIN_VALUE ? w1(Long.MAX_VALUE).w1(1) : w1(-j2);
    }

    public OffsetDateTime k1(long j2) {
        return E2(this.s.E2(j2), this.X);
    }

    public OffsetDateTime l1(long j2) {
        return E2(this.s.G2(j2), this.X);
    }

    public boolean m(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.c(this));
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.a() || temporalUnit.b() : temporalUnit != null && temporalUnit.f(this);
    }

    public long n2() {
        return this.s.L(this.X);
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i2 = AnonymousClass3.f31780a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? this.s.p(temporalField) : (long) J().F();
        }
        return n2();
    }

    public Instant p2() {
        return this.s.Q(this.X);
    }

    public OffsetDateTime q0(long j2) {
        return j2 == Long.MIN_VALUE ? D1(Long.MAX_VALUE).D1(1) : D1(-j2);
    }

    public LocalDate q2() {
        return this.s.S();
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        OffsetDateTime x = x(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, x);
        }
        return this.s.r(x.S2(this.X).s, temporalUnit);
    }

    public OffsetDateTime r0(long j2) {
        return j2 == Long.MIN_VALUE ? F1(Long.MAX_VALUE).F1(1) : F1(-j2);
    }

    public LocalDateTime r2() {
        return this.s;
    }

    public ZonedDateTime s(ZoneId zoneId) {
        return ZonedDateTime.r2(this.s, this.X, zoneId);
    }

    public String toString() {
        return this.s.toString() + this.X.toString();
    }

    public ZonedDateTime u(ZoneId zoneId) {
        return ZonedDateTime.w2(this.s, zoneId, this.X);
    }

    public LocalTime u2() {
        return this.s.U();
    }

    /* renamed from: v */
    public int compareTo(OffsetDateTime offsetDateTime) {
        if (J().equals(offsetDateTime.J())) {
            return r2().compareTo(offsetDateTime.r2());
        }
        int b2 = Jdk8Methods.b(n2(), offsetDateTime.n2());
        if (b2 != 0) {
            return b2;
        }
        int A = u2().A() - offsetDateTime.u2().A();
        return A == 0 ? r2().compareTo(offsetDateTime.r2()) : A;
    }

    public OffsetDateTime v0(long j2) {
        return j2 == Long.MIN_VALUE ? T1(Long.MAX_VALUE).T1(1) : T1(-j2);
    }

    public String w(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public OffsetDateTime w1(long j2) {
        return E2(this.s.I2(j2), this.X);
    }

    public OffsetTime w2() {
        return OffsetTime.k0(this.s.U(), this.X);
    }

    public int y() {
        return this.s.C0();
    }

    public int y0() {
        return this.s.y0();
    }

    public DayOfWeek z() {
        return this.s.D0();
    }
}
