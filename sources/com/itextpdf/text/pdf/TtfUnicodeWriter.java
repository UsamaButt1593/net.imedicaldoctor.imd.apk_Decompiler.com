package com.itextpdf.text.pdf;

public class TtfUnicodeWriter {

    /* renamed from: a  reason: collision with root package name */
    protected PdfWriter f26463a;

    public TtfUnicodeWriter(PdfWriter pdfWriter) {
        this.f26463a = pdfWriter;
    }

    /* JADX WARNING: type inference failed for: r12v21, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.itextpdf.text.pdf.TrueTypeFontUnicode r10, com.itextpdf.text.pdf.PdfIndirectReference r11, java.lang.Object[] r12, byte[] r13) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r9 = this;
            r13 = 0
            r12 = r12[r13]
            java.util.HashMap r12 = (java.util.HashMap) r12
            boolean r0 = r10.f3
            r1 = 1
            r10.u0(r12, r1, r0)
            java.util.Collection r0 = r12.values()
            int[][] r2 = new int[r13][]
            java.lang.Object[] r0 = r0.toArray(r2)
            int[][] r0 = (int[][]) r0
            java.util.Arrays.sort(r0, r10)
            boolean r2 = r10.A4
            if (r2 == 0) goto L_0x0077
            byte[] r2 = r10.M0()
            boolean r3 = r10.f3
            if (r3 != 0) goto L_0x002a
            java.util.ArrayList<int[]> r3 = r10.s
            if (r3 == 0) goto L_0x0063
        L_0x002a:
            com.itextpdf.text.pdf.CFFFontSubset r3 = new com.itextpdf.text.pdf.CFFFontSubset
            com.itextpdf.text.pdf.RandomAccessFileOrArray r4 = new com.itextpdf.text.pdf.RandomAccessFileOrArray
            r4.<init>((byte[]) r2)
            r3.<init>(r4, r12)
            java.lang.String[] r4 = r3.j()     // Catch:{ Exception -> 0x003f }
            r4 = r4[r13]     // Catch:{ Exception -> 0x003f }
            byte[] r2 = r3.Q(r4)     // Catch:{ Exception -> 0x003f }
            goto L_0x0063
        L_0x003f:
            r0 = move-exception
            java.lang.Class<com.itextpdf.text.pdf.TtfUnicodeWriter> r3 = com.itextpdf.text.pdf.TtfUnicodeWriter.class
            com.itextpdf.text.log.Logger r3 = com.itextpdf.text.log.LoggerFactory.b(r3)
            java.lang.String r4 = "Issue in CFF font subsetting.Subsetting was disabled"
            r3.i(r4, r0)
            r10.s0(r13)
            boolean r0 = r10.f3
            r10.u0(r12, r1, r0)
            java.util.Collection r12 = r12.values()
            int[][] r13 = new int[r13][]
            java.lang.Object[] r12 = r12.toArray(r13)
            r0 = r12
            int[][] r0 = (int[][]) r0
            java.util.Arrays.sort(r0, r10)
        L_0x0063:
            com.itextpdf.text.pdf.BaseFont$StreamFont r12 = new com.itextpdf.text.pdf.BaseFont$StreamFont
            java.lang.String r13 = "CIDFontType0C"
            int r1 = r10.b3
            r12.<init>((byte[]) r2, (java.lang.String) r13, (int) r1)
            com.itextpdf.text.pdf.PdfWriter r13 = r9.f26463a
            com.itextpdf.text.pdf.PdfIndirectObject r12 = r13.v0(r12)
        L_0x0072:
            com.itextpdf.text.pdf.PdfIndirectReference r12 = r12.a()
            goto L_0x00bc
        L_0x0077:
            boolean r13 = r10.f3
            if (r13 != 0) goto L_0x0085
            int r13 = r10.D4
            if (r13 == 0) goto L_0x0080
            goto L_0x0085
        L_0x0080:
            byte[] r12 = r10.D0()
            goto L_0x00a9
        L_0x0085:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r13 = r10.y4
            monitor-enter(r13)
            com.itextpdf.text.pdf.TrueTypeFontSubSet r8 = new com.itextpdf.text.pdf.TrueTypeFontSubSet     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r10.z4     // Catch:{ all -> 0x00fd }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r3 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00fd }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = r10.y4     // Catch:{ all -> 0x00fd }
            r3.<init>((com.itextpdf.text.pdf.RandomAccessFileOrArray) r1)     // Catch:{ all -> 0x00fd }
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x00fd }
            java.util.Set r12 = r12.keySet()     // Catch:{ all -> 0x00fd }
            r4.<init>(r12)     // Catch:{ all -> 0x00fd }
            int r5 = r10.D4     // Catch:{ all -> 0x00fd }
            r6 = 1
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00fd }
            byte[] r12 = r8.h()     // Catch:{ all -> 0x00fd }
            monitor-exit(r13)     // Catch:{ all -> 0x00fd }
        L_0x00a9:
            int r13 = r12.length
            int[] r13 = new int[]{r13}
            com.itextpdf.text.pdf.BaseFont$StreamFont r1 = new com.itextpdf.text.pdf.BaseFont$StreamFont
            int r2 = r10.b3
            r1.<init>((byte[]) r12, (int[]) r13, (int) r2)
            com.itextpdf.text.pdf.PdfWriter r12 = r9.f26463a
            com.itextpdf.text.pdf.PdfIndirectObject r12 = r12.v0(r1)
            goto L_0x0072
        L_0x00bc:
            java.lang.String r13 = ""
            boolean r1 = r10.f3
            if (r1 == 0) goto L_0x00c6
            java.lang.String r13 = com.itextpdf.text.pdf.BaseFont.o()
        L_0x00c6:
            r1 = 0
            com.itextpdf.text.pdf.PdfDictionary r12 = r10.C0(r12, r13, r1)
            com.itextpdf.text.pdf.PdfWriter r2 = r9.f26463a
            com.itextpdf.text.pdf.PdfIndirectObject r12 = r2.v0(r12)
            com.itextpdf.text.pdf.PdfIndirectReference r12 = r12.a()
            com.itextpdf.text.pdf.PdfDictionary r12 = r10.X0(r12, r13, r0)
            com.itextpdf.text.pdf.PdfWriter r2 = r9.f26463a
            com.itextpdf.text.pdf.PdfIndirectObject r12 = r2.v0(r12)
            com.itextpdf.text.pdf.PdfIndirectReference r12 = r12.a()
            com.itextpdf.text.pdf.PdfStream r0 = r10.b1(r0)
            if (r0 == 0) goto L_0x00f3
            com.itextpdf.text.pdf.PdfWriter r1 = r9.f26463a
            com.itextpdf.text.pdf.PdfIndirectObject r0 = r1.v0(r0)
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r0.a()
        L_0x00f3:
            com.itextpdf.text.pdf.PdfDictionary r10 = r10.Y0(r12, r13, r1)
            com.itextpdf.text.pdf.PdfWriter r12 = r9.f26463a
            r12.y0(r10, r11)
            return
        L_0x00fd:
            r10 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00fd }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.TtfUnicodeWriter.a(com.itextpdf.text.pdf.TrueTypeFontUnicode, com.itextpdf.text.pdf.PdfIndirectReference, java.lang.Object[], byte[]):void");
    }
}
