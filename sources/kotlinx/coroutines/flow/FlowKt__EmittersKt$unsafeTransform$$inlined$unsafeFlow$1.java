package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ Function3 X;
    final /* synthetic */ Flow s;

    public FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.s = flow;
        this.X = function3;
    }

    @Nullable
    public Object a(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object a2 = this.s.a(new FlowKt__EmittersKt$unsafeTransform$1$1(this.X, flowCollector), continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @Nullable
    public Object d(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.e(4);
        new ContinuationImpl(this, continuation) {
            int X2;
            final /* synthetic */ FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1 Y2;
            /* synthetic */ Object Z;

            {
                this.Y2 = r1;
            }

            @Nullable
            public final Object D(@NotNull Object obj) {
                this.Z = obj;
                this.X2 |= Integer.MIN_VALUE;
                return this.Y2.a((FlowCollector) null, this);
            }
        };
        InlineMarker.e(5);
        Flow flow = this.s;
        FlowKt__EmittersKt$unsafeTransform$1$1 flowKt__EmittersKt$unsafeTransform$1$1 = new FlowKt__EmittersKt$unsafeTransform$1$1(this.X, flowCollector);
        InlineMarker.e(0);
        flow.a(flowKt__EmittersKt$unsafeTransform$1$1, continuation);
        InlineMarker.e(1);
        return Unit.f28779a;
    }
}
