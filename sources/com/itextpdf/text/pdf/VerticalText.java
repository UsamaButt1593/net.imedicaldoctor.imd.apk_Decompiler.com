package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

public class VerticalText {

    /* renamed from: m  reason: collision with root package name */
    public static final int f26464m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f26465n = 2;

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<PdfChunk> f26466a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected PdfContentByte f26467b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26468c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f26469d = -1;

    /* renamed from: e  reason: collision with root package name */
    protected PdfChunk f26470e;

    /* renamed from: f  reason: collision with root package name */
    protected String f26471f;

    /* renamed from: g  reason: collision with root package name */
    protected float f26472g;

    /* renamed from: h  reason: collision with root package name */
    protected float f26473h;

    /* renamed from: i  reason: collision with root package name */
    protected float f26474i;

    /* renamed from: j  reason: collision with root package name */
    protected int f26475j;

    /* renamed from: k  reason: collision with root package name */
    protected float f26476k;

    /* renamed from: l  reason: collision with root package name */
    private Float f26477l = Float.valueOf(0.0f);

    public VerticalText(PdfContentByte pdfContentByte) {
        this.f26467b = pdfContentByte;
    }

    public void a(Chunk chunk) {
        this.f26466a.add(new PdfChunk(chunk, (PdfAction) null));
    }

    public void b(Phrase phrase) {
        for (Chunk pdfChunk : phrase.Y()) {
            this.f26466a.add(new PdfChunk(pdfChunk, (PdfAction) null));
        }
    }

    /* access modifiers changed from: protected */
    public PdfLine c(float f2) {
        if (this.f26466a.isEmpty()) {
            return null;
        }
        this.f26471f = null;
        this.f26470e = null;
        PdfLine pdfLine = new PdfLine(0.0f, f2, this.f26468c, 0.0f);
        int i2 = 0;
        while (true) {
            this.f26469d = i2;
            if (this.f26469d >= this.f26466a.size()) {
                return pdfLine;
            }
            PdfChunk pdfChunk = this.f26466a.get(this.f26469d);
            String pdfChunk2 = pdfChunk.toString();
            PdfChunk a2 = pdfLine.a(pdfChunk);
            this.f26470e = a2;
            if (a2 != null) {
                this.f26471f = pdfChunk.toString();
                pdfChunk.L(pdfChunk2);
                return pdfLine;
            }
            i2 = this.f26469d + 1;
        }
    }

    public int d() {
        return this.f26468c;
    }

    public float e() {
        return this.f26476k;
    }

    public float f() {
        return this.f26472g;
    }

    public int g() {
        return this.f26475j;
    }

    public float h() {
        return this.f26473h;
    }

    public float i() {
        return this.f26474i;
    }

    public int j() {
        return k(false);
    }

    public int k(boolean z) {
        PdfContentByte pdfContentByte;
        int i2;
        PdfContentByte pdfContentByte2 = this.f26467b;
        boolean z2 = false;
        if (pdfContentByte2 != null) {
            pdfContentByte = pdfContentByte2.U0();
        } else if (z) {
            pdfContentByte = null;
        } else {
            throw new NullPointerException(MessageLocalization.b("verticaltext.go.with.simulate.eq.eq.false.and.text.eq.eq.null", new Object[0]));
        }
        while (true) {
            if (this.f26475j <= 0) {
                i2 = this.f26466a.isEmpty() ? 3 : 2;
            } else if (this.f26466a.isEmpty()) {
                i2 = 1;
                break;
            } else {
                PdfLine c2 = c(this.f26476k);
                if (!z && !z2) {
                    this.f26467b.R();
                    z2 = true;
                }
                r();
                if (!z) {
                    this.f26467b.e3(this.f26473h, this.f26474i - c2.p());
                    s(c2, this.f26467b, pdfContentByte);
                }
                this.f26475j--;
                this.f26473h -= this.f26472g;
            }
        }
        if (z2) {
            this.f26467b.L0();
            this.f26467b.c(pdfContentByte);
        }
        return i2;
    }

    public void l(int i2) {
        this.f26468c = i2;
    }

    public void m(float f2) {
        this.f26476k = f2;
    }

    public void n(float f2) {
        this.f26472g = f2;
    }

    public void o(int i2) {
        this.f26475j = i2;
    }

    public void p(float f2, float f3) {
        this.f26473h = f2;
        this.f26474i = f3;
    }

    public void q(float f2, float f3, float f4, int i2, float f5) {
        this.f26473h = f2;
        this.f26474i = f3;
        this.f26476k = f4;
        this.f26475j = i2;
        n(f5);
    }

    /* access modifiers changed from: protected */
    public void r() {
        int i2 = this.f26469d;
        if (i2 >= 0) {
            if (i2 >= this.f26466a.size()) {
                this.f26466a.clear();
                return;
            }
            this.f26466a.get(this.f26469d).L(this.f26471f);
            this.f26466a.set(this.f26469d, this.f26470e);
            for (int i3 = this.f26469d - 1; i3 >= 0; i3--) {
                this.f26466a.remove(i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(com.itextpdf.text.pdf.PdfLine r11, com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.pdf.PdfContentByte r13) {
        /*
            r10 = this;
            java.util.Iterator r11 = r11.s()
            r13 = 0
            r0 = r13
        L_0x0006:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00ba
            java.lang.Object r1 = r11.next()
            com.itextpdf.text.pdf.PdfChunk r1 = (com.itextpdf.text.pdf.PdfChunk) r1
            boolean r2 = r1.y()
            if (r2 != 0) goto L_0x0031
            com.itextpdf.text.pdf.PdfFont r2 = r1.d()
            int r2 = r2.compareTo(r0)
            if (r2 == 0) goto L_0x0031
            com.itextpdf.text.pdf.PdfFont r0 = r1.d()
            com.itextpdf.text.pdf.BaseFont r2 = r0.c()
            float r3 = r0.g()
            r12.s2(r2, r3)
        L_0x0031:
            java.lang.String r2 = "TEXTRENDERMODE"
            java.lang.Object r2 = r1.e(r2)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            com.itextpdf.text.BaseColor r3 = r1.c()
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0078
            r6 = r2[r4]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r6 = r6 & 3
            if (r6 == 0) goto L_0x0051
            r12.h3(r6)
        L_0x0051:
            r7 = 2
            r8 = 1
            if (r6 == r8) goto L_0x005c
            if (r6 != r7) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            r2 = r13
        L_0x0059:
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x007b
        L_0x005c:
            r8 = r2[r8]
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            int r9 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x006b
            r12.J2(r8)
        L_0x006b:
            r2 = r2[r7]
            com.itextpdf.text.BaseColor r2 = (com.itextpdf.text.BaseColor) r2
            if (r2 != 0) goto L_0x0072
            r2 = r3
        L_0x0072:
            if (r2 == 0) goto L_0x007b
            r12.l2(r2)
            goto L_0x007b
        L_0x0078:
            r2 = r13
            r6 = 0
            goto L_0x0059
        L_0x007b:
            java.lang.String r7 = "CHAR_SPACING"
            java.lang.Object r7 = r1.e(r7)
            java.lang.Float r7 = (java.lang.Float) r7
            if (r7 == 0) goto L_0x0096
            java.lang.Float r9 = r10.f26477l
            boolean r9 = r9.equals(r7)
            if (r9 != 0) goto L_0x0096
            r10.f26477l = r7
            float r7 = r7.floatValue()
            r12.g2(r7)
        L_0x0096:
            if (r3 == 0) goto L_0x009b
            r12.h2(r3)
        L_0x009b:
            java.lang.String r1 = r1.toString()
            r12.m3(r1)
            if (r3 == 0) goto L_0x00a7
            r12.R1()
        L_0x00a7:
            if (r6 == 0) goto L_0x00ac
            r12.h3(r4)
        L_0x00ac:
            if (r2 == 0) goto L_0x00b1
            r12.S1()
        L_0x00b1:
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0006
            r12.J2(r5)
            goto L_0x0006
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.VerticalText.s(com.itextpdf.text.pdf.PdfLine, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte):void");
    }
}
