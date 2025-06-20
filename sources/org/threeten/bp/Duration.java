package org.threeten.bp;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final int X2 = 1000000000;
    public static final Duration Y = new Duration(0, 0);
    private static final int Y2 = 1000000;
    private static final long Z = 3078945930695997490L;
    private static final BigInteger Z2 = BigInteger.valueOf(C.f9093k);
    private static final Pattern a3 = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    private final int X;
    private final long s;

    /* renamed from: org.threeten.bp.Duration$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31770a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31770a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31770a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31770a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31770a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.AnonymousClass1.<clinit>():void");
        }
    }

    private Duration(long j2, int i2) {
        this.s = j2;
        this.X = i2;
    }

    public static Duration D(long j2, TemporalUnit temporalUnit) {
        return Y.R(j2, temporalUnit);
    }

    public static Duration E(long j2) {
        return i(Jdk8Methods.n(j2, 86400), 0);
    }

    public static Duration F(long j2) {
        return i(Jdk8Methods.n(j2, 3600), 0);
    }

    public static Duration H(long j2) {
        long j3 = j2 / 1000;
        int i2 = (int) (j2 % 1000);
        if (i2 < 0) {
            i2 += 1000;
            j3--;
        }
        return i(j3, i2 * 1000000);
    }

    public static Duration I(long j2) {
        return i(Jdk8Methods.n(j2, 60), 0);
    }

    public static Duration J(long j2) {
        long j3 = j2 / C.f9093k;
        int i2 = (int) (j2 % C.f9093k);
        if (i2 < 0) {
            i2 += 1000000000;
            j3--;
        }
        return i(j3, i2);
    }

    public static Duration K(long j2) {
        return i(j2, 0);
    }

    public static Duration L(long j2, long j3) {
        return i(Jdk8Methods.l(j2, Jdk8Methods.e(j3, C.f9093k)), Jdk8Methods.g(j3, 1000000000));
    }

    public static Duration N(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        Jdk8Methods.j(charSequence2, "text");
        Matcher matcher = a3.matcher(charSequence2);
        if (matcher.matches() && !ExifInterface.d5.equals(matcher.group(3))) {
            int i2 = 1;
            boolean equals = "-".equals(matcher.group(1));
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            String group3 = matcher.group(5);
            String group4 = matcher.group(6);
            String group5 = matcher.group(7);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                long P = P(charSequence2, group, 86400, "days");
                long P2 = P(charSequence2, group2, 3600, "hours");
                long P3 = P(charSequence2, group3, 60, "minutes");
                long P4 = P(charSequence2, group4, 1, "seconds");
                if (group4 != null && group4.charAt(0) == '-') {
                    i2 = -1;
                }
                try {
                    return k(equals, P, P2, P3, P4, O(charSequence2, group5, i2));
                } catch (ArithmeticException e2) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence2, 0).initCause(e2));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence2, 0);
    }

    private static int O(CharSequence charSequence, String str, int i2) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt((str + "000000000").substring(0, 9)) * i2;
        } catch (NumberFormatException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e2));
        } catch (ArithmeticException e3) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e3));
        }
    }

    private static long P(CharSequence charSequence, String str, int i2, String str2) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return Jdk8Methods.n(Long.parseLong(str), i2);
        } catch (NumberFormatException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e2));
        } catch (ArithmeticException e3) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e3));
        }
    }

    private Duration Q(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return L(Jdk8Methods.l(Jdk8Methods.l(this.s, j2), j3 / C.f9093k), ((long) this.X) + (j3 % C.f9093k));
    }

    static Duration d0(DataInput dataInput) throws IOException {
        return L(dataInput.readLong(), (long) dataInput.readInt());
    }

    private Object e0() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Duration g(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long r = temporal.r(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j2 = 0;
        if (temporal.m(chronoField) && temporal2.m(chronoField)) {
            try {
                long p = temporal.p(chronoField);
                long p2 = temporal2.p(chronoField) - p;
                int i2 = (r > 0 ? 1 : (r == 0 ? 0 : -1));
                if (i2 > 0 && p2 < 0) {
                    p2 += C.f9093k;
                } else if (i2 < 0 && p2 > 0) {
                    p2 -= C.f9093k;
                } else if (i2 == 0 && p2 != 0) {
                    try {
                        r = temporal.r(temporal2.a(chronoField, p), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j2 = p2;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return L(r, j2);
    }

    private static Duration i(long j2, int i2) {
        return (((long) i2) | j2) == 0 ? Y : new Duration(j2, i2);
    }

    private static Duration j(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] divideAndRemainder = bigIntegerExact.divideAndRemainder(Z2);
        if (divideAndRemainder[0].bitLength() <= 63) {
            return L(divideAndRemainder[0].longValue(), (long) divideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    private static Duration k(boolean z, long j2, long j3, long j4, long j5, int i2) {
        long l2 = Jdk8Methods.l(j2, Jdk8Methods.l(j3, Jdk8Methods.l(j4, j5)));
        long j6 = (long) i2;
        return z ? L(l2, j6).C() : L(l2, j6);
    }

    public static Duration m(TemporalAmount temporalAmount) {
        Jdk8Methods.j(temporalAmount, "amount");
        Duration duration = Y;
        for (TemporalUnit next : temporalAmount.c()) {
            duration = duration.R(temporalAmount.e(next), next);
        }
        return duration;
    }

    private BigDecimal p0() {
        return BigDecimal.valueOf(this.s).add(BigDecimal.valueOf((long) this.X, 9));
    }

    private Object x0() {
        return new Ser((byte) 1, this);
    }

    public Duration A(long j2) {
        if (j2 == 0) {
            return Y;
        }
        return j2 == 1 ? this : j(p0().multiply(BigDecimal.valueOf(j2)));
    }

    public Duration C() {
        return A(-1);
    }

    public Duration R(long j2, TemporalUnit temporalUnit) {
        Jdk8Methods.j(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return Q(Jdk8Methods.n(j2, 86400), 0);
        }
        if (temporalUnit.c()) {
            throw new DateTimeException("Unit must not have an estimated duration");
        } else if (j2 == 0) {
            return this;
        } else {
            if (temporalUnit instanceof ChronoUnit) {
                int i2 = AnonymousClass1.f31770a[((ChronoUnit) temporalUnit).ordinal()];
                if (i2 == 1) {
                    return a0(j2);
                }
                if (i2 == 2) {
                    return c0((j2 / C.f9093k) * 1000).a0((j2 % C.f9093k) * 1000);
                }
                if (i2 != 3) {
                    return i2 != 4 ? c0(Jdk8Methods.o(temporalUnit.Q().s, j2)) : c0(j2);
                }
                return W(j2);
            }
            Duration A = temporalUnit.Q().A(j2);
            return c0(A.o()).a0((long) A.n());
        }
    }

    public Duration S(Duration duration) {
        return Q(duration.o(), (long) duration.n());
    }

    public Duration T(long j2) {
        return Q(Jdk8Methods.n(j2, 86400), 0);
    }

    public Duration U(long j2) {
        return Q(Jdk8Methods.n(j2, 3600), 0);
    }

    public Duration W(long j2) {
        return Q(j2 / 1000, (j2 % 1000) * 1000000);
    }

    public Duration Z(long j2) {
        return Q(Jdk8Methods.n(j2, 60), 0);
    }

    public Temporal a(Temporal temporal) {
        long j2 = this.s;
        if (j2 != 0) {
            temporal = temporal.o(j2, ChronoUnit.SECONDS);
        }
        int i2 = this.X;
        return i2 != 0 ? temporal.o((long) i2, ChronoUnit.NANOS) : temporal;
    }

    public Duration a0(long j2) {
        return Q(0, j2);
    }

    public Temporal b(Temporal temporal) {
        long j2 = this.s;
        if (j2 != 0) {
            temporal = temporal.q(j2, ChronoUnit.SECONDS);
        }
        int i2 = this.X;
        return i2 != 0 ? temporal.q((long) i2, ChronoUnit.NANOS) : temporal;
    }

    public List<TemporalUnit> c() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    public Duration c0(long j2) {
        return Q(j2, 0);
    }

    public long e(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.SECONDS) {
            return this.s;
        }
        if (temporalUnit == ChronoUnit.NANOS) {
            return (long) this.X;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.s == duration.s && this.X == duration.X;
    }

    public Duration f() {
        return p() ? C() : this;
    }

    /* renamed from: h */
    public int compareTo(Duration duration) {
        int b2 = Jdk8Methods.b(this.s, duration.s);
        return b2 != 0 ? b2 : this.X - duration.X;
    }

    public long h0() {
        return this.s / 86400;
    }

    public int hashCode() {
        long j2 = this.s;
        return ((int) (j2 ^ (j2 >>> 32))) + (this.X * 51);
    }

    public long i0() {
        return this.s / 3600;
    }

    public long j0() {
        return Jdk8Methods.l(Jdk8Methods.n(this.s, 1000), (long) (this.X / 1000000));
    }

    public long k0() {
        return this.s / 60;
    }

    public Duration l(long j2) {
        if (j2 != 0) {
            return j2 == 1 ? this : j(p0().divide(BigDecimal.valueOf(j2), RoundingMode.DOWN));
        }
        throw new ArithmeticException("Cannot divide by zero");
    }

    public long m0() {
        return Jdk8Methods.l(Jdk8Methods.n(this.s, 1000000000), (long) this.X);
    }

    public int n() {
        return this.X;
    }

    public long o() {
        return this.s;
    }

    public boolean p() {
        return this.s < 0;
    }

    public boolean q() {
        return (this.s | ((long) this.X)) == 0;
    }

    public Duration q0(int i2) {
        ChronoField.NANO_OF_SECOND.m((long) i2);
        return i(this.s, i2);
    }

    public Duration r(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? R(Long.MAX_VALUE, temporalUnit).R(1, temporalUnit) : R(-j2, temporalUnit);
    }

    public Duration r0(long j2) {
        return i(j2, this.X);
    }

    public Duration s(Duration duration) {
        long o = duration.o();
        int n2 = duration.n();
        return o == Long.MIN_VALUE ? Q(Long.MAX_VALUE, (long) (-n2)).Q(1, 0) : Q(-o, (long) (-n2));
    }

    public String toString() {
        if (this == Y) {
            return "PT0S";
        }
        long j2 = this.s;
        long j3 = j2 / 3600;
        int i2 = (int) ((j2 % 3600) / 60);
        int i3 = (int) (j2 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j3 != 0) {
            sb.append(j3);
            sb.append('H');
        }
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        if (i3 == 0 && this.X == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i3 >= 0 || this.X <= 0) {
            sb.append(i3);
        } else if (i3 == -1) {
            sb.append("-0");
        } else {
            sb.append(i3 + 1);
        }
        if (this.X > 0) {
            int length = sb.length();
            sb.append(i3 < 0 ? 2000000000 - this.X : this.X + 1000000000);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        sb.append('S');
        return sb.toString();
    }

    public Duration u(long j2) {
        return j2 == Long.MIN_VALUE ? T(Long.MAX_VALUE).T(1) : T(-j2);
    }

    public Duration v(long j2) {
        return j2 == Long.MIN_VALUE ? U(Long.MAX_VALUE).U(1) : U(-j2);
    }

    /* access modifiers changed from: package-private */
    public void v0(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.s);
        dataOutput.writeInt(this.X);
    }

    public Duration w(long j2) {
        return j2 == Long.MIN_VALUE ? W(Long.MAX_VALUE).W(1) : W(-j2);
    }

    public Duration x(long j2) {
        return j2 == Long.MIN_VALUE ? Z(Long.MAX_VALUE).Z(1) : Z(-j2);
    }

    public Duration y(long j2) {
        return j2 == Long.MIN_VALUE ? a0(Long.MAX_VALUE).a0(1) : a0(-j2);
    }

    public Duration z(long j2) {
        return j2 == Long.MIN_VALUE ? c0(Long.MAX_VALUE).c0(1) : c0(-j2);
    }
}
