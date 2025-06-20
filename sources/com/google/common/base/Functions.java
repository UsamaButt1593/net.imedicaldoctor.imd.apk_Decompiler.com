package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Functions {

    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long X = 0;
        @ParametricNullness
        private final E s;

        public ConstantFunction(@ParametricNullness E e2) {
            this.s = e2;
        }

        @ParametricNullness
        public E apply(@CheckForNull Object obj) {
            return this.s;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.a(this.s, ((ConstantFunction) obj).s);
            }
            return false;
        }

        public int hashCode() {
            E e2 = this.s;
            if (e2 == null) {
                return 0;
            }
            return e2.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.s + ")";
        }
    }

    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long Y = 0;
        @ParametricNullness
        final V X;
        final Map<K, ? extends V> s;

        ForMapWithDefault(Map<K, ? extends V> map, @ParametricNullness V v) {
            this.s = (Map) Preconditions.E(map);
            this.X = v;
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k2) {
            Object obj = this.s.get(k2);
            return (obj != null || this.s.containsKey(k2)) ? NullnessCasts.a(obj) : this.X;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            return this.s.equals(forMapWithDefault.s) && Objects.a(this.X, forMapWithDefault.X);
        }

        public int hashCode() {
            return Objects.b(this.s, this.X);
        }

        public String toString() {
            return "Functions.forMap(" + this.s + ", defaultValue=" + this.X + ")";
        }
    }

    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long Y = 0;
        private final Function<A, ? extends B> X;
        private final Function<B, C> s;

        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.s = (Function) Preconditions.E(function);
            this.X = (Function) Preconditions.E(function2);
        }

        @ParametricNullness
        public C apply(@ParametricNullness A a2) {
            return this.s.apply(this.X.apply(a2));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            return this.X.equals(functionComposition.X) && this.s.equals(functionComposition.s);
        }

        public int hashCode() {
            return this.X.hashCode() ^ this.s.hashCode();
        }

        public String toString() {
            return this.s + "(" + this.X + ")";
        }
    }

    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long X = 0;
        final Map<K, V> s;

        FunctionForMapNoDefault(Map<K, V> map) {
            this.s = (Map) Preconditions.E(map);
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k2) {
            V v = this.s.get(k2);
            Preconditions.u(v != null || this.s.containsKey(k2), "Key '%s' not present in map", k2);
            return NullnessCasts.a(v);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.s.equals(((FunctionForMapNoDefault) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.s + ")";
        }
    }

    private enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @CheckForNull
        public Object apply(@CheckForNull Object obj) {
            return obj;
        }

        public String toString() {
            return "Functions.identity()";
        }
    }

    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long X = 0;
        private final Predicate<T> s;

        private PredicateFunction(Predicate<T> predicate) {
            this.s = (Predicate) Preconditions.E(predicate);
        }

        /* renamed from: a */
        public Boolean apply(@ParametricNullness T t) {
            return Boolean.valueOf(this.s.apply(t));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.s.equals(((PredicateFunction) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.s + ")";
        }
    }

    private static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long X = 0;
        private final Supplier<T> s;

        private SupplierFunction(Supplier<T> supplier) {
            this.s = (Supplier) Preconditions.E(supplier);
        }

        @ParametricNullness
        public T apply(@ParametricNullness F f2) {
            return this.s.get();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.s.equals(((SupplierFunction) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.s + ")";
        }
    }

    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        /* renamed from: b */
        public String apply(Object obj) {
            Preconditions.E(obj);
            return obj.toString();
        }

        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    private Functions() {
    }

    public static <A, B, C> Function<A, C> a(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    public static <E> Function<Object, E> b(@ParametricNullness E e2) {
        return new ConstantFunction(e2);
    }

    public static <K, V> Function<K, V> c(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <K, V> Function<K, V> d(Map<K, ? extends V> map, @ParametricNullness V v) {
        return new ForMapWithDefault(map, v);
    }

    public static <T> Function<T, Boolean> e(Predicate<T> predicate) {
        return new PredicateFunction(predicate);
    }

    public static <F, T> Function<F, T> f(Supplier<T> supplier) {
        return new SupplierFunction(supplier);
    }

    public static <E> Function<E, E> g() {
        return IdentityFunction.INSTANCE;
    }

    public static Function<Object, String> h() {
        return ToStringFunction.INSTANCE;
    }
}
