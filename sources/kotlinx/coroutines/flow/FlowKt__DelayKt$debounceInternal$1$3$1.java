package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int X2;
    final /* synthetic */ FlowCollector<T> Y2;
    final /* synthetic */ Ref.ObjectRef<Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$1(FlowCollector<? super T> flowCollector, Ref.ObjectRef<Object> objectRef, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$1> continuation) {
        super(1, continuation);
        this.Y2 = flowCollector;
        this.Z2 = objectRef;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            FlowCollector<T> flowCollector = this.Y2;
            T t = NullSurrogateKt.f29323a;
            T t2 = this.Z2.s;
            if (t2 == t) {
                t2 = null;
            }
            this.X2 = 1;
            if (flowCollector.h(t2, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.Z2.s = null;
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object f(@Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) y(continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> y(@NotNull Continuation<?> continuation) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.Y2, this.Z2, continuation);
    }
}
