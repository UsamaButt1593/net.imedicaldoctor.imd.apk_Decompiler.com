package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class ChannelMixingMatrix {

    /* renamed from: a  reason: collision with root package name */
    private final int f9394a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9395b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f9396c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9397d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9398e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9399f;

    public ChannelMixingMatrix(int i2, int i3, float[] fArr) {
        boolean z = false;
        Assertions.b(i2 > 0, "Input channel count must be positive.");
        Assertions.b(i3 > 0, "Output channel count must be positive.");
        Assertions.b(fArr.length == i2 * i3, "Coefficient array length is invalid.");
        this.f9394a = i2;
        this.f9395b = i3;
        this.f9396c = a(fArr);
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        while (i4 < i2) {
            int i5 = 0;
            while (i5 < i3) {
                float e2 = e(i4, i5);
                boolean z5 = i4 == i5;
                if (e2 != 1.0f && z5) {
                    z4 = false;
                }
                if (e2 != 0.0f) {
                    z2 = false;
                    if (!z5) {
                        z3 = false;
                    }
                }
                i5++;
            }
            i4++;
        }
        this.f9397d = z2;
        boolean z6 = j() && z3;
        this.f9398e = z6;
        if (z6 && z4) {
            z = true;
        }
        this.f9399f = z;
    }

    private static float[] a(float[] fArr) {
        int i2 = 0;
        while (i2 < fArr.length) {
            if (fArr[i2] >= 0.0f) {
                i2++;
            } else {
                throw new IllegalArgumentException("Coefficient at index " + i2 + " is negative.");
            }
        }
        return fArr;
    }

    public static ChannelMixingMatrix b(int i2, int i3) {
        return new ChannelMixingMatrix(i2, i3, c(i2, i3));
    }

    private static float[] c(int i2, int i3) {
        if (i2 == i3) {
            return g(i3);
        }
        if (i2 == 1 && i3 == 2) {
            return new float[]{1.0f, 1.0f};
        }
        if (i2 == 2 && i3 == 1) {
            return new float[]{0.5f, 0.5f};
        }
        throw new UnsupportedOperationException("Default channel mixing coefficients for " + i2 + "->" + i3 + " are not yet implemented.");
    }

    private static float[] g(int i2) {
        float[] fArr = new float[(i2 * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[(i2 * i3) + i3] = 1.0f;
        }
        return fArr;
    }

    public int d() {
        return this.f9394a;
    }

    public float e(int i2, int i3) {
        return this.f9396c[(i2 * this.f9395b) + i3];
    }

    public int f() {
        return this.f9395b;
    }

    public boolean h() {
        return this.f9398e;
    }

    public boolean i() {
        return this.f9399f;
    }

    public boolean j() {
        return this.f9394a == this.f9395b;
    }

    public boolean k() {
        return this.f9397d;
    }

    public ChannelMixingMatrix l(float f2) {
        float[] fArr = new float[this.f9396c.length];
        int i2 = 0;
        while (true) {
            float[] fArr2 = this.f9396c;
            if (i2 >= fArr2.length) {
                return new ChannelMixingMatrix(this.f9394a, this.f9395b, fArr);
            }
            fArr[i2] = fArr2[i2] * f2;
            i2++;
        }
    }
}
