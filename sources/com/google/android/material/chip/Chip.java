package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.itextpdf.tool.xml.css.CSS;
import java.util.List;

public class Chip extends AppCompatCheckBox implements ChipDrawable.Delegate, Shapeable, MaterialCheckable<Chip> {
    private static final String A3 = "http://schemas.android.com/apk/res/android";
    private static final int B3 = 48;
    private static final String C3 = "android.widget.Button";
    private static final String D3 = "android.widget.RadioButton";
    private static final String E3 = "android.view.View";
    private static final String t3 = "Chip";
    private static final int u3 = R.style.Vi;
    private static final int v3 = 0;
    private static final int w3 = 1;
    /* access modifiers changed from: private */
    public static final Rect x3 = new Rect();
    private static final int[] y3 = {16842913};
    private static final int[] z3 = {16842911};
    /* access modifiers changed from: private */
    @Nullable
    public ChipDrawable a3;
    @Nullable
    private InsetDrawable b3;
    @Nullable
    private RippleDrawable c3;
    /* access modifiers changed from: private */
    @Nullable
    public View.OnClickListener d3;
    @Nullable
    private CompoundButton.OnCheckedChangeListener e3;
    @Nullable
    private MaterialCheckable.OnCheckedChangeListener<Chip> f3;
    private boolean g3;
    private boolean h3;
    private boolean i3;
    /* access modifiers changed from: private */
    public boolean j3;
    private boolean k3;
    private int l3;
    @Dimension(unit = 1)
    private int m3;
    @Nullable
    private CharSequence n3;
    @NonNull
    private final ChipTouchHelper o3;
    private boolean p3;
    private final Rect q3;
    private final RectF r3;
    private final TextAppearanceFontCallback s3;

    private class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int C(float f2, float f3) {
            return (!Chip.this.o() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        /* access modifiers changed from: protected */
        public void D(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.o() && Chip.this.y() && Chip.this.d3 != null) {
                list.add(1);
            }
        }

        /* access modifiers changed from: protected */
        public boolean N(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.A();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void Q(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.h1(Chip.this.s());
            accessibilityNodeInfoCompat.k1(Chip.this.isClickable());
            accessibilityNodeInfoCompat.j1(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.d2(text);
            } else {
                accessibilityNodeInfoCompat.o1(text);
            }
        }

        /* access modifiers changed from: protected */
        public void R(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R.string.Z0;
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    closeIconContentDescription = context.getString(i3, new Object[]{charSequence}).trim();
                }
                accessibilityNodeInfoCompat.o1(closeIconContentDescription);
                accessibilityNodeInfoCompat.d1(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6657j);
                accessibilityNodeInfoCompat.u1(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.o1(charSequence);
            accessibilityNodeInfoCompat.d1(Chip.x3);
        }

        /* access modifiers changed from: protected */
        public void S(int i2, boolean z) {
            if (i2 == 1) {
                boolean unused = Chip.this.j3 = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    private void B() {
        if (this.b3 != null) {
            this.b3 = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            F();
        }
    }

    private void D(@Nullable ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.l3((ChipDrawable.Delegate) null);
        }
    }

    private void E() {
        boolean z;
        if (!o() || !y() || this.d3 == null) {
            ViewCompat.H1(this, (AccessibilityDelegateCompat) null);
            z = false;
        } else {
            ViewCompat.H1(this, this.o3);
            z = true;
        }
        this.p3 = z;
    }

    private void F() {
        if (RippleUtils.f21729a) {
            G();
            return;
        }
        this.a3.K3(true);
        ViewCompat.P1(this, getBackgroundDrawable());
        H();
        n();
    }

    private void G() {
        this.c3 = new RippleDrawable(RippleUtils.e(this.a3.O1()), getBackgroundDrawable(), (Drawable) null);
        this.a3.K3(false);
        ViewCompat.P1(this, this.c3);
        H();
    }

    private void H() {
        ChipDrawable chipDrawable;
        if (!TextUtils.isEmpty(getText()) && (chipDrawable = this.a3) != null) {
            int q1 = (int) (chipDrawable.q1() + this.a3.S1() + this.a3.W0());
            int v1 = (int) (this.a3.v1() + this.a3.T1() + this.a3.S0());
            if (this.b3 != null) {
                Rect rect = new Rect();
                this.b3.getPadding(rect);
                v1 += rect.left;
                q1 += rect.right;
            }
            ViewCompat.n2(this, v1, getPaddingTop(), q1, getPaddingBottom());
        }
    }

    private void I() {
        TextPaint paint = getPaint();
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            paint.drawableState = chipDrawable.getState();
        }
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.s3);
        }
    }

    private void J(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue(A3, CSS.Property.f27458a) != null) {
                Log.w(t3, "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue(A3, "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(A3, "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(A3, "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue(A3, "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue(A3, "singleLine", true) || attributeSet.getAttributeIntValue(A3, "lines", 1) != 1 || attributeSet.getAttributeIntValue(A3, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(A3, "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue(A3, "gravity", 8388627) != 8388627) {
                Log.w(t3, "Chip text must be vertically center and start aligned");
            }
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.r3.setEmpty();
        if (o() && this.d3 != null) {
            this.a3.G1(this.r3);
        }
        return this.r3;
    }

    /* access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.q3.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.q3;
    }

    @Nullable
    private TextAppearance getTextAppearance() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.R1();
        }
        return null;
    }

    private void k(@NonNull ChipDrawable chipDrawable) {
        chipDrawable.l3(this);
    }

    @NonNull
    private int[] l() {
        int isEnabled = isEnabled();
        if (this.j3) {
            isEnabled++;
        }
        if (this.i3) {
            isEnabled++;
        }
        if (this.h3) {
            isEnabled++;
        }
        if (isChecked()) {
            isEnabled++;
        }
        int[] iArr = new int[isEnabled];
        int i2 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.j3) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.i3) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.h3) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void n() {
        if (getBackgroundDrawable() == this.b3 && this.a3.getCallback() == null) {
            this.a3.setCallback(this.b3);
        }
    }

    /* access modifiers changed from: private */
    public boolean o() {
        ChipDrawable chipDrawable = this.a3;
        return (chipDrawable == null || chipDrawable.z1() == null) ? false : true;
    }

    private void p(Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.s6, i2, u3, new int[0]);
        this.k3 = k2.getBoolean(R.styleable.Z6, false);
        this.m3 = (int) Math.ceil((double) k2.getDimension(R.styleable.N6, (float) Math.ceil((double) ViewUtils.i(getContext(), 48))));
        k2.recycle();
    }

    private void q() {
        setOutlineProvider(new ViewOutlineProvider() {
            @TargetApi(21)
            public void getOutline(View view, @NonNull Outline outline) {
                if (Chip.this.a3 != null) {
                    Chip.this.a3.getOutline(outline);
                } else {
                    outline.setAlpha(0.0f);
                }
            }
        });
    }

    private void r(int i2, int i4, int i5, int i6) {
        this.b3 = new InsetDrawable(this.a3, i2, i4, i5, i6);
    }

    private void setCloseIconHovered(boolean z) {
        if (this.i3 != z) {
            this.i3 = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.h3 != z) {
            this.h3 = z;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(CompoundButton compoundButton, boolean z) {
        MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener = this.f3;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.a(this, z);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.e3;
        if (onCheckedChangeListener2 != null) {
            onCheckedChangeListener2.onCheckedChanged(compoundButton, z);
        }
    }

    @CallSuper
    public boolean A() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.d3;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        if (this.p3) {
            this.o3.Y(1, 1);
        }
        return z;
    }

    public boolean C() {
        return this.k3;
    }

    public void a() {
        m(this.m3);
        requestLayout();
        invalidateOutline();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return !this.p3 ? super.dispatchHoverEvent(motionEvent) : this.o3.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.p3) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.o3.w(keyEvent) || this.o3.B() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable chipDrawable = this.a3;
        if ((chipDrawable == null || !chipDrawable.d2()) ? false : this.a3.g3(l())) {
            invalidate();
        }
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.n3)) {
            return this.n3;
        }
        if (!s()) {
            return isClickable() ? C3 : E3;
        }
        ViewParent parent = getParent();
        return (!(parent instanceof ChipGroup) || !((ChipGroup) parent).l()) ? C3 : D3;
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.b3;
        return insetDrawable == null ? this.a3 : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.m1();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.n1();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.o1();
        }
        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return Math.max(0.0f, chipDrawable.p1());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.a3;
    }

    public float getChipEndPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.q1();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.r1();
        }
        return null;
    }

    public float getChipIconSize() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.s1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.t1();
        }
        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.u1();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.v1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.w1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.x1();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.z1();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.A1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.B1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.C1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.D1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.F1();
        }
        return null;
    }

    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.J1();
        }
        return null;
    }

    public void getFocusedRect(@NonNull Rect rect) {
        if (!this.p3 || !(this.o3.B() == 1 || this.o3.x() == 1)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(getCloseIconTouchBoundsInt());
        }
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.K1();
        }
        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.L1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.M1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.O1();
        }
        return null;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.a3.getShapeAppearanceModel();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.P1();
        }
        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.S1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            return chipDrawable.T1();
        }
        return 0.0f;
    }

    public boolean m(@Dimension int i2) {
        this.m3 = i2;
        int i4 = 0;
        if (!C()) {
            if (this.b3 != null) {
                B();
            } else {
                F();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.a3.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.a3.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i5 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i4 = max / 2;
            }
            if (this.b3 != null) {
                Rect rect = new Rect();
                this.b3.getPadding(rect);
                if (rect.top == i4 && rect.bottom == i4 && rect.left == i5 && rect.right == i5) {
                    F();
                    return true;
                }
            }
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
            r(i5, i4, i5, i4);
            F();
            return true;
        }
        if (this.b3 != null) {
            B();
        } else {
            F();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.a3);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, y3);
        }
        if (s()) {
            View.mergeDrawableStates(onCreateDrawableState, z3);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.p3) {
            this.o3.M(z, i2, rect);
        }
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.i(this) : -1, 1, false, isChecked()));
        }
    }

    @TargetApi(24)
    @Nullable
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i2) {
        return (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) ? super.onResolvePointerIcon(motionEvent, i2) : PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.l3 != i2) {
            this.l3 = i2;
            H();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x002c
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0035
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.h3
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x002a
            r5.setCloseIconPressed(r3)
        L_0x002a:
            r0 = 1
            goto L_0x0041
        L_0x002c:
            boolean r0 = r5.h3
            if (r0 == 0) goto L_0x0035
            r5.A()
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            r5.setCloseIconPressed(r3)
            goto L_0x0041
        L_0x003a:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r2)
            goto L_0x002a
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x004b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean s() {
        ChipDrawable chipDrawable = this.a3;
        return chipDrawable != null && chipDrawable.X1();
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.n3 = charSequence;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c3) {
            super.setBackground(drawable);
        } else {
            Log.w(t3, "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i2) {
        Log.w(t3, "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c3) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w(t3, "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i2) {
        Log.w(t3, "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w(t3, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w(t3, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.m2(z);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.n2(i2);
        }
    }

    public void setChecked(boolean z) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable == null) {
            this.g3 = z;
        } else if (chipDrawable.X1()) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.o2(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.r2(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.s2(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.t2(i2);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.u2(i2);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.w2(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.x2(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.y2(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.z2(i2);
        }
    }

    public void setChipDrawable(@NonNull ChipDrawable chipDrawable) {
        ChipDrawable chipDrawable2 = this.a3;
        if (chipDrawable2 != chipDrawable) {
            D(chipDrawable2);
            this.a3 = chipDrawable;
            chipDrawable.w3(false);
            k(this.a3);
            m(this.m3);
        }
    }

    public void setChipEndPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.A2(f2);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.B2(i2);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.C2(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.F2(i2);
        }
    }

    public void setChipIconSize(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.G2(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.H2(i2);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.I2(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.J2(i2);
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.K2(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.M2(f2);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.N2(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.O2(f2);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.P2(i2);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.Q2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.R2(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.S2(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.T2(i2);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.V2(drawable);
        }
        E();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.W2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.Z2(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.a3(i2);
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.b3(i2);
        }
        E();
    }

    public void setCloseIconSize(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.c3(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.d3(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.e3(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.f3(i2);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.h3(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.i3(i2);
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i4, int i5, int i6) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i5 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i4, i5, i6);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i4, int i5, int i6) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i5 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i4, i5, i6);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.o0(f2);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.a3 != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ChipDrawable chipDrawable = this.a3;
                if (chipDrawable != null) {
                    chipDrawable.m3(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.k3 = z;
        m(this.m3);
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w(t3, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.n3(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.o3(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.p3(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.q3(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.r3(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.s3(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f3 = onCheckedChangeListener;
    }

    public void setLayoutDirection(int i2) {
        if (this.a3 != null) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.t3(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.e3 = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.d3 = onClickListener;
        E();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.u3(colorStateList);
        }
        if (!this.a3.V1()) {
            G();
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.v3(i2);
            if (!this.a3.V1()) {
                G();
            }
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.a3.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.x3(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.y3(i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(chipDrawable.L3() ? null : charSequence, bufferType);
            ChipDrawable chipDrawable2 = this.a3;
            if (chipDrawable2 != null) {
                chipDrawable2.z3(charSequence);
            }
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.B3(i2);
        }
        I();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.E3(f2);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.F3(i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.H3(TypedValue.applyDimension(i2, f2, getResources().getDisplayMetrics()));
        }
        I();
    }

    public void setTextStartPadding(float f2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.I3(f2);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.J3(i2);
        }
    }

    @Deprecated
    public boolean t() {
        return u();
    }

    public boolean u() {
        ChipDrawable chipDrawable = this.a3;
        return chipDrawable != null && chipDrawable.Z1();
    }

    @Deprecated
    public boolean v() {
        return w();
    }

    public boolean w() {
        ChipDrawable chipDrawable = this.a3;
        return chipDrawable != null && chipDrawable.b2();
    }

    @Deprecated
    public boolean x() {
        return y();
    }

    public boolean y() {
        ChipDrawable chipDrawable = this.a3;
        return chipDrawable != null && chipDrawable.e2();
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.I2);
    }

    public void setCheckedIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.v2(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.L2(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.k3(z);
        }
        E();
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.B3(i2);
        }
        I();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = u3
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.q3 = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.r3 = r8
            com.google.android.material.chip.Chip$1 r8 = new com.google.android.material.chip.Chip$1
            r8.<init>()
            r7.s3 = r8
            android.content.Context r8 = r7.getContext()
            r7.J(r9)
            com.google.android.material.chip.ChipDrawable r6 = com.google.android.material.chip.ChipDrawable.b1(r8, r9, r10, r4)
            r7.p(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.T(r7)
            r6.o0(r0)
            int[] r2 = com.google.android.material.R.styleable.s6
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L_0x0051
            int r10 = com.google.android.material.R.styleable.v6
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r8, r9, r10)
            r7.setTextColor(r8)
        L_0x0051:
            int r8 = com.google.android.material.R.styleable.e7
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$ChipTouchHelper r9 = new com.google.android.material.chip.Chip$ChipTouchHelper
            r9.<init>(r7)
            r7.o3 = r9
            r7.E()
            if (r8 != 0) goto L_0x0069
            r7.q()
        L_0x0069:
            boolean r8 = r7.g3
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.Q1()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.J1()
            r7.setEllipsize(r8)
            r7.I()
            com.google.android.material.chip.ChipDrawable r8 = r7.a3
            boolean r8 = r8.L3()
            if (r8 != 0) goto L_0x008e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L_0x008e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.H()
            boolean r8 = r7.C()
            if (r8 == 0) goto L_0x00a2
            int r8 = r7.m3
            r7.setMinHeight(r8)
        L_0x00a2:
            int r8 = androidx.core.view.ViewCompat.c0(r7)
            r7.l3 = r8
            com.google.android.material.chip.b r8 = new com.google.android.material.chip.b
            r8.<init>(r7)
            super.setOnCheckedChangeListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        ChipDrawable chipDrawable = this.a3;
        if (chipDrawable != null) {
            chipDrawable.A3(textAppearance);
        }
        I();
    }
}
