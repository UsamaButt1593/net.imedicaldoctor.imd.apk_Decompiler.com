package io.reactivex.rxjava3.internal.disposables;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements Disposable {
    DISPOSED;

    public static boolean a(AtomicReference<Disposable> atomicReference) {
        Disposable andSet;
        Disposable disposable = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.m();
        return true;
    }

    public static boolean b(Disposable disposable) {
        return disposable == DISPOSED;
    }

    public static boolean c(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.m();
                return false;
            }
        } while (!g.a(atomicReference, disposable2, disposable));
        return true;
    }

    public static void e() {
        RxJavaPlugins.Y(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean f(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.m();
                return false;
            }
        } while (!g.a(atomicReference, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.m();
        return true;
    }

    public static boolean h(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Objects.requireNonNull(disposable, "d is null");
        if (g.a(atomicReference, (Object) null, disposable)) {
            return true;
        }
        disposable.m();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean i(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (g.a(atomicReference, (Object) null, disposable)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        disposable.m();
        return false;
    }

    public static boolean j(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.Y(new NullPointerException("next is null"));
            return false;
        } else if (disposable == null) {
            return true;
        } else {
            disposable2.m();
            e();
            return false;
        }
    }

    public boolean g() {
        return true;
    }

    public void m() {
    }
}
