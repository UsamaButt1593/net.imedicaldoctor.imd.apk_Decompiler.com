package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bH@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0014*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001e\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u001b\u0010$\u001a\u00020 *\u00020\u00008F¢\u0006\f\u0012\u0004\b#\u0010\u001d\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "m", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;", "b", "()Lkotlinx/coroutines/CoroutineScope;", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "g", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "d", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;)V", "", "message", "", "c", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Throwable;)V", "j", "(Lkotlinx/coroutines/CoroutineScope;)V", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "k", "(Lkotlinx/coroutines/CoroutineScope;)Z", "l", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineScopeKt {
    @NotNull
    public static final CoroutineScope a(@NotNull CoroutineContext coroutineContext) {
        if (coroutineContext.e(Job.P2) == null) {
            coroutineContext = coroutineContext.v(JobKt__JobKt.c((Job) null, 1, (Object) null));
        }
        return new ContextScope(coroutineContext);
    }

    @NotNull
    public static final CoroutineScope b() {
        return new ContextScope(SupervisorKt.c((Job) null, 1, (Object) null).v(Dispatchers.e()));
    }

    public static final void c(@NotNull CoroutineScope coroutineScope, @NotNull String str, @Nullable Throwable th) {
        d(coroutineScope, ExceptionsKt.a(str, th));
    }

    public static final void d(@NotNull CoroutineScope coroutineScope, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineScope.U().e(Job.P2);
        if (job != null) {
            job.i(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void e(CoroutineScope coroutineScope, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c(coroutineScope, str, th);
    }

    public static /* synthetic */ void f(CoroutineScope coroutineScope, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        d(coroutineScope, cancellationException);
    }

    @Nullable
    public static final <R> Object g(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation.g(), continuation);
        Object f2 = UndispatchedKt.f(scopeCoroutine, scopeCoroutine, function2);
        if (f2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return f2;
    }

    @Nullable
    public static final Object h(@NotNull Continuation<? super CoroutineContext> continuation) {
        return continuation.g();
    }

    private static final Object i(Continuation<? super CoroutineContext> continuation) {
        InlineMarker.e(3);
        throw null;
    }

    public static final void j(@NotNull CoroutineScope coroutineScope) {
        JobKt.z(coroutineScope.U());
    }

    public static final boolean k(@NotNull CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.U().e(Job.P2);
        if (job != null) {
            return job.b();
        }
        return true;
    }

    public static /* synthetic */ void l(CoroutineScope coroutineScope) {
    }

    @NotNull
    public static final CoroutineScope m(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext) {
        return new ContextScope(coroutineScope.U().v(coroutineContext));
    }
}
