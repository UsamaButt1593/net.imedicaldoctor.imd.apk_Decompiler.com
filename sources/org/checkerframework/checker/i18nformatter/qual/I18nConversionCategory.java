package org.checkerframework.checker.i18nformatter.qual;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import n.b;

public enum I18nConversionCategory {
    UNUSED((String) null, (int) null),
    GENERAL((String) null, (int) null),
    DATE(new Class[]{Date.class, r1}, new String[]{DublinCoreProperties.f27398d, HTML.Tag.P0}),
    NUMBER(new Class[]{r1}, new String[]{"number", "choice"});
    
    private static final I18nConversionCategory[] Z2 = null;
    private static final I18nConversionCategory[] a3 = null;
    public final String[] X;
    public final Class<?>[] s;

    static {
        I18nConversionCategory i18nConversionCategory;
        I18nConversionCategory i18nConversionCategory2;
        Z2 = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
        a3 = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    private I18nConversionCategory(Class<?>[] clsArr, String[] strArr) {
        this.s = clsArr;
        this.X = strArr;
    }

    private static <E> Set<E> b(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static I18nConversionCategory c(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        Set b2 = b(i18nConversionCategory.s);
        b2.retainAll(b(i18nConversionCategory2.s));
        for (I18nConversionCategory i18nConversionCategory5 : a3) {
            if (b(i18nConversionCategory5.s).equals(b2)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean f(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return c(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    public static I18nConversionCategory g(String str) {
        String lowerCase = str.toLowerCase();
        for (I18nConversionCategory i18nConversionCategory : Z2) {
            for (String equals : i18nConversionCategory.X) {
                if (equals.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = Z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = X2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory h(org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r1, org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r2) {
        /*
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = UNUSED
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0007
            goto L_0x0018
        L_0x0007:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = GENERAL
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r0 = DATE
            if (r1 == r0) goto L_0x0018
            if (r2 != r0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory r1 = NUMBER
            return r1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory.h(org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory, org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory):org.checkerframework.checker.i18nformatter.qual.I18nConversionCategory");
    }

    public boolean e(Class<?> cls) {
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

    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.s == null) {
            sb.append(" conversion category (all types)");
        } else {
            StringJoiner a2 = b.a(", ", " conversion category (one of: ", ")");
            for (Class<?> canonicalName : this.s) {
                StringJoiner unused = a2.add(canonicalName.getCanonicalName());
            }
            sb.append(a2);
        }
        return sb.toString();
    }
}
