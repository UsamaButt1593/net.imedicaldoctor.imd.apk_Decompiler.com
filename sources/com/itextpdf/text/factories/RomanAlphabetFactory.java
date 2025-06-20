package com.itextpdf.text.factories;

import com.itextpdf.text.error_messages.MessageLocalization;

public class RomanAlphabetFactory {
    public static final String a(int i2) {
        return b(i2);
    }

    public static final String b(int i2) {
        int i3 = 0;
        int i4 = 1;
        if (i2 >= 1) {
            int i5 = i2 - 1;
            int i6 = 26;
            while (true) {
                int i7 = i6 + i3;
                if (i5 < i7) {
                    break;
                }
                i4++;
                i6 *= 26;
                i3 = i7;
            }
            int i8 = i5 - i3;
            char[] cArr = new char[i4];
            while (i4 > 0) {
                i4--;
                cArr[i4] = (char) ((i8 % 26) + 97);
                i8 /= 26;
            }
            return new String(cArr);
        }
        throw new NumberFormatException(MessageLocalization.b("you.can.t.translate.a.negative.number.into.an.alphabetical.value", new Object[0]));
    }

    public static final String c(int i2, boolean z) {
        return z ? a(i2) : d(i2);
    }

    public static final String d(int i2) {
        return b(i2).toUpperCase();
    }
}
