package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int Z2 = 1431655765;
    private static final int a3 = -1431655766;
    private static final int b3 = 11;
    private final MinMaxPriorityQueue<E>.Heap X;
    /* access modifiers changed from: private */
    public int X2;
    @VisibleForTesting
    final int Y;
    /* access modifiers changed from: private */
    public int Y2;
    /* access modifiers changed from: private */
    public Object[] Z;
    private final MinMaxPriorityQueue<E>.Heap s;

    public static final class Builder<B> {

        /* renamed from: d  reason: collision with root package name */
        private static final int f22452d = -1;

        /* renamed from: a  reason: collision with root package name */
        private final Comparator<B> f22453a;

        /* renamed from: b  reason: collision with root package name */
        private int f22454b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f22455c;

        private Builder(Comparator<B> comparator) {
            this.f22454b = -1;
            this.f22455c = Integer.MAX_VALUE;
            this.f22453a = (Comparator) Preconditions.E(comparator);
        }

        /* access modifiers changed from: private */
        public <T extends B> Ordering<T> g() {
            return Ordering.i(this.f22453a);
        }

        public <T extends B> MinMaxPriorityQueue<T> c() {
            return d(Collections.emptySet());
        }

        public <T extends B> MinMaxPriorityQueue<T> d(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.z(this.f22454b, this.f22455c, iterable));
            for (Object offer : iterable) {
                minMaxPriorityQueue.offer(offer);
            }
            return minMaxPriorityQueue;
        }

        @CanIgnoreReturnValue
        public Builder<B> e(int i2) {
            Preconditions.d(i2 >= 0);
            this.f22454b = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> f(int i2) {
            Preconditions.d(i2 > 0);
            this.f22455c = i2;
            return this;
        }
    }

    private class Heap {

        /* renamed from: a  reason: collision with root package name */
        final Ordering<E> f22456a;
        @Weak

        /* renamed from: b  reason: collision with root package name */
        MinMaxPriorityQueue<E>.Heap f22457b;

        Heap(Ordering<E> ordering) {
            this.f22456a = ordering;
        }

        private int k(int i2) {
            return m(m(i2));
        }

        private int l(int i2) {
            return (i2 * 2) + 1;
        }

        private int m(int i2) {
            return (i2 - 1) / 2;
        }

        private int n(int i2) {
            return (i2 * 2) + 2;
        }

        /* access modifiers changed from: private */
        public boolean q(int i2) {
            if (l(i2) < MinMaxPriorityQueue.this.X2 && d(i2, l(i2)) > 0) {
                return false;
            }
            if (n(i2) < MinMaxPriorityQueue.this.X2 && d(i2, n(i2)) > 0) {
                return false;
            }
            if (i2 <= 0 || d(i2, m(i2)) <= 0) {
                return i2 <= 2 || d(k(i2), i2) <= 0;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, E e2) {
            Heap heap;
            int f2 = f(i2, e2);
            if (f2 == i2) {
                f2 = i2;
                heap = this;
            } else {
                heap = this.f22457b;
            }
            heap.c(f2, e2);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public int c(int i2, E e2) {
            while (i2 > 2) {
                int k2 = k(i2);
                Object n2 = MinMaxPriorityQueue.this.n(k2);
                if (this.f22456a.compare(n2, e2) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.Z[i2] = n2;
                i2 = k2;
            }
            MinMaxPriorityQueue.this.Z[i2] = e2;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int d(int i2, int i3) {
            return this.f22456a.compare(MinMaxPriorityQueue.this.n(i2), MinMaxPriorityQueue.this.n(i3));
        }

        /* access modifiers changed from: package-private */
        public int e(int i2, E e2) {
            int i3 = i(i2);
            if (i3 <= 0 || this.f22456a.compare(MinMaxPriorityQueue.this.n(i3), e2) >= 0) {
                return f(i2, e2);
            }
            MinMaxPriorityQueue.this.Z[i2] = MinMaxPriorityQueue.this.n(i3);
            MinMaxPriorityQueue.this.Z[i3] = e2;
            return i3;
        }

        /* access modifiers changed from: package-private */
        public int f(int i2, E e2) {
            int n2;
            if (i2 == 0) {
                MinMaxPriorityQueue.this.Z[0] = e2;
                return 0;
            }
            int m2 = m(i2);
            Object n3 = MinMaxPriorityQueue.this.n(m2);
            if (!(m2 == 0 || (n2 = n(m(m2))) == m2 || l(n2) < MinMaxPriorityQueue.this.X2)) {
                Object n4 = MinMaxPriorityQueue.this.n(n2);
                if (this.f22456a.compare(n4, n3) < 0) {
                    m2 = n2;
                    n3 = n4;
                }
            }
            if (this.f22456a.compare(n3, e2) < 0) {
                MinMaxPriorityQueue.this.Z[i2] = n3;
                MinMaxPriorityQueue.this.Z[m2] = e2;
                return m2;
            }
            MinMaxPriorityQueue.this.Z[i2] = e2;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int g(int i2) {
            while (true) {
                int j2 = j(i2);
                if (j2 <= 0) {
                    return i2;
                }
                MinMaxPriorityQueue.this.Z[i2] = MinMaxPriorityQueue.this.n(j2);
                i2 = j2;
            }
        }

        /* access modifiers changed from: package-private */
        public int h(int i2, int i3) {
            if (i2 >= MinMaxPriorityQueue.this.X2) {
                return -1;
            }
            Preconditions.g0(i2 > 0);
            int min = Math.min(i2, MinMaxPriorityQueue.this.X2 - i3) + i3;
            for (int i4 = i2 + 1; i4 < min; i4++) {
                if (d(i4, i2) < 0) {
                    i2 = i4;
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int i(int i2) {
            return h(l(i2), 2);
        }

        /* access modifiers changed from: package-private */
        public int j(int i2) {
            int l2 = l(i2);
            if (l2 < 0) {
                return -1;
            }
            return h(l(l2), 4);
        }

        /* access modifiers changed from: package-private */
        public int o(E e2) {
            int n2;
            int m2 = m(MinMaxPriorityQueue.this.X2);
            if (!(m2 == 0 || (n2 = n(m(m2))) == m2 || l(n2) < MinMaxPriorityQueue.this.X2)) {
                Object n3 = MinMaxPriorityQueue.this.n(n2);
                if (this.f22456a.compare(n3, e2) < 0) {
                    MinMaxPriorityQueue.this.Z[n2] = e2;
                    MinMaxPriorityQueue.this.Z[MinMaxPriorityQueue.this.X2] = n3;
                    return n2;
                }
            }
            return MinMaxPriorityQueue.this.X2;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public MoveDesc<E> p(int i2, int i3, E e2) {
            int e3 = e(i3, e2);
            if (e3 == i3) {
                return null;
            }
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            Object n2 = e3 < i2 ? minMaxPriorityQueue.n(i2) : minMaxPriorityQueue.n(m(i2));
            if (this.f22457b.c(e3, e2) < i2) {
                return new MoveDesc<>(e2, n2);
            }
            return null;
        }
    }

    static class MoveDesc<E> {

        /* renamed from: a  reason: collision with root package name */
        final E f22459a;

        /* renamed from: b  reason: collision with root package name */
        final E f22460b;

        MoveDesc(E e2, E e3) {
            this.f22459a = e2;
            this.f22460b = e3;
        }
    }

    private class QueueIterator implements Iterator<E> {
        private int X;
        @CheckForNull
        private List<E> X2;
        private int Y;
        @CheckForNull
        private E Y2;
        @CheckForNull
        private Queue<E> Z;
        private boolean Z2;
        private int s;

        private QueueIterator() {
            this.s = -1;
            this.X = -1;
            this.Y = MinMaxPriorityQueue.this.Y2;
        }

        private void a() {
            if (MinMaxPriorityQueue.this.Y2 != this.Y) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean b(Iterable<E> iterable, E e2) {
            Iterator<E> it2 = iterable.iterator();
            while (it2.hasNext()) {
                if (it2.next() == e2) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        }

        private void c(int i2) {
            if (this.X < i2) {
                if (this.X2 != null) {
                    while (i2 < MinMaxPriorityQueue.this.size() && b(this.X2, MinMaxPriorityQueue.this.n(i2))) {
                        i2++;
                    }
                }
                this.X = i2;
            }
        }

        private boolean d(Object obj) {
            for (int i2 = 0; i2 < MinMaxPriorityQueue.this.X2; i2++) {
                if (MinMaxPriorityQueue.this.Z[i2] == obj) {
                    MinMaxPriorityQueue.this.H(i2);
                    return true;
                }
            }
            return false;
        }

        public boolean hasNext() {
            a();
            c(this.s + 1);
            if (this.X < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.Z;
            return queue != null && !queue.isEmpty();
        }

        public E next() {
            a();
            c(this.s + 1);
            if (this.X < MinMaxPriorityQueue.this.size()) {
                int i2 = this.X;
                this.s = i2;
                this.Z2 = true;
                return MinMaxPriorityQueue.this.n(i2);
            }
            if (this.Z != null) {
                this.s = MinMaxPriorityQueue.this.size();
                E poll = this.Z.poll();
                this.Y2 = poll;
                if (poll != null) {
                    this.Z2 = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        public void remove() {
            CollectPreconditions.e(this.Z2);
            a();
            this.Z2 = false;
            this.Y++;
            if (this.s < MinMaxPriorityQueue.this.size()) {
                MoveDesc H = MinMaxPriorityQueue.this.H(this.s);
                if (H != null) {
                    if (this.Z == null || this.X2 == null) {
                        this.Z = new ArrayDeque();
                        this.X2 = new ArrayList(3);
                    }
                    if (!b(this.X2, H.f22459a)) {
                        this.Z.add(H.f22459a);
                    }
                    if (!b(this.Z, H.f22460b)) {
                        this.X2.add(H.f22460b);
                    }
                }
                this.s--;
                this.X--;
                return;
            }
            E e2 = this.Y2;
            Objects.requireNonNull(e2);
            Preconditions.g0(d(e2));
            this.Y2 = null;
        }
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i2) {
        Ordering a2 = builder.g();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(a2);
        this.s = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(a2.E());
        this.X = heap2;
        heap.f22457b = heap2;
        heap2.f22457b = heap;
        this.Y = builder.f22455c;
        this.Z = new Object[i2];
    }

    @VisibleForTesting
    static boolean B(int i2) {
        int i3 = ~(~(i2 + 1));
        Preconditions.h0(i3 > 0, "negative index");
        return (Z2 & i3) > (i3 & a3);
    }

    public static Builder<Comparable> D(int i2) {
        return new Builder(Ordering.z()).f(i2);
    }

    public static <B> Builder<B> E(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E G(int i2) {
        E n2 = n(i2);
        H(i2);
        return n2;
    }

    private int g() {
        int length = this.Z.length;
        return h(length < 64 ? (length + 1) * 2 : IntMath.d(length / 2, 3), this.Y);
    }

    private static int h(int i2, int i3) {
        return Math.min(i2 - 1, i3) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> k() {
        return new Builder(Ordering.z()).c();
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> m(Iterable<? extends E> iterable) {
        return new Builder(Ordering.z()).d(iterable);
    }

    public static Builder<Comparable> o(int i2) {
        return new Builder(Ordering.z()).e(i2);
    }

    @CheckForNull
    private MoveDesc<E> q(int i2, E e2) {
        MinMaxPriorityQueue<E>.Heap x = x(i2);
        int g2 = x.g(i2);
        int c2 = x.c(g2, e2);
        if (c2 == g2) {
            return x.p(i2, g2, e2);
        }
        if (c2 < i2) {
            return new MoveDesc<>(e2, n(i2));
        }
        return null;
    }

    private int r() {
        int i2 = this.X2;
        if (i2 != 1) {
            return (i2 == 2 || this.X.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void t() {
        if (this.X2 > this.Z.length) {
            Object[] objArr = new Object[g()];
            Object[] objArr2 = this.Z;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.Z = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap x(int i2) {
        return B(i2) ? this.s : this.X;
    }

    @VisibleForTesting
    static int z(int i2, int i3, Iterable<?> iterable) {
        if (i2 == -1) {
            i2 = 11;
        }
        if (iterable instanceof Collection) {
            i2 = Math.max(i2, ((Collection) iterable).size());
        }
        return h(i2, i3);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean C() {
        for (int i2 = 1; i2 < this.X2; i2++) {
            if (!x(i2).q(i2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @VisibleForTesting
    @CheckForNull
    public MoveDesc<E> H(int i2) {
        MoveDesc<E> moveDesc;
        Preconditions.d0(i2, this.X2);
        this.Y2++;
        int i3 = this.X2 - 1;
        this.X2 = i3;
        if (i3 == i2) {
            this.Z[i3] = null;
            return null;
        }
        Object n2 = n(i3);
        int o = x(this.X2).o(n2);
        if (o == i2) {
            this.Z[this.X2] = null;
            return null;
        }
        Object n3 = n(this.X2);
        this.Z[this.X2] = null;
        MoveDesc<E> q = q(i2, n3);
        if (o >= i2) {
            return q;
        }
        if (q == null) {
            return moveDesc;
        }
        moveDesc = new MoveDesc<>(n2, q.f22460b);
        return moveDesc;
    }

    @CanIgnoreReturnValue
    public boolean add(E e2) {
        offer(e2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object offer : collection) {
            offer(offer);
            z = true;
        }
        return z;
    }

    public void clear() {
        for (int i2 = 0; i2 < this.X2; i2++) {
            this.Z[i2] = null;
        }
        this.X2 = 0;
    }

    public Comparator<? super E> comparator() {
        return this.s.f22456a;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int j() {
        return this.Z.length;
    }

    /* access modifiers changed from: package-private */
    public E n(int i2) {
        E e2 = this.Z[i2];
        Objects.requireNonNull(e2);
        return e2;
    }

    @CanIgnoreReturnValue
    public boolean offer(E e2) {
        Preconditions.E(e2);
        this.Y2++;
        int i2 = this.X2;
        this.X2 = i2 + 1;
        t();
        x(i2).b(i2, e2);
        return this.X2 <= this.Y || pollLast() != e2;
    }

    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return n(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return n(r());
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return G(0);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return G(r());
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return G(r());
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return this.X2;
    }

    @J2ktIncompatible
    public Object[] toArray() {
        int i2 = this.X2;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.Z, 0, objArr, 0, i2);
        return objArr;
    }
}
