package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UriUtil;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.HlsChunkSource;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    public static final String N = "com.apple.streaming.transportStreamTimestamp";
    private static final AtomicInteger O = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final PlayerId C;
    private final long D;
    private HlsMediaChunkExtractor E;
    private HlsSampleStreamWrapper F;
    private int G;
    private boolean H;
    private volatile boolean I;
    private boolean J;
    private ImmutableList<Integer> K;
    private boolean L;
    private boolean M;

    /* renamed from: k  reason: collision with root package name */
    public final int f11411k;

    /* renamed from: l  reason: collision with root package name */
    public final int f11412l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f11413m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f11414n;
    public final int o;
    @Nullable
    private final DataSource p;
    @Nullable
    private final DataSpec q;
    @Nullable
    private final HlsMediaChunkExtractor r;
    private final boolean s;
    private final boolean t;
    private final TimestampAdjuster u;
    private final HlsExtractorFactory v;
    @Nullable
    private final List<Format> w;
    @Nullable
    private final DrmInitData x;
    private final Id3Decoder y;
    private final ParsableByteArray z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z2, @Nullable DataSource dataSource2, @Nullable DataSpec dataSpec2, boolean z3, Uri uri, @Nullable List<Format> list, int i2, @Nullable Object obj, long j2, long j3, long j4, int i3, boolean z4, int i4, boolean z5, boolean z6, TimestampAdjuster timestampAdjuster, long j5, @Nullable DrmInitData drmInitData, @Nullable HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z7, PlayerId playerId) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4);
        DataSpec dataSpec3 = dataSpec2;
        this.A = z2;
        this.o = i3;
        this.M = z4;
        this.f11412l = i4;
        this.q = dataSpec3;
        this.p = dataSource2;
        this.H = dataSpec3 != null;
        this.B = z3;
        this.f11413m = uri;
        this.s = z6;
        this.u = timestampAdjuster;
        this.D = j5;
        this.t = z5;
        this.v = hlsExtractorFactory;
        this.w = list;
        this.x = drmInitData;
        this.r = hlsMediaChunkExtractor;
        this.y = id3Decoder;
        this.z = parsableByteArray;
        this.f11414n = z7;
        this.C = playerId;
        this.K = ImmutableList.I();
        this.f11411k = O.getAndIncrement();
    }

    private static DataSource i(DataSource dataSource, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        Assertions.g(bArr2);
        return new Aes128DataSource(dataSource, bArr, bArr2);
    }

    public static HlsMediaChunk j(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, Format format, long j2, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, Uri uri, @Nullable List<Format> list, int i2, @Nullable Object obj, boolean z2, TimestampAdjusterProvider timestampAdjusterProvider, long j3, @Nullable HlsMediaChunk hlsMediaChunk, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z3, PlayerId playerId, @Nullable CmcdData.Factory factory) {
        boolean z4;
        DataSpec dataSpec;
        DataSource dataSource2;
        ParsableByteArray parsableByteArray;
        Id3Decoder id3Decoder;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        DataSource dataSource3 = dataSource;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        HlsChunkSource.SegmentBaseHolder segmentBaseHolder2 = segmentBaseHolder;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        CmcdData.Factory factory2 = factory;
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder2.f11404a;
        DataSpec a2 = new DataSpec.Builder().j(UriUtil.g(hlsMediaPlaylist2.f11597a, segmentBase.s)).i(segmentBase.b3).h(segmentBase.c3).c(segmentBaseHolder2.f11407d ? 8 : 0).a();
        if (factory2 != null) {
            a2 = factory2.d(segmentBase.Y).a().a(a2);
        }
        DataSpec dataSpec2 = a2;
        boolean z5 = bArr3 != null;
        DataSource i3 = i(dataSource3, bArr3, z5 ? l((String) Assertions.g(segmentBase.a3)) : null);
        HlsMediaPlaylist.Segment segment = segmentBase.X;
        if (segment != null) {
            boolean z6 = bArr4 != null;
            byte[] l2 = z6 ? l((String) Assertions.g(segment.a3)) : null;
            boolean z7 = z6;
            dataSpec = new DataSpec.Builder().j(UriUtil.g(hlsMediaPlaylist2.f11597a, segment.s)).i(segment.b3).h(segment.c3).a();
            if (factory2 != null) {
                dataSpec = factory2.g("i").a().a(dataSpec2);
            }
            dataSource2 = i(dataSource3, bArr4, l2);
            z4 = z7;
        } else {
            dataSource2 = null;
            dataSpec = null;
            z4 = false;
        }
        long j4 = j2 + segmentBase.X2;
        long j5 = j4 + segmentBase.Y;
        int i4 = hlsMediaPlaylist2.f11563j + segmentBase.Z;
        if (hlsMediaChunk2 != null) {
            DataSpec dataSpec3 = hlsMediaChunk2.q;
            boolean z8 = dataSpec == dataSpec3 || (dataSpec != null && dataSpec3 != null && dataSpec.f9779a.equals(dataSpec3.f9779a) && dataSpec.f9785g == hlsMediaChunk2.q.f9785g);
            boolean z9 = uri.equals(hlsMediaChunk2.f11413m) && hlsMediaChunk2.J;
            Id3Decoder id3Decoder2 = hlsMediaChunk2.y;
            id3Decoder = id3Decoder2;
            parsableByteArray = hlsMediaChunk2.z;
            hlsMediaChunkExtractor = (!z8 || !z9 || hlsMediaChunk2.L || hlsMediaChunk2.f11412l != i4) ? null : hlsMediaChunk2.E;
        } else {
            Uri uri2 = uri;
            id3Decoder = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            hlsMediaChunkExtractor = null;
        }
        return new HlsMediaChunk(hlsExtractorFactory, i3, dataSpec2, format, z5, dataSource2, dataSpec, z4, uri, list, i2, obj, j4, j5, segmentBaseHolder2.f11405b, segmentBaseHolder2.f11406c, !segmentBaseHolder2.f11407d, i4, segmentBase.d3, z2, timestampAdjusterProvider.a(i4), j3, segmentBase.Y2, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z3, playerId);
    }

    @RequiresNonNull({"output"})
    private void k(DataSource dataSource, DataSpec dataSpec, boolean z2, boolean z3) throws IOException {
        DataSpec dataSpec2;
        DefaultExtractorInput u2;
        long j2;
        long j3;
        boolean z4 = false;
        if (z2) {
            if (this.G != 0) {
                z4 = true;
            }
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.e((long) this.G);
        }
        try {
            u2 = u(dataSource, dataSpec2, z3);
            if (z4) {
                u2.o(this.G);
            }
            do {
                if (this.I || !this.E.b(u2)) {
                    break;
                }
                break;
                break;
            } while (!this.E.b(u2));
            break;
            j2 = u2.getPosition();
            j3 = dataSpec.f9785g;
        } catch (EOFException e2) {
            if ((this.f12281d.Y2 & 16384) != 0) {
                this.E.e();
                j2 = u2.getPosition();
                j3 = dataSpec.f9785g;
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            DataSourceUtil.a(dataSource);
            throw th;
        }
        this.G = (int) (j2 - j3);
        DataSourceUtil.a(dataSource);
    }

    private static byte[] l(String str) {
        if (Ascii.g(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static boolean p(HlsChunkSource.SegmentBaseHolder segmentBaseHolder, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.f11404a;
        if (segmentBase instanceof HlsMediaPlaylist.Part) {
            return ((HlsMediaPlaylist.Part) segmentBase).e3 || (segmentBaseHolder.f11406c == 0 && hlsMediaPlaylist.f11599c);
        }
        return hlsMediaPlaylist.f11599c;
    }

    @RequiresNonNull({"output"})
    private void r() throws IOException {
        k(this.f12286i, this.f12279b, this.A, true);
    }

    @RequiresNonNull({"output"})
    private void s() throws IOException {
        if (this.H) {
            Assertions.g(this.p);
            Assertions.g(this.q);
            k(this.p, this.q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    private long t(ExtractorInput extractorInput) throws IOException {
        extractorInput.n();
        try {
            this.z.U(10);
            extractorInput.s(this.z.e(), 0, 10);
            if (this.z.O() != 4801587) {
                return C.f9084b;
            }
            this.z.Z(3);
            int K2 = this.z.K();
            int i2 = K2 + 10;
            if (i2 > this.z.b()) {
                byte[] e2 = this.z.e();
                this.z.U(i2);
                System.arraycopy(e2, 0, this.z.e(), 0, 10);
            }
            extractorInput.s(this.z.e(), 10, K2);
            Metadata e3 = this.y.e(this.z.e(), K2);
            if (e3 == null) {
                return C.f9084b;
            }
            int g2 = e3.g();
            for (int i3 = 0; i3 < g2; i3++) {
                Metadata.Entry d2 = e3.d(i3);
                if (d2 instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) d2;
                    if (N.equals(privFrame.X)) {
                        System.arraycopy(privFrame.Y, 0, this.z.e(), 0, 8);
                        this.z.Y(0);
                        this.z.X(8);
                        return this.z.E() & 8589934591L;
                    }
                }
            }
            return C.f9084b;
        } catch (EOFException unused) {
        }
    }

    @RequiresNonNull({"output"})
    @EnsuresNonNull({"extractor"})
    private DefaultExtractorInput u(DataSource dataSource, DataSpec dataSpec, boolean z2) throws IOException {
        HlsSampleStreamWrapper hlsSampleStreamWrapper;
        long j2;
        long a2 = dataSource.a(dataSpec);
        if (z2) {
            try {
                this.u.j(this.s, this.f12284g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e2) {
                throw new IOException(e2);
            }
        }
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, dataSpec.f9785g, a2);
        if (this.E == null) {
            long t2 = t(defaultExtractorInput);
            defaultExtractorInput.n();
            HlsMediaChunkExtractor hlsMediaChunkExtractor = this.r;
            HlsMediaChunkExtractor h2 = hlsMediaChunkExtractor != null ? hlsMediaChunkExtractor.h() : this.v.d(dataSpec.f9779a, this.f12281d, this.w, this.u, dataSource.getResponseHeaders(), defaultExtractorInput, this.C);
            this.E = h2;
            if (h2.f()) {
                hlsSampleStreamWrapper = this.F;
                j2 = t2 != C.f9084b ? this.u.b(t2) : this.f12284g;
            } else {
                hlsSampleStreamWrapper = this.F;
                j2 = 0;
            }
            hlsSampleStreamWrapper.p0(j2);
            this.F.b0();
            this.E.d(this.F);
        }
        this.F.m0(this.x);
        return defaultExtractorInput;
    }

    public static boolean w(@Nullable HlsMediaChunk hlsMediaChunk, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, long j2) {
        if (hlsMediaChunk == null) {
            return false;
        }
        if (uri.equals(hlsMediaChunk.f11413m) && hlsMediaChunk.J) {
            return false;
        }
        return !p(segmentBaseHolder, hlsMediaPlaylist) || j2 + segmentBaseHolder.f11404a.X2 < hlsMediaChunk.f12285h;
    }

    public void a() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.g(this.F);
        if (this.E == null && (hlsMediaChunkExtractor = this.r) != null && hlsMediaChunkExtractor.g()) {
            this.E = this.r;
            this.H = false;
        }
        s();
        if (!this.I) {
            if (!this.t) {
                r();
            }
            this.J = !this.I;
        }
    }

    public void c() {
        this.I = true;
    }

    public boolean h() {
        return this.J;
    }

    public int m(int i2) {
        Assertions.i(!this.f11414n);
        if (i2 >= this.K.size()) {
            return 0;
        }
        return this.K.get(i2).intValue();
    }

    public void n(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.F = hlsSampleStreamWrapper;
        this.K = immutableList;
    }

    public void o() {
        this.L = true;
    }

    public boolean q() {
        return this.M;
    }

    public void v() {
        this.M = true;
    }
}
