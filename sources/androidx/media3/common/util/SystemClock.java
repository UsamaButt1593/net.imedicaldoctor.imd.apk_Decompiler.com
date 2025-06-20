package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

@UnstableApi
public class SystemClock implements Clock {
    protected SystemClock() {
    }

    public long a() {
        return System.currentTimeMillis();
    }

    public long b() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public long c() {
        return System.nanoTime();
    }

    public long d() {
        return android.os.SystemClock.uptimeMillis();
    }

    public HandlerWrapper e(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    public void f() {
    }
}
