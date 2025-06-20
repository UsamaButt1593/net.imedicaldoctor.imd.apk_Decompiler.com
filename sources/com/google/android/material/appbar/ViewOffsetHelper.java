package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f20819a;

    /* renamed from: b  reason: collision with root package name */
    private int f20820b;

    /* renamed from: c  reason: collision with root package name */
    private int f20821c;

    /* renamed from: d  reason: collision with root package name */
    private int f20822d;

    /* renamed from: e  reason: collision with root package name */
    private int f20823e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20824f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20825g = true;

    public ViewOffsetHelper(View view) {
        this.f20819a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f20819a;
        ViewCompat.j1(view, this.f20822d - (view.getTop() - this.f20820b));
        View view2 = this.f20819a;
        ViewCompat.i1(view2, this.f20823e - (view2.getLeft() - this.f20821c));
    }

    public int b() {
        return this.f20821c;
    }

    public int c() {
        return this.f20820b;
    }

    public int d() {
        return this.f20823e;
    }

    public int e() {
        return this.f20822d;
    }

    public boolean f() {
        return this.f20825g;
    }

    public boolean g() {
        return this.f20824f;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f20820b = this.f20819a.getTop();
        this.f20821c = this.f20819a.getLeft();
    }

    public void i(boolean z) {
        this.f20825g = z;
    }

    public boolean j(int i2) {
        if (!this.f20825g || this.f20823e == i2) {
            return false;
        }
        this.f20823e = i2;
        a();
        return true;
    }

    public boolean k(int i2) {
        if (!this.f20824f || this.f20822d == i2) {
            return false;
        }
        this.f20822d = i2;
        a();
        return true;
    }

    public void l(boolean z) {
        this.f20824f = z;
    }
}
