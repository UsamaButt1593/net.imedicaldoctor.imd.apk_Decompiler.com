package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.SingleSampleMediaChunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public class DefaultDashChunkSource implements DashChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final LoaderErrorThrower f10988a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseUrlExclusionList f10989b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f10990c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10991d;

    /* renamed from: e  reason: collision with root package name */
    private final DataSource f10992e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10993f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10994g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler f10995h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final CmcdConfiguration f10996i;

    /* renamed from: j  reason: collision with root package name */
    protected final RepresentationHolder[] f10997j;

    /* renamed from: k  reason: collision with root package name */
    private ExoTrackSelection f10998k;

    /* renamed from: l  reason: collision with root package name */
    private DashManifest f10999l;

    /* renamed from: m  reason: collision with root package name */
    private int f11000m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private IOException f11001n;
    private boolean o;
    private long p = C.f9084b;

    public static final class Factory implements DashChunkSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f11002a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11003b;

        /* renamed from: c  reason: collision with root package name */
        private final ChunkExtractor.Factory f11004c;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Format c(Format format) {
            return this.f11004c.c(format);
        }

        public DashChunkSource d(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, long j2, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @Nullable TransferListener transferListener, PlayerId playerId, @Nullable CmcdConfiguration cmcdConfiguration) {
            TransferListener transferListener2 = transferListener;
            DataSource a2 = this.f11002a.a();
            if (transferListener2 != null) {
                a2.e(transferListener2);
            }
            return new DefaultDashChunkSource(this.f11004c, loaderErrorThrower, dashManifest, baseUrlExclusionList, i2, iArr, exoTrackSelection, i3, a2, j2, this.f11003b, z, list, playerTrackEmsgHandler, playerId, cmcdConfiguration);
        }

        @CanIgnoreReturnValue
        /* renamed from: e */
        public Factory b(boolean z) {
            this.f11004c.b(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: f */
        public Factory a(SubtitleParser.Factory factory) {
            this.f11004c.a(factory);
            return this;
        }

        public Factory(DataSource.Factory factory, int i2) {
            this(BundledChunkExtractor.c3, factory, i2);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i2) {
            this.f11004c = factory;
            this.f11002a = factory2;
            this.f11003b = i2;
        }
    }

    protected static final class RepresentationHolder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        final ChunkExtractor f11005a;

        /* renamed from: b  reason: collision with root package name */
        public final Representation f11006b;

        /* renamed from: c  reason: collision with root package name */
        public final BaseUrl f11007c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final DashSegmentIndex f11008d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f11009e;

        /* renamed from: f  reason: collision with root package name */
        private final long f11010f;

        RepresentationHolder(long j2, Representation representation, BaseUrl baseUrl, @Nullable ChunkExtractor chunkExtractor, long j3, @Nullable DashSegmentIndex dashSegmentIndex) {
            this.f11009e = j2;
            this.f11006b = representation;
            this.f11007c = baseUrl;
            this.f11010f = j3;
            this.f11005a = chunkExtractor;
            this.f11008d = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        @CheckResult
        public RepresentationHolder b(long j2, Representation representation) throws BehindLiveWindowException {
            long g2;
            long j3 = j2;
            DashSegmentIndex l2 = this.f11006b.l();
            DashSegmentIndex l3 = representation.l();
            if (l2 == null) {
                return new RepresentationHolder(j2, representation, this.f11007c, this.f11005a, this.f11010f, l2);
            } else if (!l2.h()) {
                return new RepresentationHolder(j2, representation, this.f11007c, this.f11005a, this.f11010f, l3);
            } else {
                long j4 = l2.j(j3);
                if (j4 == 0) {
                    return new RepresentationHolder(j2, representation, this.f11007c, this.f11005a, this.f11010f, l3);
                }
                Assertions.k(l3);
                long i2 = l2.i();
                long b2 = l2.b(i2);
                long j5 = j4 + i2;
                long j6 = j5 - 1;
                long b3 = l2.b(j6) + l2.c(j6, j3);
                long i3 = l3.i();
                DashSegmentIndex dashSegmentIndex = l2;
                long b4 = l3.b(i3);
                long j7 = i2;
                long j8 = this.f11010f;
                int i4 = (b3 > b4 ? 1 : (b3 == b4 ? 0 : -1));
                if (i4 != 0) {
                    if (i4 < 0) {
                        throw new BehindLiveWindowException();
                    } else if (b4 < b2) {
                        g2 = j8 - (l3.g(b2, j3) - j7);
                        return new RepresentationHolder(j2, representation, this.f11007c, this.f11005a, g2, l3);
                    } else {
                        j5 = dashSegmentIndex.g(b4, j3);
                    }
                }
                g2 = j8 + (j5 - i3);
                return new RepresentationHolder(j2, representation, this.f11007c, this.f11005a, g2, l3);
            }
        }

        /* access modifiers changed from: package-private */
        @CheckResult
        public RepresentationHolder c(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.f11009e, this.f11006b, this.f11007c, this.f11005a, this.f11010f, dashSegmentIndex);
        }

        /* access modifiers changed from: package-private */
        @CheckResult
        public RepresentationHolder d(BaseUrl baseUrl) {
            return new RepresentationHolder(this.f11009e, this.f11006b, baseUrl, this.f11005a, this.f11010f, this.f11008d);
        }

        public long e(long j2) {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).d(this.f11009e, j2) + this.f11010f;
        }

        public long f() {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).i() + this.f11010f;
        }

        public long g(long j2) {
            return (e(j2) + ((DashSegmentIndex) Assertions.k(this.f11008d)).k(this.f11009e, j2)) - 1;
        }

        public long h() {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).j(this.f11009e);
        }

        public long i(long j2) {
            return k(j2) + ((DashSegmentIndex) Assertions.k(this.f11008d)).c(j2 - this.f11010f, this.f11009e);
        }

        public long j(long j2) {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).g(j2, this.f11009e) + this.f11010f;
        }

        public long k(long j2) {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).b(j2 - this.f11010f);
        }

        public RangedUri l(long j2) {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).f(j2 - this.f11010f);
        }

        public boolean m(long j2, long j3) {
            return ((DashSegmentIndex) Assertions.k(this.f11008d)).h() || j3 == C.f9084b || i(j2) <= j3;
        }
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final RepresentationHolder f11011e;

        /* renamed from: f  reason: collision with root package name */
        private final long f11012f;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j2, long j3, long j4) {
            super(j2, j3);
            this.f11011e = representationHolder;
            this.f11012f = j4;
        }

        public long a() {
            e();
            return this.f11011e.k(f());
        }

        public DataSpec b() {
            e();
            long f2 = f();
            RangedUri l2 = this.f11011e.l(f2);
            int i2 = this.f11011e.m(f2, this.f11012f) ? 0 : 8;
            RepresentationHolder representationHolder = this.f11011e;
            return DashUtil.c(representationHolder.f11006b, representationHolder.f11007c.f11127a, l2, i2, ImmutableMap.s());
        }

        public long d() {
            e();
            return this.f11011e.i(f());
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z, List<Format> list, @Nullable PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, PlayerId playerId, @Nullable CmcdConfiguration cmcdConfiguration) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList2 = baseUrlExclusionList;
        int i5 = i2;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.f10988a = loaderErrorThrower;
        this.f10999l = dashManifest2;
        this.f10989b = baseUrlExclusionList2;
        this.f10990c = iArr;
        this.f10998k = exoTrackSelection2;
        this.f10991d = i3;
        this.f10992e = dataSource;
        this.f11000m = i5;
        this.f10993f = j2;
        this.f10994g = i4;
        this.f10995h = playerTrackEmsgHandler;
        this.f10996i = cmcdConfiguration;
        long g2 = dashManifest2.g(i5);
        ArrayList<Representation> p2 = p();
        this.f10997j = new RepresentationHolder[exoTrackSelection.length()];
        int i6 = 0;
        while (i6 < this.f10997j.length) {
            Representation representation = p2.get(exoTrackSelection2.k(i6));
            BaseUrl j3 = baseUrlExclusionList2.j(representation.f11184d);
            int i7 = i6;
            this.f10997j[i7] = new RepresentationHolder(g2, representation, j3 == null ? representation.f11184d.get(0) : j3, factory.d(i3, representation.f11183c, z, list, playerTrackEmsgHandler, playerId), 0, representation.l());
            i6 = i7 + 1;
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions l(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.b(i3, elapsedRealtime)) {
                i2++;
            }
        }
        int f2 = BaseUrlExclusionList.f(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(f2, f2 - this.f10989b.g(list), length, i2);
    }

    private long m(long j2, long j3) {
        if (!this.f10999l.f11134d || this.f10997j[0].h() == 0) {
            return C.f9084b;
        }
        return Math.max(0, Math.min(o(j2), this.f10997j[0].i(this.f10997j[0].g(j2))) - j3);
    }

    @Nullable
    private Pair<String, String> n(long j2, RangedUri rangedUri, RepresentationHolder representationHolder) {
        long j3 = j2 + 1;
        if (j3 >= representationHolder.h()) {
            return null;
        }
        RangedUri l2 = representationHolder.l(j3);
        String a2 = UriUtil.a(rangedUri.b(representationHolder.f11007c.f11127a), l2.b(representationHolder.f11007c.f11127a));
        String str = l2.f11177a + "-";
        if (l2.f11178b != -1) {
            str = str + (l2.f11177a + l2.f11178b);
        }
        return new Pair<>(a2, str);
    }

    private long o(long j2) {
        DashManifest dashManifest = this.f10999l;
        long j3 = dashManifest.f11131a;
        return j3 == C.f9084b ? C.f9084b : j2 - Util.I1(j3 + dashManifest.d(this.f11000m).f11168b);
    }

    @RequiresNonNull({"manifest", "adaptationSetIndices"})
    private ArrayList<Representation> p() {
        List<AdaptationSet> list = this.f10999l.d(this.f11000m).f11169c;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i2 : this.f10990c) {
            arrayList.addAll(list.get(i2).f11120c);
        }
        return arrayList;
    }

    private long q(RepresentationHolder representationHolder, @Nullable MediaChunk mediaChunk, long j2, long j3, long j4) {
        return mediaChunk != null ? mediaChunk.g() : Util.x(representationHolder.j(j2), j3, j4);
    }

    private RepresentationHolder t(int i2) {
        RepresentationHolder representationHolder = this.f10997j[i2];
        BaseUrl j2 = this.f10989b.j(representationHolder.f11006b.f11184d);
        if (j2 == null || j2.equals(representationHolder.f11007c)) {
            return representationHolder;
        }
        RepresentationHolder d2 = representationHolder.d(j2);
        this.f10997j[i2] = d2;
        return d2;
    }

    public void a() {
        for (RepresentationHolder representationHolder : this.f10997j) {
            ChunkExtractor chunkExtractor = representationHolder.f11005a;
            if (chunkExtractor != null) {
                chunkExtractor.a();
            }
        }
    }

    public void b() throws IOException {
        IOException iOException = this.f11001n;
        if (iOException == null) {
            this.f10988a.b();
            return;
        }
        throw iOException;
    }

    public void c(ExoTrackSelection exoTrackSelection) {
        this.f10998k = exoTrackSelection;
    }

    public void d(Chunk chunk) {
        ChunkIndex f2;
        if (chunk instanceof InitializationChunk) {
            int c2 = this.f10998k.c(((InitializationChunk) chunk).f12281d);
            RepresentationHolder representationHolder = this.f10997j[c2];
            if (representationHolder.f11008d == null && (f2 = ((ChunkExtractor) Assertions.k(representationHolder.f11005a)).f()) != null) {
                this.f10997j[c2] = representationHolder.c(new DashWrappingSegmentIndex(f2, representationHolder.f11006b.f11185e));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f10995h;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.i(chunk);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(androidx.media3.exoplayer.LoadingInfo r44, long r45, java.util.List<? extends androidx.media3.exoplayer.source.chunk.MediaChunk> r47, androidx.media3.exoplayer.source.chunk.ChunkHolder r48) {
        /*
            r43 = this;
            r15 = r43
            r9 = r44
            r14 = r48
            java.io.IOException r0 = r15.f11001n
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            long r10 = r9.f10228a
            long r12 = r45 - r10
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.f10999l
            long r0 = r0.f11131a
            long r0 = androidx.media3.common.util.Util.I1(r0)
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r15.f10999l
            int r3 = r15.f11000m
            androidx.media3.exoplayer.dash.manifest.Period r2 = r2.d(r3)
            long r2 = r2.f11168b
            long r2 = androidx.media3.common.util.Util.I1(r2)
            long r0 = r0 + r2
            long r0 = r0 + r45
            androidx.media3.exoplayer.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler r2 = r15.f10995h
            if (r2 == 0) goto L_0x0033
            boolean r0 = r2.h(r0)
            if (r0 == 0) goto L_0x0033
            return
        L_0x0033:
            long r0 = r15.f10993f
            long r0 = androidx.media3.common.util.Util.B0(r0)
            long r7 = androidx.media3.common.util.Util.I1(r0)
            long r25 = r15.o(r7)
            boolean r0 = r47.isEmpty()
            r27 = 0
            r5 = 1
            if (r0 == 0) goto L_0x004f
            r6 = r47
            r28 = r27
            goto L_0x005e
        L_0x004f:
            int r0 = r47.size()
            int r0 = r0 - r5
            r6 = r47
            java.lang.Object r0 = r6.get(r0)
            androidx.media3.exoplayer.source.chunk.MediaChunk r0 = (androidx.media3.exoplayer.source.chunk.MediaChunk) r0
            r28 = r0
        L_0x005e:
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            int r3 = r0.length()
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r4 = new androidx.media3.exoplayer.source.chunk.MediaChunkIterator[r3]
            r29 = 0
            r2 = 0
        L_0x0069:
            if (r2 >= r3) goto L_0x00c5
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder[] r0 = r15.f10997j
            r1 = r0[r2]
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r1.f11008d
            if (r0 != 0) goto L_0x0080
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.f12297a
            r4[r2] = r0
            r14 = r2
            r24 = r3
            r30 = r4
            r31 = r12
            r12 = r7
            goto L_0x00b6
        L_0x0080:
            long r16 = r1.e(r7)
            long r20 = r1.g(r7)
            r0 = r43
            r14 = r2
            r2 = r28
            r24 = r3
            r30 = r4
            r3 = r45
            r5 = r16
            r31 = r12
            r12 = r7
            r7 = r20
            long r18 = r0.q(r1, r2, r3, r5, r7)
            int r0 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a7
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.f12297a
            r30[r14] = r0
            goto L_0x00b6
        L_0x00a7:
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r17 = r15.t(r14)
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator r0 = new androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator
            r16 = r0
            r22 = r25
            r16.<init>(r17, r18, r20, r22)
            r30[r14] = r0
        L_0x00b6:
            int r2 = r14 + 1
            r6 = r47
            r14 = r48
            r7 = r12
            r3 = r24
            r4 = r30
            r12 = r31
            r5 = 1
            goto L_0x0069
        L_0x00c5:
            r30 = r4
            r31 = r12
            r12 = r7
            long r21 = r15.m(r12, r10)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            r16 = r0
            r17 = r10
            r19 = r31
            r23 = r47
            r24 = r30
            r16.m(r17, r19, r21, r23, r24)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            int r0 = r0.e()
            androidx.media3.exoplayer.upstream.CmcdConfiguration r1 = r15.f10996i
            r2 = 0
            if (r1 != 0) goto L_0x00ec
            r14 = r27
            goto L_0x0118
        L_0x00ec:
            androidx.media3.exoplayer.upstream.CmcdData$Factory r1 = new androidx.media3.exoplayer.upstream.CmcdData$Factory
            androidx.media3.exoplayer.upstream.CmcdConfiguration r4 = r15.f10996i
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r5 = r15.f10998k
            r6 = r31
            long r36 = java.lang.Math.max(r2, r6)
            float r6 = r9.f10229b
            androidx.media3.exoplayer.dash.manifest.DashManifest r7 = r15.f10999l
            boolean r7 = r7.f11134d
            long r10 = r15.p
            boolean r41 = r9.b(r10)
            boolean r42 = r47.isEmpty()
            java.lang.String r39 = "d"
            r33 = r1
            r34 = r4
            r35 = r5
            r38 = r6
            r40 = r7
            r33.<init>(r34, r35, r36, r38, r39, r40, r41, r42)
            r14 = r1
        L_0x0118:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r15.p = r4
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r9 = r15.t(r0)
            androidx.media3.exoplayer.source.chunk.ChunkExtractor r0 = r9.f11005a
            if (r0 == 0) goto L_0x0147
            androidx.media3.exoplayer.dash.manifest.Representation r1 = r9.f11006b
            androidx.media3.common.Format[] r0 = r0.c()
            if (r0 != 0) goto L_0x0134
            androidx.media3.exoplayer.dash.manifest.RangedUri r0 = r1.n()
            r6 = r0
            goto L_0x0136
        L_0x0134:
            r6 = r27
        L_0x0136:
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r9.f11008d
            if (r0 != 0) goto L_0x0140
            androidx.media3.exoplayer.dash.manifest.RangedUri r0 = r1.m()
            r7 = r0
            goto L_0x0142
        L_0x0140:
            r7 = r27
        L_0x0142:
            if (r6 != 0) goto L_0x014a
            if (r7 == 0) goto L_0x0147
            goto L_0x014a
        L_0x0147:
            r10 = r48
            goto L_0x016b
        L_0x014a:
            androidx.media3.datasource.DataSource r2 = r15.f10992e
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            androidx.media3.common.Format r3 = r0.o()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            int r4 = r0.p()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            java.lang.Object r5 = r0.s()
            r0 = r43
            r1 = r9
            r8 = r14
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.r(r1, r2, r3, r4, r5, r6, r7, r8)
            r10 = r48
            r10.f12287a = r0
            return
        L_0x016b:
            long r16 = r9.f11009e
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.f10999l
            boolean r1 = r0.f11134d
            if (r1 == 0) goto L_0x0181
            int r1 = r15.f11000m
            int r0 = r0.e()
            r11 = 1
            int r0 = r0 - r11
            if (r1 != r0) goto L_0x0182
            r5 = 1
            goto L_0x0183
        L_0x0181:
            r11 = 1
        L_0x0182:
            r5 = 0
        L_0x0183:
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == 0) goto L_0x0191
            int r0 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x018f
            goto L_0x0191
        L_0x018f:
            r0 = 0
            goto L_0x0192
        L_0x0191:
            r0 = 1
        L_0x0192:
            long r6 = r9.h()
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x019d
            r10.f12288b = r0
            return
        L_0x019d:
            long r20 = r9.e(r12)
            long r12 = r9.g(r12)
            if (r5 == 0) goto L_0x01ba
            long r1 = r9.i(r12)
            long r3 = r9.k(r12)
            long r3 = r1 - r3
            long r1 = r1 + r3
            int r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r3 < 0) goto L_0x01b8
            r5 = 1
            goto L_0x01b9
        L_0x01b8:
            r5 = 0
        L_0x01b9:
            r0 = r0 & r5
        L_0x01ba:
            r7 = r0
            r0 = r43
            r1 = r9
            r2 = r28
            r3 = r45
            r5 = r20
            r11 = r7
            r7 = r12
            long r7 = r0.q(r1, r2, r3, r5, r7)
            int r0 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r0 >= 0) goto L_0x01d6
            androidx.media3.exoplayer.source.BehindLiveWindowException r0 = new androidx.media3.exoplayer.source.BehindLiveWindowException
            r0.<init>()
            r15.f11001n = r0
            return
        L_0x01d6:
            int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x01e0
            boolean r1 = r15.o
            if (r1 == 0) goto L_0x01e2
            if (r0 < 0) goto L_0x01e2
        L_0x01e0:
            r15 = r10
            goto L_0x0241
        L_0x01e2:
            if (r11 == 0) goto L_0x01f0
            long r0 = r9.k(r7)
            int r2 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r2 < 0) goto L_0x01f0
            r0 = 1
            r10.f12288b = r0
            return
        L_0x01f0:
            int r0 = r15.f10994g
            long r0 = (long) r0
            long r12 = r12 - r7
            r2 = 1
            long r12 = r12 + r2
            long r0 = java.lang.Math.min(r0, r12)
            int r1 = (int) r0
            int r0 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0211
            r0 = 1
        L_0x0201:
            if (r1 <= r0) goto L_0x0211
            long r4 = (long) r1
            long r4 = r4 + r7
            long r4 = r4 - r2
            long r4 = r9.k(r4)
            int r6 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0211
            int r1 = r1 + -1
            goto L_0x0201
        L_0x0211:
            r11 = r1
            boolean r0 = r47.isEmpty()
            if (r0 == 0) goto L_0x021a
            r18 = r45
        L_0x021a:
            androidx.media3.datasource.DataSource r2 = r15.f10992e
            int r3 = r15.f10991d
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            androidx.media3.common.Format r4 = r0.o()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            int r5 = r0.p()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f10998k
            java.lang.Object r6 = r0.s()
            r0 = r43
            r1 = r9
            r9 = r11
            r10 = r18
            r12 = r25
            r15 = r48
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.s(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14)
            r15.f12287a = r0
            return
        L_0x0241:
            r15.f12288b = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DefaultDashChunkSource.e(androidx.media3.exoplayer.LoadingInfo, long, java.util.List, androidx.media3.exoplayer.source.chunk.ChunkHolder):void");
    }

    public long f(long j2, SeekParameters seekParameters) {
        long j3 = j2;
        for (RepresentationHolder representationHolder : this.f10997j) {
            if (representationHolder.f11008d != null) {
                long h2 = representationHolder.h();
                if (h2 != 0) {
                    long j4 = representationHolder.j(j3);
                    long k2 = representationHolder.k(j4);
                    return seekParameters.a(j2, k2, (k2 >= j3 || (h2 != -1 && j4 >= (representationHolder.f() + h2) - 1)) ? k2 : representationHolder.k(j4 + 1));
                }
            }
        }
        return j3;
    }

    public boolean g(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection d2;
        if (!z) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f10995h;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.j(chunk)) {
            return true;
        }
        if (!this.f10999l.f11134d && (chunk instanceof MediaChunk)) {
            IOException iOException = loadErrorInfo.f12567c;
            if ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).a3 == 404) {
                RepresentationHolder representationHolder = this.f10997j[this.f10998k.c(chunk.f12281d)];
                long h2 = representationHolder.h();
                if (!(h2 == -1 || h2 == 0)) {
                    if (((MediaChunk) chunk).g() > (representationHolder.f() + h2) - 1) {
                        this.o = true;
                        return true;
                    }
                }
            }
        }
        RepresentationHolder representationHolder2 = this.f10997j[this.f10998k.c(chunk.f12281d)];
        BaseUrl j2 = this.f10989b.j(representationHolder2.f11006b.f11184d);
        if (j2 != null && !representationHolder2.f11007c.equals(j2)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions l2 = l(this.f10998k, representationHolder2.f11006b.f11184d);
        if ((!l2.a(2) && !l2.a(1)) || (d2 = loadErrorHandlingPolicy.d(l2, loadErrorInfo)) == null || !l2.a(d2.f12563a)) {
            return false;
        }
        int i2 = d2.f12563a;
        if (i2 == 2) {
            ExoTrackSelection exoTrackSelection = this.f10998k;
            return exoTrackSelection.q(exoTrackSelection.c(chunk.f12281d), d2.f12564b);
        } else if (i2 != 1) {
            return false;
        } else {
            this.f10989b.e(representationHolder2.f11007c, d2.f12564b);
            return true;
        }
    }

    public void i(DashManifest dashManifest, int i2) {
        try {
            this.f10999l = dashManifest;
            this.f11000m = i2;
            long g2 = dashManifest.g(i2);
            ArrayList<Representation> p2 = p();
            for (int i3 = 0; i3 < this.f10997j.length; i3++) {
                RepresentationHolder[] representationHolderArr = this.f10997j;
                representationHolderArr[i3] = representationHolderArr[i3].b(g2, p2.get(this.f10998k.k(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.f11001n = e2;
        }
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        return (this.f11001n != null || this.f10998k.length() < 2) ? list.size() : this.f10998k.l(j2, list);
    }

    public boolean k(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f11001n != null) {
            return false;
        }
        return this.f10998k.f(j2, chunk, list);
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"#1.chunkExtractor"})
    public Chunk r(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i2, @Nullable Object obj, @Nullable RangedUri rangedUri, @Nullable RangedUri rangedUri2, @Nullable CmcdData.Factory factory) {
        Representation representation = representationHolder.f11006b;
        if (rangedUri != null) {
            RangedUri a2 = rangedUri.a(rangedUri2, representationHolder.f11007c.f11127a);
            if (a2 != null) {
                rangedUri = a2;
            }
        } else {
            rangedUri = (RangedUri) Assertions.g(rangedUri2);
        }
        DataSpec c2 = DashUtil.c(representation, representationHolder.f11007c.f11127a, rangedUri, 0, ImmutableMap.s());
        if (factory != null) {
            c2 = factory.g("i").a().a(c2);
        }
        return new InitializationChunk(dataSource, c2, format, i2, obj, representationHolder.f11005a);
    }

    /* access modifiers changed from: protected */
    public Chunk s(RepresentationHolder representationHolder, DataSource dataSource, int i2, Format format, int i3, @Nullable Object obj, long j2, int i4, long j3, long j4, @Nullable CmcdData.Factory factory) {
        DataSpec dataSpec;
        RepresentationHolder representationHolder2 = representationHolder;
        long j5 = j2;
        long j6 = j4;
        CmcdData.Factory factory2 = factory;
        Representation representation = representationHolder2.f11006b;
        long k2 = representationHolder2.k(j5);
        RangedUri l2 = representationHolder2.l(j5);
        if (representationHolder2.f11005a == null) {
            long i5 = representationHolder2.i(j5);
            DataSpec c2 = DashUtil.c(representation, representationHolder2.f11007c.f11127a, l2, representationHolder2.m(j5, j6) ? 0 : 8, ImmutableMap.s());
            if (factory2 != null) {
                factory2.d(i5 - k2).g(CmcdData.Factory.c(this.f10998k));
                Pair<String, String> n2 = n(j5, l2, representationHolder2);
                if (n2 != null) {
                    factory2.e((String) n2.first).f((String) n2.second);
                }
                dataSpec = factory.a().a(c2);
            } else {
                dataSpec = c2;
            }
            return new SingleSampleMediaChunk(dataSource, dataSpec, format, i3, obj, k2, i5, j2, i2, format);
        }
        int i6 = 1;
        int i7 = i4;
        int i8 = 1;
        while (i6 < i7) {
            RangedUri a2 = l2.a(representationHolder2.l(((long) i6) + j5), representationHolder2.f11007c.f11127a);
            if (a2 == null) {
                break;
            }
            i8++;
            i6++;
            l2 = a2;
        }
        long j7 = (((long) i8) + j5) - 1;
        long i9 = representationHolder2.i(j7);
        long a3 = representationHolder.f11009e;
        long j8 = C.f9084b;
        if (a3 != C.f9084b && a3 <= i9) {
            j8 = a3;
        }
        DataSpec c3 = DashUtil.c(representation, representationHolder2.f11007c.f11127a, l2, representationHolder2.m(j7, j6) ? 0 : 8, ImmutableMap.s());
        if (factory2 != null) {
            factory2.d(i9 - k2).g(CmcdData.Factory.c(this.f10998k));
            Pair<String, String> n3 = n(j5, l2, representationHolder2);
            if (n3 != null) {
                factory2.e((String) n3.first).f((String) n3.second);
            }
            c3 = factory.a().a(c3);
        }
        DataSpec dataSpec2 = c3;
        long j9 = -representation.f11185e;
        if (MimeTypes.q(format.f3)) {
            j9 += k2;
        }
        return new ContainerMediaChunk(dataSource, dataSpec2, format, i3, obj, k2, i9, j3, j8, j2, i8, j9, representationHolder2.f11005a);
    }
}
