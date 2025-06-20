package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    public static void exclusiveBetween(double d2, double d3, double d4) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)}));
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)}));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, new Object[]{cls2 == null ? "null" : cls2.getName(), cls.getName()}));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, new Object[]{cls.getName(), obj == null ? "null" : obj.getClass().getName()}));
        }
    }

    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, new Object[]{charSequence, str}));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t) {
        return noNullElements(t, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T notBlank(T t) {
        return notBlank(t, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T notEmpty(T t) {
        return notEmpty(t, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }

    public static <T> T notNull(T t) {
        return notNull(t, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T validIndex(T t, int i2) {
        return validIndex(t, i2, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i2));
    }

    public static void validState(boolean z) {
        if (!z) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void exclusiveBetween(double d2, double d3, double d4, String str) {
        if (d4 <= d2 || d4 >= d3) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(double d2, double d3, double d4, String str) {
        if (d4 < d2 || d4 > d3) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z, String str, double d2) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, new Object[]{Double.valueOf(d2)}));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t, String str, Object... objArr) {
        notNull(t);
        int i2 = 0;
        for (Object obj : t) {
            if (obj != null) {
                i2++;
            } else {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll((T[]) objArr, (T[]) new Object[]{Integer.valueOf(i2)})));
            }
        }
        return t;
    }

    public static <T extends CharSequence> T notBlank(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!StringUtils.isBlank(t)) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (t.length() != 0) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T notNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T validIndex(T t, int i2, String str, Object... objArr) {
        notNull(t);
        if (i2 >= 0 && i2 < t.length()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static void validState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void exclusiveBetween(long j2, long j3, long j4) {
        if (j4 <= j2 || j4 >= j3) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static void inclusiveBetween(long j2, long j3, long j4) {
        if (j4 < j2 || j4 > j3) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static void isTrue(boolean z, String str, long j2) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, new Object[]{Long.valueOf(j2)}));
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return noNullElements(tArr, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T notEmpty(T t) {
        return notEmpty(t, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T validIndex(T t, int i2) {
        return validIndex(t, i2, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i2));
    }

    public static void exclusiveBetween(long j2, long j3, long j4, String str) {
        if (j4 <= j2 || j4 >= j3) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void inclusiveBetween(long j2, long j3, long j4, String str) {
        if (j4 < j2 || j4 > j3) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }

    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        int i2 = 0;
        while (i2 < tArr.length) {
            if (tArr[i2] != null) {
                i2++;
            } else {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((T[]) objArr, Integer.valueOf(i2))));
            }
        }
        return tArr;
    }

    public static <T extends Collection<?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!t.isEmpty()) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T validIndex(T t, int i2, String str, Object... objArr) {
        notNull(t);
        if (i2 >= 0 && i2 < t.size()) {
            return t;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{comparable, t, t2}));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, new Object[]{comparable, t, t2}));
        }
    }

    public static <T extends Map<?, ?>> T notEmpty(T t) {
        return notEmpty(t, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i2) {
        return validIndex(tArr, i2, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i2));
    }

    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Map<?, ?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (!t.isEmpty()) {
            return t;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T[] validIndex(T[] tArr, int i2, String str, Object... objArr) {
        notNull(tArr);
        if (i2 >= 0 && i2 < tArr.length) {
            return tArr;
        }
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr == null) {
            throw new NullPointerException(String.format(str, objArr));
        } else if (tArr.length != 0) {
            return tArr;
        } else {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
