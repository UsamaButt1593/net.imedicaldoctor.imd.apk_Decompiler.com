package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001HHø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001HHø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"T", "Ljava/lang/ThreadLocal;", "value", "Lkotlinx/coroutines/ThreadContextElement;", "a", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "", "e", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ThreadContextElementKt {
    @NotNull
    public static final <T> ThreadContextElement<T> a(@NotNull ThreadLocal<T> threadLocal, T t) {
        return new ThreadLocalElement(t, threadLocal);
    }

    public static /* synthetic */ ThreadContextElement b(ThreadLocal threadLocal, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @Nullable
    public static final Object c(@NotNull ThreadLocal<?> threadLocal, @NotNull Continuation<? super Unit> continuation) {
        if (continuation.g().e(new ThreadLocalKey(threadLocal)) != null) {
            return Unit.f28779a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + continuation.g()).toString());
    }

    private static final Object d(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        InlineMarker.e(3);
        throw null;
    }

    @Nullable
    public static final Object e(@NotNull ThreadLocal<?> threadLocal, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.a(continuation.g().e(new ThreadLocalKey(threadLocal)) != null);
    }

    private static final Object f(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        InlineMarker.e(3);
        throw null;
    }
}
