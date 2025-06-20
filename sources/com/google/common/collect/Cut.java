package com.google.common.collect;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long X = 0;
    final C s;

    /* renamed from: com.google.common.collect.Cut$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22380a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.collect.BoundType[] r0 = com.google.common.collect.BoundType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22380a = r0
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.CLOSED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22380a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.OPEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Cut.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class AboveAll extends Cut<Comparable<?>> {
        /* access modifiers changed from: private */
        public static final AboveAll Y = new AboveAll();
        private static final long Z = 0;

        private AboveAll() {
            super("");
        }

        private Object s() {
            return Y;
        }

        /* renamed from: g */
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        /* access modifiers changed from: package-private */
        public void h(StringBuilder sb) {
            throw new AssertionError();
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        /* access modifiers changed from: package-private */
        public void i(StringBuilder sb) {
            sb.append("+∞)");
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> j() {
            throw new IllegalStateException("range unbounded on this side");
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> k(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.e();
        }

        /* access modifiers changed from: package-private */
        public boolean l(Comparable<?> comparable) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> m(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public BoundType n() {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public BoundType o() {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public Cut<Comparable<?>> p(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public Cut<Comparable<?>> q(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long Y = 0;

        AboveValue(C c2) {
            super((Comparable) Preconditions.E(c2));
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Cut.super.compareTo((Cut) obj);
        }

        /* access modifiers changed from: package-private */
        public Cut<C> f(DiscreteDomain<C> discreteDomain) {
            C m2 = m(discreteDomain);
            return m2 != null ? Cut.e(m2) : Cut.a();
        }

        /* access modifiers changed from: package-private */
        public void h(StringBuilder sb) {
            sb.append(ASCIIPropertyListParser.f18649g);
            sb.append(this.s);
        }

        public int hashCode() {
            return ~this.s.hashCode();
        }

        /* access modifiers changed from: package-private */
        public void i(StringBuilder sb) {
            sb.append(this.s);
            sb.append(']');
        }

        /* access modifiers changed from: package-private */
        public C k(DiscreteDomain<C> discreteDomain) {
            return this.s;
        }

        /* access modifiers changed from: package-private */
        public boolean l(C c2) {
            return Range.h(this.s, c2) < 0;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public C m(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.g(this.s);
        }

        /* access modifiers changed from: package-private */
        public BoundType n() {
            return BoundType.OPEN;
        }

        /* access modifiers changed from: package-private */
        public BoundType o() {
            return BoundType.CLOSED;
        }

        /* access modifiers changed from: package-private */
        public Cut<C> p(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i2 = AnonymousClass1.f22380a[boundType.ordinal()];
            if (i2 == 1) {
                C g2 = discreteDomain.g(this.s);
                return g2 == null ? Cut.c() : Cut.e(g2);
            } else if (i2 == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i2 = AnonymousClass1.f22380a[boundType.ordinal()];
            if (i2 == 1) {
                return this;
            }
            if (i2 == 2) {
                C g2 = discreteDomain.g(this.s);
                return g2 == null ? Cut.a() : Cut.e(g2);
            }
            throw new AssertionError();
        }

        public String toString() {
            return "/" + this.s + "\\";
        }
    }

    private static final class BelowAll extends Cut<Comparable<?>> {
        /* access modifiers changed from: private */
        public static final BelowAll Y = new BelowAll();
        private static final long Z = 0;

        private BelowAll() {
            super("");
        }

        private Object s() {
            return Y;
        }

        /* access modifiers changed from: package-private */
        public Cut<Comparable<?>> f(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.e(discreteDomain.f());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        /* renamed from: g */
        public int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        /* access modifiers changed from: package-private */
        public void h(StringBuilder sb) {
            sb.append("(-∞");
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        /* access modifiers changed from: package-private */
        public void i(StringBuilder sb) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> j() {
            throw new IllegalStateException("range unbounded on this side");
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> k(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public boolean l(Comparable<?> comparable) {
            return true;
        }

        /* access modifiers changed from: package-private */
        public Comparable<?> m(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.f();
        }

        /* access modifiers changed from: package-private */
        public BoundType n() {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public BoundType o() {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public Cut<Comparable<?>> p(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public Cut<Comparable<?>> q(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long Y = 0;

        BelowValue(C c2) {
            super((Comparable) Preconditions.E(c2));
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Cut.super.compareTo((Cut) obj);
        }

        /* access modifiers changed from: package-private */
        public void h(StringBuilder sb) {
            sb.append('[');
            sb.append(this.s);
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        /* access modifiers changed from: package-private */
        public void i(StringBuilder sb) {
            sb.append(this.s);
            sb.append(ASCIIPropertyListParser.f18650h);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public C k(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.i(this.s);
        }

        /* access modifiers changed from: package-private */
        public boolean l(C c2) {
            return Range.h(this.s, c2) <= 0;
        }

        /* access modifiers changed from: package-private */
        public C m(DiscreteDomain<C> discreteDomain) {
            return this.s;
        }

        /* access modifiers changed from: package-private */
        public BoundType n() {
            return BoundType.CLOSED;
        }

        /* access modifiers changed from: package-private */
        public BoundType o() {
            return BoundType.OPEN;
        }

        /* access modifiers changed from: package-private */
        public Cut<C> p(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i2 = AnonymousClass1.f22380a[boundType.ordinal()];
            if (i2 == 1) {
                return this;
            }
            if (i2 == 2) {
                C i3 = discreteDomain.i(this.s);
                return i3 == null ? Cut.c() : new AboveValue(i3);
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i2 = AnonymousClass1.f22380a[boundType.ordinal()];
            if (i2 == 1) {
                C i3 = discreteDomain.i(this.s);
                return i3 == null ? Cut.a() : new AboveValue(i3);
            } else if (i2 == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        public String toString() {
            return "\\" + this.s + "/";
        }
    }

    Cut(C c2) {
        this.s = c2;
    }

    static <C extends Comparable> Cut<C> a() {
        return AboveAll.Y;
    }

    static <C extends Comparable> Cut<C> b(C c2) {
        return new AboveValue(c2);
    }

    static <C extends Comparable> Cut<C> c() {
        return BelowAll.Y;
    }

    static <C extends Comparable> Cut<C> e(C c2) {
        return new BelowValue(c2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public Cut<C> f(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    /* renamed from: g */
    public int compareTo(Cut<C> cut) {
        if (cut == c()) {
            return 1;
        }
        if (cut == a()) {
            return -1;
        }
        int h2 = Range.h(this.s, cut.s);
        return h2 != 0 ? h2 : Booleans.d(this instanceof AboveValue, cut instanceof AboveValue);
    }

    /* access modifiers changed from: package-private */
    public abstract void h(StringBuilder sb);

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract void i(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public C j() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public abstract C k(DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract boolean l(C c2);

    /* access modifiers changed from: package-private */
    @CheckForNull
    public abstract C m(DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract BoundType n();

    /* access modifiers changed from: package-private */
    public abstract BoundType o();

    /* access modifiers changed from: package-private */
    public abstract Cut<C> p(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain);
}
