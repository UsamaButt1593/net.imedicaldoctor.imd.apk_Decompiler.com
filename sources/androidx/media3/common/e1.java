package androidx.media3.common;

import android.os.SystemClock;
import androidx.media3.common.SimpleBasePlayer;

public final /* synthetic */ class e1 {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.f9306a;
    }

    public static SimpleBasePlayer.PositionSupplier a(long j2) {
        return new d1(j2);
    }

    public static SimpleBasePlayer.PositionSupplier b(long j2, float f2) {
        return new c1(j2, SystemClock.elapsedRealtime(), f2);
    }

    public static /* synthetic */ long d(long j2, long j3, float f2) {
        return j2 + ((long) (((float) (SystemClock.elapsedRealtime() - j3)) * f2));
    }

    public static /* synthetic */ long c(long j2) {
        return j2;
    }
}
