package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator implements Cloneable {
    ArrayList<AnimatorListener> s = null;

    public interface AnimatorListener {
        void a(Animator animator);

        void b(Animator animator);

        void c(Animator animator);

        void d(Animator animator);
    }

    public void a(AnimatorListener animatorListener) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(animatorListener);
    }

    /* renamed from: b */
    public Animator clone() {
        try {
            Animator animator = (Animator) super.clone();
            ArrayList<AnimatorListener> arrayList = this.s;
            if (arrayList != null) {
                animator.s = new ArrayList<>();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    animator.s.add(arrayList.get(i2));
                }
            }
            return animator;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public void c() {
    }

    public void cancel() {
    }

    public abstract long d();

    public ArrayList<AnimatorListener> e() {
        return this.s;
    }

    public abstract long f();

    public abstract boolean g();

    public boolean h() {
        return g();
    }

    public void i() {
        ArrayList<AnimatorListener> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
            this.s = null;
        }
    }

    public void l(AnimatorListener animatorListener) {
        ArrayList<AnimatorListener> arrayList = this.s;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
            if (this.s.size() == 0) {
                this.s = null;
            }
        }
    }

    public abstract Animator m(long j2);

    public abstract void n(Interpolator interpolator);

    public abstract void o(long j2);

    public void p(Object obj) {
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }
}
