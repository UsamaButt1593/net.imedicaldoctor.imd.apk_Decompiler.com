package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {
    /* synthetic */ Object X2;
    int Y2;
    Object Z;

    ChannelsKt__DeprecatedKt$none$1(Continuation<? super ChannelsKt__DeprecatedKt$none$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.O((ReceiveChannel) null, this);
    }
}
