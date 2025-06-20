package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"kotlin/sequences/TakeWhileSequence$iterator$1", "", "", "a", "()V", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "d", "()I", "f", "(I)V", "nextState", "Y", "Ljava/lang/Object;", "c", "e", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TakeWhileSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int X = -1;
    @Nullable
    private T Y;
    final /* synthetic */ TakeWhileSequence<T> Z;
    @NotNull
    private final Iterator<T> s;

    TakeWhileSequence$iterator$1(TakeWhileSequence<T> takeWhileSequence) {
        this.Z = takeWhileSequence;
        this.s = takeWhileSequence.f29041a.iterator();
    }

    private final void a() {
        if (this.s.hasNext()) {
            T next = this.s.next();
            if (((Boolean) this.Z.f29042b.f(next)).booleanValue()) {
                this.X = 1;
                this.Y = next;
                return;
            }
        }
        this.X = 0;
    }

    @NotNull
    public final Iterator<T> b() {
        return this.s;
    }

    @Nullable
    public final T c() {
        return this.Y;
    }

    public final int d() {
        return this.X;
    }

    public final void e(@Nullable T t) {
        this.Y = t;
    }

    public final void f(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        if (this.X == -1) {
            a();
        }
        return this.X == 1;
    }

    public T next() {
        if (this.X == -1) {
            a();
        }
        if (this.X != 0) {
            T t = this.Y;
            this.Y = null;
            this.X = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
