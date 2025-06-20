package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class FlowKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f29300a = "kotlinx.coroutines.flow.defaultConcurrency";

    @Nullable
    public static final <T> Object A(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.f(flow, function2, continuation);
    }

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> A0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> A1(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.h(flow, j2);
    }

    @Nullable
    public static final <T> Object B(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__LimitKt.b(flow, function2, continuation);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> B0(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.b(flow, function2);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> B1(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.i(flow, j2);
    }

    @NotNull
    @FlowPreview
    public static final <T, R> Flow<R> C0(@NotNull Flow<? extends T> flow, int i2, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.c(flow, i2, function2);
    }

    @NotNull
    public static final <T, R> Flow<R> C1(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.j(flow, r, function3);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> D(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.c(flow, flow2, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", imports = {}))
    public static final <T, R> Flow<R> D1(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.B(flow, r, function3);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> E(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull @BuilderInference Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__ZipKt.d(flow, flow2, flow3, function4);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> E0(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.m(flow);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <T> Flow<T> E1(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__MigrationKt.C(flow, function3);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> F(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__ZipKt.e(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> F0(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MergeKt.e(flow);
    }

    @NotNull
    public static final <T> SharedFlow<T> F1(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, int i2) {
        return FlowKt__ShareKt.g(flow, coroutineScope, sharingStarted, i2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> G(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__ZipKt.f(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> G0(@NotNull Flow<? extends Flow<? extends T>> flow, int i2) {
        return FlowKt__MergeKt.f(flow, i2);
    }

    @Nullable
    public static final <T> Object H1(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.j(flow, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", imports = {}))
    public static final <T1, T2, R> Flow<R> I(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.b(flow, flow2, function3);
    }

    @NotNull
    public static final <T> Flow<T> I0(@NotNull @BuilderInference Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.n(function2);
    }

    @Nullable
    public static final <T> Object I1(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.k(flow, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", imports = {}))
    public static final <T1, T2, T3, R> Flow<R> J(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__MigrationKt.c(flow, flow2, flow3, function4);
    }

    @NotNull
    @JvmName(name = "flowCombine")
    public static final <T1, T2, R> Flow<R> J0(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.p(flow, flow2, function3);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", imports = {}))
    public static final <T> Flow<T> J1(@NotNull Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.D(flow, i2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, R> Flow<R> K(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__MigrationKt.d(flow, flow2, flow3, flow4, function5);
    }

    @NotNull
    @JvmName(name = "flowCombineTransform")
    public static final <T1, T2, R> Flow<R> K0(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.q(flow, flow2, function4);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", imports = {}))
    public static final <T> Flow<T> K1(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.E(flow, t);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    public static final <T1, T2, T3, T4, T5, R> Flow<R> L(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__MigrationKt.e(flow, flow2, flow3, flow4, flow5, function6);
    }

    @NotNull
    public static final <T> Flow<T> L0(T t) {
        return FlowKt__BuildersKt.o(t);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", imports = {}))
    public static final <T> Flow<T> L1(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.F(flow, flow2);
    }

    @NotNull
    public static final <T> Flow<T> M0(@NotNull T... tArr) {
        return FlowKt__BuildersKt.p(tArr);
    }

    @Nullable
    public static final <T> Object M1(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super StateFlow<? extends T>> continuation) {
        return FlowKt__ShareKt.i(flow, coroutineScope, continuation);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> N(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull @BuilderInference Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.i(flow, flow2, function4);
    }

    @NotNull
    public static final <T> Flow<T> N0(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.h(flow, coroutineContext);
    }

    @NotNull
    public static final <T> StateFlow<T> N1(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull SharingStarted sharingStarted, T t) {
        return FlowKt__ShareKt.j(flow, coroutineScope, sharingStarted, t);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> O(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull @BuilderInference Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> function5) {
        return FlowKt__ZipKt.j(flow, flow2, flow3, function5);
    }

    @Nullable
    public static final <T, R> Object O0(@NotNull Flow<? extends T> flow, R r, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        return FlowKt__ReduceKt.e(flow, r, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void O1(@NotNull Flow<? extends T> flow) {
        FlowKt__MigrationKt.G(flow);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> P(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull @BuilderInference Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> function6) {
        return FlowKt__ZipKt.k(flow, flow2, flow3, flow4, function6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", imports = {}))
    public static final <T> void P0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.n(flow, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void P1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.H(flow, function2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> Q(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull @BuilderInference Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> function7) {
        return FlowKt__ZipKt.l(flow, flow2, flow3, flow4, flow5, function7);
    }

    public static final int Q0() {
        return FlowKt__MergeKt.h();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Q1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        FlowKt__MigrationKt.I(flow, function2, function22);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    public static final <T> Flow<T> R1(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.J(flow, coroutineContext);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", imports = {}))
    public static final <T, R> Flow<R> S(@NotNull Flow<? extends T> flow, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.f(flow, function1);
    }

    @Nullable
    public static final <T> Object S0(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.g(flow, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", imports = {}))
    public static final <T, R> Flow<R> S1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.K(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> T(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.g(flow, function1);
    }

    @Nullable
    public static final <T> Object T0(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.h(flow, continuation);
    }

    @NotNull
    public static final <T> Flow<T> T1(@NotNull Flow<? extends T> flow, int i2) {
        return FlowKt__LimitKt.g(flow, i2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", imports = {}))
    public static final <T> Flow<T> U(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.h(flow, t);
    }

    @NotNull
    public static final <T> Job U0(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.h(flow, coroutineScope);
    }

    @NotNull
    public static final <T> Flow<T> U1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.h(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    public static final <T> Flow<T> V(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.i(flow, flow2);
    }

    @NotNull
    public static final <T, R> Flow<R> V0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.e(flow, function2);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object V1(@NotNull Flow<? extends T> flow, @NotNull C c2, @NotNull Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.a(flow, c2, continuation);
    }

    @NotNull
    public static final <T> Flow<T> W(@NotNull Flow<? extends T> flow) {
        return FlowKt__ContextKt.g(flow);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> W0(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.k(flow, function2);
    }

    @Nullable
    public static final <T> Object W1(@NotNull Flow<? extends T> flow, @NotNull List<T> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        return FlowKt__CollectionKt.b(flow, list, continuation);
    }

    @NotNull
    public static final <T> Flow<T> X(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.c(receiveChannel);
    }

    @NotNull
    public static final <T, R> Flow<R> X0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.f(flow, function2);
    }

    @Nullable
    public static final <T> Object Y(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.a(flow, continuation);
    }

    @NotNull
    public static final <T> Flow<T> Y0(@NotNull Iterable<? extends Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.l(iterable);
    }

    @Nullable
    public static final <T> Object Y1(@NotNull Flow<? extends T> flow, @NotNull Set<T> set, @NotNull Continuation<? super Set<? extends T>> continuation) {
        return FlowKt__CollectionKt.d(flow, set, continuation);
    }

    @Nullable
    public static final <T> Object Z(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.b(flow, function2, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", imports = {}))
    public static final <T> Flow<T> Z0(@NotNull Flow<? extends Flow<? extends T>> flow) {
        return FlowKt__MigrationKt.o(flow);
    }

    @NotNull
    public static final <T> Flow<T> a(@NotNull Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.a(iterable);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> a0(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.a(flow, j2);
    }

    @NotNull
    public static final <T> Flow<T> a1(@NotNull Flow<? extends T>... flowArr) {
        return FlowKt__MergeKt.m(flowArr);
    }

    @NotNull
    public static final <T, R> Flow<R> a2(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.g(flow, function3);
    }

    @NotNull
    public static final <T> Flow<T> b(@NotNull Iterator<? extends T> it2) {
        return FlowKt__BuildersKt.b(it2);
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> b0(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return FlowKt__DelayKt.b(flow, function1);
    }

    @NotNull
    public static final Void b1() {
        return FlowKt__MigrationKt.p();
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> b2(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.n(flow, function3);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> c(@NotNull Function0<? extends T> function0) {
        return FlowKt__BuildersKt.c(function0);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> c0(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__DelayKt.c(flow, j2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> c1(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.q(flow, coroutineContext);
    }

    @NotNull
    public static final <T, R> Flow<R> c2(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt__LimitKt.i(flow, function3);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> d(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return FlowKt__BuildersKt.d(function1);
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    @JvmName(name = "debounceDuration")
    public static final <T> Flow<T> d0(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Duration> function1) {
        return FlowKt__DelayKt.d(flow, function1);
    }

    @NotNull
    public static final <T> Flow<T> d1(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.d(flow, function3);
    }

    @NotNull
    @PublishedApi
    public static final <T, R> Flow<R> d2(@NotNull Flow<? extends T> flow, @NotNull @BuilderInference Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.h(flow, function3);
    }

    @NotNull
    public static final Flow<Integer> e(@NotNull IntRange intRange) {
        return FlowKt__BuildersKt.e(intRange);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> e0(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__MigrationKt.j(flow, j2);
    }

    @NotNull
    public static final <T> Flow<T> e1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.g(flow, function2);
    }

    @NotNull
    public static final <T> Flow<IndexedValue<T>> e2(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.k(flow);
    }

    @NotNull
    public static final Flow<Long> f(@NotNull LongRange longRange) {
        return FlowKt__BuildersKt.f(longRange);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", imports = {}))
    public static final <T> Flow<T> f0(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt__MigrationKt.k(flow, j2);
    }

    @NotNull
    public static final <T> Flow<T> f1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.e(flow, function2);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> f2(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.s(flow, flow2, function3);
    }

    @NotNull
    public static final <T> Flow<T> g(@NotNull Sequence<? extends T> sequence) {
        return FlowKt__BuildersKt.g(sequence);
    }

    @NotNull
    public static final <T> Flow<T> g0(@NotNull Flow<? extends T> flow) {
        return FlowKt__DistinctKt.a(flow);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> g1(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.r(flow, flow2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> h(@NotNull BroadcastChannel<T> broadcastChannel) {
        return FlowKt__ChannelsKt.b(broadcastChannel);
    }

    @NotNull
    public static final <T> Flow<T> h0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        return FlowKt__DistinctKt.b(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", imports = {}))
    public static final <T> Flow<T> h1(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2) {
        return FlowKt__MigrationKt.s(flow, flow2);
    }

    @NotNull
    public static final Flow<Integer> i(@NotNull int[] iArr) {
        return FlowKt__BuildersKt.h(iArr);
    }

    @NotNull
    public static final <T, K> Flow<T> i0(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends K> function1) {
        return FlowKt__DistinctKt.c(flow, function1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", imports = {}))
    public static final <T> Flow<T> i1(@NotNull Flow<? extends T> flow, T t) {
        return FlowKt__MigrationKt.t(flow, t);
    }

    @NotNull
    public static final Flow<Long> j(@NotNull long[] jArr) {
        return FlowKt__BuildersKt.i(jArr);
    }

    @NotNull
    public static final <T> Flow<T> j0(@NotNull Flow<? extends T> flow, int i2) {
        return FlowKt__LimitKt.d(flow, i2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> j1(@NotNull Flow<? extends T> flow, T t, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt__MigrationKt.u(flow, t, function1);
    }

    @NotNull
    public static final <T> Flow<T> k(@NotNull T[] tArr) {
        return FlowKt__BuildersKt.j(tArr);
    }

    @NotNull
    public static final <T> Flow<T> k0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.e(flow, function2);
    }

    @NotNull
    public static final <T> SharedFlow<T> l(@NotNull MutableSharedFlow<T> mutableSharedFlow) {
        return FlowKt__ShareKt.a(mutableSharedFlow);
    }

    @Nullable
    public static final <T> Object l0(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.d(flowCollector, receiveChannel, continuation);
    }

    @NotNull
    public static final <T> Flow<T> l1(@NotNull Flow<? extends T> flow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.f(flow, function2);
    }

    @NotNull
    public static final <T> StateFlow<T> m(@NotNull MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.b(mutableStateFlow);
    }

    @Nullable
    public static final <T> Object m0(@NotNull FlowCollector<? super T> flowCollector, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.g(flowCollector, flow, continuation);
    }

    @NotNull
    public static final <T> SharedFlow<T> m1(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__ShareKt.f(sharedFlow, function2);
    }

    @NotNull
    public static final <T> Flow<T> n0() {
        return FlowKt__BuildersKt.m();
    }

    @NotNull
    @FlowPreview
    public static final <T> ReceiveChannel<T> n1(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.f(flow, coroutineScope);
    }

    @NotNull
    public static final <T> Flow<T> o(@NotNull Flow<? extends T> flow, int i2, @NotNull BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.b(flow, i2, bufferOverflow);
    }

    public static final void o0(@NotNull FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.b(flowCollector);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> o1(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.w(flow);
    }

    @NotNull
    public static final <T> Flow<T> p0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.a(flow, function2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    public static final <T> Flow<T> p1(@NotNull Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.x(flow, i2);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> Flow<T> q1(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.y(flow, coroutineContext);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    public static final <T> Flow<T> r(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.a(flow);
    }

    @NotNull
    public static final <T> Flow<T> r0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.c(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> r1(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.g(receiveChannel);
    }

    @NotNull
    public static final <T> Flow<T> s(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.k(function2);
    }

    @NotNull
    public static final <T> Flow<T> s0(@NotNull Flow<? extends T> flow) {
        return FlowKt__TransformKt.d(flow);
    }

    @Nullable
    public static final <S, T extends S> Object s1(@NotNull Flow<? extends T> flow, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, @NotNull Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.i(flow, function3, continuation);
    }

    @NotNull
    public static final <T> Flow<T> t(@NotNull Flow<? extends T> flow) {
        return FlowKt__ContextKt.e(flow);
    }

    @Nullable
    public static final <T> Object t0(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(flow, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    public static final <T> Flow<T> t1(@NotNull Flow<? extends T> flow) {
        return FlowKt__MigrationKt.z(flow);
    }

    @NotNull
    public static final <T> Flow<T> u(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.a(flow, function3);
    }

    @Nullable
    public static final <T> Object u0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.b(flow, function2, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    public static final <T> Flow<T> u1(@NotNull Flow<? extends T> flow, int i2) {
        return FlowKt__MigrationKt.A(flow, i2);
    }

    @Nullable
    public static final <T> Object v(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.b(flow, flowCollector, continuation);
    }

    @Nullable
    public static final <T> Object v0(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.c(flow, continuation);
    }

    @NotNull
    public static final <T> Flow<T> v1(@NotNull Flow<? extends T> flow, long j2, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.e(flow, j2, function2);
    }

    @NotNull
    public static final <T> Flow<T> w(@NotNull @BuilderInference Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.l(function2);
    }

    @Nullable
    public static final <T> Object w0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.d(flow, function2, continuation);
    }

    @Nullable
    public static final Object x(@NotNull Flow<?> flow, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(flow, continuation);
    }

    @NotNull
    public static final ReceiveChannel<Unit> x0(@NotNull CoroutineScope coroutineScope, long j2, long j3) {
        return FlowKt__DelayKt.f(coroutineScope, j2, j3);
    }

    @NotNull
    public static final <T> Flow<T> x1(@NotNull Flow<? extends T> flow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.g(flow, function4);
    }

    @NotNull
    public static final <T, R> Flow<R> y1(@NotNull Flow<? extends T> flow, R r, @NotNull @BuilderInference Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.h(flow, r, function3);
    }

    @Nullable
    public static final <T> Object z(@NotNull Flow<? extends T> flow, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.d(flow, function3, continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", imports = {}))
    public static final <T, R> Flow<R> z0(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.l(flow, function2);
    }

    @NotNull
    public static final <T> Flow<T> z1(@NotNull Flow<? extends T> flow, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__TransformKt.i(flow, function3);
    }
}
