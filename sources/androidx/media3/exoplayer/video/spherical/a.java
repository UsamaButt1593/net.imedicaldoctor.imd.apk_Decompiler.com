package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ SceneRenderer s;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.s = sceneRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.s.e(surfaceTexture);
    }
}
