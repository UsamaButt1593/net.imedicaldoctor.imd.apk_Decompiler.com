package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        Object f3571a;

        /* renamed from: b  reason: collision with root package name */
        SafeFuture<T> f3572b;

        /* renamed from: c  reason: collision with root package name */
        private ResolvableFuture<Void> f3573c = ResolvableFuture.w();

        /* renamed from: d  reason: collision with root package name */
        private boolean f3574d;

        Completer() {
        }

        private void e() {
            this.f3571a = null;
            this.f3572b = null;
            this.f3573c = null;
        }

        public void a(@NonNull Runnable runnable, @NonNull Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.f3573c;
            if (resolvableFuture != null) {
                resolvableFuture.a0(runnable, executor);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3571a = null;
            this.f3572b = null;
            this.f3573c.q(null);
        }

        public boolean c(T t) {
            boolean z = true;
            this.f3574d = true;
            SafeFuture<T> safeFuture = this.f3572b;
            if (safeFuture == null || !safeFuture.b(t)) {
                z = false;
            }
            if (z) {
                e();
            }
            return z;
        }

        public boolean d() {
            boolean z = true;
            this.f3574d = true;
            SafeFuture<T> safeFuture = this.f3572b;
            if (safeFuture == null || !safeFuture.a(true)) {
                z = false;
            }
            if (z) {
                e();
            }
            return z;
        }

        public boolean f(@NonNull Throwable th) {
            boolean z = true;
            this.f3574d = true;
            SafeFuture<T> safeFuture = this.f3572b;
            if (safeFuture == null || !safeFuture.c(th)) {
                z = false;
            }
            if (z) {
                e();
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.f3572b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f3571a));
            }
            if (!this.f3574d && (resolvableFuture = this.f3573c) != null) {
                resolvableFuture.q(null);
            }
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        @Nullable
        Object a(@NonNull Completer<T> completer) throws Exception;
    }

    private static final class SafeFuture<T> implements ListenableFuture<T> {
        private final AbstractResolvableFuture<T> X = new AbstractResolvableFuture<T>() {
            /* access modifiers changed from: protected */
            public String n() {
                Completer completer = SafeFuture.this.s.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f3571a + "]";
            }
        };
        final WeakReference<Completer<T>> s;

        SafeFuture(Completer<T> completer) {
            this.s = new WeakReference<>(completer);
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z) {
            return this.X.cancel(z);
        }

        public void a0(@NonNull Runnable runnable, @NonNull Executor executor) {
            this.X.a0(runnable, executor);
        }

        /* access modifiers changed from: package-private */
        public boolean b(T t) {
            return this.X.q(t);
        }

        /* access modifiers changed from: package-private */
        public boolean c(Throwable th) {
            return this.X.r(th);
        }

        public boolean cancel(boolean z) {
            Completer completer = this.s.get();
            boolean cancel = this.X.cancel(z);
            if (cancel && completer != null) {
                completer.b();
            }
            return cancel;
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.X.get();
        }

        public boolean isCancelled() {
            return this.X.isCancelled();
        }

        public boolean isDone() {
            return this.X.isDone();
        }

        public String toString() {
            return this.X.toString();
        }

        public T get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.X.get(j2, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    @NonNull
    public static <T> ListenableFuture<T> a(@NonNull Resolver<T> resolver) {
        Completer completer = new Completer();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.f3572b = safeFuture;
        completer.f3571a = resolver.getClass();
        try {
            Object a2 = resolver.a(completer);
            if (a2 != null) {
                completer.f3571a = a2;
            }
        } catch (Exception e2) {
            safeFuture.c(e2);
        }
        return safeFuture;
    }
}
