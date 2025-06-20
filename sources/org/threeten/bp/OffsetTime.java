package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.itextpdf.tool.xml.html.HTML;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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

public final class OffsetTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<OffsetTime>, Serializable {
    public static final TemporalQuery<OffsetTime> X2 = new TemporalQuery<OffsetTime>() {
        /* renamed from: b */
        public OffsetTime a(TemporalAccessor temporalAccessor) {
            return OffsetTime.w(temporalAccessor);
        }
    };
    public static final OffsetTime Y = LocalTime.X2.u(ZoneOffset.i3);
    private static final long Y2 = 7264499704384272492L;
    public static final OffsetTime Z = LocalTime.Y2.u(ZoneOffset.h3);
    private final ZoneOffset X;
    private final LocalTime s;

    /* renamed from: org.threeten.bp.OffsetTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31781a;

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
                f31781a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31781a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.OffsetTime.AnonymousClass2.<clinit>():void");
        }
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        this.s = (LocalTime) Jdk8Methods.j(localTime, HTML.Tag.P0);
        this.X = (ZoneOffset) Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
    }

    public static OffsetTime S() {
        return U(Clock.g());
    }

    static OffsetTime S0(DataInput dataInput) throws IOException {
        return k0(LocalTime.e1(dataInput), ZoneOffset.O(dataInput));
    }

    public static OffsetTime U(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        Instant c2 = clock.c();
        return q0(c2, clock.b().u().b(c2));
    }

    private Object Y0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static OffsetTime c0(ZoneId zoneId) {
        return U(Clock.f(zoneId));
    }

    private long c1() {
        return this.s.j1() - (((long) this.X.F()) * C.f9093k);
    }

    public static OffsetTime h0(int i2, int i3, int i4, int i5, ZoneOffset zoneOffset) {
        return new OffsetTime(LocalTime.r0(i2, i3, i4, i5), zoneOffset);
    }

    private OffsetTime h1(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.s != localTime || !this.X.equals(zoneOffset)) ? new OffsetTime(localTime, zoneOffset) : this;
    }

    private Object i2() {
        return new Ser((byte) 66, this);
    }

    public static OffsetTime k0(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    public static OffsetTime q0(Instant instant, ZoneId zoneId) {
        Jdk8Methods.j(instant, "instant");
        Jdk8Methods.j(zoneId, "zone");
        ZoneOffset b2 = zoneId.u().b(instant);
        long y = ((instant.y() % 86400) + ((long) b2.F())) % 86400;
        if (y < 0) {
            y += 86400;
        }
        return new OffsetTime(LocalTime.D0(y, instant.z()), b2);
    }

    public static OffsetTime r0(CharSequence charSequence) {
        return v0(charSequence, DateTimeFormatter.f31802l);
    }

    public static OffsetTime v0(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (OffsetTime) dateTimeFormatter.r(charSequence, X2);
    }

    public static OffsetTime w(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof OffsetTime) {
            return (OffsetTime) temporalAccessor;
        }
        try {
            return new OffsetTime(LocalTime.y(temporalAccessor), ZoneOffset.E(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public boolean A(OffsetTime offsetTime) {
        return c1() < offsetTime.c1();
    }

    public int A1() {
        return this.s.A1();
    }

    /* renamed from: C0 */
    public OffsetTime q(long j2, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? h1(this.s.q(j2, temporalUnit), this.X) : (OffsetTime) temporalUnit.g(this, j2);
    }

    public boolean D(OffsetTime offsetTime) {
        return c1() == offsetTime.c1();
    }

    /* renamed from: D0 */
    public OffsetTime h(TemporalAmount temporalAmount) {
        return (OffsetTime) temporalAmount.b(this);
    }

    public OffsetTime D1(int i2) {
        return h1(this.s.e2(i2), this.X);
    }

    /* renamed from: E */
    public OffsetTime o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    /* renamed from: F */
    public OffsetTime g(TemporalAmount temporalAmount) {
        return (OffsetTime) temporalAmount.a(this);
    }

    public OffsetTime F1(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.X)) {
            return this;
        }
        return new OffsetTime(this.s.d1((long) (zoneOffset.F() - this.X.F())), zoneOffset);
    }

    public OffsetTime G0(long j2) {
        return h1(this.s.S0(j2), this.X);
    }

    public OffsetTime J(long j2) {
        return h1(this.s.K(j2), this.X);
    }

    public OffsetTime K(long j2) {
        return h1(this.s.L(j2), this.X);
    }

    public OffsetTime K0(long j2) {
        return h1(this.s.Y0(j2), this.X);
    }

    public OffsetTime L(long j2) {
        return h1(this.s.Q(j2), this.X);
    }

    public OffsetTime L0(long j2) {
        return h1(this.s.c1(j2), this.X);
    }

    public OffsetTime Q(long j2) {
        return h1(this.s.S(j2), this.X);
    }

    public OffsetTime R0(long j2) {
        return h1(this.s.d1(j2), this.X);
    }

    public int S1() {
        return this.s.S1();
    }

    public OffsetTime T1(ZoneOffset zoneOffset) {
        return (zoneOffset == null || !zoneOffset.equals(this.X)) ? new OffsetTime(this.s, zoneOffset) : this;
    }

    public int b(TemporalField temporalField) {
        return super.b(temporalField);
    }

    public LocalTime d1() {
        return this.s;
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.NANO_OF_DAY, this.s.j1()).a(ChronoField.OFFSET_SECONDS, (long) y().F());
    }

    public OffsetTime e1(TemporalUnit temporalUnit) {
        return h1(this.s.l1(temporalUnit), this.X);
    }

    public OffsetTime e2(int i2) {
        return h1(this.s.f2(i2), this.X);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetTime)) {
            return false;
        }
        OffsetTime offsetTime = (OffsetTime) obj;
        return this.s.equals(offsetTime.s) && this.X.equals(offsetTime.X);
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField == ChronoField.OFFSET_SECONDS ? temporalField.h() : this.s.f(temporalField);
        }
        return temporalField.f(this);
    }

    /* access modifiers changed from: package-private */
    public void f2(DataOutput dataOutput) throws IOException {
        this.s.i2(dataOutput);
        this.X.S(dataOutput);
    }

    public int hashCode() {
        return this.s.hashCode() ^ this.X.hashCode();
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return y();
        }
        if (temporalQuery == TemporalQueries.c()) {
            return this.s;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return super.i(temporalQuery);
    }

    /* renamed from: j1 */
    public OffsetTime l(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return h1((LocalTime) temporalAdjuster, this.X);
        }
        if (temporalAdjuster instanceof ZoneOffset) {
            return h1(this.s, (ZoneOffset) temporalAdjuster);
        }
        return temporalAdjuster instanceof OffsetTime ? (OffsetTime) temporalAdjuster : (OffsetTime) temporalAdjuster.e(this);
    }

    /* renamed from: k1 */
    public OffsetTime a(TemporalField temporalField, long j2) {
        if (temporalField instanceof ChronoField) {
            return temporalField == ChronoField.OFFSET_SECONDS ? h1(this.s, ZoneOffset.L(((ChronoField) temporalField).m(j2))) : h1(this.s.a(temporalField, j2), this.X);
        }
        return (OffsetTime) temporalField.e(this, j2);
    }

    public OffsetTime l1(int i2) {
        return h1(this.s.F1(i2), this.X);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.b() || temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.b();
        }
        return temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField == ChronoField.OFFSET_SECONDS ? (long) y().F() : this.s.p(temporalField);
        }
        return temporalField.j(this);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        long j2;
        OffsetTime w = w(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, w);
        }
        long c1 = w.c1() - c1();
        switch (AnonymousClass2.f31781a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return c1;
            case 2:
                j2 = 1000;
                break;
            case 3:
                j2 = 1000000;
                break;
            case 4:
                j2 = C.f9093k;
                break;
            case 5:
                j2 = 60000000000L;
                break;
            case 6:
                j2 = 3600000000000L;
                break;
            case 7:
                j2 = 43200000000000L;
                break;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return c1 / j2;
    }

    public OffsetDateTime s(LocalDate localDate) {
        return OffsetDateTime.S0(localDate, this.s, this.X);
    }

    public String toString() {
        return this.s.toString() + this.X.toString();
    }

    /* renamed from: u */
    public int compareTo(OffsetTime offsetTime) {
        if (this.X.equals(offsetTime.X)) {
            return this.s.compareTo(offsetTime.s);
        }
        int b2 = Jdk8Methods.b(c1(), offsetTime.c1());
        return b2 == 0 ? this.s.compareTo(offsetTime.s) : b2;
    }

    public String v(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public OffsetTime w1(int i2) {
        return h1(this.s.T1(i2), this.X);
    }

    public int x() {
        return this.s.A();
    }

    public ZoneOffset y() {
        return this.X;
    }

    public int y0() {
        return this.s.y0();
    }

    public boolean z(OffsetTime offsetTime) {
        return c1() > offsetTime.c1();
    }
}
