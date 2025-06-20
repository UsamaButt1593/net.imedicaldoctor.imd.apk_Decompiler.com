package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: c  reason: collision with root package name */
    private static final float f6697c = 0.002f;

    /* renamed from: a  reason: collision with root package name */
    private final float[] f6698a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f6699b;

    PathInterpolatorApi14(float f2, float f3) {
        this(b(f2, f3));
    }

    private static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    private static Path b(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f6698a.length - 1;
        int i2 = 0;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f2 < this.f6698a[i3]) {
                length = i3;
            } else {
                i2 = i3;
            }
        }
        float[] fArr = this.f6698a;
        float f3 = fArr[length];
        float f4 = fArr[i2];
        float f5 = f3 - f4;
        if (f5 == 0.0f) {
            return this.f6699b[i2];
        }
        float[] fArr2 = this.f6699b;
        float f6 = fArr2[i2];
        return f6 + (((f2 - f4) / f5) * (fArr2[length] - f6));
    }

    PathInterpolatorApi14(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i2 = (int) (length / 0.002f);
        int i3 = i2 + 1;
        this.f6698a = new float[i3];
        this.f6699b = new float[i3];
        float[] fArr = new float[2];
        for (int i4 = 0; i4 < i3; i4++) {
            pathMeasure.getPosTan((((float) i4) * length) / ((float) i2), fArr, (float[]) null);
            this.f6698a[i4] = fArr[0];
            this.f6699b[i4] = fArr[1];
        }
    }
}
