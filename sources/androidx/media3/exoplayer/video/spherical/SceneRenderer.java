package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {
    private static final String g3 = "SceneRenderer";
    private final AtomicBoolean X = new AtomicBoolean(true);
    private final TimedValueQueue<Long> X2 = new TimedValueQueue<>();
    private final ProjectionRenderer Y = new ProjectionRenderer();
    private final TimedValueQueue<Projection> Y2 = new TimedValueQueue<>();
    private final FrameRotationQueue Z = new FrameRotationQueue();
    private final float[] Z2 = new float[16];
    private final float[] a3 = new float[16];
    private int b3;
    private SurfaceTexture c3;
    private volatile int d3 = 0;
    private int e3 = -1;
    @Nullable
    private byte[] f3;
    private final AtomicBoolean s = new AtomicBoolean();

    /* access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        this.s.set(true);
    }

    private void h(@Nullable byte[] bArr, int i2, long j2) {
        byte[] bArr2 = this.f3;
        int i3 = this.e3;
        this.f3 = bArr;
        if (i2 == -1) {
            i2 = this.d3;
        }
        this.e3 = i2;
        if (i3 != i2 || !Arrays.equals(bArr2, this.f3)) {
            byte[] bArr3 = this.f3;
            Projection a2 = bArr3 != null ? ProjectionDecoder.a(bArr3, this.e3) : null;
            if (a2 == null || !ProjectionRenderer.c(a2)) {
                a2 = Projection.b(this.e3);
            }
            this.Y2.a(j2, a2);
        }
    }

    public void b(long j2, float[] fArr) {
        this.Z.e(j2, fArr);
    }

    public void c(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        try {
            GlUtil.d();
        } catch (GlUtil.GlException e2) {
            Log.e(g3, "Failed to draw a frame", e2);
        }
        if (this.s.compareAndSet(true, false)) {
            ((SurfaceTexture) Assertions.g(this.c3)).updateTexImage();
            try {
                GlUtil.d();
            } catch (GlUtil.GlException e4) {
                Log.e(g3, "Failed to draw a frame", e4);
            }
            if (this.X.compareAndSet(true, false)) {
                GlUtil.Q(this.Z2);
            }
            long timestamp = this.c3.getTimestamp();
            Long g2 = this.X2.g(timestamp);
            if (g2 != null) {
                this.Z.c(this.Z2, g2.longValue());
            }
            Projection j2 = this.Y2.j(timestamp);
            if (j2 != null) {
                this.Y.d(j2);
            }
        }
        Matrix.multiplyMM(this.a3, 0, fArr, 0, this.Z2, 0);
        this.Y.a(this.b3, this.a3, z);
    }

    public SurfaceTexture d() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.d();
            this.Y.b();
            GlUtil.d();
            this.b3 = GlUtil.m();
        } catch (GlUtil.GlException e2) {
            Log.e(g3, "Failed to initialize the renderer", e2);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.b3);
        this.c3 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new a(this));
        return this.c3;
    }

    public void f() {
        this.X2.c();
        this.Z.d();
        this.X.set(true);
    }

    public void g(int i2) {
        this.d3 = i2;
    }

    public void i() {
        this.Y.e();
    }

    public void j(long j2, long j3, Format format, @Nullable MediaFormat mediaFormat) {
        this.X2.a(j3, Long.valueOf(j2));
        h(format.p3, format.q3, j3);
    }
}
