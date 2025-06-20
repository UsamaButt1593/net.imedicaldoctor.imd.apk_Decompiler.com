package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithSingle<T, U> extends Single<T> {
    final SingleSource<U> X;
    final SingleSource<T> s;

    static final class OtherObserver<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {
        private static final long Y = -8565274649390031272L;
        final SingleSource<T> X;
        final SingleObserver<? super T> s;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.s = singleObserver;
            this.X = singleSource;
        }

        public void a(U u) {
            this.X.e(new ResumeSingleObserver(this, this.s));
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.s = singleSource;
        this.X = singleSource2;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.X.e(new OtherObserver(singleObserver, this.s));
    }
}
