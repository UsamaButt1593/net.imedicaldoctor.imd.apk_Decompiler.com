package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ViewPropertyAnimatorHC extends ViewPropertyAnimator {

    /* renamed from: n  reason: collision with root package name */
    private static final int f27910n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 4;
    private static final int r = 8;
    private static final int s = 16;
    private static final int t = 32;
    private static final int u = 64;
    private static final int v = 128;
    private static final int w = 256;
    private static final int x = 512;
    private static final int y = 511;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f27911b;

    /* renamed from: c  reason: collision with root package name */
    private long f27912c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27913d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f27914e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27915f = false;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f27916g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f27917h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Animator.AnimatorListener f27918i = null;

    /* renamed from: j  reason: collision with root package name */
    private AnimatorEventListener f27919j = new AnimatorEventListener();

    /* renamed from: k  reason: collision with root package name */
    ArrayList<NameValuesHolder> f27920k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private Runnable f27921l = new Runnable() {
        public void run() {
            ViewPropertyAnimatorHC.this.O();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public HashMap<Animator, PropertyBundle> f27922m = new HashMap<>();

    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        public void a(Animator animator) {
            if (ViewPropertyAnimatorHC.this.f27918i != null) {
                ViewPropertyAnimatorHC.this.f27918i.a(animator);
            }
        }

        public void b(Animator animator) {
            if (ViewPropertyAnimatorHC.this.f27918i != null) {
                ViewPropertyAnimatorHC.this.f27918i.b(animator);
            }
        }

        public void c(Animator animator) {
            if (ViewPropertyAnimatorHC.this.f27918i != null) {
                ViewPropertyAnimatorHC.this.f27918i.c(animator);
            }
        }

        public void d(Animator animator) {
            if (ViewPropertyAnimatorHC.this.f27918i != null) {
                ViewPropertyAnimatorHC.this.f27918i.d(animator);
            }
            ViewPropertyAnimatorHC.this.f27922m.remove(animator);
            if (ViewPropertyAnimatorHC.this.f27922m.isEmpty()) {
                Animator.AnimatorListener unused = ViewPropertyAnimatorHC.this.f27918i = null;
            }
        }

        public void e(ValueAnimator valueAnimator) {
            View view;
            float S = valueAnimator.S();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorHC.this.f27922m.get(valueAnimator);
            if (!((propertyBundle.f27927a & 511) == 0 || (view = (View) ViewPropertyAnimatorHC.this.f27911b.get()) == null)) {
                view.invalidate();
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.f27928b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NameValuesHolder nameValuesHolder = arrayList.get(i2);
                    ViewPropertyAnimatorHC.this.N(nameValuesHolder.f27924a, nameValuesHolder.f27925b + (nameValuesHolder.f27926c * S));
                }
            }
            View view2 = (View) ViewPropertyAnimatorHC.this.f27911b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    private static class NameValuesHolder {

        /* renamed from: a  reason: collision with root package name */
        int f27924a;

        /* renamed from: b  reason: collision with root package name */
        float f27925b;

        /* renamed from: c  reason: collision with root package name */
        float f27926c;

        NameValuesHolder(int i2, float f2, float f3) {
            this.f27924a = i2;
            this.f27925b = f2;
            this.f27926c = f3;
        }
    }

    private static class PropertyBundle {

        /* renamed from: a  reason: collision with root package name */
        int f27927a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<NameValuesHolder> f27928b;

        PropertyBundle(int i2, ArrayList<NameValuesHolder> arrayList) {
            this.f27927a = i2;
            this.f27928b = arrayList;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            ArrayList<NameValuesHolder> arrayList;
            if (!((this.f27927a & i2) == 0 || (arrayList = this.f27928b) == null)) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f27928b.get(i3).f27924a == i2) {
                        this.f27928b.remove(i3);
                        this.f27927a = (~i2) & this.f27927a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    ViewPropertyAnimatorHC(View view) {
        this.f27911b = new WeakReference<>(view);
    }

    private void J(int i2, float f2) {
        float M = M(i2);
        L(i2, M, f2 - M);
    }

    private void K(int i2, float f2) {
        L(i2, M(i2), f2);
    }

    private void L(int i2, float f2, float f3) {
        Animator animator;
        if (this.f27922m.size() > 0) {
            Iterator<Animator> it2 = this.f27922m.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    animator = null;
                    break;
                }
                animator = it2.next();
                PropertyBundle propertyBundle = this.f27922m.get(animator);
                if (propertyBundle.a(i2) && propertyBundle.f27927a == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.f27920k.add(new NameValuesHolder(i2, f2, f3));
        View view = this.f27911b.get();
        if (view != null) {
            view.removeCallbacks(this.f27921l);
            view.post(this.f27921l);
        }
    }

    private float M(int i2) {
        View view = this.f27911b.get();
        if (view == null) {
            return 0.0f;
        }
        if (i2 == 1) {
            return view.getTranslationX();
        }
        if (i2 == 2) {
            return view.getTranslationY();
        }
        if (i2 == 4) {
            return view.getScaleX();
        }
        if (i2 == 8) {
            return view.getScaleY();
        }
        if (i2 == 16) {
            return view.getRotation();
        }
        if (i2 == 32) {
            return view.getRotationX();
        }
        if (i2 == 64) {
            return view.getRotationY();
        }
        if (i2 == 128) {
            return view.getX();
        }
        if (i2 == 256) {
            return view.getY();
        }
        if (i2 != 512) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    /* access modifiers changed from: private */
    public void N(int i2, float f2) {
        View view = this.f27911b.get();
        if (view == null) {
            return;
        }
        if (i2 == 1) {
            view.setTranslationX(f2);
        } else if (i2 == 2) {
            view.setTranslationY(f2);
        } else if (i2 == 4) {
            view.setScaleX(f2);
        } else if (i2 == 8) {
            view.setScaleY(f2);
        } else if (i2 == 16) {
            view.setRotation(f2);
        } else if (i2 == 32) {
            view.setRotationX(f2);
        } else if (i2 == 64) {
            view.setRotationY(f2);
        } else if (i2 == 128) {
            view.setX(f2);
        } else if (i2 == 256) {
            view.setY(f2);
        } else if (i2 == 512) {
            view.setAlpha(f2);
        }
    }

    /* access modifiers changed from: private */
    public void O() {
        ValueAnimator l0 = ValueAnimator.l0(1.0f);
        ArrayList arrayList = (ArrayList) this.f27920k.clone();
        this.f27920k.clear();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 |= ((NameValuesHolder) arrayList.get(i3)).f27924a;
        }
        this.f27922m.put(l0, new PropertyBundle(i2, arrayList));
        l0.F(this.f27919j);
        l0.a(this.f27919j);
        if (this.f27915f) {
            l0.o(this.f27914e);
        }
        if (this.f27913d) {
            l0.m(this.f27912c);
        }
        if (this.f27917h) {
            l0.n(this.f27916g);
        }
        l0.s();
    }

    public ViewPropertyAnimator A(float f2) {
        K(128, f2);
        return this;
    }

    public ViewPropertyAnimator B(float f2) {
        J(256, f2);
        return this;
    }

    public ViewPropertyAnimator C(float f2) {
        K(256, f2);
        return this;
    }

    public ViewPropertyAnimator a(float f2) {
        J(512, f2);
        return this;
    }

    public ViewPropertyAnimator b(float f2) {
        K(512, f2);
        return this;
    }

    public void d() {
        if (this.f27922m.size() > 0) {
            for (Animator cancel : ((HashMap) this.f27922m.clone()).keySet()) {
                cancel.cancel();
            }
        }
        this.f27920k.clear();
        View view = this.f27911b.get();
        if (view != null) {
            view.removeCallbacks(this.f27921l);
        }
    }

    public long e() {
        return this.f27913d ? this.f27912c : new ValueAnimator().d();
    }

    public long f() {
        if (this.f27915f) {
            return this.f27914e;
        }
        return 0;
    }

    public ViewPropertyAnimator g(float f2) {
        J(16, f2);
        return this;
    }

    public ViewPropertyAnimator h(float f2) {
        K(16, f2);
        return this;
    }

    public ViewPropertyAnimator i(float f2) {
        J(32, f2);
        return this;
    }

    public ViewPropertyAnimator j(float f2) {
        K(32, f2);
        return this;
    }

    public ViewPropertyAnimator k(float f2) {
        J(64, f2);
        return this;
    }

    public ViewPropertyAnimator l(float f2) {
        K(64, f2);
        return this;
    }

    public ViewPropertyAnimator m(float f2) {
        J(4, f2);
        return this;
    }

    public ViewPropertyAnimator n(float f2) {
        K(4, f2);
        return this;
    }

    public ViewPropertyAnimator o(float f2) {
        J(8, f2);
        return this;
    }

    public ViewPropertyAnimator p(float f2) {
        K(8, f2);
        return this;
    }

    public ViewPropertyAnimator q(long j2) {
        if (j2 >= 0) {
            this.f27913d = true;
            this.f27912c = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    public ViewPropertyAnimator r(Interpolator interpolator) {
        this.f27917h = true;
        this.f27916g = interpolator;
        return this;
    }

    public ViewPropertyAnimator s(Animator.AnimatorListener animatorListener) {
        this.f27918i = animatorListener;
        return this;
    }

    public ViewPropertyAnimator t(long j2) {
        if (j2 >= 0) {
            this.f27915f = true;
            this.f27914e = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    public void u() {
        O();
    }

    public ViewPropertyAnimator v(float f2) {
        J(1, f2);
        return this;
    }

    public ViewPropertyAnimator w(float f2) {
        K(1, f2);
        return this;
    }

    public ViewPropertyAnimator x(float f2) {
        J(2, f2);
        return this;
    }

    public ViewPropertyAnimator y(float f2) {
        K(2, f2);
        return this;
    }

    public ViewPropertyAnimator z(float f2) {
        J(128, f2);
        return this;
    }
}
