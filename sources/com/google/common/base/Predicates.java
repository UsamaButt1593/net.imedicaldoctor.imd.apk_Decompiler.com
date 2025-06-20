package com.google.common.base;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Predicates {

    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long X = 0;
        private final List<? extends Predicate<? super T>> s;

        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.s = list;
        }

        public boolean apply(@ParametricNullness T t) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                if (!((Predicate) this.s.get(i2)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AndPredicate) {
                return this.s.equals(((AndPredicate) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.w("and", this.s);
        }
    }

    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long Y = 0;
        final Function<A, ? extends B> X;
        final Predicate<B> s;

        private CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
            this.s = (Predicate) Preconditions.E(predicate);
            this.X = (Function) Preconditions.E(function);
        }

        public boolean apply(@ParametricNullness A a2) {
            return this.s.apply(this.X.apply(a2));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.X.equals(compositionPredicate.X) && this.s.equals(compositionPredicate.s);
        }

        public int hashCode() {
            return this.X.hashCode() ^ this.s.hashCode();
        }

        public String toString() {
            return this.s + "(" + this.X + ")";
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long Y = 0;

        ContainsPatternFromStringPredicate(String str) {
            super(Platform.a(str));
        }

        public String toString() {
            return "Predicates.containsPattern(" + this.s.e() + ")";
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long X = 0;
        final CommonPattern s;

        ContainsPatternPredicate(CommonPattern commonPattern) {
            this.s = (CommonPattern) Preconditions.E(commonPattern);
        }

        /* renamed from: a */
        public boolean apply(CharSequence charSequence) {
            return this.s.d(charSequence).b();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
            return Objects.a(this.s.e(), containsPatternPredicate.s.e()) && this.s.b() == containsPatternPredicate.s.b();
        }

        public int hashCode() {
            return Objects.b(this.s.e(), Integer.valueOf(this.s.b()));
        }

        public String toString() {
            String toStringHelper = MoreObjects.c(this.s).f("pattern", this.s.e()).d("pattern.flags", this.s.b()).toString();
            return "Predicates.contains(" + toStringHelper + ")";
        }
    }

    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long X = 0;
        private final Collection<?> s;

        private InPredicate(Collection<?> collection) {
            this.s = (Collection) Preconditions.E(collection);
        }

        public boolean apply(@ParametricNullness T t) {
            try {
                return this.s.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof InPredicate) {
                return this.s.equals(((InPredicate) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.s + ")";
        }
    }

    @GwtIncompatible
    private static class InstanceOfPredicate<T> implements Predicate<T>, Serializable {
        @J2ktIncompatible
        private static final long X = 0;
        private final Class<?> s;

        private InstanceOfPredicate(Class<?> cls) {
            this.s = (Class) Preconditions.E(cls);
        }

        public boolean apply(@ParametricNullness T t) {
            return this.s.isInstance(t);
        }

        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.s == ((InstanceOfPredicate) obj).s;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.s.getName() + ")";
        }
    }

    private static class IsEqualToPredicate implements Predicate<Object>, Serializable {
        private static final long X = 0;
        private final Object s;

        private IsEqualToPredicate(Object obj) {
            this.s = obj;
        }

        /* access modifiers changed from: package-private */
        public <T> Predicate<T> a() {
            return this;
        }

        public boolean apply(@CheckForNull Object obj) {
            return this.s.equals(obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.s.equals(((IsEqualToPredicate) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.s + ")";
        }
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long X = 0;
        final Predicate<T> s;

        NotPredicate(Predicate<T> predicate) {
            this.s = (Predicate) Preconditions.E(predicate);
        }

        public boolean apply(@ParametricNullness T t) {
            return !this.s.apply(t);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof NotPredicate) {
                return this.s.equals(((NotPredicate) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return ~this.s.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.s + ")";
        }
    }

    enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            public boolean apply(@CheckForNull Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(@CheckForNull Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(@CheckForNull Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(@CheckForNull Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* access modifiers changed from: package-private */
        public <T> Predicate<T> b() {
            return this;
        }
    }

    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long X = 0;
        private final List<? extends Predicate<? super T>> s;

        private OrPredicate(List<? extends Predicate<? super T>> list) {
            this.s = list;
        }

        public boolean apply(@ParametricNullness T t) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                if (((Predicate) this.s.get(i2)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof OrPredicate) {
                return this.s.equals(((OrPredicate) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.w("or", this.s);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long X = 0;
        private final Class<?> s;

        private SubtypeOfPredicate(Class<?> cls) {
            this.s = (Class) Preconditions.E(cls);
        }

        /* renamed from: a */
        public boolean apply(Class<?> cls) {
            return this.s.isAssignableFrom(cls);
        }

        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.s == ((SubtypeOfPredicate) obj).s;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.s.getName() + ")";
        }
    }

    private Predicates() {
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> b() {
        return ObjectPredicate.ALWAYS_FALSE.b();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> c() {
        return ObjectPredicate.ALWAYS_TRUE.b();
    }

    public static <T> Predicate<T> d(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new AndPredicate(g((Predicate) Preconditions.E(predicate), (Predicate) Preconditions.E(predicate2)));
    }

    public static <T> Predicate<T> e(Iterable<? extends Predicate<? super T>> iterable) {
        return new AndPredicate(k(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> f(Predicate<? super T>... predicateArr) {
        return new AndPredicate(l(predicateArr));
    }

    private static <T> List<Predicate<? super T>> g(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(new Predicate[]{predicate, predicate2});
    }

    public static <A, B> Predicate<A> h(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    @J2ktIncompatible
    public static Predicate<CharSequence> i(Pattern pattern) {
        return new ContainsPatternPredicate(new JdkPattern(pattern));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Predicate<CharSequence> j(String str) {
        return new ContainsPatternFromStringPredicate(str);
    }

    static <T> List<T> k(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T E : iterable) {
            arrayList.add(Preconditions.E(E));
        }
        return arrayList;
    }

    private static <T> List<T> l(T... tArr) {
        return k(Arrays.asList(tArr));
    }

    public static <T> Predicate<T> m(@ParametricNullness T t) {
        return t == null ? p() : new IsEqualToPredicate(t).a();
    }

    public static <T> Predicate<T> n(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    @GwtIncompatible
    public static <T> Predicate<T> o(Class<?> cls) {
        return new InstanceOfPredicate(cls);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> p() {
        return ObjectPredicate.IS_NULL.b();
    }

    public static <T> Predicate<T> q(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> r() {
        return ObjectPredicate.NOT_NULL.b();
    }

    public static <T> Predicate<T> s(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new OrPredicate(g((Predicate) Preconditions.E(predicate), (Predicate) Preconditions.E(predicate2)));
    }

    public static <T> Predicate<T> t(Iterable<? extends Predicate<? super T>> iterable) {
        return new OrPredicate(k(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> u(Predicate<? super T>... predicateArr) {
        return new OrPredicate(l(predicateArr));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Predicate<Class<?>> v(Class<?> cls) {
        return new SubtypeOfPredicate(cls);
    }

    /* access modifiers changed from: private */
    public static String w(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append(ASCIIPropertyListParser.f18649g);
        boolean z = true;
        for (Object next : iterable) {
            if (!z) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
            sb.append(next);
            z = false;
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }
}
