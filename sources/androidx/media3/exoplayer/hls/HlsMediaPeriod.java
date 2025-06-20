package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Label;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class HlsMediaPeriod implements MediaPeriod, HlsPlaylistTracker.PlaylistEventListener {
    /* access modifiers changed from: private */
    public final HlsPlaylistTracker X;
    @Nullable
    private final CmcdConfiguration X2;
    private final HlsDataSourceFactory Y;
    private final DrmSessionManager Y2;
    @Nullable
    private final TransferListener Z;
    private final DrmSessionEventListener.EventDispatcher Z2;
    private final LoadErrorHandlingPolicy a3;
    private final MediaSourceEventListener.EventDispatcher b3;
    private final Allocator c3;
    private final IdentityHashMap<SampleStream, Integer> d3;
    private final TimestampAdjusterProvider e3;
    private final CompositeSequenceableLoaderFactory f3;
    private final boolean g3;
    private final int h3;
    private final boolean i3;
    private final PlayerId j3;
    private final HlsSampleStreamWrapper.Callback k3 = new SampleStreamWrapperCallback();
    private final long l3;
    /* access modifiers changed from: private */
    @Nullable
    public MediaPeriod.Callback m3;
    private int n3;
    /* access modifiers changed from: private */
    public TrackGroupArray o3;
    /* access modifiers changed from: private */
    public HlsSampleStreamWrapper[] p3;
    private HlsSampleStreamWrapper[] q3;
    private int[][] r3;
    private final HlsExtractorFactory s;
    private int s3;
    private SequenceableLoader t3;

    private class SampleStreamWrapperCallback implements HlsSampleStreamWrapper.Callback {
        private SampleStreamWrapperCallback() {
        }

        /* renamed from: a */
        public void j(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
            HlsMediaPeriod.this.m3.j(HlsMediaPeriod.this);
        }

        public void b() {
            if (HlsMediaPeriod.j(HlsMediaPeriod.this) <= 0) {
                int i2 = 0;
                for (HlsSampleStreamWrapper s2 : HlsMediaPeriod.this.p3) {
                    i2 += s2.s().s;
                }
                TrackGroup[] trackGroupArr = new TrackGroup[i2];
                int i3 = 0;
                for (HlsSampleStreamWrapper hlsSampleStreamWrapper : HlsMediaPeriod.this.p3) {
                    int i4 = hlsSampleStreamWrapper.s().s;
                    int i5 = 0;
                    while (i5 < i4) {
                        trackGroupArr[i3] = hlsSampleStreamWrapper.s().d(i5);
                        i5++;
                        i3++;
                    }
                }
                TrackGroupArray unused = HlsMediaPeriod.this.o3 = new TrackGroupArray(trackGroupArr);
                HlsMediaPeriod.this.m3.i(HlsMediaPeriod.this);
            }
        }

        public void o(Uri uri) {
            HlsMediaPeriod.this.X.k(uri);
        }
    }

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, @Nullable TransferListener transferListener, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z, int i2, boolean z2, PlayerId playerId, long j2) {
        this.s = hlsExtractorFactory;
        this.X = hlsPlaylistTracker;
        this.Y = hlsDataSourceFactory;
        this.Z = transferListener;
        this.X2 = cmcdConfiguration;
        this.Y2 = drmSessionManager;
        this.Z2 = eventDispatcher;
        this.a3 = loadErrorHandlingPolicy;
        this.b3 = eventDispatcher2;
        this.c3 = allocator;
        this.f3 = compositeSequenceableLoaderFactory;
        this.g3 = z;
        this.h3 = i2;
        this.i3 = z2;
        this.j3 = playerId;
        this.l3 = j2;
        this.t3 = compositeSequenceableLoaderFactory.b();
        this.d3 = new IdentityHashMap<>();
        this.e3 = new TimestampAdjusterProvider();
        this.p3 = new HlsSampleStreamWrapper[0];
        this.q3 = new HlsSampleStreamWrapper[0];
        this.r3 = new int[0][];
    }

    private static Format A(Format format, @Nullable Format format2, boolean z) {
        List<Label> list;
        String str;
        String str2;
        int i2;
        int i4;
        int i5;
        Metadata metadata;
        String str3;
        List<Label> I = ImmutableList.I();
        int i6 = -1;
        if (format2 != null) {
            str3 = format2.c3;
            metadata = format2.d3;
            i5 = format2.s3;
            i4 = format2.X2;
            i2 = format2.Y2;
            str2 = format2.Z;
            str = format2.X;
            list = format2.Y;
        } else {
            String g0 = Util.g0(format.c3, 1);
            metadata = format.d3;
            if (z) {
                i5 = format.s3;
                i4 = format.X2;
                i2 = format.Y2;
                str2 = format.Z;
                str = format.X;
                I = format.Y;
            } else {
                i4 = 0;
                str2 = null;
                str = null;
                i5 = -1;
                i2 = 0;
            }
            List<Label> list2 = I;
            str3 = g0;
            list = list2;
        }
        String g2 = MimeTypes.g(str3);
        int i7 = z ? format.Z2 : -1;
        if (z) {
            i6 = format.a3;
        }
        return new Format.Builder().X(format.s).Z(str).a0(list).O(format.e3).k0(g2).M(str3).d0(metadata).K(i7).f0(i6).L(i5).m0(i4).i0(i2).b0(str2).I();
    }

    private static Map<String, DrmInitData> B(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i2);
            String str = drmInitData.Y;
            i2++;
            int i4 = i2;
            while (i4 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i4);
                if (TextUtils.equals(drmInitData2.Y, str)) {
                    drmInitData = drmInitData.j(drmInitData2);
                    arrayList.remove(i4);
                } else {
                    i4++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static Format C(Format format) {
        String g0 = Util.g0(format.c3, 2);
        return new Format.Builder().X(format.s).Z(format.X).a0(format.Y).O(format.e3).k0(MimeTypes.g(g0)).M(g0).d0(format.d3).K(format.Z2).f0(format.a3).r0(format.k3).V(format.l3).U(format.m3).m0(format.X2).i0(format.Y2).I();
    }

    static /* synthetic */ int j(HlsMediaPeriod hlsMediaPeriod) {
        int i2 = hlsMediaPeriod.n3 - 1;
        hlsMediaPeriod.n3 = i2;
        return i2;
    }

    private void w(long j2, List<HlsMultivariantPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<HlsMultivariantPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list4.get(i2).f11590d;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (Util.g(str, list4.get(i4).f11590d)) {
                        HlsMultivariantPlaylist.Rendition rendition = list4.get(i4);
                        arrayList3.add(Integer.valueOf(i4));
                        arrayList.add(rendition.f11587a);
                        arrayList2.add(rendition.f11588b);
                        z &= Util.f0(rendition.f11588b.c3, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                HlsSampleStreamWrapper z2 = z(str2, 1, (Uri[]) arrayList.toArray((Uri[]) Util.p(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j2);
                list3.add(Ints.D(arrayList3));
                list2.add(z2);
                if (this.g3 && z) {
                    z2.f0(new TrackGroup[]{new TrackGroup(str2, (Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist r20, long r21, java.util.List<androidx.media3.exoplayer.hls.HlsSampleStreamWrapper> r23, java.util.List<int[]> r24, java.util.Map<java.lang.String, androidx.media3.common.DrmInitData> r25) {
        /*
            r19 = this;
            r10 = r19
            r11 = r20
            r12 = 1
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r0 = r11.f11578e
            int r0 = r0.size()
            int[] r1 = new int[r0]
            r13 = 0
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0011:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r5 = r11.f11578e
            int r5 = r5.size()
            r6 = 2
            if (r2 >= r5) goto L_0x0046
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r5 = r11.f11578e
            java.lang.Object r5 = r5.get(r2)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r5 = (androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist.Variant) r5
            androidx.media3.common.Format r5 = r5.f11592b
            int r7 = r5.l3
            if (r7 > 0) goto L_0x0041
            java.lang.String r7 = r5.c3
            java.lang.String r7 = androidx.media3.common.util.Util.g0(r7, r6)
            if (r7 == 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            java.lang.String r5 = r5.c3
            java.lang.String r5 = androidx.media3.common.util.Util.g0(r5, r12)
            if (r5 == 0) goto L_0x003d
            r1[r2] = r12
            int r4 = r4 + r12
            goto L_0x0044
        L_0x003d:
            r5 = -1
            r1[r2] = r5
            goto L_0x0044
        L_0x0041:
            r1[r2] = r6
            int r3 = r3 + r12
        L_0x0044:
            int r2 = r2 + r12
            goto L_0x0011
        L_0x0046:
            if (r3 <= 0) goto L_0x004c
            r14 = r3
            r0 = 1
        L_0x004a:
            r2 = 0
            goto L_0x0056
        L_0x004c:
            if (r4 >= r0) goto L_0x0053
            int r0 = r0 - r4
            r14 = r0
            r0 = 0
            r2 = 1
            goto L_0x0056
        L_0x0053:
            r14 = r0
            r0 = 0
            goto L_0x004a
        L_0x0056:
            android.net.Uri[] r3 = new android.net.Uri[r14]
            androidx.media3.common.Format[] r15 = new androidx.media3.common.Format[r14]
            int[] r8 = new int[r14]
            r4 = 0
            r5 = 0
        L_0x005e:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r11.f11578e
            int r7 = r7.size()
            if (r4 >= r7) goto L_0x0089
            if (r0 == 0) goto L_0x006c
            r7 = r1[r4]
            if (r7 != r6) goto L_0x0087
        L_0x006c:
            if (r2 == 0) goto L_0x0072
            r7 = r1[r4]
            if (r7 == r12) goto L_0x0087
        L_0x0072:
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant> r7 = r11.f11578e
            java.lang.Object r7 = r7.get(r4)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r7 = (androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist.Variant) r7
            android.net.Uri r9 = r7.f11591a
            r3[r5] = r9
            androidx.media3.common.Format r7 = r7.f11592b
            r15[r5] = r7
            int r7 = r5 + 1
            r8[r5] = r4
            r5 = r7
        L_0x0087:
            int r4 = r4 + r12
            goto L_0x005e
        L_0x0089:
            r1 = r15[r13]
            java.lang.String r1 = r1.c3
            int r9 = androidx.media3.common.util.Util.f0(r1, r6)
            int r7 = androidx.media3.common.util.Util.f0(r1, r12)
            if (r7 == r12) goto L_0x00a1
            if (r7 != 0) goto L_0x00aa
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition> r1 = r11.f11580g
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00aa
        L_0x00a1:
            if (r9 > r12) goto L_0x00aa
            int r1 = r7 + r9
            if (r1 <= 0) goto L_0x00aa
            r16 = 1
            goto L_0x00ac
        L_0x00aa:
            r16 = 0
        L_0x00ac:
            if (r0 != 0) goto L_0x00b2
            if (r7 <= 0) goto L_0x00b2
            r2 = 1
            goto L_0x00b3
        L_0x00b2:
            r2 = 0
        L_0x00b3:
            androidx.media3.common.Format r5 = r11.f11583j
            java.util.List<androidx.media3.common.Format> r6 = r11.f11584k
            java.lang.String r4 = "main"
            r0 = r19
            r1 = r4
            r13 = r4
            r4 = r15
            r17 = r7
            r7 = r25
            r12 = r8
            r18 = r9
            r8 = r21
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper r0 = r0.z(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r23
            r1.add(r0)
            r1 = r24
            r1.add(r12)
            boolean r1 = r10.g3
            if (r1 == 0) goto L_0x01cd
            if (r16 == 0) goto L_0x01cd
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r18 <= 0) goto L_0x016c
            androidx.media3.common.Format[] r2 = new androidx.media3.common.Format[r14]
            r3 = 0
        L_0x00e5:
            if (r3 >= r14) goto L_0x00f2
            r4 = r15[r3]
            androidx.media3.common.Format r4 = C(r4)
            r2[r3] = r4
            r4 = 1
            int r3 = r3 + r4
            goto L_0x00e5
        L_0x00f2:
            androidx.media3.common.TrackGroup r3 = new androidx.media3.common.TrackGroup
            r3.<init>(r13, r2)
            r1.add(r3)
            if (r17 <= 0) goto L_0x012f
            androidx.media3.common.Format r2 = r11.f11583j
            if (r2 != 0) goto L_0x0108
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition> r2 = r11.f11580g
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x012f
        L_0x0108:
            androidx.media3.common.TrackGroup r2 = new androidx.media3.common.TrackGroup
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            java.lang.String r4 = ":audio"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r5 = r15[r4]
            androidx.media3.common.Format r6 = r11.f11583j
            androidx.media3.common.Format r5 = A(r5, r6, r4)
            r6 = 1
            androidx.media3.common.Format[] r7 = new androidx.media3.common.Format[r6]
            r7[r4] = r5
            r2.<init>(r3, r7)
            r1.add(r2)
        L_0x012f:
            java.util.List<androidx.media3.common.Format> r2 = r11.f11584k
            if (r2 == 0) goto L_0x016a
            r4 = 0
        L_0x0134:
            int r3 = r2.size()
            if (r4 >= r3) goto L_0x016a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            java.lang.String r5 = ":cc:"
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            androidx.media3.common.TrackGroup r5 = new androidx.media3.common.TrackGroup
            androidx.media3.exoplayer.hls.HlsExtractorFactory r6 = r10.s
            java.lang.Object r7 = r2.get(r4)
            androidx.media3.common.Format r7 = (androidx.media3.common.Format) r7
            androidx.media3.common.Format r6 = r6.c(r7)
            r7 = 1
            androidx.media3.common.Format[] r8 = new androidx.media3.common.Format[r7]
            r9 = 0
            r8[r9] = r6
            r5.<init>(r3, r8)
            r1.add(r5)
            int r4 = r4 + r7
            goto L_0x0134
        L_0x016a:
            r7 = 1
            goto L_0x0186
        L_0x016c:
            r7 = 1
            androidx.media3.common.Format[] r2 = new androidx.media3.common.Format[r14]
            r4 = 0
        L_0x0170:
            if (r4 >= r14) goto L_0x017e
            r3 = r15[r4]
            androidx.media3.common.Format r5 = r11.f11583j
            androidx.media3.common.Format r3 = A(r3, r5, r7)
            r2[r4] = r3
            int r4 = r4 + r7
            goto L_0x0170
        L_0x017e:
            androidx.media3.common.TrackGroup r3 = new androidx.media3.common.TrackGroup
            r3.<init>(r13, r2)
            r1.add(r3)
        L_0x0186:
            androidx.media3.common.TrackGroup r2 = new androidx.media3.common.TrackGroup
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            java.lang.String r4 = ":id3"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            androidx.media3.common.Format$Builder r4 = new androidx.media3.common.Format$Builder
            r4.<init>()
            java.lang.String r5 = "ID3"
            androidx.media3.common.Format$Builder r4 = r4.X(r5)
            java.lang.String r5 = "application/id3"
            androidx.media3.common.Format$Builder r4 = r4.k0(r5)
            androidx.media3.common.Format r4 = r4.I()
            r5 = 1
            androidx.media3.common.Format[] r5 = new androidx.media3.common.Format[r5]
            r6 = 0
            r5[r6] = r4
            r2.<init>(r3, r5)
            r1.add(r2)
            androidx.media3.common.TrackGroup[] r3 = new androidx.media3.common.TrackGroup[r6]
            java.lang.Object[] r3 = r1.toArray(r3)
            androidx.media3.common.TrackGroup[] r3 = (androidx.media3.common.TrackGroup[]) r3
            int r1 = r1.indexOf(r2)
            int[] r1 = new int[]{r1}
            r0.f0(r3, r6, r1)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaPeriod.x(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void y(long j2) {
        char c2 = 0;
        int i2 = 1;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.g(this.X.h());
        Map<String, DrmInitData> B = this.i3 ? B(hlsMultivariantPlaylist.f11586m) : Collections.emptyMap();
        boolean z = !hlsMultivariantPlaylist.f11578e.isEmpty();
        List<HlsMultivariantPlaylist.Rendition> list = hlsMultivariantPlaylist.f11580g;
        List<HlsMultivariantPlaylist.Rendition> list2 = hlsMultivariantPlaylist.f11581h;
        this.n3 = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            x(hlsMultivariantPlaylist, j2, arrayList, arrayList2, B);
        }
        w(j2, list, arrayList, arrayList2, B);
        this.s3 = arrayList.size();
        int i4 = 0;
        while (i4 < list2.size()) {
            HlsMultivariantPlaylist.Rendition rendition = list2.get(i4);
            String str = "subtitle:" + i4 + ":" + rendition.f11590d;
            Format format = rendition.f11588b;
            Uri[] uriArr = new Uri[i2];
            uriArr[c2] = rendition.f11587a;
            Format[] formatArr = new Format[i2];
            formatArr[c2] = format;
            ArrayList arrayList3 = arrayList2;
            int i5 = i4;
            HlsSampleStreamWrapper z2 = z(str, 3, uriArr, formatArr, (Format) null, Collections.emptyList(), B, j2);
            arrayList3.add(new int[]{i5});
            arrayList.add(z2);
            z2.f0(new TrackGroup[]{new TrackGroup(str, this.s.c(format))}, 0, new int[0]);
            i4 = i5 + 1;
            arrayList2 = arrayList3;
            c2 = 0;
            i2 = 1;
        }
        this.p3 = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.r3 = (int[][]) arrayList2.toArray(new int[0][]);
        this.n3 = this.p3.length;
        for (int i6 = 0; i6 < this.s3; i6++) {
            this.p3[i6].o0(true);
        }
        for (HlsSampleStreamWrapper A : this.p3) {
            A.A();
        }
        this.q3 = this.p3;
    }

    private HlsSampleStreamWrapper z(String str, int i2, Uri[] uriArr, Format[] formatArr, @Nullable Format format, @Nullable List<Format> list, Map<String, DrmInitData> map, long j2) {
        HlsChunkSource hlsChunkSource = new HlsChunkSource(this.s, this.X, uriArr, formatArr, this.Y, this.Z, this.e3, this.l3, list, this.j3, this.X2);
        return new HlsSampleStreamWrapper(str, i2, this.k3, hlsChunkSource, map, this.c3, j2, format, this.Y2, this.Z2, this.a3, this.b3, this.h3);
    }

    public void E() {
        this.X.d(this);
        for (HlsSampleStreamWrapper h0 : this.p3) {
            h0.h0();
        }
        this.m3 = null;
    }

    public boolean a(LoadingInfo loadingInfo) {
        if (this.o3 != null) {
            return this.t3.a(loadingInfo);
        }
        for (HlsSampleStreamWrapper A : this.p3) {
            A.A();
        }
        return false;
    }

    public void b() {
        for (HlsSampleStreamWrapper d0 : this.p3) {
            d0.d0();
        }
        this.m3.j(this);
    }

    public boolean c() {
        return this.t3.c();
    }

    public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        boolean z2 = true;
        for (HlsSampleStreamWrapper c0 : this.p3) {
            z2 &= c0.c0(uri, loadErrorInfo, z);
        }
        this.m3.j(this);
        return z2;
    }

    public long e() {
        return this.t3.e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.q3) {
            if (hlsSampleStreamWrapper.S()) {
                return hlsSampleStreamWrapper.f(j2, seekParameters);
            }
        }
        return j2;
    }

    public long g() {
        return this.t3.g();
    }

    public void h(long j2) {
        this.t3.h(j2);
    }

    public List<StreamKey> k(List<ExoTrackSelection> list) {
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i2;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMultivariantPlaylist hlsMultivariantPlaylist = (HlsMultivariantPlaylist) Assertions.g(hlsMediaPeriod.X.h());
        boolean z = !hlsMultivariantPlaylist.f11578e.isEmpty();
        int length = hlsMediaPeriod.p3.length - hlsMultivariantPlaylist.f11581h.size();
        int i4 = 0;
        if (z) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.p3[0];
            iArr = hlsMediaPeriod.r3[0];
            trackGroupArray = hlsSampleStreamWrapper.s();
            i2 = hlsSampleStreamWrapper.L();
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.X2;
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        for (ExoTrackSelection next : list) {
            TrackGroup d2 = next.d();
            int f2 = trackGroupArray.f(d2);
            if (f2 == -1) {
                int i5 = z;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.p3;
                    if (i5 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i5].s().f(d2) != -1) {
                        int i6 = i5 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.r3[i5];
                        int i7 = 0;
                        while (i7 < next.length()) {
                            arrayList.add(new StreamKey(i6, iArr2[next.k(i7)]));
                            i7++;
                        }
                    } else {
                        i5++;
                        hlsMediaPeriod = this;
                    }
                }
            } else if (f2 == i2) {
                for (int i8 = 0; i8 < next.length(); i8++) {
                    arrayList.add(new StreamKey(i4, iArr[next.k(i8)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
            hlsMediaPeriod = this;
            i4 = 0;
        }
        if (z2 && !z3) {
            int i9 = iArr[0];
            int i10 = hlsMultivariantPlaylist.f11578e.get(i9).f11592b.b3;
            for (int i11 = 1; i11 < iArr.length; i11++) {
                int i12 = hlsMultivariantPlaylist.f11578e.get(iArr[i11]).f11592b.b3;
                if (i12 < i10) {
                    i9 = iArr[i11];
                    i10 = i12;
                }
            }
            arrayList.add(new StreamKey(0, i9));
        }
        return arrayList;
    }

    public void l() throws IOException {
        for (HlsSampleStreamWrapper l2 : this.p3) {
            l2.l();
        }
    }

    public long m(long j2) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.q3;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean k0 = hlsSampleStreamWrapperArr[0].k0(j2, false);
            int i2 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.q3;
                if (i2 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i2].k0(j2, k0);
                i2++;
            }
            if (k0) {
                this.e3.b();
            }
        }
        return j2;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        boolean z;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i2 = 0; i2 < exoTrackSelectionArr2.length; i2++) {
            SampleStream sampleStream = sampleStreamArr2[i2];
            iArr[i2] = sampleStream == null ? -1 : this.d3.get(sampleStream).intValue();
            iArr2[i2] = -1;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i2];
            if (exoTrackSelection != null) {
                TrackGroup d2 = exoTrackSelection.d();
                int i4 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.p3;
                    if (i4 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i4].s().f(d2) != -1) {
                        iArr2[i2] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.d3.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.p3.length];
        int i5 = 0;
        int i6 = 0;
        boolean z2 = false;
        while (i6 < this.p3.length) {
            for (int i7 = 0; i7 < exoTrackSelectionArr2.length; i7++) {
                ExoTrackSelection exoTrackSelection2 = null;
                sampleStreamArr4[i7] = iArr[i7] == i6 ? sampleStreamArr2[i7] : null;
                if (iArr2[i7] == i6) {
                    exoTrackSelection2 = exoTrackSelectionArr2[i7];
                }
                exoTrackSelectionArr3[i7] = exoTrackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.p3[i6];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i8 = i5;
            int i9 = length;
            int i10 = i6;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean l0 = hlsSampleStreamWrapper.l0(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j2, z2);
            int i11 = 0;
            boolean z3 = false;
            while (true) {
                z = true;
                if (i11 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream2 = sampleStreamArr4[i11];
                if (iArr2[i11] == i10) {
                    Assertions.g(sampleStream2);
                    sampleStreamArr3[i11] = sampleStream2;
                    this.d3.put(sampleStream2, Integer.valueOf(i10));
                    z3 = true;
                } else if (iArr[i11] == i10) {
                    if (sampleStream2 != null) {
                        z = false;
                    }
                    Assertions.i(z);
                }
                i11++;
            }
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = hlsSampleStreamWrapperArr3;
            if (z3) {
                hlsSampleStreamWrapperArr4[i8] = hlsSampleStreamWrapper2;
                i5 = i8 + 1;
                if (i8 == 0) {
                    hlsSampleStreamWrapper2.o0(true);
                    if (!l0) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = this.q3;
                        if (hlsSampleStreamWrapperArr5.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr5[0]) {
                        }
                    }
                    this.e3.b();
                    z2 = true;
                } else {
                    if (i10 >= this.s3) {
                        z = false;
                    }
                    hlsSampleStreamWrapper2.o0(z);
                }
            } else {
                i5 = i8;
            }
            i6 = i10 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr4;
            length = i9;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr6 = (HlsSampleStreamWrapper[]) Util.O1(hlsSampleStreamWrapperArr2, i5);
        this.q3 = hlsSampleStreamWrapperArr6;
        ImmutableList D = ImmutableList.D(hlsSampleStreamWrapperArr6);
        this.t3 = this.f3.a(D, Lists.D(D, new b()));
        return j2;
    }

    public long q() {
        return C.f9084b;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.m3 = callback;
        this.X.e(this);
        y(j2);
    }

    public TrackGroupArray s() {
        return (TrackGroupArray) Assertions.g(this.o3);
    }

    public void t(long j2, boolean z) {
        for (HlsSampleStreamWrapper t : this.q3) {
            t.t(j2, z);
        }
    }
}
