package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    @GwtCompatible
    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final boolean[] s;

        BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        /* renamed from: b */
        public Boolean get(int i2) {
            Preconditions.C(i2, size());
            return Boolean.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Boolean set(int i2, Boolean bool) {
            Preconditions.C(i2, size());
            boolean[] zArr = this.s;
            int i3 = this.X;
            boolean z = zArr[i3 + i2];
            zArr[i3 + i2] = ((Boolean) Preconditions.E(bool)).booleanValue();
            return Boolean.valueOf(z);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Boolean) && Booleans.l(this.s, ((Boolean) obj).booleanValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public boolean[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != booleanArrayAsList.s[booleanArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Booleans.j(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Boolean) || (a2 = Booleans.l(this.s, ((Boolean) obj).booleanValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Boolean) || (b2 = Booleans.p(this.s, ((Boolean) obj).booleanValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Boolean> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.s;
            int i4 = this.X;
            return new BooleanArrayAsList(zArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.s[this.X] ? "[true" : "[false");
            int i2 = this.X;
            while (true) {
                i2++;
                if (i2 < this.Y) {
                    sb.append(this.s[i2] ? ", true" : ", false");
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        BooleanArrayAsList(boolean[] zArr, int i2, int i3) {
            this.s = zArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        private final String X;
        private final int s;

        private BooleanComparator(int i2, String str) {
            this.s = i2;
            this.X = str;
        }

        /* renamed from: b */
        public int compare(Boolean bool, Boolean bool2) {
            int i2 = 0;
            int i3 = bool.booleanValue() ? this.s : 0;
            if (bool2.booleanValue()) {
                i2 = this.s;
            }
            return i2 - i3;
        }

        public String toString() {
            return this.X;
        }
    }

    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int d2 = Booleans.d(zArr[i2], zArr2[i2]);
                if (d2 != 0) {
                    return d2;
                }
            }
            return zArr.length - zArr2.length;
        }

        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    private Booleans() {
    }

    public static List<Boolean> c(boolean... zArr) {
        return zArr.length == 0 ? Collections.emptyList() : new BooleanArrayAsList(zArr);
    }

    public static int d(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static boolean[] e(boolean[]... zArr) {
        int i2 = 0;
        for (boolean[] length : zArr) {
            i2 += length.length;
        }
        boolean[] zArr2 = new boolean[i2];
        int i3 = 0;
        for (boolean[] zArr3 : zArr) {
            System.arraycopy(zArr3, 0, zArr2, i3, zArr3.length);
            i3 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean f(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static int g(boolean... zArr) {
        int i2 = 0;
        for (boolean z : zArr) {
            if (z) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean[] h(boolean[] zArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return zArr.length < i2 ? Arrays.copyOf(zArr, i2 + i3) : zArr;
    }

    public static Comparator<Boolean> i() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int j(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int k(boolean[] zArr, boolean z) {
        return l(zArr, z, 0, zArr.length);
    }

    /* access modifiers changed from: private */
    public static int l(boolean[] zArr, boolean z, int i2, int i3) {
        while (i2 < i3) {
            if (zArr[i2] == z) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int m(boolean[] zArr, boolean[] zArr2) {
        Preconditions.F(zArr, "array");
        Preconditions.F(zArr2, TypedValues.AttributesType.M);
        if (zArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (zArr.length - zArr2.length) + 1) {
            int i3 = 0;
            while (i3 < zArr2.length) {
                if (zArr[i2 + i3] != zArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static String n(String str, boolean... zArr) {
        Preconditions.E(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i2 = 1; i2 < zArr.length; i2++) {
            sb.append(str);
            sb.append(zArr[i2]);
        }
        return sb.toString();
    }

    public static int o(boolean[] zArr, boolean z) {
        return p(zArr, z, 0, zArr.length);
    }

    /* access modifiers changed from: private */
    public static int p(boolean[] zArr, boolean z, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (zArr[i4] == z) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> q() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void r(boolean[] zArr) {
        Preconditions.E(zArr);
        s(zArr, 0, zArr.length);
    }

    public static void s(boolean[] zArr, int i2, int i3) {
        Preconditions.E(zArr);
        Preconditions.f0(i2, i3, zArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            boolean z = zArr[i2];
            zArr[i2] = zArr[i4];
            zArr[i4] = z;
            i2++;
        }
    }

    public static void t(boolean[] zArr, int i2) {
        u(zArr, i2, 0, zArr.length);
    }

    public static void u(boolean[] zArr, int i2, int i3, int i4) {
        Preconditions.E(zArr);
        Preconditions.f0(i3, i4, zArr.length);
        if (zArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                s(zArr, i3, i7);
                s(zArr, i7, i4);
                s(zArr, i3, i4);
            }
        }
    }

    public static boolean[] v(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = ((Boolean) Preconditions.E(array[i2])).booleanValue();
        }
        return zArr;
    }

    public static Comparator<Boolean> w() {
        return BooleanComparator.TRUE_FIRST;
    }
}
