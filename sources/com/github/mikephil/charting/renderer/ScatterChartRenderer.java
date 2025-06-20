package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {

    /* renamed from: i  reason: collision with root package name */
    protected ScatterDataProvider f19119i;

    /* renamed from: j  reason: collision with root package name */
    float[] f19120j = new float[2];

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19119i = scatterDataProvider;
    }

    public void b(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.f19119i.getScatterData().q()) {
            if (iScatterDataSet.isVisible()) {
                o(canvas, iScatterDataSet);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.f19119i.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.k(highlight.d());
            if (iScatterDataSet != null && iScatterDataSet.i1()) {
                Entry x = iScatterDataSet.x(highlight.h(), highlight.j());
                if (l(x, iScatterDataSet)) {
                    MPPointD f2 = this.f19119i.a(iScatterDataSet.a1()).f(x.m(), x.c() * this.f19078b.i());
                    highlight.n((float) f2.Y, (float) f2.Z);
                    n(canvas, (float) f2.Y, (float) f2.Z, iScatterDataSet);
                }
            }
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        IScatterDataSet iScatterDataSet;
        Entry entry;
        if (k(this.f19119i)) {
            List q = this.f19119i.getScatterData().q();
            for (int i2 = 0; i2 < this.f19119i.getScatterData().m(); i2++) {
                IScatterDataSet iScatterDataSet2 = (IScatterDataSet) q.get(i2);
                if (m(iScatterDataSet2) && iScatterDataSet2.e1() >= 1) {
                    a(iScatterDataSet2);
                    this.f19059g.a(this.f19119i, iScatterDataSet2);
                    Transformer a2 = this.f19119i.a(iScatterDataSet2.a1());
                    float h2 = this.f19078b.h();
                    float i3 = this.f19078b.i();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                    float[] d2 = a2.d(iScatterDataSet2, h2, i3, xBounds.f19060a, xBounds.f19061b);
                    float e2 = Utils.e(iScatterDataSet2.p0());
                    ValueFormatter T = iScatterDataSet2.T();
                    MPPointF d3 = MPPointF.d(iScatterDataSet2.f1());
                    d3.Y = Utils.e(d3.Y);
                    d3.Z = Utils.e(d3.Z);
                    int i4 = 0;
                    while (i4 < d2.length && this.f19118a.J(d2[i4])) {
                        if (this.f19118a.I(d2[i4])) {
                            int i5 = i4 + 1;
                            if (this.f19118a.M(d2[i5])) {
                                int i6 = i4 / 2;
                                Entry X = iScatterDataSet2.X(this.f19059g.f19060a + i6);
                                if (iScatterDataSet2.V0()) {
                                    String j2 = T.j(X);
                                    float f2 = d2[i4];
                                    float f3 = d2[i5] - e2;
                                    entry = X;
                                    float f4 = f3;
                                    iScatterDataSet = iScatterDataSet2;
                                    e(canvas, j2, f2, f4, iScatterDataSet2.u0(i6 + this.f19059g.f19060a));
                                } else {
                                    entry = X;
                                    iScatterDataSet = iScatterDataSet2;
                                }
                                if (entry.b() != null && iScatterDataSet.B()) {
                                    Drawable b2 = entry.b();
                                    Utils.k(canvas, b2, (int) (d2[i4] + d3.Y), (int) (d2[i5] + d3.Z), b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
                                }
                                i4 += 2;
                                iScatterDataSet2 = iScatterDataSet;
                            }
                        }
                        iScatterDataSet = iScatterDataSet2;
                        i4 += 2;
                        iScatterDataSet2 = iScatterDataSet;
                    }
                    MPPointF.h(d3);
                }
            }
        }
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public void o(Canvas canvas, IScatterDataSet iScatterDataSet) {
        int i2;
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        if (iScatterDataSet.e1() >= 1) {
            ViewPortHandler viewPortHandler = this.f19118a;
            Transformer a2 = this.f19119i.a(iScatterDataSet.a1());
            float i3 = this.f19078b.i();
            IShapeRenderer O0 = iScatterDataSet.O0();
            if (O0 == null) {
                Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
                return;
            }
            int min = (int) Math.min(Math.ceil((double) (((float) iScatterDataSet.e1()) * this.f19078b.h())), (double) ((float) iScatterDataSet.e1()));
            int i4 = 0;
            while (i4 < min) {
                Entry X = iScatterDataSet2.X(i4);
                this.f19120j[0] = X.m();
                this.f19120j[1] = X.c() * i3;
                a2.o(this.f19120j);
                if (viewPortHandler.J(this.f19120j[0])) {
                    if (!viewPortHandler.I(this.f19120j[0]) || !viewPortHandler.M(this.f19120j[1])) {
                        i2 = i4;
                    } else {
                        this.f19079c.setColor(iScatterDataSet2.d0(i4 / 2));
                        ViewPortHandler viewPortHandler2 = this.f19118a;
                        float[] fArr = this.f19120j;
                        i2 = i4;
                        O0.a(canvas, iScatterDataSet, viewPortHandler2, fArr[0], fArr[1], this.f19079c);
                    }
                    i4 = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
