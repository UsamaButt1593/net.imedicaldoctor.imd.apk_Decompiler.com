package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final String h3 = "SingleSampleMediaPeriod";
    private static final int i3 = 1024;
    private final DataSource.Factory X;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher X2;
    @Nullable
    private final TransferListener Y;
    private final TrackGroupArray Y2;
    private final LoadErrorHandlingPolicy Z;
    private final ArrayList<SampleStreamImpl> Z2 = new ArrayList<>();
    private final long a3;
    final Loader b3 = new Loader(h3);
    final Format c3;
    final boolean d3;
    boolean e3;
    byte[] f3;
    int g3;
    private final DataSpec s;

    private final class SampleStreamImpl implements SampleStream {
        private static final int X2 = 1;
        private static final int Y2 = 2;
        private static final int Z = 0;
        private boolean X;
        private int s;

        private SampleStreamImpl() {
        }

        private void a() {
            if (!this.X) {
                SingleSampleMediaPeriod.this.X2.h(MimeTypes.l(SingleSampleMediaPeriod.this.c3.f3), SingleSampleMediaPeriod.this.c3, 0, (Object) null, 0);
                this.X = true;
            }
        }

        public void b() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.d3) {
                singleSampleMediaPeriod.b3.b();
            }
        }

        public void c() {
            if (this.s == 2) {
                this.s = 1;
            }
        }

        public boolean d() {
            return SingleSampleMediaPeriod.this.e3;
        }

        public int j(long j2) {
            a();
            if (j2 <= 0 || this.s == 2) {
                return 0;
            }
            this.s = 2;
            return 1;
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            a();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z = singleSampleMediaPeriod.e3;
            if (z && singleSampleMediaPeriod.f3 == null) {
                this.s = 2;
            }
            int i3 = this.s;
            if (i3 == 2) {
                decoderInputBuffer.f(4);
                return -4;
            } else if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f10226b = singleSampleMediaPeriod.c3;
                this.s = 1;
                return -5;
            } else if (!z) {
                return -3;
            } else {
                Assertions.g(singleSampleMediaPeriod.f3);
                decoderInputBuffer.f(1);
                decoderInputBuffer.Y2 = 0;
                if ((i2 & 4) == 0) {
                    decoderInputBuffer.r(SingleSampleMediaPeriod.this.g3);
                    ByteBuffer byteBuffer = decoderInputBuffer.Z;
                    SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                    byteBuffer.put(singleSampleMediaPeriod2.f3, 0, singleSampleMediaPeriod2.g3);
                }
                if ((i2 & 1) == 0) {
                    this.s = 2;
                }
                return -4;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {

        /* renamed from: a  reason: collision with root package name */
        public final long f12236a = LoadEventInfo.a();

        /* renamed from: b  reason: collision with root package name */
        public final DataSpec f12237b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final StatsDataSource f12238c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public byte[] f12239d;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            this.f12237b = dataSpec;
            this.f12238c = new StatsDataSource(dataSource);
        }

        public void a() throws IOException {
            this.f12238c.w();
            try {
                this.f12238c.a(this.f12237b);
                int i2 = 0;
                while (i2 != -1) {
                    int t = (int) this.f12238c.t();
                    byte[] bArr = this.f12239d;
                    if (bArr == null) {
                        this.f12239d = new byte[1024];
                    } else if (t == bArr.length) {
                        this.f12239d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.f12238c;
                    byte[] bArr2 = this.f12239d;
                    i2 = statsDataSource.read(bArr2, t, bArr2.length - t);
                }
                DataSourceUtil.a(this.f12238c);
            } catch (Throwable th) {
                DataSourceUtil.a(this.f12238c);
                throw th;
            }
        }

        public void c() {
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, @Nullable TransferListener transferListener, Format format, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.s = dataSpec;
        this.X = factory;
        this.Y = transferListener;
        this.c3 = format;
        this.a3 = j2;
        this.Z = loadErrorHandlingPolicy;
        this.X2 = eventDispatcher;
        this.d3 = z;
        this.Y2 = new TrackGroupArray(new TrackGroup(format));
    }

    public boolean a(LoadingInfo loadingInfo) {
        if (this.e3 || this.b3.k() || this.b3.j()) {
            return false;
        }
        DataSource a2 = this.X.a();
        TransferListener transferListener = this.Y;
        if (transferListener != null) {
            a2.e(transferListener);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.s, a2);
        this.X2.z(new LoadEventInfo(sourceLoadable.f12236a, this.s, this.b3.n(sourceLoadable, this, this.Z.c(1))), 1, -1, this.c3, 0, (Object) null, 0, this.a3);
        return true;
    }

    public boolean c() {
        return this.b3.k();
    }

    /* renamed from: d */
    public void Z(SourceLoadable sourceLoadable, long j2, long j3, boolean z) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        StatsDataSource b2 = sourceLoadable.f12238c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f12236a, sourceLoadable2.f12237b, b2.u(), b2.v(), j2, j3, b2.t());
        this.Z.b(sourceLoadable2.f12236a);
        this.X2.q(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, 0, this.a3);
    }

    public long e() {
        return (this.e3 || this.b3.k()) ? Long.MIN_VALUE : 0;
    }

    public long f(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public long g() {
        return this.e3 ? Long.MIN_VALUE : 0;
    }

    public void h(long j2) {
    }

    /* renamed from: i */
    public void N(SourceLoadable sourceLoadable, long j2, long j3) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.g3 = (int) sourceLoadable.f12238c.t();
        this.f3 = (byte[]) Assertions.g(sourceLoadable.f12239d);
        this.e3 = true;
        StatsDataSource b2 = sourceLoadable.f12238c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f12236a, sourceLoadable2.f12237b, b2.u(), b2.v(), j2, j3, (long) this.g3);
        this.Z.b(sourceLoadable2.f12236a);
        this.X2.t(loadEventInfo, 1, -1, this.c3, 0, (Object) null, 0, this.a3);
    }

    /* renamed from: j */
    public Loader.LoadErrorAction p(SourceLoadable sourceLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction i4;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        IOException iOException2 = iOException;
        int i5 = i2;
        StatsDataSource b2 = sourceLoadable.f12238c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.f12236a, sourceLoadable2.f12237b, b2.u(), b2.v(), j2, j3, b2.t());
        long a2 = this.Z.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.c3, 0, (Object) null, 0, Util.H2(this.a3)), iOException2, i5));
        int i6 = (a2 > C.f9084b ? 1 : (a2 == C.f9084b ? 0 : -1));
        boolean z = i6 == 0 || i5 >= this.Z.c(1);
        if (!this.d3 || !z) {
            i4 = i6 != 0 ? Loader.i(false, a2) : Loader.f12577l;
        } else {
            Log.o(h3, "Loading failed, treating as end-of-stream.", iOException2);
            this.e3 = true;
            i4 = Loader.f12576k;
        }
        Loader.LoadErrorAction loadErrorAction = i4;
        boolean z2 = !loadErrorAction.c();
        this.X2.v(loadEventInfo, 1, -1, this.c3, 0, (Object) null, 0, this.a3, iOException, z2);
        if (z2) {
            this.Z.b(sourceLoadable2.f12236a);
        }
        return loadErrorAction;
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    public void l() {
    }

    public long m(long j2) {
        for (int i2 = 0; i2 < this.Z2.size(); i2++) {
            this.Z2.get(i2).c();
        }
        return j2;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if (sampleStream != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                this.Z2.remove(sampleStream);
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.Z2.add(sampleStreamImpl);
                sampleStreamArr[i2] = sampleStreamImpl;
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    public void o() {
        this.b3.l();
    }

    public long q() {
        return C.f9084b;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        callback.i(this);
    }

    public TrackGroupArray s() {
        return this.Y2;
    }

    public void t(long j2, boolean z) {
    }
}
