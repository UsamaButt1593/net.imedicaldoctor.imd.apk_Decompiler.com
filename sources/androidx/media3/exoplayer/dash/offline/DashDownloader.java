package androidx.media3.exoplayer.dash.offline;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.BaseUrlExclusionList;
import androidx.media3.exoplayer.dash.DashSegmentIndex;
import androidx.media3.exoplayer.dash.DashUtil;
import androidx.media3.exoplayer.dash.DashWrappingSegmentIndex;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.ChunkIndex;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public final class DashDownloader extends SegmentDownloader<DashManifest> {

    /* renamed from: n  reason: collision with root package name */
    private final BaseUrlExclusionList f11233n;

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(androidx.media3.datasource.DataSource r27, androidx.media3.exoplayer.dash.manifest.AdaptationSet r28, long r29, long r31, boolean r33, java.util.ArrayList<androidx.media3.exoplayer.offline.SegmentDownloader.Segment> r34) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r26 = this;
            r7 = r26
            r8 = r28
            r9 = r33
            r10 = r34
            r0 = 0
            r11 = 0
        L_0x000a:
            java.util.List<androidx.media3.exoplayer.dash.manifest.Representation> r0 = r8.f11120c
            int r0 = r0.size()
            if (r11 >= r0) goto L_0x00bd
            java.util.List<androidx.media3.exoplayer.dash.manifest.Representation> r0 = r8.f11120c
            java.lang.Object r0 = r0.get(r11)
            androidx.media3.exoplayer.dash.manifest.Representation r0 = (androidx.media3.exoplayer.dash.manifest.Representation) r0
            int r1 = r8.f11119b     // Catch:{ IOException -> 0x00b2 }
            r12 = r27
            androidx.media3.exoplayer.dash.DashSegmentIndex r13 = r7.n(r12, r1, r0, r9)     // Catch:{ IOException -> 0x00ae }
            if (r13 == 0) goto L_0x00a2
            r14 = r31
            long r16 = r13.j(r14)
            r1 = -1
            int r3 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x009a
            androidx.media3.exoplayer.dash.BaseUrlExclusionList r1 = r7.f11233n
            com.google.common.collect.ImmutableList<androidx.media3.exoplayer.dash.manifest.BaseUrl> r2 = r0.f11184d
            androidx.media3.exoplayer.dash.manifest.BaseUrl r1 = r1.j(r2)
            java.lang.Object r1 = androidx.media3.common.util.Util.o(r1)
            androidx.media3.exoplayer.dash.manifest.BaseUrl r1 = (androidx.media3.exoplayer.dash.manifest.BaseUrl) r1
            java.lang.String r6 = r1.f11127a
            androidx.media3.exoplayer.dash.manifest.RangedUri r18 = r0.n()
            if (r18 == 0) goto L_0x0058
            r1 = r26
            r2 = r0
            r3 = r6
            r4 = r29
            r19 = r6
            r6 = r18
            androidx.media3.exoplayer.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            goto L_0x005a
        L_0x0058:
            r19 = r6
        L_0x005a:
            androidx.media3.exoplayer.dash.manifest.RangedUri r6 = r0.m()
            if (r6 == 0) goto L_0x006e
            r1 = r26
            r2 = r0
            r3 = r19
            r4 = r29
            androidx.media3.exoplayer.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
        L_0x006e:
            long r1 = r13.i()
            long r16 = r1 + r16
            r20 = 1
            long r16 = r16 - r20
            r4 = r1
        L_0x0079:
            int r1 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x00b8
            long r1 = r13.b(r4)
            long r22 = r29 + r1
            androidx.media3.exoplayer.dash.manifest.RangedUri r6 = r13.f(r4)
            r1 = r26
            r2 = r0
            r3 = r19
            r24 = r4
            r4 = r22
            androidx.media3.exoplayer.offline.SegmentDownloader$Segment r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            long r4 = r24 + r20
            goto L_0x0079
        L_0x009a:
            androidx.media3.exoplayer.offline.DownloadException r0 = new androidx.media3.exoplayer.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x00a2:
            r14 = r31
            androidx.media3.exoplayer.offline.DownloadException r0 = new androidx.media3.exoplayer.offline.DownloadException     // Catch:{ IOException -> 0x00ac }
            java.lang.String r1 = "Missing segment index"
            r0.<init>((java.lang.String) r1)     // Catch:{ IOException -> 0x00ac }
            throw r0     // Catch:{ IOException -> 0x00ac }
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b6
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            r14 = r31
            goto L_0x00b6
        L_0x00b2:
            r0 = move-exception
            r12 = r27
            goto L_0x00af
        L_0x00b6:
            if (r9 == 0) goto L_0x00bc
        L_0x00b8:
            int r11 = r11 + 1
            goto L_0x000a
        L_0x00bc:
            throw r0
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.offline.DashDownloader.l(androidx.media3.datasource.DataSource, androidx.media3.exoplayer.dash.manifest.AdaptationSet, long, long, boolean, java.util.ArrayList):void");
    }

    private SegmentDownloader.Segment m(Representation representation, String str, long j2, RangedUri rangedUri) {
        return new SegmentDownloader.Segment(j2, DashUtil.c(representation, str, rangedUri, 0, ImmutableMap.s()));
    }

    @Nullable
    private DashSegmentIndex n(final DataSource dataSource, final int i2, final Representation representation, boolean z) throws IOException, InterruptedException {
        DashSegmentIndex l2 = representation.l();
        if (l2 != null) {
            return l2;
        }
        ChunkIndex chunkIndex = (ChunkIndex) e(new RunnableFutureTask<ChunkIndex, IOException>() {
            /* access modifiers changed from: protected */
            /* renamed from: f */
            public ChunkIndex d() throws IOException {
                return DashUtil.e(dataSource, i2, representation);
            }
        }, z);
        if (chunkIndex == null) {
            return null;
        }
        return new DashWrappingSegmentIndex(chunkIndex, representation.f11185e);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, DashManifest dashManifest, boolean z) throws IOException, InterruptedException {
        DashManifest dashManifest2 = dashManifest;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < dashManifest.e(); i2++) {
            Period d2 = dashManifest2.d(i2);
            long I1 = Util.I1(d2.f11168b);
            long g2 = dashManifest2.g(i2);
            int i3 = 0;
            for (List<AdaptationSet> list = d2.f11169c; i3 < list.size(); list = list) {
                l(dataSource, list.get(i3), I1, g2, z, arrayList);
                i3++;
            }
        }
        return arrayList;
    }

    public DashDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new DashManifestParser(), factory, executor, 20000);
    }

    @Deprecated
    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000);
    }

    public DashDownloader(MediaItem mediaItem, ParsingLoadable.Parser<DashManifest> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
        this.f11233n = new BaseUrlExclusionList();
    }
}
