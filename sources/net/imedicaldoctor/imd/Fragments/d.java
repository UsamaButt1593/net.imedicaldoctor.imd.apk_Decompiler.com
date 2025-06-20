package net.imedicaldoctor.imd.Fragments;

import net.imedicaldoctor.imd.Fragments.activationActivity;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ activationActivity.activationFragment s;

    public /* synthetic */ d(activationActivity.activationFragment activationfragment, String str) {
        this.s = activationfragment;
        this.X = str;
    }

    public final void run() {
        this.s.o3(this.X);
    }
}
