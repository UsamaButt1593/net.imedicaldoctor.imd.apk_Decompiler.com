package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Absent<T> extends Optional<T> {
    static final Absent<Object> X = new Absent<>();
    private static final long Y = 0;

    private Absent() {
    }

    private Object m() {
        return X;
    }

    static <T> Optional<T> n() {
        return X;
    }

    public Set<T> b() {
        return Collections.emptySet();
    }

    public T d() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public boolean e() {
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public Optional<T> g(Optional<? extends T> optional) {
        return (Optional) Preconditions.E(optional);
    }

    public T h(Supplier<? extends T> supplier) {
        return Preconditions.F(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    public int hashCode() {
        return 2040732332;
    }

    public T i(T t) {
        return Preconditions.F(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    @CheckForNull
    public T j() {
        return null;
    }

    public <V> Optional<V> l(Function<? super T, V> function) {
        Preconditions.E(function);
        return Optional.a();
    }

    public String toString() {
        return "Optional.absent()";
    }
}
