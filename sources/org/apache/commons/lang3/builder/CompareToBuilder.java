package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i2 = 0; i2 < declaredFields.length && compareToBuilder.comparison == 0; i2++) {
            Field field = declaredFields[i2];
            if (!ArrayUtils.contains((Object[]) strArr, (Object) field.getName()) && field.getName().indexOf(36) == -1 && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, new String[0]);
    }

    public CompareToBuilder append(byte b2, byte b3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = b2 < b3 ? -1 : b2 > b3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder appendSuper(int i2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i2;
        return this;
    }

    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public CompareToBuilder append(char c2, char c3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = c2 < c3 ? -1 : c2 > c3 ? 1 : 0;
        return this;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z) {
        return reflectionCompare(obj, obj2, z, (Class<?>) null, new String[0]);
    }

    public CompareToBuilder append(double d2, double d3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d2, d3);
        return this;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null || obj2 == null) {
            throw null;
        }
        Class cls2 = obj.getClass();
        if (cls2.isInstance(obj2)) {
            CompareToBuilder compareToBuilder = new CompareToBuilder();
            reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, obj2, cls2, compareToBuilder, z, strArr);
            }
            return compareToBuilder.toComparison();
        }
        throw new ClassCastException();
    }

    public CompareToBuilder append(float f2, float f3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f2, f3);
        return this;
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, (Class<?>) null, strArr);
    }

    public CompareToBuilder append(int i2, int i3) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i2 < i3 ? -1 : i2 > i3 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(long j2, long j3) {
        if (this.comparison != 0) {
            return this;
        }
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        this.comparison = i2 < 0 ? -1 : i2 > 0 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        int i2;
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            i2 = -1;
        } else if (obj2 == null) {
            i2 = 1;
        } else {
            if (!obj.getClass().isArray()) {
                this.comparison = comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
            } else if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
            } else {
                append((Object[]) obj, (Object[]) obj2, comparator);
            }
            return this;
        }
        this.comparison = i2;
        return this;
    }

    public CompareToBuilder append(short s, short s2) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = s < s2 ? -1 : s > s2 ? 1 : 0;
        return this;
    }

    public CompareToBuilder append(boolean z, boolean z2) {
        if (this.comparison != 0 || z == z2) {
            return this;
        }
        this.comparison = !z ? -1 : 1;
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison != 0 || bArr == bArr2) {
            return this;
        }
        int i2 = -1;
        if (bArr == null) {
            this.comparison = -1;
            return this;
        } else if (bArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (bArr.length != bArr2.length) {
            if (bArr.length >= bArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < bArr.length && this.comparison == 0; i3++) {
                append(bArr[i3], bArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison != 0 || cArr == cArr2) {
            return this;
        }
        int i2 = -1;
        if (cArr == null) {
            this.comparison = -1;
            return this;
        } else if (cArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (cArr.length != cArr2.length) {
            if (cArr.length >= cArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < cArr.length && this.comparison == 0; i3++) {
                append(cArr[i3], cArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison != 0 || dArr == dArr2) {
            return this;
        }
        int i2 = -1;
        if (dArr == null) {
            this.comparison = -1;
            return this;
        } else if (dArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (dArr.length != dArr2.length) {
            if (dArr.length >= dArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < dArr.length && this.comparison == 0; i3++) {
                append(dArr[i3], dArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison != 0 || fArr == fArr2) {
            return this;
        }
        int i2 = -1;
        if (fArr == null) {
            this.comparison = -1;
            return this;
        } else if (fArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (fArr.length != fArr2.length) {
            if (fArr.length >= fArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < fArr.length && this.comparison == 0; i3++) {
                append(fArr[i3], fArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison != 0 || iArr == iArr2) {
            return this;
        }
        int i2 = -1;
        if (iArr == null) {
            this.comparison = -1;
            return this;
        } else if (iArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (iArr.length != iArr2.length) {
            if (iArr.length >= iArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < iArr.length && this.comparison == 0; i3++) {
                append(iArr[i3], iArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison != 0 || jArr == jArr2) {
            return this;
        }
        int i2 = -1;
        if (jArr == null) {
            this.comparison = -1;
            return this;
        } else if (jArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (jArr.length != jArr2.length) {
            if (jArr.length >= jArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < jArr.length && this.comparison == 0; i3++) {
                append(jArr[i3], jArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.comparison != 0 || objArr == objArr2) {
            return this;
        }
        int i2 = -1;
        if (objArr == null) {
            this.comparison = -1;
            return this;
        } else if (objArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (objArr.length != objArr2.length) {
            if (objArr.length >= objArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < objArr.length && this.comparison == 0; i3++) {
                append(objArr[i3], objArr2[i3], comparator);
            }
            return this;
        }
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison != 0 || sArr == sArr2) {
            return this;
        }
        int i2 = -1;
        if (sArr == null) {
            this.comparison = -1;
            return this;
        } else if (sArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (sArr.length != sArr2.length) {
            if (sArr.length >= sArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < sArr.length && this.comparison == 0; i3++) {
                append(sArr[i3], sArr2[i3]);
            }
            return this;
        }
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison != 0 || zArr == zArr2) {
            return this;
        }
        int i2 = -1;
        if (zArr == null) {
            this.comparison = -1;
            return this;
        } else if (zArr2 == null) {
            this.comparison = 1;
            return this;
        } else if (zArr.length != zArr2.length) {
            if (zArr.length >= zArr2.length) {
                i2 = 1;
            }
            this.comparison = i2;
            return this;
        } else {
            for (int i3 = 0; i3 < zArr.length && this.comparison == 0; i3++) {
                append(zArr[i3], zArr2[i3]);
            }
            return this;
        }
    }
}
