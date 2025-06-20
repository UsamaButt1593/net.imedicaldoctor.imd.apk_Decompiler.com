package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.C;
import androidx.media3.exoplayer.dash.DashSegmentIndex;

final class SingleSegmentIndex implements DashSegmentIndex {

    /* renamed from: b  reason: collision with root package name */
    private final RangedUri f11217b;

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.f11217b = rangedUri;
    }

    public long b(long j2) {
        return 0;
    }

    public long c(long j2, long j3) {
        return j3;
    }

    public long d(long j2, long j3) {
        return 0;
    }

    public long e(long j2, long j3) {
        return C.f9084b;
    }

    public RangedUri f(long j2) {
        return this.f11217b;
    }

    public long g(long j2, long j3) {
        return 0;
    }

    public boolean h() {
        return true;
    }

    public long i() {
        return 0;
    }

    public long j(long j2) {
        return 1;
    }

    public long k(long j2, long j3) {
        return 1;
    }
}
