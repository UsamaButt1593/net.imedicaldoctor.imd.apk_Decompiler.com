package kotlin.collections;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"kotlin/collections/ReversedList$listIterator$1", "", "", "hasNext", "()Z", "hasPrevious", "next", "()Ljava/lang/Object;", "", "nextIndex", "()I", "previous", "previousIndex", "element", "", "add", "(Ljava/lang/Object;)V", "remove", "()V", "set", "s", "Ljava/util/ListIterator;", "a", "()Ljava/util/ListIterator;", "delegateIterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ReversedList$listIterator$1 implements ListIterator<T>, KMutableListIterator {
    final /* synthetic */ ReversedList<T> X;
    @NotNull
    private final ListIterator<T> s;

    ReversedList$listIterator$1(ReversedList<T> reversedList, int i2) {
        this.X = reversedList;
        this.s = reversedList.s.listIterator(CollectionsKt__ReversedViewsKt.b1(reversedList, i2));
    }

    @NotNull
    public final ListIterator<T> a() {
        return this.s;
    }

    public void add(T t) {
        this.s.add(t);
        this.s.previous();
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
        this.s.remove();
    }

    public void set(T t) {
        this.s.set(t);
    }
}
