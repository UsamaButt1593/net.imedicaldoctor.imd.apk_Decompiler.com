package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    private float J3 = 270.0f;
    private float K3 = 270.0f;
    protected boolean L3 = true;
    protected float M3 = 0.0f;

    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18923a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f18924b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f18925c;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18925c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f18925c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f18924b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f18924b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f18924b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f18923a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f18923a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass2.<clinit>():void");
        }
    }

    public PieRadarChartBase(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.j3 = new PieRadarChartTouchListener(this);
    }

    public void O() {
        if (this.X2 != null) {
            o();
            if (this.h3 != null) {
                this.m3.a(this.X2);
            }
            p();
        }
    }

    public float Z(float f2, float f3) {
        MPPointF centerOffsets = getCenterOffsets();
        float f4 = centerOffsets.Y;
        float f5 = f2 > f4 ? f2 - f4 : f4 - f2;
        float f6 = centerOffsets.Z;
        float sqrt = (float) Math.sqrt(Math.pow((double) f5, 2.0d) + Math.pow((double) (f3 > f6 ? f3 - f6 : f6 - f3), 2.0d));
        MPPointF.h(centerOffsets);
        return sqrt;
    }

    public float a0(float f2, float f3) {
        MPPointF centerOffsets = getCenterOffsets();
        double d2 = (double) (f2 - centerOffsets.Y);
        double d3 = (double) (f3 - centerOffsets.Z);
        float degrees = (float) Math.toDegrees(Math.acos(d3 / Math.sqrt((d2 * d2) + (d3 * d3))));
        if (f2 > centerOffsets.Y) {
            degrees = 360.0f - degrees;
        }
        float f4 = degrees + 90.0f;
        if (f4 > 360.0f) {
            f4 -= 360.0f;
        }
        MPPointF.h(centerOffsets);
        return f4;
    }

    public abstract int b0(float f2);

    public MPPointF c0(MPPointF mPPointF, float f2, float f3) {
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        d0(mPPointF, f2, f3, c2);
        return c2;
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.j3;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) chartTouchListener).i();
        }
    }

    public void d0(MPPointF mPPointF, float f2, float f3, MPPointF mPPointF2) {
        double d2 = (double) f2;
        double d3 = (double) f3;
        mPPointF2.Y = (float) (((double) mPPointF.Y) + (Math.cos(Math.toRadians(d3)) * d2));
        mPPointF2.Z = (float) (((double) mPPointF.Z) + (d2 * Math.sin(Math.toRadians(d3))));
    }

    public boolean e0() {
        return this.L3;
    }

    @SuppressLint({"NewApi"})
    public void f0(int i2, float f2, float f3, Easing.EasingFunction easingFunction) {
        setRotationAngle(f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", new float[]{f2, f3});
        ofFloat.setDuration((long) i2);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        ofFloat.start();
    }

    public float getDiameter() {
        RectF q = this.p3.q();
        q.left += getExtraLeftOffset();
        q.top += getExtraTopOffset();
        q.right -= getExtraRightOffset();
        q.bottom -= getExtraBottomOffset();
        return Math.min(q.width(), q.height());
    }

    public int getMaxVisibleCount() {
        return this.X2.r();
    }

    public float getMinOffset() {
        return this.M3;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.K3;
    }

    /* access modifiers changed from: protected */
    public abstract float getRequiredBaseOffset();

    /* access modifiers changed from: protected */
    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.J3;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.j3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r2) {
        /*
            r1 = this;
            boolean r0 = r1.f3
            if (r0 == 0) goto L_0x000d
            com.github.mikephil.charting.listener.ChartTouchListener r0 = r1.j3
            if (r0 == 0) goto L_0x000d
            boolean r2 = r0.onTouch(r1, r2)
            return r2
        L_0x000d:
            boolean r2 = super.onTouchEvent(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007d, code lost:
        if (r2 != 2) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r11 = this;
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            r1 = 0
            if (r0 == 0) goto L_0x0194
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x0194
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            boolean r0 = r0.H()
            if (r0 != 0) goto L_0x0194
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            float r0 = r0.x
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.p3
            float r2 = r2.o()
            com.github.mikephil.charting.components.Legend r3 = r11.h3
            float r3 = r3.z()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass2.f18925c
            com.github.mikephil.charting.components.Legend r3 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendOrientation r3 = r3.C()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x008c
            if (r2 == r3) goto L_0x003e
            goto L_0x007f
        L_0x003e:
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.E()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP
            if (r0 == r2) goto L_0x0052
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.E()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM
            if (r0 != r2) goto L_0x007f
        L_0x0052:
            float r0 = r11.getRequiredLegendOffset()
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            float r2 = r2.y
            float r2 = r2 + r0
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r11.p3
            float r0 = r0.n()
            com.github.mikephil.charting.components.Legend r5 = r11.h3
            float r5 = r5.z()
            float r0 = r0 * r5
            float r0 = java.lang.Math.min(r2, r0)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass2.f18923a
            com.github.mikephil.charting.components.Legend r5 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = r5.E()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x0087
            if (r2 == r3) goto L_0x0084
        L_0x007f:
            r0 = 0
        L_0x0080:
            r2 = 0
        L_0x0081:
            r3 = 0
            goto L_0x017f
        L_0x0084:
            r2 = r0
            r0 = 0
            goto L_0x0081
        L_0x0087:
            r3 = r0
            r0 = 0
            r2 = 0
            goto L_0x017f
        L_0x008c:
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.y()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT
            if (r2 == r5) goto L_0x00a4
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.y()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            if (r2 != r5) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r0 = 0
            goto L_0x0122
        L_0x00a4:
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.E()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER
            if (r2 != r5) goto L_0x00b6
            r2 = 1095761920(0x41500000, float:13.0)
            float r2 = com.github.mikephil.charting.utils.Utils.e(r2)
            float r0 = r0 + r2
            goto L_0x0122
        L_0x00b6:
            r2 = 1090519040(0x41000000, float:8.0)
            float r2 = com.github.mikephil.charting.utils.Utils.e(r2)
            float r0 = r0 + r2
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            float r5 = r2.y
            float r2 = r2.z
            float r5 = r5 + r2
            com.github.mikephil.charting.utils.MPPointF r2 = r11.getCenter()
            com.github.mikephil.charting.components.Legend r6 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r6 = r6.y()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r7 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            r8 = 1097859072(0x41700000, float:15.0)
            if (r6 != r7) goto L_0x00dc
            int r6 = r11.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 + r8
            goto L_0x00de
        L_0x00dc:
            float r6 = r0 - r8
        L_0x00de:
            float r5 = r5 + r8
            float r7 = r11.Z(r6, r5)
            float r8 = r11.getRadius()
            float r6 = r11.a0(r6, r5)
            com.github.mikephil.charting.utils.MPPointF r6 = r11.c0(r2, r8, r6)
            float r8 = r6.Y
            float r9 = r6.Z
            float r8 = r11.Z(r8, r9)
            r9 = 1084227584(0x40a00000, float:5.0)
            float r9 = com.github.mikephil.charting.utils.Utils.e(r9)
            float r10 = r2.Z
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x0113
            int r5 = r11.getHeight()
            float r5 = (float) r5
            float r5 = r5 - r0
            int r10 = r11.getWidth()
            float r10 = (float) r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0113
            goto L_0x011c
        L_0x0113:
            int r0 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x011b
            float r8 = r8 - r7
            float r9 = r9 + r8
            r0 = r9
            goto L_0x011c
        L_0x011b:
            r0 = 0
        L_0x011c:
            com.github.mikephil.charting.utils.MPPointF.h(r2)
            com.github.mikephil.charting.utils.MPPointF.h(r6)
        L_0x0122:
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass2.f18924b
            com.github.mikephil.charting.components.Legend r5 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = r5.y()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x017c
            if (r2 == r3) goto L_0x0080
            r0 = 3
            if (r2 == r0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            int[] r0 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass2.f18923a
            com.github.mikephil.charting.components.Legend r2 = r11.h3
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.E()
            int r2 = r2.ordinal()
            r0 = r0[r2]
            if (r0 == r4) goto L_0x0164
            if (r0 == r3) goto L_0x014c
        L_0x014a:
            goto L_0x007f
        L_0x014c:
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            float r0 = r0.y
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.p3
            float r2 = r2.n()
            com.github.mikephil.charting.components.Legend r3 = r11.h3
            float r3 = r3.z()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0084
        L_0x0164:
            com.github.mikephil.charting.components.Legend r0 = r11.h3
            float r0 = r0.y
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.p3
            float r2 = r2.n()
            com.github.mikephil.charting.components.Legend r3 = r11.h3
            float r3 = r3.z()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0087
        L_0x017c:
            r1 = r0
            goto L_0x007f
        L_0x017f:
            float r4 = r11.getRequiredBaseOffset()
            float r1 = r1 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r0 = r0 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r3 = r3 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r2 = r2 + r4
            goto L_0x0197
        L_0x0194:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0197:
            float r4 = r11.M3
            float r4 = com.github.mikephil.charting.utils.Utils.e(r4)
            boolean r5 = r11 instanceof com.github.mikephil.charting.charts.RadarChart
            if (r5 == 0) goto L_0x01b8
            com.github.mikephil.charting.components.XAxis r5 = r11.getXAxis()
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x01b8
            boolean r6 = r5.P()
            if (r6 == 0) goto L_0x01b8
            int r5 = r5.L
            float r5 = (float) r5
            float r4 = java.lang.Math.max(r4, r5)
        L_0x01b8:
            float r5 = r11.getExtraTopOffset()
            float r3 = r3 + r5
            float r5 = r11.getExtraRightOffset()
            float r0 = r0 + r5
            float r5 = r11.getExtraBottomOffset()
            float r2 = r2 + r5
            float r5 = r11.getExtraLeftOffset()
            float r1 = r1 + r5
            float r1 = java.lang.Math.max(r4, r1)
            float r3 = java.lang.Math.max(r4, r3)
            float r0 = java.lang.Math.max(r4, r0)
            float r5 = r11.getRequiredBaseOffset()
            float r2 = java.lang.Math.max(r5, r2)
            float r2 = java.lang.Math.max(r4, r2)
            com.github.mikephil.charting.utils.ViewPortHandler r4 = r11.p3
            r4.U(r1, r3, r0, r2)
            boolean r4 = r11.s
            if (r4 == 0) goto L_0x021b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", offsetTop: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "MPAndroidChart"
            android.util.Log.i(r1, r0)
        L_0x021b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.p():void");
    }

    public void setMinOffset(float f2) {
        this.M3 = f2;
    }

    public void setRotationAngle(float f2) {
        this.K3 = f2;
        this.J3 = Utils.z(f2);
    }

    public void setRotationEnabled(boolean z) {
        this.L3 = z;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
