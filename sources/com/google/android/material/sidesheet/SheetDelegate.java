package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class SheetDelegate {
    SheetDelegate() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract float b(int i2);

    /* access modifiers changed from: package-private */
    public abstract int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract int f();

    /* access modifiers changed from: package-private */
    public abstract int g();

    /* access modifiers changed from: package-private */
    public abstract <V extends View> int h(@NonNull V v);

    /* access modifiers changed from: package-private */
    public abstract int i(@NonNull CoordinatorLayout coordinatorLayout);

    /* access modifiers changed from: package-private */
    public abstract int j();

    /* access modifiers changed from: package-private */
    public abstract boolean k(float f2);

    /* access modifiers changed from: package-private */
    public abstract boolean l(@NonNull View view);

    /* access modifiers changed from: package-private */
    public abstract boolean m(float f2, float f3);

    /* access modifiers changed from: package-private */
    public abstract boolean n(@NonNull View view, float f2);

    /* access modifiers changed from: package-private */
    public abstract void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2);

    /* access modifiers changed from: package-private */
    public abstract void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3);
}
