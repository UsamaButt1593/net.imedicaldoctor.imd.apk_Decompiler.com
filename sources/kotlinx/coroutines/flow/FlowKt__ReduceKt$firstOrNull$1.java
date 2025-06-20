package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
final class FlowKt__ReduceKt$firstOrNull$1<T> extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    int Z2;

    FlowKt__ReduceKt$firstOrNull$1(Continuation<? super FlowKt__ReduceKt$firstOrNull$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return FlowKt.v0((Flow) null, this);
    }
}
