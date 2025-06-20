package net.imedicaldoctor.imd.CollapsingToolbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f29531a;

    /* renamed from: b  reason: collision with root package name */
    private int f29532b;

    /* renamed from: c  reason: collision with root package name */
    private int f29533c;

    /* renamed from: d  reason: collision with root package name */
    private int f29534d;

    /* renamed from: e  reason: collision with root package name */
    private int f29535e;

    public ViewOffsetHelper(View view) {
        this.f29531a = view;
    }

    private void h() {
        View view = this.f29531a;
        ViewCompat.j1(view, this.f29534d - (view.getTop() - this.f29532b));
        View view2 = this.f29531a;
        ViewCompat.i1(view2, this.f29535e - (view2.getLeft() - this.f29533c));
    }

    public int a() {
        return this.f29533c;
    }

    public int b() {
        return this.f29532b;
    }

    public int c() {
        return this.f29535e;
    }

    public int d() {
        return this.f29534d;
    }

    public void e() {
        this.f29532b = this.f29531a.getTop();
        this.f29533c = this.f29531a.getLeft();
        h();
    }

    public boolean f(int i2) {
        if (this.f29535e == i2) {
            return false;
        }
        this.f29535e = i2;
        h();
        return true;
    }

    public boolean g(int i2) {
        if (this.f29534d == i2) {
            return false;
        }
        this.f29534d = i2;
        h();
        return true;
    }
}
