package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Line implements Shape {

    /* renamed from: a  reason: collision with root package name */
    private final Point2D f26952a;

    /* renamed from: b  reason: collision with root package name */
    private final Point2D f26953b;

    public Line() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public List<Point2D> a() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f26952a);
        arrayList.add(this.f26953b);
        return arrayList;
    }

    public Line(float f2, float f3, float f4, float f5) {
        this.f26952a = new Point2D.Float(f2, f3);
        this.f26953b = new Point2D.Float(f4, f5);
    }

    public Line(Point2D point2D, Point2D point2D2) {
        this((float) point2D.g(), (float) point2D.h(), (float) point2D2.g(), (float) point2D2.h());
    }
}
