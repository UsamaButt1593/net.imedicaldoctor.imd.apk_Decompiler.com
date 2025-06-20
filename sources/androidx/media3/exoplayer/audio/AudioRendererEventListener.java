package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;

@UnstableApi
public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10777a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final AudioRendererEventListener f10778b;

        public EventDispatcher(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
            this.f10777a = audioRendererEventListener != null ? (Handler) Assertions.g(handler) : null;
            this.f10778b = audioRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(String str) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).i(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void B(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((AudioRendererEventListener) Util.o(this.f10778b)).B(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void C(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).m(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void D(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).a(format);
            ((AudioRendererEventListener) Util.o(this.f10778b)).v(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void E(long j2) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).u(j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void F(boolean z) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).e(z);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void G(int i2, long j2, long j3) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).z(i2, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Exception exc) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).w(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Exception exc) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).f(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).b(audioTrackConfig);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).d(audioTrackConfig);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(String str, long j2, long j3) {
            ((AudioRendererEventListener) Util.o(this.f10778b)).j(str, j2, j3);
        }

        public void H(long j2) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0268m(this, j2));
            }
        }

        public void I(boolean z) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0274t(this, z));
            }
        }

        public void J(int i2, long j2, long j3) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0269n(this, i2, j2, j3));
            }
        }

        public void m(Exception exc) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0272q(this, exc));
            }
        }

        public void n(Exception exc) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new r(this, exc));
            }
        }

        public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0270o(this, audioTrackConfig));
            }
        }

        public void p(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0271p(this, audioTrackConfig));
            }
        }

        public void q(String str, long j2, long j3) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0275u(this, str, j2, j3));
            }
        }

        public void r(String str) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0276v(this, str));
            }
        }

        public void s(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0267l(this, decoderCounters));
            }
        }

        public void t(DecoderCounters decoderCounters) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0266k(this, decoderCounters));
            }
        }

        public void u(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f10777a;
            if (handler != null) {
                handler.post(new C0273s(this, format, decoderReuseEvaluation));
            }
        }
    }

    void B(DecoderCounters decoderCounters);

    @Deprecated
    void a(Format format);

    void b(AudioSink.AudioTrackConfig audioTrackConfig);

    void d(AudioSink.AudioTrackConfig audioTrackConfig);

    void e(boolean z);

    void f(Exception exc);

    void i(String str);

    void j(String str, long j2, long j3);

    void m(DecoderCounters decoderCounters);

    void u(long j2);

    void v(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void w(Exception exc);

    void z(int i2, long j2, long j3);
}
