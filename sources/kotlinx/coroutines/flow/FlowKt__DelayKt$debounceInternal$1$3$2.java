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
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"<anonymous>", "", "T", "value", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {243}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    /* synthetic */ Object Z2;
    final /* synthetic */ Ref.ObjectRef<Object> a3;
    final /* synthetic */ FlowCollector<T> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.a3 = objectRef;
        this.b3 = flowCollector;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.Y2;
        if (i2 == 0) {
            ResultKt.n(obj);
            T o = ((ChannelResult) this.Z2).o();
            objectRef = this.a3;
            boolean z = o instanceof ChannelResult.Failed;
            if (!z) {
                objectRef.s = o;
            }
            FlowCollector<T> flowCollector = this.b3;
            if (z) {
                Throwable f2 = ChannelResult.f(o);
                if (f2 == null) {
                    T t = objectRef.s;
                    if (t != null) {
                        if (t == NullSurrogateKt.f29323a) {
                            t = null;
                        }
                        this.Z2 = o;
                        this.X2 = objectRef;
                        this.Y2 = 1;
                        if (flowCollector.h(t, this) == l2) {
                            return l2;
                        }
                        objectRef2 = objectRef;
                    }
                    objectRef.s = NullSurrogateKt.f29325c;
                } else {
                    throw f2;
                }
            }
            return Unit.f28779a;
        } else if (i2 == 1) {
            objectRef2 = (Ref.ObjectRef) this.X2;
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef = objectRef2;
        objectRef.s = NullSurrogateKt.f29325c;
        return Unit.f28779a;
    }

    @Nullable
    public final Object U(@NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) v(ChannelResult.b(obj), continuation)).D(Unit.f28779a);
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return U(((ChannelResult) obj).o(), (Continuation) obj2);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.a3, this.b3, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.Z2 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }
}
