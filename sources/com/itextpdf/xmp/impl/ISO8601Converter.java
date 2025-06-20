package com.itextpdf.xmp.impl;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class ISO8601Converter {
    private ISO8601Converter() {
    }

    public static XMPDateTime a(String str) throws XMPException {
        return b(str, new XMPDateTimeImpl());
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0224 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0225  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.xmp.XMPDateTime b(java.lang.String r12, com.itextpdf.xmp.XMPDateTime r13) throws com.itextpdf.xmp.XMPException {
        /*
            if (r12 == 0) goto L_0x022d
            int r0 = r12.length()
            if (r0 != 0) goto L_0x0009
            return r13
        L_0x0009:
            com.itextpdf.xmp.impl.ParseState r0 = new com.itextpdf.xmp.impl.ParseState
            r0.<init>(r12)
            r12 = 0
            char r1 = r0.b(r12)
            r2 = 45
            if (r1 != r2) goto L_0x001a
            r0.g()
        L_0x001a:
            java.lang.String r1 = "Invalid year in date string"
            r3 = 9999(0x270f, float:1.4012E-41)
            int r1 = r0.c(r1, r3)
            boolean r3 = r0.d()
            r4 = 5
            if (r3 == 0) goto L_0x0038
            char r3 = r0.a()
            if (r3 != r2) goto L_0x0030
            goto L_0x0038
        L_0x0030:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after year"
            r12.<init>(r13, r4)
            throw r12
        L_0x0038:
            char r3 = r0.b(r12)
            if (r3 != r2) goto L_0x003f
            int r1 = -r1
        L_0x003f:
            r13.n0(r1)
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x0049
            return r13
        L_0x0049:
            r0.g()
            java.lang.String r1 = "Invalid month in date string"
            r3 = 12
            int r1 = r0.c(r1, r3)
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0069
            char r3 = r0.a()
            if (r3 != r2) goto L_0x0061
            goto L_0x0069
        L_0x0061:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after month"
            r12.<init>(r13, r4)
            throw r12
        L_0x0069:
            r13.b2(r1)
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x0073
            return r13
        L_0x0073:
            r0.g()
            java.lang.String r1 = "Invalid day in date string"
            r3 = 31
            int r1 = r0.c(r1, r3)
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x0095
            char r3 = r0.a()
            r5 = 84
            if (r3 != r5) goto L_0x008d
            goto L_0x0095
        L_0x008d:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after day"
            r12.<init>(r13, r4)
            throw r12
        L_0x0095:
            r13.E0(r1)
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x009f
            return r13
        L_0x009f:
            r0.g()
            java.lang.String r1 = "Invalid hour in date string"
            r3 = 23
            int r1 = r0.c(r1, r3)
            r13.X(r1)
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x00b4
            return r13
        L_0x00b4:
            char r1 = r0.a()
            r5 = 59
            r6 = 58
            r7 = 43
            r8 = 90
            if (r1 != r6) goto L_0x00f5
            r0.g()
            java.lang.String r1 = "Invalid minute in date string"
            int r1 = r0.c(r1, r5)
            boolean r9 = r0.d()
            if (r9 == 0) goto L_0x00f2
            char r9 = r0.a()
            if (r9 == r6) goto L_0x00f2
            char r9 = r0.a()
            if (r9 == r8) goto L_0x00f2
            char r9 = r0.a()
            if (r9 == r7) goto L_0x00f2
            char r9 = r0.a()
            if (r9 != r2) goto L_0x00ea
            goto L_0x00f2
        L_0x00ea:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after minute"
            r12.<init>(r13, r4)
            throw r12
        L_0x00f2:
            r13.b0(r1)
        L_0x00f5:
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x00fc
            return r13
        L_0x00fc:
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x018d
            char r1 = r0.a()
            if (r1 != r6) goto L_0x018d
            r0.g()
            java.lang.String r1 = "Invalid whole seconds in date string"
            int r1 = r0.c(r1, r5)
            boolean r9 = r0.d()
            r10 = 46
            if (r9 == 0) goto L_0x013a
            char r9 = r0.a()
            if (r9 == r10) goto L_0x013a
            char r9 = r0.a()
            if (r9 == r8) goto L_0x013a
            char r9 = r0.a()
            if (r9 == r7) goto L_0x013a
            char r9 = r0.a()
            if (r9 != r2) goto L_0x0132
            goto L_0x013a
        L_0x0132:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after whole seconds"
            r12.<init>(r13, r4)
            throw r12
        L_0x013a:
            r13.O1(r1)
            char r1 = r0.a()
            if (r1 != r10) goto L_0x01a8
            r0.g()
            int r1 = r0.f()
            java.lang.String r9 = "Invalid fractional seconds in date string"
            r10 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r9 = r0.c(r9, r10)
            boolean r10 = r0.d()
            if (r10 == 0) goto L_0x0174
            char r10 = r0.a()
            if (r10 == r8) goto L_0x0174
            char r10 = r0.a()
            if (r10 == r7) goto L_0x0174
            char r10 = r0.a()
            if (r10 != r2) goto L_0x016c
            goto L_0x0174
        L_0x016c:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after fractional second"
            r12.<init>(r13, r4)
            throw r12
        L_0x0174:
            int r10 = r0.f()
            int r10 = r10 - r1
        L_0x0179:
            r1 = 9
            if (r10 <= r1) goto L_0x0182
            int r9 = r9 / 10
            int r10 = r10 + -1
            goto L_0x0179
        L_0x0182:
            if (r10 >= r1) goto L_0x0189
            int r9 = r9 * 10
            int r10 = r10 + 1
            goto L_0x0182
        L_0x0189:
            r13.H0(r9)
            goto L_0x01a8
        L_0x018d:
            char r1 = r0.a()
            if (r1 == r8) goto L_0x01a8
            char r1 = r0.a()
            if (r1 == r7) goto L_0x01a8
            char r1 = r0.a()
            if (r1 != r2) goto L_0x01a0
            goto L_0x01a8
        L_0x01a0:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after time"
            r12.<init>(r13, r4)
            throw r12
        L_0x01a8:
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x01af
            return r13
        L_0x01af:
            char r1 = r0.a()
            if (r1 != r8) goto L_0x01b9
            r0.g()
            goto L_0x0205
        L_0x01b9:
            boolean r1 = r0.d()
            if (r1 == 0) goto L_0x0205
            char r1 = r0.a()
            if (r1 != r7) goto L_0x01c7
            r1 = 1
            goto L_0x01ce
        L_0x01c7:
            char r1 = r0.a()
            if (r1 != r2) goto L_0x01fd
            r1 = -1
        L_0x01ce:
            r0.g()
            java.lang.String r2 = "Invalid time zone hour in date string"
            int r2 = r0.c(r2, r3)
            boolean r3 = r0.d()
            if (r3 == 0) goto L_0x01f9
            char r12 = r0.a()
            if (r12 != r6) goto L_0x01f1
            r0.g()
            java.lang.String r12 = "Invalid time zone minute in date string"
            int r12 = r0.c(r12, r5)
            r11 = r1
            r1 = r12
            r12 = r2
            r2 = r11
            goto L_0x0207
        L_0x01f1:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, after time zone hour"
            r12.<init>(r13, r4)
            throw r12
        L_0x01f9:
            r12 = r2
            r2 = r1
            r1 = 0
            goto L_0x0207
        L_0x01fd:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Time zone must begin with 'Z', '+', or '-'"
            r12.<init>(r13, r4)
            throw r12
        L_0x0205:
            r1 = 0
            r2 = 0
        L_0x0207:
            r3 = 3600000(0x36ee80, float:5.044674E-39)
            int r12 = r12 * r3
            r3 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 * r3
            int r12 = r12 + r1
            int r12 = r12 * r2
            java.util.SimpleTimeZone r1 = new java.util.SimpleTimeZone
            java.lang.String r2 = ""
            r1.<init>(r12, r2)
            r13.y1(r1)
            boolean r12 = r0.d()
            if (r12 != 0) goto L_0x0225
            return r13
        L_0x0225:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Invalid date string, extra chars at end"
            r12.<init>(r13, r4)
            throw r12
        L_0x022d:
            com.itextpdf.xmp.XMPException r12 = new com.itextpdf.xmp.XMPException
            java.lang.String r13 = "Parameter must not be null"
            r0 = 4
            r12.<init>(r13, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.ISO8601Converter.b(java.lang.String, com.itextpdf.xmp.XMPDateTime):com.itextpdf.xmp.XMPDateTime");
    }

    public static String c(XMPDateTime xMPDateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        if (xMPDateTime.g2()) {
            DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
            stringBuffer.append(decimalFormat.format((long) xMPDateTime.M0()));
            if (xMPDateTime.W0() == 0) {
                return stringBuffer.toString();
            }
            decimalFormat.applyPattern("'-'00");
            stringBuffer.append(decimalFormat.format((long) xMPDateTime.W0()));
            if (xMPDateTime.g1() == 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(decimalFormat.format((long) xMPDateTime.g1()));
            if (xMPDateTime.z0()) {
                stringBuffer.append(ASCIIPropertyListParser.C);
                decimalFormat.applyPattern("00");
                stringBuffer.append(decimalFormat.format((long) xMPDateTime.A1()));
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(decimalFormat.format((long) xMPDateTime.y0()));
                if (!(xMPDateTime.S1() == 0 && xMPDateTime.f0() == 0)) {
                    decimalFormat.applyPattern(":00.#########");
                    stringBuffer.append(decimalFormat.format(((double) xMPDateTime.S1()) + (((double) xMPDateTime.f0()) / 1.0E9d)));
                }
                if (xMPDateTime.l0()) {
                    int offset = xMPDateTime.getTimeZone().getOffset(xMPDateTime.o0().getTimeInMillis());
                    if (offset == 0) {
                        stringBuffer.append(ASCIIPropertyListParser.D);
                    } else {
                        int i2 = offset / 3600000;
                        int abs = Math.abs((offset % 3600000) / 60000);
                        decimalFormat.applyPattern("+00;-00");
                        stringBuffer.append(decimalFormat.format((long) i2));
                        decimalFormat.applyPattern(":00");
                        stringBuffer.append(decimalFormat.format((long) abs));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
