package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

public abstract class AbstractDraggableSwipeableItemViewHolder extends RecyclerView.ViewHolder implements DraggableItemViewHolder, SwipeableItemViewHolder {
    private int I;
    private int J;
    private int K = 0;
    private int L = 0;
    private float M;
    private float N = -3.4028235E38f;
    private float O = Float.MAX_VALUE;

    public AbstractDraggableSwipeableItemViewHolder(View view) {
        super(view);
    }

    public int a() {
        return this.K;
    }

    public float b() {
        return this.O;
    }

    public void c(int i2) {
        this.J = i2;
    }

    public int d() {
        return this.I;
    }

    public int f() {
        return this.L;
    }

    public void g(float f2) {
        this.M = f2;
    }

    public void h(int i2) {
        this.K = i2;
    }

    public void i(int i2) {
        this.I = i2;
    }

    public void j(float f2) {
        this.N = f2;
    }

    public float k() {
        return this.M;
    }

    public void l(float f2) {
        this.O = f2;
    }

    public float n() {
        return this.N;
    }

    public void o(int i2) {
        this.L = i2;
    }

    public int p() {
        return this.J;
    }
}
