package androidx.media3.exoplayer.source.preload;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.WrappingMediaSource;
import androidx.media3.exoplayer.source.p;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class PreloadMediaSource extends WrappingMediaSource {
    private static final String r3 = "PreloadMediaSource";
    /* access modifiers changed from: private */
    public final PreloadControl f3;
    /* access modifiers changed from: private */
    public final TrackSelector g3;
    private final BandwidthMeter h3;
    /* access modifiers changed from: private */
    public final RendererCapabilities[] i3;
    private final Allocator j3;
    private final Handler k3;
    private boolean l3;
    private boolean m3;
    private long n3;
    /* access modifiers changed from: private */
    @Nullable
    public Timeline o3;
    /* access modifiers changed from: private */
    @Nullable
    public Pair<PreloadMediaPeriod, MediaPeriodKey> p3;
    @Nullable
    private Pair<PreloadMediaPeriod, MediaSource.MediaPeriodId> q3;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: c  reason: collision with root package name */
        private final MediaSource.Factory f12333c;

        /* renamed from: d  reason: collision with root package name */
        private final Looper f12334d;

        /* renamed from: e  reason: collision with root package name */
        private final Allocator f12335e;

        /* renamed from: f  reason: collision with root package name */
        private final TrackSelector f12336f;

        /* renamed from: g  reason: collision with root package name */
        private final BandwidthMeter f12337g;

        /* renamed from: h  reason: collision with root package name */
        private final RendererCapabilities[] f12338h;

        /* renamed from: i  reason: collision with root package name */
        private final PreloadControl f12339i;

        public Factory(MediaSource.Factory factory, PreloadControl preloadControl, TrackSelector trackSelector, BandwidthMeter bandwidthMeter, RendererCapabilities[] rendererCapabilitiesArr, Allocator allocator, Looper looper) {
            this.f12333c = factory;
            this.f12339i = preloadControl;
            this.f12336f = trackSelector;
            this.f12337g = bandwidthMeter;
            this.f12338h = (RendererCapabilities[]) Arrays.copyOf(rendererCapabilitiesArr, rendererCapabilitiesArr.length);
            this.f12335e = allocator;
            this.f12334d = looper;
        }

        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return p.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z) {
            return p.a(this, z);
        }

        public int[] f() {
            return this.f12333c.f();
        }

        /* renamed from: h */
        public PreloadMediaSource c(MediaItem mediaItem) {
            return new PreloadMediaSource(this.f12333c.c(mediaItem), this.f12339i, this.f12336f, this.f12337g, this.f12338h, this.f12335e, this.f12334d);
        }

        public PreloadMediaSource i(MediaSource mediaSource) {
            return new PreloadMediaSource(mediaSource, this.f12339i, this.f12336f, this.f12337g, this.f12338h, this.f12335e, this.f12334d);
        }

        /* renamed from: j */
        public Factory g(CmcdConfiguration.Factory factory) {
            this.f12333c.g(factory);
            return this;
        }

        /* renamed from: k */
        public Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f12333c.e(drmSessionManagerProvider);
            return this;
        }

        /* renamed from: l */
        public Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f12333c.d(loadErrorHandlingPolicy);
            return this;
        }
    }

    private static class MediaPeriodKey {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f12340a;

        /* renamed from: b  reason: collision with root package name */
        private final Long f12341b;

        public MediaPeriodKey(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            this.f12340a = mediaPeriodId;
            this.f12341b = Long.valueOf(j2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodKey)) {
                return false;
            }
            MediaPeriodKey mediaPeriodKey = (MediaPeriodKey) obj;
            return PreloadMediaSource.i1(this.f12340a, mediaPeriodKey.f12340a) && this.f12341b.equals(mediaPeriodKey.f12341b);
        }

        public int hashCode() {
            MediaSource.MediaPeriodId mediaPeriodId = this.f12340a;
            return ((((((((MetaDo.w + this.f12340a.f12163a.hashCode()) * 31) + mediaPeriodId.f12164b) * 31) + mediaPeriodId.f12165c) * 31) + mediaPeriodId.f12167e) * 31) + this.f12341b.intValue();
        }
    }

    public interface PreloadControl {
        boolean a(PreloadMediaSource preloadMediaSource);

        boolean b(PreloadMediaSource preloadMediaSource);

        boolean c(PreloadMediaSource preloadMediaSource, long j2);
    }

    private class PreloadMediaPeriodCallback implements MediaPeriod.Callback {
        private boolean X;
        private final long s;

        public PreloadMediaPeriodCallback(long j2) {
            this.s = j2;
        }

        /* renamed from: a */
        public void j(MediaPeriod mediaPeriod) {
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
            if (!this.X || PreloadMediaSource.this.f3.c(PreloadMediaSource.this, preloadMediaPeriod.g())) {
                preloadMediaPeriod.a(new LoadingInfo.Builder().f(this.s).d());
            }
        }

        public void i(MediaPeriod mediaPeriod) {
            TrackSelectorResult trackSelectorResult;
            this.X = true;
            PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
            try {
                trackSelectorResult = PreloadMediaSource.this.g3.k(PreloadMediaSource.this.i3, preloadMediaPeriod.s(), ((MediaPeriodKey) ((Pair) Assertions.g(PreloadMediaSource.this.p3)).second).f12340a, (Timeline) Assertions.g(PreloadMediaSource.this.o3));
            } catch (ExoPlaybackException e2) {
                Log.e(PreloadMediaSource.r3, "Failed to select tracks", e2);
                trackSelectorResult = null;
            }
            if (trackSelectorResult != null) {
                preloadMediaPeriod.u(trackSelectorResult.f12418c, this.s);
                if (PreloadMediaSource.this.f3.b(PreloadMediaSource.this)) {
                    preloadMediaPeriod.a(new LoadingInfo.Builder().f(this.s).d());
                }
            }
        }
    }

    private PreloadMediaSource(MediaSource mediaSource, PreloadControl preloadControl, TrackSelector trackSelector, BandwidthMeter bandwidthMeter, RendererCapabilities[] rendererCapabilitiesArr, Allocator allocator, Looper looper) {
        super(mediaSource);
        this.f3 = preloadControl;
        this.g3 = trackSelector;
        this.h3 = bandwidthMeter;
        this.i3 = rendererCapabilitiesArr;
        this.j3 = allocator;
        this.k3 = Util.G(looper, (Handler.Callback) null);
        this.n3 = C.f9084b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(long j2) {
        this.l3 = true;
        this.n3 = j2;
        if (!f1()) {
            y0(PlayerId.f10613b);
            s0(this.h3.f());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1() {
        this.l3 = false;
        this.n3 = C.f9084b;
        Pair<PreloadMediaPeriod, MediaPeriodKey> pair = this.p3;
        if (pair != null) {
            this.d3.X(((PreloadMediaPeriod) pair.first).s);
            this.p3 = null;
        }
        u0();
        this.k3.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    public static boolean i1(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.f12163a.equals(mediaPeriodId2.f12163a) && mediaPeriodId.f12164b == mediaPeriodId2.f12164b && mediaPeriodId.f12165c == mediaPeriodId2.f12165c && mediaPeriodId.f12167e == mediaPeriodId2.f12167e;
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId L0(MediaSource.MediaPeriodId mediaPeriodId) {
        Pair<PreloadMediaPeriod, MediaSource.MediaPeriodId> pair = this.q3;
        return (pair == null || !i1(mediaPeriodId, (MediaSource.MediaPeriodId) ((Pair) Assertions.g(pair)).second)) ? mediaPeriodId : (MediaSource.MediaPeriodId) ((Pair) Assertions.g(this.q3)).second;
    }

    /* access modifiers changed from: protected */
    public void R0(Timeline timeline) {
        this.o3 = timeline;
        t0(timeline);
        if (!f1() && this.f3.a(this)) {
            Pair<Object, Long> q = timeline.q(new Timeline.Window(), new Timeline.Period(), 0, this.n3);
            E(new MediaSource.MediaPeriodId(q.first), this.j3, ((Long) q.second).longValue()).o(new PreloadMediaPeriodCallback(((Long) q.second).longValue()), ((Long) q.second).longValue());
        }
    }

    /* access modifiers changed from: protected */
    public void U0() {
        Timeline timeline = this.o3;
        if (timeline != null) {
            R0(timeline);
        } else if (!this.m3) {
            this.m3 = true;
            T0();
        }
    }

    public void X(MediaPeriod mediaPeriod) {
        PreloadMediaPeriod preloadMediaPeriod = (PreloadMediaPeriod) mediaPeriod;
        Pair<PreloadMediaPeriod, MediaPeriodKey> pair = this.p3;
        if (pair == null || preloadMediaPeriod != ((Pair) Assertions.g(pair)).first) {
            Pair<PreloadMediaPeriod, MediaSource.MediaPeriodId> pair2 = this.q3;
            if (pair2 != null && preloadMediaPeriod == ((Pair) Assertions.g(pair2)).first) {
                this.q3 = null;
            }
        } else {
            this.p3 = null;
        }
        this.d3.X(preloadMediaPeriod.s);
    }

    /* renamed from: e1 */
    public PreloadMediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaPeriodKey mediaPeriodKey = new MediaPeriodKey(mediaPeriodId, j2);
        Pair<PreloadMediaPeriod, MediaPeriodKey> pair = this.p3;
        if (pair == null || !mediaPeriodKey.equals(pair.second)) {
            Pair<PreloadMediaPeriod, MediaPeriodKey> pair2 = this.p3;
            if (pair2 != null) {
                this.d3.X(((PreloadMediaPeriod) ((Pair) Assertions.g(pair2)).first).s);
                this.p3 = null;
            }
            PreloadMediaPeriod preloadMediaPeriod = new PreloadMediaPeriod(this.d3.E(mediaPeriodId, allocator, j2));
            if (!f1()) {
                this.p3 = new Pair<>(preloadMediaPeriod, mediaPeriodKey);
            }
            return preloadMediaPeriod;
        }
        PreloadMediaPeriod preloadMediaPeriod2 = (PreloadMediaPeriod) ((Pair) Assertions.g(this.p3)).first;
        if (f1()) {
            this.p3 = null;
            this.q3 = new Pair<>(preloadMediaPeriod2, mediaPeriodId);
        }
        return preloadMediaPeriod2;
    }

    /* access modifiers changed from: package-private */
    public boolean f1() {
        return p0();
    }

    public void j1(long j2) {
        this.k3.post(new b(this, j2));
    }

    public void k1() {
        this.k3.post(new a(this));
    }

    /* access modifiers changed from: protected */
    public void u0() {
        if (!this.l3 && !f1()) {
            this.o3 = null;
            this.m3 = false;
            super.u0();
        }
    }
}
