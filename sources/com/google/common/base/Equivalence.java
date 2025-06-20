package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {
        private static final long X = 1;
        static final Equals s = new Equals();

        Equals() {
        }

        private Object k() {
            return s;
        }

        /* access modifiers changed from: protected */
        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long Y = 0;
        @CheckForNull
        private final T X;
        private final Equivalence<T> s;

        EquivalentToPredicate(Equivalence<T> equivalence, @CheckForNull T t) {
            this.s = (Equivalence) Preconditions.E(equivalence);
            this.X = t;
        }

        public boolean apply(@CheckForNull T t) {
            return this.s.d(t, this.X);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.s.equals(equivalentToPredicate.s) && Objects.a(this.X, equivalentToPredicate.X);
        }

        public int hashCode() {
            return Objects.b(this.s, this.X);
        }

        public String toString() {
            return this.s + ".equivalentTo(" + this.X + ")";
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        private static final long X = 1;
        static final Identity s = new Identity();

        Identity() {
        }

        private Object k() {
            return s;
        }

        /* access modifiers changed from: protected */
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        /* access modifiers changed from: protected */
        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long Y = 0;
        @ParametricNullness
        private final T X;
        private final Equivalence<? super T> s;

        private Wrapper(Equivalence<? super T> equivalence, @ParametricNullness T t) {
            this.s = (Equivalence) Preconditions.E(equivalence);
            this.X = t;
        }

        @ParametricNullness
        public T a() {
            return this.X;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.s.equals(wrapper.s)) {
                return this.s.d(this.X, wrapper.X);
            }
            return false;
        }

        public int hashCode() {
            return this.s.f(this.X);
        }

        public String toString() {
            return this.s + ".wrap(" + this.X + ")";
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> c() {
        return Equals.s;
    }

    public static Equivalence<Object> g() {
        return Identity.s;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract boolean a(T t, T t2);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract int b(T t);

    public final boolean d(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return a(t, t2);
    }

    public final Predicate<T> e(@CheckForNull T t) {
        return new EquivalentToPredicate(this, t);
    }

    public final int f(@CheckForNull T t) {
        if (t == null) {
            return 0;
        }
        return b(t);
    }

    public final <F> Equivalence<F> h(Function<? super F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> i() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> j(@ParametricNullness S s) {
        return new Wrapper<>(s);
    }
}
