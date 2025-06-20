package com.itextpdf.text.xml;

import com.dd.plist.ASCIIPropertyListParser;

public class XMLUtil {
    public static String a(String str, boolean z) {
        String str2;
        char c2;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c3 : str.toCharArray()) {
            if (c3 == '\"') {
                str2 = "&quot;";
            } else if (c3 == '<') {
                str2 = "&lt;";
            } else if (c3 == '>') {
                str2 = "&gt;";
            } else if (c3 == '&') {
                str2 = "&amp;";
            } else if (c3 != '\'') {
                if (d(c3)) {
                    if (!z || c3 <= 127) {
                        c2 = (char) c3;
                    } else {
                        stringBuffer.append("&#");
                        stringBuffer.append(c3);
                        c2 = ASCIIPropertyListParser.f18655m;
                    }
                    stringBuffer.append(c2);
                }
            } else {
                str2 = "&apos;";
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public static int b(char c2, char[] cArr, int i2) {
        while (i2 < cArr.length) {
            if (cArr[i2] == ';') {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static String c(byte[] bArr) {
        byte b2 = bArr[0] & 255;
        byte b3 = bArr[1] & 255;
        if (b2 == 254 && b3 == 255) {
            return "UTF-16BE";
        }
        if (b2 == 255 && b3 == 254) {
            return "UTF-16LE";
        }
        byte b4 = bArr[2] & 255;
        if (b2 == 239 && b3 == 187 && b4 == 191) {
            return "UTF-8";
        }
        byte b5 = bArr[3] & 255;
        if (b2 == 0 && b3 == 0 && b4 == 0 && b5 == 60) {
            return "ISO-10646-UCS-4";
        }
        if (b2 == 60 && b3 == 0 && b4 == 0 && b5 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b2 == 0 && b3 == 0 && b4 == 60 && b5 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b2 == 0 && b3 == 60 && b4 == 0 && b5 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b2 == 0 && b3 == 60 && b4 == 0 && b5 == 63) {
            return "UTF-16BE";
        }
        if (b2 == 60 && b3 == 0 && b4 == 63 && b5 == 0) {
            return "UTF-16LE";
        }
        return (b2 == 76 && b3 == 111 && b4 == 167 && b5 == 148) ? "CP037" : "UTF-8";
    }

    public static boolean d(int i2) {
        return i2 == 9 || i2 == 10 || i2 == 13 || (i2 >= 32 && i2 <= 55295) || ((i2 >= 57344 && i2 <= 65533) || (i2 >= 65536 && i2 <= 1114111));
    }

    public static boolean e(String str) {
        try {
            return d(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static int f(String str) {
        if ("apos".equals(str)) {
            return 39;
        }
        if ("quot".equals(str)) {
            return 34;
        }
        if ("lt".equals(str)) {
            return 60;
        }
        if ("gt".equals(str)) {
            return 62;
        }
        return "amp".equals(str) ? 38 : -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: char} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r3v0, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(java.lang.String r9) {
        /*
            char[] r9 = r9.toCharArray()
            int r0 = r9.length
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
        L_0x000b:
            if (r2 >= r0) goto L_0x0052
            char r3 = r9[r2]
            r4 = 38
            r5 = 1
            if (r3 != r4) goto L_0x004a
            int r4 = r2 + 3
            r6 = 59
            int r4 = b(r6, r9, r4)
            r6 = -1
            if (r4 <= r6) goto L_0x004a
            java.lang.String r6 = new java.lang.String
            int r7 = r2 + 1
            int r8 = r4 - r2
            int r8 = r8 - r5
            r6.<init>(r9, r7, r8)
            java.lang.String r7 = "#"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x0042
            java.lang.String r2 = r6.substring(r5)
            boolean r3 = e(r2)
            if (r3 == 0) goto L_0x004f
            int r2 = java.lang.Integer.parseInt(r2)
            char r3 = (char) r2
            r2 = r4
            goto L_0x004a
        L_0x0042:
            int r6 = f(r6)
            if (r6 <= 0) goto L_0x004a
            r2 = r4
            r3 = r6
        L_0x004a:
            char r3 = (char) r3
            r1.append(r3)
            r4 = r2
        L_0x004f:
            int r2 = r4 + 1
            goto L_0x000b
        L_0x0052:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.XMLUtil.g(java.lang.String):java.lang.String");
    }
}
