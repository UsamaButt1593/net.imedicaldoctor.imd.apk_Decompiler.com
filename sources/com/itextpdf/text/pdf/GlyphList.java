package com.itextpdf.text.pdf;

import java.util.HashMap;

public class GlyphList {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, String> f26067a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, int[]> f26068b = new HashMap<>();

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3 A[SYNTHETIC, Splitter:B:38:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[SYNTHETIC, Splitter:B:42:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            f26067a = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            f26068b = r0
            r0 = 0
            java.lang.String r1 = "com/itextpdf/text/pdf/fonts/glyphlist.txt"
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r2 = new com.itextpdf.text.pdf.fonts.FontsResourceAnchor     // Catch:{ Exception -> 0x008e }
            r2.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.Class<com.itextpdf.text.pdf.fonts.FontsResourceAnchor> r2 = com.itextpdf.text.pdf.fonts.FontsResourceAnchor.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x008e }
            java.io.InputStream r1 = com.itextpdf.text.io.StreamUtil.c(r1, r2)     // Catch:{ Exception -> 0x008e }
            if (r1 == 0) goto L_0x009f
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            r3.<init>()     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
        L_0x002b:
            int r4 = r1.read(r2)     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            if (r4 >= 0) goto L_0x009a
            r1.close()     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            byte[] r1 = r3.toByteArray()     // Catch:{ Exception -> 0x008e }
            java.lang.String r1 = com.itextpdf.text.pdf.PdfEncodings.d(r1, r0)     // Catch:{ Exception -> 0x008e }
            java.util.StringTokenizer r2 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x008e }
            java.lang.String r3 = "\r\n"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x008e }
        L_0x0043:
            boolean r1 = r2.hasMoreTokens()     // Catch:{ Exception -> 0x008e }
            if (r1 == 0) goto L_0x00c6
            java.lang.String r1 = r2.nextToken()     // Catch:{ Exception -> 0x008e }
            java.lang.String r3 = "#"
            boolean r3 = r1.startsWith(r3)     // Catch:{ Exception -> 0x008e }
            if (r3 == 0) goto L_0x0056
            goto L_0x0043
        L_0x0056:
            java.util.StringTokenizer r3 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = " ;\r\n\t\f"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x008e }
            boolean r1 = r3.hasMoreTokens()     // Catch:{ Exception -> 0x008e }
            if (r1 != 0) goto L_0x0064
            goto L_0x0043
        L_0x0064:
            java.lang.String r1 = r3.nextToken()     // Catch:{ Exception -> 0x008e }
            boolean r4 = r3.hasMoreTokens()     // Catch:{ Exception -> 0x008e }
            if (r4 != 0) goto L_0x006f
            goto L_0x0043
        L_0x006f:
            java.lang.String r3 = r3.nextToken()     // Catch:{ Exception -> 0x008e }
            r4 = 16
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3, r4)     // Catch:{ Exception -> 0x008e }
            java.util.HashMap<java.lang.Integer, java.lang.String> r4 = f26067a     // Catch:{ Exception -> 0x008e }
            r4.put(r3, r1)     // Catch:{ Exception -> 0x008e }
            java.util.HashMap<java.lang.String, int[]> r4 = f26068b     // Catch:{ Exception -> 0x008e }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x008e }
            int[] r3 = new int[]{r3}     // Catch:{ Exception -> 0x008e }
            r4.put(r1, r3)     // Catch:{ Exception -> 0x008e }
            goto L_0x0043
        L_0x008c:
            r1 = move-exception
            goto L_0x00c7
        L_0x008e:
            r1 = move-exception
            goto L_0x00a7
        L_0x0090:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00c7
        L_0x0095:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00a7
        L_0x009a:
            r5 = 0
            r3.write(r2, r5, r4)     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            goto L_0x002b
        L_0x009f:
            java.lang.String r0 = "glyphlist.txt not found as resource. (It must exist as resource in the package com.itextpdf.text.pdf.fonts)"
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
            throw r2     // Catch:{ Exception -> 0x0095, all -> 0x0090 }
        L_0x00a7:
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r3.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "glyphlist.txt loading error: "
            r3.append(r4)     // Catch:{ all -> 0x008c }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x008c }
            r3.append(r1)     // Catch:{ all -> 0x008c }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x008c }
            r2.println(r1)     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x00c6
            r0.close()     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            return
        L_0x00c7:
            if (r0 == 0) goto L_0x00cc
            r0.close()     // Catch:{ Exception -> 0x00cc }
        L_0x00cc:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.GlyphList.<clinit>():void");
    }

    public static int[] a(String str) {
        int[] iArr = f26068b.get(str);
        if (iArr == null && str.length() == 7 && str.toLowerCase().startsWith("uni")) {
            try {
                return new int[]{Integer.parseInt(str.substring(3), 16)};
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static String b(int i2) {
        return f26067a.get(Integer.valueOf(i2));
    }
}
