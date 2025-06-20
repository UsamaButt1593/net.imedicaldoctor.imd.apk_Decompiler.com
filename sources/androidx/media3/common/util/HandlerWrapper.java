package androidx.media3.common.util;

import android.os.Looper;
import androidx.annotation.Nullable;

@UnstableApi
public interface HandlerWrapper {

    public interface Message {
        void a();

        HandlerWrapper b();
    }

    Message a(int i2, int i3, int i4);

    boolean b(Message message);

    boolean c(int i2, int i3);

    boolean d(Runnable runnable);

    boolean e(Runnable runnable);

    Message f(int i2);

    boolean g(int i2);

    boolean h(Runnable runnable, long j2);

    boolean i(int i2);

    Message j(int i2, int i3, int i4, @Nullable Object obj);

    boolean k(int i2, long j2);

    void l(int i2);

    Message m(int i2, @Nullable Object obj);

    void n(@Nullable Object obj);

    Looper o();
}
