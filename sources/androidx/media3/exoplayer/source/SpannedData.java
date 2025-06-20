package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;

final class SpannedData<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f12245a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<V> f12246b;

    /* renamed from: c  reason: collision with root package name */
    private final Consumer<V> f12247c;

    public SpannedData() {
        this(new E());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i2, V v) {
        boolean z = false;
        if (this.f12245a == -1) {
            Assertions.i(this.f12246b.size() == 0);
            this.f12245a = 0;
        }
        if (this.f12246b.size() > 0) {
            SparseArray<V> sparseArray = this.f12246b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i2 >= keyAt) {
                z = true;
            }
            Assertions.a(z);
            if (keyAt == i2) {
                Consumer<V> consumer = this.f12247c;
                SparseArray<V> sparseArray2 = this.f12246b;
                consumer.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f12246b.append(i2, v);
    }

    public void c() {
        for (int i2 = 0; i2 < this.f12246b.size(); i2++) {
            this.f12247c.accept(this.f12246b.valueAt(i2));
        }
        this.f12245a = -1;
        this.f12246b.clear();
    }

    public void d(int i2) {
        int size = this.f12246b.size() - 1;
        while (size >= 0 && i2 < this.f12246b.keyAt(size)) {
            this.f12247c.accept(this.f12246b.valueAt(size));
            this.f12246b.removeAt(size);
            size--;
        }
        this.f12245a = this.f12246b.size() > 0 ? Math.min(this.f12245a, this.f12246b.size() - 1) : -1;
    }

    public void e(int i2) {
        int i3 = 0;
        while (i3 < this.f12246b.size() - 1) {
            int i4 = i3 + 1;
            if (i2 >= this.f12246b.keyAt(i4)) {
                this.f12247c.accept(this.f12246b.valueAt(i3));
                this.f12246b.removeAt(i3);
                int i5 = this.f12245a;
                if (i5 > 0) {
                    this.f12245a = i5 - 1;
                }
                i3 = i4;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0019 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V f(int r3) {
        /*
            r2 = this;
            int r0 = r2.f12245a
            r1 = -1
            if (r0 != r1) goto L_0x0008
            r0 = 0
        L_0x0006:
            r2.f12245a = r0
        L_0x0008:
            int r0 = r2.f12245a
            if (r0 <= 0) goto L_0x0019
            android.util.SparseArray<V> r1 = r2.f12246b
            int r0 = r1.keyAt(r0)
            if (r3 >= r0) goto L_0x0019
            int r0 = r2.f12245a
            int r0 = r0 + -1
            goto L_0x0006
        L_0x0019:
            int r0 = r2.f12245a
            android.util.SparseArray<V> r1 = r2.f12246b
            int r1 = r1.size()
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x0038
            android.util.SparseArray<V> r0 = r2.f12246b
            int r1 = r2.f12245a
            int r1 = r1 + 1
            int r0 = r0.keyAt(r1)
            if (r3 < r0) goto L_0x0038
            int r0 = r2.f12245a
            int r0 = r0 + 1
            r2.f12245a = r0
            goto L_0x0019
        L_0x0038:
            android.util.SparseArray<V> r3 = r2.f12246b
            int r0 = r2.f12245a
            java.lang.Object r3 = r3.valueAt(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SpannedData.f(int):java.lang.Object");
    }

    public V g() {
        SparseArray<V> sparseArray = this.f12246b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public boolean h() {
        return this.f12246b.size() == 0;
    }

    public SpannedData(Consumer<V> consumer) {
        this.f12246b = new SparseArray<>();
        this.f12247c = consumer;
        this.f12245a = -1;
    }
}
