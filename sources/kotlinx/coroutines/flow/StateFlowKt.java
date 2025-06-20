package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a4\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\u001a4\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0005H\b¢\u0006\u0004\b\t\u0010\b\u001a4\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0005H\b¢\u0006\u0004\b\u000b\u0010\f\u001a=\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u001b\u001a\u00020\u00178\u0002X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001e\u001a\u00020\u00178\u0002X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u0012\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, d2 = {"T", "value", "Lkotlinx/coroutines/flow/MutableStateFlow;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Function1;", "function", "i", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e", "", "h", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "d", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "f", "()V", "NONE", "b", "g", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class StateFlowKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29319a = new Symbol("NONE");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29320b = new Symbol("PENDING");

    @NotNull
    public static final <T> MutableStateFlow<T> a(T t) {
        if (t == null) {
            t = NullSurrogateKt.f29323a;
        }
        return new StateFlowImpl(t);
    }

    @NotNull
    public static final <T> Flow<T> d(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? SharedFlowKt.e(stateFlow, coroutineContext, i2, bufferOverflow) : stateFlow;
    }

    public static final <T> T e(@NotNull MutableStateFlow<T> mutableStateFlow, @NotNull Function1<? super T, ? extends T> function1) {
        T value;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, function1.f(value)));
        return value;
    }

    private static /* synthetic */ void f() {
    }

    private static /* synthetic */ void g() {
    }

    public static final <T> void h(@NotNull MutableStateFlow<T> mutableStateFlow, @NotNull Function1<? super T, ? extends T> function1) {
        T value;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, function1.f(value)));
    }

    public static final <T> T i(@NotNull MutableStateFlow<T> mutableStateFlow, @NotNull Function1<? super T, ? extends T> function1) {
        T value;
        T f2;
        do {
            value = mutableStateFlow.getValue();
            f2 = function1.f(value);
        } while (!mutableStateFlow.compareAndSet(value, f2));
        return f2;
    }
}
