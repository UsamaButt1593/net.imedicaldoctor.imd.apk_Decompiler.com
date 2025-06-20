package net.imedicaldoctor.imd.Fragments.UWorld;

import android.view.View;
import java.util.Set;

public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ Set X;
    public final /* synthetic */ CheckDialog s;

    public /* synthetic */ b(CheckDialog checkDialog, Set set) {
        this.s = checkDialog;
        this.X = set;
    }

    public final void onClick(View view) {
        this.s.m3(this.X, view);
    }
}
