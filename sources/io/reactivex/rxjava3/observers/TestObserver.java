package io.reactivex.rxjava3.observers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    private final Observer<? super T> b3;
    private final AtomicReference<Disposable> c3;

    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        public void b(Disposable disposable) {
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    @NonNull
    public static <T> TestObserver<T> I() {
        return new TestObserver<>();
    }

    @NonNull
    public static <T> TestObserver<T> J(@NonNull Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: H */
    public final TestObserver<T> q() {
        if (this.c3.get() != null) {
            return this;
        }
        throw D("Not subscribed!");
    }

    public final boolean K() {
        return this.c3.get() != null;
    }

    public void a(@NonNull T t) {
        onNext(t);
        onComplete();
    }

    public void b(@NonNull Disposable disposable) {
        this.X2 = Thread.currentThread();
        if (disposable == null) {
            this.Y.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!g.a(this.c3, (Object) null, disposable)) {
            disposable.m();
            if (this.c3.get() != DisposableHelper.DISPOSED) {
                List<Throwable> list = this.Y;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            this.b3.b(disposable);
        }
    }

    public final boolean g() {
        return DisposableHelper.b(this.c3.get());
    }

    public final void m() {
        DisposableHelper.a(this.c3);
    }

    public void onComplete() {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.c3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.X2 = Thread.currentThread();
            this.Z++;
            this.b3.onComplete();
        } finally {
            this.s.countDown();
        }
    }

    public void onError(@NonNull Throwable th) {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.c3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.X2 = Thread.currentThread();
            if (th == null) {
                this.Y.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.Y.add(th);
            }
            this.b3.onError(th);
            this.s.countDown();
        } catch (Throwable th2) {
            this.s.countDown();
            throw th2;
        }
    }

    public void onNext(@NonNull T t) {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.c3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.X2 = Thread.currentThread();
        this.X.add(t);
        if (t == null) {
            this.Y.add(new NullPointerException("onNext received a null value"));
        }
        this.b3.onNext(t);
    }

    public TestObserver(@NonNull Observer<? super T> observer) {
        this.c3 = new AtomicReference<>();
        this.b3 = observer;
    }
}
