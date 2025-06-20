package androidx.media3.exoplayer.dash;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Descriptor;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern s3 = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern t3 = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    private final DashChunkSource.Factory X;
    private final DrmSessionManager X2;
    @Nullable
    private final TransferListener Y;
    private final LoadErrorHandlingPolicy Y2;
    @Nullable
    private final CmcdConfiguration Z;
    private final BaseUrlExclusionList Z2;
    private final long a3;
    private final LoaderErrorThrower b3;
    private final Allocator c3;
    private final TrackGroupArray d3;
    private final TrackGroupInfo[] e3;
    private final CompositeSequenceableLoaderFactory f3;
    private final PlayerEmsgHandler g3;
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> h3 = new IdentityHashMap<>();
    private final MediaSourceEventListener.EventDispatcher i3;
    private final DrmSessionEventListener.EventDispatcher j3;
    private final PlayerId k3;
    @Nullable
    private MediaPeriod.Callback l3;
    private ChunkSampleStream<DashChunkSource>[] m3 = J(0);
    private EventSampleStream[] n3 = new EventSampleStream[0];
    private SequenceableLoader o3;
    private DashManifest p3;
    private int q3;
    private List<EventStream> r3;
    final int s;

    private static final class TrackGroupInfo {

        /* renamed from: i  reason: collision with root package name */
        private static final int f10961i = 0;

        /* renamed from: j  reason: collision with root package name */
        private static final int f10962j = 1;

        /* renamed from: k  reason: collision with root package name */
        private static final int f10963k = 2;

        /* renamed from: a  reason: collision with root package name */
        public final int[] f10964a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10965b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10966c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10967d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10968e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10969f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10970g;

        /* renamed from: h  reason: collision with root package name */
        public final ImmutableList<Format> f10971h;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface TrackGroupCategory {
        }

        private TrackGroupInfo(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, ImmutableList<Format> immutableList) {
            this.f10965b = i2;
            this.f10964a = iArr;
            this.f10966c = i3;
            this.f10968e = i4;
            this.f10969f = i5;
            this.f10970g = i6;
            this.f10967d = i7;
            this.f10971h = immutableList;
        }

        public static TrackGroupInfo a(int[] iArr, int i2, ImmutableList<Format> immutableList) {
            return new TrackGroupInfo(3, 1, iArr, i2, -1, -1, -1, immutableList);
        }

        public static TrackGroupInfo b(int[] iArr, int i2) {
            return new TrackGroupInfo(5, 1, iArr, i2, -1, -1, -1, ImmutableList.I());
        }

        public static TrackGroupInfo c(int i2) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i2, ImmutableList.I());
        }

        public static TrackGroupInfo d(int i2, int[] iArr, int i3, int i4, int i5) {
            return new TrackGroupInfo(i2, 0, iArr, i3, i4, i5, -1, ImmutableList.I());
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i4, DashChunkSource.Factory factory, @Nullable TransferListener transferListener, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId) {
        DrmSessionManager drmSessionManager2 = drmSessionManager;
        Allocator allocator2 = allocator;
        this.s = i2;
        this.p3 = dashManifest;
        this.Z2 = baseUrlExclusionList;
        this.q3 = i4;
        this.X = factory;
        this.Y = transferListener;
        this.Z = cmcdConfiguration;
        this.X2 = drmSessionManager2;
        this.j3 = eventDispatcher;
        this.Y2 = loadErrorHandlingPolicy;
        this.i3 = eventDispatcher2;
        this.a3 = j2;
        this.b3 = loaderErrorThrower;
        this.c3 = allocator2;
        this.f3 = compositeSequenceableLoaderFactory;
        this.k3 = playerId;
        this.g3 = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator2);
        this.o3 = compositeSequenceableLoaderFactory.b();
        Period d2 = dashManifest.d(i4);
        List<EventStream> list = d2.f11170d;
        this.r3 = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> x = x(drmSessionManager2, factory, d2.f11169c, list);
        this.d3 = (TrackGroupArray) x.first;
        this.e3 = (TrackGroupInfo[]) x.second;
    }

    @Nullable
    private static Descriptor A(List<Descriptor> list) {
        return z(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Format[] B(List<AdaptationSet> list, int[] iArr) {
        Format I;
        Pattern pattern;
        for (int i2 : iArr) {
            AdaptationSet adaptationSet = list.get(i2);
            List<Descriptor> list2 = list.get(i2).f11121d;
            int i4 = 0;
            while (i4 < list2.size()) {
                Descriptor descriptor = list2.get(i4);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f11159a)) {
                    I = new Format.Builder().k0(MimeTypes.w0).X(adaptationSet.f11118a + ":cea608").I();
                    pattern = s3;
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f11159a)) {
                    I = new Format.Builder().k0(MimeTypes.x0).X(adaptationSet.f11118a + ":cea708").I();
                    pattern = t3;
                } else {
                    i4++;
                }
                return L(descriptor, pattern, I);
            }
        }
        return new Format[0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0057, code lost:
        r7 = (java.lang.Integer) r1.get(java.lang.Long.valueOf(java.lang.Long.parseLong(r7.f11160b)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int[][] C(java.util.List<androidx.media3.exoplayer.dash.manifest.AdaptationSet> r12) {
        /*
            int r0 = r12.size()
            java.util.HashMap r1 = com.google.common.collect.Maps.a0(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r0)
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>(r0)
            r4 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r0) goto L_0x003e
            java.lang.Object r6 = r12.get(r5)
            androidx.media3.exoplayer.dash.manifest.AdaptationSet r6 = (androidx.media3.exoplayer.dash.manifest.AdaptationSet) r6
            long r6 = r6.f11118a
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r1.put(r6, r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r6.add(r7)
            r2.add(r6)
            r3.put(r5, r6)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x003e:
            r5 = 0
        L_0x003f:
            if (r5 >= r0) goto L_0x00bc
            java.lang.Object r6 = r12.get(r5)
            androidx.media3.exoplayer.dash.manifest.AdaptationSet r6 = (androidx.media3.exoplayer.dash.manifest.AdaptationSet) r6
            java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r7 = r6.f11122e
            androidx.media3.exoplayer.dash.manifest.Descriptor r7 = A(r7)
            if (r7 != 0) goto L_0x0055
            java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r7 = r6.f11123f
            androidx.media3.exoplayer.dash.manifest.Descriptor r7 = A(r7)
        L_0x0055:
            if (r7 == 0) goto L_0x006e
            java.lang.String r7 = r7.f11160b
            long r7 = java.lang.Long.parseLong(r7)
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            java.lang.Object r7 = r1.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x006e
            int r7 = r7.intValue()
            goto L_0x006f
        L_0x006e:
            r7 = r5
        L_0x006f:
            if (r7 != r5) goto L_0x00a2
            java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r6 = r6.f11123f
            androidx.media3.exoplayer.dash.manifest.Descriptor r6 = y(r6)
            if (r6 == 0) goto L_0x00a2
            java.lang.String r6 = r6.f11160b
            java.lang.String r8 = ","
            java.lang.String[] r6 = androidx.media3.common.util.Util.p2(r6, r8)
            int r8 = r6.length
            r9 = 0
        L_0x0083:
            if (r9 >= r8) goto L_0x00a2
            r10 = r6[r9]
            long r10 = java.lang.Long.parseLong(r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            java.lang.Object r10 = r1.get(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x009f
            int r10 = r10.intValue()
            int r7 = java.lang.Math.min(r7, r10)
        L_0x009f:
            int r9 = r9 + 1
            goto L_0x0083
        L_0x00a2:
            if (r7 == r5) goto L_0x00b9
            java.lang.Object r6 = r3.get(r5)
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r3.get(r7)
            java.util.List r7 = (java.util.List) r7
            r7.addAll(r6)
            r3.put(r5, r7)
            r2.remove(r6)
        L_0x00b9:
            int r5 = r5 + 1
            goto L_0x003f
        L_0x00bc:
            int r12 = r2.size()
            int[][] r0 = new int[r12][]
        L_0x00c2:
            if (r4 >= r12) goto L_0x00d6
            java.lang.Object r1 = r2.get(r4)
            java.util.Collection r1 = (java.util.Collection) r1
            int[] r1 = com.google.common.primitives.Ints.D(r1)
            r0[r4] = r1
            java.util.Arrays.sort(r1)
            int r4 = r4 + 1
            goto L_0x00c2
        L_0x00d6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaPeriod.C(java.util.List):int[][]");
    }

    private int D(int i2, int[] iArr) {
        int i4 = iArr[i2];
        if (i4 == -1) {
            return -1;
        }
        int i5 = this.e3[i4].f10968e;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            if (i7 == i5 && this.e3[i7].f10966c == 0) {
                return i6;
            }
        }
        return -1;
    }

    private int[] E(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                iArr[i2] = this.d3.f(exoTrackSelection.d());
            } else {
                iArr[i2] = -1;
            }
        }
        return iArr;
    }

    private static boolean F(List<AdaptationSet> list, int[] iArr) {
        for (int i2 : iArr) {
            List<Representation> list2 = list.get(i2).f11120c;
            for (int i4 = 0; i4 < list2.size(); i4++) {
                if (!list2.get(i4).f11186f.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int G(int i2, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (F(list, iArr[i5])) {
                zArr[i5] = true;
                i4++;
            }
            Format[] B = B(list, iArr[i5]);
            formatArr[i5] = B;
            if (B.length != 0) {
                i4++;
            }
        }
        return i4;
    }

    private static void I(DashChunkSource.Factory factory, Format[] formatArr) {
        for (int i2 = 0; i2 < formatArr.length; i2++) {
            formatArr[i2] = factory.c(formatArr[i2]);
        }
    }

    private static ChunkSampleStream<DashChunkSource>[] J(int i2) {
        return new ChunkSampleStream[i2];
    }

    private static Format[] L(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.f11160b;
        if (str == null) {
            return new Format[]{format};
        }
        String[] p2 = Util.p2(str, ";");
        Format[] formatArr = new Format[p2.length];
        for (int i2 = 0; i2 < p2.length; i2++) {
            Matcher matcher = pattern.matcher(p2[i2]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            Format.Builder c2 = format.c();
            formatArr[i2] = c2.X(format.s + ":" + parseInt).J(parseInt).b0(matcher.group(2)).I();
        }
        return formatArr;
    }

    private void N(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (exoTrackSelectionArr[i2] == null || !zArr[i2]) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream instanceof ChunkSampleStream) {
                    chunkSampleStream.Q(this);
                } else if (chunkSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) chunkSampleStream).c();
                }
                sampleStreamArr[i2] = null;
            }
        }
    }

    private void O(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z;
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int D = D(i2, iArr);
                if (D == -1) {
                    z = sampleStreamArr[i2] instanceof EmptySampleStream;
                } else {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = sampleStreamArr[i2];
                    z = (embeddedSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) && embeddedSampleStream.s == sampleStreamArr[D];
                }
                if (!z) {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream2 = sampleStreamArr[i2];
                    if (embeddedSampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        embeddedSampleStream2.c();
                    }
                    sampleStreamArr[i2] = null;
                }
            }
        }
    }

    private void P(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream == null) {
                    zArr[i2] = true;
                    TrackGroupInfo trackGroupInfo = this.e3[iArr[i2]];
                    int i4 = trackGroupInfo.f10966c;
                    if (i4 == 0) {
                        sampleStreamArr[i2] = w(trackGroupInfo, exoTrackSelection, j2);
                    } else if (i4 == 2) {
                        sampleStreamArr[i2] = new EventSampleStream(this.r3.get(trackGroupInfo.f10967d), exoTrackSelection.d().d(0), this.p3.f11134d);
                    }
                } else if (chunkSampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) chunkSampleStream.D()).c(exoTrackSelection);
                }
            }
        }
        for (int i5 = 0; i5 < exoTrackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && exoTrackSelectionArr[i5] != null) {
                TrackGroupInfo trackGroupInfo2 = this.e3[iArr[i5]];
                if (trackGroupInfo2.f10966c == 1) {
                    int D = D(i5, iArr);
                    if (D == -1) {
                        sampleStreamArr[i5] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i5] = sampleStreamArr[D].T(j2, trackGroupInfo2.f10965b);
                    }
                }
            }
        }
    }

    private static void u(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i2) {
        int i4 = 0;
        while (i4 < list.size()) {
            EventStream eventStream = list.get(i4);
            Format I = new Format.Builder().X(eventStream.a()).k0(MimeTypes.I0).I();
            trackGroupArr[i2] = new TrackGroup(eventStream.a() + ":" + i4, I);
            trackGroupInfoArr[i2] = TrackGroupInfo.c(i4);
            i4++;
            i2++;
        }
    }

    private static int v(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        String str;
        int i4;
        int i5;
        DashChunkSource.Factory factory2 = factory;
        List<AdaptationSet> list2 = list;
        char c2 = 0;
        int i6 = i2;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int[] iArr2 = iArr[i7];
            ArrayList arrayList = new ArrayList();
            for (int i9 : iArr2) {
                arrayList.addAll(list2.get(i9).f11120c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i10 = 0; i10 < size; i10++) {
                Format format = ((Representation) arrayList.get(i10)).f11183c;
                formatArr2[i10] = format.c().P(drmSessionManager.d(format)).I();
            }
            DrmSessionManager drmSessionManager2 = drmSessionManager;
            AdaptationSet adaptationSet = list2.get(iArr2[c2]);
            long j2 = adaptationSet.f11118a;
            if (j2 != -1) {
                str = Long.toString(j2);
            } else {
                str = "unset:" + i7;
            }
            int i11 = i8 + 1;
            if (zArr[i7]) {
                i4 = i8 + 2;
            } else {
                i4 = i11;
                i11 = -1;
            }
            if (formatArr[i7].length != 0) {
                i5 = i4 + 1;
            } else {
                i5 = i4;
                i4 = -1;
            }
            I(factory2, formatArr2);
            trackGroupArr[i8] = new TrackGroup(str, formatArr2);
            trackGroupInfoArr[i8] = TrackGroupInfo.d(adaptationSet.f11119b, iArr2, i8, i11, i4);
            if (i11 != -1) {
                String str2 = str + ":emsg";
                trackGroupArr[i11] = new TrackGroup(str2, new Format.Builder().X(str2).k0(MimeTypes.I0).I());
                trackGroupInfoArr[i11] = TrackGroupInfo.b(iArr2, i8);
            }
            if (i4 != -1) {
                trackGroupInfoArr[i4] = TrackGroupInfo.a(iArr2, i8, ImmutableList.D(formatArr[i7]));
                I(factory2, formatArr[i7]);
                trackGroupArr[i4] = new TrackGroup(str + ":cc", formatArr[i7]);
            }
            i7++;
            i8 = i5;
            c2 = 0;
        }
        return i8;
    }

    private ChunkSampleStream<DashChunkSource> w(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j2) {
        int i2;
        TrackGroup trackGroup;
        int i4;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        int i5 = trackGroupInfo2.f10969f;
        boolean z = i5 != -1;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z) {
            trackGroup = this.d3.d(i5);
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        int i6 = trackGroupInfo2.f10970g;
        ImmutableList<Format> I = i6 != -1 ? this.e3[i6].f10971h : ImmutableList.I();
        int size = i2 + I.size();
        Format[] formatArr = new Format[size];
        int[] iArr = new int[size];
        if (z) {
            formatArr[0] = trackGroup.d(0);
            iArr[0] = 5;
            i4 = 1;
        } else {
            i4 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < I.size(); i7++) {
            Format format = I.get(i7);
            formatArr[i4] = format;
            iArr[i4] = 3;
            arrayList.add(format);
            i4++;
        }
        if (this.p3.f11134d && z) {
            playerTrackEmsgHandler = this.g3.k();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.f10965b, iArr, formatArr, this.X.d(this.b3, this.p3, this.Z2, this.q3, trackGroupInfo2.f10964a, exoTrackSelection, trackGroupInfo2.f10965b, this.a3, z, arrayList, playerTrackEmsgHandler2, this.Y, this.k3, this.Z), this, this.c3, j2, this.X2, this.j3, this.Y2, this.i3);
        synchronized (this) {
            this.h3.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> x(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] C = C(list);
        int length = C.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int G = G(length, list, C, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[G];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[G];
        u(list2, trackGroupArr, trackGroupInfoArr, v(drmSessionManager, factory, list, C, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    @Nullable
    private static Descriptor y(List<Descriptor> list) {
        return z(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    private static Descriptor z(List<Descriptor> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (str.equals(descriptor.f11159a)) {
                return descriptor;
            }
        }
        return null;
    }

    /* renamed from: K */
    public void j(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.l3.j(this);
    }

    public void M() {
        this.g3.o();
        for (ChunkSampleStream<DashChunkSource> Q : this.m3) {
            Q.Q(this);
        }
        this.l3 = null;
    }

    public void Q(DashManifest dashManifest, int i2) {
        this.p3 = dashManifest;
        this.q3 = i2;
        this.g3.q(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.m3;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> D : chunkSampleStreamArr) {
                D.D().i(dashManifest, i2);
            }
            this.l3.j(this);
        }
        this.r3 = dashManifest.d(i2).f11170d;
        for (EventSampleStream eventSampleStream : this.n3) {
            Iterator<EventStream> it2 = this.r3.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                EventStream next = it2.next();
                if (next.a().equals(eventSampleStream.a())) {
                    boolean z = true;
                    int e2 = dashManifest.e() - 1;
                    if (!dashManifest.f11134d || i2 != e2) {
                        z = false;
                    }
                    eventSampleStream.e(next, z);
                }
            }
        }
    }

    public boolean a(LoadingInfo loadingInfo) {
        return this.o3.a(loadingInfo);
    }

    public boolean c() {
        return this.o3.c();
    }

    public synchronized void d(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.h3.remove(chunkSampleStream);
        if (remove != null) {
            remove.n();
        }
    }

    public long e() {
        return this.o3.e();
    }

    public long f(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.m3) {
            if (chunkSampleStream.s == 2) {
                return chunkSampleStream.f(j2, seekParameters);
            }
        }
        return j2;
    }

    public long g() {
        return this.o3.g();
    }

    public void h(long j2) {
        this.o3.h(j2);
    }

    public List<StreamKey> k(List<ExoTrackSelection> list) {
        List<AdaptationSet> list2 = this.p3.d(this.q3).f11169c;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection next : list) {
            TrackGroupInfo trackGroupInfo = this.e3[this.d3.f(next.d())];
            if (trackGroupInfo.f10966c == 0) {
                int[] iArr = trackGroupInfo.f10964a;
                int length = next.length();
                int[] iArr2 = new int[length];
                for (int i2 = 0; i2 < next.length(); i2++) {
                    iArr2[i2] = next.k(i2);
                }
                Arrays.sort(iArr2);
                int size = list2.get(iArr[0]).f11120c.size();
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < length; i6++) {
                    int i7 = iArr2[i6];
                    while (true) {
                        int i8 = i5 + size;
                        if (i7 < i8) {
                            break;
                        }
                        i4++;
                        size = list2.get(iArr[i4]).f11120c.size();
                        i5 = i8;
                    }
                    arrayList.add(new StreamKey(this.q3, iArr[i4], i7 - i5));
                }
            }
        }
        return arrayList;
    }

    public void l() throws IOException {
        this.b3.b();
    }

    public long m(long j2) {
        for (ChunkSampleStream<DashChunkSource> S : this.m3) {
            S.S(j2);
        }
        for (EventSampleStream c2 : this.n3) {
            c2.c(j2);
        }
        return j2;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        int[] E = E(exoTrackSelectionArr);
        N(exoTrackSelectionArr, zArr, sampleStreamArr);
        O(exoTrackSelectionArr, sampleStreamArr, E);
        P(exoTrackSelectionArr, sampleStreamArr, zArr2, j2, E);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChunkSampleStream chunkSampleStream : sampleStreamArr) {
            if (chunkSampleStream instanceof ChunkSampleStream) {
                arrayList.add(chunkSampleStream);
            } else if (chunkSampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) chunkSampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] J = J(arrayList.size());
        this.m3 = J;
        arrayList.toArray(J);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.n3 = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.o3 = this.f3.a(arrayList, Lists.D(arrayList, new c()));
        return j2;
    }

    public long q() {
        return C.f9084b;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.l3 = callback;
        callback.i(this);
    }

    public TrackGroupArray s() {
        return this.d3;
    }

    public void t(long j2, boolean z) {
        for (ChunkSampleStream<DashChunkSource> t : this.m3) {
            t.t(j2, z);
        }
    }
}
