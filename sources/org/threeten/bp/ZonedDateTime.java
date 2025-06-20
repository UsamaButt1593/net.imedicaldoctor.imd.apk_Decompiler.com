package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
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
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Temporal, Serializable {
    public static final TemporalQuery<ZonedDateTime> X2 = new TemporalQuery<ZonedDateTime>() {
        /* renamed from: b */
        public ZonedDateTime a(TemporalAccessor temporalAccessor) {
            return ZonedDateTime.K0(temporalAccessor);
        }
    };
    private static final long Y2 = -6260982410461394882L;
    private final LocalDateTime X;
    private final ZoneOffset Y;
    private final ZoneId Z;

    /* renamed from: org.threeten.bp.ZonedDateTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31786a;

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
                f31786a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31786a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.X = localDateTime;
        this.Y = zoneOffset;
        this.Z = zoneId;
    }

    public static ZonedDateTime B2(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.j(localDateTime, "localDateTime");
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        Jdk8Methods.j(zoneId, "zone");
        ZoneRules u = zoneId.u();
        if (u.k(localDateTime, zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        ZoneOffsetTransition e2 = u.e(localDateTime);
        if (e2 == null || !e2.k()) {
            throw new DateTimeException("ZoneOffset '" + zoneOffset + "' is not valid for LocalDateTime '" + localDateTime + "' in zone '" + zoneId + "'");
        }
        throw new DateTimeException("LocalDateTime '" + localDateTime + "' does not exist in zone '" + zoneId + "' due to a gap in the local time-line, typically caused by daylight savings");
    }

    public static ZonedDateTime C2(CharSequence charSequence) {
        return E2(charSequence, DateTimeFormatter.p);
    }

    public static ZonedDateTime E2(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.r(charSequence, X2);
    }

    private static ZonedDateTime G0(long j2, int i2, ZoneId zoneId) {
        ZoneOffset b2 = zoneId.u().b(Instant.k0(j2, (long) i2));
        return new ZonedDateTime(LocalDateTime.q2(j2, i2, b2), b2, zoneId);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|(3:7|8|9)|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.ZonedDateTime K0(org.threeten.bp.temporal.TemporalAccessor r4) {
        /*
            boolean r0 = r4 instanceof org.threeten.bp.ZonedDateTime
            if (r0 == 0) goto L_0x0007
            org.threeten.bp.ZonedDateTime r4 = (org.threeten.bp.ZonedDateTime) r4
            return r4
        L_0x0007:
            org.threeten.bp.ZoneId r0 = org.threeten.bp.ZoneId.j(r4)     // Catch:{ DateTimeException -> 0x002b }
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ DateTimeException -> 0x002b }
            boolean r2 = r4.m(r1)     // Catch:{ DateTimeException -> 0x002b }
            if (r2 == 0) goto L_0x0022
            long r1 = r4.p(r1)     // Catch:{ DateTimeException -> 0x0022 }
            org.threeten.bp.temporal.ChronoField r3 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ DateTimeException -> 0x0022 }
            int r3 = r4.b(r3)     // Catch:{ DateTimeException -> 0x0022 }
            org.threeten.bp.ZonedDateTime r4 = G0(r1, r3, r0)     // Catch:{ DateTimeException -> 0x0022 }
            return r4
        L_0x0022:
            org.threeten.bp.LocalDateTime r1 = org.threeten.bp.LocalDateTime.v0(r4)     // Catch:{ DateTimeException -> 0x002b }
            org.threeten.bp.ZonedDateTime r4 = p2(r1, r0)     // Catch:{ DateTimeException -> 0x002b }
            return r4
        L_0x002b:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to obtain ZonedDateTime from TemporalAccessor: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", type "
            r1.append(r2)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.K0(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.ZonedDateTime");
    }

    static ZonedDateTime U2(DataInput dataInput) throws IOException {
        return u2(LocalDateTime.S2(dataInput), ZoneOffset.O(dataInput), (ZoneId) Ser.a(dataInput));
    }

    private Object V2() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime W2(LocalDateTime localDateTime) {
        return r2(localDateTime, this.Y, this.Z);
    }

    private ZonedDateTime X2(LocalDateTime localDateTime) {
        return w2(localDateTime, this.Z, this.Y);
    }

    private ZonedDateTime Y2(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.Y) || !this.Z.u().k(this.X, zoneOffset)) ? this : new ZonedDateTime(this.X, zoneOffset, this.Z);
    }

    public static ZonedDateTime f2() {
        return i2(Clock.g());
    }

    public static ZonedDateTime i2(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return q2(clock.c(), clock.b());
    }

    public static ZonedDateTime j2(ZoneId zoneId) {
        return i2(Clock.f(zoneId));
    }

    public static ZonedDateTime m2(int i2, int i3, int i4, int i5, int i6, int i7, int i8, ZoneId zoneId) {
        return w2(LocalDateTime.i2(i2, i3, i4, i5, i6, i7, i8), zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime n2(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        return p2(LocalDateTime.p2(localDate, localTime), zoneId);
    }

    public static ZonedDateTime p2(LocalDateTime localDateTime, ZoneId zoneId) {
        return w2(localDateTime, zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime q2(Instant instant, ZoneId zoneId) {
        Jdk8Methods.j(instant, "instant");
        Jdk8Methods.j(zoneId, "zone");
        return G0(instant.y(), instant.z(), zoneId);
    }

    public static ZonedDateTime r2(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.j(localDateTime, "localDateTime");
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        Jdk8Methods.j(zoneId, "zone");
        return G0(localDateTime.L(zoneOffset), localDateTime.R0(), zoneId);
    }

    private Object t3() {
        return new Ser((byte) 6, this);
    }

    private static ZonedDateTime u2(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        Jdk8Methods.j(localDateTime, "localDateTime");
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        Jdk8Methods.j(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime w2(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Object j2;
        Jdk8Methods.j(localDateTime, "localDateTime");
        Jdk8Methods.j(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules u = zoneId.u();
        List h2 = u.h(localDateTime);
        if (h2.size() == 1) {
            j2 = h2.get(0);
        } else {
            if (h2.size() == 0) {
                ZoneOffsetTransition e2 = u.e(localDateTime);
                localDateTime = localDateTime.M2(e2.e().o());
                zoneOffset = e2.h();
            } else if (zoneOffset == null || !h2.contains(zoneOffset)) {
                j2 = Jdk8Methods.j(h2.get(0), TypedValues.CycleType.R);
            }
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        zoneOffset = (ZoneOffset) j2;
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public int A1() {
        return this.X.A1();
    }

    public ZonedDateTime D1(long j2) {
        return j2 == Long.MIN_VALUE ? P2(Long.MAX_VALUE).P2(1) : P2(-j2);
    }

    public ZonedDateTime F1(long j2) {
        return j2 == Long.MIN_VALUE ? Q2(Long.MAX_VALUE).Q2(1) : Q2(-j2);
    }

    /* renamed from: G2 */
    public ZonedDateTime q(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.a() ? X2(this.X.q(j2, temporalUnit)) : W2(this.X.q(j2, temporalUnit));
        }
        return (ZonedDateTime) temporalUnit.g(this, j2);
    }

    /* renamed from: I2 */
    public ZonedDateTime h(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.b(this);
    }

    public ZonedDateTime J2(long j2) {
        return X2(this.X.E2(j2));
    }

    public int L0() {
        return this.X.C0();
    }

    public ZonedDateTime L2(long j2) {
        return W2(this.X.G2(j2));
    }

    public int M0() {
        return this.X.M0();
    }

    public ZonedDateTime M2(long j2) {
        return W2(this.X.I2(j2));
    }

    public ZonedDateTime N2(long j2) {
        return X2(this.X.J2(j2));
    }

    public ZonedDateTime P2(long j2) {
        return W2(this.X.L2(j2));
    }

    public ZonedDateTime Q2(long j2) {
        return W2(this.X.M2(j2));
    }

    public DayOfWeek R0() {
        return this.X.D0();
    }

    public int S0() {
        return this.X.G0();
    }

    public int S1() {
        return this.X.S1();
    }

    public ZonedDateTime S2(long j2) {
        return X2(this.X.N2(j2));
    }

    public ZonedDateTime T1(long j2) {
        return j2 == Long.MIN_VALUE ? S2(Long.MAX_VALUE).S2(1) : S2(-j2);
    }

    public ZonedDateTime T2(long j2) {
        return X2(this.X.Q2(j2));
    }

    public Month Y0() {
        return this.X.K0();
    }

    /* renamed from: Z2 */
    public LocalDate U() {
        return this.X.S();
    }

    /* renamed from: a3 */
    public LocalDateTime c0() {
        return this.X;
    }

    public int b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.b(temporalField);
        }
        int i2 = AnonymousClass2.f31786a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? this.X.b(temporalField) : x().F();
        }
        throw new DateTimeException("Field too large for an int: " + temporalField);
    }

    public OffsetDateTime b3() {
        return OffsetDateTime.Y0(this.X, this.Y);
    }

    public int c1() {
        return this.X.L0();
    }

    public ZonedDateTime c3(TemporalUnit temporalUnit) {
        return X2(this.X.V2(temporalUnit));
    }

    public int d1() {
        return this.X.R0();
    }

    /* renamed from: d3 */
    public ZonedDateTime l(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return X2(LocalDateTime.p2((LocalDate) temporalAdjuster, this.X.U()));
        }
        if (temporalAdjuster instanceof LocalTime) {
            return X2(LocalDateTime.p2(this.X.S(), (LocalTime) temporalAdjuster));
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return X2((LocalDateTime) temporalAdjuster);
        }
        if (!(temporalAdjuster instanceof Instant)) {
            return temporalAdjuster instanceof ZoneOffset ? Y2((ZoneOffset) temporalAdjuster) : (ZonedDateTime) temporalAdjuster.e(this);
        }
        Instant instant = (Instant) temporalAdjuster;
        return G0(instant.y(), instant.z(), this.Z);
    }

    /* renamed from: e1 */
    public ZonedDateTime o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public ZonedDateTime e2(long j2) {
        return j2 == Long.MIN_VALUE ? T2(Long.MAX_VALUE).T2(1) : T2(-j2);
    }

    /* renamed from: e3 */
    public ZonedDateTime q0(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i2 = AnonymousClass2.f31786a[chronoField.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? X2(this.X.h0(temporalField, j2)) : Y2(ZoneOffset.L(chronoField.m(j2)));
        }
        return G0(j2, d1(), this.Z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.X.equals(zonedDateTime.X) && this.Y.equals(zonedDateTime.Y) && this.Z.equals(zonedDateTime.Z);
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.h() : this.X.f(temporalField);
        }
        return temporalField.f(this);
    }

    public ZonedDateTime f3(int i2) {
        return X2(this.X.Z2(i2));
    }

    public ZonedDateTime g3(int i2) {
        return X2(this.X.a3(i2));
    }

    public LocalTime h0() {
        return this.X.U();
    }

    /* renamed from: h1 */
    public ZonedDateTime g(TemporalAmount temporalAmount) {
        return (ZonedDateTime) temporalAmount.a(this);
    }

    /* renamed from: h3 */
    public ZonedDateTime r0() {
        ZoneOffsetTransition e2 = y().u().e(this.X);
        if (e2 != null && e2.l()) {
            ZoneOffset i2 = e2.i();
            if (!i2.equals(this.Y)) {
                return new ZonedDateTime(this.X, i2, this.Z);
            }
        }
        return this;
    }

    public int hashCode() {
        return (this.X.hashCode() ^ this.Y.hashCode()) ^ Integer.rotateLeft(this.Z.hashCode(), 3);
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? U() : super.i(temporalQuery);
    }

    public ZonedDateTime i3() {
        if (this.Z.equals(this.Y)) {
            return this;
        }
        LocalDateTime localDateTime = this.X;
        ZoneOffset zoneOffset = this.Y;
        return new ZonedDateTime(localDateTime, zoneOffset, zoneOffset);
    }

    public ZonedDateTime j1(long j2) {
        return j2 == Long.MIN_VALUE ? J2(Long.MAX_VALUE).J2(1) : J2(-j2);
    }

    public ZonedDateTime j3(int i2) {
        return X2(this.X.b3(i2));
    }

    public ZonedDateTime k1(long j2) {
        return j2 == Long.MIN_VALUE ? L2(Long.MAX_VALUE).L2(1) : L2(-j2);
    }

    /* renamed from: k3 */
    public ZonedDateTime v0() {
        ZoneOffsetTransition e2 = y().u().e(c0());
        if (e2 != null) {
            ZoneOffset h2 = e2.h();
            if (!h2.equals(this.Y)) {
                return new ZonedDateTime(this.X, h2, this.Z);
            }
        }
        return this;
    }

    public ZonedDateTime l1(long j2) {
        return j2 == Long.MIN_VALUE ? M2(Long.MAX_VALUE).M2(1) : M2(-j2);
    }

    public ZonedDateTime l3(int i2) {
        return X2(this.X.c3(i2));
    }

    public boolean m(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.c(this));
    }

    public ZonedDateTime m3(int i2) {
        return X2(this.X.d3(i2));
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.a() || temporalUnit.b() : temporalUnit != null && temporalUnit.f(this);
    }

    public ZonedDateTime n3(int i2) {
        return X2(this.X.e3(i2));
    }

    public ZonedDateTime o3(int i2) {
        return X2(this.X.f3(i2));
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i2 = AnonymousClass2.f31786a[((ChronoField) temporalField).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? this.X.p(temporalField) : (long) x().F();
        }
        return Q();
    }

    public ZonedDateTime p3(int i2) {
        return X2(this.X.g3(i2));
    }

    /* renamed from: q3 */
    public ZonedDateTime C0(ZoneId zoneId) {
        Jdk8Methods.j(zoneId, "zone");
        return this.Z.equals(zoneId) ? this : G0(this.X.L(this.Y), this.X.R0(), zoneId);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime K0 = K0(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, K0);
        }
        ZonedDateTime q3 = K0.C0(this.Z);
        return temporalUnit.a() ? this.X.r(q3.X, temporalUnit) : b3().r(q3.b3(), temporalUnit);
    }

    /* renamed from: r3 */
    public ZonedDateTime D0(ZoneId zoneId) {
        Jdk8Methods.j(zoneId, "zone");
        return this.Z.equals(zoneId) ? this : w2(this.X, zoneId, this.Y);
    }

    /* access modifiers changed from: package-private */
    public void s3(DataOutput dataOutput) throws IOException {
        this.X.h3(dataOutput);
        this.Y.S(dataOutput);
        this.Z.A(dataOutput);
    }

    public String toString() {
        String str = this.X.toString() + this.Y.toString();
        if (this.Y == this.Z) {
            return str;
        }
        return str + '[' + this.Z.toString() + ']';
    }

    public String u(DateTimeFormatter dateTimeFormatter) {
        return super.u(dateTimeFormatter);
    }

    public ZonedDateTime w1(long j2) {
        return j2 == Long.MIN_VALUE ? N2(Long.MAX_VALUE).N2(1) : N2(-j2);
    }

    public ZoneOffset x() {
        return this.Y;
    }

    public ZoneId y() {
        return this.Z;
    }

    public int y0() {
        return this.X.y0();
    }
}
