package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart r;
    private Path s = new Path();

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, (Transformer) null);
        this.r = radarChart;
    }

    /* access modifiers changed from: protected */
    public void b(float f2, float f3) {
        boolean z;
        float f4 = f2;
        float f5 = f3;
        int C = this.f19047b.C();
        double abs = (double) Math.abs(f5 - f4);
        if (C == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.f19047b;
            axisBase.f18931l = new float[0];
            axisBase.f18932m = new float[0];
            axisBase.f18933n = 0;
            return;
        }
        double L = (double) Utils.L(abs / ((double) C));
        if (this.f19047b.S() && L < ((double) this.f19047b.y())) {
            L = (double) this.f19047b.y();
        }
        double L2 = (double) Utils.L(Math.pow(10.0d, (double) ((int) Math.log10(L))));
        if (((int) (L / L2)) > 5) {
            L = Math.floor(L2 * 10.0d);
        }
        boolean L3 = this.f19047b.L();
        if (this.f19047b.R()) {
            float f6 = ((float) abs) / ((float) (C - 1));
            AxisBase axisBase2 = this.f19047b;
            axisBase2.f18933n = C;
            if (axisBase2.f18931l.length < C) {
                axisBase2.f18931l = new float[C];
            }
            for (int i2 = 0; i2 < C; i2++) {
                this.f19047b.f18931l[i2] = f4;
                f4 += f6;
            }
        } else {
            int i3 = (L > 0.0d ? 1 : (L == 0.0d ? 0 : -1));
            double ceil = i3 == 0 ? 0.0d : Math.ceil(((double) f4) / L) * L;
            if (L3) {
                ceil -= L;
            }
            double J = i3 == 0 ? 0.0d : Utils.J(Math.floor(((double) f5) / L) * L);
            if (i3 != 0) {
                z = L3;
                for (double d2 = ceil; d2 <= J; d2 += L) {
                    z++;
                }
            } else {
                z = L3;
            }
            int i4 = ((int) z) + 1;
            AxisBase axisBase3 = this.f19047b;
            axisBase3.f18933n = i4;
            if (axisBase3.f18931l.length < i4) {
                axisBase3.f18931l = new float[i4];
            }
            for (int i5 = 0; i5 < i4; i5++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                this.f19047b.f18931l[i5] = (float) ceil;
                ceil += L;
            }
            C = i4;
        }
        this.f19047b.o = (L > 1.0d ? 1 : (L == 1.0d ? 0 : -1)) < 0 ? (int) Math.ceil(-Math.log10(L)) : 0;
        if (L3) {
            AxisBase axisBase4 = this.f19047b;
            if (axisBase4.f18932m.length < C) {
                axisBase4.f18932m = new float[C];
            }
            float[] fArr = axisBase4.f18931l;
            float f7 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i6 = 0; i6 < C; i6++) {
                AxisBase axisBase5 = this.f19047b;
                axisBase5.f18932m[i6] = axisBase5.f18931l[i6] + f7;
            }
        }
        AxisBase axisBase6 = this.f19047b;
        float[] fArr2 = axisBase6.f18931l;
        float f8 = fArr2[0];
        axisBase6.H = f8;
        float f9 = fArr2[C - 1];
        axisBase6.G = f9;
        axisBase6.I = Math.abs(f9 - f8);
    }

    public void g(Canvas canvas) {
        if (this.f19128h.f() && this.f19128h.P()) {
            this.f19050e.setTypeface(this.f19128h.c());
            this.f19050e.setTextSize(this.f19128h.b());
            this.f19050e.setColor(this.f19128h.a());
            MPPointF centerOffsets = this.r.getCenterOffsets();
            MPPointF c2 = MPPointF.c(0.0f, 0.0f);
            float factor = this.r.getFactor();
            int i2 = this.f19128h.G0() ? this.f19128h.f18933n : this.f19128h.f18933n - 1;
            for (int i3 = !this.f19128h.F0(); i3 < i2; i3++) {
                YAxis yAxis = this.f19128h;
                Utils.B(centerOffsets, (yAxis.f18931l[i3] - yAxis.H) * factor, this.r.getRotationAngle(), c2);
                canvas.drawText(this.f19128h.x(i3), c2.Y + 10.0f, c2.Z, this.f19050e);
            }
            MPPointF.h(centerOffsets);
            MPPointF.h(c2);
        }
    }

    public void j(Canvas canvas) {
        List<LimitLine> D = this.f19128h.D();
        if (D != null) {
            float sliceAngle = this.r.getSliceAngle();
            float factor = this.r.getFactor();
            MPPointF centerOffsets = this.r.getCenterOffsets();
            MPPointF c2 = MPPointF.c(0.0f, 0.0f);
            for (int i2 = 0; i2 < D.size(); i2++) {
                LimitLine limitLine = D.get(i2);
                if (limitLine.f()) {
                    this.f19052g.setColor(limitLine.s());
                    this.f19052g.setPathEffect(limitLine.o());
                    this.f19052g.setStrokeWidth(limitLine.t());
                    float r2 = (limitLine.r() - this.r.getYChartMin()) * factor;
                    Path path = this.s;
                    path.reset();
                    for (int i3 = 0; i3 < ((IRadarDataSet) ((RadarData) this.r.getData()).w()).e1(); i3++) {
                        Utils.B(centerOffsets, r2, (((float) i3) * sliceAngle) + this.r.getRotationAngle(), c2);
                        float f2 = c2.Y;
                        float f3 = c2.Z;
                        if (i3 == 0) {
                            path.moveTo(f2, f3);
                        } else {
                            path.lineTo(f2, f3);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.f19052g);
                }
            }
            MPPointF.h(centerOffsets);
            MPPointF.h(c2);
        }
    }
}
