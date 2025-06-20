package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int X = 0;
    private int Y = 0;
    private ViewOffsetHelper s;

    public ViewOffsetBehavior() {
    }

    public int N() {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.d();
        }
        return 0;
    }

    public int O() {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.e();
        }
        return 0;
    }

    public boolean P() {
        ViewOffsetHelper viewOffsetHelper = this.s;
        return viewOffsetHelper != null && viewOffsetHelper.f();
    }

    public boolean Q() {
        ViewOffsetHelper viewOffsetHelper = this.s;
        return viewOffsetHelper != null && viewOffsetHelper.g();
    }

    /* access modifiers changed from: protected */
    public void R(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        coordinatorLayout.N(v, i2);
    }

    public void S(boolean z) {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.i(z);
        }
    }

    public boolean T(int i2) {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.j(i2);
        }
        this.Y = i2;
        return false;
    }

    public boolean U(int i2) {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.k(i2);
        }
        this.X = i2;
        return false;
    }

    public void V(boolean z) {
        ViewOffsetHelper viewOffsetHelper = this.s;
        if (viewOffsetHelper != null) {
            viewOffsetHelper.l(z);
        }
    }

    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        R(coordinatorLayout, v, i2);
        if (this.s == null) {
            this.s = new ViewOffsetHelper(v);
        }
        this.s.h();
        this.s.a();
        int i3 = this.X;
        if (i3 != 0) {
            this.s.k(i3);
            this.X = 0;
        }
        int i4 = this.Y;
        if (i4 == 0) {
            return true;
        }
        this.s.j(i4);
        this.Y = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
