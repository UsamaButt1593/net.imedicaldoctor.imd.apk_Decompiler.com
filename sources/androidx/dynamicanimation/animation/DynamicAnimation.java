package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final float A = 1.0f;
    public static final float B = 0.1f;
    public static final float C = 0.00390625f;
    public static final float D = 0.002f;
    private static final float E = Float.MAX_VALUE;
    private static final float F = 0.75f;

    /* renamed from: m  reason: collision with root package name */
    public static final ViewProperty f7528m = new ViewProperty("translationX") {
        /* renamed from: d */
        public float b(View view) {
            return view.getTranslationX();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setTranslationX(f2);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public static final ViewProperty f7529n = new ViewProperty("translationY") {
        /* renamed from: d */
        public float b(View view) {
            return view.getTranslationY();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setTranslationY(f2);
        }
    };
    public static final ViewProperty o = new ViewProperty("translationZ") {
        /* renamed from: d */
        public float b(View view) {
            return ViewCompat.D0(view);
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            ViewCompat.G2(view, f2);
        }
    };
    public static final ViewProperty p = new ViewProperty("scaleX") {
        /* renamed from: d */
        public float b(View view) {
            return view.getScaleX();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setScaleX(f2);
        }
    };
    public static final ViewProperty q = new ViewProperty("scaleY") {
        /* renamed from: d */
        public float b(View view) {
            return view.getScaleY();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setScaleY(f2);
        }
    };
    public static final ViewProperty r = new ViewProperty(Key.f4369i) {
        /* renamed from: d */
        public float b(View view) {
            return view.getRotation();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setRotation(f2);
        }
    };
    public static final ViewProperty s = new ViewProperty("rotationX") {
        /* renamed from: d */
        public float b(View view) {
            return view.getRotationX();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setRotationX(f2);
        }
    };
    public static final ViewProperty t = new ViewProperty("rotationY") {
        /* renamed from: d */
        public float b(View view) {
            return view.getRotationY();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setRotationY(f2);
        }
    };
    public static final ViewProperty u = new ViewProperty("x") {
        /* renamed from: d */
        public float b(View view) {
            return view.getX();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setX(f2);
        }
    };
    public static final ViewProperty v = new ViewProperty("y") {
        /* renamed from: d */
        public float b(View view) {
            return view.getY();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setY(f2);
        }
    };
    public static final ViewProperty w = new ViewProperty("z") {
        /* renamed from: d */
        public float b(View view) {
            return ViewCompat.I0(view);
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            ViewCompat.K2(view, f2);
        }
    };
    public static final ViewProperty x = new ViewProperty("alpha") {
        /* renamed from: d */
        public float b(View view) {
            return view.getAlpha();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setAlpha(f2);
        }
    };
    public static final ViewProperty y = new ViewProperty("scrollX") {
        /* renamed from: d */
        public float b(View view) {
            return (float) view.getScrollX();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setScrollX((int) f2);
        }
    };
    public static final ViewProperty z = new ViewProperty("scrollY") {
        /* renamed from: d */
        public float b(View view) {
            return (float) view.getScrollY();
        }

        /* renamed from: e */
        public void c(View view, float f2) {
            view.setScrollY((int) f2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    float f7530a;

    /* renamed from: b  reason: collision with root package name */
    float f7531b;

    /* renamed from: c  reason: collision with root package name */
    boolean f7532c;

    /* renamed from: d  reason: collision with root package name */
    final Object f7533d;

    /* renamed from: e  reason: collision with root package name */
    final FloatPropertyCompat f7534e;

    /* renamed from: f  reason: collision with root package name */
    boolean f7535f;

    /* renamed from: g  reason: collision with root package name */
    float f7536g;

    /* renamed from: h  reason: collision with root package name */
    float f7537h;

    /* renamed from: i  reason: collision with root package name */
    private long f7538i;

    /* renamed from: j  reason: collision with root package name */
    private float f7539j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<OnAnimationEndListener> f7540k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<OnAnimationUpdateListener> f7541l;

    static class MassState {

        /* renamed from: a  reason: collision with root package name */
        float f7544a;

        /* renamed from: b  reason: collision with root package name */
        float f7545b;

        MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void a(DynamicAnimation dynamicAnimation, boolean z, float f2, float f3);
    }

    public interface OnAnimationUpdateListener {
        void m(DynamicAnimation dynamicAnimation, float f2, float f3);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.f7530a = 0.0f;
        this.f7531b = Float.MAX_VALUE;
        this.f7532c = false;
        this.f7535f = false;
        this.f7536g = Float.MAX_VALUE;
        this.f7537h = -Float.MAX_VALUE;
        this.f7538i = 0;
        this.f7540k = new ArrayList<>();
        this.f7541l = new ArrayList<>();
        this.f7533d = null;
        this.f7534e = new FloatPropertyCompat("FloatValueHolder") {
            public float b(Object obj) {
                return floatValueHolder.a();
            }

            public void c(Object obj, float f2) {
                floatValueHolder.b(f2);
            }
        };
        this.f7539j = 1.0f;
    }

    private void e(boolean z2) {
        this.f7535f = false;
        AnimationHandler.e().h(this);
        this.f7538i = 0;
        this.f7532c = false;
        for (int i2 = 0; i2 < this.f7540k.size(); i2++) {
            if (this.f7540k.get(i2) != null) {
                this.f7540k.get(i2).a(this, z2, this.f7531b, this.f7530a);
            }
        }
        n(this.f7540k);
    }

    private float h() {
        return this.f7534e.b(this.f7533d);
    }

    private static <T> void m(ArrayList<T> arrayList, T t2) {
        int indexOf = arrayList.indexOf(t2);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    private static <T> void n(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void x() {
        if (!this.f7535f) {
            this.f7535f = true;
            if (!this.f7532c) {
                this.f7531b = h();
            }
            float f2 = this.f7531b;
            if (f2 > this.f7536g || f2 < this.f7537h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            AnimationHandler.e().a(this, 0);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        long j3 = this.f7538i;
        if (j3 == 0) {
            this.f7538i = j2;
            s(this.f7531b);
            return false;
        }
        this.f7538i = j2;
        boolean y2 = y(j2 - j3);
        float min = Math.min(this.f7531b, this.f7536g);
        this.f7531b = min;
        float max = Math.max(min, this.f7537h);
        this.f7531b = max;
        s(max);
        if (y2) {
            e(false);
        }
        return y2;
    }

    public T b(OnAnimationEndListener onAnimationEndListener) {
        if (!this.f7540k.contains(onAnimationEndListener)) {
            this.f7540k.add(onAnimationEndListener);
        }
        return this;
    }

    public T c(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!k()) {
            if (!this.f7541l.contains(onAnimationUpdateListener)) {
                this.f7541l.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f7535f) {
            e(true);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract float f(float f2, float f3);

    public float g() {
        return this.f7539j;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f7539j * 0.75f;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean j(float f2, float f3);

    public boolean k() {
        return this.f7535f;
    }

    public void l(OnAnimationEndListener onAnimationEndListener) {
        m(this.f7540k, onAnimationEndListener);
    }

    public void o(OnAnimationUpdateListener onAnimationUpdateListener) {
        m(this.f7541l, onAnimationUpdateListener);
    }

    public T p(float f2) {
        this.f7536g = f2;
        return this;
    }

    public T q(float f2) {
        this.f7537h = f2;
        return this;
    }

    public T r(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.f7539j = f2;
            v(f2 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void s(float f2) {
        this.f7534e.c(this.f7533d, f2);
        for (int i2 = 0; i2 < this.f7541l.size(); i2++) {
            if (this.f7541l.get(i2) != null) {
                this.f7541l.get(i2).m(this, this.f7531b, this.f7530a);
            }
        }
        n(this.f7541l);
    }

    public T t(float f2) {
        this.f7531b = f2;
        this.f7532c = true;
        return this;
    }

    public T u(float f2) {
        this.f7530a = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void v(float f2);

    public void w() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f7535f) {
            x();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean y(long j2);

    <K> DynamicAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        float f2;
        this.f7530a = 0.0f;
        this.f7531b = Float.MAX_VALUE;
        this.f7532c = false;
        this.f7535f = false;
        this.f7536g = Float.MAX_VALUE;
        this.f7537h = -Float.MAX_VALUE;
        this.f7538i = 0;
        this.f7540k = new ArrayList<>();
        this.f7541l = new ArrayList<>();
        this.f7533d = k2;
        this.f7534e = floatPropertyCompat;
        if (floatPropertyCompat == r || floatPropertyCompat == s || floatPropertyCompat == t) {
            f2 = 0.1f;
        } else if (floatPropertyCompat == x || floatPropertyCompat == p || floatPropertyCompat == q) {
            this.f7539j = 0.00390625f;
            return;
        } else {
            f2 = 1.0f;
        }
        this.f7539j = f2;
    }
}
