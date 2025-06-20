package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect X2 = new Rect();
    private int Y2 = 0;
    final Rect Z = new Rect();
    private int Z2;

    public HeaderScrollingViewBehavior() {
    }

    private static int c0(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void R(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        int i3;
        View W = W(coordinatorLayout.w(view));
        if (W != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.Z;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, W.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + W.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.W(coordinatorLayout) && !ViewCompat.W(view)) {
                rect.left += lastWindowInsets.p();
                rect.right -= lastWindowInsets.q();
            }
            Rect rect2 = this.X2;
            GravityCompat.b(c0(layoutParams.f5079c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int X = X(W);
            view.layout(rect2.left, rect2.top - X, rect2.right, rect2.bottom - X);
            i3 = rect2.top - W.getBottom();
        } else {
            super.R(coordinatorLayout, view, i2);
            i3 = 0;
        }
        this.Y2 = i3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract View W(List<View> list);

    /* access modifiers changed from: package-private */
    public final int X(View view) {
        if (this.Z2 == 0) {
            return 0;
        }
        float Y = Y(view);
        int i2 = this.Z2;
        return MathUtils.e((int) (Y * ((float) i2)), 0, i2);
    }

    /* access modifiers changed from: package-private */
    public float Y(View view) {
        return 1.0f;
    }

    public final int Z() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public int a0(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int b0() {
        return this.Y2;
    }

    public final void d0(int i2) {
        this.Z2 = i2;
    }

    /* access modifiers changed from: protected */
    public boolean e0() {
        return false;
    }

    public boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        View W;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (W = W(coordinatorLayout.w(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.W(W) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.r() + lastWindowInsets.o();
        }
        int a0 = size + a0(W);
        int measuredHeight = W.getMeasuredHeight();
        if (e0()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            view.setTranslationY(0.0f);
            a0 -= measuredHeight;
        }
        coordinatorLayout.O(view, i2, i3, View.MeasureSpec.makeMeasureSpec(a0, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
