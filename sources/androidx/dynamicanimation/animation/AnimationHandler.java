package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

class AnimationHandler {

    /* renamed from: g  reason: collision with root package name */
    private static final long f7513g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static final ThreadLocal<AnimationHandler> f7514h = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap<AnimationFrameCallback, Long> f7515a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<AnimationFrameCallback> f7516b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final AnimationCallbackDispatcher f7517c = new AnimationCallbackDispatcher();

    /* renamed from: d  reason: collision with root package name */
    private AnimationFrameCallbackProvider f7518d;

    /* renamed from: e  reason: collision with root package name */
    long f7519e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7520f = false;

    class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AnimationHandler.this.f7519e = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.c(animationHandler.f7519e);
            if (AnimationHandler.this.f7516b.size() > 0) {
                AnimationHandler.this.f().a();
            }
        }
    }

    interface AnimationFrameCallback {
        boolean a(long j2);
    }

    static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a  reason: collision with root package name */
        final AnimationCallbackDispatcher f7522a;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f7522a = animationCallbackDispatcher;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f7523b = new Runnable() {
            public void run() {
                FrameCallbackProvider14.this.f7525d = SystemClock.uptimeMillis();
                FrameCallbackProvider14.this.f7522a.a();
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private final Handler f7524c = new Handler(Looper.myLooper());

        /* renamed from: d  reason: collision with root package name */
        long f7525d = -1;

        FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f7524c.postDelayed(this.f7523b, Math.max(AnimationHandler.f7513g - (SystemClock.uptimeMillis() - this.f7525d), 0));
        }
    }

    @RequiresApi(16)
    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f7526b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f7527c = new Choreographer.FrameCallback() {
            public void doFrame(long j2) {
                FrameCallbackProvider16.this.f7522a.a();
            }
        };

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f7526b.postFrameCallback(this.f7527c);
        }
    }

    AnimationHandler() {
    }

    private void b() {
        if (this.f7520f) {
            for (int size = this.f7516b.size() - 1; size >= 0; size--) {
                if (this.f7516b.get(size) == null) {
                    this.f7516b.remove(size);
                }
            }
            this.f7520f = false;
        }
    }

    public static long d() {
        ThreadLocal<AnimationHandler> threadLocal = f7514h;
        if (threadLocal.get() == null) {
            return 0;
        }
        return threadLocal.get().f7519e;
    }

    public static AnimationHandler e() {
        ThreadLocal<AnimationHandler> threadLocal = f7514h;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    private boolean g(AnimationFrameCallback animationFrameCallback, long j2) {
        Long l2 = this.f7515a.get(animationFrameCallback);
        if (l2 == null) {
            return true;
        }
        if (l2.longValue() >= j2) {
            return false;
        }
        this.f7515a.remove(animationFrameCallback);
        return true;
    }

    public void a(AnimationFrameCallback animationFrameCallback, long j2) {
        if (this.f7516b.size() == 0) {
            f().a();
        }
        if (!this.f7516b.contains(animationFrameCallback)) {
            this.f7516b.add(animationFrameCallback);
        }
        if (j2 > 0) {
            this.f7515a.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j2));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f7516b.size(); i2++) {
            AnimationFrameCallback animationFrameCallback = this.f7516b.get(i2);
            if (animationFrameCallback != null && g(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.a(j2);
            }
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public AnimationFrameCallbackProvider f() {
        if (this.f7518d == null) {
            this.f7518d = new FrameCallbackProvider16(this.f7517c);
        }
        return this.f7518d;
    }

    public void h(AnimationFrameCallback animationFrameCallback) {
        this.f7515a.remove(animationFrameCallback);
        int indexOf = this.f7516b.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.f7516b.set(indexOf, (Object) null);
            this.f7520f = true;
        }
    }

    public void i(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.f7518d = animationFrameCallbackProvider;
    }
}
