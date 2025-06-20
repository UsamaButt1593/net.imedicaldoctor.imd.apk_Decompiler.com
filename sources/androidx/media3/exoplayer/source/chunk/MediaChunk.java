package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;

@UnstableApi
public abstract class MediaChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    public final long f12296j;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, long j2, long j3, long j4) {
        super(dataSource, dataSpec, 1, format, i2, obj, j2, j3);
        Assertions.g(format);
        this.f12296j = j4;
    }

    public long g() {
        long j2 = this.f12296j;
        if (j2 != -1) {
            return 1 + j2;
        }
        return -1;
    }

    public abstract boolean h();
}
