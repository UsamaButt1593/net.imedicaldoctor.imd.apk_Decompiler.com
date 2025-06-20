package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.apache.commons.lang3.time.DateUtils;
import org.threeten.bp.chrono.ChronoLocalDateTime;
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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Temporal, TemporalAdjuster, Serializable {
    public static final LocalDateTime X2 = p2(LocalDate.Y2, LocalTime.Y2);
    public static final TemporalQuery<LocalDateTime> Y2 = new TemporalQuery<LocalDateTime>() {
        /* renamed from: b */
        public LocalDateTime a(TemporalAccessor temporalAccessor) {
            return LocalDateTime.v0(temporalAccessor);
        }
    };
    public static final LocalDateTime Z = p2(LocalDate.X2, LocalTime.X2);
    private static final long Z2 = 6207766400415563566L;
    private final LocalDate X;
    private final LocalTime Y;

    /* renamed from: org.threeten.bp.LocalDateTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31775a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31775a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31775a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.X = localDate;
        this.Y = localTime;
    }

    public static LocalDateTime D1() {
        return F1(Clock.g());
    }

    public static LocalDateTime F1(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        Instant c2 = clock.c();
        return q2(c2.y(), c2.z(), clock.b().u().b(c2));
    }

    private LocalDateTime P2(LocalDate localDate, long j2, long j3, long j4, long j5, int i2) {
        LocalTime v0;
        LocalDate localDate2 = localDate;
        if ((j2 | j3 | j4 | j5) == 0) {
            v0 = this.Y;
        } else {
            long j6 = (long) i2;
            long j7 = (j5 % 86400000000000L) + ((j4 % 86400) * C.f9093k) + ((j3 % 1440) * 60000000000L) + ((j2 % 24) * 3600000000000L);
            long j1 = this.Y.j1();
            long j8 = (j7 * j6) + j1;
            long e2 = (((j5 / 86400000000000L) + (j4 / 86400) + (j3 / 1440) + (j2 / 24)) * j6) + Jdk8Methods.e(j8, 86400000000000L);
            long h2 = Jdk8Methods.h(j8, 86400000000000L);
            v0 = h2 == j1 ? this.Y : LocalTime.v0(h2);
            localDate2 = localDate2.J2(e2);
        }
        return W2(localDate2, v0);
    }

    static LocalDateTime S2(DataInput dataInput) throws IOException {
        return p2(LocalDate.P2(dataInput), LocalTime.e1(dataInput));
    }

    public static LocalDateTime T1(ZoneId zoneId) {
        return F1(Clock.f(zoneId));
    }

    private Object T2() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private LocalDateTime W2(LocalDate localDate, LocalTime localTime) {
        return (this.X == localDate && this.Y == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime e2(int i2, int i3, int i4, int i5, int i6) {
        return new LocalDateTime(LocalDate.r2(i2, i3, i4), LocalTime.k0(i5, i6));
    }

    public static LocalDateTime f2(int i2, int i3, int i4, int i5, int i6, int i7) {
        return new LocalDateTime(LocalDate.r2(i2, i3, i4), LocalTime.q0(i5, i6, i7));
    }

    public static LocalDateTime i2(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new LocalDateTime(LocalDate.r2(i2, i3, i4), LocalTime.r0(i5, i6, i7, i8));
    }

    private Object i3() {
        return new Ser((byte) 4, this);
    }

    public static LocalDateTime j2(int i2, Month month, int i3, int i4, int i5) {
        return new LocalDateTime(LocalDate.u2(i2, month, i3), LocalTime.k0(i4, i5));
    }

    public static LocalDateTime m2(int i2, Month month, int i3, int i4, int i5, int i6) {
        return new LocalDateTime(LocalDate.u2(i2, month, i3), LocalTime.q0(i4, i5, i6));
    }

    public static LocalDateTime n2(int i2, Month month, int i3, int i4, int i5, int i6, int i7) {
        return new LocalDateTime(LocalDate.u2(i2, month, i3), LocalTime.r0(i4, i5, i6, i7));
    }

    public static LocalDateTime p2(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.j(localDate, DublinCoreProperties.f27398d);
        Jdk8Methods.j(localTime, HTML.Tag.P0);
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime q2(long j2, int i2, ZoneOffset zoneOffset) {
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        long F = j2 + ((long) zoneOffset.F());
        return new LocalDateTime(LocalDate.w2(Jdk8Methods.e(F, 86400)), LocalTime.D0((long) Jdk8Methods.g(F, 86400), i2));
    }

    private int r0(LocalDateTime localDateTime) {
        int R0 = this.X.R0(localDateTime.S());
        return R0 == 0 ? this.Y.compareTo(localDateTime.U()) : R0;
    }

    public static LocalDateTime r2(Instant instant, ZoneId zoneId) {
        Jdk8Methods.j(instant, "instant");
        Jdk8Methods.j(zoneId, "zone");
        return q2(instant.y(), instant.z(), zoneId.u().b(instant));
    }

    public static LocalDateTime u2(CharSequence charSequence) {
        return w2(charSequence, DateTimeFormatter.f31804n);
    }

    public static LocalDateTime v0(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).c0();
        }
        try {
            return new LocalDateTime(LocalDate.c1(temporalAccessor), LocalTime.y(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static LocalDateTime w2(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.r(charSequence, Y2);
    }

    public boolean A(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return r0((LocalDateTime) chronoLocalDateTime) == 0;
        }
        return super.A(chronoLocalDateTime);
    }

    public int A1() {
        return this.Y.A1();
    }

    /* renamed from: B2 */
    public LocalDateTime q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.g(this, j2);
        }
        switch (AnonymousClass2.f31775a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return L2(j2);
            case 2:
                return E2(j2 / 86400000000L).L2((j2 % 86400000000L) * 1000);
            case 3:
                return E2(j2 / DateUtils.MILLIS_PER_DAY).L2((j2 % DateUtils.MILLIS_PER_DAY) * 1000000);
            case 4:
                return M2(j2);
            case 5:
                return I2(j2);
            case 6:
                return G2(j2);
            case 7:
                return E2(j2 / 256).G2((j2 % 256) * 12);
            default:
                return W2(this.X.q(j2, temporalUnit), this.Y);
        }
    }

    public int C0() {
        return this.X.h1();
    }

    /* renamed from: C2 */
    public LocalDateTime h(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.b(this);
    }

    public DayOfWeek D0() {
        return this.X.j1();
    }

    public LocalDateTime E2(long j2) {
        return W2(this.X.J2(j2), this.Y);
    }

    public int G0() {
        return this.X.k1();
    }

    public LocalDateTime G2(long j2) {
        return P2(this.X, j2, 0, 0, 0, 1);
    }

    public LocalDateTime I2(long j2) {
        return P2(this.X, 0, j2, 0, 0, 1);
    }

    public LocalDateTime J2(long j2) {
        return W2(this.X.L2(j2), this.Y);
    }

    public Month K0() {
        return this.X.l1();
    }

    public int L0() {
        return this.X.w1();
    }

    public LocalDateTime L2(long j2) {
        return P2(this.X, 0, 0, 0, j2, 1);
    }

    public int M0() {
        return this.X.M0();
    }

    public LocalDateTime M2(long j2) {
        return P2(this.X, 0, 0, j2, 0, 1);
    }

    public LocalDateTime N2(long j2) {
        return W2(this.X.M2(j2), this.Y);
    }

    public LocalDateTime Q2(long j2) {
        return W2(this.X.N2(j2), this.Y);
    }

    public int R0() {
        return this.Y.A();
    }

    /* renamed from: S0 */
    public LocalDateTime o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public int S1() {
        return this.Y.S1();
    }

    public LocalTime U() {
        return this.Y;
    }

    /* renamed from: U2 */
    public LocalDate S() {
        return this.X;
    }

    public LocalDateTime V2(TemporalUnit temporalUnit) {
        return W2(this.X, this.Y.l1(temporalUnit));
    }

    /* renamed from: X2 */
    public LocalDateTime l(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return W2((LocalDate) temporalAdjuster, this.Y);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return W2(this.X, (LocalTime) temporalAdjuster);
        }
        return temporalAdjuster instanceof LocalDateTime ? (LocalDateTime) temporalAdjuster : (LocalDateTime) temporalAdjuster.e(this);
    }

    /* renamed from: Y0 */
    public LocalDateTime g(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.a(this);
    }

    /* renamed from: Y2 */
    public LocalDateTime h0(TemporalField temporalField, long j2) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? W2(this.X, this.Y.a(temporalField, j2)) : W2(this.X.q0(temporalField, j2), this.Y);
        }
        return (LocalDateTime) temporalField.e(this, j2);
    }

    public LocalDateTime Z2(int i2) {
        return W2(this.X.W2(i2), this.Y);
    }

    public LocalDateTime a3(int i2) {
        return W2(this.X.X2(i2), this.Y);
    }

    public int b(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.b(temporalField) : this.X.b(temporalField);
        }
        return super.b(temporalField);
    }

    public LocalDateTime b3(int i2) {
        return W2(this.X, this.Y.F1(i2));
    }

    public LocalDateTime c1(long j2) {
        return j2 == Long.MIN_VALUE ? E2(Long.MAX_VALUE).E2(1) : E2(-j2);
    }

    public LocalDateTime c3(int i2) {
        return W2(this.X, this.Y.T1(i2));
    }

    public LocalDateTime d1(long j2) {
        return P2(this.X, j2, 0, 0, 0, -1);
    }

    public LocalDateTime d3(int i2) {
        return W2(this.X.Y2(i2), this.Y);
    }

    public Temporal e(Temporal temporal) {
        return super.e(temporal);
    }

    public LocalDateTime e1(long j2) {
        return P2(this.X, 0, j2, 0, 0, -1);
    }

    public LocalDateTime e3(int i2) {
        return W2(this.X, this.Y.e2(i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.X.equals(localDateTime.X) && this.Y.equals(localDateTime.Y);
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.f(temporalField) : this.X.f(temporalField);
        }
        return temporalField.f(this);
    }

    public LocalDateTime f3(int i2) {
        return W2(this.X, this.Y.f2(i2));
    }

    public LocalDateTime g3(int i2) {
        return W2(this.X.Z2(i2), this.Y);
    }

    public LocalDateTime h1(long j2) {
        return j2 == Long.MIN_VALUE ? J2(Long.MAX_VALUE).J2(1) : J2(-j2);
    }

    /* access modifiers changed from: package-private */
    public void h3(DataOutput dataOutput) throws IOException {
        this.X.a3(dataOutput);
        this.Y.i2(dataOutput);
    }

    public int hashCode() {
        return this.X.hashCode() ^ this.Y.hashCode();
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        return temporalQuery == TemporalQueries.b() ? S() : super.i(temporalQuery);
    }

    public LocalDateTime j1(long j2) {
        return P2(this.X, 0, 0, 0, j2, -1);
    }

    public OffsetDateTime k0(ZoneOffset zoneOffset) {
        return OffsetDateTime.Y0(this, zoneOffset);
    }

    public LocalDateTime k1(long j2) {
        return P2(this.X, 0, 0, j2, 0, -1);
    }

    public LocalDateTime l1(long j2) {
        return j2 == Long.MIN_VALUE ? N2(Long.MAX_VALUE).N2(1) : N2(-j2);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.a() || temporalField.b() : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.a() || temporalUnit.b() : temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.p(temporalField) : this.X.p(temporalField);
        }
        return temporalField.j(this);
    }

    /* renamed from: q0 */
    public ZonedDateTime s(ZoneId zoneId) {
        return ZonedDateTime.p2(this, zoneId);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDateTime v0 = v0(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, v0);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (chronoUnit.b()) {
            long Y0 = this.X.Y0(v0.X);
            long j1 = v0.Y.j1() - this.Y.j1();
            int i2 = (Y0 > 0 ? 1 : (Y0 == 0 ? 0 : -1));
            if (i2 > 0 && j1 < 0) {
                Y0--;
                j1 += 86400000000000L;
            } else if (i2 < 0 && j1 > 0) {
                Y0++;
                j1 -= 86400000000000L;
            }
            switch (AnonymousClass2.f31775a[chronoUnit.ordinal()]) {
                case 1:
                    return Jdk8Methods.l(Jdk8Methods.o(Y0, 86400000000000L), j1);
                case 2:
                    return Jdk8Methods.l(Jdk8Methods.o(Y0, 86400000000L), j1 / 1000);
                case 3:
                    return Jdk8Methods.l(Jdk8Methods.o(Y0, DateUtils.MILLIS_PER_DAY), j1 / 1000000);
                case 4:
                    return Jdk8Methods.l(Jdk8Methods.n(Y0, 86400), j1 / C.f9093k);
                case 5:
                    return Jdk8Methods.l(Jdk8Methods.n(Y0, 1440), j1 / 60000000000L);
                case 6:
                    return Jdk8Methods.l(Jdk8Methods.n(Y0, 24), j1 / 3600000000000L);
                case 7:
                    return Jdk8Methods.l(Jdk8Methods.n(Y0, 2), j1 / 43200000000000L);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        } else {
            LocalDate localDate = v0.X;
            if (localDate.z(this.X) && v0.Y.E(this.Y)) {
                localDate = localDate.e2(1);
            } else if (localDate.A(this.X) && v0.Y.D(this.Y)) {
                localDate = localDate.J2(1);
            }
            return this.X.r(localDate, temporalUnit);
        }
    }

    public String toString() {
        return this.X.toString() + ASCIIPropertyListParser.C + this.Y.toString();
    }

    /* renamed from: u */
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? r0((LocalDateTime) chronoLocalDateTime) : super.compareTo(chronoLocalDateTime);
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        return super.v(dateTimeFormatter);
    }

    public LocalDateTime w1(long j2) {
        return j2 == Long.MIN_VALUE ? Q2(Long.MAX_VALUE).Q2(1) : Q2(-j2);
    }

    public boolean y(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return r0((LocalDateTime) chronoLocalDateTime) > 0;
        }
        return super.y(chronoLocalDateTime);
    }

    public int y0() {
        return this.Y.y0();
    }

    public boolean z(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return r0((LocalDateTime) chronoLocalDateTime) < 0;
        }
        return super.z(chronoLocalDateTime);
    }
}
