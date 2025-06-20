package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__ReduceKt$last$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> s;

    FlowKt__ReduceKt$last$2(Ref.ObjectRef<Object> objectRef) {
        this.s = objectRef;
    }

    @Nullable
    public final Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        this.s.s = t;
        return Unit.f28779a;
    }
}
