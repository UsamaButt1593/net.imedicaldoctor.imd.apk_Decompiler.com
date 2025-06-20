package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

@UnstableApi
public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void B(DecoderCounters decoderCounters);

    void C(long j2, int i2);

    void G(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void J(AnalyticsListener analyticsListener);

    void T();

    void a();

    void b(AudioSink.AudioTrackConfig audioTrackConfig);

    void d(AudioSink.AudioTrackConfig audioTrackConfig);

    void f(Exception exc);

    void g(String str);

    void h(String str, long j2, long j3);

    void i(String str);

    void i0(AnalyticsListener analyticsListener);

    void j(String str, long j2, long j3);

    void l(int i2, long j2);

    void m(DecoderCounters decoderCounters);

    void n(DecoderCounters decoderCounters);

    void n0(Player player, Looper looper);

    void o(Object obj, long j2);

    void r(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void t(DecoderCounters decoderCounters);

    void u(long j2);

    void v(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void w(Exception exc);

    void y(Exception exc);

    void z(int i2, long j2, long j3);
}
