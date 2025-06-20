package com.timehop.stickyheadersrecyclerview.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinearLayoutOrientationProvider implements OrientationProvider {
    private void c(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
        }
    }

    public int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).Q2();
    }

    public boolean b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).S2();
    }
}
