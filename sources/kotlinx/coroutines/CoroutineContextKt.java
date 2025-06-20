package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a:\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001fH\u0010¢\u0006\u0004\b \u0010!\"\u0014\u0010$\u001a\u00020\"8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010#\"\u001a\u0010'\u001a\u0004\u0018\u00010\"*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "e", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "addedContext", "d", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "", "c", "(Lkotlin/coroutines/CoroutineContext;)Z", "originalContext", "appendContext", "isNewCoroutine", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Z)Lkotlin/coroutines/CoroutineContext;", "T", "", "countOrElement", "Lkotlin/Function0;", "block", "i", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "continuation", "h", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "oldValue", "Lkotlinx/coroutines/UndispatchedCoroutine;", "g", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "f", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/UndispatchedCoroutine;", "", "Ljava/lang/String;", "DEBUG_THREAD_NAME_SEPARATOR", "b", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineContextKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final String f29167a = " @";

    private static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        boolean c2 = c(coroutineContext);
        boolean c3 = c(coroutineContext2);
        if (!c2 && !c3) {
            return coroutineContext.v(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.s = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.s;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.n(emptyCoroutineContext, new CoroutineContextKt$foldCopies$folded$1(objectRef, z));
        if (c3) {
            objectRef.s = ((CoroutineContext) objectRef.s).n(emptyCoroutineContext, CoroutineContextKt$foldCopies$1.X);
        }
        return coroutineContext3.v((CoroutineContext) objectRef.s);
    }

    @Nullable
    public static final String b(@NotNull CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.n(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.X)).booleanValue();
    }

    @NotNull
    @InternalCoroutinesApi
    public static final CoroutineContext d(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.v(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final CoroutineContext e(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        CoroutineContext a2 = a(coroutineScope.U(), coroutineContext, true);
        return (a2 == Dispatchers.a() || a2.e(ContinuationInterceptor.N2) != null) ? a2 : a2.v(Dispatchers.a());
    }

    @Nullable
    public static final UndispatchedCoroutine<?> f(@NotNull CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.j()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    @Nullable
    public static final UndispatchedCoroutine<?> g(@NotNull Continuation<?> continuation, @NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (!(continuation instanceof CoroutineStackFrame) || coroutineContext.e(UndispatchedMarker.s) == null) {
            return null;
        }
        UndispatchedCoroutine<?> f2 = f((CoroutineStackFrame) continuation);
        if (f2 != null) {
            f2.M1(coroutineContext, obj);
        }
        return f2;
    }

    public static final <T> T h(@NotNull Continuation<?> continuation, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        CoroutineContext g2 = continuation.g();
        Object c2 = ThreadContextKt.c(g2, obj);
        UndispatchedCoroutine<?> g3 = c2 != ThreadContextKt.f29399a ? g(continuation, g2, c2) : null;
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            if (g3 == null || g3.L1()) {
                ThreadContextKt.a(g2, c2);
            }
            InlineMarker.c(1);
        }
    }

    public static final <T> T i(@NotNull CoroutineContext coroutineContext, @Nullable Object obj, @NotNull Function0<? extends T> function0) {
        Object c2 = ThreadContextKt.c(coroutineContext, obj);
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            ThreadContextKt.a(coroutineContext, c2);
            InlineMarker.c(1);
        }
    }
}
