package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {352}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    private /* synthetic */ Object a3;
    /* synthetic */ Object b3;
    final /* synthetic */ long c3;
    final /* synthetic */ Flow<T> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(long j2, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2> continuation) {
        super(3, continuation);
        this.c3 = j2;
        this.d3 = flow;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel2;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.Z2;
        if (i2 == 0) {
            ResultKt.n(obj);
            FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.d3, (Continuation<? super FlowKt__DelayKt$sample$2$values$1>) null);
            CoroutineScope coroutineScope = (CoroutineScope) this.a3;
            ReceiveChannel f2 = ProduceKt.f(coroutineScope, (CoroutineContext) null, -1, flowKt__DelayKt$sample$2$values$1, 1, (Object) null);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ReceiveChannel y0 = FlowKt__DelayKt.g(coroutineScope, this.c3, 0, 2, (Object) null);
            flowCollector = (FlowCollector) this.b3;
            receiveChannel = f2;
            objectRef = objectRef2;
            receiveChannel2 = y0;
        } else if (i2 == 1) {
            receiveChannel2 = (ReceiveChannel) this.Y2;
            objectRef = (Ref.ObjectRef) this.X2;
            receiveChannel = (ReceiveChannel) this.b3;
            flowCollector = (FlowCollector) this.a3;
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (objectRef.s != NullSurrogateKt.f29325c) {
            this.a3 = flowCollector;
            this.b3 = receiveChannel;
            this.X2 = objectRef;
            this.Y2 = receiveChannel2;
            this.Z2 = 1;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(this);
            try {
                selectBuilderImpl.q0(receiveChannel.o(), new FlowKt__DelayKt$sample$2$1$1(objectRef, receiveChannel2, (Continuation<? super FlowKt__DelayKt$sample$2$1$1>) null));
                selectBuilderImpl.q0(receiveChannel2.m(), new FlowKt__DelayKt$sample$2$1$2(objectRef, flowCollector, (Continuation<? super FlowKt__DelayKt$sample$2$1$2>) null));
            } catch (Throwable th) {
                selectBuilderImpl.g1(th);
            }
            Object f1 = selectBuilderImpl.f1();
            if (f1 == IntrinsicsKt.l()) {
                DebugProbesKt.c(this);
                continue;
            }
            if (f1 == l2) {
                return l2;
            }
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object A(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.c3, this.d3, continuation);
        flowKt__DelayKt$sample$2.a3 = coroutineScope;
        flowKt__DelayKt$sample$2.b3 = flowCollector;
        return flowKt__DelayKt$sample$2.D(Unit.f28779a);
    }
}
