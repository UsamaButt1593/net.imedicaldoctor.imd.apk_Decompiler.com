package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    public static final int l3 = 1048576;
    private final DataSource.Factory a3;
    private final ProgressiveMediaExtractor.Factory b3;
    private final DrmSessionManager c3;
    private final LoadErrorHandlingPolicy d3;
    private final int e3;
    private boolean f3;
    private long g3;
    private boolean h3;
    private boolean i3;
    @Nullable
    private TransferListener j3;
    @GuardedBy("this")
    private MediaItem k3;

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: c  reason: collision with root package name */
        private final DataSource.Factory f12197c;

        /* renamed from: d  reason: collision with root package name */
        private ProgressiveMediaExtractor.Factory f12198d;

        /* renamed from: e  reason: collision with root package name */
        private DrmSessionManagerProvider f12199e;

        /* renamed from: f  reason: collision with root package name */
        private LoadErrorHandlingPolicy f12200f;

        /* renamed from: g  reason: collision with root package name */
        private int f12201g;

        public Factory(DataSource.Factory factory) {
            this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ProgressiveMediaExtractor j(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return p.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z) {
            return p.a(this, z);
        }

        public int[] f() {
            return new int[]{4};
        }

        public /* synthetic */ MediaSource.Factory g(CmcdConfiguration.Factory factory) {
            return p.b(this, factory);
        }

        /* renamed from: i */
        public ProgressiveMediaSource c(MediaItem mediaItem) {
            Assertions.g(mediaItem.X);
            return new ProgressiveMediaSource(mediaItem, this.f12197c, this.f12198d, this.f12199e.a(mediaItem), this.f12200f, this.f12201g);
        }

        @CanIgnoreReturnValue
        public Factory k(int i2) {
            this.f12201g = i2;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f12199e = (DrmSessionManagerProvider) Assertions.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f12200f = (LoadErrorHandlingPolicy) Assertions.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
            this.f12197c = factory;
            this.f12198d = factory2;
            this.f12199e = drmSessionManagerProvider;
            this.f12200f = loadErrorHandlingPolicy;
            this.f12201g = i2;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this(factory, (ProgressiveMediaExtractor.Factory) new C(extractorsFactory));
        }
    }

    private ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
        this.k3 = mediaItem;
        this.a3 = factory;
        this.b3 = factory2;
        this.c3 = drmSessionManager;
        this.d3 = loadErrorHandlingPolicy;
        this.e3 = i2;
        this.f3 = true;
        this.g3 = C.f9084b;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [androidx.media3.exoplayer.source.ProgressiveMediaSource$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0() {
        /*
            r9 = this;
            androidx.media3.exoplayer.source.SinglePeriodTimeline r8 = new androidx.media3.exoplayer.source.SinglePeriodTimeline
            long r1 = r9.g3
            boolean r3 = r9.h3
            boolean r5 = r9.i3
            r6 = 0
            androidx.media3.common.MediaItem r7 = r9.H()
            r4 = 0
            r0 = r8
            r0.<init>((long) r1, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.Object) r6, (androidx.media3.common.MediaItem) r7)
            boolean r0 = r9.f3
            if (r0 == 0) goto L_0x001c
            androidx.media3.exoplayer.source.ProgressiveMediaSource$1 r0 = new androidx.media3.exoplayer.source.ProgressiveMediaSource$1
            r0.<init>(r8)
            r8 = r0
        L_0x001c:
            r9.t0(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ProgressiveMediaSource.A0():void");
    }

    private MediaItem.LocalConfiguration z0() {
        return (MediaItem.LocalConfiguration) Assertions.g(H().X);
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        DataSource a2 = this.a3.a();
        TransferListener transferListener = this.j3;
        if (transferListener != null) {
            a2.e(transferListener);
        }
        MediaItem.LocalConfiguration z0 = z0();
        return new ProgressiveMediaPeriod(z0.s, a2, this.b3.a(k0()), this.c3, b0(mediaPeriodId), this.d3, f0(mediaPeriodId), this, allocator, z0.Y2, this.e3, Util.I1(z0.c3));
    }

    public void F(long j2, boolean z, boolean z2) {
        if (j2 == C.f9084b) {
            j2 = this.g3;
        }
        if (this.f3 || this.g3 != j2 || this.h3 != z || this.i3 != z2) {
            this.g3 = j2;
            this.h3 = z;
            this.i3 = z2;
            this.f3 = false;
            A0();
        }
    }

    public synchronized MediaItem H() {
        return this.k3;
    }

    public void I() {
    }

    public boolean S(MediaItem mediaItem) {
        MediaItem.LocalConfiguration z0 = z0();
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        return localConfiguration != null && localConfiguration.s.equals(z0.s) && localConfiguration.c3 == z0.c3 && Util.g(localConfiguration.Y2, z0.Y2);
    }

    public void X(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).h0();
    }

    public synchronized void k(MediaItem mediaItem) {
        this.k3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        this.j3 = transferListener;
        this.c3.b((Looper) Assertions.g(Looper.myLooper()), k0());
        this.c3.k();
        A0();
    }

    /* access modifiers changed from: protected */
    public void u0() {
        this.c3.a();
    }
}
