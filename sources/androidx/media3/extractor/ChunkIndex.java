package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.util.Arrays;

@UnstableApi
public final class ChunkIndex implements SeekMap {

    /* renamed from: d  reason: collision with root package name */
    public final int f12973d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f12974e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f12975f;

    /* renamed from: g  reason: collision with root package name */
    public final long[] f12976g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f12977h;

    /* renamed from: i  reason: collision with root package name */
    private final long f12978i;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f12974e = iArr;
        this.f12975f = jArr;
        this.f12976g = jArr2;
        this.f12977h = jArr3;
        int length = iArr.length;
        this.f12973d = length;
        if (length > 0) {
            this.f12978i = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f12978i = 0;
        }
    }

    public int a(long j2) {
        return Util.n(this.f12977h, j2, true, true);
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        int a2 = a(j2);
        SeekPoint seekPoint = new SeekPoint(this.f12977h[a2], this.f12975f[a2]);
        if (seekPoint.f13117a >= j2 || a2 == this.f12973d - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = a2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f12977h[i2], this.f12975f[i2]));
    }

    public long l() {
        return this.f12978i;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f12973d + ", sizes=" + Arrays.toString(this.f12974e) + ", offsets=" + Arrays.toString(this.f12975f) + ", timeUs=" + Arrays.toString(this.f12977h) + ", durationsUs=" + Arrays.toString(this.f12976g) + ")";
    }
}
