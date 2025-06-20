package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

@UnstableApi
public interface Clock {

    /* renamed from: a  reason: collision with root package name */
    public static final Clock f9502a = new SystemClock();

    long a();

    long b();

    long c();

    long d();

    HandlerWrapper e(Looper looper, @Nullable Handler.Callback callback);

    void f();
}
