package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"<anonymous>", "", "T", "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Ref.ObjectRef<Object> Z2;
    final /* synthetic */ ReceiveChannel<Unit> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.Z2 = objectRef;
        this.a3 = receiveChannel;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            T o = ((ChannelResult) this.Y2).o();
            Ref.ObjectRef<Object> objectRef = this.Z2;
            boolean z = o instanceof ChannelResult.Failed;
            if (!z) {
                objectRef.s = o;
            }
            ReceiveChannel<Unit> receiveChannel = this.a3;
            if (z) {
                Throwable f2 = ChannelResult.f(o);
                if (f2 == null) {
                    receiveChannel.i(new ChildCancelledException());
                    objectRef.s = NullSurrogateKt.f29325c;
                } else {
                    throw f2;
                }
            }
            return Unit.f28779a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object U(@NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) v(ChannelResult.b(obj), continuation)).D(Unit.f28779a);
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return U(((ChannelResult) obj).o(), (Continuation) obj2);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.Z2, this.a3, continuation);
        flowKt__DelayKt$sample$2$1$1.Y2 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }
}
