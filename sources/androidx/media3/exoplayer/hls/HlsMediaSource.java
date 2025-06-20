package androidx.media3.exoplayer.hls;

import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.FilteringHlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParserFactory;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.source.SinglePeriodTimeline;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@UnstableApi
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int p3 = 1;
    public static final int q3 = 3;
    private final HlsExtractorFactory a3;
    private final HlsDataSourceFactory b3;
    private final CompositeSequenceableLoaderFactory c3;
    @Nullable
    private final CmcdConfiguration d3;
    private final DrmSessionManager e3;
    private final LoadErrorHandlingPolicy f3;
    private final boolean g3;
    private final int h3;
    private final boolean i3;
    private final HlsPlaylistTracker j3;
    private final long k3;
    private final long l3;
    private MediaItem.LiveConfiguration m3;
    @Nullable
    private TransferListener n3;
    @GuardedBy("this")
    private MediaItem o3;

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: c  reason: collision with root package name */
        private final HlsDataSourceFactory f11415c;

        /* renamed from: d  reason: collision with root package name */
        private HlsExtractorFactory f11416d;

        /* renamed from: e  reason: collision with root package name */
        private HlsPlaylistParserFactory f11417e;

        /* renamed from: f  reason: collision with root package name */
        private HlsPlaylistTracker.Factory f11418f;

        /* renamed from: g  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f11419g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private CmcdConfiguration.Factory f11420h;

        /* renamed from: i  reason: collision with root package name */
        private DrmSessionManagerProvider f11421i;

        /* renamed from: j  reason: collision with root package name */
        private LoadErrorHandlingPolicy f11422j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11423k;

        /* renamed from: l  reason: collision with root package name */
        private int f11424l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f11425m;

        /* renamed from: n  reason: collision with root package name */
        private long f11426n;
        private long o;

        public Factory(DataSource.Factory factory) {
            this((HlsDataSourceFactory) new DefaultHlsDataSourceFactory(factory));
        }

        public int[] f() {
            return new int[]{2};
        }

        /* renamed from: h */
        public HlsMediaSource c(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.g(mediaItem2.X);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.f11417e;
            List<StreamKey> list = mediaItem2.X.X2;
            FilteringHlsPlaylistParserFactory filteringHlsPlaylistParserFactory = !list.isEmpty() ? new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list) : hlsPlaylistParserFactory;
            CmcdConfiguration.Factory factory = this.f11420h;
            CmcdConfiguration a2 = factory == null ? null : factory.a(mediaItem2);
            HlsDataSourceFactory hlsDataSourceFactory = this.f11415c;
            HlsExtractorFactory hlsExtractorFactory = this.f11416d;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f11419g;
            DrmSessionManager a3 = this.f11421i.a(mediaItem2);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f11422j;
            return new HlsMediaSource(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, a2, a3, loadErrorHandlingPolicy, this.f11418f.a(this.f11415c, loadErrorHandlingPolicy, filteringHlsPlaylistParserFactory), this.f11426n, this.f11423k, this.f11424l, this.f11425m, this.o);
        }

        @CanIgnoreReturnValue
        /* renamed from: i */
        public Factory b(boolean z) {
            this.f11416d.b(z);
            return this;
        }

        @CanIgnoreReturnValue
        public Factory j(boolean z) {
            this.f11423k = z;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: k */
        public Factory g(CmcdConfiguration.Factory factory) {
            this.f11420h = (CmcdConfiguration.Factory) Assertions.g(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Factory l(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f11419g = (CompositeSequenceableLoaderFactory) Assertions.h(compositeSequenceableLoaderFactory, "HlsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f11421i = (DrmSessionManagerProvider) Assertions.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @CanIgnoreReturnValue
        public Factory n(long j2) {
            this.f11426n = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory o(@Nullable HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.f11408a;
            }
            this.f11416d = hlsExtractorFactory;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: p */
        public Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11422j = (LoadErrorHandlingPolicy) Assertions.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory q(int i2) {
            this.f11424l = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory r(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            this.f11417e = (HlsPlaylistParserFactory) Assertions.h(hlsPlaylistParserFactory, "HlsMediaSource.Factory#setPlaylistParserFactory no longer handles null by instantiating a new DefaultHlsPlaylistParserFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory s(HlsPlaylistTracker.Factory factory) {
            this.f11418f = (HlsPlaylistTracker.Factory) Assertions.h(factory, "HlsMediaSource.Factory#setPlaylistTrackerFactory no longer handles null by defaulting to DefaultHlsPlaylistTracker.FACTORY. Explicitly pass a reference to this instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: t */
        public Factory a(SubtitleParser.Factory factory) {
            this.f11416d.a((SubtitleParser.Factory) Assertions.g(factory));
            return this;
        }

        @CanIgnoreReturnValue
        public Factory u(long j2) {
            this.o = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory v(boolean z) {
            this.f11425m = z;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.f11415c = (HlsDataSourceFactory) Assertions.g(hlsDataSourceFactory);
            this.f11421i = new DefaultDrmSessionManagerProvider();
            this.f11417e = new DefaultHlsPlaylistParserFactory();
            this.f11418f = DefaultHlsPlaylistTracker.i3;
            this.f11416d = HlsExtractorFactory.f11408a;
            this.f11422j = new DefaultLoadErrorHandlingPolicy();
            this.f11419g = new DefaultCompositeSequenceableLoaderFactory();
            this.f11424l = 1;
            this.f11426n = C.f9084b;
            this.f11423k = true;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.hls");
    }

    private HlsMediaSource(MediaItem mediaItem, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long j2, boolean z, int i2, boolean z2, long j4) {
        this.o3 = mediaItem;
        this.m3 = mediaItem.Z;
        this.b3 = hlsDataSourceFactory;
        this.a3 = hlsExtractorFactory;
        this.c3 = compositeSequenceableLoaderFactory;
        this.d3 = cmcdConfiguration;
        this.e3 = drmSessionManager;
        this.f3 = loadErrorHandlingPolicy;
        this.j3 = hlsPlaylistTracker;
        this.k3 = j2;
        this.g3 = z;
        this.h3 = i2;
        this.i3 = z2;
        this.l3 = j4;
    }

    private SinglePeriodTimeline A0(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j4, HlsManifest hlsManifest) {
        long j5;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        if (hlsMediaPlaylist2.f11558e == C.f9084b || hlsMediaPlaylist2.r.isEmpty()) {
            j5 = 0;
        } else {
            if (!hlsMediaPlaylist2.f11560g) {
                long j6 = hlsMediaPlaylist2.f11558e;
                if (j6 != hlsMediaPlaylist2.u) {
                    j5 = C0(hlsMediaPlaylist2.r, j6).X2;
                }
            }
            j5 = hlsMediaPlaylist2.f11558e;
        }
        long j7 = j5;
        long j8 = hlsMediaPlaylist2.u;
        return new SinglePeriodTimeline(j2, j4, C.f9084b, j8, j8, 0, j7, true, false, true, hlsManifest, H(), (MediaItem.LiveConfiguration) null);
    }

    @Nullable
    private static HlsMediaPlaylist.Part B0(List<HlsMediaPlaylist.Part> list, long j2) {
        HlsMediaPlaylist.Part part = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            HlsMediaPlaylist.Part part2 = list.get(i2);
            long j4 = part2.X2;
            if (j4 <= j2 && part2.e3) {
                part = part2;
            } else if (j4 > j2) {
                break;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment C0(List<HlsMediaPlaylist.Segment> list, long j2) {
        return list.get(Util.l(list, Long.valueOf(j2), true, true));
    }

    private long D0(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.p) {
            return Util.I1(Util.B0(this.k3)) - hlsMediaPlaylist.e();
        }
        return 0;
    }

    private long E0(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j4 = hlsMediaPlaylist.f11558e;
        if (j4 == C.f9084b) {
            j4 = (hlsMediaPlaylist.u + j2) - Util.I1(this.m3.s);
        }
        if (hlsMediaPlaylist.f11560g) {
            return j4;
        }
        HlsMediaPlaylist.Part B0 = B0(hlsMediaPlaylist.s, j4);
        if (B0 != null) {
            return B0.X2;
        }
        if (hlsMediaPlaylist.r.isEmpty()) {
            return 0;
        }
        HlsMediaPlaylist.Segment C0 = C0(hlsMediaPlaylist.r, j4);
        HlsMediaPlaylist.Part B02 = B0(C0.f3, j4);
        return B02 != null ? B02.X2 : C0.X2;
    }

    private static long F0(HlsMediaPlaylist hlsMediaPlaylist, long j2) {
        long j4;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.v;
        long j5 = hlsMediaPlaylist.f11558e;
        if (j5 != C.f9084b) {
            j4 = hlsMediaPlaylist.u - j5;
        } else {
            long j6 = serverControl.f11574d;
            if (j6 == C.f9084b || hlsMediaPlaylist.f11567n == C.f9084b) {
                long j7 = serverControl.f11573c;
                j4 = j7 != C.f9084b ? j7 : hlsMediaPlaylist.f11566m * 3;
            } else {
                j4 = j6;
            }
        }
        return j4 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void G0(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r6, long r7) {
        /*
            r5 = this;
            androidx.media3.common.MediaItem r0 = r5.H()
            androidx.media3.common.MediaItem$LiveConfiguration r0 = r0.Z
            float r1 = r0.Z
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002a
            float r0 = r0.X2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl r6 = r6.v
            long r0 = r6.f11573c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002a
            long r0 = r6.f11574d
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002a
            r6 = 1
            goto L_0x002b
        L_0x002a:
            r6 = 0
        L_0x002b:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r0 = new androidx.media3.common.MediaItem$LiveConfiguration$Builder
            r0.<init>()
            long r7 = androidx.media3.common.util.Util.H2(r7)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = r0.k(r7)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x003f
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0043
        L_0x003f:
            androidx.media3.common.MediaItem$LiveConfiguration r0 = r5.m3
            float r0 = r0.Z
        L_0x0043:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = r7.j(r0)
            if (r6 == 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            androidx.media3.common.MediaItem$LiveConfiguration r6 = r5.m3
            float r8 = r6.X2
        L_0x004e:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r6 = r7.h(r8)
            androidx.media3.common.MediaItem$LiveConfiguration r6 = r6.f()
            r5.m3 = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.G0(androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist, long):void");
    }

    private SinglePeriodTimeline z0(HlsMediaPlaylist hlsMediaPlaylist, long j2, long j4, HlsManifest hlsManifest) {
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long f2 = hlsMediaPlaylist2.f11561h - this.j3.f();
        long j5 = hlsMediaPlaylist2.o ? f2 + hlsMediaPlaylist2.u : -9223372036854775807L;
        long D0 = D0(hlsMediaPlaylist);
        long j6 = this.m3.s;
        G0(hlsMediaPlaylist2, Util.x(j6 != C.f9084b ? Util.I1(j6) : F0(hlsMediaPlaylist2, D0), D0, hlsMediaPlaylist2.u + D0));
        return new SinglePeriodTimeline(j2, j4, C.f9084b, j5, hlsMediaPlaylist2.u, f2, E0(hlsMediaPlaylist2, D0), true, !hlsMediaPlaylist2.o, hlsMediaPlaylist2.f11557d == 2 && hlsMediaPlaylist2.f11559f, hlsManifest, H(), this.m3);
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher f0 = f0(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher b0 = b0(mediaPeriodId);
        HlsExtractorFactory hlsExtractorFactory = this.a3;
        return new HlsMediaPeriod(hlsExtractorFactory, this.j3, this.b3, this.n3, this.d3, this.e3, b0, this.f3, f0, allocator, this.c3, this.g3, this.h3, this.i3, k0(), this.l3);
    }

    public synchronized MediaItem H() {
        return this.o3;
    }

    public void I() throws IOException {
        this.j3.j();
    }

    public boolean S(MediaItem mediaItem) {
        MediaItem H = H();
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.g(H.X);
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.X;
        return localConfiguration2 != null && localConfiguration2.s.equals(localConfiguration.s) && localConfiguration2.X2.equals(localConfiguration.X2) && Util.g(localConfiguration2.Y, localConfiguration.Y) && H.Z.equals(mediaItem.Z);
    }

    public void X(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).E();
    }

    public synchronized void k(MediaItem mediaItem) {
        this.o3 = mediaItem;
    }

    public void s(HlsMediaPlaylist hlsMediaPlaylist) {
        long H2 = hlsMediaPlaylist.p ? Util.H2(hlsMediaPlaylist.f11561h) : -9223372036854775807L;
        int i2 = hlsMediaPlaylist.f11557d;
        long j2 = (i2 == 2 || i2 == 1) ? H2 : -9223372036854775807L;
        HlsManifest hlsManifest = new HlsManifest((HlsMultivariantPlaylist) Assertions.g(this.j3.h()), hlsMediaPlaylist);
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        t0(this.j3.g() ? z0(hlsMediaPlaylist2, j2, H2, hlsManifest) : A0(hlsMediaPlaylist2, j2, H2, hlsManifest));
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        this.n3 = transferListener;
        this.e3.b((Looper) Assertions.g(Looper.myLooper()), k0());
        this.e3.k();
        this.j3.a(((MediaItem.LocalConfiguration) Assertions.g(H().X)).s, f0((MediaSource.MediaPeriodId) null), this);
    }

    /* access modifiers changed from: protected */
    public void u0() {
        this.j3.stop();
        this.e3.a();
    }
}
