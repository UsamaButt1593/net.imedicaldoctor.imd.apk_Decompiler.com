package com.google.android.material.search;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class r implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f21776a;

    public /* synthetic */ r(SearchView searchView) {
        this.f21776a = searchView;
    }

    public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f21776a.N(view, windowInsetsCompat);
    }
}
