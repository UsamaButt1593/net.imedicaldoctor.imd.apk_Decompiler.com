package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
public abstract class Traverser<N> {

    /* renamed from: a  reason: collision with root package name */
    private final SuccessorsFunction<N> f22645a;

    private enum InsertionOrder {
        FRONT {
            /* access modifiers changed from: package-private */
            public <T> void b(Deque<T> deque, T t) {
                deque.addFirst(t);
            }
        },
        BACK {
            /* access modifiers changed from: package-private */
            public <T> void b(Deque<T> deque, T t) {
                deque.addLast(t);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract <T> void b(Deque<T> deque, T t);
    }

    private static abstract class Traversal<N> {

        /* renamed from: a  reason: collision with root package name */
        final SuccessorsFunction<N> f22648a;

        Traversal(SuccessorsFunction<N> successorsFunction) {
            this.f22648a = successorsFunction;
        }

        static <N> Traversal<N> b(SuccessorsFunction<N> successorsFunction) {
            final HashSet hashSet = new HashSet();
            return new Traversal<N>(successorsFunction) {
                /* access modifiers changed from: package-private */
                @CheckForNull
                public N g(Deque<Iterator<? extends N>> deque) {
                    Iterator first = deque.getFirst();
                    while (first.hasNext()) {
                        N next = first.next();
                        Objects.requireNonNull(next);
                        if (hashSet.add(next)) {
                            return next;
                        }
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        static <N> Traversal<N> c(SuccessorsFunction<N> successorsFunction) {
            return new Traversal<N>(successorsFunction) {
                /* access modifiers changed from: package-private */
                @CheckForNull
                public N g(Deque<Iterator<? extends N>> deque) {
                    Iterator first = deque.getFirst();
                    if (first.hasNext()) {
                        return Preconditions.E(first.next());
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        private Iterator<N> f(Iterator<? extends N> it2, final InsertionOrder insertionOrder) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it2);
            return new AbstractIterator<N>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                public N a() {
                    do {
                        N g2 = Traversal.this.g(arrayDeque);
                        if (g2 != null) {
                            Iterator<? extends N> it2 = Traversal.this.f22648a.b(g2).iterator();
                            if (it2.hasNext()) {
                                insertionOrder.b(arrayDeque, it2);
                            }
                            return g2;
                        }
                    } while (!arrayDeque.isEmpty());
                    return b();
                }
            };
        }

        /* access modifiers changed from: package-private */
        public final Iterator<N> a(Iterator<? extends N> it2) {
            return f(it2, InsertionOrder.BACK);
        }

        /* access modifiers changed from: package-private */
        public final Iterator<N> d(Iterator<? extends N> it2) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            final ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it2);
            return new AbstractIterator<N>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                public N a() {
                    while (true) {
                        N g2 = Traversal.this.g(arrayDeque2);
                        if (g2 == null) {
                            return !arrayDeque.isEmpty() ? arrayDeque.pop() : b();
                        }
                        Iterator<? extends N> it2 = Traversal.this.f22648a.b(g2).iterator();
                        if (!it2.hasNext()) {
                            return g2;
                        }
                        arrayDeque2.addFirst(it2);
                        arrayDeque.push(g2);
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        public final Iterator<N> e(Iterator<? extends N> it2) {
            return f(it2, InsertionOrder.FRONT);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public abstract N g(Deque<Iterator<? extends N>> deque);
    }

    private Traverser(SuccessorsFunction<N> successorsFunction) {
        this.f22645a = (SuccessorsFunction) Preconditions.E(successorsFunction);
    }

    public static <N> Traverser<N> g(final SuccessorsFunction<N> successorsFunction) {
        return new Traverser<N>(successorsFunction) {
            /* access modifiers changed from: package-private */
            public Traversal<N> i() {
                return Traversal.b(successorsFunction);
            }
        };
    }

    public static <N> Traverser<N> h(final SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.e(((BaseGraph) successorsFunction).f(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.e(((Network) successorsFunction).f(), "Undirected networks can never be trees.");
        }
        return new Traverser<N>(successorsFunction) {
            /* access modifiers changed from: package-private */
            public Traversal<N> i() {
                return Traversal.c(successorsFunction);
            }
        };
    }

    private ImmutableSet<N> j(Iterable<? extends N> iterable) {
        ImmutableSet<N> B = ImmutableSet.B(iterable);
        UnmodifiableIterator<N> k2 = B.iterator();
        while (k2.hasNext()) {
            this.f22645a.b(k2.next());
        }
        return B;
    }

    public final Iterable<N> a(Iterable<? extends N> iterable) {
        final ImmutableSet<N> j2 = j(iterable);
        return new Iterable<N>() {
            public Iterator<N> iterator() {
                return Traverser.this.i().a(j2.iterator());
            }
        };
    }

    public final Iterable<N> b(N n2) {
        return a(ImmutableSet.L(n2));
    }

    public final Iterable<N> c(Iterable<? extends N> iterable) {
        final ImmutableSet<N> j2 = j(iterable);
        return new Iterable<N>() {
            public Iterator<N> iterator() {
                return Traverser.this.i().d(j2.iterator());
            }
        };
    }

    public final Iterable<N> d(N n2) {
        return c(ImmutableSet.L(n2));
    }

    public final Iterable<N> e(Iterable<? extends N> iterable) {
        final ImmutableSet<N> j2 = j(iterable);
        return new Iterable<N>() {
            public Iterator<N> iterator() {
                return Traverser.this.i().e(j2.iterator());
            }
        };
    }

    public final Iterable<N> f(N n2) {
        return e(ImmutableSet.L(n2));
    }

    /* access modifiers changed from: package-private */
    public abstract Traversal<N> i();
}
