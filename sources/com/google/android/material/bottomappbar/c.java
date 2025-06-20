package com.google.android.material.bottomappbar;

import android.view.View;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ View s;

    public /* synthetic */ c(View view) {
        this.s = view;
    }

    public final void run() {
        this.s.requestLayout();
    }
}
