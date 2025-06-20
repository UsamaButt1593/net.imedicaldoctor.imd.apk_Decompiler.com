package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {
    private static final int C = 217;
    private static final int D = 167;
    static final int E = 0;
    static final int F = 1;
    static final int G = 2;
    private static final int H = 0;
    private static final int I = 1;
    private static final int J = 2;
    @Nullable
    private ColorStateList A;
    private Typeface B;

    /* renamed from: a  reason: collision with root package name */
    private final int f22044a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22045b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22046c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f22047d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f22048e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f22049f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f22050g;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f22051h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f22052i;

    /* renamed from: j  reason: collision with root package name */
    private int f22053j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f22054k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public Animator f22055l;

    /* renamed from: m  reason: collision with root package name */
    private final float f22056m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f22057n;
    private int o;
    @Nullable
    private CharSequence p;
    private boolean q;
    /* access modifiers changed from: private */
    @Nullable
    public TextView r;
    @Nullable
    private CharSequence s;
    private int t;
    private int u;
    @Nullable
    private ColorStateList v;
    private CharSequence w;
    private boolean x;
    @Nullable
    private TextView y;
    private int z;

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f22050g = context;
        this.f22051h = textInputLayout;
        this.f22056m = (float) context.getResources().getDimensionPixelSize(R.dimen.L1);
        int i2 = R.attr.Pd;
        this.f22044a = MotionUtils.f(context, i2, C);
        this.f22045b = MotionUtils.f(context, R.attr.Ld, D);
        this.f22046c = MotionUtils.f(context, i2, D);
        int i3 = R.attr.Ud;
        this.f22047d = MotionUtils.g(context, i3, AnimationUtils.f20769d);
        TimeInterpolator timeInterpolator = AnimationUtils.f20766a;
        this.f22048e = MotionUtils.g(context, i3, timeInterpolator);
        this.f22049f = MotionUtils.g(context, R.attr.Xd, timeInterpolator);
    }

    private boolean C(int i2) {
        return i2 == 1 && this.r != null && !TextUtils.isEmpty(this.p);
    }

    private boolean D(int i2) {
        return i2 == 2 && this.y != null && !TextUtils.isEmpty(this.w);
    }

    private void I(int i2, int i3) {
        TextView n2;
        TextView n3;
        if (i2 != i3) {
            if (!(i3 == 0 || (n3 = n(i3)) == null)) {
                n3.setVisibility(0);
                n3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (n2 = n(i2)) == null)) {
                n2.setVisibility(4);
                if (i2 == 1) {
                    n2.setText((CharSequence) null);
                }
            }
            this.f22057n = i3;
        }
    }

    private void R(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void T(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean U(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        return ViewCompat.Y0(this.f22051h) && this.f22051h.isEnabled() && (this.o != this.f22057n || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void X(int i2, int i3, boolean z2) {
        boolean z3 = z2;
        if (i2 != i3) {
            if (z3) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f22055l = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i4 = i2;
                int i5 = i3;
                i(arrayList2, this.x, this.y, 2, i4, i5);
                i(arrayList2, this.q, this.r, 1, i4, i5);
                AnimatorSetCompat.a(animatorSet, arrayList);
                final TextView n2 = n(i2);
                final TextView n3 = n(i3);
                final int i6 = i3;
                final int i7 = i2;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        int unused = IndicatorViewController.this.f22057n = i6;
                        Animator unused2 = IndicatorViewController.this.f22055l = null;
                        TextView textView = n2;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i7 == 1 && IndicatorViewController.this.r != null) {
                                IndicatorViewController.this.r.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = n3;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            n3.setAlpha(1.0f);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        TextView textView = n3;
                        if (textView != null) {
                            textView.setVisibility(0);
                            n3.setAlpha(0.0f);
                        }
                    }
                });
                animatorSet.start();
            } else {
                I(i2, i3);
            }
            this.f22051h.J0();
            this.f22051h.O0(z3);
            this.f22051h.U0();
        }
    }

    private boolean g() {
        return (this.f22052i == null || this.f22051h.getEditText() == null) ? false : true;
    }

    private void i(@NonNull List<Animator> list, boolean z2, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView != null && z2) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator j2 = j(textView, i4 == i2);
                if (i2 == i4 && i3 != 0) {
                    j2.setStartDelay((long) this.f22046c);
                }
                list.add(j2);
                if (i4 == i2 && i3 != 0) {
                    ObjectAnimator k2 = k(textView);
                    k2.setStartDelay((long) this.f22046c);
                    list.add(k2);
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z2 ? 1.0f : 0.0f});
        ofFloat.setDuration((long) (z2 ? this.f22045b : this.f22046c));
        ofFloat.setInterpolator(z2 ? this.f22048e : this.f22049f);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f22056m, 0.0f});
        ofFloat.setDuration((long) this.f22044a);
        ofFloat.setInterpolator(this.f22047d);
        return ofFloat;
    }

    @Nullable
    private TextView n(int i2) {
        if (i2 == 1) {
            return this.r;
        }
        if (i2 != 2) {
            return null;
        }
        return this.y;
    }

    private int x(boolean z2, @DimenRes int i2, int i3) {
        return z2 ? this.f22050g.getResources().getDimensionPixelSize(i2) : i3;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.p = null;
        h();
        if (this.f22057n == 1) {
            this.o = (!this.x || TextUtils.isEmpty(this.w)) ? 0 : 2;
        }
        X(this.f22057n, this.o, U(this.r, ""));
    }

    /* access modifiers changed from: package-private */
    public void B() {
        h();
        int i2 = this.f22057n;
        if (i2 == 2) {
            this.o = 0;
        }
        X(i2, this.o, U(this.y, ""));
    }

    /* access modifiers changed from: package-private */
    public boolean E(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void H(TextView textView, int i2) {
        ViewGroup viewGroup;
        if (this.f22052i != null) {
            if (!E(i2) || (viewGroup = this.f22054k) == null) {
                viewGroup = this.f22052i;
            }
            viewGroup.removeView(textView);
            int i3 = this.f22053j - 1;
            this.f22053j = i3;
            T(this.f22052i, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int i2) {
        this.t = i2;
        TextView textView = this.r;
        if (textView != null) {
            ViewCompat.J1(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(@Nullable CharSequence charSequence) {
        this.s = charSequence;
        TextView textView = this.r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z2) {
        if (this.q != z2) {
            h();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f22050g);
                this.r = appCompatTextView;
                appCompatTextView.setId(R.id.a6);
                this.r.setTextAlignment(5);
                Typeface typeface = this.B;
                if (typeface != null) {
                    this.r.setTypeface(typeface);
                }
                M(this.u);
                N(this.v);
                K(this.s);
                J(this.t);
                this.r.setVisibility(4);
                e(this.r, 0);
            } else {
                A();
                H(this.r, 0);
                this.r = null;
                this.f22051h.J0();
                this.f22051h.U0();
            }
            this.q = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public void M(@StyleRes int i2) {
        this.u = i2;
        TextView textView = this.r;
        if (textView != null) {
            this.f22051h.w0(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(@Nullable ColorStateList colorStateList) {
        this.v = colorStateList;
        TextView textView = this.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(@StyleRes int i2) {
        this.z = i2;
        TextView textView = this.y;
        if (textView != null) {
            TextViewCompat.D(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void P(boolean z2) {
        if (this.x != z2) {
            h();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f22050g);
                this.y = appCompatTextView;
                appCompatTextView.setId(R.id.b6);
                this.y.setTextAlignment(5);
                Typeface typeface = this.B;
                if (typeface != null) {
                    this.y.setTypeface(typeface);
                }
                this.y.setVisibility(4);
                ViewCompat.J1(this.y, 1);
                O(this.z);
                Q(this.A);
                e(this.y, 1);
                this.y.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                        EditText editText = IndicatorViewController.this.f22051h.getEditText();
                        if (editText != null) {
                            accessibilityNodeInfo.setLabeledBy(editText);
                        }
                    }
                });
            } else {
                B();
                H(this.y, 1);
                this.y = null;
                this.f22051h.J0();
                this.f22051h.U0();
            }
            this.x = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(@Nullable ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.y;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            R(this.r, typeface);
            R(this.y, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void V(CharSequence charSequence) {
        h();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i2 = this.f22057n;
        if (i2 != 1) {
            this.o = 1;
        }
        X(i2, this.o, U(this.r, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void W(CharSequence charSequence) {
        h();
        this.w = charSequence;
        this.y.setText(charSequence);
        int i2 = this.f22057n;
        if (i2 != 2) {
            this.o = 2;
        }
        X(i2, this.o, U(this.y, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void e(TextView textView, int i2) {
        if (this.f22052i == null && this.f22054k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f22050g);
            this.f22052i = linearLayout;
            linearLayout.setOrientation(0);
            this.f22051h.addView(this.f22052i, -1, -2);
            this.f22054k = new FrameLayout(this.f22050g);
            this.f22052i.addView(this.f22054k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f22051h.getEditText() != null) {
                f();
            }
        }
        if (E(i2)) {
            this.f22054k.setVisibility(0);
            this.f22054k.addView(textView);
        } else {
            this.f22052i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f22052i.setVisibility(0);
        this.f22053j++;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f22051h.getEditText();
            boolean j2 = MaterialResources.j(this.f22050g);
            LinearLayout linearLayout = this.f22052i;
            int i2 = R.dimen.ca;
            ViewCompat.n2(linearLayout, x(j2, i2, ViewCompat.n0(editText)), x(j2, R.dimen.da, this.f22050g.getResources().getDimensionPixelSize(R.dimen.ba)), x(j2, i2, ViewCompat.m0(editText)), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Animator animator = this.f22055l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return C(this.f22057n);
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return C(this.o);
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence p() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence q() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int r() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList s() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence t() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public View u() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList v() {
        TextView textView = this.y;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int w() {
        TextView textView = this.y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return D(this.f22057n);
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return D(this.o);
    }
}
