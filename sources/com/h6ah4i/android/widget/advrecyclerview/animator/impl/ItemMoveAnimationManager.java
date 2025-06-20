package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

public abstract class ItemMoveAnimationManager extends BaseItemAnimationManager<MoveAnimationInfo> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f25361e = "ARVItemMoveAnimMgr";

    public ItemMoveAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    /* renamed from: A */
    public void e(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25361e, "dispatchMoveFinished(" + viewHolder + ")");
        }
        this.f25345a.dispatchMoveFinished(viewHolder);
    }

    /* renamed from: B */
    public void g(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25361e, "dispatchMoveStarting(" + viewHolder + ")");
        }
        this.f25345a.dispatchMoveStarting(viewHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public boolean l(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = moveAnimationInfo.f25363a;
        if (viewHolder2 == null) {
            return false;
        }
        if (viewHolder != null && viewHolder2 != viewHolder) {
            return false;
        }
        s(moveAnimationInfo, viewHolder2);
        e(moveAnimationInfo, moveAnimationInfo.f25363a);
        moveAnimationInfo.a(moveAnimationInfo.f25363a);
        return true;
    }

    public long o() {
        return this.f25345a.o();
    }

    public void x(long j2) {
        this.f25345a.B(j2);
    }

    public abstract boolean z(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5);
}
