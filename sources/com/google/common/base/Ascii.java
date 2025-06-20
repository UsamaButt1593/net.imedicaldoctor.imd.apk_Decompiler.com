package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Ascii {
    public static final byte A = 23;
    public static final byte B = 24;
    public static final byte C = 25;
    public static final byte D = 26;
    public static final byte E = 27;
    public static final byte F = 28;
    public static final byte G = 29;
    public static final byte H = 30;
    public static final byte I = 31;
    public static final byte J = 32;
    public static final byte K = 32;
    public static final byte L = Byte.MAX_VALUE;
    public static final char M = '\u0000';
    public static final char N = '';
    private static final char O = ' ';

    /* renamed from: a  reason: collision with root package name */
    public static final byte f22239a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final byte f22240b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final byte f22241c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final byte f22242d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final byte f22243e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final byte f22244f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final byte f22245g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final byte f22246h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final byte f22247i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final byte f22248j = 9;

    /* renamed from: k  reason: collision with root package name */
    public static final byte f22249k = 10;

    /* renamed from: l  reason: collision with root package name */
    public static final byte f22250l = 10;

    /* renamed from: m  reason: collision with root package name */
    public static final byte f22251m = 11;

    /* renamed from: n  reason: collision with root package name */
    public static final byte f22252n = 12;
    public static final byte o = 13;
    public static final byte p = 14;
    public static final byte q = 15;
    public static final byte r = 16;
    public static final byte s = 17;
    public static final byte t = 17;
    public static final byte u = 18;
    public static final byte v = 19;
    public static final byte w = 19;
    public static final byte x = 20;
    public static final byte y = 21;
    public static final byte z = 22;

    private Ascii() {
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int b2;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2 && ((b2 = b(charAt)) >= 26 || b2 != b(charAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int b(char c2) {
        return (char) ((c2 | ' ') - 'a');
    }

    public static boolean c(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean d(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static char e(char c2) {
        return d(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String f(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return g((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = e(charSequence.charAt(i2));
        }
        return String.valueOf(cArr);
    }

    public static String g(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (d(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (d(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static char h(char c2) {
        return c(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String i(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return j((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = h(charSequence.charAt(i2));
        }
        return String.valueOf(cArr);
    }

    public static String j(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (c(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (c(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static String k(CharSequence charSequence, int i2, String str) {
        Preconditions.E(charSequence);
        int length = i2 - str.length();
        Preconditions.m(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i2, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i2) {
            String charSequence2 = charSequence.toString();
            int length3 = charSequence2.length();
            str2 = charSequence2;
            if (length3 <= i2) {
                return charSequence2;
            }
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str2, 0, length);
        sb.append(str);
        return sb.toString();
    }
}
