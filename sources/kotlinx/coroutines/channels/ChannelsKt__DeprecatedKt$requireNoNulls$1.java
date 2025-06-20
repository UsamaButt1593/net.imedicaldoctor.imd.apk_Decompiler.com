package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H@"}, d2 = {"<anonymous>", "E", "", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__DeprecatedKt$requireNoNulls$1 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ ReceiveChannel<Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$requireNoNulls$1> continuation) {
        super(2, continuation);
        this.Z2 = receiveChannel;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            Object obj2 = this.Y2;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.Z2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@Nullable Object obj, @Nullable Continuation<Object> continuation) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) v(obj, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 channelsKt__DeprecatedKt$requireNoNulls$1 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.Z2, continuation);
        channelsKt__DeprecatedKt$requireNoNulls$1.Y2 = obj;
        return channelsKt__DeprecatedKt$requireNoNulls$1;
    }
}
