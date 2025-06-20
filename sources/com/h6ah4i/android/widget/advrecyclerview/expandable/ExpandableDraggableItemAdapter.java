package com.h6ah4i.android.widget.advrecyclerview.expandable;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;

public interface ExpandableDraggableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    boolean a(GVH gvh, int i2, int i3, int i4);

    ItemDraggableRange b(GVH gvh, int i2);

    void c(int i2, int i3, int i4, int i5);

    void d(int i2, int i3);

    boolean e(CVH cvh, int i2, int i3, int i4, int i5);

    ItemDraggableRange f(CVH cvh, int i2, int i3);
}
