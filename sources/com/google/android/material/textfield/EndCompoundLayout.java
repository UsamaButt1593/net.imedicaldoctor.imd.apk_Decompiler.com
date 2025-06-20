package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressLint({"ViewConstructor"})
class EndCompoundLayout extends LinearLayout {
    @NonNull
    private final FrameLayout X2;
    @NonNull
    private final CheckableImageButton Y2;
    private ColorStateList Z2;
    private PorterDuff.Mode a3;
    private View.OnLongClickListener b3;
    @NonNull
    private final CheckableImageButton c3;
    private final EndIconDelegates d3;
    private int e3 = 0;
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> f3 = new LinkedHashSet<>();
    private ColorStateList g3;
    private PorterDuff.Mode h3;
    private int i3;
    @NonNull
    private ImageView.ScaleType j3;
    private View.OnLongClickListener k3;
    @Nullable
    private CharSequence l3;
    @NonNull
    private final TextView m3;
    private boolean n3;
    /* access modifiers changed from: private */
    public EditText o3;
    @Nullable
    private final AccessibilityManager p3;
    @Nullable
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener q3;
    /* access modifiers changed from: private */
    public final TextWatcher r3 = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            EndCompoundLayout.this.o().a(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            EndCompoundLayout.this.o().b(charSequence, i2, i3, i4);
        }
    };
    final TextInputLayout s;
    private final TextInputLayout.OnEditTextAttachedListener s3;

    private static class EndIconDelegates {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<EndIconDelegate> f22036a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private final EndCompoundLayout f22037b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f22038c;

        /* renamed from: d  reason: collision with root package name */
        private final int f22039d;

        EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.f22037b = endCompoundLayout;
            this.f22038c = tintTypedArray.u(R.styleable.Vw, 0);
            this.f22039d = tintTypedArray.u(R.styleable.tx, 0);
        }

        private EndIconDelegate b(int i2) {
            if (i2 == -1) {
                return new CustomEndIconDelegate(this.f22037b);
            }
            if (i2 == 0) {
                return new NoEndIconDelegate(this.f22037b);
            }
            if (i2 == 1) {
                return new PasswordToggleEndIconDelegate(this.f22037b, this.f22039d);
            }
            if (i2 == 2) {
                return new ClearTextEndIconDelegate(this.f22037b);
            }
            if (i2 == 3) {
                return new DropdownMenuEndIconDelegate(this.f22037b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i2);
        }

        /* access modifiers changed from: package-private */
        public EndIconDelegate c(int i2) {
            EndIconDelegate endIconDelegate = this.f22036a.get(i2);
            if (endIconDelegate != null) {
                return endIconDelegate;
            }
            EndIconDelegate b2 = b(i2);
            this.f22036a.append(i2, b2);
            return b2;
        }
    }

    EndCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        AnonymousClass2 r1 = new TextInputLayout.OnEditTextAttachedListener() {
            public void a(@NonNull TextInputLayout textInputLayout) {
                if (EndCompoundLayout.this.o3 != textInputLayout.getEditText()) {
                    if (EndCompoundLayout.this.o3 != null) {
                        EndCompoundLayout.this.o3.removeTextChangedListener(EndCompoundLayout.this.r3);
                        if (EndCompoundLayout.this.o3.getOnFocusChangeListener() == EndCompoundLayout.this.o().e()) {
                            EndCompoundLayout.this.o3.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                        }
                    }
                    EditText unused = EndCompoundLayout.this.o3 = textInputLayout.getEditText();
                    if (EndCompoundLayout.this.o3 != null) {
                        EndCompoundLayout.this.o3.addTextChangedListener(EndCompoundLayout.this.r3);
                    }
                    EndCompoundLayout.this.o().n(EndCompoundLayout.this.o3);
                    EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                    endCompoundLayout.m0(endCompoundLayout.o());
                }
            }
        };
        this.s3 = r1;
        this.p3 = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.s = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.f6388c));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.X2 = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton k2 = k(this, from, R.id.X5);
        this.Y2 = k2;
        CheckableImageButton k4 = k(frameLayout, from, R.id.W5);
        this.c3 = k4;
        this.d3 = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.m3 = appCompatTextView;
        E(tintTypedArray);
        D(tintTypedArray);
        F(tintTypedArray);
        frameLayout.addView(k4);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(k2);
        textInputLayout.i(r1);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                EndCompoundLayout.this.h();
            }

            public void onViewDetachedFromWindow(View view) {
                EndCompoundLayout.this.R();
            }
        });
    }

    private void B0() {
        int i2 = 8;
        this.X2.setVisibility((this.c3.getVisibility() != 0 || J()) ? 8 : 0);
        char c2 = (this.l3 == null || this.n3) ? (char) 8 : 0;
        if (I() || J() || c2 == 0) {
            i2 = 0;
        }
        setVisibility(i2);
    }

    private void C0() {
        int i2 = 0;
        boolean z = u() != null && this.s.T() && this.s.x0();
        CheckableImageButton checkableImageButton = this.Y2;
        if (!z) {
            i2 = 8;
        }
        checkableImageButton.setVisibility(i2);
        B0();
        D0();
        if (!C()) {
            this.s.I0();
        }
    }

    private void D(TintTypedArray tintTypedArray) {
        int i2 = R.styleable.ux;
        if (!tintTypedArray.C(i2)) {
            int i4 = R.styleable.Zw;
            if (tintTypedArray.C(i4)) {
                this.g3 = MaterialResources.b(getContext(), tintTypedArray, i4);
            }
            int i5 = R.styleable.ax;
            if (tintTypedArray.C(i5)) {
                this.h3 = ViewUtils.u(tintTypedArray.o(i5, -1), (PorterDuff.Mode) null);
            }
        }
        int i6 = R.styleable.Xw;
        if (tintTypedArray.C(i6)) {
            Z(tintTypedArray.o(i6, 0));
            int i7 = R.styleable.Uw;
            if (tintTypedArray.C(i7)) {
                V(tintTypedArray.x(i7));
            }
            T(tintTypedArray.a(R.styleable.Tw, true));
        } else if (tintTypedArray.C(i2)) {
            int i8 = R.styleable.vx;
            if (tintTypedArray.C(i8)) {
                this.g3 = MaterialResources.b(getContext(), tintTypedArray, i8);
            }
            int i9 = R.styleable.wx;
            if (tintTypedArray.C(i9)) {
                this.h3 = ViewUtils.u(tintTypedArray.o(i9, -1), (PorterDuff.Mode) null);
            }
            Z(tintTypedArray.a(i2, false) ? 1 : 0);
            V(tintTypedArray.x(R.styleable.sx));
        }
        Y(tintTypedArray.g(R.styleable.Ww, getResources().getDimensionPixelSize(R.dimen.Ec)));
        int i10 = R.styleable.Yw;
        if (tintTypedArray.C(i10)) {
            c0(IconHelper.b(tintTypedArray.o(i10, -1)));
        }
    }

    private void E(TintTypedArray tintTypedArray) {
        int i2 = R.styleable.fx;
        if (tintTypedArray.C(i2)) {
            this.Z2 = MaterialResources.b(getContext(), tintTypedArray, i2);
        }
        int i4 = R.styleable.gx;
        if (tintTypedArray.C(i4)) {
            this.a3 = ViewUtils.u(tintTypedArray.o(i4, -1), (PorterDuff.Mode) null);
        }
        int i5 = R.styleable.ex;
        if (tintTypedArray.C(i5)) {
            h0(tintTypedArray.h(i5));
        }
        this.Y2.setContentDescription(getResources().getText(R.string.U));
        ViewCompat.Z1(this.Y2, 2);
        this.Y2.setClickable(false);
        this.Y2.setPressable(false);
        this.Y2.setFocusable(false);
    }

    private void E0() {
        int visibility = this.m3.getVisibility();
        boolean z = false;
        int i2 = (this.l3 == null || this.n3) ? 8 : 0;
        if (visibility != i2) {
            EndIconDelegate o = o();
            if (i2 == 0) {
                z = true;
            }
            o.q(z);
        }
        B0();
        this.m3.setVisibility(i2);
        this.s.I0();
    }

    private void F(TintTypedArray tintTypedArray) {
        this.m3.setVisibility(8);
        this.m3.setId(R.id.e6);
        this.m3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.J1(this.m3, 1);
        v0(tintTypedArray.u(R.styleable.Nx, 0));
        int i2 = R.styleable.Ox;
        if (tintTypedArray.C(i2)) {
            w0(tintTypedArray.d(i2));
        }
        u0(tintTypedArray.x(R.styleable.Mx));
    }

    /* access modifiers changed from: private */
    public void R() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.q3;
        if (touchExplorationStateChangeListener != null && (accessibilityManager = this.p3) != null) {
            AccessibilityManagerCompat.h(accessibilityManager, touchExplorationStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.q3 != null && this.p3 != null && ViewCompat.R0(this)) {
            AccessibilityManagerCompat.b(this.p3, this.q3);
        }
    }

    private CheckableImageButton k(ViewGroup viewGroup, LayoutInflater layoutInflater, @IdRes int i2) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.Q, viewGroup, false);
        checkableImageButton.setId(i2);
        IconHelper.e(checkableImageButton);
        if (MaterialResources.j(getContext())) {
            MarginLayoutParamsCompat.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void l(int i2) {
        Iterator<TextInputLayout.OnEndIconChangedListener> it2 = this.f3.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.s, i2);
        }
    }

    /* access modifiers changed from: private */
    public void m0(EndIconDelegate endIconDelegate) {
        if (this.o3 != null) {
            if (endIconDelegate.e() != null) {
                this.o3.setOnFocusChangeListener(endIconDelegate.e());
            }
            if (endIconDelegate.g() != null) {
                this.c3.setOnFocusChangeListener(endIconDelegate.g());
            }
        }
    }

    private int v(EndIconDelegate endIconDelegate) {
        int a2 = this.d3.f22038c;
        return a2 == 0 ? endIconDelegate.d() : a2;
    }

    private void x0(@NonNull EndIconDelegate endIconDelegate) {
        endIconDelegate.s();
        this.q3 = endIconDelegate.h();
        h();
    }

    private void y0(@NonNull EndIconDelegate endIconDelegate) {
        R();
        this.q3 = null;
        endIconDelegate.u();
    }

    private void z0(boolean z) {
        if (!z || p() == null) {
            IconHelper.a(this.s, this.c3, this.g3, this.h3);
            return;
        }
        Drawable mutate = DrawableCompat.r(p()).mutate();
        DrawableCompat.n(mutate, this.s.getErrorCurrentTextColors());
        this.c3.setImageDrawable(mutate);
    }

    /* access modifiers changed from: package-private */
    public int A() {
        return ViewCompat.m0(this) + ViewCompat.m0(this.m3) + ((I() || J()) ? this.c3.getMeasuredWidth() + MarginLayoutParamsCompat.c((ViewGroup.MarginLayoutParams) this.c3.getLayoutParams()) : 0);
    }

    /* access modifiers changed from: package-private */
    public void A0(boolean z) {
        if (this.e3 == 1) {
            this.c3.performClick();
            if (z) {
                this.c3.jumpDrawablesToCurrentState();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public TextView B() {
        return this.m3;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return this.e3 != 0;
    }

    /* access modifiers changed from: package-private */
    public void D0() {
        if (this.s.Z2 != null) {
            ViewCompat.n2(this.m3, getContext().getResources().getDimensionPixelSize(R.dimen.ea), this.s.Z2.getPaddingTop(), (I() || J()) ? 0 : ViewCompat.m0(this.s.Z2), this.s.Z2.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.c3.a();
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return C() && this.c3.isChecked();
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return this.X2.getVisibility() == 0 && this.c3.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return this.Y2.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return this.e3 == 1;
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z) {
        this.n3 = z;
        E0();
    }

    /* access modifiers changed from: package-private */
    public void M() {
        C0();
        O();
        N();
        if (o().t()) {
            z0(this.s.x0());
        }
    }

    /* access modifiers changed from: package-private */
    public void N() {
        IconHelper.d(this.s, this.c3, this.g3);
    }

    /* access modifiers changed from: package-private */
    public void O() {
        IconHelper.d(this.s, this.Y2, this.Z2);
    }

    /* access modifiers changed from: package-private */
    public void P(boolean z) {
        boolean z2;
        boolean isActivated;
        boolean isChecked;
        EndIconDelegate o = o();
        boolean z3 = true;
        if (!o.l() || (isChecked = this.c3.isChecked()) == o.m()) {
            z2 = false;
        } else {
            this.c3.setChecked(!isChecked);
            z2 = true;
        }
        if (!o.j() || (isActivated = this.c3.isActivated()) == o.k()) {
            z3 = z2;
        } else {
            S(!isActivated);
        }
        if (z || z3) {
            N();
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.f3.remove(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void S(boolean z) {
        this.c3.setActivated(z);
    }

    /* access modifiers changed from: package-private */
    public void T(boolean z) {
        this.c3.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    public void U(@StringRes int i2) {
        V(i2 != 0 ? getResources().getText(i2) : null);
    }

    /* access modifiers changed from: package-private */
    public void V(@Nullable CharSequence charSequence) {
        if (n() != charSequence) {
            this.c3.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void W(@DrawableRes int i2) {
        X(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    /* access modifiers changed from: package-private */
    public void X(@Nullable Drawable drawable) {
        this.c3.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.s, this.c3, this.g3, this.h3);
            N();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i2 != this.i3) {
            this.i3 = i2;
            IconHelper.g(this.c3, i2);
            IconHelper.g(this.Y2, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(int i2) {
        if (this.e3 != i2) {
            y0(o());
            int i4 = this.e3;
            this.e3 = i2;
            l(i4);
            f0(i2 != 0);
            EndIconDelegate o = o();
            W(v(o));
            U(o.c());
            T(o.l());
            if (o.i(this.s.getBoxBackgroundMode())) {
                x0(o);
                a0(o.f());
                EditText editText = this.o3;
                if (editText != null) {
                    o.n(editText);
                    m0(o);
                }
                IconHelper.a(this.s, this.c3, this.g3, this.h3);
                P(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.s.getBoxBackgroundMode() + " is not supported by the end icon mode " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(@Nullable View.OnClickListener onClickListener) {
        IconHelper.h(this.c3, onClickListener, this.k3);
    }

    /* access modifiers changed from: package-private */
    public void b0(@Nullable View.OnLongClickListener onLongClickListener) {
        this.k3 = onLongClickListener;
        IconHelper.i(this.c3, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void c0(@NonNull ImageView.ScaleType scaleType) {
        this.j3 = scaleType;
        IconHelper.j(this.c3, scaleType);
        IconHelper.j(this.Y2, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void d0(@Nullable ColorStateList colorStateList) {
        if (this.g3 != colorStateList) {
            this.g3 = colorStateList;
            IconHelper.a(this.s, this.c3, colorStateList, this.h3);
        }
    }

    /* access modifiers changed from: package-private */
    public void e0(@Nullable PorterDuff.Mode mode) {
        if (this.h3 != mode) {
            this.h3 = mode;
            IconHelper.a(this.s, this.c3, this.g3, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void f0(boolean z) {
        if (I() != z) {
            this.c3.setVisibility(z ? 0 : 8);
            B0();
            D0();
            this.s.I0();
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.f3.add(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void g0(@DrawableRes int i2) {
        h0(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
        O();
    }

    /* access modifiers changed from: package-private */
    public void h0(@Nullable Drawable drawable) {
        this.Y2.setImageDrawable(drawable);
        C0();
        IconHelper.a(this.s, this.Y2, this.Z2, this.a3);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.c3.performClick();
        this.c3.jumpDrawablesToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public void i0(@Nullable View.OnClickListener onClickListener) {
        IconHelper.h(this.Y2, onClickListener, this.b3);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f3.clear();
    }

    /* access modifiers changed from: package-private */
    public void j0(@Nullable View.OnLongClickListener onLongClickListener) {
        this.b3 = onLongClickListener;
        IconHelper.i(this.Y2, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void k0(@Nullable ColorStateList colorStateList) {
        if (this.Z2 != colorStateList) {
            this.Z2 = colorStateList;
            IconHelper.a(this.s, this.Y2, colorStateList, this.a3);
        }
    }

    /* access modifiers changed from: package-private */
    public void l0(@Nullable PorterDuff.Mode mode) {
        if (this.a3 != mode) {
            this.a3 = mode;
            IconHelper.a(this.s, this.Y2, this.Z2, mode);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CheckableImageButton m() {
        if (J()) {
            return this.Y2;
        }
        if (!C() || !I()) {
            return null;
        }
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence n() {
        return this.c3.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void n0(@StringRes int i2) {
        o0(i2 != 0 ? getResources().getText(i2) : null);
    }

    /* access modifiers changed from: package-private */
    public EndIconDelegate o() {
        return this.d3.c(this.e3);
    }

    /* access modifiers changed from: package-private */
    public void o0(@Nullable CharSequence charSequence) {
        this.c3.setContentDescription(charSequence);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable p() {
        return this.c3.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void p0(@DrawableRes int i2) {
        q0(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public void q0(@Nullable Drawable drawable) {
        this.c3.setImageDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.e3;
    }

    /* access modifiers changed from: package-private */
    public void r0(boolean z) {
        if (z && this.e3 != 1) {
            Z(1);
        } else if (!z) {
            Z(0);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType s() {
        return this.j3;
    }

    /* access modifiers changed from: package-private */
    public void s0(@Nullable ColorStateList colorStateList) {
        this.g3 = colorStateList;
        IconHelper.a(this.s, this.c3, colorStateList, this.h3);
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton t() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public void t0(@Nullable PorterDuff.Mode mode) {
        this.h3 = mode;
        IconHelper.a(this.s, this.c3, this.g3, mode);
    }

    /* access modifiers changed from: package-private */
    public Drawable u() {
        return this.Y2.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void u0(@Nullable CharSequence charSequence) {
        this.l3 = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.m3.setText(charSequence);
        E0();
    }

    /* access modifiers changed from: package-private */
    public void v0(@StyleRes int i2) {
        TextViewCompat.D(this.m3, i2);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence w() {
        return this.c3.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void w0(@NonNull ColorStateList colorStateList) {
        this.m3.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable x() {
        return this.c3.getDrawable();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence y() {
        return this.l3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList z() {
        return this.m3.getTextColors();
    }
}
