package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
import kotlin.jvm.internal.ShortCompanionObject;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Shorts extends ShortsMethodsForWeb {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22965a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final short f22966b = 16384;

    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int e2 = Shorts.e(sArr[i2], sArr2[i2]);
                if (e2 != 0) {
                    return e2;
                }
            }
            return sArr.length - sArr2.length;
        }

        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    @GwtCompatible
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final short[] s;

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        /* renamed from: b */
        public Short get(int i2) {
            Preconditions.C(i2, size());
            return Short.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Short set(int i2, Short sh) {
            Preconditions.C(i2, size());
            short[] sArr = this.s;
            int i3 = this.X;
            short s2 = sArr[i3 + i2];
            sArr[i3 + i2] = ((Short) Preconditions.E(sh)).shortValue();
            return Short.valueOf(s2);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Short) && Shorts.n(this.s, ((Short) obj).shortValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public short[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != shortArrayAsList.s[shortArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Shorts.l(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Short) || (a2 = Shorts.n(this.s, ((Short) obj).shortValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Short) || (b2 = Shorts.r(this.s, ((Short) obj).shortValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Short> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            short[] sArr = this.s;
            int i4 = this.X;
            return new ShortArrayAsList(sArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
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

        ShortArrayAsList(short[] sArr, int i2, int i3) {
            this.s = sArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter Y = new ShortConverter();
        private static final long Z = 1;

        private ShortConverter() {
        }

        private Object q() {
            return Y;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(Short sh) {
            return sh.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public Short i(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    private Shorts() {
    }

    public static void A(short[] sArr) {
        Preconditions.E(sArr);
        B(sArr, 0, sArr.length);
    }

    public static void B(short[] sArr, int i2, int i3) {
        Preconditions.E(sArr);
        Preconditions.f0(i2, i3, sArr.length);
        Arrays.sort(sArr, i2, i3);
        w(sArr, i2, i3);
    }

    public static Converter<String, Short> C() {
        return ShortConverter.Y;
    }

    public static short[] D(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = ((Number) Preconditions.E(array[i2])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] E(short s) {
        return new byte[]{(byte) (s >> 8), (byte) s};
    }

    public static List<Short> c(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new ShortArrayAsList(sArr);
    }

    public static short d(long j2) {
        short s = (short) ((int) j2);
        Preconditions.p(((long) s) == j2, "Out of range: %s", j2);
        return s;
    }

    public static int e(short s, short s2) {
        return s - s2;
    }

    public static short[] f(short[]... sArr) {
        int i2 = 0;
        for (short[] length : sArr) {
            i2 += length.length;
        }
        short[] sArr2 = new short[i2];
        int i3 = 0;
        for (short[] sArr3 : sArr) {
            System.arraycopy(sArr3, 0, sArr2, i3, sArr3.length);
            i3 += sArr3.length;
        }
        return sArr2;
    }

    public static short g(short s, short s2, short s3) {
        Preconditions.m(s2 <= s3, "min (%s) must be less than or equal to max (%s)", s2, s3);
        if (s < s2) {
            return s2;
        }
        return s < s3 ? s : s3;
    }

    public static boolean h(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static short[] i(short[] sArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return sArr.length < i2 ? Arrays.copyOf(sArr, i2 + i3) : sArr;
    }

    @GwtIncompatible
    public static short j(byte[] bArr) {
        Preconditions.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short k(byte b2, byte b3) {
        return (short) ((b2 << 8) | (b3 & 255));
    }

    public static int l(short s) {
        return s;
    }

    public static int m(short[] sArr, short s) {
        return n(sArr, s, 0, sArr.length);
    }

    /* access modifiers changed from: private */
    public static int n(short[] sArr, short s, int i2, int i3) {
        while (i2 < i3) {
            if (sArr[i2] == s) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int o(short[] sArr, short[] sArr2) {
        Preconditions.F(sArr, "array");
        Preconditions.F(sArr2, TypedValues.AttributesType.M);
        if (sArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (sArr.length - sArr2.length) + 1) {
            int i3 = 0;
            while (i3 < sArr2.length) {
                if (sArr[i2 + i3] != sArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static String p(String str, short... sArr) {
        Preconditions.E(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append(sArr[0]);
        for (int i2 = 1; i2 < sArr.length; i2++) {
            sb.append(str);
            sb.append(sArr[i2]);
        }
        return sb.toString();
    }

    public static int q(short[] sArr, short s) {
        return r(sArr, s, 0, sArr.length);
    }

    /* access modifiers changed from: private */
    public static int r(short[] sArr, short s, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (sArr[i4] == s) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<short[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short t(short... sArr) {
        Preconditions.d(sArr.length > 0);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            short s2 = sArr[i2];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short u(short... sArr) {
        Preconditions.d(sArr.length > 0);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            short s2 = sArr[i2];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }

    public static void v(short[] sArr) {
        Preconditions.E(sArr);
        w(sArr, 0, sArr.length);
    }

    public static void w(short[] sArr, int i2, int i3) {
        Preconditions.E(sArr);
        Preconditions.f0(i2, i3, sArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            short s = sArr[i2];
            sArr[i2] = sArr[i4];
            sArr[i4] = s;
            i2++;
        }
    }

    public static void x(short[] sArr, int i2) {
        y(sArr, i2, 0, sArr.length);
    }

    public static void y(short[] sArr, int i2, int i3, int i4) {
        Preconditions.E(sArr);
        Preconditions.f0(i3, i4, sArr.length);
        if (sArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                w(sArr, i3, i7);
                w(sArr, i7, i4);
                w(sArr, i3, i4);
            }
        }
    }

    public static short z(long j2) {
        if (j2 > 32767) {
            return ShortCompanionObject.f28966c;
        }
        return j2 < -32768 ? ShortCompanionObject.f28965b : (short) ((int) j2);
    }
}
