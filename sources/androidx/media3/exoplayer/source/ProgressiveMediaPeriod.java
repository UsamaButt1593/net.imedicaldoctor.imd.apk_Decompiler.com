package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.IcyDataSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private static final long G3 = 10000;
    /* access modifiers changed from: private */
    public static final Map<String, String> H3 = L();
    /* access modifiers changed from: private */
    public static final Format I3 = new Format.Builder().X("icy").k0(MimeTypes.L0).I();
    private long A3;
    private long B3;
    private boolean C3;
    private int D3;
    private boolean E3;
    private boolean F3;
    private final DataSource X;
    private final MediaSourceEventListener.EventDispatcher X2;
    private final DrmSessionManager Y;
    private final DrmSessionEventListener.EventDispatcher Y2;
    private final LoadErrorHandlingPolicy Z;
    private final Listener Z2;
    private final Allocator a3;
    /* access modifiers changed from: private */
    @Nullable
    public final String b3;
    /* access modifiers changed from: private */
    public final long c3;
    private final Loader d3 = new Loader("ProgressiveMediaPeriod");
    private final ProgressiveMediaExtractor e3;
    private final ConditionVariable f3;
    private final Runnable g3;
    /* access modifiers changed from: private */
    public final Runnable h3;
    /* access modifiers changed from: private */
    public final Handler i3;
    private final boolean j3;
    @Nullable
    private MediaPeriod.Callback k3;
    /* access modifiers changed from: private */
    @Nullable
    public IcyHeaders l3;
    private SampleQueue[] m3;
    private TrackId[] n3;
    private boolean o3;
    private boolean p3;
    private boolean q3;
    private TrackState r3;
    private final Uri s;
    private SeekMap s3;
    /* access modifiers changed from: private */
    public long t3;
    private boolean u3;
    private int v3;
    private boolean w3;
    private boolean x3;
    private int y3;
    private boolean z3;

    final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final long f12177a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        private final Uri f12178b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f12179c;

        /* renamed from: d  reason: collision with root package name */
        private final ProgressiveMediaExtractor f12180d;

        /* renamed from: e  reason: collision with root package name */
        private final ExtractorOutput f12181e;

        /* renamed from: f  reason: collision with root package name */
        private final ConditionVariable f12182f;

        /* renamed from: g  reason: collision with root package name */
        private final PositionHolder f12183g = new PositionHolder();

        /* renamed from: h  reason: collision with root package name */
        private volatile boolean f12184h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f12185i = true;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public long f12186j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public DataSpec f12187k = i(0);
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private TrackOutput f12188l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f12189m;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
            this.f12178b = uri;
            this.f12179c = new StatsDataSource(dataSource);
            this.f12180d = progressiveMediaExtractor;
            this.f12181e = extractorOutput;
            this.f12182f = conditionVariable;
        }

        private DataSpec i(long j2) {
            return new DataSpec.Builder().j(this.f12178b).i(j2).g(ProgressiveMediaPeriod.this.b3).c(6).f(ProgressiveMediaPeriod.H3).a();
        }

        /* access modifiers changed from: private */
        public void j(long j2, long j3) {
            this.f12183g.f13111a = j2;
            this.f12186j = j3;
            this.f12185i = true;
            this.f12189m = false;
        }

        public void a() throws IOException {
            int i2 = 0;
            while (i2 == 0 && !this.f12184h) {
                try {
                    long j2 = this.f12183g.f13111a;
                    DataSpec i3 = i(j2);
                    this.f12187k = i3;
                    long a2 = this.f12179c.a(i3);
                    if (this.f12184h) {
                        if (!(i2 == 1 || this.f12180d.d() == -1)) {
                            this.f12183g.f13111a = this.f12180d.d();
                        }
                        DataSourceUtil.a(this.f12179c);
                        return;
                    }
                    if (a2 != -1) {
                        a2 += j2;
                        ProgressiveMediaPeriod.this.b0();
                    }
                    long j3 = a2;
                    IcyHeaders unused = ProgressiveMediaPeriod.this.l3 = IcyHeaders.a(this.f12179c.getResponseHeaders());
                    DataReader dataReader = this.f12179c;
                    if (!(ProgressiveMediaPeriod.this.l3 == null || ProgressiveMediaPeriod.this.l3.Y2 == -1)) {
                        dataReader = new IcyDataSource(this.f12179c, ProgressiveMediaPeriod.this.l3.Y2, this);
                        TrackOutput P = ProgressiveMediaPeriod.this.P();
                        this.f12188l = P;
                        P.e(ProgressiveMediaPeriod.I3);
                    }
                    long j4 = j2;
                    this.f12180d.g(dataReader, this.f12178b, this.f12179c.getResponseHeaders(), j2, j3, this.f12181e);
                    if (ProgressiveMediaPeriod.this.l3 != null) {
                        this.f12180d.e();
                    }
                    if (this.f12185i) {
                        this.f12180d.c(j4, this.f12186j);
                        this.f12185i = false;
                    }
                    while (true) {
                        long j5 = j4;
                        while (i2 == 0 && !this.f12184h) {
                            this.f12182f.a();
                            i2 = this.f12180d.f(this.f12183g);
                            j4 = this.f12180d.d();
                            if (j4 > ProgressiveMediaPeriod.this.c3 + j5) {
                                this.f12182f.d();
                                ProgressiveMediaPeriod.this.i3.post(ProgressiveMediaPeriod.this.h3);
                            }
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else if (this.f12180d.d() != -1) {
                        this.f12183g.f13111a = this.f12180d.d();
                    }
                    DataSourceUtil.a(this.f12179c);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th) {
                    if (!(i2 == 1 || this.f12180d.d() == -1)) {
                        this.f12183g.f13111a = this.f12180d.d();
                    }
                    DataSourceUtil.a(this.f12179c);
                    throw th;
                }
            }
        }

        public void b(ParsableByteArray parsableByteArray) {
            long max = !this.f12189m ? this.f12186j : Math.max(ProgressiveMediaPeriod.this.O(true), this.f12186j);
            int a2 = parsableByteArray.a();
            TrackOutput trackOutput = (TrackOutput) Assertions.g(this.f12188l);
            trackOutput.d(parsableByteArray, a2);
            trackOutput.f(max, 1, a2, 0, (TrackOutput.CryptoData) null);
            this.f12189m = true;
        }

        public void c() {
            this.f12184h = true;
        }
    }

    interface Listener {
        void F(long j2, boolean z, boolean z2);
    }

    private final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */
        public final int s;

        public SampleStreamImpl(int i2) {
            this.s = i2;
        }

        public void b() throws IOException {
            ProgressiveMediaPeriod.this.a0(this.s);
        }

        public boolean d() {
            return ProgressiveMediaPeriod.this.R(this.s);
        }

        public int j(long j2) {
            return ProgressiveMediaPeriod.this.k0(this.s, j2);
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            return ProgressiveMediaPeriod.this.g0(this.s, formatHolder, decoderInputBuffer, i2);
        }
    }

    private static final class TrackId {

        /* renamed from: a  reason: collision with root package name */
        public final int f12191a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f12192b;

        public TrackId(int i2, boolean z) {
            this.f12191a = i2;
            this.f12192b = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            return this.f12191a == trackId.f12191a && this.f12192b == trackId.f12192b;
        }

        public int hashCode() {
            return (this.f12191a * 31) + (this.f12192b ? 1 : 0);
        }
    }

    private static final class TrackState {

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroupArray f12193a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f12194b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f12195c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f12196d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f12193a = trackGroupArray;
            this.f12194b = zArr;
            int i2 = trackGroupArray.s;
            this.f12195c = new boolean[i2];
            this.f12196d = new boolean[i2];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener, Allocator allocator, @Nullable String str, int i2, long j2) {
        this.s = uri;
        this.X = dataSource;
        this.Y = drmSessionManager;
        this.Y2 = eventDispatcher;
        this.Z = loadErrorHandlingPolicy;
        this.X2 = eventDispatcher2;
        this.Z2 = listener;
        this.a3 = allocator;
        this.b3 = str;
        this.c3 = (long) i2;
        this.e3 = progressiveMediaExtractor;
        this.t3 = j2;
        this.j3 = j2 != C.f9084b;
        this.f3 = new ConditionVariable();
        this.g3 = new z(this);
        this.h3 = new A(this);
        this.i3 = Util.H();
        this.n3 = new TrackId[0];
        this.m3 = new SampleQueue[0];
        this.B3 = C.f9084b;
        this.v3 = 1;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void J() {
        Assertions.i(this.p3);
        Assertions.g(this.r3);
        Assertions.g(this.s3);
    }

    private boolean K(ExtractingLoadable extractingLoadable, int i2) {
        SeekMap seekMap;
        if (this.z3 || !((seekMap = this.s3) == null || seekMap.l() == C.f9084b)) {
            this.D3 = i2;
            return true;
        }
        if (!this.p3 || m0()) {
            this.x3 = this.p3;
            this.A3 = 0;
            this.D3 = 0;
            for (SampleQueue Y3 : this.m3) {
                Y3.Y();
            }
            extractingLoadable.j(0, 0);
            return true;
        }
        this.C3 = true;
        return false;
    }

    private static Map<String, String> L() {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.Z2, IcyHeaders.a3);
        return Collections.unmodifiableMap(hashMap);
    }

    private int M() {
        int i2 = 0;
        for (SampleQueue J : this.m3) {
            i2 += J.J();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public long O(boolean z) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < this.m3.length; i2++) {
            if (z || ((TrackState) Assertions.g(this.r3)).f12195c[i2]) {
                j2 = Math.max(j2, this.m3[i2].C());
            }
        }
        return j2;
    }

    private boolean Q() {
        return this.B3 != C.f9084b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S() {
        if (!this.F3) {
            ((MediaPeriod.Callback) Assertions.g(this.k3)).j(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.z3 = true;
    }

    /* access modifiers changed from: private */
    public void V() {
        if (!this.F3 && !this.p3 && this.o3 && this.s3 != null) {
            SampleQueue[] sampleQueueArr = this.m3;
            int length = sampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (sampleQueueArr[i2].I() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.f3.d();
            int length2 = this.m3.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length2];
            boolean[] zArr = new boolean[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                Format format = (Format) Assertions.g(this.m3[i4].I());
                String str = format.f3;
                boolean p = MimeTypes.p(str);
                boolean z = p || MimeTypes.t(str);
                zArr[i4] = z;
                this.q3 = z | this.q3;
                IcyHeaders icyHeaders = this.l3;
                if (icyHeaders != null) {
                    if (p || this.n3[i4].f12192b) {
                        Metadata metadata = format.d3;
                        format = format.c().d0(metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders)).I();
                    }
                    if (p && format.Z2 == -1 && format.a3 == -1 && icyHeaders.s != -1) {
                        format = format.c().K(icyHeaders.s).I();
                    }
                }
                trackGroupArr[i4] = new TrackGroup(Integer.toString(i4), format.d(this.Y.d(format)));
            }
            this.r3 = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            this.p3 = true;
            ((MediaPeriod.Callback) Assertions.g(this.k3)).i(this);
        }
    }

    private void W(int i2) {
        J();
        TrackState trackState = this.r3;
        boolean[] zArr = trackState.f12196d;
        if (!zArr[i2]) {
            Format d2 = trackState.f12193a.d(i2).d(0);
            this.X2.h(MimeTypes.l(d2.f3), d2, 0, (Object) null, this.A3);
            zArr[i2] = true;
        }
    }

    private void X(int i2) {
        J();
        boolean[] zArr = this.r3.f12194b;
        if (this.C3 && zArr[i2]) {
            if (!this.m3[i2].N(false)) {
                this.B3 = 0;
                this.C3 = false;
                this.x3 = true;
                this.A3 = 0;
                this.D3 = 0;
                for (SampleQueue Y3 : this.m3) {
                    Y3.Y();
                }
                ((MediaPeriod.Callback) Assertions.g(this.k3)).j(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b0() {
        this.i3.post(new y(this));
    }

    private TrackOutput f0(TrackId trackId) {
        int length = this.m3.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (trackId.equals(this.n3[i2])) {
                return this.m3[i2];
            }
        }
        SampleQueue l2 = SampleQueue.l(this.a3, this.Y, this.Y2);
        l2.g0(this);
        int i4 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.n3, i4);
        trackIdArr[length] = trackId;
        this.n3 = (TrackId[]) Util.p(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.m3, i4);
        sampleQueueArr[length] = l2;
        this.m3 = (SampleQueue[]) Util.p(sampleQueueArr);
        return l2;
    }

    private boolean i0(boolean[] zArr, long j2) {
        int length = this.m3.length;
        for (int i2 = 0; i2 < length; i2++) {
            SampleQueue sampleQueue = this.m3[i2];
            if (!(this.j3 ? sampleQueue.b0(sampleQueue.A()) : sampleQueue.c0(j2, false)) && (zArr[i2] || !this.q3)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j0 */
    public void U(SeekMap seekMap) {
        this.s3 = this.l3 == null ? seekMap : new SeekMap.Unseekable(C.f9084b);
        if (seekMap.l() == C.f9084b && this.t3 != C.f9084b) {
            this.s3 = new ForwardingSeekMap(this.s3) {
                public long l() {
                    return ProgressiveMediaPeriod.this.t3;
                }
            };
        }
        this.t3 = this.s3.l();
        int i2 = 1;
        boolean z = !this.z3 && seekMap.l() == C.f9084b;
        this.u3 = z;
        if (z) {
            i2 = 7;
        }
        this.v3 = i2;
        this.Z2.F(this.t3, seekMap.g(), this.u3);
        if (!this.p3) {
            V();
        }
    }

    private void l0() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.s, this.X, this.e3, this, this.f3);
        if (this.p3) {
            Assertions.i(Q());
            long j2 = this.t3;
            if (j2 == C.f9084b || this.B3 <= j2) {
                extractingLoadable.j(((SeekMap) Assertions.g(this.s3)).j(this.B3).f13112a.f13118b, this.B3);
                for (SampleQueue e0 : this.m3) {
                    e0.e0(this.B3);
                }
                this.B3 = C.f9084b;
            } else {
                this.E3 = true;
                this.B3 = C.f9084b;
                return;
            }
        }
        this.D3 = M();
        this.X2.z(new LoadEventInfo(extractingLoadable.f12177a, extractingLoadable.f12187k, this.d3.n(extractingLoadable, this, this.Z.c(this.v3))), 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f12186j, this.t3);
    }

    private boolean m0() {
        return this.x3 || Q();
    }

    /* access modifiers changed from: package-private */
    public TrackOutput P() {
        return f0(new TrackId(0, true));
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i2) {
        return !m0() && this.m3[i2].N(this.E3);
    }

    /* access modifiers changed from: package-private */
    public void Y() throws IOException {
        this.d3.a(this.Z.c(this.v3));
    }

    public boolean a(LoadingInfo loadingInfo) {
        if (this.E3 || this.d3.j() || this.C3) {
            return false;
        }
        if (this.p3 && this.y3 == 0) {
            return false;
        }
        boolean f2 = this.f3.f();
        if (this.d3.k()) {
            return f2;
        }
        l0();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a0(int i2) throws IOException {
        this.m3[i2].Q();
        Y();
    }

    public void b(Format format) {
        this.i3.post(this.g3);
    }

    public boolean c() {
        return this.d3.k() && this.f3.e();
    }

    /* renamed from: c0 */
    public void Z(ExtractingLoadable extractingLoadable, long j2, long j4, boolean z) {
        StatsDataSource d2 = extractingLoadable.f12179c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f12177a, extractingLoadable.f12187k, d2.u(), d2.v(), j2, j4, d2.t());
        this.Z.b(extractingLoadable.f12177a);
        this.X2.q(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f12186j, this.t3);
        if (!z) {
            for (SampleQueue Y3 : this.m3) {
                Y3.Y();
            }
            if (this.y3 > 0) {
                ((MediaPeriod.Callback) Assertions.g(this.k3)).j(this);
            }
        }
    }

    public TrackOutput d(int i2, int i4) {
        return f0(new TrackId(i2, false));
    }

    /* renamed from: d0 */
    public void N(ExtractingLoadable extractingLoadable, long j2, long j4) {
        SeekMap seekMap;
        if (this.t3 == C.f9084b && (seekMap = this.s3) != null) {
            boolean g2 = seekMap.g();
            long O = O(true);
            long j5 = O == Long.MIN_VALUE ? 0 : O + G3;
            this.t3 = j5;
            this.Z2.F(j5, g2, this.u3);
        }
        StatsDataSource d2 = extractingLoadable.f12179c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f12177a, extractingLoadable.f12187k, d2.u(), d2.v(), j2, j4, d2.t());
        this.Z.b(extractingLoadable.f12177a);
        this.X2.t(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f12186j, this.t3);
        this.E3 = true;
        ((MediaPeriod.Callback) Assertions.g(this.k3)).j(this);
    }

    public long e() {
        return g();
    }

    /* renamed from: e0 */
    public Loader.LoadErrorAction p(ExtractingLoadable extractingLoadable, long j2, long j4, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2;
        boolean z;
        StatsDataSource d2 = extractingLoadable.f12179c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.f12177a, extractingLoadable.f12187k, d2.u(), d2.v(), j2, j4, d2.t());
        long a2 = this.Z.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, (Format) null, 0, (Object) null, Util.H2(extractingLoadable.f12186j), Util.H2(this.t3)), iOException, i2));
        if (a2 == C.f9084b) {
            loadErrorAction = Loader.f12577l;
            ExtractingLoadable extractingLoadable3 = extractingLoadable;
        } else {
            int M = M();
            if (M > this.D3) {
                extractingLoadable2 = extractingLoadable;
                z = true;
            } else {
                z = false;
                extractingLoadable2 = extractingLoadable;
            }
            loadErrorAction = K(extractingLoadable2, M) ? Loader.i(z, a2) : Loader.f12576k;
        }
        boolean z2 = !loadErrorAction.c();
        this.X2.v(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.f12186j, this.t3, iOException, z2);
        if (z2) {
            this.Z.b(extractingLoadable.f12177a);
        }
        return loadErrorAction;
    }

    public long f(long j2, SeekParameters seekParameters) {
        J();
        if (!this.s3.g()) {
            return 0;
        }
        SeekMap.SeekPoints j4 = this.s3.j(j2);
        return seekParameters.a(j2, j4.f13112a.f13117a, j4.f13113b.f13117a);
    }

    public long g() {
        long j2;
        J();
        if (this.E3 || this.y3 == 0) {
            return Long.MIN_VALUE;
        }
        if (Q()) {
            return this.B3;
        }
        if (this.q3) {
            int length = this.m3.length;
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < length; i2++) {
                TrackState trackState = this.r3;
                if (trackState.f12194b[i2] && trackState.f12195c[i2] && !this.m3[i2].M()) {
                    j2 = Math.min(j2, this.m3[i2].C());
                }
            }
        } else {
            j2 = Long.MAX_VALUE;
        }
        if (j2 == Long.MAX_VALUE) {
            j2 = O(false);
        }
        return j2 == Long.MIN_VALUE ? this.A3 : j2;
    }

    /* access modifiers changed from: package-private */
    public int g0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i4) {
        if (m0()) {
            return -3;
        }
        W(i2);
        int V = this.m3[i2].V(formatHolder, decoderInputBuffer, i4, this.E3);
        if (V == -3) {
            X(i2);
        }
        return V;
    }

    public void h(long j2) {
    }

    public void h0() {
        if (this.p3) {
            for (SampleQueue U : this.m3) {
                U.U();
            }
        }
        this.d3.m(this);
        this.i3.removeCallbacksAndMessages((Object) null);
        this.k3 = null;
        this.F3 = true;
    }

    public void i() {
        for (SampleQueue W : this.m3) {
            W.W();
        }
        this.e3.a();
    }

    public void j(SeekMap seekMap) {
        this.i3.post(new B(this, seekMap));
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    /* access modifiers changed from: package-private */
    public int k0(int i2, long j2) {
        if (m0()) {
            return 0;
        }
        W(i2);
        SampleQueue sampleQueue = this.m3[i2];
        int H = sampleQueue.H(j2, this.E3);
        sampleQueue.h0(H);
        if (H == 0) {
            X(i2);
        }
        return H;
    }

    public void l() throws IOException {
        Y();
        if (this.E3 && !this.p3) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public long m(long j2) {
        J();
        boolean[] zArr = this.r3.f12194b;
        if (!this.s3.g()) {
            j2 = 0;
        }
        int i2 = 0;
        this.x3 = false;
        this.A3 = j2;
        if (Q()) {
            this.B3 = j2;
            return j2;
        } else if (this.v3 != 7 && i0(zArr, j2)) {
            return j2;
        } else {
            this.C3 = false;
            this.B3 = j2;
            this.E3 = false;
            if (this.d3.k()) {
                SampleQueue[] sampleQueueArr = this.m3;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].s();
                    i2++;
                }
                this.d3.g();
            } else {
                this.d3.h();
                SampleQueue[] sampleQueueArr2 = this.m3;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].Y();
                    i2++;
                }
            }
            return j2;
        }
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ExoTrackSelection exoTrackSelection;
        J();
        TrackState trackState = this.r3;
        TrackGroupArray trackGroupArray = trackState.f12193a;
        boolean[] zArr3 = trackState.f12195c;
        int i2 = this.y3;
        int i4 = 0;
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            SampleStreamImpl sampleStreamImpl = sampleStreamArr[i5];
            if (sampleStreamImpl != null && (exoTrackSelectionArr[i5] == null || !zArr[i5])) {
                int a2 = sampleStreamImpl.s;
                Assertions.i(zArr3[a2]);
                this.y3--;
                zArr3[a2] = false;
                sampleStreamArr[i5] = null;
            }
        }
        boolean z = !this.j3 && (!this.w3 ? j2 != 0 : i2 == 0);
        for (int i6 = 0; i6 < exoTrackSelectionArr.length; i6++) {
            if (sampleStreamArr[i6] == null && (exoTrackSelection = exoTrackSelectionArr[i6]) != null) {
                Assertions.i(exoTrackSelection.length() == 1);
                Assertions.i(exoTrackSelection.k(0) == 0);
                int f2 = trackGroupArray.f(exoTrackSelection.d());
                Assertions.i(!zArr3[f2]);
                this.y3++;
                zArr3[f2] = true;
                sampleStreamArr[i6] = new SampleStreamImpl(f2);
                zArr2[i6] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.m3[f2];
                    z = sampleQueue.F() != 0 && !sampleQueue.c0(j2, true);
                }
            }
        }
        if (this.y3 == 0) {
            this.C3 = false;
            this.x3 = false;
            if (this.d3.k()) {
                SampleQueue[] sampleQueueArr = this.m3;
                int length = sampleQueueArr.length;
                while (i4 < length) {
                    sampleQueueArr[i4].s();
                    i4++;
                }
                this.d3.g();
            } else {
                SampleQueue[] sampleQueueArr2 = this.m3;
                int length2 = sampleQueueArr2.length;
                while (i4 < length2) {
                    sampleQueueArr2[i4].Y();
                    i4++;
                }
            }
        } else if (z) {
            j2 = m(j2);
            while (i4 < sampleStreamArr.length) {
                if (sampleStreamArr[i4] != null) {
                    zArr2[i4] = true;
                }
                i4++;
            }
        }
        this.w3 = true;
        return j2;
    }

    public void o() {
        this.o3 = true;
        this.i3.post(this.g3);
    }

    public long q() {
        if (!this.x3) {
            return C.f9084b;
        }
        if (!this.E3 && M() <= this.D3) {
            return C.f9084b;
        }
        this.x3 = false;
        return this.A3;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.k3 = callback;
        this.f3.f();
        l0();
    }

    public TrackGroupArray s() {
        J();
        return this.r3.f12193a;
    }

    public void t(long j2, boolean z) {
        if (!this.j3) {
            J();
            if (!Q()) {
                boolean[] zArr = this.r3.f12195c;
                int length = this.m3.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.m3[i2].r(j2, z, zArr[i2]);
                }
            }
        }
    }
}
