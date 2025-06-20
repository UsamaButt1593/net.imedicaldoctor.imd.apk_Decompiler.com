package com.h6ah4i.android.widget.advrecyclerview.draggable;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface DraggableItemAdapter<T extends RecyclerView.ViewHolder> {
    void h(int i2, int i3);

    boolean k(T t, int i2, int i3, int i4);

    ItemDraggableRange w(T t, int i2);
}
