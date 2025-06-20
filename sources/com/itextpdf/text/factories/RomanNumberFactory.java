package com.itextpdf.text.factories;

import com.itextpdf.text.pdf.Barcode128;

public class RomanNumberFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final RomanDigit[] f25740a = {new RomanDigit('m', 1000, false), new RomanDigit(Barcode128.G, 500, false), new RomanDigit(Barcode128.F, 100, true), new RomanDigit('l', 50, false), new RomanDigit('x', 10, true), new RomanDigit('v', 5, false), new RomanDigit(Barcode128.L, 1, true)};

    private static class RomanDigit {

        /* renamed from: a  reason: collision with root package name */
        public char f25741a;

        /* renamed from: b  reason: collision with root package name */
        public int f25742b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f25743c;

        RomanDigit(char c2, int i2, boolean z) {
            this.f25741a = c2;
            this.f25742b = i2;
            this.f25743c = z;
        }
    }

    public static final String a(int i2) {
        return b(i2);
    }

    public static final String b(int i2) {
        RomanDigit[] romanDigitArr;
        RomanDigit romanDigit;
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 < 0) {
            stringBuffer.append('-');
            i2 = -i2;
        }
        if (i2 > 3000) {
            stringBuffer.append('|');
            int i3 = i2 / 1000;
            stringBuffer.append(b(i3));
            stringBuffer.append('|');
            i2 -= i3 * 1000;
        }
        int i4 = 0;
        while (true) {
            RomanDigit romanDigit2 = f25740a[i4];
            while (i2 >= romanDigit2.f25742b) {
                stringBuffer.append(romanDigit2.f25741a);
                i2 -= romanDigit2.f25742b;
            }
            if (i2 <= 0) {
                return stringBuffer.toString();
            }
            int i5 = i4;
            do {
                romanDigitArr = f25740a;
                i5++;
                romanDigit = romanDigitArr[i5];
            } while (!romanDigit.f25743c);
            if (romanDigit.f25742b + i2 >= romanDigit2.f25742b) {
                stringBuffer.append(romanDigit.f25741a);
                stringBuffer.append(romanDigit2.f25741a);
                i2 -= romanDigit2.f25742b - romanDigitArr[i5].f25742b;
            }
            i4++;
        }
    }

    public static final String c(int i2, boolean z) {
        return z ? a(i2) : d(i2);
    }

    public static final String d(int i2) {
        return b(i2).toUpperCase();
    }
}
