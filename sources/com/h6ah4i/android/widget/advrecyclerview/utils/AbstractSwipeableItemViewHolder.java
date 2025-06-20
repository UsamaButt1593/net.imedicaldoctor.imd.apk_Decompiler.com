package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

public abstract class AbstractSwipeableItemViewHolder extends RecyclerView.ViewHolder implements SwipeableItemViewHolder {
    private int I;
    private int J = 0;
    private int K = 0;
    private float L;
    private float M = -3.4028235E38f;
    private float N = Float.MAX_VALUE;

    public AbstractSwipeableItemViewHolder(View view) {
        super(view);
    }

    public int a() {
        return this.J;
    }

    public float b() {
        return this.N;
    }

    public void c(int i2) {
        this.I = i2;
    }

    public int f() {
        return this.K;
    }

    public void g(float f2) {
        this.L = f2;
    }

    public void h(int i2) {
        this.J = i2;
    }

    public void j(float f2) {
        this.M = f2;
    }

    public float k() {
        return this.L;
    }

    public void l(float f2) {
        this.N = f2;
    }

    public float n() {
        return this.M;
    }

    public void o(int i2) {
        this.K = i2;
    }

    public int p() {
        return this.I;
    }
}
