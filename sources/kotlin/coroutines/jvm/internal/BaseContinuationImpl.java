package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH$ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR!\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlin/Result;", "result", "", "w", "(Ljava/lang/Object;)V", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "I", "()V", "y", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "value", "v", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "s", "Lkotlin/coroutines/Continuation;", "B", "()Lkotlin/coroutines/Continuation;", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    @Nullable
    private final Continuation<Object> s;

    public BaseContinuationImpl(@Nullable Continuation<Object> continuation) {
        this.s = continuation;
    }

    @Nullable
    public final Continuation<Object> B() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object D(@NotNull Object obj);

    /* access modifiers changed from: protected */
    public void I() {
    }

    @Nullable
    public StackTraceElement K() {
        return DebugMetadataKt.e(this);
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<Object> continuation = this.s;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object K = K();
        if (K == null) {
            K = getClass().getName();
        }
        sb.append(K);
        return sb.toString();
    }

    @NotNull
    public Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.p(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final void w(@NotNull Object obj) {
        Continuation continuation = this;
        while (true) {
            DebugProbesKt.b(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation continuation2 = baseContinuationImpl.s;
            Intrinsics.m(continuation2);
            try {
                Object D = baseContinuationImpl.D(obj);
                if (D != IntrinsicsKt.l()) {
                    Result.Companion companion = Result.X;
                    obj = Result.b(D);
                    baseContinuationImpl.I();
                    if (continuation2 instanceof BaseContinuationImpl) {
                        continuation = continuation2;
                    } else {
                        continuation2.w(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.X;
                obj = Result.b(ResultKt.a(th));
            }
        }
    }

    @NotNull
    public Continuation<Unit> y(@NotNull Continuation<?> continuation) {
        Intrinsics.p(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }
}
