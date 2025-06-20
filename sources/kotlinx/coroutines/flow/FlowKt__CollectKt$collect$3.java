package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__CollectKt$collect$3 implements FlowCollector<T> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> s;

    public FlowKt__CollectKt$collect$3(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.s = function2;
    }

    @Nullable
    public Object a(T t, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.e(4);
        new FlowKt__CollectKt$collect$3$emit$1(this, continuation);
        InlineMarker.e(5);
        this.s.d0(t, continuation);
        return Unit.f28779a;
    }

    @Nullable
    public Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        Object d0 = this.s.d0(t, continuation);
        return d0 == IntrinsicsKt.l() ? d0 : Unit.f28779a;
    }
}
