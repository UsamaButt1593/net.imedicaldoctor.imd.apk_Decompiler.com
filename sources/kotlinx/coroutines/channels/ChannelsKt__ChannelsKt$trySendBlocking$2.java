package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/channels/ChannelResult;", "", "E", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ SendChannel<E> Z2;
    final /* synthetic */ E a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<? super E> sendChannel, E e2, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.Z2 = sendChannel;
        this.a3 = e2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object obj2;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.Y2;
            SendChannel<E> sendChannel = this.Z2;
            E e2 = this.a3;
            Result.Companion companion = Result.X;
            this.X2 = 1;
            if (sendChannel.g0(e2, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.n(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.X;
                obj2 = Result.b(ResultKt.a(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.b(Unit.f28779a);
        return ChannelResult.b(Result.j(obj2) ? ChannelResult.f29243b.c(Unit.f28779a) : ChannelResult.f29243b.a(Result.e(obj2)));
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ChannelResult<Unit>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.Z2, this.a3, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.Y2 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }
}
