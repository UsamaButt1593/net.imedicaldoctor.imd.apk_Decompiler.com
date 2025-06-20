package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "", "a", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "c", "()I", "d", "(I)V", "position", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class SubSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int X;
    final /* synthetic */ SubSequence<T> Y;
    @NotNull
    private final Iterator<T> s;

    SubSequence$iterator$1(SubSequence<T> subSequence) {
        this.Y = subSequence;
        this.s = subSequence.f29036a.iterator();
    }

    private final void a() {
        while (this.X < this.Y.f29037b && this.s.hasNext()) {
            this.s.next();
            this.X++;
        }
    }

    @NotNull
    public final Iterator<T> b() {
        return this.s;
    }

    public final int c() {
        return this.X;
    }

    public final void d(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        a();
        return this.X < this.Y.f29038c && this.s.hasNext();
    }

    public T next() {
        a();
        if (this.X < this.Y.f29038c) {
            this.X++;
            return this.s.next();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
