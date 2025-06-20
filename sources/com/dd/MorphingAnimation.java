package com.dd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

class MorphingAnimation {

    /* renamed from: n  reason: collision with root package name */
    public static final int f18572n = 400;
    public static final int o = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OnAnimationEndListener f18573a;

    /* renamed from: b  reason: collision with root package name */
    private int f18574b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f18575c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f18576d;

    /* renamed from: e  reason: collision with root package name */
    private int f18577e;

    /* renamed from: f  reason: collision with root package name */
    private int f18578f;

    /* renamed from: g  reason: collision with root package name */
    private int f18579g;

    /* renamed from: h  reason: collision with root package name */
    private int f18580h;

    /* renamed from: i  reason: collision with root package name */
    private float f18581i;

    /* renamed from: j  reason: collision with root package name */
    private float f18582j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f18583k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final TextView f18584l;

    /* renamed from: m  reason: collision with root package name */
    private final StrokeGradientDrawable f18585m;

    public MorphingAnimation(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
        this.f18584l = textView;
        this.f18585m = strokeGradientDrawable;
    }

    public void f(int i2) {
        this.f18574b = i2;
    }

    public void g(int i2) {
        this.f18577e = i2;
    }

    public void h(float f2) {
        this.f18581i = f2;
    }

    public void i(int i2) {
        this.f18579g = i2;
    }

    public void j(int i2) {
        this.f18575c = i2;
    }

    public void k(OnAnimationEndListener onAnimationEndListener) {
        this.f18573a = onAnimationEndListener;
    }

    public void l(float f2) {
        this.f18583k = f2;
    }

    public void m(int i2) {
        this.f18578f = i2;
    }

    public void n(float f2) {
        this.f18582j = f2;
    }

    public void o(int i2) {
        this.f18580h = i2;
    }

    public void p(int i2) {
        this.f18576d = i2;
    }

    public void q() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f18575c, this.f18576d});
        final GradientDrawable a2 = this.f18585m.a();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int d2;
                int d3;
                float c2;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                if (MorphingAnimation.this.f18575c > MorphingAnimation.this.f18576d) {
                    d2 = (MorphingAnimation.this.f18575c - num.intValue()) / 2;
                    d3 = MorphingAnimation.this.f18575c - d2;
                    c2 = MorphingAnimation.this.f18583k * valueAnimator.getAnimatedFraction();
                } else {
                    d2 = (MorphingAnimation.this.f18576d - num.intValue()) / 2;
                    d3 = MorphingAnimation.this.f18576d - d2;
                    c2 = MorphingAnimation.this.f18583k - (MorphingAnimation.this.f18583k * valueAnimator.getAnimatedFraction());
                }
                int i2 = (int) c2;
                a2.setBounds(d2 + i2, i2, d3 - i2, MorphingAnimation.this.f18584l.getHeight() - i2);
            }
        });
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(a2, "color", new int[]{this.f18577e, this.f18578f});
        ofInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.f18585m, "strokeColor", new int[]{this.f18579g, this.f18580h});
        ofInt3.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2, "cornerRadius", new float[]{this.f18581i, this.f18582j});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration((long) this.f18574b);
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2, ofInt3, ofFloat});
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (MorphingAnimation.this.f18573a != null) {
                    MorphingAnimation.this.f18573a.a();
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }
}
