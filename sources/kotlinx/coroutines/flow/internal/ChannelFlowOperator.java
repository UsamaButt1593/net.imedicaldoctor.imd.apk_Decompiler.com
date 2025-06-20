package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH¤@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "newContext", "", "s", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "f", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "toString", "()Ljava/lang/String;", "Z", "Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    @NotNull
    @JvmField
    protected final Flow<S> Z;

    public ChannelFlowOperator(@NotNull Flow<? extends S> flow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.Z = flow;
    }

    static /* synthetic */ Object q(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.X == -3) {
            CoroutineContext g2 = continuation.g();
            CoroutineContext v = g2.v(channelFlowOperator.s);
            if (Intrinsics.g(v, g2)) {
                Object t = channelFlowOperator.t(flowCollector, continuation);
                return t == IntrinsicsKt.l() ? t : Unit.f28779a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.N2;
            if (Intrinsics.g(v.e(key), g2.e(key))) {
                Object s = channelFlowOperator.s(flowCollector, v, continuation);
                return s == IntrinsicsKt.l() ? s : Unit.f28779a;
            }
        }
        Object a2 = super.a(flowCollector, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    static /* synthetic */ Object r(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object t = channelFlowOperator.t(new SendingCollector(producerScope), continuation);
        return t == IntrinsicsKt.l() ? t : Unit.f28779a;
    }

    /* access modifiers changed from: private */
    public final Object s(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object d2 = ChannelFlowKt.d(coroutineContext, ChannelFlowKt.e(flowCollector, continuation.g()), (Object) null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, (Continuation<? super ChannelFlowOperator$collectWithContextUndispatched$2>) null), continuation, 4, (Object) null);
        return d2 == IntrinsicsKt.l() ? d2 : Unit.f28779a;
    }

    @Nullable
    public Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return q(this, flowCollector, continuation);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object f(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        return r(this, producerScope, continuation);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object t(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    public String toString() {
        return this.Z + " -> " + super.toString();
    }
}
