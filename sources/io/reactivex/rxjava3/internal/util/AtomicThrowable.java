package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long s = 3949248817947090603L;

    public boolean a() {
        return get() == ExceptionHelper.f28479a;
    }

    public Throwable b() {
        return ExceptionHelper.f(this);
    }

    public boolean c(Throwable th) {
        return ExceptionHelper.a(this, th);
    }

    public boolean d(Throwable th) {
        if (c(th)) {
            return true;
        }
        RxJavaPlugins.Y(th);
        return false;
    }

    public void e() {
        Throwable b2 = b();
        if (b2 != null && b2 != ExceptionHelper.f28479a) {
            RxJavaPlugins.Y(b2);
        }
    }

    public void f(CompletableObserver completableObserver) {
        Throwable b2 = b();
        if (b2 == null) {
            completableObserver.onComplete();
        } else if (b2 != ExceptionHelper.f28479a) {
            completableObserver.onError(b2);
        }
    }

    public void g(Emitter<?> emitter) {
        Throwable b2 = b();
        if (b2 == null) {
            emitter.onComplete();
        } else if (b2 != ExceptionHelper.f28479a) {
            emitter.onError(b2);
        }
    }

    public void h(MaybeObserver<?> maybeObserver) {
        Throwable b2 = b();
        if (b2 == null) {
            maybeObserver.onComplete();
        } else if (b2 != ExceptionHelper.f28479a) {
            maybeObserver.onError(b2);
        }
    }

    public void i(Observer<?> observer) {
        Throwable b2 = b();
        if (b2 == null) {
            observer.onComplete();
        } else if (b2 != ExceptionHelper.f28479a) {
            observer.onError(b2);
        }
    }

    public void j(SingleObserver<?> singleObserver) {
        Throwable b2 = b();
        if (b2 != null && b2 != ExceptionHelper.f28479a) {
            singleObserver.onError(b2);
        }
    }

    public void k(Subscriber<?> subscriber) {
        Throwable b2 = b();
        if (b2 == null) {
            subscriber.onComplete();
        } else if (b2 != ExceptionHelper.f28479a) {
            subscriber.onError(b2);
        }
    }
}
