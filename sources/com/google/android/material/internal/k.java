package com.google.android.material.internal;

import android.view.View;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ View s;

    public /* synthetic */ k(View view, boolean z) {
        this.s = view;
        this.X = z;
    }

    public final void run() {
        ViewUtils.C(this.s, this.X);
    }
}
