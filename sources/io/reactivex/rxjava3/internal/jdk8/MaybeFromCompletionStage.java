package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;

public final class MaybeFromCompletionStage<T> extends Maybe<T> {
    final CompletionStage<T> s;

    static final class CompletionStageHandler<T> implements Disposable, BiConsumer<T, Throwable> {
        final FlowableFromCompletionStage.BiConsumerAtomicReference<T> X;
        final MaybeObserver<? super T> s;

        CompletionStageHandler(MaybeObserver<? super T> maybeObserver, FlowableFromCompletionStage.BiConsumerAtomicReference<T> biConsumerAtomicReference) {
            this.s = maybeObserver;
            this.X = biConsumerAtomicReference;
        }

        /* renamed from: a */
        public void accept(T t, Throwable th) {
            if (th != null) {
                this.s.onError(th);
            } else if (t != null) {
                this.s.a(t);
            } else {
                this.s.onComplete();
            }
        }

        public boolean g() {
            return this.X.get() == null;
        }

        public void m() {
            this.X.set((Object) null);
        }
    }

    public MaybeFromCompletionStage(CompletionStage<T> completionStage) {
        this.s = completionStage;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        FlowableFromCompletionStage.BiConsumerAtomicReference biConsumerAtomicReference = new FlowableFromCompletionStage.BiConsumerAtomicReference();
        CompletionStageHandler completionStageHandler = new CompletionStageHandler(maybeObserver, biConsumerAtomicReference);
        biConsumerAtomicReference.lazySet(completionStageHandler);
        maybeObserver.b(completionStageHandler);
        CompletionStage unused = this.s.whenComplete(biConsumerAtomicReference);
    }
}
