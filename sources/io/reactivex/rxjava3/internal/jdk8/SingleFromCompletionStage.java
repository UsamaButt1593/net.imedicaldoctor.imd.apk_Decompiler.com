package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;

public final class SingleFromCompletionStage<T> extends Single<T> {
    final CompletionStage<T> s;

    static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {
        final FlowableFromCompletionStage.BiConsumerAtomicReference<T> X;
        final SingleObserver<? super T> s;

        CompletionStageHandler(SingleObserver<? super T> singleObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.s = singleObserver;
            this.X = biConsumerAtomicReference;
        }

        /* renamed from: a */
        public void accept(T t, Throwable th) {
            SingleObserver<? super T> singleObserver;
            if (th != null) {
                singleObserver = this.s;
            } else if (t != null) {
                this.s.a(t);
                return;
            } else {
                singleObserver = this.s;
                th = new NullPointerException("The CompletionStage terminated with null.");
            }
            singleObserver.onError(th);
        }

        public boolean g() {
            return this.X.get() == null;
        }

        public void m() {
            this.X.set((Object) null);
        }
    }

    public SingleFromCompletionStage(CompletionStage<T> completionStage) {
        this.s = completionStage;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(singleObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        singleObserver.b(completionStageHandler);
        CompletionStage unused = this.s.whenComplete(biConsumerAtomicReference);
    }
}
