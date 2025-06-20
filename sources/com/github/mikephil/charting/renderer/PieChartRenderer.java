package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

public class PieChartRenderer extends DataRenderer {

    /* renamed from: g  reason: collision with root package name */
    protected PieChart f19105g;

    /* renamed from: h  reason: collision with root package name */
    protected Paint f19106h;

    /* renamed from: i  reason: collision with root package name */
    protected Paint f19107i;

    /* renamed from: j  reason: collision with root package name */
    protected Paint f19108j;

    /* renamed from: k  reason: collision with root package name */
    private TextPaint f19109k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f19110l;

    /* renamed from: m  reason: collision with root package name */
    private StaticLayout f19111m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f19112n;
    private RectF o = new RectF();
    private RectF[] p = {new RectF(), new RectF(), new RectF()};
    protected WeakReference<Bitmap> q;
    protected Canvas r;
    private Path s = new Path();
    private RectF t = new RectF();
    private Path u = new Path();
    protected Path v = new Path();
    protected RectF w = new RectF();

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19105g = pieChart;
        Paint paint = new Paint(1);
        this.f19106h = paint;
        paint.setColor(-1);
        Paint paint2 = this.f19106h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f19107i = paint3;
        paint3.setColor(-1);
        this.f19107i.setStyle(style);
        this.f19107i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f19109k = textPaint;
        textPaint.setColor(ViewCompat.y);
        this.f19109k.setTextSize(Utils.e(12.0f));
        this.f19082f.setTextSize(Utils.e(13.0f));
        this.f19082f.setColor(-1);
        Paint paint4 = this.f19082f;
        Paint.Align align = Paint.Align.CENTER;
        paint4.setTextAlign(align);
        Paint paint5 = new Paint(1);
        this.f19110l = paint5;
        paint5.setColor(-1);
        this.f19110l.setTextAlign(align);
        this.f19110l.setTextSize(Utils.e(13.0f));
        Paint paint6 = new Paint(1);
        this.f19108j = paint6;
        paint6.setStyle(Paint.Style.STROKE);
    }

    public void b(Canvas canvas) {
        int o2 = (int) this.f19118a.o();
        int n2 = (int) this.f19118a.n();
        WeakReference<Bitmap> weakReference = this.q;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == o2 && bitmap.getHeight() == n2)) {
            if (o2 > 0 && n2 > 0) {
                bitmap = Bitmap.createBitmap(o2, n2, Bitmap.Config.ARGB_4444);
                this.q = new WeakReference<>(bitmap);
                this.r = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.f19105g.getData()).q()) {
            if (iPieDataSet.isVisible() && iPieDataSet.e1() > 0) {
                n(canvas, iPieDataSet);
            }
        }
    }

    public void c(Canvas canvas) {
        p(canvas);
        canvas.drawBitmap(this.q.get(), 0.0f, 0.0f, (Paint) null);
        m(canvas);
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        boolean z;
        float[] fArr;
        float f2;
        MPPointF mPPointF;
        float f3;
        int i2;
        RectF rectF;
        float f4;
        IPieDataSet R;
        float f5;
        int i3;
        int i4;
        float f6;
        float[] fArr2;
        float f7;
        float f8;
        Highlight[] highlightArr2 = highlightArr;
        boolean z2 = this.f19105g.m0() && !this.f19105g.o0();
        if (!z2 || !this.f19105g.n0()) {
            float h2 = this.f19078b.h();
            float i5 = this.f19078b.i();
            float rotationAngle = this.f19105g.getRotationAngle();
            float[] drawAngles = this.f19105g.getDrawAngles();
            float[] absoluteAngles = this.f19105g.getAbsoluteAngles();
            MPPointF centerCircleBox = this.f19105g.getCenterCircleBox();
            float radius = this.f19105g.getRadius();
            float holeRadius = z2 ? (this.f19105g.getHoleRadius() / 100.0f) * radius : 0.0f;
            RectF rectF2 = this.w;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            int i6 = 0;
            while (i6 < highlightArr2.length) {
                int h3 = (int) highlightArr2[i6].h();
                if (h3 < drawAngles.length && (R = ((PieData) this.f19105g.getData()).k(highlightArr2[i6].d())) != null && R.i1()) {
                    int e1 = R.e1();
                    int i7 = 0;
                    for (int i8 = 0; i8 < e1; i8++) {
                        if (Math.abs(((PieEntry) R.X(i8)).c()) > Utils.f19169g) {
                            i7++;
                        }
                    }
                    if (h3 == 0) {
                        i3 = 1;
                        f5 = 0.0f;
                    } else {
                        f5 = absoluteAngles[h3 - 1] * h2;
                        i3 = 1;
                    }
                    float i9 = i7 <= i3 ? 0.0f : R.i();
                    float f9 = drawAngles[h3];
                    float P0 = R.P0();
                    int i10 = i6;
                    float f10 = radius + P0;
                    float f11 = holeRadius;
                    rectF2.set(this.f19105g.getCircleBox());
                    float f12 = -P0;
                    rectF2.inset(f12, f12);
                    boolean z3 = i9 > 0.0f && f9 <= 180.0f;
                    this.f19079c.setColor(R.d0(h3));
                    float f13 = i7 == 1 ? 0.0f : i9 / (radius * 0.017453292f);
                    float f14 = i7 == 1 ? 0.0f : i9 / (f10 * 0.017453292f);
                    float f15 = rotationAngle + (((f13 / 2.0f) + f5) * i5);
                    float f16 = (f9 - f13) * i5;
                    float f17 = f16 < 0.0f ? 0.0f : f16;
                    float f18 = (((f14 / 2.0f) + f5) * i5) + rotationAngle;
                    float f19 = (f9 - f14) * i5;
                    if (f19 < 0.0f) {
                        f19 = 0.0f;
                    }
                    this.s.reset();
                    int i11 = (f17 > 360.0f ? 1 : (f17 == 360.0f ? 0 : -1));
                    if (i11 < 0 || f17 % 360.0f > Utils.f19169g) {
                        fArr2 = drawAngles;
                        f6 = f5;
                        double d2 = (double) (f18 * 0.017453292f);
                        i4 = i7;
                        z = z2;
                        this.s.moveTo(centerCircleBox.Y + (((float) Math.cos(d2)) * f10), centerCircleBox.Z + (f10 * ((float) Math.sin(d2))));
                        this.s.arcTo(rectF2, f18, f19);
                    } else {
                        this.s.addCircle(centerCircleBox.Y, centerCircleBox.Z, f10, Path.Direction.CW);
                        fArr2 = drawAngles;
                        f6 = f5;
                        i4 = i7;
                        z = z2;
                    }
                    if (z3) {
                        double d3 = (double) (f15 * 0.017453292f);
                        i2 = i10;
                        rectF = rectF2;
                        f3 = f11;
                        mPPointF = centerCircleBox;
                        fArr = fArr2;
                        f7 = l(centerCircleBox, radius, f9 * i5, (((float) Math.cos(d3)) * radius) + centerCircleBox.Y, centerCircleBox.Z + (((float) Math.sin(d3)) * radius), f15, f17);
                    } else {
                        rectF = rectF2;
                        mPPointF = centerCircleBox;
                        i2 = i10;
                        f3 = f11;
                        fArr = fArr2;
                        f7 = 0.0f;
                    }
                    RectF rectF3 = this.t;
                    float f20 = mPPointF.Y;
                    float f21 = mPPointF.Z;
                    rectF3.set(f20 - f3, f21 - f3, f20 + f3, f21 + f3);
                    if (!z || (f3 <= 0.0f && !z3)) {
                        f4 = h2;
                        f2 = i5;
                        if (f17 % 360.0f > Utils.f19169g) {
                            if (z3) {
                                double d4 = (double) ((f15 + (f17 / 2.0f)) * 0.017453292f);
                                this.s.lineTo(mPPointF.Y + (((float) Math.cos(d4)) * f7), mPPointF.Z + (f7 * ((float) Math.sin(d4))));
                            } else {
                                this.s.lineTo(mPPointF.Y, mPPointF.Z);
                            }
                        }
                    } else {
                        if (z3) {
                            if (f7 < 0.0f) {
                                f7 = -f7;
                            }
                            f8 = Math.max(f3, f7);
                        } else {
                            f8 = f3;
                        }
                        float f22 = (i4 == 1 || f8 == 0.0f) ? 0.0f : i9 / (f8 * 0.017453292f);
                        float f23 = ((f6 + (f22 / 2.0f)) * i5) + rotationAngle;
                        float f24 = (f9 - f22) * i5;
                        if (f24 < 0.0f) {
                            f24 = 0.0f;
                        }
                        float f25 = f23 + f24;
                        if (i11 < 0 || f17 % 360.0f > Utils.f19169g) {
                            double d5 = (double) (f25 * 0.017453292f);
                            f4 = h2;
                            f2 = i5;
                            this.s.lineTo(mPPointF.Y + (((float) Math.cos(d5)) * f8), mPPointF.Z + (f8 * ((float) Math.sin(d5))));
                            this.s.arcTo(this.t, f25, -f24);
                        } else {
                            this.s.addCircle(mPPointF.Y, mPPointF.Z, f8, Path.Direction.CCW);
                            f4 = h2;
                            f2 = i5;
                        }
                    }
                    this.s.close();
                    this.r.drawPath(this.s, this.f19079c);
                } else {
                    i2 = i6;
                    rectF = rectF2;
                    f3 = holeRadius;
                    fArr = drawAngles;
                    z = z2;
                    f4 = h2;
                    f2 = i5;
                    mPPointF = centerCircleBox;
                }
                i6 = i2 + 1;
                h2 = f4;
                rectF2 = rectF;
                holeRadius = f3;
                centerCircleBox = mPPointF;
                i5 = f2;
                drawAngles = fArr;
                z2 = z;
                highlightArr2 = highlightArr;
            }
            MPPointF.h(centerCircleBox);
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.graphics.Canvas r53) {
        /*
            r52 = this;
            r6 = r52
            r7 = r53
            com.github.mikephil.charting.charts.PieChart r0 = r6.f19105g
            com.github.mikephil.charting.utils.MPPointF r8 = r0.getCenterCircleBox()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f19105g
            float r9 = r0.getRadius()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f19105g
            float r0 = r0.getRotationAngle()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f19105g
            float[] r10 = r1.getDrawAngles()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f19105g
            float[] r11 = r1.getAbsoluteAngles()
            com.github.mikephil.charting.animation.ChartAnimator r1 = r6.f19078b
            float r12 = r1.h()
            com.github.mikephil.charting.animation.ChartAnimator r1 = r6.f19078b
            float r13 = r1.i()
            com.github.mikephil.charting.charts.PieChart r1 = r6.f19105g
            float r1 = r1.getHoleRadius()
            float r1 = r1 * r9
            r14 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r14
            float r1 = r9 - r1
            r15 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r15
            com.github.mikephil.charting.charts.PieChart r2 = r6.f19105g
            float r2 = r2.getHoleRadius()
            float r16 = r2 / r14
            r2 = 1092616192(0x41200000, float:10.0)
            float r2 = r9 / r2
            r3 = 1080452710(0x40666666, float:3.6)
            float r2 = r2 * r3
            com.github.mikephil.charting.charts.PieChart r3 = r6.f19105g
            boolean r3 = r3.m0()
            if (r3 == 0) goto L_0x007d
            float r2 = r9 * r16
            float r2 = r9 - r2
            float r2 = r2 / r15
            com.github.mikephil.charting.charts.PieChart r3 = r6.f19105g
            boolean r3 = r3.o0()
            if (r3 != 0) goto L_0x007d
            com.github.mikephil.charting.charts.PieChart r3 = r6.f19105g
            boolean r3 = r3.n0()
            if (r3 == 0) goto L_0x007d
            double r3 = (double) r0
            r0 = 1135869952(0x43b40000, float:360.0)
            float r1 = r1 * r0
            double r0 = (double) r1
            r17 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r14 = (double) r9
            double r14 = r14 * r17
            double r0 = r0 / r14
            double r3 = r3 + r0
            float r0 = (float) r3
        L_0x007d:
            r14 = r0
            float r15 = r9 - r2
            com.github.mikephil.charting.charts.PieChart r0 = r6.f19105g
            com.github.mikephil.charting.data.ChartData r0 = r0.getData()
            r17 = r0
            com.github.mikephil.charting.data.PieData r17 = (com.github.mikephil.charting.data.PieData) r17
            java.util.List r5 = r17.q()
            float r18 = r17.T()
            com.github.mikephil.charting.charts.PieChart r0 = r6.f19105g
            boolean r21 = r0.l0()
            r53.save()
            r0 = 1084227584(0x40a00000, float:5.0)
            float r22 = com.github.mikephil.charting.utils.Utils.e(r0)
            r23 = 0
            r0 = 0
            r4 = 0
        L_0x00a5:
            int r1 = r5.size()
            if (r4 >= r1) goto L_0x040e
            java.lang.Object r1 = r5.get(r4)
            r3 = r1
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r3 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r3
            boolean r24 = r3.V0()
            if (r24 != 0) goto L_0x00d2
            if (r21 != 0) goto L_0x00d2
            r26 = r4
            r28 = r5
            r29 = r9
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r10 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r9 = r7
            r13 = r8
            goto L_0x03fa
        L_0x00d2:
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r2 = r3.h0()
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r1 = r3.w0()
            r6.a(r3)
            r25 = r0
            android.graphics.Paint r0 = r6.f19082f
            r26 = r4
            java.lang.String r4 = "Q"
            int r0 = com.github.mikephil.charting.utils.Utils.a(r0, r4)
            float r0 = (float) r0
            r4 = 1082130432(0x40800000, float:4.0)
            float r4 = com.github.mikephil.charting.utils.Utils.e(r4)
            float r27 = r0 + r4
            com.github.mikephil.charting.formatter.ValueFormatter r4 = r3.T()
            int r0 = r3.e1()
            r28 = r5
            android.graphics.Paint r5 = r6.f19108j
            int r7 = r3.a0()
            r5.setColor(r7)
            android.graphics.Paint r5 = r6.f19108j
            float r7 = r3.e0()
            float r7 = com.github.mikephil.charting.utils.Utils.e(r7)
            r5.setStrokeWidth(r7)
            float r7 = r6.v(r3)
            com.github.mikephil.charting.utils.MPPointF r5 = r3.f1()
            com.github.mikephil.charting.utils.MPPointF r5 = com.github.mikephil.charting.utils.MPPointF.d(r5)
            r29 = r8
            float r8 = r5.Y
            float r8 = com.github.mikephil.charting.utils.Utils.e(r8)
            r5.Y = r8
            float r8 = r5.Z
            float r8 = com.github.mikephil.charting.utils.Utils.e(r8)
            r5.Z = r8
            r8 = 0
        L_0x0131:
            if (r8 >= r0) goto L_0x03e0
            com.github.mikephil.charting.data.Entry r30 = r3.X(r8)
            r31 = r5
            r5 = r30
            com.github.mikephil.charting.data.PieEntry r5 = (com.github.mikephil.charting.data.PieEntry) r5
            if (r25 != 0) goto L_0x0142
            r30 = 0
            goto L_0x0148
        L_0x0142:
            int r30 = r25 + -1
            r30 = r11[r30]
            float r30 = r30 * r12
        L_0x0148:
            r32 = r10[r25]
            r33 = 1016003125(0x3c8efa35, float:0.017453292)
            float r34 = r15 * r33
            float r34 = r7 / r34
            r20 = 1073741824(0x40000000, float:2.0)
            float r34 = r34 / r20
            float r32 = r32 - r34
            float r32 = r32 / r20
            float r30 = r30 + r32
            float r30 = r30 * r13
            r32 = r0
            float r0 = r14 + r30
            r30 = r7
            com.github.mikephil.charting.charts.PieChart r7 = r6.f19105g
            boolean r7 = r7.p0()
            if (r7 == 0) goto L_0x0176
            float r7 = r5.c()
            float r7 = r7 / r18
            r19 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r19
            goto L_0x017a
        L_0x0176:
            float r7 = r5.c()
        L_0x017a:
            java.lang.String r7 = r4.i(r7, r5)
            r34 = r10
            java.lang.String r10 = r5.t()
            r35 = r4
            float r4 = r0 * r33
            r33 = r5
            double r4 = (double) r4
            r36 = r11
            r37 = r12
            double r11 = java.lang.Math.cos(r4)
            float r11 = (float) r11
            r38 = r13
            double r12 = java.lang.Math.sin(r4)
            float r12 = (float) r12
            if (r21 == 0) goto L_0x01a3
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r13 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r2 != r13) goto L_0x01a3
            r13 = 1
            goto L_0x01a4
        L_0x01a3:
            r13 = 0
        L_0x01a4:
            r40 = r14
            if (r24 == 0) goto L_0x01ae
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r14 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r1 != r14) goto L_0x01ae
            r14 = 1
            goto L_0x01af
        L_0x01ae:
            r14 = 0
        L_0x01af:
            r41 = r10
            if (r21 == 0) goto L_0x01b9
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r10 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r2 != r10) goto L_0x01b9
            r10 = 1
            goto L_0x01ba
        L_0x01b9:
            r10 = 0
        L_0x01ba:
            r42 = r2
            if (r24 == 0) goto L_0x01c5
            com.github.mikephil.charting.data.PieDataSet$ValuePosition r2 = com.github.mikephil.charting.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r1 != r2) goto L_0x01c5
            r39 = 1
            goto L_0x01c7
        L_0x01c5:
            r39 = 0
        L_0x01c7:
            if (r13 != 0) goto L_0x01e1
            if (r14 == 0) goto L_0x01cc
            goto L_0x01e1
        L_0x01cc:
            r45 = r1
            r44 = r12
            r50 = r29
            r51 = r31
            r31 = r33
            r14 = r41
            r19 = 1120403456(0x42c80000, float:100.0)
            r12 = r3
            r29 = r9
            r9 = r53
            goto L_0x031e
        L_0x01e1:
            float r2 = r3.f0()
            float r43 = r3.D0()
            float r44 = r3.T0()
            r19 = 1120403456(0x42c80000, float:100.0)
            float r44 = r44 / r19
            r45 = r1
            com.github.mikephil.charting.charts.PieChart r1 = r6.f19105g
            boolean r1 = r1.m0()
            if (r1 == 0) goto L_0x0204
            float r1 = r9 * r16
            float r46 = r9 - r1
            float r46 = r46 * r44
            float r46 = r46 + r1
            goto L_0x0206
        L_0x0204:
            float r46 = r9 * r44
        L_0x0206:
            boolean r1 = r3.A0()
            float r43 = r43 * r15
            if (r1 == 0) goto L_0x0219
            double r4 = java.lang.Math.sin(r4)
            double r4 = java.lang.Math.abs(r4)
            float r1 = (float) r4
            float r43 = r43 * r1
        L_0x0219:
            float r1 = r46 * r11
            r5 = r29
            float r4 = r5.Y
            float r1 = r1 + r4
            float r46 = r46 * r12
            r29 = r9
            float r9 = r5.Z
            float r44 = r46 + r9
            r46 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 + r46
            float r2 = r2 * r15
            float r46 = r2 * r11
            float r46 = r46 + r4
            float r2 = r2 * r12
            float r9 = r9 + r2
            r47 = r5
            double r4 = (double) r0
            r48 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r4 = r4 % r48
            r48 = 4636033603912859648(0x4056800000000000, double:90.0)
            int r0 = (r4 > r48 ? 1 : (r4 == r48 ? 0 : -1))
            if (r0 < 0) goto L_0x0267
            r48 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r0 = (r4 > r48 ? 1 : (r4 == r48 ? 0 : -1))
            if (r0 > 0) goto L_0x0267
            float r0 = r46 - r43
            android.graphics.Paint r2 = r6.f19082f
            android.graphics.Paint$Align r4 = android.graphics.Paint.Align.RIGHT
            r2.setTextAlign(r4)
            if (r13 == 0) goto L_0x0261
            android.graphics.Paint r2 = r6.f19110l
            r2.setTextAlign(r4)
        L_0x0261:
            float r2 = r0 - r22
            r43 = r0
            r5 = r2
            goto L_0x027a
        L_0x0267:
            float r43 = r46 + r43
            android.graphics.Paint r0 = r6.f19082f
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r2)
            if (r13 == 0) goto L_0x0277
            android.graphics.Paint r0 = r6.f19110l
            r0.setTextAlign(r2)
        L_0x0277:
            float r0 = r43 + r22
            r5 = r0
        L_0x027a:
            int r0 = r3.a0()
            r2 = 1122867(0x112233, float:1.573472E-39)
            if (r0 == r2) goto L_0x02b8
            boolean r0 = r3.L0()
            if (r0 == 0) goto L_0x0292
            android.graphics.Paint r0 = r6.f19108j
            int r2 = r3.d0(r8)
            r0.setColor(r2)
        L_0x0292:
            android.graphics.Paint r4 = r6.f19108j
            r0 = r53
            r2 = r44
            r44 = r12
            r12 = r3
            r3 = r46
            r48 = r4
            r4 = r9
            r51 = r31
            r31 = r33
            r50 = r47
            r33 = r5
            r5 = r48
            r0.drawLine(r1, r2, r3, r4, r5)
            android.graphics.Paint r5 = r6.f19108j
            r1 = r46
            r2 = r9
            r3 = r43
            r0.drawLine(r1, r2, r3, r4, r5)
            goto L_0x02c3
        L_0x02b8:
            r44 = r12
            r51 = r31
            r31 = r33
            r50 = r47
            r12 = r3
            r33 = r5
        L_0x02c3:
            if (r13 == 0) goto L_0x02f1
            if (r14 == 0) goto L_0x02f1
            int r5 = r12.u0(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r33
            r4 = r9
            r0.e(r1, r2, r3, r4, r5)
            int r0 = r17.r()
            if (r8 >= r0) goto L_0x02ec
            if (r41 == 0) goto L_0x02ec
            float r9 = r9 + r27
            r5 = r53
            r3 = r33
            r4 = r41
        L_0x02e6:
            r6.o(r5, r4, r3, r9)
        L_0x02e9:
            r14 = r4
            r9 = r5
            goto L_0x031e
        L_0x02ec:
            r9 = r53
            r14 = r41
            goto L_0x031e
        L_0x02f1:
            r5 = r53
            r3 = r33
            r4 = r41
            if (r13 == 0) goto L_0x0307
            int r0 = r17.r()
            if (r8 >= r0) goto L_0x02e9
            if (r4 == 0) goto L_0x02e9
            r0 = 1073741824(0x40000000, float:2.0)
            float r1 = r27 / r0
            float r9 = r9 + r1
            goto L_0x02e6
        L_0x0307:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r14 == 0) goto L_0x02e9
            float r1 = r27 / r0
            float r9 = r9 + r1
            int r13 = r12.u0(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r14 = r4
            r4 = r9
            r9 = r5
            r5 = r13
            r0.e(r1, r2, r3, r4, r5)
        L_0x031e:
            if (r10 != 0) goto L_0x0329
            if (r39 == 0) goto L_0x0323
            goto L_0x0329
        L_0x0323:
            r13 = r50
        L_0x0325:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x038a
        L_0x0329:
            float r0 = r15 * r11
            r13 = r50
            float r1 = r13.Y
            float r5 = r0 + r1
            float r0 = r15 * r44
            float r1 = r13.Z
            float r33 = r0 + r1
            android.graphics.Paint r0 = r6.f19082f
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r1)
            if (r10 == 0) goto L_0x0361
            if (r39 == 0) goto L_0x0361
            int r10 = r12.u0(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r3 = r5
            r4 = r33
            r7 = r5
            r5 = r10
            r0.e(r1, r2, r3, r4, r5)
            int r0 = r17.r()
            if (r8 >= r0) goto L_0x0325
            if (r14 == 0) goto L_0x0325
            float r0 = r33 + r27
            r6.o(r9, r14, r7, r0)
            goto L_0x0325
        L_0x0361:
            r3 = r5
            if (r10 == 0) goto L_0x0376
            int r0 = r17.r()
            if (r8 >= r0) goto L_0x0325
            if (r14 == 0) goto L_0x0325
            r10 = 1073741824(0x40000000, float:2.0)
            float r0 = r27 / r10
            float r0 = r33 + r0
            r6.o(r9, r14, r3, r0)
            goto L_0x038a
        L_0x0376:
            r10 = 1073741824(0x40000000, float:2.0)
            if (r39 == 0) goto L_0x038a
            float r0 = r27 / r10
            float r4 = r33 + r0
            int r5 = r12.u0(r8)
            r0 = r52
            r1 = r53
            r2 = r7
            r0.e(r1, r2, r3, r4, r5)
        L_0x038a:
            android.graphics.drawable.Drawable r0 = r31.b()
            if (r0 == 0) goto L_0x03be
            boolean r0 = r12.B()
            if (r0 == 0) goto L_0x03be
            android.graphics.drawable.Drawable r1 = r31.b()
            r7 = r51
            float r0 = r7.Z
            float r2 = r15 + r0
            float r2 = r2 * r11
            float r3 = r13.Y
            float r2 = r2 + r3
            float r0 = r0 + r15
            float r0 = r0 * r44
            float r3 = r13.Z
            float r0 = r0 + r3
            float r3 = r7.Y
            float r0 = r0 + r3
            int r2 = (int) r2
            int r3 = (int) r0
            int r4 = r1.getIntrinsicWidth()
            int r5 = r1.getIntrinsicHeight()
            r0 = r53
            com.github.mikephil.charting.utils.Utils.k(r0, r1, r2, r3, r4, r5)
            goto L_0x03c0
        L_0x03be:
            r7 = r51
        L_0x03c0:
            int r25 = r25 + 1
            int r8 = r8 + 1
            r5 = r7
            r3 = r12
            r9 = r29
            r7 = r30
            r0 = r32
            r10 = r34
            r4 = r35
            r11 = r36
            r12 = r37
            r14 = r40
            r2 = r42
            r1 = r45
            r29 = r13
            r13 = r38
            goto L_0x0131
        L_0x03e0:
            r7 = r5
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r13 = r29
            r10 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r29 = r9
            r9 = r53
            com.github.mikephil.charting.utils.MPPointF.h(r7)
            r0 = r25
        L_0x03fa:
            int r4 = r26 + 1
            r7 = r9
            r8 = r13
            r5 = r28
            r9 = r29
            r10 = r34
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r40
            goto L_0x00a5
        L_0x040e:
            r9 = r7
            r13 = r8
            com.github.mikephil.charting.utils.MPPointF.h(r13)
            r53.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.f(android.graphics.Canvas):void");
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public float l(MPPointF mPPointF, float f2, float f3, float f4, float f5, float f6, float f7) {
        MPPointF mPPointF2 = mPPointF;
        double d2 = (double) ((f6 + f7) * 0.017453292f);
        float cos = mPPointF2.Y + (((float) Math.cos(d2)) * f2);
        float sin = mPPointF2.Z + (((float) Math.sin(d2)) * f2);
        double d3 = (double) ((f6 + (f7 / 2.0f)) * 0.017453292f);
        return (float) (((double) (f2 - ((float) ((Math.sqrt(Math.pow((double) (cos - f4), 2.0d) + Math.pow((double) (sin - f5), 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f3)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((double) ((mPPointF2.Y + (((float) Math.cos(d3)) * f2)) - ((cos + f4) / 2.0f)), 2.0d) + Math.pow((double) ((mPPointF2.Z + (((float) Math.sin(d3)) * f2)) - ((sin + f5) / 2.0f)), 2.0d)));
    }

    /* access modifiers changed from: protected */
    public void m(Canvas canvas) {
        MPPointF mPPointF;
        Canvas canvas2 = canvas;
        CharSequence centerText = this.f19105g.getCenterText();
        if (this.f19105g.k0() && centerText != null) {
            MPPointF centerCircleBox = this.f19105g.getCenterCircleBox();
            MPPointF centerTextOffset = this.f19105g.getCenterTextOffset();
            float f2 = centerCircleBox.Y + centerTextOffset.Y;
            float f3 = centerCircleBox.Z + centerTextOffset.Z;
            float radius = (!this.f19105g.m0() || this.f19105g.o0()) ? this.f19105g.getRadius() : this.f19105g.getRadius() * (this.f19105g.getHoleRadius() / 100.0f);
            RectF[] rectFArr = this.p;
            RectF rectF = rectFArr[0];
            rectF.left = f2 - radius;
            rectF.top = f3 - radius;
            rectF.right = f2 + radius;
            rectF.bottom = f3 + radius;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.f19105g.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.f19112n) || !rectF2.equals(this.o)) {
                this.o.set(rectF2);
                this.f19112n = centerText;
                mPPointF = centerTextOffset;
                StaticLayout staticLayout = r3;
                StaticLayout staticLayout2 = new StaticLayout(centerText, 0, centerText.length(), this.f19109k, (int) Math.max(Math.ceil((double) this.o.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                this.f19111m = staticLayout;
            } else {
                mPPointF = centerTextOffset;
            }
            canvas.save();
            Path path = this.v;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas2.clipPath(path);
            canvas2.translate(rectF2.left, rectF2.top + ((rectF2.height() - ((float) this.f19111m.getHeight())) / 2.0f));
            this.f19111m.draw(canvas2);
            canvas.restore();
            MPPointF.h(centerCircleBox);
            MPPointF.h(mPPointF);
        }
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, IPieDataSet iPieDataSet) {
        RectF rectF;
        float f2;
        float[] fArr;
        int i2;
        RectF rectF2;
        int i3;
        float f3;
        float f4;
        int i4;
        MPPointF mPPointF;
        float f5;
        int i5;
        float f6;
        RectF rectF3;
        float f7;
        float f8;
        int i6;
        RectF rectF4;
        RectF rectF5;
        int i7;
        MPPointF mPPointF2;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.f19105g.getRotationAngle();
        float h2 = this.f19078b.h();
        float i8 = this.f19078b.i();
        RectF circleBox = this.f19105g.getCircleBox();
        int e1 = iPieDataSet.e1();
        float[] drawAngles = this.f19105g.getDrawAngles();
        MPPointF centerCircleBox = this.f19105g.getCenterCircleBox();
        float radius = this.f19105g.getRadius();
        boolean z = this.f19105g.m0() && !this.f19105g.o0();
        float holeRadius = z ? (this.f19105g.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.f19105g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF6 = new RectF();
        boolean z2 = z && this.f19105g.n0();
        int i9 = 0;
        for (int i10 = 0; i10 < e1; i10++) {
            if (Math.abs(((PieEntry) iPieDataSet2.X(i10)).c()) > Utils.f19169g) {
                i9++;
            }
        }
        float v2 = i9 <= 1 ? 0.0f : v(iPieDataSet2);
        int i11 = 0;
        float f9 = 0.0f;
        while (i11 < e1) {
            float f10 = drawAngles[i11];
            float abs = Math.abs(iPieDataSet2.X(i11).c());
            float f11 = Utils.f19169g;
            if (abs > f11 && (!this.f19105g.q0(i11) || z2)) {
                boolean z3 = v2 > 0.0f && f10 <= 180.0f;
                this.f19079c.setColor(iPieDataSet2.d0(i11));
                float f12 = i9 == 1 ? 0.0f : v2 / (radius * 0.017453292f);
                float f13 = rotationAngle + ((f9 + (f12 / 2.0f)) * i8);
                float f14 = (f10 - f12) * i8;
                if (f14 < 0.0f) {
                    f14 = 0.0f;
                }
                this.s.reset();
                if (z2) {
                    float f15 = radius - holeRadius2;
                    i3 = i11;
                    i5 = i9;
                    double d2 = (double) (f13 * 0.017453292f);
                    i2 = e1;
                    fArr = drawAngles;
                    float cos = centerCircleBox.Y + (((float) Math.cos(d2)) * f15);
                    float sin = centerCircleBox.Z + (f15 * ((float) Math.sin(d2)));
                    rectF6.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i3 = i11;
                    i5 = i9;
                    i2 = e1;
                    fArr = drawAngles;
                }
                double d3 = (double) (f13 * 0.017453292f);
                f3 = rotationAngle;
                f2 = h2;
                float cos2 = centerCircleBox.Y + (((float) Math.cos(d3)) * radius);
                float sin2 = centerCircleBox.Z + (((float) Math.sin(d3)) * radius);
                int i12 = (f14 > 360.0f ? 1 : (f14 == 360.0f ? 0 : -1));
                if (i12 < 0 || f14 % 360.0f > f11) {
                    if (z2) {
                        this.s.arcTo(rectF6, f13 + 180.0f, -180.0f);
                    }
                    this.s.arcTo(circleBox, f13, f14);
                } else {
                    this.s.addCircle(centerCircleBox.Y, centerCircleBox.Z, radius, Path.Direction.CW);
                }
                RectF rectF7 = this.t;
                float f16 = centerCircleBox.Y;
                float f17 = centerCircleBox.Z;
                float f18 = f14;
                rectF7.set(f16 - holeRadius, f17 - holeRadius, f16 + holeRadius, f17 + holeRadius);
                if (!z) {
                    rectF3 = rectF6;
                    f7 = holeRadius;
                    f8 = radius;
                    i6 = i5;
                    rectF4 = circleBox;
                    mPPointF = centerCircleBox;
                    f6 = 360.0f;
                } else if (holeRadius > 0.0f || z3) {
                    if (z3) {
                        i4 = i5;
                        rectF2 = circleBox;
                        f5 = holeRadius;
                        rectF5 = rectF6;
                        i7 = 1;
                        f4 = radius;
                        float f19 = f13;
                        mPPointF2 = centerCircleBox;
                        float l2 = l(centerCircleBox, radius, f10 * i8, cos2, sin2, f19, f18);
                        if (l2 < 0.0f) {
                            l2 = -l2;
                        }
                        holeRadius = Math.max(f5, l2);
                    } else {
                        rectF5 = rectF6;
                        f5 = holeRadius;
                        f4 = radius;
                        mPPointF2 = centerCircleBox;
                        i4 = i5;
                        rectF2 = circleBox;
                        i7 = 1;
                    }
                    float f20 = (i4 == i7 || holeRadius == 0.0f) ? 0.0f : v2 / (holeRadius * 0.017453292f);
                    float f21 = f3 + ((f9 + (f20 / 2.0f)) * i8);
                    float f22 = (f10 - f20) * i8;
                    if (f22 < 0.0f) {
                        f22 = 0.0f;
                    }
                    float f23 = f21 + f22;
                    if (i12 < 0 || f18 % 360.0f > f11) {
                        if (z2) {
                            float f24 = f4 - holeRadius2;
                            double d4 = (double) (f23 * 0.017453292f);
                            float cos3 = mPPointF2.Y + (((float) Math.cos(d4)) * f24);
                            float sin3 = mPPointF2.Z + (f24 * ((float) Math.sin(d4)));
                            RectF rectF8 = rectF5;
                            rectF8.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.s.arcTo(rectF8, f23, 180.0f);
                            rectF = rectF8;
                        } else {
                            double d5 = (double) (f23 * 0.017453292f);
                            rectF = rectF5;
                            this.s.lineTo(mPPointF2.Y + (((float) Math.cos(d5)) * holeRadius), mPPointF2.Z + (holeRadius * ((float) Math.sin(d5))));
                        }
                        this.s.arcTo(this.t, f23, -f22);
                    } else {
                        this.s.addCircle(mPPointF2.Y, mPPointF2.Z, holeRadius, Path.Direction.CCW);
                        rectF = rectF5;
                    }
                    mPPointF = mPPointF2;
                    this.s.close();
                    this.r.drawPath(this.s, this.f19079c);
                    f9 += f10 * f2;
                } else {
                    rectF3 = rectF6;
                    f7 = holeRadius;
                    f8 = radius;
                    i6 = i5;
                    f6 = 360.0f;
                    rectF4 = circleBox;
                    mPPointF = centerCircleBox;
                }
                if (f18 % f6 > f11) {
                    if (z3) {
                        float l3 = l(mPPointF, f4, f10 * i8, cos2, sin2, f13, f18);
                        double d6 = (double) ((f13 + (f18 / 2.0f)) * 0.017453292f);
                        this.s.lineTo(mPPointF.Y + (((float) Math.cos(d6)) * l3), mPPointF.Z + (l3 * ((float) Math.sin(d6))));
                    } else {
                        this.s.lineTo(mPPointF.Y, mPPointF.Z);
                    }
                }
                this.s.close();
                this.r.drawPath(this.s, this.f19079c);
                f9 += f10 * f2;
            } else {
                f9 += f10 * h2;
                i3 = i11;
                rectF = rectF6;
                f4 = radius;
                f3 = rotationAngle;
                f2 = h2;
                rectF2 = circleBox;
                i2 = e1;
                fArr = drawAngles;
                i4 = i9;
                f5 = holeRadius;
                mPPointF = centerCircleBox;
            }
            i11 = i3 + 1;
            rectF6 = rectF;
            iPieDataSet2 = iPieDataSet;
            holeRadius = f5;
            centerCircleBox = mPPointF;
            i9 = i4;
            radius = f4;
            rotationAngle = f3;
            circleBox = rectF2;
            e1 = i2;
            drawAngles = fArr;
            h2 = f2;
        }
        MPPointF.h(centerCircleBox);
    }

    /* access modifiers changed from: protected */
    public void o(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2, f3, this.f19110l);
    }

    /* access modifiers changed from: protected */
    public void p(Canvas canvas) {
        if (this.f19105g.m0() && this.r != null) {
            float radius = this.f19105g.getRadius();
            float holeRadius = (this.f19105g.getHoleRadius() / 100.0f) * radius;
            MPPointF centerCircleBox = this.f19105g.getCenterCircleBox();
            if (Color.alpha(this.f19106h.getColor()) > 0) {
                this.r.drawCircle(centerCircleBox.Y, centerCircleBox.Z, holeRadius, this.f19106h);
            }
            if (Color.alpha(this.f19107i.getColor()) > 0 && this.f19105g.getTransparentCircleRadius() > this.f19105g.getHoleRadius()) {
                int alpha = this.f19107i.getAlpha();
                float transparentCircleRadius = radius * (this.f19105g.getTransparentCircleRadius() / 100.0f);
                this.f19107i.setAlpha((int) (((float) alpha) * this.f19078b.h() * this.f19078b.i()));
                this.u.reset();
                this.u.addCircle(centerCircleBox.Y, centerCircleBox.Z, transparentCircleRadius, Path.Direction.CW);
                this.u.addCircle(centerCircleBox.Y, centerCircleBox.Z, holeRadius, Path.Direction.CCW);
                this.r.drawPath(this.u, this.f19107i);
                this.f19107i.setAlpha(alpha);
            }
            MPPointF.h(centerCircleBox);
        }
    }

    /* access modifiers changed from: protected */
    public void q(Canvas canvas) {
        float f2;
        float f3;
        float[] fArr;
        if (this.f19105g.n0()) {
            IPieDataSet Q = ((PieData) this.f19105g.getData()).Q();
            if (Q.isVisible()) {
                float h2 = this.f19078b.h();
                float i2 = this.f19078b.i();
                MPPointF centerCircleBox = this.f19105g.getCenterCircleBox();
                float radius = this.f19105g.getRadius();
                float holeRadius = (radius - ((this.f19105g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.f19105g.getDrawAngles();
                float rotationAngle = this.f19105g.getRotationAngle();
                int i3 = 0;
                while (i3 < Q.e1()) {
                    float f4 = drawAngles[i3];
                    if (Math.abs(Q.X(i3).c()) > Utils.f19169g) {
                        double d2 = (double) (radius - holeRadius);
                        double d3 = (double) ((rotationAngle + f4) * i2);
                        f2 = i2;
                        fArr = drawAngles;
                        f3 = rotationAngle;
                        float cos = (float) (((double) centerCircleBox.Y) + (Math.cos(Math.toRadians(d3)) * d2));
                        float sin = (float) ((d2 * Math.sin(Math.toRadians(d3))) + ((double) centerCircleBox.Z));
                        this.f19079c.setColor(Q.d0(i3));
                        this.r.drawCircle(cos, sin, holeRadius, this.f19079c);
                    } else {
                        f2 = i2;
                        fArr = drawAngles;
                        f3 = rotationAngle;
                    }
                    rotationAngle = f3 + (f4 * h2);
                    i3++;
                    i2 = f2;
                    drawAngles = fArr;
                }
                MPPointF.h(centerCircleBox);
            }
        }
    }

    public TextPaint r() {
        return this.f19109k;
    }

    public Paint s() {
        return this.f19110l;
    }

    public Paint t() {
        return this.f19106h;
    }

    public Paint u() {
        return this.f19107i;
    }

    /* access modifiers changed from: protected */
    public float v(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.U()) {
            return iPieDataSet.i();
        }
        if (iPieDataSet.i() / this.f19118a.y() > (iPieDataSet.J() / ((PieData) this.f19105g.getData()).T()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.i();
    }

    public void w() {
        Canvas canvas = this.r;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.r = null;
        }
        WeakReference<Bitmap> weakReference = this.q;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.q.clear();
            this.q = null;
        }
    }
}
