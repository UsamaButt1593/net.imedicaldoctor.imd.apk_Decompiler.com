package com.itextpdf.tool.xml.parser.io;

public class EncodingUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "encoding"
            int r1 = r5.indexOf(r1)
            if (r1 >= 0) goto L_0x000d
            return r0
        L_0x000d:
            r2 = 34
            int r3 = r5.indexOf(r2, r1)
            r4 = 39
            int r1 = r5.indexOf(r4, r1)
            if (r3 != r1) goto L_0x001c
            return r0
        L_0x001c:
            if (r3 >= 0) goto L_0x0020
            if (r1 > 0) goto L_0x0024
        L_0x0020:
            if (r1 <= 0) goto L_0x0032
            if (r1 >= r3) goto L_0x0032
        L_0x0024:
            int r1 = r1 + 1
            int r2 = r5.indexOf(r4, r1)
            if (r2 >= 0) goto L_0x002d
            return r0
        L_0x002d:
            java.lang.String r5 = r5.substring(r1, r2)
            return r5
        L_0x0032:
            if (r1 >= 0) goto L_0x0036
            if (r3 > 0) goto L_0x003a
        L_0x0036:
            if (r3 <= 0) goto L_0x0048
            if (r3 >= r1) goto L_0x0048
        L_0x003a:
            int r3 = r3 + 1
            int r1 = r5.indexOf(r2, r3)
            if (r1 >= 0) goto L_0x0043
            return r0
        L_0x0043:
            java.lang.String r5 = r5.substring(r3, r1)
            return r5
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.parser.io.EncodingUtil.a(java.lang.String):java.lang.String");
    }
}
