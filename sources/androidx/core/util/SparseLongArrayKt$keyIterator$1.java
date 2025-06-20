package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"androidx/core/util/SparseLongArrayKt$keyIterator$1", "Lkotlin/collections/IntIterator;", "", "hasNext", "()Z", "", "b", "()I", "s", "I", "c", "d", "(I)V", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class SparseLongArrayKt$keyIterator$1 extends IntIterator {
    final /* synthetic */ SparseLongArray X;
    private int s;

    SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.X = sparseLongArray;
    }

    public int b() {
        SparseLongArray sparseLongArray = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        return sparseLongArray.keyAt(i2);
    }

    public final int c() {
        return this.s;
    }

    public final void d(int i2) {
        this.s = i2;
    }

    public boolean hasNext() {
        return this.s < this.X.size();
    }
}
