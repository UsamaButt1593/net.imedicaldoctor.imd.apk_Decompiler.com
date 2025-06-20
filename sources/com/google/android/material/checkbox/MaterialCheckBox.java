package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[][] A3;
    @SuppressLint({"DiscouragedApi"})
    private static final int B3 = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    private static final int u3 = R.style.ej;
    public static final int v3 = 0;
    public static final int w3 = 1;
    public static final int x3 = 2;
    private static final int[] y3 = {R.attr.eh};
    private static final int[] z3;
    @NonNull
    private final LinkedHashSet<OnErrorChangedListener> a3;
    @NonNull
    private final LinkedHashSet<OnCheckedStateChangedListener> b3;
    @Nullable
    private ColorStateList c3;
    private boolean d3;
    private boolean e3;
    private boolean f3;
    @Nullable
    private CharSequence g3;
    @Nullable
    private Drawable h3;
    @Nullable
    private Drawable i3;
    private boolean j3;
    @Nullable
    ColorStateList k3;
    @Nullable
    ColorStateList l3;
    @NonNull
    private PorterDuff.Mode m3;
    private int n3;
    /* access modifiers changed from: private */
    public int[] o3;
    private boolean p3;
    @Nullable
    private CharSequence q3;
    @Nullable
    private CompoundButton.OnCheckedChangeListener r3;
    @Nullable
    private final AnimatedVectorDrawableCompat s3;
    private final Animatable2Compat.AnimationCallback t3;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void a(@NonNull MaterialCheckBox materialCheckBox, int i2);
    }

    public interface OnErrorChangedListener {
        void a(@NonNull MaterialCheckBox materialCheckBox, boolean z);
    }

    static {
        int i2 = R.attr.dh;
        z3 = new int[]{i2};
        A3 = new int[][]{new int[]{16842910, i2}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private String getButtonStateDescription() {
        Resources resources;
        int i2;
        int i4 = this.n3;
        if (i4 == 1) {
            resources = getResources();
            i2 = R.string.W0;
        } else if (i4 == 0) {
            resources = getResources();
            i2 = R.string.Y0;
        } else {
            resources = getResources();
            i2 = R.string.X0;
        }
        return resources.getString(i2);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.c3 == null) {
            int[][] iArr = A3;
            int[] iArr2 = new int[iArr.length];
            int d2 = MaterialColors.d(this, R.attr.p3);
            int d4 = MaterialColors.d(this, R.attr.s3);
            int d5 = MaterialColors.d(this, R.attr.e4);
            int d6 = MaterialColors.d(this, R.attr.I3);
            iArr2[0] = MaterialColors.t(d5, d4, 1.0f);
            iArr2[1] = MaterialColors.t(d5, d2, 1.0f);
            iArr2[2] = MaterialColors.t(d5, d6, 0.54f);
            iArr2[3] = MaterialColors.t(d5, d6, 0.38f);
            iArr2[4] = MaterialColors.t(d5, d6, 0.38f);
            this.c3 = new ColorStateList(iArr, iArr2);
        }
        return this.c3;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.k3;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private boolean i(TintTypedArray tintTypedArray) {
        return tintTypedArray.u(R.styleable.rn, 0) == B3 && tintTypedArray.u(R.styleable.sn, 0) == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.i3.jumpToCurrentState();
    }

    private void n() {
        this.h3 = DrawableUtils.d(this.h3, this.k3, CompoundButtonCompat.c(this));
        this.i3 = DrawableUtils.d(this.i3, this.l3, this.m3);
        r();
        s();
        super.setButtonDrawable(DrawableUtils.a(this.h3, this.i3));
        refreshDrawableState();
    }

    private void q() {
        if (Build.VERSION.SDK_INT >= 30 && this.q3 == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void r() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (this.j3) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.s3;
            if (animatedVectorDrawableCompat2 != null) {
                animatedVectorDrawableCompat2.d(this.t3);
                this.s3.b(this.t3);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.h3;
                if ((drawable instanceof AnimatedStateListDrawable) && (animatedVectorDrawableCompat = this.s3) != null) {
                    int i2 = R.id.G0;
                    int i4 = R.id.v6;
                    ((AnimatedStateListDrawable) drawable).addTransition(i2, i4, animatedVectorDrawableCompat, false);
                    ((AnimatedStateListDrawable) this.h3).addTransition(R.id.f2, i4, this.s3, false);
                }
            }
        }
    }

    private void s() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.h3;
        if (!(drawable == null || (colorStateList2 = this.k3) == null)) {
            DrawableCompat.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.i3;
        if (drawable2 != null && (colorStateList = this.l3) != null) {
            DrawableCompat.o(drawable2, colorStateList);
        }
    }

    private void t() {
    }

    public void e(@NonNull OnCheckedStateChangedListener onCheckedStateChangedListener) {
        this.b3.add(onCheckedStateChangedListener);
    }

    public void f(@NonNull OnErrorChangedListener onErrorChangedListener) {
        this.a3.add(onErrorChangedListener);
    }

    public void g() {
        this.b3.clear();
    }

    @Nullable
    public Drawable getButtonDrawable() {
        return this.h3;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.i3;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.l3;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.m3;
    }

    @Nullable
    public ColorStateList getButtonTintList() {
        return this.k3;
    }

    public int getCheckedState() {
        return this.n3;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.g3;
    }

    public void h() {
        this.a3.clear();
    }

    public boolean isChecked() {
        return this.n3 == 1;
    }

    public boolean j() {
        return this.e3;
    }

    public boolean k() {
        return this.f3;
    }

    public boolean l() {
        return this.d3;
    }

    public void o(@NonNull OnCheckedStateChangedListener onCheckedStateChangedListener) {
        this.b3.remove(onCheckedStateChangedListener);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d3 && this.k3 == null && this.l3 == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, y3);
        }
        if (k()) {
            View.mergeDrawableStates(onCreateDrawableState, z3);
        }
        this.o3 = DrawableUtils.f(onCreateDrawableState);
        t();
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable a2;
        if (!this.e3 || !TextUtils.isEmpty(getText()) || (a2 = CompoundButtonCompat.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - a2.getIntrinsicWidth()) / 2) * (ViewUtils.s(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate((float) width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a2.getBounds();
            DrawableCompat.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && k()) {
            accessibilityNodeInfo.setText(accessibilityNodeInfo.getText() + ", " + this.g3);
        }
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.s);
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = getCheckedState();
        return savedState;
    }

    public void p(@NonNull OnErrorChangedListener onErrorChangedListener) {
        this.a3.remove(onErrorChangedListener);
    }

    public void setButtonDrawable(@DrawableRes int i2) {
        setButtonDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.i3 = drawable;
        n();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i2) {
        setButtonIconDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.l3 != colorStateList) {
            this.l3 = colorStateList;
            n();
        }
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.m3 != mode) {
            this.m3 = mode;
            n();
        }
    }

    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.k3 != colorStateList) {
            this.k3 = colorStateList;
            n();
        }
    }

    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        n();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.e3 = z;
    }

    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i2) {
        AutofillManager a2;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.n3 != i2) {
            this.n3 = i2;
            super.setChecked(i2 == 1);
            refreshDrawableState();
            q();
            if (!this.p3) {
                this.p3 = true;
                LinkedHashSet<OnCheckedStateChangedListener> linkedHashSet = this.b3;
                if (linkedHashSet != null) {
                    Iterator<OnCheckedStateChangedListener> it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(this, this.n3);
                    }
                }
                if (!(this.n3 == 2 || (onCheckedChangeListener = this.r3) == null)) {
                    onCheckedChangeListener.onCheckedChanged(this, isChecked());
                }
                if (Build.VERSION.SDK_INT >= 26 && (a2 = b.a(getContext().getSystemService(a.a()))) != null) {
                    a2.notifyValueChanged(this);
                }
                this.p3 = false;
            }
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        t();
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.g3 = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i2) {
        setErrorAccessibilityLabel(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.f3 != z) {
            this.f3 = z;
            refreshDrawableState();
            Iterator<OnErrorChangedListener> it2 = this.a3.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.f3);
            }
        }
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.r3 = onCheckedChangeListener;
    }

    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.q3 = charSequence;
        if (charSequence == null) {
            q();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.d3 = z;
        CompoundButtonCompat.d(this, z ? getMaterialThemeColorsTintList() : null);
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    static class SavedState extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int s;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.s = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }

        @NonNull
        private String a() {
            int i2 = this.s;
            if (i2 != 1) {
                return i2 != 2 ? "unchecked" : "indeterminate";
            }
            return "checked";
        }

        @NonNull
        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Integer.valueOf(this.s));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.e2);
    }

    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.h3 = drawable;
        this.j3 = false;
        n();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCheckBox(android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = u3
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.a3 = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.b3 = r9
            android.content.Context r9 = r8.getContext()
            int r0 = com.google.android.material.R.drawable.G1
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r9 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.e(r9, r0)
            r8.s3 = r9
            com.google.android.material.checkbox.MaterialCheckBox$1 r9 = new com.google.android.material.checkbox.MaterialCheckBox$1
            r9.<init>()
            r8.t3 = r9
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.CompoundButtonCompat.a(r8)
            r8.h3 = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.k3 = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = com.google.android.material.R.styleable.qn
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.TintTypedArray r10 = com.google.android.material.internal.ThemeEnforcement.l(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.tn
            android.graphics.drawable.Drawable r11 = r10.h(r11)
            r8.i3 = r11
            android.graphics.drawable.Drawable r11 = r8.h3
            r0 = 1
            if (r11 == 0) goto L_0x007c
            boolean r11 = com.google.android.material.internal.ThemeEnforcement.h(r9)
            if (r11 == 0) goto L_0x007c
            boolean r11 = r8.i(r10)
            if (r11 == 0) goto L_0x007c
            super.setButtonDrawable((android.graphics.drawable.Drawable) r6)
            int r11 = com.google.android.material.R.drawable.F1
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r9, r11)
            r8.h3 = r11
            r8.j3 = r0
            android.graphics.drawable.Drawable r11 = r8.i3
            if (r11 != 0) goto L_0x007c
            int r11 = com.google.android.material.R.drawable.H1
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.b(r9, r11)
            r8.i3 = r11
        L_0x007c:
            int r11 = com.google.android.material.R.styleable.un
            android.content.res.ColorStateList r9 = com.google.android.material.resources.MaterialResources.b(r9, r10, r11)
            r8.l3 = r9
            int r9 = com.google.android.material.R.styleable.vn
            r11 = -1
            int r9 = r10.o(r9, r11)
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.ViewUtils.u(r9, r11)
            r8.m3 = r9
            int r9 = com.google.android.material.R.styleable.Bn
            boolean r9 = r10.a(r9, r7)
            r8.d3 = r9
            int r9 = com.google.android.material.R.styleable.xn
            boolean r9 = r10.a(r9, r0)
            r8.e3 = r9
            int r9 = com.google.android.material.R.styleable.An
            boolean r9 = r10.a(r9, r7)
            r8.f3 = r9
            int r9 = com.google.android.material.R.styleable.zn
            java.lang.CharSequence r9 = r10.x(r9)
            r8.g3 = r9
            int r9 = com.google.android.material.R.styleable.yn
            boolean r11 = r10.C(r9)
            if (r11 == 0) goto L_0x00c2
            int r9 = r10.o(r9, r7)
            r8.setCheckedState(r9)
        L_0x00c2:
            r10.I()
            r8.n()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
