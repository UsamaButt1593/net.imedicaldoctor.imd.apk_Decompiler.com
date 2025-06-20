package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import net.imedicaldoctor.imd.Fragments.activationActivity;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Context X;
    public final /* synthetic */ activationActivity.activationFragment s;

    public /* synthetic */ e(activationActivity.activationFragment activationfragment, Context context) {
        this.s = activationfragment;
        this.X = context;
    }

    public final void run() {
        this.s.k3(this.X);
    }
}
