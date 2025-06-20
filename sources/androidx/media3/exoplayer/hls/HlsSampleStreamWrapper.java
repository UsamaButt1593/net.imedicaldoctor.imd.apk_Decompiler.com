package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsChunkSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final String R3 = "HlsSampleStreamWrapper";
    public static final int S3 = -1;
    public static final int T3 = -2;
    public static final int U3 = -3;
    private static final Set<Integer> V3 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    private boolean A3;
    private TrackGroupArray B3;
    private Set<TrackGroup> C3;
    private int[] D3;
    private int E3;
    private boolean F3;
    private boolean[] G3;
    private boolean[] H3;
    private long I3;
    private long J3;
    private boolean K3;
    private boolean L3;
    private boolean M3;
    private boolean N3;
    private long O3;
    @Nullable
    private DrmInitData P3;
    @Nullable
    private HlsMediaChunk Q3;
    private final int X;
    private final Allocator X2;
    private final Callback Y;
    @Nullable
    private final Format Y2;
    private final HlsChunkSource Z;
    private final DrmSessionManager Z2;
    private final DrmSessionEventListener.EventDispatcher a3;
    private final LoadErrorHandlingPolicy b3;
    private final Loader c3 = new Loader("Loader:HlsSampleStreamWrapper");
    private final MediaSourceEventListener.EventDispatcher d3;
    private final int e3;
    private final HlsChunkSource.HlsChunkHolder f3 = new HlsChunkSource.HlsChunkHolder();
    private final ArrayList<HlsMediaChunk> g3;
    private final List<HlsMediaChunk> h3;
    private final Runnable i3;
    private final Runnable j3;
    private final Handler k3;
    private final ArrayList<HlsSampleStream> l3;
    private final Map<String, DrmInitData> m3;
    @Nullable
    private Chunk n3;
    private HlsSampleQueue[] o3;
    private int[] p3 = new int[0];
    private Set<Integer> q3;
    private SparseIntArray r3;
    private final String s;
    private TrackOutput s3;
    private int t3;
    private int u3;
    private boolean v3;
    private boolean w3;
    private int x3;
    private Format y3;
    @Nullable
    private Format z3;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void b();

        void o(Uri uri);
    }

    private static class EmsgUnwrappingTrackOutput implements TrackOutput {

        /* renamed from: j  reason: collision with root package name */
        private static final Format f11427j = new Format.Builder().k0(MimeTypes.v0).I();

        /* renamed from: k  reason: collision with root package name */
        private static final Format f11428k = new Format.Builder().k0(MimeTypes.I0).I();

        /* renamed from: d  reason: collision with root package name */
        private final EventMessageDecoder f11429d = new EventMessageDecoder();

        /* renamed from: e  reason: collision with root package name */
        private final TrackOutput f11430e;

        /* renamed from: f  reason: collision with root package name */
        private final Format f11431f;

        /* renamed from: g  reason: collision with root package name */
        private Format f11432g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f11433h;

        /* renamed from: i  reason: collision with root package name */
        private int f11434i;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i2) {
            Format format;
            this.f11430e = trackOutput;
            if (i2 == 1) {
                format = f11427j;
            } else if (i2 == 3) {
                format = f11428k;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: " + i2);
            }
            this.f11431f = format;
            this.f11433h = new byte[0];
            this.f11434i = 0;
        }

        private boolean g(EventMessage eventMessage) {
            Format n2 = eventMessage.n();
            return n2 != null && Util.g(this.f11431f.f3, n2.f3);
        }

        private void h(int i2) {
            byte[] bArr = this.f11433h;
            if (bArr.length < i2) {
                this.f11433h = Arrays.copyOf(bArr, i2 + (i2 / 2));
            }
        }

        private ParsableByteArray i(int i2, int i3) {
            int i4 = this.f11434i - i3;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f11433h, i4 - i2, i4));
            byte[] bArr = this.f11433h;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.f11434i = i3;
            return parsableByteArray;
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            h(this.f11434i + i2);
            parsableByteArray.n(this.f11433h, this.f11434i, i2);
            this.f11434i += i2;
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z) {
            return g.a(this, dataReader, i2, z);
        }

        public int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException {
            h(this.f11434i + i2);
            int read = dataReader.read(this.f11433h, this.f11434i, i2);
            if (read != -1) {
                this.f11434i += read;
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void e(Format format) {
            this.f11432g = format;
            this.f11430e.e(this.f11431f);
        }

        public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
            Assertions.g(this.f11432g);
            ParsableByteArray i5 = i(i3, i4);
            if (!Util.g(this.f11432g.f3, this.f11431f.f3)) {
                if (MimeTypes.I0.equals(this.f11432g.f3)) {
                    EventMessage c2 = this.f11429d.c(i5);
                    if (!g(c2)) {
                        Log.n(HlsSampleStreamWrapper.R3, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.f11431f.f3, c2.n()}));
                        return;
                    }
                    i5 = new ParsableByteArray((byte[]) Assertions.g(c2.J()));
                } else {
                    Log.n(HlsSampleStreamWrapper.R3, "Ignoring sample for unsupported format: " + this.f11432g.f3);
                    return;
                }
            }
            int a2 = i5.a();
            this.f11430e.d(i5, a2);
            this.f11430e.f(j2, i2, a2, i4, cryptoData);
        }
    }

    private static final class HlsSampleQueue extends SampleQueue {
        private final Map<String, DrmInitData> M;
        @Nullable
        private DrmInitData N;

        private HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.M = map;
        }

        @Nullable
        private Metadata k0(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int g2 = metadata.g();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= g2) {
                    i3 = -1;
                    break;
                }
                Metadata.Entry d2 = metadata.d(i3);
                if ((d2 instanceof PrivFrame) && HlsMediaChunk.N.equals(((PrivFrame) d2).X)) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return metadata;
            }
            if (g2 == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(g2 - 1)];
            while (i2 < g2) {
                if (i2 != i3) {
                    entryArr[i2 < i3 ? i2 : i2 - 1] = metadata.d(i2);
                }
                i2++;
            }
            return new Metadata(entryArr);
        }

        public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
            super.f(j2, i2, i3, i4, cryptoData);
        }

        public void l0(@Nullable DrmInitData drmInitData) {
            this.N = drmInitData;
            L();
        }

        public void m0(HlsMediaChunk hlsMediaChunk) {
            i0((long) hlsMediaChunk.f11411k);
        }

        public Format z(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.N;
            if (drmInitData2 == null) {
                drmInitData2 = format.i3;
            }
            if (!(drmInitData2 == null || (drmInitData = this.M.get(drmInitData2.Y)) == null)) {
                drmInitData2 = drmInitData;
            }
            Metadata k0 = k0(format.d3);
            if (!(drmInitData2 == format.i3 && k0 == format.d3)) {
                format = format.c().R(drmInitData2).d0(k0).I();
            }
            return super.z(format);
        }
    }

    public HlsSampleStreamWrapper(String str, int i2, Callback callback, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator, long j2, @Nullable Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i4) {
        this.s = str;
        this.X = i2;
        this.Y = callback;
        this.Z = hlsChunkSource;
        this.m3 = map;
        this.X2 = allocator;
        this.Y2 = format;
        this.Z2 = drmSessionManager;
        this.a3 = eventDispatcher;
        this.b3 = loadErrorHandlingPolicy;
        this.d3 = eventDispatcher2;
        this.e3 = i4;
        Set<Integer> set = V3;
        this.q3 = new HashSet(set.size());
        this.r3 = new SparseIntArray(set.size());
        this.o3 = new HlsSampleQueue[0];
        this.H3 = new boolean[0];
        this.G3 = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.g3 = arrayList;
        this.h3 = Collections.unmodifiableList(arrayList);
        this.l3 = new ArrayList<>();
        this.i3 = new c(this);
        this.j3 = new d(this);
        this.k3 = Util.H();
        this.I3 = j2;
        this.J3 = j2;
    }

    private static DummyTrackOutput B(int i2, int i4) {
        Log.n(R3, "Unmapped track with id " + i2 + " of type " + i4);
        return new DummyTrackOutput();
    }

    private SampleQueue C(int i2, int i4) {
        int length = this.o3.length;
        boolean z = true;
        if (!(i4 == 1 || i4 == 2)) {
            z = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.X2, this.Z2, this.a3, this.m3);
        hlsSampleQueue.e0(this.I3);
        if (z) {
            hlsSampleQueue.l0(this.P3);
        }
        hlsSampleQueue.d0(this.O3);
        HlsMediaChunk hlsMediaChunk = this.Q3;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.m0(hlsMediaChunk);
        }
        hlsSampleQueue.g0(this);
        int i5 = length + 1;
        int[] copyOf = Arrays.copyOf(this.p3, i5);
        this.p3 = copyOf;
        copyOf[length] = i2;
        this.o3 = (HlsSampleQueue[]) Util.M1(this.o3, hlsSampleQueue);
        boolean[] copyOf2 = Arrays.copyOf(this.H3, i5);
        this.H3 = copyOf2;
        copyOf2[length] = z;
        this.F3 |= z;
        this.q3.add(Integer.valueOf(i4));
        this.r3.append(i4, length);
        if (M(i4) > M(this.t3)) {
            this.u3 = length;
            this.t3 = i4;
        }
        this.G3 = Arrays.copyOf(this.G3, i5);
        return hlsSampleQueue;
    }

    private TrackGroupArray D(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.s];
            for (int i4 = 0; i4 < trackGroup.s; i4++) {
                Format d2 = trackGroup.d(i4);
                formatArr[i4] = d2.d(this.Z2.d(d2));
            }
            trackGroupArr[i2] = new TrackGroup(trackGroup.X, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static Format E(@Nullable Format format, Format format2, boolean z) {
        String str;
        String str2;
        if (format == null) {
            return format2;
        }
        int l2 = MimeTypes.l(format2.f3);
        if (Util.f0(format.c3, l2) == 1) {
            str2 = Util.g0(format.c3, l2);
            str = MimeTypes.g(str2);
        } else {
            str2 = MimeTypes.d(format.c3, format2.f3);
            str = format2.f3;
        }
        Format.Builder M = format2.c().X(format.s).Z(format.X).a0(format.Y).b0(format.Z).m0(format.X2).i0(format.Y2).K(z ? format.Z2 : -1).f0(z ? format.a3 : -1).M(str2);
        if (l2 == 2) {
            M.r0(format.k3).V(format.l3).U(format.m3);
        }
        if (str != null) {
            M.k0(str);
        }
        int i2 = format.s3;
        if (i2 != -1 && l2 == 1) {
            M.L(i2);
        }
        Metadata metadata = format.d3;
        if (metadata != null) {
            Metadata metadata2 = format2.d3;
            if (metadata2 != null) {
                metadata = metadata2.b(metadata);
            }
            M.d0(metadata);
        }
        return M.I();
    }

    private void F(int i2) {
        Assertions.i(!this.c3.k());
        while (true) {
            if (i2 >= this.g3.size()) {
                i2 = -1;
                break;
            } else if (z(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            long j2 = J().f12285h;
            HlsMediaChunk G = G(i2);
            if (this.g3.isEmpty()) {
                this.J3 = this.I3;
            } else {
                ((HlsMediaChunk) Iterables.w(this.g3)).o();
            }
            this.M3 = false;
            this.d3.C(this.t3, G.f12284g, j2);
        }
    }

    private HlsMediaChunk G(int i2) {
        HlsMediaChunk hlsMediaChunk = this.g3.get(i2);
        ArrayList<HlsMediaChunk> arrayList = this.g3;
        Util.Y1(arrayList, i2, arrayList.size());
        for (int i4 = 0; i4 < this.o3.length; i4++) {
            this.o3[i4].w(hlsMediaChunk.m(i4));
        }
        return hlsMediaChunk;
    }

    private boolean H(HlsMediaChunk hlsMediaChunk) {
        int i2 = hlsMediaChunk.f11411k;
        int length = this.o3.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.G3[i4] && this.o3[i4].T() == ((long) i2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean I(Format format, Format format2) {
        String str = format.f3;
        String str2 = format2.f3;
        int l2 = MimeTypes.l(str);
        if (l2 != 3) {
            return l2 == MimeTypes.l(str2);
        }
        if (!Util.g(str, str2)) {
            return false;
        }
        return (!MimeTypes.w0.equals(str) && !MimeTypes.x0.equals(str)) || format.x3 == format2.x3;
    }

    private HlsMediaChunk J() {
        ArrayList<HlsMediaChunk> arrayList = this.g3;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    private TrackOutput K(int i2, int i4) {
        Assertions.a(V3.contains(Integer.valueOf(i4)));
        int i5 = this.r3.get(i4, -1);
        if (i5 == -1) {
            return null;
        }
        if (this.q3.add(Integer.valueOf(i4))) {
            this.p3[i5] = i2;
        }
        return this.p3[i5] == i2 ? this.o3[i5] : B(i2, i4);
    }

    private static int M(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void O(HlsMediaChunk hlsMediaChunk) {
        this.Q3 = hlsMediaChunk;
        this.y3 = hlsMediaChunk.f12281d;
        this.J3 = C.f9084b;
        this.g3.add(hlsMediaChunk);
        ImmutableList.Builder r = ImmutableList.r();
        for (HlsSampleQueue J : this.o3) {
            r.g(Integer.valueOf(J.J()));
        }
        hlsMediaChunk.n(this, r.e());
        for (HlsSampleQueue hlsSampleQueue : this.o3) {
            hlsSampleQueue.m0(hlsMediaChunk);
            if (hlsMediaChunk.f11414n) {
                hlsSampleQueue.j0();
            }
        }
    }

    private static boolean P(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean Q() {
        return this.J3 != C.f9084b;
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void T() {
        int i2 = this.B3.s;
        int[] iArr = new int[i2];
        this.D3 = iArr;
        Arrays.fill(iArr, -1);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.o3;
                if (i5 >= hlsSampleQueueArr.length) {
                    break;
                } else if (I((Format) Assertions.k(hlsSampleQueueArr[i5].I()), this.B3.d(i4).d(0))) {
                    this.D3[i4] = i5;
                    break;
                } else {
                    i5++;
                }
            }
        }
        Iterator<HlsSampleStream> it2 = this.l3.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        if (!this.A3 && this.D3 == null && this.v3) {
            HlsSampleQueue[] hlsSampleQueueArr = this.o3;
            int length = hlsSampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (hlsSampleQueueArr[i2].I() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.B3 != null) {
                T();
                return;
            }
            y();
            n0();
            this.Y.b();
        }
    }

    /* access modifiers changed from: private */
    public void e0() {
        this.v3 = true;
        U();
    }

    private void i0() {
        for (HlsSampleQueue Z3 : this.o3) {
            Z3.Z(this.K3);
        }
        this.K3 = false;
    }

    private boolean j0(long j2, @Nullable HlsMediaChunk hlsMediaChunk) {
        int length = this.o3.length;
        for (int i2 = 0; i2 < length; i2++) {
            HlsSampleQueue hlsSampleQueue = this.o3[i2];
            if (!(hlsMediaChunk != null ? hlsSampleQueue.b0(hlsMediaChunk.m(i2)) : hlsSampleQueue.c0(j2, false)) && (this.H3[i2] || !this.F3)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void n0() {
        this.w3 = true;
    }

    private void s0(SampleStream[] sampleStreamArr) {
        this.l3.clear();
        for (HlsSampleStream hlsSampleStream : sampleStreamArr) {
            if (hlsSampleStream != null) {
                this.l3.add(hlsSampleStream);
            }
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void w() {
        Assertions.i(this.w3);
        Assertions.g(this.B3);
        Assertions.g(this.C3);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void y() {
        Format format;
        boolean z = true;
        int length = this.o3.length;
        int i2 = 0;
        int i4 = -2;
        int i5 = -1;
        while (true) {
            int i6 = 2;
            if (i2 >= length) {
                break;
            }
            String str = ((Format) Assertions.k(this.o3[i2].I())).f3;
            if (!MimeTypes.t(str)) {
                i6 = MimeTypes.p(str) ? 1 : MimeTypes.s(str) ? 3 : -2;
            }
            if (M(i6) > M(i4)) {
                i5 = i2;
                i4 = i6;
            } else if (i6 == i4 && i5 != -1) {
                i5 = -1;
            }
            i2++;
        }
        TrackGroup k2 = this.Z.k();
        int i7 = k2.s;
        this.E3 = -1;
        this.D3 = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            this.D3[i8] = i8;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        int i9 = 0;
        while (i9 < length) {
            Format format2 = (Format) Assertions.k(this.o3[i9].I());
            if (i9 == i5) {
                Format[] formatArr = new Format[i7];
                for (int i10 = 0; i10 < i7; i10++) {
                    Format d2 = k2.d(i10);
                    if (i4 == 1 && (format = this.Y2) != null) {
                        d2 = d2.n(format);
                    }
                    formatArr[i10] = i7 == 1 ? format2.n(d2) : E(d2, format2, true);
                }
                trackGroupArr[i9] = new TrackGroup(this.s, formatArr);
                this.E3 = i9;
            } else {
                Format format3 = (i4 != 2 || !MimeTypes.p(format2.f3)) ? null : this.Y2;
                StringBuilder sb = new StringBuilder();
                sb.append(this.s);
                sb.append(":muxed:");
                sb.append(i9 < i5 ? i9 : i9 - 1);
                trackGroupArr[i9] = new TrackGroup(sb.toString(), E(format3, format2, false));
            }
            i9++;
        }
        this.B3 = D(trackGroupArr);
        if (this.C3 != null) {
            z = false;
        }
        Assertions.i(z);
        this.C3 = Collections.emptySet();
    }

    private boolean z(int i2) {
        for (int i4 = i2; i4 < this.g3.size(); i4++) {
            if (this.g3.get(i4).f11414n) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = this.g3.get(i2);
        for (int i5 = 0; i5 < this.o3.length; i5++) {
            if (this.o3[i5].F() > hlsMediaChunk.m(i5)) {
                return false;
            }
        }
        return true;
    }

    public void A() {
        if (!this.w3) {
            a(new LoadingInfo.Builder().f(this.I3).d());
        }
    }

    public int L() {
        return this.E3;
    }

    public boolean R(int i2) {
        return !Q() && this.o3[i2].N(this.M3);
    }

    public boolean S() {
        return this.t3 == 2;
    }

    public void V() throws IOException {
        this.c3.b();
        this.Z.p();
    }

    public void W(int i2) throws IOException {
        V();
        this.o3[i2].Q();
    }

    /* renamed from: X */
    public void Z(Chunk chunk, long j2, long j4, boolean z) {
        Chunk chunk2 = chunk;
        this.n3 = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f12278a, chunk2.f12279b, chunk.f(), chunk.e(), j2, j4, chunk.b());
        this.b3.b(chunk2.f12278a);
        this.d3.q(loadEventInfo, chunk2.f12280c, this.X, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, chunk2.f12284g, chunk2.f12285h);
        if (!z) {
            if (Q() || this.x3 == 0) {
                i0();
            }
            if (this.x3 > 0) {
                this.Y.j(this);
            }
        }
    }

    /* renamed from: Y */
    public void N(Chunk chunk, long j2, long j4) {
        Chunk chunk2 = chunk;
        this.n3 = null;
        this.Z.r(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f12278a, chunk2.f12279b, chunk.f(), chunk.e(), j2, j4, chunk.b());
        this.b3.b(chunk2.f12278a);
        this.d3.t(loadEventInfo, chunk2.f12280c, this.X, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, chunk2.f12284g, chunk2.f12285h);
        if (!this.w3) {
            a(new LoadingInfo.Builder().f(this.I3).d());
        } else {
            this.Y.j(this);
        }
    }

    public boolean a(LoadingInfo loadingInfo) {
        List<HlsMediaChunk> list;
        long max;
        if (this.M3 || this.c3.k() || this.c3.j()) {
            return false;
        }
        if (Q()) {
            list = Collections.emptyList();
            max = this.J3;
            for (HlsSampleQueue e0 : this.o3) {
                e0.e0(this.J3);
            }
        } else {
            list = this.h3;
            HlsMediaChunk J = J();
            max = J.h() ? J.f12285h : Math.max(this.I3, J.f12284g);
        }
        List<HlsMediaChunk> list2 = list;
        long j2 = max;
        this.f3.a();
        this.Z.f(loadingInfo, j2, list2, this.w3 || !list2.isEmpty(), this.f3);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.f3;
        boolean z = hlsChunkHolder.f11398b;
        Chunk chunk = hlsChunkHolder.f11397a;
        Uri uri = hlsChunkHolder.f11399c;
        if (z) {
            this.J3 = C.f9084b;
            this.M3 = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.Y.o(uri);
            }
            return false;
        } else {
            if (P(chunk)) {
                O((HlsMediaChunk) chunk);
            }
            this.n3 = chunk;
            this.d3.z(new LoadEventInfo(chunk.f12278a, chunk.f12279b, this.c3.n(chunk, this, this.b3.c(chunk.f12280c))), chunk.f12280c, this.X, chunk.f12281d, chunk.f12282e, chunk.f12283f, chunk.f12284g, chunk.f12285h);
            return true;
        }
    }

    /* renamed from: a0 */
    public Loader.LoadErrorAction p(Chunk chunk, long j2, long j4, IOException iOException, int i2) {
        Loader.LoadErrorAction i4;
        int i5;
        Chunk chunk2 = chunk;
        IOException iOException2 = iOException;
        boolean P = P(chunk);
        if (P && !((HlsMediaChunk) chunk2).q() && (iOException2 instanceof HttpDataSource.InvalidResponseCodeException) && ((i5 = ((HttpDataSource.InvalidResponseCodeException) iOException2).a3) == 410 || i5 == 404)) {
            return Loader.f12574i;
        }
        long b2 = chunk.b();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f12278a, chunk2.f12279b, chunk.f(), chunk.e(), j2, j4, b2);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk2.f12280c, this.X, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, Util.H2(chunk2.f12284g), Util.H2(chunk2.f12285h)), iOException2, i2);
        LoadErrorHandlingPolicy.FallbackSelection d2 = this.b3.d(TrackSelectionUtil.c(this.Z.l()), loadErrorInfo);
        boolean z = false;
        boolean o = (d2 == null || d2.f12563a != 2) ? false : this.Z.o(chunk2, d2.f12564b);
        if (o) {
            if (P && b2 == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.g3;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z = true;
                }
                Assertions.i(z);
                if (this.g3.isEmpty()) {
                    this.J3 = this.I3;
                } else {
                    ((HlsMediaChunk) Iterables.w(this.g3)).o();
                }
            }
            i4 = Loader.f12576k;
        } else {
            long a2 = this.b3.a(loadErrorInfo);
            i4 = a2 != C.f9084b ? Loader.i(false, a2) : Loader.f12577l;
        }
        Loader.LoadErrorAction loadErrorAction = i4;
        boolean z2 = !loadErrorAction.c();
        this.d3.v(loadEventInfo, chunk2.f12280c, this.X, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, chunk2.f12284g, chunk2.f12285h, iOException, z2);
        if (z2) {
            this.n3 = null;
            this.b3.b(chunk2.f12278a);
        }
        if (o) {
            if (!this.w3) {
                a(new LoadingInfo.Builder().f(this.I3).d());
            } else {
                this.Y.j(this);
            }
        }
        return loadErrorAction;
    }

    public void b(Format format) {
        this.k3.post(this.i3);
    }

    public void b0() {
        this.q3.clear();
    }

    public boolean c() {
        return this.c3.k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r6 = r4.b3.d(androidx.media3.exoplayer.trackselection.TrackSelectionUtil.c(r4.Z.l()), r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c0(android.net.Uri r5, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy.LoadErrorInfo r6, boolean r7) {
        /*
            r4 = this;
            androidx.media3.exoplayer.hls.HlsChunkSource r0 = r4.Z
            boolean r0 = r0.q(r5)
            r1 = 1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 != 0) goto L_0x002b
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r7 = r4.b3
            androidx.media3.exoplayer.hls.HlsChunkSource r0 = r4.Z
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r0.l()
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$FallbackOptions r0 = androidx.media3.exoplayer.trackselection.TrackSelectionUtil.c(r0)
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$FallbackSelection r6 = r7.d(r0, r6)
            if (r6 == 0) goto L_0x002b
            int r7 = r6.f12563a
            r0 = 2
            if (r7 != r0) goto L_0x002b
            long r6 = r6.f12564b
            goto L_0x002c
        L_0x002b:
            r6 = r2
        L_0x002c:
            androidx.media3.exoplayer.hls.HlsChunkSource r0 = r4.Z
            boolean r5 = r0.s(r5, r6)
            if (r5 == 0) goto L_0x0039
            int r5 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.c0(android.net.Uri, androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo, boolean):boolean");
    }

    public TrackOutput d(int i2, int i4) {
        TrackOutput trackOutput;
        if (!V3.contains(Integer.valueOf(i4))) {
            int i5 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.o3;
                if (i5 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.p3[i5] == i2) {
                    trackOutput = trackOutputArr[i5];
                    break;
                } else {
                    i5++;
                }
            }
        } else {
            trackOutput = K(i2, i4);
        }
        if (trackOutput == null) {
            if (this.N3) {
                return B(i2, i4);
            }
            trackOutput = C(i2, i4);
        }
        if (i4 != 5) {
            return trackOutput;
        }
        if (this.s3 == null) {
            this.s3 = new EmsgUnwrappingTrackOutput(trackOutput, this.e3);
        }
        return this.s3;
    }

    public void d0() {
        if (!this.g3.isEmpty()) {
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.w(this.g3);
            int c2 = this.Z.c(hlsMediaChunk);
            if (c2 == 1) {
                hlsMediaChunk.v();
            } else if (c2 == 2 && !this.M3 && this.c3.k()) {
                this.c3.g();
            }
        }
    }

    public long e() {
        if (Q()) {
            return this.J3;
        }
        if (this.M3) {
            return Long.MIN_VALUE;
        }
        return J().f12285h;
    }

    public long f(long j2, SeekParameters seekParameters) {
        return this.Z.b(j2, seekParameters);
    }

    public void f0(TrackGroup[] trackGroupArr, int i2, int... iArr) {
        this.B3 = D(trackGroupArr);
        this.C3 = new HashSet();
        for (int d2 : iArr) {
            this.C3.add(this.B3.d(d2));
        }
        this.E3 = i2;
        Handler handler = this.k3;
        Callback callback = this.Y;
        Objects.requireNonNull(callback);
        handler.post(new e(callback));
        n0();
    }

    public long g() {
        if (this.M3) {
            return Long.MIN_VALUE;
        }
        if (Q()) {
            return this.J3;
        }
        long j2 = this.I3;
        HlsMediaChunk J = J();
        if (!J.h()) {
            if (this.g3.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.g3;
                J = arrayList.get(arrayList.size() - 2);
            } else {
                J = null;
            }
        }
        if (J != null) {
            j2 = Math.max(j2, J.f12285h);
        }
        if (this.v3) {
            for (HlsSampleQueue C : this.o3) {
                j2 = Math.max(j2, C.C());
            }
        }
        return j2;
    }

    public int g0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i4) {
        if (Q()) {
            return -3;
        }
        int i5 = 0;
        if (!this.g3.isEmpty()) {
            int i6 = 0;
            while (i6 < this.g3.size() - 1 && H(this.g3.get(i6))) {
                i6++;
            }
            Util.Y1(this.g3, 0, i6);
            HlsMediaChunk hlsMediaChunk = this.g3.get(0);
            Format format = hlsMediaChunk.f12281d;
            if (!format.equals(this.z3)) {
                this.d3.h(this.X, format, hlsMediaChunk.f12282e, hlsMediaChunk.f12283f, hlsMediaChunk.f12284g);
            }
            this.z3 = format;
        }
        if (!this.g3.isEmpty() && !this.g3.get(0).q()) {
            return -3;
        }
        int V = this.o3[i2].V(formatHolder, decoderInputBuffer, i4, this.M3);
        if (V == -5) {
            Format format2 = (Format) Assertions.g(formatHolder.f10226b);
            if (i2 == this.u3) {
                int d2 = Ints.d(this.o3[i2].T());
                while (i5 < this.g3.size() && this.g3.get(i5).f11411k != d2) {
                    i5++;
                }
                format2 = format2.n(i5 < this.g3.size() ? this.g3.get(i5).f12281d : (Format) Assertions.g(this.y3));
            }
            formatHolder.f10226b = format2;
        }
        return V;
    }

    public void h(long j2) {
        if (!this.c3.j() && !Q()) {
            if (this.c3.k()) {
                Assertions.g(this.n3);
                if (this.Z.x(j2, this.n3, this.h3)) {
                    this.c3.g();
                    return;
                }
                return;
            }
            int size = this.h3.size();
            while (size > 0 && this.Z.c(this.h3.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.h3.size()) {
                F(size);
            }
            int i2 = this.Z.i(j2, this.h3);
            if (i2 < this.g3.size()) {
                F(i2);
            }
        }
    }

    public void h0() {
        if (this.w3) {
            for (HlsSampleQueue U : this.o3) {
                U.U();
            }
        }
        this.c3.m(this);
        this.k3.removeCallbacksAndMessages((Object) null);
        this.A3 = true;
        this.l3.clear();
    }

    public void i() {
        for (HlsSampleQueue W : this.o3) {
            W.W();
        }
    }

    public void j(SeekMap seekMap) {
    }

    public boolean k0(long j2, boolean z) {
        HlsMediaChunk hlsMediaChunk;
        this.I3 = j2;
        if (Q()) {
            this.J3 = j2;
            return true;
        }
        if (this.Z.m()) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.g3.size()) {
                    break;
                }
                hlsMediaChunk = this.g3.get(i2);
                if (hlsMediaChunk.f12284g == j2) {
                    break;
                }
                i2++;
            }
        }
        hlsMediaChunk = null;
        if (this.v3 && !z && j0(j2, hlsMediaChunk)) {
            return false;
        }
        this.J3 = j2;
        this.M3 = false;
        this.g3.clear();
        if (this.c3.k()) {
            if (this.v3) {
                for (HlsSampleQueue s2 : this.o3) {
                    s2.s();
                }
            }
            this.c3.g();
        } else {
            this.c3.h();
            i0();
        }
        return true;
    }

    public void l() throws IOException {
        V();
        if (this.M3 && !this.w3) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0119, code lost:
        if (r18.n() != r0.Z.k().e(r1.f12281d)) goto L_0x011b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l0(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r20, boolean[] r21, androidx.media3.exoplayer.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.w()
            int r3 = r0.x3
            r14 = 0
            r4 = 0
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            androidx.media3.exoplayer.hls.HlsSampleStream r5 = (androidx.media3.exoplayer.hls.HlsSampleStream) r5
            if (r5 == 0) goto L_0x002c
            r7 = r1[r4]
            if (r7 == 0) goto L_0x0022
            boolean r7 = r21[r4]
            if (r7 != 0) goto L_0x002c
        L_0x0022:
            int r7 = r0.x3
            int r7 = r7 - r15
            r0.x3 = r7
            r5.e()
            r2[r4] = r6
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002f:
            if (r26 != 0) goto L_0x0041
            boolean r4 = r0.L3
            if (r4 == 0) goto L_0x0038
            if (r3 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r3 = r0.I3
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            androidx.media3.exoplayer.hls.HlsChunkSource r4 = r0.Z
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r4 = r4.l()
            r16 = r3
            r11 = r4
            r3 = 0
        L_0x004c:
            int r5 = r1.length
            if (r3 >= r5) goto L_0x009f
            r5 = r1[r3]
            if (r5 != 0) goto L_0x0054
            goto L_0x009c
        L_0x0054:
            androidx.media3.exoplayer.source.TrackGroupArray r7 = r0.B3
            androidx.media3.common.TrackGroup r8 = r5.d()
            int r7 = r7.f(r8)
            int r8 = r0.E3
            if (r7 != r8) goto L_0x0068
            androidx.media3.exoplayer.hls.HlsChunkSource r8 = r0.Z
            r8.w(r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x009c
            int r5 = r0.x3
            int r5 = r5 + r15
            r0.x3 = r5
            androidx.media3.exoplayer.hls.HlsSampleStream r5 = new androidx.media3.exoplayer.hls.HlsSampleStream
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r8 = r0.D3
            if (r8 == 0) goto L_0x009c
            r5.a()
            if (r16 != 0) goto L_0x009c
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r5 = r0.o3
            int[] r8 = r0.D3
            r7 = r8[r7]
            r5 = r5[r7]
            int r7 = r5.F()
            if (r7 == 0) goto L_0x0099
            boolean r5 = r5.c0(r12, r15)
            if (r5 != 0) goto L_0x0099
            r5 = 1
            goto L_0x009a
        L_0x0099:
            r5 = 0
        L_0x009a:
            r16 = r5
        L_0x009c:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x009f:
            int r1 = r0.x3
            if (r1 != 0) goto L_0x00d4
            androidx.media3.exoplayer.hls.HlsChunkSource r1 = r0.Z
            r1.t()
            r0.z3 = r6
            r0.K3 = r15
            java.util.ArrayList<androidx.media3.exoplayer.hls.HlsMediaChunk> r1 = r0.g3
            r1.clear()
            androidx.media3.exoplayer.upstream.Loader r1 = r0.c3
            boolean r1 = r1.k()
            if (r1 == 0) goto L_0x00d0
            boolean r1 = r0.v3
            if (r1 == 0) goto L_0x00ca
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r1 = r0.o3
            int r3 = r1.length
        L_0x00c0:
            if (r14 >= r3) goto L_0x00ca
            r4 = r1[r14]
            r4.s()
            int r14 = r14 + 1
            goto L_0x00c0
        L_0x00ca:
            androidx.media3.exoplayer.upstream.Loader r1 = r0.c3
            r1.g()
            goto L_0x0134
        L_0x00d0:
            r19.i0()
            goto L_0x0134
        L_0x00d4:
            java.util.ArrayList<androidx.media3.exoplayer.hls.HlsMediaChunk> r1 = r0.g3
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0121
            boolean r1 = androidx.media3.common.util.Util.g(r11, r4)
            if (r1 != 0) goto L_0x0121
            boolean r1 = r0.L3
            if (r1 != 0) goto L_0x011b
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ed
            long r3 = -r12
        L_0x00ed:
            r6 = r3
            androidx.media3.exoplayer.hls.HlsMediaChunk r1 = r19.J()
            androidx.media3.exoplayer.hls.HlsChunkSource r3 = r0.Z
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r17 = r3.a(r1, r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<androidx.media3.exoplayer.hls.HlsMediaChunk> r10 = r0.h3
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.m(r4, r6, r8, r10, r11)
            androidx.media3.exoplayer.hls.HlsChunkSource r3 = r0.Z
            androidx.media3.common.TrackGroup r3 = r3.k()
            androidx.media3.common.Format r1 = r1.f12281d
            int r1 = r3.e(r1)
            int r3 = r18.n()
            if (r3 == r1) goto L_0x0121
        L_0x011b:
            r0.K3 = r15
            r1 = 1
            r16 = 1
            goto L_0x0123
        L_0x0121:
            r1 = r26
        L_0x0123:
            if (r16 == 0) goto L_0x0134
            r0.k0(r12, r1)
        L_0x0128:
            int r1 = r2.length
            if (r14 >= r1) goto L_0x0134
            r1 = r2[r14]
            if (r1 == 0) goto L_0x0131
            r23[r14] = r15
        L_0x0131:
            int r14 = r14 + 1
            goto L_0x0128
        L_0x0134:
            r0.s0(r2)
            r0.L3 = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.l0(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void m0(@Nullable DrmInitData drmInitData) {
        if (!Util.g(this.P3, drmInitData)) {
            this.P3 = drmInitData;
            int i2 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.o3;
                if (i2 < hlsSampleQueueArr.length) {
                    if (this.H3[i2]) {
                        hlsSampleQueueArr[i2].l0(drmInitData);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void o() {
        this.N3 = true;
        this.k3.post(this.j3);
    }

    public void o0(boolean z) {
        this.Z.v(z);
    }

    public void p0(long j2) {
        if (this.O3 != j2) {
            this.O3 = j2;
            for (HlsSampleQueue d0 : this.o3) {
                d0.d0(j2);
            }
        }
    }

    public int q0(int i2, long j2) {
        if (Q()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.o3[i2];
        int H = hlsSampleQueue.H(j2, this.M3);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.x(this.g3, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.q()) {
            H = Math.min(H, hlsMediaChunk.m(i2) - hlsSampleQueue.F());
        }
        hlsSampleQueue.h0(H);
        return H;
    }

    public void r0(int i2) {
        w();
        Assertions.g(this.D3);
        int i4 = this.D3[i2];
        Assertions.i(this.G3[i4]);
        this.G3[i4] = false;
    }

    public TrackGroupArray s() {
        w();
        return this.B3;
    }

    public void t(long j2, boolean z) {
        if (this.v3 && !Q()) {
            int length = this.o3.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.o3[i2].r(j2, z, this.G3[i2]);
            }
        }
    }

    public int x(int i2) {
        w();
        Assertions.g(this.D3);
        int i4 = this.D3[i2];
        if (i4 == -1) {
            return this.C3.contains(this.B3.d(i2)) ? -3 : -2;
        }
        boolean[] zArr = this.G3;
        if (zArr[i4]) {
            return -2;
        }
        zArr[i4] = true;
        return i4;
    }
}
