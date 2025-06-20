package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.util.HandlerWrapper;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

final class SystemHandlerWrapper implements HandlerWrapper {

    /* renamed from: b  reason: collision with root package name */
    private static final int f9624b = 50;
    @GuardedBy("messagePool")

    /* renamed from: c  reason: collision with root package name */
    private static final List<SystemMessage> f9625c = new ArrayList(50);

    /* renamed from: a  reason: collision with root package name */
    private final Handler f9626a;

    private static final class SystemMessage implements HandlerWrapper.Message {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Message f9627a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private SystemHandlerWrapper f9628b;

        private SystemMessage() {
        }

        private void c() {
            this.f9627a = null;
            this.f9628b = null;
            SystemHandlerWrapper.r(this);
        }

        public void a() {
            ((Message) Assertions.g(this.f9627a)).sendToTarget();
            c();
        }

        public HandlerWrapper b() {
            return (HandlerWrapper) Assertions.g(this.f9628b);
        }

        public boolean d(Handler handler) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) Assertions.g(this.f9627a));
            c();
            return sendMessageAtFrontOfQueue;
        }

        @CanIgnoreReturnValue
        public SystemMessage e(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.f9627a = message;
            this.f9628b = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f9626a = handler;
    }

    private static SystemMessage q() {
        SystemMessage systemMessage;
        List<SystemMessage> list = f9625c;
        synchronized (list) {
            try {
                systemMessage = list.isEmpty() ? new SystemMessage() : list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemMessage;
    }

    /* access modifiers changed from: private */
    public static void r(SystemMessage systemMessage) {
        List<SystemMessage> list = f9625c;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(systemMessage);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public HandlerWrapper.Message a(int i2, int i3, int i4) {
        return q().e(this.f9626a.obtainMessage(i2, i3, i4), this);
    }

    public boolean b(HandlerWrapper.Message message) {
        return ((SystemMessage) message).d(this.f9626a);
    }

    public boolean c(int i2, int i3) {
        return this.f9626a.sendEmptyMessageDelayed(i2, (long) i3);
    }

    public boolean d(Runnable runnable) {
        return this.f9626a.postAtFrontOfQueue(runnable);
    }

    public boolean e(Runnable runnable) {
        return this.f9626a.post(runnable);
    }

    public HandlerWrapper.Message f(int i2) {
        return q().e(this.f9626a.obtainMessage(i2), this);
    }

    public boolean g(int i2) {
        return this.f9626a.hasMessages(i2);
    }

    public boolean h(Runnable runnable, long j2) {
        return this.f9626a.postDelayed(runnable, j2);
    }

    public boolean i(int i2) {
        return this.f9626a.sendEmptyMessage(i2);
    }

    public HandlerWrapper.Message j(int i2, int i3, int i4, @Nullable Object obj) {
        return q().e(this.f9626a.obtainMessage(i2, i3, i4, obj), this);
    }

    public boolean k(int i2, long j2) {
        return this.f9626a.sendEmptyMessageAtTime(i2, j2);
    }

    public void l(int i2) {
        this.f9626a.removeMessages(i2);
    }

    public HandlerWrapper.Message m(int i2, @Nullable Object obj) {
        return q().e(this.f9626a.obtainMessage(i2, obj), this);
    }

    public void n(@Nullable Object obj) {
        this.f9626a.removeCallbacksAndMessages(obj);
    }

    public Looper o() {
        return this.f9626a.getLooper();
    }
}
