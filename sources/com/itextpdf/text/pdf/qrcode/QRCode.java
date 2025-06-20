package com.itextpdf.text.pdf.qrcode;

public final class QRCode {

    /* renamed from: k  reason: collision with root package name */
    public static final int f27223k = 8;

    /* renamed from: a  reason: collision with root package name */
    private Mode f27224a = null;

    /* renamed from: b  reason: collision with root package name */
    private ErrorCorrectionLevel f27225b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f27226c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f27227d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f27228e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f27229f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f27230g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f27231h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f27232i = -1;

    /* renamed from: j  reason: collision with root package name */
    private ByteMatrix f27233j = null;

    public static boolean m(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public int a(int i2, int i3) {
        byte b2 = this.f27233j.b(i2, i3);
        if (b2 == 0 || b2 == 1) {
            return b2;
        }
        throw new RuntimeException("Bad value");
    }

    public ErrorCorrectionLevel b() {
        return this.f27225b;
    }

    public int c() {
        return this.f27228e;
    }

    public ByteMatrix d() {
        return this.f27233j;
    }

    public int e() {
        return this.f27227d;
    }

    public Mode f() {
        return this.f27224a;
    }

    public int g() {
        return this.f27230g;
    }

    public int h() {
        return this.f27231h;
    }

    public int i() {
        return this.f27232i;
    }

    public int j() {
        return this.f27229f;
    }

    public int k() {
        return this.f27226c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r0 = r3.f27233j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r0 = r3.f27228e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l() {
        /*
            r3 = this;
            com.itextpdf.text.pdf.qrcode.Mode r0 = r3.f27224a
            if (r0 == 0) goto L_0x0050
            com.itextpdf.text.pdf.qrcode.ErrorCorrectionLevel r0 = r3.f27225b
            if (r0 == 0) goto L_0x0050
            int r0 = r3.f27226c
            r1 = -1
            if (r0 == r1) goto L_0x0050
            int r0 = r3.f27227d
            if (r0 == r1) goto L_0x0050
            int r0 = r3.f27228e
            if (r0 == r1) goto L_0x0050
            int r2 = r3.f27229f
            if (r2 == r1) goto L_0x0050
            int r2 = r3.f27230g
            if (r2 == r1) goto L_0x0050
            int r2 = r3.f27231h
            if (r2 == r1) goto L_0x0050
            int r2 = r3.f27232i
            if (r2 == r1) goto L_0x0050
            boolean r0 = m(r0)
            if (r0 == 0) goto L_0x0050
            int r0 = r3.f27229f
            int r1 = r3.f27230g
            int r2 = r3.f27231h
            int r1 = r1 + r2
            if (r0 != r1) goto L_0x0050
            com.itextpdf.text.pdf.qrcode.ByteMatrix r0 = r3.f27233j
            if (r0 == 0) goto L_0x0050
            int r1 = r3.f27227d
            int r0 = r0.e()
            if (r1 != r0) goto L_0x0050
            com.itextpdf.text.pdf.qrcode.ByteMatrix r0 = r3.f27233j
            int r0 = r0.e()
            com.itextpdf.text.pdf.qrcode.ByteMatrix r1 = r3.f27233j
            int r1 = r1.d()
            if (r0 != r1) goto L_0x0050
            r0 = 1
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.qrcode.QRCode.l():boolean");
    }

    public void n(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f27225b = errorCorrectionLevel;
    }

    public void o(int i2) {
        this.f27228e = i2;
    }

    public void p(ByteMatrix byteMatrix) {
        this.f27233j = byteMatrix;
    }

    public void q(int i2) {
        this.f27227d = i2;
    }

    public void r(Mode mode) {
        this.f27224a = mode;
    }

    public void s(int i2) {
        this.f27230g = i2;
    }

    public void t(int i2) {
        this.f27231h = i2;
    }

    public String toString() {
        String byteMatrix;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("<<\n");
        stringBuffer.append(" mode: ");
        stringBuffer.append(this.f27224a);
        stringBuffer.append("\n ecLevel: ");
        stringBuffer.append(this.f27225b);
        stringBuffer.append("\n version: ");
        stringBuffer.append(this.f27226c);
        stringBuffer.append("\n matrixWidth: ");
        stringBuffer.append(this.f27227d);
        stringBuffer.append("\n maskPattern: ");
        stringBuffer.append(this.f27228e);
        stringBuffer.append("\n numTotalBytes: ");
        stringBuffer.append(this.f27229f);
        stringBuffer.append("\n numDataBytes: ");
        stringBuffer.append(this.f27230g);
        stringBuffer.append("\n numECBytes: ");
        stringBuffer.append(this.f27231h);
        stringBuffer.append("\n numRSBlocks: ");
        stringBuffer.append(this.f27232i);
        if (this.f27233j == null) {
            byteMatrix = "\n matrix: null\n";
        } else {
            stringBuffer.append("\n matrix:\n");
            byteMatrix = this.f27233j.toString();
        }
        stringBuffer.append(byteMatrix);
        stringBuffer.append(">>\n");
        return stringBuffer.toString();
    }

    public void u(int i2) {
        this.f27232i = i2;
    }

    public void v(int i2) {
        this.f27229f = i2;
    }

    public void w(int i2) {
        this.f27226c = i2;
    }
}
