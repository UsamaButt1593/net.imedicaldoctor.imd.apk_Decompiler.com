package com.timehop.stickyheadersrecyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface StickyRecyclerHeadersAdapter<VH extends RecyclerView.ViewHolder> {
    int b();

    VH o(ViewGroup viewGroup);

    void p(VH vh, int i2);

    long r(int i2);
}
