package androidx.core.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "Ljava/lang/Runnable;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Runnable;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class RunnableKt {
    @NotNull
    public static final Runnable a(@NotNull Continuation<? super Unit> continuation) {
        return new ContinuationRunnable(continuation);
    }
}
