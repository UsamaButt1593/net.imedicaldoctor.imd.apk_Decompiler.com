package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;
import java.io.IOException;

@UnstableApi
public final class InitializationChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    private final ChunkExtractor f12292j;

    /* renamed from: k  reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f12293k;

    /* renamed from: l  reason: collision with root package name */
    private long f12294l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f12295m;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, 2, format, i2, obj, C.f9084b, C.f9084b);
        this.f12292j = chunkExtractor;
    }

    public void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        if (this.f12294l == 0) {
            this.f12292j.e(this.f12293k, C.f9084b, C.f9084b);
        }
        try {
            DataSpec e2 = this.f12279b.e(this.f12294l);
            StatsDataSource statsDataSource = this.f12286i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f9785g, statsDataSource.a(e2));
            do {
                if (this.f12295m || !this.f12292j.b(defaultExtractorInput)) {
                    break;
                }
                break;
                break;
            } while (!this.f12292j.b(defaultExtractorInput));
            break;
            this.f12294l = defaultExtractorInput.getPosition() - this.f12279b.f9785g;
            DataSourceUtil.a(this.f12286i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f12286i);
            throw th;
        }
    }

    public void c() {
        this.f12295m = true;
    }

    public void g(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f12293k = trackOutputProvider;
    }
}
