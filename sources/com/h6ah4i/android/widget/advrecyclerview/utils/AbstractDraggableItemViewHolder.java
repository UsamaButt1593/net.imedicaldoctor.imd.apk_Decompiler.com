package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;

public abstract class AbstractDraggableItemViewHolder extends RecyclerView.ViewHolder implements DraggableItemViewHolder {
    private int I;

    public AbstractDraggableItemViewHolder(View view) {
        super(view);
    }

    public int d() {
        return this.I;
    }

    public void i(int i2) {
        this.I = i2;
    }
}
