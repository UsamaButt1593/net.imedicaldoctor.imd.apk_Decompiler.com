package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarBuffer extends AbstractBuffer<IBarDataSet> {

    /* renamed from: g  reason: collision with root package name */
    protected int f18914g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f18915h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f18916i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f18917j = false;

    /* renamed from: k  reason: collision with root package name */
    protected float f18918k = 1.0f;

    public BarBuffer(int i2, int i3, boolean z) {
        super(i2);
        this.f18915h = i3;
        this.f18916i = z;
    }

    /* access modifiers changed from: protected */
    public void g(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f18909b;
        int i2 = this.f18908a;
        int i3 = i2 + 1;
        this.f18908a = i3;
        fArr[i2] = f2;
        int i4 = i2 + 2;
        this.f18908a = i4;
        fArr[i3] = f3;
        int i5 = i2 + 3;
        this.f18908a = i5;
        fArr[i4] = f4;
        this.f18908a = i2 + 4;
        fArr[i5] = f5;
    }

    /* renamed from: h */
    public void a(IBarDataSet iBarDataSet) {
        float f2;
        float f3;
        float f4;
        float f5;
        float e1 = ((float) iBarDataSet.e1()) * this.f18910c;
        float f6 = this.f18918k / 2.0f;
        for (int i2 = 0; ((float) i2) < e1; i2++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.X(i2);
            if (barEntry != null) {
                float m2 = barEntry.m();
                float c2 = barEntry.c();
                float[] I = barEntry.I();
                if (!this.f18916i || I == null) {
                    float f7 = m2 - f6;
                    float f8 = m2 + f6;
                    if (this.f18917j) {
                        f2 = c2 >= 0.0f ? c2 : 0.0f;
                        if (c2 > 0.0f) {
                            c2 = 0.0f;
                        }
                    } else {
                        float f9 = c2 >= 0.0f ? c2 : 0.0f;
                        if (c2 > 0.0f) {
                            c2 = 0.0f;
                        }
                        float f10 = c2;
                        c2 = f9;
                        f2 = f10;
                    }
                    if (c2 > 0.0f) {
                        c2 *= this.f18911d;
                    } else {
                        f2 *= this.f18911d;
                    }
                    g(f7, c2, f8, f2);
                } else {
                    float f11 = -barEntry.C();
                    int i3 = 0;
                    float f12 = 0.0f;
                    while (i3 < I.length) {
                        float f13 = I[i3];
                        int i4 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
                        if (i4 == 0 && (f12 == 0.0f || f11 == 0.0f)) {
                            f3 = f13;
                            f4 = f11;
                            f11 = f3;
                        } else if (i4 >= 0) {
                            f3 = f13 + f12;
                            f4 = f11;
                            f11 = f12;
                            f12 = f3;
                        } else {
                            f3 = Math.abs(f13) + f11;
                            f4 = Math.abs(f13) + f11;
                        }
                        float f14 = m2 - f6;
                        float f15 = m2 + f6;
                        if (this.f18917j) {
                            f5 = f11 >= f3 ? f11 : f3;
                            if (f11 > f3) {
                                f11 = f3;
                            }
                        } else {
                            float f16 = f11 >= f3 ? f11 : f3;
                            if (f11 > f3) {
                                f11 = f3;
                            }
                            float f17 = f11;
                            f11 = f16;
                            f5 = f17;
                        }
                        float f18 = this.f18911d;
                        g(f14, f11 * f18, f15, f5 * f18);
                        i3++;
                        f11 = f4;
                    }
                }
            }
        }
        d();
    }

    public void i(float f2) {
        this.f18918k = f2;
    }

    public void j(int i2) {
        this.f18914g = i2;
    }

    public void k(boolean z) {
        this.f18917j = z;
    }
}
