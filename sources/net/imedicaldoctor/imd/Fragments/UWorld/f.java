package net.imedicaldoctor.imd.Fragments.UWorld;

import android.view.View;

public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ TreeItem X;
    public final /* synthetic */ TreeViewAdapter s;

    public /* synthetic */ f(TreeViewAdapter treeViewAdapter, TreeItem treeItem) {
        this.s = treeViewAdapter;
        this.X = treeItem;
    }

    public final void onClick(View view) {
        this.s.n0(this.X, view);
    }
}
