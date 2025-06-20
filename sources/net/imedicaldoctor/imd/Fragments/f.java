package net.imedicaldoctor.imd.Fragments;

import net.imedicaldoctor.imd.Fragments.activationActivity;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ activationActivity.activationFragment.ResultWrapper X;
    public final /* synthetic */ activationActivity.activationFragment s;

    public /* synthetic */ f(activationActivity.activationFragment activationfragment, activationActivity.activationFragment.ResultWrapper resultWrapper) {
        this.s = activationfragment;
        this.X = resultWrapper;
    }

    public final void run() {
        this.s.n3(this.X);
    }
}
