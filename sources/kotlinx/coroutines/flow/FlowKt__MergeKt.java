package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ag\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000227\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aq\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\r\u001a\u00020\f27\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001e\u0010\u0016\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0015\"\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001at\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0001\u0010\t\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001b¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aj\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000229\b\u0005\u0010\t\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u000b\u001ac\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000223\b\u0001\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000b\" \u0010(\u001a\u00020\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010#\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\"\u001a\u0010*\u001a\u00020)8\u0006XT¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "transform", "a", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "concurrency", "c", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "e", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "l", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "flows", "m", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "f", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "n", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "b", "k", "I", "h", "()I", "i", "()V", "DEFAULT_CONCURRENCY", "", "DEFAULT_CONCURRENCY_PROPERTY_NAME", "Ljava/lang/String;", "j", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__MergeKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29303a = SystemPropsKt.b(FlowKt.f29300a, 16, 1, Integer.MAX_VALUE);

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> a(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.F0(new FlowKt__MergeKt$flatMapConcat$$inlined$map$1(flow, function2));
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> b(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.b2(flow, new FlowKt__MergeKt$flatMapLatest$1(function2, (Continuation<? super FlowKt__MergeKt$flatMapLatest$1>) null));
    }

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> c(@NotNull Flow<? extends T> flow, int i2, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.G0(new FlowKt__MergeKt$flatMapMerge$$inlined$map$1(flow, function2), i2);
    }

    public static /* synthetic */ Flow d(Flow flow, int i2, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = f29303a;
        }
        return FlowKt.C0(flow, i2, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> e(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return new FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1(flow);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> f(@NotNull Flow<? extends Flow<? extends T>> flow, int i2) {
        if (i2 > 0) {
            return i2 == 1 ? FlowKt.F0(flow) : new ChannelFlowMerge(flow, i2, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i2).toString());
    }

    public static /* synthetic */ Flow g(Flow flow, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = f29303a;
        }
        return FlowKt.G0(flow, i2);
    }

    public static final int h() {
        return f29303a;
    }

    @FlowPreview
    public static /* synthetic */ void i() {
    }

    @FlowPreview
    public static /* synthetic */ void j() {
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> k(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.b2(flow, new FlowKt__MergeKt$mapLatest$1(function2, (Continuation<? super FlowKt__MergeKt$mapLatest$1>) null));
    }

    @NotNull
    public static final <T> Flow<T> l(@NotNull Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final <T> Flow<T> m(@NotNull Flow<? extends T>... flowArr) {
        return FlowKt.Y0(ArraysKt.B5(flowArr));
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> n(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }
}
