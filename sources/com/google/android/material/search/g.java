package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ SearchBar X;
    public final /* synthetic */ boolean X2;
    public final /* synthetic */ View Y;
    public final /* synthetic */ AppBarLayout Z;
    public final /* synthetic */ SearchBarAnimationHelper s;

    public /* synthetic */ g(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        this.s = searchBarAnimationHelper;
        this.X = searchBar;
        this.Y = view;
        this.Z = appBarLayout;
        this.X2 = z;
    }

    public final void run() {
        this.s.C(this.X, this.Y, this.Z, this.X2);
    }
}
