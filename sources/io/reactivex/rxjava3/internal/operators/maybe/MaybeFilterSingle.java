package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {
    final Predicate<? super T> X;
    final SingleSource<T> s;

    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        final Predicate<? super T> X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.s = maybeObserver;
            this.X = predicate;
        }

        public void a(T t) {
            try {
                if (this.X.test(t)) {
                    this.s.a(t);
                } else {
                    this.s.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            Disposable disposable = this.Y;
            this.Y = DisposableHelper.DISPOSED;
            disposable.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.s = singleSource;
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.e(new FilterMaybeObserver(maybeObserver, this.X));
    }
}
