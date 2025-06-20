package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;

@UnstableApi
public final class FlacSeekTableSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final FlacStreamMetadata f13045d;

    /* renamed from: e  reason: collision with root package name */
    private final long f13046e;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j2) {
        this.f13045d = flacStreamMetadata;
        this.f13046e = j2;
    }

    private SeekPoint a(long j2, long j3) {
        return new SeekPoint((j2 * 1000000) / ((long) this.f13045d.f13053e), this.f13046e + j3);
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        Assertions.k(this.f13045d.f13059k);
        FlacStreamMetadata flacStreamMetadata = this.f13045d;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.f13059k;
        long[] jArr = seekTable.f13061a;
        long[] jArr2 = seekTable.f13062b;
        int n2 = Util.n(jArr, flacStreamMetadata.l(j2), true, false);
        long j3 = 0;
        long j4 = n2 == -1 ? 0 : jArr[n2];
        if (n2 != -1) {
            j3 = jArr2[n2];
        }
        SeekPoint a2 = a(j4, j3);
        if (a2.f13117a == j2 || n2 == jArr.length - 1) {
            return new SeekMap.SeekPoints(a2);
        }
        int i2 = n2 + 1;
        return new SeekMap.SeekPoints(a2, a(jArr[i2], jArr2[i2]));
    }

    public long l() {
        return this.f13045d.h();
    }
}
