package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckForNull;
import net.lingala.zip4j.util.InternalZipConstants;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger X = e(0);
    public static final UnsignedInteger Y = e(1);
    public static final UnsignedInteger Z = e(-1);
    private final int s;

    private UnsignedInteger(int i2) {
        this.s = i2;
    }

    public static UnsignedInteger e(int i2) {
        return new UnsignedInteger(i2);
    }

    public static UnsignedInteger k(long j2) {
        Preconditions.p((InternalZipConstants.f30717k & j2) == j2, "value (%s) is outside the range for an unsigned integer value", j2);
        return e((int) j2);
    }

    public static UnsignedInteger l(String str) {
        return m(str, 10);
    }

    public static UnsignedInteger m(String str, int i2) {
        return e(UnsignedInts.k(str, i2));
    }

    public static UnsignedInteger n(BigInteger bigInteger) {
        Preconditions.E(bigInteger);
        Preconditions.u(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return e(bigInteger.intValue());
    }

    public BigInteger a() {
        return BigInteger.valueOf(longValue());
    }

    /* renamed from: b */
    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.E(unsignedInteger);
        return UnsignedInts.b(this.s, unsignedInteger.s);
    }

    public UnsignedInteger c(UnsignedInteger unsignedInteger) {
        return e(UnsignedInts.d(this.s, ((UnsignedInteger) Preconditions.E(unsignedInteger)).s));
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof UnsignedInteger) && this.s == ((UnsignedInteger) obj).s;
    }

    public UnsignedInteger f(UnsignedInteger unsignedInteger) {
        return e(this.s - ((UnsignedInteger) Preconditions.E(unsignedInteger)).s);
    }

    public float floatValue() {
        return (float) longValue();
    }

    public UnsignedInteger g(UnsignedInteger unsignedInteger) {
        return e(UnsignedInts.l(this.s, ((UnsignedInteger) Preconditions.E(unsignedInteger)).s));
    }

    public UnsignedInteger h(UnsignedInteger unsignedInteger) {
        return e(this.s + ((UnsignedInteger) Preconditions.E(unsignedInteger)).s);
    }

    public int hashCode() {
        return this.s;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public UnsignedInteger i(UnsignedInteger unsignedInteger) {
        return e(this.s * ((UnsignedInteger) Preconditions.E(unsignedInteger)).s);
    }

    public int intValue() {
        return this.s;
    }

    public String j(int i2) {
        return UnsignedInts.t(this.s, i2);
    }

    public long longValue() {
        return UnsignedInts.r(this.s);
    }

    public String toString() {
        return j(10);
    }
}
