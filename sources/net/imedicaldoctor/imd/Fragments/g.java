package net.imedicaldoctor.imd.Fragments;

import android.content.Context;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ activationActivity.activationFragment.ResultWrapper X;
    public final /* synthetic */ Context Y;
    public final /* synthetic */ activationActivity.activationFragment s;

    public /* synthetic */ g(activationActivity.activationFragment activationfragment, activationActivity.activationFragment.ResultWrapper resultWrapper, Context context) {
        this.s = activationfragment;
        this.X = resultWrapper;
        this.Y = context;
    }

    public final void run() {
        this.s.onCommandResult(this.X, this.Y);
    }
}
