package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "s", "I", "index", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__CollectKt$collectIndexed$2 implements FlowCollector<T> {
    final /* synthetic */ Function3<Integer, T, Continuation<? super Unit>, Object> X;
    private int s;

    public FlowKt__CollectKt$collectIndexed$2(Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.X = function3;
    }

    @Nullable
    public Object a(T t, @NotNull Continuation<? super Unit> continuation) {
        InlineMarker.e(4);
        new FlowKt__CollectKt$collectIndexed$2$emit$1(this, continuation);
        InlineMarker.e(5);
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        if (i2 >= 0) {
            function3.A(Integer.valueOf(i2), t, continuation);
            return Unit.f28779a;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    @Nullable
    public Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        if (i2 >= 0) {
            Object A = function3.A(Boxing.f(i2), t, continuation);
            return A == IntrinsicsKt.l() ? A : Unit.f28779a;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
