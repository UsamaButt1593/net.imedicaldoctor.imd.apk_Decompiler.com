package androidx.media3.exoplayer.dash;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.dash.manifest.RangedUri;

@UnstableApi
public interface DashSegmentIndex {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10985a = -1;

    long b(long j2);

    long c(long j2, long j3);

    long d(long j2, long j3);

    long e(long j2, long j3);

    RangedUri f(long j2);

    long g(long j2, long j3);

    boolean h();

    long i();

    long j(long j2);

    long k(long j2, long j3);
}
