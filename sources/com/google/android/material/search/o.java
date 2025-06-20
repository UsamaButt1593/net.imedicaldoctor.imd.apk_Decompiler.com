package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class o implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f21772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f21774c;

    public /* synthetic */ o(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        this.f21772a = marginLayoutParams;
        this.f21773b = i2;
        this.f21774c = i3;
    }

    public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.L(this.f21772a, this.f21773b, this.f21774c, view, windowInsetsCompat);
    }
}
