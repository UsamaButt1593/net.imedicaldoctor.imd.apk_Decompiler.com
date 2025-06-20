package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;

public abstract class ItemAddAnimationManager extends BaseItemAnimationManager<AddAnimationInfo> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f25359e = "ARVItemAddAnimMgr";

    public ItemAddAnimationManager(BaseItemAnimator baseItemAnimator) {
        super(baseItemAnimator);
    }

    /* renamed from: A */
    public void e(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25359e, "dispatchAddFinished(" + viewHolder + ")");
        }
        this.f25345a.dispatchAddFinished(viewHolder);
    }

    /* renamed from: B */
    public void g(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        if (d()) {
            Log.d(f25359e, "dispatchAddStarting(" + viewHolder + ")");
        }
        this.f25345a.dispatchAddStarting(viewHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public boolean l(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = addAnimationInfo.f25344a;
        if (viewHolder2 == null) {
            return false;
        }
        if (viewHolder != null && viewHolder2 != viewHolder) {
            return false;
        }
        s(addAnimationInfo, viewHolder2);
        e(addAnimationInfo, addAnimationInfo.f25344a);
        addAnimationInfo.a(addAnimationInfo.f25344a);
        return true;
    }

    public long o() {
        return this.f25345a.m();
    }

    public void x(long j2) {
        this.f25345a.y(j2);
    }

    public abstract boolean z(RecyclerView.ViewHolder viewHolder);
}
