package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import java.util.List;

public class HTMLUtils {
    public static List<Chunk> a(String str, boolean z) {
        return b(str, z, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r8 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r1 = org.apache.commons.lang3.StringUtils.SPACE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        r0.append(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.itextpdf.text.Chunk> b(java.lang.String r7, boolean r8, boolean r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char[] r7 = r7.toCharArray()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r7.length
            r4 = 0
            if (r3 <= 0) goto L_0x001e
            char r3 = r7[r4]
            boolean r3 = java.lang.Character.isWhitespace(r3)
            goto L_0x001f
        L_0x001e:
            r3 = 1
        L_0x001f:
            int r5 = r7.length
        L_0x0020:
            if (r4 >= r5) goto L_0x005b
            char r6 = r7[r4]
            if (r3 == 0) goto L_0x004b
            boolean r3 = java.lang.Character.isWhitespace(r6)
            if (r3 != 0) goto L_0x004b
            int r3 = r0.length()
            if (r3 != 0) goto L_0x003e
            java.lang.String r1 = r1.toString()
            com.itextpdf.text.Chunk r1 = com.itextpdf.text.Chunk.g(r1, r8)
            r2.add(r1)
            goto L_0x0046
        L_0x003e:
            if (r8 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            java.lang.String r1 = " "
        L_0x0043:
            r0.append(r1)
        L_0x0046:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x004b:
            boolean r3 = java.lang.Character.isWhitespace(r6)
            if (r3 == 0) goto L_0x0055
            r1.append(r6)
            goto L_0x0058
        L_0x0055:
            r0.append(r6)
        L_0x0058:
            int r4 = r4 + 1
            goto L_0x0020
        L_0x005b:
            int r7 = r0.length()
            if (r7 <= 0) goto L_0x007c
            com.itextpdf.text.Chunk r7 = new com.itextpdf.text.Chunk
            if (r9 == 0) goto L_0x0072
            java.lang.String r9 = r0.toString()
            r0 = 160(0xa0, float:2.24E-43)
            r3 = 32
            java.lang.String r9 = r9.replace(r0, r3)
            goto L_0x0076
        L_0x0072:
            java.lang.String r9 = r0.toString()
        L_0x0076:
            r7.<init>((java.lang.String) r9)
            r2.add(r7)
        L_0x007c:
            int r7 = r1.length()
            if (r7 <= 0) goto L_0x008d
            java.lang.String r7 = r1.toString()
            com.itextpdf.text.Chunk r7 = com.itextpdf.text.Chunk.g(r7, r8)
            r2.add(r7)
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.HTMLUtils.b(java.lang.String, boolean, boolean):java.util.List");
    }

    public static List<Chunk> c(String str, boolean z) {
        return b(str, z, false);
    }

    public static List<Chunk> d(String str, boolean z, boolean z2) {
        return b(str, z, z2);
    }
}
