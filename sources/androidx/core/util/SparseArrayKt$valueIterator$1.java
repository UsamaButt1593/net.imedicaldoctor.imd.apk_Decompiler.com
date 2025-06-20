package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00018\u00008\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"androidx/core/util/SparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "kotlin.jvm.PlatformType", "next", "()Ljava/lang/Object;", "", "s", "I", "a", "()I", "b", "(I)V", "index", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, KMappedMarker {
    final /* synthetic */ SparseArray<T> X;
    private int s;

    SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.X = sparseArray;
    }

    public final int a() {
        return this.s;
    }

    public final void b(int i2) {
        this.s = i2;
    }

    public boolean hasNext() {
        return this.s < this.X.size();
    }

    public T next() {
        SparseArray<T> sparseArray = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        return sparseArray.valueAt(i2);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
