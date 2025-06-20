package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: h  reason: collision with root package name */
    protected BarDataProvider f19053h;

    /* renamed from: i  reason: collision with root package name */
    protected RectF f19054i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    protected BarBuffer[] f19055j;

    /* renamed from: k  reason: collision with root package name */
    protected Paint f19056k;

    /* renamed from: l  reason: collision with root package name */
    protected Paint f19057l;

    /* renamed from: m  reason: collision with root package name */
    private RectF f19058m = new RectF();

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19053h = barDataProvider;
        Paint paint = new Paint(1);
        this.f19080d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f19080d.setColor(Color.rgb(0, 0, 0));
        this.f19080d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f19056k = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f19057l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    public void b(Canvas canvas) {
        BarData barData = this.f19053h.getBarData();
        for (int i2 = 0; i2 < barData.m(); i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.k(i2);
            if (iBarDataSet.isVisible()) {
                n(canvas, iBarDataSet, i2);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        float f2;
        float f3;
        BarData barData = this.f19053h.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.k(highlight.d());
            if (iBarDataSet != null && iBarDataSet.i1()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.x(highlight.h(), highlight.j());
                if (l(barEntry, iBarDataSet)) {
                    Transformer a2 = this.f19053h.a(iBarDataSet.a1());
                    this.f19080d.setColor(iBarDataSet.Y0());
                    this.f19080d.setAlpha(iBarDataSet.M0());
                    if (highlight.g() < 0 || !barEntry.K()) {
                        f3 = barEntry.c();
                        f2 = 0.0f;
                    } else if (this.f19053h.d()) {
                        float D = barEntry.D();
                        f2 = -barEntry.C();
                        f3 = D;
                    } else {
                        Range range = barEntry.E()[highlight.g()];
                        f3 = range.f19033a;
                        f2 = range.f19034b;
                    }
                    o(barEntry.m(), f3, f2, barData.Q() / 2.0f, a2);
                    p(highlight, this.f19054i);
                    canvas.drawRect(this.f19054i, this.f19080d);
                }
            }
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        boolean z;
        float f2;
        float f3;
        List list;
        boolean z2;
        MPPointF mPPointF;
        int i2;
        float f4;
        boolean z3;
        Transformer transformer;
        float[] fArr;
        float f5;
        int i3;
        int i4;
        BarEntry barEntry;
        float[] fArr2;
        float f6;
        float f7;
        float f8;
        BarEntry barEntry2;
        List list2;
        int i5;
        ValueFormatter valueFormatter;
        MPPointF mPPointF2;
        float f9;
        BarEntry barEntry3;
        if (k(this.f19053h)) {
            List q = this.f19053h.getBarData().q();
            float e2 = Utils.e(4.5f);
            boolean c2 = this.f19053h.c();
            int i6 = 0;
            while (i6 < this.f19053h.getBarData().m()) {
                IBarDataSet iBarDataSet = (IBarDataSet) q.get(i6);
                if (!m(iBarDataSet)) {
                    list = q;
                    f3 = f2;
                    z2 = z;
                } else {
                    a(iBarDataSet);
                    boolean f10 = this.f19053h.f(iBarDataSet.a1());
                    float a2 = (float) Utils.a(this.f19082f, "8");
                    float f11 = z ? -f2 : a2 + f2;
                    float f12 = z ? a2 + f2 : -f2;
                    if (f10) {
                        f11 = (-f11) - a2;
                        f12 = (-f12) - a2;
                    }
                    float f13 = f11;
                    float f14 = f12;
                    BarBuffer barBuffer = this.f19055j[i6];
                    float i7 = this.f19078b.i();
                    ValueFormatter T = iBarDataSet.T();
                    MPPointF d2 = MPPointF.d(iBarDataSet.f1());
                    d2.Y = Utils.e(d2.Y);
                    d2.Z = Utils.e(d2.Z);
                    if (!iBarDataSet.U0()) {
                        int i8 = 0;
                        while (((float) i8) < ((float) barBuffer.f18909b.length) * this.f19078b.h()) {
                            float[] fArr3 = barBuffer.f18909b;
                            float f15 = (fArr3[i8] + fArr3[i8 + 2]) / 2.0f;
                            if (!this.f19118a.J(f15)) {
                                break;
                            }
                            int i9 = i8 + 1;
                            if (!this.f19118a.M(barBuffer.f18909b[i9]) || !this.f19118a.I(f15)) {
                                i5 = i8;
                                valueFormatter = T;
                                list2 = q;
                                mPPointF2 = d2;
                            } else {
                                int i10 = i8 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.X(i10);
                                float c3 = barEntry4.c();
                                if (iBarDataSet.V0()) {
                                    String d3 = T.d(barEntry4);
                                    int i11 = (c3 > 0.0f ? 1 : (c3 == 0.0f ? 0 : -1));
                                    float[] fArr4 = barBuffer.f18909b;
                                    barEntry3 = barEntry4;
                                    f9 = f15;
                                    String str = d3;
                                    i5 = i8;
                                    list2 = q;
                                    mPPointF2 = d2;
                                    float f16 = i11 >= 0 ? fArr4[i9] + f13 : fArr4[i8 + 3] + f14;
                                    valueFormatter = T;
                                    e(canvas, str, f9, f16, iBarDataSet.u0(i10));
                                } else {
                                    barEntry3 = barEntry4;
                                    f9 = f15;
                                    i5 = i8;
                                    valueFormatter = T;
                                    list2 = q;
                                    mPPointF2 = d2;
                                }
                                if (barEntry3.b() != null && iBarDataSet.B()) {
                                    Drawable b2 = barEntry3.b();
                                    Utils.k(canvas, b2, (int) (f9 + mPPointF2.Y), (int) ((c3 >= 0.0f ? barBuffer.f18909b[i9] + f13 : barBuffer.f18909b[i5 + 3] + f14) + mPPointF2.Z), b2.getIntrinsicWidth(), b2.getIntrinsicHeight());
                                }
                            }
                            i8 = i5 + 4;
                            d2 = mPPointF2;
                            T = valueFormatter;
                            q = list2;
                        }
                        list = q;
                        mPPointF = d2;
                    } else {
                        ValueFormatter valueFormatter2 = T;
                        list = q;
                        mPPointF = d2;
                        Transformer a3 = this.f19053h.a(iBarDataSet.a1());
                        int i12 = 0;
                        int i13 = 0;
                        while (((float) i12) < ((float) iBarDataSet.e1()) * this.f19078b.h()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.X(i12);
                            float[] I = barEntry5.I();
                            float[] fArr5 = barBuffer.f18909b;
                            float f17 = (fArr5[i13] + fArr5[i13 + 2]) / 2.0f;
                            int u0 = iBarDataSet.u0(i12);
                            if (I != null) {
                                BarEntry barEntry6 = barEntry5;
                                i2 = i12;
                                f4 = f2;
                                z3 = z;
                                fArr = I;
                                transformer = a3;
                                float f18 = f17;
                                int length = fArr.length * 2;
                                float[] fArr6 = new float[length];
                                float f19 = -barEntry6.C();
                                int i14 = 0;
                                int i15 = 0;
                                float f20 = 0.0f;
                                while (i14 < length) {
                                    float f21 = fArr[i15];
                                    int i16 = (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1));
                                    if (i16 == 0 && (f20 == 0.0f || f19 == 0.0f)) {
                                        float f22 = f19;
                                        f19 = f21;
                                        f7 = f22;
                                    } else if (i16 >= 0) {
                                        f20 += f21;
                                        f7 = f19;
                                        f19 = f20;
                                    } else {
                                        f7 = f19 - f21;
                                    }
                                    fArr6[i14 + 1] = f19 * i7;
                                    i14 += 2;
                                    i15++;
                                    f19 = f7;
                                }
                                transformer.o(fArr6);
                                int i17 = 0;
                                while (i17 < length) {
                                    float f23 = fArr[i17 / 2];
                                    float f24 = fArr6[i17 + 1] + (((f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) == 0 && (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) > 0) || (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) < 0 ? f14 : f13);
                                    int i18 = i17;
                                    if (!this.f19118a.J(f18)) {
                                        break;
                                    }
                                    if (!this.f19118a.M(f24) || !this.f19118a.I(f18)) {
                                        i3 = length;
                                        f5 = f18;
                                        i4 = i18;
                                        barEntry = barEntry6;
                                        fArr2 = fArr6;
                                    } else {
                                        if (iBarDataSet.V0()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f6 = f24;
                                            i4 = i18;
                                            barEntry = barEntry7;
                                            fArr2 = fArr6;
                                            i3 = length;
                                            f5 = f18;
                                            e(canvas, valueFormatter2.e(f23, barEntry7), f18, f6, u0);
                                        } else {
                                            f6 = f24;
                                            i3 = length;
                                            f5 = f18;
                                            i4 = i18;
                                            barEntry = barEntry6;
                                            fArr2 = fArr6;
                                        }
                                        if (barEntry.b() != null && iBarDataSet.B()) {
                                            Drawable b3 = barEntry.b();
                                            Utils.k(canvas, b3, (int) (f5 + mPPointF.Y), (int) (f6 + mPPointF.Z), b3.getIntrinsicWidth(), b3.getIntrinsicHeight());
                                        }
                                    }
                                    i17 = i4 + 2;
                                    fArr6 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i3;
                                    f18 = f5;
                                }
                            } else if (!this.f19118a.J(f17)) {
                                break;
                            } else {
                                float[] fArr7 = I;
                                int i19 = i13 + 1;
                                if (!this.f19118a.M(barBuffer.f18909b[i19]) || !this.f19118a.I(f17)) {
                                    a3 = a3;
                                    z = z;
                                    f2 = f2;
                                    i12 = i12;
                                } else {
                                    if (iBarDataSet.V0()) {
                                        f8 = f17;
                                        f4 = f2;
                                        fArr = fArr7;
                                        barEntry2 = barEntry5;
                                        i2 = i12;
                                        z3 = z;
                                        transformer = a3;
                                        e(canvas, valueFormatter2.d(barEntry5), f8, barBuffer.f18909b[i19] + (barEntry5.c() >= 0.0f ? f13 : f14), u0);
                                    } else {
                                        f8 = f17;
                                        i2 = i12;
                                        f4 = f2;
                                        z3 = z;
                                        fArr = fArr7;
                                        barEntry2 = barEntry5;
                                        transformer = a3;
                                    }
                                    if (barEntry2.b() != null && iBarDataSet.B()) {
                                        Drawable b4 = barEntry2.b();
                                        Utils.k(canvas, b4, (int) (mPPointF.Y + f8), (int) (barBuffer.f18909b[i19] + (barEntry2.c() >= 0.0f ? f13 : f14) + mPPointF.Z), b4.getIntrinsicWidth(), b4.getIntrinsicHeight());
                                    }
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12 = i2 + 1;
                            a3 = transformer;
                            z = z3;
                            f2 = f4;
                        }
                    }
                    f3 = f2;
                    z2 = z;
                    MPPointF.h(mPPointF);
                }
                i6++;
                c2 = z2;
                q = list;
                e2 = f3;
            }
        }
    }

    public void j() {
        BarData barData = this.f19053h.getBarData();
        this.f19055j = new BarBuffer[barData.m()];
        for (int i2 = 0; i2 < this.f19055j.length; i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.k(i2);
            this.f19055j[i2] = new BarBuffer(iBarDataSet.e1() * 4 * (iBarDataSet.U0() ? iBarDataSet.C0() : 1), barData.m(), iBarDataSet.U0());
        }
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, IBarDataSet iBarDataSet, int i2) {
        IBarDataSet iBarDataSet2 = iBarDataSet;
        int i3 = i2;
        Transformer a2 = this.f19053h.a(iBarDataSet.a1());
        this.f19057l.setColor(iBarDataSet.v());
        this.f19057l.setStrokeWidth(Utils.e(iBarDataSet.F()));
        int i4 = 0;
        boolean z = true;
        boolean z2 = iBarDataSet.F() > 0.0f;
        float h2 = this.f19078b.h();
        float i5 = this.f19078b.i();
        if (this.f19053h.b()) {
            this.f19056k.setColor(iBarDataSet.l0());
            float Q = this.f19053h.getBarData().Q() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) iBarDataSet.e1()) * h2)), iBarDataSet.e1());
            for (int i6 = 0; i6 < min; i6++) {
                float m2 = ((BarEntry) iBarDataSet2.X(i6)).m();
                RectF rectF = this.f19058m;
                rectF.left = m2 - Q;
                rectF.right = m2 + Q;
                a2.t(rectF);
                if (!this.f19118a.I(this.f19058m.right)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f19118a.J(this.f19058m.left)) {
                    break;
                } else {
                    this.f19058m.top = this.f19118a.j();
                    this.f19058m.bottom = this.f19118a.f();
                    canvas.drawRect(this.f19058m, this.f19056k);
                }
            }
        }
        Canvas canvas3 = canvas;
        BarBuffer barBuffer = this.f19055j[i3];
        barBuffer.e(h2, i5);
        barBuffer.j(i3);
        barBuffer.k(this.f19053h.f(iBarDataSet.a1()));
        barBuffer.i(this.f19053h.getBarData().Q());
        barBuffer.a(iBarDataSet2);
        a2.o(barBuffer.f18909b);
        if (iBarDataSet.B0().size() != 1) {
            z = false;
        }
        if (z) {
            this.f19079c.setColor(iBarDataSet.g1());
        }
        while (i4 < barBuffer.f()) {
            int i7 = i4 + 2;
            if (this.f19118a.I(barBuffer.f18909b[i7])) {
                if (this.f19118a.J(barBuffer.f18909b[i4])) {
                    if (!z) {
                        this.f19079c.setColor(iBarDataSet2.d0(i4 / 4));
                    }
                    if (iBarDataSet.M() != null) {
                        GradientColor M = iBarDataSet.M();
                        Paint paint = this.f19079c;
                        float[] fArr = barBuffer.f18909b;
                        float f2 = fArr[i4];
                        paint.setShader(new LinearGradient(f2, fArr[i4 + 3], f2, fArr[i4 + 1], M.b(), M.a(), Shader.TileMode.MIRROR));
                    }
                    if (iBarDataSet.N0() != null) {
                        Paint paint2 = this.f19079c;
                        float[] fArr2 = barBuffer.f18909b;
                        float f3 = fArr2[i4];
                        float f4 = fArr2[i4 + 3];
                        float f5 = fArr2[i4 + 1];
                        int i8 = i4 / 4;
                        paint2.setShader(new LinearGradient(f3, f4, f3, f5, iBarDataSet2.m1(i8).b(), iBarDataSet2.m1(i8).a(), Shader.TileMode.MIRROR));
                    }
                    float[] fArr3 = barBuffer.f18909b;
                    int i9 = i4 + 1;
                    int i10 = i4 + 3;
                    canvas.drawRect(fArr3[i4], fArr3[i9], fArr3[i7], fArr3[i10], this.f19079c);
                    if (z2) {
                        float[] fArr4 = barBuffer.f18909b;
                        canvas.drawRect(fArr4[i4], fArr4[i9], fArr4[i7], fArr4[i10], this.f19057l);
                    }
                } else {
                    return;
                }
            }
            i4 += 4;
            Canvas canvas4 = canvas;
        }
    }

    /* access modifiers changed from: protected */
    public void o(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.f19054i.set(f2 - f5, f3, f2 + f5, f4);
        transformer.r(this.f19054i, this.f19078b.i());
    }

    /* access modifiers changed from: protected */
    public void p(Highlight highlight, RectF rectF) {
        highlight.n(rectF.centerX(), rectF.top);
    }
}
