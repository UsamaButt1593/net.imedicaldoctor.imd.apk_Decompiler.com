package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

@SuppressLint({"ViewConstructor"})
class StartCompoundLayout extends LinearLayout {
    private final TextView X2;
    @Nullable
    private CharSequence Y2;
    private final CheckableImageButton Z2;
    private ColorStateList a3;
    private PorterDuff.Mode b3;
    private int c3;
    @NonNull
    private ImageView.ScaleType d3;
    private View.OnLongClickListener e3;
    private boolean f3;
    private final TextInputLayout s;

    StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.s = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.f6387b));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.R, this, false);
        this.Z2 = checkableImageButton;
        IconHelper.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.X2 = appCompatTextView;
        j(tintTypedArray);
        i(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void D() {
        int i2 = 8;
        int i3 = (this.Y2 == null || this.f3) ? 8 : 0;
        if (this.Z2.getVisibility() == 0 || i3 == 0) {
            i2 = 0;
        }
        setVisibility(i2);
        this.X2.setVisibility(i3);
        this.s.I0();
    }

    private void i(TintTypedArray tintTypedArray) {
        this.X2.setVisibility(8);
        this.X2.setId(R.id.d6);
        this.X2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.J1(this.X2, 1);
        p(tintTypedArray.u(R.styleable.Bx, 0));
        int i2 = R.styleable.Cx;
        if (tintTypedArray.C(i2)) {
            q(tintTypedArray.d(i2));
        }
        o(tintTypedArray.x(R.styleable.Ax));
    }

    private void j(TintTypedArray tintTypedArray) {
        if (MaterialResources.j(getContext())) {
            MarginLayoutParamsCompat.g((ViewGroup.MarginLayoutParams) this.Z2.getLayoutParams(), 0);
        }
        v((View.OnClickListener) null);
        w((View.OnLongClickListener) null);
        int i2 = R.styleable.Kx;
        if (tintTypedArray.C(i2)) {
            this.a3 = MaterialResources.b(getContext(), tintTypedArray, i2);
        }
        int i3 = R.styleable.Lx;
        if (tintTypedArray.C(i3)) {
            this.b3 = ViewUtils.u(tintTypedArray.o(i3, -1), (PorterDuff.Mode) null);
        }
        int i4 = R.styleable.Hx;
        if (tintTypedArray.C(i4)) {
            t(tintTypedArray.h(i4));
            int i5 = R.styleable.Gx;
            if (tintTypedArray.C(i5)) {
                s(tintTypedArray.x(i5));
            }
            r(tintTypedArray.a(R.styleable.Fx, true));
        }
        u(tintTypedArray.g(R.styleable.Ix, getResources().getDimensionPixelSize(R.dimen.Ec)));
        int i6 = R.styleable.Jx;
        if (tintTypedArray.C(i6)) {
            x(IconHelper.b(tintTypedArray.o(i6, -1)));
        }
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z) {
        if (l() != z) {
            this.Z2.setVisibility(z ? 0 : 8);
            C();
            D();
        }
    }

    /* access modifiers changed from: package-private */
    public void B(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        View view;
        if (this.X2.getVisibility() == 0) {
            accessibilityNodeInfoCompat.D1(this.X2);
            view = this.X2;
        } else {
            view = this.Z2;
        }
        accessibilityNodeInfoCompat.j2(view);
    }

    /* access modifiers changed from: package-private */
    public void C() {
        EditText editText = this.s.Z2;
        if (editText != null) {
            ViewCompat.n2(this.X2, l() ? 0 : ViewCompat.n0(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.ea), editText.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence a() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList b() {
        return this.X2.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return ViewCompat.n0(this) + ViewCompat.n0(this.X2) + (l() ? this.Z2.getMeasuredWidth() + MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) this.Z2.getLayoutParams()) : 0);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TextView d() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence e() {
        return this.Z2.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable f() {
        return this.Z2.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType h() {
        return this.d3;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.Z2.a();
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.Z2.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        this.f3 = z;
        D();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        IconHelper.d(this.s, this.Z2, this.a3);
    }

    /* access modifiers changed from: package-private */
    public void o(@Nullable CharSequence charSequence) {
        this.Y2 = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.X2.setText(charSequence);
        D();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        C();
    }

    /* access modifiers changed from: package-private */
    public void p(@StyleRes int i2) {
        TextViewCompat.D(this.X2, i2);
    }

    /* access modifiers changed from: package-private */
    public void q(@NonNull ColorStateList colorStateList) {
        this.X2.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z) {
        this.Z2.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    public void s(@Nullable CharSequence charSequence) {
        if (e() != charSequence) {
            this.Z2.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(@Nullable Drawable drawable) {
        this.Z2.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.s, this.Z2, this.a3, this.b3);
            A(true);
            n();
            return;
        }
        A(false);
        v((View.OnClickListener) null);
        w((View.OnLongClickListener) null);
        s((CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public void u(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i2 != this.c3) {
            this.c3 = i2;
            IconHelper.g(this.Z2, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(@Nullable View.OnClickListener onClickListener) {
        IconHelper.h(this.Z2, onClickListener, this.e3);
    }

    /* access modifiers changed from: package-private */
    public void w(@Nullable View.OnLongClickListener onLongClickListener) {
        this.e3 = onLongClickListener;
        IconHelper.i(this.Z2, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void x(@NonNull ImageView.ScaleType scaleType) {
        this.d3 = scaleType;
        IconHelper.j(this.Z2, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void y(@Nullable ColorStateList colorStateList) {
        if (this.a3 != colorStateList) {
            this.a3 = colorStateList;
            IconHelper.a(this.s, this.Z2, colorStateList, this.b3);
        }
    }

    /* access modifiers changed from: package-private */
    public void z(@Nullable PorterDuff.Mode mode) {
        if (this.b3 != mode) {
            this.b3 = mode;
            IconHelper.a(this.s, this.Z2, this.a3, mode);
        }
    }
}
