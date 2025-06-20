package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    @CheckForNull
    ListenableFuture<? extends I> b3;
    @CheckForNull
    F c3;

    private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: R */
        public ListenableFuture<? extends O> P(AsyncFunction<? super I, ? extends O> asyncFunction, @ParametricNullness I i2) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i2);
            Preconditions.V(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: S */
        public void Q(ListenableFuture<? extends O> listenableFuture) {
            D(listenableFuture);
        }
    }

    private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        /* access modifiers changed from: package-private */
        public void Q(@ParametricNullness O o) {
            B(o);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        /* renamed from: R */
        public O P(Function<? super I, ? extends O> function, @ParametricNullness I i2) {
            return function.apply(i2);
        }
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f2) {
        this.b3 = (ListenableFuture) Preconditions.E(listenableFuture);
        this.c3 = Preconditions.E(f2);
    }

    static <I, O> ListenableFuture<O> N(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.E(function);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.a0(transformFuture, MoreExecutors.p(executor, transformFuture));
        return transformFuture;
    }

    static <I, O> ListenableFuture<O> O(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.E(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.a0(asyncTransformFuture, MoreExecutors.p(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    /* access modifiers changed from: package-private */
    @ForOverride
    @ParametricNullness
    public abstract T P(F f2, @ParametricNullness I i2) throws Exception;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void Q(@ParametricNullness T t);

    /* access modifiers changed from: protected */
    public final void m() {
        x(this.b3);
        this.b3 = null;
        this.c3 = null;
    }

    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.b3;
        F f2 = this.c3;
        boolean z = true;
        boolean isCancelled = isCancelled() | (listenableFuture == null);
        if (f2 != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.b3 = null;
            if (listenableFuture.isCancelled()) {
                D(listenableFuture);
                return;
            }
            try {
                try {
                    Object P = P(f2, Futures.j(listenableFuture));
                    this.c3 = null;
                    Q(P);
                } catch (Throwable th) {
                    this.c3 = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                C(e2.getCause());
            } catch (RuntimeException e3) {
                C(e3);
            } catch (Error e4) {
                C(e4);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.b3;
        F f2 = this.c3;
        String y = super.y();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f2 != null) {
            return str + "function=[" + f2 + "]";
        } else if (y == null) {
            return null;
        } else {
            return str + y;
        }
    }
}
