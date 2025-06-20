package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    final /* synthetic */ SafeCollector_commonKt$unsafeFlow$1 X2;
    int Y2;
    /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$unsafeFlow$1$collect$1(SafeCollector_commonKt$unsafeFlow$1 safeCollector_commonKt$unsafeFlow$1, Continuation<? super SafeCollector_commonKt$unsafeFlow$1$collect$1> continuation) {
        super(continuation);
        this.X2 = safeCollector_commonKt$unsafeFlow$1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return this.X2.a((FlowCollector) null, this);
    }
}
