package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate extends Completable {
    final CompletableOnSubscribe s;

    static final class Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
        private static final long X = -2467358622224974244L;
        final CompletableObserver s;

        Emitter(CompletableObserver completableObserver) {
            this.s = completableObserver;
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

        public void onComplete() {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.s.onComplete();
                } finally {
                    if (disposable != null) {
                        disposable.m();
                    }
                }
            }
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

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.s = completableOnSubscribe;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        Emitter emitter = new Emitter(completableObserver);
        completableObserver.b(emitter);
        try {
            this.s.a(emitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            emitter.onError(th);
        }
    }
}
