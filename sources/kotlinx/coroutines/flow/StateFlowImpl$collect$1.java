package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {386, 398, 403}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class StateFlowImpl$collect$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    /* synthetic */ Object b3;
    final /* synthetic */ StateFlowImpl<T> c3;
    int d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, Continuation<? super StateFlowImpl$collect$1> continuation) {
        super(continuation);
        this.c3 = stateFlowImpl;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.b3 = obj;
        this.d3 |= Integer.MIN_VALUE;
        return this.c3.a((FlowCollector) null, this);
    }
}
