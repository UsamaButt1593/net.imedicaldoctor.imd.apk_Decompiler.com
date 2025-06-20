package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.DataChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HlsChunkSource {
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;
    private static final int z = 4;

    /* renamed from: a  reason: collision with root package name */
    private final HlsExtractorFactory f11382a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f11383b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f11384c;

    /* renamed from: d  reason: collision with root package name */
    private final TimestampAdjusterProvider f11385d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f11386e;

    /* renamed from: f  reason: collision with root package name */
    private final Format[] f11387f;

    /* renamed from: g  reason: collision with root package name */
    private final HlsPlaylistTracker f11388g;

    /* renamed from: h  reason: collision with root package name */
    private final TrackGroup f11389h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final List<Format> f11390i;

    /* renamed from: j  reason: collision with root package name */
    private final FullSegmentEncryptionKeyCache f11391j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: k  reason: collision with root package name */
    private final PlayerId f11392k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final CmcdConfiguration f11393l;

    /* renamed from: m  reason: collision with root package name */
    private final long f11394m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11395n;
    private byte[] o = Util.f9651f;
    @Nullable
    private IOException p;
    @Nullable
    private Uri q;
    private boolean r;
    private ExoTrackSelection s;
    private long t = C.f9084b;
    private boolean u;
    private long v = C.f9084b;

    private static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: m  reason: collision with root package name */
        private byte[] f11396m;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i2, obj, bArr);
        }

        /* access modifiers changed from: protected */
        public void g(byte[] bArr, int i2) {
            this.f11396m = Arrays.copyOf(bArr, i2);
        }

        @Nullable
        public byte[] j() {
            return this.f11396m;
        }
    }

    public static final class HlsChunkHolder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public Chunk f11397a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11398b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Uri f11399c;

        public HlsChunkHolder() {
            a();
        }

        public void a() {
            this.f11397a = null;
            this.f11398b = false;
            this.f11399c = null;
        }
    }

    @VisibleForTesting
    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final List<HlsMediaPlaylist.SegmentBase> f11400e;

        /* renamed from: f  reason: collision with root package name */
        private final long f11401f;

        /* renamed from: g  reason: collision with root package name */
        private final String f11402g;

        public HlsMediaPlaylistSegmentIterator(String str, long j2, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0, (long) (list.size() - 1));
            this.f11402g = str;
            this.f11401f = j2;
            this.f11400e = list;
        }

        public long a() {
            e();
            return this.f11401f + this.f11400e.get((int) f()).X2;
        }

        public DataSpec b() {
            e();
            HlsMediaPlaylist.SegmentBase segmentBase = this.f11400e.get((int) f());
            return new DataSpec(UriUtil.g(this.f11402g, segmentBase.s), segmentBase.b3, segmentBase.c3);
        }

        public long d() {
            e();
            HlsMediaPlaylist.SegmentBase segmentBase = this.f11400e.get((int) f());
            return this.f11401f + segmentBase.X2 + segmentBase.Y;
        }
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {

        /* renamed from: j  reason: collision with root package name */
        private int f11403j;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f11403j = c(trackGroup.d(iArr[0]));
        }

        public int e() {
            return this.f11403j;
        }

        public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f11403j, elapsedRealtime)) {
                for (int i2 = this.f12364d - 1; i2 >= 0; i2--) {
                    if (!b(i2, elapsedRealtime)) {
                        this.f11403j = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int p() {
            return 0;
        }

        @Nullable
        public Object s() {
            return null;
        }
    }

    static final class SegmentBaseHolder {

        /* renamed from: a  reason: collision with root package name */
        public final HlsMediaPlaylist.SegmentBase f11404a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11405b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11406c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f11407d;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j2, int i2) {
            this.f11404a = segmentBase;
            this.f11405b = j2;
            this.f11406c = i2;
            this.f11407d = (segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).f3;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, long j2, @Nullable List<Format> list, PlayerId playerId, @Nullable CmcdConfiguration cmcdConfiguration) {
        this.f11382a = hlsExtractorFactory;
        this.f11388g = hlsPlaylistTracker;
        this.f11386e = uriArr;
        this.f11387f = formatArr;
        this.f11385d = timestampAdjusterProvider;
        this.f11394m = j2;
        this.f11390i = list;
        this.f11392k = playerId;
        this.f11393l = cmcdConfiguration;
        DataSource a2 = hlsDataSourceFactory.a(1);
        this.f11383b = a2;
        if (transferListener != null) {
            a2.e(transferListener);
        }
        this.f11384c = hlsDataSourceFactory.a(3);
        this.f11389h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            if ((formatArr[i2].Y2 & 16384) == 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        this.s = new InitializationTrackSelection(this.f11389h, Ints.D(arrayList));
    }

    @Nullable
    private static Uri d(HlsMediaPlaylist hlsMediaPlaylist, @Nullable HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.Z2) == null) {
            return null;
        }
        return UriUtil.g(hlsMediaPlaylist.f11597a, str);
    }

    private boolean e() {
        Format d2 = this.f11389h.d(this.s.e());
        return (MimeTypes.c(d2.c3) == null || MimeTypes.o(d2.c3) == null) ? false : true;
    }

    private Pair<Long, Integer> g(@Nullable HlsMediaChunk hlsMediaChunk, boolean z2, HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3) {
        int i2 = -1;
        if (hlsMediaChunk == null || z2) {
            long j4 = hlsMediaPlaylist.u + j2;
            if (hlsMediaChunk != null && !this.r) {
                j3 = hlsMediaChunk.f12284g;
            }
            if (!hlsMediaPlaylist.o && j3 >= j4) {
                return new Pair<>(Long.valueOf(hlsMediaPlaylist.f11564k + ((long) hlsMediaPlaylist.r.size())), -1);
            }
            long j5 = j3 - j2;
            int i3 = 0;
            int l2 = Util.l(hlsMediaPlaylist.r, Long.valueOf(j5), true, !this.f11388g.g() || hlsMediaChunk == null);
            long j6 = ((long) l2) + hlsMediaPlaylist.f11564k;
            if (l2 >= 0) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(l2);
                List<HlsMediaPlaylist.Part> list = j5 < segment.X2 + segment.Y ? segment.f3 : hlsMediaPlaylist.s;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    HlsMediaPlaylist.Part part = list.get(i3);
                    if (j5 >= part.X2 + part.Y) {
                        i3++;
                    } else if (part.e3) {
                        j6 += list == hlsMediaPlaylist.s ? 1 : 0;
                        i2 = i3;
                    }
                }
            }
            return new Pair<>(Long.valueOf(j6), Integer.valueOf(i2));
        } else if (!hlsMediaChunk.h()) {
            return new Pair<>(Long.valueOf(hlsMediaChunk.f12296j), Integer.valueOf(hlsMediaChunk.o));
        } else {
            Long valueOf = Long.valueOf(hlsMediaChunk.o == -1 ? hlsMediaChunk.g() : hlsMediaChunk.f12296j);
            int i4 = hlsMediaChunk.o;
            if (i4 != -1) {
                i2 = i4 + 1;
            }
            return new Pair<>(valueOf, Integer.valueOf(i2));
        }
    }

    @Nullable
    private static SegmentBaseHolder h(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f11564k);
        if (i3 == hlsMediaPlaylist.r.size()) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 < hlsMediaPlaylist.s.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.s.get(i2), j2, i2);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(i3);
        if (i2 == -1) {
            return new SegmentBaseHolder(segment, j2, -1);
        }
        if (i2 < segment.f3.size()) {
            return new SegmentBaseHolder(segment.f3.get(i2), j2, i2);
        }
        int i4 = i3 + 1;
        if (i4 < hlsMediaPlaylist.r.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.r.get(i4), j2 + 1, -1);
        }
        if (!hlsMediaPlaylist.s.isEmpty()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.s.get(0), j2 + 1, 0);
        }
        return null;
    }

    @VisibleForTesting
    static List<HlsMediaPlaylist.SegmentBase> j(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f11564k);
        if (i3 < 0 || hlsMediaPlaylist.r.size() < i3) {
            return ImmutableList.I();
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        if (i3 < hlsMediaPlaylist.r.size()) {
            if (i2 != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.r.get(i3);
                if (i2 == 0) {
                    arrayList.add(segment);
                } else if (i2 < segment.f3.size()) {
                    List<HlsMediaPlaylist.Part> list = segment.f3;
                    arrayList.addAll(list.subList(i2, list.size()));
                }
                i3++;
            }
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.r;
            arrayList.addAll(list2.subList(i3, list2.size()));
            i2 = 0;
        }
        if (hlsMediaPlaylist.f11567n != C.f9084b) {
            if (i2 != -1) {
                i4 = i2;
            }
            if (i4 < hlsMediaPlaylist.s.size()) {
                List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist.s;
                arrayList.addAll(list3.subList(i4, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private Chunk n(@Nullable Uri uri, int i2, boolean z2, @Nullable CmcdData.Factory factory) {
        if (uri == null) {
            return null;
        }
        byte[] d2 = this.f11391j.d(uri);
        if (d2 != null) {
            this.f11391j.c(uri, d2);
            return null;
        }
        DataSpec a2 = new DataSpec.Builder().j(uri).c(1).a();
        if (factory != null) {
            if (z2) {
                factory.g("i");
            }
            a2 = factory.a().a(a2);
        }
        return new EncryptionKeyChunk(this.f11384c, a2, this.f11387f[i2], this.s.p(), this.s.s(), this.o);
    }

    private long u(long j2) {
        long j3 = this.t;
        return j3 != C.f9084b ? j3 - j2 : C.f9084b;
    }

    private void y(HlsMediaPlaylist hlsMediaPlaylist) {
        this.t = hlsMediaPlaylist.o ? C.f9084b : hlsMediaPlaylist.e() - this.f11388g.f();
    }

    public MediaChunkIterator[] a(@Nullable HlsMediaChunk hlsMediaChunk, long j2) {
        int i2;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        int e2 = hlsMediaChunk2 == null ? -1 : this.f11389h.e(hlsMediaChunk2.f12281d);
        int length = this.s.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z2 = false;
        int i3 = 0;
        while (i3 < length) {
            int k2 = this.s.k(i3);
            Uri uri = this.f11386e[k2];
            if (!this.f11388g.b(uri)) {
                mediaChunkIteratorArr[i3] = MediaChunkIterator.f12297a;
                i2 = i3;
            } else {
                HlsMediaPlaylist l2 = this.f11388g.l(uri, z2);
                Assertions.g(l2);
                long f2 = l2.f11561h - this.f11388g.f();
                i2 = i3;
                Pair<Long, Integer> g2 = g(hlsMediaChunk, k2 != e2, l2, f2, j2);
                mediaChunkIteratorArr[i2] = new HlsMediaPlaylistSegmentIterator(l2.f11597a, f2, j(l2, ((Long) g2.first).longValue(), ((Integer) g2.second).intValue()));
            }
            i3 = i2 + 1;
            z2 = false;
        }
        return mediaChunkIteratorArr;
    }

    public long b(long j2, SeekParameters seekParameters) {
        int e2 = this.s.e();
        Uri[] uriArr = this.f11386e;
        HlsMediaPlaylist l2 = (e2 >= uriArr.length || e2 == -1) ? null : this.f11388g.l(uriArr[this.s.n()], true);
        if (l2 == null || l2.r.isEmpty() || !l2.f11599c) {
            return j2;
        }
        long f2 = l2.f11561h - this.f11388g.f();
        long j3 = j2 - f2;
        int l3 = Util.l(l2.r, Long.valueOf(j3), true, true);
        long j4 = l2.r.get(l3).X2;
        return seekParameters.a(j3, j4, l3 != l2.r.size() - 1 ? l2.r.get(l3 + 1).X2 : j4) + f2;
    }

    public int c(HlsMediaChunk hlsMediaChunk) {
        if (hlsMediaChunk.o == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.g(this.f11388g.l(this.f11386e[this.f11389h.e(hlsMediaChunk.f12281d)], false));
        int i2 = (int) (hlsMediaChunk.f12296j - hlsMediaPlaylist.f11564k);
        if (i2 < 0) {
            return 1;
        }
        List<HlsMediaPlaylist.Part> list = i2 < hlsMediaPlaylist.r.size() ? hlsMediaPlaylist.r.get(i2).f3 : hlsMediaPlaylist.s;
        if (hlsMediaChunk.o >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.o);
        if (part.f3) {
            return 0;
        }
        return Util.g(Uri.parse(UriUtil.f(hlsMediaPlaylist.f11597a, part.s)), hlsMediaChunk.f12279b.f9779a) ? 1 : 2;
    }

    public void f(LoadingInfo loadingInfo, long j2, List<HlsMediaChunk> list, boolean z2, HlsChunkHolder hlsChunkHolder) {
        long j3;
        Uri uri;
        HlsMediaPlaylist hlsMediaPlaylist;
        int i2;
        Uri uri2;
        HlsMediaChunk hlsMediaChunk;
        LoadingInfo loadingInfo2 = loadingInfo;
        long j4 = j2;
        HlsChunkHolder hlsChunkHolder2 = hlsChunkHolder;
        HlsMediaChunk hlsMediaChunk2 = list.isEmpty() ? null : (HlsMediaChunk) Iterables.w(list);
        int e2 = hlsMediaChunk2 == null ? -1 : this.f11389h.e(hlsMediaChunk2.f12281d);
        long j5 = loadingInfo2.f10228a;
        long j6 = j4 - j5;
        long u2 = u(j5);
        if (hlsMediaChunk2 != null && !this.r) {
            long d2 = hlsMediaChunk2.d();
            j6 = Math.max(0, j6 - d2);
            if (u2 != C.f9084b) {
                u2 = Math.max(0, u2 - d2);
            }
        }
        long j7 = u2;
        long j8 = j6;
        this.s.m(j5, j8, j7, list, a(hlsMediaChunk2, j4));
        int n2 = this.s.n();
        boolean z3 = e2 != n2;
        Uri uri3 = this.f11386e[n2];
        if (!this.f11388g.b(uri3)) {
            hlsChunkHolder2.f11399c = uri3;
            this.u &= uri3.equals(this.q);
            this.q = uri3;
            return;
        }
        HlsMediaPlaylist l2 = this.f11388g.l(uri3, true);
        Assertions.g(l2);
        this.r = l2.f11599c;
        y(l2);
        long j9 = j8;
        long f2 = l2.f11561h - this.f11388g.f();
        HlsMediaPlaylist hlsMediaPlaylist2 = l2;
        Uri uri4 = uri3;
        HlsMediaPlaylist hlsMediaPlaylist3 = hlsMediaPlaylist2;
        long j10 = j9;
        int i3 = e2;
        int i4 = n2;
        Pair<Long, Integer> g2 = g(hlsMediaChunk2, z3, hlsMediaPlaylist2, f2, j2);
        long longValue = ((Long) g2.first).longValue();
        int intValue = ((Integer) g2.second).intValue();
        if (longValue >= hlsMediaPlaylist3.f11564k || hlsMediaChunk2 == null || !z3) {
            hlsMediaPlaylist = hlsMediaPlaylist3;
            i2 = i4;
            j3 = f2;
            uri = uri4;
        } else {
            Uri uri5 = this.f11386e[i3];
            HlsMediaPlaylist l3 = this.f11388g.l(uri5, true);
            Assertions.g(l3);
            j3 = l3.f11561h - this.f11388g.f();
            Pair<Long, Integer> g3 = g(hlsMediaChunk2, false, l3, j3, j2);
            longValue = ((Long) g3.first).longValue();
            intValue = ((Integer) g3.second).intValue();
            uri = uri5;
            hlsMediaPlaylist = l3;
            i2 = i3;
        }
        if (longValue < hlsMediaPlaylist.f11564k) {
            this.p = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder h2 = h(hlsMediaPlaylist, longValue, intValue);
        if (h2 == null) {
            if (!hlsMediaPlaylist.o) {
                hlsChunkHolder2.f11399c = uri;
                this.u &= uri.equals(this.q);
                this.q = uri;
                return;
            } else if (z2 || hlsMediaPlaylist.r.isEmpty()) {
                hlsChunkHolder2.f11398b = true;
                return;
            } else {
                h2 = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) Iterables.w(hlsMediaPlaylist.r), (hlsMediaPlaylist.f11564k + ((long) hlsMediaPlaylist.r.size())) - 1, -1);
            }
        }
        SegmentBaseHolder segmentBaseHolder = h2;
        this.u = false;
        CmcdData.Factory factory = null;
        this.q = null;
        if (this.f11393l != null) {
            uri2 = uri;
            hlsMediaChunk = hlsMediaChunk2;
            factory = new CmcdData.Factory(this.f11393l, this.s, Math.max(0, j10), loadingInfo2.f10229b, CmcdData.Factory.f12510n, !hlsMediaPlaylist.o, loadingInfo2.b(this.v), list.isEmpty()).g(e() ? CmcdData.Factory.u : CmcdData.Factory.c(this.s));
            if (intValue == -1) {
                longValue = longValue == -1 ? -1 : longValue + 1;
            }
            SegmentBaseHolder h3 = h(hlsMediaPlaylist, longValue, intValue == -1 ? -1 : intValue + 1);
            if (h3 != null) {
                factory.e(UriUtil.a(UriUtil.g(hlsMediaPlaylist.f11597a, segmentBaseHolder.f11404a.s), UriUtil.g(hlsMediaPlaylist.f11597a, h3.f11404a.s)));
                String str = h3.f11404a.b3 + "-";
                if (h3.f11404a.c3 != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    HlsMediaPlaylist.SegmentBase segmentBase = h3.f11404a;
                    sb.append(segmentBase.b3 + segmentBase.c3);
                    str = sb.toString();
                }
                factory.f(str);
            }
        } else {
            uri2 = uri;
            hlsMediaChunk = hlsMediaChunk2;
        }
        CmcdData.Factory factory2 = factory;
        this.v = SystemClock.elapsedRealtime();
        Uri d3 = d(hlsMediaPlaylist, segmentBaseHolder.f11404a.X);
        Chunk n3 = n(d3, i2, true, factory2);
        HlsChunkHolder hlsChunkHolder3 = hlsChunkHolder;
        hlsChunkHolder3.f11397a = n3;
        if (n3 == null) {
            Uri d4 = d(hlsMediaPlaylist, segmentBaseHolder.f11404a);
            Chunk n4 = n(d4, i2, false, factory2);
            hlsChunkHolder3.f11397a = n4;
            if (n4 == null) {
                boolean w2 = HlsMediaChunk.w(hlsMediaChunk, uri2, hlsMediaPlaylist, segmentBaseHolder, j3);
                if (!w2 || !segmentBaseHolder.f11407d) {
                    hlsChunkHolder3.f11397a = HlsMediaChunk.j(this.f11382a, this.f11383b, this.f11387f[i2], j3, hlsMediaPlaylist, segmentBaseHolder, uri2, this.f11390i, this.s.p(), this.s.s(), this.f11395n, this.f11385d, this.f11394m, hlsMediaChunk, this.f11391j.b(d4), this.f11391j.b(d3), w2, this.f11392k, factory2);
                }
            }
        }
    }

    public int i(long j2, List<? extends MediaChunk> list) {
        return (this.p != null || this.s.length() < 2) ? list.size() : this.s.l(j2, list);
    }

    public TrackGroup k() {
        return this.f11389h;
    }

    public ExoTrackSelection l() {
        return this.s;
    }

    public boolean m() {
        return this.r;
    }

    public boolean o(Chunk chunk, long j2) {
        ExoTrackSelection exoTrackSelection = this.s;
        return exoTrackSelection.q(exoTrackSelection.v(this.f11389h.e(chunk.f12281d)), j2);
    }

    public void p() throws IOException {
        IOException iOException = this.p;
        if (iOException == null) {
            Uri uri = this.q;
            if (uri != null && this.u) {
                this.f11388g.c(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean q(Uri uri) {
        return Util.z(this.f11386e, uri);
    }

    public void r(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.o = encryptionKeyChunk.h();
            this.f11391j.c(encryptionKeyChunk.f12279b.f9779a, (byte[]) Assertions.g(encryptionKeyChunk.j()));
        }
    }

    public boolean s(Uri uri, long j2) {
        int v2;
        int i2 = 0;
        while (true) {
            Uri[] uriArr = this.f11386e;
            if (i2 >= uriArr.length) {
                i2 = -1;
                break;
            } else if (uriArr[i2].equals(uri)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || (v2 = this.s.v(i2)) == -1) {
            return true;
        }
        this.u |= uri.equals(this.q);
        return j2 == C.f9084b || (this.s.q(v2, j2) && this.f11388g.i(uri, j2));
    }

    public void t() {
        this.p = null;
    }

    public void v(boolean z2) {
        this.f11395n = z2;
    }

    public void w(ExoTrackSelection exoTrackSelection) {
        this.s = exoTrackSelection;
    }

    public boolean x(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.p != null) {
            return false;
        }
        return this.s.f(j2, chunk, list);
    }
}
