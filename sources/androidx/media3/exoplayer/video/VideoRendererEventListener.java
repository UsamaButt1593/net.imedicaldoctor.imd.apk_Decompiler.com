package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

@UnstableApi
public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12814a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final VideoRendererEventListener f12815b;

        public EventDispatcher(@Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener) {
            this.f12814a = videoRendererEventListener != null ? (Handler) Assertions.g(handler) : null;
            this.f12815b = videoRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j2, long j3) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).h(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).g(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((VideoRendererEventListener) Util.o(this.f12815b)).t(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(int i2, long j2) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).l(i2, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void u(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).n(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).k(format);
            ((VideoRendererEventListener) Util.o(this.f12815b)).r(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j2) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).o(obj, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(long j2, int i2) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).C(j2, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).y(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.o(this.f12815b)).c(videoSize);
        }

        public void A(Object obj) {
            if (this.f12814a != null) {
                this.f12814a.post(new r(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        public void B(long j2, int i2) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new s(this, j2, i2));
            }
        }

        public void C(Exception exc) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new t(this, exc));
            }
        }

        public void D(VideoSize videoSize) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new p(this, videoSize));
            }
        }

        public void k(String str, long j2, long j3) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new o(this, str, j2, j3));
            }
        }

        public void l(String str) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new x(this, str));
            }
        }

        public void m(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new w(this, decoderCounters));
            }
        }

        public void n(int i2, long j2) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new q(this, i2, j2));
            }
        }

        public void o(DecoderCounters decoderCounters) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new u(this, decoderCounters));
            }
        }

        public void p(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f12814a;
            if (handler != null) {
                handler.post(new v(this, format, decoderReuseEvaluation));
            }
        }
    }

    void C(long j2, int i2);

    void c(VideoSize videoSize);

    void g(String str);

    void h(String str, long j2, long j3);

    @Deprecated
    void k(Format format);

    void l(int i2, long j2);

    void n(DecoderCounters decoderCounters);

    void o(Object obj, long j2);

    void r(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void t(DecoderCounters decoderCounters);

    void y(Exception exc);
}
