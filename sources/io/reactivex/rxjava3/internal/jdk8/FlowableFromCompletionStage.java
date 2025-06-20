package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import org.reactivestreams.Subscriber;

public final class FlowableFromCompletionStage<T> extends Flowable<T> {
    final CompletionStage<T> X;

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

    static final class CompletionStageHandler<T> extends DeferredScalarSubscription<T> implements BiConsumer<T, Throwable> {
        private static final long g3 = 4665335664328839859L;
        final BiConsumerAtomicReference<T> f3;

        CompletionStageHandler(Subscriber<? super T> subscriber, BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            super(subscriber);
            this.f3 = biConsumerAtomicReference;
        }

        public void cancel() {
            super.cancel();
            this.f3.set((Object) null);
        }

        /* renamed from: l */
        public void accept(T t, Throwable th) {
            Subscriber<? super T> subscriber;
            if (th != null) {
                subscriber = this.X;
            } else if (t != null) {
                f(t);
                return;
            } else {
                subscriber = this.X;
                th = new NullPointerException("The CompletionStage terminated with null.");
            }
            subscriber.onError(th);
        }
    }

    public FlowableFromCompletionStage(CompletionStage<T> completionStage) {
        this.X = completionStage;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        BiConsumerAtomicReference biConsumerAtomicReference = new BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(subscriber, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        subscriber.h(completionStageHandler);
        CompletionStage unused = this.X.whenComplete(biConsumerAtomicReference);
    }
}
