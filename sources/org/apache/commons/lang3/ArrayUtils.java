package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.mutable.MutableInt;

public class ArrayUtils {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int INDEX_NOT_FOUND = -1;

    private static Object add(Object obj, int i2, Object obj2, Class<?> cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            if (i2 > length || i2 < 0) {
                throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
            }
            Object newInstance = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance, 0, i2);
            Array.set(newInstance, i2, obj2);
            if (i2 < length) {
                System.arraycopy(obj, i2, newInstance, i2 + 1, length - i2);
            }
            return newInstance;
        } else if (i2 == 0) {
            Object newInstance2 = Array.newInstance(cls, 1);
            Array.set(newInstance2, 0, obj2);
            return newInstance2;
        } else {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: 0");
        }
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static boolean contains(byte[] bArr, byte b2) {
        return indexOf(bArr, b2) != -1;
    }

    private static Object copyArrayGrow1(Object obj, Class<?> cls) {
        if (obj == null) {
            return Array.newInstance(cls, 1);
        }
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        return newInstance;
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static int indexOf(byte[] bArr, byte b2) {
        return indexOf(bArr, b2, 0);
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    @Deprecated
    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 != null && bArr2.length > 0) {
            return false;
        }
        if (bArr2 != null || bArr == null || bArr.length <= 0) {
            return bArr == null || bArr2 == null || bArr.length == bArr2.length;
        }
        return false;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int lastIndexOf(byte[] bArr, byte b2) {
        return lastIndexOf(bArr, b2, Integer.MAX_VALUE);
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? EMPTY_BYTE_ARRAY : bArr;
    }

    private static Object remove(Object obj, int i2) {
        int length = getLength(obj);
        if (i2 < 0 || i2 >= length) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
        }
        int i3 = length - 1;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i3);
        System.arraycopy(obj, 0, newInstance, 0, i2);
        if (i2 < i3) {
            System.arraycopy(obj, i2 + 1, newInstance, i2, (length - i2) - 1);
        }
        return newInstance;
    }

    static Object removeAll(Object obj, BitSet bitSet) {
        int length = getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - bitSet.cardinality());
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i2);
            if (nextSetBit == -1) {
                break;
            }
            int i4 = nextSetBit - i2;
            if (i4 > 0) {
                System.arraycopy(obj, i2, newInstance, i3, i4);
                i3 += i4;
            }
            i2 = bitSet.nextClearBit(nextSetBit);
        }
        int i5 = length - i2;
        if (i5 > 0) {
            System.arraycopy(obj, i2, newInstance, i3, i5);
        }
        return newInstance;
    }

    public static byte[] removeElement(byte[] bArr, byte b2) {
        int indexOf = indexOf(bArr, b2);
        return indexOf == -1 ? clone(bArr) : remove(bArr, indexOf);
    }

    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        if (isEmpty(bArr) || isEmpty(bArr2)) {
            return clone(bArr);
        }
        HashMap hashMap = new HashMap(bArr2.length);
        for (byte valueOf : bArr2) {
            Byte valueOf2 = Byte.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Byte b2 = (Byte) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(bArr, b2.byteValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (byte[]) removeAll((Object) bArr, bitSet);
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            reverse(bArr, 0, bArr.length);
        }
    }

    public static byte[] subarray(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > bArr.length) {
            i3 = bArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }

    public static <T> T[] toArray(T... tArr) {
        return tArr;
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) (((double) objArr.length) * 1.5d));
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Map.Entry entry = objArr[i2];
            if (entry instanceof Map.Entry) {
                Map.Entry entry2 = entry;
                hashMap.put(entry2.getKey(), entry2.getValue());
            } else if (entry instanceof Object[]) {
                Object[] objArr2 = (Object[]) entry;
                if (objArr2.length >= 2) {
                    hashMap.put(objArr2[0], objArr2[1]);
                } else {
                    throw new IllegalArgumentException("Array element " + i2 + ", '" + entry + "', has a length less than 2");
                }
            } else {
                throw new IllegalArgumentException("Array element " + i2 + ", '" + entry + "', is neither of type Map.Entry nor an Array");
            }
        }
        return hashMap;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = zArr[i2] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = bArr[i2].byteValue();
        }
        return bArr2;
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static byte[] add(byte[] bArr, byte b2) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b2;
        return bArr2;
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[(cArr.length + cArr2.length)];
        System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
        System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static boolean contains(char[] cArr, char c2) {
        return indexOf(cArr, c2) != -1;
    }

    public static int indexOf(byte[] bArr, byte b2, int i2) {
        if (bArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < bArr.length) {
            if (b2 == bArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    public static boolean isNotEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        if (cArr == null && cArr2 != null && cArr2.length > 0) {
            return false;
        }
        if (cArr2 != null || cArr == null || cArr.length <= 0) {
            return cArr == null || cArr2 == null || cArr.length == cArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(byte[] bArr, byte b2, int i2) {
        if (bArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= bArr.length) {
            i2 = bArr.length - 1;
        }
        while (i2 >= 0) {
            if (b2 == bArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static char[] nullToEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? EMPTY_CHAR_ARRAY : cArr;
    }

    public static byte[] remove(byte[] bArr, int i2) {
        return (byte[]) remove((Object) bArr, i2);
    }

    static Object removeAll(Object obj, int... iArr) {
        int i2;
        int i3;
        int length = getLength(obj);
        if (isNotEmpty(iArr)) {
            Arrays.sort(iArr);
            int length2 = iArr.length;
            int i4 = length;
            i2 = 0;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                i3 = iArr[length2];
                if (i3 < 0 || i3 >= length) {
                } else if (i3 < i4) {
                    i2++;
                    i4 = i3;
                }
            }
            throw new IndexOutOfBoundsException("Index: " + i3 + ", Length: " + length);
        }
        i2 = 0;
        int i5 = length - i2;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i5);
        if (i2 < length) {
            int length3 = iArr.length - 1;
            while (length3 >= 0) {
                int i6 = iArr[length3];
                int i7 = length - i6;
                if (i7 > 1) {
                    int i8 = i7 - 1;
                    i5 -= i8;
                    System.arraycopy(obj, i6 + 1, newInstance, i5, i8);
                }
                length3--;
                length = i6;
            }
            if (length > 0) {
                System.arraycopy(obj, 0, newInstance, 0, length);
            }
        }
        return newInstance;
    }

    public static char[] removeElement(char[] cArr, char c2) {
        int indexOf = indexOf(cArr, c2);
        return indexOf == -1 ? clone(cArr) : remove(cArr, indexOf);
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        if (isEmpty(cArr) || isEmpty(cArr2)) {
            return clone(cArr);
        }
        HashMap hashMap = new HashMap(cArr2.length);
        for (char valueOf : cArr2) {
            Character valueOf2 = Character.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Character ch = (Character) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(cArr, ch.charValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (char[]) removeAll((Object) cArr, bitSet);
    }

    public static void reverse(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(bArr.length, i3) - 1;
            while (min > i2) {
                byte b2 = bArr[min];
                bArr[min] = bArr[i2];
                bArr[i2] = b2;
                min--;
                i2++;
            }
        }
    }

    public static char[] subarray(char[] cArr, int i2, int i3) {
        if (cArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > cArr.length) {
            i3 = cArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr2 = new char[i4];
        System.arraycopy(cArr, i2, cArr2, 0, i4);
        return cArr2;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b2) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            Byte b3 = bArr[i2];
            bArr2[i2] = b3 == null ? b2 : b3.byteValue();
        }
        return bArr2;
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static byte[] add(byte[] bArr, int i2, byte b2) {
        return (byte[]) add(bArr, i2, Byte.valueOf(b2), Byte.TYPE);
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[(dArr.length + dArr2.length)];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static boolean contains(double[] dArr, double d2) {
        return indexOf(dArr, d2) != -1;
    }

    public static int indexOf(char[] cArr, char c2) {
        return indexOf(cArr, c2, 0);
    }

    public static boolean isEmpty(double[] dArr) {
        return dArr == null || dArr.length == 0;
    }

    public static boolean isNotEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        if (dArr == null && dArr2 != null && dArr2.length > 0) {
            return false;
        }
        if (dArr2 != null || dArr == null || dArr.length <= 0) {
            return dArr == null || dArr2 == null || dArr.length == dArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(char[] cArr, char c2) {
        return lastIndexOf(cArr, c2, Integer.MAX_VALUE);
    }

    public static double[] nullToEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? EMPTY_DOUBLE_ARRAY : dArr;
    }

    public static char[] remove(char[] cArr, int i2) {
        return (char[]) remove((Object) cArr, i2);
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        return (byte[]) removeAll((Object) bArr, clone(iArr));
    }

    public static double[] removeElement(double[] dArr, double d2) {
        int indexOf = indexOf(dArr, d2);
        return indexOf == -1 ? clone(dArr) : remove(dArr, indexOf);
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        if (isEmpty(dArr) || isEmpty(dArr2)) {
            return clone(dArr);
        }
        HashMap hashMap = new HashMap(dArr2.length);
        for (double valueOf : dArr2) {
            Double valueOf2 = Double.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Double d2 = (Double) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(dArr, d2.doubleValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (double[]) removeAll((Object) dArr, bitSet);
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            reverse(cArr, 0, cArr.length);
        }
    }

    public static double[] subarray(double[] dArr, int i2, int i3) {
        if (dArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > dArr.length) {
            i3 = dArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[i4];
        System.arraycopy(dArr, i2, dArr2, 0, i4);
        return dArr2;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i2 = 0; i2 < chArr.length; i2++) {
            cArr[i2] = chArr[i2].charValue();
        }
        return cArr;
    }

    public static char[] add(char[] cArr, char c2) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c2;
        return cArr2;
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[(fArr.length + fArr2.length)];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static boolean contains(double[] dArr, double d2, double d3) {
        return indexOf(dArr, d2, 0, d3) != -1;
    }

    public static int indexOf(char[] cArr, char c2, int i2) {
        if (cArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < cArr.length) {
            if (c2 == cArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean isEmpty(float[] fArr) {
        return fArr == null || fArr.length == 0;
    }

    public static boolean isNotEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        if (fArr == null && fArr2 != null && fArr2.length > 0) {
            return false;
        }
        if (fArr2 != null || fArr == null || fArr.length <= 0) {
            return fArr == null || fArr2 == null || fArr.length == fArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(char[] cArr, char c2, int i2) {
        if (cArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= cArr.length) {
            i2 = cArr.length - 1;
        }
        while (i2 >= 0) {
            if (c2 == cArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static float[] nullToEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? EMPTY_FLOAT_ARRAY : fArr;
    }

    public static double[] remove(double[] dArr, int i2) {
        return (double[]) remove((Object) dArr, i2);
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        return (char[]) removeAll((Object) cArr, clone(iArr));
    }

    public static float[] removeElement(float[] fArr, float f2) {
        int indexOf = indexOf(fArr, f2);
        return indexOf == -1 ? clone(fArr) : remove(fArr, indexOf);
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        if (isEmpty(fArr) || isEmpty(fArr2)) {
            return clone(fArr);
        }
        HashMap hashMap = new HashMap(fArr2.length);
        for (float valueOf : fArr2) {
            Float valueOf2 = Float.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Float f2 = (Float) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(fArr, f2.floatValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (float[]) removeAll((Object) fArr, bitSet);
    }

    public static void reverse(char[] cArr, int i2, int i3) {
        if (cArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(cArr.length, i3) - 1;
            while (min > i2) {
                char c2 = cArr[min];
                cArr[min] = cArr[i2];
                cArr[i2] = c2;
                min--;
                i2++;
            }
        }
    }

    public static float[] subarray(float[] fArr, int i2, int i3) {
        if (fArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > fArr.length) {
            i3 = fArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, i4);
        return fArr2;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static char[] toPrimitive(Character[] chArr, char c2) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i2 = 0; i2 < chArr.length; i2++) {
            Character ch = chArr[i2];
            cArr[i2] = ch == null ? c2 : ch.charValue();
        }
        return cArr;
    }

    public static char[] add(char[] cArr, int i2, char c2) {
        return (char[]) add(cArr, i2, Character.valueOf(c2), Character.TYPE);
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static boolean contains(float[] fArr, float f2) {
        return indexOf(fArr, f2) != -1;
    }

    public static int indexOf(double[] dArr, double d2) {
        return indexOf(dArr, d2, 0);
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean isNotEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        if (iArr == null && iArr2 != null && iArr2.length > 0) {
            return false;
        }
        if (iArr2 != null || iArr == null || iArr.length <= 0) {
            return iArr == null || iArr2 == null || iArr.length == iArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(double[] dArr, double d2) {
        return lastIndexOf(dArr, d2, Integer.MAX_VALUE);
    }

    public static int[] nullToEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? EMPTY_INT_ARRAY : iArr;
    }

    public static float[] remove(float[] fArr, int i2) {
        return (float[]) remove((Object) fArr, i2);
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        return (double[]) removeAll((Object) dArr, clone(iArr));
    }

    public static int[] removeElement(int[] iArr, int i2) {
        int indexOf = indexOf(iArr, i2);
        return indexOf == -1 ? clone(iArr) : remove(iArr, indexOf);
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        if (isEmpty(iArr) || isEmpty(iArr2)) {
            return clone(iArr);
        }
        HashMap hashMap = new HashMap(iArr2.length);
        for (int valueOf : iArr2) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(iArr, num.intValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (int[]) removeAll((Object) iArr, bitSet);
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            reverse(dArr, 0, dArr.length);
        }
    }

    public static int[] subarray(int[] iArr, int i2, int i3) {
        if (iArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > iArr.length) {
            i3 = iArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr2 = new int[i4];
        System.arraycopy(iArr, i2, iArr2, 0, i4);
        return iArr2;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = dArr[i2].doubleValue();
        }
        return dArr2;
    }

    public static double[] add(double[] dArr, double d2) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d2;
        return dArr2;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[(jArr.length + jArr2.length)];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static boolean contains(int[] iArr, int i2) {
        return indexOf(iArr, i2) != -1;
    }

    public static int indexOf(double[] dArr, double d2, double d3) {
        return indexOf(dArr, d2, 0, d3);
    }

    public static boolean isEmpty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static boolean isNotEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        if (jArr == null && jArr2 != null && jArr2.length > 0) {
            return false;
        }
        if (jArr2 != null || jArr == null || jArr.length <= 0) {
            return jArr == null || jArr2 == null || jArr.length == jArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(double[] dArr, double d2, double d3) {
        return lastIndexOf(dArr, d2, Integer.MAX_VALUE, d3);
    }

    public static long[] nullToEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? EMPTY_LONG_ARRAY : jArr;
    }

    public static int[] remove(int[] iArr, int i2) {
        return (int[]) remove((Object) iArr, i2);
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        return (float[]) removeAll((Object) fArr, clone(iArr));
    }

    public static long[] removeElement(long[] jArr, long j2) {
        int indexOf = indexOf(jArr, j2);
        return indexOf == -1 ? clone(jArr) : remove(jArr, indexOf);
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        if (isEmpty(jArr) || isEmpty(jArr2)) {
            return clone(jArr);
        }
        HashMap hashMap = new HashMap(jArr2.length);
        for (long valueOf : jArr2) {
            Long valueOf2 = Long.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Long l2 = (Long) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(jArr, l2.longValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (long[]) removeAll((Object) jArr, bitSet);
    }

    public static void reverse(double[] dArr, int i2, int i3) {
        if (dArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(dArr.length, i3) - 1;
            while (min > i2) {
                double d2 = dArr[min];
                dArr[min] = dArr[i2];
                dArr[i2] = d2;
                min--;
                i2++;
            }
        }
    }

    public static long[] subarray(long[] jArr, int i2, int i3) {
        if (jArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > jArr.length) {
            i3 = jArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr2 = new long[i4];
        System.arraycopy(jArr, i2, jArr2, 0, i4);
        return jArr2;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    public static double[] toPrimitive(Double[] dArr, double d2) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            Double d3 = dArr[i2];
            dArr2[i2] = d3 == null ? d2 : d3.doubleValue();
        }
        return dArr2;
    }

    public static double[] add(double[] dArr, int i2, double d2) {
        return (double[]) add(dArr, i2, Double.valueOf(d2), Double.TYPE);
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return clone(tArr2);
        }
        if (tArr2 == null) {
            return clone(tArr);
        }
        Class<?> componentType = tArr.getClass().getComponentType();
        T[] tArr3 = (Object[]) Array.newInstance(componentType, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e2) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e2);
            }
            throw e2;
        }
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (Object[]) tArr.clone();
    }

    public static boolean contains(long[] jArr, long j2) {
        return indexOf(jArr, j2) != -1;
    }

    public static int indexOf(double[] dArr, double d2, int i2) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < dArr.length) {
            if (d2 == dArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return (tArr == null || tArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2) {
        if (isEmpty(dArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= dArr.length) {
            i2 = dArr.length - 1;
        }
        while (i2 >= 0) {
            if (d2 == dArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        return (boolArr == null || boolArr.length == 0) ? EMPTY_BOOLEAN_OBJECT_ARRAY : boolArr;
    }

    public static long[] remove(long[] jArr, int i2) {
        return (long[]) remove((Object) jArr, i2);
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        return (int[]) removeAll((Object) iArr, clone(iArr2));
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        int indexOf = indexOf((Object[]) tArr, obj);
        return indexOf == -1 ? clone(tArr) : remove(tArr, indexOf);
    }

    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        if (isEmpty((Object[]) tArr) || isEmpty((Object[]) tArr2)) {
            return clone(tArr);
        }
        HashMap hashMap = new HashMap(tArr2.length);
        for (T t : tArr2) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t);
            if (mutableInt == null) {
                hashMap.put(t, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf((Object[]) tArr, key, i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (Object[]) removeAll((Object) tArr, bitSet);
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            reverse(fArr, 0, fArr.length);
        }
    }

    public static <T> T[] subarray(T[] tArr, int i2, int i3) {
        if (tArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > tArr.length) {
            i3 = tArr.length;
        }
        int i4 = i3 - i2;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (i4 <= 0) {
            return (Object[]) Array.newInstance(componentType, 0);
        }
        T[] tArr2 = (Object[]) Array.newInstance(componentType, i4);
        System.arraycopy(tArr, i2, tArr2, 0, i4);
        return tArr2;
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        return fArr2;
    }

    public static float[] add(float[] fArr, float f2) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f2;
        return fArr2;
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[(sArr.length + sArr2.length)];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(double[] dArr, double d2, int i2, double d3) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        while (i2 < dArr.length) {
            double d6 = dArr[i2];
            if (d6 >= d4 && d6 <= d5) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean isEmpty(short[] sArr) {
        return sArr == null || sArr.length == 0;
    }

    public static boolean isNotEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        if (sArr == null && sArr2 != null && sArr2.length > 0) {
            return false;
        }
        if (sArr2 != null || sArr == null || sArr.length <= 0) {
            return sArr == null || sArr2 == null || sArr.length == sArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2, double d3) {
        if (isEmpty(dArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= dArr.length) {
            i2 = dArr.length - 1;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        while (i2 >= 0) {
            double d6 = dArr[i2];
            if (d6 >= d4 && d6 <= d5) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? EMPTY_BYTE_OBJECT_ARRAY : bArr;
    }

    public static <T> T[] remove(T[] tArr, int i2) {
        return (Object[]) remove((Object) tArr, i2);
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        return (long[]) removeAll((Object) jArr, clone(iArr));
    }

    public static short[] removeElement(short[] sArr, short s) {
        int indexOf = indexOf(sArr, s);
        return indexOf == -1 ? clone(sArr) : remove(sArr, indexOf);
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        if (isEmpty(sArr) || isEmpty(sArr2)) {
            return clone(sArr);
        }
        HashMap hashMap = new HashMap(sArr2.length);
        for (short valueOf : sArr2) {
            Short valueOf2 = Short.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Short sh = (Short) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(sArr, sh.shortValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (short[]) removeAll((Object) sArr, bitSet);
    }

    public static void reverse(float[] fArr, int i2, int i3) {
        if (fArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(fArr.length, i3) - 1;
            while (min > i2) {
                float f2 = fArr[min];
                fArr[min] = fArr[i2];
                fArr[i2] = f2;
                min--;
                i2++;
            }
        }
    }

    public static short[] subarray(short[] sArr, int i2, int i3) {
        if (sArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > sArr.length) {
            i3 = sArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr2 = new short[i4];
        System.arraycopy(sArr, i2, sArr2, 0, i4);
        return sArr2;
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }

    public static float[] toPrimitive(Float[] fArr, float f2) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            Float f3 = fArr[i2];
            fArr2[i2] = f3 == null ? f2 : f3.floatValue();
        }
        return fArr2;
    }

    public static float[] add(float[] fArr, int i2, float f2) {
        return (float[]) add(fArr, i2, Float.valueOf(f2), Float.TYPE);
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[(zArr.length + zArr2.length)];
        System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
        System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static int indexOf(float[] fArr, float f2) {
        return indexOf(fArr, f2, 0);
    }

    public static boolean isEmpty(boolean[] zArr) {
        return zArr == null || zArr.length == 0;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        if (zArr == null && zArr2 != null && zArr2.length > 0) {
            return false;
        }
        if (zArr2 != null || zArr == null || zArr.length <= 0) {
            return zArr == null || zArr2 == null || zArr.length == zArr2.length;
        }
        return false;
    }

    public static int lastIndexOf(float[] fArr, float f2) {
        return lastIndexOf(fArr, f2, Integer.MAX_VALUE);
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        return (chArr == null || chArr.length == 0) ? EMPTY_CHARACTER_OBJECT_ARRAY : chArr;
    }

    public static short[] remove(short[] sArr, int i2) {
        return (short[]) remove((Object) sArr, i2);
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        return (Object[]) removeAll((Object) tArr, clone(iArr));
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        int indexOf = indexOf(zArr, z);
        return indexOf == -1 ? clone(zArr) : remove(zArr, indexOf);
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        if (isEmpty(zArr) || isEmpty(zArr2)) {
            return clone(zArr);
        }
        HashMap hashMap = new HashMap(2);
        for (boolean valueOf : zArr2) {
            Boolean valueOf2 = Boolean.valueOf(valueOf);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf2);
            if (mutableInt == null) {
                hashMap.put(valueOf2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        BitSet bitSet = new BitSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Boolean bool = (Boolean) entry.getKey();
            int intValue = ((MutableInt) entry.getValue()).intValue();
            int i2 = 0;
            int i3 = 0;
            while (i2 < intValue) {
                int indexOf = indexOf(zArr, bool.booleanValue(), i3);
                if (indexOf < 0) {
                    break;
                }
                bitSet.set(indexOf);
                i2++;
                i3 = indexOf + 1;
            }
        }
        return (boolean[]) removeAll((Object) zArr, bitSet);
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            reverse(iArr, 0, iArr.length);
        }
    }

    public static boolean[] subarray(boolean[] zArr, int i2, int i3) {
        if (zArr == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > zArr.length) {
            i3 = zArr.length;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr2 = new boolean[i4];
        System.arraycopy(zArr, i2, zArr2, 0, i4);
        return zArr2;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public static int[] add(int[] iArr, int i2) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i2;
        return iArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    public static int indexOf(float[] fArr, float f2, int i2) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < fArr.length) {
            if (f2 == fArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArr, float f2, int i2) {
        if (isEmpty(fArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= fArr.length) {
            i2 = fArr.length - 1;
        }
        while (i2 >= 0) {
            if (f2 == fArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? EMPTY_CLASS_ARRAY : clsArr;
    }

    public static boolean[] remove(boolean[] zArr, int i2) {
        return (boolean[]) remove((Object) zArr, i2);
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        return (short[]) removeAll((Object) sArr, clone(iArr));
    }

    public static void reverse(int[] iArr, int i2, int i3) {
        if (iArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(iArr.length, i3) - 1;
            while (min > i2) {
                int i4 = iArr[min];
                iArr[min] = iArr[i2];
                iArr[i2] = i4;
                min--;
                i2++;
            }
        }
    }

    public static int[] toPrimitive(Integer[] numArr, int i2) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            Integer num = numArr[i3];
            iArr[i3] = num == null ? i2 : num.intValue();
        }
        return iArr;
    }

    public static int[] add(int[] iArr, int i2, int i3) {
        return (int[]) add(iArr, i2, Integer.valueOf(i3), Integer.TYPE);
    }

    public static int indexOf(int[] iArr, int i2) {
        return indexOf(iArr, i2, 0);
    }

    public static int lastIndexOf(int[] iArr, int i2) {
        return lastIndexOf(iArr, i2, Integer.MAX_VALUE);
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        return (dArr == null || dArr.length == 0) ? EMPTY_DOUBLE_OBJECT_ARRAY : dArr;
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        return (boolean[]) removeAll((Object) zArr, clone(iArr));
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            reverse(jArr, 0, jArr.length);
        }
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i2 = 0; i2 < lArr.length; i2++) {
            jArr[i2] = lArr[i2].longValue();
        }
        return jArr;
    }

    public static long[] add(long[] jArr, int i2, long j2) {
        return (long[]) add(jArr, i2, Long.valueOf(j2), Long.TYPE);
    }

    public static int indexOf(int[] iArr, int i2, int i3) {
        if (iArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < iArr.length) {
            if (i2 == iArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i2, int i3) {
        if (iArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= iArr.length) {
            i3 = iArr.length - 1;
        }
        while (i3 >= 0) {
            if (i2 == iArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        return (fArr == null || fArr.length == 0) ? EMPTY_FLOAT_OBJECT_ARRAY : fArr;
    }

    public static void reverse(long[] jArr, int i2, int i3) {
        if (jArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(jArr.length, i3) - 1;
            while (min > i2) {
                long j2 = jArr[min];
                jArr[min] = jArr[i2];
                jArr[i2] = j2;
                min--;
                i2++;
            }
        }
    }

    public static long[] toPrimitive(Long[] lArr, long j2) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i2 = 0; i2 < lArr.length; i2++) {
            Long l2 = lArr[i2];
            jArr[i2] = l2 == null ? j2 : l2.longValue();
        }
        return jArr;
    }

    public static long[] add(long[] jArr, long j2) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j2;
        return jArr2;
    }

    public static int indexOf(long[] jArr, long j2) {
        return indexOf(jArr, j2, 0);
    }

    public static int lastIndexOf(long[] jArr, long j2) {
        return lastIndexOf(jArr, j2, Integer.MAX_VALUE);
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        return (numArr == null || numArr.length == 0) ? EMPTY_INTEGER_OBJECT_ARRAY : numArr;
    }

    public static void reverse(Object[] objArr) {
        if (objArr != null) {
            reverse(objArr, 0, objArr.length);
        }
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i2 = 0; i2 < shArr.length; i2++) {
            sArr[i2] = shArr[i2].shortValue();
        }
        return sArr;
    }

    public static <T> T[] add(T[] tArr, int i2, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t != null) {
            cls = t.getClass();
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        return (Object[]) add(tArr, i2, t, cls);
    }

    public static int indexOf(long[] jArr, long j2, int i2) {
        if (jArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < jArr.length) {
            if (j2 == jArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j2, int i2) {
        if (jArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= jArr.length) {
            i2 = jArr.length - 1;
        }
        while (i2 >= 0) {
            if (j2 == jArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        return (lArr == null || lArr.length == 0) ? EMPTY_LONG_OBJECT_ARRAY : lArr;
    }

    public static void reverse(Object[] objArr, int i2, int i3) {
        if (objArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(objArr.length, i3) - 1;
            while (min > i2) {
                Object obj = objArr[min];
                objArr[min] = objArr[i2];
                objArr[i2] = obj;
                min--;
                i2++;
            }
        }
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i2 = 0; i2 < shArr.length; i2++) {
            Short sh = shArr[i2];
            sArr[i2] = sh == null ? s : sh.shortValue();
        }
        return sArr;
    }

    public static <T> T[] add(T[] tArr, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else if (t != null) {
            cls = t.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        T[] tArr2 = (Object[]) copyArrayGrow1(tArr, cls);
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            reverse(sArr, 0, sArr.length);
        }
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i2 = 0; i2 < boolArr.length; i2++) {
            zArr[i2] = boolArr[i2].booleanValue();
        }
        return zArr;
    }

    public static short[] add(short[] sArr, int i2, short s) {
        return (short[]) add(sArr, i2, Short.valueOf(s), Short.TYPE);
    }

    public static int indexOf(Object[] objArr, Object obj, int i2) {
        if (objArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (obj == null) {
            while (i2 < objArr.length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i2 < objArr.length) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i2) {
        if (objArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= objArr.length) {
            i2 = objArr.length - 1;
        }
        if (obj == null) {
            while (i2 >= 0) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i2 >= 0) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        return (shArr == null || shArr.length == 0) ? EMPTY_SHORT_OBJECT_ARRAY : shArr;
    }

    public static void reverse(short[] sArr, int i2, int i3) {
        if (sArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(sArr.length, i3) - 1;
            while (min > i2) {
                short s = sArr[min];
                sArr[min] = sArr[i2];
                sArr[i2] = s;
                min--;
                i2++;
            }
        }
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i2 = 0; i2 < boolArr.length; i2++) {
            Boolean bool = boolArr[i2];
            zArr[i2] = bool == null ? z : bool.booleanValue();
        }
        return zArr;
    }

    public static short[] add(short[] sArr, short s) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s;
        return sArr2;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, Integer.MAX_VALUE);
    }

    public static String[] nullToEmpty(String[] strArr) {
        return (strArr == null || strArr.length == 0) ? EMPTY_STRING_ARRAY : strArr;
    }

    public static void reverse(boolean[] zArr) {
        if (zArr != null) {
            reverse(zArr, 0, zArr.length);
        }
    }

    public static boolean[] add(boolean[] zArr, int i2, boolean z) {
        return (boolean[]) add(zArr, i2, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static int indexOf(short[] sArr, short s, int i2) {
        if (sArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < sArr.length) {
            if (s == sArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s, int i2) {
        if (sArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= sArr.length) {
            i2 = sArr.length - 1;
        }
        while (i2 >= 0) {
            if (s == sArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static short[] nullToEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? EMPTY_SHORT_ARRAY : sArr;
    }

    public static void reverse(boolean[] zArr, int i2, int i3) {
        if (zArr != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int min = Math.min(zArr.length, i3) - 1;
            while (min > i2) {
                boolean z = zArr[min];
                zArr[min] = zArr[i2];
                zArr[i2] = z;
                min--;
                i2++;
            }
        }
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z;
        return zArr2;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, Integer.MAX_VALUE);
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? EMPTY_BOOLEAN_ARRAY : zArr;
    }

    public static int indexOf(boolean[] zArr, boolean z, int i2) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < zArr.length) {
            if (z == zArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i2) {
        if (isEmpty(zArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= zArr.length) {
            i2 = zArr.length - 1;
        }
        while (i2 >= 0) {
            if (z == zArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }
}
