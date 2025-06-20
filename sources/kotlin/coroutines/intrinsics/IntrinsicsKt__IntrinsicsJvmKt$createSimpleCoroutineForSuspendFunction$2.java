package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/Result;", "", "result", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 extends ContinuationImpl {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        super(continuation, coroutineContext);
        Intrinsics.n(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object D(@NotNull Object obj) {
        ResultKt.n(obj);
        return obj;
    }
}
