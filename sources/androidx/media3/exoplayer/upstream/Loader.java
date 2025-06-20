package androidx.media3.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@UnstableApi
public final class Loader implements LoaderErrorThrower {

    /* renamed from: d  reason: collision with root package name */
    private static final String f12569d = "ExoPlayer:Loader:";

    /* renamed from: e  reason: collision with root package name */
    private static final int f12570e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12571f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12572g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final int f12573h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final LoadErrorAction f12574i = i(false, C.f9084b);

    /* renamed from: j  reason: collision with root package name */
    public static final LoadErrorAction f12575j = i(true, C.f9084b);

    /* renamed from: k  reason: collision with root package name */
    public static final LoadErrorAction f12576k = new LoadErrorAction(2, C.f9084b);

    /* renamed from: l  reason: collision with root package name */
    public static final LoadErrorAction f12577l = new LoadErrorAction(3, C.f9084b);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f12578a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public LoadTask<? extends Loadable> f12579b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public IOException f12580c;

    public interface Callback<T extends Loadable> {
        void N(T t, long j2, long j3);

        void Z(T t, long j2, long j3, boolean z);

        LoadErrorAction p(T t, long j2, long j3, IOException iOException, int i2);
    }

    public static final class LoadErrorAction {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f12581a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f12582b;

        private LoadErrorAction(int i2, long j2) {
            this.f12581a = i2;
            this.f12582b = j2;
        }

        public boolean c() {
            int i2 = this.f12581a;
            return i2 == 0 || i2 == 1;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final String d3 = "LoadTask";
        private static final int e3 = 0;
        private static final int f3 = 1;
        private static final int g3 = 2;
        private static final int h3 = 3;
        private final T X;
        @Nullable
        private IOException X2;
        private final long Y;
        private int Y2;
        @Nullable
        private Callback<T> Z;
        @Nullable
        private Thread Z2;
        private boolean a3;
        private volatile boolean b3;
        public final int s;

        public LoadTask(Looper looper, T t, Callback<T> callback, int i2, long j2) {
            super(looper);
            this.X = t;
            this.Z = callback;
            this.s = i2;
            this.Y = j2;
        }

        private void b() {
            this.X2 = null;
            Loader.this.f12578a.execute((Runnable) Assertions.g(Loader.this.f12579b));
        }

        private void c() {
            LoadTask unused = Loader.this.f12579b = null;
        }

        private long d() {
            return (long) Math.min((this.Y2 - 1) * 1000, 5000);
        }

        public void a(boolean z) {
            this.b3 = z;
            this.X2 = null;
            if (hasMessages(0)) {
                this.a3 = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    try {
                        this.a3 = true;
                        this.X.c();
                        Thread thread = this.Z2;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            if (z) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.g(this.Z)).Z(this.X, elapsedRealtime, elapsedRealtime - this.Y, true);
                this.Z = null;
            }
        }

        public void e(int i2) throws IOException {
            IOException iOException = this.X2;
            if (iOException != null && this.Y2 > i2) {
                throw iOException;
            }
        }

        public void f(long j2) {
            Assertions.i(Loader.this.f12579b == null);
            LoadTask unused = Loader.this.f12579b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                b();
            }
        }

        public void handleMessage(Message message) {
            if (!this.b3) {
                int i2 = message.what;
                if (i2 == 0) {
                    b();
                } else if (i2 != 3) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j2 = elapsedRealtime - this.Y;
                    Callback callback = (Callback) Assertions.g(this.Z);
                    if (this.a3) {
                        callback.Z(this.X, elapsedRealtime, j2, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 1) {
                        try {
                            callback.N(this.X, elapsedRealtime, j2);
                        } catch (RuntimeException e2) {
                            Log.e(d3, "Unexpected exception handling load completed", e2);
                            IOException unused = Loader.this.f12580c = new UnexpectedLoaderException(e2);
                        }
                    } else if (i3 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.X2 = iOException;
                        int i4 = this.Y2 + 1;
                        this.Y2 = i4;
                        LoadErrorAction p = callback.p(this.X, elapsedRealtime, j2, iOException, i4);
                        if (p.f12581a == 3) {
                            IOException unused2 = Loader.this.f12580c = this.X2;
                        } else if (p.f12581a != 2) {
                            if (p.f12581a == 1) {
                                this.Y2 = 1;
                            }
                            f(p.f12582b != C.f9084b ? p.f12582b : d());
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0081, code lost:
            r0.sendToTarget();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 2
                monitor-enter(r4)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                boolean r1 = r4.a3     // Catch:{ all -> 0x0056 }
                r2 = 1
                r1 = r1 ^ r2
                java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
                r4.Z2 = r3     // Catch:{ all -> 0x0056 }
                monitor-exit(r4)     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0043
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                r1.<init>()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                java.lang.String r3 = "load:"
                r1.append(r3)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                T r3 = r4.X     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                java.lang.Class r3 = r3.getClass()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                java.lang.String r3 = r3.getSimpleName()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                r1.append(r3)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                androidx.media3.common.util.TraceUtil.a(r1)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                T r1 = r4.X     // Catch:{ all -> 0x003e }
                r1.a()     // Catch:{ all -> 0x003e }
                androidx.media3.common.util.TraceUtil.c()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                goto L_0x0043
            L_0x0036:
                r0 = move-exception
                goto L_0x0059
            L_0x0038:
                r1 = move-exception
                goto L_0x006d
            L_0x003a:
                r1 = move-exception
                goto L_0x0085
            L_0x003c:
                r1 = move-exception
                goto L_0x0096
            L_0x003e:
                r1 = move-exception
                androidx.media3.common.util.TraceUtil.c()     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                throw r1     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
            L_0x0043:
                monitor-enter(r4)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                r1 = 0
                r4.Z2 = r1     // Catch:{ all -> 0x0053 }
                java.lang.Thread.interrupted()     // Catch:{ all -> 0x0053 }
                monitor-exit(r4)     // Catch:{ all -> 0x0053 }
                boolean r1 = r4.b3     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                if (r1 != 0) goto L_0x009f
                r4.sendEmptyMessage(r2)     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
                goto L_0x009f
            L_0x0053:
                r1 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0053 }
                throw r1     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
            L_0x0056:
                r1 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0056 }
                throw r1     // Catch:{ IOException -> 0x003c, Exception -> 0x003a, OutOfMemoryError -> 0x0038, Error -> 0x0036 }
            L_0x0059:
                boolean r1 = r4.b3
                if (r1 != 0) goto L_0x006c
                java.lang.String r1 = "LoadTask"
                java.lang.String r2 = "Unexpected error loading stream"
                androidx.media3.common.util.Log.e(r1, r2, r0)
                r1 = 3
                android.os.Message r1 = r4.obtainMessage(r1, r0)
                r1.sendToTarget()
            L_0x006c:
                throw r0
            L_0x006d:
                boolean r2 = r4.b3
                if (r2 != 0) goto L_0x009f
                java.lang.String r2 = "LoadTask"
                java.lang.String r3 = "OutOfMemory error loading stream"
                androidx.media3.common.util.Log.e(r2, r3, r1)
                androidx.media3.exoplayer.upstream.Loader$UnexpectedLoaderException r2 = new androidx.media3.exoplayer.upstream.Loader$UnexpectedLoaderException
                r2.<init>(r1)
            L_0x007d:
                android.os.Message r0 = r4.obtainMessage(r0, r2)
            L_0x0081:
                r0.sendToTarget()
                goto L_0x009f
            L_0x0085:
                boolean r2 = r4.b3
                if (r2 != 0) goto L_0x009f
                java.lang.String r2 = "LoadTask"
                java.lang.String r3 = "Unexpected exception loading stream"
                androidx.media3.common.util.Log.e(r2, r3, r1)
                androidx.media3.exoplayer.upstream.Loader$UnexpectedLoaderException r2 = new androidx.media3.exoplayer.upstream.Loader$UnexpectedLoaderException
                r2.<init>(r1)
                goto L_0x007d
            L_0x0096:
                boolean r2 = r4.b3
                if (r2 != 0) goto L_0x009f
                android.os.Message r0 = r4.obtainMessage(r0, r1)
                goto L_0x0081
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.Loader.LoadTask.run():void");
        }
    }

    public interface Loadable {
        void a() throws IOException;

        void c();
    }

    public interface ReleaseCallback {
        void i();
    }

    private static final class ReleaseTask implements Runnable {
        private final ReleaseCallback s;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.s = releaseCallback;
        }

        public void run() {
            this.s.i();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnexpectedLoaderException(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unexpected "
                r0.append(r1)
                java.lang.Class r1 = r4.getClass()
                java.lang.String r1 = r1.getSimpleName()
                r0.append(r1)
                java.lang.String r1 = r4.getMessage()
                if (r1 == 0) goto L_0x0031
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ": "
                r1.append(r2)
                java.lang.String r2 = r4.getMessage()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                goto L_0x0033
            L_0x0031:
                java.lang.String r1 = ""
            L_0x0033:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r3.<init>(r0, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.Loader.UnexpectedLoaderException.<init>(java.lang.Throwable):void");
        }
    }

    public Loader(String str) {
        this.f12578a = Util.J1(f12569d + str);
    }

    public static LoadErrorAction i(boolean z, long j2) {
        return new LoadErrorAction(z ? 1 : 0, j2);
    }

    public void a(int i2) throws IOException {
        IOException iOException = this.f12580c;
        if (iOException == null) {
            LoadTask<? extends Loadable> loadTask = this.f12579b;
            if (loadTask != null) {
                if (i2 == Integer.MIN_VALUE) {
                    i2 = loadTask.s;
                }
                loadTask.e(i2);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void b() throws IOException {
        a(Integer.MIN_VALUE);
    }

    public void g() {
        ((LoadTask) Assertions.k(this.f12579b)).a(false);
    }

    public void h() {
        this.f12580c = null;
    }

    public boolean j() {
        return this.f12580c != null;
    }

    public boolean k() {
        return this.f12579b != null;
    }

    public void l() {
        m((ReleaseCallback) null);
    }

    public void m(@Nullable ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.f12579b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        if (releaseCallback != null) {
            this.f12578a.execute(new ReleaseTask(releaseCallback));
        }
        this.f12578a.shutdown();
    }

    public <T extends Loadable> long n(T t, Callback<T> callback, int i2) {
        this.f12580c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask((Looper) Assertions.k(Looper.myLooper()), t, callback, i2, elapsedRealtime).f(0);
        return elapsedRealtime;
    }
}
