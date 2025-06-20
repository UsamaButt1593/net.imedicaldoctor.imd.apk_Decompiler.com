package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u001b\u0010\u0003\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a)\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/coroutines/Continuation;", "frame", "", "b", "(Lkotlin/coroutines/Continuation;)V", "c", "T", "completion", "a", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DebugProbesKt {
    @NotNull
    public static final <T> Continuation<T> a(@NotNull Continuation<? super T> continuation) {
        return DebugProbesImpl.f29286a.F(continuation);
    }

    public static final void b(@NotNull Continuation<?> continuation) {
        DebugProbesImpl.f29286a.G(continuation);
    }

    public static final void c(@NotNull Continuation<?> continuation) {
        DebugProbesImpl.f29286a.H(continuation);
    }
}
