package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MetaFont extends MetaObject {
    static final int A = 1;
    static final int B = 2;
    static final int C = 3;
    static final int D = 4;
    static final int E = 5;
    static final int F = 600;
    static final int G = 32;
    static final int H = 2;
    static final int I = 4;
    static final String[] p = {"Courier", "Courier-Bold", "Courier-Oblique", "Courier-BoldOblique", "Helvetica", "Helvetica-Bold", "Helvetica-Oblique", "Helvetica-BoldOblique", "Times-Roman", "Times-Bold", "Times-Italic", "Times-BoldItalic", "Symbol", "ZapfDingbats"};
    static final int q = 1;
    static final int r = 2;
    static final int s = 0;
    static final int t = 4;
    static final int u = 8;
    static final int v = 12;
    static final int w = 0;
    static final int x = 1;
    static final int y = 2;
    static final int z = 0;

    /* renamed from: f  reason: collision with root package name */
    int f26735f;

    /* renamed from: g  reason: collision with root package name */
    float f26736g;

    /* renamed from: h  reason: collision with root package name */
    int f26737h;

    /* renamed from: i  reason: collision with root package name */
    int f26738i;

    /* renamed from: j  reason: collision with root package name */
    boolean f26739j;

    /* renamed from: k  reason: collision with root package name */
    boolean f26740k;

    /* renamed from: l  reason: collision with root package name */
    int f26741l;

    /* renamed from: m  reason: collision with root package name */
    int f26742m;

    /* renamed from: n  reason: collision with root package name */
    String f26743n = "arial";
    BaseFont o = null;

    public MetaFont() {
        this.f26748a = 3;
    }

    public float b() {
        return this.f26736g;
    }

    public BaseFont c() {
        String str;
        BaseFont baseFont = this.o;
        if (baseFont != null) {
            return baseFont;
        }
        BaseFont c2 = FontFactory.m(this.f26743n, "Cp1252", true, 10.0f, (this.f26738i != 0 ? 2 : 0) | (this.f26737h != 0 ? 1 : 0)).c();
        this.o = c2;
        if (c2 != null) {
            return c2;
        }
        if (this.f26743n.indexOf("courier") != -1 || this.f26743n.indexOf("terminal") != -1 || this.f26743n.indexOf("fixedsys") != -1) {
            str = p[this.f26738i + this.f26737h];
        } else if (this.f26743n.indexOf("ms sans serif") != -1 || this.f26743n.indexOf("arial") != -1 || this.f26743n.indexOf("system") != -1) {
            str = p[this.f26738i + 4 + this.f26737h];
        } else if (this.f26743n.indexOf("arial black") != -1) {
            str = p[this.f26738i + 5];
        } else if (this.f26743n.indexOf("times") != -1 || this.f26743n.indexOf("ms serif") != -1 || this.f26743n.indexOf("roman") != -1) {
            str = p[this.f26738i + 8 + this.f26737h];
        } else if (this.f26743n.indexOf("symbol") != -1) {
            str = p[12];
        } else {
            int i2 = this.f26742m;
            int i3 = i2 & 3;
            int i4 = (i2 >> 4) & 7;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        str = p[this.f26738i + this.f26737h];
                    } else if (!(i4 == 4 || i4 == 5)) {
                        String[] strArr = p;
                        str = i3 != 1 ? strArr[this.f26738i + 4 + this.f26737h] : strArr[this.f26738i + this.f26737h];
                    }
                }
                str = p[this.f26738i + 4 + this.f26737h];
            } else {
                str = p[this.f26738i + 8 + this.f26737h];
            }
        }
        try {
            BaseFont j2 = BaseFont.j(str, "Cp1252", false);
            this.o = j2;
            return j2;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public float d(MetaState metaState) {
        return Math.abs(metaState.H(this.f26735f) - metaState.H(0)) * Document.n3;
    }

    public void e(InputMeta inputMeta) throws IOException {
        this.f26735f = Math.abs(inputMeta.e());
        int i2 = 2;
        inputMeta.g(2);
        this.f26736g = (float) ((((double) inputMeta.e()) / 1800.0d) * 3.141592653589793d);
        inputMeta.g(2);
        boolean z2 = true;
        this.f26737h = inputMeta.e() >= 600 ? 1 : 0;
        if (inputMeta.b() == 0) {
            i2 = 0;
        }
        this.f26738i = i2;
        this.f26739j = inputMeta.b() != 0;
        if (inputMeta.b() == 0) {
            z2 = false;
        }
        this.f26740k = z2;
        this.f26741l = inputMeta.b();
        inputMeta.g(3);
        this.f26742m = inputMeta.b();
        byte[] bArr = new byte[32];
        int i3 = 0;
        while (i3 < 32) {
            int b2 = inputMeta.b();
            if (b2 != 0) {
                bArr[i3] = (byte) b2;
                i3++;
            }
        }
        try {
            this.f26743n = new String(bArr, 0, i3, "Cp1252");
        } catch (UnsupportedEncodingException unused) {
            this.f26743n = new String(bArr, 0, i3);
        }
        this.f26743n = this.f26743n.toLowerCase();
    }

    public boolean f() {
        return this.f26740k;
    }

    public boolean g() {
        return this.f26739j;
    }
}
