package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseItemAnimationManager<T extends ItemAnimationInfo> {

    /* renamed from: a  reason: collision with root package name */
    protected BaseItemAnimator f25345a;

    /* renamed from: b  reason: collision with root package name */
    protected List<T> f25346b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected List<List<T>> f25347c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected List<RecyclerView.ViewHolder> f25348d = new ArrayList();

    protected static class BaseAnimatorListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private BaseItemAnimationManager f25349a;

        /* renamed from: b  reason: collision with root package name */
        private ItemAnimationInfo f25350b;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.ViewHolder f25351c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPropertyAnimatorCompat f25352d;

        public BaseAnimatorListener(BaseItemAnimationManager baseItemAnimationManager, ItemAnimationInfo itemAnimationInfo, RecyclerView.ViewHolder viewHolder, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f25349a = baseItemAnimationManager;
            this.f25350b = itemAnimationInfo;
            this.f25351c = viewHolder;
            this.f25352d = viewPropertyAnimatorCompat;
        }

        public void a(View view) {
            this.f25349a.r(this.f25350b, this.f25351c);
        }

        public void b(View view) {
            BaseItemAnimationManager baseItemAnimationManager = this.f25349a;
            ItemAnimationInfo itemAnimationInfo = this.f25350b;
            RecyclerView.ViewHolder viewHolder = this.f25351c;
            this.f25352d.u((ViewPropertyAnimatorListener) null);
            this.f25349a = null;
            this.f25350b = null;
            this.f25351c = null;
            this.f25352d = null;
            baseItemAnimationManager.t(itemAnimationInfo, viewHolder);
            baseItemAnimationManager.e(itemAnimationInfo, viewHolder);
            itemAnimationInfo.a(viewHolder);
            baseItemAnimationManager.f25348d.remove(viewHolder);
            baseItemAnimationManager.f();
        }

        public void c(View view) {
            this.f25349a.g(this.f25350b, this.f25351c);
        }
    }

    public BaseItemAnimationManager(BaseItemAnimator baseItemAnimator) {
        this.f25345a = baseItemAnimator;
    }

    private void a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            this.f25348d.add(viewHolder);
            return;
        }
        throw new IllegalStateException("item is null");
    }

    public void b() {
        List<RecyclerView.ViewHolder> list = this.f25348d;
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.g(list.get(size).f15587a).d();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(T t) {
        u(t);
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        return this.f25345a.D();
    }

    public abstract void e(T t, RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public void f() {
        this.f25345a.E();
    }

    public abstract void g(T t, RecyclerView.ViewHolder viewHolder);

    public void h() {
        k((RecyclerView.ViewHolder) null);
    }

    public void i() {
        m((RecyclerView.ViewHolder) null);
    }

    /* access modifiers changed from: protected */
    public void j(RecyclerView.ViewHolder viewHolder) {
        this.f25345a.k(viewHolder);
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        for (int size = this.f25347c.size() - 1; size >= 0; size--) {
            List list = this.f25347c.get(size);
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (l((ItemAnimationInfo) list.get(size2), viewHolder) && viewHolder != null) {
                    list.remove(size2);
                }
            }
            if (viewHolder == null) {
                list.clear();
            }
            if (list.isEmpty()) {
                this.f25347c.remove(list);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean l(T t, RecyclerView.ViewHolder viewHolder);

    public void m(RecyclerView.ViewHolder viewHolder) {
        List<T> list = this.f25346b;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (l((ItemAnimationInfo) list.get(size), viewHolder) && viewHolder != null) {
                list.remove(size);
            }
        }
        if (viewHolder == null) {
            list.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void n(T t) {
        if (t != null) {
            this.f25346b.add(t);
            return;
        }
        throw new IllegalStateException("info is null");
    }

    public abstract long o();

    public boolean p() {
        return !this.f25346b.isEmpty();
    }

    public boolean q() {
        return !this.f25346b.isEmpty() || !this.f25348d.isEmpty() || !this.f25347c.isEmpty();
    }

    /* access modifiers changed from: protected */
    public abstract void r(T t, RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public abstract void s(T t, RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public abstract void t(T t, RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public abstract void u(T t);

    public boolean v(RecyclerView.ViewHolder viewHolder) {
        return this.f25348d.remove(viewHolder);
    }

    public void w(boolean z, long j2) {
        final ArrayList<ItemAnimationInfo> arrayList = new ArrayList<>();
        arrayList.addAll(this.f25346b);
        this.f25346b.clear();
        if (z) {
            this.f25347c.add(arrayList);
            ViewCompat.w1(((ItemAnimationInfo) arrayList.get(0)).b().f15587a, new Runnable() {
                public void run() {
                    for (ItemAnimationInfo c2 : arrayList) {
                        BaseItemAnimationManager.this.c(c2);
                    }
                    arrayList.clear();
                    BaseItemAnimationManager.this.f25347c.remove(arrayList);
                }
            }, j2);
            return;
        }
        for (ItemAnimationInfo c2 : arrayList) {
            c(c2);
        }
        arrayList.clear();
    }

    public abstract void x(long j2);

    /* access modifiers changed from: protected */
    public void y(T t, RecyclerView.ViewHolder viewHolder, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        viewPropertyAnimatorCompat.u(new BaseAnimatorListener(this, t, viewHolder, viewPropertyAnimatorCompat));
        a(viewHolder);
        viewPropertyAnimatorCompat.y();
    }
}
