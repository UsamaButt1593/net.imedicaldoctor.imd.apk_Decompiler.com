package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

public final class ValueRange implements Serializable {
    private static final long X2 = -7317881728594519368L;
    private final long X;
    private final long Y;
    private final long Z;
    private final long s;

    private ValueRange(long j2, long j3, long j4, long j5) {
        this.s = j2;
        this.X = j3;
        this.Y = j4;
        this.Z = j5;
    }

    public static ValueRange k(long j2, long j3) {
        if (j2 <= j3) {
            return new ValueRange(j2, j2, j3, j3);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange l(long j2, long j3, long j4) {
        return m(j2, j2, j3, j4);
    }

    public static ValueRange m(long j2, long j3, long j4, long j5) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j3 <= j5) {
            return new ValueRange(j2, j3, j4, j5);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public int a(long j2, TemporalField temporalField) {
        if (i(j2)) {
            return (int) j2;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j2);
    }

    public long b(long j2, TemporalField temporalField) {
        if (j(j2)) {
            return j2;
        }
        if (temporalField != null) {
            throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j2);
        }
        throw new DateTimeException("Invalid value (valid values " + this + "): " + j2);
    }

    public long c() {
        return this.X;
    }

    public long d() {
        return this.Z;
    }

    public long e() {
        return this.s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        return this.s == valueRange.s && this.X == valueRange.X && this.Y == valueRange.Y && this.Z == valueRange.Z;
    }

    public long f() {
        return this.Y;
    }

    public boolean g() {
        return this.s == this.X && this.Y == this.Z;
    }

    public boolean h() {
        return e() >= -2147483648L && d() <= 2147483647L;
    }

    public int hashCode() {
        long j2 = this.s;
        long j3 = this.X;
        long j4 = this.Y;
        long j5 = this.Z;
        long j6 = ((((((j2 + j3) << ((int) (j3 + 16))) >> ((int) (j4 + 48))) << ((int) (j4 + 32))) >> ((int) (32 + j5))) << ((int) (j5 + 48))) >> 16;
        return (int) (j6 ^ (j6 >>> 32));
    }

    public boolean i(long j2) {
        return h() && j(j2);
    }

    public boolean j(long j2) {
        return j2 >= e() && j2 <= d();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.s);
        if (this.s != this.X) {
            sb.append('/');
            sb.append(this.X);
        }
        sb.append(" - ");
        sb.append(this.Y);
        if (this.Y != this.Z) {
            sb.append('/');
            sb.append(this.Z);
        }
        return sb.toString();
    }
}
