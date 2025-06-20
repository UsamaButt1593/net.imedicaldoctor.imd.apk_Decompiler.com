package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\f8\u0000X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r\"*\u0010\u0012\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011\"2\u0010\u0014\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011\"&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "", "a", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/jvm/functions/Function2;", "countAll", "Lkotlinx/coroutines/ThreadContextElement;", "findOne", "Lkotlinx/coroutines/internal/ThreadState;", "d", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ThreadContextKt {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29399a = new Symbol("NO_THREAD_ELEMENTS");
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.Element, Object> f29400b = ThreadContextKt$countAll$1.X;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> f29401c = ThreadContextKt$findOne$1.X;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> f29402d = ThreadContextKt$updateState$1.X;

    public static final void a(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj != f29399a) {
            if (obj instanceof ThreadState) {
                ((ThreadState) obj).b(coroutineContext);
                return;
            }
            Object n2 = coroutineContext.n(null, f29401c);
            if (n2 != null) {
                ((ThreadContextElement) n2).c0(coroutineContext, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    @NotNull
    public static final Object b(@NotNull CoroutineContext coroutineContext) {
        Object n2 = coroutineContext.n(0, f29400b);
        Intrinsics.m(n2);
        return n2;
    }

    @Nullable
    public static final Object c(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f29399a;
        }
        return obj instanceof Integer ? coroutineContext.n(new ThreadState(coroutineContext, ((Number) obj).intValue()), f29402d) : ((ThreadContextElement) obj).k0(coroutineContext);
    }
}
