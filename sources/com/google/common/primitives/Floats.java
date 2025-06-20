package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
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
public final class Floats extends FloatsMethodsForWeb {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22949a = 4;

    @GwtCompatible
    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final float[] s;

        FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        /* renamed from: b */
        public Float get(int i2) {
            Preconditions.C(i2, size());
            return Float.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Float set(int i2, Float f2) {
            Preconditions.C(i2, size());
            float[] fArr = this.s;
            int i3 = this.X;
            float f3 = fArr[i3 + i2];
            fArr[i3 + i2] = ((Float) Preconditions.E(f2)).floatValue();
            return Float.valueOf(f3);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Float) && Floats.k(this.s, ((Float) obj).floatValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public float[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != floatArrayAsList.s[floatArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Floats.i(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Float) || (a2 = Floats.k(this.s, ((Float) obj).floatValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Float) || (b2 = Floats.p(this.s, ((Float) obj).floatValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Float> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            float[] fArr = this.s;
            int i4 = this.X;
            return new FloatArrayAsList(fArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        FloatArrayAsList(float[] fArr, int i2, int i3) {
            this.s = fArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter Y = new FloatConverter();
        private static final long Z = 1;

        private FloatConverter() {
        }

        private Object q() {
            return Y;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(Float f2) {
            return f2.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public Float i(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Float.compare(fArr[i2], fArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    private Floats() {
    }

    public static float[] A(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = ((Number) Preconditions.E(array[i2])).floatValue();
        }
        return fArr;
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    public static Float B(String str) {
        if (!Doubles.f22948b.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static List<Float> c(float... fArr) {
        return fArr.length == 0 ? Collections.emptyList() : new FloatArrayAsList(fArr);
    }

    public static int d(float f2, float f3) {
        return Float.compare(f2, f3);
    }

    public static float[] e(float[]... fArr) {
        int i2 = 0;
        for (float[] length : fArr) {
            i2 += length.length;
        }
        float[] fArr2 = new float[i2];
        int i3 = 0;
        for (float[] fArr3 : fArr) {
            System.arraycopy(fArr3, 0, fArr2, i3, fArr3.length);
            i3 += fArr3.length;
        }
        return fArr2;
    }

    public static float f(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return Math.min(Math.max(f2, f3), f4);
        }
        throw new IllegalArgumentException(Strings.e("min (%s) must be less than or equal to max (%s)", Float.valueOf(f3), Float.valueOf(f4)));
    }

    public static boolean g(float[] fArr, float f2) {
        for (float f3 : fArr) {
            if (f3 == f2) {
                return true;
            }
        }
        return false;
    }

    public static float[] h(float[] fArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return fArr.length < i2 ? Arrays.copyOf(fArr, i2 + i3) : fArr;
    }

    public static int i(float f2) {
        return Float.valueOf(f2).hashCode();
    }

    public static int j(float[] fArr, float f2) {
        return k(fArr, f2, 0, fArr.length);
    }

    /* access modifiers changed from: private */
    public static int k(float[] fArr, float f2, int i2, int i3) {
        while (i2 < i3) {
            if (fArr[i2] == f2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int l(float[] fArr, float[] fArr2) {
        Preconditions.F(fArr, "array");
        Preconditions.F(fArr2, TypedValues.AttributesType.M);
        if (fArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (fArr.length - fArr2.length) + 1) {
            int i3 = 0;
            while (i3 < fArr2.length) {
                if (fArr[i2 + i3] != fArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static boolean m(float f2) {
        return Float.NEGATIVE_INFINITY < f2 && f2 < Float.POSITIVE_INFINITY;
    }

    public static String n(String str, float... fArr) {
        Preconditions.E(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i2 = 1; i2 < fArr.length; i2++) {
            sb.append(str);
            sb.append(fArr[i2]);
        }
        return sb.toString();
    }

    public static int o(float[] fArr, float f2) {
        return p(fArr, f2, 0, fArr.length);
    }

    /* access modifiers changed from: private */
    public static int p(float[] fArr, float f2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (fArr[i4] == f2) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<float[]> q() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float r(float... fArr) {
        Preconditions.d(fArr.length > 0);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < fArr.length; i2++) {
            f2 = Math.max(f2, fArr[i2]);
        }
        return f2;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float s(float... fArr) {
        Preconditions.d(fArr.length > 0);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < fArr.length; i2++) {
            f2 = Math.min(f2, fArr[i2]);
        }
        return f2;
    }

    public static void t(float[] fArr) {
        Preconditions.E(fArr);
        u(fArr, 0, fArr.length);
    }

    public static void u(float[] fArr, int i2, int i3) {
        Preconditions.E(fArr);
        Preconditions.f0(i2, i3, fArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[i4];
            fArr[i4] = f2;
            i2++;
        }
    }

    public static void v(float[] fArr, int i2) {
        w(fArr, i2, 0, fArr.length);
    }

    public static void w(float[] fArr, int i2, int i3, int i4) {
        Preconditions.E(fArr);
        Preconditions.f0(i3, i4, fArr.length);
        if (fArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                u(fArr, i3, i7);
                u(fArr, i7, i4);
                u(fArr, i3, i4);
            }
        }
    }

    public static void x(float[] fArr) {
        Preconditions.E(fArr);
        y(fArr, 0, fArr.length);
    }

    public static void y(float[] fArr, int i2, int i3) {
        Preconditions.E(fArr);
        Preconditions.f0(i2, i3, fArr.length);
        Arrays.sort(fArr, i2, i3);
        u(fArr, i2, i3);
    }

    public static Converter<String, Float> z() {
        return FloatConverter.Y;
    }
}
