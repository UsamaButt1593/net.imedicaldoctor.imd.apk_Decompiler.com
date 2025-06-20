package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class SeekParameters {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekParameters f10447c;

    /* renamed from: d  reason: collision with root package name */
    public static final SeekParameters f10448d = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final SeekParameters f10449e = new SeekParameters(Long.MAX_VALUE, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final SeekParameters f10450f = new SeekParameters(0, Long.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final SeekParameters f10451g;

    /* renamed from: a  reason: collision with root package name */
    public final long f10452a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10453b;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        f10447c = seekParameters;
        f10451g = seekParameters;
    }

    public SeekParameters(long j2, long j3) {
        boolean z = false;
        Assertions.a(j2 >= 0);
        Assertions.a(j3 >= 0 ? true : z);
        this.f10452a = j2;
        this.f10453b = j3;
    }

    public long a(long j2, long j3, long j4) {
        long j5 = this.f10452a;
        if (j5 == 0 && this.f10453b == 0) {
            return j2;
        }
        long t2 = Util.t2(j2, j5, Long.MIN_VALUE);
        long f2 = Util.f(j2, this.f10453b, Long.MAX_VALUE);
        boolean z = false;
        boolean z2 = t2 <= j3 && j3 <= f2;
        if (t2 <= j4 && j4 <= f2) {
            z = true;
        }
        if (z2 && z) {
            return Math.abs(j3 - j2) <= Math.abs(j4 - j2) ? j3 : j4;
        }
        if (z2) {
            return j3;
        }
        return z ? j4 : t2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        return this.f10452a == seekParameters.f10452a && this.f10453b == seekParameters.f10453b;
    }

    public int hashCode() {
        return (((int) this.f10452a) * 31) + ((int) this.f10453b);
    }
}
