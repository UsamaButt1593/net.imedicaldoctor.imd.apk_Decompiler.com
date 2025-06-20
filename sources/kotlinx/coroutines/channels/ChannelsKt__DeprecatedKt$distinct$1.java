package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H@"}, d2 = {"<anonymous>", "E", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__DeprecatedKt$distinct$1 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {
    int X2;
    /* synthetic */ Object Y2;

    ChannelsKt__DeprecatedKt$distinct$1(Continuation<? super ChannelsKt__DeprecatedKt$distinct$1> continuation) {
        super(2, continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            return this.Y2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(Object obj, @Nullable Continuation<Object> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinct$1) v(obj, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinct$1 channelsKt__DeprecatedKt$distinct$1 = new ChannelsKt__DeprecatedKt$distinct$1(continuation);
        channelsKt__DeprecatedKt$distinct$1.Y2 = obj;
        return channelsKt__DeprecatedKt$distinct$1;
    }
}
