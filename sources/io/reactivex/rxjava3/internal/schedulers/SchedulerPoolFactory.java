package io.reactivex.rxjava3.internal.schedulers;

import androidx.lifecycle.g;
import com.itextpdf.text.pdf.PdfBoolean;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {

    /* renamed from: a  reason: collision with root package name */
    static final String f28469a = "rx3.purge-enabled";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f28470b;

    /* renamed from: c  reason: collision with root package name */
    static final String f28471c = "rx3.purge-period-seconds";

    /* renamed from: d  reason: collision with root package name */
    public static final int f28472d;

    /* renamed from: e  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f28473e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f28474f = new ConcurrentHashMap();

    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        public void run() {
            Iterator it2 = new ArrayList(SchedulerPoolFactory.f28474f.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.f28474f.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class SystemPropertyAccessor implements Function<String, String> {
        SystemPropertyAccessor() {
        }

        /* renamed from: a */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        boolean b2 = b(true, f28469a, true, true, systemPropertyAccessor);
        f28470b = b2;
        f28472d = c(b2, f28471c, 1, 1, systemPropertyAccessor);
        e();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        f(f28470b, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z, String str, boolean z2, boolean z3, Function<String, String> function) {
        if (!z) {
            return z3;
        }
        try {
            String apply = function.apply(str);
            return apply == null ? z2 : PdfBoolean.l3.equals(apply);
        } catch (Throwable th) {
            Exceptions.b(th);
            return z2;
        }
    }

    static int c(boolean z, String str, int i2, int i3, Function<String, String> function) {
        if (!z) {
            return i3;
        }
        try {
            String apply = function.apply(str);
            return apply == null ? i2 : Integer.parseInt(apply);
        } catch (Throwable th) {
            Exceptions.b(th);
            return i2;
        }
    }

    public static void d() {
        ScheduledExecutorService andSet = f28473e.getAndSet((Object) null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        f28474f.clear();
    }

    public static void e() {
        g(f28470b);
    }

    static void f(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f28474f.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void g(boolean z) {
        if (z) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f28473e;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (g.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                        ScheduledTask scheduledTask = new ScheduledTask();
                        int i2 = f28472d;
                        newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
