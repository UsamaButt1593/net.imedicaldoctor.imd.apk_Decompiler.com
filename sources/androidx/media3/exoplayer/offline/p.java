package androidx.media3.exoplayer.offline;

import androidx.media3.datasource.cache.CacheWriter;

public final /* synthetic */ class p implements CacheWriter.ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgressiveDownloader f11870a;

    public /* synthetic */ p(ProgressiveDownloader progressiveDownloader) {
        this.f11870a = progressiveDownloader;
    }

    public final void a(long j2, long j3, long j4) {
        this.f11870a.d(j2, j3, j4);
    }
}
