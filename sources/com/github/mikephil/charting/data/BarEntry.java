package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

@SuppressLint({"ParcelCreator"})
public class BarEntry extends Entry {
    private float[] X2;
    private Range[] Y2;
    private float Z2;
    private float a3;

    public BarEntry(float f2, float f3) {
        super(f2, f3);
    }

    private void p() {
        float[] fArr = this.X2;
        if (fArr == null) {
            this.Z2 = 0.0f;
            this.a3 = 0.0f;
            return;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (float f4 : fArr) {
            if (f4 <= 0.0f) {
                f2 += Math.abs(f4);
            } else {
                f3 += f4;
            }
        }
        this.Z2 = f2;
        this.a3 = f3;
    }

    private static float v(float[] fArr) {
        float f2 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2;
    }

    @Deprecated
    public float B(int i2) {
        return H(i2);
    }

    public float C() {
        return this.Z2;
    }

    public float D() {
        return this.a3;
    }

    public Range[] E() {
        return this.Y2;
    }

    public float H(int i2) {
        float[] fArr = this.X2;
        float f2 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        while (length > i2 && length >= 0) {
            f2 += this.X2[length];
            length--;
        }
        return f2;
    }

    public float[] I() {
        return this.X2;
    }

    public boolean K() {
        return this.X2 != null;
    }

    public void M(float[] fArr) {
        j(v(fArr));
        this.X2 = fArr;
        p();
        t();
    }

    public float c() {
        return super.c();
    }

    /* access modifiers changed from: protected */
    public void t() {
        float[] I = I();
        if (I != null && I.length != 0) {
            this.Y2 = new Range[I.length];
            float f2 = -C();
            int i2 = 0;
            float f3 = 0.0f;
            while (true) {
                Range[] rangeArr = this.Y2;
                if (i2 < rangeArr.length) {
                    float f4 = I[i2];
                    if (f4 < 0.0f) {
                        float f5 = f2 - f4;
                        rangeArr[i2] = new Range(f2, f5);
                        f2 = f5;
                    } else {
                        float f6 = f4 + f3;
                        rangeArr[i2] = new Range(f3, f6);
                        f3 = f6;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: z */
    public BarEntry k() {
        BarEntry barEntry = new BarEntry(m(), c(), a());
        barEntry.M(this.X2);
        return barEntry;
    }

    public BarEntry(float f2, float f3, Drawable drawable) {
        super(f2, f3, drawable);
    }

    public BarEntry(float f2, float f3, Drawable drawable, Object obj) {
        super(f2, f3, drawable, obj);
    }

    public BarEntry(float f2, float f3, Object obj) {
        super(f2, f3, obj);
    }

    public BarEntry(float f2, float[] fArr) {
        super(f2, v(fArr));
        this.X2 = fArr;
        p();
        t();
    }

    public BarEntry(float f2, float[] fArr, Drawable drawable) {
        super(f2, v(fArr), drawable);
        this.X2 = fArr;
        p();
        t();
    }

    public BarEntry(float f2, float[] fArr, Drawable drawable, Object obj) {
        super(f2, v(fArr), drawable, obj);
        this.X2 = fArr;
        p();
        t();
    }

    public BarEntry(float f2, float[] fArr, Object obj) {
        super(f2, v(fArr), obj);
        this.X2 = fArr;
        p();
        t();
    }
}
