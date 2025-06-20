package com.google.android.material.search;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class q implements ViewUtils.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f21775a;

    public /* synthetic */ q(SearchView searchView) {
        this.f21775a = searchView;
    }

    public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return this.f21775a.O(view, windowInsetsCompat, relativePadding);
    }
}
