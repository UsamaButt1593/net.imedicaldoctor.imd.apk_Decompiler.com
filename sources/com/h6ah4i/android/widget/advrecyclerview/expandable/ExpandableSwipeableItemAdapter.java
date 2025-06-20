package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface ExpandableSwipeableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    int a(CVH cvh, int i2, int i3, int i4, int i5);

    void b(CVH cvh, int i2, int i3, int i4, int i5);

    int c(CVH cvh, int i2, int i3, int i4);

    void d(GVH gvh, int i2, int i3);

    void e(GVH gvh, int i2, int i3, int i4);

    void f(CVH cvh, int i2, int i3, int i4);

    int g(GVH gvh, int i2, int i3);

    int h(GVH gvh, int i2, int i3, int i4);
}
