package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

final class TrackSampleTable {

    /* renamed from: a  reason: collision with root package name */
    public final Track f13689a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13690b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f13691c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f13692d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13693e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f13694f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f13695g;

    /* renamed from: h  reason: collision with root package name */
    public final long f13696h;

    public TrackSampleTable(Track track, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
        boolean z = false;
        Assertions.a(iArr.length == jArr2.length);
        Assertions.a(jArr.length == jArr2.length);
        Assertions.a(iArr2.length == jArr2.length ? true : z);
        this.f13689a = track;
        this.f13691c = jArr;
        this.f13692d = iArr;
        this.f13693e = i2;
        this.f13694f = jArr2;
        this.f13695g = iArr2;
        this.f13696h = j2;
        this.f13690b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j2) {
        for (int n2 = Util.n(this.f13694f, j2, true, false); n2 >= 0; n2--) {
            if ((this.f13695g[n2] & 1) != 0) {
                return n2;
            }
        }
        return -1;
    }

    public int b(long j2) {
        for (int j3 = Util.j(this.f13694f, j2, true, false); j3 < this.f13694f.length; j3++) {
            if ((this.f13695g[j3] & 1) != 0) {
                return j3;
            }
        }
        return -1;
    }
}
