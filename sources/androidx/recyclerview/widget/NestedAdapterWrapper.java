package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;

class NestedAdapterWrapper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewTypeStorage.ViewTypeLookup f15469a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final StableIdStorage.StableIdLookup f15470b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f15471c;

    /* renamed from: d  reason: collision with root package name */
    final Callback f15472d;

    /* renamed from: e  reason: collision with root package name */
    int f15473e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f15474f = new RecyclerView.AdapterDataObserver() {
        public void a() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15473e = nestedAdapterWrapper.f15471c.b();
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            nestedAdapterWrapper2.f15472d.f(nestedAdapterWrapper2);
        }

        public void b(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15472d.b(nestedAdapterWrapper, i2, i3, (Object) null);
        }

        public void c(int i2, int i3, @Nullable Object obj) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15472d.b(nestedAdapterWrapper, i2, i3, obj);
        }

        public void d(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15473e += i3;
            nestedAdapterWrapper.f15472d.d(nestedAdapterWrapper, i2, i3);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.f15473e > 0 && nestedAdapterWrapper2.f15471c.D() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
                nestedAdapterWrapper3.f15472d.a(nestedAdapterWrapper3);
            }
        }

        public void e(int i2, int i3, int i4) {
            boolean z = true;
            if (i4 != 1) {
                z = false;
            }
            Preconditions.b(z, "moving more than 1 item is not supported in RecyclerView");
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15472d.e(nestedAdapterWrapper, i2, i3);
        }

        public void f(int i2, int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15473e -= i3;
            nestedAdapterWrapper.f15472d.g(nestedAdapterWrapper, i2, i3);
            NestedAdapterWrapper nestedAdapterWrapper2 = NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.f15473e < 1 && nestedAdapterWrapper2.f15471c.D() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                NestedAdapterWrapper nestedAdapterWrapper3 = NestedAdapterWrapper.this;
                nestedAdapterWrapper3.f15472d.a(nestedAdapterWrapper3);
            }
        }

        public void g() {
            NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
            nestedAdapterWrapper.f15472d.a(nestedAdapterWrapper);
        }
    };

    interface Callback {
        void a(NestedAdapterWrapper nestedAdapterWrapper);

        void b(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3, @Nullable Object obj);

        void c(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void d(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void e(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);

        void f(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

        void g(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3);
    }

    NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        this.f15471c = adapter;
        this.f15472d = callback;
        this.f15469a = viewTypeStorage.b(this);
        this.f15470b = stableIdLookup;
        this.f15473e = adapter.b();
        adapter.Z(this.f15474f);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f15471c.c0(this.f15474f);
        this.f15469a.m();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f15473e;
    }

    public long c(int i2) {
        return this.f15470b.a(this.f15471c.B(i2));
    }

    /* access modifiers changed from: package-private */
    public int d(int i2) {
        return this.f15469a.o(this.f15471c.C(i2));
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, int i2) {
        this.f15471c.x(viewHolder, i2);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ViewHolder f(ViewGroup viewGroup, int i2) {
        return this.f15471c.T(viewGroup, this.f15469a.n(i2));
    }
}
