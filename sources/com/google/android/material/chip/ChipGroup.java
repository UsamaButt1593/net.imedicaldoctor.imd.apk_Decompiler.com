package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import java.util.List;

public class ChipGroup extends FlowLayout {
    private static final int g3 = R.style.Ui;
    @Dimension
    private int a3;
    @Dimension
    private int b3;
    /* access modifiers changed from: private */
    @Nullable
    public OnCheckedStateChangeListener c3;
    /* access modifiers changed from: private */
    public final CheckableGroup<Chip> d3;
    private final int e3;
    @NonNull
    private final PassThroughHierarchyChangeListener f3;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Deprecated
    public interface OnCheckedChangeListener {
        void a(@NonNull ChipGroup chipGroup, @IdRes int i2);
    }

    public interface OnCheckedStateChangeListener {
        void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list);
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */
        public ViewGroup.OnHierarchyChangeListener s;

        private PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.D());
                }
                ChipGroup.this.d3.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.d3.o((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getVisibleChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof Chip) && j(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private boolean j(int i2) {
        return getChildAt(i2).getVisibility() == 0;
    }

    public boolean c() {
        return super.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void g(@IdRes int i2) {
        this.d3.f(i2);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.d3.k();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.d3.j(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.a3;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.b3;
    }

    public void h() {
        this.d3.h();
    }

    /* access modifiers changed from: package-private */
    public int i(@Nullable View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof Chip) && j(i3)) {
                if (((Chip) childAt) == view) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public boolean k() {
        return this.d3.l();
    }

    public boolean l() {
        return this.d3.m();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.e3;
        if (i2 != -1) {
            this.d3.f(i2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(getRowCount(), c() ? getVisibleChipCount() : -1, false, l() ? 1 : 2));
    }

    public void setChipSpacing(@Dimension int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(@Dimension int i2) {
        if (this.a3 != i2) {
            this.a3 = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(@DimenRes int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(@Dimension int i2) {
        if (this.b3 != i2) {
            this.b3 = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable final OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            setOnCheckedStateChangeListener((OnCheckedStateChangeListener) null);
        } else {
            setOnCheckedStateChangeListener(new OnCheckedStateChangeListener() {
                public void a(@NonNull ChipGroup chipGroup, @NonNull List<Integer> list) {
                    if (ChipGroup.this.d3.m()) {
                        onCheckedChangeListener.a(chipGroup, ChipGroup.this.getCheckedChipId());
                    }
                }
            });
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.c3 = onCheckedStateChangeListener;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f3.s = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.d3.q(z);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@BoolRes int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.t2);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        this.d3.r(z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChipGroup(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = g3
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            com.google.android.material.internal.CheckableGroup r9 = new com.google.android.material.internal.CheckableGroup
            r9.<init>()
            r8.d3 = r9
            com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener r6 = new com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener
            r0 = 0
            r6.<init>()
            r8.f3 = r6
            android.content.Context r0 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.j7
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.l7
            int r11 = r10.getDimensionPixelOffset(r11, r7)
            int r0 = com.google.android.material.R.styleable.m7
            int r0 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.n7
            int r11 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingVertical(r11)
            int r11 = com.google.android.material.R.styleable.p7
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleLine((boolean) r11)
            int r11 = com.google.android.material.R.styleable.q7
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleSelection((boolean) r11)
            int r11 = com.google.android.material.R.styleable.o7
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSelectionRequired(r11)
            int r11 = com.google.android.material.R.styleable.k7
            r0 = -1
            int r11 = r10.getResourceId(r11, r0)
            r8.e3 = r11
            r10.recycle()
            com.google.android.material.chip.ChipGroup$1 r10 = new com.google.android.material.chip.ChipGroup$1
            r10.<init>()
            r9.p(r10)
            super.setOnHierarchyChangeListener(r6)
            r9 = 1
            androidx.core.view.ViewCompat.Z1(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
