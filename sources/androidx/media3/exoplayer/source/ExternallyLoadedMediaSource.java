package androidx.media3.exoplayer.source;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Objects;

@UnstableApi
public final class ExternallyLoadedMediaSource extends BaseMediaSource {
    private final ExternalLoader a3;
    private final long b3;
    @GuardedBy("this")
    private MediaItem c3;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: c  reason: collision with root package name */
        private final long f12134c;

        /* renamed from: d  reason: collision with root package name */
        private final ExternalLoader f12135d;

        public Factory(long j2, ExternalLoader externalLoader) {
            this.f12134c = j2;
            this.f12135d = externalLoader;
        }

        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return p.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z) {
            return p.a(this, z);
        }

        public MediaSource.Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public MediaSource.Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public int[] f() {
            return new int[]{4};
        }

        public /* synthetic */ MediaSource.Factory g(CmcdConfiguration.Factory factory) {
            return p.b(this, factory);
        }

        /* renamed from: h */
        public ExternallyLoadedMediaSource c(MediaItem mediaItem) {
            return new ExternallyLoadedMediaSource(mediaItem, this.f12134c, this.f12135d);
        }
    }

    private ExternallyLoadedMediaSource(MediaItem mediaItem, long j2, ExternalLoader externalLoader) {
        this.c3 = mediaItem;
        this.b3 = j2;
        this.a3 = externalLoader;
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaItem H = H();
        Assertions.g(H.X);
        Assertions.h(H.X.X, "Externally loaded mediaItems require a MIME type.");
        MediaItem.LocalConfiguration localConfiguration = H.X;
        return new ExternallyLoadedMediaPeriod(localConfiguration.s, localConfiguration.X, this.a3);
    }

    public synchronized MediaItem H() {
        return this.c3;
    }

    public void I() {
    }

    public boolean S(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        MediaItem.LocalConfiguration localConfiguration2 = (MediaItem.LocalConfiguration) Assertions.g(H().X);
        if (localConfiguration != null && localConfiguration.s.equals(localConfiguration2.s) && Objects.equals(localConfiguration.X, localConfiguration2.X)) {
            long j2 = localConfiguration.c3;
            if (j2 == C.f9084b || Util.I1(j2) == this.b3) {
                return true;
            }
        }
        return false;
    }

    public void X(MediaPeriod mediaPeriod) {
        ((ExternallyLoadedMediaPeriod) mediaPeriod).o();
    }

    public synchronized void k(MediaItem mediaItem) {
        this.c3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        t0(new SinglePeriodTimeline(this.b3, true, false, false, (Object) null, H()));
    }

    /* access modifiers changed from: protected */
    public void u0() {
    }
}
