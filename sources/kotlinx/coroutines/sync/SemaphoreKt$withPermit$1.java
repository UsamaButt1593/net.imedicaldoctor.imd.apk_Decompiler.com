package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {85}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    int Z2;

    SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return SemaphoreKt.q((Semaphore) null, (Function0) null, this);
    }
}
