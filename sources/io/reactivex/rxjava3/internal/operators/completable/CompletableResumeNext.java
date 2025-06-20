package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> X;
    final CompletableSource s;

    static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long Z = 5018523762564524046L;
        final Function<? super Throwable, ? extends CompletableSource> X;
        boolean Y;
        final CompletableObserver s;

        ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.s = completableObserver;
            this.X = function;
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            if (this.Y) {
                this.s.onError(th);
                return;
            }
            this.Y = true;
            try {
                Object apply = this.X.apply(th);
                Objects.requireNonNull(apply, "The errorMapper returned a null CompletableSource");
                ((CompletableSource) apply).a(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.s = completableSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.X);
        completableObserver.b(resumeNextObserver);
        this.s.a(resumeNextObserver);
    }
}
