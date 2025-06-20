package com.itextpdf.text.pdf;

public class PdfDestination extends PdfArray {
    public static final int k3 = 0;
    public static final int l3 = 1;
    public static final int m3 = 2;
    public static final int n3 = 3;
    public static final int o3 = 4;
    public static final int p3 = 5;
    public static final int q3 = 6;
    public static final int r3 = 7;
    private boolean j3 = false;

    public PdfDestination(int i2) {
        a0(i2 == 5 ? PdfName.b8 : PdfName.X7);
    }

    public boolean X0(PdfIndirectReference pdfIndirectReference) {
        if (this.j3) {
            return false;
        }
        i0(pdfIndirectReference);
        this.j3 = true;
        return true;
    }

    public boolean Z0() {
        return this.j3;
    }

    public PdfDestination(int i2, float f2) {
        super((PdfObject) new PdfNumber(f2));
        i0(i2 != 3 ? i2 != 6 ? i2 != 7 ? PdfName.Y7 : PdfName.d8 : PdfName.c8 : PdfName.Z7);
    }

    public PdfDestination(int i2, float f2, float f3, float f4) {
        super((PdfObject) PdfName.f26251fi);
        if (f2 < 0.0f) {
            a0(PdfNull.i3);
        } else {
            a0(new PdfNumber(f2));
        }
        a0(f3 < 0.0f ? PdfNull.i3 : new PdfNumber(f3));
        a0(new PdfNumber(f4));
    }

    public PdfDestination(int i2, float f2, float f3, float f4, float f5) {
        super((PdfObject) PdfName.a8);
        a0(new PdfNumber(f2));
        a0(new PdfNumber(f3));
        a0(new PdfNumber(f4));
        a0(new PdfNumber(f5));
    }

    public PdfDestination(PdfDestination pdfDestination) {
        super((PdfArray) pdfDestination);
        this.j3 = pdfDestination.j3;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023  */
    public PdfDestination(java.lang.String r3) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.j3 = r0
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r0.<init>(r3)
            boolean r3 = r0.hasMoreTokens()
            if (r3 == 0) goto L_0x001d
            com.itextpdf.text.pdf.PdfName r3 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r1 = r0.nextToken()
            r3.<init>((java.lang.String) r1)
        L_0x001a:
            r2.a0(r3)
        L_0x001d:
            boolean r3 = r0.hasMoreTokens()
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = r0.nextToken()
            java.lang.String r1 = "null"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0035
            com.itextpdf.text.pdf.PdfNull r3 = new com.itextpdf.text.pdf.PdfNull
            r3.<init>()
            goto L_0x001a
        L_0x0035:
            com.itextpdf.text.pdf.PdfNumber r1 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ RuntimeException -> 0x003e }
            r1.<init>((java.lang.String) r3)     // Catch:{ RuntimeException -> 0x003e }
            r2.a0(r1)     // Catch:{ RuntimeException -> 0x003e }
            goto L_0x001d
        L_0x003e:
            com.itextpdf.text.pdf.PdfNull r3 = new com.itextpdf.text.pdf.PdfNull
            r3.<init>()
            goto L_0x001a
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDestination.<init>(java.lang.String):void");
    }
}
