package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    protected Path r = new Path();
    protected Path s = new Path();
    protected float[] t = new float[4];

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.f19052g.setTextAlign(Paint.Align.LEFT);
    }

    public void a(float f2, float f3, boolean z) {
        float f4;
        double d2;
        if (this.f19118a.g() > 10.0f && !this.f19118a.E()) {
            MPPointD j2 = this.f19048c.j(this.f19118a.h(), this.f19118a.j());
            MPPointD j3 = this.f19048c.j(this.f19118a.i(), this.f19118a.j());
            if (!z) {
                f4 = (float) j2.Y;
                d2 = j3.Y;
            } else {
                f4 = (float) j3.Y;
                d2 = j2.Y;
            }
            float f5 = (float) d2;
            MPPointD.c(j2);
            MPPointD.c(j3);
            f2 = f4;
            f3 = f5;
        }
        b(f2, f3);
    }

    public void g(Canvas canvas) {
        float f2;
        if (this.f19128h.f() && this.f19128h.P()) {
            float[] n2 = n();
            this.f19050e.setTypeface(this.f19128h.c());
            this.f19050e.setTextSize(this.f19128h.b());
            this.f19050e.setColor(this.f19128h.a());
            this.f19050e.setTextAlign(Paint.Align.CENTER);
            float e2 = Utils.e(2.5f);
            float a2 = (float) Utils.a(this.f19050e, "Q");
            YAxis.AxisDependency v0 = this.f19128h.v0();
            YAxis.YAxisLabelPosition w0 = this.f19128h.w0();
            if (v0 == YAxis.AxisDependency.LEFT) {
                YAxis.YAxisLabelPosition yAxisLabelPosition = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                f2 = this.f19118a.j() - e2;
            } else {
                YAxis.YAxisLabelPosition yAxisLabelPosition2 = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                f2 = this.f19118a.f() + a2 + e2;
            }
            k(canvas, f2, n2, this.f19128h.e());
        }
    }

    public void h(Canvas canvas) {
        float h2;
        float f2;
        float i2;
        float f3;
        if (this.f19128h.f() && this.f19128h.M()) {
            this.f19051f.setColor(this.f19128h.s());
            this.f19051f.setStrokeWidth(this.f19128h.u());
            if (this.f19128h.v0() == YAxis.AxisDependency.LEFT) {
                h2 = this.f19118a.h();
                f2 = this.f19118a.j();
                i2 = this.f19118a.i();
                f3 = this.f19118a.j();
            } else {
                h2 = this.f19118a.h();
                f2 = this.f19118a.f();
                i2 = this.f19118a.i();
                f3 = this.f19118a.f();
            }
            canvas.drawLine(h2, f2, i2, f3, this.f19051f);
        }
    }

    public void j(Canvas canvas) {
        float f2;
        float a2;
        float f3;
        Canvas canvas2 = canvas;
        List<LimitLine> D = this.f19128h.D();
        if (D != null && D.size() > 0) {
            float[] fArr = this.t;
            float f4 = 0.0f;
            fArr[0] = 0.0f;
            char c2 = 1;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            Path path = this.s;
            path.reset();
            int i2 = 0;
            while (i2 < D.size()) {
                LimitLine limitLine = D.get(i2);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.q.set(this.f19118a.q());
                    this.q.inset(-limitLine.t(), f4);
                    canvas2.clipRect(this.q);
                    fArr[0] = limitLine.r();
                    fArr[2] = limitLine.r();
                    this.f19048c.o(fArr);
                    fArr[c2] = this.f19118a.j();
                    fArr[3] = this.f19118a.f();
                    path.moveTo(fArr[0], fArr[c2]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.f19052g.setStyle(Paint.Style.STROKE);
                    this.f19052g.setColor(limitLine.s());
                    this.f19052g.setPathEffect(limitLine.o());
                    this.f19052g.setStrokeWidth(limitLine.t());
                    canvas2.drawPath(path, this.f19052g);
                    path.reset();
                    String p = limitLine.p();
                    if (p != null && !p.equals("")) {
                        this.f19052g.setStyle(limitLine.u());
                        this.f19052g.setPathEffect((PathEffect) null);
                        this.f19052g.setColor(limitLine.a());
                        this.f19052g.setTypeface(limitLine.c());
                        this.f19052g.setStrokeWidth(0.5f);
                        this.f19052g.setTextSize(limitLine.b());
                        float t2 = limitLine.t() + limitLine.d();
                        float e2 = Utils.e(2.0f) + limitLine.e();
                        LimitLine.LimitLabelPosition q = limitLine.q();
                        if (q == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            a2 = (float) Utils.a(this.f19052g, p);
                            this.f19052g.setTextAlign(Paint.Align.LEFT);
                            f3 = fArr[0] + t2;
                        } else {
                            if (q == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                                this.f19052g.setTextAlign(Paint.Align.LEFT);
                                f2 = fArr[0] + t2;
                            } else if (q == LimitLine.LimitLabelPosition.LEFT_TOP) {
                                this.f19052g.setTextAlign(Paint.Align.RIGHT);
                                a2 = (float) Utils.a(this.f19052g, p);
                                f3 = fArr[0] - t2;
                            } else {
                                this.f19052g.setTextAlign(Paint.Align.RIGHT);
                                f2 = fArr[0] - t2;
                            }
                            canvas2.drawText(p, f2, this.f19118a.f() - e2, this.f19052g);
                        }
                        canvas2.drawText(p, f3, this.f19118a.j() + e2 + a2, this.f19052g);
                    }
                    canvas2.restoreToCount(save);
                }
                i2++;
                f4 = 0.0f;
                c2 = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(Canvas canvas, float f2, float[] fArr, float f3) {
        this.f19050e.setTypeface(this.f19128h.c());
        this.f19050e.setTextSize(this.f19128h.b());
        this.f19050e.setColor(this.f19128h.a());
        int i2 = this.f19128h.G0() ? this.f19128h.f18933n : this.f19128h.f18933n - 1;
        for (int i3 = !this.f19128h.F0(); i3 < i2; i3++) {
            canvas.drawText(this.f19128h.x(i3), fArr[i3 * 2], f2 - f3, this.f19050e);
        }
    }

    /* access modifiers changed from: protected */
    public void l(Canvas canvas) {
        int save = canvas.save();
        this.f19134n.set(this.f19118a.q());
        this.f19134n.inset(-this.f19128h.E0(), 0.0f);
        canvas.clipRect(this.q);
        MPPointD f2 = this.f19048c.f(0.0f, 0.0f);
        this.f19129i.setColor(this.f19128h.D0());
        this.f19129i.setStrokeWidth(this.f19128h.E0());
        Path path = this.r;
        path.reset();
        path.moveTo(((float) f2.Y) - 1.0f, this.f19118a.j());
        path.lineTo(((float) f2.Y) - 1.0f, this.f19118a.f());
        canvas.drawPath(path, this.f19129i);
        canvas.restoreToCount(save);
    }

    public RectF m() {
        this.f19131k.set(this.f19118a.q());
        this.f19131k.inset(-this.f19047b.B(), 0.0f);
        return this.f19131k;
    }

    /* access modifiers changed from: protected */
    public float[] n() {
        int length = this.f19132l.length;
        int i2 = this.f19128h.f18933n;
        if (length != i2 * 2) {
            this.f19132l = new float[(i2 * 2)];
        }
        float[] fArr = this.f19132l;
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            fArr[i3] = this.f19128h.f18931l[i3 / 2];
        }
        this.f19048c.o(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public Path o(Path path, int i2, float[] fArr) {
        path.moveTo(fArr[i2], this.f19118a.j());
        path.lineTo(fArr[i2], this.f19118a.f());
        return path;
    }
}
