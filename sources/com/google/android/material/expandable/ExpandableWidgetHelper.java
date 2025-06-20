package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f21419a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21420b = false;
    @IdRes

    /* renamed from: c  reason: collision with root package name */
    private int f21421c = 0;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.f21419a = (View) expandableWidget;
    }

    private void a() {
        ViewParent parent = this.f21419a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).k(this.f21419a);
        }
    }

    @IdRes
    public int b() {
        return this.f21421c;
    }

    public boolean c() {
        return this.f21420b;
    }

    public void d(@NonNull Bundle bundle) {
        this.f21420b = bundle.getBoolean("expanded", false);
        this.f21421c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f21420b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f21420b);
        bundle.putInt("expandedComponentIdHint", this.f21421c);
        return bundle;
    }

    public boolean f(boolean z) {
        if (this.f21420b == z) {
            return false;
        }
        this.f21420b = z;
        a();
        return true;
    }

    public void g(@IdRes int i2) {
        this.f21421c = i2;
    }
}
