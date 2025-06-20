package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i2, int i3, boolean z) {
        super(i2, i3, z);
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
                    g(f2, f8, c2, f7);
                } else {
                    float f11 = -barEntry.C();
                    int i3 = 0;
                    float f12 = 0.0f;
                    while (i3 < I.length) {
                        float f13 = I[i3];
                        if (f13 >= 0.0f) {
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
                        g(f5 * f18, f15, f11 * f18, f14);
                        i3++;
                        f11 = f4;
                    }
                }
            }
        }
        d();
    }
}
