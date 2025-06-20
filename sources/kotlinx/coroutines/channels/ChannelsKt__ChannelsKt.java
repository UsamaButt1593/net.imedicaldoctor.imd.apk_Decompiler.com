package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "", "b", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "a", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__ChannelsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void a(@NotNull SendChannel<? super E> sendChannel, E e2) {
        if (!ChannelResult.m(sendChannel.Y(e2))) {
            Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new ChannelsKt__ChannelsKt$sendBlocking$1(sendChannel, e2, (Continuation<? super ChannelsKt__ChannelsKt$sendBlocking$1>) null), 1, (Object) null);
        }
    }

    @NotNull
    public static final <E> Object b(@NotNull SendChannel<? super E> sendChannel, E e2) {
        Object Y = sendChannel.Y(e2);
        if (Y instanceof ChannelResult.Failed) {
            return ((ChannelResult) BuildersKt__BuildersKt.b((CoroutineContext) null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, e2, (Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2>) null), 1, (Object) null)).o();
        }
        Unit unit = (Unit) Y;
        return ChannelResult.f29243b.c(Unit.f28779a);
    }
}
