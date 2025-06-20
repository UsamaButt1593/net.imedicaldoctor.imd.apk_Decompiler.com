package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.C0004e;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] n3 = {16842911};
    private static final int[] o3 = {16842912};
    public static final int p3 = 1;
    public static final int q3 = 2;
    public static final int r3 = 3;
    public static final int s3 = 4;
    public static final int t3 = 16;
    public static final int u3 = 32;
    private static final String v3 = "MaterialButton";
    private static final int w3 = R.style.Gi;
    @NonNull
    private final MaterialButtonHelper Z2;
    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> a3;
    @Nullable
    private OnPressedChangeListener b3;
    @Nullable
    private PorterDuff.Mode c3;
    @Nullable
    private ColorStateList d3;
    @Nullable
    private Drawable e3;
    @Nullable
    private String f3;
    @Px
    private int g3;
    @Px
    private int h3;
    @Px
    private int i3;
    @Px
    private int j3;
    private boolean k3;
    private boolean l3;
    private int m3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<MaterialButton> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f20879a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f20880b;

        /* renamed from: a */
        public void readProperties(@NonNull MaterialButton materialButton, @NonNull PropertyReader propertyReader) {
            if (this.f20879a) {
                propertyReader.readInt(this.f20880b, materialButton.getIconPadding());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f20880b = propertyMapper.mapInt("iconPadding", R.attr.e9);
            this.f20879a = true;
        }
    }

    public interface OnCheckedChangeListener {
        void a(MaterialButton materialButton, boolean z);
    }

    interface OnPressedChangeListener {
        void a(MaterialButton materialButton, boolean z);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean Y;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            b(parcel);
        }

        private void b(@NonNull Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.Y = z;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean e() {
        int i2 = this.m3;
        return i2 == 3 || i2 == 4;
    }

    private boolean f() {
        int i2 = this.m3;
        return i2 == 1 || i2 == 2;
    }

    private boolean g() {
        int i2 = this.m3;
        return i2 == 16 || i2 == 32;
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.f6389d;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < lineCount; i2++) {
            f2 = Math.max(f2, getLayout().getLineWidth(i2));
        }
        return (int) Math.ceil((double) f2);
    }

    private boolean h() {
        return ViewCompat.c0(this) == 1;
    }

    private boolean j() {
        MaterialButtonHelper materialButtonHelper = this.Z2;
        return materialButtonHelper != null && !materialButtonHelper.o();
    }

    private void l() {
        if (f()) {
            TextViewCompat.u(this, this.e3, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (e()) {
            TextViewCompat.u(this, (Drawable) null, (Drawable) null, this.e3, (Drawable) null);
        } else if (g()) {
            TextViewCompat.u(this, (Drawable) null, this.e3, (Drawable) null, (Drawable) null);
        }
    }

    private void m(boolean z) {
        Drawable drawable = this.e3;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.e3 = mutate;
            DrawableCompat.o(mutate, this.d3);
            PorterDuff.Mode mode = this.c3;
            if (mode != null) {
                DrawableCompat.p(this.e3, mode);
            }
            int i2 = this.g3;
            if (i2 == 0) {
                i2 = this.e3.getIntrinsicWidth();
            }
            int i4 = this.g3;
            if (i4 == 0) {
                i4 = this.e3.getIntrinsicHeight();
            }
            Drawable drawable2 = this.e3;
            int i5 = this.h3;
            int i6 = this.i3;
            drawable2.setBounds(i5, i6, i2 + i5, i4 + i6);
            this.e3.setVisible(true, z);
        }
        if (z) {
            l();
            return;
        }
        Drawable[] h2 = TextViewCompat.h(this);
        Drawable drawable3 = h2[0];
        Drawable drawable4 = h2[1];
        Drawable drawable5 = h2[2];
        if ((f() && drawable3 != this.e3) || ((e() && drawable5 != this.e3) || (g() && drawable4 != this.e3))) {
            l();
        }
    }

    private void n(int i2, int i4) {
        if (this.e3 != null && getLayout() != null) {
            if (f() || e()) {
                this.i3 = 0;
                Layout.Alignment actualTextAlignment = getActualTextAlignment();
                int i5 = this.m3;
                boolean z = true;
                if (i5 == 1 || i5 == 3 || ((i5 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i5 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                    this.h3 = 0;
                } else {
                    int i6 = this.g3;
                    if (i6 == 0) {
                        i6 = this.e3.getIntrinsicWidth();
                    }
                    int textLayoutWidth = ((((i2 - getTextLayoutWidth()) - ViewCompat.m0(this)) - i6) - this.j3) - ViewCompat.n0(this);
                    if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                        textLayoutWidth /= 2;
                    }
                    boolean h2 = h();
                    if (this.m3 != 4) {
                        z = false;
                    }
                    if (h2 != z) {
                        textLayoutWidth = -textLayoutWidth;
                    }
                    if (this.h3 != textLayoutWidth) {
                        this.h3 = textLayoutWidth;
                        m(false);
                        return;
                    }
                    return;
                }
            } else if (g()) {
                this.h3 = 0;
                if (this.m3 == 16) {
                    this.i3 = 0;
                } else {
                    int i7 = this.g3;
                    if (i7 == 0) {
                        i7 = this.e3.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i4 - getTextHeight()) - getPaddingTop()) - i7) - this.j3) - getPaddingBottom()) / 2);
                    if (this.i3 != max) {
                        this.i3 = max;
                        m(false);
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            m(false);
        }
    }

    public void a(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.a3.add(onCheckedChangeListener);
    }

    public void c() {
        this.a3.clear();
    }

    public boolean d() {
        MaterialButtonHelper materialButtonHelper = this.Z2;
        return materialButtonHelper != null && materialButtonHelper.p();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f3)) {
            return this.f3;
        }
        return (d() ? CompoundButton.class : Button.class).getName();
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (j()) {
            return this.Z2.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.e3;
    }

    public int getIconGravity() {
        return this.m3;
    }

    @Px
    public int getIconPadding() {
        return this.j3;
    }

    @Px
    public int getIconSize() {
        return this.g3;
    }

    public ColorStateList getIconTint() {
        return this.d3;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.c3;
    }

    @Dimension
    public int getInsetBottom() {
        return this.Z2.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.Z2.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (j()) {
            return this.Z2.h();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (j()) {
            return this.Z2.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (j()) {
            return this.Z2.j();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (j()) {
            return this.Z2.k();
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return j() ? this.Z2.l() : super.getSupportBackgroundTintList();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return j() ? this.Z2.m() : super.getSupportBackgroundTintMode();
    }

    public boolean i() {
        return this.Z2.q();
    }

    public boolean isChecked() {
        return this.k3;
    }

    public void k(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.a3.remove(onCheckedChangeListener);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (j()) {
            MaterialShapeUtils.f(this, this.Z2.f());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (d()) {
            View.mergeDrawableStates(onCreateDrawableState, n3);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, o3);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z, i2, i4, i5, i6);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper = this.Z2) != null) {
            materialButtonHelper.J(i6 - i4, i5 - i2);
        }
        n(getMeasuredWidth(), getMeasuredHeight());
    }

    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.Y);
    }

    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = this.k3;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        super.onTextChanged(charSequence, i2, i4, i5);
        n(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        if (this.Z2.q()) {
            toggle();
        }
        return super.performClick();
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.e3 != null) {
            if (this.e3.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setA11yClassName(@Nullable String str) {
        this.f3 = str;
    }

    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(@ColorInt int i2) {
        if (j()) {
            this.Z2.s(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (j()) {
            if (drawable != getBackground()) {
                Log.w(v3, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.Z2.t();
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (j()) {
            this.Z2.u(z);
        }
    }

    public void setChecked(boolean z) {
        if (d() && isEnabled() && this.k3 != z) {
            this.k3 = z;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).p(this, this.k3);
            }
            if (!this.l3) {
                this.l3 = true;
                Iterator<OnCheckedChangeListener> it2 = this.a3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.k3);
                }
                this.l3 = false;
            }
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (j()) {
            this.Z2.v(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (j()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (j()) {
            this.Z2.f().o0(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.e3 != drawable) {
            this.e3 = drawable;
            m(true);
            n(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.m3 != i2) {
            this.m3 = i2;
            n(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.j3 != i2) {
            this.j3 = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.g3 != i2) {
            this.g3 = i2;
            m(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.d3 != colorStateList) {
            this.d3 = colorStateList;
            m(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.c3 != mode) {
            this.c3 = mode;
            m(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.a(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        this.Z2.w(i2);
    }

    public void setInsetTop(@Dimension int i2) {
        this.Z2.x(i2);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        this.b3 = onPressedChangeListener;
    }

    public void setPressed(boolean z) {
        OnPressedChangeListener onPressedChangeListener = this.b3;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (j()) {
            this.Z2.y(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (j()) {
            setRippleColor(AppCompatResources.a(getContext(), i2));
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (j()) {
            this.Z2.z(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (j()) {
            this.Z2.A(z);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (j()) {
            this.Z2.B(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (j()) {
            setStrokeColor(AppCompatResources.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (j()) {
            this.Z2.C(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (j()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (j()) {
            this.Z2.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (j()) {
            this.Z2.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @RequiresApi(17)
    public void setTextAlignment(int i2) {
        super.setTextAlignment(i2);
        n(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.Z2.F(z);
    }

    public void toggle() {
        setChecked(!this.k3);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mc);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = w3
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.a3 = r9
            r9 = 0
            r8.k3 = r9
            r8.l3 = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.dm
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.qm
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.j3 = r1
            int r1 = com.google.android.material.R.styleable.tm
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.u(r1, r2)
            r8.c3 = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.sm
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r1, r0, r2)
            r8.d3 = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.om
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.e(r1, r0, r2)
            r8.e3 = r1
            int r1 = com.google.android.material.R.styleable.pm
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.m3 = r1
            int r1 = com.google.android.material.R.styleable.rm
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.g3 = r1
            com.google.android.material.shape.ShapeAppearanceModel$Builder r10 = com.google.android.material.shape.ShapeAppearanceModel.e(r7, r10, r11, r6)
            com.google.android.material.shape.ShapeAppearanceModel r10 = r10.m()
            com.google.android.material.button.MaterialButtonHelper r11 = new com.google.android.material.button.MaterialButtonHelper
            r11.<init>(r8, r10)
            r8.Z2 = r11
            r11.r(r0)
            r0.recycle()
            int r10 = r8.j3
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.e3
            if (r10 == 0) goto L_0x0084
            r9 = 1
        L_0x0084:
            r8.m(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
