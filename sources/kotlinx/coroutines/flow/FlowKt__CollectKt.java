package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NopCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001am\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002H\b\u0004\u0010\u0012\u001aB\b\u0001\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nHHø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aV\u0010\u0016\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a1\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aX\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000023\b\u0004\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0015HHø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "", "a", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Job;", "h", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Job;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "index", "value", "Lkotlin/coroutines/Continuation;", "", "action", "d", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "f", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "g", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CollectKt {
    @Nullable
    public static final Object a(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        Object a2 = flow.a(NopCollector.s, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object b(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object a2 = flow.a(new FlowKt__CollectKt$collect$3(function2), continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object c(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(function2);
        InlineMarker.e(0);
        flow.a(flowKt__CollectKt$collect$3, continuation);
        InlineMarker.e(1);
        return Unit.f28779a;
    }

    @Nullable
    public static final <T> Object d(@NotNull Flow<? extends T> flow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) {
        Object a2 = flow.a(new FlowKt__CollectKt$collectIndexed$2(function3), continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    private static final <T> Object e(Flow<? extends T> flow, Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(function3);
        InlineMarker.e(0);
        flow.a(flowKt__CollectKt$collectIndexed$2, continuation);
        InlineMarker.e(1);
        return Unit.f28779a;
    }

    @Nullable
    public static final <T> Object f(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object x = FlowKt.x(FlowKt__ContextKt.d(FlowKt.W0(flow, function2), 0, (BufferOverflow) null, 2, (Object) null), continuation);
        return x == IntrinsicsKt.l() ? x : Unit.f28779a;
    }

    @Nullable
    public static final <T> Object g(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        FlowKt.o0(flowCollector);
        Object a2 = flow.a(flowCollector, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @NotNull
    public static final <T> Job h(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return BuildersKt__Builders_commonKt.f(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new FlowKt__CollectKt$launchIn$1(flow, (Continuation<? super FlowKt__CollectKt$launchIn$1>) null), 3, (Object) null);
    }
}
