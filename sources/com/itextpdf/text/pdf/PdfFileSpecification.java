package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.collection.PdfCollectionItem;
import java.io.IOException;
import java.io.OutputStream;

public class PdfFileSpecification extends PdfDictionary {
    protected PdfWriter p3;
    protected PdfIndirectReference q3;

    public PdfFileSpecification() {
        super(PdfName.S7);
    }

    public static PdfFileSpecification E1(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.p3 = pdfWriter;
        pdfFileSpecification.V0(PdfName.B8, PdfName.Zg);
        pdfFileSpecification.V0(PdfName.F7, new PdfString(str));
        return pdfFileSpecification;
    }

    public static PdfFileSpecification m1(PdfWriter pdfWriter, String str, String str2, byte[] bArr) throws IOException {
        return n1(pdfWriter, str, str2, bArr, 9);
    }

    public static PdfFileSpecification n1(PdfWriter pdfWriter, String str, String str2, byte[] bArr, int i2) throws IOException {
        return o1(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, i2);
    }

    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v3, types: [com.itextpdf.text.pdf.PdfIndirectReference, com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b A[SYNTHETIC, Splitter:B:50:0x010b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.pdf.PdfFileSpecification o1(com.itextpdf.text.pdf.PdfWriter r4, java.lang.String r5, java.lang.String r6, byte[] r7, java.lang.String r8, com.itextpdf.text.pdf.PdfDictionary r9, int r10) throws java.io.IOException {
        /*
            com.itextpdf.text.pdf.PdfFileSpecification r0 = new com.itextpdf.text.pdf.PdfFileSpecification
            r0.<init>()
            r0.p3 = r4
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.F7
            com.itextpdf.text.pdf.PdfString r2 = new com.itextpdf.text.pdf.PdfString
            r2.<init>((java.lang.String) r6)
            r0.V0(r1, r2)
            r1 = 0
            r0.x1(r6, r1)
            r6 = 0
            if (r7 != 0) goto L_0x007c
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r4.D1()     // Catch:{ all -> 0x002e }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x002e }
            r3.<init>(r5)     // Catch:{ all -> 0x002e }
            boolean r3 = r3.canRead()     // Catch:{ all -> 0x002e }
            if (r3 == 0) goto L_0x0031
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002e }
            r1.<init>(r5)     // Catch:{ all -> 0x002e }
            r6 = r1
            goto L_0x0074
        L_0x002e:
            r4 = move-exception
            goto L_0x0109
        L_0x0031:
            java.lang.String r3 = "file:/"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "http://"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "https://"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "jar:"
            boolean r3 = r5.startsWith(r3)     // Catch:{ all -> 0x002e }
            if (r3 == 0) goto L_0x0052
            goto L_0x006a
        L_0x0052:
            java.io.InputStream r6 = com.itextpdf.text.io.StreamUtil.b(r5)     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x0059
            goto L_0x0074
        L_0x0059:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x002e }
            java.lang.String r7 = "1.not.found.as.file.or.resource"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x002e }
            r8[r1] = r5     // Catch:{ all -> 0x002e }
            java.lang.String r5 = com.itextpdf.text.error_messages.MessageLocalization.b(r7, r8)     // Catch:{ all -> 0x002e }
            r4.<init>(r5)     // Catch:{ all -> 0x002e }
            throw r4     // Catch:{ all -> 0x002e }
        L_0x006a:
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x002e }
            r1.<init>(r5)     // Catch:{ all -> 0x002e }
            java.io.InputStream r5 = r1.openStream()     // Catch:{ all -> 0x002e }
            r6 = r5
        L_0x0074:
            com.itextpdf.text.pdf.PdfEFStream r5 = new com.itextpdf.text.pdf.PdfEFStream     // Catch:{ all -> 0x002e }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x002e }
            r1 = r6
            r6 = r2
            goto L_0x0082
        L_0x007c:
            com.itextpdf.text.pdf.PdfEFStream r5 = new com.itextpdf.text.pdf.PdfEFStream     // Catch:{ all -> 0x002e }
            r5.<init>(r7)     // Catch:{ all -> 0x002e }
            r1 = r6
        L_0x0082:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Kg     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.i7     // Catch:{ all -> 0x0097 }
            r5.V0(r2, r3)     // Catch:{ all -> 0x0097 }
            r5.i1(r10)     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfDictionary r10 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ all -> 0x0097 }
            r10.<init>()     // Catch:{ all -> 0x0097 }
            if (r9 == 0) goto L_0x009a
            r10.T0(r9)     // Catch:{ all -> 0x0097 }
            goto L_0x009a
        L_0x0097:
            r4 = move-exception
            r6 = r1
            goto L_0x0109
        L_0x009a:
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.ib     // Catch:{ all -> 0x0097 }
            boolean r2 = r10.a0(r9)     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x00aa
            com.itextpdf.text.pdf.PdfDate r2 = new com.itextpdf.text.pdf.PdfDate     // Catch:{ all -> 0x0097 }
            r2.<init>()     // Catch:{ all -> 0x0097 }
            r10.V0(r9, r2)     // Catch:{ all -> 0x0097 }
        L_0x00aa:
            if (r7 != 0) goto L_0x00b2
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Cc     // Catch:{ all -> 0x0097 }
            r5.V0(r9, r6)     // Catch:{ all -> 0x0097 }
            goto L_0x00c5
        L_0x00b2:
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Ve     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ all -> 0x0097 }
            int r3 = r5.m1()     // Catch:{ all -> 0x0097 }
            r2.<init>((int) r3)     // Catch:{ all -> 0x0097 }
            r10.V0(r9, r2)     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Cc     // Catch:{ all -> 0x0097 }
            r5.V0(r9, r10)     // Catch:{ all -> 0x0097 }
        L_0x00c5:
            if (r8 == 0) goto L_0x00d1
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Cf     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfName r2 = new com.itextpdf.text.pdf.PdfName     // Catch:{ all -> 0x0097 }
            r2.<init>((java.lang.String) r8)     // Catch:{ all -> 0x0097 }
            r5.V0(r9, r2)     // Catch:{ all -> 0x0097 }
        L_0x00d1:
            com.itextpdf.text.pdf.PdfIndirectObject r8 = r4.v0(r5)     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfIndirectReference r8 = r8.a()     // Catch:{ all -> 0x0097 }
            if (r7 != 0) goto L_0x00ef
            r5.p1()     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Ve     // Catch:{ all -> 0x0097 }
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ all -> 0x0097 }
            int r5 = r5.m1()     // Catch:{ all -> 0x0097 }
            r9.<init>((int) r5)     // Catch:{ all -> 0x0097 }
            r10.V0(r7, r9)     // Catch:{ all -> 0x0097 }
            r4.y0(r10, r6)     // Catch:{ all -> 0x0097 }
        L_0x00ef:
            if (r1 == 0) goto L_0x00f4
            r1.close()     // Catch:{ Exception -> 0x00f4 }
        L_0x00f4:
            com.itextpdf.text.pdf.PdfDictionary r4 = new com.itextpdf.text.pdf.PdfDictionary
            r4.<init>()
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.F7
            r4.V0(r5, r8)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Qg
            r4.V0(r5, r8)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.e7
            r0.V0(r5, r4)
            return r0
        L_0x0109:
            if (r6 == 0) goto L_0x010e
            r6.close()     // Catch:{ Exception -> 0x010e }
        L_0x010e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfFileSpecification.o1(com.itextpdf.text.pdf.PdfWriter, java.lang.String, java.lang.String, byte[], java.lang.String, com.itextpdf.text.pdf.PdfDictionary, int):com.itextpdf.text.pdf.PdfFileSpecification");
    }

    public static PdfFileSpecification p1(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z) throws IOException {
        return o1(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, z ? 9 : 0);
    }

    public static PdfFileSpecification q1(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z, String str3, PdfDictionary pdfDictionary) throws IOException {
        return o1(pdfWriter, str, str2, bArr, str3, pdfDictionary, z ? 9 : 0);
    }

    public static PdfFileSpecification s1(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.p3 = pdfWriter;
        pdfFileSpecification.V0(PdfName.F7, new PdfString(str));
        pdfFileSpecification.x1(str, false);
        return pdfFileSpecification;
    }

    public void B1(boolean z) {
        V0(PdfName.kh, new PdfBoolean(z));
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 10, this);
        super.T(pdfWriter, outputStream);
    }

    public void f1(PdfCollectionItem pdfCollectionItem) {
        V0(PdfName.h5, pdfCollectionItem);
    }

    public void i1(String str, boolean z) {
        V0(PdfName.u6, new PdfString(str, z ? PdfObject.h3 : PdfObject.g3));
    }

    public PdfIndirectReference v1() throws IOException {
        PdfIndirectReference pdfIndirectReference = this.q3;
        if (pdfIndirectReference != null) {
            return pdfIndirectReference;
        }
        PdfIndirectReference a2 = this.p3.v0(this).a();
        this.q3 = a2;
        return a2;
    }

    public void w1(byte[] bArr) {
        V0(PdfName.F7, new PdfString(bArr).i0(true));
    }

    public void x1(String str, boolean z) {
        V0(PdfName.Qg, new PdfString(str, z ? PdfObject.h3 : PdfObject.g3));
    }
}
