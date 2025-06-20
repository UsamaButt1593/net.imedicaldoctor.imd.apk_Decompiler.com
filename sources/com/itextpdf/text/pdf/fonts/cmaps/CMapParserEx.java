package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfName;
import java.io.IOException;
import java.util.ArrayList;

public class CMapParserEx {

    /* renamed from: a  reason: collision with root package name */
    private static final PdfName f26811a = new PdfName("CMapName");

    /* renamed from: b  reason: collision with root package name */
    private static final String f26812b = "def";

    /* renamed from: c  reason: collision with root package name */
    private static final String f26813c = "endcidrange";

    /* renamed from: d  reason: collision with root package name */
    private static final String f26814d = "endcidchar";

    /* renamed from: e  reason: collision with root package name */
    private static final String f26815e = "endbfrange";

    /* renamed from: f  reason: collision with root package name */
    private static final String f26816f = "endbfchar";

    /* renamed from: g  reason: collision with root package name */
    private static final String f26817g = "usecmap";

    /* renamed from: h  reason: collision with root package name */
    private static final int f26818h = 10;

    private static void a(int i2, byte[] bArr, char c2, ArrayList<char[]> arrayList) {
        int i3 = i2 - 1;
        int i4 = 0;
        char c3 = 0;
        while (i4 < i3) {
            char[] cArr = arrayList.get(c3);
            byte b2 = bArr[i4] & 255;
            char c4 = cArr[b2];
            if (c4 == 0 || (c4 & 32768) != 0) {
                if (c4 == 0) {
                    arrayList.add(new char[256]);
                    c4 = (char) ((arrayList.size() - 1) | 32768);
                    cArr[b2] = c4;
                }
                c3 = c4 & BaseFont.r4;
                i4++;
            } else {
                throw new RuntimeException(MessageLocalization.b("inconsistent.mapping", new Object[0]));
            }
        }
        char[] cArr2 = arrayList.get(c3);
        byte b3 = bArr[i3] & 255;
        if ((cArr2[b3] & 32768) == 0) {
            cArr2[b3] = c2;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("inconsistent.mapping", new Object[0]));
    }

    public static void b(String str, AbstractCMap abstractCMap, CidLocation cidLocation) throws IOException {
        c(str, abstractCMap, cidLocation, 0);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[LOOP:0: B:7:0x0015->B:76:0x0015, LOOP_START, PHI: r2 
      PHI: (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:6:0x0013, B:76:0x0015] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:7:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(java.lang.String r9, com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap r10, com.itextpdf.text.pdf.fonts.cmaps.CidLocation r11, int r12) throws java.io.IOException {
        /*
            r0 = 10
            if (r12 < r0) goto L_0x0005
            return
        L_0x0005:
            com.itextpdf.text.pdf.PRTokeniser r9 = r11.a(r9)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x005e }
            r0.<init>()     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfContentParser r1 = new com.itextpdf.text.pdf.PdfContentParser     // Catch:{ all -> 0x005e }
            r1.<init>(r9)     // Catch:{ all -> 0x005e }
            r2 = 50
        L_0x0015:
            r1.c(r0)     // Catch:{ Exception -> 0x0153 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0020
            goto L_0x0157
        L_0x0020:
            int r3 = r0.size()     // Catch:{ all -> 0x005e }
            r4 = 1
            int r3 = r3 - r4
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005e }
            r5 = 3
            r6 = 0
            if (r12 != 0) goto L_0x00a4
            int r7 = r0.size()     // Catch:{ all -> 0x005e }
            if (r7 != r5) goto L_0x00a4
            java.lang.String r7 = "def"
            boolean r7 = r3.equals(r7)     // Catch:{ all -> 0x005e }
            if (r7 == 0) goto L_0x00a4
            java.lang.Object r3 = r0.get(r6)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Qd     // Catch:{ all -> 0x005e }
            boolean r5 = r5.equals(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0061
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005e }
            r10.m(r3)     // Catch:{ all -> 0x005e }
            goto L_0x0015
        L_0x005e:
            r10 = move-exception
            goto L_0x015b
        L_0x0061:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.kc     // Catch:{ all -> 0x005e }
            boolean r5 = r5.equals(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0077
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005e }
            r10.l(r3)     // Catch:{ all -> 0x005e }
            goto L_0x0015
        L_0x0077:
            com.itextpdf.text.pdf.PdfName r5 = f26811a     // Catch:{ all -> 0x005e }
            boolean r5 = r5.equals(r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x008d
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005e }
            r10.k(r3)     // Catch:{ all -> 0x005e }
            goto L_0x0015
        L_0x008d:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Ef     // Catch:{ all -> 0x005e }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0015
            java.lang.Object r3 = r0.get(r4)     // Catch:{ Exception -> 0x0015 }
            com.itextpdf.text.pdf.PdfNumber r3 = (com.itextpdf.text.pdf.PdfNumber) r3     // Catch:{ Exception -> 0x0015 }
            int r3 = r3.e0()     // Catch:{ Exception -> 0x0015 }
            r10.n(r3)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0015
        L_0x00a4:
            java.lang.String r4 = "endcidchar"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x005e }
            r7 = 2
            if (r4 != 0) goto L_0x00b5
            java.lang.String r4 = "endbfchar"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x00de
        L_0x00b5:
            int r4 = r0.size()     // Catch:{ all -> 0x005e }
            if (r4 < r5) goto L_0x00de
            int r3 = r0.size()     // Catch:{ all -> 0x005e }
            int r3 = r3 - r7
        L_0x00c0:
            if (r6 >= r3) goto L_0x0015
            java.lang.Object r4 = r0.get(r6)     // Catch:{ all -> 0x005e }
            boolean r4 = r4 instanceof com.itextpdf.text.pdf.PdfString     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x00db
            java.lang.Object r4 = r0.get(r6)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfString r4 = (com.itextpdf.text.pdf.PdfString) r4     // Catch:{ all -> 0x005e }
            int r5 = r6 + 1
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r5 = (com.itextpdf.text.pdf.PdfObject) r5     // Catch:{ all -> 0x005e }
            r10.a(r4, r5)     // Catch:{ all -> 0x005e }
        L_0x00db:
            int r6 = r6 + 2
            goto L_0x00c0
        L_0x00de:
            java.lang.String r4 = "endcidrange"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x005e }
            if (r4 != 0) goto L_0x00ee
            java.lang.String r4 = "endbfrange"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0128
        L_0x00ee:
            int r4 = r0.size()     // Catch:{ all -> 0x005e }
            r8 = 4
            if (r4 < r8) goto L_0x0128
            int r3 = r0.size()     // Catch:{ all -> 0x005e }
            int r3 = r3 - r5
        L_0x00fa:
            if (r6 >= r3) goto L_0x0015
            java.lang.Object r4 = r0.get(r6)     // Catch:{ all -> 0x005e }
            boolean r4 = r4 instanceof com.itextpdf.text.pdf.PdfString     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0125
            int r4 = r6 + 1
            java.lang.Object r5 = r0.get(r4)     // Catch:{ all -> 0x005e }
            boolean r5 = r5 instanceof com.itextpdf.text.pdf.PdfString     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x0125
            java.lang.Object r5 = r0.get(r6)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfString r5 = (com.itextpdf.text.pdf.PdfString) r5     // Catch:{ all -> 0x005e }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfString r4 = (com.itextpdf.text.pdf.PdfString) r4     // Catch:{ all -> 0x005e }
            int r7 = r6 + 2
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r7 = (com.itextpdf.text.pdf.PdfObject) r7     // Catch:{ all -> 0x005e }
            r10.b(r5, r4, r7)     // Catch:{ all -> 0x005e }
        L_0x0125:
            int r6 = r6 + 3
            goto L_0x00fa
        L_0x0128:
            java.lang.String r4 = "usecmap"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0015
            int r3 = r0.size()     // Catch:{ all -> 0x005e }
            if (r3 != r7) goto L_0x0015
            java.lang.Object r3 = r0.get(r6)     // Catch:{ all -> 0x005e }
            boolean r3 = r3 instanceof com.itextpdf.text.pdf.PdfName     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0015
            java.lang.Object r3 = r0.get(r6)     // Catch:{ all -> 0x005e }
            com.itextpdf.text.pdf.PdfObject r3 = (com.itextpdf.text.pdf.PdfObject) r3     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x005e }
            java.lang.String r3 = com.itextpdf.text.pdf.PdfName.a0(r3)     // Catch:{ all -> 0x005e }
            int r4 = r12 + 1
            c(r3, r10, r11, r4)     // Catch:{ all -> 0x005e }
            goto L_0x0015
        L_0x0153:
            int r2 = r2 + -1
            if (r2 >= 0) goto L_0x0015
        L_0x0157:
            r9.e()
            return
        L_0x015b:
            r9.e()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx.c(java.lang.String, com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap, com.itextpdf.text.pdf.fonts.cmaps.CidLocation, int):void");
    }
}
