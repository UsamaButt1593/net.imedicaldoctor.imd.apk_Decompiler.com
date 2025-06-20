package com.itextpdf.xmp.impl;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.xmp.XMPConst;

public class Utils implements XMPConst {
    public static final int X = 36;
    private static boolean[] Y = null;
    private static boolean[] Z = null;
    public static final int s = 4;

    static {
        c();
    }

    private Utils() {
    }

    static boolean a(String str) {
        if (str == null) {
            return false;
        }
        int i2 = 0;
        boolean z = true;
        int i3 = 0;
        while (i2 < str.length()) {
            if (str.charAt(i2) == '-') {
                i3++;
                z = z && (i2 == 8 || i2 == 13 || i2 == 18 || i2 == 23);
            }
            i2++;
        }
        return z && 4 == i3 && 36 == i2;
    }

    public static String b(String str, boolean z, boolean z2) {
        String str2;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '<' || charAt == '>' || charAt == '&' || ((z2 && (charAt == 9 || charAt == 10 || charAt == 13)) || (z && charAt == '\"'))) {
                StringBuffer stringBuffer = new StringBuffer((str.length() * 4) / 3);
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt2 = str.charAt(i3);
                    if (!z2 || !(charAt2 == 9 || charAt2 == 10 || charAt2 == 13)) {
                        if (charAt2 == '\"') {
                            str2 = z ? "&quot;" : "\"";
                        } else if (charAt2 == '&') {
                            str2 = "&amp;";
                        } else if (charAt2 == '<') {
                            str2 = "&lt;";
                        } else if (charAt2 == '>') {
                            str2 = "&gt;";
                        }
                        stringBuffer.append(str2);
                    } else {
                        stringBuffer.append("&#x");
                        stringBuffer.append(Integer.toHexString(charAt2).toUpperCase());
                        charAt2 = ASCIIPropertyListParser.f18655m;
                    }
                    stringBuffer.append(charAt2);
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    private static void c() {
        Z = new boolean[256];
        Y = new boolean[256];
        char c2 = 0;
        while (true) {
            boolean[] zArr = Z;
            if (c2 < zArr.length) {
                boolean[] zArr2 = Y;
                boolean z = true;
                boolean z2 = c2 == ':' || ('A' <= c2 && c2 <= 'Z') || c2 == '_' || (('a' <= c2 && c2 <= 'z') || ((192 <= c2 && c2 <= 214) || ((216 <= c2 && c2 <= 246) || (248 <= c2 && c2 <= 255))));
                zArr2[c2] = z2;
                if (!z2 && c2 != '-' && c2 != '.' && (('0' > c2 || c2 > '9') && c2 != 183)) {
                    z = false;
                }
                zArr[c2] = z;
                c2 = (char) (c2 + 1);
            } else {
                return;
            }
        }
    }

    static boolean d(char c2) {
        return ((c2 > 31 && c2 != 127) || c2 == 9 || c2 == 10 || c2 == 13) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean e(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "http://purl.org/dc/elements/1.1/"
            boolean r0 = r0.equals(r3)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001c
            java.lang.String r3 = "dc:format"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "dc:language"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a8
            goto L_0x0136
        L_0x001c:
            java.lang.String r0 = "http://ns.adobe.com/xap/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0056
            java.lang.String r3 = "xmp:BaseURL"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "xmp:CreatorTool"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "xmp:Format"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "xmp:Locale"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "xmp:MetadataDate"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "xmp:ModifyDate"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a8
            goto L_0x0136
        L_0x0056:
            java.lang.String r0 = "http://ns.adobe.com/pdf/1.3/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0088
            java.lang.String r3 = "pdf:BaseURL"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "pdf:Creator"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "pdf:ModDate"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "pdf:PDFVersion"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "pdf:Producer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a8
            goto L_0x0136
        L_0x0088:
            java.lang.String r0 = "http://ns.adobe.com/tiff/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00ab
            java.lang.String r3 = "tiff:ImageDescription"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00a8
            java.lang.String r3 = "tiff:Artist"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00a8
            java.lang.String r3 = "tiff:Copyright"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0136
        L_0x00a8:
            r1 = 0
            goto L_0x0136
        L_0x00ab:
            java.lang.String r0 = "http://ns.adobe.com/exif/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00bc
            java.lang.String r3 = "exif:UserComment"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0136
            goto L_0x00a8
        L_0x00bc:
            java.lang.String r0 = "http://ns.adobe.com/exif/1.0/aux/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00c6
            goto L_0x0136
        L_0x00c6:
            java.lang.String r0 = "http://ns.adobe.com/photoshop/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00d7
            java.lang.String r3 = "photoshop:ICCProfile"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a8
            goto L_0x0136
        L_0x00d7:
            java.lang.String r0 = "http://ns.adobe.com/camera-raw-settings/1.0/"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00f8
            java.lang.String r3 = "crs:Version"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "crs:RawFileName"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0136
            java.lang.String r3 = "crs:ToneCurveName"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00a8
            goto L_0x0136
        L_0x00f8:
            java.lang.String r4 = "http://ns.adobe.com/StockPhoto/1.0/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0101
            goto L_0x0136
        L_0x0101:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/mm/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x010a
            goto L_0x0136
        L_0x010a:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/t/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0113
            goto L_0x0136
        L_0x0113:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/t/pg/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x011c
            goto L_0x0136
        L_0x011c:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/g/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x0125
            goto L_0x0136
        L_0x0125:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/g/img/"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x012e
            goto L_0x0136
        L_0x012e:
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/sType/Font#"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00a8
        L_0x0136:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.Utils.e(java.lang.String, java.lang.String):boolean");
    }

    private static boolean f(char c2) {
        return (c2 <= 255 && Z[c2]) || g(c2) || (c2 >= 768 && c2 <= 879) || (c2 >= 8255 && c2 <= 8256);
    }

    private static boolean g(char c2) {
        return (c2 <= 255 && Y[c2]) || (c2 >= 256 && c2 <= 767) || ((c2 >= 880 && c2 <= 893) || ((c2 >= 895 && c2 <= 8191) || ((c2 >= 8204 && c2 <= 8205) || ((c2 >= 8304 && c2 <= 8591) || ((c2 >= 11264 && c2 <= 12271) || ((c2 >= 12289 && c2 <= 55295) || ((c2 >= 63744 && c2 <= 64975) || ((c2 >= 65008 && c2 <= 65533) || (c2 >= 0 && c2 <= 65535)))))))));
    }

    public static boolean h(String str) {
        if (str.length() > 0 && !g(str.charAt(0))) {
            return false;
        }
        for (int i2 = 1; i2 < str.length(); i2++) {
            if (!f(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(String str) {
        if (str.length() > 0 && (!g(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i2 = 1; i2 < str.length(); i2++) {
            if (!f(str.charAt(i2)) || str.charAt(i2) == ':') {
                return false;
            }
        }
        return true;
    }

    public static String j(String str) {
        if ("x-default".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt != ' ') {
                if (charAt == '-' || charAt == '_') {
                    stringBuffer.append('-');
                    i2++;
                } else {
                    stringBuffer.append(i2 != 2 ? Character.toLowerCase(str.charAt(i3)) : Character.toUpperCase(str.charAt(i3)));
                }
            }
        }
        return stringBuffer.toString();
    }

    static String k(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            if (d(stringBuffer.charAt(i2))) {
                stringBuffer.setCharAt(i2, ' ');
            }
        }
        return stringBuffer.toString();
    }

    static String[] l(String str) {
        int indexOf = str.indexOf(61);
        int i2 = 1;
        if (str.charAt(1) == '?') {
            i2 = 2;
        }
        String substring = str.substring(i2, indexOf);
        char charAt = str.charAt(indexOf + 1);
        int i3 = indexOf + 2;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - indexOf);
        while (i3 < length) {
            stringBuffer.append(str.charAt(i3));
            int i4 = i3 + 1;
            i3 = str.charAt(i4) == charAt ? i3 + 2 : i4;
        }
        return new String[]{substring, stringBuffer.toString()};
    }
}
