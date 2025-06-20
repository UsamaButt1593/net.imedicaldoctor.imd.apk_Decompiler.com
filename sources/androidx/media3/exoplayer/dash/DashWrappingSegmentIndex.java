package androidx.media3.exoplayer.dash;

import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.extractor.ChunkIndex;

@UnstableApi
public final class DashWrappingSegmentIndex implements DashSegmentIndex {

    /* renamed from: b  reason: collision with root package name */
    private final ChunkIndex f10986b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10987c;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex, long j2) {
        this.f10986b = chunkIndex;
        this.f10987c = j2;
    }

    public long b(long j2) {
        return this.f10986b.f12977h[(int) j2] - this.f10987c;
    }

    public long c(long j2, long j3) {
        return this.f10986b.f12976g[(int) j2];
    }

    public long d(long j2, long j3) {
        return 0;
    }

    public long e(long j2, long j3) {
        return C.f9084b;
    }

    public RangedUri f(long j2) {
        ChunkIndex chunkIndex = this.f10986b;
        int i2 = (int) j2;
        return new RangedUri((String) null, chunkIndex.f12975f[i2], (long) chunkIndex.f12974e[i2]);
    }

    public long g(long j2, long j3) {
        return (long) this.f10986b.a(j2 + this.f10987c);
    }

    public boolean h() {
        return true;
    }

    public long i() {
        return 0;
    }

    public long j(long j2) {
        return (long) this.f10986b.f12973d;
    }

    public long k(long j2, long j3) {
        return (long) this.f10986b.f12973d;
    }
}
