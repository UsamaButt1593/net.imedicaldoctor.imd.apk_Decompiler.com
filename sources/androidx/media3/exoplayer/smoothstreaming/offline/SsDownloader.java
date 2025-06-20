package androidx.media3.exoplayer.smoothstreaming.offline;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public final class SsDownloader extends SegmentDownloader<SsManifest> {
    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public List<SegmentDownloader.Segment> h(DataSource dataSource, SsManifest ssManifest, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (SsManifest.StreamElement streamElement : ssManifest.f12020f) {
            for (int i2 = 0; i2 < streamElement.f12035j.length; i2++) {
                for (int i3 = 0; i3 < streamElement.f12036k; i3++) {
                    arrayList.add(new SegmentDownloader.Segment(streamElement.e(i3), new DataSpec(streamElement.a(i2, i3))));
                }
            }
        }
        return arrayList;
    }

    public SsDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem.b().M(Util.R(((MediaItem.LocalConfiguration) Assertions.g(mediaItem.X)).s)).a(), new SsManifestParser(), factory, executor, 20000);
    }

    @Deprecated
    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000);
    }

    public SsDownloader(MediaItem mediaItem, ParsingLoadable.Parser<SsManifest> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        super(mediaItem, parser, factory, executor, j2);
    }
}
