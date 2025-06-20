package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    int Z2;

    ProduceKt$awaitClose$1(Continuation<? super ProduceKt$awaitClose$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return ProduceKt.a((ProducerScope<?>) null, (Function0<Unit>) null, this);
    }
}
