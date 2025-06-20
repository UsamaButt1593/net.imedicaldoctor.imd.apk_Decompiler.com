package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {419, 423}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ SubscribedFlowCollector<T> Z2;
    int a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super SubscribedFlowCollector$onSubscription$1> continuation) {
        super(continuation);
        this.Z2 = subscribedFlowCollector;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.a3 |= Integer.MIN_VALUE;
        return this.Z2.a(this);
    }
}
