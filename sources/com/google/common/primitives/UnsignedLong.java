package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private static final long X = Long.MAX_VALUE;
    public static final UnsignedLong X2 = new UnsignedLong(-1);
    public static final UnsignedLong Y = new UnsignedLong(0);
    public static final UnsignedLong Z = new UnsignedLong(1);
    private final long s;

    private UnsignedLong(long j2) {
        this.s = j2;
    }

    public static UnsignedLong e(long j2) {
        return new UnsignedLong(j2);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong k(long j2) {
        Preconditions.p(j2 >= 0, "value (%s) is outside the range for an unsigned long value", j2);
        return e(j2);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong l(String str) {
        return m(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong m(String str, int i2) {
        return e(UnsignedLongs.j(str, i2));
    }

    @CanIgnoreReturnValue
    public static UnsignedLong n(BigInteger bigInteger) {
        Preconditions.E(bigInteger);
        Preconditions.u(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return e(bigInteger.longValue());
    }

    public BigInteger a() {
        BigInteger valueOf = BigInteger.valueOf(this.s & Long.MAX_VALUE);
        return this.s < 0 ? valueOf.setBit(63) : valueOf;
    }

    /* renamed from: b */
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.E(unsignedLong);
        return UnsignedLongs.a(this.s, unsignedLong.s);
    }

    public UnsignedLong c(UnsignedLong unsignedLong) {
        return e(UnsignedLongs.c(this.s, ((UnsignedLong) Preconditions.E(unsignedLong)).s));
    }

    public double doubleValue() {
        long j2 = this.s;
        if (j2 >= 0) {
            return (double) j2;
        }
        return ((double) ((j2 & 1) | (j2 >>> 1))) * 2.0d;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof UnsignedLong) && this.s == ((UnsignedLong) obj).s;
    }

    public UnsignedLong f(UnsignedLong unsignedLong) {
        return e(this.s - ((UnsignedLong) Preconditions.E(unsignedLong)).s);
    }

    public float floatValue() {
        long j2 = this.s;
        if (j2 >= 0) {
            return (float) j2;
        }
        return ((float) ((j2 & 1) | (j2 >>> 1))) * 2.0f;
    }

    public UnsignedLong g(UnsignedLong unsignedLong) {
        return e(UnsignedLongs.k(this.s, ((UnsignedLong) Preconditions.E(unsignedLong)).s));
    }

    public UnsignedLong h(UnsignedLong unsignedLong) {
        return e(this.s + ((UnsignedLong) Preconditions.E(unsignedLong)).s);
    }

    public int hashCode() {
        return Longs.l(this.s);
    }

    public UnsignedLong i(UnsignedLong unsignedLong) {
        return e(this.s * ((UnsignedLong) Preconditions.E(unsignedLong)).s);
    }

    public int intValue() {
        return (int) this.s;
    }

    public String j(int i2) {
        return UnsignedLongs.q(this.s, i2);
    }

    public long longValue() {
        return this.s;
    }

    public String toString() {
        return UnsignedLongs.p(this.s);
    }
}
