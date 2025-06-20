package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.StreamKey;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.C0296j;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {
    private final MediaSource a3;
    private final ListMultimap<Pair<Long, Object>, SharedMediaPeriod> b3 = ArrayListMultimap.J();
    private final MediaSourceEventListener.EventDispatcher c3 = f0((MediaSource.MediaPeriodId) null);
    private final DrmSessionEventListener.EventDispatcher d3 = b0((MediaSource.MediaPeriodId) null);
    @Nullable
    private final AdPlaybackStateUpdater e3;
    @GuardedBy("this")
    @Nullable
    private Handler f3;
    @Nullable
    private SharedMediaPeriod g3;
    private ImmutableMap<Object, AdPlaybackState> h3 = ImmutableMap.s();

    public interface AdPlaybackStateUpdater {
        boolean a(Timeline timeline);
    }

    private static final class MediaPeriodImpl implements MediaPeriod {
        public final MediaSource.MediaPeriodId X;
        public MediaPeriod.Callback X2;
        public final MediaSourceEventListener.EventDispatcher Y;
        public long Y2;
        public final DrmSessionEventListener.EventDispatcher Z;
        public boolean[] Z2 = new boolean[0];
        public boolean a3;
        public final SharedMediaPeriod s;

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.s = sharedMediaPeriod;
            this.X = mediaPeriodId;
            this.Y = eventDispatcher;
            this.Z = eventDispatcher2;
        }

        public boolean a(LoadingInfo loadingInfo) {
            return this.s.g(this, loadingInfo);
        }

        public void b() {
            MediaPeriod.Callback callback = this.X2;
            if (callback != null) {
                callback.i(this);
            }
            this.a3 = true;
        }

        public boolean c() {
            return this.s.u(this);
        }

        public long e() {
            return this.s.q(this);
        }

        public long f(long j2, SeekParameters seekParameters) {
            return this.s.l(this, j2, seekParameters);
        }

        public long g() {
            return this.s.m(this);
        }

        public void h(long j2) {
            this.s.H(this, j2);
        }

        public List<StreamKey> k(List<ExoTrackSelection> list) {
            return this.s.r(list);
        }

        public void l() throws IOException {
            this.s.z();
        }

        public long m(long j2) {
            return this.s.K(this, j2);
        }

        public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            if (this.Z2.length == 0) {
                this.Z2 = new boolean[sampleStreamArr.length];
            }
            return this.s.L(this, exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
        }

        public long q() {
            return this.s.G(this);
        }

        public void r(MediaPeriod.Callback callback, long j2) {
            this.X2 = callback;
            this.s.E(this, j2);
        }

        public TrackGroupArray s() {
            return this.s.t();
        }

        public void t(long j2, boolean z) {
            this.s.h(this, j2, z);
        }
    }

    private static final class SampleStreamImpl implements SampleStream {
        private final int X;
        private final MediaPeriodImpl s;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i2) {
            this.s = mediaPeriodImpl;
            this.X = i2;
        }

        public void b() throws IOException {
            this.s.s.y(this.X);
        }

        public boolean d() {
            return this.s.s.v(this.X);
        }

        public int j(long j2) {
            MediaPeriodImpl mediaPeriodImpl = this.s;
            return mediaPeriodImpl.s.M(mediaPeriodImpl, this.X, j2);
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            MediaPeriodImpl mediaPeriodImpl = this.s;
            return mediaPeriodImpl.s.F(mediaPeriodImpl, this.X, formatHolder, decoderInputBuffer, i2);
        }
    }

    private static final class ServerSideAdInsertionTimeline extends ForwardingTimeline {
        private final ImmutableMap<Object, AdPlaybackState> Z2;

        public ServerSideAdInsertionTimeline(Timeline timeline, ImmutableMap<Object, AdPlaybackState> immutableMap) {
            super(timeline);
            Assertions.i(timeline.w() == 1);
            Timeline.Period period = new Timeline.Period();
            for (int i2 = 0; i2 < timeline.n(); i2++) {
                timeline.l(i2, period, true);
                Assertions.i(immutableMap.containsKey(Assertions.g(period.X)));
            }
            this.Z2 = immutableMap;
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            super.l(i2, period, true);
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.g(this.Z2.get(period.X));
            long j2 = period.Z;
            long f2 = j2 == C.f9084b ? adPlaybackState.Z : ServerSideAdInsertionUtil.f(j2, -1, adPlaybackState);
            Timeline.Period period2 = new Timeline.Period();
            long j3 = 0;
            for (int i3 = 0; i3 < i2 + 1; i3++) {
                this.Y2.l(i3, period2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.g(this.Z2.get(period2.X));
                if (i3 == 0) {
                    j3 = -ServerSideAdInsertionUtil.f(-period2.s(), -1, adPlaybackState2);
                }
                if (i3 != i2) {
                    j3 += ServerSideAdInsertionUtil.f(period2.Z, -1, adPlaybackState2);
                }
            }
            period.y(period.s, period.X, period.Y, f2, j3, adPlaybackState, period.Y2);
            return period;
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            super.v(i2, window, j2);
            Timeline.Period period = new Timeline.Period();
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.g(this.Z2.get(Assertions.g(l(window.h3, period, true).X)));
            long f2 = ServerSideAdInsertionUtil.f(window.j3, -1, adPlaybackState);
            if (window.g3 == C.f9084b) {
                long j3 = adPlaybackState.Z;
                if (j3 != C.f9084b) {
                    window.g3 = j3 - f2;
                }
            } else {
                Timeline.Period l2 = super.l(window.i3, period, true);
                long j4 = l2.X2;
                Timeline.Period k2 = k(window.i3, period);
                window.g3 = k2.X2 + ServerSideAdInsertionUtil.f(window.g3 - j4, -1, (AdPlaybackState) Assertions.g(this.Z2.get(l2.X)));
            }
            window.j3 = f2;
            return window;
        }
    }

    private static final class SharedMediaPeriod implements MediaPeriod.Callback {
        /* access modifiers changed from: private */
        public final List<MediaPeriodImpl> X = new ArrayList();
        private AdPlaybackState X2;
        private final Map<Long, Pair<LoadEventInfo, MediaLoadData>> Y = new HashMap();
        /* access modifiers changed from: private */
        @Nullable
        public MediaPeriodImpl Y2;
        /* access modifiers changed from: private */
        public final Object Z;
        private boolean Z2;
        private boolean a3;
        public ExoTrackSelection[] b3 = new ExoTrackSelection[0];
        public SampleStream[] c3 = new SampleStream[0];
        public MediaLoadData[] d3 = new MediaLoadData[0];
        private final MediaPeriod s;

        public SharedMediaPeriod(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
            this.s = mediaPeriod;
            this.Z = obj;
            this.X2 = adPlaybackState;
        }

        private int k(MediaLoadData mediaLoadData) {
            String str;
            if (mediaLoadData.f12151c == null) {
                return -1;
            }
            int i2 = 0;
            loop0:
            while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = this.b3;
                if (i2 >= exoTrackSelectionArr.length) {
                    return -1;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
                if (exoTrackSelection != null) {
                    TrackGroup d2 = exoTrackSelection.d();
                    boolean z = mediaLoadData.f12150b == 0 && d2.equals(t().d(0));
                    for (int i3 = 0; i3 < d2.s; i3++) {
                        Format d4 = d2.d(i3);
                        if (d4.equals(mediaLoadData.f12151c) || (z && (str = d4.s) != null && str.equals(mediaLoadData.f12151c.s))) {
                            return i2;
                        }
                    }
                    continue;
                }
                i2++;
            }
            return i2;
        }

        private long p(MediaPeriodImpl mediaPeriodImpl, long j2) {
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long d2 = ServerSideAdInsertionUtil.d(j2, mediaPeriodImpl.X, this.X2);
            if (d2 >= ServerSideAdInsertionMediaSource.E0(mediaPeriodImpl, this.X2)) {
                return Long.MIN_VALUE;
            }
            return d2;
        }

        private long s(MediaPeriodImpl mediaPeriodImpl, long j2) {
            long j3 = mediaPeriodImpl.Y2;
            return j2 < j3 ? ServerSideAdInsertionUtil.g(j3, mediaPeriodImpl.X, this.X2) - (mediaPeriodImpl.Y2 - j2) : ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2);
        }

        private void x(MediaPeriodImpl mediaPeriodImpl, int i2) {
            MediaLoadData mediaLoadData;
            boolean[] zArr = mediaPeriodImpl.Z2;
            if (!zArr[i2] && (mediaLoadData = this.d3[i2]) != null) {
                zArr[i2] = true;
                mediaPeriodImpl.Y.i(ServerSideAdInsertionMediaSource.C0(mediaPeriodImpl, mediaLoadData, this.X2));
            }
        }

        /* renamed from: A */
        public void j(MediaPeriod mediaPeriod) {
            MediaPeriodImpl mediaPeriodImpl = this.Y2;
            if (mediaPeriodImpl != null) {
                ((MediaPeriod.Callback) Assertions.g(mediaPeriodImpl.X2)).j(this.Y2);
            }
        }

        public void B(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData) {
            int k2 = k(mediaLoadData);
            if (k2 != -1) {
                this.d3[k2] = mediaLoadData;
                mediaPeriodImpl.Z2[k2] = true;
            }
        }

        public void C(LoadEventInfo loadEventInfo) {
            this.Y.remove(Long.valueOf(loadEventInfo.f12142a));
        }

        public void D(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            this.Y.put(Long.valueOf(loadEventInfo.f12142a), Pair.create(loadEventInfo, mediaLoadData));
        }

        public void E(MediaPeriodImpl mediaPeriodImpl, long j2) {
            mediaPeriodImpl.Y2 = j2;
            if (!this.Z2) {
                this.Z2 = true;
                this.s.r(this, ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2));
            } else if (this.a3) {
                mediaPeriodImpl.b();
            }
        }

        public int F(MediaPeriodImpl mediaPeriodImpl, int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            long m2 = m(mediaPeriodImpl);
            int o = ((SampleStream) Util.o(this.c3[i2])).o(formatHolder, decoderInputBuffer, i3 | 5);
            long p = p(mediaPeriodImpl, decoderInputBuffer.Y2);
            if ((o == -4 && p == Long.MIN_VALUE) || (o == -3 && m2 == Long.MIN_VALUE && !decoderInputBuffer.X2)) {
                x(mediaPeriodImpl, i2);
                decoderInputBuffer.g();
                decoderInputBuffer.f(4);
                return -4;
            }
            if (o == -4) {
                x(mediaPeriodImpl, i2);
                ((SampleStream) Util.o(this.c3[i2])).o(formatHolder, decoderInputBuffer, i3);
                decoderInputBuffer.Y2 = p;
            }
            return o;
        }

        public long G(MediaPeriodImpl mediaPeriodImpl) {
            if (!mediaPeriodImpl.equals(this.X.get(0))) {
                return C.f9084b;
            }
            long q = this.s.q();
            return q == C.f9084b ? C.f9084b : ServerSideAdInsertionUtil.d(q, mediaPeriodImpl.X, this.X2);
        }

        public void H(MediaPeriodImpl mediaPeriodImpl, long j2) {
            this.s.h(s(mediaPeriodImpl, j2));
        }

        public void I(MediaSource mediaSource) {
            mediaSource.X(this.s);
        }

        public void J(MediaPeriodImpl mediaPeriodImpl) {
            if (mediaPeriodImpl.equals(this.Y2)) {
                this.Y2 = null;
                this.Y.clear();
            }
            this.X.remove(mediaPeriodImpl);
        }

        public long K(MediaPeriodImpl mediaPeriodImpl, long j2) {
            return ServerSideAdInsertionUtil.d(this.s.m(ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2)), mediaPeriodImpl.X, this.X2);
        }

        public long L(MediaPeriodImpl mediaPeriodImpl, ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            MediaPeriodImpl mediaPeriodImpl2 = mediaPeriodImpl;
            ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
            long j3 = j2;
            mediaPeriodImpl2.Y2 = j3;
            if (mediaPeriodImpl.equals(this.X.get(0))) {
                this.b3 = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr2.length);
                long g2 = ServerSideAdInsertionUtil.g(j3, mediaPeriodImpl2.X, this.X2);
                SampleStream[] sampleStreamArr2 = this.c3;
                SampleStream[] sampleStreamArr3 = sampleStreamArr2.length == 0 ? new SampleStream[exoTrackSelectionArr2.length] : (SampleStream[]) Arrays.copyOf(sampleStreamArr2, sampleStreamArr2.length);
                long n2 = this.s.n(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, g2);
                this.c3 = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
                this.d3 = (MediaLoadData[]) Arrays.copyOf(this.d3, sampleStreamArr3.length);
                for (int i2 = 0; i2 < sampleStreamArr3.length; i2++) {
                    if (sampleStreamArr3[i2] == null) {
                        sampleStreamArr[i2] = null;
                        this.d3[i2] = null;
                    } else if (sampleStreamArr[i2] == null || zArr2[i2]) {
                        sampleStreamArr[i2] = new SampleStreamImpl(mediaPeriodImpl, i2);
                        this.d3[i2] = null;
                    }
                }
                return ServerSideAdInsertionUtil.d(n2, mediaPeriodImpl2.X, this.X2);
            }
            for (int i3 = 0; i3 < exoTrackSelectionArr2.length; i3++) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i3];
                boolean z = true;
                if (exoTrackSelection != null) {
                    if (zArr[i3] && sampleStreamArr[i3] != null) {
                        z = false;
                    }
                    zArr2[i3] = z;
                    if (z) {
                        sampleStreamArr[i3] = Util.g(this.b3[i3], exoTrackSelection) ? new SampleStreamImpl(mediaPeriodImpl, i3) : new EmptySampleStream();
                    }
                } else {
                    sampleStreamArr[i3] = null;
                    zArr2[i3] = true;
                }
            }
            return j3;
        }

        public int M(MediaPeriodImpl mediaPeriodImpl, int i2, long j2) {
            return ((SampleStream) Util.o(this.c3[i2])).j(ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2));
        }

        public void N(AdPlaybackState adPlaybackState) {
            this.X2 = adPlaybackState;
        }

        public void e(MediaPeriodImpl mediaPeriodImpl) {
            this.X.add(mediaPeriodImpl);
        }

        public boolean f(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) Iterables.w(this.X);
            return ServerSideAdInsertionUtil.g(j2, mediaPeriodId, this.X2) == ServerSideAdInsertionUtil.g(ServerSideAdInsertionMediaSource.E0(mediaPeriodImpl, this.X2), mediaPeriodImpl.X, this.X2);
        }

        public boolean g(MediaPeriodImpl mediaPeriodImpl, LoadingInfo loadingInfo) {
            MediaPeriodImpl mediaPeriodImpl2 = this.Y2;
            if (mediaPeriodImpl2 != null && !mediaPeriodImpl.equals(mediaPeriodImpl2)) {
                for (Pair next : this.Y.values()) {
                    mediaPeriodImpl2.Y.u((LoadEventInfo) next.first, ServerSideAdInsertionMediaSource.C0(mediaPeriodImpl2, (MediaLoadData) next.second, this.X2));
                    mediaPeriodImpl.Y.A((LoadEventInfo) next.first, ServerSideAdInsertionMediaSource.C0(mediaPeriodImpl, (MediaLoadData) next.second, this.X2));
                }
            }
            this.Y2 = mediaPeriodImpl;
            return this.s.a(loadingInfo.a().f(s(mediaPeriodImpl, loadingInfo.f10228a)).d());
        }

        public void h(MediaPeriodImpl mediaPeriodImpl, long j2, boolean z) {
            this.s.t(ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2), z);
        }

        public void i(MediaPeriod mediaPeriod) {
            this.a3 = true;
            for (int i2 = 0; i2 < this.X.size(); i2++) {
                this.X.get(i2).b();
            }
        }

        public long l(MediaPeriodImpl mediaPeriodImpl, long j2, SeekParameters seekParameters) {
            return ServerSideAdInsertionUtil.d(this.s.f(ServerSideAdInsertionUtil.g(j2, mediaPeriodImpl.X, this.X2), seekParameters), mediaPeriodImpl.X, this.X2);
        }

        public long m(MediaPeriodImpl mediaPeriodImpl) {
            return p(mediaPeriodImpl, this.s.g());
        }

        @Nullable
        public MediaPeriodImpl n(@Nullable MediaLoadData mediaLoadData) {
            if (mediaLoadData == null || mediaLoadData.f12154f == C.f9084b) {
                return null;
            }
            for (int i2 = 0; i2 < this.X.size(); i2++) {
                MediaPeriodImpl mediaPeriodImpl = this.X.get(i2);
                if (mediaPeriodImpl.a3) {
                    long d2 = ServerSideAdInsertionUtil.d(Util.I1(mediaLoadData.f12154f), mediaPeriodImpl.X, this.X2);
                    long A0 = ServerSideAdInsertionMediaSource.E0(mediaPeriodImpl, this.X2);
                    if (d2 >= 0 && d2 < A0) {
                        return mediaPeriodImpl;
                    }
                }
            }
            return null;
        }

        public long q(MediaPeriodImpl mediaPeriodImpl) {
            return p(mediaPeriodImpl, this.s.e());
        }

        public List<StreamKey> r(List<ExoTrackSelection> list) {
            return this.s.k(list);
        }

        public TrackGroupArray t() {
            return this.s.s();
        }

        public boolean u(MediaPeriodImpl mediaPeriodImpl) {
            return mediaPeriodImpl.equals(this.Y2) && this.s.c();
        }

        public boolean v(int i2) {
            return ((SampleStream) Util.o(this.c3[i2])).d();
        }

        public boolean w() {
            return this.X.isEmpty();
        }

        public void y(int i2) throws IOException {
            ((SampleStream) Util.o(this.c3[i2])).b();
        }

        public void z() throws IOException {
            this.s.l();
        }
    }

    public ServerSideAdInsertionMediaSource(MediaSource mediaSource, @Nullable AdPlaybackStateUpdater adPlaybackStateUpdater) {
        this.a3 = mediaSource;
        this.e3 = adPlaybackStateUpdater;
    }

    /* access modifiers changed from: private */
    public static MediaLoadData C0(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.f12149a, mediaLoadData.f12150b, mediaLoadData.f12151c, mediaLoadData.f12152d, mediaLoadData.f12153e, D0(mediaLoadData.f12154f, mediaPeriodImpl, adPlaybackState), D0(mediaLoadData.f12155g, mediaPeriodImpl, adPlaybackState));
    }

    private static long D0(long j2, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        if (j2 == C.f9084b) {
            return C.f9084b;
        }
        long I1 = Util.I1(j2);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.X;
        return Util.H2(mediaPeriodId.c() ? ServerSideAdInsertionUtil.e(I1, mediaPeriodId.f12164b, mediaPeriodId.f12165c, adPlaybackState) : ServerSideAdInsertionUtil.f(I1, -1, adPlaybackState));
    }

    /* access modifiers changed from: private */
    public static long E0(MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.X;
        if (mediaPeriodId.c()) {
            AdPlaybackState.AdGroup f2 = adPlaybackState.f(mediaPeriodId.f12164b);
            if (f2.X == -1) {
                return 0;
            }
            return f2.Z2[mediaPeriodId.f12165c];
        }
        int i2 = mediaPeriodId.f12167e;
        if (i2 == -1) {
            return Long.MAX_VALUE;
        }
        long j2 = adPlaybackState.f(i2).s;
        if (j2 == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j2;
    }

    @Nullable
    private MediaPeriodImpl F0(@Nullable MediaSource.MediaPeriodId mediaPeriodId, @Nullable MediaLoadData mediaLoadData, boolean z) {
        if (mediaPeriodId == null) {
            return null;
        }
        List list = this.b3.get((Object) new Pair(Long.valueOf(mediaPeriodId.f12166d), mediaPeriodId.f12163a));
        if (list.isEmpty()) {
            return null;
        }
        if (z) {
            SharedMediaPeriod sharedMediaPeriod = (SharedMediaPeriod) Iterables.w(list);
            return sharedMediaPeriod.Y2 != null ? sharedMediaPeriod.Y2 : (MediaPeriodImpl) Iterables.w(sharedMediaPeriod.X);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaPeriodImpl n2 = ((SharedMediaPeriod) list.get(i2)).n(mediaLoadData);
            if (n2 != null) {
                return n2;
            }
        }
        return (MediaPeriodImpl) ((SharedMediaPeriod) list.get(0)).X.get(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(ImmutableMap immutableMap, Timeline timeline) {
        AdPlaybackState adPlaybackState;
        for (SharedMediaPeriod next : this.b3.values()) {
            AdPlaybackState adPlaybackState2 = (AdPlaybackState) immutableMap.get(next.Z);
            if (adPlaybackState2 != null) {
                next.N(adPlaybackState2);
            }
        }
        SharedMediaPeriod sharedMediaPeriod = this.g3;
        if (!(sharedMediaPeriod == null || (adPlaybackState = (AdPlaybackState) immutableMap.get(sharedMediaPeriod.Z)) == null)) {
            this.g3.N(adPlaybackState);
        }
        this.h3 = immutableMap;
        t0(new ServerSideAdInsertionTimeline(timeline, immutableMap));
    }

    private void H0() {
        SharedMediaPeriod sharedMediaPeriod = this.g3;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.I(this.a3);
            this.g3 = null;
        }
    }

    public void A(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, false);
        if (F0 == null) {
            this.c3.D(mediaLoadData);
        } else {
            F0.Y.D(C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))));
        }
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        SharedMediaPeriod sharedMediaPeriod;
        Pair pair = new Pair(Long.valueOf(mediaPeriodId.f12166d), mediaPeriodId.f12163a);
        SharedMediaPeriod sharedMediaPeriod2 = this.g3;
        boolean z = false;
        if (sharedMediaPeriod2 != null) {
            if (sharedMediaPeriod2.Z.equals(mediaPeriodId.f12163a)) {
                sharedMediaPeriod = this.g3;
                this.b3.put(pair, sharedMediaPeriod);
                z = true;
            } else {
                this.g3.I(this.a3);
                sharedMediaPeriod = null;
            }
            this.g3 = null;
        } else {
            sharedMediaPeriod = null;
        }
        if (sharedMediaPeriod == null && ((sharedMediaPeriod = (SharedMediaPeriod) Iterables.x(this.b3.get((Object) pair), null)) == null || !sharedMediaPeriod.f(mediaPeriodId, j2))) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.g(this.h3.get(mediaPeriodId.f12163a));
            SharedMediaPeriod sharedMediaPeriod3 = new SharedMediaPeriod(this.a3.E(new MediaSource.MediaPeriodId(mediaPeriodId.f12163a, mediaPeriodId.f12166d), allocator, ServerSideAdInsertionUtil.g(j2, mediaPeriodId, adPlaybackState)), mediaPeriodId.f12163a, adPlaybackState);
            this.b3.put(pair, sharedMediaPeriod3);
            sharedMediaPeriod = sharedMediaPeriod3;
        }
        MediaPeriodImpl mediaPeriodImpl = new MediaPeriodImpl(sharedMediaPeriod, mediaPeriodId, f0(mediaPeriodId), b0(mediaPeriodId));
        sharedMediaPeriod.e(mediaPeriodImpl);
        if (z && sharedMediaPeriod.b3.length > 0) {
            mediaPeriodImpl.m(j2);
        }
        return mediaPeriodImpl;
    }

    public MediaItem H() {
        return this.a3.H();
    }

    public void I() throws IOException {
        this.a3.I();
    }

    public void I0(ImmutableMap<Object, AdPlaybackState> immutableMap, Timeline timeline) {
        ImmutableMap<Object, AdPlaybackState> immutableMap2 = immutableMap;
        Assertions.a(!immutableMap.isEmpty());
        Object g2 = Assertions.g(immutableMap.values().b().get(0).s);
        UnmodifiableIterator<Map.Entry<Object, AdPlaybackState>> k2 = immutableMap.entrySet().iterator();
        while (k2.hasNext()) {
            Map.Entry next = k2.next();
            Object key = next.getKey();
            AdPlaybackState adPlaybackState = (AdPlaybackState) next.getValue();
            Assertions.a(Util.g(g2, adPlaybackState.s));
            AdPlaybackState adPlaybackState2 = this.h3.get(key);
            if (adPlaybackState2 != null) {
                for (int i2 = adPlaybackState.X2; i2 < adPlaybackState.X; i2++) {
                    AdPlaybackState.AdGroup f2 = adPlaybackState.f(i2);
                    Assertions.a(f2.b3);
                    if (i2 < adPlaybackState2.X && ServerSideAdInsertionUtil.c(adPlaybackState, i2) < ServerSideAdInsertionUtil.c(adPlaybackState2, i2)) {
                        AdPlaybackState.AdGroup f4 = adPlaybackState.f(i2 + 1);
                        Assertions.a(f2.a3 + f4.a3 == adPlaybackState2.f(i2).a3);
                        Assertions.a(f2.s + f2.a3 == f4.s);
                    }
                    if (f2.s == Long.MIN_VALUE) {
                        Assertions.a(ServerSideAdInsertionUtil.c(adPlaybackState, i2) == 0);
                    }
                }
            }
        }
        synchronized (this) {
            try {
                Handler handler = this.f3;
                if (handler == null) {
                    this.h3 = immutableMap2;
                } else {
                    handler.post(new g(this, immutableMap2, timeline));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void O(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, true);
        if (F0 == null) {
            this.c3.u(loadEventInfo, mediaLoadData);
            return;
        }
        F0.s.C(loadEventInfo);
        F0.Y.u(loadEventInfo, C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))));
    }

    public void Q(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, false);
        if (F0 == null) {
            this.c3.i(mediaLoadData);
            return;
        }
        F0.s.B(F0, mediaLoadData);
        F0.Y.i(C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))));
    }

    public void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, false);
        (F0 == null ? this.d3 : F0.Z).j();
    }

    public boolean S(MediaItem mediaItem) {
        return this.a3.S(mediaItem);
    }

    public void V(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, true);
        if (F0 == null) {
            this.c3.A(loadEventInfo, mediaLoadData);
            return;
        }
        F0.s.D(loadEventInfo, mediaLoadData);
        F0.Y.A(loadEventInfo, C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))));
    }

    public void W(MediaSource mediaSource, Timeline timeline) {
        AdPlaybackStateUpdater adPlaybackStateUpdater = this.e3;
        if ((adPlaybackStateUpdater == null || !adPlaybackStateUpdater.a(timeline)) && !this.h3.isEmpty()) {
            t0(new ServerSideAdInsertionTimeline(timeline, this.h3));
        }
    }

    public void X(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        mediaPeriodImpl.s.J(mediaPeriodImpl);
        if (mediaPeriodImpl.s.w()) {
            this.b3.remove(new Pair(Long.valueOf(mediaPeriodImpl.X.f12166d), mediaPeriodImpl.X.f12163a), mediaPeriodImpl.s);
            boolean isEmpty = this.b3.isEmpty();
            SharedMediaPeriod sharedMediaPeriod = mediaPeriodImpl.s;
            if (isEmpty) {
                this.g3 = sharedMediaPeriod;
            } else {
                sharedMediaPeriod.I(this.a3);
            }
        }
    }

    public void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, false);
        (F0 == null ? this.d3 : F0.Z).h();
    }

    /* access modifiers changed from: protected */
    public void h0() {
        H0();
        this.a3.D(this);
    }

    /* access modifiers changed from: protected */
    public void j0() {
        this.a3.e(this);
    }

    public void k(MediaItem mediaItem) {
        this.a3.k(mediaItem);
    }

    public void m0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, false);
        (F0 == null ? this.d3 : F0.Z).m();
    }

    public void o0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, true);
        (F0 == null ? this.d3 : F0.Z).k(i3);
    }

    public void q0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, true);
        if (F0 == null) {
            this.c3.x(loadEventInfo, mediaLoadData, iOException, z);
            return;
        }
        if (z) {
            F0.s.C(loadEventInfo);
        }
        F0.Y.x(loadEventInfo, C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))), iOException, z);
    }

    public /* synthetic */ void r0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        C0296j.d(this, i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        Handler H = Util.H();
        synchronized (this) {
            this.f3 = H;
        }
        this.a3.c(H, this);
        this.a3.P(H, this);
        this.a3.Y(this, transferListener, k0());
    }

    /* access modifiers changed from: protected */
    public void u0() {
        H0();
        synchronized (this) {
            this.f3 = null;
        }
        this.a3.x(this);
        this.a3.q(this);
        this.a3.U(this);
    }

    public void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, false);
        (F0 == null ? this.d3 : F0.Z).i();
    }

    public void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, (MediaLoadData) null, false);
        (F0 == null ? this.d3 : F0.Z).l(exc);
    }

    public void x0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl F0 = F0(mediaPeriodId, mediaLoadData, true);
        if (F0 == null) {
            this.c3.r(loadEventInfo, mediaLoadData);
            return;
        }
        F0.s.C(loadEventInfo);
        F0.Y.r(loadEventInfo, C0(F0, mediaLoadData, (AdPlaybackState) Assertions.g(this.h3.get(F0.X.f12163a))));
    }
}
