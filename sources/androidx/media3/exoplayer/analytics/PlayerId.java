package androidx.media3.exoplayer.analytics;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class PlayerId {

    /* renamed from: b  reason: collision with root package name */
    public static final PlayerId f10613b = (Util.f9646a < 31 ? new PlayerId() : new PlayerId(LogSessionIdApi31.f10615b));
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final LogSessionIdApi31 f10614a;

    @RequiresApi(31)
    private static final class LogSessionIdApi31 {

        /* renamed from: b  reason: collision with root package name */
        public static final LogSessionIdApi31 f10615b = new LogSessionIdApi31(LogSessionId.LOG_SESSION_ID_NONE);

        /* renamed from: a  reason: collision with root package name */
        public final LogSessionId f10616a;

        public LogSessionIdApi31(LogSessionId logSessionId) {
            this.f10616a = logSessionId;
        }
    }

    public PlayerId() {
        Assertions.i(Util.f9646a < 31);
        this.f10614a = null;
    }

    @RequiresApi(31)
    public LogSessionId a() {
        return ((LogSessionIdApi31) Assertions.g(this.f10614a)).f10616a;
    }

    @RequiresApi(31)
    public PlayerId(LogSessionId logSessionId) {
        this(new LogSessionIdApi31(logSessionId));
    }

    private PlayerId(LogSessionIdApi31 logSessionIdApi31) {
        this.f10614a = logSessionIdApi31;
    }
}
