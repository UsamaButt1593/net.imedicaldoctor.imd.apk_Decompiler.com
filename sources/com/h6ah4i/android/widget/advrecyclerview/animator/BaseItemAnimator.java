package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: l  reason: collision with root package name */
    private ItemAnimatorListener f25340l;

    public interface ItemAnimatorListener {
        void a(RecyclerView.ViewHolder viewHolder);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder);

        void d(RecyclerView.ViewHolder viewHolder);
    }

    public boolean D() {
        return false;
    }

    public boolean E() {
        if (q()) {
            return false;
        }
        j();
        return true;
    }

    public final void F(RecyclerView.ViewHolder viewHolder) {
        G(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f25340l;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.d(viewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void G(RecyclerView.ViewHolder viewHolder) {
    }

    public final void H(RecyclerView.ViewHolder viewHolder) {
        I(viewHolder);
    }

    /* access modifiers changed from: protected */
    public void I(RecyclerView.ViewHolder viewHolder) {
    }

    public final void J(RecyclerView.ViewHolder viewHolder, boolean z) {
        K(viewHolder, z);
        ItemAnimatorListener itemAnimatorListener = this.f25340l;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.a(viewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void K(RecyclerView.ViewHolder viewHolder, boolean z) {
    }

    public final void L(RecyclerView.ViewHolder viewHolder, boolean z) {
        M(viewHolder, z);
    }

    /* access modifiers changed from: protected */
    public void M(RecyclerView.ViewHolder viewHolder, boolean z) {
    }

    public final void N(RecyclerView.ViewHolder viewHolder) {
        O(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f25340l;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.b(viewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void O(RecyclerView.ViewHolder viewHolder) {
    }

    public final void P(RecyclerView.ViewHolder viewHolder) {
        Q(viewHolder);
    }

    /* access modifiers changed from: protected */
    public void Q(RecyclerView.ViewHolder viewHolder) {
    }

    public final void R(RecyclerView.ViewHolder viewHolder) {
        S(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f25340l;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.c(viewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void S(RecyclerView.ViewHolder viewHolder) {
    }

    public final void T(RecyclerView.ViewHolder viewHolder) {
        U(viewHolder);
    }

    /* access modifiers changed from: protected */
    public void U(RecyclerView.ViewHolder viewHolder) {
    }

    public void V(ItemAnimatorListener itemAnimatorListener) {
        this.f25340l = itemAnimatorListener;
    }
}
