package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Deprecated
@Beta
public abstract class TreeTraverser<T> {

    private final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> s;

        BreadthFirstIterator(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.s = arrayDeque;
            arrayDeque.add(t);
        }

        public boolean hasNext() {
            return !this.s.isEmpty();
        }

        public T next() {
            T remove = this.s.remove();
            Iterables.a(this.s, TreeTraverser.this.b(remove));
            return remove;
        }

        public T peek() {
            return this.s.element();
        }
    }

    private final class PostOrderIterator extends AbstractIterator<T> {
        private final ArrayDeque<PostOrderNode<T>> Y;

        PostOrderIterator(T t) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.Y = arrayDeque;
            arrayDeque.addLast(d(t));
        }

        private PostOrderNode<T> d(T t) {
            return new PostOrderNode<>(t, TreeTraverser.this.b(t).iterator());
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public T a() {
            while (!this.Y.isEmpty()) {
                PostOrderNode last = this.Y.getLast();
                if (last.f22516b.hasNext()) {
                    this.Y.addLast(d(last.f22516b.next()));
                } else {
                    this.Y.removeLast();
                    return last.f22515a;
                }
            }
            return b();
        }
    }

    private static final class PostOrderNode<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f22515a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<T> f22516b;

        PostOrderNode(T t, Iterator<T> it2) {
            this.f22515a = Preconditions.E(t);
            this.f22516b = (Iterator) Preconditions.E(it2);
        }
    }

    private final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final Deque<Iterator<T>> s;

        PreOrderIterator(T t) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.s = arrayDeque;
            arrayDeque.addLast(Iterators.Y(Preconditions.E(t)));
        }

        public boolean hasNext() {
            return !this.s.isEmpty();
        }

        public T next() {
            Iterator last = this.s.getLast();
            T E = Preconditions.E(last.next());
            if (!last.hasNext()) {
                this.s.removeLast();
            }
            Iterator it2 = TreeTraverser.this.b(E).iterator();
            if (it2.hasNext()) {
                this.s.addLast(it2);
            }
            return E;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> g(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.E(function);
        return new TreeTraverser<T>() {
            public Iterable<T> b(T t) {
                return (Iterable) Function.this.apply(t);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> a(final T t) {
        Preconditions.E(t);
        return new FluentIterable<T>() {
            /* renamed from: b0 */
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t);
            }
        };
    }

    public abstract Iterable<T> b(T t);

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<T> c(T t) {
        return new PostOrderIterator(t);
    }

    @Deprecated
    public final FluentIterable<T> d(final T t) {
        Preconditions.E(t);
        return new FluentIterable<T>() {
            /* renamed from: b0 */
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.c(t);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<T> e(T t) {
        return new PreOrderIterator(t);
    }

    @Deprecated
    public final FluentIterable<T> f(final T t) {
        Preconditions.E(t);
        return new FluentIterable<T>() {
            /* renamed from: b0 */
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.e(t);
            }
        };
    }
}
