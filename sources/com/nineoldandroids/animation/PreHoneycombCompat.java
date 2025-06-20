package com.nineoldandroids.animation;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat {

    /* renamed from: a  reason: collision with root package name */
    static Property<View, Float> f27887a = new FloatProperty<View>("alpha") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).b());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).t(f2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static Property<View, Float> f27888b = new FloatProperty<View>("pivotX") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).c());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).u(f2);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static Property<View, Float> f27889c = new FloatProperty<View>("pivotY") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).d());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).v(f2);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static Property<View, Float> f27890d = new FloatProperty<View>("translationX") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).n());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).E(f2);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static Property<View, Float> f27891e = new FloatProperty<View>("translationY") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).o());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).F(f2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    static Property<View, Float> f27892f = new FloatProperty<View>(Key.f4369i) {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).e());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).w(f2);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    static Property<View, Float> f27893g = new FloatProperty<View>("rotationX") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).f());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).x(f2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    static Property<View, Float> f27894h = new FloatProperty<View>("rotationY") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).g());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).y(f2);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    static Property<View, Float> f27895i = new FloatProperty<View>("scaleX") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).h());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).z(f2);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    static Property<View, Float> f27896j = new FloatProperty<View>("scaleY") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).i());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).A(f2);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    static Property<View, Integer> f27897k = new IntProperty<View>("scrollX") {
        /* renamed from: i */
        public Integer a(View view) {
            return Integer.valueOf(AnimatorProxy.L(view).l());
        }

        /* renamed from: j */
        public void h(View view, int i2) {
            AnimatorProxy.L(view).B(i2);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    static Property<View, Integer> f27898l = new IntProperty<View>("scrollY") {
        /* renamed from: i */
        public Integer a(View view) {
            return Integer.valueOf(AnimatorProxy.L(view).m());
        }

        /* renamed from: j */
        public void h(View view, int i2) {
            AnimatorProxy.L(view).D(i2);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    static Property<View, Float> f27899m = new FloatProperty<View>("x") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).p());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).G(f2);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    static Property<View, Float> f27900n = new FloatProperty<View>("y") {
        /* renamed from: i */
        public Float a(View view) {
            return Float.valueOf(AnimatorProxy.L(view).q());
        }

        /* renamed from: j */
        public void h(View view, float f2) {
            AnimatorProxy.L(view).J(f2);
        }
    };

    private PreHoneycombCompat() {
    }
}
