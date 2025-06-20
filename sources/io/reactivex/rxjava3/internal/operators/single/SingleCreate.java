package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCreate<T> extends Single<T> {
    final SingleOnSubscribe<T> s;

    static final class Emitter<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {
        private static final long X = -2467358622224974244L;
        final SingleObserver<? super T> s;

        Emitter(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                if (t == null) {
                    try {
                        this.s.onError(ExceptionHelper.b("onSuccess called with a null value."));
                    } finally {
                        if (disposable != null) {
                            disposable.m();
                        }
                    }
                } else {
                    this.s.a(t);
                }
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public boolean c(Throwable th) {
            Disposable disposable;
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.s.onError(th);
            } finally {
                if (disposable != null) {
                    disposable.m();
                }
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void h(Cancellable cancellable) {
            b(new CancellableDisposable(cancellable));
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
        }
    }

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.s = singleOnSubscribe;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        Emitter emitter = new Emitter(singleObserver);
        singleObserver.b(emitter);
        try {
            this.s.a(emitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            emitter.onError(th);
        }
    }
}
