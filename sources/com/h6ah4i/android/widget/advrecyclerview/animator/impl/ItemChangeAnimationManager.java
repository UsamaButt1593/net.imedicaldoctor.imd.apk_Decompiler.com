package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

public abstract class ItemChangeAnimationManager extends BaseItemAnimationManager<ChangeAnimationInfo> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f25360e = "ARVItemChangeAnimMgr";

    public ItemChangeAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    /* renamed from: A */
    public void e(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25360e, "dispatchChangeFinished(" + viewHolder + ")");
        }
        this.f25345a.dispatchChangeFinished(viewHolder, viewHolder == changeAnimationInfo.f25354b);
    }

    /* renamed from: B */
    public void g(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25360e, "dispatchChangeStarting(" + viewHolder + ")");
        }
        this.f25345a.dispatchChangeStarting(viewHolder, viewHolder == changeAnimationInfo.f25354b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public boolean l(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = changeAnimationInfo.f25354b;
        if (viewHolder2 != null && (viewHolder == null || viewHolder2 == viewHolder)) {
            s(changeAnimationInfo, viewHolder2);
            e(changeAnimationInfo, changeAnimationInfo.f25354b);
            changeAnimationInfo.a(changeAnimationInfo.f25354b);
        }
        RecyclerView.ViewHolder viewHolder3 = changeAnimationInfo.f25353a;
        if (viewHolder3 != null && (viewHolder == null || viewHolder3 == viewHolder)) {
            s(changeAnimationInfo, viewHolder3);
            e(changeAnimationInfo, changeAnimationInfo.f25353a);
            changeAnimationInfo.a(changeAnimationInfo.f25353a);
        }
        return changeAnimationInfo.f25354b == null && changeAnimationInfo.f25353a == null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public void u(ChangeAnimationInfo changeAnimationInfo) {
        RecyclerView.ViewHolder viewHolder = changeAnimationInfo.f25354b;
        if (!(viewHolder == null || viewHolder.f15587a == null)) {
            F(changeAnimationInfo);
        }
        RecyclerView.ViewHolder viewHolder2 = changeAnimationInfo.f25353a;
        if (viewHolder2 != null && viewHolder2.f15587a != null) {
            E(changeAnimationInfo);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void E(ChangeAnimationInfo changeAnimationInfo);

    /* access modifiers changed from: protected */
    public abstract void F(ChangeAnimationInfo changeAnimationInfo);

    public long o() {
        return this.f25345a.n();
    }

    public void x(long j2) {
        this.f25345a.z(j2);
    }

    public abstract boolean z(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5);
}
