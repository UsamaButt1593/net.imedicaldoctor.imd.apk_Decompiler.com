package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;

@UnstableApi
public abstract class BaseMediaChunk extends MediaChunk {

    /* renamed from: k  reason: collision with root package name */
    public final long f12259k;

    /* renamed from: l  reason: collision with root package name */
    public final long f12260l;

    /* renamed from: m  reason: collision with root package name */
    private BaseMediaChunkOutput f12261m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f12262n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j6);
        this.f12259k = j4;
        this.f12260l = j5;
    }

    public final int i(int i2) {
        return ((int[]) Assertions.k(this.f12262n))[i2];
    }

    /* access modifiers changed from: protected */
    public final BaseMediaChunkOutput j() {
        return (BaseMediaChunkOutput) Assertions.k(this.f12261m);
    }

    public void k(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.f12261m = baseMediaChunkOutput;
        this.f12262n = baseMediaChunkOutput.a();
    }
}
