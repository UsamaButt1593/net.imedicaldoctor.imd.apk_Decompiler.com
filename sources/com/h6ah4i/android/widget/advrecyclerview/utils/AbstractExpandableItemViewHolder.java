package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;

public abstract class AbstractExpandableItemViewHolder extends RecyclerView.ViewHolder implements ExpandableItemViewHolder {
    private int I;

    public AbstractExpandableItemViewHolder(View view) {
        super(view);
    }

    public void m(int i2) {
        this.I = i2;
    }

    public int q() {
        return this.I;
    }
}
