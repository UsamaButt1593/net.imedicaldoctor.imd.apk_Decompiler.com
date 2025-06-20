package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "", "a", "()V", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "c", "()I", "d", "(I)V", "left", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class DropSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int X;
    @NotNull
    private final Iterator<T> s;

    DropSequence$iterator$1(DropSequence<T> dropSequence) {
        this.s = dropSequence.f28997a.iterator();
        this.X = dropSequence.f28998b;
    }

    private final void a() {
        while (this.X > 0 && this.s.hasNext()) {
            this.s.next();
            this.X--;
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
        return this.s.hasNext();
    }

    public T next() {
        a();
        return this.s.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
