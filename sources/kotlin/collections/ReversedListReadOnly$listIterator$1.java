package kotlin.collections;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010*\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"kotlin/collections/ReversedListReadOnly$listIterator$1", "", "", "hasNext", "()Z", "hasPrevious", "next", "()Ljava/lang/Object;", "", "nextIndex", "()I", "previous", "previousIndex", "s", "Ljava/util/ListIterator;", "a", "()Ljava/util/ListIterator;", "delegateIterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ReversedListReadOnly$listIterator$1 implements ListIterator<T>, KMappedMarker {
    final /* synthetic */ ReversedListReadOnly<T> X;
    @NotNull
    private final ListIterator<T> s;

    ReversedListReadOnly$listIterator$1(ReversedListReadOnly<? extends T> reversedListReadOnly, int i2) {
        this.X = reversedListReadOnly;
        this.s = reversedListReadOnly.X.listIterator(CollectionsKt__ReversedViewsKt.b1(reversedListReadOnly, i2));
    }

    @NotNull
    public final ListIterator<T> a() {
        return this.s;
    }

    public void add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        return this.s.hasPrevious();
    }

    public boolean hasPrevious() {
        return this.s.hasNext();
    }

    public T next() {
        return this.s.previous();
    }

    public int nextIndex() {
        return CollectionsKt__ReversedViewsKt.a1(this.X, this.s.previousIndex());
    }

    public T previous() {
        return this.s.next();
    }

    public int previousIndex() {
        return CollectionsKt__ReversedViewsKt.a1(this.X, this.s.nextIndex());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void set(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
