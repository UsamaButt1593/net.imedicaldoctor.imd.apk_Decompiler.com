package io.reactivex.rxjava3.android;

import android.os.Looper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean s = new AtomicBoolean();

    public static void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final boolean g() {
        return this.s.get();
    }

    public final void m() {
        if (!this.s.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
        } else {
            AndroidSchedulers.e().f(new a(this));
        }
    }
}
