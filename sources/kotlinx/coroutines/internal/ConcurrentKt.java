package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002\"\u0004\b\u0000\u0010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00060\u0006j\u0002`\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\b¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\r\u001a\u00020\fH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018*\f\b\u0000\u0010\u001a\"\u00020\u00062\u00020\u0006¨\u0006\u001b"}, d2 = {"E", "", "Lkotlinx/coroutines/internal/SubscribersList;", "d", "()Ljava/util/List;", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Lkotlin/Function0;", "action", "e", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "expectedSize", "", "b", "(I)Ljava/util/Set;", "Ljava/util/concurrent/Executor;", "executor", "", "c", "(Ljava/util/concurrent/Executor;)Z", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "ReentrantLock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ConcurrentKt {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static final Method f29336a;

    static {
        Method method;
        Class<ScheduledThreadPoolExecutor> cls = ScheduledThreadPoolExecutor.class;
        try {
            method = cls.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});
        } catch (Throwable unused) {
            method = null;
        }
        f29336a = method;
    }

    public static /* synthetic */ void a() {
    }

    @NotNull
    public static final <E> Set<E> b(int i2) {
        return Collections.newSetFromMap(new IdentityHashMap(i2));
    }

    public static final boolean c(@NotNull Executor executor) {
        Method method;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor == null || (method = f29336a) == null) {
                return false;
            }
            method.invoke(scheduledThreadPoolExecutor, new Object[]{Boolean.TRUE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @NotNull
    public static final <E> List<E> d() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T e(@NotNull ReentrantLock reentrantLock, @NotNull Function0<? extends T> function0) {
        reentrantLock.lock();
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            reentrantLock.unlock();
            InlineMarker.c(1);
        }
    }
}
