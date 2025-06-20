package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewEventDistributor<T> {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f25433a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f25434b;

    /* renamed from: c  reason: collision with root package name */
    protected List<T> f25435c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f25436d;

    public boolean a(T t) {
        return b(t, -1);
    }

    public boolean b(T t, int i2) {
        if (t != null) {
            o("add()");
            n("add()");
            if (this.f25435c == null) {
                this.f25435c = new ArrayList();
            }
            if (this.f25435c.contains(t)) {
                return true;
            }
            if (i2 < 0) {
                this.f25435c.add(t);
            } else {
                this.f25435c.add(i2, t);
            }
            if (!(t instanceof RecyclerViewEventDistributorListener)) {
                return true;
            }
            ((RecyclerViewEventDistributorListener) t).a(this);
            return true;
        }
        throw new IllegalArgumentException("can not specify null for the listener");
    }

    public void c(RecyclerView recyclerView) {
        if (recyclerView != null) {
            o("attachRecyclerView()");
            n("attachRecyclerView()");
            i(recyclerView);
            return;
        }
        throw new IllegalArgumentException("RecyclerView cannot be null");
    }

    public void d() {
        e(false);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void e(boolean z) {
        if (!z) {
            o("clear()");
        }
        n("clear()");
        List<T> list = this.f25435c;
        if (list != null) {
            try {
                this.f25436d = true;
                for (int size = list.size() - 1; size >= 0; size--) {
                    T remove = this.f25435c.remove(size);
                    if (remove instanceof RecyclerViewEventDistributorListener) {
                        ((RecyclerViewEventDistributorListener) remove).b(this);
                    }
                }
                this.f25436d = false;
            } catch (Throwable th) {
                this.f25436d = false;
                throw th;
            }
        }
    }

    public boolean f(T t) {
        List<T> list = this.f25435c;
        if (list != null) {
            return list.contains(t);
        }
        return false;
    }

    public RecyclerView g() {
        return this.f25434b;
    }

    public boolean h() {
        return this.f25433a;
    }

    /* access modifiers changed from: protected */
    public void i(RecyclerView recyclerView) {
        this.f25434b = recyclerView;
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f25434b = null;
        this.f25435c = null;
        this.f25436d = false;
    }

    public void k() {
        if (!this.f25433a) {
            this.f25433a = true;
            e(true);
            j();
        }
    }

    public boolean l(T t) {
        if (t != null) {
            n("remove()");
            o("remove()");
            List<T> list = this.f25435c;
            if (list == null) {
                return false;
            }
            boolean remove = list.remove(t);
            if (remove && (t instanceof RecyclerViewEventDistributorListener)) {
                ((RecyclerViewEventDistributorListener) t).b(this);
            }
            return remove;
        }
        throw new IllegalArgumentException("can not specify null for the listener");
    }

    public int m() {
        List<T> list = this.f25435c;
        return list != null ? list.size() : list.size();
    }

    /* access modifiers changed from: protected */
    public void n(String str) {
        if (this.f25436d) {
            throw new IllegalStateException(str + " can not be called while performing the clear() method");
        }
    }

    /* access modifiers changed from: protected */
    public void o(String str) {
        if (this.f25433a) {
            throw new IllegalStateException(str + " can not be called after release() method called");
        }
    }
}
