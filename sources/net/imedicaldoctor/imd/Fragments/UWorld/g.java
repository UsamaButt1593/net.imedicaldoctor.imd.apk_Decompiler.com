package net.imedicaldoctor.imd.Fragments.UWorld;

import android.view.View;

public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ TreeItem X;
    public final /* synthetic */ TreeViewAdapter s;

    public /* synthetic */ g(TreeViewAdapter treeViewAdapter, TreeItem treeItem) {
        this.s = treeViewAdapter;
        this.X = treeItem;
    }

    public final void onClick(View view) {
        this.s.o0(this.X, view);
    }
}
