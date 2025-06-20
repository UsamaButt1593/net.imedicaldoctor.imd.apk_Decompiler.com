package com.google.android.material.sidesheet;

import com.google.android.material.sidesheet.SideSheetBehavior;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ SideSheetBehavior.StateSettlingTracker s;

    public /* synthetic */ e(SideSheetBehavior.StateSettlingTracker stateSettlingTracker) {
        this.s = stateSettlingTracker;
    }

    public final void run() {
        this.s.c();
    }
}
