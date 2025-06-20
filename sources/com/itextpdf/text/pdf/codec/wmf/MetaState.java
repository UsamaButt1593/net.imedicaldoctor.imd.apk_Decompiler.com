package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfContentByte;
import java.util.ArrayList;
import java.util.Stack;

public class MetaState {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 1;
    public static final int D = 2;
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 0;
    public static final int v = 2;
    public static final int w = 6;
    public static final int x = 0;
    public static final int y = 8;
    public static final int z = 24;

    /* renamed from: a  reason: collision with root package name */
    public Stack<MetaState> f26758a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<MetaObject> f26759b;

    /* renamed from: c  reason: collision with root package name */
    public Point f26760c;

    /* renamed from: d  reason: collision with root package name */
    public MetaPen f26761d;

    /* renamed from: e  reason: collision with root package name */
    public MetaBrush f26762e;

    /* renamed from: f  reason: collision with root package name */
    public MetaFont f26763f;

    /* renamed from: g  reason: collision with root package name */
    public BaseColor f26764g;

    /* renamed from: h  reason: collision with root package name */
    public BaseColor f26765h;

    /* renamed from: i  reason: collision with root package name */
    public int f26766i;

    /* renamed from: j  reason: collision with root package name */
    public int f26767j;

    /* renamed from: k  reason: collision with root package name */
    public int f26768k;

    /* renamed from: l  reason: collision with root package name */
    public int f26769l;

    /* renamed from: m  reason: collision with root package name */
    public int f26770m;

    /* renamed from: n  reason: collision with root package name */
    public int f26771n;
    public int o;
    public int p;
    public float q;
    public float r;

    public MetaState() {
        this.f26764g = BaseColor.f25673b;
        this.f26765h = BaseColor.f25677f;
        this.f26766i = 2;
        this.f26767j = 1;
        this.f26768k = 1;
        this.f26758a = new Stack<>();
        this.f26759b = new ArrayList<>();
        this.f26760c = new Point(0, 0);
        this.f26761d = new MetaPen();
        this.f26762e = new MetaBrush();
        this.f26763f = new MetaFont();
    }

    public void A(int i2) {
        this.f26771n = i2;
    }

    public void B(int i2) {
        this.f26767j = i2;
    }

    public void C(float f2) {
        this.q = f2;
    }

    public void D(float f2) {
        this.r = f2;
    }

    public void E(int i2) {
        this.f26769l = i2;
    }

    public float F(float f2) {
        if (this.r < 0.0f) {
            f2 = -f2;
        }
        return (float) (this.q < 0.0f ? 3.141592653589793d - ((double) f2) : (double) f2);
    }

    public float G(int i2) {
        return ((((float) i2) - ((float) this.f26770m)) * this.q) / ((float) this.o);
    }

    public float H(int i2) {
        return (1.0f - ((((float) i2) - ((float) this.f26771n)) / ((float) this.p))) * this.r;
    }

    public void a(MetaObject metaObject) {
        for (int i2 = 0; i2 < this.f26759b.size(); i2++) {
            if (this.f26759b.get(i2) == null) {
                this.f26759b.set(i2, metaObject);
                return;
            }
        }
        this.f26759b.add(metaObject);
    }

    public void b(PdfContentByte pdfContentByte) {
        int size = this.f26758a.size();
        while (true) {
            int i2 = size - 1;
            if (size > 0) {
                pdfContentByte.U1();
                size = i2;
            } else {
                return;
            }
        }
    }

    public void c(int i2) {
        this.f26759b.set(i2, (Object) null);
    }

    public int d() {
        return this.f26766i;
    }

    public BaseColor e() {
        return this.f26764g;
    }

    public MetaBrush f() {
        return this.f26762e;
    }

    public MetaFont g() {
        return this.f26763f;
    }

    public MetaPen h() {
        return this.f26761d;
    }

    public Point i() {
        return this.f26760c;
    }

    public BaseColor j() {
        return this.f26765h;
    }

    public boolean k() {
        return this.f26768k == 0;
    }

    public int l() {
        return this.f26767j;
    }

    public int m() {
        return this.f26769l;
    }

    public void n(int i2, PdfContentByte pdfContentByte) {
        int min = i2 < 0 ? Math.min(-i2, this.f26758a.size()) : Math.max(this.f26758a.size() - i2, 0);
        if (min != 0) {
            MetaState metaState = null;
            while (true) {
                int i3 = min - 1;
                if (min != 0) {
                    pdfContentByte.U1();
                    metaState = this.f26758a.pop();
                    min = i3;
                } else {
                    y(metaState);
                    return;
                }
            }
        }
    }

    public void o(PdfContentByte pdfContentByte) {
        pdfContentByte.a2();
        this.f26758a.push(new MetaState(this));
    }

    public void p(int i2, PdfContentByte pdfContentByte) {
        String str;
        BaseColor baseColor;
        MetaObject metaObject = this.f26759b.get(i2);
        if (metaObject != null) {
            int a2 = metaObject.a();
            if (a2 == 1) {
                MetaPen metaPen = (MetaPen) metaObject;
                this.f26761d = metaPen;
                int d2 = metaPen.d();
                if (d2 != 5) {
                    pdfContentByte.l2(this.f26761d.b());
                    pdfContentByte.J2(Math.abs((((float) this.f26761d.c()) * this.q) / ((float) this.o)));
                    if (d2 == 1) {
                        pdfContentByte.E2(18.0f, 6.0f, 0.0f);
                    } else if (d2 != 2) {
                        if (d2 == 3) {
                            str = "[9 6 3 6]0 d\n";
                        } else if (d2 != 4) {
                            pdfContentByte.C2(0.0f);
                            return;
                        } else {
                            str = "[9 3 3 3 3 3]0 d\n";
                        }
                        pdfContentByte.M2(str);
                    } else {
                        pdfContentByte.D2(3.0f, 0.0f);
                    }
                }
            } else if (a2 == 2) {
                MetaBrush metaBrush = (MetaBrush) metaObject;
                this.f26762e = metaBrush;
                int d3 = metaBrush.d();
                if (d3 == 0) {
                    baseColor = this.f26762e.b();
                } else if (d3 == 2) {
                    baseColor = this.f26764g;
                } else {
                    return;
                }
                pdfContentByte.h2(baseColor);
            } else if (a2 == 3) {
                this.f26763f = (MetaFont) metaObject;
            }
        }
    }

    public void q(int i2) {
        this.f26766i = i2;
    }

    public void r(BaseColor baseColor) {
        this.f26764g = baseColor;
    }

    public void s(Point point) {
        this.f26760c = point;
    }

    public void t(BaseColor baseColor) {
        this.f26765h = baseColor;
    }

    public void u(int i2) {
        this.o = i2;
    }

    public void v(int i2) {
        this.p = i2;
    }

    public void w(PdfContentByte pdfContentByte) {
        if (this.f26768k == 0) {
            this.f26768k = 1;
            pdfContentByte.H2(1);
        }
    }

    public void x(PdfContentByte pdfContentByte) {
        if (this.f26768k != 0) {
            this.f26768k = 0;
            pdfContentByte.H2(0);
        }
    }

    public void y(MetaState metaState) {
        this.f26758a = metaState.f26758a;
        this.f26759b = metaState.f26759b;
        this.f26760c = metaState.f26760c;
        this.f26761d = metaState.f26761d;
        this.f26762e = metaState.f26762e;
        this.f26763f = metaState.f26763f;
        this.f26764g = metaState.f26764g;
        this.f26765h = metaState.f26765h;
        this.f26766i = metaState.f26766i;
        this.f26767j = metaState.f26767j;
        this.f26769l = metaState.f26769l;
        this.f26768k = metaState.f26768k;
        this.f26770m = metaState.f26770m;
        this.f26771n = metaState.f26771n;
        this.o = metaState.o;
        this.p = metaState.p;
        this.q = metaState.q;
        this.r = metaState.r;
    }

    public void z(int i2) {
        this.f26770m = i2;
    }

    public MetaState(MetaState metaState) {
        this.f26764g = BaseColor.f25673b;
        this.f26765h = BaseColor.f25677f;
        this.f26766i = 2;
        this.f26767j = 1;
        this.f26768k = 1;
        y(metaState);
    }
}
