package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class ChannelsKt__DeprecatedKt$lastIndexOf$1<E> extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    /* synthetic */ Object b3;
    int c3;

    ChannelsKt__DeprecatedKt$lastIndexOf$1(Continuation<? super ChannelsKt__DeprecatedKt$lastIndexOf$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.b3 = obj;
        this.c3 |= Integer.MIN_VALUE;
        return ChannelsKt__DeprecatedKt.C((ReceiveChannel) null, (Object) null, this);
    }
}
