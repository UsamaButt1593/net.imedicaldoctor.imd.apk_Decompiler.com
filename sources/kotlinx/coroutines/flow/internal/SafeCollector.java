package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010\"\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020(8\u0000X\u0004¢\u0006\u0006\n\u0004\b)\u0010 R\u0018\u0010,\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "Lkotlin/coroutines/CoroutineContext;", "collectContext", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/coroutines/Continuation;", "", "uCont", "value", "", "c0", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "currentContext", "previousContext", "U", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "exception", "i0", "(Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "I", "()V", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Z", "Lkotlinx/coroutines/flow/FlowCollector;", "X2", "Lkotlin/coroutines/CoroutineContext;", "", "Y2", "collectContextSize", "Z2", "lastEmissionContext", "a3", "Lkotlin/coroutines/Continuation;", "completion", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {
    @NotNull
    @JvmField
    public final CoroutineContext X2;
    @JvmField
    public final int Y2;
    @NotNull
    @JvmField
    public final FlowCollector<T> Z;
    @Nullable
    private CoroutineContext Z2;
    @Nullable
    private Continuation<? super Unit> a3;

    public SafeCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        super(NoOpContinuation.s, EmptyCoroutineContext.s);
        this.Z = flowCollector;
        this.X2 = coroutineContext;
        this.Y2 = ((Number) coroutineContext.n(0, SafeCollector$collectContextSize$1.X)).intValue();
    }

    private final void U(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof DownstreamExceptionContext) {
            i0((DownstreamExceptionContext) coroutineContext2, t);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final Object c0(Continuation<? super Unit> continuation, T t) {
        CoroutineContext g2 = continuation.g();
        JobKt.z(g2);
        CoroutineContext coroutineContext = this.Z2;
        if (coroutineContext != g2) {
            U(g2, coroutineContext, t);
            this.Z2 = g2;
        }
        this.a3 = continuation;
        Object A = SafeCollectorKt.f29326a.A(this.Z, t, this);
        if (!Intrinsics.g(A, IntrinsicsKt.l())) {
            this.a3 = null;
        }
        return A;
    }

    private final void i0(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        throw new IllegalStateException(StringsKt.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.s + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @NotNull
    public Object D(@NotNull Object obj) {
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            this.Z2 = new DownstreamExceptionContext(e2, g());
        }
        Continuation<? super Unit> continuation = this.a3;
        if (continuation != null) {
            continuation.w(obj);
        }
        return IntrinsicsKt.l();
    }

    public void I() {
        super.I();
    }

    @Nullable
    public StackTraceElement K() {
        return null;
    }

    @NotNull
    public CoroutineContext g() {
        CoroutineContext coroutineContext = this.Z2;
        return coroutineContext == null ? EmptyCoroutineContext.s : coroutineContext;
    }

    @Nullable
    public Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        try {
            Object c0 = c0(continuation, t);
            if (c0 == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            return c0 == IntrinsicsKt.l() ? c0 : Unit.f28779a;
        } catch (Throwable th) {
            this.Z2 = new DownstreamExceptionContext(th, continuation.g());
            throw th;
        }
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<? super Unit> continuation = this.a3;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }
}
