package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007\u001aT\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a@\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a[\u0010\u0014\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0016\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001aF\u0010\u001c\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00012\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\b¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "d", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "a", "b", "block", "e", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "f", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "g", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "h", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class UndispatchedKt {
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext g2;
        Object c2;
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            g2 = continuation.g();
            c2 = ThreadContextKt.c(g2, (Object) null);
            obj = ((Function1) TypeIntrinsics.q(function1, 1)).f(a2);
            ThreadContextKt.a(g2, c2);
            if (obj != IntrinsicsKt.l()) {
                Result.Companion companion = Result.X;
                a2.w(Result.b(obj));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = ResultKt.a(th);
        }
    }

    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext g2;
        Object c2;
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            g2 = continuation.g();
            c2 = ThreadContextKt.c(g2, (Object) null);
            obj = ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, a2);
            ThreadContextKt.a(g2, c2);
            if (obj != IntrinsicsKt.l()) {
                Result.Companion companion = Result.X;
                a2.w(Result.b(obj));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = ResultKt.a(th);
        }
    }

    public static final <T> void c(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object obj;
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            obj = ((Function1) TypeIntrinsics.q(function1, 1)).f(a2);
            if (obj != IntrinsicsKt.l()) {
                Result.Companion companion = Result.X;
                a2.w(Result.b(obj));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = ResultKt.a(th);
        }
    }

    public static final <R, T> void d(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Object obj;
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            obj = ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, a2);
            if (obj != IntrinsicsKt.l()) {
                Result.Companion companion = Result.X;
                a2.w(Result.b(obj));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = ResultKt.a(th);
        }
    }

    private static final <T> void e(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        try {
            Object f2 = function1.f(a2);
            if (f2 != IntrinsicsKt.l()) {
                Result.Companion companion = Result.X;
                a2.w(Result.b(f2));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            a2.w(Result.b(ResultKt.a(th)));
        }
    }

    @Nullable
    public static final <T, R> Object f(@NotNull ScopeCoroutine<? super T> scopeCoroutine, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Object f1;
        try {
            obj = ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, scopeCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == IntrinsicsKt.l() || (f1 = scopeCoroutine.f1(obj)) == JobSupportKt.f29208b) {
            return IntrinsicsKt.l();
        }
        if (!(f1 instanceof CompletedExceptionally)) {
            return JobSupportKt.o(f1);
        }
        throw ((CompletedExceptionally) f1).f29164a;
    }

    @Nullable
    public static final <T, R> Object g(@NotNull ScopeCoroutine<? super T> scopeCoroutine, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Object f1;
        try {
            obj = ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, scopeCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == IntrinsicsKt.l() || (f1 = scopeCoroutine.f1(obj)) == JobSupportKt.f29208b) {
            return IntrinsicsKt.l();
        }
        if (f1 instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) f1).f29164a;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).s != scopeCoroutine) {
                throw th2;
            } else if (obj instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) obj).f29164a;
            }
        } else {
            obj = JobSupportKt.o(f1);
        }
        return obj;
    }

    private static final <T> Object h(ScopeCoroutine<? super T> scopeCoroutine, Function1<? super Throwable, Boolean> function1, Function0<? extends Object> function0) {
        Object obj;
        try {
            obj = function0.o();
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj == IntrinsicsKt.l()) {
            return IntrinsicsKt.l();
        }
        Object f1 = scopeCoroutine.f1(obj);
        if (f1 == JobSupportKt.f29208b) {
            return IntrinsicsKt.l();
        }
        if (!(f1 instanceof CompletedExceptionally)) {
            return JobSupportKt.o(f1);
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) f1;
        if (function1.f(completedExceptionally.f29164a).booleanValue()) {
            throw completedExceptionally.f29164a;
        } else if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        } else {
            throw ((CompletedExceptionally) obj).f29164a;
        }
    }
}
