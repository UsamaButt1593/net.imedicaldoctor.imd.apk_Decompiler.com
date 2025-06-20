package com.itextpdf.text.factories;

import com.itextpdf.text.SpecialSymbol;

public class GreekAlphabetFactory {
    public static final String a(int i2) {
        return b(i2);
    }

    public static final String b(int i2) {
        return c(i2, true);
    }

    public static final String c(int i2, boolean z) {
        int i3 = 1;
        if (i2 < 1) {
            return "";
        }
        int i4 = i2 - 1;
        int i5 = 24;
        int i6 = 0;
        while (true) {
            int i7 = i5 + i6;
            if (i4 < i7) {
                break;
            }
            i3++;
            i5 *= 24;
            i6 = i7;
        }
        int i8 = i4 - i6;
        char[] cArr = new char[i3];
        while (i3 > 0) {
            i3--;
            char c2 = (char) (i8 % 24);
            cArr[i3] = c2;
            if (c2 > 16) {
                cArr[i3] = (char) (c2 + 1);
            }
            char c3 = (char) (cArr[i3] + (z ? (char) 945 : 913));
            cArr[i3] = c3;
            cArr[i3] = SpecialSymbol.b(c3);
            i8 /= 24;
        }
        return String.valueOf(cArr);
    }

    public static final String d(int i2) {
        return b(i2).toUpperCase();
    }
}
