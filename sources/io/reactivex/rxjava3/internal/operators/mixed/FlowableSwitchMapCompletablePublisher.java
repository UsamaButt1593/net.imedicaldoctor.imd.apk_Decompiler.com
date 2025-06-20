package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import org.reactivestreams.Publisher;

public final class FlowableSwitchMapCompletablePublisher<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> X;
    final boolean Y;
    final Publisher<T> s;

    public FlowableSwitchMapCompletablePublisher(Publisher<T> publisher, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.s = publisher;
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.e(new FlowableSwitchMapCompletable.SwitchMapCompletableObserver(completableObserver, this.X, this.Y));
    }
}
