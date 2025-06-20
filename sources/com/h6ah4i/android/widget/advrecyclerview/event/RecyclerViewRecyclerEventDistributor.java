package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;

public class RecyclerViewRecyclerEventDistributor extends BaseRecyclerViewEventDistributor<RecyclerView.RecyclerListener> {

    /* renamed from: e  reason: collision with root package name */
    private InternalRecyclerListener f25439e = new InternalRecyclerListener(this);

    private static class InternalRecyclerListener implements RecyclerView.RecyclerListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<RecyclerViewRecyclerEventDistributor> f25440a;

        public InternalRecyclerListener(RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor) {
            this.f25440a = new WeakReference<>(recyclerViewRecyclerEventDistributor);
        }

        public void a(RecyclerView.ViewHolder viewHolder) {
            RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor = this.f25440a.get();
            if (recyclerViewRecyclerEventDistributor != null) {
                recyclerViewRecyclerEventDistributor.p(viewHolder);
            }
        }

        public void b() {
            this.f25440a.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void i(RecyclerView recyclerView) {
        super.i(recyclerView);
        recyclerView.setRecyclerListener(this.f25439e);
    }

    /* access modifiers changed from: protected */
    public void j() {
        super.j();
        InternalRecyclerListener internalRecyclerListener = this.f25439e;
        if (internalRecyclerListener != null) {
            internalRecyclerListener.b();
            this.f25439e = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.ViewHolder viewHolder) {
        List<T> list = this.f25435c;
        if (list != null) {
            for (T a2 : list) {
                a2.a(viewHolder);
            }
        }
    }
}
