package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class LeftSheetDelegate extends SheetDelegate {

    /* renamed from: a  reason: collision with root package name */
    final SideSheetBehavior<? extends View> f21918a;

    LeftSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f21918a = sideSheetBehavior;
    }

    /* access modifiers changed from: package-private */
    public int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* access modifiers changed from: package-private */
    public float b(int i2) {
        float e2 = (float) e();
        return (((float) i2) - e2) / (((float) d()) - e2);
    }

    /* access modifiers changed from: package-private */
    public int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return Math.max(0, this.f21918a.w0() + this.f21918a.t0());
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return (-this.f21918a.m0()) - this.f21918a.t0();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f21918a.t0();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return -this.f21918a.m0();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int h(@NonNull V v) {
        return v.getRight() + this.f21918a.t0();
    }

    public int i(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public boolean k(float f2) {
        return f2 > 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean l(@NonNull View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    /* access modifiers changed from: package-private */
    public boolean m(float f2, float f3) {
        return SheetUtils.a(f2, f3) && Math.abs(f2) > ((float) this.f21918a.y0());
    }

    /* access modifiers changed from: package-private */
    public boolean n(@NonNull View view, float f2) {
        return Math.abs(((float) view.getLeft()) + (f2 * this.f21918a.r0())) > this.f21918a.s0();
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.leftMargin = i2;
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        if (i2 <= this.f21918a.x0()) {
            marginLayoutParams.leftMargin = i3;
        }
    }
}
