package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"kotlin/sequences/IndexingSequence$iterator$1", "", "Lkotlin/collections/IndexedValue;", "c", "()Lkotlin/collections/IndexedValue;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "a", "()I", "d", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class IndexingSequence$iterator$1 implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private int X;
    @NotNull
    private final Iterator<T> s;

    IndexingSequence$iterator$1(IndexingSequence<T> indexingSequence) {
        this.s = indexingSequence.f29010a.iterator();
    }

    public final int a() {
        return this.X;
    }

    @NotNull
    public final Iterator<T> b() {
        return this.s;
    }

    @NotNull
    /* renamed from: c */
    public IndexedValue<T> next() {
        int i2 = this.X;
        this.X = i2 + 1;
        if (i2 < 0) {
            CollectionsKt.W();
        }
        return new IndexedValue<>(i2, this.s.next());
    }

    public final void d(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        return this.s.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
