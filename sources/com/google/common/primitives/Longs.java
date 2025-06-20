package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Longs {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22958a = 8;

    /* renamed from: b  reason: collision with root package name */
    public static final long f22959b = 4611686018427387904L;

    static final class AsciiDigits {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f22960a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i2 = 0; i2 < 10; i2++) {
                bArr[i2 + 48] = (byte) i2;
            }
            for (int i3 = 0; i3 < 26; i3++) {
                byte b2 = (byte) (i3 + 10);
                bArr[i3 + 65] = b2;
                bArr[i3 + 97] = b2;
            }
            f22960a = bArr;
        }

        private AsciiDigits() {
        }

        static int a(char c2) {
            if (c2 < 128) {
                return f22960a[c2];
            }
            return -1;
        }
    }

    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int e2 = Longs.e(jArr[i2], jArr2[i2]);
                if (e2 != 0) {
                    return e2;
                }
            }
            return jArr.length - jArr2.length;
        }

        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    @GwtCompatible
    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final long[] s;

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        /* renamed from: b */
        public Long get(int i2) {
            Preconditions.C(i2, size());
            return Long.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Long set(int i2, Long l2) {
            Preconditions.C(i2, size());
            long[] jArr = this.s;
            int i3 = this.X;
            long j2 = jArr[i3 + i2];
            jArr[i3 + i2] = ((Long) Preconditions.E(l2)).longValue();
            return Long.valueOf(j2);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Long) && Longs.n(this.s, ((Long) obj).longValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public long[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != longArrayAsList.s[longArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Longs.l(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Long) || (a2 = Longs.n(this.s, ((Long) obj).longValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Long) || (b2 = Longs.r(this.s, ((Long) obj).longValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Long> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            long[] jArr = this.s;
            int i4 = this.X;
            return new LongArrayAsList(jArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.s[this.X]);
            int i2 = this.X;
            while (true) {
                i2++;
                if (i2 < this.Y) {
                    sb.append(", ");
                    sb.append(this.s[i2]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        LongArrayAsList(long[] jArr, int i2, int i3) {
            this.s = jArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter Y = new LongConverter();
        private static final long Z = 1;

        private LongConverter() {
        }

        private Object q() {
            return Y;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(Long l2) {
            return l2.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public Long i(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    private Longs() {
    }

    public static void A(long[] jArr, int i2, int i3) {
        Preconditions.E(jArr);
        Preconditions.f0(i2, i3, jArr.length);
        Arrays.sort(jArr, i2, i3);
        w(jArr, i2, i3);
    }

    public static Converter<String, Long> B() {
        return LongConverter.Y;
    }

    public static long[] C(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = ((Number) Preconditions.E(array[i2])).longValue();
        }
        return jArr;
    }

    public static byte[] D(long j2) {
        byte[] bArr = new byte[8];
        for (int i2 = 7; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j2));
            j2 >>= 8;
        }
        return bArr;
    }

    @CheckForNull
    public static Long E(String str) {
        return F(str, 10);
    }

    @CheckForNull
    public static Long F(String str, int i2) {
        String str2 = str;
        int i3 = i2;
        if (((String) Preconditions.E(str)).isEmpty()) {
            return null;
        }
        if (i3 < 2 || i3 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i3);
        }
        int i4 = 0;
        if (str2.charAt(0) == '-') {
            i4 = 1;
        }
        if (i4 == str.length()) {
            return null;
        }
        int i5 = i4 + 1;
        int a2 = AsciiDigits.a(str2.charAt(i4));
        if (a2 < 0 || a2 >= i3) {
            return null;
        }
        long j2 = (long) (-a2);
        long j3 = (long) i3;
        long j4 = Long.MIN_VALUE / j3;
        while (i5 < str.length()) {
            int i6 = i5 + 1;
            int a3 = AsciiDigits.a(str2.charAt(i5));
            if (a3 < 0 || a3 >= i3 || j2 < j4) {
                return null;
            }
            long j5 = j2 * j3;
            long j6 = (long) a3;
            if (j5 < j6 - Long.MIN_VALUE) {
                return null;
            }
            j2 = j5 - j6;
            i5 = i6;
        }
        if (i4 != 0) {
            return Long.valueOf(j2);
        }
        if (j2 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j2);
    }

    public static List<Long> c(long... jArr) {
        return jArr.length == 0 ? Collections.emptyList() : new LongArrayAsList(jArr);
    }

    private static int d(long j2) {
        int i2 = (int) j2;
        Preconditions.p(j2 == ((long) i2), "the total number of elements (%s) in the arrays must fit in an int", j2);
        return i2;
    }

    public static int e(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static long[] f(long[]... jArr) {
        long j2 = 0;
        for (long[] length : jArr) {
            j2 += (long) length.length;
        }
        long[] jArr2 = new long[d(j2)];
        int i2 = 0;
        for (long[] jArr3 : jArr) {
            System.arraycopy(jArr3, 0, jArr2, i2, jArr3.length);
            i2 += jArr3.length;
        }
        return jArr2;
    }

    public static long g(long j2, long j3, long j4) {
        Preconditions.s(j3 <= j4, "min (%s) must be less than or equal to max (%s)", j3, j4);
        return Math.min(Math.max(j2, j3), j4);
    }

    public static boolean h(long[] jArr, long j2) {
        for (long j3 : jArr) {
            if (j3 == j2) {
                return true;
            }
        }
        return false;
    }

    public static long[] i(long[] jArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return jArr.length < i2 ? Arrays.copyOf(jArr, i2 + i3) : jArr;
    }

    public static long j(byte[] bArr) {
        Preconditions.m(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return k(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long k(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((((long) b3) & 255) << 48) | ((((long) b2) & 255) << 56) | ((((long) b4) & 255) << 40) | ((((long) b5) & 255) << 32) | ((((long) b6) & 255) << 24) | ((((long) b7) & 255) << 16) | ((((long) b8) & 255) << 8) | (((long) b9) & 255);
    }

    public static int l(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int m(long[] jArr, long j2) {
        return n(jArr, j2, 0, jArr.length);
    }

    /* access modifiers changed from: private */
    public static int n(long[] jArr, long j2, int i2, int i3) {
        while (i2 < i3) {
            if (jArr[i2] == j2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int o(long[] jArr, long[] jArr2) {
        Preconditions.F(jArr, "array");
        Preconditions.F(jArr2, TypedValues.AttributesType.M);
        if (jArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (jArr.length - jArr2.length) + 1) {
            int i3 = 0;
            while (i3 < jArr2.length) {
                if (jArr[i2 + i3] != jArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static String p(String str, long... jArr) {
        Preconditions.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            sb.append(str);
            sb.append(jArr[i2]);
        }
        return sb.toString();
    }

    public static int q(long[] jArr, long j2) {
        return r(jArr, j2, 0, jArr.length);
    }

    /* access modifiers changed from: private */
    public static int r(long[] jArr, long j2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (jArr[i4] == j2) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<long[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long t(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long j2 = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public static long u(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long j2 = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public static void v(long[] jArr) {
        Preconditions.E(jArr);
        w(jArr, 0, jArr.length);
    }

    public static void w(long[] jArr, int i2, int i3) {
        Preconditions.E(jArr);
        Preconditions.f0(i2, i3, jArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            long j2 = jArr[i2];
            jArr[i2] = jArr[i4];
            jArr[i4] = j2;
            i2++;
        }
    }

    public static void x(long[] jArr, int i2) {
        y(jArr, i2, 0, jArr.length);
    }

    public static void y(long[] jArr, int i2, int i3, int i4) {
        Preconditions.E(jArr);
        Preconditions.f0(i3, i4, jArr.length);
        if (jArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                w(jArr, i3, i7);
                w(jArr, i7, i4);
                w(jArr, i3, i4);
            }
        }
    }

    public static void z(long[] jArr) {
        Preconditions.E(jArr);
        A(jArr, 0, jArr.length);
    }
}
