package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0017\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "d", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "e", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "fatalCompletion", "c", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "Lkotlin/Function0;", "block", "b", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function0;)V", "a", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CancellableKt {
    private static final void a(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.X;
        continuation.w(Result.b(ResultKt.a(th)));
        throw th;
    }

    private static final void b(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.o();
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static final void c(@NotNull Continuation<? super Unit> continuation, @NotNull Continuation<?> continuation2) {
        try {
            Continuation<? super Unit> e2 = IntrinsicsKt.e(continuation);
            Result.Companion companion = Result.X;
            DispatchedContinuationKt.g(e2, Result.b(Unit.f28779a), (Function1) null, 2, (Object) null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    @InternalCoroutinesApi
    public static final <T> void d(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        try {
            Continuation<Unit> e2 = IntrinsicsKt.e(IntrinsicsKt.b(function1, continuation));
            Result.Companion companion = Result.X;
            DispatchedContinuationKt.g(e2, Result.b(Unit.f28779a), (Function1) null, 2, (Object) null);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static final <R, T> void e(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation, @Nullable Function1<? super Throwable, Unit> function1) {
        try {
            Continuation<Unit> e2 = IntrinsicsKt.e(IntrinsicsKt.c(function2, r, continuation));
            Result.Companion companion = Result.X;
            DispatchedContinuationKt.f(e2, Result.b(Unit.f28779a), function1);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void f(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        e(function2, obj, continuation, function1);
    }
}
