package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0010\u0010\u000b\u001a\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "b", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "a", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "g", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "h", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "e", "", "f", "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ContextKt {
    @NotNull
    public static final <T> Flow<T> b(@NotNull Flow<? extends T> flow, int i2, @NotNull BufferOverflow bufferOverflow) {
        BufferOverflow bufferOverflow2;
        int i3;
        if (i2 < 0 && i2 != -2 && i2 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i2).toString());
        } else if (i2 != -1 || bufferOverflow == BufferOverflow.SUSPEND) {
            if (i2 == -1) {
                bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                i3 = 0;
            } else {
                i3 = i2;
                bufferOverflow2 = bufferOverflow;
            }
            return flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.a((FusibleFlow) flow, (CoroutineContext) null, i3, bufferOverflow2, 1, (Object) null) : new ChannelFlowOperatorImpl(flow, (CoroutineContext) null, i3, bufferOverflow2, 2, (DefaultConstructorMarker) null);
        } else {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
    }

    public static /* synthetic */ Flow c(Flow flow, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        return d(flow, i2, (BufferOverflow) null, 2, (Object) null);
    }

    public static /* synthetic */ Flow d(Flow flow, int i2, BufferOverflow bufferOverflow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -2;
        }
        if ((i3 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.o(flow, i2, bufferOverflow);
    }

    @NotNull
    public static final <T> Flow<T> e(@NotNull Flow<? extends T> flow) {
        return flow instanceof CancellableFlow ? flow : new CancellableFlowImpl(flow);
    }

    private static final void f(CoroutineContext coroutineContext) {
        if (coroutineContext.e(Job.P2) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
        }
    }

    @NotNull
    public static final <T> Flow<T> g(@NotNull Flow<? extends T> flow) {
        return d(flow, -1, (BufferOverflow) null, 2, (Object) null);
    }

    @NotNull
    public static final <T> Flow<T> h(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        f(coroutineContext);
        if (Intrinsics.g(coroutineContext, EmptyCoroutineContext.s)) {
            return flow;
        }
        return flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.a((FusibleFlow) flow, coroutineContext, 0, (BufferOverflow) null, 6, (Object) null) : new ChannelFlowOperatorImpl(flow, coroutineContext, 0, (BufferOverflow) null, 12, (DefaultConstructorMarker) null);
    }
}
