package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {

    /* renamed from: c  reason: collision with root package name */
    private static final String f26982c = "Path shall start with \"re\" or \"m\" operator";

    /* renamed from: a  reason: collision with root package name */
    private List<Subpath> f26983a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Point2D f26984b;

    public Path() {
    }

    private Subpath i() {
        if (this.f26983a.size() <= 0) {
            return null;
        }
        List<Subpath> list = this.f26983a;
        return list.get(list.size() - 1);
    }

    public void a(Subpath subpath) {
        this.f26983a.add(subpath);
        this.f26984b = subpath.b();
    }

    public void b(List<? extends Subpath> list) {
        if (list.size() > 0) {
            this.f26983a.addAll(list);
            this.f26984b = this.f26983a.get(list.size() - 1).b();
        }
    }

    public void c() {
        for (Subpath k2 : this.f26983a) {
            k2.k(true);
        }
    }

    public void d() {
        Subpath i2 = i();
        i2.k(true);
        Point2D e2 = i2.e();
        m((float) e2.g(), (float) e2.h());
    }

    public void e(float f2, float f3, float f4, float f5) {
        if (this.f26984b != null) {
            g(f2, f3, f4, f5, f4, f5);
            return;
        }
        throw new RuntimeException(f26982c);
    }

    public void f(float f2, float f3, float f4, float f5) {
        Point2D point2D = this.f26984b;
        if (point2D != null) {
            g((float) point2D.g(), (float) this.f26984b.h(), f2, f3, f4, f5);
            return;
        }
        throw new RuntimeException(f26982c);
    }

    public void g(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (this.f26984b != null) {
            Point2D.Float floatR = new Point2D.Float(f2, f3);
            Point2D.Float floatR2 = new Point2D.Float(f4, f5);
            Point2D.Float floatR3 = new Point2D.Float(f6, f7);
            i().a(new BezierCurve(new ArrayList(Arrays.asList(new Point2D[]{this.f26984b, floatR, floatR2, floatR3}))));
            this.f26984b = floatR3;
            return;
        }
        throw new RuntimeException(f26982c);
    }

    public Point2D h() {
        return this.f26984b;
    }

    public List<Subpath> j() {
        return this.f26983a;
    }

    public boolean k() {
        return this.f26983a.size() == 0;
    }

    public void l(float f2, float f3) {
        if (this.f26984b != null) {
            Point2D.Float floatR = new Point2D.Float(f2, f3);
            i().a(new Line(this.f26984b, floatR));
            this.f26984b = floatR;
            return;
        }
        throw new RuntimeException(f26982c);
    }

    public void m(float f2, float f3) {
        this.f26984b = new Point2D.Float(f2, f3);
        Subpath i2 = i();
        if (i2 == null || !i2.j()) {
            this.f26983a.add(new Subpath(this.f26984b));
        } else {
            i2.m(this.f26984b);
        }
    }

    public void n(float f2, float f3, float f4, float f5) {
        m(f2, f3);
        float f6 = f4 + f2;
        l(f6, f3);
        float f7 = f3 + f5;
        l(f6, f7);
        l(f2, f7);
        d();
    }

    public List<Integer> o() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Subpath next : this.f26983a) {
            if (next.f()) {
                next.k(false);
                next.a(new Line(next.b(), next.e()));
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        return arrayList;
    }

    public Path(List<? extends Subpath> list) {
        b(list);
    }
}
