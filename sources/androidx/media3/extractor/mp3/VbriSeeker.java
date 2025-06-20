package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class VbriSeeker implements Seeker {

    /* renamed from: i  reason: collision with root package name */
    private static final String f13476i = "VbriSeeker";

    /* renamed from: d  reason: collision with root package name */
    private final long[] f13477d;

    /* renamed from: e  reason: collision with root package name */
    private final long[] f13478e;

    /* renamed from: f  reason: collision with root package name */
    private final long f13479f;

    /* renamed from: g  reason: collision with root package name */
    private final long f13480g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13481h;

    private VbriSeeker(long[] jArr, long[] jArr2, long j2, long j3, int i2) {
        this.f13477d = jArr;
        this.f13478e = jArr2;
        this.f13479f = j2;
        this.f13480g = j3;
        this.f13481h = i2;
    }

    @Nullable
    public static VbriSeeker a(long j2, long j3, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int i2;
        long j4 = j2;
        MpegAudioUtil.Header header2 = header;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.Z(10);
        int s = parsableByteArray.s();
        if (s <= 0) {
            return null;
        }
        int i3 = header2.f13103d;
        long c2 = Util.c2((long) s, ((long) (i3 >= 32000 ? 1152 : 576)) * 1000000, (long) i3);
        int R = parsableByteArray.R();
        int R2 = parsableByteArray.R();
        int R3 = parsableByteArray.R();
        parsableByteArray2.Z(2);
        long j5 = j3 + ((long) header2.f13102c);
        long[] jArr = new long[R];
        long[] jArr2 = new long[R];
        int i4 = 0;
        long j6 = j3;
        while (i4 < R) {
            int i5 = R2;
            jArr[i4] = (((long) i4) * c2) / ((long) R);
            long j7 = j5;
            jArr2[i4] = Math.max(j6, j7);
            if (R3 == 1) {
                i2 = parsableByteArray.L();
            } else if (R3 == 2) {
                i2 = parsableByteArray.R();
            } else if (R3 == 3) {
                i2 = parsableByteArray.O();
            } else if (R3 != 4) {
                return null;
            } else {
                i2 = parsableByteArray.P();
            }
            long j8 = (long) i2;
            int i6 = i5;
            j6 += j8 * ((long) i6);
            i4++;
            ParsableByteArray parsableByteArray3 = parsableByteArray;
            R = R;
            R2 = i6;
            j5 = j7;
        }
        if (!(j4 == -1 || j4 == j6)) {
            Log.n(f13476i, "VBRI data size mismatch: " + j4 + ", " + j6);
        }
        return new VbriSeeker(jArr, jArr2, c2, j6, header2.f13105f);
    }

    public long b(long j2) {
        return this.f13477d[Util.n(this.f13478e, j2, true, true)];
    }

    public long f() {
        return this.f13480g;
    }

    public boolean g() {
        return true;
    }

    public SeekMap.SeekPoints j(long j2) {
        int n2 = Util.n(this.f13477d, j2, true, true);
        SeekPoint seekPoint = new SeekPoint(this.f13477d[n2], this.f13478e[n2]);
        if (seekPoint.f13117a >= j2 || n2 == this.f13477d.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i2 = n2 + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.f13477d[i2], this.f13478e[i2]));
    }

    public int k() {
        return this.f13481h;
    }

    public long l() {
        return this.f13479f;
    }
}
