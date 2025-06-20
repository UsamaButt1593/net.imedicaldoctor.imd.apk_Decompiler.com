package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.OrientationListener;
import androidx.media3.exoplayer.video.spherical.TouchTracker;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@UnstableApi
public final class SphericalGLSurfaceView extends GLSurfaceView {
    private static final int i3 = 90;
    private static final float j3 = 0.1f;
    private static final float k3 = 100.0f;
    private static final float l3 = 25.0f;
    static final float m3 = 3.1415927f;
    private final SensorManager X2;
    @Nullable
    private final Sensor Y2;
    private final OrientationListener Z2;
    private final Handler a3;
    private final TouchTracker b3;
    private final SceneRenderer c3;
    @Nullable
    private SurfaceTexture d3;
    @Nullable
    private Surface e3;
    private boolean f3;
    private boolean g3;
    private boolean h3;
    private final CopyOnWriteArrayList<VideoSurfaceListener> s;

    @VisibleForTesting
    final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {
        private final float[] X = new float[16];
        private final float[] X2;
        private final float[] Y = new float[16];
        private final float[] Y2;
        private final float[] Z;
        private float Z2;
        private float a3;
        private final float[] b3;
        private final float[] c3;
        private final SceneRenderer s;

        public Renderer(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.Z = fArr;
            float[] fArr2 = new float[16];
            this.X2 = fArr2;
            float[] fArr3 = new float[16];
            this.Y2 = fArr3;
            this.b3 = new float[16];
            this.c3 = new float[16];
            this.s = sceneRenderer;
            GlUtil.Q(fArr);
            GlUtil.Q(fArr2);
            GlUtil.Q(fArr3);
            this.a3 = SphericalGLSurfaceView.m3;
        }

        private float c(float f2) {
            if (f2 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f2))) * 2.0d);
            }
            return 90.0f;
        }

        @AnyThread
        private void d() {
            Matrix.setRotateM(this.X2, 0, -this.Z2, (float) Math.cos((double) this.a3), (float) Math.sin((double) this.a3), 0.0f);
        }

        @BinderThread
        public synchronized void a(float[] fArr, float f2) {
            float[] fArr2 = this.Z;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.a3 = -f2;
            d();
        }

        @UiThread
        public synchronized void b(PointF pointF) {
            this.Z2 = pointF.y;
            d();
            Matrix.setRotateM(this.Y2, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.c3, 0, this.Z, 0, this.Y2, 0);
                Matrix.multiplyMM(this.b3, 0, this.X2, 0, this.c3, 0);
            }
            Matrix.multiplyMM(this.Y, 0, this.X, 0, this.b3, 0);
            this.s.c(this.Y, false);
        }

        @UiThread
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            Matrix.perspectiveM(this.X, 0, c(f2), f2, 0.1f, SphericalGLSurfaceView.k3);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.g(this.s.d());
        }
    }

    public interface VideoSurfaceListener {
        void F(Surface surface);

        void H(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        Surface surface = this.e3;
        if (surface != null) {
            Iterator<VideoSurfaceListener> it2 = this.s.iterator();
            while (it2.hasNext()) {
                it2.next().F(surface);
            }
        }
        h(this.d3, surface);
        this.d3 = null;
        this.e3 = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.d3;
        Surface surface = this.e3;
        Surface surface2 = new Surface(surfaceTexture);
        this.d3 = surfaceTexture;
        this.e3 = surface2;
        Iterator<VideoSurfaceListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().H(surface2);
        }
        h(surfaceTexture2, surface);
    }

    /* access modifiers changed from: private */
    public void g(SurfaceTexture surfaceTexture) {
        this.a3.post(new c(this, surfaceTexture));
    }

    private static void h(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void j() {
        boolean z = this.f3 && this.g3;
        Sensor sensor = this.Y2;
        if (sensor != null && z != this.h3) {
            if (z) {
                this.X2.registerListener(this.Z2, sensor, 0);
            } else {
                this.X2.unregisterListener(this.Z2);
            }
            this.h3 = z;
        }
    }

    public void d(VideoSurfaceListener videoSurfaceListener) {
        this.s.add(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.c3;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.c3;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.e3;
    }

    public void i(VideoSurfaceListener videoSurfaceListener) {
        this.s.remove(videoSurfaceListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a3.post(new b(this));
    }

    public void onPause() {
        this.g3 = false;
        j();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.g3 = true;
        j();
    }

    public void setDefaultStereoMode(int i2) {
        this.c3.g(i2);
    }

    public void setUseSensorRotation(boolean z) {
        this.f3 = z;
        j();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new CopyOnWriteArrayList<>();
        this.a3 = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.g(context.getSystemService("sensor"));
        this.X2 = sensorManager;
        Sensor defaultSensor = Util.f9646a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.Y2 = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.c3 = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, renderer, l3);
        this.b3 = touchTracker;
        this.Z2 = new OrientationListener(((WindowManager) Assertions.g((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker, renderer);
        this.f3 = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker);
    }
}
