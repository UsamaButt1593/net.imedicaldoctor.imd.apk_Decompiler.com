package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"androidx/core/util/SparseLongArrayKt$valueIterator$1", "Lkotlin/collections/LongIterator;", "", "hasNext", "()Z", "", "b", "()J", "", "s", "I", "c", "()I", "d", "(I)V", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class SparseLongArrayKt$valueIterator$1 extends LongIterator {
    final /* synthetic */ SparseLongArray X;
    private int s;

    SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.X = sparseLongArray;
    }

    public long b() {
        SparseLongArray sparseLongArray = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        return sparseLongArray.valueAt(i2);
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
