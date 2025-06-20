package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.source.SinglePeriodTimeline;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final long u3 = 30000;
    private static final int v3 = 5000;
    private static final long w3 = 5000000;
    private final boolean a3;
    private final Uri b3;
    private final DataSource.Factory c3;
    private final SsChunkSource.Factory d3;
    private final CompositeSequenceableLoaderFactory e3;
    @Nullable
    private final CmcdConfiguration f3;
    private final DrmSessionManager g3;
    private final LoadErrorHandlingPolicy h3;
    private final long i3;
    private final MediaSourceEventListener.EventDispatcher j3;
    private final ParsingLoadable.Parser<? extends SsManifest> k3;
    private final ArrayList<SsMediaPeriod> l3;
    private DataSource m3;
    private Loader n3;
    private LoaderErrorThrower o3;
    @Nullable
    private TransferListener p3;
    private long q3;
    private SsManifest r3;
    private Handler s3;
    @GuardedBy("this")
    private MediaItem t3;

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: c  reason: collision with root package name */
        private final SsChunkSource.Factory f12006c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final DataSource.Factory f12007d;

        /* renamed from: e  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f12008e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private CmcdConfiguration.Factory f12009f;

        /* renamed from: g  reason: collision with root package name */
        private DrmSessionManagerProvider f12010g;

        /* renamed from: h  reason: collision with root package name */
        private LoadErrorHandlingPolicy f12011h;

        /* renamed from: i  reason: collision with root package name */
        private long f12012i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private ParsingLoadable.Parser<? extends SsManifest> f12013j;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        public int[] f() {
            return new int[]{1};
        }

        /* renamed from: h */
        public SsMediaSource c(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.g(mediaItem2.X);
            ParsingLoadable.Parser parser = this.f12013j;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            List<StreamKey> list = mediaItem2.X.X2;
            FilteringManifestParser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser;
            CmcdConfiguration.Factory factory = this.f12009f;
            return new SsMediaSource(mediaItem, (SsManifest) null, this.f12007d, filteringManifestParser, this.f12006c, this.f12008e, factory == null ? null : factory.a(mediaItem2), this.f12010g.a(mediaItem2), this.f12011h, this.f12012i);
        }

        public SsMediaSource i(SsManifest ssManifest) {
            return j(ssManifest, MediaItem.d(Uri.EMPTY));
        }

        public SsMediaSource j(SsManifest ssManifest, MediaItem mediaItem) {
            SsManifest ssManifest2 = ssManifest;
            MediaItem mediaItem2 = mediaItem;
            boolean z = true;
            Assertions.a(!ssManifest2.f12018d);
            MediaItem.LocalConfiguration localConfiguration = mediaItem2.X;
            List I = localConfiguration != null ? localConfiguration.X2 : ImmutableList.I();
            if (!I.isEmpty()) {
                ssManifest2 = ssManifest2.a(I);
            }
            SsManifest ssManifest3 = ssManifest2;
            if (mediaItem2.X == null) {
                z = false;
            }
            MediaItem a2 = mediaItem.b().G(MimeTypes.u0).M(z ? mediaItem2.X.s : Uri.EMPTY).a();
            CmcdConfiguration.Factory factory = this.f12009f;
            return new SsMediaSource(a2, ssManifest3, (DataSource.Factory) null, (ParsingLoadable.Parser) null, this.f12006c, this.f12008e, factory == null ? null : factory.a(a2), this.f12010g.a(a2), this.f12011h, this.f12012i);
        }

        @CanIgnoreReturnValue
        /* renamed from: k */
        public Factory b(boolean z) {
            this.f12006c.b(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public Factory g(CmcdConfiguration.Factory factory) {
            this.f12009f = (CmcdConfiguration.Factory) Assertions.g(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Factory m(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f12008e = (CompositeSequenceableLoaderFactory) Assertions.h(compositeSequenceableLoaderFactory, "SsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: n */
        public Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f12010g = (DrmSessionManagerProvider) Assertions.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory o(long j2) {
            this.f12012i = j2;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: p */
        public Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f12011h = (LoadErrorHandlingPolicy) Assertions.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory q(@Nullable ParsingLoadable.Parser<? extends SsManifest> parser) {
            this.f12013j = parser;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r */
        public Factory a(SubtitleParser.Factory factory) {
            this.f12006c.a((SubtitleParser.Factory) Assertions.g(factory));
            return this;
        }

        public Factory(SsChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f12006c = (SsChunkSource.Factory) Assertions.g(factory);
            this.f12007d = factory2;
            this.f12010g = new DefaultDrmSessionManagerProvider();
            this.f12011h = new DefaultLoadErrorHandlingPolicy();
            this.f12012i = 30000;
            this.f12008e = new DefaultCompositeSequenceableLoaderFactory();
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.smoothstreaming");
    }

    private SsMediaSource(MediaItem mediaItem, @Nullable SsManifest ssManifest, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        boolean z = true;
        Assertions.i(ssManifest == null || !ssManifest.f12018d);
        this.t3 = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.g(mediaItem.X);
        this.r3 = ssManifest;
        this.b3 = localConfiguration.s.equals(Uri.EMPTY) ? null : Util.R(localConfiguration.s);
        this.c3 = factory;
        this.k3 = parser;
        this.d3 = factory2;
        this.e3 = compositeSequenceableLoaderFactory;
        this.f3 = cmcdConfiguration;
        this.g3 = drmSessionManager;
        this.h3 = loadErrorHandlingPolicy;
        this.i3 = j2;
        this.j3 = f0((MediaSource.MediaPeriodId) null);
        this.a3 = ssManifest == null ? false : z;
        this.l3 = new ArrayList<>();
    }

    private void D0() {
        SinglePeriodTimeline singlePeriodTimeline;
        for (int i2 = 0; i2 < this.l3.size(); i2++) {
            this.l3.get(i2).z(this.r3);
        }
        long j2 = Long.MIN_VALUE;
        long j4 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.r3.f12020f) {
            if (streamElement.f12036k > 0) {
                j4 = Math.min(j4, streamElement.e(0));
                j2 = Math.max(j2, streamElement.e(streamElement.f12036k - 1) + streamElement.c(streamElement.f12036k - 1));
            }
        }
        if (j4 == Long.MAX_VALUE) {
            long j5 = this.r3.f12018d ? -9223372036854775807L : 0;
            SsManifest ssManifest = this.r3;
            boolean z = ssManifest.f12018d;
            singlePeriodTimeline = new SinglePeriodTimeline(j5, 0, 0, 0, true, z, z, (Object) ssManifest, H());
        } else {
            SsManifest ssManifest2 = this.r3;
            if (ssManifest2.f12018d) {
                long j6 = ssManifest2.f12022h;
                if (j6 != C.f9084b && j6 > 0) {
                    j4 = Math.max(j4, j2 - j6);
                }
                long j7 = j4;
                long j8 = j2 - j7;
                long I1 = j8 - Util.I1(this.i3);
                if (I1 < 5000000) {
                    I1 = Math.min(5000000, j8 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline((long) C.f9084b, j8, j7, I1, true, true, true, (Object) this.r3, H());
            } else {
                long j9 = ssManifest2.f12021g;
                long j10 = j9 != C.f9084b ? j9 : j2 - j4;
                singlePeriodTimeline = new SinglePeriodTimeline(j4 + j10, j10, j4, 0, true, false, false, (Object) this.r3, H());
            }
        }
        t0(singlePeriodTimeline);
    }

    private void E0() {
        if (this.r3.f12018d) {
            this.s3.postDelayed(new c(this), Math.max(0, (this.q3 + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void F0() {
        if (!this.n3.j()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.m3, this.b3, 4, this.k3);
            this.j3.y(new LoadEventInfo(parsingLoadable.f12583a, parsingLoadable.f12584b, this.n3.n(parsingLoadable, this, this.h3.c(parsingLoadable.f12585c))), parsingLoadable.f12585c);
        }
    }

    /* renamed from: A0 */
    public void Z(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j4, boolean z) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.h3.b(parsingLoadable2.f12583a);
        this.j3.p(loadEventInfo, parsingLoadable2.f12585c);
    }

    /* renamed from: B0 */
    public void N(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j4) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.h3.b(parsingLoadable2.f12583a);
        this.j3.s(loadEventInfo, parsingLoadable2.f12585c);
        this.r3 = parsingLoadable.e();
        this.q3 = j2 - j4;
        D0();
        E0();
    }

    /* renamed from: C0 */
    public Loader.LoadErrorAction p(ParsingLoadable<SsManifest> parsingLoadable, long j2, long j4, IOException iOException, int i2) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        long a2 = this.h3.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f12585c), iOException2, i2));
        Loader.LoadErrorAction i4 = a2 == C.f9084b ? Loader.f12577l : Loader.i(false, a2);
        boolean z = !i4.c();
        this.j3.w(loadEventInfo, parsingLoadable2.f12585c, iOException2, z);
        if (z) {
            this.h3.b(parsingLoadable2.f12583a);
        }
        return i4;
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSourceEventListener.EventDispatcher f0 = f0(mediaPeriodId);
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.r3, this.d3, this.p3, this.e3, this.f3, this.g3, b0(mediaPeriodId), this.h3, f0, this.o3, allocator);
        this.l3.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public synchronized MediaItem H() {
        return this.t3;
    }

    public void I() throws IOException {
        this.o3.b();
    }

    public boolean S(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.g(H().X);
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.X;
        return localConfiguration2 != null && localConfiguration2.s.equals(localConfiguration.s) && localConfiguration2.X2.equals(localConfiguration.X2) && Util.g(localConfiguration2.Y, localConfiguration.Y);
    }

    public void X(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).y();
        this.l3.remove(mediaPeriod);
    }

    public synchronized void k(MediaItem mediaItem) {
        this.t3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        this.p3 = transferListener;
        this.g3.b(Looper.myLooper(), k0());
        this.g3.k();
        if (this.a3) {
            this.o3 = new LoaderErrorThrower.Placeholder();
            D0();
            return;
        }
        this.m3 = this.c3.a();
        Loader loader = new Loader("SsMediaSource");
        this.n3 = loader;
        this.o3 = loader;
        this.s3 = Util.H();
        F0();
    }

    /* access modifiers changed from: protected */
    public void u0() {
        this.r3 = this.a3 ? this.r3 : null;
        this.m3 = null;
        this.q3 = 0;
        Loader loader = this.n3;
        if (loader != null) {
            loader.l();
            this.n3 = null;
        }
        Handler handler = this.s3;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.s3 = null;
        }
        this.g3.a();
    }
}
