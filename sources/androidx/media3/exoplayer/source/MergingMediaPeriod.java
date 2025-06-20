package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.collect.Lists;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final IdentityHashMap<SampleStream, Integer> X;
    private final HashMap<TrackGroup, TrackGroup> X2 = new HashMap<>();
    private final CompositeSequenceableLoaderFactory Y;
    @Nullable
    private MediaPeriod.Callback Y2;
    private final ArrayList<MediaPeriod> Z = new ArrayList<>();
    @Nullable
    private TrackGroupArray Z2;
    private MediaPeriod[] a3;
    private SequenceableLoader b3;
    private final MediaPeriod[] s;

    private static final class ForwardingTrackSelection implements ExoTrackSelection {

        /* renamed from: c  reason: collision with root package name */
        private final ExoTrackSelection f12174c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroup f12175d;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.f12174c = exoTrackSelection;
            this.f12175d = trackGroup;
        }

        public long a() {
            return this.f12174c.a();
        }

        public boolean b(int i2, long j2) {
            return this.f12174c.b(i2, j2);
        }

        public int c(Format format) {
            return this.f12174c.v(this.f12175d.e(format));
        }

        public TrackGroup d() {
            return this.f12175d;
        }

        public int e() {
            return this.f12174c.e();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            return this.f12174c.equals(forwardingTrackSelection.f12174c) && this.f12175d.equals(forwardingTrackSelection.f12175d);
        }

        public boolean f(long j2, Chunk chunk, List<? extends MediaChunk> list) {
            return this.f12174c.f(j2, chunk, list);
        }

        public void g(boolean z) {
            this.f12174c.g(z);
        }

        public int getType() {
            return this.f12174c.getType();
        }

        public void h() {
            this.f12174c.h();
        }

        public int hashCode() {
            return ((MetaDo.w + this.f12175d.hashCode()) * 31) + this.f12174c.hashCode();
        }

        public Format i(int i2) {
            return this.f12175d.d(this.f12174c.k(i2));
        }

        public void j() {
            this.f12174c.j();
        }

        public int k(int i2) {
            return this.f12174c.k(i2);
        }

        public int l(long j2, List<? extends MediaChunk> list) {
            return this.f12174c.l(j2, list);
        }

        public int length() {
            return this.f12174c.length();
        }

        public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.f12174c.m(j2, j3, j4, list, mediaChunkIteratorArr);
        }

        public int n() {
            return this.f12174c.n();
        }

        public Format o() {
            return this.f12175d.d(this.f12174c.n());
        }

        public int p() {
            return this.f12174c.p();
        }

        public boolean q(int i2, long j2) {
            return this.f12174c.q(i2, j2);
        }

        public void r(float f2) {
            this.f12174c.r(f2);
        }

        @Nullable
        public Object s() {
            return this.f12174c.s();
        }

        public void t() {
            this.f12174c.t();
        }

        public void u() {
            this.f12174c.u();
        }

        public int v(int i2) {
            return this.f12174c.v(i2);
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.Y = compositeSequenceableLoaderFactory;
        this.s = mediaPeriodArr;
        this.b3 = compositeSequenceableLoaderFactory.b();
        this.X = new IdentityHashMap<>();
        this.a3 = new MediaPeriod[0];
        for (int i2 = 0; i2 < mediaPeriodArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.s[i2] = new TimeOffsetMediaPeriod(mediaPeriodArr[i2], j2);
            }
        }
    }

    public boolean a(LoadingInfo loadingInfo) {
        if (this.Z.isEmpty()) {
            return this.b3.a(loadingInfo);
        }
        int size = this.Z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.Z.get(i2).a(loadingInfo);
        }
        return false;
    }

    public boolean c() {
        return this.b3.c();
    }

    public long e() {
        return this.b3.e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.a3;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.s[0]).f(j2, seekParameters);
    }

    public long g() {
        return this.b3.g();
    }

    public void h(long j2) {
        this.b3.h(j2);
    }

    public void i(MediaPeriod mediaPeriod) {
        this.Z.remove(mediaPeriod);
        if (this.Z.isEmpty()) {
            int i2 = 0;
            for (MediaPeriod s2 : this.s) {
                i2 += s2.s().s;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                MediaPeriod[] mediaPeriodArr = this.s;
                if (i3 < mediaPeriodArr.length) {
                    TrackGroupArray s3 = mediaPeriodArr[i3].s();
                    int i5 = s3.s;
                    int i6 = 0;
                    while (i6 < i5) {
                        TrackGroup d2 = s3.d(i6);
                        Format[] formatArr = new Format[d2.s];
                        for (int i7 = 0; i7 < d2.s; i7++) {
                            Format d3 = d2.d(i7);
                            Format.Builder c2 = d3.c();
                            StringBuilder sb = new StringBuilder();
                            sb.append(i3);
                            sb.append(":");
                            String str = d3.s;
                            if (str == null) {
                                str = "";
                            }
                            sb.append(str);
                            formatArr[i7] = c2.X(sb.toString()).I();
                        }
                        TrackGroup trackGroup = new TrackGroup(i3 + ":" + d2.X, formatArr);
                        this.X2.put(trackGroup, d2);
                        trackGroupArr[i4] = trackGroup;
                        i6++;
                        i4++;
                    }
                    i3++;
                } else {
                    this.Z2 = new TrackGroupArray(trackGroupArr);
                    ((MediaPeriod.Callback) Assertions.g(this.Y2)).i(this);
                    return;
                }
            }
        }
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    public void l() throws IOException {
        for (MediaPeriod l2 : this.s) {
            l2.l();
        }
    }

    public long m(long j2) {
        long m2 = this.a3[0].m(j2);
        int i2 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.a3;
            if (i2 >= mediaPeriodArr.length) {
                return m2;
            }
            if (mediaPeriodArr[i2].m(m2) == m2) {
                i2++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        Integer num;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        int i2 = 0;
        while (true) {
            num = 0;
            if (i2 >= exoTrackSelectionArr2.length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr2[i2];
            if (sampleStream != null) {
                num = this.X.get(sampleStream);
            }
            iArr[i2] = num == null ? -1 : num.intValue();
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i2];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.d().X;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        this.X.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.s.length);
        long j3 = j2;
        int i3 = 0;
        while (i3 < this.s.length) {
            for (int i4 = 0; i4 < exoTrackSelectionArr2.length; i4++) {
                sampleStreamArr4[i4] = iArr[i4] == i3 ? sampleStreamArr2[i4] : num;
                if (iArr2[i4] == i3) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.g(exoTrackSelectionArr2[i4]);
                    exoTrackSelectionArr3[i4] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.g(this.X2.get(exoTrackSelection2.d())));
                } else {
                    exoTrackSelectionArr3[i4] = num;
                }
            }
            int i5 = i3;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            long n2 = this.s[i3].n(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j3);
            if (i5 == 0) {
                j3 = n2;
            } else if (n2 != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < exoTrackSelectionArr2.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i5) {
                    sampleStreamArr3[i6] = sampleStreamArr4[i6];
                    this.X.put((SampleStream) Assertions.g(sampleStreamArr4[i6]), Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    if (sampleStreamArr4[i6] != null) {
                        z2 = false;
                    }
                    Assertions.i(z2);
                }
            }
            if (z) {
                arrayList2.add(this.s[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            num = null;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        this.a3 = (MediaPeriod[]) arrayList3.toArray(new MediaPeriod[0]);
        this.b3 = this.Y.a(arrayList3, Lists.D(arrayList3, new x()));
        return j3;
    }

    public MediaPeriod p(int i2) {
        MediaPeriod mediaPeriod = this.s[i2];
        return mediaPeriod instanceof TimeOffsetMediaPeriod ? ((TimeOffsetMediaPeriod) mediaPeriod).d() : mediaPeriod;
    }

    public long q() {
        long j2 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.a3) {
            long q = mediaPeriod.q();
            if (q != C.f9084b) {
                if (j2 == C.f9084b) {
                    MediaPeriod[] mediaPeriodArr = this.a3;
                    int length = mediaPeriodArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        MediaPeriod mediaPeriod2 = mediaPeriodArr[i2];
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.m(q) == q) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j2 = q;
                } else if (q != j2) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j2 == C.f9084b || mediaPeriod.m(j2) == j2)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j2;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.Y2 = callback;
        Collections.addAll(this.Z, this.s);
        for (MediaPeriod r : this.s) {
            r.r(this, j2);
        }
    }

    public TrackGroupArray s() {
        return (TrackGroupArray) Assertions.g(this.Z2);
    }

    public void t(long j2, boolean z) {
        for (MediaPeriod t : this.a3) {
            t.t(j2, z);
        }
    }

    /* renamed from: v */
    public void j(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.g(this.Y2)).j(this);
    }
}
