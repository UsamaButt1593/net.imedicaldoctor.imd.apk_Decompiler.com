package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", i = {}, l = {211}, m = "emit", n = {}, s = {})
final class FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 extends ContinuationImpl {
    final /* synthetic */ FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1<T> X2;
    int Y2;
    /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(FlowKt__DelayKt$debounceInternal$1$values$1.AnonymousClass1<? super T> r1, Continuation<? super FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1> continuation) {
        super(continuation);
        this.X2 = r1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return this.X2.h(null, this);
    }
}
