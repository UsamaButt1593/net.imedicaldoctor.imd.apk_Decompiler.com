package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
    private RectF N3 = new RectF();
    private boolean O3 = true;
    private float[] P3 = new float[1];
    private float[] Q3 = new float[1];
    private boolean R3 = true;
    private boolean S3 = false;
    private boolean T3 = false;
    private boolean U3 = false;
    private CharSequence V3 = "";
    private MPPointF W3 = MPPointF.c(0.0f, 0.0f);
    private float X3 = 50.0f;
    protected float Y3 = 55.0f;
    private boolean Z3 = true;
    private float a4 = 100.0f;
    protected float b4 = 360.0f;
    private float c4 = 0.0f;

    public PieChart(Context context) {
        super(context);
    }

    private float g0(float f2) {
        return h0(f2, ((PieData) this.X2).T());
    }

    private float h0(float f2, float f3) {
        return (f2 / f3) * this.b4;
    }

    private void i0() {
        int r = ((PieData) this.X2).r();
        if (this.P3.length != r) {
            this.P3 = new float[r];
        } else {
            for (int i2 = 0; i2 < r; i2++) {
                this.P3[i2] = 0.0f;
            }
        }
        if (this.Q3.length != r) {
            this.Q3 = new float[r];
        } else {
            for (int i3 = 0; i3 < r; i3++) {
                this.Q3[i3] = 0.0f;
            }
        }
        float T = ((PieData) this.X2).T();
        List q = ((PieData) this.X2).q();
        float f2 = this.c4;
        boolean z = f2 != 0.0f && ((float) r) * f2 <= this.b4;
        float[] fArr = new float[r];
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i4 = 0;
        for (int i5 = 0; i5 < ((PieData) this.X2).m(); i5++) {
            IPieDataSet iPieDataSet = (IPieDataSet) q.get(i5);
            for (int i6 = 0; i6 < iPieDataSet.e1(); i6++) {
                float h0 = h0(Math.abs(((PieEntry) iPieDataSet.X(i6)).c()), T);
                if (z) {
                    float f5 = this.c4;
                    float f6 = h0 - f5;
                    if (f6 <= 0.0f) {
                        fArr[i4] = f5;
                        f3 += -f6;
                    } else {
                        fArr[i4] = h0;
                        f4 += f6;
                    }
                }
                this.P3[i4] = h0;
                float[] fArr2 = this.Q3;
                if (i4 == 0) {
                    fArr2[i4] = h0;
                } else {
                    fArr2[i4] = fArr2[i4 - 1] + h0;
                }
                i4++;
            }
        }
        if (z) {
            for (int i7 = 0; i7 < r; i7++) {
                float f7 = fArr[i7];
                float f8 = f7 - (((f7 - this.c4) / f4) * f3);
                fArr[i7] = f8;
                if (i7 == 0) {
                    this.Q3[0] = fArr[0];
                } else {
                    float[] fArr3 = this.Q3;
                    fArr3[i7] = fArr3[i7 - 1] + f8;
                }
            }
            this.P3 = fArr;
        }
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new PieChartRenderer(this, this.q3, this.p3);
        this.e3 = null;
        this.o3 = new PieHighlighter(this);
    }

    public int b0(float f2) {
        float z = Utils.z(f2 - getRotationAngle());
        int i2 = 0;
        while (true) {
            float[] fArr = this.Q3;
            if (i2 >= fArr.length) {
                return -1;
            }
            if (fArr[i2] > z) {
                return i2;
            }
            i2++;
        }
    }

    public float[] getAbsoluteAngles() {
        return this.Q3;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.c(this.N3.centerX(), this.N3.centerY());
    }

    public CharSequence getCenterText() {
        return this.V3;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.W3;
        return MPPointF.c(mPPointF.Y, mPPointF.Z);
    }

    public float getCenterTextRadiusPercent() {
        return this.a4;
    }

    public RectF getCircleBox() {
        return this.N3;
    }

    public float[] getDrawAngles() {
        return this.P3;
    }

    public float getHoleRadius() {
        return this.X3;
    }

    public float getMaxAngle() {
        return this.b4;
    }

    public float getMinAngleForSlices() {
        return this.c4;
    }

    public float getRadius() {
        RectF rectF = this.N3;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.N3.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.m3.e().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.Y3;
    }

    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public int j0(int i2) {
        List q = ((PieData) this.X2).q();
        for (int i3 = 0; i3 < q.size(); i3++) {
            if (((IPieDataSet) q.get(i3)).x((float) i2, Float.NaN) != null) {
                return i3;
            }
        }
        return -1;
    }

    public boolean k0() {
        return this.Z3;
    }

    public boolean l0() {
        return this.O3;
    }

    public boolean m0() {
        return this.R3;
    }

    public boolean n0() {
        return this.U3;
    }

    /* access modifiers changed from: protected */
    public void o() {
        i0();
    }

    public boolean o0() {
        return this.S3;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.n3;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).w();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.X2 != null) {
            this.n3.b(canvas);
            if (Y()) {
                this.n3.d(canvas, this.w3);
            }
            this.n3.c(canvas);
            this.n3.f(canvas);
            this.m3.f(canvas);
            u(canvas);
            v(canvas);
        }
    }

    public void p() {
        super.p();
        if (this.X2 != null) {
            float diameter = getDiameter() / 2.0f;
            MPPointF centerOffsets = getCenterOffsets();
            float P0 = ((PieData) this.X2).Q().P0();
            RectF rectF = this.N3;
            float f2 = centerOffsets.Y;
            float f3 = centerOffsets.Z;
            rectF.set((f2 - diameter) + P0, (f3 - diameter) + P0, (f2 + diameter) - P0, (f3 + diameter) - P0);
            MPPointF.h(centerOffsets);
        }
    }

    public boolean p0() {
        return this.T3;
    }

    public boolean q0(int i2) {
        if (!Y()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Highlight[] highlightArr = this.w3;
            if (i3 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i3].h()) == i2) {
                return true;
            }
            i3++;
        }
    }

    public void r0(float f2, float f3) {
        this.W3.Y = Utils.e(f2);
        this.W3.Z = Utils.e(f3);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.V3 = charSequence;
    }

    public void setCenterTextColor(int i2) {
        ((PieChartRenderer) this.n3).r().setColor(i2);
    }

    public void setCenterTextRadiusPercent(float f2) {
        this.a4 = f2;
    }

    public void setCenterTextSize(float f2) {
        ((PieChartRenderer) this.n3).r().setTextSize(Utils.e(f2));
    }

    public void setCenterTextSizePixels(float f2) {
        ((PieChartRenderer) this.n3).r().setTextSize(f2);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.n3).r().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.Z3 = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.O3 = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.R3 = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.U3 = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.O3 = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.S3 = z;
    }

    public void setEntryLabelColor(int i2) {
        ((PieChartRenderer) this.n3).s().setColor(i2);
    }

    public void setEntryLabelTextSize(float f2) {
        ((PieChartRenderer) this.n3).s().setTextSize(Utils.e(f2));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.n3).s().setTypeface(typeface);
    }

    public void setHoleColor(int i2) {
        ((PieChartRenderer) this.n3).t().setColor(i2);
    }

    public void setHoleRadius(float f2) {
        this.X3 = f2;
    }

    public void setMaxAngle(float f2) {
        if (f2 > 360.0f) {
            f2 = 360.0f;
        }
        if (f2 < 90.0f) {
            f2 = 90.0f;
        }
        this.b4 = f2;
    }

    public void setMinAngleForSlices(float f2) {
        float f3 = this.b4;
        if (f2 > f3 / 2.0f) {
            f2 = f3 / 2.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.c4 = f2;
    }

    public void setTransparentCircleAlpha(int i2) {
        ((PieChartRenderer) this.n3).u().setAlpha(i2);
    }

    public void setTransparentCircleColor(int i2) {
        Paint u = ((PieChartRenderer) this.n3).u();
        int alpha = u.getAlpha();
        u.setColor(i2);
        u.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f2) {
        this.Y3 = f2;
    }

    public void setUsePercentValues(boolean z) {
        this.T3 = z;
    }

    /* access modifiers changed from: protected */
    public float[] y(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f2 = (radius / 10.0f) * 3.6f;
        if (m0()) {
            f2 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f3 = radius - f2;
        float rotationAngle = getRotationAngle();
        int h2 = (int) highlight.h();
        float f4 = this.P3[h2] / 2.0f;
        double d2 = (double) f3;
        float cos = (float) ((Math.cos(Math.toRadians((double) (((this.Q3[h2] + rotationAngle) - f4) * this.q3.i()))) * d2) + ((double) centerCircleBox.Y));
        MPPointF.h(centerCircleBox);
        return new float[]{cos, (float) ((d2 * Math.sin(Math.toRadians((double) (((rotationAngle + this.Q3[h2]) - f4) * this.q3.i())))) + ((double) centerCircleBox.Z))};
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
