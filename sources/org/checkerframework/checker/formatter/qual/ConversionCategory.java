package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import n.b;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

public enum ConversionCategory {
    GENERAL("bBhHsS", (int) null),
    CHAR("cC", Character.class, r3, r5, r6),
    INT("doxX", r3, r5, r6, r12, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", r12, Calendar.class, Date.class),
    CHAR_AND_INT((String) null, r3, r5, r6),
    INT_AND_TIME((String) null, r12),
    NULL((String) null, new Class[0]),
    UNUSED((String) null, (int) null);
    
    private static final ConversionCategory[] e3 = null;
    private static final ConversionCategory[] f3 = null;
    private static final ConversionCategory[] g3 = null;
    public final String X;
    public final Class<?>[] s;

    static {
        ConversionCategory conversionCategory;
        ConversionCategory conversionCategory2;
        ConversionCategory conversionCategory3;
        ConversionCategory conversionCategory4;
        ConversionCategory conversionCategory5;
        ConversionCategory conversionCategory6;
        ConversionCategory conversionCategory7;
        ConversionCategory conversionCategory8;
        e3 = new ConversionCategory[]{conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5};
        f3 = new ConversionCategory[]{conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5, conversionCategory6, conversionCategory7, conversionCategory8};
        g3 = new ConversionCategory[]{conversionCategory8, conversionCategory6, conversionCategory7, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5};
    }

    private ConversionCategory(String str, Class<?>... clsArr) {
        this.X = str;
        if (clsArr == null) {
            this.s = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            arrayList.add(cls);
            Class<? extends Object> i2 = i(cls);
            if (i2 != null) {
                arrayList.add(i2);
            }
        }
        this.s = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    private static <E> Set<E> b(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static ConversionCategory c(char c2) {
        for (ConversionCategory conversionCategory : e3) {
            if (conversionCategory.X.contains(String.valueOf(c2))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c2);
    }

    public static ConversionCategory e(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set b2 = b(conversionCategory.s);
        b2.retainAll(b(conversionCategory2.s));
        for (ConversionCategory conversionCategory5 : f3) {
            if (b(conversionCategory5.s).equals(b2)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean g(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return e(conversionCategory, conversionCategory2) == conversionCategory;
    }

    public static ConversionCategory h(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3 || conversionCategory2 == conversionCategory3 || conversionCategory == (conversionCategory3 = GENERAL) || conversionCategory2 == conversionCategory3) {
            return conversionCategory3;
        }
        ConversionCategory conversionCategory4 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory4 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == INT_AND_TIME && conversionCategory2 == conversionCategory4)) {
            return INT;
        }
        Set b2 = b(conversionCategory.s);
        b2.addAll(b(conversionCategory2.s));
        for (ConversionCategory conversionCategory5 : g3) {
            if (b(conversionCategory5.s).equals(b2)) {
                return conversionCategory5;
            }
        }
        return GENERAL;
    }

    private static Class<? extends Object> i(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    public boolean f(Class<?> cls) {
        Class<?>[] clsArr = this.s;
        if (clsArr == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" conversion category");
        Class<?>[] clsArr = this.s;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner a2 = b.a(", ", "(one of: ", ")");
        for (Class<?> simpleName : this.s) {
            StringJoiner unused = a2.add(simpleName.getSimpleName());
        }
        sb.append(StringUtils.SPACE);
        sb.append(a2);
        return sb.toString();
    }
}
