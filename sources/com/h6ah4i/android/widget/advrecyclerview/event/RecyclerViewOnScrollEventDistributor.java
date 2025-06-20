package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;

@Deprecated
public class RecyclerViewOnScrollEventDistributor extends BaseRecyclerViewEventDistributor<RecyclerView.OnScrollListener> {

    /* renamed from: e  reason: collision with root package name */
    private InternalOnScrollListener f25437e = new InternalOnScrollListener(this);

    private static class InternalOnScrollListener extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<RecyclerViewOnScrollEventDistributor> f25438a;

        public InternalOnScrollListener(RecyclerViewOnScrollEventDistributor recyclerViewOnScrollEventDistributor) {
            this.f25438a = new WeakReference<>(recyclerViewOnScrollEventDistributor);
        }

        public void a(RecyclerView recyclerView, int i2) {
            RecyclerViewOnScrollEventDistributor recyclerViewOnScrollEventDistributor = this.f25438a.get();
            if (recyclerViewOnScrollEventDistributor != null) {
                recyclerViewOnScrollEventDistributor.p(recyclerView, i2);
            }
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
            RecyclerViewOnScrollEventDistributor recyclerViewOnScrollEventDistributor = this.f25438a.get();
            if (recyclerViewOnScrollEventDistributor != null) {
                recyclerViewOnScrollEventDistributor.q(recyclerView, i2, i3);
            }
        }

        public void c() {
            this.f25438a.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void i(RecyclerView recyclerView) {
        super.i(recyclerView);
        recyclerView.t(this.f25437e);
    }

    /* access modifiers changed from: protected */
    public void j() {
        InternalOnScrollListener internalOnScrollListener = this.f25437e;
        if (internalOnScrollListener != null) {
            RecyclerView recyclerView = this.f25434b;
            if (recyclerView != null) {
                recyclerView.E1(internalOnScrollListener);
            }
            this.f25437e.c();
            this.f25437e = null;
        }
        super.j();
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView recyclerView, int i2) {
        List<T> list = this.f25435c;
        if (list != null) {
            for (T a2 : list) {
                a2.a(recyclerView, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView recyclerView, int i2, int i3) {
        List<T> list = this.f25435c;
        if (list != null) {
            for (T b2 : list) {
                b2.b(recyclerView, i2, i3);
            }
        }
    }
}
