package org.threeten.bp.format;

import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class DecimalStyle {

    /* renamed from: e  reason: collision with root package name */
    public static final DecimalStyle f31841e = new DecimalStyle('0', '+', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* renamed from: f  reason: collision with root package name */
    private static final ConcurrentMap<Locale, DecimalStyle> f31842f = new ConcurrentHashMap(16, 0.75f, 2);

    /* renamed from: a  reason: collision with root package name */
    private final char f31843a;

    /* renamed from: b  reason: collision with root package name */
    private final char f31844b;

    /* renamed from: c  reason: collision with root package name */
    private final char f31845c;

    /* renamed from: d  reason: collision with root package name */
    private final char f31846d;

    private DecimalStyle(char c2, char c3, char c4, char c5) {
        this.f31843a = c2;
        this.f31844b = c3;
        this.f31845c = c4;
        this.f31846d = c5;
    }

    private static DecimalStyle c(Locale locale) {
        DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit = instance.getZeroDigit();
        char minusSign = instance.getMinusSign();
        char decimalSeparator = instance.getDecimalSeparator();
        return (zeroDigit == '0' && minusSign == '-' && decimalSeparator == '.') ? f31841e : new DecimalStyle(zeroDigit, '+', minusSign, decimalSeparator);
    }

    public static Set<Locale> d() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static DecimalStyle i(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        ConcurrentMap<Locale, DecimalStyle> concurrentMap = f31842f;
        DecimalStyle decimalStyle = concurrentMap.get(locale);
        if (decimalStyle != null) {
            return decimalStyle;
        }
        concurrentMap.putIfAbsent(locale, c(locale));
        return concurrentMap.get(locale);
    }

    public static DecimalStyle j() {
        return i(Locale.getDefault());
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        char c2 = this.f31843a;
        if (c2 == '0') {
            return str;
        }
        int i2 = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            charArray[i3] = (char) (charArray[i3] + i2);
        }
        return new String(charArray);
    }

    /* access modifiers changed from: package-private */
    public int b(char c2) {
        int i2 = c2 - this.f31843a;
        if (i2 < 0 || i2 > 9) {
            return -1;
        }
        return i2;
    }

    public char e() {
        return this.f31846d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.f31843a == decimalStyle.f31843a && this.f31844b == decimalStyle.f31844b && this.f31845c == decimalStyle.f31845c && this.f31846d == decimalStyle.f31846d;
    }

    public char f() {
        return this.f31845c;
    }

    public char g() {
        return this.f31844b;
    }

    public char h() {
        return this.f31843a;
    }

    public int hashCode() {
        return this.f31843a + this.f31844b + this.f31845c + this.f31846d;
    }

    public DecimalStyle k(char c2) {
        return c2 == this.f31846d ? this : new DecimalStyle(this.f31843a, this.f31844b, this.f31845c, c2);
    }

    public DecimalStyle l(char c2) {
        return c2 == this.f31845c ? this : new DecimalStyle(this.f31843a, this.f31844b, c2, this.f31846d);
    }

    public DecimalStyle m(char c2) {
        return c2 == this.f31844b ? this : new DecimalStyle(this.f31843a, c2, this.f31845c, this.f31846d);
    }

    public DecimalStyle n(char c2) {
        return c2 == this.f31843a ? this : new DecimalStyle(c2, this.f31844b, this.f31845c, this.f31846d);
    }

    public String toString() {
        return "DecimalStyle[" + this.f31843a + this.f31844b + this.f31845c + this.f31846d + "]";
    }
}
