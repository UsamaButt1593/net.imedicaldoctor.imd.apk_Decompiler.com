package androidx.media3.exoplayer.video;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;

final class VideoFrameRenderControl {

    /* renamed from: a  reason: collision with root package name */
    private final FrameRenderer f12804a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoFrameReleaseControl f12805b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoFrameReleaseControl.FrameReleaseInfo f12806c = new VideoFrameReleaseControl.FrameReleaseInfo();

    /* renamed from: d  reason: collision with root package name */
    private final TimedValueQueue<VideoSize> f12807d = new TimedValueQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final TimedValueQueue<Long> f12808e = new TimedValueQueue<>();

    /* renamed from: f  reason: collision with root package name */
    private final LongArrayQueue f12809f = new LongArrayQueue();
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private VideoSize f12810g;

    /* renamed from: h  reason: collision with root package name */
    private VideoSize f12811h = VideoSize.b3;

    /* renamed from: i  reason: collision with root package name */
    private long f12812i;

    /* renamed from: j  reason: collision with root package name */
    private long f12813j = C.f9084b;

    interface FrameRenderer {
        void c(VideoSize videoSize);

        void g(long j2, long j3, long j4, boolean z);

        void k();
    }

    public VideoFrameRenderControl(FrameRenderer frameRenderer, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.f12804a = frameRenderer;
        this.f12805b = videoFrameReleaseControl;
    }

    private void a() {
        Assertions.k(Long.valueOf(this.f12809f.g()));
        this.f12804a.k();
    }

    private static <T> T c(TimedValueQueue<T> timedValueQueue) {
        Assertions.a(timedValueQueue.l() > 0);
        while (timedValueQueue.l() > 1) {
            timedValueQueue.i();
        }
        return Assertions.g(timedValueQueue.i());
    }

    private boolean f(long j2) {
        Long j3 = this.f12808e.j(j2);
        if (j3 == null || j3.longValue() == this.f12812i) {
            return false;
        }
        this.f12812i = j3.longValue();
        return true;
    }

    private boolean g(long j2) {
        VideoSize j3 = this.f12807d.j(j2);
        if (j3 == null || j3.equals(VideoSize.b3) || j3.equals(this.f12811h)) {
            return false;
        }
        this.f12811h = j3;
        return true;
    }

    private void l(boolean z) {
        long longValue = ((Long) Assertions.k(Long.valueOf(this.f12809f.g()))).longValue();
        if (g(longValue)) {
            this.f12804a.c(this.f12811h);
        }
        this.f12804a.g(z ? -1 : this.f12806c.g(), longValue, this.f12812i, this.f12805b.i());
    }

    public void b() {
        this.f12809f.c();
        this.f12813j = C.f9084b;
        if (this.f12808e.l() > 0) {
            Long l2 = (Long) c(this.f12808e);
            l2.longValue();
            this.f12808e.a(0, l2);
        }
        if (this.f12810g != null) {
            this.f12807d.c();
        } else if (this.f12807d.l() > 0) {
            this.f12810g = (VideoSize) c(this.f12807d);
        }
    }

    public boolean d(long j2) {
        long j3 = this.f12813j;
        return j3 != C.f9084b && j3 >= j2;
    }

    public boolean e() {
        return this.f12805b.d(true);
    }

    public void h(long j2) {
        VideoSize videoSize = this.f12810g;
        if (videoSize != null) {
            this.f12807d.a(j2, videoSize);
            this.f12810g = null;
        }
        this.f12809f.a(j2);
    }

    public void i(int i2, int i3) {
        VideoSize videoSize = new VideoSize(i2, i3);
        if (!Util.g(this.f12810g, videoSize)) {
            this.f12810g = videoSize;
        }
    }

    public void j(long j2, long j3) {
        this.f12808e.a(j2, Long.valueOf(j3));
    }

    public void k(long j2, long j3) throws ExoPlaybackException {
        while (!this.f12809f.f()) {
            long e2 = this.f12809f.e();
            if (f(e2)) {
                this.f12805b.j();
            }
            int c2 = this.f12805b.c(e2, j2, j3, this.f12812i, false, this.f12806c);
            boolean z = true;
            if (c2 == 0 || c2 == 1) {
                this.f12813j = e2;
                if (c2 != 0) {
                    z = false;
                }
                l(z);
            } else if (c2 == 2 || c2 == 3 || c2 == 4) {
                this.f12813j = e2;
                a();
            } else if (c2 != 5) {
                throw new IllegalStateException(String.valueOf(c2));
            } else {
                return;
            }
        }
    }

    public void m(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        Assertions.a(f2 > 0.0f);
        this.f12805b.r(f2);
    }
}
