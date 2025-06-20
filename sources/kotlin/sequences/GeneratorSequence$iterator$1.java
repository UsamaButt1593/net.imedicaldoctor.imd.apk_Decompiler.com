package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "", "a", "()V", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/lang/Object;", "b", "d", "(Ljava/lang/Object;)V", "nextItem", "", "X", "I", "c", "()I", "e", "(I)V", "nextState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int X = -2;
    final /* synthetic */ GeneratorSequence<T> Y;
    @Nullable
    private T s;

    GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.Y = generatorSequence;
    }

    private final void a() {
        T t;
        if (this.X == -2) {
            t = this.Y.f29008a.o();
        } else {
            Function1 d2 = this.Y.f29009b;
            T t2 = this.s;
            Intrinsics.m(t2);
            t = d2.f(t2);
        }
        this.s = t;
        this.X = t == null ? 0 : 1;
    }

    @Nullable
    public final T b() {
        return this.s;
    }

    public final int c() {
        return this.X;
    }

    public final void d(@Nullable T t) {
        this.s = t;
    }

    public final void e(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        if (this.X < 0) {
            a();
        }
        return this.X == 1;
    }

    @NotNull
    public T next() {
        if (this.X < 0) {
            a();
        }
        if (this.X != 0) {
            T t = this.s;
            Intrinsics.n(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.X = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
