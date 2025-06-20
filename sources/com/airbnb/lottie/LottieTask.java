package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f16763e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    private final Set<LottieListener<T>> f16764a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<LottieListener<Throwable>> f16765b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f16766c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public volatile LottieResult<T> f16767d;

    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.l((LottieResult) get());
                } catch (InterruptedException | ExecutionException e2) {
                    LottieTask.this.l(new LottieResult(e2));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.f16765b);
        if (arrayList.isEmpty()) {
            Logger.f("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    private void h() {
        this.f16766c.post(new Runnable() {
            public void run() {
                if (LottieTask.this.f16767d != null) {
                    LottieResult a2 = LottieTask.this.f16767d;
                    if (a2.b() != null) {
                        LottieTask.this.i(a2.b());
                    } else {
                        LottieTask.this.g(a2.a());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void i(T t) {
        for (LottieListener onResult : new ArrayList(this.f16764a)) {
            onResult.onResult(t);
        }
    }

    /* access modifiers changed from: private */
    public void l(@Nullable LottieResult<T> lottieResult) {
        if (this.f16767d == null) {
            this.f16767d = lottieResult;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> e(LottieListener<Throwable> lottieListener) {
        try {
            if (!(this.f16767d == null || this.f16767d.a() == null)) {
                lottieListener.onResult(this.f16767d.a());
            }
            this.f16765b.add(lottieListener);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this;
    }

    public synchronized LottieTask<T> f(LottieListener<T> lottieListener) {
        try {
            if (!(this.f16767d == null || this.f16767d.b() == null)) {
                lottieListener.onResult(this.f16767d.b());
            }
            this.f16764a.add(lottieListener);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this;
    }

    public synchronized LottieTask<T> j(LottieListener<Throwable> lottieListener) {
        this.f16765b.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> k(LottieListener<T> lottieListener) {
        this.f16764a.remove(lottieListener);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.f16764a = new LinkedHashSet(1);
        this.f16765b = new LinkedHashSet(1);
        this.f16766c = new Handler(Looper.getMainLooper());
        this.f16767d = null;
        if (z) {
            try {
                l(callable.call());
            } catch (Throwable th) {
                l(new LottieResult(th));
            }
        } else {
            f16763e.execute(new LottieFutureTask(callable));
        }
    }
}
