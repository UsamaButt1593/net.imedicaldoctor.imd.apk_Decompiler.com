package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00020\n2\u001a\b\u0004\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00030\fH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001aF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a@\u0010\u001b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001aY\u0010\u001d\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0016¢\u0006\u0002\b\u00172\u0006\u0010\u0018\u001a\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aB\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00030\fHHø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b \u0010!\"\u001b\u0010&\u001a\u00020\n8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "value", "", "f", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "", "exception", "g", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function1;", "Lkotlin/Result;", "resumeWith", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlin/coroutines/Continuation;", "", "completion", "b", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "c", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "h", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "i", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "block", "j", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "()Lkotlin/coroutines/CoroutineContext;", "e", "()V", "coroutineContext", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class ContinuationKt {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Continuation<T> a(CoroutineContext coroutineContext, Function1<? super Result<? extends T>, Unit> function1) {
        Intrinsics.p(coroutineContext, "context");
        Intrinsics.p(function1, "resumeWith");
        return new ContinuationKt$Continuation$1(coroutineContext, function1);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<Unit> b(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function1, "<this>");
        Intrinsics.p(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt.e(IntrinsicsKt.b(function1, continuation)), IntrinsicsKt.l());
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final <R, T> Continuation<Unit> c(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function2, "<this>");
        Intrinsics.p(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt.e(IntrinsicsKt.c(function2, r, continuation)), IntrinsicsKt.l());
    }

    private static final CoroutineContext d() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static /* synthetic */ void e() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void f(Continuation<? super T> continuation, T t) {
        Intrinsics.p(continuation, "<this>");
        Result.Companion companion = Result.X;
        continuation.w(Result.b(t));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void g(Continuation<? super T> continuation, Throwable th) {
        Intrinsics.p(continuation, "<this>");
        Intrinsics.p(th, "exception");
        Result.Companion companion = Result.X;
        continuation.w(Result.b(ResultKt.a(th)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void h(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function1, "<this>");
        Intrinsics.p(continuation, "completion");
        Continuation<Unit> e2 = IntrinsicsKt.e(IntrinsicsKt.b(function1, continuation));
        Result.Companion companion = Result.X;
        e2.w(Result.b(Unit.f28779a));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void i(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function2, "<this>");
        Intrinsics.p(continuation, "completion");
        Continuation<Unit> e2 = IntrinsicsKt.e(IntrinsicsKt.c(function2, r, continuation));
        Result.Companion companion = Result.X;
        e2.w(Result.b(Unit.f28779a));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object j(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.e(0);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.e(continuation));
        function1.f(safeContinuation);
        Object a2 = safeContinuation.a();
        if (a2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return a2;
    }
}
