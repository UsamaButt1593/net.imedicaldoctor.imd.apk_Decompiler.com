package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

public final class ObservableFromCompletionStage<T> extends Observable<T> {
    final CompletionStage<T> s;

    static final class BiConsumerAtomicReference<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
        private static final long s = 45838553147237545L;

        BiConsumerAtomicReference() {
        }

        /* renamed from: a */
        public void accept(T t, Throwable th) {
            BiConsumer a2 = i.a(get());
            if (a2 != null) {
                a2.accept(t, th);
            }
        }
    }

    static final class CompletionStageHandler<T> extends DeferredScalarDisposable<T> implements BiConsumer<T, Throwable> {
        private static final long d3 = 4665335664328839859L;
        final BiConsumerAtomicReference<T> c3;

        CompletionStageHandler(Observer<? super T> observer, BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            super(observer);
            this.c3 = biConsumerAtomicReference;
        }

        /* renamed from: h */
        public void accept(T t, Throwable th) {
            Observer<? super T> observer;
            if (th != null) {
                observer = this.X;
            } else if (t != null) {
                d(t);
                return;
            } else {
                observer = this.X;
                th = new NullPointerException("The CompletionStage terminated with null.");
            }
            observer.onError(th);
        }

        public void m() {
            super.m();
            this.c3.set((Object) null);
        }
    }

    public ObservableFromCompletionStage(CompletionStage<T> completionStage) {
        this.s = completionStage;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        BiConsumerAtomicReference biConsumerAtomicReference = new BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(observer, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        observer.b(completionStageHandler);
        CompletionStage unused = this.s.whenComplete(biConsumerAtomicReference);
    }
}
