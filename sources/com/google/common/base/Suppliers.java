package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Suppliers {

    @VisibleForTesting
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long X2 = 0;
        final long X;
        @CheckForNull
        volatile transient T Y;
        volatile transient long Z;
        final Supplier<T> s;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long j2, TimeUnit timeUnit) {
            this.s = (Supplier) Preconditions.E(supplier);
            this.X = timeUnit.toNanos(j2);
            Preconditions.t(j2 > 0, "duration (%s %s) must be > 0", j2, timeUnit);
        }

        @ParametricNullness
        public T get() {
            long j2 = this.Z;
            long nanoTime = System.nanoTime();
            if (j2 == 0 || nanoTime - j2 >= 0) {
                synchronized (this) {
                    try {
                        if (j2 == this.Z) {
                            T t = this.s.get();
                            this.Y = t;
                            long j3 = nanoTime + this.X;
                            if (j3 == 0) {
                                j3 = 1;
                            }
                            this.Z = j3;
                            return t;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            return NullnessCasts.a(this.Y);
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.s + ", " + this.X + ", NANOS)";
        }
    }

    @VisibleForTesting
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long Z = 0;
        volatile transient boolean X;
        @CheckForNull
        transient T Y;
        final Supplier<T> s;

        MemoizingSupplier(Supplier<T> supplier) {
            this.s = (Supplier) Preconditions.E(supplier);
        }

        @ParametricNullness
        public T get() {
            if (!this.X) {
                synchronized (this) {
                    try {
                        if (!this.X) {
                            T t = this.s.get();
                            this.Y = t;
                            this.X = true;
                            return t;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return NullnessCasts.a(this.Y);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.X) {
                obj = "<supplier that returned " + this.Y + ">";
            } else {
                obj = this.s;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    @VisibleForTesting
    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        private static final Supplier<Void> Y = new a();
        @CheckForNull
        private T X;
        private volatile Supplier<T> s;

        NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.s = (Supplier) Preconditions.E(supplier);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @ParametricNullness
        public T get() {
            Supplier<T> supplier = this.s;
            Supplier<Void> supplier2 = Y;
            if (supplier != supplier2) {
                synchronized (this) {
                    try {
                        if (this.s != supplier2) {
                            T t = this.s.get();
                            this.X = t;
                            this.s = supplier2;
                            return t;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return NullnessCasts.a(this.X);
        }

        public String toString() {
            Object obj = this.s;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == Y) {
                obj = "<supplier that returned " + this.X + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long Y = 0;
        final Supplier<F> X;
        final Function<? super F, T> s;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.s = (Function) Preconditions.E(function);
            this.X = (Supplier) Preconditions.E(supplier);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            return this.s.equals(supplierComposition.s) && this.X.equals(supplierComposition.X);
        }

        @ParametricNullness
        public T get() {
            return this.s.apply(this.X.get());
        }

        public int hashCode() {
            return Objects.b(this.s, this.X);
        }

        public String toString() {
            return "Suppliers.compose(" + this.s + ", " + this.X + ")";
        }
    }

    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        @CheckForNull
        /* renamed from: b */
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }

        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long X = 0;
        @ParametricNullness
        final T s;

        SupplierOfInstance(@ParametricNullness T t) {
            this.s = t;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.a(this.s, ((SupplierOfInstance) obj).s);
            }
            return false;
        }

        @ParametricNullness
        public T get() {
            return this.s;
        }

        public int hashCode() {
            return Objects.b(this.s);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.s + ")";
        }
    }

    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long X = 0;
        final Supplier<T> s;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.s = (Supplier) Preconditions.E(supplier);
        }

        @ParametricNullness
        public T get() {
            T t;
            synchronized (this.s) {
                t = this.s.get();
            }
            return t;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.s + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> a(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    public static <T> Supplier<T> b(Supplier<T> supplier) {
        if ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) {
            return supplier;
        }
        return supplier instanceof Serializable ? new MemoizingSupplier(supplier) : new NonSerializableMemoizingSupplier(supplier);
    }

    public static <T> Supplier<T> c(Supplier<T> supplier, long j2, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(supplier, j2, timeUnit);
    }

    public static <T> Supplier<T> d(@ParametricNullness T t) {
        return new SupplierOfInstance(t);
    }

    public static <T> Function<Supplier<T>, T> e() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> f(Supplier<T> supplier) {
        return new ThreadSafeSupplier(supplier);
    }
}
