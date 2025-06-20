package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Array;

class TileList<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f15655a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<Tile<T>> f15656b = new SparseArray<>(10);

    /* renamed from: c  reason: collision with root package name */
    Tile<T> f15657c;

    public static class Tile<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f15658a;

        /* renamed from: b  reason: collision with root package name */
        public int f15659b;

        /* renamed from: c  reason: collision with root package name */
        public int f15660c;

        /* renamed from: d  reason: collision with root package name */
        Tile<T> f15661d;

        Tile(@NonNull Class<T> cls, int i2) {
            this.f15658a = (Object[]) Array.newInstance(cls, i2);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            int i3 = this.f15659b;
            return i3 <= i2 && i2 < i3 + this.f15660c;
        }

        /* access modifiers changed from: package-private */
        public T b(int i2) {
            return this.f15658a[i2 - this.f15659b];
        }
    }

    public TileList(int i2) {
        this.f15655a = i2;
    }

    public Tile<T> a(Tile<T> tile) {
        int indexOfKey = this.f15656b.indexOfKey(tile.f15659b);
        if (indexOfKey < 0) {
            this.f15656b.put(tile.f15659b, tile);
            return null;
        }
        Tile<T> valueAt = this.f15656b.valueAt(indexOfKey);
        this.f15656b.setValueAt(indexOfKey, tile);
        if (this.f15657c == valueAt) {
            this.f15657c = tile;
        }
        return valueAt;
    }

    public void b() {
        this.f15656b.clear();
    }

    public Tile<T> c(int i2) {
        if (i2 < 0 || i2 >= this.f15656b.size()) {
            return null;
        }
        return this.f15656b.valueAt(i2);
    }

    public T d(int i2) {
        Tile<T> tile = this.f15657c;
        if (tile == null || !tile.a(i2)) {
            int indexOfKey = this.f15656b.indexOfKey(i2 - (i2 % this.f15655a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f15657c = this.f15656b.valueAt(indexOfKey);
        }
        return this.f15657c.b(i2);
    }

    public Tile<T> e(int i2) {
        Tile<T> tile = this.f15656b.get(i2);
        if (this.f15657c == tile) {
            this.f15657c = null;
        }
        this.f15656b.delete(i2);
        return tile;
    }

    public int f() {
        return this.f15656b.size();
    }
}
