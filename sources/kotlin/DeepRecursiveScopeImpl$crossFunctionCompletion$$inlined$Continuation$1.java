package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 DeepRecursive.kt\nkotlin/DeepRecursiveScopeImpl\n*L\n1#1,161:1\n184#2,6:162\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J \u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "", "w", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements Continuation<Object> {
    final /* synthetic */ DeepRecursiveScopeImpl X;
    final /* synthetic */ Function3 Y;
    final /* synthetic */ Continuation Z;
    final /* synthetic */ CoroutineContext s;

    public DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(CoroutineContext coroutineContext, DeepRecursiveScopeImpl deepRecursiveScopeImpl, Function3 function3, Continuation continuation) {
        this.s = coroutineContext;
        this.X = deepRecursiveScopeImpl;
        this.Y = function3;
        this.Z = continuation;
    }

    @NotNull
    public CoroutineContext g() {
        return this.s;
    }

    public void w(@NotNull Object obj) {
        this.X.s = this.Y;
        this.X.Y = this.Z;
        this.X.Z = obj;
    }
}
