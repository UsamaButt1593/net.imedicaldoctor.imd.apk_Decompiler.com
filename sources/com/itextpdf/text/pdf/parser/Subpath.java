package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subpath {

    /* renamed from: a  reason: collision with root package name */
    private Point2D f27047a;

    /* renamed from: b  reason: collision with root package name */
    private List<Shape> f27048b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27049c;

    public Subpath() {
        this.f27048b = new ArrayList();
    }

    public void a(Shape shape) {
        if (!this.f27049c) {
            if (j()) {
                this.f27047a = shape.a().get(0);
            }
            this.f27048b.add(shape);
        }
    }

    public Point2D b() {
        Point2D point2D = this.f27047a;
        if (this.f27048b.size() <= 0 || this.f27049c) {
            return point2D;
        }
        List<Shape> list = this.f27048b;
        Shape shape = list.get(list.size() - 1);
        return shape.a().get(shape.a().size() - 1);
    }

    public List<Point2D> c() {
        ArrayList arrayList = new ArrayList();
        if (this.f27048b.size() == 0) {
            return arrayList;
        }
        arrayList.addAll(this.f27048b.get(0) instanceof BezierCurve ? ((BezierCurve) this.f27048b.get(0)).b() : this.f27048b.get(0).a());
        for (int i2 = 1; i2 < this.f27048b.size(); i2++) {
            List<Point2D> b2 = this.f27048b.get(i2) instanceof BezierCurve ? ((BezierCurve) this.f27048b.get(i2)).b() : this.f27048b.get(i2).a();
            arrayList.addAll(b2.subList(1, b2.size()));
        }
        return arrayList;
    }

    public List<Shape> d() {
        return this.f27048b;
    }

    public Point2D e() {
        return this.f27047a;
    }

    public boolean f() {
        return this.f27049c;
    }

    public boolean g() {
        if (this.f27048b.size() > 0 && this.f27049c) {
            return false;
        }
        for (Shape a2 : this.f27048b) {
            if (new HashSet(a2.a()).size() != 1) {
                return false;
            }
        }
        return this.f27048b.size() > 0 || this.f27049c;
    }

    public boolean h() {
        return this.f27047a == null;
    }

    public boolean i() {
        return this.f27048b.size() == 0 && this.f27049c;
    }

    public boolean j() {
        return this.f27048b.size() == 0 && !this.f27049c;
    }

    public void k(boolean z) {
        this.f27049c = z;
    }

    public void l(float f2, float f3) {
        this.f27047a = new Point2D.Float(f2, f3);
    }

    public void m(Point2D point2D) {
        l((float) point2D.g(), (float) point2D.h());
    }

    public Subpath(float f2, float f3) {
        this.f27048b = new ArrayList();
        this.f27047a = new Point2D.Float(f2, f3);
    }

    public Subpath(Point2D point2D) {
        this((float) point2D.g(), (float) point2D.h());
    }

    public Subpath(Subpath subpath) {
        ArrayList arrayList = new ArrayList();
        this.f27048b = arrayList;
        this.f27047a = subpath.f27047a;
        arrayList.addAll(subpath.d());
        this.f27049c = subpath.f27049c;
    }
}
