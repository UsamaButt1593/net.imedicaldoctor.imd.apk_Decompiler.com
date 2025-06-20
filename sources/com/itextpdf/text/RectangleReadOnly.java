package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

public class RectangleReadOnly extends Rectangle {
    public RectangleReadOnly(float f2, float f3) {
        super(0.0f, 0.0f, f2, f3);
    }

    private void D0() {
        throw new UnsupportedOperationException(MessageLocalization.b("rectanglereadonly.this.rectangle.is.read.only", new Object[0]));
    }

    public void A0(boolean z) {
        D0();
    }

    public void B0(Rectangle rectangle) {
        D0();
    }

    public void e0() {
        D0();
    }

    public void f(Rectangle rectangle) {
        D0();
    }

    public void h0(BaseColor baseColor) {
        D0();
    }

    public void i(int i2) {
        D0();
    }

    public void i0(int i2) {
        D0();
    }

    public void j(int i2) {
        D0();
    }

    public void j0(BaseColor baseColor) {
        D0();
    }

    public void l0(BaseColor baseColor) {
        D0();
    }

    public void m0(BaseColor baseColor) {
        D0();
    }

    public void n0(BaseColor baseColor) {
        D0();
    }

    public void o0(BaseColor baseColor) {
        D0();
    }

    public void p0(float f2) {
        D0();
    }

    public void q0(float f2) {
        D0();
    }

    public void r0(float f2) {
        D0();
    }

    public void s0(float f2) {
        D0();
    }

    public void t0(float f2) {
        D0();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RectangleReadOnly: ");
        stringBuffer.append(a0());
        stringBuffer.append('x');
        stringBuffer.append(N());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.X2);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }

    public void u0(float f2) {
        D0();
    }

    public void v0(float f2) {
        D0();
    }

    public void w0(float f2) {
        D0();
    }

    public void x0(float f2) {
        D0();
    }

    public void y0(int i2) {
        D0();
    }

    public void z0(float f2) {
        D0();
    }

    public RectangleReadOnly(float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
    }

    public RectangleReadOnly(float f2, float f3, float f4, float f5, int i2) {
        super(f2, f3, f4, f5);
        super.y0(i2);
    }

    public RectangleReadOnly(float f2, float f3, int i2) {
        super(0.0f, 0.0f, f2, f3);
        super.y0(i2);
    }

    public RectangleReadOnly(Rectangle rectangle) {
        super(rectangle.s, rectangle.X, rectangle.Y, rectangle.Z);
        super.f(rectangle);
    }
}
