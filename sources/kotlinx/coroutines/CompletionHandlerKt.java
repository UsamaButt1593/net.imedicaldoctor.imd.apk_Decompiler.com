package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0007\u001a\u00020\u0005*#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\b¢\u0006\u0004\b\u0007\u0010\b\":\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\t8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\":\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\u00020\r8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "c", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CompletionHandlerBase;", "b", "(Lkotlinx/coroutines/CompletionHandlerBase;)Lkotlin/jvm/functions/Function1;", "asHandler", "Lkotlinx/coroutines/CancelHandlerBase;", "a", "(Lkotlinx/coroutines/CancelHandlerBase;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CompletionHandlerKt {
    @NotNull
    public static final Function1<Throwable, Unit> a(@NotNull CancelHandlerBase cancelHandlerBase) {
        return cancelHandlerBase;
    }

    @NotNull
    public static final Function1<Throwable, Unit> b(@NotNull CompletionHandlerBase completionHandlerBase) {
        return completionHandlerBase;
    }

    public static final void c(@NotNull Function1<? super Throwable, Unit> function1, @Nullable Throwable th) {
        function1.f(th);
    }
}
