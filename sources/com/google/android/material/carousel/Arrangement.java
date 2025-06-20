package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

final class Arrangement {

    /* renamed from: i  reason: collision with root package name */
    private static final float f20916i = 0.1f;

    /* renamed from: a  reason: collision with root package name */
    final int f20917a;

    /* renamed from: b  reason: collision with root package name */
    float f20918b;

    /* renamed from: c  reason: collision with root package name */
    int f20919c;

    /* renamed from: d  reason: collision with root package name */
    int f20920d;

    /* renamed from: e  reason: collision with root package name */
    float f20921e;

    /* renamed from: f  reason: collision with root package name */
    float f20922f;

    /* renamed from: g  reason: collision with root package name */
    final int f20923g;

    /* renamed from: h  reason: collision with root package name */
    final float f20924h;

    Arrangement(int i2, float f2, float f3, float f4, int i3, float f5, int i4, float f6, int i5, float f7) {
        this.f20917a = i2;
        this.f20918b = MathUtils.d(f2, f3, f4);
        this.f20919c = i3;
        this.f20921e = f5;
        this.f20920d = i4;
        this.f20922f = f6;
        this.f20923g = i5;
        d(f7, f3, f4, f6);
        this.f20924h = b(f6);
    }

    private float a(float f2, int i2, float f3, int i3, int i4) {
        if (i2 <= 0) {
            f3 = 0.0f;
        }
        float f4 = ((float) i3) / 2.0f;
        return (f2 - ((((float) i2) + f4) * f3)) / (((float) i4) + f4);
    }

    private float b(float f2) {
        if (!g()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f2 - this.f20922f) * ((float) this.f20917a);
    }

    static Arrangement c(float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        Arrangement arrangement = null;
        int i2 = 1;
        for (int i3 : iArr3) {
            int length = iArr5.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = iArr5[i4];
                int length2 = iArr4.length;
                int i6 = 0;
                while (i6 < length2) {
                    Arrangement arrangement2 = r8;
                    int i7 = i6;
                    int i8 = length2;
                    int i9 = i4;
                    int i10 = length;
                    Arrangement arrangement3 = new Arrangement(i2, f3, f4, f5, iArr4[i6], f6, i5, f7, i3, f2);
                    if (arrangement == null || arrangement2.f20924h < arrangement.f20924h) {
                        if (arrangement2.f20924h == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    i2++;
                    i6 = i7 + 1;
                    length2 = i8;
                    i4 = i9;
                    length = i10;
                }
                int i11 = length;
                i4++;
            }
        }
        return arrangement;
    }

    private void d(float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = f2 - f();
        int i2 = this.f20919c;
        if (i2 > 0 && f7 > 0.0f) {
            float f8 = this.f20918b;
            this.f20918b = f8 + Math.min(f7 / ((float) i2), f4 - f8);
        } else if (i2 > 0 && f7 < 0.0f) {
            float f9 = this.f20918b;
            this.f20918b = f9 + Math.max(f7 / ((float) i2), f3 - f9);
        }
        int i3 = this.f20919c;
        float f10 = i3 > 0 ? this.f20918b : 0.0f;
        this.f20918b = f10;
        float a2 = a(f2, i3, f10, this.f20920d, this.f20923g);
        this.f20922f = a2;
        float f11 = (this.f20918b + a2) / 2.0f;
        this.f20921e = f11;
        int i4 = this.f20920d;
        if (i4 > 0 && a2 != f5) {
            float f12 = (f5 - a2) * ((float) this.f20923g);
            float min = Math.min(Math.abs(f12), f11 * 0.1f * ((float) i4));
            if (f12 > 0.0f) {
                this.f20921e -= min / ((float) this.f20920d);
                f6 = this.f20922f + (min / ((float) this.f20923g));
            } else {
                this.f20921e += min / ((float) this.f20920d);
                f6 = this.f20922f - (min / ((float) this.f20923g));
            }
            this.f20922f = f6;
        }
    }

    private float f() {
        return (this.f20922f * ((float) this.f20923g)) + (this.f20921e * ((float) this.f20920d)) + (this.f20918b * ((float) this.f20919c));
    }

    private boolean g() {
        int i2 = this.f20923g;
        if (i2 <= 0 || this.f20919c <= 0 || this.f20920d <= 0) {
            return i2 <= 0 || this.f20919c <= 0 || this.f20922f > this.f20918b;
        }
        float f2 = this.f20922f;
        float f3 = this.f20921e;
        return f2 > f3 && f3 > this.f20918b;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f20919c + this.f20920d + this.f20923g;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.f20917a + ", smallCount=" + this.f20919c + ", smallSize=" + this.f20918b + ", mediumCount=" + this.f20920d + ", mediumSize=" + this.f20921e + ", largeCount=" + this.f20923g + ", largeSize=" + this.f20922f + ", cost=" + this.f20924h + "]";
    }
}
