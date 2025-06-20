package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0005\u001a<\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\b\u001a9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0005\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMillis", "a", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/time/Duration;", "timeout", "c", "d", "timeoutMillisSelector", "e", "periodMillis", "h", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "f", "(Lkotlinx/coroutines/CoroutineScope;JJ)Lkotlinx/coroutines/channels/ReceiveChannel;", "period", "i", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__DelayKt {
    @NotNull
    @FlowPreview
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow, long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? flow : e(flow, new FlowKt__DelayKt$debounce$2(j2));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    public static final <T> Flow<T> b(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Long> function1) {
        return e(flow, function1);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> c(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt.a0(flow, DelayKt.e(j2));
    }

    @OverloadResolutionByLambdaReturnType
    @FlowPreview
    @NotNull
    @JvmName(name = "debounceDuration")
    public static final <T> Flow<T> d(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Duration> function1) {
        return e(flow, new FlowKt__DelayKt$debounce$3(function1));
    }

    private static final <T> Flow<T> e(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(function1, flow, (Continuation<? super FlowKt__DelayKt$debounceInternal$1>) null));
    }

    @NotNull
    public static final ReceiveChannel<Unit> f(@NotNull CoroutineScope coroutineScope, long j2, long j3) {
        if (j2 < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        } else if (j3 >= 0) {
            return ProduceKt.f(coroutineScope, (CoroutineContext) null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j3, j2, (Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$3>) null), 1, (Object) null);
        } else {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
        }
    }

    public static /* synthetic */ ReceiveChannel g(CoroutineScope coroutineScope, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        return FlowKt.x0(coroutineScope, j2, j3);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> h(@NotNull Flow<? extends T> flow, long j2) {
        if (j2 > 0) {
            return FlowCoroutineKt.b(new FlowKt__DelayKt$sample$2(j2, flow, (Continuation<? super FlowKt__DelayKt$sample$2>) null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> i(@NotNull Flow<? extends T> flow, long j2) {
        return FlowKt.A1(flow, DelayKt.e(j2));
    }
}
