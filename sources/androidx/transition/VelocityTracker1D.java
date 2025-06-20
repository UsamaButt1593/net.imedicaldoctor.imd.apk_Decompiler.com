package androidx.transition;

import java.util.Arrays;

class VelocityTracker1D {

    /* renamed from: d  reason: collision with root package name */
    private static final int f16101d = 20;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16102e = 40;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16103f = 100;

    /* renamed from: a  reason: collision with root package name */
    private long[] f16104a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f16105b = new float[20];

    /* renamed from: c  reason: collision with root package name */
    private int f16106c = 0;

    VelocityTracker1D() {
        long[] jArr = new long[20];
        this.f16104a = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float c(float f2) {
        return (float) (((double) Math.signum(f2)) * Math.sqrt((double) (Math.abs(f2) * 2.0f)));
    }

    public void a(long j2, float f2) {
        int i2 = (this.f16106c + 1) % 20;
        this.f16106c = i2;
        this.f16104a[i2] = j2;
        this.f16105b[i2] = f2;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        float c2;
        int i2 = this.f16106c;
        if (i2 == 0 && this.f16104a[i2] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j2 = this.f16104a[i2];
        int i3 = 0;
        long j3 = j2;
        while (true) {
            long j4 = this.f16104a[i2];
            if (j4 != Long.MIN_VALUE) {
                float abs = (float) Math.abs(j4 - j3);
                if (((float) (j2 - j4)) > 100.0f || abs > 40.0f) {
                    break;
                }
                if (i2 == 0) {
                    i2 = 20;
                }
                i2--;
                i3++;
                if (i3 >= 20) {
                    break;
                }
                j3 = j4;
            } else {
                break;
            }
        }
        if (i3 < 2) {
            return 0.0f;
        }
        if (i3 == 2) {
            int i4 = this.f16106c;
            int i5 = i4 == 0 ? 19 : i4 - 1;
            long[] jArr = this.f16104a;
            float f2 = (float) (jArr[i4] - jArr[i5]);
            if (f2 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.f16105b;
            c2 = (fArr[i4] - fArr[i5]) / f2;
        } else {
            int i6 = this.f16106c;
            int i7 = ((i6 - i3) + 21) % 20;
            int i8 = (i6 + 21) % 20;
            long j5 = this.f16104a[i7];
            float f3 = this.f16105b[i7];
            int i9 = i7 + 1;
            float f4 = 0.0f;
            for (int i10 = i9 % 20; i10 != i8; i10 = (i10 + 1) % 20) {
                long j6 = this.f16104a[i10];
                float f5 = (float) (j6 - j5);
                if (f5 != 0.0f) {
                    float f6 = this.f16105b[i10];
                    float f7 = (f6 - f3) / f5;
                    f4 += (f7 - c(f4)) * Math.abs(f7);
                    if (i10 == i9) {
                        f4 *= 0.5f;
                    }
                    f3 = f6;
                    j5 = j6;
                }
            }
            c2 = c(f4);
        }
        return c2 * 1000.0f;
    }

    public void d() {
        this.f16106c = 0;
        Arrays.fill(this.f16104a, Long.MIN_VALUE);
        Arrays.fill(this.f16105b, 0.0f);
    }
}
