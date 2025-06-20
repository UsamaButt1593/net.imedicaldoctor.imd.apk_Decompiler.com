package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class HashCode {
    private static final char[] s = "0123456789abcdef".toCharArray();

    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long Y = 0;
        final byte[] X;

        BytesHashCode(byte[] bArr) {
            this.X = (byte[]) Preconditions.E(bArr);
        }

        public byte[] a() {
            return (byte[]) this.X.clone();
        }

        public int b() {
            byte[] bArr = this.X;
            Preconditions.n0(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.X;
            return ((bArr2[3] & 255) << Ascii.B) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        public long c() {
            byte[] bArr = this.X;
            Preconditions.n0(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return m();
        }

        public int d() {
            return this.X.length * 8;
        }

        /* access modifiers changed from: package-private */
        public boolean f(HashCode hashCode) {
            if (this.X.length != hashCode.l().length) {
                return false;
            }
            int i2 = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.X;
                if (i2 >= bArr.length) {
                    return z;
                }
                z &= bArr[i2] == hashCode.l()[i2];
                i2++;
            }
        }

        /* access modifiers changed from: package-private */
        public byte[] l() {
            return this.X;
        }

        public long m() {
            long j2 = (long) (this.X[0] & 255);
            for (int i2 = 1; i2 < Math.min(this.X.length, 8); i2++) {
                j2 |= (((long) this.X[i2]) & 255) << (i2 * 8);
            }
            return j2;
        }

        /* access modifiers changed from: package-private */
        public void o(byte[] bArr, int i2, int i3) {
            System.arraycopy(this.X, 0, bArr, i2, i3);
        }
    }

    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long Y = 0;
        final int X;

        IntHashCode(int i2) {
            this.X = i2;
        }

        public byte[] a() {
            int i2 = this.X;
            return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
        }

        public int b() {
            return this.X;
        }

        public long c() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        public int d() {
            return 32;
        }

        /* access modifiers changed from: package-private */
        public boolean f(HashCode hashCode) {
            return this.X == hashCode.b();
        }

        public long m() {
            return UnsignedInts.r(this.X);
        }

        /* access modifiers changed from: package-private */
        public void o(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) (this.X >> (i4 * 8));
            }
        }
    }

    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long Y = 0;
        final long X;

        LongHashCode(long j2) {
            this.X = j2;
        }

        public byte[] a() {
            long j2 = this.X;
            return new byte[]{(byte) ((int) j2), (byte) ((int) (j2 >> 8)), (byte) ((int) (j2 >> 16)), (byte) ((int) (j2 >> 24)), (byte) ((int) (j2 >> 32)), (byte) ((int) (j2 >> 40)), (byte) ((int) (j2 >> 48)), (byte) ((int) (j2 >> 56))};
        }

        public int b() {
            return (int) this.X;
        }

        public long c() {
            return this.X;
        }

        public int d() {
            return 64;
        }

        /* access modifiers changed from: package-private */
        public boolean f(HashCode hashCode) {
            return this.X == hashCode.c();
        }

        public long m() {
            return this.X;
        }

        /* access modifiers changed from: package-private */
        public void o(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) ((int) (this.X >> (i4 * 8)));
            }
        }
    }

    HashCode() {
    }

    private static int e(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c2);
    }

    public static HashCode g(byte[] bArr) {
        boolean z = true;
        if (bArr.length < 1) {
            z = false;
        }
        Preconditions.e(z, "A HashCode must contain at least 1 byte.");
        return h((byte[]) bArr.clone());
    }

    static HashCode h(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode i(int i2) {
        return new IntHashCode(i2);
    }

    public static HashCode j(long j2) {
        return new LongHashCode(j2);
    }

    public static HashCode k(String str) {
        boolean z = true;
        Preconditions.u(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        if (str.length() % 2 != 0) {
            z = false;
        }
        Preconditions.u(z, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) ((e(str.charAt(i2)) << 4) + e(str.charAt(i2 + 1)));
        }
        return h(bArr);
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        return d() == hashCode.d() && f(hashCode);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean f(HashCode hashCode);

    public final int hashCode() {
        if (d() >= 32) {
            return b();
        }
        byte[] l2 = l();
        byte b2 = l2[0] & 255;
        for (int i2 = 1; i2 < l2.length; i2++) {
            b2 |= (l2[i2] & 255) << (i2 * 8);
        }
        return b2;
    }

    /* access modifiers changed from: package-private */
    public byte[] l() {
        return a();
    }

    public abstract long m();

    @CanIgnoreReturnValue
    public int n(byte[] bArr, int i2, int i3) {
        int u = Ints.u(i3, d() / 8);
        Preconditions.f0(i2, i2 + u, bArr.length);
        o(bArr, i2, u);
        return u;
    }

    /* access modifiers changed from: package-private */
    public abstract void o(byte[] bArr, int i2, int i3);

    public final String toString() {
        byte[] l2 = l();
        StringBuilder sb = new StringBuilder(l2.length * 2);
        for (byte b2 : l2) {
            char[] cArr = s;
            sb.append(cArr[(b2 >> 4) & 15]);
            sb.append(cArr[b2 & 15]);
        }
        return sb.toString();
    }
}
