package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a)\u0010\u0012\u001a\u00020\u0011*\u0006\u0012\u0002\b\u00030\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001ao\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012D\b\b\u0010\u001b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0014¢\u0006\u0002\b\u001aH\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001ah\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001e23\b\n\u0010\"\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190 H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012Y\b\b\u0010\"\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190%¢\u0006\u0002\b\u001aH\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a)\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001HHø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a)\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001HHø\u0001\u0000¢\u0006\u0004\b-\u0010+\u001a#\u0010/\u001a\u00020.\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001HHø\u0001\u0000¢\u0006\u0004\b/\u0010+\"\"\u00104\u001a\u00020!*\u0006\u0012\u0002\b\u00030\r8FX\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b0\u00101\"\"\u00108\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\r8FX\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001a\u0004\b5\u00106\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "c", "(Lkotlinx/coroutines/flow/SharedFlow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "h", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "e", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "g", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/util/concurrent/CancellationException;)V", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "d", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "", "retries", "Lkotlin/Function2;", "", "predicate", "m", "(Lkotlinx/coroutines/flow/SharedFlow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "attempt", "o", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "", "p", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "q", "", "f", "k", "(Lkotlinx/coroutines/flow/FlowCollector;)Z", "l", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "isActive", "i", "(Lkotlinx/coroutines/flow/FlowCollector;)Lkotlin/coroutines/CoroutineContext;", "j", "coroutineContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class LintKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@NotNull FlowCollector<?> flowCollector, @Nullable CancellationException cancellationException) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void b(FlowCollector flowCollector, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        a(flowCollector, cancellationException);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    public static final <T> Flow<T> c(@NotNull SharedFlow<? extends T> sharedFlow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> Flow<T> d(SharedFlow<? extends T> sharedFlow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt.u(sharedFlow, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    public static final <T> Flow<T> e(@NotNull StateFlow<? extends T> stateFlow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object f(SharedFlow<? extends T> sharedFlow, Continuation<? super Integer> continuation) {
        InlineMarker.e(0);
        Object Y = FlowKt.Y(sharedFlow, continuation);
        InlineMarker.e(1);
        return Y;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    public static final <T> Flow<T> g(@NotNull StateFlow<? extends T> stateFlow) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    public static final <T> Flow<T> h(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull CoroutineContext coroutineContext) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final CoroutineContext i(@NotNull FlowCollector<?> flowCollector) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @ReplaceWith(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void j(FlowCollector flowCollector) {
    }

    public static final boolean k(@NotNull FlowCollector<?> flowCollector) {
        FlowKt.b1();
        throw new KotlinNothingValueException();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @ReplaceWith(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void l(FlowCollector flowCollector) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> Flow<T> m(SharedFlow<? extends T> sharedFlow, long j2, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt.v1(sharedFlow, j2, function2);
    }

    static /* synthetic */ Flow n(SharedFlow sharedFlow, long j2, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = Long.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            function2 = new LintKt$retry$1((Continuation<? super LintKt$retry$1>) null);
        }
        return FlowKt.v1(sharedFlow, j2, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @ReplaceWith(expression = "this", imports = {}))
    @InlineOnly
    private static final <T> Flow<T> o(SharedFlow<? extends T> sharedFlow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt.x1(sharedFlow, function4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object p(SharedFlow<? extends T> sharedFlow, Continuation<? super List<? extends T>> continuation) {
        InlineMarker.e(0);
        Object X1 = FlowKt__CollectionKt.c(sharedFlow, (List) null, continuation, 1, (Object) null);
        InlineMarker.e(1);
        return X1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    @InlineOnly
    private static final <T> Object q(SharedFlow<? extends T> sharedFlow, Continuation<? super Set<? extends T>> continuation) {
        InlineMarker.e(0);
        Object Z1 = FlowKt__CollectionKt.e(sharedFlow, (Set) null, continuation, 1, (Object) null);
        InlineMarker.e(1);
        return Z1;
    }
}
