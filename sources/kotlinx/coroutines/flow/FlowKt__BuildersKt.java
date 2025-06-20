package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a8\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001a\"\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b#\u0010\u001d\u001a\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020$¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\b*\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\b*\u00020,¢\u0006\u0004\b-\u0010.\u001a\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020)0\b*\u00020/¢\u0006\u0004\b0\u00101\u001aM\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b3\u0010\n\u001aM\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b4\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/Flow;", "n", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function0;", "c", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "d", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "", "a", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "b", "(Ljava/util/Iterator;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/sequences/Sequence;", "g", "(Lkotlin/sequences/Sequence;)Lkotlinx/coroutines/flow/Flow;", "", "elements", "p", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "value", "o", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "m", "()Lkotlinx/coroutines/flow/Flow;", "j", "", "", "h", "([I)Lkotlinx/coroutines/flow/Flow;", "", "", "i", "([J)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/IntRange;", "e", "(Lkotlin/ranges/IntRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/ranges/LongRange;", "f", "(Lkotlin/ranges/LongRange;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/channels/ProducerScope;", "l", "k", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__BuildersKt {
    @NotNull
    public static final <T> Flow<T> a(@NotNull Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @NotNull
    public static final <T> Flow<T> b(@NotNull Iterator<? extends T> it2) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it2);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> c(@NotNull Function0<? extends T> function0) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1(function0);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> d(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    @NotNull
    public static final Flow<Integer> e(@NotNull IntRange intRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(intRange);
    }

    @NotNull
    public static final Flow<Long> f(@NotNull LongRange longRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(longRange);
    }

    @NotNull
    public static final <T> Flow<T> g(@NotNull Sequence<? extends T> sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    @NotNull
    public static final Flow<Integer> h(@NotNull int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @NotNull
    public static final Flow<Long> i(@NotNull long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @NotNull
    public static final <T> Flow<T> j(@NotNull T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @NotNull
    public static final <T> Flow<T> k(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new CallbackFlowBuilder(function2, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final <T> Flow<T> l(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new ChannelFlowBuilder(function2, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final <T> Flow<T> m() {
        return EmptyFlow.s;
    }

    @NotNull
    public static final <T> Flow<T> n(@NotNull @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new SafeFlow(function2);
    }

    @NotNull
    public static final <T> Flow<T> o(T t) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(t);
    }

    @NotNull
    public static final <T> Flow<T> p(@NotNull T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }
}
