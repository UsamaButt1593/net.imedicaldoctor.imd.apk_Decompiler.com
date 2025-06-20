package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText[] f21391a;

    public /* synthetic */ c(EditText[] editTextArr) {
        this.f21391a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z) {
        e.a(this.f21391a, view, z);
    }
}
