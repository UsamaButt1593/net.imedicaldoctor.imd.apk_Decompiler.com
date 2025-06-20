package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"kotlin/sequences/MergingSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "a", "()Ljava/util/Iterator;", "iterator1", "X", "b", "iterator2", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class MergingSequence$iterator$1 implements Iterator<V>, KMappedMarker {
    @NotNull
    private final Iterator<T2> X;
    final /* synthetic */ MergingSequence<T1, T2, V> Y;
    @NotNull
    private final Iterator<T1> s;

    MergingSequence$iterator$1(MergingSequence<T1, T2, V> mergingSequence) {
        this.Y = mergingSequence;
        this.s = mergingSequence.f29011a.iterator();
        this.X = mergingSequence.f29012b.iterator();
    }

    @NotNull
    public final Iterator<T1> a() {
        return this.s;
    }

    @NotNull
    public final Iterator<T2> b() {
        return this.X;
    }

    public boolean hasNext() {
        return this.s.hasNext() && this.X.hasNext();
    }

    public V next() {
        return this.Y.f29013c.d0(this.s.next(), this.X.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
