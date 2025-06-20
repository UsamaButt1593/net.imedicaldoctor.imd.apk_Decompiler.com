package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
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

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Ints extends IntsMethodsForWeb {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22956a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static final int f22957b = 1073741824;

    @GwtCompatible
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final int[] s;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        /* renamed from: b */
        public Integer get(int i2) {
            Preconditions.C(i2, size());
            return Integer.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Integer set(int i2, Integer num) {
            Preconditions.C(i2, size());
            int[] iArr = this.s;
            int i3 = this.X;
            int i4 = iArr[i3 + i2];
            iArr[i3 + i2] = ((Integer) Preconditions.E(num)).intValue();
            return Integer.valueOf(i4);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Integer) && Ints.n(this.s, ((Integer) obj).intValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public int[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != intArrayAsList.s[intArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Ints.l(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Integer) || (a2 = Ints.n(this.s, ((Integer) obj).intValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Integer) || (b2 = Ints.r(this.s, ((Integer) obj).intValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Integer> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            int[] iArr = this.s;
            int i4 = this.X;
            return new IntArrayAsList(iArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        IntArrayAsList(int[] iArr, int i2, int i3) {
            this.s = iArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter Y = new IntConverter();
        private static final long Z = 1;

        private IntConverter() {
        }

        private Object q() {
            return Y;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(Integer num) {
            return num.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public Integer i(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int e2 = Ints.e(iArr[i2], iArr2[i2]);
                if (e2 != 0) {
                    return e2;
                }
            }
            return iArr.length - iArr2.length;
        }

        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    private Ints() {
    }

    public static void A(int[] iArr) {
        Preconditions.E(iArr);
        B(iArr, 0, iArr.length);
    }

    public static void B(int[] iArr, int i2, int i3) {
        Preconditions.E(iArr);
        Preconditions.f0(i2, i3, iArr.length);
        Arrays.sort(iArr, i2, i3);
        w(iArr, i2, i3);
    }

    public static Converter<String, Integer> C() {
        return IntConverter.Y;
    }

    public static int[] D(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = ((Number) Preconditions.E(array[i2])).intValue();
        }
        return iArr;
    }

    public static byte[] E(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }

    @CheckForNull
    public static Integer F(String str) {
        return G(str, 10);
    }

    @CheckForNull
    public static Integer G(String str, int i2) {
        Long F = Longs.F(str, i2);
        if (F == null || F.longValue() != ((long) F.intValue())) {
            return null;
        }
        return Integer.valueOf(F.intValue());
    }

    public static List<Integer> c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new IntArrayAsList(iArr);
    }

    public static int d(long j2) {
        int i2 = (int) j2;
        Preconditions.p(((long) i2) == j2, "Out of range: %s", j2);
        return i2;
    }

    public static int e(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int[] f(int[]... iArr) {
        int i2 = 0;
        for (int[] length : iArr) {
            i2 += length.length;
        }
        int[] iArr2 = new int[i2];
        int i3 = 0;
        for (int[] iArr3 : iArr) {
            System.arraycopy(iArr3, 0, iArr2, i3, iArr3.length);
            i3 += iArr3.length;
        }
        return iArr2;
    }

    public static int g(int i2, int i3, int i4) {
        Preconditions.m(i3 <= i4, "min (%s) must be less than or equal to max (%s)", i3, i4);
        return Math.min(Math.max(i2, i3), i4);
    }

    public static boolean h(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static int[] i(int[] iArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return iArr.length < i2 ? Arrays.copyOf(iArr, i2 + i3) : iArr;
    }

    public static int j(byte[] bArr) {
        Preconditions.m(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return k(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int k(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << Ascii.B) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int l(int i2) {
        return i2;
    }

    public static int m(int[] iArr, int i2) {
        return n(iArr, i2, 0, iArr.length);
    }

    /* access modifiers changed from: private */
    public static int n(int[] iArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (iArr[i3] == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int o(int[] iArr, int[] iArr2) {
        Preconditions.F(iArr, "array");
        Preconditions.F(iArr2, TypedValues.AttributesType.M);
        if (iArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (iArr.length - iArr2.length) + 1) {
            int i3 = 0;
            while (i3 < iArr2.length) {
                if (iArr[i2 + i3] != iArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static String p(String str, int... iArr) {
        Preconditions.E(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            sb.append(str);
            sb.append(iArr[i2]);
        }
        return sb.toString();
    }

    public static int q(int[] iArr, int i2) {
        return r(iArr, i2, 0, iArr.length);
    }

    /* access modifiers changed from: private */
    public static int r(int[] iArr, int i2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (iArr[i5] == i2) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<int[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int t(int... iArr) {
        Preconditions.d(iArr.length > 0);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int u(int... iArr) {
        Preconditions.d(iArr.length > 0);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    public static void v(int[] iArr) {
        Preconditions.E(iArr);
        w(iArr, 0, iArr.length);
    }

    public static void w(int[] iArr, int i2, int i3) {
        Preconditions.E(iArr);
        Preconditions.f0(i2, i3, iArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            int i5 = iArr[i2];
            iArr[i2] = iArr[i4];
            iArr[i4] = i5;
            i2++;
        }
    }

    public static void x(int[] iArr, int i2) {
        y(iArr, i2, 0, iArr.length);
    }

    public static void y(int[] iArr, int i2, int i3, int i4) {
        Preconditions.E(iArr);
        Preconditions.f0(i3, i4, iArr.length);
        if (iArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                w(iArr, i3, i7);
                w(iArr, i7, i4);
                w(iArr, i3, i4);
            }
        }
    }

    public static int z(long j2) {
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }
}
