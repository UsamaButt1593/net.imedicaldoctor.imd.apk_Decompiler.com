package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource X;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long Z2 = -4592979584110982903L;
        final AtomicReference<Disposable> X = new AtomicReference<>();
        volatile boolean X2;
        final OtherObserver Y = new OtherObserver(this);
        volatile boolean Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        final Observer<? super T> s;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = -2935427570954647017L;
            final MergeWithObserver<?> s;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.s = mergeWithObserver;
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.a();
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.Y2 = true;
            if (this.X2) {
                HalfSerializer.a(this.s, this, this.Z);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            DisposableHelper.a(this.X);
            HalfSerializer.c(this.s, th, this, this.Z);
        }

        public boolean g() {
            return DisposableHelper.b(this.X.get());
        }

        public void m() {
            DisposableHelper.a(this.X);
            DisposableHelper.a(this.Y);
            this.Z.e();
        }

        public void onComplete() {
            this.X2 = true;
            if (this.Y2) {
                HalfSerializer.a(this.s, this, this.Z);
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Y);
            HalfSerializer.c(this.s, th, this, this.Z);
        }

        public void onNext(T t) {
            HalfSerializer.e(this.s, t, this, this.Z);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.X = completableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.b(mergeWithObserver);
        this.s.a(mergeWithObserver);
        this.X.a(mergeWithObserver.Y);
    }
}
