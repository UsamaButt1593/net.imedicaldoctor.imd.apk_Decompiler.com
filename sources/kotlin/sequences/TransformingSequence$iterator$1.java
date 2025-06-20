package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "a", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TransformingSequence$iterator$1 implements Iterator<R>, KMappedMarker {
    final /* synthetic */ TransformingSequence<T, R> X;
    @NotNull
    private final Iterator<T> s;

    TransformingSequence$iterator$1(TransformingSequence<T, R> transformingSequence) {
        this.X = transformingSequence;
        this.s = transformingSequence.f29045a.iterator();
    }

    @NotNull
    public final Iterator<T> a() {
        return this.s;
    }

    public boolean hasNext() {
        return this.s.hasNext();
    }

    public R next() {
        return this.X.f29046b.f(this.s.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
