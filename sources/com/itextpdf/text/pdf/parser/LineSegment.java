package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Rectangle2D;

public class LineSegment {

    /* renamed from: a  reason: collision with root package name */
    private final Vector f26962a;

    /* renamed from: b  reason: collision with root package name */
    private final Vector f26963b;

    public LineSegment(Vector vector, Vector vector2) {
        this.f26962a = vector;
        this.f26963b = vector2;
    }

    public Rectangle2D.Float a() {
        float d2 = d().d(0);
        float d3 = d().d(1);
        float d4 = b().d(0);
        float d5 = b().d(1);
        return new Rectangle2D.Float(Math.min(d2, d4), Math.min(d3, d5), Math.abs(d4 - d2), Math.abs(d5 - d3));
    }

    public Vector b() {
        return this.f26963b;
    }

    public float c() {
        return this.f26963b.i(this.f26962a).e();
    }

    public Vector d() {
        return this.f26962a;
    }

    public LineSegment e(Matrix matrix) {
        return new LineSegment(this.f26962a.a(matrix), this.f26963b.a(matrix));
    }
}
