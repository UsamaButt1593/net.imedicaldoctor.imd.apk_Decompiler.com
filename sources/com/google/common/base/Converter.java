package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Converter<A, B> implements Function<A, B> {
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient Converter<B, A> X;
    private final boolean s;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long X2 = 0;
        final Converter<A, B> Y;
        final Converter<B, C> Z;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.Y = converter;
            this.Z = converter2;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public A d(@CheckForNull C c2) {
            return this.Y.d(this.Z.d(c2));
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public C e(@CheckForNull A a2) {
            return this.Z.e(this.Y.e(a2));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.Y.equals(converterComposition.Y) && this.Z.equals(converterComposition.Z);
        }

        /* access modifiers changed from: protected */
        public A h(C c2) {
            throw new AssertionError();
        }

        public int hashCode() {
            return (this.Y.hashCode() * 31) + this.Z.hashCode();
        }

        /* access modifiers changed from: protected */
        public C i(A a2) {
            throw new AssertionError();
        }

        public String toString() {
            return this.Y + ".andThen(" + this.Z + ")";
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super A, ? extends B> Y;
        private final Function<? super B, ? extends A> Z;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.Y = (Function) Preconditions.E(function);
            this.Z = (Function) Preconditions.E(function2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.Y.equals(functionBasedConverter.Y) && this.Z.equals(functionBasedConverter.Z);
        }

        /* access modifiers changed from: protected */
        public A h(B b2) {
            return this.Z.apply(b2);
        }

        public int hashCode() {
            return (this.Y.hashCode() * 31) + this.Z.hashCode();
        }

        /* access modifiers changed from: protected */
        public B i(A a2) {
            return this.Y.apply(a2);
        }

        public String toString() {
            return "Converter.from(" + this.Y + ", " + this.Z + ")";
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> Y = new IdentityConverter<>();
        private static final long Z = 0;

        private IdentityConverter() {
        }

        private Object o() {
            return Y;
        }

        /* access modifiers changed from: package-private */
        public <S> Converter<T, S> f(Converter<T, S> converter) {
            return (Converter) Preconditions.F(converter, "otherConverter");
        }

        /* access modifiers changed from: protected */
        public T h(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        public T i(T t) {
            return t;
        }

        /* renamed from: p */
        public IdentityConverter<T> l() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long Z = 0;
        final Converter<A, B> Y;

        ReverseConverter(Converter<A, B> converter) {
            this.Y = converter;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public B d(@CheckForNull A a2) {
            return this.Y.e(a2);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public A e(@CheckForNull B b2) {
            return this.Y.d(b2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.Y.equals(((ReverseConverter) obj).Y);
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public B h(A a2) {
            throw new AssertionError();
        }

        public int hashCode() {
            return ~this.Y.hashCode();
        }

        /* access modifiers changed from: protected */
        public A i(B b2) {
            throw new AssertionError();
        }

        public Converter<A, B> l() {
            return this.Y;
        }

        public String toString() {
            return this.Y + ".reverse()";
        }
    }

    protected Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> j(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> k() {
        return IdentityConverter.Y;
    }

    @CheckForNull
    private A m(@CheckForNull B b2) {
        return h(NullnessCasts.a(b2));
    }

    @CheckForNull
    private B n(@CheckForNull A a2) {
        return i(NullnessCasts.a(a2));
    }

    public final <C> Converter<A, C> a(Converter<B, C> converter) {
        return f(converter);
    }

    @InlineMe(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a2) {
        return b(a2);
    }

    @CheckForNull
    public final B b(@CheckForNull A a2) {
        return e(a2);
    }

    public Iterable<B> c(final Iterable<? extends A> iterable) {
        Preconditions.F(iterable, "fromIterable");
        return new Iterable<B>() {
            public Iterator<B> iterator() {
                return new Iterator<B>() {
                    private final Iterator<? extends A> s;

                    {
                        this.s = iterable.iterator();
                    }

                    public boolean hasNext() {
                        return this.s.hasNext();
                    }

                    public B next() {
                        return Converter.this.b(this.s.next());
                    }

                    public void remove() {
                        this.s.remove();
                    }
                };
            }
        };
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public A d(@CheckForNull B b2) {
        if (!this.s) {
            return m(b2);
        }
        if (b2 == null) {
            return null;
        }
        return Preconditions.E(h(b2));
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public B e(@CheckForNull A a2) {
        if (!this.s) {
            return n(a2);
        }
        if (a2 == null) {
            return null;
        }
        return Preconditions.E(i(a2));
    }

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public <C> Converter<A, C> f(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.E(converter));
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract A h(B b2);

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract B i(A a2);

    @CheckReturnValue
    public Converter<B, A> l() {
        Converter<B, A> converter = this.X;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.X = reverseConverter;
        return reverseConverter;
    }

    Converter(boolean z) {
        this.s = z;
    }
}
