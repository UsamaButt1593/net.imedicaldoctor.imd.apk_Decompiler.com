package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f22063a;

    public /* synthetic */ b(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f22063a = clearTextEndIconDelegate;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f22063a.H(view, z);
    }
}
