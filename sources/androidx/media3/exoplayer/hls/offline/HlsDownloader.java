package androidx.media3.exoplayer.hls.offline;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public final class HlsDownloader extends SegmentDownloader<HlsPlaylist> {
    public HlsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new a());
    }

    private void l(List<Uri> list, List<DataSpec> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list2.add(SegmentDownloader.f(list.get(i2)));
        }
    }

    private void m(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.Segment segment, HashSet<Uri> hashSet, ArrayList<SegmentDownloader.Segment> arrayList) {
        String str = hlsMediaPlaylist.f11597a;
        long j2 = hlsMediaPlaylist.f11561h + segment.X2;
        String str2 = segment.Z2;
        if (str2 != null) {
            Uri g2 = UriUtil.g(str, str2);
            if (hashSet.add(g2)) {
                arrayList.add(new SegmentDownloader.Segment(j2, SegmentDownloader.f(g2)));
            }
        }
        arrayList.add(new SegmentDownloader.Segment(j2, new DataSpec(UriUtil.g(str, segment.s), segment.b3, segment.c3)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, HlsPlaylist hlsPlaylist, boolean z) throws IOException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        if (hlsPlaylist instanceof HlsMultivariantPlaylist) {
            l(((HlsMultivariantPlaylist) hlsPlaylist).f11577d, arrayList);
        } else {
            arrayList.add(SegmentDownloader.f(Uri.parse(hlsPlaylist.f11597a)));
        }
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            DataSpec dataSpec = (DataSpec) it2.next();
            arrayList2.add(new SegmentDownloader.Segment(0, dataSpec));
            try {
                HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) g(dataSource, dataSpec, z);
                List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.r;
                HlsMediaPlaylist.Segment segment = null;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    HlsMediaPlaylist.Segment segment2 = list.get(i2);
                    HlsMediaPlaylist.Segment segment3 = segment2.X;
                    if (!(segment3 == null || segment3 == segment)) {
                        m(hlsMediaPlaylist, segment3, hashSet, arrayList2);
                        segment = segment3;
                    }
                    m(hlsMediaPlaylist, segment2, hashSet, arrayList2);
                }
            } catch (IOException e2) {
                if (!z) {
                    throw e2;
                }
            }
        }
        return arrayList2;
    }

    public HlsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, new HlsPlaylistParser(), factory, executor, 20000);
    }

    @Deprecated
    public HlsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<HlsPlaylist> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000);
    }

    public HlsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<HlsPlaylist> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
    }
}
