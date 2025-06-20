package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;

public class MaterialToolbar extends Toolbar {
    private static final int W3 = R.style.Ck;
    private static final ImageView.ScaleType[] X3 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    @Nullable
    private Integer R3;
    private boolean S3;
    private boolean T3;
    @Nullable
    private ImageView.ScaleType U3;
    @Nullable
    private Boolean V3;

    public MaterialToolbar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private Pair<Integer, Integer> a0(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i2 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || childAt == textView || childAt == textView2)) {
                if (childAt.getRight() < i2 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i2 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void c0(Context context) {
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : DrawableUtils.g(background);
        if (valueOf != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.p0(valueOf);
            materialShapeDrawable.a0(context);
            materialShapeDrawable.o0(ViewCompat.T(this));
            ViewCompat.P1(this, materialShapeDrawable);
        }
    }

    private void g0(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i2 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i3 = measuredWidth2 + i2;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i2, 0), Math.max(i3 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i2 += max;
            i3 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 - i2, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i2, view.getTop(), i3, view.getBottom());
    }

    private void h0() {
        if (this.S3 || this.T3) {
            TextView i2 = ToolbarUtils.i(this);
            TextView g2 = ToolbarUtils.g(this);
            if (i2 != null || g2 != null) {
                Pair<Integer, Integer> a0 = a0(i2, g2);
                if (this.S3 && i2 != null) {
                    g0(i2, a0);
                }
                if (this.T3 && g2 != null) {
                    g0(g2, a0);
                }
            }
        }
    }

    @Nullable
    private Drawable i0(@Nullable Drawable drawable) {
        if (drawable == null || this.R3 == null) {
            return drawable;
        }
        Drawable r = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(r, this.R3.intValue());
        return r;
    }

    private void j0() {
        ImageView d2 = ToolbarUtils.d(this);
        if (d2 != null) {
            Boolean bool = this.V3;
            if (bool != null) {
                d2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.U3;
            if (scaleType != null) {
                d2.setScaleType(scaleType);
            }
        }
    }

    public void b0() {
        this.R3 = null;
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            DrawableCompat.o(DrawableCompat.r(navigationIcon.mutate()), (ColorStateList) null);
            setNavigationIcon(navigationIcon);
        }
    }

    public boolean d0() {
        Boolean bool = this.V3;
        return bool != null && bool.booleanValue();
    }

    public boolean e0() {
        return this.T3;
    }

    public boolean f0() {
        return this.S3;
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.U3;
    }

    @ColorInt
    @Nullable
    public Integer getNavigationIconTint() {
        return this.R3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        h0();
        j0();
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.d(this, f2);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.V3;
        if (bool == null || bool.booleanValue() != z) {
            this.V3 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.U3 != scaleType) {
            this.U3 = scaleType;
            requestLayout();
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(i0(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.R3 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.T3 != z) {
            this.T3 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.S3 != z) {
            this.S3 = z;
            requestLayout();
        }
    }

    public void z(int i2) {
        Menu menu = getMenu();
        boolean z = menu instanceof MenuBuilder;
        if (z) {
            ((MenuBuilder) menu).n0();
        }
        super.z(i2);
        if (z) {
            ((MenuBuilder) menu).m0();
        }
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hk);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = W3
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.mo
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.po
            boolean r0 = r9.hasValue(r10)
            r1 = -1
            if (r0 == 0) goto L_0x0029
            int r10 = r9.getColor(r10, r1)
            r7.setNavigationIconTint(r10)
        L_0x0029:
            int r10 = com.google.android.material.R.styleable.ro
            boolean r10 = r9.getBoolean(r10, r6)
            r7.S3 = r10
            int r10 = com.google.android.material.R.styleable.qo
            boolean r10 = r9.getBoolean(r10, r6)
            r7.T3 = r10
            int r10 = com.google.android.material.R.styleable.oo
            int r10 = r9.getInt(r10, r1)
            if (r10 < 0) goto L_0x004a
            android.widget.ImageView$ScaleType[] r0 = X3
            int r1 = r0.length
            if (r10 >= r1) goto L_0x004a
            r10 = r0[r10]
            r7.U3 = r10
        L_0x004a:
            int r10 = com.google.android.material.R.styleable.no
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x005c
            boolean r10 = r9.getBoolean(r10, r6)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r7.V3 = r10
        L_0x005c:
            r9.recycle()
            r7.c0(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
