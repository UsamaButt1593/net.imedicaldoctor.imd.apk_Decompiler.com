package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

public abstract class ItemRemoveAnimationManager extends BaseItemAnimationManager<RemoveAnimationInfo> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f25362e = "ARVItemRemoveAnimMgr";

    public ItemRemoveAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    /* renamed from: A */
    public void e(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25362e, "dispatchRemoveFinished(" + viewHolder + ")");
        }
        this.f25345a.dispatchRemoveFinished(viewHolder);
    }

    /* renamed from: B */
    public void g(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25362e, "dispatchRemoveStarting(" + viewHolder + ")");
        }
        this.f25345a.dispatchRemoveStarting(viewHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public boolean l(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = removeAnimationInfo.f25368a;
        if (viewHolder2 == null) {
            return false;
        }
        if (viewHolder != null && viewHolder2 != viewHolder) {
            return false;
        }
        s(removeAnimationInfo, viewHolder2);
        e(removeAnimationInfo, removeAnimationInfo.f25368a);
        removeAnimationInfo.a(removeAnimationInfo.f25368a);
        return true;
    }

    public long o() {
        return this.f25345a.p();
    }

    public void x(long j2) {
        this.f25345a.C(j2);
    }

    public abstract boolean z(RecyclerView.ViewHolder viewHolder);
}
