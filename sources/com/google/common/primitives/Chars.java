package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
import kotlin.jvm.internal.CharCompanionObject;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Chars {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22946a = 2;

    @GwtCompatible
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final char[] s;

        CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        /* renamed from: b */
        public Character get(int i2) {
            Preconditions.C(i2, size());
            return Character.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Character set(int i2, Character ch) {
            Preconditions.C(i2, size());
            char[] cArr = this.s;
            int i3 = this.X;
            char c2 = cArr[i3 + i2];
            cArr[i3 + i2] = ((Character) Preconditions.E(ch)).charValue();
            return Character.valueOf(c2);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Character) && Chars.n(this.s, ((Character) obj).charValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public char[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != charArrayAsList.s[charArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Chars.l(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Character) || (a2 = Chars.n(this.s, ((Character) obj).charValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Character) || (b2 = Chars.r(this.s, ((Character) obj).charValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Character> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            char[] cArr = this.s;
            int i4 = this.X;
            return new CharArrayAsList(cArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
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

        CharArrayAsList(char[] cArr, int i2, int i3) {
            this.s = cArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int e2 = Chars.e(cArr[i2], cArr2[i2]);
                if (e2 != 0) {
                    return e2;
                }
            }
            return cArr.length - cArr2.length;
        }

        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    private Chars() {
    }

    public static void A(char[] cArr) {
        Preconditions.E(cArr);
        B(cArr, 0, cArr.length);
    }

    public static void B(char[] cArr, int i2, int i3) {
        Preconditions.E(cArr);
        Preconditions.f0(i2, i3, cArr.length);
        Arrays.sort(cArr, i2, i3);
        w(cArr, i2, i3);
    }

    public static char[] C(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = ((Character) Preconditions.E(array[i2])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] D(char c2) {
        return new byte[]{(byte) (c2 >> 8), (byte) c2};
    }

    public static List<Character> c(char... cArr) {
        return cArr.length == 0 ? Collections.emptyList() : new CharArrayAsList(cArr);
    }

    public static char d(long j2) {
        char c2 = (char) ((int) j2);
        Preconditions.p(((long) c2) == j2, "Out of range: %s", j2);
        return c2;
    }

    public static int e(char c2, char c3) {
        return c2 - c3;
    }

    public static char[] f(char[]... cArr) {
        int i2 = 0;
        for (char[] length : cArr) {
            i2 += length.length;
        }
        char[] cArr2 = new char[i2];
        int i3 = 0;
        for (char[] cArr3 : cArr) {
            System.arraycopy(cArr3, 0, cArr2, i3, cArr3.length);
            i3 += cArr3.length;
        }
        return cArr2;
    }

    public static char g(char c2, char c3, char c4) {
        Preconditions.g(c3 <= c4, "min (%s) must be less than or equal to max (%s)", c3, c4);
        if (c2 < c3) {
            return c3;
        }
        return c2 < c4 ? c2 : c4;
    }

    public static boolean h(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public static char[] i(char[] cArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return cArr.length < i2 ? Arrays.copyOf(cArr, i2 + i3) : cArr;
    }

    @GwtIncompatible
    public static char j(byte[] bArr) {
        Preconditions.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static char k(byte b2, byte b3) {
        return (char) ((b2 << 8) | (b3 & 255));
    }

    public static int l(char c2) {
        return c2;
    }

    public static int m(char[] cArr, char c2) {
        return n(cArr, c2, 0, cArr.length);
    }

    /* access modifiers changed from: private */
    public static int n(char[] cArr, char c2, int i2, int i3) {
        while (i2 < i3) {
            if (cArr[i2] == c2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int o(char[] cArr, char[] cArr2) {
        Preconditions.F(cArr, "array");
        Preconditions.F(cArr2, TypedValues.AttributesType.M);
        if (cArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (cArr.length - cArr2.length) + 1) {
            int i3 = 0;
            while (i3 < cArr2.length) {
                if (cArr[i2 + i3] != cArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static String p(String str, char... cArr) {
        Preconditions.E(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(str);
            sb.append(cArr[i2]);
        }
        return sb.toString();
    }

    public static int q(char[] cArr, char c2) {
        return r(cArr, c2, 0, cArr.length);
    }

    /* access modifiers changed from: private */
    public static int r(char[] cArr, char c2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (cArr[i4] == c2) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<char[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char t(char... cArr) {
        Preconditions.d(cArr.length > 0);
        char c2 = cArr[0];
        for (int i2 = 1; i2 < cArr.length; i2++) {
            char c3 = cArr[i2];
            if (c3 > c2) {
                c2 = c3;
            }
        }
        return c2;
    }

    public static char u(char... cArr) {
        Preconditions.d(cArr.length > 0);
        char c2 = cArr[0];
        for (int i2 = 1; i2 < cArr.length; i2++) {
            char c3 = cArr[i2];
            if (c3 < c2) {
                c2 = c3;
            }
        }
        return c2;
    }

    public static void v(char[] cArr) {
        Preconditions.E(cArr);
        w(cArr, 0, cArr.length);
    }

    public static void w(char[] cArr, int i2, int i3) {
        Preconditions.E(cArr);
        Preconditions.f0(i2, i3, cArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            char c2 = cArr[i2];
            cArr[i2] = cArr[i4];
            cArr[i4] = c2;
            i2++;
        }
    }

    public static void x(char[] cArr, int i2) {
        y(cArr, i2, 0, cArr.length);
    }

    public static void y(char[] cArr, int i2, int i3, int i4) {
        Preconditions.E(cArr);
        Preconditions.f0(i3, i4, cArr.length);
        if (cArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                w(cArr, i3, i7);
                w(cArr, i7, i4);
                w(cArr, i3, i4);
            }
        }
    }

    public static char z(long j2) {
        if (j2 > 65535) {
            return CharCompanionObject.f28914c;
        }
        if (j2 < 0) {
            return 0;
        }
        return (char) ((int) j2);
    }
}
