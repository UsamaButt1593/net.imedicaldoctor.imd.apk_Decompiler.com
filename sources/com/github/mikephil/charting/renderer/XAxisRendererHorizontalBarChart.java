package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
    protected BarChart p;
    protected Path q = new Path();

    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.p = barChart;
    }

    public void a(float f2, float f3, boolean z) {
        float f4;
        double d2;
        if (this.f19118a.k() > 10.0f && !this.f19118a.F()) {
            MPPointD j2 = this.f19048c.j(this.f19118a.h(), this.f19118a.f());
            MPPointD j3 = this.f19048c.j(this.f19118a.h(), this.f19118a.j());
            if (z) {
                f4 = (float) j3.Z;
                d2 = j2.Z;
            } else {
                f4 = (float) j2.Z;
                d2 = j3.Z;
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
        float h2;
        float h3;
        float f2;
        if (this.f19121h.f() && this.f19121h.P()) {
            float d2 = this.f19121h.d();
            this.f19050e.setTypeface(this.f19121h.c());
            this.f19050e.setTextSize(this.f19121h.b());
            this.f19050e.setColor(this.f19121h.a());
            MPPointF c2 = MPPointF.c(0.0f, 0.0f);
            if (this.f19121h.w0() == XAxis.XAxisPosition.TOP) {
                c2.Y = 0.0f;
                c2.Z = 0.5f;
                h2 = this.f19118a.i();
            } else {
                if (this.f19121h.w0() == XAxis.XAxisPosition.TOP_INSIDE) {
                    c2.Y = 1.0f;
                    c2.Z = 0.5f;
                    h3 = this.f19118a.i();
                } else {
                    if (this.f19121h.w0() != XAxis.XAxisPosition.BOTTOM) {
                        if (this.f19121h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                            c2.Y = 1.0f;
                            c2.Z = 0.5f;
                            h2 = this.f19118a.h();
                        } else {
                            c2.Y = 0.0f;
                            c2.Z = 0.5f;
                            n(canvas, this.f19118a.i() + d2, c2);
                        }
                    }
                    c2.Y = 1.0f;
                    c2.Z = 0.5f;
                    h3 = this.f19118a.h();
                }
                f2 = h3 - d2;
                n(canvas, f2, c2);
                MPPointF.h(c2);
            }
            f2 = h2 + d2;
            n(canvas, f2, c2);
            MPPointF.h(c2);
        }
    }

    public void h(Canvas canvas) {
        if (this.f19121h.M() && this.f19121h.f()) {
            this.f19051f.setColor(this.f19121h.s());
            this.f19051f.setStrokeWidth(this.f19121h.u());
            if (this.f19121h.w0() == XAxis.XAxisPosition.TOP || this.f19121h.w0() == XAxis.XAxisPosition.TOP_INSIDE || this.f19121h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f19118a.i(), this.f19118a.j(), this.f19118a.i(), this.f19118a.f(), this.f19051f);
            }
            if (this.f19121h.w0() == XAxis.XAxisPosition.BOTTOM || this.f19121h.w0() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f19121h.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f19118a.h(), this.f19118a.j(), this.f19118a.h(), this.f19118a.f(), this.f19051f);
            }
        }
    }

    public void j(Canvas canvas) {
        float P;
        float f2;
        float h2;
        float f3;
        List<LimitLine> D = this.f19121h.D();
        if (D != null && D.size() > 0) {
            float[] fArr = this.f19125l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.q;
            path.reset();
            for (int i2 = 0; i2 < D.size(); i2++) {
                LimitLine limitLine = D.get(i2);
                if (limitLine.f()) {
                    int save = canvas.save();
                    this.f19126m.set(this.f19118a.q());
                    this.f19126m.inset(0.0f, -limitLine.t());
                    canvas.clipRect(this.f19126m);
                    this.f19052g.setStyle(Paint.Style.STROKE);
                    this.f19052g.setColor(limitLine.s());
                    this.f19052g.setStrokeWidth(limitLine.t());
                    this.f19052g.setPathEffect(limitLine.o());
                    fArr[1] = limitLine.r();
                    this.f19048c.o(fArr);
                    path.moveTo(this.f19118a.h(), fArr[1]);
                    path.lineTo(this.f19118a.i(), fArr[1]);
                    canvas.drawPath(path, this.f19052g);
                    path.reset();
                    String p2 = limitLine.p();
                    if (p2 != null && !p2.equals("")) {
                        this.f19052g.setStyle(limitLine.u());
                        this.f19052g.setPathEffect((PathEffect) null);
                        this.f19052g.setColor(limitLine.a());
                        this.f19052g.setStrokeWidth(0.5f);
                        this.f19052g.setTextSize(limitLine.b());
                        float a2 = (float) Utils.a(this.f19052g, p2);
                        float e2 = Utils.e(4.0f) + limitLine.d();
                        float t = limitLine.t() + a2 + limitLine.e();
                        LimitLine.LimitLabelPosition q2 = limitLine.q();
                        if (q2 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f19052g.setTextAlign(Paint.Align.RIGHT);
                            h2 = this.f19118a.i() - e2;
                            f3 = fArr[1];
                        } else {
                            if (q2 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                                this.f19052g.setTextAlign(Paint.Align.RIGHT);
                                P = this.f19118a.i() - e2;
                                f2 = fArr[1];
                            } else if (q2 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                                this.f19052g.setTextAlign(Paint.Align.LEFT);
                                h2 = this.f19118a.h() + e2;
                                f3 = fArr[1];
                            } else {
                                this.f19052g.setTextAlign(Paint.Align.LEFT);
                                P = this.f19118a.P() + e2;
                                f2 = fArr[1];
                            }
                            canvas.drawText(p2, P, f2 + t, this.f19052g);
                        }
                        canvas.drawText(p2, h2, (f3 - t) + a2, this.f19052g);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f19050e.setTypeface(this.f19121h.c());
        this.f19050e.setTextSize(this.f19121h.b());
        FSize b2 = Utils.b(this.f19050e, this.f19121h.E());
        float f2 = b2.Z;
        FSize D = Utils.D(b2.Y, f2, this.f19121h.v0());
        this.f19121h.J = Math.round((float) ((int) (b2.Y + (this.f19121h.d() * 3.5f))));
        this.f19121h.K = Math.round(f2);
        XAxis xAxis = this.f19121h;
        xAxis.L = (int) (D.Y + (xAxis.d() * 3.5f));
        this.f19121h.M = Math.round(D.Z);
        FSize.c(D);
    }

    /* access modifiers changed from: protected */
    public void l(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(this.f19118a.i(), f3);
        path.lineTo(this.f19118a.h(), f3);
        canvas.drawPath(path, this.f19049d);
        path.reset();
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, float f2, MPPointF mPPointF) {
        float v0 = this.f19121h.v0();
        boolean L = this.f19121h.L();
        int i2 = this.f19121h.f18933n * 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i3 + 1;
            XAxis xAxis = this.f19121h;
            if (L) {
                fArr[i4] = xAxis.f18932m[i3 / 2];
            } else {
                fArr[i4] = xAxis.f18931l[i3 / 2];
            }
        }
        this.f19048c.o(fArr);
        for (int i5 = 0; i5 < i2; i5 += 2) {
            float f3 = fArr[i5 + 1];
            if (this.f19118a.M(f3)) {
                ValueFormatter H = this.f19121h.H();
                XAxis xAxis2 = this.f19121h;
                m(canvas, H.c(xAxis2.f18931l[i5 / 2], xAxis2), f2, f3, mPPointF, v0);
            }
        }
    }

    public RectF o() {
        this.f19124k.set(this.f19118a.q());
        this.f19124k.inset(0.0f, -this.f19047b.B());
        return this.f19124k;
    }
}
