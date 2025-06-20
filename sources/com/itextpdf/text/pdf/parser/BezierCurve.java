package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class BezierCurve implements Shape {

    /* renamed from: b  reason: collision with root package name */
    public static double f26918b = 1.0E-30d;

    /* renamed from: c  reason: collision with root package name */
    public static double f26919c = 0.025d;

    /* renamed from: d  reason: collision with root package name */
    public static double f26920d = 0.4d;

    /* renamed from: a  reason: collision with root package name */
    private final List<Point2D> f26921a;

    public BezierCurve(List<Point2D> list) {
        this.f26921a = new ArrayList(list);
    }

    private void c(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, List<Point2D> list) {
        List<Point2D> list2 = list;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = (d4 + d6) / 2.0d;
        double d13 = (d5 + d7) / 2.0d;
        double d14 = (d6 + d8) / 2.0d;
        double d15 = (d7 + d9) / 2.0d;
        double d16 = (d10 + d12) / 2.0d;
        double d17 = (d11 + d13) / 2.0d;
        double d18 = (d12 + d14) / 2.0d;
        double d19 = (d13 + d15) / 2.0d;
        double d20 = (d16 + d18) / 2.0d;
        double d21 = (d17 + d19) / 2.0d;
        double d22 = d8 - d2;
        double d23 = d9 - d3;
        double abs = Math.abs(((d4 - d8) * d23) - ((d5 - d9) * d22));
        double abs2 = Math.abs(((d6 - d8) * d23) - ((d7 - d9) * d22));
        double d24 = f26918b;
        if (abs > d24 || abs2 > d24) {
            double d25 = abs + abs2;
            if (d25 * d25 <= f26919c * ((d22 * d22) + (d23 * d23))) {
                list2.add(new Point2D.Double(d20, d21));
                return;
            }
        } else if (Math.abs(((d2 + d6) - d4) - d4) + Math.abs(((d3 + d7) - d5) - d5) + Math.abs(((d4 + d8) - d6) - d6) + Math.abs(((d5 + d9) - d7) - d7) <= f26920d) {
            list2.add(new Point2D.Double(d20, d21));
            return;
        }
        double d26 = d21;
        double d27 = d20;
        List<Point2D> list3 = list;
        c(d2, d3, d10, d11, d16, d17, d27, d26, list3);
        c(d27, d26, d18, d19, d14, d15, d8, d9, list3);
    }

    public List<Point2D> a() {
        return this.f26921a;
    }

    public List<Point2D> b() {
        ArrayList arrayList = r13;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f26921a.get(0));
        double g2 = this.f26921a.get(0).g();
        ArrayList arrayList3 = arrayList2;
        double d2 = g2;
        c(d2, this.f26921a.get(0).h(), this.f26921a.get(1).g(), this.f26921a.get(1).h(), this.f26921a.get(2).g(), this.f26921a.get(2).h(), this.f26921a.get(3).g(), this.f26921a.get(3).h(), arrayList);
        List<Point2D> list = this.f26921a;
        ArrayList arrayList4 = arrayList3;
        arrayList4.add(list.get(list.size() - 1));
        return arrayList4;
    }
}
