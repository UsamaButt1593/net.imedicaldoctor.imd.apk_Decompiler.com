package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

@UnstableApi
public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private final int o;
    private final Format p;
    private long q;
    private boolean r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, long j2, long j3, long j4, int i3, Format format2) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, C.f9084b, C.f9084b, j4);
        this.o = i3;
        this.p = format2;
    }

    public void a() throws IOException {
        BaseMediaChunkOutput j2 = j();
        j2.b(0);
        TrackOutput d2 = j2.d(0, this.o);
        d2.e(this.p);
        try {
            long a2 = this.f12286i.a(this.f12279b.e(this.q));
            if (a2 != -1) {
                a2 += this.q;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f12286i, this.q, a2);
            for (int i2 = 0; i2 != -1; i2 = d2.b(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.q += (long) i2;
            }
            d2.f(this.f12284g, 1, (int) this.q, 0, (TrackOutput.CryptoData) null);
            DataSourceUtil.a(this.f12286i);
            this.r = true;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f12286i);
            throw th;
        }
    }

    public void c() {
    }

    public boolean h() {
        return this.r;
    }
}
