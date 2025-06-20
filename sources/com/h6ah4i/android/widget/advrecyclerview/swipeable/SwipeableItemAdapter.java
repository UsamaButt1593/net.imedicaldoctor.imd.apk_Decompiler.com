package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface SwipeableItemAdapter<T extends RecyclerView.ViewHolder> {
    int c(T t, int i2, int i3);

    void l(T t, int i2, int i3);

    int s(T t, int i2, int i3, int i4);

    void t(T t, int i2, int i3, int i4);
}
