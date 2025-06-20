package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use Optional.of(value) or Optional.absent()")
public abstract class Optional<T> implements Serializable {
    private static final long s = 0;

    Optional() {
    }

    public static <T> Optional<T> a() {
        return Absent.n();
    }

    public static <T> Optional<T> c(@CheckForNull T t) {
        return t == null ? a() : new Present(t);
    }

    public static <T> Optional<T> f(T t) {
        return new Present(Preconditions.E(t));
    }

    public static <T> Iterable<T> k(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.E(iterable);
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() {
                    private final Iterator<? extends Optional<? extends T>> Y;

                    {
                        this.Y = (Iterator) Preconditions.E(iterable.iterator());
                    }

                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public T a() {
                        while (this.Y.hasNext()) {
                            Optional optional = (Optional) this.Y.next();
                            if (optional.e()) {
                                return optional.d();
                            }
                        }
                        return b();
                    }
                };
            }
        };
    }

    public abstract Set<T> b();

    public abstract T d();

    public abstract boolean e();

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract Optional<T> g(Optional<? extends T> optional);

    public abstract T h(Supplier<? extends T> supplier);

    public abstract int hashCode();

    public abstract T i(T t);

    @CheckForNull
    public abstract T j();

    public abstract <V> Optional<V> l(Function<? super T, V> function);

    public abstract String toString();
}
