package androidx.media3.exoplayer.source.ads;

import androidx.annotation.CheckResult;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;

@UnstableApi
public final class ServerSideAdInsertionUtil {
    private ServerSideAdInsertionUtil() {
    }

    @CheckResult
    public static AdPlaybackState a(AdPlaybackState adPlaybackState, long j2, long j3, long... jArr) {
        long f2 = f(j2, -1, adPlaybackState);
        int i2 = adPlaybackState.X2;
        while (i2 < adPlaybackState.X && adPlaybackState.f(i2).s != Long.MIN_VALUE && adPlaybackState.f(i2).s <= f2) {
            i2++;
        }
        int i3 = 0;
        AdPlaybackState v = adPlaybackState.z(i2, f2).w(i2, true).l(i2, jArr.length).m(i2, jArr).v(i2, j3);
        while (i3 < jArr.length && jArr[i3] == 0) {
            v = v.E(i2, i3);
            i3++;
        }
        return b(v, i2, Util.u2(jArr), j3);
    }

    private static AdPlaybackState b(AdPlaybackState adPlaybackState, int i2, long j2, long j3) {
        long j4 = (-j2) + j3;
        while (true) {
            i2++;
            if (i2 >= adPlaybackState.X) {
                return adPlaybackState;
            }
            long j5 = adPlaybackState.f(i2).s;
            if (j5 != Long.MIN_VALUE) {
                adPlaybackState = adPlaybackState.o(i2, j5 + j4);
            }
        }
    }

    public static int c(AdPlaybackState adPlaybackState, int i2) {
        int i3 = adPlaybackState.f(i2).X;
        if (i3 == -1) {
            return 0;
        }
        return i3;
    }

    public static long d(long j2, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? e(j2, mediaPeriodId.f12164b, mediaPeriodId.f12165c, adPlaybackState) : f(j2, mediaPeriodId.f12167e, adPlaybackState);
    }

    public static long e(long j2, int i2, int i3, AdPlaybackState adPlaybackState) {
        int i4;
        AdPlaybackState.AdGroup f2 = adPlaybackState.f(i2);
        long j3 = j2 - f2.s;
        int i5 = adPlaybackState.X2;
        while (true) {
            i4 = 0;
            if (i5 >= i2) {
                break;
            }
            AdPlaybackState.AdGroup f3 = adPlaybackState.f(i5);
            while (i4 < c(adPlaybackState, i5)) {
                j3 -= f3.Z2[i4];
                i4++;
            }
            j3 += f3.a3;
            i5++;
        }
        if (i3 < c(adPlaybackState, i2)) {
            while (i4 < i3) {
                j3 -= f2.Z2[i4];
                i4++;
            }
        }
        return j3;
    }

    public static long f(long j2, int i2, AdPlaybackState adPlaybackState) {
        if (i2 == -1) {
            i2 = adPlaybackState.X;
        }
        long j3 = 0;
        for (int i3 = adPlaybackState.X2; i3 < i2; i3++) {
            AdPlaybackState.AdGroup f2 = adPlaybackState.f(i3);
            long j4 = f2.s;
            if (j4 == Long.MIN_VALUE || j4 > j2 - j3) {
                break;
            }
            for (int i4 = 0; i4 < c(adPlaybackState, i3); i4++) {
                j3 += f2.Z2[i4];
            }
            long j5 = f2.a3;
            j3 -= j5;
            long j6 = f2.s;
            long j7 = j2 - j3;
            if (j5 + j6 > j7) {
                return Math.max(j6, j7);
            }
        }
        return j2 - j3;
    }

    public static long g(long j2, MediaSource.MediaPeriodId mediaPeriodId, AdPlaybackState adPlaybackState) {
        return mediaPeriodId.c() ? i(j2, mediaPeriodId.f12164b, mediaPeriodId.f12165c, adPlaybackState) : j(j2, mediaPeriodId.f12167e, adPlaybackState);
    }

    public static long h(Player player, AdPlaybackState adPlaybackState) {
        Timeline j2 = player.j2();
        if (j2.x()) {
            return C.f9084b;
        }
        Timeline.Period k2 = j2.k(player.B0(), new Timeline.Period());
        if (!Util.g(k2.l(), adPlaybackState.s)) {
            return C.f9084b;
        }
        if (!player.c0()) {
            return j(Util.I1(player.z2()) - k2.s(), -1, adPlaybackState);
        }
        return i(Util.I1(player.z2()), player.O1(), player.O0(), adPlaybackState);
    }

    public static long i(long j2, int i2, int i3, AdPlaybackState adPlaybackState) {
        int i4;
        AdPlaybackState.AdGroup f2 = adPlaybackState.f(i2);
        long j3 = j2 + f2.s;
        int i5 = adPlaybackState.X2;
        while (true) {
            i4 = 0;
            if (i5 >= i2) {
                break;
            }
            AdPlaybackState.AdGroup f3 = adPlaybackState.f(i5);
            while (i4 < c(adPlaybackState, i5)) {
                j3 += f3.Z2[i4];
                i4++;
            }
            j3 -= f3.a3;
            i5++;
        }
        if (i3 < c(adPlaybackState, i2)) {
            while (i4 < i3) {
                j3 += f2.Z2[i4];
                i4++;
            }
        }
        return j3;
    }

    public static long j(long j2, int i2, AdPlaybackState adPlaybackState) {
        if (i2 == -1) {
            i2 = adPlaybackState.X;
        }
        long j3 = 0;
        for (int i3 = adPlaybackState.X2; i3 < i2; i3++) {
            AdPlaybackState.AdGroup f2 = adPlaybackState.f(i3);
            long j4 = f2.s;
            if (j4 == Long.MIN_VALUE || j4 > j2) {
                break;
            }
            long j5 = j4 + j3;
            for (int i4 = 0; i4 < c(adPlaybackState, i3); i4++) {
                j3 += f2.Z2[i4];
            }
            long j6 = f2.a3;
            j3 -= j6;
            if (f2.s + j6 > j2) {
                return Math.max(j5, j2 + j3);
            }
        }
        return j2 + j3;
    }
}
