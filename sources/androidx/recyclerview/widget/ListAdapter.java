package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: d  reason: collision with root package name */
    final AsyncListDiffer<T> f15436d;

    /* renamed from: e  reason: collision with root package name */
    private final AsyncListDiffer.ListListener<T> f15437e;

    protected ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        AnonymousClass1 r0 = new AsyncListDiffer.ListListener<T>() {
            public void a(@NonNull List<T> list, @NonNull List<T> list2) {
                ListAdapter.this.f0(list, list2);
            }
        };
        this.f15437e = r0;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.f15436d = asyncListDiffer;
        asyncListDiffer.a(r0);
    }

    public int b() {
        return this.f15436d.b().size();
    }

    @NonNull
    public List<T> d0() {
        return this.f15436d.b();
    }

    /* access modifiers changed from: protected */
    public T e0(int i2) {
        return this.f15436d.b().get(i2);
    }

    public void f0(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void g0(@Nullable List<T> list) {
        this.f15436d.f(list);
    }

    public void h0(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.f15436d.g(list, runnable);
    }

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        AnonymousClass1 r0 = new AsyncListDiffer.ListListener<T>() {
            public void a(@NonNull List<T> list, @NonNull List<T> list2) {
                ListAdapter.this.f0(list, list2);
            }
        };
        this.f15437e = r0;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).a());
        this.f15436d = asyncListDiffer;
        asyncListDiffer.a(r0);
    }
}
