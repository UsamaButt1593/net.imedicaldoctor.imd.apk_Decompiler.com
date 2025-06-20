package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter<?> s;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.s = adapter;
    }

    public void a(int i2, int i3) {
        this.s.K(i2, i3);
    }

    public void b(int i2, int i3) {
        this.s.N(i2, i3);
    }

    public void c(int i2, int i3) {
        this.s.O(i2, i3);
    }

    @SuppressLint({"UnknownNullness"})
    public void d(int i2, int i3, Object obj) {
        this.s.M(i2, i3, obj);
    }

    public void h(int i2, int i3) {
        this.s.L(i2, i3);
    }
}
