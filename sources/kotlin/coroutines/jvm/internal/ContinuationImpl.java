package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationImpl.kt\nkotlin/coroutines/jvm/internal/ContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\b!\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0015\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "completion", "Lkotlin/coroutines/CoroutineContext;", "_context", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "(Lkotlin/coroutines/Continuation;)V", "J", "()Lkotlin/coroutines/Continuation;", "", "I", "()V", "X", "Lkotlin/coroutines/CoroutineContext;", "Y", "Lkotlin/coroutines/Continuation;", "intercepted", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class ContinuationImpl extends BaseContinuationImpl {
    @Nullable
    private final CoroutineContext X;
    @Nullable
    private transient Continuation<Object> Y;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(@Nullable Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.g() : null);
    }

    /* access modifiers changed from: protected */
    public void I() {
        Continuation<Object> continuation = this.Y;
        if (!(continuation == null || continuation == this)) {
            CoroutineContext.Element e2 = g().e(ContinuationInterceptor.N2);
            Intrinsics.m(e2);
            ((ContinuationInterceptor) e2).q(continuation);
        }
        this.Y = CompletedContinuation.s;
    }

    @NotNull
    public final Continuation<Object> J() {
        Continuation<Object> continuation = this.Y;
        if (continuation == null) {
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) g().e(ContinuationInterceptor.N2);
            if (continuationInterceptor == null || (continuation = continuationInterceptor.t(this)) == null) {
                continuation = this;
            }
            this.Y = continuation;
        }
        return continuation;
    }

    @NotNull
    public CoroutineContext g() {
        CoroutineContext coroutineContext = this.X;
        Intrinsics.m(coroutineContext);
        return coroutineContext;
    }

    public ContinuationImpl(@Nullable Continuation<Object> continuation, @Nullable CoroutineContext coroutineContext) {
        super(continuation);
        this.X = coroutineContext;
    }
}
