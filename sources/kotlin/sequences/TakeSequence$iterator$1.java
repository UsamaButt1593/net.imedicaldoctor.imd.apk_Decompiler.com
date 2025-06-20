package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/sequences/TakeSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "", "s", "I", "b", "()I", "c", "(I)V", "left", "X", "Ljava/util/Iterator;", "a", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TakeSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    @NotNull
    private final Iterator<T> X;
    private int s;

    TakeSequence$iterator$1(TakeSequence<T> takeSequence) {
        this.s = takeSequence.f29040b;
        this.X = takeSequence.f29039a.iterator();
    }

    @NotNull
    public final Iterator<T> a() {
        return this.X;
    }

    public final int b() {
        return this.s;
    }

    public final void c(int i2) {
        this.s = i2;
    }

    public boolean hasNext() {
        return this.s > 0 && this.X.hasNext();
    }

    public T next() {
        int i2 = this.s;
        if (i2 != 0) {
            this.s = i2 - 1;
            return this.X.next();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
