package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ SurfaceTexture X;
    public final /* synthetic */ SphericalGLSurfaceView s;

    public /* synthetic */ c(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.s = sphericalGLSurfaceView;
        this.X = surfaceTexture;
    }

    public final void run() {
        this.s.f(this.X);
    }
}
