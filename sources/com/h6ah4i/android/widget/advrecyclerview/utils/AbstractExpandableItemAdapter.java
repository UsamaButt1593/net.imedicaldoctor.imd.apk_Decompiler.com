package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter;

public abstract class AbstractExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ExpandableItemAdapter<GVH, CVH> {
    public final long B(int i2) {
        return -1;
    }

    public final int C(int i2) {
        return 0;
    }

    public final void R(RecyclerView.ViewHolder viewHolder, int i2) {
    }

    public final RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        return null;
    }

    public final int b() {
        return 0;
    }

    public boolean n(int i2, boolean z) {
        return true;
    }

    public boolean u(int i2, boolean z) {
        return true;
    }
}
