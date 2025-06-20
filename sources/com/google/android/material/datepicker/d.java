package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ View s;

    public /* synthetic */ d(View view) {
        this.s = view;
    }

    public final void run() {
        ViewUtils.z(this.s, false);
    }
}
