package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;

public final class CompletableFromCompletionStage<T> extends Completable {
    final CompletionStage<T> s;

    static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {
        final FlowableFromCompletionStage.BiConsumerAtomicReference<T> X;
        final CompletableObserver s;

        CompletionStageHandler(CompletableObserver completableObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.s = completableObserver;
            this.X = biConsumerAtomicReference;
        }

        /* renamed from: a */
        public void accept(T t, Throwable th) {
            CompletableObserver completableObserver = this.s;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }

        public boolean g() {
            return this.X.get() == null;
        }

        public void m() {
            this.X.set((Object) null);
        }
    }

    public CompletableFromCompletionStage(CompletionStage<T> completionStage) {
        this.s = completionStage;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(completableObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        completableObserver.b(completionStageHandler);
        CompletionStage unused = this.s.whenComplete(biConsumerAtomicReference);
    }
}
