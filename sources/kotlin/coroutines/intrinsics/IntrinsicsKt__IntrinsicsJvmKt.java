package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aC\u0010\u0005\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aB\u0010\u0007\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\\\u0010\f\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a[\u0010\u000e\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u001ap\u0010\u0012\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\u0000*)\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001ao\u0010\u0014\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u000f\"\u0004\b\u0002\u0010\u0000*)\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001aF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a_\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001c\b\u0004\u0010\u001c\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "f", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "g", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "P", "Lkotlin/Function3;", "param", "h", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "", "b", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "c", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "e", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "block", "a", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)Lkotlin/coroutines/Continuation;", "d", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
@SourceDebugExtension({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
class IntrinsicsKt__IntrinsicsJvmKt {
    @SinceKotlin(version = "1.3")
    private static final <T> Continuation<Unit> a(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        CoroutineContext g2 = continuation.g();
        return g2 == EmptyCoroutineContext.s ? new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(continuation, function1) : new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(continuation, g2, function1);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static <T> Continuation<Unit> b(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function1, "<this>");
        Intrinsics.p(continuation, "completion");
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).y(a2);
        }
        CoroutineContext g2 = a2.g();
        return g2 == EmptyCoroutineContext.s ? new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1(a2, function1) : new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2(a2, g2, function1);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static <R, T> Continuation<Unit> c(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function2, "<this>");
        Intrinsics.p(continuation, "completion");
        Continuation<? super T> a2 = DebugProbesKt.a(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).v(r, a2);
        }
        CoroutineContext g2 = a2.g();
        return g2 == EmptyCoroutineContext.s ? new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(a2, function2, r) : new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(a2, g2, function2, r);
    }

    private static final <T> Continuation<T> d(Continuation<? super T> continuation) {
        CoroutineContext g2 = continuation.g();
        return g2 == EmptyCoroutineContext.s ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(continuation) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(continuation, g2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static <T> Continuation<T> e(@NotNull Continuation<? super T> continuation) {
        Continuation<Object> J;
        Intrinsics.p(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (J = continuationImpl.J()) == null) ? continuation : J;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object f(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.p(function1, "<this>");
        Intrinsics.p(continuation, "completion");
        return !(function1 instanceof BaseContinuationImpl) ? i(function1, continuation) : ((Function1) TypeIntrinsics.q(function1, 1)).f(continuation);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object g(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.p(function2, "<this>");
        Intrinsics.p(continuation, "completion");
        return !(function2 instanceof BaseContinuationImpl) ? j(function2, r, continuation) : ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, continuation);
    }

    @InlineOnly
    private static final <R, P, T> Object h(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        Intrinsics.p(function3, "<this>");
        Intrinsics.p(continuation, "completion");
        return !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.k(function3, r, p, continuation) : ((Function3) TypeIntrinsics.q(function3, 3)).A(r, p, continuation);
    }

    @Nullable
    @PublishedApi
    public static final <T> Object i(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function1, "<this>");
        Intrinsics.p(continuation, "completion");
        return ((Function1) TypeIntrinsics.q(function1, 1)).f(d(DebugProbesKt.a(continuation)));
    }

    @Nullable
    @PublishedApi
    public static final <R, T> Object j(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function2, "<this>");
        Intrinsics.p(continuation, "completion");
        return ((Function2) TypeIntrinsics.q(function2, 2)).d0(r, d(DebugProbesKt.a(continuation)));
    }

    @Nullable
    @PublishedApi
    public static <R, P, T> Object k(@NotNull Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, @NotNull Continuation<? super T> continuation) {
        Intrinsics.p(function3, "<this>");
        Intrinsics.p(continuation, "completion");
        return ((Function3) TypeIntrinsics.q(function3, 3)).A(r, p, d(DebugProbesKt.a(continuation)));
    }
}
