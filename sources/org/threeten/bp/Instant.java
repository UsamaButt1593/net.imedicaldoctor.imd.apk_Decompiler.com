package org.threeten.bp;

import androidx.media3.common.C;
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

public final class Instant extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    private static final long X2 = 31556889864403199L;
    public static final Instant Y = new Instant(0, 0);
    public static final Instant Y2 = k0(Z, 0);
    private static final long Z = -31557014167219200L;
    public static final Instant Z2 = k0(X2, 999999999);
    public static final TemporalQuery<Instant> a3 = new TemporalQuery<Instant>() {
        /* renamed from: b */
        public Instant a(TemporalAccessor temporalAccessor) {
            return Instant.x(temporalAccessor);
        }
    };
    private static final long b3 = -665713676816604388L;
    private static final int c3 = 1000000000;
    private static final int d3 = 1000000;
    private static final long e3 = 1000;
    private final int X;
    private final long s;

    /* renamed from: org.threeten.bp.Instant$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31771a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31772b;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31772b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f31772b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f31772b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f31772b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = f31772b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = f31772b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = f31772b     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = f31772b     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                org.threeten.bp.temporal.ChronoField[] r4 = org.threeten.bp.temporal.ChronoField.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f31771a = r4
                org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = f31771a     // Catch:{ NoSuchFieldError -> 0x007b }
                org.threeten.bp.temporal.ChronoField r4 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x007b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f31771a     // Catch:{ NoSuchFieldError -> 0x0085 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = f31771a     // Catch:{ NoSuchFieldError -> 0x008f }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Instant.AnonymousClass2.<clinit>():void");
        }
    }

    private Instant(long j2, int i2) {
        this.s = j2;
        this.X = i2;
    }

    static Instant L0(DataInput dataInput) throws IOException {
        return k0(dataInput.readLong(), (long) dataInput.readInt());
    }

    private long Q(Instant instant) {
        return Jdk8Methods.l(Jdk8Methods.n(Jdk8Methods.q(instant.s, this.s), 1000000000), (long) (instant.X - this.X));
    }

    private Object R0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Instant S() {
        return Clock.h().c();
    }

    private long S0(Instant instant) {
        long q = Jdk8Methods.q(instant.s, this.s);
        long j2 = (long) (instant.X - this.X);
        int i2 = (q > 0 ? 1 : (q == 0 ? 0 : -1));
        if (i2 <= 0 || j2 >= 0) {
            return (i2 >= 0 || j2 <= 0) ? q : q + 1;
        }
        return q - 1;
    }

    public static Instant U(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        return clock.c();
    }

    public static Instant c0(long j2) {
        return w(Jdk8Methods.e(j2, 1000), Jdk8Methods.g(j2, 1000) * 1000000);
    }

    public static Instant h0(long j2) {
        return w(j2, 0);
    }

    private Object j1() {
        return new Ser((byte) 2, this);
    }

    public static Instant k0(long j2, long j3) {
        return w(Jdk8Methods.l(j2, Jdk8Methods.e(j3, C.f9093k)), Jdk8Methods.g(j3, 1000000000));
    }

    public static Instant q0(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.t.r(charSequence, a3);
    }

    private Instant r0(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return k0(Jdk8Methods.l(Jdk8Methods.l(this.s, j2), j3 / C.f9093k), ((long) this.X) + (j3 % C.f9093k));
    }

    private static Instant w(long j2, int i2) {
        if ((((long) i2) | j2) == 0) {
            return Y;
        }
        if (j2 >= Z && j2 <= X2) {
            return new Instant(j2, i2);
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    public static Instant x(TemporalAccessor temporalAccessor) {
        try {
            return k0(temporalAccessor.p(ChronoField.INSTANT_SECONDS), (long) temporalAccessor.b(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    public boolean A(Instant instant) {
        return compareTo(instant) > 0;
    }

    /* renamed from: C0 */
    public Instant h(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.b(this);
    }

    public boolean D(Instant instant) {
        return compareTo(instant) < 0;
    }

    public Instant D0(long j2) {
        return r0(j2 / 1000, (j2 % 1000) * 1000000);
    }

    /* renamed from: E */
    public Instant o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    /* renamed from: F */
    public Instant g(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.a(this);
    }

    public Instant G0(long j2) {
        return r0(0, j2);
    }

    public Instant J(long j2) {
        return j2 == Long.MIN_VALUE ? D0(Long.MAX_VALUE).D0(1) : D0(-j2);
    }

    public Instant K(long j2) {
        return j2 == Long.MIN_VALUE ? G0(Long.MAX_VALUE).G0(1) : G0(-j2);
    }

    public Instant K0(long j2) {
        return r0(j2, 0);
    }

    public Instant L(long j2) {
        return j2 == Long.MIN_VALUE ? K0(Long.MAX_VALUE).K0(1) : K0(-j2);
    }

    public long Y0() {
        long j2 = this.s;
        return j2 >= 0 ? Jdk8Methods.l(Jdk8Methods.o(j2, 1000), (long) (this.X / 1000000)) : Jdk8Methods.q(Jdk8Methods.o(j2 + 1, 1000), 1000 - ((long) (this.X / 1000000)));
    }

    public int b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return f(temporalField).a(temporalField.j(this), temporalField);
        }
        int i2 = AnonymousClass2.f31771a[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            return this.X;
        }
        if (i2 == 2) {
            return this.X / 1000;
        }
        if (i2 == 3) {
            return this.X / 1000000;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public Instant c1(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration Q = temporalUnit.Q();
        if (Q.o() <= 86400) {
            long m0 = Q.m0();
            if (86400000000000L % m0 == 0) {
                long j2 = ((this.s % 86400) * C.f9093k) + ((long) this.X);
                return G0((Jdk8Methods.e(j2, m0) * m0) - j2);
            }
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    /* renamed from: d1 */
    public Instant l(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.e(this);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.INSTANT_SECONDS, this.s).a(ChronoField.NANO_OF_SECOND, (long) this.X);
    }

    /* renamed from: e1 */
    public Instant a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        int i2 = AnonymousClass2.f31771a[chronoField.ordinal()];
        if (i2 == 1) {
            return j2 != ((long) this.X) ? w(this.s, (int) j2) : this;
        }
        if (i2 == 2) {
            int i3 = ((int) j2) * 1000;
            return i3 != this.X ? w(this.s, i3) : this;
        } else if (i2 == 3) {
            int i4 = ((int) j2) * 1000000;
            return i4 != this.X ? w(this.s, i4) : this;
        } else if (i2 == 4) {
            return j2 != this.s ? w(j2, this.X) : this;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.s == instant.s && this.X == instant.X;
    }

    public ValueRange f(TemporalField temporalField) {
        return super.f(temporalField);
    }

    /* access modifiers changed from: package-private */
    public void h1(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.s);
        dataOutput.writeInt(this.X);
    }

    public int hashCode() {
        long j2 = this.s;
        return ((int) (j2 ^ (j2 >>> 32))) + (this.X * 51);
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.b() || temporalUnit == ChronoUnit.DAYS : temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        int i2;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        int i3 = AnonymousClass2.f31771a[((ChronoField) temporalField).ordinal()];
        if (i3 == 1) {
            i2 = this.X;
        } else if (i3 == 2) {
            i2 = this.X / 1000;
        } else if (i3 == 3) {
            i2 = this.X / 1000000;
        } else if (i3 == 4) {
            return this.s;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (long) i2;
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        Instant x = x(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, x);
        }
        switch (AnonymousClass2.f31772b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return Q(x);
            case 2:
                return Q(x) / 1000;
            case 3:
                return Jdk8Methods.q(x.Y0(), Y0());
            case 4:
                return S0(x);
            case 5:
                return S0(x) / 60;
            case 6:
                return S0(x) / 3600;
            case 7:
                return S0(x) / 43200;
            case 8:
                return S0(x) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public OffsetDateTime s(ZoneOffset zoneOffset) {
        return OffsetDateTime.c1(this, zoneOffset);
    }

    public String toString() {
        return DateTimeFormatter.t.d(this);
    }

    public ZonedDateTime u(ZoneId zoneId) {
        return ZonedDateTime.q2(this, zoneId);
    }

    /* renamed from: v */
    public int compareTo(Instant instant) {
        int b2 = Jdk8Methods.b(this.s, instant.s);
        return b2 != 0 ? b2 : this.X - instant.X;
    }

    /* renamed from: v0 */
    public Instant q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.g(this, j2);
        }
        switch (AnonymousClass2.f31772b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return G0(j2);
            case 2:
                return r0(j2 / 1000000, (j2 % 1000000) * 1000);
            case 3:
                return D0(j2);
            case 4:
                return K0(j2);
            case 5:
                return K0(Jdk8Methods.n(j2, 60));
            case 6:
                return K0(Jdk8Methods.n(j2, 3600));
            case 7:
                return K0(Jdk8Methods.n(j2, 43200));
            case 8:
                return K0(Jdk8Methods.n(j2, 86400));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public long y() {
        return this.s;
    }

    public int z() {
        return this.X;
    }
}
