package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public abstract class AsyncZipTask<T> {

    /* renamed from: a  reason: collision with root package name */
    private ProgressMonitor f30677a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30678b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f30679c;

    public static class AsyncTaskParameters {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ProgressMonitor f30680a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f30681b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ExecutorService f30682c;

        public AsyncTaskParameters(ExecutorService executorService, boolean z, ProgressMonitor progressMonitor) {
            this.f30682c = executorService;
            this.f30681b = z;
            this.f30680a = progressMonitor;
        }
    }

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.f30677a = asyncTaskParameters.f30680a;
        this.f30678b = asyncTaskParameters.f30681b;
        this.f30679c = asyncTaskParameters.f30682c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Object obj) {
        try {
            g(obj, this.f30677a);
        } catch (ZipException unused) {
        } catch (Throwable th) {
            this.f30679c.shutdown();
            throw th;
        }
        this.f30679c.shutdown();
    }

    private void g(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            d(t, progressMonitor);
            progressMonitor.a();
        } catch (ZipException e2) {
            progressMonitor.b(e2);
            throw e2;
        } catch (Exception e3) {
            progressMonitor.b(e3);
            throw new ZipException(e3);
        }
    }

    /* access modifiers changed from: protected */
    public abstract long b(T t) throws ZipException;

    public void c(T t) throws ZipException {
        this.f30677a.c();
        this.f30677a.v(ProgressMonitor.State.BUSY);
        this.f30677a.p(e());
        if (this.f30678b) {
            this.f30677a.w(b(t));
            this.f30679c.execute(new c(this, t));
            return;
        }
        g(t, this.f30677a);
    }

    /* access modifiers changed from: protected */
    public abstract void d(T t, ProgressMonitor progressMonitor) throws IOException;

    /* access modifiers changed from: protected */
    public abstract ProgressMonitor.Task e();

    /* access modifiers changed from: protected */
    public void h() throws ZipException {
        if (this.f30677a.l()) {
            this.f30677a.u(ProgressMonitor.Result.CANCELLED);
            this.f30677a.v(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }
}
