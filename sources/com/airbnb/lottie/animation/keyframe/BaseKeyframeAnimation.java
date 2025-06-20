package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<AnimationListener> f17038a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f17039b = false;

    /* renamed from: c  reason: collision with root package name */
    private final KeyframesWrapper<K> f17040c;

    /* renamed from: d  reason: collision with root package name */
    protected float f17041d = 0.0f;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    protected LottieValueCallback<A> f17042e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private A f17043f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f17044g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f17045h = -1.0f;

    public interface AnimationListener {
        void a();
    }

    private static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private EmptyKeyframeWrapper() {
        }

        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }

        public Keyframe<T> b() {
            throw new IllegalStateException("not implemented");
        }

        public boolean c(float f2) {
            return false;
        }

        public float d() {
            return 1.0f;
        }

        public float e() {
            return 0.0f;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    private interface KeyframesWrapper<T> {
        boolean a(float f2);

        Keyframe<T> b();

        boolean c(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float d();

        @FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    private static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends Keyframe<T>> f17046a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private Keyframe<T> f17047b;

        /* renamed from: c  reason: collision with root package name */
        private Keyframe<T> f17048c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f17049d = -1.0f;

        KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.f17046a = list;
            this.f17047b = f(0.0f);
        }

        private Keyframe<T> f(float f2) {
            List<? extends Keyframe<T>> list = this.f17046a;
            Keyframe<T> keyframe = (Keyframe) list.get(list.size() - 1);
            if (f2 >= keyframe.e()) {
                return keyframe;
            }
            for (int size = this.f17046a.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = (Keyframe) this.f17046a.get(size);
                if (this.f17047b != keyframe2 && keyframe2.a(f2)) {
                    return keyframe2;
                }
            }
            return (Keyframe) this.f17046a.get(0);
        }

        public boolean a(float f2) {
            Keyframe<T> keyframe = this.f17048c;
            Keyframe<T> keyframe2 = this.f17047b;
            if (keyframe == keyframe2 && this.f17049d == f2) {
                return true;
            }
            this.f17048c = keyframe2;
            this.f17049d = f2;
            return false;
        }

        @NonNull
        public Keyframe<T> b() {
            return this.f17047b;
        }

        public boolean c(float f2) {
            if (this.f17047b.a(f2)) {
                return !this.f17047b.h();
            }
            this.f17047b = f(f2);
            return true;
        }

        public float d() {
            List<? extends Keyframe<T>> list = this.f17046a;
            return ((Keyframe) list.get(list.size() - 1)).b();
        }

        public float e() {
            return ((Keyframe) this.f17046a.get(0)).e();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Keyframe<T> f17050a;

        /* renamed from: b  reason: collision with root package name */
        private float f17051b = -1.0f;

        SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.f17050a = (Keyframe) list.get(0);
        }

        public boolean a(float f2) {
            if (this.f17051b == f2) {
                return true;
            }
            this.f17051b = f2;
            return false;
        }

        public Keyframe<T> b() {
            return this.f17050a;
        }

        public boolean c(float f2) {
            return !this.f17050a.h();
        }

        public float d() {
            return this.f17050a.b();
        }

        public float e() {
            return this.f17050a.e();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f17040c = n(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.f17044g == -1.0f) {
            this.f17044g = this.f17040c.e();
        }
        return this.f17044g;
    }

    private static <T> KeyframesWrapper<T> n(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        return list.size() == 1 ? new SingleKeyframeWrapper(list) : new KeyframesWrapperImpl(list);
    }

    public void a(AnimationListener animationListener) {
        this.f17038a.add(animationListener);
    }

    /* access modifiers changed from: protected */
    public Keyframe<K> b() {
        L.a("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> b2 = this.f17040c.b();
        L.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        if (this.f17045h == -1.0f) {
            this.f17045h = this.f17040c.d();
        }
        return this.f17045h;
    }

    /* access modifiers changed from: protected */
    public float d() {
        Keyframe b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.f17357d.getInterpolation(e());
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.f17039b) {
            return 0.0f;
        }
        Keyframe b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.f17041d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.f17041d;
    }

    public A h() {
        float d2 = d();
        if (this.f17042e == null && this.f17040c.a(d2)) {
            return this.f17043f;
        }
        A i2 = i(b(), d2);
        this.f17043f = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public abstract A i(Keyframe<K> keyframe, float f2);

    public void j() {
        for (int i2 = 0; i2 < this.f17038a.size(); i2++) {
            this.f17038a.get(i2).a();
        }
    }

    public void k() {
        this.f17039b = true;
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (!this.f17040c.isEmpty()) {
            if (f2 < g()) {
                f2 = g();
            } else if (f2 > c()) {
                f2 = c();
            }
            if (f2 != this.f17041d) {
                this.f17041d = f2;
                if (this.f17040c.c(f2)) {
                    j();
                }
            }
        }
    }

    public void m(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.f17042e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f17042e = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }
}
