package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper {

    enum NoSuchElementSupplier implements Supplier<NoSuchElementException> {
        INSTANCE;

        /* renamed from: a */
        public NoSuchElementException get() {
            return new NoSuchElementException();
        }
    }

    enum ToFlowable implements Function<SingleSource, Publisher> {
        INSTANCE;

        /* renamed from: a */
        public Publisher apply(SingleSource singleSource) {
            return new SingleToFlowable(singleSource);
        }
    }

    static final class ToFlowableIterable<T> implements Iterable<Flowable<T>> {
        private final Iterable<? extends SingleSource<? extends T>> s;

        ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> iterable) {
            this.s = iterable;
        }

        public Iterator<Flowable<T>> iterator() {
            return new ToFlowableIterator(this.s.iterator());
        }
    }

    static final class ToFlowableIterator<T> implements Iterator<Flowable<T>> {
        private final Iterator<? extends SingleSource<? extends T>> s;

        ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> it2) {
            this.s = it2;
        }

        /* renamed from: a */
        public Flowable<T> next() {
            return new SingleToFlowable((SingleSource) this.s.next());
        }

        public boolean hasNext() {
            return this.s.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Supplier<NoSuchElementException> a() {
        return NoSuchElementSupplier.INSTANCE;
    }

    public static <T> Iterable<? extends Flowable<T>> b(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new ToFlowableIterable(iterable);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> c() {
        return ToFlowable.INSTANCE;
    }
}
