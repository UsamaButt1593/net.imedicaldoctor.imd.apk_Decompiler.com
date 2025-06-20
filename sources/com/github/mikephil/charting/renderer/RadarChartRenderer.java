package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class RadarChartRenderer extends LineRadarRenderer {

    /* renamed from: i  reason: collision with root package name */
    protected RadarChart f19113i;

    /* renamed from: j  reason: collision with root package name */
    protected Paint f19114j;

    /* renamed from: k  reason: collision with root package name */
    protected Paint f19115k;

    /* renamed from: l  reason: collision with root package name */
    protected Path f19116l = new Path();

    /* renamed from: m  reason: collision with root package name */
    protected Path f19117m = new Path();

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19113i = radarChart;
        Paint paint = new Paint(1);
        this.f19080d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f19080d.setStrokeWidth(2.0f);
        this.f19080d.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.f19114j = paint2;
        paint2.setStyle(style);
        this.f19115k = new Paint(1);
    }

    public void b(Canvas canvas) {
        RadarData radarData = (RadarData) this.f19113i.getData();
        int e1 = ((IRadarDataSet) radarData.w()).e1();
        for (IRadarDataSet iRadarDataSet : radarData.q()) {
            if (iRadarDataSet.isVisible()) {
                r(canvas, iRadarDataSet, e1);
            }
        }
    }

    public void c(Canvas canvas) {
        t(canvas);
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        int i2;
        Highlight[] highlightArr2 = highlightArr;
        float sliceAngle = this.f19113i.getSliceAngle();
        float factor = this.f19113i.getFactor();
        MPPointF centerOffsets = this.f19113i.getCenterOffsets();
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        RadarData radarData = (RadarData) this.f19113i.getData();
        int length = highlightArr2.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            Highlight highlight = highlightArr2[i4];
            IRadarDataSet iRadarDataSet = (IRadarDataSet) radarData.k(highlight.d());
            if (iRadarDataSet != null && iRadarDataSet.i1()) {
                RadarEntry radarEntry = (RadarEntry) iRadarDataSet.X((int) highlight.h());
                if (l(radarEntry, iRadarDataSet)) {
                    Utils.B(centerOffsets, (radarEntry.c() - this.f19113i.getYChartMin()) * factor * this.f19078b.i(), (highlight.h() * sliceAngle * this.f19078b.h()) + this.f19113i.getRotationAngle(), c2);
                    highlight.n(c2.Y, c2.Z);
                    n(canvas, c2.Y, c2.Z, iRadarDataSet);
                    if (iRadarDataSet.z() && !Float.isNaN(c2.Y) && !Float.isNaN(c2.Z)) {
                        int t = iRadarDataSet.t();
                        if (t == 1122867) {
                            t = iRadarDataSet.d0(i3);
                        }
                        if (iRadarDataSet.m() < 255) {
                            t = ColorTemplate.a(t, iRadarDataSet.m());
                        }
                        float j2 = iRadarDataSet.j();
                        float K = iRadarDataSet.K();
                        int h2 = iRadarDataSet.h();
                        int i5 = h2;
                        i2 = i4;
                        s(canvas, c2, j2, K, i5, t, iRadarDataSet.c());
                        i4 = i2 + 1;
                        i3 = 0;
                    }
                }
            }
            i2 = i4;
            i4 = i2 + 1;
            i3 = 0;
        }
        MPPointF.h(centerOffsets);
        MPPointF.h(c2);
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        float f2;
        int i2;
        float f3;
        int i3;
        int i4;
        RadarEntry radarEntry;
        ValueFormatter valueFormatter;
        IRadarDataSet iRadarDataSet;
        MPPointF mPPointF;
        float h2 = this.f19078b.h();
        float i5 = this.f19078b.i();
        float sliceAngle = this.f19113i.getSliceAngle();
        float factor = this.f19113i.getFactor();
        MPPointF centerOffsets = this.f19113i.getCenterOffsets();
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        MPPointF c3 = MPPointF.c(0.0f, 0.0f);
        float e2 = Utils.e(5.0f);
        int i6 = 0;
        while (i6 < ((RadarData) this.f19113i.getData()).m()) {
            IRadarDataSet iRadarDataSet2 = (IRadarDataSet) ((RadarData) this.f19113i.getData()).k(i6);
            if (!m(iRadarDataSet2)) {
                i2 = i6;
                f2 = h2;
            } else {
                a(iRadarDataSet2);
                ValueFormatter T = iRadarDataSet2.T();
                MPPointF d2 = MPPointF.d(iRadarDataSet2.f1());
                d2.Y = Utils.e(d2.Y);
                d2.Z = Utils.e(d2.Z);
                int i7 = 0;
                while (i7 < iRadarDataSet2.e1()) {
                    RadarEntry radarEntry2 = (RadarEntry) iRadarDataSet2.X(i7);
                    MPPointF mPPointF2 = d2;
                    float f4 = ((float) i7) * sliceAngle * h2;
                    Utils.B(centerOffsets, (radarEntry2.c() - this.f19113i.getYChartMin()) * factor * i5, f4 + this.f19113i.getRotationAngle(), c2);
                    if (iRadarDataSet2.V0()) {
                        String k2 = T.k(radarEntry2);
                        float f5 = c2.Y;
                        radarEntry = radarEntry2;
                        float f6 = c2.Z - e2;
                        int u0 = iRadarDataSet2.u0(i7);
                        i3 = i7;
                        f3 = h2;
                        mPPointF = mPPointF2;
                        valueFormatter = T;
                        float f7 = f5;
                        iRadarDataSet = iRadarDataSet2;
                        float f8 = f6;
                        i4 = i6;
                        e(canvas, k2, f7, f8, u0);
                    } else {
                        radarEntry = radarEntry2;
                        i3 = i7;
                        iRadarDataSet = iRadarDataSet2;
                        i4 = i6;
                        f3 = h2;
                        mPPointF = mPPointF2;
                        valueFormatter = T;
                    }
                    if (radarEntry.b() != null && iRadarDataSet.B()) {
                        Drawable b2 = radarEntry.b();
                        Utils.B(centerOffsets, (radarEntry.c() * factor * i5) + mPPointF.Z, f4 + this.f19113i.getRotationAngle(), c3);
                        float f9 = c3.Z + mPPointF.Y;
                        c3.Z = f9;
                        Utils.k(canvas, b2, (int) c3.Y, (int) f9, b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
                    }
                    i7 = i3 + 1;
                    d2 = mPPointF;
                    iRadarDataSet2 = iRadarDataSet;
                    T = valueFormatter;
                    i6 = i4;
                    h2 = f3;
                }
                i2 = i6;
                f2 = h2;
                MPPointF.h(d2);
            }
            i6 = i2 + 1;
            h2 = f2;
        }
        MPPointF.h(centerOffsets);
        MPPointF.h(c2);
        MPPointF.h(c3);
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public void r(Canvas canvas, IRadarDataSet iRadarDataSet, int i2) {
        float h2 = this.f19078b.h();
        float i3 = this.f19078b.i();
        float sliceAngle = this.f19113i.getSliceAngle();
        float factor = this.f19113i.getFactor();
        MPPointF centerOffsets = this.f19113i.getCenterOffsets();
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        Path path = this.f19116l;
        path.reset();
        boolean z = false;
        for (int i4 = 0; i4 < iRadarDataSet.e1(); i4++) {
            this.f19079c.setColor(iRadarDataSet.d0(i4));
            Utils.B(centerOffsets, (((RadarEntry) iRadarDataSet.X(i4)).c() - this.f19113i.getYChartMin()) * factor * i3, (((float) i4) * sliceAngle * h2) + this.f19113i.getRotationAngle(), c2);
            if (!Float.isNaN(c2.Y)) {
                if (!z) {
                    path.moveTo(c2.Y, c2.Z);
                    z = true;
                } else {
                    path.lineTo(c2.Y, c2.Z);
                }
            }
        }
        if (iRadarDataSet.e1() > i2) {
            path.lineTo(centerOffsets.Y, centerOffsets.Z);
        }
        path.close();
        if (iRadarDataSet.Z()) {
            Drawable Q = iRadarDataSet.Q();
            if (Q != null) {
                q(canvas, path, Q);
            } else {
                p(canvas, path, iRadarDataSet.g(), iRadarDataSet.l());
            }
        }
        this.f19079c.setStrokeWidth(iRadarDataSet.u());
        this.f19079c.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.Z() || iRadarDataSet.l() < 255) {
            canvas.drawPath(path, this.f19079c);
        }
        MPPointF.h(centerOffsets);
        MPPointF.h(c2);
    }

    public void s(Canvas canvas, MPPointF mPPointF, float f2, float f3, int i2, int i3, float f4) {
        canvas.save();
        float e2 = Utils.e(f3);
        float e3 = Utils.e(f2);
        if (i2 != 1122867) {
            Path path = this.f19117m;
            path.reset();
            path.addCircle(mPPointF.Y, mPPointF.Z, e2, Path.Direction.CW);
            if (e3 > 0.0f) {
                path.addCircle(mPPointF.Y, mPPointF.Z, e3, Path.Direction.CCW);
            }
            this.f19115k.setColor(i2);
            this.f19115k.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f19115k);
        }
        if (i3 != 1122867) {
            this.f19115k.setColor(i3);
            this.f19115k.setStyle(Paint.Style.STROKE);
            this.f19115k.setStrokeWidth(Utils.e(f4));
            canvas.drawCircle(mPPointF.Y, mPPointF.Z, e2, this.f19115k);
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void t(Canvas canvas) {
        float sliceAngle = this.f19113i.getSliceAngle();
        float factor = this.f19113i.getFactor();
        float rotationAngle = this.f19113i.getRotationAngle();
        MPPointF centerOffsets = this.f19113i.getCenterOffsets();
        this.f19114j.setStrokeWidth(this.f19113i.getWebLineWidth());
        this.f19114j.setColor(this.f19113i.getWebColor());
        this.f19114j.setAlpha(this.f19113i.getWebAlpha());
        int skipWebLineCount = this.f19113i.getSkipWebLineCount() + 1;
        int e1 = ((IRadarDataSet) ((RadarData) this.f19113i.getData()).w()).e1();
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        for (int i2 = 0; i2 < e1; i2 += skipWebLineCount) {
            Utils.B(centerOffsets, this.f19113i.getYRange() * factor, (((float) i2) * sliceAngle) + rotationAngle, c2);
            canvas.drawLine(centerOffsets.Y, centerOffsets.Z, c2.Y, c2.Z, this.f19114j);
        }
        MPPointF.h(c2);
        this.f19114j.setStrokeWidth(this.f19113i.getWebLineWidthInner());
        this.f19114j.setColor(this.f19113i.getWebColorInner());
        this.f19114j.setAlpha(this.f19113i.getWebAlpha());
        int i3 = this.f19113i.getYAxis().f18933n;
        MPPointF c3 = MPPointF.c(0.0f, 0.0f);
        MPPointF c4 = MPPointF.c(0.0f, 0.0f);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            while (i5 < ((RadarData) this.f19113i.getData()).r()) {
                float yChartMin = (this.f19113i.getYAxis().f18931l[i4] - this.f19113i.getYChartMin()) * factor;
                Utils.B(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, c3);
                i5++;
                Utils.B(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, c4);
                canvas.drawLine(c3.Y, c3.Z, c4.Y, c4.Z, this.f19114j);
            }
        }
        MPPointF.h(c3);
        MPPointF.h(c4);
    }

    public Paint u() {
        return this.f19114j;
    }
}
