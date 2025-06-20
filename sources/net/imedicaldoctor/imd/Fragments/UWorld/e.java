package net.imedicaldoctor.imd.Fragments.UWorld;

import android.view.View;

public final /* synthetic */ class e implements View.OnClickListener {
    public final /* synthetic */ TreeItem X;
    public final /* synthetic */ TreeViewAdapter s;

    public /* synthetic */ e(TreeViewAdapter treeViewAdapter, TreeItem treeItem) {
        this.s = treeViewAdapter;
        this.X = treeItem;
    }

    public final void onClick(View view) {
        this.s.m0(this.X, view);
    }
}
