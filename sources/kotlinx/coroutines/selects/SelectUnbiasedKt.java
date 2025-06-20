package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SelectUnbiasedKt {
    @Nullable
    public static final <R> Object a(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(continuation);
        try {
            function1.f(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.c(th);
        }
        Object d2 = unbiasedSelectBuilderImpl.d();
        if (d2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return d2;
    }

    private static final <R> Object b(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        InlineMarker.e(0);
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(continuation);
        try {
            function1.f(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.c(th);
        }
        Object d2 = unbiasedSelectBuilderImpl.d();
        if (d2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return d2;
    }
}
