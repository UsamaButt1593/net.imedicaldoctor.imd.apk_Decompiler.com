package androidx.core.os;

import androidx.annotation.Nullable;

@Deprecated
public final class CancellationSignal {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6052a;

    /* renamed from: b  reason: collision with root package name */
    private OnCancelListener f6053b;

    /* renamed from: c  reason: collision with root package name */
    private Object f6054c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6055d;

    public interface OnCancelListener {
        void onCancel();
    }

    private void f() {
        while (this.f6055d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        if (r0 == null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        if (r1 == null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        ((android.os.CancellationSignal) r1).cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.f6055d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002f, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.f6055d = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0035, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f6052a     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r0 = move-exception
            goto L_0x003a
        L_0x0009:
            r0 = 1
            r3.f6052a = r0     // Catch:{ all -> 0x0007 }
            r3.f6055d = r0     // Catch:{ all -> 0x0007 }
            androidx.core.os.CancellationSignal$OnCancelListener r0 = r3.f6053b     // Catch:{ all -> 0x0007 }
            java.lang.Object r1 = r3.f6054c     // Catch:{ all -> 0x0007 }
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            r2 = 0
            if (r0 == 0) goto L_0x001c
            r0.onCancel()     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r0 = move-exception
            goto L_0x0024
        L_0x001c:
            if (r1 == 0) goto L_0x002f
            android.os.CancellationSignal r1 = (android.os.CancellationSignal) r1     // Catch:{ all -> 0x001a }
            r1.cancel()     // Catch:{ all -> 0x001a }
            goto L_0x002f
        L_0x0024:
            monitor-enter(r3)
            r3.f6055d = r2     // Catch:{ all -> 0x002c }
            r3.notifyAll()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            throw r0
        L_0x002c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            throw r0
        L_0x002f:
            monitor-enter(r3)
            r3.f6055d = r2     // Catch:{ all -> 0x0037 }
            r3.notifyAll()     // Catch:{ all -> 0x0037 }
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return
        L_0x0037:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x003a:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.CancellationSignal.a():void");
    }

    @Nullable
    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.f6054c == null) {
                    android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                    this.f6054c = cancellationSignal;
                    if (this.f6052a) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.f6054c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.f6052a;
        }
        return z;
    }

    public void d(@Nullable OnCancelListener onCancelListener) {
        synchronized (this) {
            try {
                f();
                if (this.f6053b != onCancelListener) {
                    this.f6053b = onCancelListener;
                    if (this.f6052a) {
                        if (onCancelListener != null) {
                            onCancelListener.onCancel();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void e() {
        if (c()) {
            throw new OperationCanceledException();
        }
    }
}
