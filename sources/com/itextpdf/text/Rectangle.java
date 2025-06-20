package com.itextpdf.text;

import com.itextpdf.text.pdf.GrayColor;
import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Element {
    public static final int l3 = -1;
    public static final int m3 = 1;
    public static final int n3 = 2;
    public static final int o3 = 4;
    public static final int p3 = 8;
    public static final int q3 = 0;
    public static final int r3 = 15;
    protected float X;
    protected int X2;
    protected float Y;
    protected BaseColor Y2;
    protected float Z;
    protected int Z2;
    protected boolean a3;
    protected float b3;
    protected float c3;
    protected float d3;
    protected float e3;
    protected float f3;
    protected BaseColor g3;
    protected BaseColor h3;
    protected BaseColor i3;
    protected BaseColor j3;
    protected BaseColor k3;
    protected float s;

    public Rectangle(float f2, float f4) {
        this(0.0f, 0.0f, f2, f4);
    }

    private void C0(float f2, int i2) {
        this.a3 = true;
        if (f2 > 0.0f) {
            j(i2);
        } else {
            i(i2);
        }
    }

    private float Z(float f2, int i2) {
        if ((i2 & this.Z2) != 0) {
            return f2 != -1.0f ? f2 : this.b3;
        }
        return 0.0f;
    }

    public float A() {
        return Z(this.f3, 2);
    }

    public void A0(boolean z) {
        this.a3 = z;
    }

    public void B0(Rectangle rectangle) {
        int i2 = rectangle.X2;
        if (i2 != 0) {
            this.X2 = i2;
        }
        BaseColor baseColor = rectangle.Y2;
        if (baseColor != null) {
            this.Y2 = baseColor;
        }
        int i4 = rectangle.Z2;
        if (i4 != -1) {
            this.Z2 = i4;
        }
        if (this.a3) {
            this.a3 = rectangle.a3;
        }
        float f2 = rectangle.b3;
        if (f2 != -1.0f) {
            this.b3 = f2;
        }
        float f4 = rectangle.c3;
        if (f4 != -1.0f) {
            this.c3 = f4;
        }
        float f5 = rectangle.d3;
        if (f5 != -1.0f) {
            this.d3 = f5;
        }
        float f6 = rectangle.e3;
        if (f6 != -1.0f) {
            this.e3 = f6;
        }
        float f7 = rectangle.f3;
        if (f7 != -1.0f) {
            this.f3 = f7;
        }
        BaseColor baseColor2 = rectangle.g3;
        if (baseColor2 != null) {
            this.g3 = baseColor2;
        }
        BaseColor baseColor3 = rectangle.h3;
        if (baseColor3 != null) {
            this.h3 = baseColor3;
        }
        BaseColor baseColor4 = rectangle.i3;
        if (baseColor4 != null) {
            this.i3 = baseColor4;
        }
        BaseColor baseColor5 = rectangle.j3;
        if (baseColor5 != null) {
            this.j3 = baseColor5;
        }
        BaseColor baseColor6 = rectangle.k3;
        if (baseColor6 != null) {
            this.k3 = baseColor6;
        }
    }

    public float C() {
        return Z(this.c3, 4);
    }

    public float F() {
        return Z(this.d3, 8);
    }

    public float G() {
        return Z(this.e3, 1);
    }

    public float H() {
        return this.X;
    }

    public float I(float f2) {
        return this.X + f2;
    }

    public float J() {
        BaseColor baseColor = this.Y2;
        if (baseColor instanceof GrayColor) {
            return ((GrayColor) baseColor).m();
        }
        return 0.0f;
    }

    public float N() {
        return this.Z - this.X;
    }

    public float O() {
        return this.s;
    }

    public float P(float f2) {
        return this.s + f2;
    }

    public float Q() {
        return this.Y;
    }

    public float R(float f2) {
        return this.Y - f2;
    }

    public int S() {
        return this.X2;
    }

    public float T() {
        return this.Z;
    }

    public boolean V() {
        return true;
    }

    public float W(float f2) {
        return this.Z - f2;
    }

    public List<Chunk> Y() {
        return new ArrayList();
    }

    public float a0() {
        return this.Y - this.s;
    }

    public boolean b0(int i2) {
        int i4 = this.Z2;
        return i4 != -1 && (i4 & i2) == i2;
    }

    public boolean c0() {
        int i2 = this.Z2;
        if (i2 == -1 || i2 == 0) {
            return false;
        }
        return this.b3 > 0.0f || this.c3 > 0.0f || this.d3 > 0.0f || this.e3 > 0.0f || this.f3 > 0.0f;
    }

    public boolean d0() {
        return this.a3;
    }

    public void e0() {
        float f2 = this.s;
        float f4 = this.Y;
        if (f2 > f4) {
            this.s = f4;
            this.Y = f2;
        }
        float f5 = this.X;
        float f6 = this.Z;
        if (f5 > f6) {
            this.X = f6;
            this.Z = f5;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return rectangle.s == this.s && rectangle.X == this.X && rectangle.Y == this.Y && rectangle.Z == this.Z && rectangle.X2 == this.X2;
    }

    public void f(Rectangle rectangle) {
        this.X2 = rectangle.X2;
        this.Y2 = rectangle.Y2;
        this.Z2 = rectangle.Z2;
        this.a3 = rectangle.a3;
        this.b3 = rectangle.b3;
        this.c3 = rectangle.c3;
        this.d3 = rectangle.d3;
        this.e3 = rectangle.e3;
        this.f3 = rectangle.f3;
        this.g3 = rectangle.g3;
        this.h3 = rectangle.h3;
        this.i3 = rectangle.i3;
        this.j3 = rectangle.j3;
        this.k3 = rectangle.k3;
    }

    public Rectangle f0(float f2, float f4) {
        Rectangle rectangle = new Rectangle(this);
        if (T() > f2) {
            rectangle.z0(f2);
            rectangle.i(1);
        }
        if (H() < f4) {
            rectangle.u0(f4);
            rectangle.i(2);
        }
        return rectangle;
    }

    public Rectangle g0() {
        Rectangle rectangle = new Rectangle(this.X, this.s, this.Z, this.Y);
        rectangle.y0(this.X2 + 90);
        return rectangle;
    }

    public void h0(BaseColor baseColor) {
        this.Y2 = baseColor;
    }

    public void i(int i2) {
        if (this.Z2 == -1) {
            this.Z2 = 0;
        }
        this.Z2 = (~i2) & this.Z2;
    }

    public void i0(int i2) {
        this.Z2 = i2;
    }

    public void j(int i2) {
        if (this.Z2 == -1) {
            this.Z2 = 0;
        }
        this.Z2 = i2 | this.Z2;
    }

    public void j0(BaseColor baseColor) {
        this.g3 = baseColor;
    }

    public BaseColor k() {
        return this.Y2;
    }

    public int l() {
        return this.Z2;
    }

    public void l0(BaseColor baseColor) {
        this.k3 = baseColor;
    }

    public void m0(BaseColor baseColor) {
        this.h3 = baseColor;
    }

    public void n0(BaseColor baseColor) {
        this.i3 = baseColor;
    }

    public void o0(BaseColor baseColor) {
        this.j3 = baseColor;
    }

    public BaseColor p() {
        return this.g3;
    }

    public void p0(float f2) {
        this.b3 = f2;
    }

    public void q0(float f2) {
        this.f3 = f2;
        C0(f2, 2);
    }

    public void r0(float f2) {
        this.c3 = f2;
        C0(f2, 4);
    }

    public BaseColor s() {
        BaseColor baseColor = this.k3;
        return baseColor == null ? this.g3 : baseColor;
    }

    public void s0(float f2) {
        this.d3 = f2;
        C0(f2, 8);
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void t0(float f2) {
        this.e3 = f2;
        C0(f2, 1);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Rectangle: ");
        stringBuffer.append(a0());
        stringBuffer.append('x');
        stringBuffer.append(N());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.X2);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }

    public int type() {
        return 30;
    }

    public BaseColor u() {
        BaseColor baseColor = this.h3;
        return baseColor == null ? this.g3 : baseColor;
    }

    public void u0(float f2) {
        this.X = f2;
    }

    public BaseColor v() {
        BaseColor baseColor = this.i3;
        return baseColor == null ? this.g3 : baseColor;
    }

    public void v0(float f2) {
        this.Y2 = new GrayColor(f2);
    }

    public BaseColor w() {
        BaseColor baseColor = this.j3;
        return baseColor == null ? this.g3 : baseColor;
    }

    public void w0(float f2) {
        this.s = f2;
    }

    public boolean x() {
        return false;
    }

    public void x0(float f2) {
        this.Y = f2;
    }

    public float y() {
        return this.b3;
    }

    public void y0(int i2) {
        int i4 = i2 % 360;
        this.X2 = i4;
        if (i4 != 90 && i4 != 180 && i4 != 270) {
            this.X2 = 0;
        }
    }

    public void z0(float f2) {
        this.Z = f2;
    }

    public Rectangle(float f2, float f4, float f5, float f6) {
        this.X2 = 0;
        this.Y2 = null;
        this.Z2 = -1;
        this.a3 = false;
        this.b3 = -1.0f;
        this.c3 = -1.0f;
        this.d3 = -1.0f;
        this.e3 = -1.0f;
        this.f3 = -1.0f;
        this.g3 = null;
        this.h3 = null;
        this.i3 = null;
        this.j3 = null;
        this.k3 = null;
        this.s = f2;
        this.X = f4;
        this.Y = f5;
        this.Z = f6;
    }

    public Rectangle(float f2, float f4, float f5, float f6, int i2) {
        this(f2, f4, f5, f6);
        y0(i2);
    }

    public Rectangle(float f2, float f4, int i2) {
        this(0.0f, 0.0f, f2, f4, i2);
    }

    public Rectangle(com.itextpdf.awt.geom.Rectangle rectangle) {
        this((float) rectangle.u(), (float) rectangle.v(), (float) (rectangle.u() + rectangle.t()), (float) (rectangle.v() + rectangle.o()));
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.s, rectangle.X, rectangle.Y, rectangle.Z);
        f(rectangle);
    }
}
