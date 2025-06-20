package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", i = {0}, l = {103, 104}, m = "emit", n = {"this"}, s = {"L$0"})
final class FlowKt__TransformKt$runningFold$1$1$emit$1 extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ FlowKt__TransformKt$runningFold$1$1<T> Z2;
    int a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__TransformKt$runningFold$1$1$emit$1(FlowKt__TransformKt$runningFold$1$1<? super T> flowKt__TransformKt$runningFold$1$1, Continuation<? super FlowKt__TransformKt$runningFold$1$1$emit$1> continuation) {
        super(continuation);
        this.Z2 = flowKt__TransformKt$runningFold$1$1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.a3 |= Integer.MIN_VALUE;
        return this.Z2.h(null, this);
    }
}
