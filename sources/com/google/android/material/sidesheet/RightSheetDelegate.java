package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class RightSheetDelegate extends SheetDelegate {

    /* renamed from: a  reason: collision with root package name */
    final SideSheetBehavior<? extends View> f21919a;

    RightSheetDelegate(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f21919a = sideSheetBehavior;
    }

    /* access modifiers changed from: package-private */
    public int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* access modifiers changed from: package-private */
    public float b(int i2) {
        float e2 = (float) e();
        return (e2 - ((float) i2)) / (e2 - ((float) d()));
    }

    /* access modifiers changed from: package-private */
    public int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return Math.max(0, (e() - this.f21919a.m0()) - this.f21919a.t0());
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f21919a.x0();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f21919a.x0();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return d();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int h(@NonNull V v) {
        return v.getLeft() - this.f21919a.t0();
    }

    public int i(@NonNull CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean k(float f2) {
        return f2 < 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean l(@NonNull View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    /* access modifiers changed from: package-private */
    public boolean m(float f2, float f3) {
        return SheetUtils.a(f2, f3) && Math.abs(f2) > ((float) this.f21919a.y0());
    }

    /* access modifiers changed from: package-private */
    public boolean n(@NonNull View view, float f2) {
        return Math.abs(((float) view.getRight()) + (f2 * this.f21919a.r0())) > this.f21919a.s0();
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.rightMargin = i2;
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        int x0 = this.f21919a.x0();
        if (i2 <= x0) {
            marginLayoutParams.rightMargin = x0 - i2;
        }
    }
}
