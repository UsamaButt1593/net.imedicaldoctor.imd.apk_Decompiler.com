package androidx.media3.exoplayer.video.spherical;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.TimedValueQueue;

final class FrameRotationQueue {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f12820a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f12821b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final TimedValueQueue<float[]> f12822c = new TimedValueQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f12823d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.Q(fArr);
        float f2 = fArr2[10];
        float f3 = fArr2[8];
        float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        float f4 = fArr2[10];
        fArr[0] = f4 / sqrt;
        float f5 = fArr2[8];
        fArr[2] = f5 / sqrt;
        fArr[8] = (-f5) / sqrt;
        fArr[10] = f4 / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f2 = fArr2[0];
        float f3 = -fArr2[1];
        float f4 = -fArr2[2];
        float length = Matrix.length(f2, f3, f4);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees((double) length), f2 / length, f3 / length, f4 / length);
            return;
        }
        GlUtil.Q(fArr);
    }

    public boolean c(float[] fArr, long j2) {
        float[] j3 = this.f12822c.j(j2);
        if (j3 == null) {
            return false;
        }
        b(this.f12821b, j3);
        if (!this.f12823d) {
            a(this.f12820a, this.f12821b);
            this.f12823d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f12820a, 0, this.f12821b, 0);
        return true;
    }

    public void d() {
        this.f12822c.c();
        this.f12823d = false;
    }

    public void e(long j2, float[] fArr) {
        this.f12822c.a(j2, fArr);
    }
}
