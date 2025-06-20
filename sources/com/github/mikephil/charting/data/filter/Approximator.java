package com.github.mikephil.charting.data.filter;

import android.annotation.TargetApi;
import java.util.Arrays;

public class Approximator {

    private class Line {

        /* renamed from: a  reason: collision with root package name */
        private float[] f18996a;

        /* renamed from: b  reason: collision with root package name */
        private float f18997b;

        /* renamed from: c  reason: collision with root package name */
        private float f18998c;

        /* renamed from: d  reason: collision with root package name */
        private float f18999d;

        /* renamed from: e  reason: collision with root package name */
        private float f19000e;

        /* renamed from: f  reason: collision with root package name */
        private float f19001f;

        public Line(float f2, float f3, float f4, float f5) {
            float f6 = f2 - f4;
            this.f18999d = f6;
            float f7 = f3 - f5;
            this.f19000e = f7;
            this.f18997b = f2 * f5;
            this.f18998c = f4 * f3;
            this.f19001f = (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
            this.f18996a = new float[]{f2, f3, f4, f5};
        }

        public float a(float f2, float f3) {
            return Math.abs((((this.f19000e * f2) - (this.f18999d * f3)) + this.f18997b) - this.f18998c) / this.f19001f;
        }

        public float[] b() {
            return this.f18996a;
        }
    }

    /* access modifiers changed from: package-private */
    public float[] a(float[]... fArr) {
        int i2 = 0;
        for (float[] length : fArr) {
            i2 += length.length;
        }
        float[] fArr2 = new float[i2];
        int i3 = 0;
        for (float[] fArr3 : fArr) {
            for (float f2 : fArr[r3]) {
                fArr2[i3] = f2;
                i3++;
            }
        }
        return fArr2;
    }

    @TargetApi(9)
    public float[] b(float[] fArr, float f2) {
        Line line = new Line(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f3 = 0.0f;
        int i2 = 0;
        for (int i3 = 2; i3 < fArr.length - 2; i3 += 2) {
            float a2 = line.a(fArr[i3], fArr[i3 + 1]);
            if (a2 > f3) {
                i2 = i3;
                f3 = a2;
            }
        }
        if (f3 <= f2) {
            return line.b();
        }
        float[] b2 = b(Arrays.copyOfRange(fArr, 0, i2 + 2), f2);
        float[] b3 = b(Arrays.copyOfRange(fArr, i2, fArr.length), f2);
        return a(b2, Arrays.copyOfRange(b3, 2, b3.length));
    }
}
