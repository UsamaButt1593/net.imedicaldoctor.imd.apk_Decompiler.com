package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean s = true;
    private static final int t = 50;
    private static final int u = 67;

    /* renamed from: e  reason: collision with root package name */
    private final int f22025e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22026f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TimeInterpolator f22027g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AutoCompleteTextView f22028h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f22029i = new j(this);

    /* renamed from: j  reason: collision with root package name */
    private final View.OnFocusChangeListener f22030j = new k(this);

    /* renamed from: k  reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f22031k = new l(this);

    /* renamed from: l  reason: collision with root package name */
    private boolean f22032l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22033m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22034n;
    private long o = Long.MAX_VALUE;
    @Nullable
    private AccessibilityManager p;
    private ValueAnimator q;
    /* access modifiers changed from: private */
    public ValueAnimator r;

    DropdownMenuEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        Context context = endCompoundLayout.getContext();
        int i2 = R.attr.Od;
        this.f22026f = MotionUtils.f(context, i2, 67);
        this.f22025e = MotionUtils.f(endCompoundLayout.getContext(), i2, 50);
        this.f22027g = MotionUtils.g(endCompoundLayout.getContext(), R.attr.Xd, AnimationUtils.f20766a);
    }

    @NonNull
    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f22027g);
        ofFloat.setDuration((long) i2);
        ofFloat.addUpdateListener(new g(this));
        return ofFloat;
    }

    private void F() {
        this.r = E(this.f22026f, 0.0f, 1.0f);
        ValueAnimator E = E(this.f22025e, 1.0f, 0.0f);
        this.q = E;
        E.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.r();
                DropdownMenuEndIconDelegate.this.r.start();
            }
        });
    }

    private boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.o;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f22028h.isPopupShowing();
        O(isPopupShowing);
        this.f22033m = isPopupShowing;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f22043d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z) {
        this.f22032l = z;
        r();
        if (!z) {
            O(false);
            this.f22033m = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(boolean z) {
        AutoCompleteTextView autoCompleteTextView = this.f22028h;
        if (autoCompleteTextView != null && !EditTextUtils.a(autoCompleteTextView)) {
            ViewCompat.Z1(this.f22043d, z ? 2 : 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f22033m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z) {
        if (this.f22034n != z) {
            this.f22034n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void P() {
        this.f22028h.setOnTouchListener(new h(this));
        if (s) {
            this.f22028h.setOnDismissListener(new i(this));
        }
        this.f22028h.setThreshold(0);
    }

    private void Q() {
        if (this.f22028h != null) {
            if (G()) {
                this.f22033m = false;
            }
            if (!this.f22033m) {
                if (s) {
                    O(!this.f22034n);
                } else {
                    this.f22034n = !this.f22034n;
                    r();
                }
                if (this.f22034n) {
                    this.f22028h.requestFocus();
                    this.f22028h.showDropDown();
                    return;
                }
                this.f22028h.dismissDropDown();
                return;
            }
            this.f22033m = false;
        }
    }

    private void R() {
        this.f22033m = true;
        this.o = System.currentTimeMillis();
    }

    public void a(Editable editable) {
        if (this.p.isTouchExplorationEnabled() && EditTextUtils.a(this.f22028h) && !this.f22043d.hasFocus()) {
            this.f22028h.dismissDropDown();
        }
        this.f22028h.post(new m(this));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return R.string.V;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return s ? R.drawable.Q1 : R.drawable.R1;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f22030j;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f22029i;
    }

    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f22031k;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i2) {
        return i2 != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f22032l;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f22034n;
    }

    public void n(@Nullable EditText editText) {
        this.f22028h = D(editText);
        P();
        this.f22040a.setErrorIconDrawable((Drawable) null);
        if (!EditTextUtils.a(editText) && this.p.isTouchExplorationEnabled()) {
            ViewCompat.Z1(this.f22043d, 2);
        }
        this.f22040a.setEndIconVisible(true);
    }

    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!EditTextUtils.a(this.f22028h)) {
            accessibilityNodeInfoCompat.j1(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.J0()) {
            accessibilityNodeInfoCompat.A1((CharSequence) null);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
        if (this.p.isEnabled() && !EditTextUtils.a(this.f22028h)) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f22034n && !this.f22028h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                Q();
                R();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        F();
        this.p = (AccessibilityManager) this.f22042c.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f22028h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
            if (s) {
                this.f22028h.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
            }
        }
    }
}
