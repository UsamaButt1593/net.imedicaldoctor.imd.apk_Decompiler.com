package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

@UnstableApi
public final class IndexSeekMap implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    private final long[] f13083d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f13084e;

    /* renamed from: f  reason: collision with root package name */
    private final long f13085f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13086g;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j2) {
        Assertions.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.f13086g = z;
        if (!z || jArr2[0] <= 0) {
            this.f13083d = jArr;
            this.f13084e = jArr2;
        } else {
            int i2 = length + 1;
            long[] jArr3 = new long[i2];
            this.f13083d = jArr3;
            long[] jArr4 = new long[i2];
            this.f13084e = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f13085f = j2;
    }

    public boolean g() {
        return this.f13086g;
    }

    public SeekMap.SeekPoints j(long j2) {
        if (!this.f13086g) {
            return new SeekMap.SeekPoints(SeekPoint.f13116c);
        }
        int n2 = Util.n(this.f13084e, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f13084e[n2], this.f13083d[n2]);
        if (seekPoint.f13117a == j2 || n2 == this.f13084e.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = n2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f13084e[i2], this.f13083d[i2]));
    }

    public long l() {
        return this.f13085f;
    }
}
