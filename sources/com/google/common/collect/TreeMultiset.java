package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long a3 = 1;
    private final transient Reference<AvlNode<E>> X2;
    /* access modifiers changed from: private */
    public final transient GeneralRange<E> Y2;
    /* access modifiers changed from: private */
    public final transient AvlNode<E> Z2;

    /* renamed from: com.google.common.collect.TreeMultiset$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22503a;

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
                f22503a = r0
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22503a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.AnonymousClass4.<clinit>():void");
        }
    }

    private enum Aggregate {
        SIZE {
            /* access modifiers changed from: package-private */
            public int b(AvlNode<?> avlNode) {
                return avlNode.f22505b;
            }

            /* access modifiers changed from: package-private */
            public long c(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.f22507d;
            }
        },
        DISTINCT {
            /* access modifiers changed from: package-private */
            public int b(AvlNode<?> avlNode) {
                return 1;
            }

            /* access modifiers changed from: package-private */
            public long c(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return (long) avlNode.f22506c;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int b(AvlNode<?> avlNode);

        /* access modifiers changed from: package-private */
        public abstract long c(@CheckForNull AvlNode<?> avlNode);
    }

    private static final class AvlNode<E> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private final E f22504a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f22505b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f22506c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public long f22507d;

        /* renamed from: e  reason: collision with root package name */
        private int f22508e;
        /* access modifiers changed from: private */
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        public AvlNode<E> f22509f;
        /* access modifiers changed from: private */
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        public AvlNode<E> f22510g;
        /* access modifiers changed from: private */
        @CheckForNull

        /* renamed from: h  reason: collision with root package name */
        public AvlNode<E> f22511h;
        /* access modifiers changed from: private */
        @CheckForNull

        /* renamed from: i  reason: collision with root package name */
        public AvlNode<E> f22512i;

        AvlNode() {
            this.f22504a = null;
            this.f22505b = 1;
        }

        private AvlNode<E> A() {
            int r = r();
            if (r == -2) {
                Objects.requireNonNull(this.f22510g);
                if (this.f22510g.r() > 0) {
                    this.f22510g = this.f22510g.I();
                }
                return H();
            } else if (r != 2) {
                C();
                return this;
            } else {
                Objects.requireNonNull(this.f22509f);
                if (this.f22509f.r() < 0) {
                    this.f22509f = this.f22509f.H();
                }
                return I();
            }
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f22508e = Math.max(y(this.f22509f), y(this.f22510g)) + 1;
        }

        private void D() {
            this.f22506c = TreeMultiset.K(this.f22509f) + 1 + TreeMultiset.K(this.f22510g);
            this.f22507d = ((long) this.f22505b) + M(this.f22509f) + M(this.f22510g);
        }

        @CheckForNull
        private AvlNode<E> F(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.f22510g;
            if (avlNode2 == null) {
                return this.f22509f;
            }
            this.f22510g = avlNode2.F(avlNode);
            this.f22506c--;
            this.f22507d -= (long) avlNode.f22505b;
            return A();
        }

        @CheckForNull
        private AvlNode<E> G(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.f22509f;
            if (avlNode2 == null) {
                return this.f22510g;
            }
            this.f22509f = avlNode2.G(avlNode);
            this.f22506c--;
            this.f22507d -= (long) avlNode.f22505b;
            return A();
        }

        private AvlNode<E> H() {
            Preconditions.g0(this.f22510g != null);
            AvlNode<E> avlNode = this.f22510g;
            this.f22510g = avlNode.f22509f;
            avlNode.f22509f = this;
            avlNode.f22507d = this.f22507d;
            avlNode.f22506c = this.f22506c;
            B();
            avlNode.C();
            return avlNode;
        }

        private AvlNode<E> I() {
            Preconditions.g0(this.f22509f != null);
            AvlNode<E> avlNode = this.f22509f;
            this.f22509f = avlNode.f22510g;
            avlNode.f22510g = this;
            avlNode.f22507d = this.f22507d;
            avlNode.f22506c = this.f22506c;
            B();
            avlNode.C();
            return avlNode;
        }

        /* access modifiers changed from: private */
        public AvlNode<E> L() {
            AvlNode<E> avlNode = this.f22512i;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private static long M(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.f22507d;
        }

        private AvlNode<E> p(@ParametricNullness E e2, int i2) {
            this.f22509f = new AvlNode<>(e2, i2);
            TreeMultiset.P(z(), this.f22509f, this);
            this.f22508e = Math.max(2, this.f22508e);
            this.f22506c++;
            this.f22507d += (long) i2;
            return this;
        }

        private AvlNode<E> q(@ParametricNullness E e2, int i2) {
            AvlNode<E> avlNode = new AvlNode<>(e2, i2);
            this.f22510g = avlNode;
            TreeMultiset.P(this, avlNode, L());
            this.f22508e = Math.max(2, this.f22508e);
            this.f22506c++;
            this.f22507d += (long) i2;
            return this;
        }

        private int r() {
            return y(this.f22509f) - y(this.f22510g);
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> s(Comparator<? super E> comparator, @ParametricNullness E e2) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                return avlNode == null ? this : (AvlNode) MoreObjects.a(avlNode.s(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.s(comparator, e2);
            }
        }

        @CheckForNull
        private AvlNode<E> u() {
            AvlNode L;
            int i2 = this.f22505b;
            this.f22505b = 0;
            TreeMultiset.O(z(), L());
            AvlNode<E> avlNode = this.f22509f;
            if (avlNode == null) {
                return this.f22510g;
            }
            AvlNode<E> avlNode2 = this.f22510g;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.f22508e >= avlNode2.f22508e) {
                L = z();
                L.f22509f = this.f22509f.F(L);
                L.f22510g = this.f22510g;
            } else {
                L = L();
                L.f22510g = this.f22510g.G(L);
                L.f22509f = this.f22509f;
            }
            L.f22506c = this.f22506c - 1;
            L.f22507d = this.f22507d - ((long) i2);
            return L.A();
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> v(Comparator<? super E> comparator, @ParametricNullness E e2) {
            int compare = comparator.compare(e2, x());
            if (compare > 0) {
                AvlNode<E> avlNode = this.f22510g;
                return avlNode == null ? this : (AvlNode) MoreObjects.a(avlNode.v(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.f22509f;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.v(comparator, e2);
            }
        }

        private static int y(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.f22508e;
        }

        /* access modifiers changed from: private */
        public AvlNode<E> z() {
            AvlNode<E> avlNode = this.f22511h;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> E(Comparator<? super E> comparator, @ParametricNullness E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f22509f = avlNode.E(comparator, e2, i2, iArr);
                int i3 = iArr[0];
                if (i3 > 0) {
                    if (i2 >= i3) {
                        this.f22506c--;
                        this.f22507d -= (long) i3;
                    } else {
                        this.f22507d -= (long) i2;
                    }
                }
                return i3 == 0 ? this : A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f22510g = avlNode2.E(comparator, e2, i2, iArr);
                int i4 = iArr[0];
                if (i4 > 0) {
                    if (i2 >= i4) {
                        this.f22506c--;
                        this.f22507d -= (long) i4;
                    } else {
                        this.f22507d -= (long) i2;
                    }
                }
                return A();
            } else {
                int i5 = this.f22505b;
                iArr[0] = i5;
                if (i2 >= i5) {
                    return u();
                }
                this.f22505b = i5 - i2;
                this.f22507d -= (long) i2;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> J(Comparator<? super E> comparator, @ParametricNullness E e2, int i2, int i3, int[] iArr) {
            int i4;
            int i5;
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i2 != 0 || i3 <= 0) ? this : p(e2, i3);
                }
                this.f22509f = avlNode.J(comparator, e2, i2, i3, iArr);
                int i6 = iArr[0];
                if (i6 == i2) {
                    if (i3 != 0 || i6 == 0) {
                        if (i3 > 0 && i6 == 0) {
                            i5 = this.f22506c + 1;
                        }
                        this.f22507d += (long) (i3 - i6);
                    } else {
                        i5 = this.f22506c - 1;
                    }
                    this.f22506c = i5;
                    this.f22507d += (long) (i3 - i6);
                }
                return A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return (i2 != 0 || i3 <= 0) ? this : q(e2, i3);
                }
                this.f22510g = avlNode2.J(comparator, e2, i2, i3, iArr);
                int i7 = iArr[0];
                if (i7 == i2) {
                    if (i3 != 0 || i7 == 0) {
                        if (i3 > 0 && i7 == 0) {
                            i4 = this.f22506c + 1;
                        }
                        this.f22507d += (long) (i3 - i7);
                    } else {
                        i4 = this.f22506c - 1;
                    }
                    this.f22506c = i4;
                    this.f22507d += (long) (i3 - i7);
                }
                return A();
            } else {
                int i8 = this.f22505b;
                iArr[0] = i8;
                if (i2 == i8) {
                    if (i3 == 0) {
                        return u();
                    }
                    this.f22507d += (long) (i3 - i8);
                    this.f22505b = i3;
                }
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> K(Comparator<? super E> comparator, @ParametricNullness E e2, int i2, int[] iArr) {
            long j2;
            int i3;
            int i4;
            int i5;
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i2 > 0 ? p(e2, i2) : this;
                }
                this.f22509f = avlNode.K(comparator, e2, i2, iArr);
                if (i2 != 0 || iArr[0] == 0) {
                    if (i2 > 0 && iArr[0] == 0) {
                        i5 = this.f22506c + 1;
                    }
                    j2 = this.f22507d;
                    i3 = iArr[0];
                } else {
                    i5 = this.f22506c - 1;
                }
                this.f22506c = i5;
                j2 = this.f22507d;
                i3 = iArr[0];
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return i2 > 0 ? q(e2, i2) : this;
                }
                this.f22510g = avlNode2.K(comparator, e2, i2, iArr);
                if (i2 != 0 || iArr[0] == 0) {
                    if (i2 > 0 && iArr[0] == 0) {
                        i4 = this.f22506c + 1;
                    }
                    j2 = this.f22507d;
                    i3 = iArr[0];
                } else {
                    i4 = this.f22506c - 1;
                }
                this.f22506c = i4;
                j2 = this.f22507d;
                i3 = iArr[0];
            } else {
                int i6 = this.f22505b;
                iArr[0] = i6;
                if (i2 == 0) {
                    return u();
                }
                this.f22507d += (long) (i2 - i6);
                this.f22505b = i2;
                return this;
            }
            this.f22507d = j2 + ((long) (i2 - i3));
            return A();
        }

        /* access modifiers changed from: package-private */
        public AvlNode<E> o(Comparator<? super E> comparator, @ParametricNullness E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, x());
            boolean z = true;
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return p(e2, i2);
                }
                int i3 = avlNode.f22508e;
                AvlNode<E> o = avlNode.o(comparator, e2, i2, iArr);
                this.f22509f = o;
                if (iArr[0] == 0) {
                    this.f22506c++;
                }
                this.f22507d += (long) i2;
                return o.f22508e == i3 ? this : A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return q(e2, i2);
                }
                int i4 = avlNode2.f22508e;
                AvlNode<E> o2 = avlNode2.o(comparator, e2, i2, iArr);
                this.f22510g = o2;
                if (iArr[0] == 0) {
                    this.f22506c++;
                }
                this.f22507d += (long) i2;
                return o2.f22508e == i4 ? this : A();
            } else {
                int i5 = this.f22505b;
                iArr[0] = i5;
                long j2 = (long) i2;
                if (((long) i5) + j2 > 2147483647L) {
                    z = false;
                }
                Preconditions.d(z);
                this.f22505b += i2;
                this.f22507d += j2;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public int t(Comparator<? super E> comparator, @ParametricNullness E e2) {
            int compare = comparator.compare(e2, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f22509f;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.t(comparator, e2);
            } else if (compare <= 0) {
                return this.f22505b;
            } else {
                AvlNode<E> avlNode2 = this.f22510g;
                if (avlNode2 == null) {
                    return 0;
                }
                return avlNode2.t(comparator, e2);
            }
        }

        public String toString() {
            return Multisets.k(x(), w()).toString();
        }

        /* access modifiers changed from: package-private */
        public int w() {
            return this.f22505b;
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public E x() {
            return NullnessCasts.a(this.f22504a);
        }

        AvlNode(@ParametricNullness E e2, int i2) {
            Preconditions.d(i2 > 0);
            this.f22504a = e2;
            this.f22505b = i2;
            this.f22507d = (long) i2;
            this.f22506c = 1;
            this.f22508e = 1;
            this.f22509f = null;
            this.f22510g = null;
        }
    }

    private static final class Reference<T> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private T f22513a;

        private Reference() {
        }

        public void a(@CheckForNull T t, @CheckForNull T t2) {
            if (this.f22513a == t) {
                this.f22513a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f22513a = null;
        }

        @CheckForNull
        public T c() {
            return this.f22513a;
        }
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.b());
        this.X2 = reference;
        this.Y2 = generalRange;
        this.Z2 = avlNode;
    }

    private long B(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long c2;
        long B;
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(NullnessCasts.a(this.Y2.i()), avlNode.x());
        if (compare > 0) {
            return B(aggregate, avlNode.f22510g);
        }
        if (compare == 0) {
            int i2 = AnonymousClass4.f22503a[this.Y2.h().ordinal()];
            if (i2 == 1) {
                c2 = (long) aggregate.b(avlNode);
                B = aggregate.c(avlNode.f22510g);
            } else if (i2 == 2) {
                return aggregate.c(avlNode.f22510g);
            } else {
                throw new AssertionError();
            }
        } else {
            c2 = aggregate.c(avlNode.f22510g) + ((long) aggregate.b(avlNode));
            B = B(aggregate, avlNode.f22509f);
        }
        return c2 + B;
    }

    private long C(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long c2;
        long C;
        if (avlNode == null) {
            return 0;
        }
        int compare = comparator().compare(NullnessCasts.a(this.Y2.g()), avlNode.x());
        if (compare < 0) {
            return C(aggregate, avlNode.f22509f);
        }
        if (compare == 0) {
            int i2 = AnonymousClass4.f22503a[this.Y2.f().ordinal()];
            if (i2 == 1) {
                c2 = (long) aggregate.b(avlNode);
                C = aggregate.c(avlNode.f22509f);
            } else if (i2 == 2) {
                return aggregate.c(avlNode.f22509f);
            } else {
                throw new AssertionError();
            }
        } else {
            c2 = aggregate.c(avlNode.f22509f) + ((long) aggregate.b(avlNode));
            C = C(aggregate, avlNode.f22510g);
        }
        return c2 + C;
    }

    private long D(Aggregate aggregate) {
        AvlNode c2 = this.X2.c();
        long c3 = aggregate.c(c2);
        if (this.Y2.j()) {
            c3 -= C(aggregate, c2);
        }
        return this.Y2.k() ? c3 - B(aggregate, c2) : c3;
    }

    public static <E extends Comparable> TreeMultiset<E> E() {
        return new TreeMultiset<>(Ordering.z());
    }

    public static <E extends Comparable> TreeMultiset<E> H(Iterable<? extends E> iterable) {
        TreeMultiset<E> E = E();
        Iterables.a(E, iterable);
        return E;
    }

    public static <E> TreeMultiset<E> I(@CheckForNull Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.z()) : new TreeMultiset<>(comparator);
    }

    static int K(@CheckForNull AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return avlNode.f22506c;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (comparator().compare(r2, r0.x()) == 0) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.TreeMultiset.AvlNode<E> L() {
        /*
            r5 = this;
            com.google.common.collect.TreeMultiset$Reference<com.google.common.collect.TreeMultiset$AvlNode<E>> r0 = r5.X2
            java.lang.Object r0 = r0.c()
            com.google.common.collect.TreeMultiset$AvlNode r0 = (com.google.common.collect.TreeMultiset.AvlNode) r0
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            boolean r2 = r2.j()
            if (r2 == 0) goto L_0x0042
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            java.lang.Object r2 = r2.g()
            java.lang.Object r2 = com.google.common.collect.NullnessCasts.a(r2)
            java.util.Comparator r3 = r5.comparator()
            com.google.common.collect.TreeMultiset$AvlNode r0 = r0.s(r3, r2)
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            com.google.common.collect.GeneralRange<E> r3 = r5.Y2
            com.google.common.collect.BoundType r3 = r3.f()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L_0x0048
            java.util.Comparator r3 = r5.comparator()
            java.lang.Object r4 = r0.x()
            int r2 = r3.compare(r2, r4)
            if (r2 != 0) goto L_0x0048
            goto L_0x0044
        L_0x0042:
            com.google.common.collect.TreeMultiset$AvlNode<E> r0 = r5.Z2
        L_0x0044:
            com.google.common.collect.TreeMultiset$AvlNode r0 = r0.L()
        L_0x0048:
            com.google.common.collect.TreeMultiset$AvlNode<E> r2 = r5.Z2
            if (r0 == r2) goto L_0x005a
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            java.lang.Object r3 = r0.x()
            boolean r2 = r2.c(r3)
            if (r2 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = r0
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.L():com.google.common.collect.TreeMultiset$AvlNode");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (comparator().compare(r2, r0.x()) == 0) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.TreeMultiset.AvlNode<E> M() {
        /*
            r5 = this;
            com.google.common.collect.TreeMultiset$Reference<com.google.common.collect.TreeMultiset$AvlNode<E>> r0 = r5.X2
            java.lang.Object r0 = r0.c()
            com.google.common.collect.TreeMultiset$AvlNode r0 = (com.google.common.collect.TreeMultiset.AvlNode) r0
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            boolean r2 = r2.k()
            if (r2 == 0) goto L_0x0042
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            java.lang.Object r2 = r2.i()
            java.lang.Object r2 = com.google.common.collect.NullnessCasts.a(r2)
            java.util.Comparator r3 = r5.comparator()
            com.google.common.collect.TreeMultiset$AvlNode r0 = r0.v(r3, r2)
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            com.google.common.collect.GeneralRange<E> r3 = r5.Y2
            com.google.common.collect.BoundType r3 = r3.h()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L_0x0048
            java.util.Comparator r3 = r5.comparator()
            java.lang.Object r4 = r0.x()
            int r2 = r3.compare(r2, r4)
            if (r2 != 0) goto L_0x0048
            goto L_0x0044
        L_0x0042:
            com.google.common.collect.TreeMultiset$AvlNode<E> r0 = r5.Z2
        L_0x0044:
            com.google.common.collect.TreeMultiset$AvlNode r0 = r0.z()
        L_0x0048:
            com.google.common.collect.TreeMultiset$AvlNode<E> r2 = r5.Z2
            if (r0 == r2) goto L_0x005a
            com.google.common.collect.GeneralRange<E> r2 = r5.Y2
            java.lang.Object r3 = r0.x()
            boolean r2 = r2.c(r3)
            if (r2 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = r0
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.M():com.google.common.collect.TreeMultiset$AvlNode");
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void N(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        Comparator comparator = (Comparator) readObject;
        Serialization.a(AbstractSortedMultiset.class, "comparator").b(this, comparator);
        Class<TreeMultiset> cls = TreeMultiset.class;
        Serialization.a(cls, "range").b(this, GeneralRange.a(comparator));
        Serialization.a(cls, "rootReference").b(this, new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.a(cls, HTML.Tag.R).b(this, avlNode);
        O(avlNode, avlNode);
        Serialization.f(this, objectInputStream);
    }

    /* access modifiers changed from: private */
    public static <T> void O(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        AvlNode unused = avlNode.f22512i = avlNode2;
        AvlNode unused2 = avlNode2.f22511h = avlNode;
    }

    /* access modifiers changed from: private */
    public static <T> void P(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        O(avlNode, avlNode2);
        O(avlNode2, avlNode3);
    }

    /* access modifiers changed from: private */
    public Multiset.Entry<E> R(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() {
            @ParametricNullness
            public E a() {
                return avlNode.x();
            }

            public int getCount() {
                int w = avlNode.w();
                return w == 0 ? TreeMultiset.this.l1(a()) : w;
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void T(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(e().comparator());
        Serialization.k(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public boolean D0(@ParametricNullness E e2, int i2, int i3) {
        CollectPreconditions.b(i3, "newCount");
        CollectPreconditions.b(i2, "oldCount");
        Preconditions.d(this.Y2.c(e2));
        AvlNode c2 = this.X2.c();
        if (c2 != null) {
            int[] iArr = new int[1];
            this.X2.a(c2, c2.J(comparator(), e2, i2, i3, iArr));
            return iArr[0] == i2;
        } else if (i2 != 0) {
            return false;
        } else {
            if (i3 > 0) {
                Q(e2, i3);
            }
            return true;
        }
    }

    public SortedMultiset<E> D1(@ParametricNullness E e2, BoundType boundType) {
        return new TreeMultiset(this.X2, this.Y2.l(GeneralRange.d(comparator(), e2, boundType)), this.Z2);
    }

    @CanIgnoreReturnValue
    public int F(@CheckForNull Object obj, int i2) {
        CollectPreconditions.b(i2, "occurrences");
        if (i2 == 0) {
            return l1(obj);
        }
        AvlNode c2 = this.X2.c();
        int[] iArr = new int[1];
        try {
            if (this.Y2.c(obj)) {
                if (c2 != null) {
                    this.X2.a(c2, c2.E(comparator(), obj, i2, iArr));
                    return iArr[0];
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    public /* bridge */ /* synthetic */ SortedMultiset J2(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.J2(obj, boundType, obj2, boundType2);
    }

    @CanIgnoreReturnValue
    public int Q(@ParametricNullness E e2, int i2) {
        CollectPreconditions.b(i2, "occurrences");
        if (i2 == 0) {
            return l1(e2);
        }
        Preconditions.d(this.Y2.c(e2));
        AvlNode c2 = this.X2.c();
        if (c2 == null) {
            comparator().compare(e2, e2);
            AvlNode avlNode = new AvlNode(e2, i2);
            AvlNode<E> avlNode2 = this.Z2;
            P(avlNode2, avlNode, avlNode2);
            this.X2.a(c2, avlNode);
            return 0;
        }
        int[] iArr = new int[1];
        this.X2.a(c2, c2.o(comparator(), e2, i2, iArr));
        return iArr[0];
    }

    public /* bridge */ /* synthetic */ SortedMultiset c0() {
        return super.c0();
    }

    public void clear() {
        if (this.Y2.j() || this.Y2.k()) {
            Iterators.h(h());
            return;
        }
        AvlNode<E> l2 = this.Z2.L();
        while (true) {
            AvlNode<E> avlNode = this.Z2;
            if (l2 != avlNode) {
                AvlNode<E> l3 = l2.L();
                int unused = l2.f22505b = 0;
                AvlNode unused2 = l2.f22509f = null;
                AvlNode unused3 = l2.f22510g = null;
                AvlNode unused4 = l2.f22511h = null;
                AvlNode unused5 = l2.f22512i = null;
                l2 = l3;
            } else {
                O(avlNode, avlNode);
                this.X2.b();
                return;
            }
        }
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return Ints.z(D(Aggregate.DISTINCT));
    }

    public /* bridge */ /* synthetic */ NavigableSet e() {
        return super.e();
    }

    public SortedMultiset<E> e1(@ParametricNullness E e2, BoundType boundType) {
        return new TreeMultiset(this.X2, this.Y2.l(GeneralRange.r(comparator(), e2, boundType)), this.Z2);
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> g() {
        return Multisets.h(h());
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> h() {
        return new Iterator<Multiset.Entry<E>>() {
            @CheckForNull
            Multiset.Entry<E> X;
            @CheckForNull
            AvlNode<E> s;

            {
                this.s = TreeMultiset.this.L();
            }

            /* renamed from: a */
            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    TreeMultiset treeMultiset = TreeMultiset.this;
                    AvlNode<E> avlNode = this.s;
                    Objects.requireNonNull(avlNode);
                    Multiset.Entry<E> q = treeMultiset.R(avlNode);
                    this.X = q;
                    this.s = this.s.L() == TreeMultiset.this.Z2 ? null : this.s.L();
                    return q;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.s == null) {
                    return false;
                }
                if (!TreeMultiset.this.Y2.p(this.s.x())) {
                    return true;
                }
                this.s = null;
                return false;
            }

            public void remove() {
                Preconditions.h0(this.X != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.r0(this.X.a(), 0);
                this.X = null;
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    public int l1(@CheckForNull Object obj) {
        try {
            AvlNode c2 = this.X2.c();
            if (this.Y2.c(obj)) {
                if (c2 != null) {
                    return c2.t(comparator(), obj);
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> m() {
        return new Iterator<Multiset.Entry<E>>() {
            @CheckForNull
            Multiset.Entry<E> X = null;
            @CheckForNull
            AvlNode<E> s;

            {
                this.s = TreeMultiset.this.M();
            }

            /* renamed from: a */
            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Objects.requireNonNull(this.s);
                    Multiset.Entry<E> q = TreeMultiset.this.R(this.s);
                    this.X = q;
                    this.s = this.s.z() == TreeMultiset.this.Z2 ? null : this.s.z();
                    return q;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.s == null) {
                    return false;
                }
                if (!TreeMultiset.this.Y2.q(this.s.x())) {
                    return true;
                }
                this.s = null;
                return false;
            }

            public void remove() {
                Preconditions.h0(this.X != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.r0(this.X.a(), 0);
                this.X = null;
            }
        };
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @CanIgnoreReturnValue
    public int r0(@ParametricNullness E e2, int i2) {
        CollectPreconditions.b(i2, "count");
        boolean z = true;
        if (!this.Y2.c(e2)) {
            if (i2 != 0) {
                z = false;
            }
            Preconditions.d(z);
            return 0;
        }
        AvlNode c2 = this.X2.c();
        if (c2 == null) {
            if (i2 > 0) {
                Q(e2, i2);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.X2.a(c2, c2.K(comparator(), e2, i2, iArr));
        return iArr[0];
    }

    public int size() {
        return Ints.z(D(Aggregate.SIZE));
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.Y2 = GeneralRange.a(comparator);
        AvlNode<E> avlNode = new AvlNode<>();
        this.Z2 = avlNode;
        O(avlNode, avlNode);
        this.X2 = new Reference<>();
    }
}
