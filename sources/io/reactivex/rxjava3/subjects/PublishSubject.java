package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {
    static final PublishDisposable[] Y = new PublishDisposable[0];
    static final PublishDisposable[] Z = new PublishDisposable[0];
    Throwable X;
    final AtomicReference<PublishDisposable<T>[]> s = new AtomicReference<>(Z);

    static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long Y = 3562861878281475070L;
        final PublishSubject<T> X;
        final Observer<? super T> s;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.s = observer;
            this.X = publishSubject;
        }

        public void a() {
            if (!get()) {
                this.s.onComplete();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }

        public void c(T t) {
            if (!get()) {
                this.s.onNext(t);
            }
        }

        public boolean g() {
            return get();
        }

        public void m() {
            if (compareAndSet(false, true)) {
                this.X.K8(this);
            }
        }
    }

    PublishSubject() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> PublishSubject<T> J8() {
        return new PublishSubject<>();
    }

    @CheckReturnValue
    @Nullable
    public Throwable D8() {
        if (this.s.get() == Y) {
            return this.X;
        }
        return null;
    }

    @CheckReturnValue
    public boolean E8() {
        return this.s.get() == Y && this.X == null;
    }

    @CheckReturnValue
    public boolean F8() {
        return ((PublishDisposable[]) this.s.get()).length != 0;
    }

    @CheckReturnValue
    public boolean G8() {
        return this.s.get() == Y && this.X != null;
    }

    /* access modifiers changed from: package-private */
    public boolean I8(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.s.get();
            if (publishDisposableArr == Y) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!g.a(this.s, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void K8(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.s.get();
            if (publishDisposableArr != Y && publishDisposableArr != Z) {
                int length = publishDisposableArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (publishDisposableArr[i2] == publishDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = Z;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i2);
                        System.arraycopy(publishDisposableArr, i2 + 1, publishDisposableArr3, i2, (length - i2) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.s, publishDisposableArr, publishDisposableArr2));
    }

    public void b(Disposable disposable) {
        if (this.s.get() == Y) {
            disposable.m();
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.b(publishDisposable);
        if (!I8(publishDisposable)) {
            Throwable th = this.X;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.g()) {
            K8(publishDisposable);
        }
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.s.get();
        PublishDisposable<T>[] publishDisposableArr2 = Y;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable a2 : (PublishDisposable[]) this.s.getAndSet(publishDisposableArr2)) {
                a2.a();
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        PublishDisposable<T>[] publishDisposableArr = this.s.get();
        PublishDisposable<T>[] publishDisposableArr2 = Y;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.X = th;
        for (PublishDisposable b2 : (PublishDisposable[]) this.s.getAndSet(publishDisposableArr2)) {
            b2.b(th);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        for (PublishDisposable c2 : (PublishDisposable[]) this.s.get()) {
            c2.c(t);
        }
    }
}
