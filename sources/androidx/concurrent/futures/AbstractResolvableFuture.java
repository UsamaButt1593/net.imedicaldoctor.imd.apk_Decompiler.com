package androidx.concurrent.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {
    private static final Logger X2;
    private static final long Y2 = 1000;
    static final boolean Z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    static final AtomicHelper Z2;
    private static final Object a3 = new Object();
    @Nullable
    volatile Listener X;
    @Nullable
    volatile Waiter Y;
    @Nullable
    volatile Object s;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void d(Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void e(Waiter waiter, Thread thread);
    }

    private static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f3553c;

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f3554d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f3555a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        final Throwable f3556b;

        static {
            if (AbstractResolvableFuture.Z) {
                f3554d = null;
                f3553c = null;
                return;
            }
            f3554d = new Cancellation(false, (Throwable) null);
            f3553c = new Cancellation(true, (Throwable) null);
        }

        Cancellation(boolean z, @Nullable Throwable th) {
            this.f3555a = z;
            this.f3556b = th;
        }
    }

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f3557b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f3558a;

        Failure(Throwable th) {
            this.f3558a = (Throwable) AbstractResolvableFuture.e(th);
        }
    }

    private static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f3559d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3560a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f3561b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        Listener f3562c;

        Listener(Runnable runnable, Executor executor) {
            this.f3560a = runnable;
            this.f3561b = executor;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f3563a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f3564b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> f3565c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> f3566d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f3567e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f3563a = atomicReferenceFieldUpdater;
            this.f3564b = atomicReferenceFieldUpdater2;
            this.f3565c = atomicReferenceFieldUpdater3;
            this.f3566d = atomicReferenceFieldUpdater4;
            this.f3567e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return a.a(this.f3566d, abstractResolvableFuture, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f3567e, abstractResolvableFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f3565c, abstractResolvableFuture, waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void d(Waiter waiter, Waiter waiter2) {
            this.f3564b.lazySet(waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void e(Waiter waiter, Thread thread) {
            this.f3563a.lazySet(waiter, thread);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> X;
        final AbstractResolvableFuture<V> s;

        SetFuture(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.s = abstractResolvableFuture;
            this.X = listenableFuture;
        }

        public void run() {
            if (this.s.s == this) {
                if (AbstractResolvableFuture.Z2.b(this.s, this, AbstractResolvableFuture.j(this.X))) {
                    AbstractResolvableFuture.g(this.s);
                }
            }
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.X != listener) {
                        return false;
                    }
                    abstractResolvableFuture.X = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.s != obj) {
                        return false;
                    }
                    abstractResolvableFuture.s = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.Y != waiter) {
                        return false;
                    }
                    abstractResolvableFuture.Y = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Waiter waiter, Waiter waiter2) {
            waiter.f3570b = waiter2;
        }

        /* access modifiers changed from: package-private */
        public void e(Waiter waiter, Thread thread) {
            waiter.f3569a = thread;
        }
    }

    private static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f3568c = new Waiter(false);
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f3569a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f3570b;

        Waiter() {
            AbstractResolvableFuture.Z2.e(this, Thread.currentThread());
        }

        /* access modifiers changed from: package-private */
        public void a(Waiter waiter) {
            AbstractResolvableFuture.Z2.d(this, waiter);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f3569a;
            if (thread != null) {
                this.f3569a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter(boolean z) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Waiter> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            Z = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            X2 = r2
            androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "Y"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Listener> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Listener.class
            java.lang.String r3 = "X"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "s"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper
            r2.<init>()
        L_0x004e:
            Z2 = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = X2
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            a3 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
    }

    protected AbstractResolvableFuture() {
    }

    private void a(StringBuilder sb) {
        String str = "]";
        try {
            Object k2 = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(u(k2));
            sb.append(str);
            return;
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    private static CancellationException c(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @NonNull
    static <T> T e(@Nullable T t) {
        t.getClass();
        return t;
    }

    private Listener f(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.X;
        } while (!Z2.a(this, listener2, Listener.f3559d));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.f3562c;
            listener5.f3562c = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    static void g(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.o();
            abstractResolvableFuture2.b();
            Listener f2 = abstractResolvableFuture2.f(listener);
            while (true) {
                if (f2 != null) {
                    listener = f2.f3562c;
                    Runnable runnable = f2.f3560a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = setFuture.s;
                        if (abstractResolvableFuture3.s == setFuture) {
                            if (Z2.b(abstractResolvableFuture3, setFuture, j(setFuture.X))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        h(runnable, f2.f3561b);
                    }
                    f2 = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = X2;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private V i(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw c("Task was cancelled.", ((Cancellation) obj).f3556b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f3558a);
        } else if (obj == a3) {
            return null;
        } else {
            return obj;
        }
    }

    static Object j(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).s;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (cancellation.f3555a) {
                return cancellation.f3556b != null ? new Cancellation(false, cancellation.f3556b) : Cancellation.f3554d;
            }
            return obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!Z) && isCancelled) {
            return Cancellation.f3554d;
        }
        try {
            Object k2 = k(listenableFuture);
            return k2 == null ? a3 : k2;
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new Cancellation(false, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static <V> V k(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void o() {
        Waiter waiter;
        do {
            waiter = this.Y;
        } while (!Z2.c(this, waiter, Waiter.f3568c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f3570b;
        }
    }

    private void p(Waiter waiter) {
        waiter.f3569a = null;
        while (true) {
            Waiter waiter2 = this.Y;
            if (waiter2 != Waiter.f3568c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f3570b;
                    if (waiter2.f3569a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f3570b = waiter4;
                        if (waiter3.f3569a == null) {
                        }
                    } else if (!Z2.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private String u(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void a0(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        Listener listener = this.X;
        if (listener != Listener.f3559d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f3562c = listener;
                if (!Z2.a(this, listener, listener2)) {
                    listener = this.X;
                } else {
                    return;
                }
            } while (listener != Listener.f3559d);
        }
        h(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.s
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = Z
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = new androidx.concurrent.futures.AbstractResolvableFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f3553c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f3554d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper r6 = Z2
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.l()
        L_0x0035:
            g(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$SetFuture r0 = (androidx.concurrent.futures.AbstractResolvableFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.X
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.s
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.s
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.s;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return i(obj2);
            }
            Waiter waiter = this.Y;
            if (waiter != Waiter.f3568c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (Z2.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.s;
                            } else {
                                p(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return i(obj);
                    }
                    waiter = this.Y;
                } while (waiter != Waiter.f3568c);
            }
            return i(this.s);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.s instanceof Cancellation;
    }

    public final boolean isDone() {
        Object obj = this.s;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: package-private */
    public final void m(@Nullable Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(v());
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String n() {
        Object obj = this.s;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + u(((SetFuture) obj).X) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean q(@Nullable V v) {
        if (v == null) {
            v = a3;
        }
        if (!Z2.b(this, (Object) null, v)) {
            return false;
        }
        g(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean r(Throwable th) {
        if (!Z2.b(this, (Object) null, new Failure((Throwable) e(th)))) {
            return false;
        }
        g(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean s(ListenableFuture<? extends V> listenableFuture) {
        SetFuture setFuture;
        Failure failure;
        e(listenableFuture);
        Object obj = this.s;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!Z2.b(this, (Object) null, j(listenableFuture))) {
                    return false;
                }
                g(this);
                return true;
            }
            setFuture = new SetFuture(this, listenableFuture);
            if (Z2.b(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.a0(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable unused) {
                    failure = Failure.f3557b;
                }
                return true;
            }
            obj = this.s;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f3555a);
        }
        return false;
        Z2.b(this, setFuture, failure);
        return true;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str = n();
                } catch (RuntimeException e2) {
                    str = "Exception thrown from implementation: " + e2.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean v() {
        Object obj = this.s;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f3555a;
    }

    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.s;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return i(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.Y;
                if (waiter != Waiter.f3568c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (Z2.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.s;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return i(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    p(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            p(waiter2);
                        } else {
                            waiter = this.Y;
                        }
                    } while (waiter != Waiter.f3568c);
                }
                return i(this.s);
            }
            while (nanos > 0) {
                Object obj3 = this.s;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return i(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j3 + StringUtils.SPACE + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + StringUtils.SPACE;
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }
}
