package androidx.media3.common;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface VideoGraph {

    @UnstableApi
    public interface Listener {
        void d(int i2, int i3);

        void e(VideoFrameProcessingException videoFrameProcessingException);

        void f(long j2);

        void l(long j2);
    }

    void a();

    void b() throws VideoFrameProcessingException;

    void c(@Nullable SurfaceInfo surfaceInfo);

    VideoFrameProcessor e(int i2);

    boolean f();

    int g() throws VideoFrameProcessingException;
}
