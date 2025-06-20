package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Present<T> extends Optional<T> {
    private static final long Y = 0;
    private final T X;

    Present(T t) {
        this.X = t;
    }

    public Set<T> b() {
        return Collections.singleton(this.X);
    }

    public T d() {
        return this.X;
    }

    public boolean e() {
        return true;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Present) {
            return this.X.equals(((Present) obj).X);
        }
        return false;
    }

    public Optional<T> g(Optional<? extends T> optional) {
        Preconditions.E(optional);
        return this;
    }

    public T h(Supplier<? extends T> supplier) {
        Preconditions.E(supplier);
        return this.X;
    }

    public int hashCode() {
        return this.X.hashCode() + 1502476572;
    }

    public T i(T t) {
        Preconditions.F(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.X;
    }

    public T j() {
        return this.X;
    }

    public <V> Optional<V> l(Function<? super T, V> function) {
        return new Present(Preconditions.F(function.apply(this.X), "the Function passed to Optional.transform() must not return null."));
    }

    public String toString() {
        return "Optional.of(" + this.X + ")";
    }
}
