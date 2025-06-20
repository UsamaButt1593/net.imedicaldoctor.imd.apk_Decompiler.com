package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001aD\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\b\u0004\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001HHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u000b\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "n", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "()Ljava/lang/Object;", "m", "()V", "COROUTINE_SUSPENDED", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
class IntrinsicsKt__IntrinsicsKt extends IntrinsicsKt__IntrinsicsJvmKt {
    @NotNull
    public static Object l() {
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void m() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object n(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        throw new NotImplementedError("Implementation of suspendCoroutineUninterceptedOrReturn is intrinsic");
    }
}
