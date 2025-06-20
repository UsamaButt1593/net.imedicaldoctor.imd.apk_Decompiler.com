package com.itextpdf.text.pdf;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class PdfDate extends PdfString {
    private static final int[] o3 = {1, 4, 0, 2, 2, -1, 5, 2, 0, 11, 2, 0, 12, 2, 0, 13, 2, 0};

    public PdfDate() {
        this(new GregorianCalendar());
    }

    private String A0(int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        while (stringBuffer.length() < i3) {
            stringBuffer.insert(0, "0");
        }
        stringBuffer.setLength(i3);
        return stringBuffer.toString();
    }

    public static Calendar p0(String str) {
        GregorianCalendar gregorianCalendar;
        try {
            if (str.startsWith("D:")) {
                str = str.substring(2);
            }
            int length = str.length();
            int indexOf = str.indexOf(90);
            int i2 = 0;
            if (indexOf >= 0) {
                gregorianCalendar = new GregorianCalendar(new SimpleTimeZone(0, "ZPDF"));
            } else {
                indexOf = str.indexOf(43);
                int i3 = 1;
                if (indexOf < 0 && (indexOf = str.indexOf(45)) >= 0) {
                    i3 = -1;
                }
                if (indexOf < 0) {
                    indexOf = length;
                    gregorianCalendar = new GregorianCalendar();
                } else {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf + 3)) * 60;
                    if (indexOf + 5 < str.length()) {
                        parseInt += Integer.parseInt(str.substring(indexOf + 4, indexOf + 6));
                    }
                    gregorianCalendar = new GregorianCalendar(new SimpleTimeZone(parseInt * i3 * 60000, "ZPDF"));
                }
            }
            gregorianCalendar.clear();
            int i4 = 0;
            while (true) {
                int[] iArr = o3;
                if (i2 >= iArr.length) {
                    break;
                } else if (i4 >= indexOf) {
                    break;
                } else {
                    int i5 = i2 + 1;
                    gregorianCalendar.set(iArr[i2], Integer.parseInt(str.substring(i4, iArr[i5] + i4)) + iArr[i2 + 2]);
                    i4 += iArr[i5];
                    i2 += 3;
                }
            }
            return gregorianCalendar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String x0(String str) {
        String str2;
        if (str.startsWith("D:")) {
            str = str.substring(2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() < 4) {
            return "0000";
        }
        stringBuffer.append(str.substring(0, 4));
        String substring = str.substring(4);
        if (substring.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append('-');
        stringBuffer.append(substring.substring(0, 2));
        String substring2 = substring.substring(2);
        if (substring2.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append('-');
        stringBuffer.append(substring2.substring(0, 2));
        String substring3 = substring2.substring(2);
        if (substring3.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append(ASCIIPropertyListParser.C);
        stringBuffer.append(substring3.substring(0, 2));
        String substring4 = substring3.substring(2);
        if (substring4.length() < 2) {
            str2 = ":00Z";
        } else {
            stringBuffer.append(ASCIIPropertyListParser.A);
            stringBuffer.append(substring4.substring(0, 2));
            String substring5 = substring4.substring(2);
            if (substring5.length() >= 2) {
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(substring5.substring(0, 2));
                String substring6 = substring5.substring(2);
                if (substring6.startsWith("-") || substring6.startsWith("+")) {
                    String substring7 = substring6.substring(0, 1);
                    String substring8 = substring6.substring(1);
                    if (substring8.length() >= 2) {
                        String substring9 = substring8.substring(0, 2);
                        if (substring8.length() > 2) {
                            String substring10 = substring8.substring(3);
                            if (substring10.length() >= 2) {
                                str2 = substring10.substring(0, 2);
                                stringBuffer.append(substring7);
                                stringBuffer.append(substring9);
                                stringBuffer.append(ASCIIPropertyListParser.A);
                            }
                        }
                        str2 = "00";
                        stringBuffer.append(substring7);
                        stringBuffer.append(substring9);
                        stringBuffer.append(ASCIIPropertyListParser.A);
                    }
                }
            }
            stringBuffer.append(ASCIIPropertyListParser.D);
            return stringBuffer.toString();
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public String q0() {
        return x0(this.i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PdfDate(java.util.Calendar r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            java.lang.String r1 = "D:"
            r0.<init>(r1)
            r1 = 1
            int r2 = r7.get(r1)
            r3 = 4
            java.lang.String r2 = r6.A0(r2, r3)
            r0.append(r2)
            r2 = 2
            int r3 = r7.get(r2)
            int r3 = r3 + r1
            java.lang.String r1 = r6.A0(r3, r2)
            r0.append(r1)
            r1 = 5
            int r1 = r7.get(r1)
            java.lang.String r1 = r6.A0(r1, r2)
            r0.append(r1)
            r1 = 11
            int r1 = r7.get(r1)
            java.lang.String r1 = r6.A0(r1, r2)
            r0.append(r1)
            r1 = 12
            int r1 = r7.get(r1)
            java.lang.String r1 = r6.A0(r1, r2)
            r0.append(r1)
            r1 = 13
            int r1 = r7.get(r1)
            java.lang.String r1 = r6.A0(r1, r2)
            r0.append(r1)
            r1 = 15
            int r3 = r7.get(r1)
            r4 = 16
            int r5 = r7.get(r4)
            int r3 = r3 + r5
            r5 = 3600000(0x36ee80, float:5.044674E-39)
            int r3 = r3 / r5
            if (r3 != 0) goto L_0x0070
            r5 = 90
        L_0x006c:
            r0.append(r5)
            goto L_0x007c
        L_0x0070:
            if (r3 >= 0) goto L_0x0079
            r5 = 45
            r0.append(r5)
            int r3 = -r3
            goto L_0x007c
        L_0x0079:
            r5 = 43
            goto L_0x006c
        L_0x007c:
            if (r3 == 0) goto L_0x00a8
            java.lang.String r5 = r6.A0(r3, r2)
            r0.append(r5)
            r5 = 39
            r0.append(r5)
            int r1 = r7.get(r1)
            int r7 = r7.get(r4)
            int r1 = r1 + r7
            r7 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 / r7
            int r7 = java.lang.Math.abs(r1)
            int r3 = r3 * 60
            int r7 = r7 - r3
            java.lang.String r7 = r6.A0(r7, r2)
            r0.append(r7)
            r0.append(r5)
        L_0x00a8:
            java.lang.String r7 = r0.toString()
            r6.i3 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDate.<init>(java.util.Calendar):void");
    }
}
