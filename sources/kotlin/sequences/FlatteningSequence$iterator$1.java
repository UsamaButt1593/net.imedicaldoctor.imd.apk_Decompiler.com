package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0010*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "", "a", "()Z", "next", "()Ljava/lang/Object;", "hasNext", "s", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "X", "b", "d", "(Ljava/util/Iterator;)V", "itemIterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class FlatteningSequence$iterator$1 implements Iterator<E>, KMappedMarker {
    @Nullable
    private Iterator<? extends E> X;
    final /* synthetic */ FlatteningSequence<T, R, E> Y;
    @NotNull
    private final Iterator<T> s;

    FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        this.Y = flatteningSequence;
        this.s = flatteningSequence.f29005a.iterator();
    }

    private final boolean a() {
        Iterator<? extends E> it2 = this.X;
        if (it2 != null && !it2.hasNext()) {
            this.X = null;
        }
        while (true) {
            if (this.X == null) {
                if (this.s.hasNext()) {
                    Iterator<? extends E> it3 = (Iterator) this.Y.f29007c.f(this.Y.f29006b.f(this.s.next()));
                    if (it3.hasNext()) {
                        this.X = it3;
                        break;
                    }
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }

    @Nullable
    public final Iterator<E> b() {
        return this.X;
    }

    @NotNull
    public final Iterator<T> c() {
        return this.s;
    }

    public final void d(@Nullable Iterator<? extends E> it2) {
        this.X = it2;
    }

    public boolean hasNext() {
        return a();
    }

    public E next() {
        if (a()) {
            Iterator<? extends E> it2 = this.X;
            Intrinsics.m(it2);
            return it2.next();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
