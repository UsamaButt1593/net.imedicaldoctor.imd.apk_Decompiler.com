package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
final class FlowKt__ReduceKt$reduce$1<S, T extends S> extends ContinuationImpl {
    /* synthetic */ Object X2;
    int Y2;
    Object Z;

    FlowKt__ReduceKt$reduce$1(Continuation<? super FlowKt__ReduceKt$reduce$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return FlowKt.s1((Flow) null, (Function3) null, this);
    }
}
