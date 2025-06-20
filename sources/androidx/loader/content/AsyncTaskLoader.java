package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final String p = "AsyncTaskLoader";
    static final boolean q = false;

    /* renamed from: j  reason: collision with root package name */
    private final Executor f8817j;

    /* renamed from: k  reason: collision with root package name */
    volatile AsyncTaskLoader<D>.LoadTask f8818k;

    /* renamed from: l  reason: collision with root package name */
    volatile AsyncTaskLoader<D>.LoadTask f8819l;

    /* renamed from: m  reason: collision with root package name */
    long f8820m;

    /* renamed from: n  reason: collision with root package name */
    long f8821n;
    Handler o;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch j3 = new CountDownLatch(1);
        boolean k3;

        LoadTask() {
        }

        /* access modifiers changed from: protected */
        public void m(D d2) {
            try {
                AsyncTaskLoader.this.E(this, d2);
            } finally {
                this.j3.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void n(D d2) {
            try {
                AsyncTaskLoader.this.F(this, d2);
            } finally {
                this.j3.countDown();
            }
        }

        public void run() {
            this.k3 = false;
            AsyncTaskLoader.this.G();
        }

        /* access modifiers changed from: protected */
        /* renamed from: u */
        public D b(Void... voidArr) {
            try {
                return AsyncTaskLoader.this.K();
            } catch (OperationCanceledException e2) {
                if (k()) {
                    return null;
                }
                throw e2;
            }
        }

        public void v() {
            try {
                this.j3.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.e3);
    }

    public void D() {
    }

    /* access modifiers changed from: package-private */
    public void E(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        J(d2);
        if (this.f8819l == loadTask) {
            x();
            this.f8821n = SystemClock.uptimeMillis();
            this.f8819l = null;
            e();
            G();
        }
    }

    /* access modifiers changed from: package-private */
    public void F(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        if (this.f8818k != loadTask) {
            E(loadTask, d2);
        } else if (k()) {
            J(d2);
        } else {
            c();
            this.f8821n = SystemClock.uptimeMillis();
            this.f8818k = null;
            f(d2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        if (this.f8819l == null && this.f8818k != null) {
            if (this.f8818k.k3) {
                this.f8818k.k3 = false;
                this.o.removeCallbacks(this.f8818k);
            }
            if (this.f8820m <= 0 || SystemClock.uptimeMillis() >= this.f8821n + this.f8820m) {
                this.f8818k.e(this.f8817j, (Params[]) null);
                return;
            }
            this.f8818k.k3 = true;
            this.o.postAtTime(this.f8818k, this.f8821n + this.f8820m);
        }
    }

    public boolean H() {
        return this.f8819l != null;
    }

    @Nullable
    public abstract D I();

    public void J(@Nullable D d2) {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public D K() {
        return I();
    }

    public void L(long j2) {
        this.f8820m = j2;
        if (j2 != 0) {
            this.o = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void M() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.f8818k;
        if (loadTask != null) {
            loadTask.v();
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f8818k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f8818k);
            printWriter.print(" waiting=");
            printWriter.println(this.f8818k.k3);
        }
        if (this.f8819l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f8819l);
            printWriter.print(" waiting=");
            printWriter.println(this.f8819l.k3);
        }
        if (this.f8820m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.c(this.f8820m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.b(this.f8821n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        if (this.f8818k == null) {
            return false;
        }
        if (!this.f8826e) {
            this.f8829h = true;
        }
        if (this.f8819l != null) {
            if (this.f8818k.k3) {
                this.f8818k.k3 = false;
                this.o.removeCallbacks(this.f8818k);
            }
            this.f8818k = null;
            return false;
        } else if (this.f8818k.k3) {
            this.f8818k.k3 = false;
            this.o.removeCallbacks(this.f8818k);
            this.f8818k = null;
            return false;
        } else {
            boolean a2 = this.f8818k.a(false);
            if (a2) {
                this.f8819l = this.f8818k;
                D();
            }
            this.f8818k = null;
            return a2;
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        super.q();
        b();
        this.f8818k = new LoadTask();
        G();
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.f8821n = -10000;
        this.f8817j = executor;
    }
}
