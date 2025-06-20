package androidx.media3.exoplayer.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.C0265j;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.a;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.n;
import androidx.media3.extractor.ExtractorsFactory;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class DownloadHelper {
    public static final DefaultTrackSelector.Parameters o = DefaultTrackSelector.Parameters.v4.G().P(true).j1(false).D();

    /* renamed from: a  reason: collision with root package name */
    private final MediaItem.LocalConfiguration f11770a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final MediaSource f11771b;

    /* renamed from: c  reason: collision with root package name */
    private final DefaultTrackSelector f11772c;

    /* renamed from: d  reason: collision with root package name */
    private final RendererCapabilities[] f11773d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseIntArray f11774e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    private final Handler f11775f;

    /* renamed from: g  reason: collision with root package name */
    private final Timeline.Window f11776g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11777h;

    /* renamed from: i  reason: collision with root package name */
    private Callback f11778i;

    /* renamed from: j  reason: collision with root package name */
    private MediaPreparer f11779j;

    /* renamed from: k  reason: collision with root package name */
    private TrackGroupArray[] f11780k;

    /* renamed from: l  reason: collision with root package name */
    private MappingTrackSelector.MappedTrackInfo[] f11781l;

    /* renamed from: m  reason: collision with root package name */
    private List<ExoTrackSelection>[][] f11782m;

    /* renamed from: n  reason: collision with root package name */
    private List<ExoTrackSelection>[][] f11783n;

    public interface Callback {
        void a(DownloadHelper downloadHelper);

        void b(DownloadHelper downloadHelper, IOException iOException);
    }

    private static final class DownloadTrackSelection extends BaseTrackSelection {

        private static final class Factory implements ExoTrackSelection.Factory {
            private Factory() {
            }

            public ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
                ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
                for (int i2 = 0; i2 < definitionArr.length; i2++) {
                    ExoTrackSelection.Definition definition = definitionArr[i2];
                    exoTrackSelectionArr[i2] = definition == null ? null : new DownloadTrackSelection(definition.f12389a, definition.f12390b);
                }
                return exoTrackSelectionArr;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        public int e() {
            return 0;
        }

        public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }

        public int p() {
            return 0;
        }

        @Nullable
        public Object s() {
            return null;
        }
    }

    private static final class FakeBandwidthMeter implements BandwidthMeter {
        private FakeBandwidthMeter() {
        }

        public void a(BandwidthMeter.EventListener eventListener) {
        }

        public /* synthetic */ long b() {
            return a.a(this);
        }

        public void c(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        @Nullable
        public TransferListener f() {
            return null;
        }

        public long i() {
            return 0;
        }
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    private static final class MediaPreparer implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {
        private static final int d3 = 0;
        private static final int e3 = 1;
        private static final int f3 = 2;
        private static final int g3 = 3;
        private static final int h3 = 0;
        private static final int i3 = 1;
        private final DownloadHelper X;
        private final Handler X2 = Util.K(new i(this));
        private final Allocator Y = new DefaultAllocator(true, 65536);
        private final HandlerThread Y2;
        private final ArrayList<MediaPeriod> Z = new ArrayList<>();
        private final Handler Z2;
        public Timeline a3;
        public MediaPeriod[] b3;
        private boolean c3;
        private final MediaSource s;

        public MediaPreparer(MediaSource mediaSource, DownloadHelper downloadHelper) {
            this.s = mediaSource;
            this.X = downloadHelper;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.Y2 = handlerThread;
            handlerThread.start();
            Handler G = Util.G(handlerThread.getLooper(), this);
            this.Z2 = G;
            G.sendEmptyMessage(0);
        }

        /* access modifiers changed from: private */
        public boolean c(Message message) {
            if (this.c3) {
                return false;
            }
            int i2 = message.what;
            if (i2 == 0) {
                try {
                    this.X.Q();
                } catch (ExoPlaybackException e2) {
                    this.X2.obtainMessage(1, new IOException(e2)).sendToTarget();
                }
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                e();
                this.X.P((IOException) Util.o(message.obj));
                return true;
            }
        }

        public void W(MediaSource mediaSource, Timeline timeline) {
            MediaPeriod[] mediaPeriodArr;
            if (this.a3 == null) {
                if (timeline.u(0, new Timeline.Window()).j()) {
                    this.X2.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                    return;
                }
                this.a3 = timeline;
                this.b3 = new MediaPeriod[timeline.n()];
                int i2 = 0;
                while (true) {
                    mediaPeriodArr = this.b3;
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    MediaPeriod E = this.s.E(new MediaSource.MediaPeriodId(timeline.t(i2)), this.Y, 0);
                    this.b3[i2] = E;
                    this.Z.add(E);
                    i2++;
                }
                for (MediaPeriod r : mediaPeriodArr) {
                    r.r(this, 0);
                }
            }
        }

        /* renamed from: d */
        public void j(MediaPeriod mediaPeriod) {
            if (this.Z.contains(mediaPeriod)) {
                this.Z2.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }

        public void e() {
            if (!this.c3) {
                this.c3 = true;
                this.Z2.sendEmptyMessage(3);
            }
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                int i4 = 0;
                if (i2 == 1) {
                    try {
                        if (this.b3 == null) {
                            this.s.I();
                        } else {
                            while (i4 < this.Z.size()) {
                                this.Z.get(i4).l();
                                i4++;
                            }
                        }
                        this.Z2.sendEmptyMessageDelayed(1, 100);
                    } catch (IOException e2) {
                        this.X2.obtainMessage(1, e2).sendToTarget();
                    }
                    return true;
                } else if (i2 == 2) {
                    MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                    if (this.Z.contains(mediaPeriod)) {
                        mediaPeriod.a(new LoadingInfo.Builder().f(0).d());
                    }
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    MediaPeriod[] mediaPeriodArr = this.b3;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i4 < length) {
                            this.s.X(mediaPeriodArr[i4]);
                            i4++;
                        }
                    }
                    this.s.x(this);
                    this.Z2.removeCallbacksAndMessages((Object) null);
                    this.Y2.quit();
                    return true;
                }
            } else {
                this.s.Y(this, (TransferListener) null, PlayerId.f10613b);
                this.Z2.sendEmptyMessage(1);
                return true;
            }
        }

        public void i(MediaPeriod mediaPeriod) {
            this.Z.remove(mediaPeriod);
            if (this.Z.isEmpty()) {
                this.Z2.removeMessages(1);
                this.X2.sendEmptyMessage(0);
            }
        }
    }

    public DownloadHelper(MediaItem mediaItem, @Nullable MediaSource mediaSource, TrackSelectionParameters trackSelectionParameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.f11770a = (MediaItem.LocalConfiguration) Assertions.g(mediaItem.X);
        this.f11771b = mediaSource;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(trackSelectionParameters, (ExoTrackSelection.Factory) new DownloadTrackSelection.Factory());
        this.f11772c = defaultTrackSelector;
        this.f11773d = rendererCapabilitiesArr;
        defaultTrackSelector.e(new b(), new FakeBandwidthMeter());
        this.f11775f = Util.J();
        this.f11776g = new Timeline.Window();
    }

    public static RendererCapabilities[] D(RenderersFactory renderersFactory) {
        Renderer[] a2 = renderersFactory.a(Util.J(), new VideoRendererEventListener() {
            public /* synthetic */ void C(long j2, int i2) {
                n.h(this, j2, i2);
            }

            public /* synthetic */ void c(VideoSize videoSize) {
                n.k(this, videoSize);
            }

            public /* synthetic */ void g(String str) {
                n.e(this, str);
            }

            public /* synthetic */ void h(String str, long j2, long j3) {
                n.d(this, str, j2, j3);
            }

            public /* synthetic */ void k(Format format) {
                n.i(this, format);
            }

            public /* synthetic */ void l(int i2, long j2) {
                n.a(this, i2, j2);
            }

            public /* synthetic */ void n(DecoderCounters decoderCounters) {
                n.g(this, decoderCounters);
            }

            public /* synthetic */ void o(Object obj, long j2) {
                n.b(this, obj, j2);
            }

            public /* synthetic */ void r(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                n.j(this, format, decoderReuseEvaluation);
            }

            public /* synthetic */ void t(DecoderCounters decoderCounters) {
                n.f(this, decoderCounters);
            }

            public /* synthetic */ void y(Exception exc) {
                n.c(this, exc);
            }
        }, new AudioRendererEventListener() {
            public /* synthetic */ void B(DecoderCounters decoderCounters) {
                C0265j.d(this, decoderCounters);
            }

            public /* synthetic */ void a(Format format) {
                C0265j.f(this, format);
            }

            public /* synthetic */ void b(AudioSink.AudioTrackConfig audioTrackConfig) {
                C0265j.j(this, audioTrackConfig);
            }

            public /* synthetic */ void d(AudioSink.AudioTrackConfig audioTrackConfig) {
                C0265j.k(this, audioTrackConfig);
            }

            public /* synthetic */ void e(boolean z) {
                C0265j.m(this, z);
            }

            public /* synthetic */ void f(Exception exc) {
                C0265j.i(this, exc);
            }

            public /* synthetic */ void i(String str) {
                C0265j.c(this, str);
            }

            public /* synthetic */ void j(String str, long j2, long j3) {
                C0265j.b(this, str, j2, j3);
            }

            public /* synthetic */ void m(DecoderCounters decoderCounters) {
                C0265j.e(this, decoderCounters);
            }

            public /* synthetic */ void u(long j2) {
                C0265j.h(this, j2);
            }

            public /* synthetic */ void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                C0265j.g(this, format, decoderReuseEvaluation);
            }

            public /* synthetic */ void w(Exception exc) {
                C0265j.a(this, exc);
            }

            public /* synthetic */ void z(int i2, long j2, long j3) {
                C0265j.l(this, i2, j2, j3);
            }
        }, new d(), new e());
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[a2.length];
        for (int i2 = 0; i2 < a2.length; i2++) {
            rendererCapabilitiesArr[i2] = a2[i2].s();
        }
        return rendererCapabilitiesArr;
    }

    private static boolean H(MediaItem.LocalConfiguration localConfiguration) {
        return Util.b1(localConfiguration.s, localConfiguration.X) == 4;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DrmSessionManager I(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void J(CueGroup cueGroup) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void K(Metadata metadata) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void L() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(IOException iOException) {
        ((Callback) Assertions.g(this.f11778i)).b(this, iOException);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        ((Callback) Assertions.g(this.f11778i)).a(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Callback callback) {
        callback.a(this);
    }

    /* access modifiers changed from: private */
    public void P(IOException iOException) {
        ((Handler) Assertions.g(this.f11775f)).post(new g(this, iOException));
    }

    /* access modifiers changed from: private */
    public void Q() throws ExoPlaybackException {
        Assertions.g(this.f11779j);
        Assertions.g(this.f11779j.b3);
        Assertions.g(this.f11779j.a3);
        int length = this.f11779j.b3.length;
        int length2 = this.f11773d.length;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        Class<List> cls = List.class;
        this.f11782m = (List[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        this.f11783n = (List[][]) Array.newInstance(cls, iArr2);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                this.f11782m[i2][i3] = new ArrayList();
                this.f11783n[i2][i3] = Collections.unmodifiableList(this.f11782m[i2][i3]);
            }
        }
        this.f11780k = new TrackGroupArray[length];
        this.f11781l = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i4 = 0; i4 < length; i4++) {
            this.f11780k[i4] = this.f11779j.b3[i4].s();
            this.f11772c.i(U(i4).f12420e);
            this.f11781l[i4] = (MappingTrackSelector.MappedTrackInfo) Assertions.g(this.f11772c.o());
        }
        V();
        ((Handler) Assertions.g(this.f11775f)).post(new f(this));
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private TrackSelectorResult U(int i2) throws ExoPlaybackException {
        TrackSelectorResult k2 = this.f11772c.k(this.f11773d, this.f11780k[i2], new MediaSource.MediaPeriodId(this.f11779j.a3.t(i2)), this.f11779j.a3);
        for (int i3 = 0; i3 < k2.f12416a; i3++) {
            ExoTrackSelection exoTrackSelection = k2.f12418c[i3];
            if (exoTrackSelection != null) {
                List<ExoTrackSelection> list = this.f11782m[i2][i3];
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        list.add(exoTrackSelection);
                        break;
                    }
                    ExoTrackSelection exoTrackSelection2 = list.get(i4);
                    if (exoTrackSelection2.d().equals(exoTrackSelection.d())) {
                        this.f11774e.clear();
                        for (int i5 = 0; i5 < exoTrackSelection2.length(); i5++) {
                            this.f11774e.put(exoTrackSelection2.k(i5), 0);
                        }
                        for (int i6 = 0; i6 < exoTrackSelection.length(); i6++) {
                            this.f11774e.put(exoTrackSelection.k(i6), 0);
                        }
                        int[] iArr = new int[this.f11774e.size()];
                        for (int i7 = 0; i7 < this.f11774e.size(); i7++) {
                            iArr[i7] = this.f11774e.keyAt(i7);
                        }
                        list.set(i4, new DownloadTrackSelection(exoTrackSelection2.d(), iArr));
                    } else {
                        i4++;
                    }
                }
            }
        }
        return k2;
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void V() {
        this.f11777h = true;
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private void n(int i2, TrackSelectionParameters trackSelectionParameters) throws ExoPlaybackException {
        this.f11772c.m(trackSelectionParameters);
        U(i2);
        UnmodifiableIterator<TrackSelectionOverride> k2 = trackSelectionParameters.t3.values().iterator();
        while (k2.hasNext()) {
            this.f11772c.m(trackSelectionParameters.G().b0(k2.next()).D());
            U(i2);
        }
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void o() {
        Assertions.i(this.f11777h);
    }

    public static MediaSource q(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return r(downloadRequest, factory, (DrmSessionManager) null);
    }

    public static MediaSource r(DownloadRequest downloadRequest, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        return s(downloadRequest.d(), factory, drmSessionManager);
    }

    private static MediaSource s(MediaItem mediaItem, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(factory, ExtractorsFactory.f13039a);
        if (drmSessionManager != null) {
            defaultMediaSourceFactory.e(new c(drmSessionManager));
        }
        return defaultMediaSourceFactory.c(mediaItem);
    }

    public static DownloadHelper t(Context context, MediaItem mediaItem) {
        Assertions.a(H((MediaItem.LocalConfiguration) Assertions.g(mediaItem.X)));
        return w(mediaItem, x(context), (RenderersFactory) null, (DataSource.Factory) null, (DrmSessionManager) null);
    }

    public static DownloadHelper u(Context context, MediaItem mediaItem, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return w(mediaItem, x(context), renderersFactory, factory, (DrmSessionManager) null);
    }

    public static DownloadHelper v(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return w(mediaItem, trackSelectionParameters, renderersFactory, factory, (DrmSessionManager) null);
    }

    public static DownloadHelper w(MediaItem mediaItem, TrackSelectionParameters trackSelectionParameters, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        boolean H = H((MediaItem.LocalConfiguration) Assertions.g(mediaItem.X));
        Assertions.a(H || factory != null);
        return new DownloadHelper(mediaItem, H ? null : s(mediaItem, (DataSource.Factory) Util.o(factory), drmSessionManager), trackSelectionParameters, renderersFactory != null ? D(renderersFactory) : new RendererCapabilities[0]);
    }

    public static DefaultTrackSelector.Parameters x(Context context) {
        return DefaultTrackSelector.Parameters.Q(context).G().P(true).j1(false).D();
    }

    @Nullable
    public Object A() {
        if (this.f11771b == null) {
            return null;
        }
        o();
        if (this.f11779j.a3.w() > 0) {
            return this.f11779j.a3.u(0, this.f11776g).Z;
        }
        return null;
    }

    public MappingTrackSelector.MappedTrackInfo B(int i2) {
        o();
        return this.f11781l[i2];
    }

    public int C() {
        if (this.f11771b == null) {
            return 0;
        }
        o();
        return this.f11780k.length;
    }

    public TrackGroupArray E(int i2) {
        o();
        return this.f11780k[i2];
    }

    public List<ExoTrackSelection> F(int i2, int i3) {
        o();
        return this.f11783n[i2][i3];
    }

    public Tracks G(int i2) {
        o();
        return TrackSelectionUtil.b(this.f11781l[i2], this.f11783n[i2]);
    }

    public void R(Callback callback) {
        Assertions.i(this.f11778i == null);
        this.f11778i = callback;
        MediaSource mediaSource = this.f11771b;
        if (mediaSource != null) {
            this.f11779j = new MediaPreparer(mediaSource, this);
        } else {
            this.f11775f.post(new h(this, callback));
        }
    }

    public void S() {
        MediaPreparer mediaPreparer = this.f11779j;
        if (mediaPreparer != null) {
            mediaPreparer.e();
        }
        this.f11772c.j();
    }

    public void T(int i2, TrackSelectionParameters trackSelectionParameters) {
        try {
            o();
            p(i2);
            n(i2, trackSelectionParameters);
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void j(String... strArr) {
        try {
            o();
            DefaultTrackSelector.Parameters.Builder O = o.G();
            O.P(true);
            for (RendererCapabilities i2 : this.f11773d) {
                int i3 = i2.i();
                O.r0(i3, i3 != 1);
            }
            int C = C();
            for (String c0 : strArr) {
                TrackSelectionParameters D = O.c0(c0).D();
                for (int i4 = 0; i4 < C; i4++) {
                    n(i4, D);
                }
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void k(boolean z, String... strArr) {
        try {
            o();
            DefaultTrackSelector.Parameters.Builder O = o.G();
            O.q0(z);
            O.P(true);
            for (RendererCapabilities i2 : this.f11773d) {
                int i3 = i2.i();
                O.r0(i3, i3 != 3);
            }
            int C = C();
            for (String h0 : strArr) {
                TrackSelectionParameters D = O.h0(h0).D();
                for (int i4 = 0; i4 < C; i4++) {
                    n(i4, D);
                }
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void l(int i2, TrackSelectionParameters trackSelectionParameters) {
        try {
            o();
            n(i2, trackSelectionParameters);
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void m(int i2, int i3, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        try {
            o();
            DefaultTrackSelector.Parameters.Builder O = parameters.G();
            int i4 = 0;
            while (i4 < this.f11781l[i2].d()) {
                O.O1(i4, i4 != i3);
                i4++;
            }
            if (list.isEmpty()) {
                n(i2, O.D());
                return;
            }
            TrackGroupArray h2 = this.f11781l[i2].h(i3);
            for (int i5 = 0; i5 < list.size(); i5++) {
                O.Q1(i3, h2, list.get(i5));
                n(i2, O.D());
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void p(int i2) {
        o();
        for (int i3 = 0; i3 < this.f11773d.length; i3++) {
            this.f11782m[i2][i3].clear();
        }
    }

    public DownloadRequest y(String str, @Nullable byte[] bArr) {
        DownloadRequest.Builder e2 = new DownloadRequest.Builder(str, this.f11770a.s).e(this.f11770a.X);
        MediaItem.DrmConfiguration drmConfiguration = this.f11770a.Y;
        DownloadRequest.Builder c2 = e2.d(drmConfiguration != null ? drmConfiguration.e() : null).b(this.f11770a.Y2).c(bArr);
        if (this.f11771b == null) {
            return c2.a();
        }
        o();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f11782m.length;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList2.clear();
            for (List<ExoTrackSelection> addAll : this.f11782m[i2]) {
                arrayList2.addAll(addAll);
            }
            arrayList.addAll(this.f11779j.b3[i2].k(arrayList2));
        }
        return c2.f(arrayList).a();
    }

    public DownloadRequest z(@Nullable byte[] bArr) {
        return y(this.f11770a.s.toString(), bArr);
    }
}
