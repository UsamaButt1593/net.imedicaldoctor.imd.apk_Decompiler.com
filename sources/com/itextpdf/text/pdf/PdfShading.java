package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

public class PdfShading {

    /* renamed from: a  reason: collision with root package name */
    protected PdfDictionary f26303a;

    /* renamed from: b  reason: collision with root package name */
    protected PdfWriter f26304b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26305c;

    /* renamed from: d  reason: collision with root package name */
    protected ColorDetails f26306d;

    /* renamed from: e  reason: collision with root package name */
    protected PdfName f26307e;

    /* renamed from: f  reason: collision with root package name */
    protected PdfIndirectReference f26308f;

    /* renamed from: g  reason: collision with root package name */
    private BaseColor f26309g;

    /* renamed from: h  reason: collision with root package name */
    protected float[] f26310h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f26311i = false;

    protected PdfShading(PdfWriter pdfWriter) {
        this.f26304b = pdfWriter;
    }

    public static void b(BaseColor baseColor, BaseColor baseColor2) {
        int k2 = ExtendedColor.k(baseColor);
        if (k2 != ExtendedColor.k(baseColor2)) {
            throw new IllegalArgumentException(MessageLocalization.b("both.colors.must.be.of.the.same.type", new Object[0]));
        } else if (k2 == 3 && ((SpotColor) baseColor).m() != ((SpotColor) baseColor2).m()) {
            throw new IllegalArgumentException(MessageLocalization.b("the.spot.color.must.be.the.same.only.the.tint.can.vary", new Object[0]));
        } else if (k2 == 4 || k2 == 5) {
            s();
        }
    }

    public static float[] d(BaseColor baseColor) {
        int k2 = ExtendedColor.k(baseColor);
        if (k2 == 0) {
            return new float[]{((float) baseColor.g()) / 255.0f, ((float) baseColor.e()) / 255.0f, ((float) baseColor.d()) / 255.0f};
        } else if (k2 == 1) {
            return new float[]{((GrayColor) baseColor).m()};
        } else if (k2 == 2) {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            return new float[]{cMYKColor.n(), cMYKColor.o(), cMYKColor.p(), cMYKColor.m()};
        } else if (k2 == 3) {
            return new float[]{((SpotColor) baseColor).n()};
        } else if (k2 == 6) {
            return ((DeviceNColor) baseColor).n();
        } else {
            s();
            return null;
        }
    }

    public static PdfShading o(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, BaseColor baseColor, BaseColor baseColor2) {
        return p(pdfWriter, f2, f3, f4, f5, baseColor, baseColor2, true, true);
    }

    public static PdfShading p(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, BaseColor baseColor, BaseColor baseColor2, boolean z, boolean z2) {
        b(baseColor, baseColor2);
        return u(pdfWriter, baseColor, new float[]{f2, f3, f4, f5}, (float[]) null, PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, d(baseColor), d(baseColor2), 1.0f), new boolean[]{z, z2});
    }

    public static PdfShading q(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, float f6, float f7, BaseColor baseColor, BaseColor baseColor2) {
        return r(pdfWriter, f2, f3, f4, f5, f6, f7, baseColor, baseColor2, true, true);
    }

    public static PdfShading r(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, float f6, float f7, BaseColor baseColor, BaseColor baseColor2, boolean z, boolean z2) {
        b(baseColor, baseColor2);
        return v(pdfWriter, baseColor, new float[]{f2, f3, f4, f5, f6, f7}, (float[]) null, PdfFunction.c(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, d(baseColor), d(baseColor2), 1.0f), new boolean[]{z, z2});
    }

    public static void s() {
        throw new IllegalArgumentException(MessageLocalization.b("a.tiling.or.shading.pattern.cannot.be.used.as.a.color.space.in.a.shading.pattern", new Object[0]));
    }

    public static PdfShading t(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction) {
        PdfShading pdfShading = new PdfShading(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfShading.f26303a = pdfDictionary;
        pdfShading.f26305c = 1;
        pdfDictionary.V0(PdfName.Ne, new PdfNumber(1));
        pdfShading.m(baseColor);
        if (fArr != null) {
            pdfShading.f26303a.V0(PdfName.Q6, new PdfArray(fArr));
        }
        if (fArr2 != null) {
            pdfShading.f26303a.V0(PdfName.Qa, new PdfArray(fArr2));
        }
        pdfShading.f26303a.V0(PdfName.E8, pdfFunction.a());
        return pdfShading;
    }

    public static PdfShading u(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        boolean z;
        PdfShading pdfShading = new PdfShading(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfShading.f26303a = pdfDictionary;
        pdfShading.f26305c = 2;
        pdfDictionary.V0(PdfName.Ne, new PdfNumber(2));
        pdfShading.m(baseColor);
        pdfShading.f26303a.V0(PdfName.O5, new PdfArray(fArr));
        if (fArr2 != null) {
            pdfShading.f26303a.V0(PdfName.Q6, new PdfArray(fArr2));
        }
        pdfShading.f26303a.V0(PdfName.E8, pdfFunction.a());
        if (zArr != null && ((z = zArr[0]) || zArr[1])) {
            PdfArray pdfArray = new PdfArray((PdfObject) z ? PdfBoolean.j3 : PdfBoolean.k3);
            pdfArray.a0(zArr[1] ? PdfBoolean.j3 : PdfBoolean.k3);
            pdfShading.f26303a.V0(PdfName.y7, pdfArray);
        }
        return pdfShading;
    }

    public static PdfShading v(PdfWriter pdfWriter, BaseColor baseColor, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        PdfShading u = u(pdfWriter, baseColor, fArr, fArr2, pdfFunction, zArr);
        u.f26305c = 3;
        u.f26303a.V0(PdfName.Ne, new PdfNumber(3));
        return u;
    }

    public void a() throws IOException {
        float[] fArr = this.f26310h;
        if (fArr != null) {
            this.f26303a.V0(PdfName.n4, new PdfArray(fArr));
        }
        if (this.f26311i) {
            this.f26303a.V0(PdfName.R3, PdfBoolean.j3);
        }
        this.f26304b.y0(this.f26303a, h());
    }

    public float[] c() {
        return this.f26310h;
    }

    /* access modifiers changed from: package-private */
    public ColorDetails e() {
        return this.f26306d;
    }

    public BaseColor f() {
        return this.f26309g;
    }

    /* access modifiers changed from: package-private */
    public PdfName g() {
        return this.f26307e;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference h() {
        if (this.f26308f == null) {
            this.f26308f = this.f26304b.D1();
        }
        return this.f26308f;
    }

    /* access modifiers changed from: package-private */
    public PdfWriter i() {
        return this.f26304b;
    }

    public boolean j() {
        return this.f26311i;
    }

    public void k(boolean z) {
        this.f26311i = z;
    }

    public void l(float[] fArr) {
        if (fArr.length == 4) {
            this.f26310h = fArr;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("bbox.must.be.a.4.element.array", new Object[0]));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        r3 = r0.n0(r3);
        r2.f26306d = r3;
        r3 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        r3 = com.itextpdf.text.pdf.PdfName.B6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        r2.f26303a.V0(com.itextpdf.text.pdf.PdfName.w5, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(com.itextpdf.text.BaseColor r3) {
        /*
            r2 = this;
            r2.f26309g = r3
            int r0 = com.itextpdf.text.pdf.ExtendedColor.k(r3)
            switch(r0) {
                case 1: goto L_0x002f;
                case 2: goto L_0x002c;
                case 3: goto L_0x0023;
                case 4: goto L_0x001d;
                case 5: goto L_0x001d;
                case 6: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0020
        L_0x000a:
            com.itextpdf.text.pdf.DeviceNColor r3 = (com.itextpdf.text.pdf.DeviceNColor) r3
            com.itextpdf.text.pdf.PdfWriter r0 = r2.f26304b
            com.itextpdf.text.pdf.PdfDeviceNColor r3 = r3.m()
        L_0x0012:
            com.itextpdf.text.pdf.ColorDetails r3 = r0.n0(r3)
            r2.f26306d = r3
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.b()
            goto L_0x0031
        L_0x001d:
            s()
        L_0x0020:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.B6
            goto L_0x0031
        L_0x0023:
            com.itextpdf.text.pdf.SpotColor r3 = (com.itextpdf.text.pdf.SpotColor) r3
            com.itextpdf.text.pdf.PdfWriter r0 = r2.f26304b
            com.itextpdf.text.pdf.PdfSpotColor r3 = r3.m()
            goto L_0x0012
        L_0x002c:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.C6
            goto L_0x0031
        L_0x002f:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.A6
        L_0x0031:
            com.itextpdf.text.pdf.PdfDictionary r0 = r2.f26303a
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.w5
            r0.V0(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfShading.m(com.itextpdf.text.BaseColor):void");
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
        this.f26307e = new PdfName("Sh" + i2);
    }
}
