package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

@UnstableApi
public class ContainerMediaChunk extends BaseMediaChunk {
    private final int o;
    private final long p;
    private final ChunkExtractor q;
    private long r;
    private volatile boolean s;
    private boolean t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, ChunkExtractor chunkExtractor) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4, j5, j6);
        this.o = i3;
        this.p = j7;
        this.q = chunkExtractor;
    }

    private void m(BaseMediaChunkOutput baseMediaChunkOutput) {
        if (MimeTypes.q(this.f12281d.e3)) {
            Format format = this.f12281d;
            int i2 = format.z3;
            if ((i2 > 1 || format.A3 > 1) && i2 != -1 && format.A3 != -1) {
                TrackOutput d2 = baseMediaChunkOutput.d(0, 4);
                Format format2 = this.f12281d;
                int i3 = format2.A3 * format2.z3;
                long j2 = (this.f12285h - this.f12284g) / ((long) i3);
                for (int i4 = 1; i4 < i3; i4++) {
                    d2.d(new ParsableByteArray(), 0);
                    d2.f(((long) i4) * j2, 0, 0, 0, (TrackOutput.CryptoData) null);
                }
            }
        }
    }

    public final void a() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        BaseMediaChunkOutput j2 = j();
        if (this.r == 0) {
            j2.b(this.p);
            ChunkExtractor chunkExtractor = this.q;
            ChunkExtractor.TrackOutputProvider l2 = l(j2);
            long j3 = this.f12259k;
            long j4 = j3 == C.f9084b ? -9223372036854775807L : j3 - this.p;
            long j5 = this.f12260l;
            chunkExtractor.e(l2, j4, j5 == C.f9084b ? -9223372036854775807L : j5 - this.p);
        }
        try {
            DataSpec e2 = this.f12279b.e(this.r);
            StatsDataSource statsDataSource = this.f12286i;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, e2.f9785g, statsDataSource.a(e2));
            while (!this.s && this.q.b(defaultExtractorInput)) {
            }
            m(j2);
            this.r = defaultExtractorInput.getPosition() - this.f12279b.f9785g;
            DataSourceUtil.a(this.f12286i);
            this.t = !this.s;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f12286i);
            throw th;
        }
    }

    public final void c() {
        this.s = true;
    }

    public long g() {
        return this.f12296j + ((long) this.o);
    }

    public boolean h() {
        return this.t;
    }

    /* access modifiers changed from: protected */
    public ChunkExtractor.TrackOutputProvider l(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
