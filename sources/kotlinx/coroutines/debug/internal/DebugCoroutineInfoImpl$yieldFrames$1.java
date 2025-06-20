package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {80}, m = "yieldFrames", n = {}, s = {})
final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    /* synthetic */ Object Z2;
    final /* synthetic */ DebugCoroutineInfoImpl a3;
    int b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, Continuation<? super DebugCoroutineInfoImpl$yieldFrames$1> continuation) {
        super(continuation);
        this.a3 = debugCoroutineInfoImpl;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z2 = obj;
        this.b3 |= Integer.MIN_VALUE;
        return this.a3.k((SequenceScope<? super StackTraceElement>) null, (CoroutineStackFrame) null, this);
    }
}
