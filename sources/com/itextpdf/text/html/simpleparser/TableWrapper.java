package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.pdf.PdfPCell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class TableWrapper implements Element {
    private final List<List<PdfPCell>> X = new ArrayList();
    private float[] Y;
    private final Map<String, String> s;

    public TableWrapper(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.s = hashMap;
        hashMap.putAll(map);
    }

    public boolean V() {
        return false;
    }

    public List<Chunk> Y() {
        return null;
    }

    public void a(List<PdfPCell> list) {
        if (list != null) {
            Collections.reverse(list);
            this.X.add(list);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfPTable c() {
        /*
            r5 = this;
            java.util.List<java.util.List<com.itextpdf.text.pdf.PdfPCell>> r0 = r5.X
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L_0x000f
            com.itextpdf.text.pdf.PdfPTable r0 = new com.itextpdf.text.pdf.PdfPTable
            r0.<init>((int) r1)
            return r0
        L_0x000f:
            java.util.List<java.util.List<com.itextpdf.text.pdf.PdfPCell>> r0 = r5.X
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
        L_0x001d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x002f
            java.lang.Object r4 = r0.next()
            com.itextpdf.text.pdf.PdfPCell r4 = (com.itextpdf.text.pdf.PdfPCell) r4
            int r4 = r4.J0()
            int r3 = r3 + r4
            goto L_0x001d
        L_0x002f:
            com.itextpdf.text.pdf.PdfPTable r0 = new com.itextpdf.text.pdf.PdfPTable
            r0.<init>((int) r3)
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.s
            java.lang.String r4 = "width"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0046
            r1 = 1120403456(0x42c80000, float:100.0)
        L_0x0042:
            r0.Z0(r1)
            goto L_0x0066
        L_0x0046:
            java.lang.String r4 = "%"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x005c
            int r4 = r3.length()
            int r4 = r4 - r1
            java.lang.String r1 = r3.substring(r2, r4)
            float r1 = java.lang.Float.parseFloat(r1)
            goto L_0x0042
        L_0x005c:
            float r3 = java.lang.Float.parseFloat(r3)
            r0.X0(r3)
            r0.O0(r1)
        L_0x0066:
            java.util.Map<java.lang.String, java.lang.String> r1 = r5.s
            java.lang.String r3 = "align"
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0076
            int r2 = com.itextpdf.text.html.HtmlUtilities.a(r1)
        L_0x0076:
            r0.M0(r2)
            float[] r1 = r5.Y     // Catch:{ Exception -> 0x0080 }
            if (r1 == 0) goto L_0x0080
            r0.b1(r1)     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            java.util.List<java.util.List<com.itextpdf.text.pdf.PdfPCell>> r1 = r5.X
            java.util.Iterator r1 = r1.iterator()
        L_0x0086:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00a6
            java.lang.Object r2 = r1.next()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0096:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r2.next()
            com.itextpdf.text.pdf.PdfPCell r3 = (com.itextpdf.text.pdf.PdfPCell) r3
            r0.a(r3)
            goto L_0x0096
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.html.simpleparser.TableWrapper.c():com.itextpdf.text.pdf.PdfPTable");
    }

    public void e(float[] fArr) {
        this.Y = fArr;
    }

    public boolean t(ElementListener elementListener) {
        return false;
    }

    public int type() {
        return 0;
    }

    public boolean x() {
        return false;
    }
}
