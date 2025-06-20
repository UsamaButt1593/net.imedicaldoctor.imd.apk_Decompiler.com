package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface ExpandableItemAdapter<GVH extends RecyclerView.ViewHolder, CVH extends RecyclerView.ViewHolder> {
    void e(GVH gvh, int i2, int i3);

    CVH f(ViewGroup viewGroup, int i2);

    int g(int i2);

    long getChildId(int i2, int i3);

    int getGroupCount();

    long getGroupId(int i2);

    int i(int i2, int i3);

    void j(CVH cvh, int i2, int i3, int i4);

    int m(int i2);

    boolean n(int i2, boolean z);

    GVH q(ViewGroup viewGroup, int i2);

    boolean u(int i2, boolean z);

    boolean v(GVH gvh, int i2, int i3, int i4, boolean z);
}
