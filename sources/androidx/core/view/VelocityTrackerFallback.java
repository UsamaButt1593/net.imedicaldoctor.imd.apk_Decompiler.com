package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

class VelocityTrackerFallback {

    /* renamed from: f  reason: collision with root package name */
    private static final long f6481f = 100;

    /* renamed from: g  reason: collision with root package name */
    private static final int f6482g = 20;

    /* renamed from: h  reason: collision with root package name */
    private static final long f6483h = 40;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f6484a = new float[20];

    /* renamed from: b  reason: collision with root package name */
    private final long[] f6485b = new long[20];

    /* renamed from: c  reason: collision with root package name */
    private float f6486c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f6487d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f6488e = 0;

    VelocityTrackerFallback() {
    }

    private void b() {
        this.f6487d = 0;
        this.f6486c = 0.0f;
    }

    private float f() {
        long[] jArr;
        long j2;
        int i2 = this.f6487d;
        if (i2 < 2) {
            return 0.0f;
        }
        int i3 = this.f6488e;
        int i4 = ((i3 + 20) - (i2 - 1)) % 20;
        long j3 = this.f6485b[i3];
        while (true) {
            jArr = this.f6485b;
            j2 = jArr[i4];
            if (j3 - j2 <= f6481f) {
                break;
            }
            this.f6487d--;
            i4 = (i4 + 1) % 20;
        }
        int i5 = this.f6487d;
        if (i5 < 2) {
            return 0.0f;
        }
        if (i5 == 2) {
            int i6 = (i4 + 1) % 20;
            long j4 = jArr[i6];
            if (j2 == j4) {
                return 0.0f;
            }
            return this.f6484a[i6] / ((float) (j4 - j2));
        }
        int i7 = 0;
        float f2 = 0.0f;
        for (int i8 = 0; i8 < this.f6487d - 1; i8++) {
            int i9 = i8 + i4;
            long[] jArr2 = this.f6485b;
            long j5 = jArr2[i9 % 20];
            int i10 = (i9 + 1) % 20;
            if (jArr2[i10] != j5) {
                i7++;
                float g2 = g(f2);
                float f3 = this.f6484a[i10] / ((float) (this.f6485b[i10] - j5));
                f2 += (f3 - g2) * Math.abs(f3);
                if (i7 == 1) {
                    f2 *= 0.5f;
                }
            }
        }
        return g(f2);
    }

    private static float g(float f2) {
        return (f2 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt((double) (Math.abs(f2) * 2.0f)));
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f6487d != 0 && eventTime - this.f6485b[this.f6488e] > f6483h) {
            b();
        }
        int i2 = (this.f6488e + 1) % 20;
        this.f6488e = i2;
        int i3 = this.f6487d;
        if (i3 != 20) {
            this.f6487d = i3 + 1;
        }
        this.f6484a[i2] = motionEvent.getAxisValue(26);
        this.f6485b[this.f6488e] = eventTime;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        d(i2, Float.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, float f2) {
        float abs;
        float f3 = f() * ((float) i2);
        this.f6486c = f3;
        if (f3 < (-Math.abs(f2))) {
            abs = -Math.abs(f2);
        } else if (this.f6486c > Math.abs(f2)) {
            abs = Math.abs(f2);
        } else {
            return;
        }
        this.f6486c = abs;
    }

    /* access modifiers changed from: package-private */
    public float e(int i2) {
        if (i2 != 26) {
            return 0.0f;
        }
        return this.f6486c;
    }
}
