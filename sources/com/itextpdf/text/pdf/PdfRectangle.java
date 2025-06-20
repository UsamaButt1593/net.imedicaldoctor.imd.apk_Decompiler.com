package com.itextpdf.text.pdf;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.Rectangle;

public class PdfRectangle extends NumberArray {
    private float j3;
    private float k3;
    private float l3;
    private float m3;

    public PdfRectangle(float f2, float f3) {
        this(0.0f, 0.0f, f2, f3, 0);
    }

    public float X0() {
        return this.k3;
    }

    public float Z0(int i2) {
        return this.k3 + ((float) i2);
    }

    public boolean a0(PdfObject pdfObject) {
        return false;
    }

    public Rectangle a1() {
        return new Rectangle(i1(), X0(), n1(), q1());
    }

    public boolean d0(float[] fArr) {
        return false;
    }

    public boolean e0(int[] iArr) {
        return false;
    }

    public float f1() {
        return this.m3 - this.k3;
    }

    public void i0(PdfObject pdfObject) {
    }

    public float i1() {
        return this.j3;
    }

    public float m1(int i2) {
        return this.j3 + ((float) i2);
    }

    public float n1() {
        return this.l3;
    }

    public float o1(int i2) {
        return this.l3 - ((float) i2);
    }

    public PdfRectangle p1() {
        return new PdfRectangle(this.k3, this.j3, this.m3, this.l3, 0);
    }

    public float q1() {
        return this.m3;
    }

    public float s1(int i2) {
        return this.m3 - ((float) i2);
    }

    public PdfRectangle v1(AffineTransform affineTransform) {
        float[] fArr = {this.j3, this.k3, this.l3, this.m3};
        affineTransform.h0(fArr, 0, fArr, 0, 2);
        float[] fArr2 = {fArr[0], fArr[1], fArr[2], fArr[3]};
        float f2 = fArr[0];
        float f3 = fArr[2];
        if (f2 > f3) {
            fArr2[0] = f3;
            fArr2[2] = fArr[0];
        }
        float f4 = fArr[1];
        float f5 = fArr[3];
        if (f4 > f5) {
            fArr2[1] = f5;
            fArr2[3] = fArr[1];
        }
        return new PdfRectangle(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
    }

    public float w1() {
        return this.l3 - this.j3;
    }

    public PdfRectangle(float f2, float f3, float f4, float f5) {
        this(f2, f3, f4, f5, 0);
    }

    public PdfRectangle(float f2, float f3, float f4, float f5, int i2) {
        super(new float[0]);
        this.j3 = 0.0f;
        this.k3 = 0.0f;
        this.l3 = 0.0f;
        this.m3 = 0.0f;
        if (i2 == 90 || i2 == 270) {
            this.j3 = f3;
            this.k3 = f2;
            this.l3 = f5;
            this.m3 = f4;
        } else {
            this.j3 = f2;
            this.k3 = f3;
            this.l3 = f4;
            this.m3 = f5;
        }
        super.a0(new PdfNumber(this.j3));
        super.a0(new PdfNumber(this.k3));
        super.a0(new PdfNumber(this.l3));
        super.a0(new PdfNumber(this.m3));
    }

    public PdfRectangle(float f2, float f3, int i2) {
        this(0.0f, 0.0f, f2, f3, i2);
    }

    public PdfRectangle(Rectangle rectangle) {
        this(rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T(), 0);
    }

    public PdfRectangle(Rectangle rectangle, int i2) {
        this(rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T(), i2);
    }
}
