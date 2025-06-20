package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.List;

public class ShapeData {

    /* renamed from: a  reason: collision with root package name */
    private final List<CubicCurveData> f17203a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f17204b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17205c;

    public ShapeData() {
        this.f17203a = new ArrayList();
    }

    private void e(float f2, float f3) {
        if (this.f17204b == null) {
            this.f17204b = new PointF();
        }
        this.f17204b.set(f2, f3);
    }

    public List<CubicCurveData> a() {
        return this.f17203a;
    }

    public PointF b() {
        return this.f17204b;
    }

    public void c(ShapeData shapeData, ShapeData shapeData2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f17204b == null) {
            this.f17204b = new PointF();
        }
        this.f17205c = shapeData.d() || shapeData2.d();
        if (shapeData.a().size() != shapeData2.a().size()) {
            Logger.e("Curves must have the same number of control points. Shape 1: " + shapeData.a().size() + "\tShape 2: " + shapeData2.a().size());
        }
        int min = Math.min(shapeData.a().size(), shapeData2.a().size());
        if (this.f17203a.size() < min) {
            for (int size = this.f17203a.size(); size < min; size++) {
                this.f17203a.add(new CubicCurveData());
            }
        } else if (this.f17203a.size() > min) {
            for (int size2 = this.f17203a.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = this.f17203a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = shapeData.b();
        PointF b3 = shapeData2.b();
        e(MiscUtils.j(b2.x, b3.x, f2), MiscUtils.j(b2.y, b3.y, f2));
        for (int size3 = this.f17203a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.a().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.a().get(size3);
            PointF a2 = cubicCurveData.a();
            PointF b4 = cubicCurveData.b();
            PointF c2 = cubicCurveData.c();
            PointF a3 = cubicCurveData2.a();
            PointF b5 = cubicCurveData2.b();
            PointF c3 = cubicCurveData2.c();
            this.f17203a.get(size3).d(MiscUtils.j(a2.x, a3.x, f2), MiscUtils.j(a2.y, a3.y, f2));
            this.f17203a.get(size3).e(MiscUtils.j(b4.x, b5.x, f2), MiscUtils.j(b4.y, b5.y, f2));
            this.f17203a.get(size3).f(MiscUtils.j(c2.x, c3.x, f2), MiscUtils.j(c2.y, c3.y, f2));
        }
    }

    public boolean d() {
        return this.f17205c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f17203a.size() + "closed=" + this.f17205c + ASCIIPropertyListParser.f18653k;
    }

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.f17204b = pointF;
        this.f17205c = z;
        this.f17203a = new ArrayList(list);
    }
}
