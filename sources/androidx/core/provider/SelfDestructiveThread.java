package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {

    /* renamed from: i  reason: collision with root package name */
    private static final int f6135i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f6136j = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object f6137a = new Object();
    @GuardedBy("mLock")

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f6138b;
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private Handler f6139c;
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    private int f6140d;

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f6141e = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                SelfDestructiveThread.this.c();
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.d((Runnable) message.obj);
                return true;
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f6142f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6143g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6144h;

    public interface ReplyCallback<T> {
        void a(T t);
    }

    public SelfDestructiveThread(String str, int i2, int i3) {
        this.f6144h = str;
        this.f6143g = i2;
        this.f6142f = i3;
        this.f6140d = 0;
    }

    private void e(Runnable runnable) {
        synchronized (this.f6137a) {
            try {
                if (this.f6138b == null) {
                    HandlerThread handlerThread = new HandlerThread(this.f6144h, this.f6143g);
                    this.f6138b = handlerThread;
                    handlerThread.start();
                    this.f6139c = new Handler(this.f6138b.getLooper(), this.f6141e);
                    this.f6140d++;
                }
                this.f6139c.removeMessages(0);
                Handler handler = this.f6139c;
                handler.sendMessage(handler.obtainMessage(1, runnable));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public int a() {
        int i2;
        synchronized (this.f6137a) {
            i2 = this.f6140d;
        }
        return i2;
    }

    @VisibleForTesting
    public boolean b() {
        boolean z;
        synchronized (this.f6137a) {
            z = this.f6138b != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        synchronized (this.f6137a) {
            try {
                if (!this.f6139c.hasMessages(1)) {
                    this.f6138b.quit();
                    this.f6138b = null;
                    this.f6139c = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Runnable runnable) {
        runnable.run();
        synchronized (this.f6137a) {
            this.f6139c.removeMessages(0);
            Handler handler = this.f6139c;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.f6142f);
        }
    }

    public <T> void f(final Callable<T> callable, final ReplyCallback<T> replyCallback) {
        final Handler a2 = CalleeHandler.a();
        e(new Runnable() {
            public void run() {
                final Object obj;
                try {
                    obj = callable.call();
                } catch (Exception unused) {
                    obj = null;
                }
                a2.post(new Runnable() {
                    public void run() {
                        replyCallback.a(obj);
                    }
                });
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|(4:25|15|16|17)(1:18)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T g(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.provider.SelfDestructiveThread$3 r11 = new androidx.core.provider.SelfDestructiveThread$3
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r2, r3, r4, r5, r6)
            r12.e(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x0034 }
            if (r13 != 0) goto L_0x0036
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x0034 }
            r7.unlock()
            return r13
        L_0x0034:
            r13 = move-exception
            goto L_0x005e
        L_0x0036:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0034 }
            long r0 = (long) r14     // Catch:{ all -> 0x0034 }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x0034 }
        L_0x003d:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x0041 }
        L_0x0041:
            boolean r0 = r10.get()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x004f
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x0034 }
            r7.unlock()
            return r13
        L_0x004f:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0056
            goto L_0x003d
        L_0x0056:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x0034 }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x0034 }
            throw r13     // Catch:{ all -> 0x0034 }
        L_0x005e:
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.g(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
