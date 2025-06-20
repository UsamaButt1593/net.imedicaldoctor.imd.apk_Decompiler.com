package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: h  reason: collision with root package name */
    protected BubbleDataProvider f19064h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f19065i = new float[4];

    /* renamed from: j  reason: collision with root package name */
    private float[] f19066j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    private float[] f19067k = new float[3];

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19064h = bubbleDataProvider;
        this.f19079c.setStyle(Paint.Style.FILL);
        this.f19080d.setStyle(Paint.Style.STROKE);
        this.f19080d.setStrokeWidth(Utils.e(1.5f));
    }

    public void b(Canvas canvas) {
        for (IBubbleDataSet iBubbleDataSet : this.f19064h.getBubbleData().q()) {
            if (iBubbleDataSet.isVisible()) {
                n(canvas, iBubbleDataSet);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        BubbleData bubbleData = this.f19064h.getBubbleData();
        float i2 = this.f19078b.i();
        for (Highlight highlight : highlightArr) {
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.k(highlight.d());
            if (iBubbleDataSet != null && iBubbleDataSet.i1()) {
                BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.x(highlight.h(), highlight.j());
                if (bubbleEntry.c() == highlight.j() && l(bubbleEntry, iBubbleDataSet)) {
                    Transformer a2 = this.f19064h.a(iBubbleDataSet.a1());
                    float[] fArr = this.f19065i;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    a2.o(fArr);
                    boolean e2 = iBubbleDataSet.e();
                    float[] fArr2 = this.f19065i;
                    float min = Math.min(Math.abs(this.f19118a.f() - this.f19118a.j()), Math.abs(fArr2[2] - fArr2[0]));
                    this.f19066j[0] = bubbleEntry.m();
                    this.f19066j[1] = bubbleEntry.c() * i2;
                    a2.o(this.f19066j);
                    float[] fArr3 = this.f19066j;
                    highlight.n(fArr3[0], fArr3[1]);
                    float o = o(bubbleEntry.t(), iBubbleDataSet.a(), min, e2) / 2.0f;
                    if (this.f19118a.K(this.f19066j[1] + o) && this.f19118a.H(this.f19066j[1] - o) && this.f19118a.I(this.f19066j[0] + o)) {
                        if (this.f19118a.J(this.f19066j[0] - o)) {
                            int d0 = iBubbleDataSet.d0((int) bubbleEntry.m());
                            Color.RGBToHSV(Color.red(d0), Color.green(d0), Color.blue(d0), this.f19067k);
                            float[] fArr4 = this.f19067k;
                            fArr4[2] = fArr4[2] * 0.5f;
                            this.f19080d.setColor(Color.HSVToColor(Color.alpha(d0), this.f19067k));
                            this.f19080d.setStrokeWidth(iBubbleDataSet.S0());
                            float[] fArr5 = this.f19066j;
                            canvas.drawCircle(fArr5[0], fArr5[1], o, this.f19080d);
                        } else {
                            return;
                        }
                    }
                }
            }
            Canvas canvas2 = canvas;
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        int i2;
        float f2;
        BubbleEntry bubbleEntry;
        float f3;
        BubbleData bubbleData = this.f19064h.getBubbleData();
        if (bubbleData != null && k(this.f19064h)) {
            List q = bubbleData.q();
            float a2 = (float) Utils.a(this.f19082f, IcyHeaders.a3);
            for (int i3 = 0; i3 < q.size(); i3++) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) q.get(i3);
                if (m(iBubbleDataSet) && iBubbleDataSet.e1() >= 1) {
                    a(iBubbleDataSet);
                    float max = Math.max(0.0f, Math.min(1.0f, this.f19078b.h()));
                    float i4 = this.f19078b.i();
                    this.f19059g.a(this.f19064h, iBubbleDataSet);
                    Transformer a3 = this.f19064h.a(iBubbleDataSet.a1());
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                    float[] a4 = a3.a(iBubbleDataSet, i4, xBounds.f19060a, xBounds.f19061b);
                    float f4 = max == 1.0f ? i4 : max;
                    ValueFormatter T = iBubbleDataSet.T();
                    MPPointF d2 = MPPointF.d(iBubbleDataSet.f1());
                    d2.Y = Utils.e(d2.Y);
                    d2.Z = Utils.e(d2.Z);
                    for (int i5 = 0; i5 < a4.length; i5 = i2 + 2) {
                        int i6 = i5 / 2;
                        int u0 = iBubbleDataSet.u0(this.f19059g.f19060a + i6);
                        int argb = Color.argb(Math.round(255.0f * f4), Color.red(u0), Color.green(u0), Color.blue(u0));
                        float f5 = a4[i5];
                        float f6 = a4[i5 + 1];
                        if (!this.f19118a.J(f5)) {
                            break;
                        }
                        if (!this.f19118a.I(f5) || !this.f19118a.M(f6)) {
                            i2 = i5;
                        } else {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) iBubbleDataSet.X(i6 + this.f19059g.f19060a);
                            if (iBubbleDataSet.V0()) {
                                float f7 = f6 + (0.5f * a2);
                                bubbleEntry = bubbleEntry2;
                                f3 = f6;
                                float f8 = f5;
                                f2 = f5;
                                float f9 = f7;
                                i2 = i5;
                                e(canvas, T.f(bubbleEntry2), f8, f9, argb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f3 = f6;
                                f2 = f5;
                                i2 = i5;
                            }
                            if (bubbleEntry.b() != null && iBubbleDataSet.B()) {
                                Drawable b2 = bubbleEntry.b();
                                Utils.k(canvas, b2, (int) (f2 + d2.Y), (int) (f3 + d2.Z), b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
                            }
                        }
                    }
                    MPPointF.h(d2);
                }
            }
        }
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        if (iBubbleDataSet.e1() >= 1) {
            Transformer a2 = this.f19064h.a(iBubbleDataSet.a1());
            float i2 = this.f19078b.i();
            this.f19059g.a(this.f19064h, iBubbleDataSet);
            float[] fArr = this.f19065i;
            fArr[0] = 0.0f;
            fArr[2] = 1.0f;
            a2.o(fArr);
            boolean e2 = iBubbleDataSet.e();
            float[] fArr2 = this.f19065i;
            float min = Math.min(Math.abs(this.f19118a.f() - this.f19118a.j()), Math.abs(fArr2[2] - fArr2[0]));
            int i3 = this.f19059g.f19060a;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                if (i3 <= xBounds.f19062c + xBounds.f19060a) {
                    BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.X(i3);
                    this.f19066j[0] = bubbleEntry.m();
                    this.f19066j[1] = bubbleEntry.c() * i2;
                    a2.o(this.f19066j);
                    float o = o(bubbleEntry.t(), iBubbleDataSet.a(), min, e2) / 2.0f;
                    if (this.f19118a.K(this.f19066j[1] + o) && this.f19118a.H(this.f19066j[1] - o) && this.f19118a.I(this.f19066j[0] + o)) {
                        if (this.f19118a.J(this.f19066j[0] - o)) {
                            this.f19079c.setColor(iBubbleDataSet.d0((int) bubbleEntry.m()));
                            float[] fArr3 = this.f19066j;
                            canvas.drawCircle(fArr3[0], fArr3[1], o, this.f19079c);
                        } else {
                            return;
                        }
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public float o(float f2, float f3, float f4, boolean z) {
        if (z) {
            f2 = f3 == 0.0f ? 1.0f : (float) Math.sqrt((double) (f2 / f3));
        }
        return f4 * f2;
    }
}
