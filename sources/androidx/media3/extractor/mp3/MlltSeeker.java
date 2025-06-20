package androidx.media3.extractor.mp3;

import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.metadata.id3.MlltFrame;

final class MlltSeeker implements Seeker {

    /* renamed from: d  reason: collision with root package name */
    private final long[] f13462d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f13463e;

    /* renamed from: f  reason: collision with root package name */
    private final long f13464f;

    private MlltSeeker(long[] jArr, long[] jArr2, long j2) {
        this.f13462d = jArr;
        this.f13463e = jArr2;
        this.f13464f = j2 == C.f9084b ? Util.I1(jArr2[jArr2.length - 1]) : j2;
    }

    public static MlltSeeker a(long j2, MlltFrame mlltFrame, long j3) {
        int length = mlltFrame.X2.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j4 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (mlltFrame.Y + mlltFrame.X2[i4]);
            j4 += (long) (mlltFrame.Z + mlltFrame.Y2[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j4;
        }
        return new MlltSeeker(jArr, jArr2, j3);
    }

    private static Pair<Long, Long> c(long j2, long[] jArr, long[] jArr2) {
        Long valueOf;
        Long valueOf2;
        int n2 = Util.n(jArr, j2, true, true);
        long j3 = jArr[n2];
        long j4 = jArr2[n2];
        int i2 = n2 + 1;
        if (i2 == jArr.length) {
            valueOf = Long.valueOf(j3);
            valueOf2 = Long.valueOf(j4);
        } else {
            long j5 = jArr[i2];
            long j6 = jArr2[i2];
            double d2 = j5 == j3 ? 0.0d : (((double) j2) - ((double) j3)) / ((double) (j5 - j3));
            valueOf = Long.valueOf(j2);
            valueOf2 = Long.valueOf(((long) (d2 * ((double) (j6 - j4)))) + j4);
        }
        return Pair.create(valueOf, valueOf2);
    }

    public long b(long j2) {
        return Util.I1(((Long) c(j2, this.f13462d, this.f13463e).second).longValue());
    }

    public long f() {
        return -1;
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        Pair<Long, Long> c2 = c(Util.H2(Util.x(j2, 0, this.f13464f)), this.f13463e, this.f13462d);
        return new SeekMap.SeekPoints(new SeekPoint(Util.I1(((Long) c2.first).longValue()), ((Long) c2.second).longValue()));
    }

    public int k() {
        return C.f9088f;
    }

    public long l() {
        return this.f13464f;
    }
}
