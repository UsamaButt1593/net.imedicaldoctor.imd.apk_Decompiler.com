package org.threeten.bp;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Period extends ChronoPeriod implements Serializable {
    private static final long X2 = -8290556941213247973L;
    private static final Pattern Y2 = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    public static final Period Z = new Period(0, 0, 0);
    private final int X;
    private final int Y;
    private final int s;

    private Period(int i2, int i3, int i4) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
    }

    public static Period A(int i2, int i3, int i4) {
        return o(i2, i3, i4);
    }

    public static Period B(int i2) {
        return o(0, 0, i2);
    }

    public static Period C(int i2) {
        return o(0, i2, 0);
    }

    public static Period D(int i2) {
        return o(0, 0, Jdk8Methods.m(i2, 7));
    }

    public static Period E(int i2) {
        return o(i2, 0, 0);
    }

    public static Period F(CharSequence charSequence) {
        Jdk8Methods.j(charSequence, "text");
        Matcher matcher = Y2.matcher(charSequence);
        if (matcher.matches()) {
            int i2 = 1;
            if ("-".equals(matcher.group(1))) {
                i2 = -1;
            }
            String group = matcher.group(2);
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            String group4 = matcher.group(5);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                try {
                    return o(H(charSequence, group, i2), H(charSequence, group2, i2), Jdk8Methods.k(H(charSequence, group4, i2), Jdk8Methods.m(H(charSequence, group3, i2), 7)));
                } catch (NumberFormatException e2) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e2));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int H(CharSequence charSequence, String str, int i2) {
        if (str == null) {
            return 0;
        }
        try {
            return Jdk8Methods.m(Integer.parseInt(str), i2);
        } catch (ArithmeticException e2) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e2));
        }
    }

    private Object M() {
        return ((this.s | this.X) | this.Y) == 0 ? Z : this;
    }

    public static Period n(LocalDate localDate, LocalDate localDate2) {
        return localDate.h0(localDate2);
    }

    private static Period o(int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? Z : new Period(i2, i3, i4);
    }

    public static Period p(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return (Period) temporalAmount;
        }
        if (!(temporalAmount instanceof ChronoPeriod) || IsoChronology.X2.equals(((ChronoPeriod) temporalAmount).f())) {
            Jdk8Methods.j(temporalAmount, "amount");
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (TemporalUnit next : temporalAmount.c()) {
                long e2 = temporalAmount.e(next);
                if (next == ChronoUnit.YEARS) {
                    i2 = Jdk8Methods.r(e2);
                } else if (next == ChronoUnit.MONTHS) {
                    i3 = Jdk8Methods.r(e2);
                } else if (next == ChronoUnit.DAYS) {
                    i4 = Jdk8Methods.r(e2);
                } else {
                    throw new DateTimeException("Unit must be Years, Months or Days, but was " + next);
                }
            }
            return o(i2, i3, i4);
        }
        throw new DateTimeException("Period requires ISO chronology: " + temporalAmount);
    }

    /* renamed from: I */
    public Period m(TemporalAmount temporalAmount) {
        Period p = p(temporalAmount);
        return o(Jdk8Methods.k(this.s, p.s), Jdk8Methods.k(this.X, p.X), Jdk8Methods.k(this.Y, p.Y));
    }

    public Period J(long j2) {
        return j2 == 0 ? this : o(this.s, this.X, Jdk8Methods.r(Jdk8Methods.l((long) this.Y, j2)));
    }

    public Period K(long j2) {
        return j2 == 0 ? this : o(this.s, Jdk8Methods.r(Jdk8Methods.l((long) this.X, j2)), this.Y);
    }

    public Period L(long j2) {
        return j2 == 0 ? this : o(Jdk8Methods.r(Jdk8Methods.l((long) this.s, j2)), this.X, this.Y);
    }

    public long N() {
        return (((long) this.s) * 12) + ((long) this.X);
    }

    public Period O(int i2) {
        return i2 == this.Y ? this : o(this.s, this.X, i2);
    }

    public Period P(int i2) {
        return i2 == this.X ? this : o(this.s, i2, this.Y);
    }

    public Period Q(int i2) {
        return i2 == this.s ? this : o(i2, this.X, this.Y);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.temporal.Temporal a(org.threeten.bp.temporal.Temporal r4) {
        /*
            r3 = this;
            java.lang.String r0 = "temporal"
            org.threeten.bp.jdk8.Jdk8Methods.j(r4, r0)
            int r0 = r3.s
            if (r0 == 0) goto L_0x001c
            int r1 = r3.X
            if (r1 == 0) goto L_0x0018
            long r0 = r3.N()
        L_0x0011:
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.MONTHS
        L_0x0013:
            org.threeten.bp.temporal.Temporal r4 = r4.o(r0, r2)
            goto L_0x0022
        L_0x0018:
            long r0 = (long) r0
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.YEARS
            goto L_0x0013
        L_0x001c:
            int r0 = r3.X
            if (r0 == 0) goto L_0x0022
            long r0 = (long) r0
            goto L_0x0011
        L_0x0022:
            int r0 = r3.Y
            if (r0 == 0) goto L_0x002d
            long r0 = (long) r0
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.temporal.Temporal r4 = r4.o(r0, r2)
        L_0x002d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Period.a(org.threeten.bp.temporal.Temporal):org.threeten.bp.temporal.Temporal");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.temporal.Temporal b(org.threeten.bp.temporal.Temporal r4) {
        /*
            r3 = this;
            java.lang.String r0 = "temporal"
            org.threeten.bp.jdk8.Jdk8Methods.j(r4, r0)
            int r0 = r3.s
            if (r0 == 0) goto L_0x001c
            int r1 = r3.X
            if (r1 == 0) goto L_0x0018
            long r0 = r3.N()
        L_0x0011:
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.MONTHS
        L_0x0013:
            org.threeten.bp.temporal.Temporal r4 = r4.q(r0, r2)
            goto L_0x0022
        L_0x0018:
            long r0 = (long) r0
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.YEARS
            goto L_0x0013
        L_0x001c:
            int r0 = r3.X
            if (r0 == 0) goto L_0x0022
            long r0 = (long) r0
            goto L_0x0011
        L_0x0022:
            int r0 = r3.Y
            if (r0 == 0) goto L_0x002d
            long r0 = (long) r0
            org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.temporal.Temporal r4 = r4.q(r0, r2)
        L_0x002d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Period.b(org.threeten.bp.temporal.Temporal):org.threeten.bp.temporal.Temporal");
    }

    public List<TemporalUnit> c() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public long e(TemporalUnit temporalUnit) {
        int i2;
        if (temporalUnit == ChronoUnit.YEARS) {
            i2 = this.s;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i2 = this.X;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i2 = this.Y;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (long) i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.s == period.s && this.X == period.X && this.Y == period.Y;
    }

    public Chronology f() {
        return IsoChronology.X2;
    }

    public boolean g() {
        return this.s < 0 || this.X < 0 || this.Y < 0;
    }

    public boolean h() {
        return this == Z;
    }

    public int hashCode() {
        return this.s + Integer.rotateLeft(this.X, 8) + Integer.rotateLeft(this.Y, 16);
    }

    public int q() {
        return this.Y;
    }

    public int r() {
        return this.X;
    }

    public int s() {
        return this.s;
    }

    /* renamed from: t */
    public Period i(TemporalAmount temporalAmount) {
        Period p = p(temporalAmount);
        return o(Jdk8Methods.p(this.s, p.s), Jdk8Methods.p(this.X, p.X), Jdk8Methods.p(this.Y, p.Y));
    }

    public String toString() {
        if (this == Z) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i2 = this.s;
        if (i2 != 0) {
            sb.append(i2);
            sb.append(ASCIIPropertyListParser.v);
        }
        int i3 = this.X;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('M');
        }
        int i4 = this.Y;
        if (i4 != 0) {
            sb.append(i4);
            sb.append(ASCIIPropertyListParser.t);
        }
        return sb.toString();
    }

    public Period u(long j2) {
        return j2 == Long.MIN_VALUE ? J(Long.MAX_VALUE).J(1) : J(-j2);
    }

    public Period v(long j2) {
        return j2 == Long.MIN_VALUE ? K(Long.MAX_VALUE).K(1) : K(-j2);
    }

    public Period w(long j2) {
        return j2 == Long.MIN_VALUE ? L(Long.MAX_VALUE).L(1) : L(-j2);
    }

    /* renamed from: x */
    public Period j(int i2) {
        return (this == Z || i2 == 1) ? this : o(Jdk8Methods.m(this.s, i2), Jdk8Methods.m(this.X, i2), Jdk8Methods.m(this.Y, i2));
    }

    /* renamed from: y */
    public Period k() {
        return j(-1);
    }

    /* renamed from: z */
    public Period l() {
        long N = N();
        long j2 = N / 12;
        int i2 = (int) (N % 12);
        return (j2 == ((long) this.s) && i2 == this.X) ? this : o(Jdk8Methods.r(j2), i2, this.Y);
    }
}
