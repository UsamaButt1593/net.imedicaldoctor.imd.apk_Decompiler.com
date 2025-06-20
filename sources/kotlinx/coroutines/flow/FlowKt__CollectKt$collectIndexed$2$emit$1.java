package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__CollectKt$collectIndexed$2$emit$1 extends ContinuationImpl {
    final /* synthetic */ FlowKt__CollectKt$collectIndexed$2 X2;
    int Y2;
    /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$collectIndexed$2$emit$1(FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2, Continuation<? super FlowKt__CollectKt$collectIndexed$2$emit$1> continuation) {
        super(continuation);
        this.X2 = flowKt__CollectKt$collectIndexed$2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return this.X2.h(null, this);
    }
}
