package com.google.android.material.snackbar;

import android.view.View;

public final /* synthetic */ class c implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener X;
    public final /* synthetic */ Snackbar s;

    public /* synthetic */ c(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.s = snackbar;
        this.X = onClickListener;
    }

    public final void onClick(View view) {
        this.s.B0(this.X, view);
    }
}
