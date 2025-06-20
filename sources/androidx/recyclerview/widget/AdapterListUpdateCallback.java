package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class AdapterListUpdateCallback implements ListUpdateCallback {
    @NonNull
    private final RecyclerView.Adapter s;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
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
}
