package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import androidx.media3.extractor.ts.TsExtractor;

final class OrientationListener implements SensorEventListener {
    private final float[] X = new float[16];
    private final Display X2;
    private final float[] Y = new float[16];
    private final Listener[] Y2;
    private final float[] Z = new float[3];
    private boolean Z2;
    private final float[] s = new float[16];

    public interface Listener {
        void a(float[] fArr, float f2);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.X2 = display;
        this.Y2 = listenerArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.X);
        SensorManager.getOrientation(this.X, this.Z);
        return this.Z[2];
    }

    private void b(float[] fArr, float f2) {
        for (Listener a2 : this.Y2) {
            a2.a(fArr, f2);
        }
    }

    private void c(float[] fArr) {
        if (!this.Z2) {
            FrameRotationQueue.a(this.Y, fArr);
            this.Z2 = true;
        }
        float[] fArr2 = this.X;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.X, 0, this.Y, 0);
    }

    private void d(float[] fArr, int i2) {
        if (i2 != 0) {
            int i3 = TsExtractor.J;
            int i4 = 1;
            if (i2 == 1) {
                i3 = 2;
                i4 = TsExtractor.J;
            } else if (i2 == 2) {
                i4 = TsExtractor.L;
            } else if (i2 == 3) {
                i3 = TsExtractor.L;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.X;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.X, i3, i4, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.s, sensorEvent.values);
        d(this.s, this.X2.getRotation());
        float a2 = a(this.s);
        e(this.s);
        c(this.s);
        b(this.s, a2);
    }
}
