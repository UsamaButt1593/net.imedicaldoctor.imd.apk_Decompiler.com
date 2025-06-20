package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"androidx/core/util/SparseBooleanArrayKt$valueIterator$1", "Lkotlin/collections/BooleanIterator;", "", "hasNext", "()Z", "b", "", "s", "I", "c", "()I", "d", "(I)V", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {
    final /* synthetic */ SparseBooleanArray X;
    private int s;

    SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.X = sparseBooleanArray;
    }

    public boolean b() {
        SparseBooleanArray sparseBooleanArray = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        return sparseBooleanArray.valueAt(i2);
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
