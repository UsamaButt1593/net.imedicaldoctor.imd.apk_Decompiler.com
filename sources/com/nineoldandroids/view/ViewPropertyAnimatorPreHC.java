package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ViewPropertyAnimatorPreHC extends ViewPropertyAnimator {
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 4;
    private static final int s = 8;
    private static final int t = 16;
    private static final int u = 32;
    private static final int v = 64;
    private static final int w = 128;
    private static final int x = 256;
    private static final int y = 512;
    private static final int z = 511;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatorProxy f27931b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<View> f27932c;

    /* renamed from: d  reason: collision with root package name */
    private long f27933d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27934e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f27935f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27936g = false;

    /* renamed from: h  reason: collision with root package name */
    private Interpolator f27937h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27938i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Animator.AnimatorListener f27939j = null;

    /* renamed from: k  reason: collision with root package name */
    private AnimatorEventListener f27940k = new AnimatorEventListener();

    /* renamed from: l  reason: collision with root package name */
    ArrayList<NameValuesHolder> f27941l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private Runnable f27942m = new Runnable() {
        public void run() {
            ViewPropertyAnimatorPreHC.this.O();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public HashMap<Animator, PropertyBundle> f27943n = new HashMap<>();

    private class AnimatorEventListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        public void a(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.f27939j != null) {
                ViewPropertyAnimatorPreHC.this.f27939j.a(animator);
            }
        }

        public void b(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.f27939j != null) {
                ViewPropertyAnimatorPreHC.this.f27939j.b(animator);
            }
        }

        public void c(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.f27939j != null) {
                ViewPropertyAnimatorPreHC.this.f27939j.c(animator);
            }
        }

        public void d(Animator animator) {
            if (ViewPropertyAnimatorPreHC.this.f27939j != null) {
                ViewPropertyAnimatorPreHC.this.f27939j.d(animator);
            }
            ViewPropertyAnimatorPreHC.this.f27943n.remove(animator);
            if (ViewPropertyAnimatorPreHC.this.f27943n.isEmpty()) {
                Animator.AnimatorListener unused = ViewPropertyAnimatorPreHC.this.f27939j = null;
            }
        }

        public void e(ValueAnimator valueAnimator) {
            View view;
            float S = valueAnimator.S();
            PropertyBundle propertyBundle = (PropertyBundle) ViewPropertyAnimatorPreHC.this.f27943n.get(valueAnimator);
            if (!((propertyBundle.f27948a & 511) == 0 || (view = (View) ViewPropertyAnimatorPreHC.this.f27932c.get()) == null)) {
                view.invalidate();
            }
            ArrayList<NameValuesHolder> arrayList = propertyBundle.f27949b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NameValuesHolder nameValuesHolder = arrayList.get(i2);
                    ViewPropertyAnimatorPreHC.this.N(nameValuesHolder.f27945a, nameValuesHolder.f27946b + (nameValuesHolder.f27947c * S));
                }
            }
            View view2 = (View) ViewPropertyAnimatorPreHC.this.f27932c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    private static class NameValuesHolder {

        /* renamed from: a  reason: collision with root package name */
        int f27945a;

        /* renamed from: b  reason: collision with root package name */
        float f27946b;

        /* renamed from: c  reason: collision with root package name */
        float f27947c;

        NameValuesHolder(int i2, float f2, float f3) {
            this.f27945a = i2;
            this.f27946b = f2;
            this.f27947c = f3;
        }
    }

    private static class PropertyBundle {

        /* renamed from: a  reason: collision with root package name */
        int f27948a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<NameValuesHolder> f27949b;

        PropertyBundle(int i2, ArrayList<NameValuesHolder> arrayList) {
            this.f27948a = i2;
            this.f27949b = arrayList;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            ArrayList<NameValuesHolder> arrayList;
            if (!((this.f27948a & i2) == 0 || (arrayList = this.f27949b) == null)) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f27949b.get(i3).f27945a == i2) {
                        this.f27949b.remove(i3);
                        this.f27948a = (~i2) & this.f27948a;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    ViewPropertyAnimatorPreHC(View view) {
        this.f27932c = new WeakReference<>(view);
        this.f27931b = AnimatorProxy.L(view);
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
        if (this.f27943n.size() > 0) {
            Iterator<Animator> it2 = this.f27943n.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    animator = null;
                    break;
                }
                animator = it2.next();
                PropertyBundle propertyBundle = this.f27943n.get(animator);
                if (propertyBundle.a(i2) && propertyBundle.f27948a == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.f27941l.add(new NameValuesHolder(i2, f2, f3));
        View view = this.f27932c.get();
        if (view != null) {
            view.removeCallbacks(this.f27942m);
            view.post(this.f27942m);
        }
    }

    private float M(int i2) {
        if (i2 == 1) {
            return this.f27931b.n();
        }
        if (i2 == 2) {
            return this.f27931b.o();
        }
        if (i2 == 4) {
            return this.f27931b.h();
        }
        if (i2 == 8) {
            return this.f27931b.i();
        }
        if (i2 == 16) {
            return this.f27931b.e();
        }
        if (i2 == 32) {
            return this.f27931b.f();
        }
        if (i2 == 64) {
            return this.f27931b.g();
        }
        if (i2 == 128) {
            return this.f27931b.p();
        }
        if (i2 == 256) {
            return this.f27931b.q();
        }
        if (i2 != 512) {
            return 0.0f;
        }
        return this.f27931b.b();
    }

    /* access modifiers changed from: private */
    public void N(int i2, float f2) {
        if (i2 == 1) {
            this.f27931b.E(f2);
        } else if (i2 == 2) {
            this.f27931b.F(f2);
        } else if (i2 == 4) {
            this.f27931b.z(f2);
        } else if (i2 == 8) {
            this.f27931b.A(f2);
        } else if (i2 == 16) {
            this.f27931b.w(f2);
        } else if (i2 == 32) {
            this.f27931b.x(f2);
        } else if (i2 == 64) {
            this.f27931b.y(f2);
        } else if (i2 == 128) {
            this.f27931b.G(f2);
        } else if (i2 == 256) {
            this.f27931b.J(f2);
        } else if (i2 == 512) {
            this.f27931b.t(f2);
        }
    }

    /* access modifiers changed from: private */
    public void O() {
        ValueAnimator l0 = ValueAnimator.l0(1.0f);
        ArrayList arrayList = (ArrayList) this.f27941l.clone();
        this.f27941l.clear();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 |= ((NameValuesHolder) arrayList.get(i3)).f27945a;
        }
        this.f27943n.put(l0, new PropertyBundle(i2, arrayList));
        l0.F(this.f27940k);
        l0.a(this.f27940k);
        if (this.f27936g) {
            l0.o(this.f27935f);
        }
        if (this.f27934e) {
            l0.m(this.f27933d);
        }
        if (this.f27938i) {
            l0.n(this.f27937h);
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
        if (this.f27943n.size() > 0) {
            for (Animator cancel : ((HashMap) this.f27943n.clone()).keySet()) {
                cancel.cancel();
            }
        }
        this.f27941l.clear();
        View view = this.f27932c.get();
        if (view != null) {
            view.removeCallbacks(this.f27942m);
        }
    }

    public long e() {
        return this.f27934e ? this.f27933d : new ValueAnimator().d();
    }

    public long f() {
        if (this.f27936g) {
            return this.f27935f;
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
            this.f27934e = true;
            this.f27933d = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    public ViewPropertyAnimator r(Interpolator interpolator) {
        this.f27938i = true;
        this.f27937h = interpolator;
        return this;
    }

    public ViewPropertyAnimator s(Animator.AnimatorListener animatorListener) {
        this.f27939j = animatorListener;
        return this;
    }

    public ViewPropertyAnimator t(long j2) {
        if (j2 >= 0) {
            this.f27936g = true;
            this.f27935f = j2;
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
