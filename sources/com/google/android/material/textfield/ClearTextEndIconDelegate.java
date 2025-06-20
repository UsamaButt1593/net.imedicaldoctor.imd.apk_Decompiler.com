package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

class ClearTextEndIconDelegate extends EndIconDelegate {

    /* renamed from: n  reason: collision with root package name */
    private static final int f22015n = 100;
    private static final int o = 150;
    private static final float p = 0.8f;

    /* renamed from: e  reason: collision with root package name */
    private final int f22016e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22017f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f22018g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TimeInterpolator f22019h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private EditText f22020i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f22021j = new a(this);

    /* renamed from: k  reason: collision with root package name */
    private final View.OnFocusChangeListener f22022k = new b(this);

    /* renamed from: l  reason: collision with root package name */
    private AnimatorSet f22023l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f22024m;

    ClearTextEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        Context context = endCompoundLayout.getContext();
        int i2 = R.attr.Od;
        this.f22016e = MotionUtils.f(context, i2, 100);
        this.f22017f = MotionUtils.f(endCompoundLayout.getContext(), i2, o);
        this.f22018g = MotionUtils.g(endCompoundLayout.getContext(), R.attr.Xd, AnimationUtils.f20766a);
        this.f22019h = MotionUtils.g(endCompoundLayout.getContext(), R.attr.Vd, AnimationUtils.f20769d);
    }

    private void A(boolean z) {
        boolean z2 = this.f22041b.I() == z;
        if (z && !this.f22023l.isRunning()) {
            this.f22024m.cancel();
            this.f22023l.start();
            if (z2) {
                this.f22023l.end();
            }
        } else if (!z) {
            this.f22023l.cancel();
            this.f22024m.start();
            if (z2) {
                this.f22024m.end();
            }
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f22018g);
        ofFloat.setDuration((long) this.f22016e);
        ofFloat.addUpdateListener(new c(this));
        return ofFloat;
    }

    private ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{p, 1.0f});
        ofFloat.setInterpolator(this.f22019h);
        ofFloat.setDuration((long) this.f22017f);
        ofFloat.addUpdateListener(new e(this));
        return ofFloat;
    }

    private void D() {
        ValueAnimator C = C();
        ValueAnimator B = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f22023l = animatorSet;
        animatorSet.playTogether(new Animator[]{C, B});
        this.f22023l.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.f22041b.f0(true);
            }
        });
        ValueAnimator B2 = B(1.0f, 0.0f);
        this.f22024m = B2;
        B2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.f22041b.f0(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f22043d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f22043d.setScaleX(floatValue);
        this.f22043d.setScaleY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f22020i;
        if (editText != null) {
            Editable text = editText.getText();
            if (text != null) {
                text.clear();
            }
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z) {
        A(J());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f22020i;
        return editText != null && (editText.hasFocus() || this.f22043d.hasFocus()) && this.f22020i.getText().length() > 0;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Editable editable) {
        if (this.f22041b.y() == null) {
            A(J());
        }
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return R.string.S;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return R.drawable.T1;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f22022k;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f22021j;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return this.f22022k;
    }

    public void n(@Nullable EditText editText) {
        this.f22020i = editText;
        this.f22040a.setEndIconVisible(J());
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z) {
        if (this.f22041b.y() != null) {
            A(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        D();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f22020i;
        if (editText != null) {
            editText.post(new d(this));
        }
    }
}
