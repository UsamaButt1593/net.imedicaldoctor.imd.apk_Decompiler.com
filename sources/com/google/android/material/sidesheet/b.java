package com.google.android.material.sidesheet;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ SideSheetBehavior s;

    public /* synthetic */ b(SideSheetBehavior sideSheetBehavior, int i2) {
        this.s = sideSheetBehavior;
        this.X = i2;
    }

    public final void run() {
        this.s.M0(this.X);
    }
}
